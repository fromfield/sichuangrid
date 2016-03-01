package com.tianque.issue.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tianque.core.base.AbstractBaseService;
import com.tianque.core.globalSetting.service.GlobalSettingService;
import com.tianque.core.globalSetting.util.GlobalSetting;
import com.tianque.core.util.StringUtil;
import com.tianque.core.util.ThreadVariable;
import com.tianque.core.vo.AutoCompleteData;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.property.OrganizationType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.exception.base.ServiceValidationException;
import com.tianque.issue.IssueHelper;
import com.tianque.issue.constants.IssueConstants;
import com.tianque.issue.constants.IssueIsStayStepType;
import com.tianque.issue.dao.IssueLogDao;
import com.tianque.issue.dao.IssueProcessDao;
import com.tianque.issue.domain.IssueAttachFile;
import com.tianque.issue.domain.IssueLogNew;
import com.tianque.issue.domain.IssueNew;
import com.tianque.issue.domain.IssueSkiprule;
import com.tianque.issue.domain.IssueStep;
import com.tianque.issue.event.IssueChangeEvent;
import com.tianque.issue.event.listener.IssueChangeListener;
import com.tianque.issue.service.IssueHistoryService;
import com.tianque.issue.service.IssueService;
import com.tianque.issue.service.IssueSkipruleService;
import com.tianque.issue.service.IssueWorkFlowEngine;
import com.tianque.issue.state.IssueOperate;
import com.tianque.issue.state.IssueOperationContext;
import com.tianque.issue.state.IssueSourceState;
import com.tianque.issue.state.IssueState;
import com.tianque.issue.state.IssueStepGroup;
import com.tianque.issue.state.IssueStepInfo;
import com.tianque.issue.state.OrganizationInfo;
import com.tianque.issue.state.impl.DealingState;
import com.tianque.issue.uitl.IssueToCMSUtil;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.tqSearch.common.TqSolrSearchCommonOperate;
import com.tianque.tqSearch.constant.TqSolrSearchOperateType;
import com.tianque.tqSearch.constant.TqSolrSearchType;
import com.tianque.tqSearch.convert.IssueSolrDocumentConvert;
import com.tianque.tqSearch.dubboService.TqSearchDubboService;

public abstract class AbstractIssueWorkFlowEngineImpl extends
		AbstractBaseService implements IssueWorkFlowEngine {
	@Autowired
	protected IssueProcessDao issueProcessDao;
	@Autowired
	protected OrganizationDubboService organizationDubboService;
	@Autowired
	protected PropertyDictService propertyDictService;
	@Autowired
	private IssueSkipruleService issueSkipruleService;
	@Autowired
	private IssueLogDao issueLogDao;
	@Autowired
	private IssueHistoryService issueHistoryService;
	@Autowired
	private IssueService issueService;

	@Autowired
	private TqSolrSearchCommonOperate tqSolrSearchCommonOperate;
	@Autowired
	private GlobalSettingService globalSettingService;
	@Autowired
	private TqSearchDubboService tqSearchDubboService;

	/***
	 * 创建事件处理步骤实对象
	 * 
	 * @param issue
	 *            事件
	 * @return
	 */
	protected abstract IssueStep createEntryIssueStep(IssueNew issue,
			Long sourceKindId);

	/***
	 * 获取事件监听器类
	 * 
	 * @return
	 */
	protected abstract List<IssueChangeListener> getIssueChangeListeners();

	@Override
	public IssueStep register(IssueNew issue) {
		issue.setCreateOrg(organizationDubboService.getFullOrgById(issue
				.getCreateOrg().getId()));
		issue.setOccurOrg(organizationDubboService.getFullOrgById(issue
				.getOccurOrg().getId()));
		PropertyDict sourceKind = propertyDictService
				.findPropertyDictByDomainNameAndDictDisplayName(
						PropertyTypes.SOURCE_KIND,
						IssueConstants.CALLCENTER_INPUT);
		IssueStep result = issueProcessDao.addIssueStep(createEntryIssueStep(
				issue, sourceKind != null ? sourceKind.getId() : 0l));
		IssueStepGroup issueStepGroup = new IssueStepGroup();
		issueStepGroup.setKeyStep(result);
		issueStepGroup.setIssue(issue);
		fetchSourceAndTargetOrg(result, result);
		fireIssueEntry(issue, result);
		fireIssueGroup(issueStepGroup);
		return result;
	}

	@Override
	public boolean unRegister(Long issueId) {
		issueProcessDao.deleteIssueStepsByIssueId(issueId);
		return true;
	}

	@Override
	public IssueStep getFullIssueStepById(Long stepId) {
		IssueStep step = getSimpleIssueStepById(stepId);
		if(step == null){
			step = issueHistoryService.getSimpleIssueStepHistoryById(stepId);
		}
		if (step == null
				&& Boolean.valueOf(globalSettingService
						.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
			List<String> solrIds = new ArrayList<String>();
			solrIds.add(TqSolrSearchType.ISSUE_TYPE + "_" + stepId);
			tqSearchDubboService.deleteSolrIndexById(solrIds,
					TqSolrSearchType.ISSUE_TYPE);
		}
		try {
			fetchSourceAndTargetOrg(step, step);
		} catch (Exception e) {
			logger.error("stepId:" + stepId + " 数据不存在或者有问题", e);
		}
		return step;
	}

	@Override
	public IssueStep complete(IssueNew issue, IssueStep step, IssueLogNew log,
			List<IssueAttachFile> attachFiles) {
		try {
			IssueOperationContext context;
			if (StringUtil.isStringAvaliable(issue.getFromSerialNumber())) {
				context = new IssueOperationContext(log.getDealOrg(),
						step.getSource(), "", log.getDealUserName());
			} else {
				context = constructIssueOperationContext(step.getTarget(), null);
			}
			if (log.getIssueStep() != null
					&& log.getIssueStep().getFourTeams() != null
					&& log.getIssueStep().getFourTeamsTypeID() != null) {
				step.setFourTeamsTypeID(log.getIssueStep().getFourTeamsTypeID());
				step.setFourTeams(log.getIssueStep().getFourTeams());
			}
			IssueStepGroup steps = saveStepGroup(IssueHelper
					.constructIssueStateFromStep(step).complete(issue, step,
							context));
			updateIsNotStayIssueSteps(step, issue);
			IssueStep oldIssueStep = issueProcessDao
					.updateIssueStepExceptOrg(step);
//			tqSolrSearchCommonOperate.commonOperate(IssueSolrDocumentConvert
//					.createIssueSolrDocument(issue, oldIssueStep),
//					TqSolrSearchOperateType.ADD_OR_UPDATE);
			fireIssueChanged(issue, steps, IssueOperate.COMPLETE, log,
					attachFiles);
			IssueStep result = getFullIssueStepById(steps.getKeyStep().getId());
			fireIssueComplete(issue, result, log, attachFiles);
			fireIssueGroup(steps);
			return result;
		} catch (Exception e) {
			throw new ServiceValidationException("办结过程中发生错误", e);
		}
	}

	@Override
	public IssueStep verification(IssueNew issue, IssueStep step,
			IssueLogNew log, List<IssueAttachFile> attachFiles) {
		try {
			IssueOperationContext context;
			if (log.isReport12345()) {// 上报12345
				context = new IssueOperationContext(log.getDealOrg(),
						step.getSource(), "", log.getDealUserName());
			} else {
				context = constructIssueOperationContext(step.getTarget(), null);
			}
			IssueHelper.constructIssueStateFromStep(step).verification(issue,
					step, context);
			if (log.getIssueStep() != null
					&& log.getIssueStep().getFourTeams() != null
					&& log.getIssueStep().getFourTeamsTypeID() != null) {
				step.setFourTeamsTypeID(log.getIssueStep().getFourTeamsTypeID());
				step.setFourTeams(log.getIssueStep().getFourTeams());
			}
			updateIsNotStayIssueSteps(step, issue);
			IssueStep oldIssueStep = issueProcessDao
					.updateIssueStepExceptOrg(step);
			IssueStep result = getFullIssueStepById(step.getId());
			fireIssueVerification(issue, result, log, attachFiles);
			List<IssueStep> issueSteps = issueProcessDao
					.findIssueStepsByIssueId(issue.getId());
			if (issueSteps != null && issueSteps.size() > 0) {
				for (IssueStep issueStep : issueSteps) {
					Organization org = organizationDubboService.getSimpleOrgById(issueStep.getSource().getId());
					issueStep.setSource(org);
					tqSolrSearchCommonOperate.commonOperate(
							IssueSolrDocumentConvert.createIssueSolrDocument(
									issue, issueStep),
							TqSolrSearchOperateType.ADD_OR_UPDATE);
				}
			}
			return result;
		} catch (Exception e) {
			throw new ServiceValidationException("验证过程中发生错误", e);
		}
	}

	@Override
	public IssueStep submit(IssueNew issue, IssueStep step, IssueLogNew log,
			Long targetOrg, Long[] tells, List<IssueAttachFile> attachFiles) {
		try {
			List<Organization> tellsList = null;
			IssueSkiprule issueSkiprule = issueSkipruleService
					.getIssueSkipruleByIssue(issue, step);
			IssueOperationContext context = null;
			if (issueSkiprule != null) {// 越级上报的时候，给越过的层级抄告信息
				tellsList = constructGreatCopy(issueSkiprule, tells);
			} else {
				tellsList = loadFullOrganizations(tells);
			}
			if (log.isReport12345()) {// 上报12345
				context = constructOperationContextBy12345(targetOrg, tellsList);
			} else {
				context = constructOperationContext(targetOrg, tellsList);
			}
			IssueStepGroup steps = IssueHelper
					.constructIssueStateFromStep(step).submit(issue, step,
							context, issueSkiprule);
			if (log.isReport12345()) {// 上报12345
				steps.getKeyStep().setState(DealingState.class.getName());
				steps.getKeyStep().setStateCode(IssueState.DEALING_CODE);
			}
			steps.getKeyStep().setIsStayStep(IssueIsStayStepType.IS_STAYSTEP);
			steps = saveStepGroup(steps);
			step.setSubmit(IssueSourceState.submit);
			updateIsNotStayIssueSteps(step, issue);
			IssueStep oldIssueStep = issueProcessDao
					.updateIssueStepExceptOrg(step);
			tqSolrSearchCommonOperate.commonOperate(IssueSolrDocumentConvert
					.createIssueSolrDocument(issue, oldIssueStep),
					TqSolrSearchOperateType.ADD_OR_UPDATE);
			fireIssueChanged(issue, steps, IssueOperate.SUBMIT, log,
					attachFiles);
			fireIssueGroup(steps);
			return steps.getKeyStep();
		} catch (Exception e) {
			throw new ServiceValidationException("上报过程中发生错误", e);
		}
	}

	private IssueOperationContext constructOperationContextBy12345(
			Long targetOrg, List<Organization> tells) throws Exception {
		Organization target = IssueToCMSUtil
				.getLocationOrgNameByLocationId(targetOrg);
		IssueOperationContext context = constructIssueOperationContext(target,
				tells);
		return context;
	}

	@Override
	public IssueStep giveTo(IssueNew issue, IssueStep step, IssueLogNew log,
			Long targetOrg, Long[] tells, List<IssueAttachFile> attachFiles) {
		try {
			IssueOperationContext context = constructOperationContext(
					targetOrg, loadFullOrganizations(tells));
			IssueStepGroup steps = saveStepGroup(IssueHelper
					.constructIssueStateFromStep(step).giveTo(issue, step,
							context));
			updateIsNotStayIssueSteps(step, issue);
			IssueStep oldIssueStep = issueProcessDao
					.updateIssueStepExceptOrg(step);
			tqSolrSearchCommonOperate.commonOperate(IssueSolrDocumentConvert
					.createIssueSolrDocument(issue, oldIssueStep),
					TqSolrSearchOperateType.ADD_OR_UPDATE);
			fireIssueChanged(issue, steps, IssueOperate.SUBMIT, log,
					attachFiles);
			fireIssueGroup(steps);
			return steps.getKeyStep();
		} catch (Exception e) {
			throw new ServiceValidationException("上报过程中发生错误", e);
		}
	}

	@Override
	public IssueStep assign(IssueNew issue, IssueStep step, IssueLogNew log,
			Long targetOrg, Long[] tells, List<IssueAttachFile> attachFiles) {
		try {
			IssueOperationContext context;
			if (log.isReport12345()) {
				context = new IssueOperationContext(log.getDealOrg(),
						log.getTargeOrg(), "", ThreadVariable.getSession()
								.getUserRealName());
			} else {
				context = constructOperationContext(targetOrg,
						loadFullOrganizations(tells));
			}
			IssueStepGroup steps = IssueHelper
					.constructIssueStateFromStep(step).assign(issue, step,
							context);
			steps.getKeyStep().setIsStayStep(IssueIsStayStepType.IS_STAYSTEP);
			steps = saveStepGroup(steps);
			updateIsNotStayIssueSteps(step, issue);
			IssueStep oldIssueStep = issueProcessDao
					.updateIssueStepExceptOrg(step);
			tqSolrSearchCommonOperate.commonOperate(IssueSolrDocumentConvert
					.createIssueSolrDocument(issue, oldIssueStep),
					TqSolrSearchOperateType.ADD_OR_UPDATE);
			fireIssueChanged(issue, steps, IssueOperate.ASSIGN, log,
					attachFiles);
			fireIssueGroup(steps);
			return steps.getKeyStep();
		} catch (Exception e) {
			throw new ServiceValidationException("交办过程中发生错误", e);
		}
	}

	@Override
	public IssueStep concept(IssueNew issue, IssueStep step, IssueLogNew log) {
		try {
			IssueOperationContext context = constructIssueOperationContext(
					loadFullCurrentLoginedOrganization(), null);
			IssueHelper.constructIssueStateFromStep(step).concept(issue, step,
					context);
			step = getFullIssueStepById(issueProcessDao
					.updateIssueStepExceptOrg(step).getId());
			fireIssueChanged(issue, step, IssueOperate.CONCEPT, log,
					new ArrayList<IssueAttachFile>());
			return step;
		} catch (Exception e) {
			throw new ServiceValidationException("受理过程中发生错误", e);
		}
	}

	@Override
	public IssueStep back(IssueNew issue, IssueStep step, IssueLogNew log,
			List<IssueAttachFile> attachFiles) {
		try {
			IssueStep backTo = getSimpleIssueStepById(step.getBackTo().getId());
			step.setBackTo(backTo);
			IssueOperationContext context;
			if (log.isReport12345()) {
				context = new IssueOperationContext(log.getDealOrg(),
						backTo.getTarget(), "", null);
			} else {
				context = constructIssueOperationContext(
						loadFullOrganization(backTo.getTarget().getId()), null);
			}
			IssueStepGroup steps = saveStepGroup(IssueHelper
					.constructIssueStateFromStep(step).back(issue, step,
							context));
			updateIsNotStayIssueSteps(step, issue);
			IssueStep oldIssueStep = issueProcessDao
					.updateIssueStepExceptOrg(step);
			tqSolrSearchCommonOperate.commonOperate(IssueSolrDocumentConvert
					.createIssueSolrDocument(issue, oldIssueStep),
					TqSolrSearchOperateType.ADD_OR_UPDATE);
			if (!log.isReport12345() && steps.getKeyStep().getTarget() != null
					&& steps.getKeyStep().getTarget().getId() < 0) {
				// 回退坐席，特殊处理
				IssueStep issueStepTemp = steps.getKeyStep();
				Organization orgTemp = IssueToCMSUtil
						.getLocationOrgNameByLocationId(steps.getKeyStep()
								.getTarget().getId());
				issueStepTemp.setTarget(orgTemp);
				steps.setKeyStep(issueStepTemp);
			}
			fireIssueChanged(issue, steps, IssueOperate.BACK, log, attachFiles);
			fireIssueGroup(steps);
			return steps.getKeyStep();
		} catch (Exception e) {
			throw new ServiceValidationException("回退时发生错误", e);
		}
	}

	@Override
	public IssueStep read(IssueNew issue, IssueStep step, IssueLogNew log) {
		try {
			IssueOperationContext context = constructIssueOperationContext(
					loadFullCurrentLoginedOrganization(), null);
			IssueHelper.constructIssueStateFromStep(step).read(issue, step,
					context);
			updateIsNotStayIssueSteps(step, issue);
			step = getFullIssueStepById(issueProcessDao
					.updateIssueStepExceptOrg(step).getId());
			fireIssueChanged(issue, step, IssueOperate.READ, log,
					new ArrayList<IssueAttachFile>());
			return step;
		} catch (Exception e) {
			throw new ServiceValidationException("阅读过程中发生错误", e);
		}
	}

	@Override
	public IssueStep reportTo(IssueNew issue, IssueStep step, IssueLogNew log) {
		try {
			IssueOperationContext context = constructIssueOperationContext(
					getNearestCommandCenter(step.getTarget()), null);
			IssueStep newStep = IssueHelper.constructIssueStateFromStep(step)
					.reportTo(issue, step, context);
			newStep = addAndReloadFullIssueStep(newStep);
			updateIsNotStayIssueSteps(step, issue);
			IssueStep oldIssueStep = issueProcessDao
					.updateIssueStepExceptOrg(step);
			tqSolrSearchCommonOperate.commonOperate(IssueSolrDocumentConvert
					.createIssueSolrDocument(issue, oldIssueStep),
					TqSolrSearchOperateType.ADD_OR_UPDATE);
			IssueStepGroup steps = new IssueStepGroup();
			steps.setKeyStep(newStep);
			steps.setIssue(issue);
			fireIssueChanged(issue, newStep, IssueOperate.REPORT_TO, log,
					new ArrayList<IssueAttachFile>());
			fireIssueGroup(steps);
			return newStep;
		} catch (Exception e) {
			throw new ServiceValidationException("上报指挥中心过程中发生错误", e);
		}
	}

	@Override
	public IssueStep comment(IssueNew issue, IssueStep step, IssueLogNew log,
			List<IssueAttachFile> attachFiles) {
		try {
			IssueOperationContext context = constructIssueOperationContext(
					loadFullCurrentLoginedOrganization(), null);
			IssueHelper.constructIssueStateFromStep(step).comment(issue, step,
					context);
			if (log.getIssueStep() != null
					&& log.getIssueStep().getFourTeams() != null
					&& log.getIssueStep().getFourTeamsTypeID() != null) {
				step.setFourTeamsTypeID(log.getIssueStep().getFourTeamsTypeID());
				step.setFourTeams(log.getIssueStep().getFourTeams());
			}
			step = getFullIssueStepById(issueProcessDao
					.updateIssueStepExceptOrg(step).getId());
			fireIssueChanged(issue, step, IssueOperate.COMMENT, log,
					attachFiles);
			return step;
		} catch (Exception e) {
			throw new ServiceValidationException("填写处理意见过程中发生错误", e);
		}
	}

	@Override
	public IssueStep instruct(IssueNew issue, IssueStep step, IssueLogNew log) {
		try {
			IssueOperationContext context = constructIssueOperationContext(
					organizationDubboService.getFullOrgById(step.getTarget()
							.getId()), null);
			IssueHelper.constructIssueStateFromStep(step).instruct(issue, step,
					context);
			fireIssueChanged(issue, step, IssueOperate.INSTRUCT, log,
					new ArrayList<IssueAttachFile>());
			return step;
		} catch (Exception e) {
			throw new ServiceValidationException("填写处理意见过程中发生错误", e);
		}
	}

	@Override
	public IssueStep cancelSupervise(IssueNew issue, IssueStep step,
			IssueLogNew log) {
		try {
			IssueOperationContext context = constructIssueOperationContext(
					organizationDubboService.getFullOrgById(step.getTarget()
							.getId()), null);
			IssueHelper.constructIssueStateFromStep(step).cancelSupervise(
					issue, step, context);
			step = getFullIssueStepById(issueProcessDao
					.updateIssueStepExceptOrg(step).getId());
			fireIssueChanged(issue, step, IssueOperate.CANCEL_SUPERVISE, log,
					new ArrayList<IssueAttachFile>());
			return step;
		} catch (Exception e) {
			throw new ServiceValidationException("填写处理意见过程中发生错误", e);
		}
	}

	@Override
	public IssueStep supervise(IssueNew issue, IssueStep step, IssueLogNew log,
			IssueOperate type) {
		try {
			IssueOperationContext context = constructIssueOperationContext(
					organizationDubboService.getFullOrgById(step.getTarget()
							.getId()), null);
			context.addParameter(IssueOperationContext.SUPERVISE_LEVEL_KEY,
					getSuperviseLevel(type));
			IssueHelper.constructIssueStateFromStep(step).supervise(issue,
					step, context);
			step = getFullIssueStepById(issueProcessDao
					.updateIssueStepExceptOrg(step).getId());
			fireIssueChanged(issue, step, type, log,
					new ArrayList<IssueAttachFile>());
			return step;
		} catch (Exception e) {
			throw new ServiceValidationException("督办过程中发生错误", e);
		}
	}

	@Override
	public void fireIssueChanged(IssueNew issue, IssueOperate operate,
			IssueLogNew log, List<IssueAttachFile> attachFiles) {
		IssueChangeEvent event = new IssueChangeEvent(log, attachFiles, operate);
		if (getIssueChangeListeners() != null) {
			for (IssueChangeListener listener : getIssueChangeListeners()) {
				listener.onChanged(issue, null, event);
			}
		}
	}

	@Override
	public List<IssueOperate> getIssueCandoForOrg(Long stepId, Organization org) {
		IssueStep step = getSimpleIssueStepById(stepId);
		if (step == null || step.getId() == null) {
			step = issueHistoryService.getSimpleIssueStepHistoryById(stepId);
		}
		fetchFullSourceAndTargetOrg(step);
		org = loadFullOrganization(org.getId());
		IssueStepInfo si = new IssueStepInfo();
		si.setOperationOrg(step.getTarget());
		si.setSuperviseLevel(step.getSuperviseLevel());
		OrganizationInfo oi = new OrganizationInfo();
		oi.setLeafOrg((org.getSubCount() + org.getSubCountFun()) == 0);
		oi.setTopOrg(org.getParentOrg() == null);
		oi.setOrganization(org);
		try {
			return IssueHelper.constructIssueStateFromStep(step).getCando(si,
					oi);
		} catch (Exception e) {
			throw new ServiceValidationException("获取可以进行的操作时发生以下错误", e);
		}
	}

	@Override
	public PageInfo<AutoCompleteData> findAdminTargetsByName(Long stepid,
			IssueOperate operate, String tag, Long[] exceptId, int page,
			int rows) {
		IssueStep step = getFullIssueStepById(stepid);
		if (IssueOperate.GIVETO.equals(operate)) {
			return findGiveToAdminTargetsByName(tag, exceptId, step, page, rows);
		} else if (IssueOperate.SUBMIT.equals(operate)) {
			return findSubmitAdminTargetsByName(tag, exceptId, step);
		} else if (IssueOperate.ASSIGN.equals(operate)) {
			return findAssignAdminTargetsByName(tag, exceptId, step, page, rows);
		}
		return createEmptyAutoCompleteDataPage();
	}

	@Override
	public PageInfo<AutoCompleteData> findFunctionTargetsByName(Long stepid,
			IssueOperate operate, String tag, Long[] exceptIds, int pageIndex,
			int rows) {
		IssueStep step = getFullIssueStepById(stepid);
		if (IssueOperate.GIVETO.equals(operate)) {
			return findGiveToFunctionTargetsByName(tag, exceptIds, step, rows,
					pageIndex);
		} else if (IssueOperate.SUBMIT.equals(operate)) {
			return findSubmitFunctionTargetsByName(tag, exceptIds, step,
					pageIndex, rows);
		} else if (IssueOperate.ASSIGN.equals(operate)) {
			return findAssignFunctionTargetsByName(tag, exceptIds, step,
					pageIndex, rows);
		}
		return createEmptyAutoCompleteDataPage();
	}

	@Override
	public PageInfo<AutoCompleteData> findTellTargetsByName(Long stepid,
			IssueOperate operate, String tag, boolean transferToAdmin,
			Long[] exceptIds, int page, int rows) {
		IssueStep step = getFullIssueStepById(stepid);
		if (IssueOperate.GIVETO.equals(operate)) {
			return findGiveToTellsByName(tag, exceptIds, step, transferToAdmin,
					page, rows);
		} else if (IssueOperate.SUBMIT.equals(operate)) {
			return findSubmitTellsByName(tag, exceptIds, step, transferToAdmin,
					page, rows);
		} else if (IssueOperate.ASSIGN.equals(operate)) {
			return findAssignTellsByName(tag, exceptIds, step, transferToAdmin,
					page, rows);
		}
		return createEmptyAutoCompleteDataPage();
	}

	protected Organization getNearestCommandCenter(Organization org) {
		return organizationDubboService.findOrganizationsByParentId(null)
				.get(0);
	}

	private PageInfo<AutoCompleteData> findGiveToTellsByName(String tag,
			Long[] exceptIds, IssueStep step, boolean transferToAdmin,
			int page, int rows) {
		if (exceptIds == null || exceptIds.length == 0) {
			return createEmptyAutoCompleteDataPage();
		} else {
			Organization transferTo = loadFullOrganization(exceptIds[0]);
			if (isAdminOrg(transferTo)) {
				PropertyDict dict = propertyDictService
						.findPropertyDictByDomainNameAndInternalId(
								OrganizationType.ORG_TYPE_KEY,
								OrganizationType.FUNCTIONAL_ORG).get(0);
				return issueProcessDao.findChildOrgsByParentIdAndName(dict,
						transferTo.getId(), tag, exceptIds, page, rows);
			} else {
				return findParentAndSiblingFunOrgs(tag, exceptIds, transferTo);
			}
		}
	}

	private PageInfo<AutoCompleteData> findParentAndSiblingFunOrgs(String tag,
			Long[] exceptIds, Organization funOrg) {
		Organization parent = organizationDubboService.getSimpleOrgById(funOrg
				.getParentOrg().getId());
		PropertyDict dict = propertyDictService
				.findPropertyDictByDomainNameAndInternalId(
						OrganizationType.ORG_TYPE_KEY,
						OrganizationType.FUNCTIONAL_ORG).get(0);
		PageInfo<AutoCompleteData> result = issueProcessDao
				.findChildOrgsByParentIdAndName(dict, parent.getId(), tag,
						exceptIds, 1, 10);
		if (!inExceptOrg(parent.getId(), exceptIds)) {
			insertOrgToPages(parent, result);
		}
		return result;
	}

	private PageInfo<AutoCompleteData> findAssignTellsByName(String tag,
			Long[] exceptIds, IssueStep step, boolean transferToAdmin,
			int page, int rows) {
		Organization operationOrg = organizationDubboService
				.getFullOrgById(ThreadVariable.getSession().getOrganization()
						.getId());
		if (isAdminOrg(operationOrg)) {
			PropertyDict dict = propertyDictService
					.findPropertyDictByDomainNameAndInternalId(
							OrganizationType.ORG_TYPE_KEY,
							OrganizationType.FUNCTIONAL_ORG).get(0);
			return issueProcessDao.findChildOrgsByParentIdAndName(dict,
					ThreadVariable.getSession().getOrganization().getId(), tag,
					exceptIds, page, rows);
		} else {
			PageInfo<AutoCompleteData> result = createEmptyAutoCompleteDataPage();
			if (!inExceptOrg(operationOrg.getParentOrg().getId(), exceptIds)) {
				insertOrgToPages(
						organizationDubboService.getSimpleOrgById(operationOrg
								.getParentOrg().getId()), result);
			}
			return result;
		}
	}

	private PageInfo<AutoCompleteData> findSubmitTellsByName(String tag,
			Long[] exceptIds, IssueStep step, boolean transferToAdmin,
			int page, int rows) {
		Organization operationOrg = organizationDubboService
				.getFullOrgById(ThreadVariable.getSession().getOrganization()
						.getId());
		if (transferToAdmin) {
			if (isAdminOrg(operationOrg)) {
				PropertyDict dict = propertyDictService
						.findPropertyDictByDomainNameAndInternalId(
								OrganizationType.ORG_TYPE_KEY,
								OrganizationType.FUNCTIONAL_ORG).get(0);
				return issueProcessDao.findChildOrgsByParentIdAndName(dict,
						step.getTarget().getParentOrg().getId(), tag,
						exceptIds, page, rows);
			} else {
				return createEmptyAutoCompleteDataPage();
			}
		} else {
			if (isAdminOrg(operationOrg)) {
				PropertyDict dict = propertyDictService
						.findPropertyDictByDomainNameAndInternalId(
								OrganizationType.ORG_TYPE_KEY,
								OrganizationType.FUNCTIONAL_ORG).get(0);
				PageInfo<AutoCompleteData> result = issueProcessDao
						.findChildOrgsByParentIdAndName(dict, operationOrg
								.getParentOrg().getId(), tag, exceptIds, 1, 10);
				if (!inExceptOrg(operationOrg.getParentOrg().getId(), exceptIds)) {
					insertOrgToPages(
							organizationDubboService.getSimpleOrgById(operationOrg
									.getParentOrg().getId()), result);
				}
				return result;
			} else {
				PageInfo<AutoCompleteData> result = createEmptyAutoCompleteDataPage();
				if (!inExceptOrg(operationOrg.getParentOrg().getId(), exceptIds)) {
					insertOrgToPages(
							organizationDubboService.getSimpleOrgById(operationOrg
									.getParentOrg().getId()), result);
				}
				return result;
			}
		}
	}

	private boolean isAdminOrg(Organization org) {
		return OrganizationType.ADMINISTRATIVE_REGION == org.getOrgType()
				.getInternalId();
	}

	private PageInfo<AutoCompleteData> createEmptyAutoCompleteDataPage() {
		return createAutoCompleteDataPage(1, 0, 0,
				new ArrayList<AutoCompleteData>());
	}

	private PageInfo<AutoCompleteData> createAutoCompleteDataPage(
			int pageIndex, int pagesize, int totalCount,
			List<AutoCompleteData> data) {
		PageInfo<AutoCompleteData> result = new PageInfo<AutoCompleteData>();
		result.setCurrentPage(pageIndex);
		result.setPerPageSize(pagesize == 0 ? 1 : pagesize);
		result.setTotalRowSize(totalCount);
		result.setResult(data);
		return result;
	}

	private boolean inExceptOrg(Long id, Long[] exceptIds) {
		if (id != null && (exceptIds == null || exceptIds.length == 0))
			return false;
		if (id == null)
			return false;
		for (Long exceptId : exceptIds) {
			if (exceptId.equals(id))
				return true;
		}
		return false;
	}

	private AutoCompleteData convertToAutoCompleteData(Organization org) {
		AutoCompleteData autoCompleteData = new AutoCompleteData();
		autoCompleteData.setValue(org.getId().toString());
		autoCompleteData.setLabel(org.getOrgName());
		autoCompleteData.setDesc(org.getRemark());
		return autoCompleteData;
	}

	private PageInfo<AutoCompleteData> findAssignFunctionTargetsByName(
			String tag, Long[] exceptIds, IssueStep step, int pageIndex,
			int rows) {
		Organization org = organizationDubboService.getFullOrgById(step
				.getTarget().getId());
		if (OrganizationType.FUNCTIONAL_ORG == org.getOrgType().getInternalId()) {
			return issueProcessDao.findChildFunOrgsByParentFunIdAndName(
					org.getId(), tag, exceptIds);
		} else {
			PropertyDict dict = propertyDictService
					.findPropertyDictByDomainNameAndInternalId(
							OrganizationType.ORG_TYPE_KEY,
							OrganizationType.FUNCTIONAL_ORG).get(0);
			return issueProcessDao.findChildOrgsByParentIdAndName(dict, step
					.getTarget().getId(), tag, exceptIds, pageIndex, rows);
		}
	}

	private PageInfo<AutoCompleteData> findAssignAdminTargetsByName(String tag,
			Long[] exceptIds, IssueStep step, int page, int rows) {
		PropertyDict dict = propertyDictService
				.findPropertyDictByDomainNameAndInternalId(
						OrganizationType.ORG_TYPE_KEY,
						OrganizationType.ADMINISTRATIVE_REGION).get(0);
		return issueProcessDao.findChildOrgsByParentIdAndName(dict, step
				.getTarget().getId(), tag, exceptIds, page, rows);
	}

	private PageInfo<AutoCompleteData> findSubmitAdminTargetsByName(String tag,
			Long[] exceptIds, IssueStep step) {
		Organization org = step.getTarget();
		if (org.getParentOrg() == null
				|| inExceptOrg(org.getParentOrg().getId(), exceptIds)) {
			return createEmptyAutoCompleteDataPage();
		} else {
			PageInfo<AutoCompleteData> result = createAutoCompleteDataPage(1,
					1, 1, new ArrayList<AutoCompleteData>());
			result.getResult().add(
					convertToAutoCompleteData(organizationDubboService
							.getSimpleOrgById(org.getParentOrg().getId())));
			return result;
		}
	}

	private PageInfo<AutoCompleteData> findSubmitFunctionTargetsByName(
			String tag, Long[] exceptIds, IssueStep step, int pageIndex,
			int rows) {
		Organization org = organizationDubboService.getFullOrgById(step
				.getTarget().getId());
		if (org.getParentOrg() == null) {
			return createEmptyAutoCompleteDataPage();
		} else if (OrganizationType.FUNCTIONAL_ORG == org.getOrgType()
				.getInternalId()) {
			return issueProcessDao.findParentFunOrgsByIdAndName(org.getId(),
					tag, exceptIds);
		} else {
			PropertyDict dict = propertyDictService
					.findPropertyDictByDomainNameAndInternalId(
							OrganizationType.ORG_TYPE_KEY,
							OrganizationType.FUNCTIONAL_ORG).get(0);
			return issueProcessDao.findChildOrgsByParentIdAndName(dict, org
					.getParentOrg().getId(), tag, exceptIds, pageIndex, rows);
		}
	}

	private PageInfo<AutoCompleteData> findGiveToAdminTargetsByName(String tag,
			Long[] exceptIds, IssueStep step, int page, int rows) {
		PropertyDict dict = propertyDictService
				.findPropertyDictByDomainNameAndInternalId(
						OrganizationType.ORG_TYPE_KEY,
						OrganizationType.ADMINISTRATIVE_REGION).get(0);
		return issueProcessDao.findChildOrgsByOrgcodeAndNameAndType(dict, step
				.getTarget().getOrgInternalCode(), tag, exceptIds, page, rows);
	}

	private PageInfo<AutoCompleteData> findGiveToFunctionTargetsByName(
			String tag, Long[] exceptIds, IssueStep step, int pageIndex,
			int rows) {
		PropertyDict dict = propertyDictService
				.findPropertyDictByDomainNameAndInternalId(
						OrganizationType.ORG_TYPE_KEY,
						OrganizationType.FUNCTIONAL_ORG).get(0);
		return issueProcessDao.findChildOrgsByOrgcodeAndNameAndType(dict, step
				.getTarget().getOrgInternalCode(), tag, exceptIds, rows,
				pageIndex);
	}

	private void insertOrgToPages(Organization org,
			PageInfo<AutoCompleteData> datas) {
		datas.getResult().add(0, convertToAutoCompleteData(org));
		datas.setPerPageSize(datas.getResult().size());
		datas.setTotalRowSize(datas.getResult().size());
	}

	private Organization loadFullCurrentLoginedOrganization() {
		return loadFullOrganization(ThreadVariable.getSession()
				.getOrganization().getId());
	}

	private List<Organization> loadFullOrganizations(Long[] tells) {
		List<Organization> result = new ArrayList<Organization>();
		if (tells != null && tells.length > 0) {
			for (Long id : tells) {
				result.add(loadFullOrganization(id));
			}
		}
		return result;
	}

	private Organization loadFullOrganization(Long id) {
		return null == id ? null : organizationDubboService.getFullOrgById(id);
	}

	private IssueStep addAndReloadFullIssueStep(IssueStep step) {
		fetchSourceAndTargetOrg(step, step);
		IssueStep result = issueProcessDao.addIssueStep(step);
		fetchSourceAndTargetOrg(result, step);
		return result;
	}

	private IssueStep getSimpleIssueStepById(Long stepId) {
		return issueProcessDao.getSimpleIssueStepById(stepId);
	}

	private IssueStepGroup saveStepGroup(IssueStepGroup steps) {
		IssueNew issue = steps.getKeyStep().getIssue();
		steps.setKeyStep(addAndReloadFullIssueStep(steps.getKeyStep()));
		steps.setIssue(steps.getKeyStep().getIssue());
		if (steps.hasIncidentalStep()) {
			for (int index = 0; index < steps.getIncidentalSteps().size(); index++) {
				IssueStep issueStep = addAndReloadFullIssueStep(steps
						.getIncidentalSteps().get(index));
				steps.getIncidentalSteps().set(index, issueStep);
				tqSolrSearchCommonOperate.commonOperate(
						IssueSolrDocumentConvert.createIssueSolrDocument(issue,
								issueStep),
						TqSolrSearchOperateType.ADD_OR_UPDATE);
			}
		}
		return steps;
	}

	private void saveGroupId(IssueStepGroup steps) {
		IssueStep keyStep = steps.getKeyStep();
		List<IssueStep> incidentalSteps = steps.getIncidentalSteps();
		if (null != keyStep) {
			keyStep.setGroupId(steps.getId());
			issueProcessDao.updateGroupId(keyStep);
		}
		if (null != incidentalSteps && incidentalSteps.size() > 0) {
			for (IssueStep step : incidentalSteps) {
				step.setGroupId(steps.getId());
				issueProcessDao.updateGroupId(step);
			}
		}
	}

	private void fireIssueGroup(IssueStepGroup issueStepGroup) {
		issueStepGroup.setEntyLog(issueLogDao.getIssueLogsByStepId(
				issueStepGroup.getKeyStep().getId()).get(0));
		IssueStepGroup stepGroup = issueProcessDao
				.addIssueStepGroup(issueStepGroup);
		stepGroup.setIncidentalSteps(issueStepGroup.getIncidentalSteps());
		saveGroupId(stepGroup);
		List<IssueStepGroup> list = issueProcessDao
				.getIssueStepGroupByIssueId(stepGroup.getIssue().getId());
		if (null != list && list.size() > 1) {
			IssueStepGroup isg = list.get(list.size() - 2);
			isg.setOutLog(issueStepGroup.getEntyLog());
			issueProcessDao.updateOutLog(isg);
		}
	}

	private IssueOperationContext constructIssueOperationContext(
			Organization target, List<Organization> tells) {
		Organization org = organizationDubboService
				.getFullOrgById(ThreadVariable.getSession().getOrganization()
						.getId());
		IssueOperationContext context = new IssueOperationContext(org, target,
				"", ThreadVariable.getSession().getUserRealName());
		if (tells != null && tells.size() > 0) {
			for (Organization tellorg : tells) {
				context.addTellOrg(tellorg);
			}
		}
		return context;
	}

	private void fetchSourceAndTargetOrg(IssueStep step, IssueStep oldStep) {
		if (step.getSource().getId() < 0) {
			step.setSource(oldStep.getSource());
		} else {
			step.setSource(organizationDubboService.getSimpleOrgById(step
					.getSource().getId()));
		}
		if (step.getTarget().getId() < 0) {
			step.setTarget(oldStep.getTarget());
		} else {
			step.setTarget(organizationDubboService.getSimpleOrgById(step
					.getTarget().getId()));
		}
	}

	private void fetchFullSourceAndTargetOrg(IssueStep step) {
		if (step.getSource().getId() < 0) {
			step.setSource(IssueToCMSUtil.getLocationOrgNameByLocationId(step
					.getSource().getId()));
		} else {
			step.setSource(loadFullOrganization(step.getSource().getId()));
		}
		if (step.getTarget().getId() < 0) {
			step.setTarget(IssueToCMSUtil.getLocationOrgNameByLocationId(step
					.getTarget().getId()));
		} else {
			step.setTarget(loadFullOrganization(step.getTarget().getId()));
		}
	}

	private void fireIssueEntry(IssueNew issue, IssueStep step) {
		if (getIssueChangeListeners() != null) {
			for (IssueChangeListener listener : getIssueChangeListeners()) {
				listener.onEntry(issue, step);
			}
		}
	}

	private void fireIssueComplete(IssueNew issue, IssueStep step,
			IssueLogNew log, List<IssueAttachFile> attachFiles) {
		IssueChangeEvent event = new IssueChangeEvent(log, attachFiles,
				IssueOperate.COMPLETE);
		if (getIssueChangeListeners() != null) {
			for (IssueChangeListener listener : getIssueChangeListeners()) {
				listener.onComplete(issue, step, event);
			}
		}
	}

	private void fireIssueVerification(IssueNew issue, IssueStep step,
			IssueLogNew log, List<IssueAttachFile> attachFiles) {
		IssueChangeEvent event = new IssueChangeEvent(log, attachFiles,
				IssueOperate.VERIFICATION);
		if (getIssueChangeListeners() != null) {
			for (IssueChangeListener listener : getIssueChangeListeners()) {
				listener.onVerification(issue, step, event);
			}
		}
	}

	@Override
	public void fireIssueChanged(IssueNew issue, IssueStep step,
			IssueOperate operate, IssueLogNew log,
			List<IssueAttachFile> attachFiles) {
		IssueChangeEvent event = new IssueChangeEvent(log, attachFiles, operate);
		IssueStepGroup steps = new IssueStepGroup();
		steps.setKeyStep(step);
		if (getIssueChangeListeners() != null) {
			for (IssueChangeListener listener : getIssueChangeListeners()) {
				listener.onChanged(issue, steps, event);
			}
		}
	}

	private void fireIssueChanged(IssueNew issue, IssueStepGroup steps,
			IssueOperate operate, IssueLogNew log,
			List<IssueAttachFile> attachFiles) {
		IssueChangeEvent event = new IssueChangeEvent(log, attachFiles, operate);
		if (getIssueChangeListeners() != null) {
			for (IssueChangeListener listener : getIssueChangeListeners()) {
				listener.onChanged(issue, steps, event);
			}
		}
	}

	/**
	 * 越级上报，自动抄告越过的层级
	 * 
	 * @param issueSkiprule
	 * @param tells
	 * @return
	 */
	private List<Organization> constructGreatCopy(IssueSkiprule issueSkiprule,
			Long[] tells) {
		List<Organization> list = loadFullOrganizations(tells);// 页面上抄告的组织信息
		// 越级上报的组织信息
		Organization skipruleOrg = organizationDubboService
				.getSimpleOrgById(issueSkiprule.getSubmitOrgId());
		// 当前登录用户组织的父组织信息
		Organization currentParentOrg = ThreadVariable.getOrganization()
				.getParentOrg();
		// 当前行政部门到越级的行政部门，之间的所有行政部门
		List<Organization> tellsList = new ArrayList<Organization>();
		tellsList = findAllParentOrg(tellsList, skipruleOrg, currentParentOrg);
		// 判断当前层级到越级规则设定的层级，中间是否有层级
		if (tellsList != null && tellsList.size() > 0) {
			if (list != null && list.size() > 0) {
				allTellsList(tellsList, list);
			}
			return tellsList;
		} else {
			return list;
		}
	}

	/**
	 * 越级上报时，当前行政部门到越级的行政部门，之间的所有行政部门
	 * 
	 * @param tellsLists
	 *            (存储list)
	 * @param skipruleOrg
	 * @param currentParentOrg
	 * @return
	 */
	private List<Organization> findAllParentOrg(List<Organization> tellsLists,
			Organization skipruleOrg, Organization currentParentOrg) {
		if (!skipruleOrg.equals(currentParentOrg)) {
			tellsLists.add(currentParentOrg);
			currentParentOrg = organizationDubboService
					.getSimpleOrgById(currentParentOrg.getParentOrg().getId());
			findAllParentOrg(tellsLists, skipruleOrg, currentParentOrg);
		}
		return tellsLists;
	}

	/**
	 * 越级上报，最终需要抄告的所有组织机构（手动选择的和需要自动抄告的中间层级）
	 * 
	 * @param allParentOrgList
	 *            (所有越过层级的行政部门)
	 * @param list
	 *            (页面手动选中的组织机构)
	 * @return
	 */
	private List<Organization> allTellsList(
			List<Organization> allParentOrgList, List<Organization> list) {
		for (Organization organization : list) {
			if (organization.getOrgType().getInternalId() == OrganizationType.FUNCTIONAL_ORG) {// 手动选择的职能部门，全部加到抄告的列表中
				allParentOrgList.add(organization);
			} else if (isNeedToTell(allParentOrgList, organization)) {// 手动选中的行政部门，是否存在所有越过层级的list中
				allParentOrgList.add(organization);
			}
		}
		return allParentOrgList;
	}

	/**
	 * 判断org是否存在list中
	 * 
	 * @param allParentOrgList
	 * @param organization
	 * @return
	 */
	private boolean isNeedToTell(List<Organization> allParentOrgList,
			Organization organization) {
		for (Organization org : allParentOrgList) {
			if ((organization.getId()).equals(org.getId())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 事件上报时候，获取IssueOperationContext信息
	 * 
	 * @param targetOrg
	 * @param tells
	 *            （上报需要抄告的部门信息列表）
	 * @return
	 */
	private IssueOperationContext constructOperationContext(Long targetOrg,
			List<Organization> tells) {
		Organization target = loadFullOrganization(targetOrg);
		IssueOperationContext context = constructIssueOperationContext(target,
				tells);
		return context;
	}

	private int getSuperviseLevel(IssueOperate superviseType) {
		if (IssueOperate.NORMAL_SUPERVISE.equals(superviseType)) {
			return IssueState.NORMAL_SUPERVISE;
		} else if (IssueOperate.YELLOW_SUPERVISE.equals(superviseType)) {
			return IssueState.YELLOW_CARD_SUPERVISE;
		} else if (IssueOperate.RED_SUPERVISE.equals(superviseType)) {
			return IssueState.RED_CARD_SUPERVISE;
		} else {
			return IssueState.NO_SUPERVISE;
		}
	}

	@Override
	public List<IssueStep> findIssueStepListByIssueState(int[] issueStates) {
		PropertyDict sourceKind = propertyDictService
				.findPropertyDictByDomainNameAndDictDisplayName(
						PropertyTypes.SOURCE_KIND,
						IssueConstants.CALLCENTER_INPUT);
		List<IssueStep> list = issueProcessDao.findIssueStepListByIssueState(
				issueStates, sourceKind.getId());
		for (IssueStep issueStep : list) {
			issueStep.setSource(organizationDubboService
					.getSimpleOrgById(issueStep.getSource().getId()));
			issueStep.setTarget(organizationDubboService
					.getSimpleOrgById(issueStep.getTarget().getId()));
			issueStep.setIssue(issueService.getFullIssueByIssueId(issueStep
					.getIssue().getId()));
		}
		return list;
	}

	private void updateIsNotStayIssueSteps(IssueStep issueStep, IssueNew issue) {
		if (issueStep == null || issueStep.getTarget() == null
				|| issueStep.getTarget().getId() == null
				|| issueStep.getId() == null || issueStep.getIssue() == null
				|| issueStep.getIssue().getId() == null) {
			return;
		}
		List<IssueStep> issueSteps = issueProcessDao
				.findIsNotStayStepByIssueStep(issueStep);
		if (issueSteps == null || issueSteps.size() < 1) {
			return;
		}
		for (IssueStep isp : issueSteps) {
			issueProcessDao.updateIsNotStayStepByIssueStepId(isp.getId());
			isp.setIsStayStep(IssueIsStayStepType.IS_NOT_STAYSTEP);
			Organization org = organizationDubboService.getSimpleOrgById(isp.getSource().getId());
			isp.setSource(org);
			tqSolrSearchCommonOperate.commonOperate(IssueSolrDocumentConvert
					.createIssueSolrDocument(issue, isp),
					TqSolrSearchOperateType.ADD_OR_UPDATE);
		}
	}
}

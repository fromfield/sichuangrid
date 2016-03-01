package com.tianque.issue.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tianque.approval.domain.property.ApprovalItemStatus;
import com.tianque.baseInfo.utils.CustomDateUtil;
import com.tianque.core.base.AbstractBaseDao;
import com.tianque.core.util.ThreadVariable;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.GisInfo;
import com.tianque.domain.IssueType;
import com.tianque.domain.IssueTypeDomain;
import com.tianque.domain.Organization;
import com.tianque.file.constants.AttachFileModule;
import com.tianque.file.domain.AttachFile;
import com.tianque.issue.constants.IssueAttachFileType;
import com.tianque.issue.constants.IssueTag;
import com.tianque.issue.constants.IssueViewType;
import com.tianque.issue.dao.IssueDao;
import com.tianque.issue.domain.IssueAttachFile;
import com.tianque.issue.domain.IssueEvaluate;
import com.tianque.issue.domain.IssueNew;
import com.tianque.issue.domain.IssueStep;
import com.tianque.issue.state.IssueSourceState;
import com.tianque.issue.state.IssueState;
import com.tianque.issue.uitl.IssueAttachFileRetuenUtil;
import com.tianque.issue.vo.IssueViewObject;
import com.tianque.util.DateFormat;

@Repository("issueDao")
public class IssueDaoImpl extends AbstractBaseDao implements IssueDao {
	private final static Long NO_SEARCH_ORG = null;// 事件快速检索时候，未选择组织机构
	private final static int ORG_CODE_FIND_LEVEL = 0;// 事件快速检索时候，未选择组织机构
	private final static String NO_SEARCH_ORGCODE = "";// 事件快速检索时候，未选择组织机构

	private PageInfo<IssueViewObject> createIssueVoPageInfoInstance(
			int totalRecord, int pageSize, int pageIndex) {
		PageInfo<IssueViewObject> result = new PageInfo<IssueViewObject>();
		result.setTotalRowSize(totalRecord);
		result.setCurrentPage(pageIndex);
		result.setPerPageSize(pageSize);
		return result;
	}

	/**
	 * 统计已办的事件数量
	 * 
	 * @param params
	 * @return
	 */
	public int getMyDoneCount(Map params) {
		// return (Integer) getSqlMapClientTemplate().queryForObject(
		// "issue.countMyDone", params);
		return getJurisdictionsDone(params);
	}

	private int getJurisdictionsFollow(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsFollow", map);
	}

	private int getJurisdictionsDone(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsDone", map);
	}

	private int getTimeOutIssue(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countTimeOutIssue", map);
	}

	private int getJurisdictionsSkipIssue(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsSkipIssue", map);
	}

	private int getJurisdictionsCompleted(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsCompleted", map);
	}

	private int getJurisdictionsGradeDelay(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsGradeDelay", map);
	}

	/**
	 * 查询待验证的数据
	 * 
	 * @param map
	 * @return
	 */
	public int getJurisdictionsVerification(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsVerification", map);
	}

	private int getJurisdictionsSubmit(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsSubmit", map);
	}

	/***
	 * 查询宣传案例的数据
	 * 
	 * @param map
	 * @return
	 */
	private int findJurisdictionsPublicltyCassDone(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsPublicltyCassDone", map);
	}

	private int getMyCompleted(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countMyCompleted", map);
	}

	/**
	 * 查询待办的数量
	 * 
	 * @param map
	 * @return
	 */
	public int getJurisdictionsNeedDoCount(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsNeedDo", map);
	}

	/**
	 * 查询待办的数量
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public int getJurisdictionsNeedDoCountForOverseerForMobile(
			Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsNeedDoForOverseerForMobile", map);
	}

	@Override
	public int getJurisdictionsAuditDelayCount(Long orgLevel, Organization org,
			Long functionalOrgType, int orgCodeFindLevel, Long searchOrgId,
			String searchOrgCode, Long issueType) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCode", searchOrgCode);
		} else {
			map.put("orgCode", org.getOrgInternalCode());
		}
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("superviselevel", IssueState.RED_CARD_SUPERVISE);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsAuditDelayByLevel", map);
	}

	@Override
	public int getJurisdictionsAuditDelayCount(Long orgId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsAuditDelay", map);
	}

	@Override
	public int getJurisdictionsVerificationCountForViewTab(Long orgLevel,
			Organization org, Long functionalOrgType) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		map.put("orgCode", org.getOrgInternalCode());
		map.put("statecode", IssueState.ISSUEVERIFICATION_CODE);
		map.put("status", IssueState.COMPLETE);
		map.put("functionalOrgType", functionalOrgType);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsVerificationForViewTab", map);

	}

	@Override
	public int getJurisdictionsGradeDelayCountForViewTab(Long orgLevel,
			Organization org, Long functionalOrgType) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		/** 20天以内的展示的条件 */
		map.put("limitDate", CustomDateUtil
				.dateBeforeNowDateByDays(CustomDateUtil.DAYS_BEFORE));
		map.put("orgCode", org.getOrgInternalCode());
		map.put("completeCode", IssueState.ISSUECOMPLETE_CODE);
		map.put("functionalOrgType", functionalOrgType);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsGradeDelayForViewTab_new", map);
	}

	private int getJurisdictionsAssginCount(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsAssgin", map);
	}

	private int getJurisdictionsDoingCount(Map<String, Object> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countJurisdictionsDoing", map);
	}

	private int getMyHistoricCount(String orgCode) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countMyHistoric", orgCode);
	}

	private int getMyPublicltyCount(Long orgId) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countMyPubliclty", orgId);
	}

	@Override
	public IssueNew addIssue(IssueNew issue) {
		Long id = (Long) getSqlMapClientTemplate().insert("issue.addIssue",
				issue);
		// addIssueTypes(id, issue.getIssueTypes());
		return getFullIssueById(id);
	}

	/** 保存事件类型 */
	private void addIssueTypes(Long issueId, List<IssueType> list) {
		if (list != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("issueId", issueId);
			for (IssueType type : list) {
				params.put("type", type);
				try {
					getSqlMapClientTemplate().insert("issue.addIssueHasType",
							params);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}

	@Override
	public IssueNew updateIssue(IssueNew issue) {
		getSqlMapClientTemplate().update("issue.updateIssue", issue);
		return getFullIssueById(issue.getId());
	}

	@Override
	public boolean deleteIssueById(Long issueId) {
		getSqlMapClientTemplate().delete("issue.removeIssue", issueId);
		return true;
	}

	@Override
	public boolean removeAllIssueAttachFiles(Long issueId) {
		getSqlMapClientTemplate().delete(
				"issue.removeAllIssueAttachFilesFromBaseFile", issueId);
		getSqlMapClientTemplate().delete("issue.removeAllIssueAttachFiles",
				issueId);
		return true;
	}

	@Override
	public IssueNew getFullIssueById(Long id) {
		return (IssueNew) getSqlMapClientTemplate().queryForObject(
				"issue.getFullIssueById", id);
	}

	@Override
	public IssueAttachFileRetuenUtil addIssueAttachFiles(
			List<IssueAttachFile> attachFiles) {
		IssueAttachFileRetuenUtil attachFileRetuen = new IssueAttachFileRetuenUtil();
		List<Long> attachFileId = new ArrayList<Long>();
		List<String> attachFileName = new ArrayList<String>();
		if (attachFiles != null && !attachFiles.isEmpty()) {

			Map<String, Object> params = new HashMap<String, Object>();

			for (IssueAttachFile file : attachFiles) {
				params.put("issueId", file.getIssue().getId());
				if (file.getIssueLog() == null) {
					params.put("fileType", IssueAttachFileType.ISSUE_FILE);
				} else {
					params.put("fileType", IssueAttachFileType.ISSUELOG_FILE);
					params.put("issueLogId", file.getIssueLog().getId());
				}
				Long id = (Long) getSqlMapClientTemplate().insert(
						"issue.addIssueAttachFiles", params);
				getSqlMapClientTemplate().insert("attachFiles.addAttachFile",
						constractAttachFile(id, file));
				attachFileId.add(id);
				attachFileName.add(file.getFileName());
			}
		}
		attachFileRetuen.setAttachFileId(attachFileId);
		attachFileRetuen.setAttachFileName(attachFileName);
		return attachFileRetuen;
	}

	@Override
	public void addIssueEvaluateAttachFiles(List<IssueAttachFile> attachFiles) {
		if (attachFiles != null && !attachFiles.isEmpty()) {
			Map<String, Object> params = new HashMap<String, Object>();
			for (IssueAttachFile file : attachFiles) {
				params.put("issueId", file.getIssue().getId());
				params.put("fileType", IssueAttachFileType.ISSUEEVALUATE_FILE);
				Long id = (Long) getSqlMapClientTemplate().insert(
						"issue.addIssueAttachFiles", params);
				getSqlMapClientTemplate().insert("attachFiles.addAttachFile",
						constractAttachFile(id, file));
			}
		}
	}

	private AttachFile constractAttachFile(Long objId, IssueAttachFile file) {
		AttachFile attachFile = new AttachFile();
		attachFile.setModuleKey(AttachFileModule.MODULE_TYPE);
		attachFile.setModuleObjectId(objId.toString());
		attachFile.setName(file.getFileName());
		attachFile.setPhysicsFullFileName(file.getFileActualUrl());
		return attachFile;
	}

	@Override
	public List<IssueAttachFile> loadIssueAttachFilesByIssueAndLog(
			Long issueId, Long logId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("issueId", issueId);
		if (null != logId) {
			params.put("issueLogId", logId);
		}
		return getSqlMapClientTemplate().queryForList(
				"issue.loadIssueAttachFilesByIssueAndLog", params);
	}

	@Override
	public void updateIssueCurrentStepAndOrg(IssueNew issue) {
		getSqlMapClientTemplate().update("issue.updateIssueCurrentStepAndOrg",
				issue);
	}

	@Override
	public IssueNew getFullIssueByStepId(Long stepId) {
		return (IssueNew) getSqlMapClientTemplate().queryForObject(
				"issue.getFullIssueByStepId", stepId);
	}

	@Override
	public IssueAttachFile getIssueAttachFileById(Long id) {
		return (IssueAttachFile) getSqlMapClientTemplate().queryForObject(
				"issue.getIssueAttachFileById", id);
	}

	public List<IssueAttachFile> getIssueAttachFileByIssueId(Long issueId) {
		return getSqlMapClientTemplate().queryForList(
				"issue.getIssueAttachFileByIssueId", issueId);
	}

	@Override
	public boolean updateIssueHistoricState(Long issueId, boolean state) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", state);
		params.put("issueid", issueId);
		getSqlMapClientTemplate().update("issue.updateIssueHistoricState",
				params);
		return true;
	}

	@Override
	public boolean updateIssueUrgentState(Long issueId, boolean state) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", state);
		params.put("issueid", issueId);
		getSqlMapClientTemplate()
				.update("issue.updateIssueUrgentState", params);
		return true;
	}

	@Override
	public boolean alreadyPubliclty(Long issueId, Long orgId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		map.put("issueId", issueId);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countPubliclty", map) > 0;
	}

	@Override
	public void publiclty(Long orgId, Long issueId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		map.put("issueId", issueId);
		getSqlMapClientTemplate().insert("issue.addPublicltyCass", map);
	}

	@Override
	public void removePubliclty(Long orgId, Long issueId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		map.put("issueId", issueId);
		getSqlMapClientTemplate().delete("issue.removeIssueFromPublicltyCass",
				map);
	}

	@Override
	public void removePublicltyByIssueId(Long issueId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("issueId", issueId);
		getSqlMapClientTemplate().delete("issue.removePublicltyByIssueId", map);
	}

	@Override
	public PageInfo<IssueViewObject> findMyNeedDoIssues(Long orgId,
			Long issueType, int page, int rows, String sidx, String sord) {

		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getMyNeedDoCount(orgId, issueType), rows, page);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("orgId", orgId);
		if (null != issueType) {
			map.put("issueType", issueType);
			map.put("status", ApprovalItemStatus.IN_PROCESS);
		}
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("sortField", sidx);
		map.put("order", sord);
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findMyNeedDoIssues", map, (page - 1) * rows, rows));
		return result;
	}

	public PageInfo<IssueViewObject> findcommandCenterMyNeedDoIssues(
			Long orgId, Long issueType, int page, int rows, String sidx,
			String sord, String commandCenterNum) {
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getMyNeedDoCount(orgId, issueType), rows, page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		if (null != issueType) {
			map.put("issueType", issueType);
			map.put("status", ApprovalItemStatus.IN_PROCESS);
		}
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("sortField", sidx);
		map.put("order", sord);
		map.put("commandCenterNum", commandCenterNum);
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findcommandCenterMyNeedDoIssues", map,
				(page - 1) * rows, rows));
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findMyDone(Long orgId, IssueNew issue,
			Integer page, Integer rows, String sidx, String sord, Long issueType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("status", issue == null ? null
				: (issue.getStatus() == -1 ? null : issue.getStatus()));
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("sortField", sidx);
		map.put("order", sord);
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getMyDoneCount(map), rows, page);
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findMyDoneIssues", map, (page - 1) * rows, rows));
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findcommandCenterMyDone(Long orgId,
			IssueNew issue, Integer page, Integer rows, String sidx,
			String sord, String commandCenterNum, int stateKind) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		if (stateKind == -1) {
			map.put("stepcompleteCode", IssueState.DEALING_CODE);
		} else if (stateKind == 300) {
			Organization organization = (Organization) getSqlMapClientTemplate()
					.queryForObject("organization.findById", orgId);
			map.put("issuecompleteCode", IssueState.DEALING);
			map.put("orgCode", organization.getOrgInternalCode());
		} else {
			Organization organization = (Organization) getSqlMapClientTemplate()
					.queryForObject("organization.findById", orgId);
			map.put("stepcompleteCode", IssueState.DEALING_CODE);
			map.put("issuecompleteCode", IssueState.DEALING);
			map.put("orgCode", organization.getOrgInternalCode());
		}
		map.put("sortField", sidx);
		map.put("order", sord);
		map.put("commandCenterNum", commandCenterNum);
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getMyDoneCount(map), rows, page);
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findcommandCenterMyDoneIssues", map, (page - 1) * rows,
				rows));
		return result;
	}

	@Override
	public int getMyNeedDoCount(Long orgId, Long issueType) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != issueType) {
			map.put("issueType", issueType);
			map.put("status", ApprovalItemStatus.IN_PROCESS);
		}
		map.put("orgId", orgId);
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.countMyNeedDo", map);
	}

	@Override
	public PageInfo<IssueViewObject> findMyHistoricIssues(Long orgId,
			String orgInternalCode, Integer page, Integer rows, String sidx,
			String sord) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		map.put("orgCode", orgInternalCode);
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getMyHistoricCount(orgInternalCode), rows, page);
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findMyHistoricIssues", map, (page - 1) * rows, rows));
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findMyPublicltyIssues(Long orgId,
			Integer page, Integer rows, String sidx, String sord) {
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getMyPublicltyCount(orgId), rows, page);
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findMyPublicltyIssues", orgId, (page - 1) * rows, rows));
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsSkipIssue(
			Organization org, Integer page, Integer rows, String sidx,
			String sord, Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId, String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("orgCode", org.getOrgInternalCode());
		map.put("orgId", org.getId());
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		// map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("issueTag", IssueTag.SKIP_ISSUE);
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsSkipIssue(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findJurisdictionsSkeipIssue", map, (page - 1) * rows,
				rows));
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsFollow(Organization org,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId, String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		if (org != null && org.getOrgInternalCode() != null) {
			map.put("orgCode", org.getOrgInternalCode());
		}
		if (org != null && org.getId() != null) {
			map.put("orgId", org.getId());
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("verification", IssueState.VERIFICATION);// 事件表中已验证状态，值为300
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);// 事件流程表中办理中的状态，值为500
		map.put("issueCompleteCode", IssueState.ISSUECOMPLETE_CODE);// 事件流程表中已验证的状态，值为1000
		map.put("issueTag", IssueTag.DONE_ISSUE);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsFollow(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsFollow", map));
		} else {
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsFollow", map, (page - 1) * rows,
					rows));
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsDone(Organization org,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId, String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("orgCode", org.getOrgInternalCode());
		map.put("orgId", org.getId());
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("issueTag", IssueTag.DONE_ISSUE);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsDone(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsDone", map));
		} else {
			result.setResult(getSqlMapClientTemplate()
					.queryForList("issue.findJurisdictionsDone", map,
							(page - 1) * rows, rows));
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findTimeOutIssue(Organization org,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Integer superviseType, Long orgLevel,
			String leaderView, Long functionalOrgType, Integer viewProcess,
			Long sourceType, int orgCodeFindLevel, Long searchOrgId,
			String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("orgCode", org.getOrgInternalCode());
		map.put("supervise", superviseType);
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);// 办理中的事件
		map.put("verification", IssueState.ISSUEVERIFICATION_CODE);// 待验证的事件
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getTimeOutIssue(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findTimeOutIssue", map));
		} else {
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findTimeOutIssue", map, (page - 1) * rows, rows));
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsCompleted(
			Organization org, Integer page, Integer rows, String sidx,
			String sord, Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, String issueGradeIsVisabled, int orgCodeFindLevel,
			Long searchOrgId, String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("orgCode", org.getOrgInternalCode());
		map.put("orgId", org.getId());
		map.put("statusType", statusType);
		map.put("completeCode", IssueState.ISSUECOMPLETE_CODE);
		map.put("issueTag", IssueTag.COMPLETED_ISSUE);
		map.put("issueGradeIsVisabled", issueGradeIsVisabled);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsCompleted(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsCompleted", map));
		} else {
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsCompleted", map, (page - 1) * rows,
					rows));
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsGradeDelay(
			Organization org, Integer page, Integer rows, String sidx,
			String sord, Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, int orgCodeFindLevel, Long searchOrgId,
			String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("orgCode", org.getOrgInternalCode());
		map.put("orgId", org.getId());
		map.put("statusType", statusType);
		map.put("completeCode", IssueState.ISSUECOMPLETE_CODE);
		map.put("issueTag", IssueTag.CHECKGRADE_ISSUE);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		/** 20天以内的展示的条件 */
		map.put("nowDate",
				DateFormat.getAddDate(DateFormat.DEFAULT_DATE_FORMAT, -20));
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsGradeDelay(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsGradeDelay", map));
		} else {
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsGradeDelay", map,
					(page - 1) * rows, rows));
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsVerification(
			Organization org, Integer page, Integer rows, String sidx,
			String sord, Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, int orgCodeFindLevel, Long searchOrgId,
			String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("orgCode", org.getOrgInternalCode());
		map.put("orgId", org.getId());
		map.put("statusType", statusType);
		map.put("completeCode", IssueState.ISSUEVERIFICATION_CODE);
		map.put("issueTag", IssueTag.VERIFICATION_ISSUE);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsVerification(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsVerification", map));
		} else {
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsVerification", map,
					(page - 1) * rows, rows));
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsPublicltyCassDone(
			Organization org, Integer page, Integer rows, String sidx,
			String sord, Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, String issueGradeIsVisabled, int orgCodeFindLevel,
			Long searchOrgId, String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("orgCode", org.getOrgInternalCode());
		map.put("orgId", org.getId());
		map.put("statusType", statusType);
		map.put("completeCode", IssueState.ISSUECOMPLETE_CODE);
		map.put("issueTag", IssueTag.COMPLETED_ISSUE);
		map.put("issueGradeIsVisabled", issueGradeIsVisabled);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				findJurisdictionsPublicltyCassDone(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsPublicltyCassDone", map));
		} else {
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsPublicltyCassDone", map,
					(page - 1) * rows, rows));
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findMyCompleted(Long orgId,
			String orgInternalCode, Integer page, Integer rows, String sidx,
			String sord, Long issueType) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("orgId", orgId);
		map.put("orgCode", orgInternalCode);
		map.put("completeCode", IssueState.ISSUECOMPLETE_CODE);
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getMyCompleted(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findMyCompleted", map, (page - 1) * rows, rows));
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsNeedDo(String seachValue,
			Organization org, Integer page, Integer rows, String sidx,
			String sord, Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId, String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("seachValue", seachValue);
		map.put("orgId", org.getId());
		map.put("orgCode", org.getOrgInternalCode());
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("issueTag", IssueTag.NEEDDO_ISSUE);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsNeedDoCount(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsNeedDo", map));
		} else {
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsNeedDo", map, (page - 1) * rows,
					rows));
		}

		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsNeedDoForOverseerForMobile(
			String seachValue, Organization org, Integer page, Integer rows,
			String sidx, String sord, Long issueType, Long orgLevel,
			String leaderView, Long functionalOrgType, Integer viewProcess,
			Long sourceType) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("seachValue", seachValue);
		map.put("orgId", org.getId());
		map.put("orgCode", org.getOrgInternalCode());
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("issueTag", IssueTag.NEEDDO_ISSUE);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsNeedDoCountForOverseerForMobile(map), rows,
				page);
		map.put("sortField", sidx);
		map.put("order", sord);

		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findJurisdictionsNeedDoForOverseerForMobile", map,
				(page - 1) * rows, rows));
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsDoing(String seachValue,
			Organization org, Integer page, Integer rows, String sidx,
			String sord, Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, int orgCodeFindLevel,
			Long searchOrgId, String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("seachValue", seachValue);
		map.put("orgId", org.getId());
		map.put("orgCode", org.getOrgInternalCode());
		map.put("unconceptedCode", IssueState.UNCONCEPTED_CODE);
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsDoingCount(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsDoing", map));
		} else {
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsDoing", map, (page - 1) * rows,
					rows));
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsAssgin(String seachValue,
			Organization org, Integer page, Integer rows, String sidx,
			String sord, Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId, String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("seachValue", seachValue);
		map.put("orgId", org.getId());
		map.put("orgCode", org.getOrgInternalCode());
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("assgin", IssueSourceState.assign);
		map.put("issueTag", IssueTag.ASSIGN_ISSUE);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsAssginCount(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsAssgin", map));
		} else {
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsAssgin", map, (page - 1) * rows,
					rows));
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsSubmit(Organization org,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId, String searchOrgCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("orgCode", org.getOrgInternalCode());
		map.put("orgId", org.getId());
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("submit", IssueSourceState.submit);
		map.put("issueTag", IssueTag.SUBMIT_ISSUE);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsSubmit(map), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {// 用于查询大屏滚动数据
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsSubmit", map));
		} else {
			result.setResult(getSqlMapClientTemplate().queryForList(
					"issue.findJurisdictionsSubmit", map, (page - 1) * rows,
					rows));
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsNeedDoForProcess(
			String seachValue, Organization org, String sidx, String sord) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seachValue", seachValue);
		map.put("orgId", org.getId());
		map.put("orgCode", org.getOrgInternalCode());
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		map.put("sortField", sidx);
		map.put("order", sord);
		PageInfo<IssueViewObject> result = new PageInfo<IssueViewObject>();
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findJurisdictionsNeedDo", map));
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsDoneForProcess(
			String seachValue, Organization org, String sidx, String sord) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seachValue", seachValue);
		map.put("orgCode", org.getOrgInternalCode());
		map.put("orgId", org.getId());
		map.put("completeCode", IssueState.ISSUECOMPLETE_CODE);
		PageInfo<IssueViewObject> result = new PageInfo<IssueViewObject>();
		map.put("userOrgLevel", ThreadVariable.getOrganization().getOrgLevel()
				.getInternalId());
		map.put("sortField", sidx);
		map.put("order", sord);
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findJurisdictionsCompleted", map));
		return result;
	}

	@Override
	public List<IssueNew> searchAllRoundIssues(GisInfo minOption,
			GisInfo maxOption) {
		Map<String, GisInfo> map = new HashMap<String, GisInfo>();
		map.put("minOption", minOption);
		map.put("maxOption", maxOption);
		return getSqlMapClientTemplate().queryForList(
				"issue.searchAllRoundIssues", map);
	}

	@Override
	public void addIssueHasTypes(Long issueId, Long IssueTypeId,
			Long IssueTypeDomainId) {
		Map<String, Object> map = getparameters(issueId, IssueTypeId,
				IssueTypeDomainId);
		getSqlMapClientTemplate().insert("issue.addIssueHasType", map);

	}

	private Map<String, Object> getparameters(Long issueId, Long IssueTypeId,
			Long IssueTypeDomainId) {
		Map<String, Object> map = new HashMap<String, Object>();
		IssueType type = new IssueType();
		IssueTypeDomain issueDomain = new IssueTypeDomain();
		issueDomain.setId(IssueTypeDomainId);

		type.setId(IssueTypeId);
		type.setIssueTypeDomain(issueDomain);

		map.put("issueId", issueId);
		map.put("type", type);
		return map;
	}

	@Override
	public void deleteIssueHasTypesByIssueId(Long issueId) {
		getSqlMapClientTemplate().delete("issue.deleteIssueHasTypesByIssueId",
				issueId);
	}

	@Override
	public void deleteIssueHasTypesByIssueIdAndIssueTypeId(Long issueId,
			Long IssueTypeId) {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("issueId", issueId);
		map.put("IssueTypeId", IssueTypeId);
		getSqlMapClientTemplate().delete(
				"issue.deleteIssueHasTypesByIssueIdAndIssueTypeId", map);

	}

	@Override
	public void deleteAttachFileByAttachfilesId(Long fileId) {
		getSqlMapClientTemplate().delete(
				"issue.deleteAttachFileBymoduleobjectId", fileId);
		getSqlMapClientTemplate().delete("issue.deleteIssuehasattachfilesById",
				fileId);
	}

	@Override
	public IssueNew getIssueBySerialNumber(String serialNumber) {
		if (null == serialNumber || "".equals(serialNumber.trim())) {
			return null;
		}
		return (IssueNew) getSqlMapClientTemplate().queryForObject(
				"issue.getIssueBySerialNumber", serialNumber);
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionAuditDelay(
			Organization org, Long orgLevel, Long functionalOrgType,
			Integer page, Integer rows, String sidx, String sord,
			int orgCodeFindLevel, Long searchOrgId, String searchOrgCode,
			Long issueType) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		map.put("searchOrgId", searchOrgId);
		if (searchOrgId != null) {
			map.put("orgCodeFindLevel", orgCodeFindLevel);
			map.put("searchOrgCode", searchOrgCode);
		}
		if (searchOrgId != null) {
			map.put("orgCode", searchOrgCode);
		} else {
			map.put("orgCode", org.getOrgInternalCode());
		}
		map.put("functionalOrgType", functionalOrgType);
		PageInfo<IssueViewObject> result = createIssueVoPageInfoInstance(
				getJurisdictionsAuditDelayCount(orgLevel, org,
						functionalOrgType, orgCodeFindLevel, searchOrgId,
						searchOrgCode, issueType), rows, page);
		map.put("sortField", sidx);
		map.put("order", sord);
		// 2014.9.15重新确认了需求，只查询状态为待办的待审核记录
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("superviselevel", IssueState.RED_CARD_SUPERVISE);
		result.setResult(getSqlMapClientTemplate().queryForList(
				"issue.findJurisdictionAuditDelay", map, (page - 1) * rows,
				rows));
		return result;
	}

	@Override
	public IssueEvaluate getIssueEvaluateById(Long id) {
		return (IssueEvaluate) getSqlMapClientTemplate().queryForObject(
				"issue.getIssueEvaluateById", id);
	}

	@Override
	public Integer getIssueStepDelayWorkDaysById(Long stepId) {
		Integer result = (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.getIssueStepDelayWorkDaysById", stepId);
		return result == null ? 0 : result;
	}

	@Override
	public List<IssueAttachFile> getIssueAttachFileAndNotLogAttachFileByIssueId(
			Long issueId) {
		return getSqlMapClientTemplate()
				.queryForList(
						"issue.getIssueAttachFileAndNotLogAttachFileByIssueId",
						issueId);
	}

	@Override
	public List<IssueAttachFile> getIssueEvaluateAttachFileAttachFileByIssueId(
			Long issueId) {
		return getSqlMapClientTemplate().queryForList(
				"issue.getIssueEvaluateAttachFileAttachFileByIssueId", issueId);
	}

	@Override
	public List<IssueStep> searchIssueStepsByIssueId(Long issueId) {
		return getSqlMapClientTemplate().queryForList(
				"issue.searchIssueStepsByIssueId", issueId);
	}

	@Override
	public List<IssueStep> searchAllIssueStepsByStepId(Long stepId) {
		return getSqlMapClientTemplate().queryForList(
				"issue.searchAllIssueStepsByStepId", stepId);
	}

	@Override
	public List<IssueAttachFile> getDocfilesByIdAndModuleKey(Long issueId,
			String moduleType, String fileType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fileId", issueId);
		map.put("moduleKey", moduleType);
		map.put("fileType", fileType);
		return getSqlMapClientTemplate().queryForList(
				"issue.getDocfilesByIdAndModuleKey", map);
	}

	@Override
	public Integer findIssueExistForMobile(IssueNew issue) {

		return (Integer) getSqlMapClientTemplate().queryForObject(
				"issue.queryIssueExistForCount", issue);
	}

	/**
	 * 为手机端增加一个返回事件步骤的方法
	 */
	@Override
	public IssueStep findIssueStepByIssueId(Long issueId) {

		return (IssueStep) getSqlMapClientTemplate().queryForObject(
				"issueStep.getIssueStepByIssueId", issueId);
	}

	@Override
	public int getIssueNumWorkBench(String seachValue, Organization org,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, Long sourceType,
			boolean needIssuePermission, boolean checkPendingIssuePermission,
			boolean verificationIssuePermission,
			boolean checkGradeIssuePermission) {
		int totalRowSize = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (issueType != null) {
			map.put("issueType", issueType);
		}
		map.put("searchOrgId", NO_SEARCH_ORG);
		if (orgLevel != null) {
			map.put("orgLevel", orgLevel);
		}
		if (leaderView != null && !"".equals(leaderView)) {
			map.put("leaderView", leaderView);
		}
		if (sourceType != null) {
			map.put("sourceType", sourceType);
		}
		map.put("functionalOrgType", functionalOrgType);
		map.put("seachValue", seachValue);
		map.put("orgId", org.getId());
		map.put("orgCode", org.getOrgInternalCode());
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("issueTag", IssueTag.NEEDDO_ISSUE);
		if (needIssuePermission) {
			totalRowSize += getJurisdictionsNeedDoCount(map);// 待办事件的数量
		}
		if (checkPendingIssuePermission) {
			totalRowSize += getJurisdictionsAuditDelayCount(orgLevel, org,
					functionalOrgType, ORG_CODE_FIND_LEVEL, NO_SEARCH_ORG,
					NO_SEARCH_ORGCODE, issueType);// 待审核事件的数量
		}
		if (verificationIssuePermission) {
			map.put("statusType", "");
			map.put("completeCode", IssueState.ISSUEVERIFICATION_CODE);
			map.put("issueTag", IssueTag.VERIFICATION_ISSUE);
			totalRowSize += getJurisdictionsVerification(map);// 待验证数据的数量
		}
		if (checkGradeIssuePermission) {
			map.put("completeCode", IssueState.ISSUECOMPLETE_CODE);
			map.put("issueTag", IssueTag.CHECKGRADE_ISSUE);
			totalRowSize += getJurisdictionsGradeDelay(map);// 待评分的数量
		}
		return totalRowSize;
	}

	@Override
	public void updateIssueFromSerialNumber(Long issueId, String demandCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("issueId", issueId);
		map.put("fromSerialNumber", demandCode);
		getSqlMapClientTemplate().update("issue.updateIssueFromSerialNumber",
				map);
	}

	@Override
	public void updateIssueDeadLine(IssueNew issue) {
		getSqlMapClientTemplate().update("issue.updateIssueDeadLine", issue);
	}

	@Override
	public void updateTableUpdateDateById(Long id) {
		super.updateTableUpdateDateById("issues", id);
	}

	@Override
	public void publiclty(Long issueId, int flag) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("issueId", issueId);
		map.put("flag", flag);
		getSqlMapClientTemplate().update("issue.publiclty", map);
	}
	
	@Override
	public void publicltyHistory(Long issueId, int flag) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("issueId", issueId);
		map.put("flag", flag);
		getSqlMapClientTemplate().update("issue.publicltyHistory", map);
	}

	@Override
	public void updateEventStateByIssueId(Long issueId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("issueId", issueId);
		getSqlMapClientTemplate()
				.update("issue.updateEventStateByIssueId", map);
	}
}

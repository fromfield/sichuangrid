package com.tianque.issue.service.impl;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.struts2.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tianque.approval.service.ApprovalItemService;
import com.tianque.baseInfo.dangerousChemicalsUnit.domain.DangerousChemicalsUnit;
import com.tianque.baseInfo.dangerousChemicalsUnit.service.DangerousChemicalsUnitService;
import com.tianque.baseInfo.dangerousGoodsPractitioner.domain.DangerousGoodsPractitioner;
import com.tianque.baseInfo.dangerousGoodsPractitioner.service.DangerousGoodsPractitionerService;
import com.tianque.baseInfo.druggy.domain.Druggy;
import com.tianque.baseInfo.druggy.service.DruggyService;
import com.tianque.baseInfo.idleYouth.domain.IdleYouth;
import com.tianque.baseInfo.idleYouth.service.IdleYouthService;
import com.tianque.baseInfo.internetBar.domain.InternetBar;
import com.tianque.baseInfo.internetBar.service.InternetBarService;
import com.tianque.baseInfo.mentalPatient.domain.MentalPatient;
import com.tianque.baseInfo.mentalPatient.service.MentalPatientService;
import com.tianque.baseInfo.otherAttentionPersonnel.domain.OtherAttentionPersonnel;
import com.tianque.baseInfo.otherAttentionPersonnel.service.OtherAttentionPersonnelService;
import com.tianque.baseInfo.positiveInfo.domain.PositiveInfo;
import com.tianque.baseInfo.positiveInfo.service.PositiveInfoService;
import com.tianque.baseInfo.publicPlace.domain.PublicPlace;
import com.tianque.baseInfo.publicPlace.service.PublicPlaceService;
import com.tianque.baseInfo.rectificativePerson.domain.RectificativePerson;
import com.tianque.baseInfo.rectificativePerson.service.RectificativePersonService;
import com.tianque.baseInfo.rentalHouse.domain.RentalHouse;
import com.tianque.baseInfo.rentalHouse.service.RentalHouseService;
import com.tianque.baseInfo.superiorVisit.domain.SuperiorVisit;
import com.tianque.baseInfo.superiorVisit.service.SuperiorVisitService;
import com.tianque.controller.annotation.SolrServerIndex;
import com.tianque.core.base.AbstractBaseService;
import com.tianque.core.datatransfer.dataconvert.ValidateHelper;
import com.tianque.core.globalSetting.service.GlobalSettingService;
import com.tianque.core.globalSetting.util.GlobalSetting;
import com.tianque.core.util.CalendarUtil;
import com.tianque.core.util.FileUtil;
import com.tianque.core.util.GridProperties;
import com.tianque.core.util.StringUtil;
import com.tianque.core.util.ThreadVariable;
import com.tianque.core.validate.ValidateResult;
import com.tianque.core.vo.AutoCompleteData;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Enterprise;
import com.tianque.domain.GisInfo;
import com.tianque.domain.Hospital;
import com.tianque.domain.IssueType;
import com.tianque.domain.IssueTypeDomain;
import com.tianque.domain.Organization;
import com.tianque.domain.OtherLocale;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.RegradedPoints;
import com.tianque.domain.School;
import com.tianque.domain.property.IssueSourceType;
import com.tianque.domain.property.OrganizationType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.domain.vo.EmphasesVo;
import com.tianque.domain.vo.WorkContacterRegradedReason;
import com.tianque.eventSource.domain.EventSource;
import com.tianque.eventSource.domain.EventSourceVo;
import com.tianque.eventSource.service.EventSourceService;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.exception.base.ServiceValidationException;
import com.tianque.issue.constants.IssueConstants;
import com.tianque.issue.constants.IssueEvaluationType;
import com.tianque.issue.constants.IssueTag;
import com.tianque.issue.constants.IssueTypes;
import com.tianque.issue.constants.IssueViewType;
import com.tianque.issue.controller.IssueOvertimeHelper;
import com.tianque.issue.dao.IssueDao;
import com.tianque.issue.dao.IssueLogDao;
import com.tianque.issue.dao.IssueProcessDao;
import com.tianque.issue.dao.TopIssueDao;
import com.tianque.issue.domain.CompletedIssue;
import com.tianque.issue.domain.IssueAccord;
import com.tianque.issue.domain.IssueAttachFile;
import com.tianque.issue.domain.IssueEvaluate;
import com.tianque.issue.domain.IssueLogNew;
import com.tianque.issue.domain.IssueMap;
import com.tianque.issue.domain.IssueNew;
import com.tianque.issue.domain.IssueRelatedPeople;
import com.tianque.issue.domain.IssueStep;
import com.tianque.issue.domain.TopIssue;
import com.tianque.issue.service.CompletedIssueService;
import com.tianque.issue.service.IssueAccessConfigService;
import com.tianque.issue.service.IssueEvaluateService;
import com.tianque.issue.service.IssueHistoryService;
import com.tianque.issue.service.IssueRelatedPeopleService;
import com.tianque.issue.service.IssueSerialNumberGenerator;
import com.tianque.issue.service.IssueService;
import com.tianque.issue.service.IssueWorkFlowEngine;
import com.tianque.issue.state.IssueOperate;
import com.tianque.issue.state.IssueState;
import com.tianque.issue.state.IssueStepGroup;
import com.tianque.issue.uitl.IssueMapUtil;
import com.tianque.issue.uitl.IssueToCMSUtil;
import com.tianque.issue.validator.IssueOperationLogValidator;
import com.tianque.issue.validator.IssueValidator;
import com.tianque.issue.vo.IssueViewObject;
import com.tianque.jms.OperateMode;
import com.tianque.openLayersMap.domian.vo.GisBoundVo;
import com.tianque.openLayersMap.util.GisTransformatUtil;
import com.tianque.plugin.tqSearch.sqlMap.DeleteSqlMap;
import com.tianque.plugin.tqSearch.sqlMap.UpdateSqlMap;
import com.tianque.service.EnterpriseService;
import com.tianque.service.HospitalService;
import com.tianque.service.IssueLogService;
import com.tianque.service.IssueTypeService;
import com.tianque.service.OtherLocaleService;
import com.tianque.service.RegradedPointService;
import com.tianque.service.SchoolService;
import com.tianque.state.RegradedType;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PermissionService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.tqSearch.common.SolrResultRelationalObject;
import com.tianque.tqSearch.common.TqSolrSearchCommonOperate;
import com.tianque.tqSearch.constant.TqSolrSearchOperateType;
import com.tianque.tqSearch.constant.TqSolrSearchType;
import com.tianque.tqSearch.convert.IssueSolrDocumentConvert;
import com.tianque.tqSearch.domain.IssueSearchSolrParams;
import com.tianque.tqSearch.domain.TqSolrDocumentList;
import com.tianque.tqSearch.dubboService.TqSearchDubboService;
import com.tianque.util.DateFormat;

@Transactional
public abstract class AbstractIssueServiceImpl extends AbstractBaseService
		implements IssueService {

	protected abstract IssueValidator getIssueValidator();

	protected abstract IssueOperationLogValidator getIssueLogValidator();

	protected abstract IssueSerialNumberGenerator getIssueSerialNumberGenerator();

	protected abstract IssueWorkFlowEngine getIssueWorkFlowEngine();

	// @Autowired
	// private IssueDao issueDao;
	@Autowired
	protected IssueDao issueDao;
	@Autowired
	private RentalHouseService rentalHouseService;
	@Autowired
	private RectificativePersonService rectificativePersonService;
	@Autowired
	private PositiveInfoService posiviteInfoService;
	@Autowired
	private MentalPatientService mentalPatientService;
	@Autowired
	private IdleYouthService idleYouthService;
	@Autowired
	private DruggyService druggyService;
	@Autowired
	private DangerousGoodsPractitionerService dangerousGoodsPractitionerService;
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private OtherLocaleService otherLocaleService;
	@Autowired
	private OtherAttentionPersonnelService otherAttentionPersonnelService;
	@Autowired
	private SuperiorVisitService superiorVisitService;
	@Autowired
	private IssueTypeService issueTypeService;
	@Autowired
	protected OrganizationDubboService organizationDubboService;
	@Autowired
	protected PropertyDictService propertyDictService;
	@Autowired
	protected IssueProcessDao issueProcessDao;

	@Autowired
	protected IssueLogDao issueLogDao;
	@Autowired
	private IssueLogService issueLogService;
	@Autowired
	protected TopIssueDao topIssueDao;
	@Autowired
	private ApprovalItemService approvalItemService;
	@Autowired
	private EventSourceService eventSourceService;
	@Autowired
	private InternetBarService internetBarService;
	@Autowired
	private PublicPlaceService publicPlaceServic;
	@Autowired
	private DangerousChemicalsUnitService dangerousChemicalsUnitService;
	@Autowired
	private IssueAccessConfigService issueAccessConfigService;
	@Autowired
	private RegradedPointService regradedPointService;
	@Autowired
	private IssueOvertimeHelper issueOvertimeHelper;
	@Autowired
	private IssueRelatedPeopleService issueRelatedPeopleService;
	@Autowired
	private ValidateHelper validateHelper;
	@Autowired
	private IssueEvaluateService issueEvaluateService;
	@Autowired
	private CompletedIssueService completedIssueService;
	private final static int PUBLICLTY = 1;// 设置为宣传案例
	private final static int CANCLE_PUBLICLTY = 0;// 取消宣传案例
	private final static Long NO_SEARCH_ORG = null;// 事件快速检索时候，未选择组织机构
	private final static int ORG_CODE_FIND_LEVEL = 0;// 事件快速检索时候，未选择组织机构
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private IssueHistoryService issueHistoryService;
	@Autowired
	private TqSearchDubboService tqSearchDubboService;
	@Autowired
	private TqSolrSearchCommonOperate tqSolrSearchCommonOperate;
	@Autowired
	private GlobalSettingService globalSettingService;
	private final static int MAX_SCREEN_DISPLAY = 200;// 大屏展示最大条数

	@Override
	public IssueNew getIssueBySerialNumber(String serialNumber) {

		if (!StringUtil.isStringAvaliable(serialNumber)) {

			return null;
		}
		return issueDao.getIssueBySerialNumber(serialNumber);
	}

	@Override
	public void validateDataForAddIssue(IssueNew issue,
			List<IssueAttachFile> files, String issueRelatedPeopleNames,
			String issueRelatedPeopleTelephones,
			String issueRelatedPeopleFixPhones) {
		validate(issue, files);
		validateNamesAndTelephones(issueRelatedPeopleNames,
				issueRelatedPeopleTelephones, issueRelatedPeopleFixPhones,
				issue);
	}

	@Override
	public IssueViewObject addIssue(IssueNew issue,
			List<IssueAttachFile> files, Map<String, String> map,
			String issueRelatedPeopleNames,
			String issueRelatedPeopleTelephones,
			String issueRelatedPeopleFixPhones) {
		validateDataForAddIssue(issue, files, issueRelatedPeopleNames,
				issueRelatedPeopleTelephones, issueRelatedPeopleFixPhones);
		issue.setSerialNumber(getIssueSerialNumberGenerator().nextValue(issue));
		try {
			loadAndAutoFillAllOrgInfo(issue);
			setCenterLonLat(issue);// 设置三维坐标
			IssueNew savedIssue = issueDao.addIssue(issue);
			IssueNew copyIssue = (IssueNew) BeanUtils.cloneBean(savedIssue);
			addIssueRelatedPeople(savedIssue, issueRelatedPeopleNames,
					issueRelatedPeopleTelephones, issueRelatedPeopleFixPhones);
			// 重点人员和重点场所
			if (map != null) {
				addEmphases(savedIssue.getId(), map, savedIssue);
			}
			fillIssueAttachFilesIssue(savedIssue, files);
			issueDao.addIssueAttachFiles(files);
			IssueStep step = getIssueWorkFlowEngine().register(savedIssue);
			if (Boolean.valueOf(globalSettingService
					.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
				tqSearchDubboService.addSolrIndex(IssueSolrDocumentConvert
						.createIssueSolrDocument(copyIssue, step));
			}
			return createIssueViewObject(savedIssue, step);
		} catch (Exception e) {
			throw new ServiceValidationException("新增事件失败！", e);
		}
	}

	private void setCenterLonLat(IssueNew issue) {
		if (StringUtil.isStringAvaliable(issue.getCenterLon())
				&& StringUtil.isStringAvaliable(issue.getCenterLat())) {
			GisBoundVo gisBoundVo = new GisBoundVo(issue.getCenterLon(),
					issue.getCenterLat(), issue.getGisType(),
					issue.getIsTransformat());
			GisTransformatUtil.autoFillGisBound(gisBoundVo);
			issue.setCenterLon(gisBoundVo.getLon());
			issue.setCenterLat(gisBoundVo.getLat());
			issue.setCenterLon2(gisBoundVo.getLon2());
			issue.setCenterLat2(gisBoundVo.getLat2());
		}
	}

	private void addEmphases(Long issueId, Map<String, String> map,
			IssueNew issueNew) {
		issueTypeService.deleteRelatePersons(issueId);
		issueTypeService.deleteRelatePlaces(issueId);
		for (int i = 0; i < map.size(); i++) {
			if (map.get("superiorVisit") != null
					&& !map.get("superiorVisit").equals("")) {
				String[] key = map.get("superiorVisit").split(",");
				for (int j = 0; j < key.length; j++) {
					SuperiorVisit superiorVisit = superiorVisitService
							.getSuperiorVisitById(Long.parseLong(key[j]));
					issueTypeService.addRelatePersons(issueId, "superiorVisit",
							superiorVisit.getId(), superiorVisit.getName());
				}
				map.remove("superiorVisit");
			}

			if (map.get("otherAttentionPersonnel") != null
					&& !map.get("otherAttentionPersonnel").equals("")) {
				String[] key = map.get("otherAttentionPersonnel").split(",");
				for (int j = 0; j < key.length; j++) {
					OtherAttentionPersonnel otherAttention = otherAttentionPersonnelService
							.getSimpleOtherAttentionPersonnelById(Long
									.parseLong(key[j]));
					issueTypeService.addRelatePersons(issueId,
							"otherAttentionPersonnel", otherAttention.getId(),
							otherAttention.getName());
				}
				map.remove("otherAttentionPersonnel");
			}

			if (map.get("rectificativePerson") != null
					&& !map.get("rectificativePerson").equals("")) {
				String[] key = map.get("rectificativePerson").split(",");
				for (int j = 0; j < key.length; j++) {
					RectificativePerson superiorVisit = rectificativePersonService
							.getRectificativePersonById(Long.parseLong(key[j]));
					issueTypeService.addRelatePersons(issueId,
							"rectificativePerson", superiorVisit.getId(),
							superiorVisit.getName());
				}
				map.remove("rectificativePerson");
			}

			if (map.get("positiveInfo") != null
					&& !map.get("positiveInfo").equals("")) {
				String[] key = map.get("positiveInfo").split(",");
				for (int j = 0; j < key.length; j++) {
					PositiveInfo superiorVisit = posiviteInfoService
							.getPositiveInfoById(Long.parseLong(key[j]));
					issueTypeService.addRelatePersons(issueId, "positiveInfo",
							superiorVisit.getId(), superiorVisit.getName());
				}
				map.remove("positiveInfo");
			}

			if (map.get("mentalPatient") != null
					&& !map.get("mentalPatient").equals("")) {
				String[] key = map.get("mentalPatient").split(",");
				for (int j = 0; j < key.length; j++) {
					MentalPatient mentalPatient = mentalPatientService
							.getMentalPatientById(Long.parseLong(key[j]));
					issueTypeService.addRelatePersons(issueId, "mentalPatient",
							mentalPatient.getId(), mentalPatient.getName());
				}
				map.remove("mentalPatient");
			}

			if (map.get("idleYouth") != null
					&& !map.get("idleYouth").equals("")) {
				String[] key = map.get("idleYouth").split(",");
				for (int j = 0; j < key.length; j++) {
					IdleYouth mentalPatient = idleYouthService
							.getIdleYouthById(Long.parseLong(key[j]));
					issueTypeService.addRelatePersons(issueId, "idleYouth",
							mentalPatient.getId(), mentalPatient.getName());
				}
				map.remove("idleYouth");
			}

			if (map.get("druggy") != null && !map.get("druggy").equals("")) {
				String[] key = map.get("druggy").split(",");
				for (int j = 0; j < key.length; j++) {
					Druggy mentalPatient = druggyService.getDruggyById(Long
							.parseLong(key[j]));
					issueTypeService.addRelatePersons(issueId, "druggy",
							mentalPatient.getId(), mentalPatient.getName());
				}
				map.remove("druggy");
			}

			if (map.get("dangerousGoodsPractitioner") != null
					&& !map.get("dangerousGoodsPractitioner").equals("")) {
				String[] key = map.get("dangerousGoodsPractitioner").split(",");
				for (int j = 0; j < key.length; j++) {
					DangerousGoodsPractitioner mentalPatient = dangerousGoodsPractitionerService
							.getSimpleDangerousGoodsPractitionerById(Long
									.parseLong(key[j]));
					issueTypeService.addRelatePersons(issueId,
							"dangerousGoodsPractitioner",
							mentalPatient.getId(), mentalPatient.getName());
				}
				map.remove("dangerousGoodsPractitioner");
			}

			if (map.get("RENTALHOUSE") != null
					&& !map.get("RENTALHOUSE").equals("")) {
				String[] key = map.get("RENTALHOUSE").split(",");
				for (int j = 0; j < key.length; j++) {
					RentalHouse mentalPatient = rentalHouseService
							.getHouseInfoById(Long.parseLong(key[j]));
					issueTypeService.addRelatePlaces(issueId, "RENTALHOUSE",
							mentalPatient.getId(),
							mentalPatient.getRentalPerson());
					issueNew.setOccurLocation(mentalPatient.getAddress());
					issueDao.updateIssue(issueNew);
				}
				map.remove("RENTALHOUSE");
			}

			updateMapWhenEnterpeise(map, issueId, issueNew,
					"SAFETYPRODUCTIONKEY");
			updateMapWhenEnterpeise(map, issueId, issueNew, "FIRESAFETYKEY");
			updateMapWhenEnterpeise(map, issueId, issueNew, "SECURITYKEY");
			updateMapWhenEnterpeise(map, issueId, issueNew, "ENTERPRISEKEY");

			if (map.get("SCHOOL") != null && !map.get("SCHOOL").equals("")) {
				String[] key = map.get("SCHOOL").split(",");
				for (int j = 0; j < key.length; j++) {
					School mentalPatient = schoolService.getSchoolById(Long
							.parseLong(key[j]));
					issueTypeService.addRelatePlaces(issueId, "SCHOOL",
							mentalPatient.getId(),
							mentalPatient.getChineseName());
					issueNew.setOccurLocation(mentalPatient.getAddress());
					issueDao.updateIssue(issueNew);
				}
				map.remove("SCHOOL");
			}

			if (map.get("HOSPITAL") != null && !map.get("HOSPITAL").equals("")) {
				String[] key = map.get("HOSPITAL").split(",");
				for (int j = 0; j < key.length; j++) {
					Hospital hospital = hospitalService.getHospitalById(Long
							.parseLong(key[j]));
					issueTypeService.addRelatePlaces(issueId, "HOSPITAL",
							hospital.getId(), hospital.getHospitalName());
					issueNew.setOccurLocation(hospital.getAddress());
					issueDao.updateIssue(issueNew);
				}
				map.remove("HOSPITAL");
			}

			if (map.get("OTHERLOCALES") != null
					&& !map.get("OTHERLOCALES").equals("")) {
				String[] key = map.get("OTHERLOCALES").split(",");
				for (int j = 0; j < key.length; j++) {
					OtherLocale mentalPatient = otherLocaleService
							.getOtherLocaleById(Long.parseLong(key[j]));
					issueTypeService.addRelatePlaces(issueId, "OTHERLOCALES",
							mentalPatient.getId(), mentalPatient.getName());
					issueNew.setOccurLocation(mentalPatient.getAddress());
					issueDao.updateIssue(issueNew);
				}
				map.remove("OTHERLOCALES");
			}

			if (map.get("INTERNETBAR") != null
					&& !map.get("INTERNETBAR").equals("")) {
				String[] key = map.get("INTERNETBAR").split(",");
				for (int j = 0; j < key.length; j++) {
					InternetBar mentalPatient = internetBarService
							.getInternetBarById(Long.parseLong(key[j]));
					issueTypeService
							.addRelatePlaces(issueId, "INTERNETBAR",
									mentalPatient.getId(),
									mentalPatient.getPlaceName());
					issueNew.setOccurLocation(mentalPatient.getPlaceAddress());
					issueDao.updateIssue(issueNew);
				}
				map.remove("INTERNETBAR");
			}

			if (map.get("PUBLICPLACE") != null
					&& !map.get("PUBLICPLACE").equals("")) {
				String[] key = map.get("PUBLICPLACE").split(",");
				for (int j = 0; j < key.length; j++) {
					PublicPlace mentalPatient = publicPlaceServic
							.getPlaceById(Long.parseLong(key[j]));
					issueTypeService
							.addRelatePlaces(issueId, "PUBLICPLACE",
									mentalPatient.getId(),
									mentalPatient.getPlaceName());
					issueNew.setOccurLocation(mentalPatient.getPlaceAddress());
					issueDao.updateIssue(issueNew);
				}
				map.remove("PUBLICPLACE");
			}

			if (map.get("DANGEROUSCHEMICALSUNIT") != null
					&& !map.get("DANGEROUSCHEMICALSUNIT").equals("")) {
				String[] key = map.get("DANGEROUSCHEMICALSUNIT").split(",");
				for (int j = 0; j < key.length; j++) {
					DangerousChemicalsUnit mentalPatient = dangerousChemicalsUnitService
							.getDangerousChemicalsUnitById(Long
									.parseLong(key[j]));
					issueTypeService.addRelatePlaces(issueId,
							"DANGEROUSCHEMICALSUNIT", mentalPatient.getId(),
							mentalPatient.getUnitName());
					issueNew.setOccurLocation(mentalPatient.getUnitAddress());
					issueDao.updateIssue(issueNew);
				}
				map.remove("DANGEROUSCHEMICALSUNIT");
			}
		}
	}

	private void updateMapWhenEnterpeise(Map<String, String> map, Long issueId,
			IssueNew issueNew, String enerpriseKey) {
		if (map.get(enerpriseKey) != null && !map.get(enerpriseKey).equals("")) {
			String[] key = map.get(enerpriseKey).split(",");
			for (int j = 0; j < key.length; j++) {
				Enterprise mentalPatient = enterpriseService
						.getEnterpriseById(Long.parseLong(key[j]));
				issueTypeService.addRelatePlaces(issueId, enerpriseKey,
						mentalPatient.getId(), mentalPatient.getName());
				issueNew.setOccurLocation(mentalPatient.getAddress());
				issueDao.updateIssue(issueNew);
			}
			map.remove(enerpriseKey);
		}
	}

	private void fillIssueAttachFilesIssueAndIssueLog(IssueLogNew issueLog,
			List<IssueAttachFile> files) {
		if (files != null && !files.isEmpty()) {
			for (IssueAttachFile issueAttachFile : files) {
				issueAttachFile.setIssue(issueLog.getIssue());
				issueAttachFile.setIssueLog(issueLog);
			}
		}
	}

	private void fillIssueAttachFilesIssue(IssueNew issue,
			List<IssueAttachFile> files) {
		if (files != null && !files.isEmpty()) {
			for (IssueAttachFile issueAttachFile : files) {
				issueAttachFile.setIssue(issue);
			}
		}
	}

	@Override
	@SolrServerIndex(mode = OperateMode.EDIT, value = UpdateSqlMap.ISSUE_KEY)
	public IssueViewObject updateIssue(IssueNew issue,
			List<IssueAttachFile> files, long stepId, Map<String, String> map,
			String issueRelatedPeopleNames,
			String issueRelatedPeopleTelephones,
			String issueRelatedPeoplefixPhones) {
		validate(issue, files);
		setCenterLonLat(issue);// 设置三维坐标
		validateNamesAndTelephones(issueRelatedPeopleNames,
				issueRelatedPeopleTelephones, issueRelatedPeoplefixPhones,
				issue);
		loadAndAutoFillAllOrgInfo(issue);
		IssueNew postIssue = issueDao.updateIssue(issue);
		issueRelatedPeopleService.deleteIssueRelatedPeopleByIssueId(postIssue
				.getId());// 先删除相关人员信息
		addIssueRelatedPeople(postIssue, issueRelatedPeopleNames,
				issueRelatedPeopleTelephones, issueRelatedPeoplefixPhones);// 添加相关人员
		IssueNew existIssue = issueDao.getFullIssueById(issue.getId());
		updateAttachFiles(postIssue, existIssue, files);
		IssueStep step = issueProcessDao.getSimpleIssueStepById(stepId);
		IssueViewObject issueViewObject = createIssueViewObject(postIssue, step);
		addEmphases(postIssue.getId(), map, postIssue);
		if (Boolean.valueOf(globalSettingService
				.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
			List<IssueStep> issueSteps = issueProcessDao
					.findIssueStepsByIssueId(postIssue.getId());
			if (issueSteps != null && issueSteps.size() > 0) {
				for (IssueStep issueStep : issueSteps) {
					tqSolrSearchCommonOperate.commonOperate(
							IssueSolrDocumentConvert.createIssueSolrDocument(
									postIssue, issueStep),
							TqSolrSearchOperateType.ADD_OR_UPDATE);
				}
			}
		}
		return issueViewObject;
	}

	@Override
	public IssueLogNew updateIssueLog(IssueLogNew issueLog,
			List<IssueAttachFile> files) {
		IssueLogNew postIssueLog = issueLogDao.updateLog(issueLog);
		updateAttachFilesLog(postIssueLog, files);
		return postIssueLog;
	}

	private void updateAttachFilesLog(IssueLogNew issueLog,
			List<IssueAttachFile> postFiles) {

		List<IssueAttachFile> existAttachFiles = issueDao
				.loadIssueAttachFilesByIssueAndLog(issueLog.getIssue().getId(),
						issueLog.getId());
		// 修改事件的时候没有上传附件
		if (postFiles == null || postFiles.isEmpty()) {
			// 该事件本来就没有附件
			if (existAttachFiles == null || existAttachFiles.isEmpty()) {
				return;
			} else {
				// 如果有附件则删除附件
				for (IssueAttachFile issueAttachFile : existAttachFiles) {
					issueDao.deleteAttachFileByAttachfilesId(issueAttachFile
							.getId());
					deleteFile(issueAttachFile.getFileActualUrl());
				}
			}
		} else {
			if (existAttachFiles == null || existAttachFiles.isEmpty()) {
				fillIssueAttachFilesIssueAndIssueLog(issueLog, postFiles);
				issueDao.addIssueAttachFiles(postFiles);
			} else {
				List<IssueAttachFile> addFile = new ArrayList<IssueAttachFile>();
				List<IssueAttachFile> saveFile = new ArrayList<IssueAttachFile>();
				for (IssueAttachFile file : postFiles) {
					if (file.getId() == null) {
						addFile.add(file);
					} else {
						saveFile.add(file);
					}
				}
				fillIssueAttachFilesIssueAndIssueLog(issueLog, addFile);
				issueDao.addIssueAttachFiles(addFile);
				existAttachFiles.removeAll(saveFile);
				for (IssueAttachFile file : existAttachFiles) {
					issueDao.deleteAttachFileByAttachfilesId(file.getId());
					deleteFile(file.getFileActualUrl());
				}
			}
		}

	}

	@Override
	public void addIssueAttachFiles(IssueNew postIssue, IssueNew existIssue,
			List<IssueAttachFile> files) {
		updateAttachFiles(postIssue, existIssue, files);

	}

	@Override
	public List<IssueAttachFile> getIssueEvaluateAttachFileAttachFileByIssueId(
			Long issueId) {
		if (null == issueId) {
			throw new BusinessValidationException("参数错误");
		}
		return issueDao.getIssueEvaluateAttachFileAttachFileByIssueId(issueId);
	}

	@Override
	public void addIssueEvaluateAttachFile(IssueEvaluate issueEvaluate,
			List<IssueAttachFile> files) {
		fillIssueAttachFilesIssue(issueEvaluate.getIssue(), files);
		List<IssueAttachFile> existAttachFiles = issueDao
				.getIssueEvaluateAttachFileAttachFileByIssueId(issueEvaluate
						.getIssue().getId());
		for (IssueAttachFile issueAttachFile : existAttachFiles) {
			if (null != issueAttachFile.getId())
				issueDao.deleteAttachFileByAttachfilesId(issueAttachFile
						.getId());
		}
		issueDao.addIssueEvaluateAttachFiles(files);
	}

	private void updateAttachFiles(IssueNew postIssue, IssueNew existIssue,
			List<IssueAttachFile> postFiles) {

		List<IssueAttachFile> existAttachFiles = issueDao
				.getIssueAttachFileAndNotLogAttachFileByIssueId(existIssue
						.getId());
		// 修改事件的时候没有上传附件
		if (postFiles == null || postFiles.isEmpty()) {
			// 该事件本来就没有附件
			if (existAttachFiles == null || existAttachFiles.isEmpty()) {
				return;
			} else {
				// 如果有附件则删除附件
				for (IssueAttachFile issueAttachFile : existAttachFiles) {
					issueDao.deleteAttachFileByAttachfilesId(issueAttachFile
							.getId());
					deleteFile(issueAttachFile.getFileActualUrl());
				}
			}
		} else {
			if (existAttachFiles == null || existAttachFiles.isEmpty()) {
				fillIssueAttachFilesIssue(postIssue, postFiles);
				issueDao.addIssueAttachFiles(postFiles);
			} else {
				List<IssueAttachFile> addFile = new ArrayList<IssueAttachFile>();
				List<IssueAttachFile> saveFile = new ArrayList<IssueAttachFile>();
				for (IssueAttachFile file : postFiles) {
					if (file.getId() == null) {
						addFile.add(file);
					} else {
						saveFile.add(file);
					}
				}
				fillIssueAttachFilesIssue(postIssue, addFile);
				issueDao.addIssueAttachFiles(addFile);
				existAttachFiles.removeAll(saveFile);
				for (IssueAttachFile file : existAttachFiles) {
					issueDao.deleteAttachFileByAttachfilesId(file.getId());
					deleteFile(file.getFileActualUrl());
				}
			}
		}

	}

	/** 物理删除文件 */
	private void deleteFile(String filePath) {
		filePath = FileUtil.getWebRoot() + File.separator + filePath;
		File file = new File(filePath);
		if (file.isFile() && file.exists()) {
			try {
				file.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 修改事件类型 对IssueType进行更新 更新方法是才用交集原则 就是保持两个集合的交集不变 在交集之外的删除旧的，增加新的
	 * 
	 * @param existIssue旧集合
	 * @param postIssue
	 *            新集合
	 */
	// private void updateIssueTypes(IssueNew existIssue, IssueNew postIssue) {
	// handleExistIssueTypes(existIssue.getId(), existIssue.getIssueTypes(),
	// postIssue.getIssueTypes());
	// handlePostIssueTypes(existIssue.getId(), existIssue.getIssueTypes(),
	// postIssue.getIssueTypes());
	// }

	/**
	 * ***删除旧集合 处理旧的集合只有删除
	 * 
	 * @param id
	 * @param existIssueTypes
	 *            存在的
	 * @param postIisueTypes
	 *            要添加的
	 */
	// private void handlePostIssueTypes(Long issueId,
	// List<IssueType> existIssueTypes, List<IssueType> postIssueTypes) {
	// // 如果旧的集合不存在，则没有可删除的
	// if (existIssueTypes == null || existIssueTypes.size() == 0) {
	// return;
	// }
	// // 如果新的集合不存在，则所有旧的集合全部删掉
	// if (postIssueTypes == null || postIssueTypes.size() == 0) {
	// issueDao.deleteIssueHasTypesByIssueId(issueId);
	// } else {
	// // 如果existIssueTypes不包含要保存的，那么删除
	// for (IssueType existIssueType : existIssueTypes) {
	// if (!postIssueTypes.contains(existIssueType)) {
	// issueDao.deleteIssueHasTypesByIssueIdAndIssueTypeId(
	// issueId, existIssueType.getId());
	// }
	// }
	// }
	// }

	/**
	 * 新增新集合 处理新的集合只有增加
	 * 
	 * @param id
	 * @param existIssueTypes
	 *            存在的
	 * @param postIisueTypes
	 *            要添加的
	 */
	private void handleExistIssueTypes(Long issueId,
			List<IssueType> existIssueTypes, List<IssueType> postIssueTypes) {
		// 如果新的集合不存在，则没有可增加的
		if (postIssueTypes == null || postIssueTypes.size() == 0) {
			return;
		}
		// 如果旧的集合不存在，则所有的新的需要增加
		if (existIssueTypes == null || existIssueTypes.size() == 0) {
			for (IssueType postIssueType : postIssueTypes) {
				issueDao.addIssueHasTypes(issueId, postIssueType.getId(),
						postIssueType.getIssueTypeDomain().getId());
			}
		} else {
			for (IssueType postIssueType : postIssueTypes) {
				if (!existIssueTypes.contains(postIssueType)) {
					issueDao.addIssueHasTypes(issueId, postIssueType.getId(),
							postIssueType.getIssueTypeDomain().getId());
				}
			}
		}

	}

	@Override
	@SolrServerIndex(mode = OperateMode.DELETE, value = DeleteSqlMap.ISSUES_KEY)
	public boolean deleteIssueByIssueId(Long issueId) {
		List<IssueStep> issueSteps = issueProcessDao
				.findIssueStepsByIssueId(issueId);// 查询所有的step，给solr删除
		IssueNew issue = getFullIssueByIssueId(issueId);
		approvalItemService.deleteApprovalItemByApprovalNumber(issue
				.getSerialNumber());
		removeIssueAllAttachFiles(issueId);
		removeIssueFromPublilty(issueId);
		// issueDao.deleteIssueHasTypesByIssueId(issueId);
		issueLogDao.deleteIssueLogByIssueId(issueId);
		getIssueWorkFlowEngine().unRegister(issueId);
		issueTypeService.deleteRelatePersons(issueId);
		issueTypeService.deleteRelatePlaces(issueId);
		issueDao.deleteIssueById(issueId);
		topIssueDao.deleteTopIssue(issueId, ThreadVariable.getOrganization()
				.getId(), IssueTag.NEEDDO_ISSUE);
		issueRelatedPeopleService.deleteIssueRelatedPeopleByIssueId(issueId);// 删除相关人员信息
		CompletedIssue completedIssue = completedIssueService
				.getCompletedByIssueId(issueId);// 删除事件操作时，判断是否是已办结中的操作
		if (completedIssue != null && completedIssue.getIssueId() != null) {
			return completedIssueService.removeCompletedIssueByIssueId(issueId);
		}
		if (Boolean.valueOf(globalSettingService
				.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
			List<String> solrIds = new ArrayList<String>();
			if (issueSteps != null && issueSteps.size() > 0) {
				for (IssueStep issueStep : issueSteps) {
					solrIds.add(TqSolrSearchType.ISSUE_TYPE + "_"
							+ issueStep.getId());
				}
			}
			tqSearchDubboService.deleteSolrIndexById(solrIds,
					TqSolrSearchType.ISSUE_TYPE);
		}
		return true;
	}

	@Override
	public boolean topIssue(TopIssue topIssue) {
		TopIssue ti = topIssueDao.getTopIssue(topIssue);
		if (ti == null) {
			topIssue.setTopState(TopIssue.TOP);
			topIssue.setTopDate(CalendarUtil.now("yyyy-MM-dd HH:mm:ss"));
			TopIssue te = topIssueDao.addTopIssue(topIssue);
			if (topIssue.getIssueTag() == IssueTag.COMPLETED_ISSUE
					|| topIssue.getIssueTag() == IssueTag.CHECKGRADE_ISSUE) {
				boolean flag = completedIssueService.topIssue(topIssue, 1);
				return te != null && flag;
			}
			return te != null;
		} else {
			boolean flag = topIssueDao.deleteTopIssueById(ti.getId());
			if (flag
					&& (topIssue.getIssueTag() == IssueTag.COMPLETED_ISSUE || topIssue
							.getIssueTag() == IssueTag.CHECKGRADE_ISSUE)) {
				flag = completedIssueService.topIssue(topIssue, 0);
			}
			return flag;
		}
	}

	@Override
	public IssueViewObject publiclty(Long issueId) {
		IssueNew issue = getFullIssueByIssueId(issueId);
		List<IssueStep> issueSteps = null;
		Organization org = organizationDubboService
				.getSimpleOrgById(ThreadVariable.getUser().getOrganization()
						.getId());
		if (!alreadyPubliclty(org, issue)) {
			if(issue.getHistoryIssue()){
				issueDao.publicltyHistory(issue.getId(), CANCLE_PUBLICLTY);
				issueSteps = issueProcessDao
						.findIssueStepsHistoryByIssueId(issueId);
			}else{
				issueDao.publiclty(issue.getId(), CANCLE_PUBLICLTY);
				issueSteps = issueProcessDao
						.findIssueStepsByIssueId(issueId);
			}
			// topIssueDao.deleteTopIssue(issueId, org.getId(),
			// IssueTag.DONE_ISSUE);
			// 已办结事件表，修改宣传案例的字段值
			completedIssueService.publicltycassIssue(issueId, PUBLICLTY);
		}
		// 设置宣传案例更新修改时间暂时注释掉
		// issueDao.updateTableUpdateDateById(issue.getId());
		
		IssueEvaluate issueEvaluate = issueEvaluateService
				.getIssueEvaluateByIssueId(issueId);
		if (issueSteps != null && issueSteps.size() > 0) {
			for (IssueStep issueStep : issueSteps) {
				org = organizationDubboService.getSimpleOrgById(issueStep.getSource().getId());
				issueStep.setSource(org);
				tqSolrSearchCommonOperate.commonOperate(
						IssueSolrDocumentConvert
								.createIssueSolrDocumentForPubliclty(issue,
										issueStep, PUBLICLTY,issueEvaluate),
						TqSolrSearchOperateType.ADD_OR_UPDATE);
			}
		}
		return createIssueViewObject(issue);
	}

	@Override
	public IssueViewObject cancelPubliclty(Long issueId) {
		IssueNew issue = getFullIssueByIssueId(issueId);
		List<IssueStep> issueSteps = null;
		if(issue.getHistoryIssue()){
			issueDao.publicltyHistory(issue.getId(), CANCLE_PUBLICLTY);
			issueSteps = issueProcessDao
					.findIssueStepsHistoryByIssueId(issueId);
		}else{
			issueDao.publiclty(issue.getId(), CANCLE_PUBLICLTY);
			issueSteps = issueProcessDao
					.findIssueStepsByIssueId(issueId);
		}
		// issueDao.removePublicltyByIssueId(issue.getId());
		// topIssueDao.deleteTopIssue(issueId, org.getId(),
		// IssueTag.PUBLICLTYCASS_ISSUE);
		// 已办结事件表，修改宣传案例的字段值
		completedIssueService.publicltycassIssue(issueId, CANCLE_PUBLICLTY);
		// 取消设置宣传案例更新修改时间暂时注释掉
		// issueDao.updateTableUpdateDateById(issue.getId());
		
		IssueEvaluate issueEvaluate = issueEvaluateService
				.getIssueEvaluateByIssueId(issueId);
		if (issueSteps != null && issueSteps.size() > 0) {
			for (IssueStep issueStep : issueSteps) {
				Organization org = organizationDubboService.getSimpleOrgById(issueStep.getSource().getId());
				issueStep.setSource(org);
				tqSolrSearchCommonOperate.commonOperate(
						IssueSolrDocumentConvert
								.createIssueSolrDocumentForPubliclty(issue,
										issueStep, CANCLE_PUBLICLTY,issueEvaluate),
						TqSolrSearchOperateType.ADD_OR_UPDATE);
			}
		}
		return createIssueViewObject(issue);
	}

	@Override
	public IssueViewObject reportToCommandCenter(Long stepId, IssueLogNew log) {
		autoFillIssueLogProperty(log, IssueOperate.REPORT_TO);
		validateOperationLog(IssueOperate.REPORT_TO, log, null);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		IssueStep newStep = getIssueWorkFlowEngine().reportTo(issue, step, log);
		issue = getFullIssueByStepId(stepId);
		return createIssueViewObject(issue, newStep);
	}

	@Override
	public IssueViewObject complete(Long stepId, IssueLogNew log,
			List<IssueAttachFile> attachFiles) {
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		Organization dealOrg = log.getDealOrg();
		autoFillIssueLogProperty(log, IssueOperate.COMPLETE);
		validateOperationLog(IssueOperate.COMPLETE, log, attachFiles);
		IssueNew issue = getFullIssueByStepId(stepId);
		if (StringUtil.isStringAvaliable(issue.getFromSerialNumber())) {
			log.setDealOrg(dealOrg);
			log.setReport12345(true);
		}
		IssueStep newStep = getIssueWorkFlowEngine().complete(issue, step, log,
				attachFiles);
		issue = getFullIssueByStepId(stepId);
		List<IssueStep> issueSteps = issueProcessDao.findIssueStepsByIssueId(issue.getId());
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
		if (StringUtil.isStringAvaliable(issue.getFromSerialNumber())) {
			IssueToCMSUtil.post(GridProperties.CMS_CALLCENTER_ISSUE_COMPLETE
					+ "?demandsCode=" + issue.getFromSerialNumber());
		}
		return createIssueViewObject(issue, newStep);
	}

	@Override
	public IssueViewObject verification(Long stepId, IssueLogNew log,
			List<IssueAttachFile> attachFiles, int isChangeIntoThreeRecords) {
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		Organization dealOrg = log.getDealOrg();
		autoFillIssueLogProperty(log, IssueOperate.VERIFICATION);
		validateOperationLog(IssueOperate.VERIFICATION, log, attachFiles);
		IssueNew issue = getFullIssueByStepId(stepId);
		issue.setIsChangeIntoThreeRecords(isChangeIntoThreeRecords);
		if (StringUtil.isStringAvaliable(issue.getFromSerialNumber())) {
			log.setDealOrg(dealOrg);
			log.setReport12345(true);
		}
		IssueStep newStep = getIssueWorkFlowEngine().verification(issue, step,
				log, attachFiles);
		issue = getFullIssueByStepId(stepId);
		// if (issue.isIssueType()) {
		// approvalItemService.verification(issue.getSerialNumber());
		// }
		return createIssueViewObject(issue, newStep);
	}

	@Override
	public IssueViewObject submit(Long stepId, IssueLogNew log,
			Long submitTarget, Long[] tells, List<IssueAttachFile> attachFiles) {
		autoFillIssueLogProperty(log, IssueOperate.SUBMIT);
		validateOperationLog(IssueOperate.SUBMIT, log, attachFiles);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		IssueStep newStep = getIssueWorkFlowEngine().submit(issue, step, log,
				submitTarget, tells, attachFiles);
		issue = getFullIssueByStepId(stepId);
		if (log.isReport12345()) {
			// 事件上报12345,在座席的诉求列表里插入来源为网格员的数据
			String demandCode = report12345(issue, newStep.getTarget().getId(),
					newStep.getId());
			if (demandCode.equals("null")) {
				throw new BusinessValidationException("上报12345失败!");
			}
			issueDao.updateIssueFromSerialNumber(issue.getId(), demandCode);
			MultipartEntity data = newStep.getMultipartEntityData();
			if (data != null) {
				try {
					data.addPart("demandsCode", new StringBody(demandCode,
							Charset.forName("UTF-8")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			IssueToCMSUtil.post(
					GridProperties.CMS_CALLCENTER_ISSUE_TRANSACTION_LOG, data);
		}
		return createIssueViewObject(issue, newStep);
	}

	@Override
	public IssueViewObject giveTo(Long stepId, IssueLogNew log, Long target,
			Long[] tells, List<IssueAttachFile> files) {
		autoFillIssueLogProperty(log, IssueOperate.GIVETO);
		validateOperationLog(IssueOperate.GIVETO, log, files);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		IssueStep newStep = getIssueWorkFlowEngine().giveTo(issue, step, log,
				target, tells, files);
		issue = getFullIssueByStepId(stepId);
		return createIssueViewObject(issue, newStep);
	}

	@Override
	public IssueViewObject assign(Long stepId, IssueLogNew log, Long targetOrg,
			Long[] tells, List<IssueAttachFile> attachFiles) {
		if (log.isReport12345()) {
			log.setDealType(Long.valueOf(IssueOperate.ASSIGN.getCode()));
			log.setDealTime(CalendarUtil.now());
		} else {
			autoFillIssueLogProperty(log, IssueOperate.ASSIGN);
		}
		validateOperationLog(IssueOperate.ASSIGN, log, attachFiles);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		if (null != log.getIssueStep()) {
			step.setItemTypeId(log.getIssueStep().getItemTypeId());
		}
		IssueStep newStep = getIssueWorkFlowEngine().assign(issue, step, log,
				targetOrg, tells, attachFiles);
		issue = getFullIssueByStepId(stepId);
		// IssueToCMSUtil.post("事件交办完毕", null);
		return createIssueViewObject(issue, newStep);
	}

	@Override
	public IssueViewObject concept(Long stepId, IssueLogNew log) {
		autoFillIssueLogProperty(log, IssueOperate.CONCEPT);
		validateOperationLog(IssueOperate.CONCEPT, log, null);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		IssueStep newStep = getIssueWorkFlowEngine().concept(issue, step, log);
		issue = getFullIssueByStepId(stepId);
		if (StringUtil.isStringAvaliable(issue.getFromSerialNumber())) {
			IssueToCMSUtil.post(GridProperties.CMS_CALLCENTER_ISSUE_CONCEPT
					+ "?demandsCode=" + issue.getFromSerialNumber());
		}
		return createIssueViewObject(issue, newStep);
	}

	@Override
	public IssueViewObject read(Long stepId, IssueLogNew log) {
		autoFillIssueLogProperty(log, IssueOperate.READ);
		validateOperationLog(IssueOperate.READ, log, null);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		IssueStep newStep = getIssueWorkFlowEngine().read(issue, step, log);
		issue = getFullIssueByStepId(stepId);
		// IssueToCMSUtil.post("事件阅读完毕", null);
		return createIssueViewObject(issue, newStep);
	}

	@Override
	public IssueViewObject comment(Long stepId, IssueLogNew log,
			List<IssueAttachFile> attachFiles) {
		autoFillIssueLogProperty(log, IssueOperate.COMMENT);
		validateOperationLog(IssueOperate.COMMENT, log, attachFiles);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		IssueStep newStep = getIssueWorkFlowEngine().comment(issue, step, log,
				attachFiles);
		issue = getFullIssueByStepId(stepId);
		// IssueToCMSUtil.post("事件办理中", null);
		return createIssueViewObject(issue, newStep);
	}

	@Override
	public IssueViewObject back(Long stepId, IssueLogNew log,
			List<IssueAttachFile> attachFiles) {
		Organization dealOrg = log.getDealOrg();
		autoFillIssueLogProperty(log, IssueOperate.BACK);
		validateOperationLog(IssueOperate.BACK, log, attachFiles);
		IssueNew issue = getFullIssueByStepId(stepId);
		if (StringUtil.isStringAvaliable(issue.getFromSerialNumber())) {
			log.setDealOrg(dealOrg);
			log.setReport12345(true);
		}
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		IssueStep newStep = getIssueWorkFlowEngine().back(issue, step, log,
				attachFiles);
		issue = getFullIssueByStepId(stepId);
		PropertyDict sourceKind = propertyDictService
				.findPropertyDictByDomainNameAndDictDisplayName(
						PropertyTypes.SOURCE_KIND,
						IssueConstants.CALLCENTER_INPUT);
		if (!sourceKind.getId().equals(issue.getSourceKind().getId())) {
			issueDao.updateIssueFromSerialNumber(issue.getId(), null);
		}
		return createIssueViewObject(issue, newStep);
	}

	@Override
	public IssueViewObject cancelHistoric(Long stepId, IssueLogNew log) {
		autoFillIssueLogProperty(log, IssueOperate.CANCEL_HISTORIC);
		validateOperationLog(IssueOperate.CANCEL_HISTORIC, log, null);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueStepById(stepId);
		issueDao.updateIssueHistoricState(issue.getId(), Boolean.FALSE);
		getIssueWorkFlowEngine().fireIssueChanged(issue, step,
				IssueOperate.CANCEL_HISTORIC, log,
				new ArrayList<IssueAttachFile>());
		return createIssueViewObject(getFullIssueByStepId(stepId),
				getIssueWorkFlowEngine().getFullIssueStepById(stepId));
	}

	@Override
	public IssueViewObject cancelSupervise(Long stepId, IssueLogNew log) {
		autoFillIssueLogProperty(log, IssueOperate.CANCEL_SUPERVISE);
		validateOperationLog(IssueOperate.CANCEL_SUPERVISE, log, null);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		step = getIssueWorkFlowEngine().cancelSupervise(issue, step, log);
		// IssueToCMSUtil.post("事件取消督办", null);
		tqSolrSearchCommonOperate.commonOperate(
				IssueSolrDocumentConvert.createIssueSolrDocument(issue, step),
				TqSolrSearchOperateType.ADD_OR_UPDATE);
		return createIssueViewObject(issue, step);
	}

	@Override
	public IssueViewObject cancelUrgent(Long stepId, IssueLogNew log) {
		autoFillIssueLogProperty(log, IssueOperate.CANCEL_URGENT);
		validateOperationLog(IssueOperate.CANCEL_URGENT, log, null);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueStepById(stepId);
		getIssueWorkFlowEngine().fireIssueChanged(issue, step,
				IssueOperate.CANCEL_URGENT, log,
				new ArrayList<IssueAttachFile>());
		issueDao.updateIssueUrgentState(issue.getId(), Boolean.FALSE);
		// IssueToCMSUtil.post("事件取消加急", null);
		issue = getFullIssueByStepId(stepId);
		tqSolrSearchCommonOperate.commonOperate(
				IssueSolrDocumentConvert.createIssueSolrDocument(issue, step),
				TqSolrSearchOperateType.ADD_OR_UPDATE);
		return createIssueViewObject(issue, getIssueWorkFlowEngine()
				.getFullIssueStepById(stepId));
	}

	@Override
	public IssueViewObject historic(Long stepId, IssueLogNew log) {
		autoFillIssueLogProperty(log, IssueOperate.HISTORIC);
		validateOperationLog(IssueOperate.HISTORIC, log, null);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueStepById(stepId);
		issueDao.updateIssueHistoricState(issue.getId(), Boolean.TRUE);
		getIssueWorkFlowEngine().fireIssueChanged(issue, step,
				IssueOperate.HISTORIC, log, new ArrayList<IssueAttachFile>());
		return createIssueViewObject(getFullIssueByStepId(stepId),
				getIssueWorkFlowEngine().getFullIssueStepById(stepId));
	}

	@Override
	public IssueViewObject instruct(Long stepId, IssueLogNew log) {
		autoFillIssueLogProperty(log, IssueOperate.INSTRUCT);
		validateOperationLog(IssueOperate.INSTRUCT, log, null);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		getIssueWorkFlowEngine().instruct(issue, step, log);
		// IssueToCMSUtil.post("事件领导批示", null);
		return createIssueViewObject(issue, step);
	}

	@Override
	public IssueViewObject supervise(IssueOperate superviseLevel, Long stepId,
			IssueLogNew log) {
		autoFillIssueLogProperty(log, superviseLevel);
		validateOperationLog(superviseLevel, log, null);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueWorkFlowEngine().getFullIssueStepById(stepId);
		step = getIssueWorkFlowEngine().supervise(issue, step, log,
				superviseLevel);
		double cent = issueAccessConfigService
				.getIssueScoresConfig(superviseLevel);
		deductStatRegradedPoint(superviseLevel, issue, cent, step.getTarget()
				.getId());
		// IssueToCMSUtil.post("事件督办", null);
		tqSolrSearchCommonOperate.commonOperate(
				IssueSolrDocumentConvert.createIssueSolrDocument(issue, step),
				TqSolrSearchOperateType.ADD_OR_UPDATE);
		return createIssueViewObject(issue, step);
	}

	private RegradedPoints deductStatRegradedPoint(IssueOperate superviseLevel,
			IssueNew issue, Double cent, Long orgId) {
		RegradedPoints regradedPoints = null;
		try {
			Organization org = organizationDubboService.getSimpleOrgById(orgId);
			WorkContacterRegradedReason regradedReason = new WorkContacterRegradedReason();
			regradedReason.setContent("服务单号：" + issue.getSerialNumber()
					+ ",主题:" + issue.getSubject() + ",原因:"
					+ superviseLevel.getDesc());
			regradedReason.setIssueSerialNumber(issue.getSerialNumber());
			String type = RegradedType.REGRADEDBYPERSON;
			if (superviseLevel.getCode() == IssueOperate.YELLOW_SUPERVISE_CODE) {
				type = RegradedType.YELLOWCARD;
			} else if (superviseLevel.getCode() == IssueOperate.RED_SUPERVISE_CODE) {
				type = RegradedType.REDCARD;
			} else if (superviseLevel.getCode() == IssueOperate.NORMAL_SUPERVISE_CODE) {
				type = RegradedType.NORMALCARD;
			}

			regradedPoints = regradedPointService.deductPoints(org, type,
					regradedReason, cent,
					CalendarUtil.now("yyyy-MM-dd HH:mm:ss"),
					getLastIssueLogId(issue.getId()));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return regradedPoints;
	}

	private Long getLastIssueLogId(Long id) {
		List<IssueLogNew> issueLogs = issueLogService
				.findIssueLogsByIssueId(id);
		IssueLogNew issueLog = issueLogs.get(issueLogs.size() - 1);
		return issueLog == null ? null : issueLog.getId();
	}

	@Override
	public IssueViewObject urgent(Long stepId, IssueLogNew log) {
		autoFillIssueLogProperty(log, IssueOperate.URGENT);
		validateOperationLog(IssueOperate.URGENT, log, null);
		IssueNew issue = getFullIssueByStepId(stepId);
		IssueStep step = getIssueStepById(stepId);
		getIssueWorkFlowEngine().fireIssueChanged(issue, step,
				IssueOperate.URGENT, log, new ArrayList<IssueAttachFile>());
		issueDao.updateIssueUrgentState(issue.getId(), Boolean.TRUE);
		// IssueToCMSUtil.post("事件加急", null);
		issue = getFullIssueByStepId(stepId);
		tqSolrSearchCommonOperate.commonOperate(
				IssueSolrDocumentConvert.createIssueSolrDocument(issue, step),
				TqSolrSearchOperateType.ADD_OR_UPDATE);
		return createIssueViewObject(issue, getIssueWorkFlowEngine()
				.getFullIssueStepById(stepId));
	}

	@Override
	public PageInfo<IssueViewObject> findMyNeedDoIssues(Long orgId,
			Long issueType, Integer page, Integer rows, String sidx, String sord) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		PageInfo<IssueViewObject> pageInfo = issueDao.findMyNeedDoIssues(orgId,
				issueType, page, rows, sidx, sord);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findcommandCenterMyNeedDoIssues(
			Long orgId, Long issueType, Integer page, Integer rows,
			String sidx, String sord) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		EventSourceVo eventSourceVO = new EventSourceVo();
		PropertyDict state = propertyDictService
				.findPropertyDictByDomainNameAndInternalId(
						PropertyTypes.EVENTSOURCE_STATE,
						IssueSourceType.TRANS_EVENT_NOTDONE).get(0);
		eventSourceVO.setState(state);
		eventSourceVO.setDealState(1);// 0未处理，1已处理
		List<EventSource> eventSourceList = eventSourceService
				.findInformation(eventSourceVO);

		String commandCenterNum = "";
		if (eventSourceList != null) {
			for (Iterator<EventSource> it = eventSourceList.iterator(); it
					.hasNext();) {
				EventSource eventSource = it.next();
				if (!"".equals(eventSource.getSerialNumber())) {
					commandCenterNum += eventSource.getSerialNumber() + ",";
				}
			}
		}
		if (!"".equals(commandCenterNum)) {
			commandCenterNum = commandCenterNum.substring(0,
					commandCenterNum.length() - 1);
		}
		return issueDao.findcommandCenterMyNeedDoIssues(orgId, issueType, page,
				rows, sidx, sord, commandCenterNum);
	}

	@Override
	public PageInfo<IssueViewObject> findMyDone(Long orgId, IssueNew issue,
			Integer page, Integer rows, String sidx, String sord, Long issueType) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		PageInfo<IssueViewObject> pageInfo = issueDao.findMyDone(orgId, issue,
				page, rows, sidx, sord, issueType);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		return pageInfo;
	}

	public PageInfo<IssueViewObject> findcommandCenterMyDone(Long orgId,
			IssueNew issue, Integer page, Integer rows, String sidx,
			String sord, int stateKind) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		PropertyDict state = propertyDictService
				.findPropertyDictByDomainNameAndInternalId(
						PropertyTypes.EVENTSOURCE_STATE,
						IssueSourceType.TRANS_EVENT_DONE).get(0);
		EventSourceVo eventSourceVo = new EventSourceVo();
		eventSourceVo.setState(state);
		eventSourceVo.setDealState(1);// 0为未处理,1为已处理
		List<EventSource> eventSourceList = eventSourceService
				.findInformation(eventSourceVo);
		String commandCenterNum = "";
		if (eventSourceList != null) {
			for (Iterator<EventSource> it = eventSourceList.iterator(); it
					.hasNext();) {
				EventSource eventSource = it.next();
				if (eventSource.getSerialNumber() != null
						&& !"".equals(eventSource.getSerialNumber())) {
					commandCenterNum += eventSource.getSerialNumber() + ",";
				}
			}
		}
		if (!"".equals(commandCenterNum)) {
			commandCenterNum = commandCenterNum.substring(0,
					commandCenterNum.length() - 1);
		}
		return issueDao.findcommandCenterMyDone(orgId, issue, page, rows, sidx,
				sord, commandCenterNum, stateKind);
	}

	@Override
	public PageInfo<IssueViewObject> findMyHistoricIssues(Long orgId,
			Integer page, Integer rows, String sidx, String sord) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = issueDao.findMyHistoricIssues(
				orgId, org.getOrgInternalCode(), page, rows, sidx, sord);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findMyPublicltyIssues(Long orgId,
			Integer page, Integer rows, String sidx, String sord) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		PageInfo<IssueViewObject> pageInfo = issueDao.findMyPublicltyIssues(
				orgId, page, rows, sidx, sord);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		return pageInfo;
	}

	/*******
	 * 
	 * 越级
	 */
	@Override
	public PageInfo<IssueViewObject> findJurisdictionsSkipIssue(Long orgId,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, int orgCodeFindLevel, Long searchOrgId) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = null;
		// statusType为0时，为近期越级；statusType为1时，为历史越级
		if ("0".equals(statusType)) {
			if (Boolean.valueOf(globalSettingService
					.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
				StringBuffer query = new StringBuffer();
				query.append("emergencyLevel:[0 TO *] ");
				createSolrQuery(query, orgLevel, searchOrgId, issueType,
						sourceType, functionalOrgType, searchOrgCode,
						org.getOrgInternalCode());
				if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
					rows = MAX_SCREEN_DISPLAY;
				}
				pageInfo = createPageInfoFromSolr(page, rows, sidx, sord, query);
			} else {
				pageInfo = issueDao.findJurisdictionsSkipIssue(org, page, rows,
						sidx, sord, issueType, orgLevel, leaderView,
						functionalOrgType, viewProcess, sourceType,
						orgCodeFindLevel, searchOrgId, searchOrgCode);
			}
		} else if ("1".equals(statusType)) {
			// 历史越级（已办结的历史越级）
			pageInfo = issueHistoryService.findJurisdictionsSkipIssueHistory(
					org, page, rows, sidx, sord, issueType, orgLevel,
					leaderView, functionalOrgType, viewProcess, sourceType,
					orgCodeFindLevel, searchOrgId, searchOrgCode);
		}
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsFollow(Long orgId,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId) {
		try {
			if (orgId == null) {
				return createEmptyIssueVoPageInfo(rows, 0);
			}
			// 快速检索的组织机构的code
			String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
			Organization org = organizationDubboService.getSimpleOrgById(orgId);
			PageInfo<IssueViewObject> pageInfo = null;
			if (Boolean.valueOf(globalSettingService
					.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
				StringBuffer query = new StringBuffer();
				query.append("stateCode:[500 TO 1000} AND status:[* TO 300}");
				createSolrQuery(query, orgLevel, searchOrgId, issueType,
						sourceType, functionalOrgType, searchOrgCode,
						org.getOrgInternalCode());
				if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
					rows = MAX_SCREEN_DISPLAY;
				}
				pageInfo = createPageInfoFromSolr(page, rows, sidx, sord, query);
			} else {
				pageInfo = issueDao.findJurisdictionsFollow(org, page, rows,
						sidx, sord, issueType, orgLevel, leaderView,
						functionalOrgType, viewProcess, sourceType,
						orgCodeFindLevel, searchOrgId, searchOrgCode);
			}
			for (IssueViewObject issueViewObject : pageInfo.getResult()) {
				issueOvertimeHelper.fillEaringWarnField(issueViewObject);
			}
			if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
				loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
			}
			return pageInfo;
		} catch (Exception e) {
			throw new ServiceValidationException("待跟进过程中发生错误", e);
		}
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsDone(Long orgId,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, int orgCodeFindLevel, Long searchOrgId) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = null;
		// statusType为0的时候，查询近期已办的数据,statusType为1的时候，查询历史已办的数据
		if ("0".equals(statusType)) {
			if (Boolean.valueOf(globalSettingService
					.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
				StringBuffer query = new StringBuffer();
				query.append("stateCode:[500 TO *] AND isStayStep:1");
				createSolrQuery(query, orgLevel, searchOrgId, issueType,
						sourceType, functionalOrgType, searchOrgCode,
						org.getOrgInternalCode());
				if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
					rows = MAX_SCREEN_DISPLAY;
				}
				pageInfo = createPageInfoFromSolr(page, rows, sidx, sord, query);
			} else {
				pageInfo = issueDao.findJurisdictionsDone(org, page, rows,
						sidx, sord, issueType, orgLevel, leaderView,
						functionalOrgType, viewProcess, sourceType,
						orgCodeFindLevel, searchOrgId, searchOrgCode);
			}
		} else if ("1".equals(statusType)) {
			// 历史已办结事件
			pageInfo = issueHistoryService.findJurisdictionsDoneHistory(org,
					page, rows, sidx, sord, issueType, orgLevel, leaderView,
					functionalOrgType, viewProcess, sourceType,
					orgCodeFindLevel, searchOrgId, searchOrgCode);
		}
		// PageInfo<IssueViewObject> pageInfo = issueDao.findJurisdictionsDone(
		// org, page, rows, sidx, sord, issueType, orgLevel, leaderView,
		// functionalOrgType, viewProcess, sourceType);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			IssueEvaluate issueEvaluate = issueEvaluateService
					.getIssueEvaluateByIssueId(issueViewObject.getIssueId());
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
			if (issueEvaluate != null && issueEvaluate.getId() != null) {
				issueViewObject.setEvaluateType(issueEvaluate.getEvaluateType());
				issueViewObject.setStatus(IssueState.GRADEDELAY);
			}
		}
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findTimeOutIssue(Long orgId, Integer page,
			Integer rows, String sidx, String sord, Long issueType,
			Integer superviseType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId) {
		try {
			if (orgId == null) {
				return createEmptyIssueVoPageInfo(rows, 0);
			}
			// 快速检索的组织机构的code
			String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
			Organization org = organizationDubboService.getSimpleOrgById(orgId);
			PageInfo<IssueViewObject> pageInfo = null;
			if (Boolean.valueOf(globalSettingService
					.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
				StringBuffer query = new StringBuffer();
				query.append("stateCode:[* TO 800]");
				if (superviseType == 0) {
					query.append(" AND superviseLevel:[100 TO *]");
				}
				if (superviseType == 100) {
					query.append(" AND superviseLevel:100");
				}
				if (superviseType == 200) {
					query.append(" AND superviseLevel:200");
				}
				createSolrQuery(query, orgLevel, searchOrgId, issueType,
						sourceType, functionalOrgType, searchOrgCode,
						org.getOrgInternalCode());
				if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
					rows = MAX_SCREEN_DISPLAY;
				}
				pageInfo = createPageInfoFromSolr(page, rows, sidx, sord, query);
			} else {
				pageInfo = issueDao.findTimeOutIssue(org, page, rows, sidx,
						sord, issueType, superviseType, orgLevel, leaderView,
						functionalOrgType, viewProcess, sourceType,
						orgCodeFindLevel, searchOrgId, searchOrgCode);
			}
			for (IssueViewObject issueViewObject : pageInfo.getResult()) {
				issueOvertimeHelper.fillEaringWarnField(issueViewObject);
			}
			if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
				loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
			}
			return pageInfo;
		} catch (Exception e) {
			throw new ServiceValidationException("获取超时事件发生错误", e);
		}
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsVerification(Long orgId,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, int orgCodeFindLevel, Long searchOrgId) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = null;
		if (Boolean.valueOf(globalSettingService
				.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
			StringBuffer query = new StringBuffer();
			query.append("stateCode:800");
			query.append(" AND targetOrg:{0 TO *]");
			createSolrQueryForCreateOrg(query, orgLevel, searchOrgId,
					issueType, sourceType, functionalOrgType, searchOrgCode,
					org.getOrgInternalCode());
			if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
				rows = MAX_SCREEN_DISPLAY;
			}
			pageInfo = createPageInfoFromSolr(page, rows, sidx, sord,
					query);
		} else {
			pageInfo = issueDao.findJurisdictionsVerification(org, page, rows,
					sidx, sord, issueType, orgLevel, leaderView,
					functionalOrgType, statusType, viewProcess, sourceType,
					orgCodeFindLevel, searchOrgId, searchOrgCode);
		}
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		}
		return pageInfo;
	}

	@Override
	public int getJurisdictionsVerificationCountForViewTab(Long orgLevel,
			Long orgId, Long functionalOrgType) {
		if (orgLevel == null || orgId == null) {
			throw new BusinessValidationException("参数错误");
		}
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		if (org == null) {
			throw new BusinessValidationException("参数错误");
		}
		return issueDao.getJurisdictionsVerificationCountForViewTab(orgLevel,
				org, functionalOrgType);
	}

	@Override
	public int getJurisdictionsGradeDelayCountForViewTab(Long orgLevel,
			Long orgId, Long functionalOrgType) {
		if (orgLevel == null || orgId == null) {
			throw new BusinessValidationException("参数错误");
		}
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		if (org == null) {
			throw new BusinessValidationException("参数错误");
		}
		return issueDao.getJurisdictionsGradeDelayCountForViewTab(orgLevel,
				org, functionalOrgType);
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsCompleted(Long orgId,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, String issueGradeIsVisabled, int orgCodeFindLevel,
			Long searchOrgId, String evaluationType) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		StringBuffer query = new StringBuffer();
		query.append("stateCode:[1000 TO *]");
		if (IssueEvaluationType.NOT_EVALUATION.equals(evaluationType)) {
			query.append(" AND issueEvaluate:0");
		}
		if (IssueEvaluationType.HAVE_EVALUATION.equals(evaluationType)) {
			query.append(" AND issueEvaluate:1");
		}
		createSolrQueryForCurrentOrg(query, orgLevel, searchOrgId, issueType,
				sourceType, functionalOrgType, searchOrgCode,
				org.getOrgInternalCode());
//		createSolrQueryForCreateOrg(query, orgLevel, searchOrgId, issueType,
//				sourceType, functionalOrgType, searchOrgCode,
//				org.getOrgInternalCode());
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			rows = MAX_SCREEN_DISPLAY;
		}
		PageInfo<IssueViewObject> pageInfo = createPageInfoFromSolr(page, rows,
				sidx, sord, query);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			IssueEvaluate issueEvaluate = issueEvaluateService
					.getIssueEvaluateByIssueId(issueViewObject.getIssueId());
			if (issueEvaluate != null && issueEvaluate.getId() != null) {
				issueViewObject.setEvaluateType(issueEvaluate.getEvaluateType());
				issueViewObject.setStatus(IssueState.GRADEDELAY);
			}
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsPublicltyCassDone(
			Long orgId, Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, String issueGradeIsVisabled, int orgCodeFindLevel,
			Long searchOrgId) {
		try {
			if (orgId == null) {
				return createEmptyIssueVoPageInfo(rows, 0);
			}
			// 快速检索的组织机构的code
			String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
			Organization org = organizationDubboService.getSimpleOrgById(orgId);
			PageInfo<IssueViewObject> pageInfo = null;
			if (Boolean.valueOf(globalSettingService
					.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
				StringBuffer query = new StringBuffer();
				query.append("stateCode:[1000 TO *] AND publicltycass:1");
				createSolrQueryForCreateOrg(query, orgLevel, searchOrgId,
						issueType, sourceType, functionalOrgType,
						searchOrgCode, org.getOrgInternalCode());
				if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
					rows = MAX_SCREEN_DISPLAY;
				}
				pageInfo = createPageInfoFromSolr(page, rows, sidx, sord, query);
			} else {
				pageInfo = issueDao.findJurisdictionsPublicltyCassDone(org,
						page, rows, sidx, sord, issueType, orgLevel,
						leaderView, functionalOrgType, statusType, viewProcess,
						sourceType, issueGradeIsVisabled, orgCodeFindLevel,
						searchOrgId, searchOrgCode);
			}
			for (IssueViewObject issueViewObject : pageInfo.getResult()) {
				issueOvertimeHelper.fillEaringWarnField(issueViewObject);
				IssueEvaluate issueEvaluate = issueEvaluateService
						.getIssueEvaluateByIssueId(issueViewObject.getIssueId());
				if (issueEvaluate != null && issueEvaluate.getId() != null) {
					issueViewObject.setEvaluateType(issueEvaluate.getEvaluateType());
					issueViewObject.setStatus(IssueState.GRADEDELAY);
				}
			}
			if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
				loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
			}
			return pageInfo;
		} catch (Exception e) {
			throw new ServiceValidationException("获取宣传案例事件发生错误", e);
		}
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsGradeDelay(Long orgId,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, int orgCodeFindLevel, Long searchOrgId,
			String evaluationType) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		StringBuffer query = new StringBuffer();
		query.append("stateCode:1000");
		query.append(" AND endDate:["
				+ DateFormat.getSolrAddDateString(
						DateFormat.DEFAULT_DATE_FORMAT, -20) + " TO *]");
		if (IssueEvaluationType.NOT_EVALUATION.equals(evaluationType)) {
			query.append(" AND issueEvaluate:0");
		}
		if (IssueEvaluationType.HAVE_EVALUATION.equals(evaluationType)) {
			query.append(" AND issueEvaluate:1");
		}
		createSolrQueryForCreateOrg(query, orgLevel, searchOrgId, issueType,
				sourceType, functionalOrgType, searchOrgCode,
				org.getOrgInternalCode());
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			rows = MAX_SCREEN_DISPLAY;
		}
		PageInfo<IssueViewObject> pageInfo = createPageInfoFromSolr(page, rows,
				sidx, sord, query);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			IssueEvaluate issueEvaluate = issueEvaluateService
					.getIssueEvaluateByIssueId(issueViewObject.getIssueId());
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
			if (issueEvaluate != null && issueEvaluate.getId() != null) {
				issueViewObject.setEvaluateType(issueEvaluate.getEvaluateType());
				issueViewObject.setStatus(IssueState.GRADEDELAY);
			}
			// fillStatusForGradeDelayIssue(issueViewObject);
		}
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		}
		return pageInfo;
	}

	// 待评分页面中，对于已评分的数据进行状态修改
	private void fillStatusForGradeDelayIssue(IssueViewObject issueViewObject) {
		IssueEvaluate evaluate = issueEvaluateService
				.getIssueEvaluateByIssueId(issueViewObject.getIssueId());
		if (evaluate != null) {
			issueViewObject.setStatus(IssueState.GRADEDELAY);
		}
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsSubmit(Long orgId,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, int orgCodeFindLevel, Long searchOrgId) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = null;
		// statusType为0时，为近期上报；statusType为1时，为历史上报
		if ("0".equals(statusType)) {
			if (Boolean.valueOf(globalSettingService
					.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
				StringBuffer query = new StringBuffer();
				query.append("submit:1");
				createSolrQuery(query, orgLevel, searchOrgId, issueType,
						sourceType, functionalOrgType, searchOrgCode,
						org.getOrgInternalCode());
				if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
					rows = MAX_SCREEN_DISPLAY;
				}
				pageInfo = createPageInfoFromSolr(page, rows, sidx, sord, query);
			} else {
				pageInfo = issueDao.findJurisdictionsSubmit(org, page, rows,
						sidx, sord, issueType, orgLevel, leaderView,
						functionalOrgType, viewProcess, sourceType,
						orgCodeFindLevel, searchOrgId, searchOrgCode);
			}
		} else if ("1".equals(statusType)) {
			// 历史上报（已办结的历史上报）
			pageInfo = issueHistoryService.findJurisdictionsSubmitHistory(org,
					page, rows, sidx, sord, issueType, orgLevel, leaderView,
					functionalOrgType, viewProcess, sourceType,
					orgCodeFindLevel, searchOrgId, searchOrgCode);
		}
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findMyCompleted(Long orgId, Integer page,
			Integer rows, String sidx, String sord, Long issueType) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = issueDao.findMyCompleted(orgId,
				org.getOrgInternalCode(), page, rows, sidx, sord, issueType);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsNeedDo(String seachValue,
			Long orgId, Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalorgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = null;
		if (Boolean.valueOf(globalSettingService
				.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
			StringBuffer query = new StringBuffer();
			query.append("stateCode:[* TO 500}");
			createSolrQuery(query, orgLevel, searchOrgId, issueType,
					sourceType, functionalorgType, searchOrgCode,
					org.getOrgInternalCode());
			if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
				rows = MAX_SCREEN_DISPLAY;
			}
			pageInfo = createPageInfoFromSolr(page, rows, sidx, sord, query);
		} else {
			pageInfo = issueDao.findJurisdictionsNeedDo(seachValue, org, page,
					rows, sidx, sord, issueType, orgLevel, leaderView,
					functionalorgType, viewProcess, sourceType,
					orgCodeFindLevel, searchOrgId, searchOrgCode);
		}
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsNeedDoForOverseerForMobile(
			String seachValue, Long orgId, Integer page, Integer rows,
			String sidx, String sord, Long issueType, Long orgLevel,
			String leaderView, Long functionalorgType, Integer viewProcess,
			Long sourceType) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = issueDao
				.findJurisdictionsNeedDoForOverseerForMobile(seachValue, org,
						page, rows, sidx, sord, issueType, orgLevel,
						leaderView, functionalorgType, viewProcess, sourceType);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findIssueNeedDo(String seachValue,
			Long orgId, Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalorgType, Integer viewProcess, Long sourceType) {
		try {
			if (orgId == null) {
				return createEmptyIssueVoPageInfo(rows, 0);
			}
			// 获取工作台待办事项的列表
			PageInfo<IssueViewObject> pageInfo = getWorkBench(seachValue,
					orgId, page, rows, sidx, sord, issueType, orgLevel,
					leaderView, functionalorgType, viewProcess, sourceType,
					ORG_CODE_FIND_LEVEL, NO_SEARCH_ORG);
			for (IssueViewObject issueViewObject : pageInfo.getResult()) {
				issueOvertimeHelper.fillEaringWarnField(issueViewObject);
			}
			if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
				loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
			}
			// 获取待办，待审核，待验证，待评分的总条数
			int totalRowSize = getIssueNumWorkBench(seachValue, orgId, page,
					rows, sidx, sord, issueType, orgLevel, leaderView,
					functionalorgType, viewProcess, sourceType, ThreadVariable
							.getUser().getId());
			pageInfo.setTotalRowSize(totalRowSize);

			return pageInfo;
		} catch (Exception e) {
			throw new BusinessValidationException("获取待办列表出错");
		}
	}

	private PageInfo<IssueViewObject> getWorkBench(String seachValue,
			Long orgId, Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalorgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId) {
		List<IssueViewObject> issueNeedList = new ArrayList<IssueViewObject>();
		PageInfo<IssueViewObject> pageInfo = new PageInfo<IssueViewObject>();
		Integer count = 0;// 记录每次查询后的真实总条数
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		// 判断当前用户是否有待办的权限
		if (permissionService.findUserAllPermissionByUserIdAndPermissionEname(
				ThreadVariable.getUser().getId(), "needIssueListManagement")) {
			// 待办列表
			pageInfo = issueDao.findJurisdictionsNeedDo(seachValue, org, page,
					rows, sidx, sord, issueType, orgLevel, leaderView,
					functionalorgType, viewProcess, sourceType,
					orgCodeFindLevel, searchOrgId, searchOrgCode);
			issueNeedList = pageInfo.getResult();
			count = issueNeedList.size();
		}
		// 递归获取工作台待办事项中
		for (int index = 1; index < 4; index++) {
			if (count < rows) {
				issueNeedList = getIssueListOfWorkBench(issueNeedList, rows
						- count, index, seachValue, org, page, sidx, sord,
						issueType, orgLevel, leaderView, functionalorgType,
						viewProcess, sourceType, orgCodeFindLevel, searchOrgId,
						searchOrgCode);
				count = issueNeedList.size();
			} else {
				break;
			}
		}
		pageInfo.setResult(issueNeedList);
		return pageInfo;
	}

	/**
	 * 获取工作台待办事项列表
	 * 
	 * @param issueNeedList
	 * 
	 * @param num
	 *            （查询条数）
	 * @param index
	 *            （页面计数器，1表示查待审核，2表示查待验证，3表示查待评分）
	 * @return
	 */
	private List<IssueViewObject> getIssueListOfWorkBench(
			List<IssueViewObject> issueNeedList, Integer num, int index,
			String seachValue, Organization org, Integer page, String sidx,
			String sord, Long issueType, Long orgLevel, String leaderView,
			Long functionalorgType, Integer viewProcess, Long sourceType,
			int orgCodeFindLevel, Long searchOrgId, String searchOrgCode) {
		if (index == 1
				&& permissionService
						.findUserAllPermissionByUserIdAndPermissionEname(
								ThreadVariable.getUser().getId(),
								"checkPendingIssueListManagement")) {
			PageInfo<IssueViewObject> pageInfo = issueDao
					.findJurisdictionAuditDelay(org, orgLevel,
							functionalorgType, page, num, sidx, sord,
							orgCodeFindLevel, searchOrgId, searchOrgCode,
							issueType);
			for (IssueViewObject issueViewObject : pageInfo.getResult()) {
				issueNeedList.add(issueViewObject);
			}
		}
		if (index == 2
				&& permissionService
						.findUserAllPermissionByUserIdAndPermissionEname(
								ThreadVariable.getUser().getId(),
								"verificationIssueListManagement")) {
			PageInfo<IssueViewObject> pageInfo = issueDao
					.findJurisdictionsVerification(org, page, num, sidx, sord,
							issueType, orgLevel, leaderView, functionalorgType,
							"", viewProcess, sourceType, orgCodeFindLevel,
							searchOrgId, searchOrgCode);
			for (IssueViewObject issueViewObject : pageInfo.getResult()) {
				issueNeedList.add(issueViewObject);
			}
		}
		if (index == 3
				&& permissionService
						.findUserAllPermissionByUserIdAndPermissionEname(
								ThreadVariable.getUser().getId(),
								"checkGradeIssueListManagement")) {
			PageInfo<IssueViewObject> pageInfo = issueDao
					.findJurisdictionsGradeDelay(org, page, num, sidx, sord,
							issueType, orgLevel, leaderView, functionalorgType,
							"", viewProcess, sourceType, orgCodeFindLevel,
							searchOrgId, searchOrgCode);
			for (IssueViewObject issueViewObject : pageInfo.getResult()) {
				issueNeedList.add(issueViewObject);
			}
		}
		return issueNeedList;
	}

	public int getIssueNumWorkBench(String seachValue, Long orgId,
			Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalorgType, Integer viewProcess, Long sourceType,
			Long userId) {
		boolean needIssuePermission = false;// 待办的权限
		boolean checkPendingIssuePermission = false;// 待审核的权限
		boolean verificationIssuePermission = false;// 待验证的权限
		boolean checkGradeIssuePermission = false;// 待评分的权限
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		if (permissionService.findUserAllPermissionByUserIdAndPermissionEname(
				userId, "needIssueListManagement")) {
			needIssuePermission = true;
		}
		if (permissionService.findUserAllPermissionByUserIdAndPermissionEname(
				userId, "checkPendingIssueListManagement")) {
			checkPendingIssuePermission = true;
		}
		if (permissionService.findUserAllPermissionByUserIdAndPermissionEname(
				userId, "verificationIssueListManagement")) {
			verificationIssuePermission = true;
		}
		if (permissionService.findUserAllPermissionByUserIdAndPermissionEname(
				userId, "checkGradeIssueListManagement")) {
			checkGradeIssuePermission = true;
		}
		return issueDao.getIssueNumWorkBench(seachValue, org, page, rows, sidx,
				sord, issueType, orgLevel, leaderView, functionalorgType,
				viewProcess, sourceType, needIssuePermission,
				checkPendingIssuePermission, verificationIssuePermission,
				checkGradeIssuePermission);
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsDoing(String seachValue,
			Long orgId, Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, Integer viewProcess, int orgCodeFindLevel,
			Long searchOrgId) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = issueDao.findJurisdictionsDoing(
				seachValue, org, page, rows, sidx, sord, issueType, orgLevel,
				leaderView, functionalOrgType, viewProcess, orgCodeFindLevel,
				searchOrgId, searchOrgCode);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsAssgin(String seachValue,
			Long orgId, Integer page, Integer rows, String sidx, String sord,
			Long issueType, Long orgLevel, String leaderView,
			Long functionalOrgType, String statusType, Integer viewProcess,
			Long sourceType, int orgCodeFindLevel, Long searchOrgId) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(rows, 0);
		}
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = null;
		// statusType为0时，为近期上级交办；statusType为1时，为历史上级交办
		if ("0".equals(statusType)) {
			if (Boolean.valueOf(globalSettingService
					.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
				StringBuffer query = new StringBuffer();
				query.append("assign:1");
				createSolrQuery(query, orgLevel, searchOrgId, issueType,
						sourceType, functionalOrgType, searchOrgCode,
						org.getOrgInternalCode());
				if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
					rows = MAX_SCREEN_DISPLAY;
				}
				pageInfo = createPageInfoFromSolr(page, rows, sidx, sord, query);
			} else {
				pageInfo = issueDao.findJurisdictionsAssgin(seachValue, org,
						page, rows, sidx, sord, issueType, orgLevel,
						leaderView, functionalOrgType, viewProcess, sourceType,
						orgCodeFindLevel, searchOrgId, searchOrgCode);
			}
		} else if ("1".equals(statusType)) {
			// 历史上级交办（已办结的历史上级交办）
			pageInfo = issueHistoryService.findJurisdictionsAssginHistory(
					seachValue, org, page, rows, sidx, sord, issueType,
					orgLevel, leaderView, functionalOrgType, viewProcess,
					sourceType, orgCodeFindLevel, searchOrgId, searchOrgCode);
		}
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		if (IssueViewType.VIEWPROCESS.equals(viewProcess)) {
			loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		}
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsNeedDoForProcess(
			String seachValue, Long orgId, String sidx, String sord) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(0, 0);
		}
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = issueDao
				.findJurisdictionsNeedDoForProcess(seachValue, org, sidx, sord);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}

		loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		return pageInfo;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionsDoneForProcess(
			String seachValue, Long orgId, String sidx, String sord) {
		if (orgId == null) {
			return createEmptyIssueVoPageInfo(0, 0);
		}
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = issueDao
				.findJurisdictionsDoneForProcess(seachValue, org, sidx, sord);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		return pageInfo;
	}

	private void loadIssueOccurOrgAndCurrentOrgAndIssueTypes(
			PageInfo<IssueViewObject> pageInfo) {
		if (null != pageInfo.getResult() && pageInfo.getResult().size() > 0) {
			for (IssueViewObject ivo : pageInfo.getResult()) {
				IssueNew issueNew = issueDao.getFullIssueById(ivo.getIssueId());
				if (issueNew == null || issueNew.getId() == null) {
					issueNew = issueHistoryService.getFullIssueHistoryById(ivo
							.getIssueId());
				}
				loadFullIssueTypes(issueNew, ivo);

				ivo.setOccurOrg(organizationDubboService.getSimpleOrgById(ivo
						.getOccurOrg() == null ? null : ivo.getOccurOrg()
						.getId()));
				ivo.setCurrentOrg(organizationDubboService.getSimpleOrgById(ivo
						.getCurrentOrg() == null ? null : ivo.getCurrentOrg()
						.getId()));
				ivo.setCreateOrg(organizationDubboService.getSimpleOrgById(issueNew
						.getCreateOrg() == null ? null : issueNew
						.getCreateOrg().getId()));
				ivo.setCreateUser(issueNew.getCreateUser());

			}
		}
	}

	private void loadFullIssueTypes(IssueNew selectIssue,
			IssueViewObject issueViewObject) {
		String issueTypes = "";
		IssueType type = issueTypeService.getIssueTypeById(selectIssue
				.getIssueType().getIssueTypeDomain().getId(), selectIssue
				.getIssueType().getId());
		IssueTypeDomain issueTypeDomain = issueTypeService
				.getIssueTypeDomainById(type.getIssueTypeDomain().getId());
		issueTypes += issueTypeDomain.getDomainName() + "：";
		issueTypes += type.getIssueTypeName() + "，";
		if (issueTypes.lastIndexOf('，') >= 0) {
			issueTypes = (new StringBuffer(issueTypes)).replace(
					issueTypes.length() - 1, issueTypes.length(), "")
					.toString();
		}
		issueViewObject.setIssueTypes(issueTypes);
	}

	@Override
	public IssueNew getFullIssueByStepId(Long keyId) {
		IssueNew result = issueDao.getFullIssueByStepId(keyId);
		if (result == null || result.getId() == null) {
			result = issueHistoryService.getFullIssueByHistoryStepId(keyId);
		}
		populationIssueProperty(result);
		return result;
	}

	@Override
	public IssueNew getFullIssueByIssueId(Long issueId) {
		IssueNew issue = issueDao.getFullIssueById(issueId);
		if (issue == null) {
			issue = issueHistoryService.getFullIssueHistoryById(issueId);
		}
		populationIssueProperty(issue);
		return issue;
	}

	@Override
	public List<IssueAttachFile> loadIssueAttachFilesByIssueId(Long issueId) {
		return issueDao.loadIssueAttachFilesByIssueAndLog(issueId, null);
	}

	@Override
	public List<IssueAttachFile> loadIssueAttachFilesByIssueIdAndIssueLogId(
			Long issueId, Long issueLogId) {
		return issueDao.loadIssueAttachFilesByIssueAndLog(issueId, issueLogId);
	}

	@Override
	public List<IssueLogNew> loadIssueOperationLogsByIssueId(Long id) {
		List<IssueLogNew> issueLogList = issueLogDao
				.loadIssueOperationLogsByIssueId(id);
		return enclosureOrg(issueLogList);
	}

	private List<IssueLogNew> enclosureOrg(List<IssueLogNew> issueLogList) {
		List<IssueLogNew> issueLogNewList = new ArrayList<IssueLogNew>();
		for (IssueLogNew issueLogNew : issueLogList) {
			Organization org = organizationDubboService
					.getSimpleOrgAllOrganizationById(issueLogNew.getDealOrg()
							.getId());
			issueLogNew.setDealOrg(org);
			issueLogNewList.add(issueLogNew);
		}
		return issueLogNewList;
	}

	@Override
	public IssueAttachFile getIssueAttachFileById(Long id) {
		return issueDao.getIssueAttachFileById(id);
	}

	@Override
	public List<IssueOperate> getIssueCandoForOrg(Long stepId,
			Organization operateOrg) {
		if (stepId == null || isHistoricIssue(stepId)) {
			return new ArrayList<IssueOperate>();
		}
		return getIssueWorkFlowEngine().getIssueCandoForOrg(stepId, operateOrg);
	}

	@Override
	public IssueStep getIssueStepById(Long stepId) {
		return getIssueWorkFlowEngine().getFullIssueStepById(stepId);
	}

	@Override
	public PageInfo<AutoCompleteData> findAdminTargetsByName(Long stepid,
			String tag, IssueOperate operate, Long[] exceptIds, int pageIndex,
			int rows) {
		return getIssueWorkFlowEngine().findAdminTargetsByName(stepid, operate,
				tag, exceptIds, pageIndex, rows);
	}

	@Override
	public PageInfo<AutoCompleteData> findFunctionTargetsByName(Long stepid,
			String tag, IssueOperate operate, Long[] exceptIds, int pageIndex,
			int rows) {
		return getIssueWorkFlowEngine().findFunctionTargetsByName(stepid,
				operate, tag, exceptIds, pageIndex, rows);
	}

	@Override
	public PageInfo<AutoCompleteData> findTellTargetsByName(Long stepid,
			String tag, IssueOperate operate, boolean transferToAdmin,
			Long[] exceptIds, int page, int rows) {
		return getIssueWorkFlowEngine().findTellTargetsByName(stepid, operate,
				tag, transferToAdmin, exceptIds, page, rows);
	}

	private void autoFillIssueLogProperty(IssueLogNew log, IssueOperate operate) {
		log.setDealType(Long.valueOf(operate.getCode()));
		log.setDealOrg(ThreadVariable.getSession().getOrganization());
		log.setDealTime(CalendarUtil.now());
	}

	private void loadAndAutoFillAllOrgInfo(IssueNew issue) {
		issue.setCreateOrg(loadSimpleOrg(ThreadVariable.getSession()
				.getOrganization().getId()));
		issue.setLastOrg(issue.getCreateOrg());
		issue.setOccurOrg(loadSimpleOrg(issue.getOccurOrg().getId()));
	}

	private Organization loadSimpleOrg(Long orgId) {
		return orgId == null ? null : organizationDubboService
				.getSimpleOrgById(orgId);
	}

	private void validate(IssueNew issue, List<IssueAttachFile> files) {
		ValidateResult vr = getIssueValidator().validate(issue);
		vr.addAllErrorMessage(getIssueValidator().validateAttachFiles(files));
		if (vr.hasError()) {
			throw new BusinessValidationException(vr.getErrorMessages());
		}
	}

	private void validateNamesAndTelephones(String issueRelatedPeopleNames,
			String issueRelatedPeopleTelephones,
			String issueRelatedPeopleFixPhones, IssueNew issue) {
		if (null == issueRelatedPeopleNames
				|| null == issueRelatedPeopleTelephones
				|| null == issueRelatedPeopleFixPhones) {
			throw new BusinessValidationException("参数错误");
		}
		String[] issueRelatedPeopleNameArray = issueRelatedPeopleNames
				.split(",");
		String[] issueRelatedPeopleTelephoneArray = issueRelatedPeopleTelephones
				.split(",");
		String[] issueRelatedPeoplefixPhoneArray = issueRelatedPeopleFixPhones
				.split(",");
		IssueTypeDomain issueTypeDomain = issueTypeService
				.getIssueTypeDoaminByDomainName(IssueTypes.SECURITYPRECAUTIONS);

		if (issue.getIssueType().getIssueTypeDomain().getId()
				.equals(issueTypeDomain.getId())) {// 如果事件类型是参与治安防控，则不进行必填项验证
			for (String name : issueRelatedPeopleNameArray) {
				if (StringUtil.isStringAvaliable(name)) {
					if (validateHelper.illegalExculdeParticalChar2(name.trim()))
						throw new BusinessValidationException("姓名不能输入特殊字符");
				}
			}
			validateFixPhoneAndTelephone(issueRelatedPeopleTelephoneArray,
					issueRelatedPeoplefixPhoneArray);
		} else {
			for (String name : issueRelatedPeopleNameArray) {
				if (!StringUtil.isStringAvaliable(name)) {
					throw new BusinessValidationException("姓名不能为空");
				} else if (validateHelper.illegalExculdeParticalChar2(name
						.trim())) {
					throw new BusinessValidationException("姓名不能输入特殊字符");
				}
			}
			validateFixPhoneAndTelephone(issueRelatedPeopleTelephoneArray,
					issueRelatedPeoplefixPhoneArray);
		}
	}

	private void validateFixPhoneAndTelephone(
			String[] issueRelatedPeopleTelephoneArray,
			String[] issueRelatedPeoplefixPhoneArray) {
		for (String telephone : issueRelatedPeopleTelephoneArray) {
			if (StringUtil.isStringAvaliable(telephone)) {
				if (validateHelper.illegalMobilePhone(telephone.trim())) {
					throw new BusinessValidationException("手机号码必须由1开头的11位数字组成");
				}
			}
		}
		for (String fixPhone : issueRelatedPeoplefixPhoneArray) {
			if (StringUtil.isStringAvaliable(fixPhone)) {
				if (validateHelper.illegalTelephone(fixPhone.trim())) {
					throw new BusinessValidationException("固话输入不正确，只能输数字和横杠(-)");
				}
			}
		}
	}

	private void addIssueRelatedPeople(IssueNew issue,
			String issueRelatedPeopleNames,
			String issueRelatedPeopleTelephones,
			String issueRelatedPeoplefixPhones) {
		String[] issueRelatedPeopleNameArray = issueRelatedPeopleNames
				.split(",");
		String[] issueRelatedPeopleTelephoneArray = issueRelatedPeopleTelephones
				.replace(",", ", ").replace("  ", " ").split(",");
		String[] issueRelatedPeoplefixPhoneArray = issueRelatedPeoplefixPhones
				.replace(",", ", ").replace("  ", " ").split(",");
		for (int i = 0; i < issueRelatedPeopleNameArray.length; i++) {
			IssueRelatedPeople issueRelatedPeople = new IssueRelatedPeople();
			issueRelatedPeople.setIssue(issue);
			issueRelatedPeople.setName(issueRelatedPeopleNameArray[i].trim());
			issueRelatedPeople.setTelephone(issueRelatedPeopleTelephoneArray[i]
					.trim());
			issueRelatedPeople.setFixPhone(issueRelatedPeoplefixPhoneArray[i]
					.trim());
			issueRelatedPeopleService.addIssueRelatedPeople(issueRelatedPeople);
		}
	}

	private void validateOperationLog(IssueOperate operate, IssueLogNew log,
			List<IssueAttachFile> attachFiles) {
		ValidateResult vr = getIssueLogValidator().validate(operate, log,
				attachFiles);
		if (vr.hasError()) {
			throw new BusinessValidationException(vr.getErrorMessages());
		}
	}

	private IssueViewObject createIssueViewObject(IssueNew issue, IssueStep step) {
		IssueViewObject issueViewObject = new IssueViewObject();
		copyPropertyFromIssue(issue, issueViewObject);
		issueViewObject.setDealTime(step.getLastDealDate());
		issueViewObject.setSuperviseLevel(step.getSuperviseLevel());
		issueViewObject.setIssueLogId(step.getId());
		issueViewObject.setIssueStepId(step.getId());
		issueViewObject.setSupervisionState(step.getSuperviseLevel());
		issueViewObject.setTargeOrg(step.getTarget());
		issueViewObject.setDealState(Long.valueOf(step.getStateCode()));
		issueViewObject.setIssueContent(issue.getIssueContent());
		issueViewObject.setIssueType(issue.getIssueType());
		issueViewObject.setCreateDate(issue.getCreateDate());
		issueViewObject.setCreateOrg(issue.getCreateOrg());
		issueViewObject.setEmergencyLevel(step.getEmergencyLevel());
		issueViewObject.setSubmit(step.getSubmit());
		issueViewObject.setAssign(step.getAssign());
		issueViewObject.setEndDate(step.getEndDate());
		issueViewObject.setIsStayStep(step.getIsStayStep());
		//结案部门组织机构
		issueViewObject.setCurrentOrg(step.getSource());
		issueViewObject.setCurrentOrgFunctionalType(step.getSource().getFunctionalOrgType() == null ? 0L:step.getSource().getFunctionalOrgType().getId());
		issueViewObject.setCurrentOrginternalCode(step.getSource().getOrgInternalCode());
		if(step.getSource().getOrgLevel() != null){
			issueViewObject.setCurrentOrgLevel(step.getSource().getOrgLevel().getId());
		}
		return issueViewObject;
	}

	private boolean isHistoricIssue(Long stepId) {
		return getFullIssueByStepId(stepId).isHistoric();
	}

	private PageInfo<IssueViewObject> createEmptyIssueVoPageInfo(int pageSize,
			int pageIndex) {
		PageInfo<IssueViewObject> result = new PageInfo<IssueViewObject>();
		result.setTotalRowSize(0);
		result.setCurrentPage(pageIndex);
		result.setPerPageSize(pageSize);
		return result;
	}

	private void populationIssueProperty(IssueNew issue) {
		if (issue == null) {
			return;
		}
		if (issue.getSourceKind() != null
				&& issue.getSourceKind().getId() != null) {
			issue.setSourceKind(propertyDictService.getPropertyDictById(issue
					.getSourceKind().getId()));
		}
		if (issue.getCurrentStep() != null
				&& issue.getCurrentStep().getId() != null) {
			issue.setCurrentStep(getIssueStepById(issue.getCurrentStep()
					.getId()));
		}
		if (issue.getCurrentOrg() != null
				&& issue.getCurrentOrg().getId() != null) {
			issue.setCurrentOrg(organizationDubboService.getSimpleOrgById(issue
					.getCurrentOrg().getId()));
		}
		if (issue.getLastOrg() != null && issue.getLastOrg().getId() != null) {
			issue.setLastOrg(organizationDubboService.getSimpleOrgById(issue
					.getLastOrg().getId()));
		}
		if (issue.getOccurOrg() != null && issue.getOccurOrg().getId() != null) {
			issue.setOccurOrg(organizationDubboService.getSimpleOrgById(issue
					.getOccurOrg().getId()));
		}
		if (issue.getCreateUser() != null) {
			if (permissionService.getFullUserByUerName(issue.getCreateUser()) != null
					&& permissionService.getFullUserByUerName(
							issue.getCreateUser()).getId() != null) {
				issue.setSourceMobile(permissionService.getFullUserByUerName(
						issue.getCreateUser()).getMobile());
			}
		}
	}

	private IssueViewObject createIssueViewObject(IssueNew issue) {
		IssueViewObject issueViewObject = new IssueViewObject();
		copyPropertyFromIssue(issue, issueViewObject);
		if (issue.getCurrentStep() != null) {
			IssueStep step = getIssueStepById(issue.getCurrentStep().getId());
			issueViewObject.setDealTime(step.getLastDealDate());
			issueViewObject.setIssueLogId(step.getId());
			issueViewObject.setIssueStepId(step.getId());
			issueViewObject.setSupervisionState(step.getSuperviseLevel());
			issueViewObject.setTargeOrg(step.getTarget());
			issueViewObject.setDealState(Long.valueOf(IssueState.DEALING));
			issueViewObject.setEmergencyLevel(step.getEmergencyLevel());
			issueViewObject.setSubmit(step.getSubmit());
			issueViewObject.setAssign(step.getAssign());
			issueViewObject.setEndDate(step.getEndDate());
			issueViewObject.setIsStayStep(step.getIsStayStep());
		} else {
			issueViewObject.setDealState(Long.valueOf(IssueState.COMPLETE));
		}
		return issueViewObject;
	}

	private void copyPropertyFromIssue(IssueNew issue,
			IssueViewObject issueViewObject) {
		issueViewObject.setIssueId(issue.getId());
		issueViewObject.setSerialNumber(issue.getSerialNumber());
		issueViewObject.setSubject(issue.getSubject());
		issueViewObject.setStatus(issue.getStatus());
		issueViewObject.setCurrentOrg(issue.getCurrentStep() == null ? null
				: issue.getCurrentStep().getTarget());
		issueViewObject.setOccurDate(issue.getOccurDate());
		issueViewObject.setLastOrg(issue.getLastOrg());
		issueViewObject.setOccurOrg(issue.getOccurOrg());
		issueViewObject.setUrgent(issue.getUrgent());
		issueViewObject.setSourcePerson(issue.getSourcePerson());
		issueViewObject.setSourceKind(issue.getSourceKind());
		issueViewObject.setSourceMobile(issue.getSourceMobile());
		issueViewObject.setCreateOrg(issue.getCreateOrg());
		issueViewObject.setIssueType(issue.getIssueType());
		issueViewObject.setOccurLocation(issue.getOccurLocation());
		issueViewObject.setIssueKind(issue.getIssueKind());
		issueViewObject.setRelatePeopleCount(issue.getRelatePeopleCount());
		issueViewObject.setUrgent(issue.getUrgent());
		issueViewObject.setEventState(issue.getEventState());
	}

	/** 判断事件是否已经设为宣传案例 */
	private boolean alreadyPubliclty(Organization org, IssueNew issue) {
		return issueDao.alreadyPubliclty(issue.getId(), org.getId());
	}

	/**
	 * 从宣传案例中删除事件
	 * 
	 * @param issueId
	 *            事件id
	 */
	private void removeIssueFromPublilty(Long issueId) {
		issueDao.removePubliclty(null, issueId);
	}

	/***************************************************************************
	 * 删除事件的附件和附件关联关系
	 * 
	 * @param issueId
	 *            事件id
	 */
	private void removeIssueAllAttachFiles(Long issueId) {
		List<IssueAttachFile> issueAttachFiles = loadIssueAttachFilesByIssueId(issueId);
		if (issueAttachFiles != null && issueAttachFiles.size() > 0) {
			String webRootPath = FileUtil.getWebRoot();
			for (IssueAttachFile issueFile : issueAttachFiles) {
				File file = new File(webRootPath + File.separator
						+ issueFile.getFileActualUrl());
				if (file.exists()) {
					file.delete();
				}
			}
		}
		issueDao.removeAllIssueAttachFiles(issueId);
	}

	public List<IssueNew> searchAllRoundIssues(GisInfo minOption,
			GisInfo maxOption) {
		return issueDao.searchAllRoundIssues(minOption, maxOption);
	}

	@Override
	public List<IssueMap> getIssueMap(Long issueId) {
		List<IssueStepGroup> stepGroupList = issueProcessDao
				.getIssueStepGroupByIssueId(issueId);
		List<IssueMap> issueMapList;
		if (null != stepGroupList && stepGroupList.size() > 0) {
			issueMapList = loadIssueMap(stepGroupList);
		} else {
			issueMapList = new ArrayList<IssueMap>();
		}
		return issueMapList;
	}

	private List<IssueMap> loadIssueMap(List<IssueStepGroup> stepGroupList) {
		List<IssueMap> issueMapList = new ArrayList<IssueMap>();
		for (int i = 0; i < stepGroupList.size(); i++) {
			IssueStepGroup isg = stepGroupList.get(i);
			if (i == stepGroupList.size() - 1) {
				isg.setOutLog(isg.getEntyLog());
			}
			IssueMap im = issueProcessDao.getIssueMapByStepGroup(isg);
			if (im != null) {
				im.setId(isg.getId());
				if (i + 1 < stepGroupList.size()) {
					im.setTo(stepGroupList.get(i + 1).getId());
				}
				im = IssueMapUtil.setRelationAndStates(im);
				im.setFunctionalOrg(propertyDictService.getPropertyDictById(
						organizationDubboService
								.getSimpleOrgById(im.getOrgId()).getOrgType()
								.getId()).getInternalId() == OrganizationType.FUNCTIONAL_ORG);
				issueMapList.add(im);
			}
		}
		return issueMapList;
	}

	public List<IssueLogNew> getIssueDealLog(IssueMap issueMap) {
		IssueStepGroup group = issueProcessDao
				.getSimpleIssueStepGroupById(issueMap.getId());

		List<IssueLogNew> logs = issueLogDao
				.findIssueDealLogByIssueMapAndIssueStepGroup(issueMap, group);
		return logs;
	}

	public Map<String, List<EmphasesVo>> findRelatePerson(Long issueId) {
		Map<String, List<EmphasesVo>> map = new HashMap<String, List<EmphasesVo>>();
		List<EmphasesVo> list = issueTypeService
				.findRelatePersonByName(issueId);
		for (int i = 0; i < list.size(); i++) {
			if (map.get(list.get(i).getType()) != null) {
				map.get(list.get(i).getType()).add(list.get(i));
			} else {
				List<EmphasesVo> emphasesVos = new ArrayList<EmphasesVo>();
				list.add(list.get(i));
				map.put(list.get(i).getType(), emphasesVos);
			}
		}
		return map;
	}

	public Map<String, List<EmphasesVo>> findRelatePlace(Long issueId) {
		Map<String, List<EmphasesVo>> map = new HashMap<String, List<EmphasesVo>>();
		List<EmphasesVo> list = issueTypeService
				.findRelatePlacesByName(issueId);
		for (int i = 0; i < list.size(); i++) {
			if (map.get(list.get(i).getType()) != null) {
				map.get(list.get(i).getType()).add(list.get(i));
			} else {
				List<EmphasesVo> emphasesVos = new ArrayList<EmphasesVo>();
				list.add(list.get(i));
				map.put(list.get(i).getType(), emphasesVos);
			}
		}
		return map;
	}

	@Override
	public IssueNew saveIssueGrade(Long id, IssueAccord issueAccord,
			IssueEvaluate issueEvaluate) {
		if (issueEvaluate != null) {
			// 原事件验证功能有个验证事件,在打分操作中把当前系统事件做为验证事件
			try {
				issueEvaluate.setEvaluateTime(CalendarUtil.now("yyyy-MM-dd"));
				issueEvaluateService.evaluateForGrade(issueEvaluate);
			} catch (Exception e) {
				throw new ServiceValidationException("评价失败", "评价失败", e);
			}

		}
		if (issueAccord != null) {
			if (id == null || issueAccord == null
					|| issueAccord.getScore() == null
					|| issueAccord.getType() == null
					|| issueAccord.getOrgId() == null
					|| issueAccord.getInfo() == null
					|| issueAccord.getLogId() == null) {
				throw new BusinessValidationException("参数错误");
			}
			int length = issueAccord.getScore().length;
			if (length != issueAccord.getType().length
					|| length != issueAccord.getOrgId().length
					|| length != issueAccord.getInfo().length
					|| length != issueAccord.getLogId().length) {
				throw new BusinessValidationException("参数个数错误");
			}
			if (issueAccord.getInfo().length > 500) {
				throw new BusinessValidationException("打分原因字数不能超过500字");
			}
			IssueNew issueNew = getFullIssueByIssueId(id);
			if (issueNew == null || issueNew.getSerialNumber() == null) {
				throw new BusinessValidationException("参数错误");
			}
			try {
				for (int i = 0; i < length; i++) {
					if (issueAccord.getScore()[i] == 0) {
						regradedPointService
								.deleteRegradedPointByLogId(issueAccord
										.getLogId()[i]);
						continue;
					}
					regradedPointService.deleteRegradedPointByLogId(issueAccord
							.getLogId()[i]);
					WorkContacterRegradedReason regradedReason = new WorkContacterRegradedReason();
					regradedReason.setContent(issueAccord.getInfo()[i]);
					regradedReason.setIssueSerialNumber(issueNew
							.getSerialNumber());
					if (issueAccord.getType()[i].equals(1)) {
						regradedPointService.bonusPoints(
								organizationDubboService
										.getSimpleOrgById(issueAccord
												.getOrgId()[i]),
								RegradedType.REGRADEDBYPERSON, regradedReason,
								issueAccord.getScore()[i], CalendarUtil
										.now("yyyy-MM-dd HH:mm:ss"),
								issueAccord.getLogId()[i]);
					} else {
						regradedPointService.deductPoints(
								organizationDubboService
										.getSimpleOrgById(issueAccord
												.getOrgId()[i]),
								RegradedType.REGRADEDBYPERSON, regradedReason,
								issueAccord.getScore()[i], CalendarUtil
										.now("yyyy-MM-dd HH:mm:ss"),
								issueAccord.getLogId()[i]);
					}
				}
			} catch (Exception e) {
				throw new ServiceValidationException("评分失败", e);
			}
		}
		IssueNew result = getFullIssueByIssueId(id);
		if (Boolean.valueOf(globalSettingService
				.getGlobalValue(GlobalSetting.IS_TQSEARCH_OPEN))) {
			List<IssueStep> issueSteps = issueProcessDao
					.findIssueStepsByIssueId(result.getId());
			if (issueSteps != null && issueSteps.size() > 0) {
				for (IssueStep issueStep : issueSteps) {
					Organization org = organizationDubboService.getSimpleOrgById(issueStep.getSource().getId());
					issueStep.setSource(org);
					tqSolrSearchCommonOperate.commonOperate(
							IssueSolrDocumentConvert
									.createIssueSolrDocumentForEvaluate(result,
											issueStep, issueEvaluate
													.getEvaluateType()
													.longValue()),
							TqSolrSearchOperateType.ADD_OR_UPDATE);
				}
			}
		}
		return result;
	}

	@Override
	public PageInfo<IssueViewObject> findJurisdictionAuditDelay(Long orgId,
			Long orgLevel, Long functionalOrgType, Integer page, Integer rows,
			String sidx, String sord, int orgCodeFindLevel, Long searchOrgId,
			Long issueType) {
		// 快速检索的组织机构的code
		String searchOrgCode = findOrgCodeByOrgId(searchOrgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		PageInfo<IssueViewObject> pageInfo = issueDao
				.findJurisdictionAuditDelay(org, orgLevel, functionalOrgType,
						page, rows, sidx, sord, orgCodeFindLevel, searchOrgId,
						searchOrgCode, issueType);
		for (IssueViewObject issueViewObject : pageInfo.getResult()) {
			issueOvertimeHelper.fillEaringWarnField(issueViewObject);
		}
		/** 待审核的没有展示功能 不需要去拼接事件类型 */
		// loadIssueOccurOrgAndCurrentOrgAndIssueTypes(pageInfo);
		return pageInfo;
	}

	@Override
	public IssueEvaluate getIssueEvaluateById(Long id) {
		return issueDao.getIssueEvaluateById(id);
	}

	@Override
	public Integer getIssueStepDelayWorkDaysById(Long stepId) {
		return issueDao.getIssueStepDelayWorkDaysById(stepId);
	}

	@Override
	public Integer getIssueStepCountByIssueId(Long issueId) {
		return issueProcessDao.getIssueStepCountByIssueId(issueId);
	}

	@Override
	public List<IssueAttachFile> getDocfilesByIdAndModuleKey(Long issueId,
			String moduleType, String fileType) {
		if (issueId == null || moduleType == null || moduleType.equals("")
				|| fileType == null || fileType.equals("")) {
			throw new BusinessValidationException("参数错误");
		}
		return issueDao.getDocfilesByIdAndModuleKey(issueId, moduleType,
				fileType);
	}

	@Override
	public Integer findIssueExistForMobile(IssueNew issue) {
		Integer countVal = 0;
		try {
			if (issue == null || issue.getUniqueIdForMobile() == null
					|| "".equals(issue.getUniqueIdForMobile())
					|| issue.getOccurOrg() == null
					|| issue.getOccurOrg().getId() == null) {
				throw new BusinessValidationException("对象或参数有误");
			}
			countVal = issueDao.findIssueExistForMobile(issue);

		} catch (Exception e) {
			throw new ServiceValidationException("查询数据出错", e);
		}
		return countVal;
	}

	@Override
	public void updateEmergencylevelByIssueStepId(IssueStep issueStep) {
		if (issueStep == null || issueStep.getId() == null
				|| issueStep.getEmergencyLevel() == null) {
			throw new BusinessValidationException("参数有误");
		}
		issueProcessDao.updateEmergencylevelByIssueStepId(issueStep);
	}

	/**
	 * 统计已办的事件数量
	 * 
	 * @param map
	 * @return
	 */
	public int getMyDoneCount(Organization organization) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", organization.getId());
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("issueTag", IssueTag.DONE_ISSUE);
		map.put("orgCode", organization.getOrgInternalCode());
		map.put("orgLevel", organization.getOrgLevel().getId());
		map.put("leaderView", "1");
		map.put("orgType", organization.getOrgType().getId());
		return issueDao.getMyDoneCount(map);
	}

	/**
	 * 查询待验证的数据
	 * 
	 * @param map
	 * @return
	 */
	public int getJurisdictionsVerification(Organization organization) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", organization.getId());
		map.put("completeCode", IssueState.ISSUEVERIFICATION_CODE);
		map.put("issueTag", IssueTag.VERIFICATION_ISSUE);
		map.put("orgCode", organization.getOrgInternalCode());
		map.put("orgLevel", organization.getOrgLevel().getId());
		map.put("leaderView", "1");
		map.put("orgType", organization.getOrgType().getId());
		return issueDao.getJurisdictionsVerification(map);

	}

	/**
	 * 查询待办的数量
	 * 
	 * @param map
	 * @return
	 */
	public int getJurisdictionsNeedDoCount(Organization organization) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", organization.getId());
		map.put("completeCode", IssueState.STEPCOMPLETE_CODE);
		map.put("issueTag", IssueTag.NEEDDO_ISSUE);
		map.put("orgCode", organization.getOrgInternalCode());
		map.put("orgLevel", organization.getOrgLevel().getId());
		map.put("leaderView", "1");
		map.put("orgType", organization.getOrgType().getId());
		return issueDao.getJurisdictionsNeedDoCount(map);
	}

	private String report12345(IssueNew issue, Long locationId, Long newStepId) {
		locationId = locationId < 0 ? locationId * -1 : locationId;
		Map issueMap = IssueToCMSUtil.issueToMap(issue, locationId, newStepId);
		String result = IssueToCMSUtil.post(
				GridProperties.CMS_CALLCENTER_ISSUE_DEMAND, issueMap);
		if (result != null) {
			JSONObject jsonObj = JSONObject.fromObject(result);
			if (jsonObj.has("demandsCode")) {
				return jsonObj.getString("demandsCode");
			}
		}
		return "null";
	}

	private String findOrgCodeByOrgId(Long orgId) {
		String orgCode = "";
		if (orgId != null) {
			orgCode = organizationDubboService.getOrgInternalCodeById(orgId);
		}
		return orgCode;
	}

	public void updateEventStateByIssueId(Long issueId) {
		if (issueId == null) {
			throw new BusinessValidationException("参数有误");
		}
		issueDao.updateEventStateByIssueId(issueId);
	}

	private PageInfo<IssueViewObject> createPageInfoFromSolr(Integer page,
			Integer rows, String sidx, String sord, StringBuffer query) {
		TqSolrDocumentList documents = tqSearchDubboService.searchForSolrIndex(
				new IssueSearchSolrParams((page - 1) * rows, rows, sidx, sord)
						.setSolrQuery(query.toString()),
				TqSolrSearchType.ISSUE_TYPE);
		PageInfo<IssueViewObject> pageInfo = new PageInfo<IssueViewObject>(
				page, rows, documents.getNumFound(), null);
		SolrResultRelationalObject.conversionPageInfoResult(documents,
				pageInfo, IssueViewObject.class, TqSolrSearchType.ISSUE_TYPE);
		return pageInfo;
	}

	private void createSolrQuery(StringBuffer query, Long orgLevel,
			Long searchOrgId, Long issueType, Long sourceType,
			Long functionalorgType, String searchOrgCode, String targetOrgCode) {
		if (issueType != null) {
			query.append(" AND issueTypedDomainId:" + issueType);
		}
		if (sourceType != null) {
			query.append(" AND sourceKind:" + sourceType);
		}
		if (orgLevel != null) {
			query.append(" AND targetOrgLevel:" + orgLevel);
			if (searchOrgId == null) {
				query.append(" AND targetInternalCode:" + targetOrgCode + "*");
			} else {
				query.append(" AND targetInternalCode:" + searchOrgCode + "*");
			}
			if (functionalorgType == null) {
				query.append(" AND targetOrgFunctionalOrgType:0");
			} else {
				query.append(" AND targetOrgFunctionalOrgType:"
						+ functionalorgType);
			}
		} else {
			query.append(" AND targetInternalCode:" + targetOrgCode);
		}
	}

	private void createSolrQueryForCreateOrg(StringBuffer query, Long orgLevel,
			Long searchOrgId, Long issueType, Long sourceType,
			Long functionalorgType, String searchOrgCode, String targetOrgCode) {
		if (issueType != null) {
			query.append(" AND issueTypedDomainId:" + issueType);
		}
		if (sourceType != null) {
			query.append(" AND sourceKind:" + sourceType);
		}
		if (orgLevel != null) {
			query.append(" AND createOrgLevel:" + orgLevel);
			if (searchOrgId == null) {
				query.append(" AND createOrginternalCode:" + targetOrgCode
						+ "*");
			} else {
				query.append(" AND createOrginternalCode:" + searchOrgCode
						+ "*");
			}
			if (functionalorgType == null) {
				query.append(" AND createOrgFunctionalOrgType:0");
			} else {
				query.append(" AND createOrgFunctionalOrgType:"
						+ functionalorgType);
			}
		} else {
			query.append(" AND createOrginternalCode:" + targetOrgCode);
		}
	}
	private void createSolrQueryForCurrentOrg(StringBuffer query, Long orgLevel,
			Long searchOrgId, Long issueType, Long sourceType,
			Long functionalorgType, String searchOrgCode, String targetOrgCode) {
		if (issueType != null) {
			query.append(" AND issueTypedDomainId:" + issueType);
		}
		if (sourceType != null) {
			query.append(" AND sourceKind:" + sourceType);
		}
		if (orgLevel != null) {
			query.append(" AND currentOrgLevel:" + orgLevel);
			if (searchOrgId == null) {
				query.append(" AND currentOrginternalCode:" + targetOrgCode
						+ "*");
			} else {
				query.append(" AND currentOrginternalCode:" + searchOrgCode
						+ "*");
			}
			if (functionalorgType == null) {
				query.append(" AND currentOrgFunctionalType:0");
			} else {
				query.append(" AND currentOrgFunctionalType:"
						+ functionalorgType);
			}
		} else {
			query.append(" AND currentOrginternalCode:" + targetOrgCode);
		}
	}
}

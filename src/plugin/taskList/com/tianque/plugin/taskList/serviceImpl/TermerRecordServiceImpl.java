package com.tianque.plugin.taskList.serviceImpl;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinygroup.commons.tools.StringUtil;

import com.tianque.core.systemLog.util.ModuleConstants;
import com.tianque.core.util.DialogMode;
import com.tianque.core.util.FileUtil;
import com.tianque.core.util.GridProperties;
import com.tianque.core.util.StoredFile;
import com.tianque.core.util.ThreadVariable;
import com.tianque.core.validate.ValidateResult;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.User;
import com.tianque.domain.property.OrganizationType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.exception.base.ServiceValidationException;
import com.tianque.plugin.taskList.constants.Constants;
import com.tianque.plugin.taskList.dao.TermerRecordDao;
import com.tianque.plugin.taskList.domain.TaskListAttachFile;
import com.tianque.plugin.taskList.domain.TermerRecord;
import com.tianque.plugin.taskList.domain.TermerRecordVo;
import com.tianque.plugin.taskList.service.GridConfigTaskService;
import com.tianque.plugin.taskList.service.TaskListAttachFileService;
import com.tianque.plugin.taskList.service.TermerRecordService;
import com.tianque.plugin.taskList.validate.TermerRecordValidatorImpl;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.userAuth.api.PermissionDubboService;
import com.tianque.util.IdCardUtil;

@Transactional
@Service("termerRecordService")
public class TermerRecordServiceImpl implements TermerRecordService {
	@Autowired
	private TermerRecordDao termerRecordDao;
	@Autowired
	private TermerRecordValidatorImpl termerRecordValidator;
	@Autowired
	private OrganizationDubboService organizationDubboService;
	@Autowired
	private TaskListAttachFileService taskListAttachFileService;
	@Autowired
	private PropertyDictService propertyDictService;
	@Autowired
	private GridConfigTaskService configTaskService;
	@Autowired
	private PermissionDubboService permissionDubboService;
	
	@Override
	public TermerRecord addTermerRecord(TermerRecord termerRecord) {
		if (termerRecord == null) {
			throw new BusinessValidationException("社区服刑人员记录信息为空，新增记录失败！");
		}
		if (termerRecord.getHasException() == null) {
			throw new BusinessValidationException("有无异常不能为空");
		}
		if (termerRecord.getHasException() == 1
				&& StringUtils.isBlank(termerRecord.getExceptionSituationInfo())) {
			throw new BusinessValidationException("有异常时，异常情况不能为空");
		}
		termerRecordValidator(termerRecord);
		try {
			fillTermerRecord(termerRecord, DialogMode.ADD_MODE);
			//把帮扶人员的id和-去掉,例：23-asdfasf,22-sdfsdf变成asdfasf,sdfsdf
			if(com.tianque.core.util.StringUtil.isStringAvaliable(termerRecord.getHelpPeople())){
				fillDruggyHelpPeople(termerRecord);
			}
			String[] attachFileNames = termerRecord.getAttachFileNames();
			TermerRecord termerRecordTemp = termerRecordDao.addTermerRecord(termerRecord);
			addAttachFile(attachFileNames, termerRecordTemp.getId());
			return termerRecordDao.getTermerRecordById(termerRecordTemp.getId());
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类TermerRecordServiceImpl的addTermerRecord方法出现异常，原因：", "社区服刑人员记录信息新增出现错误", e);
		}
	}
	//把帮扶人员的id和-去掉
	private void fillDruggyHelpPeople(TermerRecord termerRecord){
		String helpPeople=termerRecord.getHelpPeople();
		//手机新增是没有-的，那边是直接传拼好的，直接返回即可
		if(helpPeople.indexOf("-")<=0){
			return;
		}
		if(helpPeople.indexOf(",")<=0){
			termerRecord.setHelpPeople(helpPeople.split("-")[1]);
			return;
		}
		String[] array=helpPeople.split(",");
		String str="";
		for(int i=0;i<array.length;i++){
			str=str+","+array[i].split("-")[1];
		}
		termerRecord.setHelpPeople(str.substring(1));
	}
	@Override
	public TermerRecord getTermerRecordById(Long id) {
		if (id == null) {
			throw new BusinessValidationException("参数为空，获取社区服刑人员记录信息失败！");
		}
		try {
			TermerRecord termerRecord = termerRecordDao.getTermerRecordById(id);
			fillTermerRecord(termerRecord, DialogMode.VIEW_MODE);
			termerRecord.setTaskListAttachFiles(taskListAttachFileService
					.queryTaskListAttachFilesByBusinessId(id, Constants.TERMERRECORD_KEY));
			//判断权限，有权限不隐藏
			if(permissionDubboService.
					isUserHasPermission(ThreadVariable.getUser().getId(), "isTermerRecordNotHidCard")){
				return termerRecord;
			}
			termerRecord.setIdCard(IdCardUtil.hiddenIdCard(termerRecord.getIdCard()));
			return termerRecord;
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类TermerRecordServiceImpl的getTermerRecordById方法出现异常，原因：", "获取社区服刑人员记录信息出现错误", e);
		}
	}

	@Override
	public PageInfo<TermerRecord> findTermerRecords(TermerRecordVo termerRecordVo, Integer pageNum,
			Integer pageSize, String sidx, String sord) {
		if (termerRecordVo == null || pageNum == null || pageSize == null
				|| termerRecordVo.getOrganization() == null
				|| termerRecordVo.getOrganization().getId() == null) {
			throw new BusinessValidationException("参数为空，获取社区服刑人员记录信息失败！");
		}
		try {

			PropertyDict orgTypeDict = propertyDictService
					.findPropertyDictByDomainNameAndDictDisplayName(
							PropertyTypes.ORGANIZATION_TYPE, OrganizationType.FUNCTION_KEY);
			Organization org = organizationDubboService.getFullOrgById(termerRecordVo
					.getOrganization().getId());
			fillSearchArgs(termerRecordVo);
			if (isGridConfigTaskSearch(termerRecordVo)) {
				if (!StringUtil.isEmpty(termerRecordVo.getMode())
						&& "true".equals(termerRecordVo.getMode())) {
					termerRecordVo.setFunOrgId(org.getId());
					termerRecordVo.setMode("gridConfigTask");
				}
				termerRecordVo.getOrganization().setOrgInternalCode(null);
			} else if (orgTypeDict.getId().equals(org.getOrgType().getId())) {
				termerRecordVo.getOrganization()
						.setOrgInternalCode(
								organizationDubboService.getOrgInternalCodeById(org.getParentOrg()
										.getId()));
			} else {
				termerRecordVo.getOrganization().setOrgInternalCode(org.getOrgInternalCode());
			}
			PageInfo<TermerRecord>pageInfo=termerRecordDao.findTermerRecords(termerRecordVo, pageNum, pageSize, sidx, sord);
			//隐藏身份证中间4位
			pageInfo=hiddenIdCard(pageInfo);
			return pageInfo;
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类TermerRecordServiceImpl的findTermerRecords方法出现异常，原因：", "获取社区服刑人员记录信息出现错误", e);
		}
	}
	//隐藏身份证中间4位
	private PageInfo<TermerRecord> hiddenIdCard(PageInfo<TermerRecord> pageInfo){
		//判断权限，有权限不隐藏
		if(permissionDubboService.
				isUserHasPermission(ThreadVariable.getUser().getId(), "isMentalTaskNotHidCard")){
			return pageInfo;
		}
		List<TermerRecord>list=pageInfo.getResult();
		int index=0;
		for (TermerRecord termerRecord:list) {
			termerRecord.setIdCard(IdCardUtil.hiddenIdCard(termerRecord.getIdCard()));
			list.set(index, termerRecord);
			index++;
		}
		pageInfo.setResult(list);
		return pageInfo;
	}
	//判断是否为网格配置后的查询
	private boolean isGridConfigTaskSearch(TermerRecordVo termerRecordVo) {
		Long funId = termerRecordVo.getOrganization().getId();
		if (termerRecordVo.getMode() == null) {
			return false;
		}
		if (termerRecordVo.getMode().equals("gridConfigTask")
				&& funId.equals(ThreadVariable.getOrganization().getId())) {
			return true;
		}
		if (termerRecordVo.getMode().equals("true") && configTaskService.isHasGridTaskList(funId,Constants.TASKLIST_KEY)) {
			return true;
		}
		return false;
	}

	@Override
	public TermerRecord updateTermerRecord(TermerRecord termerRecord) {
		if (termerRecord == null) {
			throw new BusinessValidationException("参数为空，获取社区服刑人员记录信息失败！");
		}
		termerRecordValidator(termerRecord);
		try {
			String[] attachFileNames = termerRecord.getAttachFileNames();
			termerRecord = termerRecordDao.updateTermerRecord(termerRecord);
			updateAttachFile(attachFileNames, termerRecord.getId());
			return termerRecordDao.getTermerRecordById(termerRecord.getId());
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类TermerRecordServiceImpl的updateTermerRecord方法出现异常，原因：", "更新社区服刑人员记录信息出现错误", e);
		}
	}

	@Override
	public Integer deleteTermerRecords(List<Long> ids) {
		if (ids == null || ids.size() < 1) {
			throw new BusinessValidationException("参数为空，获取社区服刑人员记录信息失败！");
		}
		try {
			taskListAttachFileService.deleteTaskListAttachFilesByBusinessIds(ids,
					Constants.TERMERRECORD_KEY);
			return termerRecordDao.deleteTermerRecords(ids);
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类TermerRecordServiceImpl的deleteTermerRecord方法出现异常，原因：", "删除社区服刑人员记录信息出现错误", e);
		}
	}

	@Override
	public List<TermerRecord> findTermerRecordsByName(TermerRecordVo termerRecordVo) {
		if (termerRecordVo == null || StringUtil.isEmpty(termerRecordVo.getName())
				|| termerRecordVo.getOrganization() == null
				|| termerRecordVo.getOrganization().getId() == null) {
			throw new BusinessValidationException("参数为空，获取社区服刑人员记录信息失败！");
		}
		try {
			fillSearchArgs(termerRecordVo);
			return termerRecordDao.findTermerRecordsByName(termerRecordVo);
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类TermerRecordServiceImpl的findTermerRecordsByName方法出现异常，原因：",
					"查询社区服刑人员记录信息出现错误", e);
		}
	}

	private void termerRecordValidator(TermerRecord termerRecord) {
		ValidateResult dataValidateResult = termerRecordValidator.validate(termerRecord);
		if (dataValidateResult.hasError()) {
			throw new BusinessValidationException(dataValidateResult.getErrorMessages());
		}
	}

	private void fillSearchArgs(TermerRecordVo termerRecordVo) {
		Organization organization = organizationDubboService.getSimpleOrgById(termerRecordVo
				.getOrganization().getId());
		termerRecordVo.setOrganization(organization);
	}

	private void fillTermerRecord(TermerRecord termerRecord, String type) {
		Organization organization = organizationDubboService.getFullOrgById(termerRecord
				.getOrganization().getId());
		String fullOrgName = "";
		if (organization != null) {
			fullOrgName = organization.getFullOrgName();
		}
		String[] strs = fullOrgName.split(ModuleConstants.SEPARATOR);
		if (strs.length > 2) {
			fullOrgName = strs[strs.length - 2] + ModuleConstants.SEPARATOR + strs[strs.length - 1];
		}
		organization.setFullOrgName(fullOrgName);
		termerRecord.setOrganization(organization);
		User user = ThreadVariable.getUser();
		if (user != null && DialogMode.ADD_MODE.equals(type)) {
			termerRecord.setGridMemberPhone(user.getMobile());
		}
		//termerRecord.setSignDate(CalendarUtil.now());
	}

	private void addAttachFile(String[] attachFileNames, Long objectId) {
		if (attachFileNames != null && attachFileNames.length > 0) {
			TaskListAttachFile taskListAttachFile = null;
			StoredFile storedFile = null;
			for (String attachFileName : attachFileNames) {
				if (attachFileName.charAt(0) == ',') {
					attachFileName = attachFileName.substring(1);
					try {
						storedFile = FileUtil.copyTmpFileToStoredFile(attachFileName,
								GridProperties.TASKLIST_PATH);
					} catch (Exception e) {
						e.printStackTrace();
					}
					taskListAttachFile = new TaskListAttachFile();
					taskListAttachFile.setBusinessId(objectId);
					taskListAttachFile.setPhysicsFullFileName(storedFile.getStoredFilePath()
							+ File.separator + storedFile.getStoredFileName());
					taskListAttachFile.setFileName(attachFileName);
					taskListAttachFile.setModuleKey(Constants.TERMERRECORD_KEY);
					taskListAttachFileService.addTaskListAttachFile(taskListAttachFile);
				}
			}
		}
	}

	private void updateAttachFile(String[] attachFileNames, Long objectId) {
		if (attachFileNames != null && attachFileNames.length > 0) {
			taskListAttachFileService.deleteTaskListAttachFilesByBusinessId(objectId,
					Constants.TERMERRECORD_KEY);
			addAttachFile(attachFileNames, objectId);
		}
	}
}
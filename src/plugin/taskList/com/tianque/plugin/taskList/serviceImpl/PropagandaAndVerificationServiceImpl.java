package com.tianque.plugin.taskList.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinygroup.commons.tools.StringUtil;

import com.tianque.core.util.CalendarUtil;
import com.tianque.core.util.ThreadVariable;
import com.tianque.core.validate.DomainValidator;
import com.tianque.core.validate.ValidateResult;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.property.OrganizationType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.exception.base.ServiceValidationException;
import com.tianque.plugin.taskList.constant.TaskConstant;
import com.tianque.plugin.taskList.constants.Constants;
import com.tianque.plugin.taskList.dao.PropagandaAndVerificationDao;
import com.tianque.plugin.taskList.domain.PropagandaAndVerification;
import com.tianque.plugin.taskList.domain.PropagandaAndVerificationVo;
import com.tianque.plugin.taskList.service.GridConfigTaskService;
import com.tianque.plugin.taskList.service.PropagandaAndVerificationService;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.userAuth.api.PermissionDubboService;
import com.tianque.util.IdCardUtil;

/**
 * 宣传核查模块service层实现
 * 
 * @author GAOHU
 *
 */
@Transactional
@Service("propagandaAndVerificationService")
public class PropagandaAndVerificationServiceImpl implements
		PropagandaAndVerificationService {

	@Autowired
	private PropagandaAndVerificationDao propagandaAndVerificationDao;

	@Autowired
	private OrganizationDubboService organizationDubboService;
	
	@Autowired
	private PermissionDubboService permissionDubboService;
	
	@Autowired
	private PropertyDictService propertyDictService;

	@Qualifier("propagandaAndVerificationValidator")
	@Autowired
	private DomainValidator<PropagandaAndVerification> domainValidator;

	@Autowired
	private GridConfigTaskService configTaskService;
	
	@Override
	public PropagandaAndVerification getPropagandaAndVerificationById(Long id) {

		if (id == null) {
			throw new BusinessValidationException("参数异常，请稍后重试！");
		}
		try {
			PropagandaAndVerification verification=propagandaAndVerificationDao
					.getPropagandaAndVerificationById(id);
			//判断权限，有权限不隐藏
			if(permissionDubboService.
					isUserHasPermission(ThreadVariable.getUser().getId(), "isPropagandaNotHidCard")){
				return verification;
			}
			verification.setIdCard(IdCardUtil.hiddenIdCard(verification.getIdCard()));
			return verification;

		} catch (Exception e) {
			throw new ServiceValidationException(
					"类PropagandaAndVerificationServiceImpl的getPropagandaAndVerificationById方法出现异常，原因：",
					"获取宣传核查数据时出现错误", e);
		}

	}

	@Override
	public PropagandaAndVerification addPropagandaAndVerification(
			PropagandaAndVerification propagandaAndVerification) {
		if (propagandaAndVerification == null) {
			throw new BusinessValidationException("参数异常，请稍后重试！");
		}
		propagandaAndVerification.setCellName(ThreadVariable.getUser()
				.getName());
		propagandaAndVerification.setTelephone(ThreadVariable.getUser()
				.getMobile());
		ValidateResult propagandaAndVerificationValidator = domainValidator.validate(propagandaAndVerification);
		if (propagandaAndVerificationValidator.hasError()) {
			throw new BusinessValidationException(propagandaAndVerificationValidator.getErrorMessages());
		}
		try {
//			propagandaAndVerificationValidate(propagandaAndVerification);
			autoFillOrganizationInternalCode(propagandaAndVerification);
			propagandaAndVerification.setOccurrenceDate(CalendarUtil.now());
			return propagandaAndVerificationDao
					.addPropagandaAndVerification(propagandaAndVerification);

		} catch (Exception e) {
			throw new ServiceValidationException(
					"类PropagandaAndVerificationServiceImpl的addPropagandaAndVerification方法出现异常，原因：",
					"新增宣传核查数据时出现错误", e);
		}
	}

	@Override
	public void deletePropagandaAndVerification(List<Long> ids) {
		if (ids == null || ids.size()==0) {
			throw new BusinessValidationException("参数异常，请稍后重试！");
		}
		try {
			propagandaAndVerificationDao.deletePropagandaAndVerification(ids);

		} catch (Exception e) {
			throw new ServiceValidationException(
					"类PropagandaAndVerificationServiceImpl的deletePropagandaAndVerification方法出现异常，原因：",
					"删除宣传核查数据时出现错误", e);
		}

	}

	@Override
	public PropagandaAndVerification updatePropagandaAndVerification(
			PropagandaAndVerification propagandaAndVerification) {
		if (propagandaAndVerification == null) {
			throw new BusinessValidationException("参数异常，请稍后重试！");
		}
		try {

			return propagandaAndVerificationDao
					.updatePropagandaAndVerification(propagandaAndVerification);

		} catch (Exception e) {
			throw new ServiceValidationException(
					"类PropagandaAndVerificationServiceImpl的updatePropagandaAndVerification方法出现异常，原因：",
					"更新宣传核查数据时出现错误", e);
		}

	}

	@Override
	public PageInfo<PropagandaAndVerification> searchPropagandaAndVerification(
			PropagandaAndVerificationVo propagandaAndVerificationVo,
			Integer pageNum, Integer pageSize, String sortField, String order) {
		if (propagandaAndVerificationVo == null ||propagandaAndVerificationVo.getOrganization()==null || propagandaAndVerificationVo.getOrganization().getId()==null) {
			throw new BusinessValidationException("查询条件为空，请稍后重试！");
		}
		try {
			PropertyDict orgTypeDict = propertyDictService
						.findPropertyDictByDomainNameAndDictDisplayName(
								PropertyTypes.ORGANIZATION_TYPE,
								OrganizationType.FUNCTION_KEY);
			Organization org=organizationDubboService.getFullOrgById(propagandaAndVerificationVo.getOrganization()
					.getId());
			if(org==null){
				throw new BusinessValidationException("未获得正确的组织机构参数！");
			}
			if(isGridConfigTaskSearch(propagandaAndVerificationVo)){
				if(!StringUtil.isEmpty(propagandaAndVerificationVo.getMode())&&
						"true".equals(propagandaAndVerificationVo.getMode())){
					propagandaAndVerificationVo.setFunOrgId(org.getId());
					propagandaAndVerificationVo.setMode("gridConfigTask");
				}
				propagandaAndVerificationVo.setOrgInternalCode(null);
			}else if(orgTypeDict.getId().equals(org.getOrgType().getId())){
				propagandaAndVerificationVo.setOrgInternalCode(organizationDubboService
							.getOrgInternalCodeById(org.getParentOrg().getId()));
			}else{
				propagandaAndVerificationVo.setOrgInternalCode(org.getOrgInternalCode());
			}
			PageInfo<PropagandaAndVerification>pageInfo=propagandaAndVerificationDao
					.searchPropagandaAndVerification(
							propagandaAndVerificationVo, pageNum, pageSize,
							sortField, order);
			//隐藏身份证中间4位
			pageInfo=hiddenIdCard(pageInfo);
			return pageInfo;

		} catch (Exception e) {
			throw new ServiceValidationException(
					"类PropagandaAndVerificationServiceImpl的searchPropagandaAndVerification方法出现异常，原因：",
					"查询安全隐患时出现错误", e);
		}
	}
	//隐藏身份证中间4位
	private PageInfo<PropagandaAndVerification> hiddenIdCard(PageInfo<PropagandaAndVerification> pageInfo){
		//判断权限，有权限不隐藏
		if(permissionDubboService.
				isUserHasPermission(ThreadVariable.getUser().getId(), "isPropagandaNotHidCard")){
			return pageInfo;
		}
		List<PropagandaAndVerification>list=pageInfo.getResult();
		int index=0;
		for (PropagandaAndVerification verification:list) {
			verification.setIdCard(IdCardUtil.hiddenIdCard(verification.getIdCard()));
			list.set(index, verification);
			index++;
		}
		pageInfo.setResult(list);
		return pageInfo;
	}
	//判断是否为网格配置后的查询
	private boolean isGridConfigTaskSearch(PropagandaAndVerificationVo propagandaAndVerificationVo){
		Long funId=propagandaAndVerificationVo.getOrganization().getId();
		if(propagandaAndVerificationVo.getMode()==null){
			return false;
		}
		if(propagandaAndVerificationVo.getMode().equals("gridConfigTask")&&
				funId.equals(ThreadVariable.getOrganization().getId())){
			return true;
		}
		if(propagandaAndVerificationVo.getMode().equals("true")&&configTaskService.isHasGridTaskList(funId,Constants.TASKLIST_KEY)){
			return true;
		}
		return false;
	}
		
	private void autoFillOrganizationInternalCode(
			PropagandaAndVerification propagandaAndVerification) {
		Organization org = organizationDubboService
				.getSimpleOrgById(propagandaAndVerification.getOrganization()
						.getId());
		if (org == null) {
			throw new BusinessValidationException("找不到指定的网格");
		}
		propagandaAndVerification.setOrgInternalCode(org.getOrgInternalCode());
	}

	private void propagandaAndVerificationValidate(
			PropagandaAndVerification propagandaAndVerification) {
		ValidateResult propagandaAndVerificationValidator = domainValidator
				.validate(propagandaAndVerification);
		if (propagandaAndVerificationValidator.hasError()) {
			throw new BusinessValidationException(
					propagandaAndVerificationValidator.getErrorMessages());
		}
	}

	@Override
	public PropagandaAndVerification updatePropagandaAndVerificationSignDetail(
			PropagandaAndVerification propagandaAndVerification) {
		if (propagandaAndVerification == null) {
			throw new BusinessValidationException("参数异常，请稍后重试！");
		}
		try {
			propagandaAndVerification.setIshandle(TaskConstant.HANDLE_STATE);
			propagandaAndVerification.setSignDate(CalendarUtil.now());
			propagandaAndVerification.setSignUserName(ThreadVariable.getUser()
					.getName());
			return propagandaAndVerificationDao
					.updatePropagandaAndVerificationSignDetail(propagandaAndVerification);

		} catch (Exception e) {
			throw new ServiceValidationException("更新签收时出现错误", e);
		}
	}

	@Override
	public List<PropagandaAndVerification> findPropagandaAndVerificationByName(
			PropagandaAndVerificationVo propagandaAndVerificationVo) {
		if(propagandaAndVerificationVo == null || StringUtil.isEmpty(propagandaAndVerificationVo.getName())
				|| propagandaAndVerificationVo.getOrganization() == null || propagandaAndVerificationVo.getOrganization().getId() == null){
			throw new BusinessValidationException("参数为空，获取宣传核查记录信息失败！");
		}
		try {
			fillSearchArgs(propagandaAndVerificationVo);
			return propagandaAndVerificationDao.findPropagandaAndVerificationByName(propagandaAndVerificationVo);
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类PropagandaAndVerificationServiceImpl的findPropagandaAndVerificationByName方法出现异常，原因：", "查询宣传核查记录信息出现错误",
					e);
		}
	}
	
	private void fillSearchArgs(PropagandaAndVerificationVo propagandaAndVerificationVo){
		Organization organization = organizationDubboService.getSimpleOrgById(
				propagandaAndVerificationVo.getOrganization().getId());
		propagandaAndVerificationVo.setOrganization(organization);
	}
	
	
	

}

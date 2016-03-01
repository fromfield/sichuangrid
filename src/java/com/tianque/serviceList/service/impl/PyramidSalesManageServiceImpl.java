/**
 * 
 */
package com.tianque.serviceList.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinygroup.commons.tools.StringUtil;

import com.tianque.controller.ControllerHelper;
import com.tianque.core.systemLog.util.ModuleConstants;
import com.tianque.core.util.ThreadVariable;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.User;
import com.tianque.domain.property.OrganizationType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.exception.base.ServiceValidationException;
import com.tianque.plugin.taskList.constants.Constants;
import com.tianque.plugin.taskList.service.GridConfigTaskService;
import com.tianque.serviceList.dao.PyramidSalesManageDao;
import com.tianque.serviceList.domain.DrugsSafty;
import com.tianque.serviceList.domain.PyramidSalesManage;
import com.tianque.serviceList.domain.Reply;
import com.tianque.serviceList.domain.ServiceListEnum;
import com.tianque.serviceList.domain.UnlicensedManage;
import com.tianque.serviceList.service.PyramidSalesManageService;
import com.tianque.serviceList.service.ReplyAttachService;
import com.tianque.serviceList.service.ReplyService;
import com.tianque.serviceList.service.ServiceListAttachService;
import com.tianque.serviceList.validater.PyramidSalesManageValidatorImpl;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.userAuth.api.PermissionDubboService;

@Service("pyramidSalesManageServiceImpl")
@Transactional
public class PyramidSalesManageServiceImpl implements PyramidSalesManageService{
	@Autowired 
	private PyramidSalesManageDao pyramidSalesManageDao;
	@Autowired
	private OrganizationDubboService organizationDubboService;
	@Autowired
	private ServiceListAttachService attachService;
	@Autowired
	private ReplyAttachService replyAttachService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private PyramidSalesManageValidatorImpl validatorImpl;
	@Autowired
	private PropertyDictService propertyDictService;
	@Autowired 
	private GridConfigTaskService configTaskService;
	@Autowired
	private PermissionDubboService permissionDubboService;
	private static final Integer TYPE=ServiceListEnum.getValue("pyramidSales");
	@Override
	public PyramidSalesManage addPyramidSalesManage(PyramidSalesManage info) {
		if (info == null) {
			throw new BusinessValidationException("新增失败！");
		}
		try {
			fillPyramidSalesManageOrg(info);
			info.setTelephone(ThreadVariable.getUser().getMobile());
			String[] attachFileNames = info.getAttachFileNames();
			if(info.getIsSign()==null){
				info.setIsSign(0);
			}
			if(info.getIsSign()==null){
				info.setIsReply(0);
			}
			validatorImpl.validatorPyramidSalesManage(info);
			info= pyramidSalesManageDao.add(info);
			attachService.addServiceListAttch(attachFileNames, info.getId(),TYPE);
			return info;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceValidationException("PyramidSalesManageServiceImpl的addPyramidSalesManage方法出错，原因：",
					"新增信息不全", e);
		}
	}
	
	@Override
	public PageInfo<PyramidSalesManage> getPyramidSalesManageListByQuery(
			PyramidSalesManage pyramidSalesManage, Integer page, Integer rows,
			String sidx, String sord) {
		if(pyramidSalesManage==null){
			pyramidSalesManage=new PyramidSalesManage();
		}
		PropertyDict orgTypeDict = propertyDictService
				.findPropertyDictByDomainNameAndDictDisplayName(
						PropertyTypes.ORGANIZATION_TYPE,
						OrganizationType.FUNCTION_KEY);
		fillPyramidSalesManageOrg(pyramidSalesManage);
		if(isGridConfigTaskSearch(pyramidSalesManage)){
			if(!StringUtil.isEmpty(pyramidSalesManage.getMode())&&
					"true".equals(pyramidSalesManage.getMode())){
				pyramidSalesManage.setFunOrgId(pyramidSalesManage.getOrganization().getId());
				pyramidSalesManage.setMode("gridConfigService");
			}
			pyramidSalesManage.getOrganization().setOrgInternalCode(null);
		}else if(orgTypeDict.getId().equals(pyramidSalesManage.getOrganization().getOrgType().getId())){
			pyramidSalesManage.getOrganization().setOrgInternalCode(organizationDubboService
						.getOrgInternalCodeById(pyramidSalesManage.getOrganization().getParentOrg().getId()));
		}else{
			pyramidSalesManage.getOrganization().setOrgInternalCode(pyramidSalesManage.getOrganization().getOrgInternalCode());
		}
		PageInfo<PyramidSalesManage> infos=pyramidSalesManageDao.findPagerBySearchVo(pyramidSalesManage, page, rows, sidx, sord);
		//设置督办时间
//		infos=supervise(infos);
		return infos;
	}
	//设置督办时间
	private PageInfo<PyramidSalesManage> supervise(PageInfo<PyramidSalesManage> infos ){
		List<PyramidSalesManage> pyramidSales= infos.getResult();
		for (PyramidSalesManage pyramidSalesManage:pyramidSales) {
//			propaganda.setSupervise(5);
		}
		return infos;
	}
	public void fillPyramidSalesManageOrg(PyramidSalesManage pyramidSalesManage) {
		if (pyramidSalesManage.getOrganization().getId() == null) {
			throw new BusinessValidationException("组织结构获取异常！");
		}
		Organization organization = organizationDubboService.getFullOrgById(pyramidSalesManage.getOrganization()
				.getId());
		String[] orgs = organization.getFullOrgName().split(ModuleConstants.SEPARATOR);
		if (orgs.length > 2) {
			String org = orgs[orgs.length - 2] + ModuleConstants.SEPARATOR + orgs[orgs.length - 1];
			organization.setFullOrgName(org);
		}
		pyramidSalesManage.setOrganization(organization);
	}
	
	@Override
	public PyramidSalesManage updatePyramidSalesManage(
			PyramidSalesManage pyramidSalesManage) {
		fillPyramidSalesManageOrg(pyramidSalesManage);
		validatorImpl.validatorPyramidSalesManage(pyramidSalesManage);
		String[] attachIds=pyramidSalesManage.getDeleteAttachIds().split(",");
		for (int i = 0; i < attachIds.length; i++) {
			if(!attachIds[i].equals("")){
				attachService.deleteServiceListAttch(Long.parseLong(attachIds[i]));
			}
		}
		attachService.addServiceListAttch(pyramidSalesManage.getAttachFileNames(), pyramidSalesManage.getId(),TYPE);
		return pyramidSalesManageDao.update(pyramidSalesManage);
	}

	@Override
	public void deletePyramidSalesManageByIds(String ids) {
		String[]id= ids.split(",");
		for (String objId:id){
			List<Reply>replies=replyService.getReplyByIdAndType(Long.parseLong(objId), TYPE);
			for (Reply reply:replies) {
				replyAttachService.deleteReplyAttchByIds(reply.getId(), TYPE);
			}
			replyService.deleteReplyByIds(Long.parseLong(objId), TYPE);
			pyramidSalesManageDao.delete(Long.parseLong(objId));
			attachService.deleteServiceListAttchByIds(Long.parseLong(objId),TYPE);
		}
	}

	@Override
	public PyramidSalesManage getPyramidSalesManageById(Long id) {
		PyramidSalesManage pyramidSalesManage=pyramidSalesManageDao.get(id);
		if(pyramidSalesManage!=null){
			pyramidSalesManage.setPhotos(attachService.getServiceListAttchByIdAndType(id, TYPE));
			User user = permissionDubboService.getFullUserByUerName(pyramidSalesManage.getCreateUser());
			if(user!=null){
				pyramidSalesManage.setCreateUser(user.getName());
			}
		}
		fillOrganization(pyramidSalesManage);
		return pyramidSalesManage;
	}

	public void fillOrganization(PyramidSalesManage pyramidSalesManage) {
		if (pyramidSalesManage.getOrganization().getId() == null) {
			throw new BusinessValidationException("组织结构获取异常！");
		}
		Organization organization = organizationDubboService.getFullOrgById(pyramidSalesManage
				.getOrganization().getId());
		organization = ControllerHelper.proccessRelativeOrgNameByOrg(organization, organizationDubboService);
		pyramidSalesManage.setOrganization(organization);
	}
	@Override
	public PyramidSalesManage signPyramidSalesManage(
			PyramidSalesManage pyramidSalesManage) {
		PyramidSalesManage fSafty=pyramidSalesManageDao.get(pyramidSalesManage.getId());
		fSafty.setUpdateDate(new Date());
		fSafty.setUpdateUser(pyramidSalesManage.getSignPeople());
		fSafty.setSignContent(pyramidSalesManage.getSignContent());
		fSafty.setSignDate(pyramidSalesManage.getSignDate());
		fSafty.setSignPeople(pyramidSalesManage.getSignPeople());
		fSafty.setIsSign(1);
		return pyramidSalesManageDao.update(fSafty);
	}

	@Override
	public PyramidSalesManage replyPyramidSalesManage(
			PyramidSalesManage pyramidSalesManage) {
		PyramidSalesManage fSafty=pyramidSalesManageDao.get(pyramidSalesManage.getId());
		fSafty.setIsReply(1);
		pyramidSalesManageDao.update(fSafty);
		Reply reply=pyramidSalesManage.getReply();
		reply.setServiceId(pyramidSalesManage.getId());
		reply.setServiceType(TYPE);
		reply=replyService.addReply(reply);
		replyAttachService.addReplyAttch(pyramidSalesManage.getAttachFileNames(), reply.getId(),TYPE);
		return pyramidSalesManage;
	}
	
	//判断是否为网格配置后的查询
			private boolean isGridConfigTaskSearch(PyramidSalesManage pyramidSalesManage){
				Long funId=pyramidSalesManage.getOrganization().getId();
				if(pyramidSalesManage.getMode()==null){
					return false;
				}
				if(pyramidSalesManage.getMode().equals("gridConfigService")&&
						funId.equals(ThreadVariable.getOrganization().getId())){
					return true;
				}
				if(pyramidSalesManage.getMode().equals("true")&&configTaskService.isHasGridTaskList(funId,Constants.TASKLIST_KEY)){
					return true;
				}
				return false;
			}
}

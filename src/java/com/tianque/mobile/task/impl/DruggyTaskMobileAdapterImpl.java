package com.tianque.mobile.task.impl;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tianque.core.util.ThreadVariable;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.property.OrganizationLevel;
import com.tianque.domain.property.OrganizationType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.mobile.base.BaseMobileAction;
import com.tianque.mobile.task.DruggyTaskMobileAdapter;
import com.tianque.plugin.taskList.constants.Constants;
import com.tianque.plugin.taskList.controller.DruggyTaskController;
import com.tianque.plugin.taskList.domain.DruggyTask;
import com.tianque.plugin.taskList.service.DruggyTaskService;
import com.tianque.sysadmin.service.PropertyDictService;

@Scope("request")
@Controller("druggyTaskMobileAdapter")
@Namespace("/baseinfo/druggyTaskMobileManage")
public class DruggyTaskMobileAdapterImpl extends BaseMobileAction implements
		DruggyTaskMobileAdapter {
	private Long orgId;
	private DruggyTask druggyTask;
	private Long druggyTaskId;
	@Autowired
	private DruggyTaskController druggyTaskController;
	@Autowired
	private DruggyTaskService druggyTaskService;
	private String ids;
	private Long id;
	private Boolean flag;
	@Autowired
	private PropertyDictService propertyDictService;
	/** 附件名 **/
	/* 一个参数  */
	private String[] attachFiles;
	/* 多个参数  */
	private String[] attachFile;

	/** 获取列表 */
	@Action(value = "getDruggyTaskList", results = {
			@Result(type = "json", name = "success", params = { "root", "gridPage",
					"ignoreHierarchy", "false" }),
			@Result(name = "error", type = "json", params = { "root", "errorMessage" }) })
	@Override
	public String getDruggyTaskList() throws Exception {
		druggyTaskController.setOrgId(orgId);
		if(druggyTask==null){
			druggyTask=new DruggyTask();
		}
		if(getTqmobile()!=null){
			druggyTask.setMode(getTqmobile());
		}
		druggyTaskController.setDruggyTask(druggyTask);
		druggyTaskController.getDruggyTaskList();
		gridPage = druggyTaskController.getGridPage();
		return SUCCESS;
	}
	/** 获取列表 */
	@Action(value = "getInterViewDruggyList", results = {
			@Result(type = "json", name = "success", params = { "root", "gridPage",
					"ignoreHierarchy", "false" }),
			@Result(name = "error", type = "json", params = { "root", "errorMessage" }) })
	@Override
	public String getInterViewDruggyList() throws Exception {
		druggyTaskController.setOrgId(orgId);
		if(druggyTask==null){
			druggyTask=new DruggyTask();
		}
		if(getTqmobile()!=null){
			druggyTask.setMode(getTqmobile());
		}
		druggyTaskController.setDruggyTask(druggyTask);
		druggyTaskController.searchInterViewDruggy();
		gridPage = druggyTaskController.getGridPage();
		return SUCCESS;
	}

	/**
	 * 新增吸毒任务走访记录
	 */
	@Action(value = "addDruggyTask", results = {
			@Result(type = "json", name = "success", params = { "root", "true", "ignoreHierarchy",
					"false" }),
			@Result(name = "error", type = "json", params = { "root", "errorMessage" }) })
	@Override
	public String addDruggyTask() throws Exception {
		fillAttachFileNames(druggyTask);
		druggyTaskController.setDruggyTask(druggyTask);
		druggyTaskController.addDruggyTask();
		return SUCCESS;
	}

	@Action(value = "updateDruggyTask", results = { @Result(type = "json", name = "success", params = {
			"root", "true", "ignoreHierarchy", "false" }) })
	@Override
	public String updateDruggyTask() throws Exception {
		fillAttachFileNames(druggyTask);
		druggyTaskController.setDruggyTask(druggyTask);
		druggyTaskController.updateDruggyTask();
		return SUCCESS;
	}

	@Action(value = "getDruggyTaskIsSign", results = { @Result(type = "json", name = "success", params = {
			"root", "flag", "ignoreHierarchy", "false" }) })
	@Override
	public String getDruggyTaskIsSign() throws Exception {
		flag = false;
		Organization currentUserOrg = ThreadVariable.getUser().getOrganization();
		//获取职能部门
		PropertyDict orgTypeDict = propertyDictService
				.findPropertyDictByDomainNameAndDictDisplayName(PropertyTypes.ORGANIZATION_TYPE,
						OrganizationType.FUNCTION_KEY);
		//获取职能部门类型（公安部门，司法部门。。）
		PropertyDict functionOrgTypeDict = propertyDictService
				.findPropertyDictByDomainNameAndDictDisplayName(PropertyTypes.FUNCTIONAL_ORG_TYPE,
						Constants.POLICE_DEPARTMENT);
		//获取组织结构层级（乡镇，县区）
		PropertyDict orgLevelDict = propertyDictService
				.findPropertyDictByDomainNameAndDictDisplayName(PropertyTypes.ORGANIZATION_LEVEL,
						OrganizationLevel.TOWN_KEY);
		if (currentUserOrg.getOrgType().getId().equals(orgTypeDict.getId())
				&& currentUserOrg.getOrgLevel().getId().equals(orgLevelDict.getId())
				&& currentUserOrg.getFunctionalOrgType().getId()
						.equals(functionOrgTypeDict.getId())) {
			flag = true;
		}
		return SUCCESS;
	}

	@Action(value = "deleteDruggyTask", results = { @Result(type = "json", name = "success", params = {
			"root", "true", "ignoreHierarchy", "false" }) })
	@Override
	public String deleteDruggyTask() throws Exception {
		druggyTaskController.setIds(ids);
		druggyTaskController.deleteDruggyTask();
		return SUCCESS;
	}

	@Action(value = "viewDruggyTask", results = { @Result(type = "json", name = "success", params = {
			"root", "druggyTask", "ignoreHierarchy", "false" }) })
	@Override
	public String viewDruggyTask() throws Exception {
		druggyTaskController.setId(id);
		druggyTaskController.viewDruggyTask();
		druggyTask = druggyTaskController.getDruggyTask();
		return SUCCESS;
	}
	
	@Action(value = "viewInterViewDruggy", results = { @Result(type = "json", name = "success", params = {
			"root", "druggyTask", "ignoreHierarchy", "false" }) })
	@Override
	public String viewInterViewDruggy() throws Exception {
		druggyTaskController.setId(id);
		druggyTaskController.viewInterViewDruggy();
		druggyTask = druggyTaskController.getDruggyTask();
		return SUCCESS;
	}

	private void fillAttachFileNames(DruggyTask druggyTask) {
		String[] attachFileNames = new String[] {};
		if (attachFiles != null && attachFiles.length != 0) {
			attachFiles[0] = "," + attachFiles[0];
			attachFileNames = attachFiles;
		}
		// 多个参数
		if (attachFile != null && attachFile.length != 0) {
			String[] strTmp = attachFile[0].split(",");
			for (int i = 0; i < strTmp.length; i++) {
				strTmp[i] = "," + strTmp[i];
			}
			attachFileNames = strTmp;
		}
		druggyTask.setAttachFileNames(attachFileNames);
	}

	public DruggyTask getDruggyTask() {
		return druggyTask;
	}

	public void setDruggyTask(DruggyTask druggyTask) {
		this.druggyTask = druggyTask;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getDruggyTaskId() {
		return druggyTaskId;
	}

	public void setDruggyTaskId(Long druggyTaskId) {
		this.druggyTaskId = druggyTaskId;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getAttachFiles() {
		return attachFiles;
	}

	public void setAttachFiles(String[] attachFiles) {
		this.attachFiles = attachFiles;
	}

	public String[] getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String[] attachFile) {
		this.attachFile = attachFile;
	}

}

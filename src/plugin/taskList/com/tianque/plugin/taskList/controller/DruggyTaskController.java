package com.tianque.plugin.taskList.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tianque.domain.Organization;
import com.tianque.plugin.taskList.constant.TaskConstant;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tinygroup.commons.tools.StringUtil;

import com.tianque.baseInfo.druggy.domain.Druggy;
import com.tianque.baseInfo.druggy.service.DruggyService;
import com.tianque.baseInfo.positiveInfo.domain.PositiveInfo;
import com.tianque.controller.ControllerHelper;
import com.tianque.core.base.BaseAction;
import com.tianque.core.util.CalendarUtil;
import com.tianque.core.vo.GridPage;
import com.tianque.plugin.taskList.domain.DruggyTask;
import com.tianque.plugin.taskList.service.DruggyTaskService;
import com.tianque.sysadmin.service.OrganizationDubboService;

@Scope("request")
@Namespace("/baseInfo/druggyTaskManage")
@Controller("druggyTaskController")
public class DruggyTaskController extends BaseAction {
	private Long orgId;
	private DruggyTask druggyTask;
	private Long druggyTaskId;
	@Autowired
	private DruggyTaskService druggyTaskService;
	private String ids;
	@Autowired
	private OrganizationDubboService organizationService;
	@Autowired
	private DruggyService druggyService;
	private Date currentTime;
	private List<DruggyTask> druggyTaskList;
	private Druggy population;
	/***
	 * 人口信息吸毒人员id
	 */
	private Long druggyInfoId;
	private String addFlag;
	// 只查有异常的
	private Boolean onlyHasException;

	/**
	 * 中转站 liu
	 */
	@Action(value = "dispatch", results = {
			@Result(name = "add", location = "/template/task/addDruggyTask.ftl"),
			@Result(name = "sign", location = "/template/task/druggyTaskInfoDlg.ftl"),
			@Result(name = "search", location = "/template/task/druggy/druggyTaskSearch.ftl")})
	public String dispatch() {
		if ("add".equals(mode)) {
			if (orgId == null) {
				errorMessage = "新增失败，未获得正确组织机构参数";
				return ERROR;
			}
			if (druggyInfoId != null) {
				population = druggyService.getDruggyById(druggyInfoId);
			}
			return "add";
		}
		if ("sign".equals(mode)) {
			currentTime = CalendarUtil.now();
			druggyTask = druggyTaskService.getDruggyTaskById(druggyTaskId);
			druggyTask.setSignDate(currentTime);
			return "sign";
		}
		if ("search".equals(mode)) {
			return "search";
		}
		if ("search".equals(mode)) {
			return "search";
		}
		return SUCCESS;
	}

	@Action(value = "getDruggyTaskList", results = {
			@Result(name = "success", type = "json", params = {"root", "gridPage"}),
			@Result(name = "error", type = "json", params = {"root", "errorMessage"})})
	public String getDruggyTaskList() throws Exception {
		if (druggyTask == null) {
			druggyTask = new DruggyTask();
		}
		druggyTask.setOrganization(organizationService.getSimpleOrgById(orgId));
		gridPage = new GridPage(ControllerHelper.processAllOrgRelativeName(
				druggyTaskService.getDruggyTaskList(druggyTask, page, rows, sidx, sord),
				organizationService, new String[]{"organization"}, orgId));
		return SUCCESS;
	}

	@Action(value = "addDruggyTask", results = {
			@Result(name = "success", type = "json", params = {"root", "druggyTask",
					"ignoreHierarchy", "false", "excludeNullProperties", "true"}),
			@Result(name = "error", type = "json", params = {"root", "errorMessage"})})
	public String addDruggyTask() throws Exception {
		if (druggyTask.getDruggyId()!=null&&druggyTask.getHasException()==0) {
			druggyTask.setStatus(1L);
			druggyTask.setSignDate(new Date());
			druggyTask.setSignMemberName("系统管理员");
		}else{
			druggyTask.setStatus(0L);
		}
		druggyTask = druggyTaskService.addDruggyTask(druggyTask);
		return SUCCESS;
	}

	@Action(value = "updateDruggyTask", results = {
			@Result(name = "success", type = "json", params = {"root", "druggyTask",
					"ignoreHierarchy", "false", "excludeNullProperties", "true"}),
			@Result(name = "error", type = "json", params = {"root", "errorMessage"})})
	public String updateDruggyTask() throws Exception {
		druggyTaskService.updateDruggyTask(druggyTask);
		return SUCCESS;
	}

	@Action(value = "deleteDruggyTask", results = {
			@Result(name = "success", type = "json", params = {"root", "true",
					"excludeNullProperties", "true"}),
			@Result(name = "error", type = "json", params = {"root", "errorMessage"})})
	public String deleteDruggyTask() throws Exception {
		druggyTaskService.deleteDruggyTaskByIds(analyzeIds(ids));
		return SUCCESS;
	}

	@Action(value = "viewDruggyTask", results = {@Result(name = "success", location = "/template/task/druggy/druggyTaskView.ftl")})
	public String viewDruggyTask() throws Exception {
		druggyTask = druggyTaskService.getDruggyTaskById(id);
		return SUCCESS;
	}

	@Action(value = "viewInterViewDruggy", results = {@Result(name = "success", location = "/template/task/druggy/InterViewdruggyView.ftl")})
	public String viewInterViewDruggy() throws Exception {
		druggyTask = druggyTaskService.getDruggyTaskById(id);
		return SUCCESS;
	}

	@Action(value = "searchDruggyTask", results = {
			@Result(name = "success", type = "json", params = {"root", "gridPage",
					"ignoreHierarchy", "false"}),
			@Result(name = "error", type = "json", params = {"root", "errorMessage",
					"ignoreHierarchy", "false"})})
	public String searchDruggyTask() throws Exception {
		if (onlyHasException != null && onlyHasException) {
			if (druggyTask.getOrganization() != null) {
				Organization org = organizationService.getFullOrgById(druggyTask.getOrganization().getId());
				if (org != null && org.getFullOrgName().contains(TaskConstant.GUANG_AN)) {
					druggyTask.setHasException(1);
				}
			}
		}
		gridPage = new GridPage(ControllerHelper.processAllOrgRelativeName(
				druggyTaskService.searchDruggyTask(druggyTask, page, rows, sidx, sord),
				organizationService, new String[]{"organization"}, null));

		return SUCCESS;
	}

	@Action(value = "searchInterViewDruggy", results = {
			@Result(name = "success", type = "json", params = {"root", "gridPage",
					"ignoreHierarchy", "false"}),
			@Result(name = "error", type = "json", params = {"root", "errorMessage",
					"ignoreHierarchy", "false"})})
	public String searchInterViewDruggy() throws Exception {

		gridPage = new GridPage(ControllerHelper.processAllOrgRelativeName(
				druggyTaskService.searchDruggyTask(druggyTask, page, rows, sidx, sord),
				organizationService, new String[]{"organization"}, null));

		return SUCCESS;
	}

	public String searchDruggyTaskByNameForMobile() throws Exception {
		druggyTaskList = druggyTaskService.searchDruggyTaskByName(druggyTask);
		return SUCCESS;
	}

	private List<Long> analyzeIds(String idStr) {
		if (idStr == null) {
			return null;
		}
		String[] deleteId = idStr.split(",");
		List<Long> idList = new ArrayList<Long>();
		if (StringUtil.isEmpty(deleteId[0])) {
			return null;
		} else {
			for (int i = 0; i < deleteId.length; i++) {
				idList.add(Long.parseLong(deleteId[i]));
			}
		}
		return idList;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public DruggyTask getDruggyTask() {
		return druggyTask;
	}

	public void setDruggyTask(DruggyTask druggyTask) {
		this.druggyTask = druggyTask;
	}

	public void setDruggyTaskList(List<DruggyTask> druggyTaskList) {
		this.druggyTaskList = druggyTaskList;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Long getDruggyTaskId() {
		return druggyTaskId;
	}

	public void setDruggyTaskId(Long druggyTaskId) {
		this.druggyTaskId = druggyTaskId;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public Druggy getPopulation() {
		return population;
	}

	public void setPopulation(Druggy population) {
		this.population = population;
	}

	public Long getDruggyInfoId() {
		return druggyInfoId;
	}

	public void setDruggyInfoId(Long druggyInfoId) {
		this.druggyInfoId = druggyInfoId;
	}

	public String getAddFlag() {
		return addFlag;
	}

	public void setAddFlag(String addFlag) {
		this.addFlag = addFlag;
	}

	public Boolean getOnlyHasException() {
		return onlyHasException;
	}

	public void setOnlyHasException(Boolean onlyHasException) {
		this.onlyHasException = onlyHasException;
	}

}

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

import com.tianque.baseInfo.positiveInfo.domain.PositiveInfo;
import com.tianque.baseInfo.positiveInfo.service.PositiveInfoService;
import com.tianque.baseInfo.rectificativePerson.domain.RectificativePerson;
import com.tianque.baseInfo.rectificativePerson.service.RectificativePersonService;
import com.tianque.controller.ControllerHelper;
import com.tianque.core.base.BaseAction;
import com.tianque.core.util.CalendarUtil;
import com.tianque.core.util.DialogMode;
import com.tianque.core.vo.GridPage;
import com.tianque.plugin.taskList.domain.TermerRecord;
import com.tianque.plugin.taskList.domain.TermerRecordVo;
import com.tianque.plugin.taskList.service.TermerRecordService;
import com.tianque.sysadmin.service.OrganizationDubboService;

@Scope("request")
@Namespace("/plugin/taskListManage/termerRecord")
@Controller("termerRecordController")
public class TermerRecordController extends BaseAction{
	@Autowired
	private TermerRecordService termerRecordService;
	@Autowired
	private OrganizationDubboService organizationDubboService;
	@Autowired
	private RectificativePersonService rectificativePersonService;
	
	/** 社区服刑人员记录domain **/
	private TermerRecord termerRecord;
	/** 社区服刑人员记录查询domain **/
	private TermerRecordVo termerRecordVo;
	/** id字符串  **/
	private String ids;
	/** 组织id **/
	private Long orgId;
	/** 社区服刑人员记录集合  **/
	private List<TermerRecord> termerRecords;
	
	private Boolean isGrid;
	
	private RectificativePerson population;
	 /***
	  * 人口信息社区服刑人员id
	  */
	 private Long termerInfoId;
	 
	 private String addFlag;
	// 只查有异常的
	private Boolean onlyHasException;

	@Action(value = "dispatch", results = {
			@Result(name = "success", location = "/template/task/maintainTermerRecordDlg.ftl"),
			@Result(name = "search", location = "/template/task/searchTermerRecordDlg.ftl") })
	public String maintainServiceMemberForPopulation() throws Exception {
		if (DialogMode.ADD_MODE.equals(mode)) {
			if(termerInfoId!=null){
			population = rectificativePersonService
						.getRectificativePersonById(termerInfoId);
			}
			fillNowDateAndSignDate();
			return SUCCESS;
		}else if (DialogMode.SEARCH_MODE.equals(mode)) {
			return "search";
		}else if (DialogMode.SIGN.equals(mode)){
			termerRecord = termerRecordService.getTermerRecordById(id);
			return SUCCESS;
		}
		return SUCCESS;
	}
	
	
	@Action(value = "addTermerRecord", results = {
			@Result(name = "success", type = "json", params = { "root",
					"termerRecord", "ignoreHierarchy", "false" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String addTermerRecord() throws Exception {
		if (termerRecord.getTermerId()!=null&&termerRecord.getHasException()==0) {
			termerRecord.setStatus(1L);
			termerRecord.setSignDate(new Date());
			termerRecord.setSignMemberName("系统管理员");
		}else{
			termerRecord.setStatus(0L);
		}
		termerRecord = termerRecordService.addTermerRecord(termerRecord);
		return SUCCESS;
	}
	
	@Action(value = "updateTermerRecord", results = {
			@Result(name = "success", type = "json", params = { "root",
					"termerRecord", "ignoreHierarchy", "false" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String updateTermerRecord() throws Exception {
		termerRecord = termerRecordService
				.updateTermerRecord(termerRecord);
		return SUCCESS;
	}
	
	@Action(value = "deleteTermerRecords", results = {
			@Result(type = "json", name = "success", params = { "root",
					"true", "ignoreHierarchy", "false" }),
			@Result(type = "json", name = "error", params = { "root",
					"errorMessage" }) })
	public String deleteTermerRecords() throws Exception {
		termerRecordService.deleteTermerRecords(analyzeIds(ids));
		return SUCCESS;
	}
	
	@Action(value = "findTermerRecords", results = {
			@Result(type = "json", name = "success", params = { "root",
					"gridPage", "ignoreHierarchy", "false" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String findTermerRecords() throws Exception {
		if (onlyHasException != null && onlyHasException) {
			if (termerRecordVo.getOrganization() != null) {
				Organization org = organizationDubboService.getFullOrgById(termerRecordVo.getOrganization().getId());
				if (org != null && org.getFullOrgName().contains(TaskConstant.GUANG_AN)) {
					termerRecordVo.setHasException(1);
				}
			}
		}
		gridPage = new GridPage(ControllerHelper.processAllOrgRelativeName(
				termerRecordService.findTermerRecords(termerRecordVo,
						page, rows,sidx, sord), organizationDubboService,
				new String[] { "organization" }, orgId));
		return SUCCESS;
	}
	
	@Action(value = "findInterViewTermer", results = {
			@Result(type = "json", name = "success", params = { "root",
					"gridPage", "ignoreHierarchy", "false" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String findInterViewTermer() throws Exception {
		gridPage = new GridPage(ControllerHelper.processAllOrgRelativeName(
				termerRecordService.findTermerRecords(termerRecordVo,
						page, rows,sidx, sord), organizationDubboService,
				new String[] { "organization" }, orgId));
		return SUCCESS;
	}
	
	@Action(value = "viewTermerRecord", results = {
			@Result(name = "success", location = "/template/task/viewTermerRecordDlg.ftl") })
	public String viewTermerRecord() throws Exception {
		termerRecord = termerRecordService.getTermerRecordById(id);
		return SUCCESS;
	}
	
	@Action(value = "viewInterViewTermer", results = {
			@Result(name = "success", location = "/template/task/viewInterViewTermerDlg.ftl") })
	public String viewInterViewTermer() throws Exception {
		termerRecord = termerRecordService.getTermerRecordById(id);
		return SUCCESS;
	}
	
	public String findTermerRecordsByNameForMobile() throws Exception {
		termerRecords = termerRecordService.findTermerRecordsByName(termerRecordVo);
		return SUCCESS;
	}
	
	private List<Long> analyzeIds(String idStr){
		if(idStr == null){
			return null;
		}
		String[] deleteId = idStr.split(",");
		List<Long> idList = new ArrayList<Long>();
		if(StringUtil.isEmpty(deleteId[0])){
			return null;
		}else {
			for(int i=0;i<deleteId.length;i++){
				idList.add(Long.parseLong(deleteId[i]));
			}
		}
		return idList;
	}
	
	private void fillNowDateAndSignDate(){
		if(termerRecord == null){
			termerRecord = new TermerRecord();
		}
		termerRecord.setRecordDate(CalendarUtil.now());
		termerRecord.setSignDate(CalendarUtil.now());
	}
	
	public TermerRecordVo getTermerRecordVo() {
		return termerRecordVo;
	}

	public void setTermerRecordVo(TermerRecordVo termerRecordVo) {
		this.termerRecordVo = termerRecordVo;
	}

	public TermerRecord getTermerRecord() {
		return termerRecord;
	}

	public void setTermerRecord(TermerRecord termerRecord) {
		this.termerRecord = termerRecord;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public List<TermerRecord> getTermerRecords() {
		return termerRecords;
	}

	public void setTermerRecords(List<TermerRecord> termerRecords) {
		this.termerRecords = termerRecords;
	}


	public Boolean getIsGrid() {
		return isGrid;
	}


	public void setIsGrid(Boolean isGrid) {
		this.isGrid = isGrid;
	}


	public RectificativePerson getPopulation() {
		return population;
	}


	public void setPopulation(RectificativePerson population) {
		this.population = population;
	}


	public Long getTermerInfoId() {
		return termerInfoId;
	}


	public void setTermerInfoId(Long termerInfoId) {
		this.termerInfoId = termerInfoId;
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

<%@	page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<style type="text/css">
.ui-tabs-panel {
	background: #fff !important;
}

/* .todo{width:20px;height:22px;display:block;margin:0 auto;vertical-align:top;background:url(${resource_path}/resource/images/icon_tbmk.png) no-repeat;} */
	/* .todo.yellow-todo{background-position:0 -27px;} */
	/* .todo.red-todo{background-position:0 -54px;} */
	/* .todo.blue-todo{background-position:0 0px;} */
	/* .event-expedited .expedited{width:14px;height:22px;display:block;margin:0 auto;background:url(${resource_path}/resource/images/icon_tbmk.png) no-repeat -2px -90px;} */
.myStyle {
	float: left;
	width: 17px;
	height: 17px;
	display: inline-block; *
	display: inline; *
	zoom: 1;
	margin: 0 0 0 10px;
}

.todo {
	width: 22px;
	height: 22px;
	display: block;
	margin: 0 auto;
	vertical-align: top;
}

.todo.yellow-todo {
	background: url(${resource_path}/resource/system/images/issue/icon_yHandleForList.png)
		no-repeat;
}

.todo.red-todo {
	background: url(${resource_path}/resource/system/images/issue/icon_rHandleForList.png)
		no-repeat;
}

.todo.blue-todo {
	background: url(${resource_path}/resource/system/images/issue/icon_bHandleForList.png)
		no-repeat;
}

.event-expedited.expedited {
	width: 22px;
	height: 22px;
	display: block;
	margin: 0 auto;
	background: url(${resource_path}/resource/system/images/issue/icon_EmerignceForList.png)
		no-repeat;
}

.dealState {
	width: 22px;
	height: 22px;
	display: block;
	margin: 0 auto;
	vertical-align: top;
}

.dealState.unconcepted-state {
	background:
		url(${resource_path}/resource/system/images/issue/icon_unconceptedForList.png)
		no-repeat;
}

.dealState.unread-state {
	background: url(${resource_path}/resource/system/images/issue/icon_unreadForList.png)
		no-repeat;
}

.dealState.complete-state {
	background: url(${resource_path}/resource/system/images/issue/icon_bLampForList.png)
		no-repeat;
}

.dealState.dealing-state {
	background: url(${resource_path}/resource/system/images/issue/icon_gLampForList.png)
		no-repeat;
}

.dealState.earingWarn {
	background: url(${resource_path}/resource/system/images/issue/icon_yLampForList.png)
		no-repeat;
}

.dealState.publicltycass {
	background:
		url(${resource_path}/resource/system/images/issue/icon_publicltycassForList.png)
		no-repeat;
}

.handleTop {
	display: inline-block;
	width: 15px;
	height: 15px;
	background:
		url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAPCAMAAAAMCGV4AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjVDNjkyOEM1NTk3QjExRTJBRUVBRjg3RUU5RDUzN0Q1IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjVDNjkyOEM2NTk3QjExRTJBRUVBRjg3RUU5RDUzN0Q1Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NUM2OTI4QzM1OTdCMTFFMkFFRUFGODdFRTlENTM3RDUiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NUM2OTI4QzQ1OTdCMTFFMkFFRUFGODdFRTlENTM3RDUiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7IOBiQAAAACVBMVEXMzMzm5ub///9vB0wNAAAAA3RSTlP//wDXyg1BAAAAMUlEQVR42mJgQgUMxPEZGVH4jAwMjEh8IBcmwADjQgUY4FyIAEQ/iIdsHrX5CAAQYACsfwFhFlU4OgAAAABJRU5ErkJggg==)
		no-repeat;
}
</style>
<%
	request.setAttribute("viewType", request.getParameter("viewType"));
%>
<s:action name="getLoginInfo" var="loginAction" executeResult="false"
	namespace="/sessionManage" />
<div class="content"><jsp:include
	page="${path}/account/steadyRecord/ledgerSteadyWorkForViewButtons.jsp" />
<div style="clear: both;"></div>
<div style="width: 100%;">
<table id="ledgerSteadyWorkList">
</table>
<div id="ledgerSteadyWorkListPager"></div>
</div>
<div id="steadyWorkDialog"></div>
<div id="noticeDialog"></div>
<div id="steadyWorkMaintanceDialog"></div>
<div id="feedBackDialog"></div>
<div id="printFormDialog"></div>
<input type="hidden" id="isMyIssue" /> <input type="hidden"
	id="jurisdictionsViewType"
	value="<s:property value='#parameters.viewType'/>" /> <input
	type="hidden" id="jurisdictionsOrgLevel"
	value="<s:property value='#parameters.orgLevel'/>" /> <input
	type="hidden" id="jurisdictionsKeyId"
	value="<s:property value='#parameters.keyId'/>" /> <input type="hidden"
	id="jurisdictionsSourceType"
	value="<s:property value='#parameters.sourceType'/>" /> <input
	type="hidden" id="jurisdictionsFunctionalOrgType"
	value="<s:property value='#parameters.functionalOrgType'/>" /></div>

<script type="text/javascript">
var currentOrgId='${loginAction.user.organization.id}';
var currentOrgName='${loginAction.user.organization.orgName}';
<s:if test="#getFullOrgById.organization.orgLevel.internalId == @com.tianque.domain.property.OrganizationLevel@DISTRICT">
$("#isMyIssue").val(true);
</s:if>
<s:else>
var selectName = $("#globalOrgBtnMod").html();
$("#isMyIssue").val(selectName==currentOrgName);
</s:else>
var viewType={
		name:$("#tabList li[aria-selected='true']").text(),
		value:'<s:property value="#parameters.viewType"/>'
}

<pop:formatterProperty name="createTableType" domainName="@com.tianque.plugin.account.property.PropertyTypes@LEDGER_PEOPLEASPIRATION_CREATE_TABLE_TYPE" />

function onLoadDelay(isEvaluate) {
	$("#ledgerSteadyWorkList").setGridParam({
		url:"${path}/threeRecordsIssue/ledgerSteadyWorkManage/findIssueForView.action",//?organization.id="+USER_ORG_ID,
		datatype: "json",
		page:1
	});
	$("#ledgerSteadyWorkList").setPostData({
		"viewType":viewType.value,
		"statusType": "completed" == $("#jurisdictionsViewType").val() ? (isEvaluate == null ? $("#_statusTypeSelect").val() : isEvaluate) : '',
		"orgLevelInternalId":$("#currentOrgId").attr("orgLevelInternalId"),
		"page":1,
		"leaderView":"0",
		"type":$("#jurisdictionsIssueType").val(),
		"keyId":$("#currentOrgId").attr("value"),
		"functionalOrgType":"<s:property value='#parameters.functionalOrgType'/>",
		"sourceTypeInternalId":"<s:property value='#parameters.sourceType'/>",
		"seachValue":$("#seachValue").val(),
		"year":$("#year").val(),
		"month":$("#month").val()
	});
	$("#ledgerSteadyWorkList").trigger("reloadGrid");
	if($("#currentOrgId").val()!= null){
		onOrgChanged();
	}
	initButton();
	initIssueCount();
}

function initIssueCount(){
	$.ajax({
        url: "/threeRecordsIssue/ledgerSteadyWorkManage/getIssueCount.action",
        data: {
        	"leaderView":"0",
        	"functionalOrgType":"<s:property value='#parameters.functionalOrgType'/>",
    		"sourceTypeInternalId":"<s:property value='#parameters.sourceType'/>",
        	"orgLevelInternalId":$("#currentOrgId").attr("orgLevelInternalId"),
            "keyId": $("#currentOrgId").val(),
            "year":$("#year").val(),
    		"month":$("#month").val()
        },
        success: function (responseData) {
            if (responseData!=null) {
            	if(responseData.need>99) $("#doingCount").html("99+");
            	else $("#doingCount").html(responseData.need);
            	
            	if(responseData.done>99) $("#doneCount").html("99+");
            	else $("#doneCount").html(responseData.done);
            	
            	if(responseData.period>99) $("#periodCount").html("99+");
            	else $("#periodCount").html(responseData.period);
            	
            	if(responseData.completed>99) $("#completedCount").html("99+");
            	else $("#completedCount").html(responseData.completed);
            	
            	if(responseData.createAndDone>99) $("#createAndDoneCount").html("99+");
            	else $("#createAndDoneCount").html(responseData.createAndDone);
            	
            	if(responseData.feedback>99) $("#feedbackCount").html("99+");
            	else $("#feedbackCount").html(responseData.feedback);
            	
            	if(responseData.assign>99) $("#assignCount").html("99+");
            	else $("#assignCount").html(responseData.assign);
            	
            	if(responseData.submit>99) $("#submitCount").html("99+");
            	else $("#submitCount").html(responseData.submit);
            	
            	if(responseData.support>99) $("#supportCount").html("99+");
            	else $("#supportCount").html(responseData.support);
            	
            	if(responseData.notice>99) $("#noticeCount").html("99+");
            	else $("#noticeCount").html(responseData.notice);
            }
        }
    });
}

function initButton(){
	//issueButtons.show(viewType.value);
	//mydone
	var isMyIssue = $("#isMyIssue").val();
	if(isMyIssue==true||isMyIssue=="true"){
		issueButtons.show("my"+viewType.value);
	}else{
		issueButtons.show(viewType.value);
	}
}
function setEditButton(){
	var selectedIssue = getSelectedData();
	$("#delete").hide();
	var deptNo="<s:property value="@com.tianque.core.util.ThreadVariable@getOrganization().getDepartmentNo()"/>";
	if(viewType.value=='need'){
		if(currentOrgId !=selectedIssue['createOrg.id']&&!new RegExp(/(1jg)$/).exec(deptNo)){
			$("#update").hide();
		}else{
			$("#update").show();
			if(new RegExp(/(1jg)$/).exec(deptNo)){
			    $("#delete").show();
			}
		}
		if(currentOrgId == selectedIssue['createOrg.id']){//自己新增不能自己回复
			$("#replyFormTop").hide();
		}else{
			$("#replyFormTop").show();
		}
	}
	if(viewType.value=='done' || viewType.value=='period' || viewType.value=='completed'){
		if(new RegExp(/(1jg)$/).exec(deptNo)){
			 $("#delete").show();
		}
	}
}
function setProgramButton(){
	var selectedIssue = getSelectedData();
	if(selectedIssue.status==150){
		$("#programDealTop").hide();
		$("#tmpDealTop").hide();
		return;
	}
	if(viewType.value=='done'||viewType.value=='support'){
		if(selectedIssue['state'].indexOf('Program')>-1){
			$("#programDealTop").show();
			$("#tmpDealTop").hide();
		}else{
			$("#programDealTop").hide();
			if(selectedIssue.stateCode=='待处理'){
				$("#tmpDealTop").hide();
			}else{
				$("#tmpDealTop").show();
			}
		}
	}
}

function getSelectedIds(){
	var selectedIds = $("#ledgerSteadyWorkList").jqGrid("getGridParam", "selarrrow");
	var strs = new Array();
	strs = selectedIds.toString().split(',');
	return strs;
}

function getOneSelect(){
	var selectedIds = $("#ledgerSteadyWorkList").jqGrid("getGridParam", "selarrrow");
	if(selectedIds.toString().split(',').length > 1){
		return false;
	}
	return true;
}

function getData(selectedId){
	return $("#ledgerSteadyWorkList").getRowData(selectedId);
}

function hasRowSelected(){
	if(null != $("#ledgerSteadyWorkList").getGridParam("selrow")){
		return true;
	}
	return false;
}

function getSelectedData(){
	var selectedId = $("#ledgerSteadyWorkList").getGridParam("selrow"); 
	return $("#ledgerSteadyWorkList").getRowData(selectedId);
}

function getSelectedDataId(){
	return getSelectedData().id;
}

function viewPoorPeope(rowid){
	//var id = getSelectedDataId();
	//if(id==null){
		 //return;
	//}
	var selectedIssue =  $("#ledgerSteadyWorkList").getRowData(rowid);
	if(selectedIssue==null || selectedIssue.id==null){
 		return;
	}
	var id = selectedIssue.id
	$("#steadyWorkDialog").createDialog({
		width:880,
		height:500,
		title:'查看稳定台账',
		url:'${path}/threeRecordsIssue/ledgerSteadyWorkManage/dispatchOperate.action?mode=viewNew&keyId='+id,		
		buttons: {
	   		"关闭" : function(){
	        	$("#steadyWorkDialog").dialog("close");
	   		}
		}
	});
}

function earingWarnFormatter(el,options,rowData){
	var returnString="";
	if(rowData.earingWarn == '<s:property value="@com.tianque.xichang.working.flow.constant.HandleType@NORMAL_HANDLE"/>'){
		returnString="<strong class='myAccountStyle account-green' title='正常办理中'></strong>";
	}else if(rowData.earingWarn == '<s:property value="@com.tianque.xichang.working.flow.constant.HandleType@OVERTIME_HANDLE"/>'){
		returnString="<strong class='myAccountStyle account-yellow' title='超时办理'></strong>";
	}else if(rowData.earingWarn == '<s:property value="@com.tianque.xichang.working.flow.constant.HandleType@NORMAL_FINISH"/>'){
		returnString="<strong class='myAccountStyle account-blue' title='正常办结'></strong>";
	}else if(rowData.earingWarn == '<s:property value="@com.tianque.xichang.working.flow.constant.HandleType@OVERTIME_FINISH"/>'){
		returnString="<strong class='myAccountStyle account-purple' title='超时办结'></strong>";
	}else if(rowData.earingWarn == '<s:property value="@com.tianque.xichang.working.flow.constant.HandleType@OVERTIME_CIRCULATION"/>'){
		returnString="<strong class='myAccountStyle account-red' title='超时流转'></strong>";
	}
	return returnString;
}

function dealStateFormatter(el, options, rowData){
	/*if(viewType.value=='done'||viewType.value=='follow'){//对于已办事件和待跟进事件状态的处理
		if(rowData.status==1){
			return "办理中";
		}else if(rowData.status==150){
			return "实质办结";				
		}else if(rowData.status==300){				
			return "已验证";				
		}
	}else */
	if(viewType.value=='completed'){
		return "实质办结";
	}else if(rowData.stateCode != null){
		if(110 == rowData.stateCode){
			return "待处理";
		}else if(160 == rowData.stateCode){
			return "待辅助处理";
		}else if(500 == rowData.stateCode){
			return "已办";
		}else if(600 == rowData.stateCode){
			return "阶段办结";
		}else if(700 == rowData.stateCode){
			return "实质办结";
		}else if(rowData.status == 150 && viewType.value=='support'){
			return "实质办结";
		}else {
			return "办理中";
		}
	}
}

$(document).ready(function(){
	$("#ledgerSteadyWorkList").jqGridFunction({
		datatype: "local",
		
		colModel:[
			        {name:"id",index:"id",sortable:false,frozen:true,hidden:true,hidedlg:true},
			        {name:"stepId",label:'stepId',index:'id',frozen:true,hidden:true}, 
			        {name:"encryptIdByIssueId",label:'issueStepId',index:'id',frozen:true,hidden:true},  
			        {name:"encryptIdByIssueStepId",label:'encryptIdByIssueId',index:'id',frozen:true,hidden:true},
			        {name:'publicltycass',label:'publicltycass',hidden:true,frozen:true},
			        {name:'earingWarn',label:'earingWarn',frozen:true,hidden:true,hidedlg:true},
					{name:'supervisionState',label:'supervisionState',index:'superviselevel',frozen:true,hidden:true,hidedlg:true},
					{name:'urgent',label:'urgent',index:'lsw.urgent',frozen:true,hidden:true,hidedlg:true},
					{name:'serialNumber',label:'编号',index:'serialNumber'},
					{name:'createOrg.orgName',label:'建账单位',index:'createOrg.orgName',frozen:true,hidedlg:true},
					{name:'name',label:'姓名',index:'lsw.name',sortable:true,align:'center'},
					{name:'mobileNumber',label:'联系电话',width:100,align:'center'},
					{name:'involvingSteadyInfo',label:'涉稳事项',align:'center',width:140},
					{name:"owner",label:'是否户主',align:'center',width:100,frozen:true,hidden:true,hidedlg:true},
			        {name:'birthDay',label:'出生年月',width:100,align:'center'},
			        {name:'sourceKind',label:'数据来源',width:100,align:'center',frozen:true,hidden:true,hidedlg:true},
					{name:'createTableType',label:'建卡类型',index:'lsw.createTableType',sortable:true,formatter:createTableTypeFormatter},
					{name:'status',label:'状态',index:'lsw.status',frozen:true,hidden:true,hidedlg:true},
					{name:'stateCode',label:'承办情况',index:'statecode',formatter:dealStateFormatter,width:60},
					{name:"state",frozen:true,hidden:true,hidedlg:true},
					{name:'occurDate',label:'反馈时间',index:'lsw.occurDate',sortable:true},
					{name:'createOrg.id',index:'createOrg.id',frozen:true,hidden:true,hidedlg:true},
					{name:'targetOrg.id',frozen:true,hidden:true,hidedlg:true},
					{name:'targetOrg.orgName',label:'承办部门',index:'targetOrg',sortable:true},
					{name:'occurOrg.orgName',label:'反馈部门',index:'occurorgID',sortable:true,width:200},
					{name:'lastdealDate',label:'最后处理时间',index:'lastdealdate',sortable:true,width:100}
				],
		showColModelButton:true,
		multiselect:${isShowTreeSelect},
		ondblClickRow: function (arg0){viewPoorPeope(arg0);},
		onSelectRow:function(){
			setEditButton();
			setProgramButton();
		},
		loadComplete: function(){
			var count=$("#ledgerSteadyWorkList").getGridParam("records");
			if(!isNaN(count)){
				if(viewType.name.indexOf('待办')>-1){
					if(count>99) $("#doingCount").html("99+");
					else $("#doingCount").html(count);
				}else if(viewType.name.indexOf('程序性办结')>-1){
					if(count>99) $("#doneCount").html("99+");
					else $("#doneCount").html(count);
				}else if(viewType.name.indexOf('阶段性办结')>-1){
					if(count>99) $("#periodCount").html("99+");
					else $("#periodCount").html(count);
				}else if(viewType.name.indexOf('实质性办结')>-1){
					if(count>99) $("#completedCount").html("99+");
					else $("#completedCount").html(count);
				}else if(viewType.name.indexOf('已办')>-1){
					if(count>99) $("#createAndDoneCount").html("99+");
					else $("#createAndDoneCount").html(count);
				}else if(viewType.name.indexOf('待反馈')>-1){
					if(count>99) $("#feedbackCount").html("99+");
					else $("#feedbackCount").html(count);
				}else if(viewType.name.indexOf('上级交办')>-1){
					if(count>99) $("#assignCount").html("99+");
					else $("#assignCount").html(count);
				}else if(viewType.name.indexOf('上报')>-1){
					if(count>99) $("#submitCount").html("99+");
					else $("#submitCount").html(count);
				}else if(viewType.name.indexOf('协办')>-1){
					if(count>99) $("#supportCount").html("99+");
					else $("#supportCount").html(count);
				}else if(viewType.name.indexOf('抄告')>-1){
					if(count>99) $("#noticeCount").html("99+");
					else $("#noticeCount").html(count);
				}
			}
		}
	});
	onLoadDelay();
});


function onOrgChanged(isEvaluate){
	if(undefined==$("#ledgerSteadyWorkList").attr("id")){return;}
	$("#ledgerSteadyWorkList").setGridParam({
		url:'${path}/threeRecordsIssue/ledgerSteadyWorkManage/findIssueForView.action',
		datatype: "json"
	});
	$("#ledgerSteadyWorkList").setPostData({
		"viewType":viewType.value,
		"statusType": "completed" == $("#jurisdictionsViewType").val() ? (isEvaluate == null ? $("#_statusTypeSelect").val() : isEvaluate) : '',
		"orgLevelInternalId":$("#currentOrgId").attr("orgLevelInternalId"),
		"page":1,
		"leaderView":"0",
		"type":$("#jurisdictionsIssueType").val(),
		"keyId":$("#currentOrgId").attr("value"),
		"functionalOrgType":"<s:property value='#parameters.functionalOrgType'/>",
		"sourceTypeInternalId":"<s:property value='#parameters.sourceType'/>",
		"seachValue":$("#seachValue").val(),
		"year":$("#year").val(),
		"month":$("#month").val()
	});
	$("#ledgerSteadyWorkList").trigger("reloadGrid");
}
</script>
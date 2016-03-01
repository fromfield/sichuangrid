<%@	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<style type="text/css">
	.ui-tabs-panel{background:#fff!important;}
	/* .todo{width:20px;height:22px;display:block;margin:0 auto;vertical-align:top;background:url(/resource/images/icon_tbmk.png) no-repeat;} */
	/* .todo.yellow-todo{background-position:0 -27px;} */
	/* .todo.red-todo{background-position:0 -54px;} */
	/* .todo.blue-todo{background-position:0 0px;} */
	/* .event-expedited .expedited{width:14px;height:22px;display:block;margin:0 auto;background:url(/resource/images/icon_tbmk.png) no-repeat -2px -90px;} */
	.myStyle{float:left;width:17px;height:17px;display:inline-block;*display:inline;*zoom:1;margin:0 0 0 10px;}
	.todo{width:22px;height:22px;display:block;margin:0 auto;vertical-align:top;}
	.todo.yellow-todo{background:url(/resource/system/images/issue/icon_yHandleForList.png) no-repeat;}
	.todo.red-todo{background:url(/resource/system/images/issue/icon_rHandleForList.png) no-repeat;}
	.todo.blue-todo{background:url(/resource/system/images/issue/icon_bHandleForList.png) no-repeat;}
	.event-expedited.expedited{width:22px;height:22px;display:block;margin:0 auto;background:url(/resource/system/images/issue/icon_EmerignceForList.png) no-repeat;}
	.dealState{width:22px;height:22px;display:block;margin:0 auto;vertical-align:top;}
	.dealState.unconcepted-state{background:url(/resource/system/images/issue/icon_unconceptedForList.png) no-repeat;}
	.dealState.unread-state{background:url(/resource/system/images/issue/icon_unreadForList.png) no-repeat;}
	.dealState.complete-state{background:url(/resource/system/images/issue/icon_bLampForList.png) no-repeat;}
	.dealState.dealing-state{background:url(/resource/system/images/issue/icon_gLampForList.png) no-repeat;}
	.dealState.earingWarn{background:url(/resource/system/images/issue/icon_yLampForList.png) no-repeat;}
	.dealState.publicltycass{background:url(/resource/system/images/issue/icon_publicltycassForList.png) no-repeat;}
	.handleTop{display: inline-block;width:15px;height:15px;background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAPCAMAAAAMCGV4AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjVDNjkyOEM1NTk3QjExRTJBRUVBRjg3RUU5RDUzN0Q1IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjVDNjkyOEM2NTk3QjExRTJBRUVBRjg3RUU5RDUzN0Q1Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NUM2OTI4QzM1OTdCMTFFMkFFRUFGODdFRTlENTM3RDUiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NUM2OTI4QzQ1OTdCMTFFMkFFRUFGODdFRTlENTM3RDUiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7IOBiQAAAACVBMVEXMzMzm5ub///9vB0wNAAAAA3RSTlP//wDXyg1BAAAAMUlEQVR42mJgQgUMxPEZGVH4jAwMjEh8IBcmwADjQgUY4FyIAEQ/iIdsHrX5CAAQYACsfwFhFlU4OgAAAABJRU5ErkJggg==) no-repeat;}
</style>
<% request.setAttribute("viewType",request.getParameter("viewType"));%>
<s:action name="getLoginInfo" var="loginAction" executeResult="false"
	namespace="/sessionManage" />
<div class="content">
	<jsp:include page="${path}/account/peopleAspiration/educationForViewButtons.jsp"/>
	<div style="clear: both;"></div>
	<div style="width: 100%;">
		<table id="issueList"> </table>
		<div id="issueListPager"></div>
	</div>
	<div id="issueDialog"></div>
	<div id="noticeDialog"></div>
	<div id="viewProcessDialog"></div>
	<div id="gradeDialog"></div>
	<div id="feedBackDialog"></div>
	<div id="educationDialog"></div>
	<div id="printFormDialog"></div>
	<input type="hidden" id="isMyIssue" />
	<input type="hidden" id="jurisdictionsViewType" value="<s:property value='#parameters.viewType'/>"/>
	<input type="hidden" id="jurisdictionsOrgLevel" value="<s:property value='#parameters.orgLevel'/>"/>
	<input type="hidden" id="jurisdictionsKeyId" value="<s:property value='#parameters.keyId'/>"/>
	<input type="hidden" id="jurisdictionsSourceType" value="<s:property value='#parameters.sourceType'/>"/>
	<input type="hidden" id="jurisdictionsFunctionalOrgType" value="<s:property value='#parameters.functionalOrgType'/>"/>
</div>

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
<pop:formatterProperty name="sourceKind" domainName="@com.tianque.plugin.account.property.PropertyTypes@SOURCE_KIND" />
<pop:formatterProperty name="createTableType" 	domainName="@com.tianque.plugin.account.property.PropertyTypes@LEDGER_PEOPLEASPIRATION_CREATE_TABLE_TYPE" />
var viewType={
		name:$("#tabList li[aria-selected='true']").text(),
		value:'<s:property value="#parameters.viewType"/>'
}
$(document).ready(function(){
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
		}else if(rowData.dealState != null){
			if(110 == rowData.dealState){
				return "待处理";
			}else if(160 == rowData.dealState){
				return "待辅助处理";
			}else if(500 == rowData.dealState){
				return "已办";
			}else if(600 == rowData.dealState){
				return "阶段办结";
			}else if(700 == rowData.dealState){
				return "实质办结";
			}else if(rowData.status == 150 && viewType.value=='support'){
				return "实质办结";
			}else {
				return "办理中";
			}
		}
	}
	

	$("#issueList").jqGridFunction({
		datatype: "local",
		sortname: 'issueId',
		sortorder: "desc",
		colNames:['issueId','issueStepId','encryptIdByIssueId','encryptIdByIssueStepId','publicltycass','earingWarn'
		          ,'supervisionState','urgent','编号','建账单位','反映人姓名','主要诉求','联系电话','类型'
		          ,'状态','承办情况','反馈时间','createOrg.id','targetOrg.id','承办部门','反馈部门','最后处理时间','state'
		         ],
		colModel:[
			{name:'issueId',frozen:true,hidden:true,hidedlg:true},
			{name:'issueStepId',frozen:true,hidden:true,hidedlg:true,key:true},
			{name:"encryptIdByIssueId",index:'id',frozen:true,frozen:true,hidden:true,hidedlg:true},
			{name:"encryptIdByIssueStepId",index:'id',frozen:true,frozen:true,hidden:true,hidedlg:true},
			{name:'publicltycass',frozen:true,hidden:true,hidedlg:true},
			{name:'earingWarn',frozen:true,hidden:true,hidedlg:true},
			{name:'supervisionState',index:'superviselevel',frozen:true,hidden:true,hidedlg:true},
			{name:'urgent',index:'lpa.urgent',frozen:true,hidden:true,hidedlg:true},
			{name:'serialNumber',index:'lpa.serialNumber',sortable:true},
			{name:'createOrg.orgName',index:'createOrg.orgName',sortable:false},
			{name:'name',index:'lpa.name',sortable:true},
			{name:'appealContent',index:'lpa.appealContent',sortable:false},
			{name:'mobileNumber',index:'lpa.mobileNumber',sortable:true},
			{name:'createTableType',index:'lpa.createTableType',sortable:true,formatter:createTableTypeFormatter},
			{name:'status',index:'lpa.status',frozen:true,hidden:true,hidedlg:true},
			{name:'dealState',index:'statecode',formatter:dealStateFormatter,width:60},
			{name:'occurDate',index:'lpa.occurDate',sortable:true},
			{name:'createOrg.id',index:'createOrg.id',frozen:true,hidden:true,hidedlg:true},
			{name:'targetOrg.id',index:'targetOrg.id',frozen:true,hidden:true,hidedlg:true},
			{name:'targetOrg.orgName',index:'targetOrg',sortable:true},
			{name:'occurOrg.orgName',index:'occurOrg',sortable:true,width:200},
			{name:'dealTime',index:'lastdealdate',sortable:true,width:100},
			{name:'state',frozen:true,hidden:true,hidedlg:true}
		],
		loadComplete: function(){
			var count=$("#issueList").getGridParam("records");
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
		},
		multiselect:${isShowTreeSelect},
		showColModelButton:true,
		ondblClickRow:viewIssue,
		onSelectRow:function(){
			setEditButton();
			setProgramButton();
		}
	});
	if($("#currentOrgId").val()!= null){
		onOrgChanged();
	}
	initButton();
	initIssueCount();
});

function initIssueCount(){
	$.ajax({
        url: "/threeRecords/education/getIssueCount.action",
        data: {
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
			if(selectedIssue.dealState=='待处理'){
				$("#tmpDealTop").hide();
			}else{
				$("#tmpDealTop").show();
			}
		}
	}
}

function viewIssue(rowid){
	var selectedIssue =  $("#issueList").getRowData(rowid);
	if(selectedIssue==null || selectedIssue.encryptIdByIssueId==null){
 		return;
	}
	if ($("#view").isButtonEnabled()){
	//if (hasRowSelected() && $("#view").isButtonEnabled()){
		//var selectedIssue = getSelectedData();
		$("#issueDialog").createDialog({
			width: 880,
			height: 500,
			title: "查看教育信息详情",
			url: "${path}/threeRecords/education/dispatch.action?mode=viewNew&keyId="+selectedIssue.encryptIdByIssueId,
			buttons: {
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	}else{
		$.messageBox({level:'warn',message:"没有可查看的数据！"});
		return;
	}
}


function onOrgChanged(isEvaluate){
	if(undefined==$("#issueList").attr("id")){return;}
	$("#issueList").setGridParam({
		url:'${path}/threeRecords/education/findIssueForView.action',
		datatype: "json"
	});
	$("#issueList").setPostData({
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
	$("#issueList").trigger("reloadGrid");
}

function getSelectedIds(){
	var selectedIds = $("#issueList").jqGrid("getGridParam", "selarrrow");
	var strs = new Array();
	strs = selectedIds.toString().split(',');
	return strs;
}

function getOneSelect(){
	var selectedIds = $("#issueList").jqGrid("getGridParam", "selarrrow");
	if(selectedIds.toString().split(',').length > 1){
		return false;
	}
	return true;
}

function getData(selectedId){
	return $("#issueList").getRowData(selectedId);
}


function reloadIssue(){
	onOrgChanged();
}

function hasRowSelected(){
	if(null != $("#issueList").getGridParam("selrow")){
		return true;
	}
	return false;
}
function getSelectedId(){
	return $("#issueList").getGridParam("selrow");
}
function getSelectedData(){
	var selectedId = $("#issueList").getGridParam("selrow"); 
	return $("#issueList").getRowData(selectedId);
}
function getTypeDescById(indexs,id){
	for (var index=0;index<indexs.length;index++){
		if (indexs[index]==id) return index;
	}
	return indexs.length;
}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.tianque.domain.property.OrganizationType,com.tianque.domain.Organization,com.tianque.domain.property.OrganizationLevel,com.tianque.core.util.ThreadVariable" %>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/includes/baseInclude.jsp" />

<%
	Organization userOrg = ThreadVariable.getUser().getOrganization();

	boolean isOpen = false;
	if (userOrg.getOrgType().getDisplayName().equals(OrganizationType.getInternalProperties().get(OrganizationType.FUNCTIONAL_ORG).getDisplayName())) {
		request.setAttribute("isFun", true);
		if (userOrg.getDepartmentNo() != null && (userOrg.getDepartmentNo().endsWith("1jg") || userOrg.getDepartmentNo().endsWith("1lx") || userOrg.getDepartmentNo().endsWith("1xw"))) {
			isOpen = true;
		}else{
			isOpen = false;
		}
	} else {
		request.setAttribute("isFun", false);
		isOpen = false;
	}
	request.setAttribute("isOpen", isOpen);
	Long rootId = userOrg.getId();
	if(userOrg.getParentOrg() != null){
		rootId = userOrg.getParentOrg().getId();
	}
	request.setAttribute("userParentOrgId", rootId);
%>

<style>
.select_ {width: 150px;}
._select {width: 70px;}
.input_ {width: 77px;}
.must {color: red}
</style>

<div id="nav" class="ui-corner-all">
	<div>
		<label class="must" style="margin-left: 5px">*</label><strong>所属区域：</strong> 
		<div class="btnbanner btnbannerData">
			<div class="ui-widget autosearch">
				<input class="" type="text" value="" id="fastSearchIssueOrg" maxlength="20" class="searchtxt" style="width:175px;height: 24px; margin-top: 5px; background: threedhighlight;" onblur="value=(this.value=='')?'':this.value;" onfocus="value=(this.value=='')?'':this.value;"/>
			</div>
			<select id="seachValue" class="form-txt" style="width: 100px;">
	   	 		<option value="present" selected="selected">本级</option>
	   	 		<option value="subordinate">直属下辖</option>
	    		<option value="all">下辖全部</option>
	    	</select>
			<a id="search" href="javascript:void(0)" style="margin-top:5px;"><span style="height:26px">查询</span></a> 
			<a id="moreSelect" href="javascript:void(0)" style="margin-top:5px;"><span style="height:26px">多选</span></a> 
			<a id="situation" href="javascript:void(0)" style="margin-top:5px;"><span style="height:26px">导出</span></a>
			<c:if test="${isOpen}">
				<a id="statistical" href="javascript:void(0)" style="margin-top:5px;"><span style="height:26px">统计表</span></a>  
			</c:if>
			<a id="catalog" href="javascript:void(0)" style="margin-top:5px;"><span style="height:26px">生成目录</span></a>
		</div>
	</div>
	
	<div style="margin-top: 5px;margin-left: 5px">
		<label class="must">*</label><strong>办结方式：</strong>
		<select class="select_" id="doneType">
			<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@LEDGER_STATUS" />
		</select>
		<select id="detailDoneType"></select>
	
		<strong>建卡时间：</strong>
		<input type="text" id="beginCreateDate" readonly="readonly" />
		<strong>到</strong>
		<input type="text" id="endCreateDate" readonly="readonly" />
	</div>

	<div id="steadyWork" style="margin-top:5px;margin-left: 5px">
		<label style="visibility: hidden;">*</label><strong>涉稳类别：</strong>
		<select class="select_" id="steadyWorkType">
			<pop:PropertyDictReleationSelectTag name="@com.tianque.plugin.account.property.PropertyTypes@STEADY_RECORD_WORK_TYPE" />
		</select>
		
		<strong>预警级别：</strong>
		<select style="width:161px;" id="steadyWorkWarnLevel">
			<pop:OptionTag name="@com.tianque.plugin.account.property.PropertyTypes@STEADY_RECORD_WORK_WARN_LEVEL" />
		</select>
		
		<strong>涉稳事项：</strong>
		<input type="text" class="general" id="involvingSteadyInfo" />
	</div>
</div>
<div style="width: 100%;">
	<table id="steadyWorkList"> </table>
	<div id="steadyWorkListPager"></div>
</div>
<div id=steadyWorkDialog></div>
<div id="moreSelectDialog"></div>
<div id="steadyWorkCountDialog"></div>
<input type="hidden" name="selectNodeId" id="selectNodeId"/>
<input type="hidden" id="jurisdictionsOrgLevel" value="<s:property value='#parameters.orgLevel'/>"/>
<input type="hidden" id="jurisdictionsFunctionalOrgType" value="<s:property value='#parameters.functionalOrgType'/>"/>
<input type="hidden" id="jurisdictionsKeyId" value="<s:property value='#parameters.keyId'/>"/>
<script type="text/javascript">
<pop:formatterProperty name="createTableType" domainName="@com.tianque.plugin.account.property.PropertyTypes@LEDGER_PEOPLEASPIRATION_CREATE_TABLE_TYPE" />

var switchLedger;
var doneType;

var thisTime=new Date();
var addMonth=thisTime.getMonth()+1;
var formatdate= thisTime.getFullYear()+"-"+addMonth+"-"+thisTime.getDate();

var firstDate=new Date();
firstDate.setDate(1);
var currentMonthFirstDay = firstDate.getFullYear()+"-"+(firstDate.getMonth()+1)+"-"+firstDate.getDate();
$("#beginCreateDate").attr("value",currentMonthFirstDay);
$("#endCreateDate").attr("value",formatdate);
$('#beginCreateDate').datePicker({
	yearRange:'2013:2060',
	dateFormat:'yy-mm-dd',
	maxDate:'%y-%M-#{%d}'
});
$('#endCreateDate').datePicker({
	yearRange:'2013:2060',
	dateFormat:'yy-mm-dd',
	maxDate:'%y-%M-#{%d}'
});

$("#detailDoneType").hide();
$('#doneType').change(function(){ 
	detailDoneType();
	doneTypeChange();
	selectSteadyWorkChange("");
});

$("#search").click(function (event) {
	selectSteadyWorkChange("");
});

$('#detailDoneType,#beginCreateDate,#endCreateDate,#steadyWorkType,#steadyWorkWarnLevel,#seachValue').change(function(event){
	selectSteadyWorkChange("");
});

var moreSelectOrgIds;
function selectSteadyWorkChange(orgIds){
	if(doneType == "all"){
		return;
	}
	var orgId =  $("#selectNodeId").val();
	if (orgId == "") {
        $.messageBox({level: 'warn', message: "请选择组织机构！"});
        return;
    }
	$("#steadyWorkList").setGridParam({
		url:"/threeRecords/peopleaspirationComprehensive/findSteadyWorkIssueForView.action",
		datatype: "json",
		page:1
	});
	moreSelectOrgIds = orgIds;
	$("#steadyWorkList").setPostData({
		"searchVo.ledgerType":"<s:property value='@com.tianque.plugin.account.constants.LedgerConstants@STEADYWORK'/>",
		"orgId": orgId,
		"orgIds": orgIds,
    	"searchVo.searchValue":$("#seachValue").val(),
    	"searchVo.doneType":doneType,
    	"searchVo.detailDoneType":$("#detailDoneType").val(),
        "searchVo.beginCreateDate":$("#beginCreateDate").val(),
        "searchVo.endCreateDate":$("#endCreateDate").val(),
        "searchVo.steadyWorkType":$("#steadyWorkType").val(),
        "searchVo.steadyWorkWarnLevel":$("#steadyWorkWarnLevel").val(),
        "searchVo.involvingSteadyInfo":$("#involvingSteadyInfo").val()
   	});
	$("#steadyWorkList").trigger("reloadGrid");
}

function doneTypeChange(){
	isShowPort(false);
	if($('#doneType').children('option:selected').text().indexOf('待办')>-1){
		doneType = "need";
	}else if($('#doneType').children('option:selected').text().indexOf('程序性办结')>-1){
		doneType = "done";
	}else if($('#doneType').children('option:selected').text().indexOf('阶段性办结')>-1){
		doneType = "period";
	}else if($('#doneType').children('option:selected').text().indexOf('实质性办结')>-1){
		doneType = "completed";
	}else if($('#doneType').children('option:selected').text().indexOf('已办')>-1){
		isShowPort(true);
		doneType = "createAndDone";
	}else if($('#doneType').children('option:selected').text().indexOf('待反馈')>-1){
		doneType = "feedback";
	}else if($('#doneType').children('option:selected').text().indexOf('上级交办')>-1){
		doneType = "assign";
	}else if($('#doneType').children('option:selected').text().indexOf('上报')>-1){
		doneType = "submit";
	}else if($('#doneType').children('option:selected').text().indexOf('协办')>-1){
		doneType = "support";
	}else if($('#doneType').children('option:selected').text().indexOf('抄告')>-1){
		doneType = "notice";
	}else{
		doneType = "all";
	}
}
$("#statistical").hide();
$("#situation").hide();
function isShowPort(yesOrNo){
	if(yesOrNo){
		$("#statistical").show();
		$("#situation").show();
	}else{
		$("#statistical").hide();
		$("#situation").hide();
	}
}

function detailDoneType(){
	if($('#doneType').children('option:selected').text().indexOf('程序性办结')>-1){
		$("#detailDoneType").show();
		$("#detailDoneType").html("<option><s:property value='@com.tianque.plugin.account.constants.CompleteType@ALL_QUERY'/></option>"+
		"<option><s:property value='@com.tianque.plugin.account.constants.CompleteType@OTHER_NAME'/></option>");
	}else if($('#doneType').children('option:selected').text().indexOf('阶段性办结')>-1){
		$("#detailDoneType").show();
		$("#detailDoneType").html("<option><s:property value='@com.tianque.plugin.account.constants.CompleteType@ALL_QUERY'/></option>"+
		"<option><s:property value='@com.tianque.plugin.account.constants.CompleteType@STEADY_CONTROL_NAME'/></option>");
	}else if($('#doneType').children('option:selected').text().indexOf('实质性办结')>-1){
		$("#detailDoneType").show();
		$("#detailDoneType").html("<option><s:property value='@com.tianque.plugin.account.constants.CompleteType@ALL_QUERY'/></option>"+
				"<option><s:property value='@com.tianque.plugin.account.constants.CompleteType@REALCOMPLETE_SOLVE_NAME'/></option>"+
				"<option><s:property value='@com.tianque.plugin.account.constants.CompleteType@PROGRAM_COMPLETE_NAME'/></option>"+
				"<option><s:property value='@com.tianque.plugin.account.constants.CompleteType@COMPLETE_NAME'/></option>");
	}else{
		$("#detailDoneType").hide();
		$("#detailDoneType").empty();
	}
}

var orgTree;
$(document).ready(function(){
	initLedgerSteadyWorkGrid();

	function initOccurOrgSelector() {
        var orgLevelId = $("#jurisdictionsOrgLevel").val();
        var orgFuntionalTypeId = $("#jurisdictionsFunctionalOrgType").val();
        var orgId;
        if(${isOpen}){
        	orgId = ${userParentOrgId};
        }else{
        	orgId = $("#jurisdictionsKeyId").val();
        }
        orgTree = $("#fastSearchIssueOrg").treeSelect({
            nodeUrl: '/sysadmin/orgManage/ajaxOrgsForExtTreeByLevel.action?orgFuntionalTypeId=' + orgFuntionalTypeId + '&orgLevelInternalId=' + orgLevelId,
            allOrg: false,
            isRootSelected: false,
            emptyText: '请选择组织机构',
            isFuncDep:true,
            rootId: orgId
        });
        orgTree.on("click", function (node, e) {
            if (node != null) {
                var nodeId = node.attributes.id;
                $("#selectNodeId").val(nodeId);
            }
        });
    }
    initOccurOrgSelector();
});

function getSelectedData(){
	var selectedId = $("#steadyWorkList").getGridParam("selrow"); 
	return $("#steadyWorkList").getRowData(selectedId);
}

function getSelectedDataId(){
	return getSelectedData().id;
}

function viewSteadyWork(){
	var id = getSelectedDataId();
	if(id==null){
		 return;
	}
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

$("#moreSelect").click(function (event) {
	var orgId =  $("#selectNodeId").val();
	if (orgId == "") {
        $.messageBox({level: 'warn', message: "请选择组织机构！"});
        return;
    }
    $("#moreSelectDialog").createDialog({
        width: 600,
        height: 300,
        title: "下辖组织机构多选",
        url: "/threeRecords/peopleaspirationComprehensive/moreSelect.action?mode=search&orgId=" + orgId,
        buttons: {
            "确定": function (event) {
            	var orgIds = fillOrgInputer();
            	selectSteadyWorkChange(orgIds.join());
            	$(this).dialog("close");
            },
            "关闭": function () {
                $(this).dialog("close");
            }
        }
    });
});

function initLedgerSteadyWorkGrid(){
	$("#steadyWorkList").jqGridFunction({
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
					{name:'name',label:'姓名',index:'lsw.name',sortable:true,align:'center'},
					{name:'mobileNumber',label:'联系电话',width:100,align:'center'},
					{name:'involvingSteadyInfo',label:'涉稳事项',align:'center',width:140},
					{name:"owner",label:'是否户主',align:'center',width:100,frozen:true,hidden:true,hidedlg:true},
			        {name:'birthDay',label:'出生年月',width:100,align:'center'},
			        {name:'sourceKind',label:'数据来源',width:100,align:'center',frozen:true,hidden:true,hidedlg:true},
					{name:'createTableType',label:'建卡类型',index:'lsw.createTableType',sortable:true,formatter:createTableTypeFormatter},
					{name:'status',label:'状态',index:'lsw.status',frozen:true,hidden:true,hidedlg:true},
					{name:'occurDate',label:'反馈时间',index:'lsw.occurDate',sortable:true},
					{name:'createOrg.id',index:'createOrg.id',frozen:true,hidden:true,hidedlg:true},
					{name:'targetOrg.id',index:'targetOrg.id',frozen:true,hidden:true,hidedlg:true},
					{name:'targetOrg.orgName',label:'承办部门',index:'targetOrg',sortable:true},
					{name:'occurOrg.orgName',label:'反馈部门',index:'occurorgID',sortable:true,width:200},
					{name:'lastdealDate',label:'最后处理时间',index:'lastdealdate',sortable:true,width:100}
				],
				loadComplete: function(){
					var count=$("#steadyWorkList").getGridParam("records");
					$("#tabList li[aria-selected=true]").find(".countTip").html(count);
				},
				multiselect:false,
				showColModelButton:true,
				ondblClickRow: function (arg0){viewSteadyWork(arg0);}
	});
}

$("#statistical").click(function(){
	var orgId =  $("#selectNodeId").val();
	if (orgId == "") {
        $.messageBox({level: 'warn', message: "请选择组织机构！"});
        return;
    }
	if(doneType != 'createAndDone'){
		$.messageBox({level: 'warn', message: "请在办结方式：已办条件下导出统计表！"});
		return;
	}
	var ledger = "<s:property value='@com.tianque.plugin.account.constants.LedgerConstants@STEADYWORK'/>";
    url = "/threeRecords/peopleaspirationComprehensive/countIssueForView.action?mode=steadyWork&orgId="+orgId+"&orgIds="+moreSelectOrgIds+"&searchVo.ledgerType="+ledger+
	"&searchVo.searchValue="+$("#seachValue").val()+"&searchVo.doneType="+doneType+"&searchVo.detailDoneType="+$("#detailDoneType").val()+
	"&searchVo.beginCreateDate="+$("#beginCreateDate").val()+"&searchVo.endCreateDate="+$("#endCreateDate").val()+"&searchVo.steadyWorkType="+$("#steadyWorkType").val()
	+"&searchVo.steadyWorkWarnLevel="+$("#steadyWorkWarnLevel").val()+"&searchVo.involvingSteadyInfo="+$("#involvingSteadyInfo").val();
	$("#accountPrintDlg").createDialog({
		width:900,
		height:600,
		title:"统计表",
		url:url,
		buttons: {
		   "下载" : function(){
			   $("#accountPrintDlg").dialog("close");
	  	   },
		   "关闭" : function(){
			   $("#accountPrintDlg").dialog("close");
		   }
		}
	});
});

$("#situation").click(function(event){
	if ($("#steadyWorkList").getGridParam("records")>0){
		$("#steadyWorkCountDialog").createDialog({
			width: 250,
			height: 200,
			title:'导出困难详细信息',
			url:PATH+'/common/exportExcel.jsp',
			postData:{
				gridName:'steadyWorkList',
				downloadUrl:PATH+'/threeRecords/peopleaspirationComprehensive/downloadLedgerPeopleBase.action'
				},
			buttons: {
	   			"导出" : function(event){
	   				exceldownloadSubmitForm();
	        		$(this).dialog("close");
   				},
	   			"关闭" : function(){
	        		$(this).dialog("close");
	   			}
			},
			shouldEmptyHtml:false
		});
	}else{
		$.messageBox({level:'warn',message:"列表中没有数据，不能导出！"});
	}
});

$("#catalog").click(function(event){
	if ($("#steadyWorkList").getGridParam("records")>0){
		$("#steadyWorkCountDialog").createDialog({
			width: 250,
			height: 200,
			title:'导出困难详细信息',
			url:PATH+'/common/exportExcel.jsp',
			postData:{
				gridName:'steadyWorkList',
				downloadUrl:PATH+'/threeRecords/peopleaspirationCataLogComprehensive/downloadCataLog.action'
				},
			buttons: {
	   			"导出" : function(event){
	   				exceldownloadSubmitForm();
	        		$(this).dialog("close");
   				},
	   			"关闭" : function(){
	        		$(this).dialog("close");
	   			}
			},
			shouldEmptyHtml:false
		});
	}else{
		$.messageBox({level:'warn',message:"列表中没有数据，不能导出！"});
	}
});
</script>
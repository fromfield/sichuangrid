<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.tianque.domain.property.OrganizationType,com.tianque.domain.Organization,com.tianque.domain.property.OrganizationLevel,
         com.tianque.core.util.ThreadVariable,com.tianque.domain.User" %>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="/includes/baseInclude.jsp" />

<s:action name="getLoginInfo" var="loginAction" executeResult="false" namespace="/sessionManage" />
<s:action name="getFullOrgById" var="getFullOrgById" executeResult="false" namespace="/sysadmin/orgManage" >
	<s:param name="organization.id" value="#loginAction.user.organization.id"></s:param>
</s:action>

<%
Organization userOrg = ThreadVariable.getUser().getOrganization();
User user = ThreadVariable.getUser();
boolean isFun = false;
if (userOrg != null && userOrg.getOrgType() != null && userOrg.getOrgLevel() != null) {
	if (userOrg.getOrgType().getDisplayName().equals(OrganizationType.getInternalProperties().get(OrganizationType.FUNCTIONAL_ORG).getDisplayName())
			&& userOrg.getOrgLevel().getInternalId() == OrganizationLevel.DISTRICT) {
		if(!userOrg.getDepartmentNo().endsWith("1jg") && !userOrg.getDepartmentNo().endsWith("1lx") && !userOrg.getDepartmentNo().endsWith("1xw")){
			isFun = true;
		}else{
			isFun = false;
			request.setAttribute("isJg", true);
		}
	}	
	request.setAttribute("isFun", isFun);
    request.setAttribute("orgLevel", userOrg.getOrgLevel().getInternalId());
	request.setAttribute("isTown", userOrg.getOrgLevel().getInternalId() == OrganizationLevel.TOWN);
	request.setAttribute("isVillage", userOrg.getOrgLevel().getInternalId() == OrganizationLevel.VILLAGE);
	
	Long rootId = userOrg.getId();
	request.setAttribute("currentId", rootId);
	request.setAttribute("orgName", userOrg.getOrgName());
	request.setAttribute("userName", user.getUserName());
}
%>

<style>
#orgSelector{
	width:138px
}
.print{
	float:right;
	width: 24px;
	height: 20px;
	margin: 4px;
	background: url(${resource_path}/resource/system/images/table_print_hover.jpg) no-repeat;
}
table {
	border-collapse: collapse;
	border: none;
	width: 100%;
	text-align: center;
	font-size: 11px;
}
td{
	border: solid #000 1px;
}
</style>
<div id="nav" class="ui-corner-all">
 	<c:if test="${isTown}">
		<jsp:include page="/common/orgSelectedComponent.jsp"/>
	</c:if>
	<c:if test="${isJg}">
		<jsp:include page="/common/orgSelectedComponent.jsp">
			<jsp:param  name="selectType" value="account"/>  
		</jsp:include>
	</c:if>
	
	
	<select name="reportYear" id="year" onchange=""></select>
    <label style="padding:0 10px;line-height:25px;">年</label>
    <select name="reportMonth" id="month" onchange=""></select>
    <label style="padding:0 10px;line-height:25px;">月</label>
    
	<a id="createStatistic" href="javascript:void(0)" onclick="reportMonthChange()"><span>加载</span></a>
	<a id="ecxcelExport" href="javascript:void(0)" style="float: right;"><span>报表下载</span></a>
</div>

	<c:if test="${isVillage}">
		<%@ include file="/account/report/month/threeRecordsVillageReportMonth.jsp" %>
	</c:if>
	<c:if test="${isTown}">
		<%@ include file="/account/report/month/threeRecordsTownReportMonth.jsp" %>
	</c:if>
	<c:if test="${isFun}">
		<%@ include file="/account/report/month/threeRecordsFunReportMonth.jsp" %>
	</c:if>
	<c:if test="${isJg}">
		<%@ include file="/account/report/month/threeRecordsDistrictReportMonth.jsp" %>
	</c:if>

<div id="accountPrintDlg"></div>

<script type="text/javascript">
var thisTime=new Date();
var addMonth=thisTime.getMonth()+1;
var formatdate= thisTime.getFullYear()+"-"+addMonth+"-"+thisTime.getDate();
$("#time").text("填报日期："+formatdate);
$(function(){
	autoFillYearAndMonth();
	$("#year").change(function(){
		$("#month").empty();
		getmonth();
	});
	$("#ecxcelExport").click(function(){
		exportReport('monthReport');
	});
});

function clearDiv(){
	$("#reportContent").empty();
	$(".reportData").empty();
}

var upSelect = 0;
function reportMonthChange(){
	if($("#year").val() > 2015){
		var thisTime=new Date();
		var month=thisTime.getMonth()+1;
		if($("#month").val() == month){
			$.messageBox({level: 'warn', message: "当月报表将在月底生成，请于下月查看！"});
			return;
		}
	}
	if(${isFun}){//职能部门直接查询
		getReportData(${currentId});
		return;
	}
	if(${isVillage}){//村社区直接查询
		getReportData();
		return;
	}
	$.ajax({
		url:'${path}/threeRecords/accountReport/getSelectOrg.action',
		data:{
			"orgId":$("#currentOrgId").attr("value")
		},
		success:function(data){
			if(data != null){
				if(data == upSelect){//跟上次查询处于同一层级则不切换显示图表
					getReportData();
					return;
				}
				clearDiv();//清除当前图表，加载新图表
				if(data == 1){
					$(".reportData").load("${path}/account/report/month/threeRecordsVillageReportMonth.jsp?userName=" + "${userName}&orgName=" + "${orgName}");
					getReportData();
				}else if(data == 2){
					$(".reportData").load("${path}/account/report/month/threeRecordsTownReportMonth.jsp?userName=" + "${userName}&orgName=" + "${orgName}");
					getReportData();
				}else if(data == 3){
					$(".reportData").load("${path}/account/report/month/threeRecordsJgReportMonth.jsp?userName=" + "${userName}&orgName=" + "${orgName}");
					getReportData();
				}else if(data == 4){
					$(".reportData").load("${path}/account/report/month/threeRecordsFunReportMonth.jsp?userName=" + "${userName}&orgName=" + "${orgName}");
					getReportData($("#currentOrgId").attr("value"));
				}else if(data == 5){
					$(".reportData").load("${path}/account/report/month/threeRecordsDistrictReportMonth.jsp?userName=" + "${userName}&orgName=" + "${orgName}");
					getReportData();
				}
				upSelect = data;
			}
		}
	})
}

function autoFillYearAndMonth(){
	$.ajax({
		async: false,
		url: "${path }/stat/currentTime/getCurrentTimeForYear.action",
		success:function(responseData){
			for(var i = 0;i<responseData.length;i++){
				if (responseData[i] > 2012) {
					$("#year").append("<option value='"+responseData[i]+"'>" + responseData[i] + "年</option>");
				}
			}
			getmonth();
		}
	});
}

function getmonth(){
	$.ajax({
		async: false,
		url: "${path }/stat/currentTime/getCurrentTimeForMonth.action?currenYear="+$("#year").val(),
		success:function(responseData){
			for(var i = 0;i<responseData.length;i++){
				$("#month").append("<option value='"+responseData[i]+"'>"+responseData[i]+"</option>");
			}
		}
	});
}


var idTmr;
function  getExplorer() {
	var explorer = window.navigator.userAgent ;
	//ie 
	if (explorer.indexOf("MSIE") >= 0) {
		return 'ie';
	}
	//firefox 
	else if (explorer.indexOf("Firefox") >= 0) {
		return 'Firefox';
	}
	//Chrome
	else if(explorer.indexOf("Chrome") >= 0){
		return 'Chrome';
	}
	//Opera
	else if(explorer.indexOf("Opera") >= 0){
		return 'Opera';
	}
	//Safari
	else if(explorer.indexOf("Safari") >= 0){
		return 'Safari';
	}
}
function exportReport(tableId) {//整个表格拷贝到EXCEL中
	if(getExplorer()=='ie'){
		var curTbl = document.getElementById(tableId);
		var oXL = new ActiveXObject("Excel.Application");
		
		//创建AX对象excel 
		var oWB = oXL.Workbooks.Add();
		//获取workbook对象 
		var xlsheet = oWB.Worksheets(1);
		//激活当前sheet 
		var sel = document.body.createTextRange();
		sel.moveToElementText(curTbl);
		//把表格中的内容移到TextRange中 
		sel.select();
		//全选TextRange中内容 
		sel.execCommand("Copy");
		//复制TextRange中内容  
		xlsheet.Paste();
		//粘贴到活动的EXCEL中       
		oXL.Visible = true;
		//设置excel可见属性

		try {
			var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");
		} catch (e) {
			print("Nested catch caught " + e);
		} finally {
			oWB.SaveAs(fname);

			oWB.Close(savechanges = false);
			//xls.visible = false;
			oXL.Quit();
			oXL = null;
			//结束excel进程，退出完成
			//window.setInterval("Cleanup();",1);
			idTmr = window.setInterval("Cleanup();", 1);

		}
		
	}
	else{
		tableToExcel(tableId)
	}
}
function Cleanup() {
    window.clearInterval(idTmr);
    CollectGarbage();
}
var tableToExcel = (function() {
	  var uri = 'data:application/vnd.ms-excel;base64,',
	  template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
		base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) },
		format = function(s, c) {
			return s.replace(/{(\w+)}/g,
			function(m, p) { return c[p]; }) }
		return function(table, name) {
		if (!table.nodeType) table = document.getElementById(table)
		var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
		window.location.href = uri + base64(format(template, ctx))
	  }
	})()
</script>
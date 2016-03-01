<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />

<div id="issuePrint" style="overflow: auto;height:100%;width:100%">
<style type="text/css">
        .printTable_title{position:relative;margin:0 5px;background: #E7EDF5;
              border-top: 1px solid #ccc;border-left:1px solid #ccc;
              border-right: 1px solid #ccc;font-size: 12px;height: 23px;line-height: 28px;
              padding-top: 2px;font-weight:bold;color: #333;text-align:center;
              font-size:16px;width:640px !important;border-bottom:1px solid #ccc;}
		.SigmaReportPrint table{
			width:595px;  
			border-collapse:collapse;
		}
		.SigmaReportPrint td{
			font-weight:normal;
			color:#333;
		}
		.SigmaReportPrint .head{
		    width:595px;
			margin:0 5px;
			border-left:1px solid #ccc;
		}
		
		.SigmaReportPrint .body{
			margin:0 5px;
			border-left:1px solid #ccc;
		}
		
		.SigmaReportPrint .body tr.selected{
			background-color:#CCE4F9;
		}
		.SigmaReportPrint .body tr.disabled{
			background:#F0EDED;
			color:#CECECE;
		}
		
		.SigmaReportPrint .body tr.hover{
			background-color:rgb(255,255,151);
		}
		
		.SigmaReportPrint .scroll{
		}
		
		.SigmaReportPrint .body td{
			border-right:1px solid #ccc;
			border-bottom:1px solid #ccc;
			font-size:12px;
			height:20px;
			padding:0px;
			text-align:center;
			color:#333;
		}
		
		.SigmaReportPrint .body input{
			font-size:12px;
			border:0px solid red;
		}
		.SigmaReportPrint  input{
			font-size:12px;
			border:0px solid red;
		}
		
		.SigmaReportPrint .body div.focused{
			background-color:rgb(255,250,255);
		}
		
		.SigmaReportPrint .body div{
			padding:3px;
			display:block;
			text-align:center;
		}
		.SigmaReportPrint .body div.checked{
			width:16px;
			height:16px;
			border:1px solid red;
			background-image:url(right.gif);
			background-repeat:no-repeat;
		}
		
		.SigmaReportPrint .head td{
			background:#e7edf5;
			border-right:1px solid #ccc;
			border-bottom:1px solid #ccc;
			font-size:12px;
			height:28px;
			line-height:28px;(
			overflow:hidden;
			padding-top:2px;
		}
		
		
		.SigmaReportPrint .head div.title{
			padding-top:2px;
			float:left;
			height:18px;
			overflow:hidden;
			white-space:nowrap;
		}
	</style>
<div id="gridboxIssue" class="SigmaReportPrint">
</div>
</div>
<script type="text/javascript">
var issueGrid;
var url;
function loadPrint() {
	switch($("#type").val()){
	case '1':
		url='${path}/statAnalyse/issueReport/getDataColumnByLevel.action';
		break;
	case '2':
		url='${path}/statAnalyse/issueReport/getDataColumnByArea.action';
		break;
	case '3':
		url='${path}/statAnalyse/issueReport/getDataColumnByLevel.action';
		break;
	case '4':
		url='${path}/statAnalyse/issueReport/getDataColumnByArea.action';
		break;
	case '5':
		url='${path}/statAnalyse/issueReport/getDataColumnByArea.action';
		break;
	case '6':
		url='${path}/statAnalyse/issueReport/getDataColumnByArea.action';
		break;
	case '7':
		url='${path}/statAnalyse/issueReport/getDataColumnByArea.action';
		break;
	case '8':
		url='${path}/statAnalyse/issueReport/getDataColumnByAreaNew.action';
		break;
	case '9':
		url='${path}/statAnalyse/issueReport/getDataColumnByLevelNew.action';
		break;
	case '10':
		url='${path}/statAnalyse/issueReport/getDataColumnByLevelNew.action';
		break;
	case '11':
		url='${path}/statAnalyse/issueReport/getDataColumnByLevelNew.action';
		break;
	}
	$.ajax({
		url:url,
		data:{
			"year":$("#cyear").val(),
			"month":getMonthValue(),
			"parentOrgId":getCurrentOrgId(),
			"queryType":$("#type").val(),
			"reportDateType.id":$("#reoprtDateType").val()
		},
		success:function(data){
			if(data == null){
				$.messageBox({
					message: data,
					level: "error"
				});
				return;
			}
			issueGrid.bindData(data);
		}
	})
}
$(document).ready(function(){
	issueGrid = new SigmaReport("gridboxIssue",context,columns, "SigmaReportPrint","printTable_title");
	loadPrint();
})
</script>



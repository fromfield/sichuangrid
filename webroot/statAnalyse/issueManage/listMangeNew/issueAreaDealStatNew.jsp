<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />
<div id="chartsTabs">
	<div id="gridbox" class="SigmaReport">
	</div>
</div>

<script type="text/javascript">
function onOrgChanged(){
	$.ajax({
		url:'${path}/statAnalyse/issueReport/getDataColumnByAreaNew.action',
		data:{
			"year":$("#cyear").val(),
			"month":getMonthValue(),
			"parentOrgId":getCurrentOrgId(),
			"queryType":$("#type").val(),
			"reportDateType.id":$("#reoprtDateType").val()
		},
		success:function(data){
			if(data == null || (data[0]!= null &&data[0].organization == null)){
				$.messageBox({
					message: data,
					level: "error"
				});
				return;
			}
			grid.bindData(data);
		}
	})
}

$(document).ready(function(){
	document.title=$("#type").find("option:selected").text();
	columns = [
					{name:"organization.orgName",caption:"区域",width:120,mode:"string"},
					{name:"addIssueSum",caption:"新增事件",width:80,mode:"number",format:"#"},
					{name:"doneIssueSum",caption:"办结事件",width:80,mode:"number",format:"#"},
					{name:"issueSum",caption:"事件总数",width:80,mode:"number",format:"#"},
					{name:"extendedDoingSum",caption:"超期在办",width:80,mode:"number",format:"#"},
		   			{name:"completionRate",caption:"事件办结率",width:80,mode:"string"}
				];
	grid = new SigmaReport("gridbox",context,columns);
	onOrgChanged();
	
	$(".print").click(function(){
		$("#issuePrintDlg").createDialog({
			width:680,
			height:450,
			title:"打印",
			url:'${path}/statAnalyse/issueManage/listMange/print.jsp',
			buttons: {
			   "打印" : function(){
					print();
		  	   },
			   "关闭" : function(){
				   $("#issuePrintDlg").dialog("close");
			   }
			}
		});
	});
});
</script>
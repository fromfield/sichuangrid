<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp" />
<div>
	<div id="gridbox" class="SigmaReport"></div>
</div>
<div id="PrintDlg"></div>
<script type="text/javascript">
	var fitColumns=true;
		var columns = [
			{name:"orgname",caption:"区域",mode:"string"}
			<@pop.JugePermissionTag ename="propagandaAndVerificationReportForm">
				,
				{name:"general",caption:"流动人口",children:[
				{name:"general",caption:"宣传核查",children:[
					{name:"policeSum",caption:"网格员发送",width:60,mode:"string"},
					{name:"policeVisit",caption:"已签收",width:35,mode:"string"}
				]}
			</@pop.JugePermissionTag>
			<@pop.JugePermissionTag ename="workingSituationReportForm">
				,
				{name:"general",caption:"民警带领开展工作",children:[
				    {name:"publicSum",caption:"网格员发送",width:60,mode:"string"},
					{name:"publicVisit",caption:"已签收",width:35,mode:"string"}
					
				]}
			</@pop.JugePermissionTag>
			<@pop.JugePermissionTag ename="exceptionSituationReportForm">
				,
				{name:"general",caption:"异常情况报告",children:[
				    {name:"exceptionSum",caption:"网格员发送",width:60,mode:"string"},
					{name:"exceptionVisit",caption:"已签收",width:35,mode:"string"}
					
				]}
			]}
			</@pop.JugePermissionTag>
			<@pop.JugePermissionTag ename="druggyTaskReportForm">
				,
				{name:"general",caption:"吸毒人员",children:[
				{name:"general",caption:"",children:[
					{name:"druggySum",caption:"网格员发送",width:60,mode:"string"},
					{name:"druggyVisit",caption:"已签收",width:35,mode:"string"}
				]}]}
			</@pop.JugePermissionTag>
				,
				{name:"general",caption:"严重精神障碍患者",children:[
				{name:"general",caption:"",children:[
					{name:"mentalPatientSum",caption:"网格员发送",width:55,mode:"string"},
					<@pop.JugePermissionTag ename="mentalPatientJusticeTaskReportForm">
					{name:"mentalPatientJusticeVisit",caption:"卫生所签收",width:55,mode:"string"},
					</@pop.JugePermissionTag>
					<@pop.JugePermissionTag ename="mentalPatientPoliceTaskReportForm">
					{name:"mentalPatientPoliceVisit",caption:"派出所签收",width:55,mode:"string"
					</@pop.JugePermissionTag>}
				]}]}
			<@pop.JugePermissionTag ename="termerRecordReportForm">
				,
				{name:"general",caption:"社区服刑人员",children:[
				{name:"general",caption:"",children:[
					{name:"rectificativeSum",caption:"网格员发送",width:60,mode:"string"},
					{name:"rectificativeVisit",caption:"已签收",width:35,mode:"string"}
				]}]}
			</@pop.JugePermissionTag>
			<@pop.JugePermissionTag ename="positiveInfoRecordReportForm">
				,
				{name:"general",caption:"刑释人员",children:[
				{name:"general",id:"rective",caption:"",children:[
					{name:"positiveSum",caption:"网格员发送",width:60,mode:"string"},
					{name:"positiveVisit",caption:"已签收",width:35,mode:"string"}
				]}]}
			</@pop.JugePermissionTag>
			<@pop.JugePermissionTag ename="hiddenDangerReportForm">
				,
				{name:"general",caption:"发现治安隐患",children:[
				{name:"general",caption:"",children:[
					{name:"hiddenDangerSum",caption:"网格员发送",width:60,mode:"string"},
					{name:"hiddenDangerVisit",caption:"已签收",width:35,mode:"string"}
				]}]}
			</@pop.JugePermissionTag>
		];


var grid = null;

function changeTable(){
   $("table td[caption='吸毒人员']").attr("rowspan","2");
   $("table td[caption='异常情况报告']").next().remove();
   $("table td[caption='严重精神障碍患者']").attr("rowspan","2");
   $("table td[caption='异常情况报告']").next().remove();
   $("table td[caption='社区服刑人员']").attr("rowspan","2");
   $("table td[caption='异常情况报告']").next().remove();
   $("table td[caption='刑释人员']").attr("rowspan","2");
   $("table td[caption='异常情况报告']").next().remove();
   $("table td[caption='发现治安隐患']").attr("rowspan","2");
   $("table td[caption='异常情况报告']").next().remove();
   
   $("table td[caption='吸毒人员']").attr("style","text-align:center;padding:15px;");
   $("table td[caption='严重精神障碍患者']").attr("style","text-align:center;padding:15px;");
   $("table td[caption='社区服刑人员']").attr("style","text-align:center;padding:15px;");
   $("table td[caption='刑释人员']").attr("style","text-align:center;padding:15px;");
   $("table td[caption='发现治安隐患']").attr("style","text-align:center;padding:15px;");
   $("table td[caption='区域']").attr("style","text-align:center;padding:20px;");
}

function onOrgChanged(){
    var orgId=getCurrentOrgId();
	$.ajax({
		dataType:"json",
		url:'${path }/plugin/taskListManage/common/getVisitList.action?orgId='+orgId,
		success:function(data){
			grid.bindData(data);
		}
	})
}

$(document).ready(function(){
	//$("#content").hide();
	$.gridboxHeight();
	var context = {};
	grid = new SigmaReport("gridbox",context,columns,null,null,"任务清单",null,null);
	//setTimeout('onOrgChanged()',350);
	onOrgChanged();
	changeTable();
	
	$(".print").click(function(){
		
		var url = '${path}/task/reportForm/taskListPrint.ftl?parentOrgId='+getCurrentOrgId()+"&moduleName="+document.title;
		$("#PrintDlg").createDialog({
			width: 1200,
			height:490,
			title:document.title,
			url:url,
			buttons: {
			   "打印" : function(){
				print();
		  	   },
			   "关闭" : function(){
			        $("#PrintDlg").dialog("close");
			   }
			}
		});
	});
	
	function print(){
		$("#Print").printArea();
		$("#PrintDlg").dialog("close");
	}
})
	

</script>


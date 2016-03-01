<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setAttribute("moduleName",request.getParameter("moduleName"));%>
<%request.setAttribute("lowerCaseModuleName",request.getParameter("moduleName").substring(0,1).toLowerCase()+request.getParameter("moduleName").substring(1));%>
<%request.setAttribute("upperCaseModuleName",request.getParameter("moduleName").toUpperCase());%>
<%request.setAttribute("moduleCName",request.getParameter("moduleCName"));%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<script type="text/javascript">
<pop:formatterProperty name="attentionExtent" domainName="@com.tianque.domain.property.PropertyTypes@ATTENTION_EXTENT" />
function attentionExtentColor(el,options,rowData){
	var displayName=attentionExtentFormatter(el,options,rowData);
	if(displayName=='undefined'||displayName=='')
		return '';
	else if(displayName=='严重')
		return '<span>严重：<span style="color:#ff0000;">█████</span></span>';
	else if(displayName=='中等')
		return '<span>中等：<span style="color:#ffcc00;">███</span></span>';
	else if(displayName=='一般')
		return '<span>一般：<span style="color:#99cc00;">█</span></span>';
	else
		return '';
}
	var title = document.title;
	function onOrgChanged(){
		$("#areaDatatable").setGridParam({
			url:"${path}/baseinfo/leaderViewManage/statisticsBaseInfo.action?isGrid=true",
			datatype:"json",
			page:1
		});
		$("#areaDatatable").setPostData({
	    	"orgId":getCurrentOrgId(),
	    	"tableName":"${lowerCaseModuleName}"
	   	});
	
		$("#areaDatatable").trigger("reloadGrid");
		getBaseInfoSummary();
	}
	
	function getBaseInfoSummary(){
		$("#dataMonthTable").setGridParam({
			url:"${path}/baseinfo/leaderViewManage/statisticsSummary.action",
			datatype:"json",
			page:1,
			loadComplete:function(){
				var personGeneralConditionLine = $("#containerSummary").lineChart({
					ajax:false,
					table:document.getElementById('gbox_dataMonthTable')
				});
				personGeneralConditionLine.series[1].hide();
// 				personGeneralConditionLine.series[2].hide();
			}
		});
		$("#dataMonthTable").setPostData({
	    	"orgId":getCurrentOrgId(),
	    	"tableName":"${lowerCaseModuleName}"
	   	});
		$("#dataMonthTable").trigger("reloadGrid");
	}
	
	$("#refreshOrgTree1").click(function(){
		$("#searchByCondition").attr("value","请输入姓名或身份证号码");
		$("#searchText").attr("value","请输入姓名或身份证号码");
	});
	$(function(){
		var tableHeight=($(".ui-layout-center").height()-$("#thisCrumbs").height()-190)/2-10;
		var tabWidth = $(".ui-layout-center").width() - 400;
// 		function numberFormber(el, options, rowData){
// 			return rowData.allCount-rowData.attentionCount;
// 		}
		
		$(".leaderTit").each(function(){
			$(this).text(document.title+$(this).text());
		});
		
		$("#areaDatatable").jqGridFunction({
			rowNum:100,
			datatype:"local",	
			width:360,
			height:tableHeight-20,
			colModel:[
		  		{name:'id',index:'id',hidden:true},
		  		{name:'statisticsType',index:'statisticsType',label:"地区",sortable:false,width:70},
		 		{name:'todayAddCount',index:'todayAddCount',label:"今天新增",sortable:false,width:60},
		 		{name:'thisMonthCount',index:'thisMonthCount',label:"本月新增",sortable:false,width:60},
		 		{name:'attentionCount',index:'attentionCount',label:"人员总数",sortable:false,width:80}
// 		 		{name:'allCount',index:'allCount',label:"人员总数",sortable:false,width:80}
			],
			autowidth:false,
			shrinkToFit:true
		});
		$("#dataMonthTable").jqGridFunction({
			datatype:"local",	
			width:tabWidth,
			height:tableHeight-20,
			autowidth:false,
			shrinkToFit:true,
			colModel:[
		  		{name:'id',index:'id',hidden:true},
		  		{name:'statisticsType',index:'statisticsType',label:"月份",sortable:false,width:70},
		 		{name:'thisMonthCount',index:'thisMonthCount',label:"本月新增",sortable:false,width:70},
		 		{name:'attentionCount',index:'attentionCount',label:"人员总数",sortable:false,width:80}
// 		 		{name:'allCount',index:'allCount',label:"人员总数",sortable:false,width:80}
			]
		});	
		
		if(getCurrentOrgId() != null && getCurrentOrgId() != ""){
			onOrgChanged();
		}
		
		if(getCurrentOrgId() != null && getCurrentOrgId() != ""){
			getBaseInfoSummary();
		}
		$("#searchByIdcardA").click(function(){
			$("#${moduleName}statisticsListDialog").createDialog(getDialogParam("fast"));
		});
			
		$("#searchHighA").click(function(){
			var conditions = $("#searchByCondition").val();
			if(conditions == '请输入姓名或身份证号码') conditions = '';
			$("#${lowerCaseModuleName}Dialog").createDialog({
				width: 650,
				height: 330,
				title: title+'查询-请输入查询条件',
				modal:true,
				url: '${path}/baseinfo/'+getManageName()+'/dispatchOperate.action?mode=search&organizationId='+getCurrentOrgId()+'&conditions='+conditions,
				buttons: {
					"查询" : function(event){
						$("#${moduleName}statisticsListDialog").createDialog(getDialogParam("advanced"));
				   },
			   		"关闭" : function(){
			        	$(this).dialog("close");
			   		}
				}
			});
		});
		
		// add by zhanL at 2013/08/02 18:19
		
		function getDialogParam(type){
			return {
				width: 900,
				height: 600,
				title: title+'信息',
				modal:true,
				url: '${path}/baseinfo/'+getManageName()+'/dispatchOperate.action?mode=statistic&searchType='+type,
				buttons: {
			   		"关闭" : function(){
			        	$(this).dialog("close");
			   		}
				}
			};
		}
		function getManageName(){
			var manage = "${lowerCaseModuleName}Manage";
			if("${lowerCaseModuleName}"=="aidspopulation"){
				manage = "${lowerCaseModuleName}sManage"
			}
			return manage;
		}
		var layout=function(){
			var wrapWidth=$(".ui-layout-center").width()-400;
			var wrapHeight=($(".ui-layout-center").height()-$("#thisCrumbs").height()-160)/2;
			var tableHeight=wrapHeight-50;
// 			$(".highcharts-container,.warpTable").height(wrapHeight);
// 			$(".highcharts-container").width(wrapWidth);
		}
		layout();
		$(window).resize(function(){
			layout();
		})
	});
</script>
<s:include value="/baseinfo/leaderView/searchButton.jsp"></s:include>


<div class="leaderTit">各月份图表</div>
<div class="leaderCon">
	<div id="containerSummary" class="highcharts-container_1">
	</div>
	<div class="clear"></div>
</div>

<div class="leaderTit_1"></div>
<div class="leaderCon leaderCon_1">
	<div class="warpTable_1 ">
		<table id="dataMonthTable"></table>
	</div>
	<div class="warpTable1_1">
		<table id="areaDatatable">
		</table>
	 </div>
</div>
<div id="${lowerCaseModuleName}Dialog"></div>
<div id="${moduleName}statisticsListDialog"></div>
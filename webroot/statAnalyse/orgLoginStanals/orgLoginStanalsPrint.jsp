<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />
<div id="orgLoginStanalsPrint" >
<style type="text/css">
        .printTable_title{position:relative;margin:0 5px;background: #E7EDF5;
              border-top: 1px solid #ccc;border-left:1px solid #ccc;
              border-right: 1px solid #ccc;font-size: 12px;height: 28px;line-height: 28px;
              padding-top: 2px;font-weight:bold;color: #333;text-align:center;
              font-size:16px;width:889px !important;border-bottom:1px solid #ccc;}
		.SigmaReportPrint table{
			width:890px;  
			border-collapse:collapse;
		}
		.SigmaReportPrint td{
			font-weight:normal;
			color:#333;
		}
		.SigmaReportPrint .head{
		    width:890px;
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
			white-space:nowrap;
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
<div id="orgLoginStanalsGridbox" class="SigmaReportPrint" style="overflow: auto;height:100%;width:100%">
</div>
</div>
	
	<input type="hidden" id="nowMonth" value='<s:property value="#parameters.nowMonth"/>'/>
<script type="text/javascript">
$(document).ready(function(){
	var nowMonth = $("#nowMonth").val();
	
	//$("#title_enterPriseGridbox").html(data.orgName+str+"报表");
	onOrgChangedForPrint();
	$("#title_orgLoginStanalsGridbox").children().remove();
	//$(".printTable_title").width(970);
	//if(nowMonth!=1 && nowMonth!=5 && nowMonth!=7 && nowMonth!=10){
		//$(".printTable_title").width(830)
	//}
});
function reloadReportDateForPrint(){
	$.ajax({
		async: false,
		url: '${path}/statAnalyse/orgLoginStanalsManager/findOrgLoginStanalsByOrgIdForListPage.action',
		data:{
			"nowYear": '<s:property value="#parameters.nowYear"/>',
			"nowMonth":'<s:property value="#parameters.nowMonth"/>',
			"orgId":'<s:property value="#parameters.orgId"/>',
			"internalId":'<s:property value="#parameters.internalId"/>'
		},
		success:function(responseData){
			rebuildeGridForPrint(responseData);
		}
	});
}
var blueRender = new function(){
	this.paint = function(grid,row,col){
		var data = row.getCellValue(col);
		if(data===null || data==="" || data===undefined) date= "0";
		if(row.getCellValueByColName('workday_month')==row.getCellValueByColName('loggedday_month'))
			return "<span style='color:green;font-weight:bold;'>"+data+"</span>";
		else
			return ""+data+"";
	}
}

var redRender = new function(){
	this.paint = function(grid,row,col){
		var data = row.getCellValue(col);
		if(data===null || data==="" || data===undefined) date= "0";
		if(data<3)
			return "<span style='color:red;font-weight:bold;'>"+data+"</span>";
		else
			return ""+data+"";
	}
}

function rebuildeGridForPrint(reportData){
   	var context = {};
   	var columns = [		
   			{name:"bigTitle",caption:reportData.bigTitle,children:[
				{name:"orgName",caption:"组织结构名称",width:100,mode:"string"},
				{name:"name",caption:"用户名",width:100,mode:"string"},
				{name:"helpinfo",caption:reportData.columnCaption[0],
					children:[{name:"workday_month",caption:"工作天数",width:85,mode:"number",format:"#"},
				     	     {name:"loggedday_month",caption:"登录天数",width:85,mode:"blueRender",format:"#"}]
				},
				{name:"helpinfo",caption:reportData.columnCaption[1],
					children:[{name:"workday_week1",caption:"工作天数",width:70,mode:"number",format:"#"},
					          {name:"loggedday_week1",caption:"登录天数",width:70,mode:"redRender",format:"#"}]
				},
				{name:"helpinfo",caption:reportData.columnCaption[2],
					children:[{name:"workday_week2",caption:"工作天数",width:70,mode:"number",format:"#"},
					          {name:"loggedday_week2",caption:"登录天数",width:70,mode:"redRender",format:"#"}]
				},	
				{name:"helpinfo",caption:reportData.columnCaption[3],
					children:[{name:"workday_week3",caption:"工作天数",width:70,mode:"number",format:"#"},
					          {name:"loggedday_week3",caption:"登录天数",width:70,mode:"redRender",format:"#"}]
				},	
				{name:"helpinfo",caption:reportData.columnCaption[4],
					children:[{name:"workday_week4",caption:"工作天数",width:70,mode:"number",format:"#"},
					          {name:"loggedday_week4",caption:"登录天数",width:70,mode:"redRender",format:"#"}]
				},	
				{name:"helpinfo",caption:reportData.columnCaption[5],
					children:[{name:"workday_week5",caption:"工作天数",width:70,mode:"number",format:"#"},
					          {name:"loggedday_week5",caption:"登录天数",width:70,mode:"redRender",format:"#"}]
				}
   			]}			
   		];
	var is5col = false;
   	for(n=5;n>=0;n--){
   		if(reportData.columnCaption[n]==null){
   			columns[0]['children'].pop();
   			is5col = true;
   		}
   	}
   	orgLoginStanalsGrid = new SigmaReport("orgLoginStanalsGridbox",context,columns, "SigmaReportPrint","printTable_title");
	//grid = new SigmaReport("orgLoginStanalsGridbox",context,columns);
	orgLoginStanalsGrid.registerRender("blueRender",blueRender);
	orgLoginStanalsGrid.registerRender("redRender",redRender);
	orgLoginStanalsGrid.bindData(reportData.objectDataList);
	if(is5col){
		$("#title_orgLoginStanalsGridbox").width(830);
	}
}

function onOrgChangedForPrint(){
        $.ajax({
            url:"${path}/statAnalyse/statRegradedPointManage/nextOrgLevelNameByOrgId.action",
            data:{
        			"targeOrgId":function(){return $("#orgId").val();}
                },
            success:function(data){
                    //$("#nextOrgLoginStanalsName").html(data+"登录统计");
                }
        });
        reloadReportDateForPrint();
}

</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />

<div class="content">
	<div class="ui-corner-all" id="nav">
		<s:if test='!"areaDailyYear".equals(modeType)'>
			<pop:JugePermissionTag ename="addWorkingRecord">
				<a id="add" href="javascript:;"><span>新增</span></a>
			</pop:JugePermissionTag>
			<pop:JugePermissionTag ename="updateWorkingRecord">
				<a id="update" href="javascript:void(0)"><span>修改</span></a>
			</pop:JugePermissionTag>
			<pop:JugePermissionTag ename="deleteWorkingRecord">
				<a id="delete" href="javascript:void(0)"><span>删除</span></a>
			</pop:JugePermissionTag>
		</s:if>
		
		<pop:JugePermissionTag ename="viewWorkingRecord,viewAreaWorkingRecord">
				<a id="view" href="javascript:void(0)"><span>查看</span></a>
			</pop:JugePermissionTag>
	<%-- 	<pop:JugePermissionTag ename="searchWorkingRecord,searchAreaWorkingRecord"> --%>
	<%-- 		<a id="search" href="javascript:void(0)"><span>查询</span></a> --%>
	<%-- 	</pop:JugePermissionTag> --%>
		<a id="reload" href="javascript:void(0)"><span>刷新</span></a>
	</div>

	<div style="width: 100%;" id="grid_content" >
		<table id="dailyLogList"></table>
		<div id="dailyLogListPager"></div>
	</div>
</div>
<script type="text/javascript">
var widthWhenAdd=650;
var heightWhenAdd=500;
var currentOrgId = getCurrentOrgId();
var dailyId = '${dailyDirectoryId}';
var globalFormatterArrary=new Array();
$(document).ready(function(){
	var gridoption = {
		url:"${path}/workingRecord/gridManagementNormalManage/gridManagementNormalList.action?organization.id="+currentOrgId+"&dailyDirectoryId="+dailyId,
		datatype: "json",
		colNames:['id','时间','工作内容','主要情况','附件','录入时间','有效性'],
	   	colModel:[
	        {name:"id",index:"id",hidden:true},
	        {name:'activityDate',sortable:false,width:120},
	        {name:'work',sortable:false,width:150},
	        {name:'content',sortable:false,width:350},
	        {name:"dailyAttachFiles",sortable:false,width:120,formatter:formatterAttachFile},
	        {name:'createDate',index:"createDate",width:150},
	        {name:'expiredEntering',hidden:false,sortable:false,width:150,formatter:expiredEnteringFormatter}
		],
		scrollrow:true,
		showColModelButton:true,
		multiselect:true,
		loadComplete: showDailyLogAttachFile,
		onSelectRow: showDailyLogAttachFile,
		ondblClickRow: doubleClickTable,
		gridComplete:afterGridComplete
	};

	$("#dailyLogList").jqGridFunction(gridoption);

	$("#add").click(function(event){
		var selectedNode = $.getSelectedNode(tree);
		if(!selectedNode.attributes.leaf){
			$.messageBox({message:"该目录不能新增台账信息，请选择底层目录新增!",level:"warn"});
			return ;
		}else{$("#dailyLogMaintanceDialog").createDialog({
			width:widthWhenAdd,
			height:heightWhenAdd,
			title:'新增'+innerTitle+'信息',
			modal : true,
			url:"${path}/workingRecord/gridManagementNormalManage/dispatch.action?mode=add"+"&dailyDirectoryId="+dailyDirectoryId,
			buttons :{
				"保存" : function(){
					$("#dailyLog-form").submit();
				},
				"关闭" : function(){
					$(this).dialog("close");
				}
			}
		});
		}
	});
	
	$("#update").click(function(event){
		var selectedIds = $("#dailyLogList").jqGrid("getGridParam", "selarrrow");
		if(selectedIds.length>1){
			$.messageBox({level:'warn',message:"只能选择一条记录！"});
	 		return;
		}
		var selectedId = getSelectedIdLast();
		if(selectedId==null){
			$.messageBox({message:"请选择要修改的台账信息!",level:"warn"});
	 		return;
		}
		$("#dailyLogMaintanceDialog").createDialog({
			width:widthWhenAdd,
			height:heightWhenAdd,
			title:'修改'+innerTitle+'信息',
			url:"${path}/workingRecord/gridManagementNormalManage/dispatch.action?mode=edit&gridManagementNormal.id="+selectedId+"&gridManagementNormal.dailyDirectoryId="+dailyId,
			buttons : {
				"保存" : function(){
					$("#dailyLog-form").submit();
				},
				"关闭" : function(){
					$(this).dialog("close");
				}
			}
		});
	});

	$("#delete").click(function(event){
		var selectedIds = $("#dailyLogList").jqGrid("getGridParam", "selarrrow");
		if(selectedIds==null || selectedIds.length == 0){
			$.messageBox({message:"请选择要删除的台账信息!",level:"warn"});
	 		return;
		}
		$.confirm({
			title:"确认删除",
			message:'此'+innerTitle+'信息删除后，将无法恢复,您确认删除吗?',
			width: 400,
			okFunc: function(){
				deleteDailyLog(selectedIds);
			}
		});
	});

	$("#view").click(function(event){
		var selectedIds = $("#dailyLogList").jqGrid("getGridParam", "selarrrow");
		if(selectedIds.length>1){
			$.messageBox({level:'warn',message:"只能选择一条记录！"});
	 		return;
		}
		var selectedId = getSelectedIdLast();
		if(selectedId==null){
			$.messageBox({message:"请选择要查看的台账信息!",level:"warn"});
	 		return;
		}
		doubleClickTable(selectedId);
	});

	$("#reload").click(function(){
		$("#dailyLogList").setGridParam({
			url:"${path}/workingRecord/gridManagementNormalManage/gridManagementNormalList.action?organization.id="+currentOrgId,
			postData:{
				"dailyDirectoryId":dailyId
			}
		});
		$("#dailyLogList").trigger("reloadGrid");
	})

});

function doubleClickTable(selectedId){
	$("#dailyLogMaintanceDialog").createDialog({
		width:widthWhenAdd,
		height:heightWhenAdd,
		title:'查看'+innerTitle+'信息',
		modal : true,
		url:"${path}/workingRecord/gridManagementNormalManage/dispatch.action?mode=view&gridManagementNormal.id="+selectedId,
		buttons :{
			"关闭" : function(){
				$(this).dialog("close");
			}
		}
	});
}

function getSelectedIdLast(){
	var selectedId;
	var selectedIds = $("#dailyLogList").jqGrid("getGridParam", "selarrrow");
	for(var i=0;i<selectedIds.length;i++){
		selectedId = selectedIds[i];
	}
	return selectedId;
}

function showDailyLogAttachFile(){
	$.each($(".popUpMore"), function(i, n){
		$.ajax({
			url:"${path}/workingRecord/gridManagementNormalManage/getGridManagementNormalById.action?gridManagementNormal.id="+$(n).attr("gridManagementNormalId")+"&organization.id="+currentOrgId,
			success:function(dailylog){
				var popMoreData = [];
				for(var j = 0; j < dailylog.dailyAttachFiles.length; j++){
					popMoreData[j]={id:dailylog.dailyAttachFiles[j].id, url:'${path}/workingRecord/gridManagementNormalManage/downloadDailyAttachFile.action?dailyAttachFile.id='+dailylog.dailyAttachFiles[j].id, text:dailylog.dailyAttachFiles[j].fileName,clickFun:function(){}};
				}
				$(n).popUpMore({data: popMoreData});
			}
		});
	});
}

function formatterAttachFile(el,options,rowData){
	if(rowData.dailyAttachFiles.length>0){
		return "<div style='clear:both' align='center'><a href='javascript:;' id='gridManagementNormal_"+rowData.id+"' style='color:#666666' class='popUpMore' gridManagementNormalId='"+rowData.id+"' >附件>></a></div>";
	}
	return "";
}

function deleteDailyLog(selectedIds){
	$.ajax({
		url:'${path}/workingRecord/gridManagementNormalManage/deleteGridManagementNormal.action?gridManagementNormalIds='+selectedIds+"&organization.id="+currentOrgId,
		success:function(data){
			if(data){
				$.messageBox({ message:"成功删除"+innerTitle+"!"});
				$("#dailyLogList").trigger("reloadGrid");
				return;
			}
        }
	});
}

function filterDailyLog(){
	$("#dailyLogList").setGridParam({
		url:'${path}/workingRecord/searchActivityWorkingRecord/searchActivityWorkingRecords.action'
	});
	$("#dailyLogList").setPostData({
		"searchActivityWorkingRecord.dealDate":$("#dailyLogDealDate").val(),
		"searchActivityWorkingRecord.name":$("#dailyLog-name").val(),
		"searchActivityWorkingRecord.proceedSite":$("#dailyLogSite").val(),
		"searchActivityWorkingRecord.subject":$("#dailyLogTheme").val(),
		"searchActivityWorkingRecord.dailyDirectoryId":dailyDirectoryId,
		"searchActivityWorkingRecord.orgId":currentOrgId
	});
	$("#dailyLogList").trigger("reloadGrid");
}
function expiredEnteringFormatter(cellvalue, options, rowObject){
	if(cellvalue=='1'){
		globalFormatterArrary.push(options.rowId);
		return "过期录入";
	}else{
		return "有效录入";
	}
}
function afterGridComplete(){
	var rowId;
	for(var i=0;i<globalFormatterArrary.length;i++){
	  rowId=globalFormatterArrary[i];
	 $("#dailyLogList>tbody>tr[id='"+rowId+"']").css('color','#f60')
	}
	globalFormatterArrary=new Array();
}
</script>



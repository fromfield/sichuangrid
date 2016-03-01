<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ include file="/includes/baseInclude.jsp"%>
<jsp:include page="/xichang/working/include/formatterAccount.jsp" />

<style type="text/css">
.myStyle {
	position: relative;
	left: 42%;
}
	.myStyle strong{
	    float:left;
	    margin-right: 3px;
	    width:18px;height:15px;
	    vertical-align:middle;
	    background: url('/resource/images/jingshi.png') 0 0 no-repeat;
	}

.myStyle .icon_blue  {background-position:0px 0px;}
.myStyle .icon_yellow{background-position:0px -20px;}
.myStyle .icon_orange{background-position:0px -40px;}
.myStyle .icon_red   {background-position:0px -60px;}
</style>

<div class="content">
	<div class="ui-corner-all" id="nav">
		<div class="btnbanner btnbannerData">
			<div class="ui-widget autosearch">
				<input class="basic-input" type="text" value="请输入稳定工作台账编号" name="searchText" id="searchText" maxlength="18" class="searchtxt" style="width: 180px;"
					onblur="value=(this.value=='')?'请输入稳定工作台账编号':this.value;" onfocus="value=(this.value=='请输入稳定工作台账编号')?'':this.value;" />
				<button id="refreshSearchKey" class="ui-icon ui-icon-refresh searchbtnico"></button>
			</div>
		</div>
		<a href="javascript:;" id="fastSearchButton"><span>搜索</span></a>
		<pop:JugePermissionTag ename="searchSteadyWork">
		    <a id="search" href="javascript:void(0)"><span>高级搜索</span></a>
	    </pop:JugePermissionTag>
	    <span class="lineBetween "></span>
		<pop:JugePermissionTag ename="addSteadyWork">
			<a id="add" href="javascript:;"><span>新增</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="updateSteadyWork">
			<a id="update" href="javascript:void(0)"><span>修改</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="normalSteadyWork">
			<a id="view" href="javascript:void(0)"><span>查看</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="deleteSteadyWork">
			<a id="delete" href="javascript:void(0)"><span>删除</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="recordsSteadyWork">
			<a id="records" href="javascript:void(0)"><span>情况记录</span></a>
		</pop:JugePermissionTag>
		<a id="reload" href="javascript:void(0);"><span>刷新</span></a>
	</div>
	<div style="width: 100%;">
		<table id="steadyWorkList"></table>
		<div id="steadyWorkListPager"></div>
	</div>
	<div id="steadyWorkDialog" style="overflow: auto"></div>
</div>
<script type="text/javascript">
<pop:formatterProperty name="createTableType" domainName="@com.tianque.domain.property.PropertyTypes@CREATE_TABLE_TYPE" />
var dialogWidth = 800;
var dialogHeight = 600;
function loadSteadyWorkData() {
	var initParam = {
			"state":0
	}
	$("#steadyWorkList").setGridParam({
		url:"${path}/account/steadyWorkManage/findUndoSteadyWorkForPageByOrgInternalCode.action",
		datatype: "json",
		page:1
	});
	$("#steadyWorkList").setPostData(initParam);
	$("#steadyWorkList").trigger("reloadGrid");
}

function rendWarning(el, options, rowData){
	var iconArray = "";
	if(rowData.warningType != null){
		if(0 == rowData.warningType){
			iconArray += "<div class='myStyle'><strong class='icon_blue' title='1-2人且事态在可控范围'></strong></div>";
		}else if(1 == rowData.warningType){
			iconArray += "<div class='myStyle'><strong class='icon_yellow' title='涉及3-9人且事态恶化的可能性'></strong></div>";
		}else if(2 == rowData.warningType){
			iconArray += "<div class='myStyle'><strong class='icon_orange' title='涉及10-30人且事态有扩大趋势'></strong></div>";
		}else if(3 == rowData.warningType){
			iconArray += "<div class='myStyle'><strong class='icon_red' title='涉及30人以上且事态还有扩大趋势的及涉及人数虽较少，但如不及时采取措施事态将恶化'></strong></div>";
		}
	}
	return iconArray;
}

function nameFormatter(el, options, rowData){
	if(rowData.peopleInfos!=null){
		return rowData.peopleInfos[0].name;
	}
}

function afterLoad(){

}

$(function (){
	$("#steadyWorkList").jqGridFunction({
		datatype: "local",
	   	colModel:[
	        {name:"id",index:"id",hidden:true,sortable:false},
	        {name:"encryptId",index:'id',frozen:true,hidden:true},
	        {name:"earingWarn", index:'earingWarn',label:'预警',formatter:earingWarnFormatter,width:65,frozen:true,sortable:false,align:'center' },
	        {name:"serialNumber",sortable:true,label:'编号',width:200},
	        {name:"warningType",formatter:rendWarning,sortable:true,label:'预警级别',width:100},
      		{name:'organization.orgName',index:'orgId',label:'所属区域', width:350,hidden:false,sortable:true,align:'center'},
	        {name:'name',label:'有关人员',sortable:false,align:'center',width:100,formatter:nameFormatter},
	        {name:'steadyInfo',label:'情况描述',width:420},
	        {name:'createTableType', index:'createTableType',label:'建表类型', width:300,formatter:createTableTypeFormatter, sortable:true, align:'center', hidden:false},
			{name:'createDate', index:'createDate',label:'建表时间', width:200, sortable:true, align:'center', hidden:false},
			{name:'registrant', index:'registrant',label:'登记人', width:200, sortable:true, align:'center', hidden:false}
	       // {name:'lastLoginTime',label:'评价反馈',width:100,align:'center'}
		],
		loadComplete: function(data){
    		afterLoad(data);
    	},
		multiselect: true,
		<pop:JugePermissionTag ename="normalSteadyWork">
	    ondblClickRow: viewSteadyWork
	    </pop:JugePermissionTag>
	});
	
	$("#fastSearchButton").click(function(){
		search(USER_ORG_ID);
	});
	$("#searchText").focus(function(){
        this.select();
	 });
	$("#refreshSearchKey").click(function(){
		$("#searchText").attr("value","请输入稳定工作台账编号");
	});
	
	
	$("#add").click(function(){
		$("#steadyWorkDialog").createDialog({
			title:"新增稳定工作台账信息",
			width: dialogWidth,
			height: dialogHeight,
			url:'${path}/account/steadyWorkManage/dispatch.action?mode=add',
			buttons: {
				"保存" : function(){
					$("#maintainForm").submit();
				},
				"关闭" : function(){
					$(this).dialog("close");
				}
			}
		});
	});
	
	$("#update").click(function(){
		var selectedIds = $("#steadyWorkList").jqGrid("getGridParam", "selarrrow");
		if(selectedIds==null || selectedIds.length>1){
			$.messageBox({level:'warn',message:"请选择一条记录，再进行修改！"});
			return;
		}
		var selectedId = getSelectedIdLast();
		if(selectedId==null){
			$.messageBox({level:'warn',message:"请选择一条记录，再进行修改！"});
			 return;
		}
		updateOperator(selectedId);
	});
	
	$("#delete").click(function(){
		var allValue = getSelectedIds();
		if(allValue.length ==0){
			$.messageBox({level:'warn',message:"请选择一条或多条记录，再进行删除！"});
			 return;
		}
		deleteOperator(allValue);
	});
	
	$("#view").click(function(){
		if($("#view").attr("disabled")){
			return ;
		}
		var selectedIds = $("#steadyWorkList").jqGrid("getGridParam", "selarrrow");
		var selectedId = getSelectedIdLast();
		if(selectedId==null || selectedIds==null || selectedIds.length>1){
			$.messageBox({level:'warn',message:"请选择一条记录，再进行查看！"});
	 		return;
		}
		viewSteadyWork(selectedId);
	});
	
	if(USER_ORG_ID!= null){
		loadSteadyWorkData();
	}
	
	$("#reload").click(function(){
		loadSteadyWorkData();
	});

	$("#search").click(function(event){
		$("#steadyWorkDialog").createDialog({
			width:650,
			height:320,
			title:'稳定工作台账表查询-请输入查询条件',
 	 		url:'${path}/xichang/working/steadyWork/maintainSearchSteadyWorkDlg.jsp?orgId='+USER_ORG_ID+'&state='+0,
			buttons: {
		   		"查询" : function(event){
					searchSteadyWork();
		        	$(this).dialog("close");
	   			},
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	});
	$("#records").click(function(){
		var selectedIds = $("#steadyWorkList").jqGrid("getGridParam", "selarrrow");
		if(selectedIds==null || selectedIds.length>1){
			$.messageBox({level:'warn',message:"请选择一条记录，再进行修改！"});
			return;
		}
		var selectedId = getSelectedIdLast();
		if(selectedId==null){
			$.messageBox({level:'warn',message:"请选择一条记录，再进行修改！"});
			 return;
		}
		recordsOperator(selectedId);
	});
});

function recordsOperator(selectedId){
	if(selectedId==null){
 		return;
	}
	$("#steadyWorkDialog").createDialog({
		width:dialogWidth,
		height:600,
		title:"情况记录",
 		url:'${path}/xichang/working/flow/maintainAccountLogsForSteadyWorkDlg.jsp?mode=add&accountType=<s:property value="@com.tianque.xichang.working.flow.constant.AccountType@STEADYWORK"/>&accountId='+selectedId,
		buttons: {
			"保存" : function(){
				$("#maintainAccountLogsForm").submit();
			},
		   "关闭" : function(){
		        $(this).dialog("close");
		   }
		}
	});
	
}

function parseObj(strData) {
	return (new Function("return " + strData))();
}
function searchSteadyWork(){
	var formdata = $("#searchSteadyWorkForm").serialize();
	if (formdata != '') {
		formdata = formdata.replace(/=/g, '":"');
		formdata = formdata.replace(/&/g, '","');
		formdata += '"';
	}
	formdata = decodeURIComponent('{"' + formdata + '}');
	$("#steadyWorkList").setGridParam({
		url:'${path}/account/steadyWorkManage/findSteadyWorkForPageByCondition.action',
		datatype: "json",
		page:1,
		mtype:"post"
	});
	$("#steadyWorkList").setPostData(parseObj(formdata));
	$("#steadyWorkList").trigger("reloadGrid");
	
}

function updateOperator(selectedId){
	var steadyWork =  $("#steadyWorkList").getRowData(selectedId);
	$("#steadyWorkDialog").createDialog({
		title:"修改稳定工作台账信息",
		width: dialogWidth,
		height: dialogHeight,
		url:'${path}/xichang/working/flow/accountLogsTab.jsp?mode=edit&id='+steadyWork.encryptId+'&accountType=<s:property value="@com.tianque.xichang.working.flow.constant.AccountType@STEADYWORK"/>',
		buttons: {
			"保存" : function(){
				$("#maintainForm").submit();
			},
			"关闭" : function(){
				$(this).dialog("close");
			}
		}
		
	});
}
function deleteOperator(allValue){
	var selectedIds=deleteOperatorByEncrypt("steadyWork",allValue,"encryptId");
	$.confirm({
		title:"确认删除",
		message:"确定要删除吗?一经删除将无法恢复",
		okFunc: function() {
			$.ajax({
				url:'${path}/account/steadyWorkManage/deleteSteadyWorkByIds.action',
				type:"post",
				data:{
					"ids":selectedIds
				},
				success:function(data){
					if(data!=null) {
						$.messageBox({message:"已经成功删除该稳定工作台账信息!"});
						$("#steadyWorkList").trigger("reloadGrid");
					} else {
						$.messageBox({message:data,level:"error"});
					}
				}
			});
		}
	});
}

function viewSteadyWork(selectedId){
	if(selectedId==null){
 		return;
	}
	var rowData = $("#steadyWorkList").getRowData(selectedId);
	var id = rowData.encryptId;
	if(id==null){
		 return;
	}
	$("#steadyWorkDialog").createDialog({
		width:dialogWidth,
		height:600,
		title:"查看稳定工作台账信息",
		url:'${path}/account/evaluateFeedbacksManage/dispatchOperate.action?accountType=<s:property value="@com.tianque.xichang.working.flow.constant.AccountType@STEADYWORK"/>&mode=view&evaluateMode=view&accountId='+id+'&id='+id,		
		buttons: {
		   "关闭" : function(){
		        $(this).dialog("close");
		   }
		}
	});
}


function search(orgId){
	var fastSearchVal = $("#searchText").val();
	if(fastSearchVal == '请输入稳定工作台账编号' || fastSearchVal==''){
		loadSteadyWorkData();
		return;
	}
	
	var	postData = {
		 "organization.id":orgId,
		 "steadyWork.serialNumber":fastSearchVal,
		 "state":0
	}
	$("#steadyWorkList").setGridParam({
		url:'${path}/account/steadyWorkManage/findSteadyWorkForPageByCondition.action',
		datatype: "json",
		page:1
	});
	$("#steadyWorkList").setPostData(postData);
	$("#steadyWorkList").trigger("reloadGrid");
}

function getSelectedIdLast(){
	var selectedId;
	var selectedIds = $("#steadyWorkList").jqGrid("getGridParam", "selarrrow");
	for(var i=0;i<selectedIds.length;i++){
		selectedId = selectedIds[i];
	}
	return selectedId;
}

function getSelectedIds(){
	var selectedIds = $("#steadyWorkList").jqGrid("getGridParam", "selarrrow");
	return selectedIds;
}
</script>
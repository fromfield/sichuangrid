<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ include file="/includes/baseInclude.jsp"%>
<s:action name="getLoginInfo" var="loginAction" executeResult="false" namespace="/sessionManage" />
<script type="text/javascript">
<pop:formatterProperty name="useInLevel" domainName="@com.tianque.domain.property.PropertyTypes@ORGANIZATION_LEVEL" />
$(document).ready(function(){

	$("#roleList").jqGridFunction({
	   	url:'${path}/sysadmin/roleManage/roleList.action',
		colNames:['id','encryptId','岗位名称','应用层级','岗位描述','层级编号'],
	   	colModel:[
	   	    {name:'id',index:'id',hidden:true,sortable:false},
	   	 	{name:"encryptId",index:"encryptId",sortable:false,hidedlg:true,frozen:true,hidden:true},
	   		{name:'roleName',sortable:true,index:'roleName'},
	   		{name:'useInLevel',index:'useInLevel',sortable:true,formatter:useInLevelFormatter},
	   		{name:'description',index:'description',sortable:false},
			{name:'useInLevel.id',sortable:true,hidden:true}

	   	],
	   	shrinkToFit:true,
	   	showColModelButton:false
	    <pop:JugePermissionTag ename="viewRole">
        	,ondblClickRow: doubleClickTable
  		</pop:JugePermissionTag>
	});

	$("#reload").click(function(){
		$("#roleList").setGridParam({
			url:"${path}/sysadmin/roleManage/roleList.action",
			datatype: "json",
			page:1
		});
		$("#roleList").trigger("reloadGrid");
	});

	$("#add").click(function(event){
		$("#roleDialog").createDialog({
			width:550,
			height:520,
			title:'新增岗位',
			url:'${path}/sysadmin/roleManage/prepareRole.action?mode=add',
			buttons: {
			  "保存" : function(event){
			      $("#maintainForm").submit();
			   },
			   "关闭" : function(){
			        $(this).dialog("close");
			   }
			}
		});
	});
	
	$("#addLeaderViewRole").click(function(){
		var selectedId = $("#roleList").getGridParam("selrow");
		if(selectedId==null){
			$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
	 		return;
		}
		var role =  $("#roleList").getRowData(selectedId);
		$("#roleDialog").createDialog({
			width:550,
			height:520,
			title:'配置领导视图岗位',
			url:'${path}/sysadmin/roleManage/prepareRole.action?mode=addLeaderView&role.id='+role.encryptId,
			buttons: {
			  "保存" : function(event){
			      $("#maintainForm").submit();
			   },
			   "关闭" : function(){
			        $(this).dialog("close");
			   }
			}
		});
	});
	
	
	$("#search").click(function(){
		$("#roleDialog").createDialog({
			width:550,
			height:200,
			title:"岗位查询-请输入查询条件", 
			url:"${path}/sysadmin/roleManage/searchRoles.jsp",
			buttons:{
              "查询":function(event){
				submitSearchRoles();
				$(this).dialog("close");
	          },
	          "关闭":function(event){
	        	  $(this).dialog("close");
		      }
			}
		});
	});

	$("#update").click(function(event){
		var selectedId = $("#roleList").getGridParam("selrow");
		if(selectedId==null){
			$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
	 		return;
		}
		var role =  $("#roleList").getRowData(selectedId);
		reSetPatelConfig(role.id);
		$("#roleDialog").createDialog({
			width:550,
			height:520,
			title:'修改岗位',
			modal : true,
			resizable : true,
			url:'${path}/sysadmin/roleManage/prepareRole.action?mode=edit&role.id='+ role.encryptId,
			buttons: {
			   "保存" : function(event){
			      $("#maintainForm").submit();
			   },
			   "关闭" : function(){
			        $(this).dialog("close");
			   }
			}
	   });
	});
	$("#copy").click(function(){
		var selectedId = $("#roleList").getGridParam("selrow");
		if(selectedId==null){
			$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
	 		return;
		}
		var role =  $("#roleList").getRowData(selectedId);

		$("#roleDialog").createDialog({
			width:550,
			height:520,
			title:'新增复制岗位',
			modal : true,
			resizable : true,
			url:'${path}/sysadmin/roleManage/prepareRole.action?mode=copy&role.id='+ role.encryptId,
			buttons: {
			   "保存" : function(event){
			      $("#maintainForm").submit();
			   },
			   "关闭" : function(){
			        $(this).dialog("close");
			   }
			}
	   });
	});

	$("#view").click(function(){
		var selectedId = $("#roleList").getGridParam("selrow");
		if(selectedId==null){
			$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
	 		return;
		}
		doubleClickTable(selectedId);
	});

	$("#delete").click(function(){
		var selectedId = $("#roleList").getGridParam("selrow");
		if(selectedId==null){
			$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
	 		return;
		}
		$.confirm({
			title:"确认删除",
			message:"岗位删除后，将无法恢复,您确认删除该岗位吗?",
			width: 400,
			okFunc: deleteRole
		});
	});
	$("#selectUsers").click(function(event){ 
		var selectedId = $("#roleList").getGridParam("selrow");
		var role =  $("#roleList").getRowData(selectedId);
		if(selectedId==null){
			$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
	 		return;
		}
		$("#userMaintanceDialog").createDialog({
			width: 700,
			height: 480,
			title:'选择用户',
			url:'${path}/sysadmin/roleManage/dispatchOperate.action?dictUseLevelId=' + role['useInLevel.id'] + '&orgId=' + '<s:property value="#loginAction.user.organization.id"/>' + '&roleId='+role.encryptId,
			buttons: {
		   		"应用" : function(event){
					$.confirm({
						title:"确认应用",
						message:"点击应用后，会使用本岗位替换该用户的原有岗位，确定需要应用吗？",
						okFunc: function() {
							var selectedIds = $("#roleTable").jqGrid("getGridParam", "selarrrow");
							$.ajax({
								async:false,
								url: "${path}/sysadmin/roleManage/updateUsersByUserId.action?selectIds="+selectedIds+"&roleId="+role.encryptId,
								success:function(responseData){
									 $.messageBox({message:"该操作应用成功于"+selectedIds.length+"个用户！"});
								}
							});
							$("#userMaintanceDialog").dialog("close");
						}
					});
		   		},
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	});
	
	$("#usersConfigure").click(function(event){ 
		var selectedId = $("#roleList").getGridParam("selrow");
		var role =  $("#roleList").getRowData(selectedId);
		if(selectedId==null){
			$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
	 		return;
		}
		$("#userMaintanceDialog").createDialog({
			width: 935,
			height: 550,
			title:'账号配置',
			url:'${path}/sysadmin/roleManage/usersConfigure.action',
			buttons: {
		   		"本页选中账号" : function(event){
					$.confirm({
						title:"确认应用",
						message:"点击应用后，选择的用户里如有在线的用户会强制下线，并使本岗位配置给所选用户，确定需要应用吗？",
						okFunc: function() {
							var selectedIds = $("#roleTable").jqGrid("getGridParam", "selarrrow");
							var str="";
							if(selectedIds==null||selectedIds==''){
								$.messageBox({
									message:"请选择用户来应用岗位!",
									level: "error"
								});
								return;
							}else{
								for(var i=0;i<selectedIds.length;i++){
									str+=selectedIds[i]+",";
								}
								str=str.substring(0,str.length-1);
							}
							$.ajax({
								async:false,
								url: "${path}/sysadmin/roleManage/addRoleToSelectUser.action",
								type:'post',
								data:{
									"selectIds":str,
									"roleId":role.encryptId,
									"type":"select",
									"user.organization.orgLevel.id":role['useInLevel.id']
								},	
								success:function(responseData){
									$.messageBox({message:"该操作应用成功于"+selectedIds.length+"个用户！"});
								}
							});
							$("#userMaintanceDialog").dialog("close");
						}
					});
		   		},
		   		"全部账号" : function(event){
					$.confirm({
						title:"确认应用",
						message:"点击应用后，选择的用户里如有在线的用户会强制下线，并使本岗位配置给查询出的所有用户，确定需要应用吗？",
						okFunc: function() {
							$.ajax({
								async:false,
								url: "${path}/sysadmin/roleManage/addRoleToSelectUser.action",
								type:'post',
								data:{
// 									"dictUseLevelId":role['useInLevel.id'],
									"roleId":role.encryptId,
									'user.organization.id':$("#userOrganizationId").val(),
									"user.userName":$("#userName").val(),
									"user.accountType":$("#accountType").val(),
									"type":"all",
									"user.organization.orgLevel.id":role['useInLevel.id']
								},	
								success:function(responseData){
									 $.messageBox({message:"该操作应用成功于全部用户！"});
								}
							});
							$("#userMaintanceDialog").dialog("close");
						}
					});
		   		},
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	});
	
});
function submitSearchRoles(){
	var roleUseInLevelId = $("#useInl").val();
	var roleName = $("#roleName").val();
	var roleDescription = $("#description").val();

	$("#roleList").setGridParam({
		url:"${path}/sysadmin/searchRoleManage/searchRoles.action",
		datatype: "json",
		page:1
	});

	var searchCondition={
		"role.useInLevel.id":roleUseInLevelId,
		"role.roleName":roleName,
		"role.description":roleDescription
	};
	$("#roleList").setPostData(searchCondition);
	$("#roleList").trigger("reloadGrid");

// 	$("#roleList").setGridParam({url:"${path}/sysadmin/roleManage/roleList.action"});
// 	$("#roleList").setPostData({});
}

function deleteRole(selectedId){
	var selectedId = $("#roleList").getGridParam("selrow");
	var role = $("#roleList").getRowData(selectedId);
	$.ajax({
		url:'${path}/sysadmin/roleManage/deleteRole.action?role.id='+ role.encryptId,
		success:function(data){
			if(data == true){
				$("#roleList").delRowData(role.id);
				$.messageBox({ message:"成功删除岗位!"});
				return;
			}
            $.messageBox({
				message:data,
				level: "error"
			});
        }
	});
}

function doubleClickTable(rowid){
		var role =  $("#roleList").getRowData(rowid);
		$("#roleDialog").createDialog({
			width:550,
			height:520,
			title:'查看岗位',
			modal : true,
			resizable : true,
			url:'${path}/sysadmin/roleManage/prepareRole.action?mode=view&role.id='+ role.encryptId,
			buttons: {
			   "关闭" : function(){
			        $(this).dialog("close");
			   }
			}
		});
}

function reSetPatelConfig(roleId){
	var rowData=  $("#roleList").getRowData(roleId);
	$.ajax({
		async: false ,
		url:"${path }/sysadmin/userManage/reSetPatelConfig.action",
	   	data:{
		"roleId":rowData.encryptId
		}
	});
}
</script>
<div class="content">
	<div class="ui-corner-all" id="nav">
		<pop:JugePermissionTag ename="searchRoles">
		    <a id="search" href="javascript:void(0)"><span>高级搜索</span></a>
	    </pop:JugePermissionTag>
	    <span class="lineBetween "></span>
		<pop:JugePermissionTag ename="addRole">
			<a id="add" href="javascript:;"><span>新增</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="updateRole">
			<a id="update" href="javascript:void(0)"><span>修改</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="viewRole">
			<a id="view" href="javascript:void(0)"><span>查看</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="deleteRole">
			<a id="delete" href="javascript:void(0)"><span>删除</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="addLeaderViewRole">
			<a id="addLeaderViewRole" href="javascript:void(0)"><span>配置领导视图岗位</span></a>
		</pop:JugePermissionTag>
		<a id="reload" href="javascript:void(0)"><span>刷新</span></a>
		<pop:JugePermissionTag ename="copyRole">
			<a id="copy" href="javascript:void(0)"><span>复制</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="selectUsers">
	    	<a id="selectUsers" href="javascript:void(0)"><span><strong class="ui-ico-turnPositiveInfo"></strong>选用户</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="usersConfigure">
	    	<a id="usersConfigure" href="javascript:void(0)"><span><strong class="ui-ico-turnPositiveInfo"></strong>账号配置</span></a>
		</pop:JugePermissionTag>
	</div>
	<div style="width: 100%;">
		<table id="roleList"></table>
		<div id="roleListPager"></div>
	</div>
	<div id="roleDialog" style="overflow: hidden"></div>
</div>


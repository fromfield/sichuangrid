<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/includes/baseInclude.jsp"%>
<script type="text/javascript">

function weekDeatilFormatter(el,options,rowData){
	if(rowData.weekCount=='' || rowData.weekCount==0||rowData.weekCount==undefined){
		return "";
	}else{
		return "<a href='javascript:viewWeekLoginDetail("+rowData.userId+")'><span>详情</span></a>";
	}
}
function monthDeatilFormatter(el,options,rowData){
	if(rowData.monthCount=='' || rowData.monthCount==0||rowData.monthCount==undefined){
		return "";
	}else{
		return "<a href='javascript:viewMonthLoginDetail("+rowData.userId+")'><span>详情</span></a>";
	}
}

function viewWeekLoginDetail(userId){
	if(userId==null || userId=='' || userId==undefined){
		$.messageBox({message:"请至少选择一条信息进行查看",level:'warn'});
		return ;
	}
	viewLoginDetail(userId,1);
}

function viewMonthLoginDetail(userId){
	if(userId==null || userId=='' || userId==undefined){
		$.messageBox({message:"请至少选择一条信息进行查看",level:'warn'});
		return ;
	}
	viewLoginDetail(userId,2);
}

function viewLoginDetail(userId,searchType){
	var title  = "";
	if(searchType==1){
		title="上周登录详情";
	}else{
		title="上月登录详情";
	}
	$("#accountLoginDetailsDialog").createDialog({
		width: 500,
		height: 300,
		title:title,
		url:'${path}/sysadmin/userAccountLoginDetailManage/getUserLoginDetailByUserId.action?userId='+userId+'&searchType='+searchType,
		buttons:{
			"关闭" : function(){
				$(this).dialog("close");
			}
		}
		
	});
}

function accountTypeFormatter(el,options,rowData){
	if((rowData.pcUsable==1 || rowData.pcUsable=='1')&&(rowData.mobileUsable==1 || rowData.mobileUsable=='1')){
		return "<span style='color:red;'>PC&手机</span>";
	}else if(rowData.pcUsable==1 || rowData.pcUsable=='1'){
		return "PC";
	}else if(rowData.mobileUsable==1 || rowData.mobileUsable=='1'){
		return "手机";
	}else{
		return "未定义";
	}
}

$(document).ready(function(){
	
	$("#searchType").change(function(){
		$("#accountLoginDetailsList").setGridParam({
			url:"${path}/sysadmin/userAccountLoginDetailManage/findUserAccountForPageResult.action",
			datatype: "json",
			page:1
		});
		$("#accountLoginDetailsList").setPostData({
			"searchType":$("#searchType").val(),
			"organization.id":getCurrentOrgId()
	   	});
		$("#accountLoginDetailsList").trigger("reloadGrid");
	});
	
	
	jQuery("#accountLoginDetailsList").jqGridFunction({
	   	url:'${path}/sysadmin/userAccountLoginDetailManage/findUserAccountForPageResult.action',
	   	postData: {
			"searchType":$("#searchType").val(),
			"organization.id":getCurrentOrgId()
        },
		datatype: "json",
	   	colModel:[
	   	    {name:'organization.id',index:'organization.id',sortable:false,hidden:true,frozen:true,hidedlg:true},
	   	 	{name:'userId',index:'userId',sortable:false,hidden:true,frozen:true,hidedlg:true},
	   	 	{name:'pcUsable',index:'pcUsable',sortable:false,hidden:true,frozen:true,hidedlg:true},
	   		{name:'mobileUsable',index:'mobileUsable',sortable:false,hidden:true,frozen:true,hidedlg:true},
	   		{name:'organization.orgName',label:'所在组织机构',width:400,index:'organization.orgName',align:'center', sortable:false},
	   		{name:'accountType',label:'账号类别',sortable:true,formatter:accountTypeFormatter,align:'center',width:100},
	   		{name:'userName',label:'用户名',sortable:true,align:'center',width:120},
	   		{name:'name',label:'中文名',sortable:true,align:'center',width:120},
	   		{name:'weekCount',label:'上周登录天数',sortable:true,align:'center',width:80},
	   		{name:'weekDetail',label:'周登录详情',sortable:true,formatter:weekDeatilFormatter,align:'center',width:100},
	   		{name:'monthCount',label:'上月登录天数',sortable:true,align:'center',width:80},
	   		{name:'monthDetail',label:'月登录详情',sortable:true,formatter:monthDeatilFormatter,align:'center',width:100},
	   		{name:'activationTime',label:'账号激活时间',sortable:true,align:'center',width:180},
	   		{name:'lastLoginTime',label:'最后登录时间',sortable:true,align:'center',width:180}
	   	]
	});
	
	$("#reload").click(function(){
		$("#accountLoginDetailsList").setGridParam({
			url:"${path}/sysadmin/userAccountLoginDetailManage/findUserAccountForPageResult.action",
			datatype: "json",
			page:1
		});
		$("#accountLoginDetailsList").setPostData({
			"searchType":$("#searchType").val(),
			"organization.id":getCurrentOrgId()
	   	});
		$("#accountLoginDetailsList").trigger("reloadGrid");
	});
	
	$("#createAccountLoginDetails").click(function(){
			$.ajax({
				url:'${path}/sysadmin/userAccountLoginDetailManage/createUserAccountLoginDetail.action',
				success:function(responseData){
					if(responseData=='true' || responseData==true ){
						$.messageBox({message:"报表生成成功"});
						$("#accountLoginDetailsList").trigger("reloadGrid");
					}else{
						$.messageBox({level:'error',message:responseData});
					}
				}
			});
	});
	
	$("#detailsExport").click(function(){
		if ($("#accountLoginDetailsList").getGridParam("records")>0){
			$("#accountDetailsDialog").createDialog({
				width: 250,
				height: 200,
				title:'导出账号登录详情',
				url:PATH+'/common/exportExcel.jsp',
				postData:{
					gridName:'accountLoginDetailsList',
					downloadUrl:PATH+'/sysadmin/userAccountLoginDetailManage/downloadAccountLoginDetails.action'
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
	
	$("#search").click(function(){
		$("#accountDetailsDialog").createDialog({
			width: 500,
			height: 280,
			title:'活跃度高级搜索',
			url:'${path}/sysadmin/userAccountLoginDetailManage/searchAccount.action?organization.id='+getCurrentOrgId()+'&searchType='+$("#searchType").val(),
			buttons: {
	   			"查询" : function(event){
					$("#searchCommentLogForm").submit();
	   				$(this).dialog("close");
   				},
	   			"关闭" : function(){
	        		$(this).dialog("close");
	   			}
			}
	    });
	});
});
	$("#viewAccountLoginStatistics").click(function(){
		$("#accountDetailsDialog").createDialog({
			width:1200,
			height: 580,
			title:'报表详情',
			url:'${path}/sysadmin/userAccountLoginDetailManage/viewUserAccountLoginStatistics.action?organization.id='+getCurrentOrgId()+'&searchType='+$("#searchType").val(),
			buttons: {
	   			"关闭" : function(){
	        		$(this).dialog("close");
	   			}
			}
	    });
	});


</script>
<div class="content">
	<div class="ui-corner-all" id="nav">
		<div class="btnbanner btnbannerData">
			<jsp:include page="/common/orgSelectedComponent.jsp"/>
		</div>
		<select class="basic-input" id="searchType" name="searchType">
			<option value="1" selected="selected">本级</option>
			<option value="2">下辖全部</option>
		</select>
		
		<a id="search" href="javascript:void(0)"><span>高级查询</span></a>
		<pop:JugePermissionTag ename="accountActivityExport">
				<a id="detailsExport" href="javascript:void(0)"><span>导出</span></a>
		</pop:JugePermissionTag>
		<s:if test="@com.tianque.core.util.ThreadVariable@getUser().getUserName().equals('longzhendong')||
		   @com.tianque.core.util.ThreadVariable@getUser().getUserName().equals('admin')">
			<a id="createAccountLoginDetails"  href="javascript:void(0)"><span>生成报表</span></a>
		</s:if>
		<pop:JugePermissionTag ename="viewAccountLoginStatistics">
		<a id="viewAccountLoginStatistics" href="javascript:void(0)"><span>查看报表</span></a>
		</pop:JugePermissionTag>
		<a id="reload" href="javascript:void(0)"><span>刷新</span></a>
	</div>
	<div style="width: 100%">
		<table id="accountLoginDetailsList"></table>
		<div id="accountLoginDetailsListPager"></div>
	</div>
	
	<div id="accountDetailsDialog"></div>
	<div id="accountLoginDetailsDialog"></div>
</div>


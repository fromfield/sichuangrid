<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp" />
<div class="content">
	<div class="ui-corner-all" id="nav">
		<div class="btnbanner btnbannerData">
	      <@s.include value="/common/orgSelectedTaskListComponent.jsp" />
			<div class="ui-widget autosearch">
			    <input class="basic-input" type="text" value="请输入帮扶人员姓名" name="positiveInfoRecordVo.fastSearchCondition" id="searchText" maxlength="18" class="searchtxt" onblur="value=(this.value=='')?'请输入帮扶人员姓名':this.value;" onfocus="value=(this.value=='请输入帮扶人员姓名')?'':this.value;"/>
				<button id="refreshSearchKey1" class="ui-icon ui-icon-refresh searchbtnico"></button>
			</div>
			<a href="javascript:;" id="fastSearchButton1"><span>搜索</span></a>
			<#--<@pop.JugePermissionTag ename="searchPositiveInfoRecord">
				<a id="search1" href="javascript:void(0)"><span><strong
						class="ui-ico-cx"></strong>高级搜索</span></a>
				<span class="lineBetween"></span>
			</@pop.JugePermissionTag>-->
			<span class="lineBetween"></span>
		</div>
		<@pop.JugePermissionTag ename="addPositiveInfoRecord">
			<a id="add1" href="javascript:void(0)"><span><strong
					class="ui-ico-xz"></strong>新增</span></a>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="deletePositiveInfoRecord">
			<a id="delete1" href="javascript:void(0)"><span><strong
					class="ui-ico-sc"></strong>批量删除</span></a>
		</@pop.JugePermissionTag>
		<a id="reload1" href="javascript:void(0)"><span><strong
				class="ui-ico-refresh"></strong>刷新</span></a>
		<!--
		<@pop.JugePermissionTag ename="signPositiveInfoRecord">
			<a id="transfer" href="javascript:void(0)"><span>签收</span></a>
		</@pop.JugePermissionTag>
		-->
	</div>
	<input type="hidden" name="" id="flag" value="${(flag)!}" />
	<input type="hidden" name="" id="positiveInfoId" value="${(id)!}" />
	<div style="width: 100%;" class="">
		<table id="positiveInfoRecordList"></table>
		<div id="positiveInfoRecordListPager"></div>
	</div>
	<div id="positiveInfoRecordDialog"></div>
	<div id="addTaskListReplyDlg"></div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	<@pop.formatterProperty name="livelihoodWay" domainName="@com.tianque.domain.property.PropertyTypes@DRUGGY_LIFE_RESOURCE" />
	$("#positiveInfoRecordList").jqGridFunction({
		datatype: "local",
		multiselect:true,
		colModel:[
			{name:"id",index:"id",sortable:false,hidden:true},
		    {name:'createUserName',index:"createUserName",label:'走访人',sortable:false,width:100,align:"center"},
		    {name:'createDate',index:"createDate",label:'走访时间',sortable:true,width:150},
		    {name:"helpPeople",index:"helpPeople",label:'帮扶人员',sortable:false,hidden:false},
		    {name:'hasException',label:'有无异常',sortable:false,align:"center", width:150,hidden:true,formatter:hasExceptionFormatter},
		    {name:'exceptionSituationInfo',index:'exceptionSituationInfo',label:'异常情况',sortable:false,width:190,align:"center"}
		],
		ondblClickRow: viewPositiveInfoRecord
	});
	$("#positiveInfoRecordList").jqGrid('setFrozenColumns');
	//新增按钮事件
	$("#add1").click(function(event){
	var positiveInfoId=$("#positiveInfoId").val();
		if(!isConfigTaskGrid()){
			$.messageBox({level:"warn",message:"请先选择网格级别组织机构进行新增！"});
			return;
		}
		$("#positiveInfoRecordDialog").createDialog({
			title:"新增刑释人员记录",
			width: 600,
			height: 475,
			url:"${path}/plugin/taskListManage/positiveInfoRecord/dispatch.action?addFlag=true&mode=add&positiveInfoId="+positiveInfoId,
			buttons: {
				"保存" : function(event){
		   			$("#positiveInfoRecordForm").submit();
				},
				"关闭" : function(event){
		   			$(this).dialog("close");
				}
			}
		});
	});
	//刷新按钮事件绑定
	$("#reload1").click(function(event){
		$("#searchText").val("请输入帮扶人员姓名");
		getPositiveInfoRecordList();
	});
	
	$("#refreshSearchKey1").click(function(){
		$("#searchText").val("请输入帮扶人员姓名");
	});
	
	$("#fastSearchButton1").click(function(event){
		var fastSearchCondition = $("#searchText").val();
		if(fastSearchCondition == "请输入帮扶人员姓名"){
			
		}else {
			var postData={
				"positiveInfoRecordVo.organization.id":selectConfigTaskOrg(),
				"positiveInfoRecordVo.fastSearchCondition":fastSearchCondition,
				"positiveInfoRecordVo.positiveInfoId":$("#positiveInfoId").val()
			};
			if(isConfigTaskSelect()){
				$.extend(postData,{"positiveInfoRecordVo.mode":"gridConfigTask","positiveInfoRecordVo.funOrgId": $("#funOrgId").val()})
			}
			$("#positiveInfoRecordList").setPostData(postData);
			$("#positiveInfoRecordList").trigger("reloadGrid");
		}
	});
	
		getPositiveInfoRecordList();
	
	
	$("#delete1").click(function(){
		var ids = $("#positiveInfoRecordList").jqGrid("getGridParam", "selarrrow");
		if(ids.length < 1){
			$.messageBox({level:'warn',message:"没有选中数据，无法对刑释人员记录进行删除操作！"});
		}else {
			deletePositiveInfoRecordOperator(ids);
		}
	});
});

	//列表显示（包括快速过滤）
	function getPositiveInfoRecordList(){
		$("#positiveInfoRecordList").setGridParam({
			url:"${path}/plugin/taskListManage/positiveInfoRecord/findInterViewPositiveInfos.action",
			datatype: "json",
			page:1,
			mytype:"post"
		});
		var postData={
			"positiveInfoRecordVo.organization.id":selectConfigTaskOrg(),
			"positiveInfoRecordVo.positiveInfoId":$("#positiveInfoId").val()
		};
		if(isConfigTaskSelect()){
			$.extend(postData,{"positiveInfoRecordVo.mode":"gridConfigTask","positiveInfoRecordVo.funOrgId": $("#funOrgId").val()})
		}
		$("#positiveInfoRecordList").setPostData(postData);
		$("#positiveInfoRecordList").trigger("reloadGrid");
	}
	
	//删除服务记录
	function deletePositiveInfoRecordOperator(selectedIds){
		var flag1 = false;
		var flag2= false;
		for(var i=0;i<selectedIds.length;i++){
			var positiveInfoRecord =  $("#positiveInfoRecordList").getRowData(selectedIds[i]);
			if(positiveInfoRecord.internalId>USER_ORG_LEVEL){
				flag1 = true;
			}
			if(positiveInfoRecord.status == '是'){
				flag2 = true;
			}
		}
		if(flag1){
			$.messageBox({level:'warn',message:"选中的刑释人员记录层级高于当前登录层级，无法对该刑释人员记录进行删除操作！"});
			return;
		}
	    if(flag2){
			$.messageBox({level:'warn',message:"选中的刑释人员记录已签收，无法对该刑释人员记录进行删除操作！"});
			return;
		}
		$.confirm({
			title:"确认删除",
			message:"确定要删除吗?",
			okFunc: function(){
				$.ajax({
					url:"${path}/plugin/taskListManage/positiveInfoRecord/deletePositiveInfoRecords.action?ids="+selectedIds,
					success:function(data){
						if(data>0){
						    $.messageBox({message:"成功删刑释人员记录!"});
							$("#positiveInfoRecordList").trigger("reloadGrid");
						}else{
							$.messageBox({
								message:"删除刑释人员记录出错!",
								level:"warn"
							});
						}
					}
				});
			}
		});
	}
	
	//高级搜索
	function searchPositiveInfoRecords()
	{
		$("#positiveInfoRecordList").setGridParam({
			url:"${path}/plugin/taskListManage/positiveInfoRecord/findInterViewPositiveInfos.action",
			datatype: "json",
			page:1,
			mtype:"post"
		});
		var data=$("#searchPositiveInfoRecordForm").serializeArray();
		var dataJson={};
		for(i=0;i<data.length;i++){
	 		if (dataJson[data[i].name]) {
				dataJson[data[i].name]=dataJson[data[i].name]+","+data[i].value;
			} else {
				dataJson[data[i].name] = data[i].value;
			}
		}
		var postData={
			"positiveInfoRecordVo.organization.id":selectConfigTaskOrg(),
			"positiveInfoRecordVo.positiveInfoId":$("#positiveInfoId").val()
		};
		if(isConfigTaskSelect()){
			$.extend(postData,{"positiveInfoRecordVo.mode":"gridConfigTask","positiveInfoRecordVo.funOrgId": $("#funOrgId").val()})
		}
		$("#positiveInfoRecordList").setPostData(
			$.extend(dataJson,postData));
		$("#positiveInfoRecordList").trigger("reloadGrid");
	}

	function viewPositiveInfoRecord(selectedId) {
		$("#positiveInfoRecordDialog").createDialog({
			width: 550,
			height: 400,
			title: '查看刑释人员走访信息',
			url:"${path}/plugin/taskListManage/positiveInfoRecord/viewInterViewPositiveInfo.action?mode=view&id="+selectedId,
			buttons: {
				"关闭" : function(){
					$(this).dialog("close");
				}
			}
		});
	}
	
	
 function refreshList(searchText){
	var orgId=selectConfigTaskOrg();
	$("#positiveInfoRecordList").setGridParam({
	url:"${path}/plugin/taskListManage/positiveInfoRecord/findInterViewPositiveInfos.action",
		datatype: "json",
		page:1
	});
	var postData={
		"positiveInfoRecordVo.organization.id":selectConfigTaskOrg(),
		"positiveInfoRecordVo.positiveInfoId":$("#positiveInfoId").val()
	};
	if(isConfigTaskSelect()){
		$.extend(postData,{"positiveInfoRecordVo.mode":"gridConfigTask","positiveInfoRecordVo.funOrgId": $("#funOrgId").val()})
	}
	$("#positiveInfoRecordList").setPostData(postData);
	$("#positiveInfoRecordList").trigger("reloadGrid");
  } 
  
	function operaterFormatter(el, options, rowData){
		if(rowData.status == 0){
			return "<@pop.JugePermissionTag ename='deletePositiveInfoRecord'><a href='javascript:' onclick='deletePositiveInfoRecordOperator("+rowData.id+")'><span>删除</span></a></@pop.JugePermissionTag>";
		}else {
			return "无";
		}
	}
	
	function hasExceptionFormatter(el, options, rowData){
		if(rowData.hasException == 1){
			return "有";
		}else {
			return "无";
		}
	}
	
</script>

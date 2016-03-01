<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp" />
<@s.include value="/baseinfo/commonPopulation/jsFunctionInclude.jsp">
	<@s.param name="moduleName">WorkingSituation</@s.param>
</@s.include>

<style>
    .greenLimitWarn {
        width: 22px;
        height: 22px;
        display: block;
        margin: 0 auto;
        vertical-align: top;
        background: url(/resource/system/images/issue/icon_gLamp.png) no-repeat;
    }
    .yellowLimitWarn {
        width: 22px;
        height: 22px;
        display: block;
        margin: 0 auto;
        vertical-align: top;
        background: url(/resource/system/images/issue/icon_yLamp.png) no-repeat;
    }
    .redLimitWarn {
        width: 22px;
        height: 22px;
        display: block;
        margin: 0 auto;
        vertical-align: top;
        background: url(/resource/system/images/issue/icon_rLamp.png) no-repeat;
    }
</style>
<div class="ui-corner-all contentNav" id="nav">
		<div class="btnbanner btnbannerData">
			
	<div class="btnbanner">
	    
	   <#-- <@s.include value="/common/orgSelectedComponent.jsp"/>-->
		<@s.include value="/common/orgSelectedTaskListComponent.jsp"/>

	</div>
	

		<div class="ui-widget autosearch">
				<input class="basic-input" type="text" value="请输入民警姓名" id="searchByCondition" maxlength="18" style="width: 150px;" onblur="value=(this.value=='')?'请输入民警姓名':this.value;" onfocus="value=(this.value=='请输入民警姓名')?'':this.value;">
				<button id="refreshSearchKey" class="ui-icon ui-icon-refresh searchbtnico"></button>
			</div>
		</div>
		<a href="javascript:;" id="fastSearchButton"><span>搜索</span></a>
		<@pop.JugePermissionTag ename="searchWorkingSituation">
			<a id="search" href="javascript:void(0)"><span><strong class="ui-ico-cx"></strong>高级搜索</span></a>
		</@pop.JugePermissionTag>
        <span class="lineBetween"></span>
   
		 <@pop.JugePermissionTag ename="addWorkingSituation">
			<a id="add" href="javascript:;"><span>新增</span></a>
		</@pop.JugePermissionTag>
		
		
		 <@pop.JugePermissionTag ename="updateWorkingSituation">
			<a id="update" href="javascript:void(0)"><span>修改</span></a>
			</@pop.JugePermissionTag>
		
		<@pop.JugePermissionTag ename="viewWorkingSituation">
			<a id="view" href="javascript:void(0)"><span>查看</span></a>
		</@pop.JugePermissionTag>
	
		<@pop.JugePermissionTag ename="deleteWorkingSituation">
		<a id="delete" href="javascript:void(0)"><span><strong class="ui-ico-sc"></strong>批量删除</span></a>
		</@pop.JugePermissionTag>
		
		<a id="reload" href="javascript:void(0)"><span><strong class="ui-ico-refresh"></strong>刷新</span></a>
		
	
		
	</div>


	<div style="clear: both;"></div>
	<div style="width:100%;" >
		<table id="workingSituationList"> </table>
		<div id="workingSituationListPager"> </div>
	</div>
	<div id="workingSituationeDialog"> </div>
	
	<div id="scanHeaderImage"> </div>

<script type="text/javascript">

var dialogWidth=700;
var dialogHeight=480;
var title="民警带领下开展工作情况";

<@pop.formatterProperty name="workcontent" domainName="@com.tianque.domain.property.PropertyTypes@WORKING_CONTENT_TYPE" />

function operatorFormatter(el,options,rowData){
	return "<@pop.JugePermissionTag ename='updateWorkingSituation'><a href='javascript:updateWorkingSituation(event,"+rowData.id+")'><span>修改</span></a> | </@pop.JugePermissionTag><@pop.JugePermissionTag ename='deleteWorkingSituation'><a href='javascript:deleteOperator(event,"+rowData.id+")'><span>删除</span></a></@pop.JugePermissionTag>";
}

function nameFont(el,options,rowData){
		return "<@pop.JugePermissionTag ename='viewWorkingSituation'><a href='javascript:viewWorkingSituation("+rowData.id+")'></@pop.JugePermissionTag>"+rowData.name+"<@pop.JugePermissionTag ename='viewWorkingSituation'></a></@pop.JugePermissionTag>";
}

function isHandleFormatter(el,options,rowData){
	var flag = "<@pop.JugePermissionTag ename='signWorkingSituation'>true</@pop.JugePermissionTag>";
	if(0==rowData.ishandle && flag == 'true'){
		return "<a href='javascript:;' onclick='updateIsHandle(event,"+rowData.id+")'><span style='color:#ff0000;'>签收</span></a>";
	}else if(0==rowData.ishandle && flag == ''){
		return "<span>否</span>";
	}else {
		return "<span>是</span>";
	}
}

function onOrgChanged(orgId, isgrid){
    getTaskListTimeStandardByItemName();
	var initParam = {
	    "workingSituationVo.organization.id":selectConfigTaskOrg(),
	    "workingSituationVo.isGrid":isConfigTaskGrid()
	}
	if(isConfigTaskSelect()){
		$.extend(initParam,{"propagandaAndVerificationVo.mode":"gridConfigTask","propagandaAndVerificationVo.funOrgId": $("#funOrgId").val()})
	}
	
	$("#workingSituationList").setGridParam({
		url:"${path}/baseInfo/workingSituationManage/searchWorkingSituationByVo.action",
		datatype:'json',
		page:1
	});
	
	$("#workingSituationList").setPostData(initParam);
	$("#workingSituationList").trigger("reloadGrid");
}

function refreshList(searchText){
	$("#workingSituationList").setGridParam({
		url:"${path}/baseInfo/workingSituationManage/searchWorkingSituationByVo.action",
		datatype: "json",
		page:1
	});
   	var postData={
			"workingSituationVo.organization.id":selectConfigTaskOrg()
	};
	if(isConfigTaskSelect()){
		$.extend(postData,{"workingSituationVo.mode":"gridConfigTask","workingSituationVo.funOrgId": $("#funOrgId").val()})
	}
	$("#workingSituationList").setPostData(postData);
	$("#workingSituationList").trigger("reloadGrid");
}

function afterLoad(){
	onOrgChanged(selectConfigTaskOrg(),isConfigTaskGrid());
}

function deleteOperator(event,selectedId){

	$.confirm({
		title:"确认删除该"+title,
		message:"该"+title+"删除后，将不可恢复，您确定要删除该"+title+"吗？",
		width: 400,
		okFunc: function(){deleteWorkingSituation(selectedId);}
	});
	var evt = event || window.event;
	if (window.event) {
	evt.cancelBubble=true;
	} else {
	evt.stopPropagation();
	}
}

function deleteWorkingSituation(allValue) {
	$.ajax({
		url : "${path}/baseInfo/workingSituationManage/deleteWorkingSituation.action?ids="+allValue,
		success : function(data) {
			
			afterLoad();
		}
	});
}


function updateIsHandle(event,selectedId){
	$("#workingSituationDialog").createDialog({
		width: 600,
		height: 480,
		title: '签收',
		url:'${path}/baseInfo/workingSituationManage/updatePage.action?id='+selectedId,
		buttons: {
			"签收" : function(){
				$("#maintainFormForWorkingSituation").submit();
	
			},
			"关闭" : function(){
				$(this).dialog("close");
			}
		}
	});
	var evt = event || window.event;
	if (window.event) {
	evt.cancelBubble=true;
	} else {
	evt.stopPropagation();
	}
}

function updateWorkingSituation(event,selectedId){
	$("#workingSituationDialog").createDialog({
		width:350,
		height:380,
		title:'修改信息',
		url:'${path}/baseInfo/workingSituationManage/updatePageForAll.action?id='+selectedId,
		buttons: {
			"保存" : function(){
				$("#maintainFormForWorkingSituationAdd").submit();
			},
	   		"关闭" : function(){
	        	$(this).dialog("close");
	   		}
		}
	});
}

function viewWorkingSituation(rowId) {
	if (rowId == null) {
		return;
	}
		
	var id=$('#workingSituationList').getRowData(rowId).id;
	$("#workingSituationDialog").createDialog({
		width: 550,
		height: 380,
		title : '民警带领下开展工作详情' ,
		url : '${path}/baseInfo/workingSituationManage/viewWorkingSituation.action?workingSituation.id=' + id,
		buttons : {
			"关闭" : function() {
				$(this).dialog("close");
			}
		}
	});
}

function fastSearch(orgId){
	var condition = $("#searchByCondition").val();

	if(condition == '请输入民警姓名') return;
	var initParam = {
	"workingSituationVo.organization.id":orgId,
	"workingSituationVo.fastSearchKeyWords":condition,
	"workingSituationVo.isGrid":isConfigTaskGrid()
	
	}
	if(isConfigTaskSelect()){
		$.extend(initParam,{"workingSituationVo.mode":"gridConfigTask","workingSituationVo.funOrgId": $("#funOrgId").val()})
	}

	$("#workingSituationList").setGridParam({
		url:'${path}/baseInfo/workingSituationManage/searchWorkingSituationByVo.action',
		datatype: "json",
		page:1
	});
	$("#workingSituationList").setPostData(initParam);
	$("#workingSituationList").trigger("reloadGrid");
}

function searchWorkingSituation() {
    var conditionPoliceName=$("#conditionPoliceName").val();
    var conditionWorkcontent = $("#conditionWorkcontent").val();
	var conditionStartDate = $("#conditionStartDate").val();
	var conditionEndDate = $("#conditionEndDate").val();
	var conditionCellName = $("#conditionCellName").val();
	var conditionPoliceName = $("#conditionPoliceName").val();
	var conditionSignName =  $("#conditionSignName").val();
	var conditionStartSign =  $("#conditionStartSign").val();
	var conditionEndSign =  $("#conditionEndSign").val();
	var conditionSign =  $("#conditionSign").val();
	var idCard =  $("#idCard").val();
	var phone =  $("#phone").val();
	
	
	var initParam = {
	    
		"workingSituationVo.organization.id": selectConfigTaskOrg(),
		"workingSituationVo.policeName":conditionPoliceName,
		"workingSituationVo.workcontentId":conditionWorkcontent,
		"workingSituationVo.occurrenceDateStart":conditionStartDate,
	    "workingSituationVo.occurrenceDateEnd":conditionEndDate,
		"workingSituationVo.cellName":conditionCellName,
		"workingSituationVo.policeName":conditionPoliceName,
		"workingSituationVo.signUserName":conditionSignName,
		"workingSituationVo.signDateStart":conditionStartSign,
		"workingSituationVo.signDateEnd":conditionEndSign,
		"workingSituationVo.ishandle":conditionSign,
	    "workingSituationVo.isGrid":isConfigTaskGrid(),
	    "workingSituationVo.idCard":idCard,
	    "workingSituationVo.phone":phone
	}
	if(isConfigTaskSelect()){
		$.extend(initParam,{"propagandaAndVerificationVo.mode":"gridConfigTask","propagandaAndVerificationVo.funOrgId": $("#funOrgId").val()})
	}

	$("#workingSituationList").setGridParam({
		url:'${path}/baseInfo/workingSituationManage/searchWorkingSituationByVo.action',
		datatype: "json",
		page:1
	});
	$("#workingSituationList").setPostData(initParam);
	$("#workingSituationList").trigger("reloadGrid");
}




var taskListTimeStandard;
var serverTime = new Date().getTime();
function getTaskListTimeStandardByItemName(){
    $.get(PATH + "/taskListTimeStandardManage/getTaskListTimeStandardByItemName.action", {
        'orgId':selectConfigTaskOrg(),
        'itemNameDictInternalId':<@pop.static value="@com.tianque.plugin.taskList.constant.TaskListItemNameInternalId@WORK_BYPOLICE_MANAGEMENT"/>
    }, function (data) {
        taskListTimeStandard = data[0];
        serverTime = taskListTimeStandard?taskListTimeStandard.sysCurrTime:new Date().getTime();
        // 有配置的才显示亮牌
        if(taskListTimeStandard){
            $("#workingSituationList").jqGrid("showCol", ["signDate"]);
        }
    });
}
$(document).ready(function(){
    getTaskListTimeStandardByItemName();
    var postData = {
        "workingSituationVo.organization.id": selectConfigTaskOrg(),
    };
    if (isConfigTaskSelect()) {
        $.extend(postData, {
            "workingSituationVo.mode": "gridConfigTask",
            "workingSituationVo.funOrgId": $("#funOrgId").val()
        })
    }
	$("#workingSituationList").jqGridFunction({
		url:"${path}/baseInfo/workingSituationManage/searchWorkingSituationByVo.action",
		dataType: "json",
		postData:postData,
      
        colModel:[
	    {name:"id", index:"id", hidden:true,frozen:true},
        <@pop.JugePermissionTag ename="signWorkingSituation">
            {name:'signDate',label:'签收督办',sortable:true,formatter:signSuperviseFormatter,align:'center',hidden:true,hidedlg:true,width:130},
    	</@pop.JugePermissionTag>
		{name:"occurrenceDate", index:'occurrenceDate', sortable:true,label:'时间',align:'center', width:150 ,align:'center'},
	    {name:'policeName', sortable:true, label:'民警姓名', width:130 ,align:'center'},
	    {name:'idCard',label:'身份证号码',sortable:true,align:'center',width:130},
   	 	{name:'phone',label:'电话号码',sortable:true,align:'center',width:100},
	    {name:"workcontent",sortable:true,label:"工作内容",formatter:workcontentFormatter,width:300,align:'center' },
	    {name:'ishandle', sortable:true, label:'是否签收',formatter:isHandleFormatter, width:90 ,align:'center'},
	    {name:'remark', sortable:true, label:'备注', width:300 ,align:'center'},
	    {name:'createDate',label:'创建时间',sortable:true,align:'center',hidden:true,hidedlg:true,width:120}
	],
		multiselect:true,
		viewrecords:true,
		onSelectAll:function(aRowids,status){ locationOperator(event,aRowids);},
		ondblClickRow: viewWorkingSituation,
		
	});
    function signSuperviseFormatter(el,options,rowData){
        if(rowData.ishandle==1){
            return "-";
        }else{
            if(!taskListTimeStandard){
                return '<span title="未配置">err</span>';
            }
            var createDateStr =rowData.createDate;
            var useTime =(serverTime - Date.parse(createDateStr.replace(/-/g, "/")))/(1000*60*60);
            if(useTime>taskListTimeStandard.signRedLimit){
                return '<strong class="redLimitWarn" title="红牌超时"/>';
            }else if(useTime>taskListTimeStandard.signYellowLimit){
                return '<strong class="yellowLimitWarn" title="黄牌超时"/>';
            }else{
                var title = "剩"+Math.ceil(taskListTimeStandard.signYellowLimit-useTime)+'小时时限';
                return '<strong class="greenLimitWarn" title="'+title+'"/>';
            }
        }
    }
    $("#add").click(function(event){
   
		
		if(!isConfigTaskGrid()){
			$.messageBox({level:'warn',message:"请先选择网格级别组织机构进行新增！"});
			return;
		}
		$("#workingSituationDialog").createDialog({
			width: 530,
            height: 340,
			postData:{
			       "workingSituation.organization.id":selectConfigTaskOrg()
			},
			title:"新增",
			url: '${path}/baseInfo/workingSituationManage/addPage.action',
			buttons: {
				"保存" : function(event){
				$("#maintainFormForWorkingSituationAdd").submit();
				
				 
				},
				"关闭" : function(){
					$(this).dialog("close");
				}
			}
		});
	});
	
		
	$("#search").click(function(event){
	
		$("#workingSituationDialog").createDialog({
			width: 650,
			height: 400,
			postData:{
			
			},
			title:'请输入查询条件',
			url: '${path}/baseInfo/workingSituationManage/searchPage.action',
			buttons: {
				"查询" : function(event){
				searchWorkingSituation();
				$(this).dialog("close");
				},
				"关闭" : function(){
					$(this).dialog("close");
				}
			}
		});
	});
	
	$("#reload").click(function(){
		
		$("#searchByCondition").attr("value","请输入民警姓名");
	
		if(selectConfigTaskOrg()!="" && selectConfigTaskOrg()!=null){
			onOrgChanged(selectConfigTaskOrg());
		}
	});
	
	$("#delete").click(function(){
		var selectedId = $("#workingSituationList").jqGrid("getGridParam", "selarrrow");
		if(selectedId.length==0){
			 $.messageBox({level:"warn",message:"请选择一条或多条记录，再进行删除！"});
			 return;
		}
		deleteOperator(event,selectedId);
	});
	
	$("#update").click(function(e){
	var selectedId =$("#workingSituationList").jqGrid("getGridParam", "selarrrow");
		
	  if(selectedId.length>1){
		$.messageBox({level:"warn",message:"只能选择一条数据进行操作！"});
 		return;
	}
	if(selectedId==null || selectedId==undefined || selectedId==''){
		$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
 		return;
	}
		updateWorkingSituation(event,selectedId);
	});
	
	$("#view").click(function(e){
	var selectedId =$("#workingSituationList").jqGrid("getGridParam", "selarrrow");
		
	  if(selectedId.length>1){
		$.messageBox({level:"warn",message:"只能选择一条数据进行操作！"});
 		return;
	}
	if(selectedId==null || selectedId==undefined || selectedId==''){
		$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
 		return;
	}
		viewWorkingSituation(selectedId);
	});
	
	$("#fastSearchButton").click(function(e){
	var orgId=selectConfigTaskOrg();
	fastSearch(orgId);
	});
	
	$("#refreshSearchKey").click(function(){
		$("#searchByCondition").attr("value","请输入民警姓名");
	});
	
	
	
	
	});
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.tianque.domain.property.OrganizationType,com.tianque.domain.Organization,com.tianque.domain.property.OrganizationLevel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<s:action name="getLoginInfo" var="loginAction" executeResult="false"
	namespace="/sessionManage" />
<s:action name="getFullOrgById" var="getFullOrgById"
	executeResult="false" namespace="/sysadmin/orgManage">
	<s:param name="organization.id"
		value="#loginAction.user.organization.id"></s:param>
</s:action>
<%
request.setAttribute("viewType",request.getParameter("viewType"));
	Organization userOrg = ThreadVariable.getUser().getOrganization();

boolean isOpen = false;
boolean isShowTreeSelect = false;
if (userOrg != null && userOrg.getOrgType() != null && userOrg.getOrgLevel() != null) {
	if (userOrg.getOrgType().getDisplayName().equals(OrganizationType.getInternalProperties().get(OrganizationType.FUNCTIONAL_ORG).getDisplayName())
			&& userOrg.getOrgLevel().getInternalId() == OrganizationLevel.DISTRICT && !userOrg.getDepartmentNo().endsWith("1jg") && !userOrg.getDepartmentNo().endsWith("1lx") && !userOrg.getDepartmentNo().endsWith("1xw")) {
		isOpen = true;
	}
	if (userOrg.getOrgLevel().getInternalId() == OrganizationLevel.TOWN) {
		isOpen = true;
	}
}
request.setAttribute("isOpen", isOpen);
Long rootId = userOrg.getId();
if(userOrg.getParentOrg() != null){
	rootId = userOrg.getParentOrg().getId();
}
request.setAttribute("userParentOrgId", rootId);
	if (userOrg.getOrgType().getDisplayName().equals(
			OrganizationType.getInternalProperties().get(
					OrganizationType.FUNCTIONAL_ORG).getDisplayName())) {
		request.setAttribute("isFun", true);
		if (userOrg.getDepartmentNo() != null && (userOrg.getDepartmentNo().endsWith("1jg") || userOrg.getDepartmentNo().endsWith("1lx") || userOrg.getDepartmentNo().endsWith("1xw"))) {
			isShowTreeSelect = true;
		}else{
			isShowTreeSelect = false;
		}
	} else {
		request.setAttribute("isFun", false);
		isShowTreeSelect = false;
	}
	request.setAttribute("isShowTreeSelect", isShowTreeSelect);
	if(userOrg.getDepartmentNo()!=null&&userOrg.getDepartmentNo().endsWith("1jg")){
		request.setAttribute("isShowDeleted", true);
	}
	
	String currentOrgName = "";
	if(userOrg != null && userOrg.getOrgName() !=null){
		currentOrgName = userOrg.getOrgName();
	}
	request.setAttribute("currentOrgName", currentOrgName);
%>
<style>
#nav>a {
	float: left;
	margin-right: 5px;
	display: inline;
}
</style>
<c:if test="${isShowTreeSelect}">
<div id="searchDiv" style="display:inline-block;*display:inline;zoom:1;overflow:hidden;height:30px;"> 
		 <div class="btnbanner btnbannerData">
			<div class="ui-widget autosearch">
			<input class="" type="text" value="" id="fastSearchIssueOrg" maxlength="20" class="searchtxt" style="width:200px;height: 25px; margin-top: 5px; background: threedhighlight;" onblur="value=(this.value=='')?'':this.value;" onfocus="value=(this.value=='')?'':this.value;"/>
			<button id="refreshSearchKey" class="ui-icon ui-icon-refresh searchbtnico"></button>
		</div>
		</div>
		<a href="javascript:;" id="searchOrgTree">确定</a>
	</div>
</c:if>
<c:if test="${!isFun}">
	<div class="btnbanner btnbannerData" style="float: left"><jsp:include
		page="/common/orgSelectedComponent.jsp" />
	<select
		onchange="onOrgChanged()" id="seachValue" class="form-txt"
		style="width: 100px;">
		<option value="present" selected="selected">本级</option>
		<option value="subordinate">直属下辖</option>
		<option value="all">下辖全部</option>
	</select>
	</div>
</c:if>
<%@ include file="/account/peopleAspiration/selectYearAndMonth.jsp" %>
<c:if test="${isFun}">
	<input type='hidden'  id="seachValue" value='all'/>
</c:if>
<div class="ui-corner-all nav-buttons" id="nav" style="float: left">
<pop:JugePermissionTag ename="addEnergy">
	<a id="add" href="javascript:;"><span>新增</span></a>
</pop:JugePermissionTag> 
<pop:JugePermissionTag ename="updateEnergy">
	<a id="update" href="javascript:void(0)"><span>修改</span></a>
</pop:JugePermissionTag> 
<pop:JugePermissionTag ename="deleteEnergy">
	<a id="delete" href="javascript:void(0)"><span>删除</span></a>
</pop:JugePermissionTag> 
 <pop:JugePermissionTag ename="importWaterResource">
        <a id="import" href="javascript:void(0)"><span>导入</span></a>
 </pop:JugePermissionTag>
	<!-- <a id="search" href="javascript:void(0)"><span>查询</span></a>-->
 	<a id="view" href="javascript:void(0)"><span>查看</span></a>
 	<a id="refresh" href="javascript:void(0)"><span>刷新</span></a> 
<pop:JugePermissionTag ename="addEnergy">
	<a id="printIssue" href="javascript:void(0)"><span>打印</span></a>
</pop:JugePermissionTag> 
	<a id="exportIssue" href="javascript:void(0)"><span>导出</span></a>
<a href="javascript:void(0)" class="jqsubgridButton" id="conceptTop"
	style="display: none"><span class="yijian">受理</span></a> 
<a href="javascript:void(0)" class="jqsubgridButton"
	id="supportConceptTop" style="display: none"><span class="yijian">辅助受理</span></a>
<a href="javascript:void(0)" class="jqsubgridButton" id="dealTop"
	style="display: none"><span class="yijian">办理</span></a> 
	 
<a href="javascript:void(0)" class="jqsubgridButton" id="feedBack"
	style="display: none"><span class="yijian">反馈</span></a> 	
<a href="javascript:void(0)" class="jqsubgridButton" id="replyFormTop"
      style="display: none"><span class="yijian">回复</span></a>
<a href="javascript:void(0)" class="jqsubgridButton" id="tmpDealTop"
	style="display: none"><span class="yijian">添加措施</span></a> 
<a href="javascript:void(0)" class="jqsubgridButton" id="programDealTop"
    style="display: none"><span class="yijian">办 理</span></a>		
<a href="javascript:void(0)" class="jqsubgridButton" id="periodDealTop"
	style="display: none"><span class="yijian">办  理</span></a> 	
	
 <select onchange="onOrgChanged(this.value)" id="_statusTypeSelect"
	class="form-txt" style="display: none; width: 70px; float: right;">
	<option value="" selected>全部</option>
	<option value="0">未验证</option>
	<option value="1">已验证</option>
</select> <input type="hidden" name="selectNodeId" id="selectNodeId" /> <input
	type="hidden" name="selectnodeLevel" id="selectnodeLevel" /> <input
	type="hidden" name="selectnodeType" id="selectnodeType" /></div>
<script type="text/javascript">
<c:if test="${isFun}">
	var currentOrgId='${loginAction.user.organization.id}';
	$("#currentOrgId").val(currentOrgId);
	$("#currentOrgId").attr("text",'${loginAction.user.organization.orgName}');
</c:if>
var orgTree;
var issueButtons={
		show:function(type){
			return issueButtons[type]();
		},
		myneed:function(){//我的待办
			
			<s:if test="#getFullOrgById.organization.orgLevel.internalId == @com.tianque.domain.property.OrganizationLevel@COUNTRY">
			this.showButtons(["修改",<c:if test='${isShowDeleted}'> "删除",</c:if>"查询","查看","刷新","打印","导出","受理","办理","回复"]);
			</s:if>
			<s:else>
				this.showButtons(["新增","修改",<c:if test='${isShowDeleted}'> "删除",</c:if>"导入","查询","查看","刷新","打印","导出","受理","办理","回复"]);
			</s:else>
		},
		mycheckPending:function(){
			this.showButtons(["查看","刷新", "打印","导出"]);
		},
		mydone:function(){
			this.showButtons(["查询","查看","刷新","添加措施", "办 理", "打印","导出",<c:if test='${isShowDeleted}'> "删除"</c:if>]);
		},
		mycompleted:function(){
			this.showButtons(["查询","查看","刷新", "打印","导出",<c:if test='${isShowDeleted}'> "删除"</c:if>]);
		},
		mysubmit:function(){
			this.showButtons(["查询","查看","刷新", "打印","导出"]);
		},
		myassign:function(){
			this.showButtons(["查询","查看","刷新", "打印","导出"]);
		},
		myfollow:function(){
			this.showButtons(["查询","查看","刷新", "打印","导出"]);
		},
		myperiod:function(){
			this.showButtons(["查询","查看","刷新","办  理", "打印","导出",<c:if test='${isShowDeleted}'> "删除"</c:if>]);
		},
		myfeedback:function(){
			this.showButtons(["查询","查看","刷新","反馈", "打印","导出"]);
		},
		mysupport: function () {//我的协办
            <s:if test="#getFullOrgById.organization.orgLevel.internalId == @com.tianque.domain.property.OrganizationLevel@COUNTRY">
            this.showButtons(["查询", "查看", "刷新", "受理", "添加措施", "打印","导出"]);
            </s:if>
            <s:else>
            this.showButtons(["查询", "查看", "刷新", "受理", "添加措施", "打印","导出"]);
            </s:else>
        },
        mynotice: function () {//我的抄告
            <s:if test="#getFullOrgById.organization.orgLevel.internalId == @com.tianque.domain.property.OrganizationLevel@COUNTRY">
            this.showButtons(["查询", "查看", "刷新", "打印","导出"]);
            </s:if>
            <s:else>
            this.showButtons(["查询", "查看", "刷新", "打印","导出"]);
            </s:else>
        },
        notice: function () {//抄告
            this.showButtons(["查询", "查看", "刷新"]);
        },
        createAndDone: function () {
            this.showButtons(["查询", "查看", "刷新"]);
        },
        mycreateAndDone: function () {
            this.showButtons(["查询", "查看", "刷新", "打印","导出"]);
        },
		support: function () {
            this.showButtons(["查询", "查看", "刷新"]);
        },
		need:function(){//下辖待办
			this.showButtons(["查询","查看","刷新"]);
		},
		done:function(){
			this.showButtons(["查询","查看","刷新"]);
		},
		completed:function(){
			this.showButtons(["删除","查询","查看","刷新"]);
		},
		submit:function(){
			this.showButtons(["查询","查看","刷新"]);
		},
		assign:function(){
			this.showButtons(["查询","查看","刷新"]);
		},
		
		follow:function(){
			this.showButtons(["查询","查看","刷新"]);
		},
		period:function(){
			this.showButtons(["查询","查看","刷新"]);
		},
		feedback:function(){
			this.showButtons(["查询","查看","刷新"]);
		}
		,
		skip:function(){
			this.showButtons(["查询","查看","刷新"]);
		},
		fourTeamsEvent:function(){
			this.showButtons(["查询","查看","刷新"]);
		},
		showButtons:function(showBtns){
			$(".nav-buttons>a").each(function(){
				if(!showBtns.contains($(this).text())){
					$(this).hide();
				}else{
					$(this).show();
				}
			});
			$("#seachValue").show();
			if(isGrid()){
				$("#seachValue").hide();
			}
		}
	};
$(function(){
	 
	function initOccurOrgSelector(){
			var orgLevelId = $("#jurisdictionsOrgLevel").val();
			var orgFuntionalTypeId = $("#jurisdictionsFunctionalOrgType").val();	
			orgTree=$("#fastSearchIssueOrg").treeSelect({
				nodeUrl:'/sysadmin/orgManage/ajaxOrgsForExtTreeByLevel.action?orgFuntionalTypeId='+orgFuntionalTypeId+'&orgLevelInternalId='+orgLevelId,
				allOrg:false,
				isRootSelected:false,
				emptyText:'${currentOrgName}',
				isFuncDep:true,
                rootId: ${userParentOrgId}
			});
			orgTree.on("click",function(node,e) {
				if(node != null){
					var nodeId = node.attributes.id;
					var nodeName = node.attributes.name;
					var nodeLevel = node.attributes.orgLevelInternalId;
					var nodeType = node.attributes.orgTypeInternalId;
					$("#selectNodeId").val(nodeId);
					$("#selectnodeLevel").val(nodeLevel);
					$("#selectnodeType").val(nodeType);
					$("#fastSearchIssueOrg").val(nodeName);
					$("#jurisdictionsKeyId").val(node.attributes.id);
				}
			});
		}
		
		$("#searchOrgTree").click(function(){
			var orgLevelId = $("#jurisdictionsOrgLevel").val();
			var orgFuntionalTypeId = $("#jurisdictionsFunctionalOrgType").val();	
			var nodeLevel = $("#selectnodeLevel").val();	
			var nodeType = $("#selectnodeType").val();	
			if(orgFuntionalTypeId==""||orgFuntionalTypeId==null){
					if($("#selectNodeId").val()==""){
						$.messageBox({level:'warn',message:"请选择组织机构！"});
						return;
					}
					//searchIsssueByOrgId();
					searchIsssueById();
			}else{
				var orgTypeInternal='<s:property value='@com.tianque.domain.property.OrganizationType@FUNCTIONAL_ORG'/>';
					if($("#selectNodeId").val()==""){
						$.messageBox({level:'warn',message:"请选择组织机构！"});
						return;
					}
					//searchIsssueByOrgId();
					searchIsssueById();
			}
		});
	$("#add").click(function(event){
		$("#issueDialog").createDialog({
			width:840,
			height:570,
			title:'新增能源信息',
			url:'${path}/threeRecords/energy/dispatch.action?mode=add&keyId='+$("#currentOrgId").val(),
			buttons: {
	        	"上一步": function (event) {
		        	$(".ui-dialog-buttonset  button").eq(0).hide();
		        	$('#tabs-option').tabs('select',0);
		        	$(".ui-dialog-buttonset  .ui-button-text").eq(1).text('下一步'); 
	        	},
	            "下一步": function (event) {
	                submit();
	            },
	            "关闭": function () {
	                $(this).dialog("close");
	            }
	        },
			open:function(){
				$(".ui-dialog-buttonset  button").eq(0).hide();
			}
		});
	});

	$("#delete").click(function(event){
		if (hasRowSelected()){
			$.confirm({
				title:"确认删除",
				message:"该能源处理信息删除后,将无法恢复,您确认删除该能源处理信息吗?",
				width:400,
				okFunc:function(){
					//deleteEnergy(getSelectedData().encryptIdByIssueId);
					var strs = getSelectedIds();
                    	for (i=0;i<strs.length ;i++) {
                    		deleteEnergy(getData(strs[i]).encryptIdByIssueId);
                    	}
				}
			});
		}else{
			$.messageBox({level:'warn',message:"没有可删除的数据！"});
			return;
		}
	});

	$("#update").click(function(event){
		if(!getOneSelect()){
    		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
    		return;
    	}
		if (hasRowSelected()){
			var selectedIssue = getSelectedData();
			editThreeRecords(selectedIssue.issueId)
		}else{
			$.messageBox({level:'warn',message:"没有可修改的数据！"});
		}
	});

	$("#view").click(function(){
		if(!getOneSelect()){
    		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
    		return;
    	}
		viewIssue(getSelectedId());
	});
	$("#refresh").click(function(){
		//reloadIssue();
		//searchIsssueById();
		$("#issueList").trigger("reloadGrid");
	});

	$("#search").click(function(event){
		var status = '';
		$("#issueDialog").createDialog({
			width: 750,
			height: 400,
			title: "能源查询-请输入查询条件",
			url: "${path}/threeRecords/energy/dispatch.action?mode=search&keyId="+$("#currentOrgId").val()+'&tag='+viewType.value+"&selectedIssueType=",
			buttons: {
		   		"查询" : function(event){
		   			if($("#searchIssueForm").valid()){
		   				searchIssue();
			        	$(this).dialog("close");
		   			}
	   			},
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	});
	$("#import").click(function(event){
        $("#energyDialog").createDialog({
            width: 400,
            height: 230,
            title:'数据导入',
            url:PATH+'/account/dataTrans/import.jsp?isNew=1&dataType=EnergyData&dialog=energyDialog&startRow=1&templates=ENERGYDATA&listName=energyForViewList',
            buttons:{
                "导入" : function(event){
                    $("#mForm").submit();
                },
                "关闭" : function(){
                    $(this).dialog("close");
                }
            },
            shouldEmptyHtml:false
        });
    });
	

	//打印
	$("#printIssue").click(function(event){
		if(!getOneSelect()){
    		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
    		return;
    	}
		if(!hasRowSelected()){
			$.messageBox({level:'warn',message:"没有可作打印的数据！"});
			return ;
		}
		var selectedIssue = getSelectedData();
		$("#issueDialog").createDialog({
			width: 900,
			height: 600,
			title: '打印能源信息',
			url:'${path}/threeRecords/energy/dispatch.action?mode=print&keyId=' + selectedIssue.encryptIdByIssueId,
			buttons: {
		   		"打印" : function(event){
					$("#energyPrint").printArea();
	   			},
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	});
	//导出
    $("#exportIssue").click(function (event) {
    	if(!getOneSelect()){
    		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
    		return;
    	}
        if (!hasRowSelected()) {
            $.messageBox({level: 'warn', message: "没有可导出的数据！"});
            return;
        }
        var selectedIssue = getSelectedData();
        var url='${path}/threeRecords/energy/exportExcel.action?keyId=' + selectedIssue.encryptIdByIssueId;
        var elemIF = document.createElement("iframe");  
	    elemIF.src = url;  
	    elemIF.style.display = "none";  
	    document.body.appendChild(elemIF);
    });

	$("#conceptTop,#conceptBottom").click(function(event){
		if(!getOneSelect()){
    		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
    		return;
    	}
		var selectedIssue = getSelectedData();
		var currentOrgId='${loginAction.user.organization.id}';
		 if(currentOrgId !=selectedIssue['targetOrg.id']){
      	 $.messageBox({level: 'warn', message: "该能源不可受理，请进行其它操作！"}); 
      	 return;
      	}
		if(selectedIssue.dealState!=null && '待处理' == selectedIssue.dealState){
			simpleDealIssue(selectedIssue.encryptIdByIssueStepId,<s:property value="@com.tianque.plugin.account.state.ThreeRecordsIssueOperate@CONCEPT.code"/>);
		}else{
			$.messageBox({level:'warn',message:"该能源不可受理，请进行其它操作！"});
		}
	});
	$("#supportConceptTop").click(function(event){
		if(!getOneSelect()){
    		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
    		return;
    	}
		var selectedIssue = getSelectedData();
		var currentOrgId='${loginAction.user.organization.id}';
		 if(currentOrgId !=selectedIssue['targetOrg.id']){
     	 $.messageBox({level: 'warn', message: "该能源不可受理，请进行其它操作！"}); 
     	 return;
     	}
		if(selectedIssue.dealState!=null && '待辅助处理' == selectedIssue.dealState){
			simpleDealIssue(selectedIssue.encryptIdByIssueStepId,<s:property value="@com.tianque.plugin.account.state.ThreeRecordsIssueOperate@SUPPORT.code"/>);
		}else{
			$.messageBox({level:'warn',message:"该能源不可受理，请进行其它操作！"});
		}
	});

	
	//由于该页面是动态的，使用click会重复绑定能源,所有使用以下方法
	$("#dealTop,#dealBottom").die().live("click",function(event){
		if(!getOneSelect()){
    		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
    		return;
    	}
		var selectedIssue = getSelectedData();
		if(selectedIssue.dealState!=null && '办理中' == selectedIssue.dealState){

			$.ajax({
	            url: "/threeRecords/energy/existEnergy.action",
	            data: {
	                "keyId": selectedIssue.issueId
	            },
	            success: function (responseData) {
	                if (responseData==null||responseData.id==null) {
	                    $.messageBox({level: 'warn',message: "该条能源类信息不可办理，请完善研究管理信息内容！"});
	                } else {
	                	dealIssue(selectedIssue.encryptIdByIssueStepId);
	                }
	            }
	        });
		}else{
			$.messageBox({level:'warn',message:"该条能源类信息不可办理，请先受理后再作办理操作！"});
		}
	});
	$("#tmpDealTop, #programDealTop").die().live("click",function(event){
		if(!getOneSelect()){
    		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
    		return;
    	}
		var selectedIssue = getSelectedData();
		dealIssue(selectedIssue.encryptIdByIssueStepId);
	});
	$("#periodDealTop").die().live("click",function(event){
		if(!getOneSelect()){
    		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
    		return;
    	}
		var selectedIssue = getSelectedData();
			dealIssue(selectedIssue.encryptIdByIssueStepId);
	});
	
	$("#feedBack").click(function(event){
		if(!getOneSelect()){
    		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
    		return;
    	}
		if(!hasRowSelected()){
			$.messageBox({level:'warn',message:"请选择一条数据再进行操作！"});
			return;
		}
		var selectedIssue = getSelectedData();

		$.post('${path}/threeRecords/feedBack/isCanFeedBack.action?&ledgerId='+ selectedIssue.issueId+'&ledgerType=<s:property value="@com.tianque.plugin.account.constants.LedgerConstants@PEOPLEASPIRATION_ENERGY"/>', function (data) {
			if(!data){
				$.messageBox({level:'warn',message: "该能源不可反馈，请进行其它操作！"});
				return;
			}
			$("#feedBackDialog").createDialog({
				width: 700,
				height: 400,
				title: "反馈",
				url: '${path}/threeRecords/feedBack/dispatch.action?keyId=' + selectedIssue.issueStepId+'&ledgerId='+ selectedIssue.issueId+'&ledgerType=<s:property value="@com.tianque.plugin.account.constants.LedgerConstants@PEOPLEASPIRATION_ENERGY"/>',
				buttons: {
			   		"反馈" : function(event){
			   			$("#maintainLedgerFeedBackForm").submit();
		   			},
			   		"关闭" : function(){
			        	$(this).dialog("close");
			   		}
				}
			});
		});

		
	});
	
	<c:if test="${isShowTreeSelect}">
	initOccurOrgSelector();
</c:if>
});

function searchIssue(){
	var data=$("#searchIssueForm").serializeArray();
	var searchVo={};
	for(i=0;i<data.length;i++){
		 if (searchVo[data[i].name]) {
           searchVo[data[i].name]=searchVo[data[i].name]+","+data[i].value;
		} else {
            searchVo[data[i].name] = data[i].value;
		}
	}
	var pageData = $.extend(
			{
			"searchVo.issueType":<s:property value="@com.tianque.plugin.account.constants.LedgerConstants@PEOPLEASPIRATION_ENERGY"/>,	
			"searchVo.sortField":"issueId",
			"searchVo.order":"desc",
			"searchVo.orgLevelInternalId":$("#currentOrgId").attr("orgLevelInternalId"),
			"searchVo.functionalOrgType":$("#jurisdictionsFunctionalOrgType").val(),
			"searchVo.leaderView":1,
			"viewType":$("#jurisdictionsViewType").val(),
			"type":$("#jurisdictionsIssueType").val(),
			"keyId":$("#jurisdictionsKeyId").val(),
			"orgLevel":$("#jurisdictionsOrgLevel").val(),
			"searchVo.seachValue":$("#seachValue").val()
			},
			searchVo);
	$("#issueList").setGridParam({
		url:"${path}/ledger/searchPeopleAspiration/findIssueForView.action",
		datatype: "json",
		page : 1
	});
	$("#issueList").setPostData(pageData);
	$("#issueList").trigger("reloadGrid");
	$("#_statusTypeSelect").val('');
}

function searchIsssueById(){
	if(undefined==$("#issueList").attr("id")){return;}
	$("#issueList").setGridParam({
		url:'${path}/threeRecords/energy/findIssueForView.action',
		datatype: "json"
	});
	$("#issueList").setPostData({
		"viewType":viewType.value,
		"orgLevelInternalId":$("#jurisdictionsOrgLevel").val(),
		"page":1,
		"leaderView":"0",
		"type":$("#jurisdictionsIssueType").val(),
		"keyId":$("#jurisdictionsKeyId").val(),
		"functionalOrgType":$("#jurisdictionsFunctionalOrgType").val(),
		"sourceTypeInternalId":$("#jurisdictionsOrgLevel").val(),
		"seachValue":$("#seachValue").val(),
		"year":$("#year").val(),
		"month":$("#month").val()
	});
	
	$("#issueList").trigger("reloadGrid");
}

function searchIsssueByOrgId(stateType){
	var searchVo={};
	var pageData = $.extend(
			{
			"searchVo.sortField":"issueId",
			"searchVo.order":"desc",
			"searchVo.statusType": stateType,
			"searchVo.orgLevelInternalId":$("#jurisdictionsOrgLevel").val(),
			"searchVo.functionalOrgType":$("#jurisdictionsFunctionalOrgType").val(),
			"searchVo.leaderView":1,
			"searchVo.searchOrgId":$("#selectNodeId").val(),
			"searchVo.targeOrgId":$("#jurisdictionsKeyId").val(),
			"viewType":$("#jurisdictionsViewType").val(),
			"type":$("#jurisdictionsIssueType").val()
			},
			searchVo);
	$("#issueList").setGridParam({
		url:"${path}/ledger/searchPeopleAspiration/findIssueForView.action",
		datatype: "json",
		page : 1
	});
	$("#issueList").setPostData(pageData);
	$("#issueList").trigger("reloadGrid");
}


function dealIssue(issueStepId){
	if(!getOneSelect()){
		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
		return;
	}
	if(issueStepId==null){
 		return;
	}
	var selectedIssue = getSelectedData();
	var issuesKeyId = selectedIssue.encryptIdByIssueId;
	$("#issueDialog").createDialog({
		width:720,
		height:550,
		title:'办理',
		url:'${path}/threeRecordsIssues/issueManage/dispatchDeal.action?mode=deal&keyId='+issueStepId+'&issuesKeyId='+issuesKeyId,
		buttons: {
			"确定" : function(event){
				$("#issueDealForm").submit();
			},
			"关闭" : function(){
				$(this).dialog("close");
			}
		}
	});
}


function simpleDealIssue(issueStepId,dealType){
	if(issueStepId==null){
 		return;
	}
	var dealTitil = "受理";
	if(dealType == <s:property value='@com.tianque.plugin.account.state.ThreeRecordsIssueOperate@READ.code'/>){
		dealTitil = "阅读";
	}else if(dealType == <s:property value='@com.tianque.plugin.account.state.ThreeRecordsIssueOperate@REPORT_TO.code'/>){
		dealTitil = "上报指挥中心";
	}else if (dealType == <s:property value='@com.tianque.plugin.account.state.ThreeRecordsIssueOperate@SUPPORT.code'/>){
		dealTitil = "辅助受理";
	}
	if(${isOpen} && viewType.value != "support"){
    	printAcceptForm(issueStepId)
    }else{
	$("#issueDialog").createDialog({
		width:350,
		height:200,
		title:dealTitil,
		url:'${path}/threeRecordsIssues/issueManage/dispatchDeal.action?dealCode='+dealType+'&keyId='+issueStepId,
		buttons: {
			"确定" : function(event){
				$("#issueDealForm").submit();
			},
			"关闭" : function(){
				$(this).dialog("close");
			}
		}
	});
    }
}

function printAcceptForm(id){
	$("#issueDialog").createDialog({
	    width: 900,
	    height: 400,
	    title: "受理单",
	    url: '${path}/threeRecords/acceptForm/dispatch.action?mode=add&keyId='+id+'&ledgerType=<s:property value="@com.tianque.plugin.account.constants.LedgerConstants@PEOPLEASPIRATION_ENERGY"/>',
	    ajaxType:'post',
	    buttons: {
	        "保存打印": function (event) {
	            $("#accept_form").submit();
	        },
	        "关闭": function () {
	            $(this).dialog("close");
	        }
	    }
	 });
}

function editThreeRecords(id){
	$("#issueDialog").createDialog({
		width:840,
		height:570,
		title: '修改能源信息',
		url:'/threeRecords/energy/dispatch.action?mode=edit&keyId='+id,
		buttons: {
	    	"上一步": function (event) {
	        	$(".ui-dialog-buttonset  button").eq(0).hide();
	        	$('#tabs-option').tabs('select',0);
	        	$(".ui-dialog-buttonset  .ui-button-text").eq(1).text('下一步'); 
	    	},
	        "下一步": function (event) {
	            submit();
	            searchIsssueById();
	        },
	        "关闭": function () {
	            $(this).dialog("close");
	        }
	    },
		open:function(){
			$(".ui-dialog-buttonset  button").eq(0).hide();
		}
	});
}

function deleteEnergy(keyId){
	$.ajax({
		url:"/threeRecords/energy/deleteEnergy.action",
		data:{
			"keyId":keyId
		},
		success:function(responseData){
			if (responseData==true){
				$.messageBox({message:"已经成功删除该能源处理信息!"});
				//reloadIssue();
				searchIsssueById();
				getMessageByUser();
			}else{
				$.messageBox({level:'error',message:"删除能源失败!"});
			}
		}
	});
}
$("#replyFormTop").click(function (event) {
	if(!getOneSelect()){
		$.messageBox({level: 'warn', message: "请选择一条台账进行操作！"});
		return;
	}
    if (!hasRowSelected()) {
        $.messageBox({level: 'warn', message: "请选择一条数据再进行操作！"});
        return;
    }
    var selectedIssue = getSelectedData();
     $("#feedBackDialog").createDialog({
         width: 700,
         height: 400,
         title: "回复单",
         url: '${path}/threeRecords/replyForm/dispatch.action?keyId=' + selectedIssue.issueStepId+'&serialNumber='+ selectedIssue.serialNumber + '&ledgerId=' + selectedIssue.issueId + '&ledgerType=<s:property value="@com.tianque.plugin.account.constants.LedgerConstants@PEOPLEASPIRATION_ENERGY"/>',
         buttons: {
             "回复": function (event) {
                 $("#maintainReplyForm").submit();
             },
             "关闭": function () {
                 $(this).dialog("close");
             }
         }
     });
});

</script>
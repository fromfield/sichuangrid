<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />

<input type='hidden' id='orgConfigTaskOrgId' value='' orgLevelInternalId="" />
<input type='hidden' id='funOrgId' value='' />
<s:if test="@com.tianque.core.util.ThreadVariable@getOrganization().getOrgLevel().internalId!=@com.tianque.domain.property.OrganizationLevel@GRID || @com.tianque.core.util.ThreadVariable@getUser().admin">
	<div class="btnbanner" id='btnbanner'>
		<a href="javascript:;" class="globalOrgBtnMod" id="globalOrgBtnMod"><span id="globalOrgBtn"></span></a>
	</div>
	<script>
		var childOrgsObj=null;
		var currentConfigTaskOrgDiv=null;
		$(function(){
			 if(isHasGridTaskList()){
				 $("#btnbanner").empty();
				 $("#btnbanner").append('<a href="javascript:;" class="globalOrgBtnMod" id="globalOrgTaskListBtnMod"><s:property value="@com.tianque.core.util.ThreadVariable@getOrganization().getOrgName()"/></a>');
				 var orgId='<s:property value="@com.tianque.core.util.ThreadVariable@getOrganization().getId()"/>';
				 $("#orgConfigTaskOrgId").val(orgId);
				 $("#funOrgId").val(orgId);
				 var str="<s:property value='@com.tianque.core.util.ThreadVariable@getOrganization().getOrgType().getInternalId()'/>";
				 $("#orgConfigTaskOrgId").attr("orgLevelInternalId",str);
				 orgTaskListChange();
			 }else{
				 nochange();
			 }
		});
		function isHasGridTaskList(){
			var isHasGridTaskList=false;
			$.ajax({
				type: "post", 
			    url: "${path}/baseInfo/gridConfigTaskManage/isHasGridTaskList.action?type=Task", 
				async:false, 
				error:function(){
					$.messageBox({message:"加载数据出错！",level: "error"});
				},
				success:function(data){
					if(data==null||typeof(data)=="string"){
						$.messageBox({message:"加载数据出错！",level: "error"});
					}else{
						isHasGridTaskList=data;
					}
				}
			});
			return isHasGridTaskList;
		}
		function orgTaskListChange(){
			$("#globalOrgTaskListBtnMod").click(function(){
				$("#globalOrgBox").createDialog({
					url:'${path}/baseInfo/gridConfigTaskManage/orgSelectComponent.action?organization.id='+$("#orgConfigTaskOrgId").val()+'&type=Task',
					width:550,
					height:'auto',
					title:'辖区选择',
					buttons: {
						"确定" : function(event){
							var selectInput=$("#orgConfigTaskSelectInput");
							var orgLevelInternalId=selectInput.attr("orgLevelInternalId");
							var text=selectInput.attr("text");
// 							$("#currentOrgId").attr({
// 								"orgLevelInternalId":orgLevelInternalId,
// 								text:text,
// 								value:selectInput.val()
// 							});
							$("#globalOrgTaskListBtnMod").html(text);
							$("#orgConfigTaskOrgId").val(selectInput.val());
							$("#orgConfigTaskOrgId").attr("orgLevelInternalId",orgLevelInternalId);
// 							alert(13);
							childOrgsObj=$("#childsDiv").html();
							currentConfigTaskOrgDiv=$("#currentConfigTaskOrgDiv").html();
							refreshList(null);
							$(this).dialog("close");
						},
						"取消" : function(){
							$(this).dialog("close");
						}
					}
				});
			});
		}
		
		function nochange(){
			var plateName='<%=request.getParameter("plateName")%>';
			 var selectType = '<%=request.getParameter("selectType")%>';
			 var url = '';
			 if(selectType!=null && selectType=='account'){
				 url = '${path}/sysadmin/orgManage/getOrgSelectForThreeAccount.action?id='+$.getCurrentOrgId()+"&selectType="+selectType;
			 }else{
				 url='${path}/sysadmin/orgManage/orgSelectComponent.action?id='+$.getCurrentOrgId()+"&plateName="+plateName;
			 }
			//将#globalOrgBtnMod 修正为 #globalOrgBtnMod.globalOrgBtnMod 写法仅为了解决在数字网格系统下id冲突的问题
			$("#globalOrgBtnMod.globalOrgBtnMod").click(function(){
				$("#globalOrgBox").createDialog({
					url:url,
					width:550,
					height:'auto',
					title:'辖区选择',
					buttons: {
						"确定" : function(event){
							var selectInput=$("#orgSelectInput");
							console.dir(selectInput);
							var orgLevelInternalId=selectInput.attr("orgLevelInternalId");
							var text=selectInput.attr("text");
							$("#currentOrgId").attr({
								"orgLevelInternalId":orgLevelInternalId,
								text:text,
								value:selectInput.val()
							});
							$("#globalOrgBtnMod.globalOrgBtnMod").html(text);
							if('familyAndHouse'==plateName && $("#currentOrgId").attr("orgLevelInternalId") >'<s:property value="@com.tianque.domain.property.OrganizationLevel@CITY"/>'){
								$.messageBox({level:"warn",
									message:'请选择市或市以下的层级！'});
								return ;
							}
							var curMenu=$("#accordion a.cur");
							var baseUrl=curMenu.attr("baseUrl");
							var leaderUrl=curMenu.attr("leaderUrl");
							var gridUrl=curMenu.attr("gridurl");
							if($("#tabList")[0]){
								var tabIndex=$("#tabList .ui-tabs-nav li.ui-tabs-active").index();
								if(tabIndex != -1){
									$("#tabList").tabs("load",tabIndex);
								} else {
									onOrgChanged();
								}	
								$(this).dialog("close");
							}else{
								baseLoad(curMenu,baseUrl,leaderUrl,gridUrl);
							}
							if(typeof afterOrgChanged =='function'){
								afterOrgChanged();
							}
						},
						"取消" : function(){
							$(this).dialog("close");
						}
					}
				});
			});setOrgSelect();
		  }
	</script>
</s:if>
<script>
function selectConfigTaskOrg(){
	if($("#orgConfigTaskOrgId").val()==""){
		return getCurrentOrgId();
	}else{
		return $("#orgConfigTaskOrgId").val();
	}
}

function isConfigTaskSelect(){
	if($("#orgConfigTaskOrgId").val()==""){
		return false;
	}else{
		return true;
	}
}

function isConfigTaskGrid(){
	if($("#orgConfigTaskOrgId").val()==""){
		return isGrid();
	}else{
		return $("#orgConfigTaskOrgId").attr("orgLevelInternalId") == <s:property value="@com.tianque.domain.property.OrganizationLevel@GRID"/>;
	}
}
</script>
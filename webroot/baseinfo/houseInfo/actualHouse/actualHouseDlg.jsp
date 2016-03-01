<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/PopGrid-taglib" prefix="pop"%>
<%@ include file="/includes/baseInclude.jsp" %>
<div id="dialog-form" title="房屋信息维护" class="container container_24">
	<div id="houseInfo" class="container container_24">
		<form id="maintainForm" method="post" action="" >
		<pop:token />
			<input type="hidden" name="dailogName" value="${dailogName}">
			<input id="_imgUrl" name="houseInfo.imgUrl" type="hidden" value="${houseInfo.imgUrl}"/>
			<input type="hidden" name="operateSource" value="${operateSource}" />
			<input type="hidden" id="organizationId" name="houseInfo.organization.id" value="${houseInfo.organization.id}"/>
			<jsp:include page="/baseinfo/commonPopulation/commonActualHouseDlg.jsp"></jsp:include>
		</form>
	</div>
	
</div>

<script type="text/javascript">

if(null!=$("#_imgUrl").val() && $("#_imgUrl").val()!=""){
	$("#headerImg").attr("src",$("#_imgUrl").val()+"?r="+Math.random());
	$(".shadow").show();
}

$(document).ready(function(){

	if(""!=$("#_imgUrl").val() && typeof($("#_imgUrl").val())!="undefined"){
		$("#img").attr("src","${path }/"+$("#_imgUrl").val());
	};
	
	$("#maintainForm").formValidate({
		
		submitHandler: function(form) {
		$("#_imgUrl").val($("#imgUrl").val());
		businessHouseToCurrentAddress();
		var data={};
		if(!$("#isRentalHouse").attr("checked")){
			data={'houseInfo.isRentalHouse':false};
		}
		$("#currentAddressType option:eq(1)").attr('selected', true);
		$("#addressTypeId").val($("#currentAddressType").find("option:selected").attr("id"));
        $(form).ajaxSubmit({
        	async : false,
            data:data,
			success: function(data){
	        	if(!data.id){
					$.messageBox({
						message:data,
						level: "error"
					});
					return;
				}
	        	//请求返回后赋值
	        	 $("#<s:property value='#parameters.dailogName[0]'/>").proccessSuccess(data.encryptId,data);
	        	 $("#<s:property value='#parameters.dailogName[0]'/>").proccessTypeSuccess(data.houseType,data);
      	   },
      	   error: function(XMLHttpRequest, textStatus, errorThrown){
      	      alert("提交错误");
      	   }
      	});
	},
	rules:{
	},
	messages:{
	},
	ignore:':hidden'
});

$("#maintainForm").attr("action","${path}/baseinfo/actualHouseManage/maintainHouseInfo.action");
<c:if test='${mode=="add"}'>
	$.ajax({
		async: false,
		url: "${path }/sysadmin/orgManage/getOrgRelativePath.action",
		data:{
			"organization.id":$("#organizationId").val()
		},
		success:function(responseData){
			$("#houseInfoOrgName").val(responseData);
		}
	});
</c:if>
});

</script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="dialog-form" title="志愿者岗位" class="container container_24">
	
	<form id="maintainForm" method="post" action="">
		<input type="hidden" name="mode" id="mode" value="${mode}" />
		<input type="hidden" name="volunteerJobs.id" id="id" value="${volunteerJobs.id}" />
		<input type="hidden" id="organizationId" name="volunteerJobs.organization.id" value="${volunteerJobs.organization.id}"/>
		<input type="hidden" id="orgInternalCode" name="volunteerJobs.orgInternalCode" value="${volunteerJobs.orgInternalCode}"/>
		
	 	
		<div class="grid_4 lable-right">
			<em class="form-req">*</em>
 			<label class="form-lb1">所属网格：</label>
 		</div>
 		<div class="grid_18">
 			<input type="text"  id="volunteerJobsOrgName"  name="volunteerJobs.organization.orgName"  readonly  value="${volunteerJobs.organization.orgName}" style="width: 99%"	class="form-txt" />
 		</div>
 		<div class='clearLine'>&nbsp;</div>
	 	
	 	<div class="grid_4 lable-right">
			<em class="form-req">*</em>
			<label class="form-lbl">志愿者岗位：</label>
	 	</div>
		<div class="grid_7">
			<input type="text" name="volunteerJobs.name" id="name"  maxlength="20" class="form-txt" value="${volunteerJobs.name}"/>
		</div>
	 	
	 	<div class="grid_4 lable-right">
			<label class="form-lbl">拟认领数：</label>
	 	</div>
		<div class="grid_7">
			<input type="text" name="volunteerJobs.claimPlans" id="claimPlans"  maxlength="6" class="form-txt" value="${volunteerJobs.claimPlans}"/>
		</div>
	 	
		<div class='clearLine'>&nbsp;</div>
		
		<div class="grid_4 lable-right">
			<label class="form-lbl">专长要求：</label>
	 	</div>
		<div class="grid_18 heightAuto" >
			<textarea rows="4" style="width: 99%;" name="volunteerJobs.content" id="content"  maxlength="200" class="form-txt">${volunteerJobs.content}</textarea>
		</div>
		<div class='clearLine'>&nbsp;</div>
	 	<div class="grid_4 lable-right">
			<label class="form-lbl">联系人：</label>
	 	</div>
		<div class="grid_7">
			<input type="text" name="volunteerJobs.contractor" id="contractor"  maxlength="20" class="form-txt" value="${volunteerJobs.contractor}"/>
		</div>
		<div class="grid_4 lable-right">
			<label class="form-lbl">联系电话：</label>
	 	</div>
		<div class="grid_7">
			<input type="text" name="volunteerJobs.telephone" id="telephone"  maxlength="13" class="form-txt" value="${volunteerJobs.telephone}" title="请输入由数字和-组成的联系电话 例如：0577-88888888"/>
		</div>
		<div class='clearLine'>&nbsp;</div>
		
	 	<div class="grid_4 lable-right">
			<label class="form-lbl">备注：</label>
	 	</div>
	 	<div class="grid_18 heightAuto">
			<textarea rows="4" style="width: 99%;" name="volunteerJobs.remark" id="remark"  maxlength="200" class="form-txt" >${volunteerJobs.remark}</textarea>
		</div>
		<div class='clearLine'>&nbsp;</div>
		
	</form>
	
</div>
<script type="text/javascript">

$(document).ready(function(){
	
	var nameData;
	jQuery.validator.addMethod("exsistedName", function(value, element){
		var value=$('#name').val();
		if(value==null||value==undefined||value==""){return true}
		$.ajax({
			async: false ,
			url:"${path}/volunteerjobsManage/hasDuplicateName.action",
		   	data:{
				"volunteerJobs.name":$('#name').val(),
				"volunteerJobs.organization.id":$('#organizationId').val(),
				"volunteerJobs.id":$('#id').val()
	        },
			success:function(responseData){
				nameData = responseData;
			}
		});
		if(!(nameData==null||nameData=="")){
			return false;
		}
		return true;
	});
	
	$("#maintainForm").formValidate({
		promptPosition: "bottomLeft",
		submitHandler: function(form) {
	        $(form).ajaxSubmit({
				success: function(data){
		        	if(!data.id){
						$.messageBox({
							message:data,
							level: "error"
						});
						return;
					}
					if(data.organization){
						data["organization.orgName"]=data.organization.orgName;
					}
					<c:if test='${mode=="edit"}'>
						onOrgChanged(getCurrentOrgId(),isGrid());
				    	$.messageBox({message:"志愿者岗位修改成功!"});
				    	$("#volunteerjobsDialog").dialog("close");
					</c:if>
					<c:if test='${mode=="add"}'>
						onOrgChanged(getCurrentOrgId(),isGrid());
						$.messageBox({message:"志愿者岗位新增成功!"});
						$("#volunteerjobsDialog").dialog("close");
					</c:if>
	      	   	},
	      	   	error: function(XMLHttpRequest, textStatus, errorThrown){
	      	    	alert("提交数据时发生错误");
	      	   	}
	      	});
		},
		rules:{
			"volunteerJobs.name":{
				required:true,
				exsistedName:true
			},
			"volunteerJobs.claimPlans":{
				digits:true,
				range:[1,999999]
			},
			"volunteerJobs.contractor":{
				minlength:2,
				maxlength:20
			},
			"volunteerJobs.telephone":{
				telephone:true
			}
		},
		messages:{
			"volunteerJobs.name":{
				required:"请输入志愿者岗位",
				exsistedName:function(){
					return nameData;
				}
			},
			"volunteerJobs.claimPlans":{
				digits:"拟认领数只能输入1到999999之间的整数",
				range:$.format("拟认领数只能输入{0}到{1}之间的整数")
			},
			"volunteerJobs.contractor":{
				minlength:$.format("联系人至少需要输入{0}个字符"),
				maxlength:$.format("联系人最多需要输入{0}个字符")
			},
			"volunteerJobs.telephone":{
				telephone:"联系电话不合法，只能输数字和横杠(-)"
			}
		},
		ignore:':hidden'
	});
	<c:if test='${mode=="add"}'>
    $("#maintainForm").attr("action","${path}/volunteerjobsManage/addVolunteerJobs.action");
</c:if>
<c:if test='${mode=="edit"}'>
    $("#maintainForm").attr("action","${path}/volunteerjobsManage/updateVolunteerJobs.action");
</c:if>
<c:if test='${mode=="add"}'>
	$.ajax({
		async: false,
		url: "${path}/sysadmin/orgManage/getOrgRelativePath.action",
		data:{
			"organization.id":$("#organizationId").val()
		},
		success:function(responseData){
			$("#volunteerJobsOrgName").val(responseData);
		}
	});
</c:if>
});

</script>



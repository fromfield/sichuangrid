<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@ include file="/includes/baseInclude.jsp"%>
<div id="dialog-form" title="工作台帐维护" class="container container_24">
	 <form id="dailyLog-form" method="post" action="" >
	 	<input id="dailyDirectoryId" type="hidden" name="gridManagementNormal.dailyDirectoryId" value="${gridManagementNormal.dailyDirectoryId}" />
		<input type="hidden" name="gridManagementNormal.id" value="${gridManagementNormal.id }"/>
		<input type="hidden" name="organization.id" value="${organization.id }" />
		<div class="grid_3 lable-right">
   			<label class="form-lb1">时间：</label>
   		</div>
   		<div class="grid_4" >
   			<input type="text" name="gridManagementNormal.activityDate" id="activityDate" maxlength="32"
  				readonly <s:if test='"view".equals(mode)'>disabled='true'</s:if> value='<s:date name="gridManagementNormal.activityDate" format="yyyy-MM-dd" />'
  				class="form-txt" />
   		</div>
   		<div style="clear:both"></div>
   		<div class="grid_3 lable-right">
			<label class="form-lbl">工作内容：</label>
		</div>
		<div style="display:inline;float:left;height:120px;line-height:110px;width:80.916%;">
			<textarea name="gridManagementNormal.work" style="height:110px;" <s:if test='"view".equals(mode)'>disabled="disabled"</s:if>
			 class="form-txt">${gridManagementNormal.work}</textarea>
		</div>
		<div style="clear:both"></div>
		<div class="grid_3 lable-right">
			<label >主要情况：</label>
		</div>
		<div style="display:inline;float:left;height:120px;line-height:110px;width:80.916%;">
			<textarea name="gridManagementNormal.content" style="height:110px;" <s:if test='"view".equals(mode)'>disabled="disabled"</s:if>
			 class="form-txt">${gridManagementNormal.content}</textarea>
		</div>
		<div class="grid_1"><s:if test='!"view".equals(mode)'><em class="form-req">*</em></s:if></div>
		<div style="clear:both"></div>
		<div class="grid_3 lable-right">
			<label >附件上传：</label>
		</div>
		<select id="attachFileNames" name="attachFiles" multiple="multiple" style="width:200px;display:none"/>
	</form>
	<div style="clear:both"></div>
</div>
<div id="attachFilesDiv" style="position:absolute;top:285px;left:90px;">
	<div id="custom-queue" style="width: 494px; height: 82px;overflow-y: auto;overflow-x: hidden;" class="ui-widget-border"></div>
	<s:if test='!"view".equals(mode)'>
	<input id="custom_file_upload" name="uploadFile" type="file" />
	</s:if>
</div>

<script type="text/javascript">
$(document).ready(function(){
	<s:if test='"add".equals(mode)'>$("#dailyLog-form").attr("action","${path}/workingRecord/gridManagementNormalManage/addGridManagementNormal.action");</s:if>
	<s:if test='"edit".equals(mode)'> $("#dailyLog-form").attr("action","${path}/workingRecord/gridManagementNormalManage/updateGridManagementNormal.action");</s:if>
	$(".dialogtip").inputtip();
	$('#custom_file_upload').uploadFile({
		queueID:"custom-queue",
		selectInputId:"attachFileNames"
	});
	$("#attachFileNames").empty();
	fillFile();
	$('#activityDate').datePicker({
		yearRange: '1900:2030',
   		dateFormat: 'yy-mm-dd',
           maxDate:'+0d'});
	
	$("#dailyLog-form").formValidate({
		promptPosition: "bottomLeft",
		submitHandler: function(form) {
			doAjaxSubmit(form);
		},
		rules:{
			"gridManagementNormal.work":{
				maxlength:2000
			},
			"gridManagementNormal.content":{
				required:true,
				minlength:2,
				maxlength:2000
			}
		},
		messages:{
			"gridManagementNormal.work":{
				maxlength:$.format("工作内容最多需要输入{0}个字符")
			},
			"gridManagementNormal.content":{
				required:"主要情况必须输入",
				minlength:$.format("主要情况最少需要输入{0}个字符"),
				maxlength:$.format("主要情况最多需要输入{0}个字符")
			}
		}
	});
});

function doAjaxSubmit(form){
	$(form).ajaxSubmit({
        success: function(data){
          if(!data.id){
             $.messageBox({message:data,level: "error"});
             return;
          }
 	   	 <s:if test='"add".equals(mode)'>
 	   		$("#dailyLogList").addRowData(data.id,data,"first");
	     	$.messageBox({message:"成功保存"+innerTitle+"信息!"});
	     </s:if>
	     <s:if test='"edit".equals(mode)'>
	     	$("#dailyLogList").setRowData(data.id,data);
		    $.messageBox({message:"成功修改"+innerTitle+"信息!"});
	     </s:if>
	     $("#dailyLogMaintanceDialog").dialog("close");
	     $("#dailyLogList").setSelection(data.id);
	     $("#dailyLogList").trigger("reloadGrid");
 	   },
 	   error: function(XMLHttpRequest, textStatus, errorThrown){
 	     $.messageBox({message:"提交错误",level: "error"	});
 	   }
 	});
}

function fillFile(){
	<s:if test="gridManagementNormal.dailyAttachFiles!=null && gridManagementNormal.dailyAttachFiles.size > 0">
        <s:iterator value="gridManagementNormal.dailyAttachFiles">
        $("#custom-queue").addUploadFileValue({
	          id:"<s:property value='id'/>",
	          filename:"<s:property value='fileName'/>",
	          link:"${path}/workingRecord/gridManagementNormalManage/downloadDailyAttachFile.action?dailyAttachFile.id=<s:property value='id'/>",
	          <s:if test='"view".equals(mode)'>
	          	showCloseButton:false,
	          </s:if>
	          onRemove:function(id){deleteDailyLogAttachFile(id)}
		});
        $("<option>").attr("id","<s:property value='id'/>").val("<s:property value='fileName' escape='false'/>").attr("selected",true).appendTo($("#attachFileNames"));
        </s:iterator>
	</s:if>
}

function removeAttach(fileName){
	$("#attachFileNames").find("option[value="+fileName+"]").remove();
}

function removeAttachById(id){
	$("#attachFileNames").find("option[id="+id+"]").remove();
}

function deleteDailyLogAttachFile(id){
	$.ajax({
		url:"${path}/workingRecord/gridManagementNormalManage/deleteDailyAttachFile.action?dailyAttachFile.id="+id,
		type:'GET',
		dataType:'json',
		success : function(_data){
			if(_data==true){
				removeAttachById(id);
			}
		},
		error : function(){
			$.messageBox({
				message : "加载失败，请刷新页面！",
				level : "error"
			});
		}
	});
}
</script>
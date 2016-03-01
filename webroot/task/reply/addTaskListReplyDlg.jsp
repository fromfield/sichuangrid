<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ include file="/includes/baseInclude.jsp"%>	
<div id="taskDlgForm" title="回复" class="container container_24">
	<form id="maintainForm" method="post" action="${path}/plugin/taskListManage/common/addTaskListReply.action">
		<pop:token/>
		<div class="grid_4 lable-right">
			<label class="form-lbl">回复时间：</label>
		</div>
		<div class="grid_8">
			<input type="text" name="taskListReply.replyDate" maxlength="50" value="<fmt:formatDate  value="${taskListReply.replyDate}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />"
				class="form-txt " readonly="readonly"/>
		</div>
		<div class="grid_4 lable-right">
			<label class="form-lbl">回复人：</label>
		</div>
		<div class="grid_8">
			<input type="text" name="taskListReply.replyUser" maxlength="50" value="${taskListReply.replyUser}"
				class="form-txt " readonly="readonly"/>
		</div>
		<div class='clearLine'></div>
		<div class="grid_4 lable-right">
			<label class="form-lbl">处理情况：</label>
		</div>
		<div class="grid_20 heightAuto">
			<textarea class="form-txt {required:true,messages:{required:'处理情况必填'}}" style="height: 100px" maxlength="1000" name="taskListReply.replyContent" >${taskListReply.replyContent}</textarea>
		</div>
		<div class='clearLine'></div>
		<div class="grid_4 lable-right" id="fileToShow">
		</div>
		<div class="grid_20 heightAuto">
			<select id="attachFileNames" name="attachFileNames" multiple="multiple" style="display:none"></select>
		</div>
		<input name="taskListReply.moduleKey" value="${taskListReply.moduleKey }" type="hidden"/>
		<input name="taskListReply.taskId" value="${taskListReply.taskId }" type="hidden"/>
		<input name="taskListReply.replayOrgType" value="${taskListReply.replayOrgType }" type="hidden"/>
	</form>
	<div class='clearLine'></div>
	<div class="filePanel" id='filePanelForException'>
		<div class="grid_4 lable-right" >
			<label class="form-lbl">附件上传：</label>
		</div>
		<div class="grid_20 heightAuto">
			<div id="custom-queue" class="ui-widget-border"></div>
			<input id="custom_file_upload" name="uploadFile" type="file" />
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	 $('#custom_file_upload').uploadFile({
			queueID : 'custom-queue',
			selectInputId : "attachFileNames"
		});
	 function removeAttach(fileName){
			$("input[name='file']").removeAttr("disabled");
			$("#attachFileNames").find("option:contains("+fileName+")").remove();
		}
	//表单验证 初始
	$('#maintainForm').formValidate({
		promptPosition : 'bottomLeft',
		submitHandler : function(form) {
			$(form).ajaxSubmit( {
				success : function(data) {
					if(data==true) {
						$.messageBox( {message : '成功保存回复!'});
						$("#reload,#refresh").click();
						$('#addTaskListReplyDlg').dialog('close');
					} else {
						$.messageBox( {
							level : 'error',
							message : data
						});
						return;
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert('提交错误');
				}
			});
		},
		rules:{
		},
		messages:{
		}
	});
});
	
</script>
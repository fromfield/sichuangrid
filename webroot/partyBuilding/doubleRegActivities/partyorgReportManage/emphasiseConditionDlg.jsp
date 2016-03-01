<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/includes/baseInclude.jsp"%>
<%@ taglib uri="/PopGrid-taglib" prefix="pop"%>
<% String dailogName = request.getParameter("dailogName");
	request.setAttribute("dailogName", dailogName);

	request.setAttribute("temp",request.getParameter("temp"));
	%>
<div id="emphasis-form" class="container container_24">
   	<form id="emphasisForm" method="post">
   	<pop:token />
   		<input type="hidden" name="ids" id="locationIds" value="<%=request.getParameter("locationIds")%>" />
   		<input type="hidden" name="partyOrgReport.isEmphasis" id="isEmphasisValue" value="<%=request.getParameter("isEmphasis")%>" />
        <input type="hidden" name="partyOrgReport.logOutTime" id="logOutTimeValue" value="" />

	<div class='clearLine'></div>
     <div class="grid_6 lable-right">
         <label class="form-lbl">&nbsp;&nbsp;取消关注时间：</label>
     </div>
     <div class="grid_16">
         <input type="text" name="partyOrgReport.logOutTime" id="logOutTime"  disabled="disabled" class="dialogtip form-txt"
        maxlength="20" />
     </div>
     	<div class='clearLine'></div>
    <div class="grid_6 lable-right">
    		<em class="form-req">*</em>
         <label class="form-lbl">取消关注原因：</label>
     </div>
          <div class="grid_16">
			<input type="text" name="partyOrgReport.logOutReason" id="logOutReason"   value="${partyOrgReport.logOutReason}" maxlength="20"
			class="form-txt {required:true,maxlength:20,messages:{required:'请输入取消关注原因',maxlength:$.format('备注最多只能输入{0}个字符')}}"  />
     </div>
	</form>
</div>
<script type="text/javascript">


$(function(){
	$("#emphasisForm").attr("action","${path}/partyorgReportManage/updateEmphasiseById.action" );

	var t=document.getElementById("logOutTime");
	d=new Date();
	t.value=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();

	t.onfocus=function(){
	 var d=new Date();
	 t.value=d.getHours()+":"+d.getMinutes()
	}
	$("#logOutTimeValue").val($("#logOutTime").val());
	$("#emphasisForm").formValidate({
		promptPosition: "bottomLeft",
		submitHandler: function(form){
			$(form).ajaxSubmit({
				success:function(data){
					if(!data){
	       	 			$.messageBox({
							message:data,
							evel: "error"
			 			});
	        			return;
					}
					if(null=="${temp}" || ""=="${temp}"){
						 $.messageBox({message:document.title+"取消关注成功"});
						 notExecute="${temp}";
					}else{
						 $.messageBox({level:'warn',message:"除选中的红色数据外,其余"+document.title+"取消关注成功"});
						 notExecute="${temp}".split(",");
					}
					
					$("#partyorgReportList").trigger("reloadGrid");
					 $("#partyorgReportDialog").dialog("close");
					 doAction("<s:property value='#parameters.dailogName[0]'/>",data.id);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
		      			alert("提交数据时发生错误");
	   		    }
			});
		},
		rules:{},
		messages:{}
	});

})



</script>


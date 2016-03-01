<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<jsp:include page="/includes/baseInclude.jsp" />

<div>
    <form action="${path}/serviceList/policyPropagandaManage/signPolicyPropaganda.action?" method="post" id="maintainForm">
    <input type="hidden" name="mode" id="mode" value="${mode}" />
	<input type="hidden" name="policyPropaganda.id"  value="${policyPropaganda.id}" />
	<input type="hidden" name="policyPropaganda.organization.id"  value="${policyPropaganda.organization.id}" />
	<div class="container container_24"> 
	    <div class="grid_4 lable-right">
	    	<em class="form-req">*</em>
			<label class="form-lbl">时间：</label>
		</div>
		<div class="grid_8 lable-left">
			<input id='inputTime' value='<s:date name="policyPropaganda.inputTime" format="yyyy-MM-dd HH:mm:ss"/>' readonly="readonly"  class="form-txt"/>
		</div>
	    <div class="grid_4 lable-right">
	    	<em class="form-req">*</em>
			<label class="form-lbl">地点：</label>
		</div>
		<div class="grid_8 lable-left">
			<input value='${policyPropaganda.address}' title="${policyPropaganda.address}"  readonly="readonly"  class="form-txt" />
		</div>
		<div class='clearLine'>&nbsp;</div>
		
		<div class="grid_4 lable-right">
	    	<em class="form-req">*</em>
			<label class="form-lbl">网格员姓名：</label>
		</div>
		<div class="grid_8 lable-left">
			<input id='createUser' value='${policyPropaganda.createUser}'  readonly="readonly"  class="form-txt" />
		</div>
		<div class="grid_4 lable-right">
			<em class="form-req">*</em>
			<label class="form-lbl">类别：</label>
		</div>
		<div class="grid_8">
			<select  id="category"  class="form-select "  disabled="disabled" >
	        	<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@POLICY_PROPAGANDA_CATEGORY" defaultValue="${policyPropaganda.category.id}" />
	        </select>		    
		</div>
		<div class='clearLine'>&nbsp;</div>
		
	    <div class="grid_4 lable-right">
	    	<em class="form-req">*</em>
			<label class="form-lbl">详细情况：</label>
		</div>
		<div class="grid_8 ">
			<input value='${policyPropaganda.details}' title="${policyPropaganda.details}" readonly="readonly"  class="form-txt" />
		</div>
		
		<div class='clearLine'>&nbsp;</div>
		
		<div class="grid_4 lable-right">
			<label class="form-lbl">备注：</label>
		</div>
		<div class="grid_20 heightAuto">
            <textarea rows="4" name="policyPropaganda"  cols="" class="form-txt" disabled="disabled" >${policyPropaganda.remake}</textarea>
    	</div>
		<div class='clearLine'>&nbsp;</div>
		<br/>
		
		<div class="grid_4 lable-right">
	    	<em class="form-req">*</em>
			<label class="form-lbl">签收人：</label>
		</div>
		<div class="grid_8 ">
			<input name='policyPropaganda.signPeople' value='${policyPropaganda.signPeople}' readonly="readonly"  class="form-txt"/>
		</div>
		<div class="grid_4 lable-right">
	    	<em class="form-req">*</em>
			<label class="form-lbl">签收日期：</label>
		</div>
		<div class="grid_8 lable-left">
			<input id='inputTime' name="policyPropaganda.signDate" value='<s:date name="policyPropaganda.signDate" format="yyyy-MM-dd HH:mm:ss"/>' readonly="readonly"  class="form-txt"/>
		</div>
		<div class='clearLine'>&nbsp;</div>
		
		<div class="grid_4 lable-right">
			<label class="form-lbl">签收意见：</label>
		</div>
		<div class="grid_20 heightAuto">
            <textarea rows="4" id="signContent" name="policyPropaganda.signContent" maxlength="300"  cols="" class="form-txt" >${policyPropaganda.signContent}</textarea>
    	</div>
		<div class='clearLine'>&nbsp;</div>
    </div>
    </form>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#maintainForm").formValidate({
		submitHandler: function(form){
			 $("#maintainForm").ajaxSubmit({
					success : function(data) {
						if(!data.id){
	           	 			$.messageBox({ 
								level: "error",
								message:data
				 			});
	            			return;
						}
						$.messageBox({message:"签收成功！"});
						$("#serviceListDialog").dialog('close');
						$("#policyPropagandaList").trigger("reloadGrid");
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("提交错误");
					}
			 });
		},
	});
});
</script>
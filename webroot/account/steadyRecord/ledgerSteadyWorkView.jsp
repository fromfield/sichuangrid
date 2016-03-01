<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="dialog-form" title="困难群众台账维护" class="container container_24" style="overflow:hidden;">
	<input type="hidden" id="organizationId" name="ledgerSteadyWork.organization.id" value="${ledgerSteadyWork.organization.id}"/>
	<input type="hidden" id="occurOrgId" name="ledgerSteadyWork.occurOrg.id" value="${ledgerSteadyWork.occurOrg.id}" />
	<input type="hidden" name="ledgerSteadyWork.id" id="id" value="${ledgerSteadyWork.id}" />
	<input type="hidden" name="ledgerSteadyWork.birthDay" id="birthDay" value="${ledgerSteadyWork.birthDay}" />
	<input type="hidden" name="ledgerSteadyWork.bookingUnit" id="bookingUnit" value="${ledgerSteadyWork.bookingUnit}" />
 		<div class="grid_4 lable-right">
 			<em class="form-req">*</em>
	    	<label class="form-lbl">反映群体：</label>
		</div>
		<div class="grid_7">
   			<select class="form-txt" disabled>
	   		<pop:OptionTag name="@com.tianque.plugin.account.property.PropertyTypes@STEADY_RECORD_WORK_INVOLVING_STEADY_TYPE" defaultValue="${ledgerSteadyWork.involvingSteadyType.id}"/></select>
		</div>
 		<div class="grid_4 lable-right">
   			<em class="form-req">*</em>
   		<label class="form-lbl">反映人数：</label></div>
    	<div class="grid_7">
   			<input type="text" value="${ledgerSteadyWork.involvingSteadyNum }" class="form-txt" readonly="readonly"/>
    	</div>
    	<div class='clearLine'>&nbsp;</div>
    	
		<div class="grid_4 lable-right">
   			<s:if test='!"view".equals(mode)'><em class="form-req">*</em></s:if>
	   		 <label class="form-lbl">身份证号：</label>
		</div>
		<div class="grid_7"><!-- ,exsistedIdCard:false -->
   			<input type="text" value="${ledgerSteadyWork.idCardNo }"  readonly="readonly"  class="form-txt" />
		</div>
		<div class="grid_4 lable-right">
   			<em class="form-req">*</em>
   			<label class="form-lbl">姓名：</label></div>
   	    <div class="grid_7">
   			<input type="text" value="${ledgerSteadyWork.name }" class="form-txt" readonly="readonly"/>
   	    </div>
   	    <div class='clearLine'>&nbsp;</div>
   	    
		<div class="grid_4 lable-right">
	    	<label class="form-lbl">性别：</label>
		</div>
		<div class="grid_7">
   			<select  class="form-txt" disabled>
	   		<pop:OptionTag name="@com.tianque.plugin.account.property.PropertyTypes@GENDER" defaultValue="${ledgerSteadyWork.gender.id}"/></select>
		</div>
		<div class="grid_4 lable-right">
			<em class="form-req">*</em>
			<label class="form-lbl">建卡类型：</label>
	 	</div>
		<div class="grid_7">
			<select class="form-txt" disabled>
		   		<pop:OptionTag name="@com.tianque.plugin.account.property.PropertyTypes@LEDGER_PEOPLEASPIRATION_CREATE_TABLE_TYPE"  defaultValue="${ledgerSteadyWork.createTableType.id}" />
			</select>
		</div>
		<div class='clearLine'>&nbsp;</div>
		
		<div  class="grid_4 lable-right" >
			<label class="form-lbl">编号： </label>
		</div>
		<div class="grid_7" id="userDiv">
   			<input type="text" value="${ledgerSteadyWork.serialNumber}" readonly="readonly" class="form-txt" />
		</div>
		<div class="grid_4 lable-right">
	 		<label class="form-lbl">是否党员：</label>
		</div>
    	<div class="grid_7">
   			<select name="ledgerSteadyWork.isPartyMember" class="form-txt" disabled>
   				<option value="false" <s:if test="false == ledgerSteadyWork.isPartyMember">selected="selected"</s:if>>否</option>
   				<option value="true" <s:if test="true == ledgerSteadyWork.isPartyMember">selected="selected"</s:if>>是</option>
   			</select>
   	    </div>
		<div class='clearLine'>&nbsp;</div>
		
		<div class="grid_4 lable-right">
	   	 	<label class="form-lbl">职业或身份：</label>
		</div>
		<div class="grid_7">
   			<select class="form-txt" disabled>
	   		<pop:OptionTag name="@com.tianque.plugin.account.property.PropertyTypes@POSITION_OR_STATUS" defaultValue="${ledgerSteadyWork.position.id}"/></select>
		</div>
		<div class="grid_4 lable-right">
	    	 <label class="form-lbl">常住地址：</label>
		</div>
    	<div class="grid_7">
   			<input type="text" value="${ledgerSteadyWork.permanentAddress }" class="form-txt" readonly="readonly"/>
   		</div>
   		<div class='clearLine'>&nbsp;</div>
   		
    	<div class="grid_4 lable-right">
			<label class="form-lbl">发生网格：</label>
		</div>
		<div class="grid_7">
			<input id="occurOrg" type="text" class="form-txt {orgLevelLessEqual:function(){return [getOccurOrgId(),<s:property value="@com.tianque.domain.property.OrganizationLevel@GRID"/>];},messages:{orgLevelLessEqual:'发生网格只能选择网格级别'}}" readonly="readonly" disabled/>
   		</div>
		<div class="grid_4 lable-right">
	    	<label class="form-lbl">联系电话：</label>
		</div>
		<div class="grid_7">
   			<input type="text"  value="${ledgerSteadyWork.mobileNumber }"
   				class="form-txt" readonly="readonly"/>
		</div>
		<div class='clearLine'>&nbsp;</div>
		
	<div class="grid_4 lable-right">
		<label class="form-lbl">登记人：</label>
	</div>
	<div class="grid_7">
		<input type="text"  name="ledgerSteadyWork.registrant" id="registrant"  maxlength="20" value="${ledgerSteadyWork.registrant}" 
				class='form-txt' readonly="readonly"/>
	</div>		
	<div class="grid_4 lable-right">
	    <label class="form-lbl">登记时间：</label>
	</div>
	<div class="grid_7" id="birthdayDiv">
   		<input type="text"  value="<s:date name="ledgerSteadyWork.registrationTime" format="yyyy-MM-dd"/>" class="form-txt" readonly="readonly"/>
	</div>
	<div class='clearLine'>&nbsp;</div>
    
    <div class='grid_2 lable-right'></div>
    <div class="grid_22 lable-center" style=" overflow:scroll;border-collapse: collapse;border: solid #000 1px;height:100;width:620;" >
  		<div class="grid_6 lable-right">
		    <label class="form-lbl">涉稳人员或涉稳群体代表：</label>
	    </div>
	    <div class="grid_3"></div>
	    <div class="grid_4 lable-right">
	    </div>
	    <div class="grid_11"></div>
	    
	  <div id="copyAddFamilyMembersParent">
	  <div id="copyAddFamilyMembers">
	      <c:forEach items="${ledgerSteadyWork.ledgerSteadyWorkPeopleInfos}" var="ledgerSteadyWorkPeopleInfos">
	   <div id="copyAddFamilyMembers">
	   <div class="grid_3 lable-right">
   			<label class="form-lbl">姓名：</label>
   		</div>
    	<div class="grid_3">
   			<input type="text" value="${ledgerSteadyWorkPeopleInfos.name}" class="form-txt" readonly="readonly"/>
    	</div>
    	<div class="grid_3 lable-right">
	    	<label class="form-lbl">身份证号：</label>
		</div>
		<div class="grid_3"><!-- ,exsistedIdCard:false -->
   			<input type="text" value="${ledgerSteadyWorkPeopleInfos.idCardNo}" class="form-txt" readonly="readonly"/>
		</div>
		<div class="grid_2 lable-right">
	    	<label class="form-lbl">性别：</label>
		</div>
		<div class="grid_3">
   			<select class="form-txt" disabled>
	   			<pop:OptionTag name="@com.tianque.plugin.account.property.PropertyTypes@GENDER" defaultValue="${ledgerSteadyWorkPeopleInfos.gender.id}"/></select>
		</div>
	   <div class="grid_3 lable-right">
	 		<label class="form-lbl">是否党员：</label>
		</div>
    	<div class="grid_3">
   			<select class="form-txt" disabled>
   				<option value="false" <s:if test="false == ledgerSteadyWorkPeopleInfos.isPartyMember">selected="selected"</s:if>>否</option>
   				<option value="true" <s:if test="true == ledgerSteadyWorkPeopleInfos.isPartyMember">selected="selected"</s:if>>是</option>
   			</select>
   	    </div>
		<div class='clearLine'>&nbsp;</div>
		
		<div class="grid_3 lable-right">
	    	<label class="form-lbl">联系电话：</label>
		</div>
		<div class="grid_3">
   			<input type="text" value="${ledgerSteadyWorkPeopleInfos.mobileNumber}"
   				class="form-txt" readonly="readonly"/>
		</div>
		<div class="grid_4 lable-right">
	   	 	<label class="form-lbl">职业或身份：</label>
		</div>
		<div class="grid_4">
   			<select class="form-txt" disabled>
	   		<pop:OptionTag name="@com.tianque.plugin.account.property.PropertyTypes@POSITION_OR_STATUS" defaultValue="${ledgerSteadyWorkPeopleInfos.position.id}"/></select>
		</div>
	   <div class="grid_4 lable-right">
	    	 <label class="form-lbl">常住地址：</label>
		</div>
    	<div class="grid_5">
   			<input type="text" value="${ledgerSteadyWorkPeopleInfos.permanentAddress}" class="form-txt" style="width: 99%;" readonly="readonly"/>
   		</div>
	    <div class='clearLine'>&nbsp;</div>
		
	  </div>
	  </c:forEach>
	  </div>
	  </div>
  	</div>
    <div class='clearLine'>&nbsp;</div>
    
     <div class="grid_4 lable-right">
   		<label class="form-lbl">涉稳类型 ：</label></div>
    <div class="grid_7">
   		<select name="ledgerSteadyWork.steadyWorkType.id" id="_poorBigInfo" class="form-txt" disabled>
   			<pop:PropertyDictReleationSelectTag name="@com.tianque.plugin.account.property.PropertyTypes@STEADY_RECORD_WORK_TYPE" defaultValue="${ledgerSteadyWork.steadyWorkType.id}" 
		   			reletionId="_poorInfo" reletionName="@com.tianque.plugin.account.property.PropertyTypes@STEADY_RECORD_WORK_PROBLEM_TYPE" id="_poorBigInfo"/></select>
    </div>
    <div class="grid_4 lable-right">
   		<label class="form-lbl">涉稳问题类型 ：</label>
   	</div>
    <div class="grid_7">
   		<select name="ledgerSteadyWork.steadyWorkProblemType.id" id="_poorInfo" class="form-txt" disabled>
	   		<pop:OptionTag name="@com.tianque.plugin.account.property.PropertyTypes@STEADY_RECORD_WORK_PROBLEM_TYPE" defaultValue="${ledgerSteadyWork.steadyWorkProblemType.id}"/></select>
    </div>
     <div class='clearLine'>&nbsp;</div>
    
	<div class="grid_4 lable-right">
		<s:if test='!"view".equals(mode)'><em class="form-req">*</em></s:if>
		<label class="form-lbl">涉稳事项：</label>
	</div>
	<div class="grid_20 heightAuto">
	   <textarea class="form-txt" readonly="readonly">${ledgerSteadyWork.involvingSteadyInfo}</textarea>
	</div>
</div>
<script type="text/javascript">

function initOccurOrgSelector(){
	var tree=$("#occurOrg").treeSelect({
		inputName:"ledgerSteadyWork.occurOrg.id",
		loadCom:function(){
			if(<s:property value='!"add".equals(mode)'/>){
				$.setTreeValue(getDefaultOccurOrg(),tree); 
			}
		}
	});
}

function getDefaultOccurOrg(){
	<s:if test="null!=ledgerSteadyWork.occurOrg && null!=ledgerSteadyWork.occurOrg.id">
		return "${ledgerSteadyWork.occurOrg.id}";
	</s:if>
	<s:else>
		return -1;
	</s:else>
}

$(document).ready(function(){

	$('#registrationTime').datePicker({
		yearRange: '1900:2030',
		dateFormat: 'yy-mm-dd',
        maxDate:'+0d'
        });
	
	initOccurOrgSelector();
});

function  getOccurOrgId(){
	return $("#occurOrgId").val();
} 
</script>
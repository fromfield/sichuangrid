<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/PopGrid-taglib" prefix="pop"%>
<%@ include file="/includes/baseInclude.jsp" %>
<div id="commonPopulation" class="container container_24">
		<input id="mode" type="hidden" name="mode" value="${mode}" />
		<input id="populationId" type="hidden" name="population.id" value="${population.id}" />
		<input id="" type="hidden" name="contextId" value="${contextId}" />
		<input id="provinceValue"	type="hidden" name="" value="${population.province}" />
		<input id="cityValue"	type="hidden" name="" value="${population.city}" />
		<input id="districtValue"	type="hidden" name="" value="${population.district}" />
		<input id="updateType" type="hidden" name="updateType" value="${updateType}" />
		<input id="actualHouseTypeId" type="hidden" name="" value="" />
		<input id="ajaxUrl" type="hidden" name="ajaxUrl" value="<s:property value="@com.tianque.controller.BaseInfoActionDefine@getAction(ajaxUrl)"/>" />
		<input id="populationOrganizationId" type="hidden" name="population.organization.id" value="${population.organization.id }" />
		<input id="_imgUrl" name="population.imgUrl" type="hidden" value="${population.imgUrl}"/>
		<s:if test="'floatingPopulationDialog'.equals(dailogName)||'householdStaffPopulationDialog'.equals(dailogName)">
			<input id="logOut"	type="hidden" name="population.logOut" value="${population.logOut}" />
		</s:if>
		<input id="businessHouse" type="hidden" value=""/>
		<input id="other" type="hidden" value=""/>
		<input type="hidden" id="actualPopulationType" name="population.actualPopulationType" />
		<input type="hidden" id="attentionPopulationType" name="population.attentionPopulationType" />
		<s:if test="'householdStaffPopulationDialog'.equals(dailogName)">
			<input id="population_outGone" name="population.outGone" value="${population.outGone}" type="hidden" />
		</s:if>
		<div class="grid_4 lable-right">
		   	<em class="form-req">*</em>
   			<label class="form-lb1">所属网格：</label>
   		</div>
   		<div class="grid_18">
   			<input type="text"  id="commonPopulationOrgName"  name="population.organization.orgName"  readonly value="${population.organization.orgName}" style="width: 99%"	class="form-txt" />
   		</div>

   		<div class='clearLine'>&nbsp;</div>
   			<div class="grid_4 lable-right">
   			<em class="form-req">*</em>
   			<label class="form-lb1">身份证号码：</label>
   		</div>
   		<div class="grid_7">
   			<input type="text" name="population.idCardNo" id="idCardNo" maxlength="18" value="${population.idCardNo}" style="width: 99%"
   				class="form-txt {required:true,idCard:true,messages:{required:'请输入身份证号码',idCard:'请输入一个合法的身份证号码'}}" />
   		</div>
   		<div class="grid_4 lable-right">
   			<em class="form-req">*</em>
   			<label class="form-lb1">姓名：</label>
   		</div>
   		<div class="grid_7">
   			<input type="text" name="population.name" id="name" maxlength="20" value="${population.name}" 
   				class='form-txt {required:true,exculdeParticalChar:true,minlength:2,maxlength:20,messages:{required:"请输入姓名",exculdeParticalChar:"不能输入非法字符",minlength:$.format("姓名至少需要输入{0}个字符"),maxlength:$.format("姓名最多需要输入{0}个字符")}}'
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
   				</s:if>
   			/>
   		</div>

   		<div class='clearLine'>&nbsp;</div>
   		
   		<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
			<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@SYNC_ACTUAL_POPULATION">
		   		<div id="actualPersonTypeDiv" style="display: none;">
			   		<div class="grid_4 lable-right">
			   			<em class="form-req">*</em>
			   			<label class="form-lb1">实口类型：</label>
			   		</div>
			   		<div class="grid_8">
			   			<input type="radio" class="form-btn {required:true,messages:{required:'请选择实口类型'}}" name="actualPersonType" value='<s:property value="@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF"/>' />&nbsp;&nbsp;户籍人口&nbsp;&nbsp;&nbsp;&nbsp;
			   			<input type="radio" class="form-btn" name="actualPersonType" value='<s:property value="@com.tianque.service.util.PopulationType@FLOATING_POPULATION"/>' />&nbsp;&nbsp;流动人口
			   		</div>
			   		<div class='grid_12'>&nbsp;</div>
		   		</div>   				
			</pop:GlobalSettingTag>   				
		</s:if>	
   		
   		<div class="grid_4 lable-right">
   			<em class="form-req">*</em>
   			<label class="form-lb1">性别：</label>
  		</div>
		<div class="grid_7">
		    <select name="population.gender.id" id="gender" class='form-txt {required:true,messages:{required:"请选择性别"}}' 
		    	<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
	    	>
		   		<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@GENDER" defaultValue="${population.gender.id}" />
			</select>
   		</div>
   		<div class="grid_4 lable-right">
   			<label class="form-lb1">曾用名/别名：</label>
   		</div>
   		<div class="grid_7">
   			<input type="text" name="population.usedName" id="usedName" maxlength="20" value="${population.usedName}" 
				class='form-txt {exculdeParticalChar:true,minlength:2,maxlength:20,messages:{exculdeParticalChar:"不能输入非法字符",minlength:$.format("曾用名/别名至少需要输入{0}个字符"),maxlength:$.format("曾用名/别名最多需要输入{0}个字符")}}' 
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>
   			/>
   		</div>
   		<div class="clearLine">&nbsp;</div>
   		<div  class="grid_4 lable-right">
  			<label class="form-lbl">联系手机：</label>
  		</div>
		<div class="grid_7">
		    <input type="text" name="population.mobileNumber" id="mobileNumber" maxlength="11" value="${population.mobileNumber }" title="请输入11位以1开头的联系手机  例如：13988888888" 
		    	class='form-txt {mobile:true,messages:{mobile:"手机号码输入只能是以1开头的11位数字"}}' 
		    	<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>
		    />
   		</div>
   		<div class="grid_4 lable-right">
   			<label class="form-lb1">固定电话：</label>
   		</div>
   		<div class="grid_7">
   			<input type="text" name="population.telephone" id="telephone" maxlength="20"  value="${population.telephone }" title="请输入由数字和-组成的联系电话,例如：0577-88888888" 
   				class='form-txt {telephone:true,messages:{telephone:$.format("固定电话不合法，只能输数字和横杠(-)")}}'
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>
   			/>
   		</div>
   		<div class="clearLine">&nbsp;</div>
   		<div class="grid_4 lable-right">
   			<label class="form-lb1">出生日期：</label>
   		</div>
   		<div class="grid_7" id="birthdayDiv">
   			<input type="text" name="population.birthday" id="birthday" maxlength="32" readonly  value='<s:date name="population.birthday" format="yyyy-MM-dd" />'class="form-txt" 
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>
   			/>
   		</div>
		<div  class="grid_4 lable-right">
  			<label class="form-lbl">民族：</label>
  		</div>
		<div class="grid_7">
		   <select name="population.nation.id" id="nation" class="form-txt" 
		   		<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
		   >
		   		<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@NATION" defaultValue="${population.nation.id}" />
			</select>
   		</div>
		<div class='clearLine'>&nbsp;</div>
		<div  class="grid_4 lable-right">
  			<label class="form-lbl">政治面貌：</label>
  		</div>
		<div class="grid_7">
		   <select name="population.politicalBackground.id" id="politicalBackground" class="form-txt" 
		   		<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
		   >
		   		<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@POLITICAL_BACKGROUND" defaultValue="${population.politicalBackground.id}" />
			</select>
   		</div>
   		<div  class="grid_4 lable-right">
  			<label class="form-lbl">文化程度：</label>
  		</div>
		<div class="grid_7">
		   <select name="population.schooling.id" id="schooling" class="form-txt" 
		   		<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
		   >
		   		<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@SCHOOLING" defaultValue="${population.schooling.id}" />
			</select>
   		</div>
   		 <div class="clearLine">&nbsp;</div>
   		 <div  class="grid_4 lable-right">
  			<label class="form-lbl">职业：</label>
  		</div>
		<div class="grid_7">
		   <select name="population.career.id" id="career" class="form-txt" 
		   		<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
		   >
		   		<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@CAREER" defaultValue="${population.career.id}" />
			</select>
   		</div>
   		<div class="grid_4 lable-right">
   			<s:if test='"dangerousGoodsPractitionerDialog".equals(#parameters.dailogName[0])'><em class="form-req">*</em></s:if>
   			<label class="form-lb1">工作单位或就读学校：</label>
   		</div>
   		<div class="grid_7">
   			 <input type="text" name="population.workUnit" id="workUnit" maxlength="50" value="${population.workUnit }"  class="form-txt" 
   			 	<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>
   			 />
   		</div>
   		<div class="clearLine">&nbsp;</div>
   		<div class="grid_4 lable-right">
   			<label class="form-lb1">婚姻状况：</label>
   		</div>
   		<div class="grid_7">
   			 <select name="population.maritalState.id" id="maritalState" class="form-txt" 
   			 	<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
   			 >
		   		<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@MARITAL_STATUS" defaultValue="${population.maritalState.id}" />
			</select>
   		</div>
   		<s:if test='!"add".equals(mode)'>
   		<div class="grid_4 lable-right">
		</div>
		<div class="grid_7">
			<input type="checkbox" id="isDead" name="population.death" value="true"   <s:if test='true==population.death'>checked="checked"</s:if> 
				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>
			/>
			<label class="form-check-text">是否死亡 </label>
		</div>
		</s:if>
   		<div class="clearLine">&nbsp;</div>
   		<div class="grid_4 lable-right">
   			<label class="form-lb1">身高：</label>
   		</div>
   		<div class="grid_6">
   			<input type="text" name="population.stature" id="stature" maxlength="3"  value="${population.stature }" title="请输入不大于300的正整数，如175"  
				class='form-txt {stature:true,messages:{stature:"请输入不大于300的正整数"}}'  
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>
   			/>
   		</div>
   		<div class="grid_1">cm</div>
   		<div  class="grid_4 lable-right">
  			<label class="form-lbl">血型：</label>
  		</div>
		<div class="grid_7">
		   <select name="population.bloodType.id" id="bloodType" class="form-txt" 
		   	<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
		   >
		   		<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@BLOOD_TYPE" defaultValue="${population.bloodType.id}" />
			</select>
   		</div>
   		<div class="clearLine">&nbsp;</div>

   		<div class="grid_4 lable-right">
   			<label class="form-lb1">宗教信仰：</label>
   		</div>
   		<div class="grid_7">
   			<select name="population.faith.id" id="faith" class="form-txt" 
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
   			>
		   		<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@FAITH" defaultValue="${population.faith.id}" />
			</select>
   		</div>
   		<div class="grid_4 lable-right">
   			<label class="form-lb1">电子邮箱：</label>
   		</div>
   		<div class="grid_7">
   			<input type="text" name="population.email" id="email" maxlength="50"  value="${population.email}"  
				class='form-txt {email:true,messages:{email:"请输入一个合法的电子邮箱"}}' 
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>
   			/>
   		</div>
   		<div class="clearLine">&nbsp;</div>
   		<s:if test='"householdStaffPopulationDialog".equals(#parameters.dailogName[0])'>
   		<div class="grid_4 lable-right">
   			<label class="form-lb1">户口类别：</label>
   		</div>
   		<div class="grid_7">
   			<select name="population.residenceType.id" id="residenceType" class="form-txt" 
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
   			>
		   		<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@RESIDENCE_TYPE" defaultValue="${population.residenceType.id}" />
			</select>
   		</div>
   		<div class="clearLine">&nbsp;</div>
   	    </s:if>
   		<div class="grid_4 lable-right">
   			<em class="form-req">*</em>
   			<label class="form-lb1">户籍地：</label>
   		</div>
   		<div class="grid_5">
			<select name="population.province" id="province" class='form-txt {required:true,messages:{required:"请选择户籍地省"}}' 
				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
			>
			</select>
  		</div>
   		<div class="grid_1">
   		  <label class="form-lbl">省</label>
   		</div>
   		<div class="grid_5">
			<select name="population.city" id="city" class='form-txt {checkIsNeedCity:true,messages:{checkIsNeedCity:"请选择户籍地市"}}' 
				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
			>
			</select>
 		</div>
   		<div class="grid_1">
   		  <label class="form-lbl">市</label>
   		</div>
   		<div class="grid_5">
			<select name="population.district" id="district" class='form-txt {checkIsNeedDistrict:true,messages:{checkIsNeedDistrict:"请选择户籍地县"}}' 
				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
				</s:if>
			>
			</select>
  		</div>
   		<div class="grid_1">
   		  <label class="form-lbl">县</label>
   		</div>
   		<div class="clearLine">&nbsp;</div>
   		<div class="grid_4 lable-right">
   			<label class="form-lb1">户籍地详址：</label>
   		</div>
   		<div class="grid_18">
   			<input type="text" name="population.nativePlaceAddress" id="nativePlaceAddress" maxlength="50" value="${population.nativePlaceAddress }" class="form-txt" style="width: 99%"
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>
			/>
		</div>
		<div class='clearLine'>&nbsp;</div>
		<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'>
				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION" condition="notEq">
				<s:if test="'add'.equals(mode) && population.houseId!=null">
				</s:if>
				<s:else>
					<div class="grid_4 lable-right">
						<em class="form-req">*</em>
			 			<label class="form-lb1">房屋编号：</label>
			 		</div>
			 		<div class="grid_18">
			 			<input type="text" id="houseCode"  name="population.houseCode" value="${population.houseCode}"  maxlength="50" style="width: 99%"
			 				class="form-txt {required:true,isCodeValidate:true,exsistedHouseCode:true,messages:{required:'请输入房屋编号',isCodeValidate:'不能输入非法字符',exsistedHouseCode:'该房屋编号已经存在，请重新输入'}}" />
			 		</div>
				</s:else>
			</pop:GlobalSettingTag>
		</s:if>
		<s:if test='@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)||@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)||@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'>
			
			<div class="grid_4 lable-right">
				<em class="form-req">*</em>
	 			<label class="form-lb1">有无固定地：</label>
	 		</div>
	 		<div class="grid_4">
	 			<select id="populationHasHouseInfo" name="population.isHaveHouse" class="form-txt">
	 				<option value="true" <s:if test="population.isHaveHouse">selected</s:if>>有</option>
	 				<option value="false" <s:if test="!population.isHaveHouse">selected</s:if>>无</option>
	 			</select>
	 		</div>
	 		<div id="houseCodeDiv1" <s:if test="!population.isHaveHouse">style="display: none;"</s:if>>
				<div class="grid_4 lable-right">
					<em class="form-req">*</em>
		 			<label class="form-lb1">房屋编号：</label>
		 		</div>
		 		<div class="grid_10">
		 			<input type="text" id="houseCode"  name="population.houseCode" value="${population.houseCode}"  maxlength="50" style="width: 99%"
		 				class="form-txt {required:true,isCodeValidate:true,exsistedHouseCode:true,messages:{required:'请输入房屋编号',isCodeValidate:'不能输入非法字符',exsistedHouseCode:'该房屋编号已经存在，请重新输入'}}" 
		 				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
			   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
						</s:if>	
		 			/>
		 		</div>
	 		</div>
	 		<div id="haveNotHouse" <s:if test="'add'.equals(mode)||population.isHaveHouse">style="display: none;"</s:if>>
				<div class="grid_4 lable-right">
					<em class="form-req">*</em>
		 			<label class="form-lb1">无房原因：</label>
		 		</div>
		 		<div class="grid_10">
		 			<input type="text" name="population.noHouseReason" value="${population.noHouseReason}"  maxlength="50" style="width: 99%"
		 				class="form-txt " 
		 			/>
		 		</div>
	 		</div>
		</s:if>
		<div id="houseCodeDiv2" <s:if test="!population.isHaveHouse">style="display: none;"</s:if>>
			<div class="grid_4 lable-right">
	   			<label class="form-lb1">常住地址：</label>
	   		</div>
	   		<div class="grid_3">
				<select name="population.currentAddressType.id" id="currentAddressType" class="form-txt" disabled="disabled"
					<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
		   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">disabled</pop:GlobalSettingTag>
					</s:if>
				>
			   		<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@CURRENT_ADDRESS_TYPE" defaultValue="${population.currentAddressType.id}" showInternalId="true"  notNull="true" />
				</select>
	   		</div>
	   		<div id="building" >
	   			<input type="hidden" name="population.houseId" id="houseId" value="${population.houseId}"/>
		   		<div class="grid_3">
			   		<input type="text" readonly id="community"  name="population.community"  maxlength="20"  value="${population.community}" style="width: 93%" class="form-txt" />
		   		</div>
		   		<div class="grid_2">
		   	   		 <label class="form-lbl">小区</label>
		   		</div>
		   		<div class="grid_2">
					 <input type="text" readonly id="block"  name="population.block"  maxlength="8"  value="${population.block}" style="width: 93%"	class="form-txt" />
		   		</div>
		   		<div class="grid_1">
		   		     <label class="form-lbl">幢</label>
		   		</div>
		   		<div class="grid_2">
		   			 <input type="text" readonly id="unit"  name="population.unit"  maxlength="6"  value="${population.unit}" style="width: 93%"	class="form-txt" />
		   		</div>
		   		<div class="grid_2">
		   		 	 <label class="form-lbl">单元</label>
		   		</div>
		   		<div class="grid_2">
		   			 <input type="text" readonly id="room"  name="population.room"  maxlength="10"  value="${population.room}" style="width: 93%"	class="form-txt" />
		   		</div>
		   		<div class="grid_1">
		   		  <label class="form-lbl">室</label>
		   		</div>
	   		</div>
   		</div>
   		<div id="otherAddress" class="grid_15" style="display:none">
   			<s:if test="'add'.equals(mode) && population.houseId!=null">
   				<input type="text" id="currentAddress" name="population.currentAddress"  maxlength="50"  value="${population.currentAddress }" readonly style="width: 99%" class="form-txt"/>
   			</s:if>
   			<s:else>
   				<input type="text" id="currentAddress" name="population.currentAddress"  maxlength="50"  value="${population.currentAddress }" style="width: 99%"
   					class="form-txt {currentAddress:true,messages:{currentAddress:'该房屋地址不存在，请重新填写'}}" 
   					<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
		   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
					</s:if>		
   				/>
   			</s:else>
   		</div>
   		<div class='clearLine'>&nbsp;</div>
   		<div class="grid_4 lable-right">
   			<label class="form-lb1">临时居所：</label>
   		</div>
   		<div class="grid_18">
   			<input type="text" name="population.otherAddress" id="populationOtherAddress"  maxlength="50" value="${population.otherAddress }" class="form-txt" style="width: 99%"
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>	
   			/>
   		</div>
   		<div class='clearLine'>&nbsp;</div>
   		<div class="grid_4 lable-right">
   			<label class="form-lb1">备注：</label>
   		</div>
   		<div class="grid_18">
   			<textarea rows="4" name="population.remark" id="remark" style="width: 99%"
   				class='form-txt {maxlength:300,messages:{maxlength:"备注最多需要输入300个字符"}}' 
   				<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	   				<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">readonly</pop:GlobalSettingTag>
				</s:if>	
   			>${population.remark }</textarea>
   		</div>
   		<input name="isSubmit" id="isSubmit" type="hidden" value="" />
	<div id="populationDialogJsp"></div>
</div>

<script type="text/javascript">
function populationHasHouseInfoChanged(){
	var dialogName = "<s:property value='#parameters.dailogName[0]'/>";
	if($("#populationHasHouseInfo").val()=="false"){
		$("#houseCodeDiv1,#houseCodeDiv2").hide();
		$("#haveNotHouse").show();
// 		$("#"+dialogName).createActualPopulationDialog("remove",'住房信息');
	}else{
		$("#houseCodeDiv1,#houseCodeDiv2").show();
		$("#haveNotHouse").hide();
// 		$("#"+dialogName).createActualPopulationDialog("add",[
// 			{
// 				title:'住房信息',
// 				url:'/baseinfo/houseInfoForPopulation/dispathHouseInfoForPopulation.action?mode=add&dailogName=floatingPopulationDialog',
// 				buttons:{prev:true,next:true},
// 				index:1
// 			}
// 		]);
	}
}
$("#populationHasHouseInfo").change(populationHasHouseInfoChanged);

$("input[name='actualPersonType']").click(function(){
	var dialogName = "<s:property value='#parameters.dailogName[0]'/>";
	$("#attentionPopulationType").val(dialogName.substring(0,dialogName.length-6));
	if($(this).val() == '<s:property value="@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF"/>') {
		$("#actualPopulationType").val('<s:property value="@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF"/>');
// 		$("#"+dialogName).createActualPopulationDialog("remove","流入信息");
// 		$("#"+dialogName).createActualPopulationDialog(
// 			"add",
// 			[{ 
// 				title:"户籍信息",
// 				url:"/baseinfo/householdStaff/getHouseholdStaffById.action?mode=add&dailogName="+dialogName,
// 				buttons:{prev:true,next:true},
// 				index:1
// 			}]
// 		)
	}else {
		$("#actualPopulationType").val('<s:property value="@com.tianque.service.util.PopulationType@FLOATING_POPULATION"/>');
// 		$("#"+dialogName).createActualPopulationDialog("remove","户籍信息");
// 		$("#"+dialogName).createActualPopulationDialog(
// 			"add",
// 			[{ 
// 				title:"流入信息",
// 				url:"/baseinfo/floatingPopulationManage/dispathInflowingInfomation.action?mode=add&dailogName="+dialogName,
// 				buttons:{prev:true,next:true},
// 				index:1
// 			}]
// 		)
	}
});

$("#populationDialogList").click(function(event){
	if($("#idCardNo").val().length==0 && $("#name").val().length==0){
		$.messageBox({ message:"请先输入人员身份证号码或姓名!",level: "error"});
		return;
	}
	$("#populationDialogJsp").createDialog({
		width:500,
		height:450,
		title:"选择人员",
		url:"${path}/baseinfo/commonPopulation/populationDialogList.jsp",
		buttons: {
   			"确定" : function(event){
				var	selectOrgId = $("#targeOrgSelectList").getGridParam("selrow");
				if(selectOrgId != null){
					var rowData = $("#targeOrgSelectList").getRowData(selectOrgId);
					$("#idCardNo").val(rowData.idCardNo);
					$("#name").val(rowData.name);
					var gender = document.getElementById("gender");
					selectedTrue(gender, rowData.sex);
					$("#nativePlaceAddress").val(rowData.nativePlaceAddress);
		  		}
   				$(this).dialog("close");
   			},
			"关闭" : function(){
        		$(this).dialog("close");
   			}
		}
	});
});

$("#householdAndfloatingDialogList").click(function(event){
	if($("#idCardNo").val().length==0 && $("#name").val().length==0){
		$.messageBox({ message:"请先输入人员身份证号码或姓名!",level: "error"});
		return;
	}
	$("#populationDialogJsp").createDialog({
		width:500,
		height:450,
		title:"选择人员",
		url:"${path}/baseinfo/commonPopulation/householdAndfloatingDialogList.jsp",
		buttons: {
   			"确定" : function(event){
				var	selectOrgId = $("#targeOrgSelectList").getGridParam("selrow");
				if(selectOrgId != null){
					var rowData = $("#targeOrgSelectList").getRowData(selectOrgId);
					$("#idCardNo").val(rowData.idCardNo);
					$("#name").val(rowData.name);
					$("#usedName").val(rowData.usedName);
					$("#mobileNumber").val(rowData.mobileNumber);
					$("#telephone").val(rowData.telephone);
					$("#birthday").val(rowData.birthday);
					var nation = document.getElementById("nation");
					selectedTrue(nation, rowData.nation);

					var politicalBackground = document.getElementById("politicalBackground");
					selectedTrue(politicalBackground, rowData.politicalBackground);
					var schooling = document.getElementById("schooling");
					selectedTrue(schooling, rowData.schooling);
					var career = document.getElementById("career");
					selectedTrue(career, rowData.career);
					$("#workUnit").val(rowData.workUnit);

					var maritalState = document.getElementById("maritalState");
					selectedTrue(maritalState, rowData.maritalState);
					$("#stature").val(rowData.stature);
					var bloodType = document.getElementById("bloodType");
					selectedTrue(bloodType, rowData.bloodType);
					var faith = document.getElementById("faith");
					selectedTrue(faith, rowData.faith);
					$("#email").val(rowData.email);
					threeSelect({
						province:'province',
						city:'city',
						district:'district',
						provinceValue:rowData.province,
						cityValue:rowData.city,
						districtValue:rowData.district
					});
					var currentAddressType = document.getElementById("currentAddressType");
					selectedTrue(currentAddressType, rowData.currentAddressType);
					chooseCurrentAddressType();
					if(rowData.currentAddressType == "商品房"){
						$("#community").val(rowData.community);
						$("#block").val(rowData.block);
						$("#unit").val(rowData.unit);
						$("#room").val(rowData.room);
					}else{
						$("#currentAddress").val(rowData.currentAddress);
					}
					$("#otherAddress").val(rowData.otherAddress);
					$("#remark").val(rowData.remark);
					var gender = document.getElementById("gender");
					selectedTrue(gender, rowData.gender);
					$("#nativePlaceAddress").val(rowData.nativePlaceAddress);
		  		}
   				$(this).dialog("close");
   			},
			"关闭" : function(){
        		$(this).dialog("close");
   			}
		}
	});
});

function selectedTrue(inputType, textName){
	for(var i = 0; i < inputType.length; i++){
		if(inputType[i].text==textName){
			inputType[i].selected=true;
		}
	}
}

if(null!=$("#_imgUrl").val() && $("#_imgUrl").val()!=""){
	$("#headerImg").attr("src",$("#_imgUrl").val()+"?r="+Math.random());
	$(".shadow").show();
}

function getCommonPopulation(idCardNo){
	if( idCardNo.length != null && idCardNo.length == 18){
		ajaxForCommonPopulation(idCardNo);
	}else if( idCardNo.length != null && idCardNo.length == 15){
		ajaxForCommonPopulation(idCardNo);
	}
}

jQuery.validator.addMethod("checkIsNeedCity", function(value, element){
	var flag = false;
	if($('#province').val()==""){return false;}
	if($('#city').val()!=""){return true;}
	$.ajax({
		type:'post',
		dataType:'json',
		async: false,
		url:'/baseinfo/permanentAddressManage/getPermanentAddressByParentName.action',
		data:{"parentName":$('#province').val()},
		success:function(data){
			var count = data.split("\,");
			if(count.length<=1){
				flag = true;
			}
		}
	});
	return flag;
});	

jQuery.validator.addMethod("checkIsNeedDistrict", function(value, element){
	alert("checkIsNeedCitycheckIsNeedCitycheckIsNeedCity");
	var flag = false;
	if($('#province').val()==""){return false;}
	if($('#district').val()!=""){return true;}
	$.ajax({
		type:'post',
		dataType:'json',
		async: false,
		url:'/baseinfo/permanentAddressManage/getPermanentAddressByParentNameAndPId.action',
		data:{"parentName":$('#city').val()},
		success:function(data){
			var count = data.split("\,");
			if(count.length<=1){
				flag = true;
			}
		}
	});
	return flag;
});

function ajaxForCommonPopulation(idCardNo){
	$.ajax({
		async:false,
		url: "${path}/commonPopulation/commonPopulationManage/getCommonPopulationByIdCardNo.action",
		data:{
			"commonPopulation.idCardNo":idCardNo
		},
		success:function(responseData){
			manageCommonPopulation(responseData);
		}
	});
}

function manageCommonPopulation(responseData){
	//省市县的选中
	threeSelect({
		province:'province',
		city:'city',
		district:'district',
		provinceValue:responseData.province,
		cityValue:responseData.city,
		districtValue:responseData.district
	});
}

var idleYouthOrgTree="";
function isGridForTreeSelect(){
	if(idleYouthOrgTree != ""){
		return $.getSelectedNode(idleYouthOrgTree).attributes.orgLevelInternalId == <s:property value="@com.tianque.domain.property.OrganizationLevel@GRID"/>;
	}else{
		return true;
	}
}

function initCurrentAddress(){
	$.ajax({
		async: false ,
		url:"${path }/sysadmin/propertyManage/findPropertyDictByDomainName.action",
	   	data:{
		"propertyDomain.domainName":"现居住址类型"
        },
		success:function(responseData){
    	   if(responseData!=null&&responseData.length>0){
        	   for(var i=0;i<responseData.length;i++){
            	   var data = responseData[i];
            	   if(data.internalId==<s:property value="@com.tianque.domain.property.CurrentAddressType@BUSINESS_HOUSE"/>){
        			   $("#businessHouse").val(data.id+"-"+data.internalId);
        	   		}else{
        	   		   $("#other").val(data.id+"-"+data.internalId);
        	   		}
        	   }
			}
        }
	});
	chooseCurrentAddressType();
}

function changeOrgId(){
	$("#organizationId").val($("#orgId").val());
}

function renderHouseInfoFromCBUR(house){
	$("#community").val(house.community);
	$("#block").val(house.block);
	$("#unit").val(house.unit);
	$("#room").val(house.room);
	businessHouseToCurrentAddress();
	$("#houseId").val(house.houseId);
}

function renderHouseInfoFromADD(house){
	$("#community").val("");
	$("#block").val("");
	$("#unit").val("");
	$("#room").val("");
	$("#currentAddress").val(house.address);
	$("#houseId").val(house.houseId);
}

function searchAndSynData(idCardNo, orgId) {
	$.ajax({
		url:"${path}/commonPopulation/commonPopulationManage/getActualPopulationByOrgIdAndIdCardNo.action",
		data:{
			"orgId":orgId,
			"idCardNo":idCardNo
        },
        success:function(data){
        	if(data == null) {
        		<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
        		<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@SYNC_ACTUAL_POPULATION">   				
        			$("#actualPersonTypeDiv").show();

        		</pop:GlobalSettingTag>  
        		<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_ADD_POPULATION">
        			$.messageBox({level:"info",message:"先增加实口人员信息，才能增加业务信息"});
        		</pop:GlobalSettingTag>  
        		</s:if>	
        		idCardChanged();
        		return;
        	}
        	$("#actualPersonTypeDiv").hide();
			$.each(data,function(i,n){
				if(n.id){
					$("select[name='population."+i+".id']:visible").val(n.id);
					if($("select[name='population."+i+".id']:visible").attr("disabled")) {
						$("<div>",{
								html:$("<input/>", {type:'hidden',name:'population.'+i+'.id',val:n.id})
					  	  	}).appendTo("#maintainForm");
					}
				}else{
					$("input[name='population."+i+"']:visible").val(n);
				}
			})
			$("input[name='population.houseId']", $("#maintainForm")).val(data.houseId);
			$("input[name='population.actualPopulationType']", $("#maintainForm")).val(data.actualPopulationType);
			
			$("select[name='population.province']:visible").val(data.province).change();
			if($("select[name='population.province']:visible").attr("disabled")) {
				$("<div>",{
					html:$("<input/>", {type:'hidden',name:'population.province',val:data.province})
		  	  	}).appendTo("#maintainForm");
			}
			$("select[name='population.city']:visible").val(data.city).change();
			if($("select[name='population.city']:visible").attr("disabled")) {
				$("<div>",{
					html:$("<input/>", {type:'hidden',name:'population.city',val:data.city})
		  	  	}).appendTo("#maintainForm");
			}
			$("select[name='population.district']:visible").val(data.district);
			if($("select[name='population.district']:visible").attr("disabled")) {
				$("<div>",{
					html:$("<input/>", {type:'hidden',name:'population.district',val:data.district})
		  	  	}).appendTo("#maintainForm");
			}
			$("#remark").val(data.remark);
			
			<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
    		<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@SYNC_ACTUAL_POPULATION">   				
    		var dialogName = "<s:property value='#parameters.dailogName[0]'/>";
    		$("#attentionPopulationType").val(dialogName.substring(0,dialogName.length-6));
    		if(data.actualPopulationType == '<s:property value="@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF"/>') {
//     			$("#"+dialogName).createActualPopulationDialog("remove","流入信息");
//     			$("#"+dialogName).createActualPopulationDialog(
//     				"add",
//     				[{ 
//     					title:"户籍信息",
//     					url:"/baseinfo/householdStaff/getHouseholdStaffById.action?mode=edit&dailogName="+dialogName+"&population.id="+data.id,
//     					buttons:{prev:true,next:true},
//     					index:1
//     				}]
//     			)
    			$("input[name='actualPersonType']:first").click();
    		}else if(data.actualPopulationType == '<s:property value="@com.tianque.service.util.PopulationType@FLOATING_POPULATION"/>'){
//     			$("#"+dialogName).createActualPopulationDialog("remove","户籍信息");
//     			$("#"+dialogName).createActualPopulationDialog(
//     				"add",
//     				[{ 
//     					title:"流入信息",
//     					url:"/baseinfo/floatingPopulationManage/dispathInflowingInfomation.action?mode=edit&dailogName="+dialogName+"&population.id="+data.id,
//     					buttons:{prev:true,next:true},
//     					index:1
//     				}]
//     			)
    			$("input[name='actualPersonType']:last").click();
    		}
    		</pop:GlobalSettingTag>  
    		</s:if>
		}
	})
}

function initalFormElement() {
	$("input[name^='population.']:visible",$("#maintainForm")).not("input[name='population.idCardNo']:visible").not("input[name='population.organization.orgName']:visible").val("");
	$("select[name^='population.']:visible",$("#maintainForm")).val("");
	$("textarea[name='population.remark']:visible",$("#maintainForm")).val("");
}


$(document).ready(function(){
	<s:if test="!population.isHaveHouse">
	populationHasHouseInfoChanged();
	</s:if>
	$("#idCardNo").blur(function(){
		<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@NOT_DEPENDENT" condition="notEq">
		initalFormElement();
		</pop:GlobalSettingTag>  
		
		if($(this).attr("createMsg")=="false") {
			searchAndSynData($(this).val(), getCurrentOrgId());
		}
	});
	
	<s:if test='"edit".equals(mode)'>
	<s:if test='!@com.tianque.service.util.PopulationType@UNSETTLED_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@FLOATING_POPULATION.equals(populationType)&&!@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF.equals(populationType)'> 
	<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@BUSINESS_DEPENDENT_ACTUAL_POPULATION" value="@com.tianque.core.globalSetting.util.GlobalSetting@SYNC_ACTUAL_POPULATION">   				
	var dialogName = "<s:property value='#parameters.dailogName[0]'/>";
	$("#attentionPopulationType").val(dialogName.substring(0,dialogName.length-6));
	$.ajax({
		url:"${path}/commonPopulation/commonPopulationManage/getActualPopulationByOrgIdAndIdCardNo.action",
		data:{
			"orgId":getCurrentOrgId(),
			"idCardNo":'<s:property value="population.idCardNo"/>'
        },
        success:function(data){
        	$("#houseCode").val(data.houseCode);
        	$("#houseId").val(data.houseId);
			if(data.actualPopulationType == 'householdStaff') {
// 				$("#"+dialogName).createActualPopulationDialog(
// 					"add",
// 					[{ 
// 						title:"户籍信息",
// 						url:"/baseinfo/householdStaff/getHouseholdStaffById.action?mode=edit&dailogName="+dialogName+"&population.id="+data.id,
// 						buttons:{prev:true,next:true},
// 						index:1
// 					}]
// 				)
				$("input[name='actualPersonType']:first").click();
			}else if(data.actualPopulationType == 'floatingPopulation'){
// 				$("#"+dialogName).createActualPopulationDialog(
// 					"add",
// 					[{ 
// 						title:"流入信息",
// 						url:"/baseinfo/floatingPopulationManage/dispathInflowingInfomation.action?mode=edit&dailogName="+dialogName+"&population.id="+data.id,
// 						buttons:{prev:true,next:true},
// 						index:1
// 					}]
// 				)
				$("input[name='actualPersonType']:last").click();
			}
        }
    });
	</pop:GlobalSettingTag>  
	</s:if>
	</s:if>
	
	/*
	$("#idCardNo").actualPopulationAutocomplete({
		postData:{
			orgId:function(){return getCurrentOrgId();}
		},
		select:function(event,ui){
			$.ajax({
				url:"${path}/commonPopulation/commonPopulationManage/getActualPopulationByOrgIdAndIdCardNo.action?orgId="+ui.item.orgId+"&idCardNo="+ui.item.idCardNo,
				success:function(data){
					$.each(data,function(i,n){
						if(n.id){
							$("select[name='population."+i+".id']:visible").val(n.id);
						}else{
							$("input[name='population."+i+"']:visible").val(n);
						}
					})
					$("select[name='population.province']:visible").val(data.province);
					$("select[name='population.city']:visible").val(data.city);
					$("select[name='population.district']:visible").val(data.district);
					$("#remark").val(data.remark);
				}
			})
		}
	});
	*/
	
	
	// 根据房屋编号自动获取房屋信息
	function searchHoseInfoByCode(){
		$.ajax({
			async: false ,
			url:"${path}/baseinfo/actualHouseManage/getHouseInfoByHouseCode.action",
		   	data:{
				"searchHouseInfoVo.houseCode":$('#houseCode').val(),
				"searchHouseInfoVo.houseTypeId":$('#actualHouseTypeId').val()
	        },
			success:function(data){
				if(null != data) {
					procCurrentAddressType(data);
				} else {
					$("#address").val("");
					$("#community").val("");
					$("#block").val("");
					$("#unit").val("");
					$("#room").val("");
					$("#currentAddress").val("");
					$("#houseId").val("");
				}
			}
		});
	}
	function procCurrentAddressType(data) {
		$("#houseId").val(data.id);
		$("#addressTypeId").val(data.addressType.id);
		$("#currentAddressType").val(data.addressType.id);
		if($("#currentAddressType").find("option:selected").attr("internalId")==<s:property value="@com.tianque.domain.property.CurrentAddressType@BUSINESS_HOUSE"/>) {
			$("#building").show();
			$("#otherAddress").hide();
			$("#community").val(data.community);
			$("#block").val(data.block);
			$("#unit").val(data.unit);
			$("#room").val(data.room);
			$("#address").val(data.community+"小区"+data.block+"幢"+data.unit+"单元"+data.room+"室");
		} else {
			$("#building").hide();
			$("#otherAddress").show();
			$("#currentAddress").val(data.address);
			$("#community").val("");
			$("#block").val("");
			$("#unit").val("");
			$("#room").val("");
		}
	}
	$("#houseCode").change(searchHoseInfoByCode);

	if(""!=$("#_imgUrl").val() && typeof($("#_imgUrl").val())!="undefined"){
		$("#img").attr("src","${path }/"+$("#_imgUrl").val());
	};

	$("#houseCode").houseAutoComplete({
		searchLevel:"houseCode",
		select:function(event,ui){
			renderHouseInfoForHouseCode(ui.item);
		}});

	function renderHouseInfoForHouseCode(house){
		$("#houseId").val(house.houseId);
		$("#addressTypeId").val(house.addressType.id);
		$("#currentAddressType").val(house.addressType.id);
		$("#community").val(house.community);
		$("#block").val(house.block);
		$("#unit").val(house.unit);
		$("#room").val(house.room);
		procCurrentAddressType(house);
		$("#houseCode").val(house.houseCode);
	}

	$("#community").houseAutoComplete({
		searchLevel:"community",
		select:function(event,ui){
			renderHouseInfoFromCBUR(ui.item);
		}});

	$("#block").houseAutoComplete({
		searchLevel:"block",
		select:function(event,ui){
			renderHouseInfoFromCBUR(ui.item);
		},
		postData: {
			community :function(){return $("#community").val();}
			}});

	$("#unit").houseAutoComplete({
		searchLevel:"unit",
		select:function(event,ui){
			renderHouseInfoFromCBUR(ui.item);
		},
		postData: {
			community :function(){return $("#community").val();},
			block :function(){return $("#block").val();}
			}});

	$("#room").houseAutoComplete({
		searchLevel:"room",
		select:function(event,ui){
			renderHouseInfoFromCBUR(ui.item);
		},
		postData: {
			community :function(){return $("#community").val();},
			block :function(){return $("#block").val();},
			unit :function(){return $("#unit").val();}
			}});

	$("#currentAddress").houseAutoComplete({
		searchByAddress:true,
		select:function(event,ui){
			renderHouseInfoFromADD(ui.item);
		}});

	threeSelect({province:'province',
		city:'city',
		district:'district',
		provinceValue:$('#provinceValue').val(),
		cityValue:$('#cityValue').val(),
		districtValue:$('#districtValue').val()
	});
	$(".dialogtip").inputtip();
	$("#currentAddressType").change(chooseCurrentAddressType);
	initCurrentAddress();
	initActualHouse();

	function initActualHouse() {
		$.ajax({
			async: false ,
			url:"${path }/sysadmin/propertyManage/findPropertyDictByDomainName.action",
		   	data:{
				"propertyDomain.domainName":"住房类别"
	        },
			success:function(responseData){
	    	   if(responseData!=null&&responseData.length>0){
	        	   for(var i=0;i<responseData.length;i++){
	            	   var data = responseData[i];
	            	   if(data.internalId==<s:property value="@com.tianque.domain.property.HouseInfoType@ACTUAL_HOUSE"/>){
	        			   $("#actualHouseTypeId").val(data.id);
	        	   		}
	        	   }
				}
	        }
		});
	}

	function searchHouse(searchByAddress,searchLevel){
		$.ajax({
			async: false ,
			url:"${path }/baseinfo/houseAutoComplete/findSingleHousesIdByAddressLib.action",
		   	data:{
				 "orgId":getCurrentOrgId(),
				 "searchByAddress":searchByAddress,
				 "searchType":searchLevel,
				 "community":function(){return $("#community").val()},
				 "block":function(){return $("#block").val()},
				 "unit":function(){return $("#unit").val()},
				 "searchCondition":function(){return searchByAddress?$("#currentAddress").val(): $("#room").val();}
	        },
			success:function(responseData){
	    		if(responseData==null||responseData==undefined||responseData==""||responseData=="null"){
	    			$("#houseId").val("");
		    	}else{
		        	$("#houseId").val(responseData);
			    }
	        }
		});
	}

	jQuery.validator.addMethod("isGridOrganization", function(value, element){
		if(value==null||value==undefined||value==""){return true}
		if(isGridForTreeSelect()){
			return true;
		}else{
			return false;
		}

	});

	jQuery.validator.addMethod("currentAddress", function(value, element){
		//var other = $("#other").val();
		//if(other!=null&& $("#currentAddressType").val()== other.split("-")[0]){
			if($("#currentAddressType").find("option:selected").attr("internalId")==<s:property value="@com.tianque.domain.property.CurrentAddressType@OTHER"/>){
				//searchHouse(true,"");
				var livingHouse=$("#currentAddress").val();
				return (livingHouse==null||livingHouse==undefined||livingHouse=="")?false:true;
//				if(value==null||value==undefined||value==""){
//	    			return false;
//	    		}else{
//	    			return true;
//	    		}
			}
		//}
	  return true;
	});

	jQuery.validator.addMethod("community", function(value, element){
		//var businessHouse = $("#businessHouse").val();
		//if(businessHouse!=null&& $("#currentAddressType").val()== businessHouse.split("-")[0]){
			if($("#currentAddressType").find("option:selected").attr("internalId")==<s:property value="@com.tianque.domain.property.CurrentAddressType@BUSINESS_HOUSE"/>) {
				var livingHouse=$("#community").val();
				return (livingHouse==null||livingHouse==undefined||livingHouse=="")?false:true;
			}
		//}
	  return true;
	});

	jQuery.validator.addMethod("exsistedIdCard", function(value, element){
		var flag =true;
		if(value==null||value==undefined||value==""){return true}
		$.ajax({
			async: false ,
			url:$('#ajaxUrl').val(),
		   	data:{
				"population.idCardNo":$('#idCardNo').val(),
				"organizationId":$('#populationOrganizationId').val(),
				"mode":$('#mode').val(),
				"population.id":$('#populationId').val()
	        },
			success:function(responseData){
				flag = !eval(responseData);
			}
		});
		return flag;
	});

	resetBirthdayField($("#birthday").val());
	
	$("#maintainForm").formValidate({
			submitHandler: function(form) {
				$("#_imgUrl").val($("#imgUrl").val());
				businessHouseToCurrentAddress();
	         	$(form).ajaxSubmit({
	             success: function(data){
	                     if(!data.id){
	                    	 $.messageBox({
								message:data,
								level: "error"
							 });
	                     	return;
	                     }
	                     doAction("<s:property value='#parameters.dailogName[0]'/>",data.id,data);
	      	   },
	      	   error: function(XMLHttpRequest, textStatus, errorThrown){
	      	      alert("提交错误");
	      	   }
	      	  });
			},
			ignore:":hidden",
			rules:{
			},
			messages:{
			}
		});

<s:if test='"add".equals(mode)'>
    $("#populationOrganizationId").val($("#currentOrgId").val());
	$.ajax({
		async: false,
		url: "${path }/sysadmin/orgManage/getOrgRelativePath.action",
		data:{
			"organization.id" : $("#currentOrgId").val()
		},
		success:function(responseData){
			$("#commonPopulationOrgName").val(responseData);
		}
	});
</s:if>

	<s:if test='#parameters.dialog != null'>
		idleYouthOrgTree = $("#commonPopulationOrgName").treeSelect({
			inputName:"population.organization.id",
			url:"/sysadmin/orgManage/loadTownForExtTree.action",
			onSelect:changeOrgId
		});
		var bol = false;
		$.ajax({
			async:false,
			url:"${path}/issue/issueManage/checkOccurOrgId.action",
			data:{
				"issueNew.occurOrg.id":${USER_ORG_ID}
			},
			success:function(responseData){
				bol = responseData;
			}
		});
		var url = "";
		if(bol){
			url = PATH+"/sysadmin/orgManage/ajaxSearchParentNodeIdsWhenRootIsTown.action?organization.id="+$("#orgId").val()
		}else{
			url = PATH+"/sysadmin/orgManage/ajaxSearchParentNodeIds.action?organization.id="+$("#orgId").val()
		}
		$.ajax({
			url:url,
			success:function(data){
				$.searchChild(idleYouthOrgTree,data);
			}
		});
	</s:if>

});

<s:if test='"add_path".equals(modeType)'>
function setZone(selectOrgId,selectOrgName){
		$("#orgId").val(selectOrgId);
		$("#organizationId").val(selectOrgId);
		$("#commonPopulationOrgName").val(selectOrgName);
	}
</s:if>

function idCardChanged(){
	var text=$('#idCardNo').val();
	text=getBirthDayTextFromIdCard(text);
	resetBirthdayField(text);
	text=$('#idCardNo').val();
	getCommonPopulation(text);
}

function resetBirthdayField(text){
	if (text!="" && $('#idCardNo').val()!=""){
		$("#birthdayDiv").html("<input type='text' name='population.birthday' id='birthday' class='form-txt' value='"+text+"' readonly/>");
	}else{
		$('#birthday').datePicker({
			yearRange: '1900:2030',
    		dateFormat: 'yy-mm-dd',
            maxDate:'+0d'});
	}
}

jQuery.validator.addMethod("exsistedHouseCode", function(value, element){
	var flag = true;
	/*
	if(value==null||value==undefined||value==""){return true}
	$.ajax({
		async: false ,
		url:"${path}/baseinfo/actualHouseManage/hasDuplicateHouseInfo.action",
	   	data:{
		"houseInfo.houseCode":$('#houseCode').val(),
		"orgId":$('#currentOrgId').val(),
		"mode":$('#mode').val(),
		"houseInfo.houseType.id":$('#houseTypeId').val(),
		"houseInfo.id":$("#mode").val() == "add"?"-1":$('#houseInfoId').val()
        },
		success:function(responseData){
			flag = !eval(responseData);
		}
	});
	*/
	return flag;
});

function businessHouseToCurrentAddress(){
	var businessHouse = $("#businessHouse").val();
	var other = $("#other").val();
	var currentAddressType = $("#currentAddressType").val();
	if(currentAddressType==businessHouse.split("-")[0]){
		var community = $("#community").val();
		var block = $("#block").val();
		var unit = $("#unit").val();
		var room = $("#room").val();
		var currentAddress ="";

		if(community!=null&&community!=undefined&&community!=""){
			currentAddress += community+"小区";
		}
		if(block!=null&&block!=undefined&&block!=""){
			currentAddress += block+"幢";
		}
		if(unit!=null&&unit!=undefined&&unit!=""){
			currentAddress += unit+"单元";
		}
		if(room!=null&&room!=undefined&&room!=""){
			currentAddress += room+"室";
		}
		 $("#currentAddress").val(currentAddress);
	}else{
		$("#community").val("");
		$("#block").val("");
		$("#unit").val("");
		$("#room").val("");
	}
}

function getBirthDayTextFromIdCard(idCard){
	if(idCard!=null&&idCard.length==18){
		idCard=idCard.substring(6,14);
		if(idCard.substring(4,6)<=0||idCard.substring(4,6)>12){
			return "";
		}else if(idCard.substring(6,8)<=0||idCard.substring(6,8)>31){
			return "";
		}else{
			return idCard.substring(0,4)+"-"+idCard.substring(4,6)+"-"+idCard.substring(6,8);
		}
	}else if(idCard!=null&&idCard.length==15){
		idCard=idCard.substring(6,12);
		if(idCard.substring(2,4)<=0||idCard.substring(2,4)>12){
			return "";
		}else if(idCard.substring(4,6)<=0||idCard.substring(4,6)>31){
			return "";
		}else{
			return "19"+idCard.substring(0,2)+"-"+idCard.substring(2,4)+"-"+idCard.substring(4,6);
		}
	}
	return "";
}

function isHelpPersonnel(){
	var flag=false;
	$.ajax({
		async:false,
		url: "${path }/baseinfo/helpPersonnel/getHelpPersonnelByIdAndPlace.action",
		data:{
			"personnelId":$("#idleYouthId").val(),
			"personnelType":$("#keyType").val()
		},
		success:function(responseData){
			if(responseData.length>0){
				flag=true;
			}
		}
	});
	return flag;
}

function chooseCurrentAddressType(){
	var businessHouse = $("#businessHouse").val();
	var other = $("#other").val();
	var currentAddressType = $("#currentAddressType").val();
	if(currentAddressType==businessHouse.split("-")[0]){
		$("#building").show();
		$("#otherAddress").hide();
	}else if(currentAddressType==other.split("-")[0]){
		$("#building").hide();
		$("#otherAddress").show();
	}
}
if(document.getElementById("jl_add3") != null && document.getElementById("jl_add3") != "null"){
	if($("#mode").val()== "add"){
		document.getElementById("jl_add3").style.display = "none";
	}else{
		if($("#population_outGone").val() == true || $("#population_outGone").val() == "true"){
			document.getElementById("jl_add3").style.display = "block";
		}else{
			document.getElementById("jl_add3").style.display = "none";
		}
	}
}

</script>
<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp"/> 

	<@pop.token />
<div class="container container_24">
	<input type="hidden" name="mode" id="mode" value="${(mode)!}" />
	<input type="hidden" name="mentalPatientTask.organization.id" id="orgId" value='<@s.property value="@com.tianque.core.util.ThreadVariable@getOrganization().getId()"/>'/>
	<input type="hidden" name="receipt.id" id="mentalPatientTaskId" value="${(mentalPatientTask.id)!}" />
	<input type="hidden" name="receipt.objectType" id="objectType" value="<@s.property value='@com.tianque.plugin.common.constant.Constants@MentalPatientTASK_KEY' />"/>
	<div class="grid_6 lable-right">
		<label class="form-lb1>">姓名：</label>
	</div>
	<div class="grid_4">
		<input type="text"  id="conditionName"  name="mentalPatientTask.name"      class="form-txt" />
	</div>
	<div class="grid_6 lable-right">
		<label class="form-lb1>">身份证号码：</label>
	</div>
	<div class="grid_4">
		<input type="text"  id="idCard"  name="mentalPatientTask.idCard"   value="${(mentalPatientTask.idCard)!}"   class="form-txt" />
	</div>
	<div class="grid_6 lable-right">
		<label class="form-lb1>">电话号码：</label>
	</div>
	<div class="grid_4">
		<input type="text"  id="phone"  name="mentalPatientTask.phone"   value="${(mentalPatientTask.phone)!}"   class="form-txt" />
	</div>
	<div class="grid_6 lable-right">
	    
		<label class="form-lbl">地点：</label>
	</div>
	<div class="grid_4">
		<input type="text" id="conditionPlace" name="mentalPatientTask.place" maxlength="50"  style="width:99%"  class="form-txt"/>
	</div>
	<div class='clearLine'>&nbsp;</div>
	
	<div class="grid_6 lable-right">
		
		<label class="form-lbl">监护人姓名：</label>
	</div>
	<div class="grid_4">
		<input type="text" name="mentalPatientTask.guardianName" maxlength="20" id="conditionGuardianName"  style="width:99%"  class="form-txt "/>
	</div>
	<div class="grid_6 lable-right" >
		<label class="form-lbl">帮扶人员：</label>
	</div>
	<div class="grid_4">
		<input type="text" id="helpPeople" class="form-txt" />
   	</div>
	<div class='clearLine'>&nbsp;</div>
	<div class="grid_6 lable-right">
		<label class="form-lbl">是否外出：</label>
	</div>
	<div class="grid_5">
	     <input type="radio" class="form-btn" id="conditionIsout" name="mentalPatientTask.isout" value='1'/>&nbsp;&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;
	     <input type="radio" class="form-btn" id="conditionIsout" name="mentalPatientTask.isout" value='0'/>&nbsp;&nbsp;否
	</div>
	<div class="grid_5 lable-right" class="form_txt">
		
		<label class="form-lbl">服药情况：</label>
	</div>
	<div class="grid_7">
	      <input type="radio" class="form-btn" id="conditionIsDriinked" name="mentalPatientTask.isDriinked" value='1'/>&nbsp;&nbsp;已服药&nbsp;&nbsp;
	      <input type="radio" class="form-btn" id="conditionIsDriinked" name="mentalPatientTask.isDriinked" value='0'/>&nbsp;&nbsp;未服药
	</div>	
	
	<div class='clearLine'>&nbsp;</div>
	<div class="grid_6 lable-right" >
		<label class="form-lbl">记录起始时间：</label>
	</div>
	<div class="grid_5">
		<input type="text" id="conditionStartDate" class="form-txt" readonly="readonly"/>
   	</div>
	
	<div class="grid_5 lable-right" >
		<label class="form-lbl">记录结束时间：</label>
	</div>
	<div class="grid_5">
			<input type="text" id="conditionEndDate" class="form-txt" readonly="readonly"/>
   	</div>
   	<div class='clearLine'></div>
	<div class="grid_6 lable-right">
		<label class="form-lbl">有无异常：</label>
	</div>
	<div class="grid_5">
		<select id="hasException"  class="form-select" >
				<option value=""></option>
				<option value="0">无</option>
				<option value="1">有</option>
		</select>
   	</div>
   	<div class="grid_5 lable-right">
		<label class="form-lbl">是否回复：</label>
	</div>
	<div class="grid_5">
		<select id="hasReplay"  class="form-select" >
				<option value=""></option>
				<option value="0">否</option>
				<option value="1">是</option>
		</select>
   	</div>
	<div class='clearLine'></div>
</div>	
</form>

<script type="text/javascript">

	$('#conditionStartDate').datePicker({
		yearRange: '1900:2030',
		dateFormat:'yy-mm-dd',
        maxDate:'+0d',
        onSelect: function(dateText, inst) {
		if(dateText!=null&&dateText!=''){
			var dateUnit=dateText.split('-');
			var date=new Date(dateUnit[0],dateUnit[1]-1,dateUnit[2]);
			$("#conditionStartDate").datepicker("option", "minDate",date);
			}
		}
	});
	$('#conditionEndDate').datePicker({
		yearRange: '1900:2030',
		dateFormat:'yy-mm-dd',
        maxDate:'+0d',
        onSelect: function(dateText, inst) {
		if(dateText!=null&&dateText!=''){
			var dateUnit=dateText.split('-');
			var date=new Date(dateUnit[0],dateUnit[1]-1,dateUnit[2]);
			$("#conditionEndDate").datepicker("option", "minDate",date);
			}
		}
	});

	
</script>

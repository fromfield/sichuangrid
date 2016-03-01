<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<div id="dialog-form" title="工作时间" class="container container_24">
	<form id="maintainForm" method="post" action="${path}/sysadmin/workCalendarManger/updateWorkTime.action">
	<pop:token />
		<input type="hidden" id="mode" value="<s:property value='#parameters.mode'/>">
		<input type="hidden" id="year" name="workCalendar.year" value="<s:property value='#parameters.year'/>">
		<input type="hidden" id="monthAndDay" name="monthAndDay" value="<s:property value='#parameters.monthAndDay'/>">
		<input type="hidden" id="calendarType" name="workCalendar.calendarType" value="<s:property value='#parameters.calendarType'/>">
		<input type="hidden" id="orgId" name="workCalendar.orgId" value="<s:property value='#parameters.orgId'/>">
		<input type="hidden" id="organization" name="organization" value="">
		<div class="grid_5 lable-right">
			<label class="form-lbl">工作时间：</label>
	 	</div>
		<div class='clearLine'>&nbsp;</div>
		<div class="grid_4 lable-right">
			<em class="form-req">*</em>
			<label class="form-lbl">上午：</label>
	 	</div>
		<div class="grid_8">
			<input type="text" id="startWorkTimeAM" name="workCalendar.startWorkTimeAM" value="<s:property value='#parameters.startAM'/>" class='form-txt {required:true,messages:{required:"请输入起始时间"}}' value=""/>
		</div>
		<div class="grid_2 lable-center">
			<label class="form-lbl">-</label>
	 	</div>
		<div class="grid_8">
			<input type="text" id="endWorkTimeAM" name="workCalendar.endWorkTimeAM" value="<s:property value='#parameters.endAM'/>" class='form-txt {required:true,messages:{required:"请输入结束时间"}}' value=''/>
		</div>
		<div class='clearLine'>&nbsp;</div>
		
		<div class="grid_4 lable-right">
			<em class="form-req">*</em>
			<label class="form-lbl">下午：</label>
	 	</div>
		<div class="grid_8">
			<input type="text" id="startWorkTimePM" name="workCalendar.startWorkTimePM" value="<s:property value='#parameters.startPM'/>" class='form-txt {required:true,messages:{required:"请输入起始时间"}}' value=""/>
		</div>
		<div class="grid_2 lable-center">
			<label class="form-lbl">-</label>
	 	</div>
		<div class="grid_8">
			<input type="text" id="endWorkTimePM" name="workCalendar.endWorkTimePM" value="<s:property value='#parameters.endPM'/>" class='form-txt {required:true,messages:{required:"请输入结束时间"}}' value=''/>
		</div>
		<div class='clearLine'>&nbsp;</div>
		<div class="grid_6 lable-center" id="name">
			<em class="form-req">*</em>
			<label class="form-lbl">所属地区：</label>
	 	</div>
		<div class="grid_12" id="area">
			<input type="text" class='form-txt' name="reportOrganization" id="reportOrganization" maxlength="50" readonly="readonly" value="" />
		</div>
	</form>
</div>
<script type="text/javascript">
$(document).ready(function(){
	if(<s:property value='#parameters.calendarType'/> == 0){
		$("#name").hide();
		$("#area").hide();
	}else{
		initOccurOrgSelector();
	}
	var mode = "<s:property value='#parameters.mode'/>";
	if(mode=="add"){
		$("#maintainForm").attr("action","${path}/sysadmin/workCalendarManger/addWorkCalendar.action");
	}else if(mode=="edit"){
		$("#maintainForm").attr("action","${path}/sysadmin/workCalendarManger/updateWorkTime.action");
	}
	$("#startWorkTimeAM").val("08:30:00");
	$("#endWorkTimeAM").val("11:30:00");
	$("#startWorkTimePM").val("13:30:00");
	$("#endWorkTimePM").val("17:30:00");
	var dateOption={
			timeFormat: 'HH:mm:ss',
			showMinute:true,
			showSecond:true,
			hour: 8,
			minute:00,
			currentText: '当前',
			closeText: '关闭',
			timeOnlyTitle: '选择时间',
			timeText: '时间',
			hourText: '时',
			minuteText: '分',
			secondText: '秒'
	}
	$("#startWorkTimeAM").timepicker($.extend(dateOption,{
		hour: 8,
		minute:30,
		onSelect: function(dateText, inst) {
		}
	})); 

	$("#endWorkTimeAM").timepicker($.extend(dateOption,{
		hour: 11,
		minute:30,
		onSelect: function(dateText, inst) {
		}
	}));
	$("#startWorkTimePM").timepicker($.extend(dateOption,{
		hour: 13,
		minute:30,
		onSelect: function(dateText, inst) {
		}
	})); 

	$("#endWorkTimePM").timepicker($.extend(dateOption,{
		hour: 17,
		minute:30,
		onSelect: function(dateText, inst) {
		}
	}));
	
	$("#maintainForm").formValidate({
		submitHandler: function(form) {
			var calendarType = <s:property value="#parameters.calendarType"/>;
			if(mode=="add"&&isExistCalendar()) {
				$.messageBox({message:"该年份工作类型的日历已经存在，不允许重复增加!",level:"error"});
				return;
			}else if(!isExistDefaultCalendar()&&calendarType==1){
				$.messageBox({message:"请先新增默认日历!",level:"error"});
				return;
			}
			/* 所属区域不限层级
			var calendarType = <s:property value="#parameters.calendarType"/>;
			if(calendarType==1&&!isOrgCity()){
				 $.messageBox({message:"所属区域只能选择地级市",level: "warn"});
				 return;
			} */
	        $(form).ajaxSubmit({
				success: function(data){
		        	if(data.monthAndDay!=null||data.monthAndDay!=""){
		        		if(mode=="add"){
		        			$.messageBox({message:"添加工作日历成功!"});
		        		}else{
		        			$.messageBox({message:"修改工作日历成功!"});
		        		}
		            	jQuery(".calendar").jqGrid('clearGridData',false);
		            	var day="["+data+"]";
		    			var mydata =eval("("+day+")");
		    			for(var i=0;i<=mydata.length;i++){
		    				jQuery(".calendar").jqGrid('addRowData',i+1,mydata[i]);
		    			}
		    			$("#"+$("#dialog-form").parent().attr("id")).dialog("close");
		            }
			    },
	      	   	error: function(XMLHttpRequest, textStatus, errorThrown){
	      	    	alert("提交数据时发生错误");
	      	   	}
	      	});
		},
		rules:{
		},
		messages:{
		},
		ignore:':hidden'
	});
	function isExistCalendar() {
		var orgId = $("#orgId").val();
		var flag = false;
		var urlPath;
		var calendarType = <s:property value="#parameters.calendarType"/>;
		if(calendarType==0){
			urlPath = '${path}/sysadmin/workCalendarManger/isYear.action?workCalendar.year=<s:property value="#parameters.year"/>'
		}else{
			urlPath = '${path}/sysadmin/workCalendarManger/isYear.action?workCalendar.year=<s:property value="#parameters.year"/>&workCalendar.calendarType=<s:property value="#parameters.calendarType"/>&workCalendar.orgId='+orgId;
		}
			
		$.ajax({
			async:false,
	        url:urlPath,
	        type: 'post',
	        success: function(data){
	        	flag = data;
	      	 }
	    });
		return flag;
	}
	//新增特色日历前判断是否存在默认日历
	function isExistDefaultCalendar() {
		var orgId = $("#orgId").val();
		var flag = false;
		var urlPath='${path}/sysadmin/workCalendarManger/isYear.action?workCalendar.year=<s:property value="#parameters.year"/>';
		$.ajax({
			async:false,
	        url:urlPath,
	        type: 'post',
	        success: function(data){
	        	flag = data;
	      	 }
	    });
		return flag;
	}
	function initWorkCalendar(parameter){
		if(parameter!=null && parameter!="" && !parameter.startWith("?")){
			parameter = "?"+parameter;
		}

		var startWorkTimeAM = $("#startWorkTimeAM").val();
		var endWorkTimeAM = $("#endWorkTimeAM").val();
		var startWorkTimePM = $("#startWorkTimePM").val();
		var endWorkTimePM = $("#endWorkTimePM").val();
		if(startWorkTimeAM!=null&&startWorkTimeAM!=""
			&&endWorkTimeAM!=null&&endWorkTimeAM!=""
				&&startWorkTimePM!=null&&startWorkTimePM!=""
					&&endWorkTimePM!=null&&endWorkTimePM!=""&&$("#mode").val()=="add"){
			//initWorkCalendar($("#maintainForm").formSerialize());
			return;
		}
		
		$.ajax({
	        url:'${path}/sysadmin/workCalendarManger/addWorkCalendar.action'+parameter,
	        type: 'post',
	        dataType:'json',
	        success: function(data){
	            if(data.monthAndDay!=null||data.monthAndDay!=""){
	            	$.messageBox({message:"初始化年份成功!"});
	            	jQuery(".calendar").jqGrid('clearGridData',false);
	            	var day="["+data+"]";
	    			var mydata =eval("("+day+")");
	    			for(var i=0;i<=mydata.length;i++){
	    				jQuery(".calendar").jqGrid('addRowData',i+1,mydata[i]);
	    			}
	    			$("#"+$("#dialog-form").parent().attr("id")).dialog("close");
	            }
	      	 }
	    });
	}
	function initOccurOrgSelector(){
		var orgTree=$("#reportOrganization").treeSelect({
			allOrg:false,
			isRootSelected:false,
			treeFunc:'initTree'
		});
		orgTree.on("click",function(node,e) {
			$("#organization").attr({
				"orgLevelInternalId":node.attributes.orgLevelInternalId,
				text:node.text,
				value:node.id
			});
			$("#orgId").val(node.id);
		});
	}
	function isOrgCity(){
		return $("#organization").attr("orgLevelInternalId") == <s:property value="@com.tianque.domain.property.OrganizationLevel@CITY"/>;
	}
})
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<script>
$(document).ready(function(){
	 $('#startCreateTime').dateTimePicker({
		yearRange:'1930:2060',
		timeFormat: 'HH:mm:ss',
		maxDate:'+0y',
		onClose: function (selectedDate) {
        	$("#endCreateTime").datepicker("option", "minDate", selectedDate);
        }
	})
	$('#endCreateTime').dateTimePicker({
		yearRange:'1930:2060',
		timeFormat: 'HH:mm:ss',
		maxDate:'+0y',
		onClose:function(selectedDate) {
       		$("#startCreateTime").datepicker("option", "maxDate",selectedDate);
    	}
	})
});
</script>
<div id="dialog-form" class="container container_24">
        <div class='clearLine'>&nbsp;</div> 
        <div class="grid_5 lable-right">
	     	<label class="form-lbl">粉丝昵称/备注名：</label>
	  	</div>
	  	<div class="grid_7">
	    	<input type="text" id="createUser" name="preciseInbox.createUser"  maxlength="20"  class="form-txt" />
	  	</div>
	   <div class="grid_5 lable-right">
	     	<label class="form-lbl">受理状态：</label>
	  	</div>
	  	<div class="grid_7">
	  		<select id="searchDealState" name="preciseInbox.dealState" class="form-txt">
	  		    <option value="">全部</option>
	  			<option value='<s:property value="@com.tianque.plugin.weChat.util.Constants@NOT_ACCEPT" />'>未受理</option>
				<option value='<s:property value="@com.tianque.plugin.weChat.util.Constants@ACCEPT" />'>已受理</option>
			</select>
  	   </div>
	   <div class='clearLine'>&nbsp;</div>
	   	<div class="grid_5 lable-right">
		  	<label class="form-lbl">接收时间从：</label> 
		</div>
		<div class="grid_7">
			<input type="text" value="<s:date name="preciseInbox.startCreateTime" format="yyyy-MM-dd HH:mm:ss"/>" id="startCreateTime"  readonly="readonly" class="form-txt"/>
		</div>
	  	 <div class="grid_5 lable-right">
	     	<label class="form-lbl">到：</label>
	  	</div>
	  	<div class="grid_7">
  	    	<input type="text" value="<s:date name="preciseInbox.endCreateTime" format="yyyy-MM-dd HH:mm:ss"/>" id="endCreateTime" readonly="readonly" class="form-txt"/>
  	   </div>
  	   	<div class='clearLine'>&nbsp;</div> 
	   	 <div class="grid_5 lable-right">
	  		<label class="form-lbl">所属群组：</label> 
	  	</div>
	    <div class="grid_7">
		    <select id="groupId" name='preciseInbox.groupId' class="form-txt">
		    	<option value=''>全部</option>
		    	<s:iterator value="weChatGroupList">
					 <option value='${groupId}'>${name}</option>
				</s:iterator>
			</select>
	   </div>
<%-- 	   <div class="grid_5 lable-right">
	     	<label class="form-lbl">转发状态：</label>
	  	</div>
	  	<div class="grid_7">
	  		<select id="searchForwardingState" name="preciseInbox.forwardingState" class="form-txt">
	  		<option value="">全部</option>
	  			<option value='<s:property value="@com.tianque.plugin.weChat.util.Constants@NOT_FORWARD" />'>未转发</option>
				<option value='<s:property value="@com.tianque.plugin.weChat.util.Constants@FORWARD" />'>已转发</option>
			</select>
  	   </div> --%>
	   	<div class='clearLine'>&nbsp;</div> 
  	    <div class="grid_5 lable-right">
	  		<label class="form-lbl">服务单号：</label> 
	  	</div>
	    <div class="grid_19">
	      <input type="text" id="serviceId" name="preciseInbox.serviceId"  maxlength="64"  class='form-txt {maxlength:64,messages:{maxlength:$.format("服务单号最多可以输入{0}个字符")}}' />
	   </div>
	  	<div class='clearLine'>&nbsp;</div> 
  	    <div class="grid_5 lable-right">
	  		<label class="form-lbl">事件简述：</label> 
	  	</div>
	    <div class="grid_7">
			<textarea  maxlength="64"  name="preciseInbox.profile" id="profile" style="height:70px;width: 400px" class='form-txt {maxlength:64,messages:{maxlength:$.format("回复内容最多可以输入{0}个字符")}}'></textarea>
	   </div>
</div>




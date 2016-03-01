<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@ include file="/includes/baseInclude.jsp" %>

<div id="search-condition-form" title="研判分析基础信息查询" class="container container_24">
<form id="maintainForm" method="post" action="">
   		<div>
			<div class="grid_4 lable-right">
				<label class="form-lbl">开始时间：</label>
			</div>
			<div class="grid_8 form-left">
		    	<select name="minYear" id="minYear" onchange="onChangeMinYear()">
		    		<option value="0"></option>
		    		<s:iterator begin="minYear" end="maxYear" var="newMinYear">
		    			<option value="${newMinYear }">${newMinYear }</option>
		    		</s:iterator>
		    	</select>年
		    	<select name="minMonth" id="minMonth" disabled="disabled" onchange="onChangeMinMonth()">
		    		<option value="0"></option>	
		    		<s:iterator begin="1" end="12" var="newMinMonth">
		    			<option value="${newMinMonth }">${newMinMonth }</option>
		    		</s:iterator>
		    	</select>月
			</div>
			
			<div class="grid_4 lable-right">
	  			<label class="form-lbl">结束时间：</label>
	  		</div>
    		<div class="grid_8 form-left">
				<select name="maxYear" id="maxYear" disabled="disabled" onchange="onChangeMaxYear()">
					<option value="0"></option>	
		    	</select>年
		    	<select name="maxMonth" id="maxMonth" disabled="disabled">
		    		<option value="0"></option>	
		    	</select>月
    		</div>
    		<div class='clearLine'></div>
	</div>
  </form>
</div>

<script type="text/javascript">
function onChangeMinYear(){
	if($("#minYear").val() > 0){
		$("#minMonth").removeAttr("disabled");
	}else{
		$("#minMonth").attr("disabled","disabled");
		$("#minMonth").val(0);
	}
	if($("#minMonth").val()>0){
		$("#minMonth").val(0);
	}
	$("#maxYear").attr("disabled","disabled");
	$("#maxYear").val(0);
	$("#maxMonth").attr("disabled","disabled");
	$("#maxMonth").val(0);
}

function onChangeMinMonth(){
	if($("#minMonth").val() > 0){
		var minYear = $("#minYear").val();
		var maxYear = ${maxYear};
		$("#maxYear").removeAttr("disabled");
		
		$('#maxYear option').remove();
		$("<option value='0'></option>").appendTo("#maxYear");
		for(var i = minYear ; i<=maxYear;i++){
			$("<option value='"+i+"'>"+i+"</option>").appendTo("#maxYear");
		}
	}else{
		$("#maxYear").attr("disabled","disabled");
		$("#maxYear").val(0);
	}
	$("#maxMonth").attr("disabled","disabled");
	$("#maxMonth").val(0);
}

function onChangeMaxYear(){
	if($("#maxYear").val() > 0){
		$("#maxMonth").removeAttr("disabled");
		if($("#maxYear").val() == $("#minYear").val()){
			var minMonth = $("#minMonth").val();
			$('#maxMonth option').remove();
			$("<option value='0'></option>").appendTo("#maxMonth");
			for(var i = minMonth ; i<=12;i++){
				$("<option value='"+i+"'>"+i+"</option>").appendTo("#maxMonth");
			}
		}else{
			$('#maxMonth option').remove();
			$("<option value='0'></option>").appendTo("#maxMonth");
			for(var i = 1 ; i<=12;i++){
				$("<option value='"+i+"'>"+i+"</option>").appendTo("#maxMonth");
			}
		}
	}else{
		$("#maxMonth").attr("disabled","disabled");
		$("#maxMonth").val(0);
	}
}
</script>
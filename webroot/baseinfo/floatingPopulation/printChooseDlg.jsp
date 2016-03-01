<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/PopGrid-taglib" prefix="pop"%>
<%@ include file="/includes/baseInclude.jsp" %>

<form id="printOptionsForm" method="post">
<table class="tablelist">
	
</table>
</form>

<script>
$(document).ready(function(){
	var options = $("#printOptionsForm table");
	var optionsStr='';
	var disabledStr;
	var hrefStr;
	var titleName;
	var titleArray=['家庭信息','服务人员','服务记录'];
	$("#tabs li").each(function(index) {
	     //alert(index + ': ' + $(this).text());
	     hrefStr=$(this).find("a").attr("href");
	     titleName=$.trim($(this).text());
	     if($.inArray(titleName, titleArray)>-1){
	     	//hrefStr+='&mode=print';
	     	//alert(hrefStr.replace('mode=view','mode=print'));
	     	if(hrefStr.indexOf('mode')>0){
	     		hrefStr=hrefStr.replace('mode=view','mode=print').replace('mode=page','mode=print');
	     	}else{
	     		hrefStr+='&mode=print';
	     	}
	     }
	     if(index==0){
			disabledStr ='checked="checked" disabled="disabled"';
		 }else{
			disabledStr ='';
		 }
	     if(index%2==0) optionsStr+='<tr>';
	     optionsStr+='<td><label id="printLabelTitle'+index+'">'+titleName+'：</label><input type="checkbox" '+disabledStr+' name="printOptions" value ="'+hrefStr+'"></td>';
	     if(index>0 && index%2!=0) optionsStr+='</tr>';
	});
	options.append(optionsStr);
});
</script>
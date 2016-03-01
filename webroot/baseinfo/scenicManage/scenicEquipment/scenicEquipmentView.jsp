<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/PopGrid-taglib" prefix="pop"%>
<%@ include file="/includes/baseInclude.jsp" %>
<input id="IsEmpValue"	type="hidden" name="" value="${location.isEmphasis }" />
<table width="200" class="tablelist">
  <tr>
    <td class="title"><label>所属网格</label></td>
    <td colspan="3" class="content" id="organizationOrgName">${location.organization.orgName}</td>
    <td class="imagesTX" rowspan="6">
    <s:if test='null!=location.imgUrl && !"".equals(location.imgUrl)'>
		<img id="img" name="location.imgUrl" src="${path }${location.imgUrl}" width="148px"/>
	</s:if>
	<s:else>
		<img id="img" name="location.imgUrl" src="${path }/resource/images/locationHead.png" width="148px"/>
	</s:else></td>
  </tr>
  <tr>
    <td class="title"><label>名称</label></td>
    <td colspan="3" class="content"><span>${location.equipName}</span></td>
  </tr>
  <tr>
    <td class="title"><label>地址</label></td>
    <td colspan="3" class="content"><span>${location.equipAddress}</span></td>
  </tr>
  <tr>
    <td class="title"><label>类型</label></td>
    <td class="content"><span><span><pop:PropertyDictViewTag name="@com.tianque.domain.property.PropertyTypes@SCENICEQUIP_TYPES" defaultValue="${location.equipType.id}"/></span></span></td>
     <td class="title"><label>联系电话</label></td>
    <td class="content"><span>${location.mobile}</span></td>
  </tr>
  <tr>
   	<td class="title"><label>负责人</label></td>
    <td class="content"><span>${location.manager}</span></td>
    <td class="title"><label>负责人电话</label></td>
    <td class="content"><span>${location.managerMobile}</span></td>
  </tr>
  
  <s:if test='1==location.isEmphasis'>
  <tr>
    <td class="title"><label>取消关注时间</label></td>
    <td class="content"><span><s:date name="location.logOutTime" format="yyyy-MM-dd" /></span></td>
    <td class="title"><label>取消关注原因</label></td>
    <td class="content"><span>${location.logOutReason}</span></td>
  </tr>
  </s:if>
  <tr>
  	<td class="title"><label>周边景点</label></td>
	 <td colspan="3" class="content"><span id=""><pre>${location.aroundScenic}</pre></span></td>
  </tr>
  <tr>		
   	 <td class="title"><label>备注</label></td>
   	 <td colspan="4" class="content">${location.remark}</td>	 
  </tr> 
</table>

<script>
$(document).ready(function(){
	isEmpFormatter();
	//fateson add
	var img=$("#img");
	var src=img.attr("src");
	if(src){
		img.attr("src",src+"?r="+Math.random());
	} 
	
});

function isEmpFormatter(){
	var str = "";
	if($("#IsEmpValue").val()=="true"||$("#IsEmpValue").val()==true)
		str += "是";
	if($("#IsEmpValue").val() =="false"||$("#IsEmpValue").val()==false)
		str += "否";
	$("#tagIsEmp").html(str);
}
</script>
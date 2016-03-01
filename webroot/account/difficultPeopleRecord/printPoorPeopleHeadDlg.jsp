<%@page import="com.tianque.plugin.account.property.PropertyTypes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.tianque.plugin.account.domain.LedgerFeedBack,com.tianque.plugin.account.domain.ThreeRecordsIssueLogNew"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

  <table width="97%" border="0" cellpadding="0" cellspacing="0">
       		<tr>
	          	<td width="96%" class="tdhl" colspan="6" align="left">编号： ${ledgerPoorPeople.serialNumber}${ledgerSteadyWork.serialNumber}</td>
       		</tr>
        	<tr>
	          	<td id = "titleShowValue" width="100%" colspan="6" style="text-align: center;font-Size:20px;font-family:'黑体';height:20px;width:15%;	font-weight:700;">
	          	 
	          	</td>
        	</tr>
        	<tr>
        		<td width="100%" colspan="6" id="_createType" style="text-align:left;"><b>建卡类型：</b>
        	</tr>
        	<tr>
        	    <td width="60%" colspan="3" style="white-space: nowrap;text-align:left;display: list-item;list-style: none;">
        		 新建<input type="checkbox" name="createType" value="新建"  disabled/>
        		</td>
        		<td width="40%" colspan="3"  style="white-space: nowrap;text-align:left;display: list-item;list-style: none;">
        		上年接转 <input type="checkbox" name="createType" value="上年接转"  disabled/>
        		</td>
        	</tr>
        	<tr>
        	    <td width="60%" colspan="3" style="white-space: nowrap;text-align:left;display: list-item;list-style: none;">
        		 其他台账转入<input type="checkbox" name="createType" value="其他台账转入"  disabled/> 
        		</td>
        		<td width="40%" colspan="3" style="white-space: nowrap;text-align:left;display: list-item;list-style: none;">
        		上级主管部门和县级领导班子有关领导交办(县级部门选填) <input type="checkbox" name="createType" value="上级主管部门和县级领导班子有关领导交办(县级部门选填)"  disabled/>
        		</td>
        	</tr>
        	<tr>
        	    <td width="60%" colspan="3" style="white-space: nowrap;text-align:left;display: list-item;list-style: none;">
        		  县委县政府及县级领导班子有关领导交办(乡镇选填)<input type="checkbox" name="createType" value="县委县政府及县级领导班子有关领导交办(乡镇选填)"  disabled/>  
        		</td>
        		<td width="40%" colspan="3" style="white-space: nowrap;text-align:left;display: list-item;list-style: none;">
        		县人大议案、建议、意见交办<input type="checkbox" name="createType" value="县人大议案、建议、意见交办"  disabled/>
        		</td>
        	</tr>
        	<tr>
        	    <td width="60%" colspan="3" style="white-space: nowrap;text-align:left;display: list-item;list-style: none;">
        		  县政协提案、建议、意见交办<input type="checkbox" name="createType" value="县政协提案、建议、意见交办"  disabled/>
        		</td>
        		<td width="40%" colspan="3"></td>
        	</tr>
        	
        	<tr><td width="100%" colspan="6" align="center"> <br></td></tr>
        	<tr>
        		<td width="8%" class="tdhr"><b>登记单位：</b></td>
	          	<td width="18%">${ledgerPoorPeople.bookingUnit }${ledgerSteadyWork.bookingUnit }</td>
	          	<td width="12%" class="tdhr"><b>登记人：</b></td>
	          	<td width="20%">${ledgerPoorPeople.registrant }${ledgerSteadyWork.registrant }</td>
	          	<td width="10%" class="tdhr"><b>登记时间：</b></td>
	          	<td width="21%"><s:date name="ledgerPoorPeople.registrationTime" format="yyyy-MM-dd HH:mm:ss" /><s:date name="ledgerSteadyWork.registrationTime" format="yyyy-MM-dd HH:mm:ss" /></td>
        	</tr>
        	<tr>
	          	<td width="100%" colspan="11" align="center"><hr/></td>
        	</tr>
 </table>
<% 
     String createTable = PropertyTypes.LEDGER_PEOPLEASPIRATION_CREATE_TABLE_TYPE;
%>
 
 <script>
 
 var createTableConstant = "<%=createTable %>";
 
 $(document).ready(function(){
	//appendInputCheckbox(createTableConstant, "createType", "createTableType",2,"disabled");
 });
 
 function initTitleShowValue(title){
   $("#titleShowValue").append(title+"</br></br>");
 }
 function initInputCheckbox(domainName, inputName){
		$.ajax({
			async: false ,
			url:"${path}/sysadmin/propertyManage/findPropertyDictByDomainName.action",
		   	data:{
				"propertyDomain.domainName": domainName,
	        },
			success:function(responseData){
				if(undefined == responseData || null == responseData || responseData.length <= 0){
					return;
				}
				 $("input[name='"+inputName+"']").each(function(){
					 for(var i = 0; i < responseData.length; i++){
						 if($(this).val() == responseData[i].displayName) 
					          $(this).attr('value',responseData[i].id);
					 }
				  }); 
			}
		});
	}
 function appendInputCheckbox(domainName, inputName, moudleId,column,readOnly){
	 $.ajax({
			async: false ,
			url:"${path}/sysadmin/propertyManage/findPropertyDictByDomainName.action",
		   	data:{
				"propertyDomain.domainName": domainName,
	        },
			success:function(responseData){
				if(undefined == responseData || null == responseData || responseData.length <= 0){
					return;
				}
				var moudleHtml = "";
				var width = "";
				if(column > 0){
					width = "width:" + ((100 / column) + "%;")
				}
				var count = 0;
				var rowMoudleHtml = "";
				for(var i = 0; i < responseData.length; i++){
					 ++count;
					// rowMoudleHtml +="<li style='"+width+"white-space: nowrap;text-align:left;display: list-item;list-style: none;'> "+responseData[i].displayName+
					// "<input type='checkbox' name='"+inputName+"' value='"+responseData[i].id+"' "+readOnly+"/> </li>";
					rowMoudleHtml += responseData[i].displayName+"<input type='checkbox' name='"+inputName+"' value='"+responseData[i].id+"' "+readOnly+"/>";
					if(count == column || count == responseData.length){
						moudleHtml += "<li style='width:100%;white-space: nowrap;text-align:left;display: list-item;list-style: none;'>"+rowMoudleHtml+"</li>";
						rowMoudleHtml = "";
						count = 0;
					}
				}
				$(moudleId).append(moudleHtml);
			}
		});
 }
</script>

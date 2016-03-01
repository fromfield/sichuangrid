<%@	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<%request.setAttribute("searchType",request.getParameter("searchType"));%>
<%@ include file="/baseinfo/mentalPatient/colModel.jsp"%>
<div class="content">
<!--
	<div class="ui-corner-all" id="nav">
		<pop:JugePermissionTag ename="addMentalPatient">
			<a id="add" href="javascript:;"><span>新增</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="updateMentalPatient">
			<a id="update" href="javascript:void(0)"><span>修改</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="viewMentalPatient">
			<a id="view" href="javascript:void(0)"><span>查看</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="deleteMentalPatient">
			<a id="delete" href="javascript:void(0)"><span>删除</span></a>
		</pop:JugePermissionTag>
		<pop:JugePermissionTag ename="searchMentalPatient">
			<a id="search"  href="javascript:void(0)"><span>查询</span></a>
		</pop:JugePermissionTag>
		<a id="reload"  href="javascript:void(0)"><span>刷新</span></a>
   		<pop:JugePermissionTag ename="importMentalPatient">
			<a id="import" href="javascript:void(0)"><span>导入</span></a>
   		</pop:JugePermissionTag>
   		<pop:JugePermissionTag ename="downMentalPatient">
			<a id="export" href="javascript:void(0)"><span>导出</span></a>
   		</pop:JugePermissionTag>
   		<pop:JugePermissionTag ename="abolishMentalPatient">
   			<a id="isEmphasis" href="javascript:void(0)"><span>取消关注</span></a>
   		</pop:JugePermissionTag>
   		<pop:JugePermissionTag ename="anewMentalPatient">
   			<a id="emphasis" href="javascript:void(0)"><span>重新关注</span></a>
		</pop:JugePermissionTag>
			<div style="float: right;white-space:nowrap;">
				<select id="isLock" name="user.lock">
						<option value="-1">全部</option>
	 					<option value="0" selected="selected">现在关注</option>
	 					<option value="1">曾经关注</option>
				</select>
			</div>
	</div>
 -->
</div>
<div style="display: none;"><pop:JugePermissionTag
	ename="mentalPatientManagement">
	<span id="title"><s:property value="#request.name"/></span>
</pop:JugePermissionTag>
</div>
<jsp:include page="/baseinfo/commonPopulation/commonStatisticPopulationList.jsp">
	<jsp:param value="MentalPatient" name="moduleName"/>
	<jsp:param value="重点严重精神障碍患者" name="moduleCName"/>
	<jsp:param value="服务人员" name="supervisorPerson"/>
	<jsp:param value="${searchType}" name="searchType"/>
</jsp:include>
<div style="display:none;">
	<input type="hidden" id="_populationType_" name="population.populationType" value='<s:property value="@com.tianque.core.util.BaseInfoTables@MENTALPATIENT_KEY"/>'/>
		<input type="hidden" id="_supervisorName_" 									  
	value='<s:property value="@com.tianque.service.util.ServiceTeamMemberOrRecord@getMemberAlias(@com.tianque.core.util.BaseInfoTables@MENTALPATIENT_KEY)" escape="false"/>'/>
	<input type="hidden" id="_superviceRecordName_" 
	value='<s:property value="@com.tianque.service.util.ServiceTeamMemberOrRecord@getRecordAlias(@com.tianque.core.util.BaseInfoTables@MENTALPATIENT_KEY)" escape="false"/>'/>
</div>
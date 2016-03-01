<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/PopGrid-taglib" prefix="pop"%>
<%@ include file="/includes/baseInclude.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div id="druggy" class="container container_24">
    <input id="populationId" type="hidden" name="population.populationId" value="${population.encryptId}" />
	<input id="populationType" type="hidden" name="population.populationType" value="${populationType}" />
		<div id=tabs>
			<ul>
				<li id="populationBaseInfo"><a href="${path}/baseinfo/druggyManage/viewCommonPopulation.action?population.id=${population.encryptId}">基本信息</a> </li>
				<li><a href="${path}/baseinfo/druggyManage/viewDruggy.action?population.id=${population.encryptId}">业务信息</a> </li>
				<pop:JugePermissionTag ename="serviceTeamMemberManagement">
			<li><a href="/plugin/serviceTeam/router/routerManage/maintainServiceMemberForPopulation.action?module=<s:property value='@com.tianque.service.util.PopulationType@DRUGGY'/>&mode=view&id=${population.encryptId}">服务人员</a></li>
			</pop:JugePermissionTag>
				<pop:JugePermissionTag ename="serviceRecordManagement">
				<li><a href="/plugin/serviceTeam/router/routerManage/maintainServiceRecordForPopulation.action?mode=page&fromSource=population&id=${population.id}&populationType=${populationType}">服务记录</a></li>
				</pop:JugePermissionTag>
				<pop:JugePermissionTag ename="serviceSupervisionMeasuresDruggy">
					<li><a href="${path }/plugin/serviceTeam/router/routerManage/maintainServiceRecordForPopulation.action?dailogName=druggyDialog&populationType=${populationType}&id=${population.encryptId}&showRecordType=serviceSupervisionMeasuresView&module=Druggy">服务监管措施</a></li>
				</pop:JugePermissionTag>
				<li><a id="personnelTrackInfos">轨迹信息</a></li>
			<pop:JugePermissionTag ename="interviewDruggyRecordManagement">
			<li><a href="/plugin/serviceTeam/router/routerManage/viewInterviewRecordForPopulation.action?mode=page&fromSource=population&id=${population.id}&populationType=${populationType}">走访记录</a></li>
			</pop:JugePermissionTag>	
			</ul>
   		</div>
  </div>
	<script>
	$("#personnelTrackInfos").attr("href","${path }/baseinfo/tracks/personnelTrackInfos.jsp?idCardNo=${population.idCardNo}&width=750&height=370&populationType=${populationType}&populationName="+encodeURI(encodeURI("${population.name}")));
	$(function() {
// 		<pop:GlobalSettingTag key="@com.tianque.core.globalSetting.util.GlobalSetting@POPULATION_BUSINESS_DATA" value="true">
// 		$.ajax({
// 			url:'${path}/baseinfo/populationTypeManage/getPopulationTypeByPopulationIdAndType.action?orgInternalCode=${population.orgInternalCode}&populationId=${population.encryptId}&populationType=<s:property value="@com.tianque.service.util.PopulationType@DRUGGY"/>',
// 			async:false,
// 			success:function(data){
// 				if(data!=null&&data.actualType=='<s:property value="@com.tianque.service.util.PopulationType@FLOATING_POPULATION"/>'){
// 					$("#populationBaseInfo").after('<li><a href="${path}/baseinfo/floatingPopulationManage/viewInflowingPopulation.action?population.id='+data.encryptActualId+'">流入信息</a></li>');
// 					<c:if test='${false!=population.isHaveHouse && null!=population.isHaveHouse}'>
// 						$("#populationBaseInfo").after('<li><a href="${path}/baseinfo/houseInfoForPopulation/viewHouseInfoForFloatingPopulation.action?population.id='+data.encryptActualId+'">住房信息</a> </li>');
// 					</c:if>
// 				}
// 				else if(data!=null&&data.actualType=='<s:property value="@com.tianque.service.util.PopulationType@HOUSEHOLD_STAFF"/>'){
// 					$("#populationBaseInfo").after('<li><a href="${path}/baseinfo/householdStaff/viewHouseholdStaff.action?population.id='+data.encryptActualId+'">户籍信息</a></li>');
// 					<c:if test='${false!=population.isHaveHouse && null!=population.isHaveHouse}'>
// 						$("#populationBaseInfo").after('<li><a href="${path}/baseinfo/houseInfoForPopulation/viewHouseInfoForHouseholdStaff.action?population.id='+data.encryptActualId+'">住房信息</a> </li>');
// 					</c:if>
// 				}
// 			}
// 		});
// 		</pop:GlobalSettingTag>
		$( "#tabs").tabs();
	});
	</script>
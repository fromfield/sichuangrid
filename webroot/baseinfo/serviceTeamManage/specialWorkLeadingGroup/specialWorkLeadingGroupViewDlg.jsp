<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/PopGrid-taglib" prefix="pop"%>
<%@ include file="/includes/baseInclude.jsp" %>
<div style="display: none;">
mode:<input id="mode" type="text" name="mode" value="${mode }" /> 
orgId:<input id="autonomyTeamOrgId" type="text"	name="serviceManageTeam.organization.id"		value="<s:property value="@com.tianque.core.util.ThreadVariable@getOrganization().id"/>" />
teamId:<input type="text" name="serviceManageTeam.id" value="${serviceManageTeam.id }" />
</div>
<div id="team" class="container container_24">
	<div id=tabs>
		<ul>
			<li><a href='${path}/baseinfo/serviceTeamManage/viewSeriviceTeam.action?dailogName=specialWorkLeadingGroupViewDlg&serviceManageTeam.id=${serviceManageTeam.id}&teamClazz=<s:property value="@com.tianque.baseInfo.serviceTeamManage.domain.ServiceManageTeam@specialWorkLeadingGroup"/>'>小组信息</a></li>
			<!-- <li><a href='${path}/baseinfo/serviceTeamManage/viewAutonomyTeamMember.action?dailogName=specialWorkLeadingGroupViewDlg&serviceManageTeam.id=${serviceManageTeam.id}&teamClazz=<s:property value="@com.tianque.baseInfo.serviceTeamManage.domain.ServiceManageTeam@specialWorkLeadingGroup"/>'>成员信息</a></li> -->
			<li><a href='${path}/baseinfo/serviceTeamMember/dispatchOperate.action?mode=page&dailogName=autonomyTeamDialog&teamId=${serviceManageTeam.id}&teamClazz=<s:property value="@com.tianque.baseInfo.serviceTeamManage.domain.ServiceManageTeam@specialWorkLeadingGroup"/>'>成员信息</a></li>
			<li><a href="${path}/baseinfo/serviceTeam/serviceObject/dispatchOperate.action?mode=page&dailogName=specialWorkLeadingGroupDialog&serviceObject.serviceTeamId=${serviceManageTeam.id}">服务对象</a></li>
			<li><a href="${path}/baseinfo/searchServiceRecordManage/prepareDispatch.action?mode=page&fromSource=team&searchServiceRecordVo.teamId=${serviceManageTeam.id}">服务记录</a></li>
		</ul>
	</div>
</div>
	<script>
	$(function() {
		$( "#tabs").tabs();
	});
	</script>
<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp"/>
<div class="grid_8">
	<select  name="serviceObjectVo.objectType" id="populationType" class="form-select {isSelect:true,message:{isSelect:'请选择类型'}}" <@s.if test='"view".equals(mode)'>disabled="disabled"</@s.if>>
	</select>
</div>
<div style="display:none">
	<ul id="IMPORTANTPLACE">
		<@pop.JugePermissionTag ename="securityKeyManagement">
			<option value="SECURITYKEY">治安重点</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="dangerousChemicalsUnitManagement">
			<option value="DANGEROUSCHEMICALSUNIT">危险化学品单位</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="schoolManageMent">
			<option value="SCHOOL">学校</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="HospitalManagement">
			<option value="HOSPITAL">医院</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="publicPlaceManagement">
			<option value="PUBLICPLACE">公共场所</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="internetBarManagement">
			<option value="INTERNETBAR">网吧</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="otherLocaleManagement">
			<option value="OTHERLOCALE">其他场所</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="fireSafetyKeyManagement">
			<option value="FIRESAFETYKEY">消防安全重点</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="safetyProductionKeyManagement">
			<option value="SAFETYPRODUCTIONKEY">安全生产重点</option>
		</@pop.JugePermissionTag>
	</ul>

	<ul id="CIVIL">
		<@pop.JugePermissionTag ename="handicappedManagement">
			<option value="handicapped">残疾人</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="aidNeedPopulationManagement">
			<option value="aidNeedPopulation">需救助人员</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="elderlyPeopleManagement">
			<option value="elderlyPeople">老年人</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="optimalObjectManagement">
			<option value="optimalObject">优抚对象</option>
		</@pop.JugePermissionTag>
	</ul>

	<ul id="doubleNew">
		<@pop.JugePermissionTag ename="newSocietyOrganizationsManagement">
			<option value="NEWSOCIETYORGANIZATIONS">社会组织</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="newEconomicOrganizationsManagement">
			<option value="NEWECONOMICORGANIZATIONS">新经济组织</option>
		</@pop.JugePermissionTag>
	</ul>

	<ul id="actualCompany">
		<@pop.JugePermissionTag ename="actualCompanyManagement">
			<option value="actualCompany">实有单位</option>
		</@pop.JugePermissionTag>
	</ul>

	<ul id="IMPORTANTPERSONNEL">
		<@pop.JugePermissionTag ename="mentalPatientManagement">
			<option value="mentalPatient">严重精神障碍患者</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="superiorVisitManagement">
			<option value="superiorVisit">重点上访人员</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="positiveInfoManagement">
			<option value="positiveInfo">刑释人员</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="rectificativePersonManagement">
			<option value="rectificativePerson">社区矫正人员</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="druggyManagement">
			<option value="druggy">吸毒人员</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="aidspopulationsManagement">
			<option value="aidspopulation">艾滋病人员</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="idleYouthManagement">
			<option value="idleYouth">重点青少年</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="dangerousGoodsPractitionerManagement">
			<option value="dangerousGoodsPractitioner">危险品从业人员</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="otherAttentionPersonnelManagement">
			<option value="otherAttentionPersonnel">其他人员</option>
		</@pop.JugePermissionTag>
	</ul>

	<ul id="ENTERPRISE">
		<@pop.JugePermissionTag ename="enterpriseManagement">
			<option value="ENTERPRISEKEY">规上企业</option>
		</@pop.JugePermissionTag>
		<@pop.JugePermissionTag ename="enterpriseDownManagement">
			<option value="ENTERPRISEDOWNKEY">规下企业</option>
		</@pop.JugePermissionTag>
	</ul>

	<ul id="ACTUALHOUSE">
		<@pop.JugePermissionTag ename="rentalHouseManagement">
			<option value="RENTALHOUSE">出租房</option>
		</@pop.JugePermissionTag>
	</ul>

	<ul id="UNEMPLOY">
		<@pop.JugePermissionTag ename="unemployedPeopleManagement">
			<option value="unemployedPeople">失业人员</option>
		</@pop.JugePermissionTag>
	</ul>

	<ul id="BIRTH">
		<@pop.JugePermissionTag ename="nurturesWomen">
			<option value="nurturesWomen">育妇</option>
		</@pop.JugePermissionTag>
	</ul>

</div>

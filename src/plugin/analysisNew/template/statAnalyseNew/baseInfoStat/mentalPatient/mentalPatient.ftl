<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp" />
<@s.include value="/statAnalyseNew/baseInfoStat/common/commonStatisticPrint.jsp">
	<@s.param  name="type">
	<@s.property value="@com.tianque.service.util.PopulationType@MENTAL_PATIENT"/>
	</@s.param>
</@s.include>


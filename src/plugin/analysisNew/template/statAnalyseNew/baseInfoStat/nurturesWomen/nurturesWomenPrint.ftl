<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp" />

<@s.include value="/statAnalyse/baseInfoStat/common/commonStatisticPrintNew.jsp">
	<@s.param  name="type">
	<@s.property value="@com.tianque.service.util.PopulationType@NURTURES_WOMEN"/>
	</@s.param>
</@s.include>

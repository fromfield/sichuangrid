<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp" />
<@s.include value="/common/orgSelectedComponent.jsp"/>  
<div class="zt_tabs_style">
	<div id="chartsTabs">
		<ul>
			<li><a href="${path }/statAnalyseNew/baseInfoStat/youth/statisticsYouthColumn.ftl?type=<@s.property value="@com.tianque.service.util.PopulationType@ALL_YOUTH_POPULATION"/>">区域分布图</a></li>
			<li><a href="${path }/statAnalyseNew/baseInfoStat/youth/statisticsYouthPie.ftl?type=<@s.property value="@com.tianque.service.util.PopulationType@ALL_YOUTH_POPULATION"/>">年龄分布图</a></li>
			<li><a href="${path }/statAnalyseNew/baseInfoStat/youth/statisticsYouthPie1.ftl?type=<@s.property value="@com.tianque.service.util.PopulationType@ALL_YOUTH_POPULATION"/>&domainName=true">类型分布图</a></li>
			<li><a href="${path }/statAnalyseNew/baseInfoStat/youth/statisticsYouthList.ftl?type=<@s.property value="@com.tianque.service.util.PopulationType@ALL_YOUTH_POPULATION"/>">列表信息</a></li>
			<li><a href="${path }/statAnalyseNew/baseInfoStat/common/tendencyChartForPositiveinfo.ftl?tableNameKey=<@s.property value="@com.tianque.service.util.PopulationType@ALL_YOUTH_POPULATION"/>">趋势图</a></li>
		</ul>
	</div>
</div>

<script type="text/javascript">

$(document).ready(function(){
	$("#chartsTabs").tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
	$("#chartsTabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
	 
	// 列表信息 和 柱图 饼图   外层容器计算高度
	$.sigmaReportLayout();
	
	$.loadingComp("close");
});


function enableOrDisableColumn(i){
	if(isGrid()){
		$("#chartsTabs").tabs("select", i);
		$("#chartsTabs").tabs("disable", 0);
		$("#chartsTabs").tabs("disable", 3);
	}else{
		$("#chartsTabs").tabs("enable", 0);
		$("#chartsTabs").tabs("enable", 3);
	}
}
</script>


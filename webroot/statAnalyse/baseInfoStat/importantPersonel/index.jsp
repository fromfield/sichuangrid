<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/common/orgSelectedComponent.jsp"/>    
<div class="zt_tabs_style">
	<div id="chartsTabs">
		<ul>
			<li><a href="${path }/statAnalyse/baseInfoStat/importantPersonel/statisticsImportantPersonlColumn.jsp">区域分布图</a></li>
			<li><a href="${path }/statAnalyse/baseInfoStat/importantPersonel/statisticsImportantPersonlPie.jsp?tableNameKey=
				<s:property value="@com.tianque.core.util.BaseInfoTables@IMPORTANTPERSONNEL_KEY"/>">类型分布图</a></li>
			<li><a href="${path }/statAnalyse/baseInfoStat/importantPersonel/statisticsImportantPersonelList.jsp" >列表信息</a></li>
			<li><a href="${path }/statAnalyse/baseInfoStat/allTendencyChart.jsp?tableNameKey=
				<s:property value="@com.tianque.core.util.BaseInfoTables@IMPORTANTPERSONNEL_KEY"/>">趋势图</a></li>
		</ul>
	</div>
						<input id="isNowYear"  type="hidden"/>
		<input id="isNowMonth"  type="hidden"/>
	<div id="infoList"></div>
</div>

<script type="text/javascript">

var url = '';
var title = '';
var width = 900;
var height = 600;

$(document).ready(function() {
	
	$("#chartsTabs").tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
	$("#chartsTabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
	
	
	//列表信息 和 柱图 饼图   外层容器计算高度
	$.sigmaReportLayout();
	
	$.loadingComp("close");
});


function setOptionsWhenShowInfo(name, orgId){
	if(name.indexOf("刑释人员") != -1){
		title='刑释人员';
		url = '${path}/baseinfo/positiveInfo/positiveInfoListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("社区矫正人员") != -1){
		title='社区矫正人员';
		url = '${path}/baseinfo/rectify/rectifiyListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("重点青少年") != -1){
		title='重点青少年';
		url = '${path}/baseinfo/idleYouth/idleYouthListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("严重精神障碍患者") != -1){
		title='严重精神障碍患者';
		url = '${path}/baseinfo/mentalPatient/mentalPatientlistForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("吸毒人员") != -1){
		title='吸毒人员';
		url = '${path}/baseinfo/druggyManage/druggyListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("重点上访人员") != -1){
		title='重点上访人员';
		url = '${path}/baseinfo/superiorVisit/superiorVisitListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("需救助人员") != -1){
		title='需救助人员';
		url = '${path}/baseinfo/poorPeopleManage/poorPeopleListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("危险品从业人员") != -1){
		title='危险品从业人员';
		url = '${path}/baseinfo/dangerousGoodsPractitioner/dangerousGoodsPractitionerListForStatistisc.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("其他人员") != -1){
		title='其他人员';
		url = '${path}/baseinfo/otherAttentionPersonnel/otherAttentionPersonnelListForStatistics.jsp?orgIdForStat='+orgId;
	}else{
		title='境外人员';
		url='${path}/baseinfo/overseaPersonnel/overseaPersonnelListForStatistics.jsp?orgIdForStat='+orgId;
	}
}


function showInfo(url, title, width, height,year,month){
	if(year==$("#isNowYear").val() && month==$("#isNowMonth").val()){
		$("#infoList").createDialog({
			width: width,
			height: height,
			title: title+'信息',
			modal:true,
			url: url,
			buttons: {
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   			}
				}
			});
	}
}

function shwoInfoInDialog(name, orgId){
	setOptionsWhenShowInfo(name, orgId);
	showInfo(url, title, width, height,$("#year").val(),$("#month").val());
}


function enableOrDisableColumn(i){
	if(isGrid()){
		$("#chartsTabs").tabs("select", i);
		$("#chartsTabs").tabs("disable", 0);
		$("#chartsTabs").tabs("disable", 2);
	}else{
		$("#chartsTabs").tabs("enable", 0);
		$("#chartsTabs").tabs("enable", 2);
	}
}
</script>
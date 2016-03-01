<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />
<div id="infoList"></div>
<div id="importantPersonlPie" class="SigmaReport" style="height:400px;width:100%;"></div>
<script type="text/javascript">
$(document).ready(function() {
	onOrgChanged();
});

function onOrgChanged(){
	var orgId="<s:property value='#parameters.orgId'/>";
	var typeName="<s:property value='#parameters.typeName'/>";
	var modeType="<s:property value='#parameters.modeType'/>";
	var orglevel = $('#currOrgId').attr('orglevelinternalid');
	var cityLevel = '<s:property value="@com.tianque.domain.property.OrganizationLevel@CITY"/>';
	$("#importantPersonlPie").pieChart({
		url:'${path}/gis/twoDimensionMapStatisticCommonManage/getStatisticTwoDimensionMapPieChartInfo.action?organization.id='+orgId+'&typeName='+typeName+'&modeType='+modeType,
		moduleName:"",
		onClick:function(event){
			if(orglevel<=cityLevel){
				setOptionsWhenShowInfo(event.point.name);
			}
		}	
	});
}
function setOptionsWhenShowInfo(name){
	var orgId="<s:property value='#parameters.orgId'/>";
	var title,url;
	if(name.indexOf("流动人口") != -1){
		title='流动人口';
		url = '${path}/baseinfo/floatingPopulation/floatingPopulationStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("户籍人口") != -1){
		title='户籍人口';
		url = '${path}/baseinfo/householdPopulation/householdStaffStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("未落户人口") != -1){
		title='未落户人口';
		url = '${path}/baseinfo/unsettledPopulation/unsettledPopulationStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("境外人员") != -1){
		title='境外人员';
		url = '${path}/baseinfo/overseaPersonnel/overseaPersonnelListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("刑释人员") != -1){
		title='刑释人员';
		url = '${path}/baseinfo/positiveInfo/positiveInfoListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast';
	}else if(name.indexOf("社区矫正人员") != -1){
		title='社区矫正人员';
		url = '${path}/baseinfo/rectify/rectifyListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast';
	}else if(name.indexOf("重点青少年") != -1){
		title='重点青少年';
		url = '${path}/baseinfo/idleYouth/idleYouthListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast';
	}else if(name.indexOf("严重精神障碍患者") != -1){
		title='严重精神障碍患者';
		url = '${path}/baseinfo/mentalPatient/mentalPatientlistForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast';
	}else if(name.indexOf("吸毒人员") != -1){
		title='吸毒人员';
		url = '${path}/baseinfo/druggyManage/druggyManageListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast';
	}else if(name.indexOf("重点上访人员") != -1){
		title='重点上访人员';
		url = '${path}/baseinfo/superiorVisit/superiorVisitListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast';
	}else if(name.indexOf("危险品从业人员") != -1){
		title='危险品从业人员';
		url = '${path}/baseinfo/dangerousGoodsPractitioner/dangerousGoodsPractitionerListForStatistisc.jsp?orgIdForStat='+orgId+'&searchType=fast';
	}else if(name.indexOf("涉嫌参与邪教人员") != -1){
		title='涉嫌参与邪教人员';
		url = '${path}/baseinfo/suspicionHeresyPerson/searchSuspicionHeresyPersonStatistics.ftl?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("涉法涉诉人员") != -1){
		title='涉法涉诉人员';
		url = '${path}/baseinfo/legalLitigation/searchLegalLitigationStatistics.ftl?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("正在服刑人员") != -1){
		title='正在服刑人员';
		url = '${path}/baseinfo/inmates/inmatesStatisticsList.ftl?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("其他人员") != -1){
		title='其他人员';
		url = '${path}/baseinfo/otherAttentionPersonnel/otherAttentionPersonnelListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("境外人员") != -1){
		title='境外人员';
		url='${path}/baseinfo/overseaPersonnel/overseaPersonnelListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("优抚对象") != -1){
		title='优抚对象';
		url='${path}/baseinfo/civilAdministration/optimalObject/optimalObjectStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}
	else if(name.indexOf("老年人") != -1){
		title='老年人';
		url='${path}/baseinfo/elderlyPeople/elderlyPeopleStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}
	else if(name.indexOf("需救助人员") != -1){
		title='需救助人员';
		url='${path}/baseinfo/civilAdministration/aidNeedPopulation/aidNeedPopulationListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}
	else if(name.indexOf("残疾人") != -1){
		title='残疾人';
		url='${path}/baseinfo/handicapped/handicappedListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}
	else if(name.indexOf("失业人员") != -1){
		title='失业人员';
		url='${path}/baseinfo/civilAdministration/unemployedPeople/unemployedPeopleListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("低保人员") != -1){
		title='低保人员';
		url='${path}/baseinfo/civilAdministration/minimumLivingPerson/searchMinimumLivingPersonStatistics.ftl?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("退役人员") != -1){
		title='退役人员';
		url='${path}/baseinfo/civilAdministration/retireSoldier/searchRetireSoldierStatistics.ftl?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("军转干人员") != -1){
		title='军转干人员';
		url='${path}/baseinfo/civilAdministration/demobilizedDry/searchDemobilizedDryStatistics.ftl?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("育龄妇女") != -1){
		title='育龄妇女';
		url='${path}/baseinfo/nurturesWomen/nurturesWomenStatistics.jsp?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("社保人员") != -1){
		title='社保人员';
		url='${path}/baseinfo/otherAttentionObject/socialSecurityPersonnel/socialSecurityPersonnelStatisticsList.ftl?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("流浪乞讨人员") != -1){
		title='流浪乞讨人员';
		url='${path}/baseinfo/homelessBeggars/homelessBeggarsStatisticsList.ftl?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("党员") != -1){
		title='党员';
		url='${path}/baseinfo/partyMember/partyMemberStatisticsList.ftl?orgIdForStat='+orgId+'&searchType=fast'+'&year='+$("#queryYear").val()+'&month='+$("#queryMonth").val();
	}else if(name.indexOf("非出租房") != -1){
		title='非出租房';
		url = '${path}/baseinfo/houseInfo/actualHouse/actualHouseListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fastFromMap&detailedType=0';
	}else if(name.indexOf("出租房") != -1){
		title='出租房';
		url = '${path}/baseinfo/houseInfo/actualHouse/actualHouseListForStatistics.jsp?orgIdForStat='+orgId+'&searchType=fastFromMap&detailedType=1';
	}else if(name.indexOf("下辖待办") != -1){
		return;
		//title='下辖待办';
		//url = '${path}/issue/issueManage/jurisdictionsIssueList.jsp?orgIdForStat='+orgId+'&searchType=fastFromMap&detailedType=1';
	}else if(name.indexOf("待办") != -1){
		return;
		//title='待办';
		//url = '${path}/issue/issueManage/issueList.jsp?orgIdForStat='+orgId+'&searchType=fastFromMap&detailedType=1';
	}else if(name.indexOf("下辖已办结") != -1){
		return;
		//title='下辖已办结';
		//url = '${path}/issue/issueManage/jurisdictionsDoneIssueList.jsp?orgIdForStat='+orgId+'&searchType=fastFromMap&detailedType=1';
	}else if(name=="已办"){
		return;
		//title="已办";
		//url = '${path}/issue/issueManage/issueDoneList.jsp?orgIdForStat='+orgId+'&searchType=fastFromMap&detailedType=1';
	}else if(name=="已办结"){
		return;
		//title="已办结";
		//url = '${path}/issue/issueManage/myCompletedList.jsp?orgIdForStat='+orgId+'&searchType=fastFromMap&detailedType=1';	
	}else if(name.indexOf("艾滋病人员") != -1){
		title="艾滋病人员";
		url = '${path}/baseinfo/aidspopulationsManage/dispatchOperate.action?mode=statistic&searchType=fast&orgIdForStat='+orgId;	
	}else if(name.indexOf("社会组织") != -1){
		title="社会组织";
		url='${path}/baseinfo/twoNewOrganization/newSocietyOrganizations/newSocietyOrganizationsListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("新经济组织") != -1){
		title="新经济组织";
		url='${path}/baseinfo/twoNewOrganization/newEconomicOrganizations/newEconomicOrganizationsListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("旅游景点") != -1){
		title = "旅游景点";
		url = '${path}/baseinfo/scenicManage/scenicSpot/scenicSpotListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("配套设施") != -1){
		title = "配套设施";
		url = '${path}/baseinfo/scenicManage/scenicEquipment/scenicEquipmentListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("景区交通") != -1){
		title = "景区交通";
		url = '${path}/baseinfo/scenicManage/scenicTraffic/scenicTrafficListForStatistics.jsp?orgIdForStat='+orgId;
	}else if(name.indexOf("规上企业") != -1){
		title="规上企业";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=Enterprise&orgIdForStat='+orgId;
	}else if(name.indexOf("规下企业") != -1){
		title="规下企业";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=EnterpriseDown&orgIdForStat='+orgId;
	}else if(name.indexOf("公共活动场所") != -1){
		title="公共活动场所";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=PublicPlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("交通场所") != -1){
		title="交通场所";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=TrafficPlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("娱乐场所") != -1){
		title="娱乐场所";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=EntertainmentPlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("商贸场所") != -1){
		title="商贸场所";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=TradePlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("网吧") != -1){
		title="网吧";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=InternetServicesPlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("住宿服务场所") != -1){
		title="住宿服务场所";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=AccommodationServicesPlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("餐饮服务场所") != -1){
		title="餐饮服务场所";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=FoodServicesPlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("旅游场所") != -1){
		title="旅游场所";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=TravelingPlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("施工场所") != -1){
		title="施工场所";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=ConstructionPlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("其他场所") != -1){
		title="其他场所";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=OtherPlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("其他场所") != -1){
		title="其他场所";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=OtherPlace&modulType=place&orgIdForStat='+orgId;
	}else if(name.indexOf("党政机关") != -1){
		title="党政机关";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=PartyGovernmentOrganCompany&modulType=company&orgIdForStat='+orgId;
	}else if(name.indexOf("学校") != -1){
		title="学校";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=EducationCompany&modulType=company&orgIdForStat='+orgId;
	}else if(name.indexOf("医院") != -1){
		title="医院";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=MedicalHygieneCompany&modulType=company&orgIdForStat='+orgId;
	}else if(name.indexOf("危险化学品单位") != -1){
		title="危险化学品单位";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=DangerousStoreCompany&modulType=company&orgIdForStat='+orgId;
	}else if(name.indexOf("其他单位") != -1){
		title="其他单位";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=OtherCompany&modulType=company&orgIdForStat='+orgId;
	}else if(name.indexOf("安全生产重点") != -1){
		title="安全生产重点";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=SafetyProductionKey&orgIdForStat='+orgId;
	}else if(name.indexOf("消防安全重点") != -1){
		title="消防安全重点";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=FireSafetyKey&orgIdForStat='+orgId;
	}else if(name.indexOf("治安重点") != -1){
		title="治安重点";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=SecurityKey&orgIdForStat='+orgId;
	}else if(name.indexOf("污染源") != -1){
		title="污染源";
		url='${path}/baseinfo/companyPlace/companyPlaceListForStat.jsp?modul=PollutionSource&orgIdForStat='+orgId;
	}
	
	showInfo(url, title);
}


function showInfo(url, title,width,height){
		$("#infoList").createDialog({
			width: 900,
			height: 600,
			zIndex:1020,
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
</script>
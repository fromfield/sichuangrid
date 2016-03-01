<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />
<div class="gisLeft">
	<div id="gisInfoBox">
		<div class="gis_left_info">
			<div class="updownTree">
				<h1 class="new_person_title person_selected">
					<a href="javascript:;" id="jurisdictionDistribution" class="person current">辖区分布</a>
					<a href="javascript:;" id="list_title" class="person" >详细列表</a>
				</h1>
				<div class="tabChangeAll">
					<div id="jurisdictionDistributionBox" class="tabChange tab_load">
						<a href="javascript:;" id="refreshDistribution" class="refresh current">点击加载数据</a>
						<div>
							<div class="new_personList">
								<ul class="new_personal_list" id="distributionList">
									<pop:JugePermissionTag ename="populationGis">
									<li class="current"  style="width: 32%;">
										<a href="javascript:;" id="keyPerson"  class="keyPersonTwoDimensionMap" >人口信息</a>
										<input id="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@PERSON_STATISTIC'/>" type="hidden" >
									</li>
									</pop:JugePermissionTag>
									<pop:JugePermissionTag ename="orgLocationGis">
									<li style="width: 32%;">
										<a href="javascript:;" id="keyPlaces" class="keyPlaceTwoDimensionMap">单位场所</a>
										<input  id="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PLACE_STATISTIC'/>" type="hidden" >
									</li>
									</pop:JugePermissionTag>
									<pop:JugePermissionTag ename="issueManagementGis">
									<li style="width: 32%;">
										<a href="javascript:;"  class="issueTwoDimensionMap">事件处理</a>
										<input id="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@ISSUE_STATISTIC'/>" type="hidden" >
									</li>
									</pop:JugePermissionTag>
									<pop:JugePermissionTag ename="importantHouseGis">
<!-- 									<li > -->
<!-- 										<a href="javascript:;" class="housePropertyTwoDimensionMap">房屋信息</a> -->
<%-- 										<input id="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOUSEPROPERTY_STATISTIC'/>" type="hidden" > --%>
<!-- 									</li> -->
									</pop:JugePermissionTag>
									
									<li style="width: 45%;">
										<a href="javascript:;"  class="gridTeamTwoDimensionMap">网格员队伍管理</a>
										<input id="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@GRID_TEAM_STATISTIC'/>" type="hidden" >
									</li>
									
									<li style="width: 45%;">
<!-- 										<a href="javascript:;"  class="">红袖套成员管理</a> -->
<%-- 										<input id="<s:property value=''/>" type="hidden" > --%>
									</li>
								</ul>
							</div>
							<div class="new_personal_tableCon">
								<pop:JugePermissionTag ename="peopleManageSystem">
								<table class="new_personal_table" id="AreaDistributedPerson"></table>
								</pop:JugePermissionTag>
								<pop:JugePermissionTag ename="newCompanyPlaceManageSystem">
								<table class="new_personal_table hidden" id="AreaDistributedPlace"></table>
								</pop:JugePermissionTag>
								<pop:JugePermissionTag ename="serviceWork">
								<table class="new_personal_table hidden" id="AreaDistributedIssue"></table>
								</pop:JugePermissionTag>
								<pop:JugePermissionTag ename="houseManageSystem">
<!-- 								<table class="new_personal_table hidden" id="AreaDistributedHourse"></table> -->
								</pop:JugePermissionTag>
								<table class="new_personal_table hidden" id="AreaDistributedGirdTeam"></table>
							</div>
						</div>
					</div>
					<div class="tabChange">
						<div id="tabList"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<input type="hidden"  id="modeType" value="${modeType}"/>
<input type="hidden"  id="person-type" />
<input type="hidden" id="issueType">
<input type="hidden" id="gisHouseType">
<input type="hidden" id="clickType"/>
<input type="hidden" id="detailClick"/>
<script type="text/javascript">
$(function(){
	$("#refreshDistribution").click(function(){
		if($("#jurisdictionDistributionBox:visible")[0]){//当跳入下一层级时如果辖区分布打开则重新加载列表
			$("#modeType").val($(".new_personal_list>li.current").children("input").attr("id"));
			if($(".new_personal_list>li.current").children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@PERSON_STATISTIC'/>"){
				var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@PERSONAL_MODE'/>"; 
			}else if($(".new_personal_list>li.current").children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PLACE_STATISTIC'/>"){
				var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@PLACE_MODE'/>";
			}else if($(".new_personal_list>li.current").children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@ISSUE_STATISTIC'/>"){
				var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@ISSUE_MODE'/>";
			}else if($(".new_personal_list>li.current").children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOUSEPROPERTY_STATISTIC'/>"){
				var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@HOURSE_MODE'/>";
			}else if($(".new_personal_list>li.current").children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@GRID_TEAM_STATISTIC'/>"){
				var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@GIRDTEAM_MODE'/>";
			}
			if(innerKey=="person"){
				$("#personTool").hide();
			}
			loadAreaDistributedList(innerKey);
		}
	});
	setTimeout(function() {
		//loadAreaDistributedList("person")
	}, 1000);
});


	//加载辖区分布列表
	function loadAreaDistributedList(innerKey){
		$.ajax({
			async: true,
			url: "${path }/gis/gisTypeManage/getNeedGisTypeManagesByInnerTypeAndOrgId.action",
			data:{
				"gisTypeManage.innerKey":innerKey,
				"organization.id":$('#currOrgId').val()
			},
			success:function(responseData){
				if(typeof responseData ==="string" ){
					$.messageBox({message:JSON.parse(responseData).message,level:"error"});
					return;
				}
				var className;
				if(innerKey=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@PLACE_MODE'/>"){
					className="keyPlaceDetail";
				}else if(innerKey=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@PERSONAL_MODE'/>"){
					className="keyPersonDetail";
				}else if(innerKey=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@ISSUE_MODE'/>"){
					className="issueDetail";
				}else if(innerKey=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@HOURSE_MODE'/>"){
					className="houseDetail";
				}else if(innerKey=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@GIRDTEAM_MODE'/>"){
					className="girdTeamDetail";
				}
				
				var str="";
				var allNum = 0;
				if(innerKey=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@PLACE_MODE'/>"){
					for(var i=0;i<responseData.length;i++){//重点场所
						//str+=assemblyData(responseData[i].gisTypeManage.key,responseData[i].gisTypeManage.name,responseData[i].sumNum,className);
						str+=assemblyData({
							key:responseData[i].gisTypeManage.key,
							innerKey:responseData[i].gisTypeManage.innerKey,
							name:responseData[i].gisTypeManage.name,
							sumNum:responseData[i].sumNum,
							className:className
						})
						//allNum += responseData[i].sumNum;
					}
					$("#AreaDistributedPlace").html(str);
					
					$("#AreaDistributedPlace tr").each(function(index){
						var placeId=$(this).attr("id");
						
						if(placeId=='companyPlaceBase'||placeId=='twoNewGroup' || placeId=='unitPlaceBase' || placeId=="scenicsManage" ||placeId=="sizedEnterprisePlaceBase" ||placeId=="keyCompanyPlaceBase"){
							
							$(this).find("td").eq(2).removeClass("detailInfo details").find("span").remove();
							$(this).find("td").eq(0).find("span").parent().css("cursor","auto");
							$(this).addClass("even");
							$(this).find("td").eq(2).empty();
							var title = $(this).find(".msgL>span").text();
							$(this).find("td").eq(2).html("<span id='personTool' class='personTool'>"
									+"<a title='柱状图' href='javascript:;' onclick=showColumnChart('"+placeId+"','"+title+"') class='columnChart'></a>"
									+"<a title='饼状图' href='javascript:;' onclick=showPieChart('"+placeId+"','"+title+"') class='pieChart'></a>"
									+"</span>");
						}
					})
				}else if(innerKey=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@PERSONAL_MODE'/>"){
					for(var i=0;i<responseData.length;i++){//重点人员
						//str+=assemblyData(responseData[i].gisTypeManage.tableName,responseData[i].gisTypeManage.name,responseData[i].sumNum,className);
						str+=assemblyData({
							key:responseData[i].gisTypeManage.tableName,
							innerKey:responseData[i].gisTypeManage.innerKey,
							name:responseData[i].gisTypeManage.name,
							sumNum:responseData[i].sumNum,
							className:className
						})
					}
					$("#AreaDistributedPerson").html(str);
					
					$(".new_personal_table tr").each(function(index){
						var personId=$(this).attr("id");
						
						if(personId=="person"||personId=="keyPerson"||personId=="careobject"||personId=="NURTURESWOMEN"
								||personId=='totalHouse'||personId=='totalRentHouse'||personId=='totalBuilding'
								||personId=='actualcompany'||personId=='keyPlace'||personId=='carePerson'||personId=='otherPerson'){
							
							$(this).find("td").eq(2).removeClass("detailInfo details").find("span").remove();
							$(this).find("td").eq(0).find("span").parent().css("cursor","auto");
							$(this).addClass("even");
							$(this).find("td").eq(2).empty();
							var title = $(this).find(".msgL>span").text();
							$(this).find("td").eq(2).html("<span id='personTool' class='personTool'>"
									+"<a title='柱状图' href='javascript:;' onclick=showColumnChart('"+personId+"','"+title+"') class='columnChart'></a>"
									+"<a title='饼状图' href='javascript:;' onclick=showPieChart('"+personId+"','"+title+"') class='pieChart'></a>"
									+"</span>");
						}
					})
				}else if(innerKey=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@ISSUE_MODE'/>"){
					for(var i=0;i<responseData.length;i++){//事件
						//str+=assemblyData(responseData[i].typeName,responseData[i].moduleName,responseData[i].sumNum,className);
						str+=assemblyData({
							key:responseData[i].typeName,
							name:responseData[i].moduleName,
							sumNum:responseData[i].sumNum,
							className:className
						})
						allNum += responseData[i].sumNum;
					}
					$("#AreaDistributedIssue").html(assemblyChartData(allNum,"事件处理") + str);
					if(!isGridDownOrganization()){//网格层级时隐藏下辖信息
						$("#"+"<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@FORTHING'/>").hide();
						$("#"+"<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@ALREADYTHING'/>").hide();
					}
				}else if(innerKey=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@HOURSE_MODE'/>"){
					for(var i=0;i<responseData.length;i++){//房屋信息
						//str+=assemblyData(responseData[i].typeName,responseData[i].moduleName,responseData[i].sumNum,className);
						str+=assemblyData({
							key:responseData[i].typeName,
							name:responseData[i].moduleName,
							sumNum:responseData[i].sumNum,
							className:className
						})
						allNum += responseData[i].sumNum;
					}
					$("#AreaDistributedHourse").html(assemblyChartData(allNum,"房屋信息") + str);
				}else if(innerKey=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@GIRDTEAM_MODE'/>"){
					for(var i=0;i<responseData.length;i++){//网格员队伍管理
						str+=assemblyData({
							key:responseData[i].gisTypeManage.tableName,
							name:responseData[i].gisTypeManage.name,
							sumNum:responseData[i].sumNum+" 人",
							className:className
						})
						if(i == 0){
							str = str.replace("详情", "");
						}
					}
					if($('#currOrgId').attr('orglevelinternalid') > <s:property value="@com.tianque.domain.property.OrganizationLevel@TOWN"/>){
						str = str.replaceall("详情", "");
					}
					$("#AreaDistributedGirdTeam").html("<tr ><td colspan='3' style = 'text-align: center;border-right: none;font-weight:bold;'>网格员队伍管理</td></tr>"+str);
				}
			}
		});
	}

	//拼装数据
	function assemblyData(option){
		if(option==null) return;
		var orglevel = $('#currOrgId').attr('orglevelinternalid');
		var cityLevel = '<s:property value="@com.tianque.domain.property.OrganizationLevel@CITY"/>';
		var str="<tr  id='"+option.key+"'  innerKey='"+option.innerKey+"'>"
		+"<td class='msgL'><span class='text'>"+option.name+"</span></td> "
		+"<td class='dataPoint'><span class='num'>"+option.sumNum+"</span><span id='units'></span></td>"
		+"<td class='detailInfo details' ><span class='"+option.className+"'>";
		if(orglevel<=cityLevel){
			str = str + "<a href='javascript:void(0)'>详情</a>";
		}
		str = str + "</span></td></tr>";
		var $tbody = $("<tbody>").append(str);
		if(option.key=="<s:property value='@com.tianque.gis.util.GisGlobalValue@ACTUALUNIT'/>"){
			$tbody.find("tr").addClass("even");
		}
		return $tbody.html();
	}
/*	
	//拼装数据
	function assemblyData(id,name,sumNum,className){
		var str='';
		if(id=="<s:property value='@com.tianque.gis.util.GisGlobalValue@ACTUALUNIT'/>"){
			str="<tr  id='"+id+"' class='even'>"
			+"<td class='msgL'><span class='text'>"+name+"</span></td> "
			+"<td class='dataPoint'><span class='num'>"+sumNum+"</span><span id='units'></span></td>"
			+"<td class='detailInfo details' ><span class='"+className+"'><a href='javascript:void(0)'>详情</a></span></td></tr>";
		}else{
			str="<tr  id='"+id+"' >"
			+"<td class='msgL'><span class='text'>"+name+"</span></td> "
			+"<td class='dataPoint'><span class='num'>"+sumNum+"</span><span id='units'></span></td>"
			+"<td class='detailInfo details' ><span class='"+className+"'><a href='javascript:void(0)'>详情</a></span></td></tr>";
		}	
		return str;
	}
*/
	//拼装数据--柱状图、饼状图
	function assemblyChartData(sumNum,title){
		var  str='<tr id="person" class="even">'
				+	'<td class="msgL" style="cursor: auto;"> <span class="text" >'+title+'</span></td> '
				+	'<td class="dataPoint"><span class="num" >'+sumNum+'</span><span id="units"></span></td>'
				+	'<td class=""><span id="personTool" class="personTool">'
				+		'<a title="柱状图" href="javascript:;" onclick=showColumnChart(null,"'+title+'") class="columnChart" ></a>'
				+		'<a title="饼状图" href="javascript:;" onclick=showPieChart(null,"'+title+'") class="pieChart"></a>'
				+	'</span></td>'
				+'</tr>';
		return str;
	}

	function showColumnChart(personId,title){
		if(personId=="person"){
			$('#modeType').val("personMapStatisticService");
		}else if(personId=='companyPlaceBase'||personId=='twoNewGroup' || personId=='unitPlaceBase' || personId=="scenicsManage" ||personId=="sizedEnterprisePlaceBase" || personId=="keyCompanyPlaceBase"){
			$('#modeType').val("keyPlaceMapStatisticService");
		}else if(personId!="person" && personId!="keyPlaces" && personId!="twoNewGroup" && personId!=null){
			$('#modeType').val("keyPersonMapStatisticService");
		}
		$("#chartDialog").createDialog({
			width:920,
			height:520,
			zIndex:1019,
			title:title+"柱状图显示",
			url:"${path}/openLayersMap/columnChart/columnChart.jsp?orgId="+$('#currOrgId').val()+"&modeType="+$('#modeType').val()+"&typeName="+personId,
			buttons: {
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	}
	
	function showPieChart(personId,title){
		if(personId=="person"){
			$('#modeType').val("personMapStatisticService");
		}else if(personId=="companyPlaceBase"||personId=="twoNewGroup" || personId=="unitPlaceBase" || personId=="scenicsManage" ||personId=="sizedEnterprisePlaceBase" || personId=="keyCompanyPlaceBase"){
			$('#modeType').val("keyPlaceMapStatisticService");
		}else if(personId!="person" && personId!="keyPlaces" && personId!="twoNewGroup" && personId!=null){
			$('#modeType').val("keyPersonMapStatisticService");
		}
		$("#chartDialog").createDialog({
			width:650,
			height:530,
			zIndex:1019,
			title:title+"饼状图显示",
			url:"${path}/openLayersMap/columnChart/pieChart.jsp?orgId="+$('#currOrgId').val()+"&modeType="+$('#modeType').val()+"&typeName="+personId,
			buttons: {
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	}
	
	$("#jurisdictionDistribution").click(function(){//点击辖区分布
		$("#modeType").val($(".new_personal_list>li.current").children("input").attr("id"));
		if($(".new_personal_list>li.current").children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@PERSON_STATISTIC'/>"){
			var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@PERSONAL_MODE'/>"; 
		}else if($(".new_personal_list>li.current").children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PLACE_STATISTIC'/>"){
			var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@PLACE_MODE'/>";
		}else if($(".new_personal_list>li.current").children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@ISSUE_STATISTIC'/>"){
			var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@ISSUE_MODE'/>";
		}else if($(".new_personal_list>li.current").children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOUSEPROPERTY_STATISTIC'/>"){
			var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@HOURSE_MODE'/>";
		}
		//loadAreaDistributedList(innerKey);
		clearGpsMapAllMarker();
	})
	
	
	$(".new_personal_list>li").each(function(index){
			$(this).click(function(){
				if($(this).children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PLACE_STATISTIC'/>"){
					var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@PLACE_MODE'/>";
				}else if($(this).children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@PERSON_STATISTIC'/>"){
					var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@PERSONAL_MODE'/>";
				}else if($(this).children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@ISSUE_STATISTIC'/>"){
					var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@ISSUE_MODE'/>";
				}else if($(this).children("input").attr("id")=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOUSEPROPERTY_STATISTIC'/>"){
					var innerKey="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@HOURSE_MODE'/>";
				}
				/***点击列表时不去加载只有在点击按钮才加载*/
				//loadAreaDistributedList(innerKey);
 				$("#modeType").val($(this).children("input").attr("id"));
				$(this).addClass("current").siblings().removeClass("current");
				$(".new_personal_tableCon").children("table").hide().eq(index).show().siblings().hide();
				if($('.new_personal_table').find('tr').is(':visible')){
					$('.tab_load .refresh').hide();
				}else{
					$('.tab_load .refresh').show(100);
				}
			})
		});
	
	/* $(".new_personal_table tr").hover(function(){
		$(this).addClass("tableCur").siblings().removeClass("tableCur");
	},function(){
		$(this).removeClass("tableCur");
	}); */

	$(".new_personal_table").delegate("tr", "hover", function(){
		$(this).toggleClass("tableCur");
	});


	$("#AreaDistributedPerson").delegate("span.keyPersonDetail","click",function(){//重点人员辖区分布详情点击
		IS_MAP_MOVE_SEARCH=false;//地图滑动搜索关闭
		$("#map").TqMap("removeAllFeatures");//清除二维图上的面
		$("#map").TqMap("deleteAllPopupText");
		$(".gis_zoom_button").addClass("hidden");//清除图例按钮
		$(".gis_zoom_content").hide();//清除图例
		clearMarkersByMarkerId_objectName("hourse");//清除楼宇
		clearMarkersByMarkerId_objectName("common");
		var keyPersonType=$(this).parent().parent().attr("id");
		personType=keyPersonType;
		$("#detailClick").attr("value",true);
		var keyType="";
		var modeType = "<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PERSON_SEARCH'/>";
		var modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PERSON_DETAILVIEW'/>";
		var mainTableName="keyPerson";
		if(personType=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@keyPersonalType.get("overseaStaff")'/>"
				||personType=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@keyPersonalType.get("unsettledPopulation")'/>"
					||personType=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@keyPersonalType.get("floatingPopulation")'/>"
						||personType=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@keyPersonalType.get("householdStaff")'/>"){
				modeType="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@PERSON_SEARCH'/>";
				modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@PERSON_DETAILVIEW'/>";
				mainTableName="person";
			}
		var url = '${path}/gis/twoDimensionMapSearchCommonManage/findTwoDimensionMapPageInfoByOrgIdAndTypeName.action';
		var functionType="<s:property value='@com.tianque.openLayersMap.util.FunctionType@REFINESEARCH'/>";
		loadTabListInfo("${path}/openLayersMap/detailsCommon/detailsListCommonTwoDimensionMap.jsp?type="+personType+"&mainTableName="+mainTableName+"&childTableName="+personType+"&keyType=null&modeType="+modeType+"&url="+url+"&functionType="+functionType
				+"&modeTypeDetailView="+modeTypeDetailView);
	});
	$("#AreaDistributedPlace").delegate("span.keyPlaceDetail","click",function(){//重点场所辖区分布详情点击
		IS_MAP_MOVE_SEARCH=false;//地图滑动搜索关闭
		$("#map").TqMap("removeAllFeatures");//清除二维图上的面
		$("#map").TqMap("deleteAllPopupText");
		$(".gis_zoom_button").addClass("hidden");//清除图例按钮
		$(".gis_zoom_content").hide();//清除图例
		$("#detailClick").attr("value",true);
		locationType=$(this).parent().parent().attr("id");
		clearMarkersByMarkerId_objectName("common");
		var newCompanyPlaceModuleName=$(this).parent().parent().attr("innerkey");
		var functionType="<s:property value='@com.tianque.openLayersMap.util.FunctionType@REFINESEARCH'/>";
		var url="${path}/gis/twoDimensionMapSearchCommonManage/findTwoDimensionMapPageInfoByOrgIdAndTypeName.action";
		var modeType="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PLACE_SEARCH'/>";
		var modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PLACE_DETAILVIEW'/>";
		loadTabListInfo('${path}/openLayersMap/detailsCommon/detailsListCommonTwoDimensionMap.jsp?mainTableName='+newCompanyPlaceModuleName+'&childTableName=keyPlaces&url='+url+'&modeType='+modeType+"&keyType="+locationType+'&type='+locationType+"&functionType="+functionType+
					"&modeTypeDetailView="+modeTypeDetailView);//乡镇级别的公用页面
	});
	$("#AreaDistributedIssue").delegate("span.issueDetail","click",function(){//事件辖区分布详情点击
		IS_MAP_MOVE_SEARCH=false;//地图滑动搜索关闭
		$("#map").TqMap("removeAllFeatures");//清除二维图上的面
		$("#map").TqMap("deleteAllPopupText");
		$(".gis_zoom_button").addClass("hidden");//清除图例按钮
		$(".gis_zoom_content").hide();//清除图例
		clearMarkersByMarkerId_objectName("hourse");//清除楼宇
		clearMarkersByMarkerId_objectName("common");
		$("#detailClick").attr("value",true);
		issueType=$(this).parent().parent().attr("id");
		var functionType="<s:property value='@com.tianque.openLayersMap.util.FunctionType@REFINESEARCH'/>";
		var modeType="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@ISSUE_SEARCH'/>";
		var modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@ISSUE_DETAILVIEW'/>";
		url = '${path}/gis/twoDimensionMapSearchCommonManage/findTwoDimensionMapPageInfoByOrgIdAndTypeName.action';
		loadTabListInfo('${path}/openLayersMap/detailsCommon/detailsListCommonTwoDimensionMap.jsp?mainTableName=issues&sordField=iu.centerlon&modeType='+modeType+'&url='+url+'&type='+issueType+"&functionType="+functionType+"&childTableName="+issueType
				+"&modeTypeDetailView="+modeTypeDetailView+"&flag=true"+"&isIssueDistributed=true");
	});


	$("#AreaDistributedHourse").delegate("span.houseDetail","click",function(){//房屋信息分布详情点击
		IS_MAP_MOVE_SEARCH=false;//地图滑动搜索关闭
		$("#map").TqMap("removeAllFeatures");//清除二维图上的面
		$("#map").TqMap("deleteAllPopupText");
		$(".gis_zoom_button").addClass("hidden");//清除图例按钮
		$(".gis_zoom_content").hide();//清除图例
		clearMarkersByMarkerId_objectName("hourse");//清除楼宇
		clearMarkersByMarkerId_objectName("common");
		$("#detailClick").attr("value",true);
		var houseType=$(this).parent().parent().attr("id");
		var modeType="";
		var mainTableName="";
		var childTableName="";
		var functionType="<s:property value='@com.tianque.openLayersMap.util.FunctionType@REFINESEARCH'/>";
		var url = '${path}/gis/twoDimensionMapSearchCommonManage/findTwoDimensionMapPageInfoByOrgIdAndTypeName.action';
		if(houseType=="HOUSEINFO"){
			childTableName="houseInfo";
		}else if(houseType=="RENTALHOUSE"){
			childTableName="rentalHouse";
		}
		modeType="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOUSEPROPERTY_SEARCH'/>";
		mainTableName="houseInfo";
		var modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOUSEPROPERTY_DETAILVIEW'/>";
		loadTabListInfo('${path}/openLayersMap/detailsCommon/detailsListCommonTwoDimensionMap.jsp?mainTableName='+mainTableName+'&modeType='+modeType+'&url='+url+'&type='+houseType+"&functionType="+functionType
					+"&modeTypeDetailView="+modeTypeDetailView+"&keyType="+houseType+"&childTableName="+childTableName);
	});

	//辖区分布人员检索
	$("#AreaDistributedPerson").delegate("td.msgL","click",function(){
		var text=$(this).parent().find(".text").text();
		var type=$(this).parent().attr("id");
		var innerKey = $(this).parent().attr("innerKey");
		if(type=="person"||type=="keyPerson"){//场所大类的图例点击事件判断
			return;
		}
		IS_MAP_MOVE_SEARCH=false;//地图滑动搜索关闭
		$("#person-type").val(type);
		$("#clickType").attr("value",type);
		personType=type;
		personOrPlaceName=text;
		allTypeName=personOrPlaceName;
		$("#detailClick").attr("value",true);
		$(this).parent().addClass("popClick").siblings().removeClass("popClick");
		$("#map").TqMap("deletePopup");
		$("#map").TqMap("removeAllFeatures");//清除二维图上的面
		$("#map").TqMap("deleteAllPopupText");
		clearMarkersByMarkerId_objectName("hourse");//清除楼宇
		clearMarkersByMarkerId_objectName("common");
		if(isVillageDownOrganization()){
			//$("#areaInfo").load("/openLayersMap/personnel/keyPersonForJurisdictionDistribution.jsp?flag=true&orgId="+$('#currOrgId').val()+"&type="+type);
			var modeType = "<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PERSON_STATISTIC'/>";
			if(innerKey=="person"){
				modeType = "<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@PERSON_STATISTIC'/>";
			}
			loadStatisticChildMapArea({ orgId:$("#currOrgId").val(), table:type, name:text, modeType:modeType });
		}else{
			var modeType = "<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PERSON_SEARCH'/>";
			var modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PERSON_DETAILVIEW'/>";
			var mainTableName="keyPerson";
			if(innerKey=="person"){
				modeType = "<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@PERSON_SEARCH'/>";
				modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@PERSON_DETAILVIEW'/>";
				mainTableName="person"
			}
			var url = '${path}/gis/twoDimensionMapSearchCommonManage/findTwoDimensionMapPageInfoByOrgIdAndTypeName.action';
			var functionType="<s:property value='@com.tianque.openLayersMap.util.FunctionType@REFINESEARCH'/>";
			loadTabListInfo("${path}/openLayersMap/detailsCommon/detailsListCommonTwoDimensionMap.jsp?type="+personType+"&mainTableName="+mainTableName+"&childTableName="+personType+"&keyType=null&modeType="+modeType+"&url="+url+"&functionType="+functionType
					+"&modeTypeDetailView="+modeTypeDetailView);
		}
	})

	//辖区分布场所检索
	$("#AreaDistributedPlace").delegate("td.msgL","click",function(){
		IS_MAP_MOVE_SEARCH=false;//地图滑动搜索关闭
		var text=$(this).parent().find(".text").text();
		var type=$(this).parent().attr("id");
		if(type=='companyPlaceBase' || type=='unitPlaceBase' || type=='sizedEnterprisePlaceBase' || type=='keyCompanyPlaceBase'  || type=='twoNewGroup' 
			|| type=='scenicsManage'){//场所大类的图例点击事件判断
			return;
		}
		$("#clickType").attr("value",type);
		locationType=type;
		personOrPlaceName=text;
		allTypeName=personOrPlaceName;
		$("#detailClick").attr("value",true);
		$(this).parent().addClass("popClick").siblings().removeClass("popClick");
		$("#map").TqMap("deletePopup");
		$("#map").TqMap("removeAllFeatures");//清除二维图上的面
		$("#map").TqMap("deleteAllPopupText");
		clearMarkersByMarkerId_objectName("common");
		var url="";
		var modeType="";
		if(isVillageDownOrganization()){
			loadStatisticChildMapArea({
				orgId:$("#currOrgId").val(), table:type, name:text,
				modeType:"<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PLACE_STATISTIC'/>"
			});
		}else{
			var functionType="<s:property value='@com.tianque.openLayersMap.util.FunctionType@REFINESEARCH'/>";
			url="${path}/gis/twoDimensionMapSearchCommonManage/findTwoDimensionMapPageInfoByOrgIdAndTypeName.action";
			modeType="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PLACE_SEARCH'/>";
			var modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PLACE_DETAILVIEW'/>";
			loadTabListInfo('${path}/openLayersMap/detailsCommon/detailsListCommonTwoDimensionMap.jsp?mainTableName=keyPlaces&childTableName=keyPlaces&url='+url+'&modeType='+modeType+"&keyType="+locationType+'&type='+locationType+"&functionType="+functionType+"&modeTypeDetailView="+modeTypeDetailView);//乡镇级别的公用页面
		}
	})

	//辖区分布事件搜索
	$("#AreaDistributedIssue").delegate("td.msgL","click",function(){
		var text=$(this).parent().find(".text").text();
		var type=$(this).parent().attr("id");
		issueTypeName = text;
		allTypeName = issueTypeName;
		IS_MAP_MOVE_SEARCH=false;//地图滑动搜索关闭
		$("#issueType").attr("value",type);
		$("#clickType").attr("value",type);
		$("#detailClick").attr("value",true);
		$(this).parent().addClass("popClick").siblings().removeClass("popClick");
		$("#map").TqMap("deletePopup");
		$("#map").TqMap("removeAllFeatures");//清除二维图上的面
		clearMarkersByMarkerId_objectName("hourse");//清除楼宇
		if(isVillageDownOrganization()){
			//loadTabListInfo('/openLayersMap/issue/issueForJurisdictionDistribution.jsp?flag=true&type='+type);
			loadStatisticChildMapArea({
				orgId:$("#currOrgId").val(), table:type, name:text,
				modeType:"<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@ISSUE_STATISTIC'/>"
			});
		}else{
			var functionType="<s:property value='@com.tianque.openLayersMap.util.FunctionType@REFINESEARCH'/>";
			var modeType="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@ISSUE_SEARCH'/>";
			var modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@ISSUE_DETAILVIEW'/>";
			var url = '${path}/gis/twoDimensionMapSearchCommonManage/findTwoDimensionMapPageInfoByOrgIdAndTypeName.action';
			loadTabListInfo('${path}/openLayersMap/detailsCommon/detailsListCommonTwoDimensionMap.jsp?mainTableName=issuesNew&sordField=iu.centerlon&modeType='+modeType+'&url='+url+'&type='+type+"&functionType="+functionType
					+"&modeTypeDetailView="+modeTypeDetailView);
		}
	})


	//辖区分布房屋信息搜索
	$("#AreaDistributedHourse").delegate("td.msgL","click",function(){
		IS_MAP_MOVE_SEARCH=false;//地图滑动搜索关闭
		var text=$(this).parent().find(".text").text();
		var type=$(this).parent().attr("id");
		housePropertyTypeName = text;
		allTypeName=housePropertyTypeName;
		$("#detailClick").attr("value",true);
		$("#clickType").attr("value",type);
		$("#gisHouseType").val(type);
		$(this).parent().addClass("popClick").siblings().removeClass("popClick");
		var functionType="<s:property value='@com.tianque.openLayersMap.util.FunctionType@REFINESEARCH'/>";
		$("#map").TqMap("removeAllFeatures");//清除二维图上的面
		$("#map").TqMap("deleteAllPopupText");
		clearMarkersByMarkerId_objectName("hourse");//清除楼宇
		clearMarkersByMarkerId_objectName("common");
		if(isVillageDownOrganization()){
			var modeType = "<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOUSEPROPERTY_STATISTIC'/>";
			if(type=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@BOUNDBUILDING'/>"
					|| type=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@UNBOUNDBUILDING'/>"){
				//loadTabListInfo('/openLayersMap/houseProperty/boundBuildDatasForJurisdictionDistribution.jsp?flag=true&type='+type);
				modeType = "<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@BUILDDATA_STATISTIC'/>";
			}else if(type=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@BOUNDHOUSE'/>" 
					|| type=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@UNBOUNDHOUSE'/>"){
				//loadTabListInfo('/openLayersMap/houseProperty/housePropertyForJurisdictionDistribution.jsp?flag=true&type='+type);
			}
			loadStatisticChildMapArea({ orgId:$("#currOrgId").val(), table:type, name:text, modeType:modeType });
		}else{
			var url = '${path}/gis/twoDimensionMapSearchCommonManage/findTwoDimensionMapPageInfoByOrgIdAndTypeName.action';
			var modeType=""
			var mainTableName="";
			if(type=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@BOUNDBUILDING'/>"
					|| type=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@UNBOUNDBUILDING'/>"){
				modeType="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@BUILDDATA_SEARCH'/>";
				var modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@BUILDDATA_DETAILVIEW'/>";
				mainTableName="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@BUILD_TABLENAME'/>";
				loadTabListInfo('${path}/openLayersMap/detailsCommon/detailsListCommonTwoDimensionMap.jsp?mainTableName='+mainTableName+'&modeType='+modeType+'&url='+url+'&type='+type+"&functionType="+functionType
						+"&modeTypeDetailView="+modeTypeDetailView);
				
			}else if(type=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@BOUNDHOUSE'/>" 
						|| type=="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@UNBOUNDHOUSE'/>"){
				modeType="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOUSEPROPERTY_SEARCH'/>";
				mainTableName="<s:property value='@com.tianque.openLayersMap.util.GisGlobalValueMap@HOUSEINFO_TABLENAME'/>";
					var modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOUSEPROPERTY_DETAILVIEW'/>";
				loadTabListInfo('${path}/openLayersMap/detailsCommon/detailsListCommonTwoDimensionMap.jsp?mainTableName='+mainTableName+'&modeType='+modeType+'&url='+url+'&type='+type+"&functionType="+functionType
						+"&modeTypeDetailView="+modeTypeDetailView);
			}
		}
	})
	
	
	$("#AreaDistributedGirdTeam").delegate("span.girdTeamDetail","click",function(){//网格员队伍管理详情点击
		IS_MAP_MOVE_SEARCH=false;//地图滑动搜索关闭
		//$("#map").TqMap("removeAllFeatures");//清除二维图上的面
		//$("#map").TqMap("deleteAllPopupText");
		$(".gis_zoom_button").addClass("hidden");//清除图例按钮
		$(".gis_zoom_content").hide();//清除图例
		clearMarkersByMarkerId_objectName("hourse");//清除楼宇
		clearMarkersByMarkerId_objectName("common");
		var issueType=$(this).parent().parent().attr("id");
		$("#detailClick").attr("value",true);
		var functionType="<s:property value='@com.tianque.openLayersMap.util.FunctionType@REFINESEARCH'/>";
 		var modeType="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@GRID_TEAM_SEARCH'/>";
 		var modeTypeDetailView="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@GRID_TEAM_DETAILVIEW'/>";
 		url = '${path}/gis/twoDimensionMapSearchCommonManage/findTwoDimensionMapPageInfoByOrgIdAndTypeName.action';
 		loadTabListInfo('${path}/openLayersMap/detailsCommon/detailsListCommonTwoDimensionMap.jsp?mainTableName=gridTeamMember&modeType='+modeType+'&url='+url+'&type='+issueType+"&functionType="+functionType+"&modeTypeDetailView="+modeTypeDetailView);
	});
	//一级栏目切换
	
	$(".person_selected .person").each(function(index){
		$(this).click(function(){
			$(this).addClass("current").siblings().removeClass("current");
			$(".tabChangeAll .tabChange").hide().eq(index).show().siblings().hide();
			setTimeout(function(){
				if($('.new_personal_table').find('tr').is(':visible')){
					$('.tab_load .refresh').hide();
				}else{
					$('.tab_load .refresh').show(100);
				}
			},100)
		});
	});
	$('.tab_load .refresh').click(function(){
		$(this).hide(100);
	})
	//显示搜索列表
	function showDetailsList(){
		$("#list_title").click();
	}

	//加载辖区分布下辖地图区域并统计数据
	function loadStatisticChildMapArea(option){
		if(option==null) return;
		var layerData=getGis2DLayerDataByOrgId(option.orgId);
		if(layerData!=null && layerData!=""){
			$("#map").TqMap("setCenter",{lon:layerData.lon,lat:layerData.lat,zoom:layerData.zoom});
		}else{
			$.messageBox({message:"当前部门还未划分区域!",level:"error"});
			return;
		}
		prevsCenterLonLat =$("#map").TqMap("get","map").getCenter();
		$("#map").TqMap("deactivateSelectFeature",{sfname:"wfsSelectF"});
		deleteSubordinateMapAreaInfo();
		$.ajax({
			async:false,
			url:PATH+'/gis/twoDimensionMapStatisticCommonManage/statisticTwoDimensionMapInfoByOrgIdAndTypeName.action',
			data:{
				"organization.id":option.orgId,
				"typeName":option.table,
				"modeType":option.modeType
			},
			success: function(datas) {
				var statisticInfos = new Array();
				for(var i=0;i<datas.length;i++){
					var data = datas[i];
					statisticInfos.push($.extend(data,{
						centerX:eval(data.lon),
						centerY:eval(data.lat),
						centerX2:eval(data.lon2),
						centerY2:eval(data.lat2),
						id:data.organization.id,
						lon:null,lat:null,lon2:null,lat2:null,
						popupText:data.organization.orgName+"【"+data.sumNum+"】"
					}))
				}
				viewSubordinateFeatureAndPopupText(statisticInfos)
			}
		})
	}
	

/*------------------------------待清理---------------------------------------*/
var issueTypeName,housePropertyTypeName;
var issueType;//事件类型(根据事件类型得到相应的详情查看页面)
var personOrPlaceName,allTypeName;
	
	/*map zoom*/
	function showLegend(data){
		var orgName = '';
		var arearColor = '';
		var sumNum = '';
		var areaContent="<div class='areaContent' />";
		var currOrgId=$("#currOrgId").val();
		$(".legendContent").empty();
		$(".legendContent").append(areaContent);
		for(var i=0;i<data.length;i++){
			var color = getFillColorUrl(i);
			if(data[i].lon!=null && data[i].lat!=null){
				orgName = "<div title="+data[i].organization.orgName+">"+data[i].organization.orgName+"</div>";
				arearColor = '<div><span style="color:'+color+';" title='+allTypeName+'>███</span></div>';
				sumNum = '<div>'+data[i].sumNum+'<div>';
				areaCon="<div class='areaCon'>"+orgName+arearColor+sumNum+"</div>";
				$(".areaContent").append(areaCon);
			}
		}
		$(".gis_zoom_button").removeClass("hidden");
		$(".gis_zoom_content").show();
		mapZoom();
	}
	
	function mapZoom(){
		$(".gis_zoom_button").unbind("click").click(function(){
			if($(".gis_zoom_content").is(":visible")){
				$(".gis_zoom_content").hide();
				$(this).css({borderRightWidth:"0px"})
			}else{
				$(".gis_zoom_content").show();
			}
		});
	}
	
	function loadFeature(layerData,index,typeName,modeType){
		var color = getFillColorUrl(index);
		$("#map").TqMap("createSelectFeature",{clickFeature:clickFeature});//创建自定义Feature的SelectFeature
		$("#map").TqMap("featureShow",{
			points:layerData.points,
			fillOpacity:0.5,
			fillColor: color,			//默认颜色
			featureId:layerData.organization.id+"_feature",
			data:{orgId:layerData.organization.id,typeName:typeName,modeType:modeType,index:index}
		});
		$("#map").TqMap("activateSelectFeature");//激活自定义Feature
		return color;
	}
	
	function clickFeature(feature){
		var orgId = feature.data.orgId;
		var typeName = feature.data.typeName;
		var modeType = feature.data.modeType;
		$("#personPieChartlDialog").createDialog({
			width:650,
			height:550,
			zIndex:1007,
			title:"饼状图显示",
			url:"${path}/openLayersMap/columnChart/pieChart.jsp?orgId="+orgId+'&typeName='+typeName+'&modeType='+modeType,
			buttons: {
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	}
	
	
	//乡镇及以下层级
	function isTownOrganization(){
		return $("#currentOrgId").attr("orgLevelInternalId") <= <s:property value="@com.tianque.domain.property.OrganizationLevel@TOWN"/>;
	}
</script>
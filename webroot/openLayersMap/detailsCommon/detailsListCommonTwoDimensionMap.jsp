<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />

<div class="searchResult" style="overflow: hidden;">
	<div class="resultNum"><span class="plaint" title="清空"></span> <a id="refreshLoad" style="display: none;float: right;cursor:pointer;margin-right: 3px;">刷新</a> 共有<span id="detailsListTotal" class="detailsTotal">0</span>条搜索记录 </div>
	<div class="resultCon" style="overflow:auto;">
		<div id="detailsList" class="detailsList"></div>
		<div id="loadingValue"><img src='../resource/images/loading.gif' alt='加载中...'  style='vertical-align:middle;margin-left:15px;height:25px;' />信息加载中，请等待...</div>
	</div>
</div>
<div id="detailsListPager" class="pagination"></div>
<input type="hidden" id="listModeType" />
<div id="weChatResponseMaintanceDialog"></div>
<div id="smsResponseMaintanceDialog"></div>
<script type="text/javascript">
var detailsListPrevsPageInfo=null;
var sordField = "<s:property value='#parameters.sordField'/>"
var searchFunctionType=null;//搜索功能类型
var orgField=null;//发生网格
var intervalIdSurvival =0;
//判断是否是网格队伍管理点击详情
var isGridTeam = "<s:property value='#parameters.mainTableName'/>" == "gridTeamMember" ? true : false;
sordField = (sordField==null || sordField=='')?(gisType!="3D")?"centerlon2":"centerlon":sordField;
$(function(){
	function getInfoHeight(){
		var timer;
		function getHeight(){
			$(".resultCon").height($(".ui-layout-center").height()-120);
		}
		getHeight();
		$(window).resize(function(){
			clearTimeout(timer);
			timer=setTimeout(function(){getHeight()},500);
		})
	}
	getInfoHeight();
	viewLayerInformation();
	$(".plaint").click(function(){
		$(".plaint").hide();//隐藏清除图标
		$("#map").TqMap("deleteAllPopupText");//清除所有popup
		clearDetailsListInfo();//清空详情列表的内容
		$("#map").TqMap("deleteMouseTip");//删除提示
		$("#map").TqMap("unregisterEvent",{eventName:"mousemove",func:wfsFeatureMouseTip});//注销建筑物名称鼠标跟随提示
		clearMarkersByMarkerId_objectName("common");//删除公共的marker图标
		$("#map").TqMap("deletePopup");//删除popup
		$("#map").TqMap("removeAllFeatures");//删除所有自定义的Feature
		$("#showPersonLayer li ").removeClass().addClass("currentDefault").find('label').removeData();
		clearGpsMapAllMarker();
		
		if($("#<s:property value='@com.tianque.openLayersMap.util.BigModeType@HOURSEINFO'/>").attr("checked")!="checked"){
			$("#addHourseInfo").hide();
			$("#deleteHourseInfo").hide();
			clearMarkersByMarkerId_objectName("hourse");
			$("#<s:property value='@com.tianque.openLayersMap.util.BigModeType@HOURSEINFO'/>").attr("checked",false);
		}
		if($("#<s:property value='@com.tianque.openLayersMap.util.BigModeType@GRIDLAYER'/>").attr("checked")!="checked"){
			$("#map").TqMap("removeAllFeatures");//删除所有自定义的Feature
			$("#map").TqMap("deactivateSelectFeature",{sfname: "selectF"});//不激活自定义的Feature图层
			$("#map").TqMap("destroySelectFeature");//销毁自定义的SelectFeature
			$("#<s:property value='@com.tianque.openLayersMap.util.BigModeType@GRIDLAYER'/>").attr("checked",false);
		}
		
		var modeType="<s:property value='#parameters.modeType'/>";//Service层调用的类型
		if(modeType=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@GRIDLAYER_SEARCH'/>"){
			//$("#map").TqMap("removeAllFeatures");//删除所有自定义的Feature
			clearFeaturesByMarkerId_objectName("gridLayer");
			$("#map").TqMap("deactivateSelectFeature",{sfname: "selectF"});//不激活自定义的Feature图层
			$("#map").TqMap("destroySelectFeature");//销毁自定义的SelectFeature
		}else if(modeType=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOURSEINFO_SEARCH'/>"){
			clearMarkersByMarkerId_objectName("hourse");
		}else if(modeType=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOUSEPROPERTY_SEARCH'/>" 
			|| modeType=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@ISSUE_SEARCH'/>"
				|| modeType=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PERSON_SEARCH'/>"
					|| modeType=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@KEY_PLACE_SEARCH'/>"
						|| modeType=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@PERSON_SEARCH'/>"
							|| modeType=="null" || modeType==""){
			clearMarkersByMarkerId_objectName("common");
		}
		if($("#detailClick").val()=="true"){
			clearMarkersByMarkerId_objectName("common");
		}
		clearBoundEvent();
		IS_MAP_MOVE_SEARCH=true;//地图滑动搜索开启
	});
	
	function viewLayerInformation(){
		$("#listModeType").attr("value","<s:property value='#parameters.modeType'/>");
		clearMarkersByMarkerId_objectName("search");//删除地图上的周边查询图标
		clearMarkersByMarkerId_objectName("common");//删除之前的marker
		if($("#<s:property value='@com.tianque.openLayersMap.util.BigModeType@HOURSEINFO'/>").attr("checked")){
			if(bindInWfs==false){
				$("#addHourseInfo").show();
				$("#deleteHourseInfo").show();
			}
		}
		var screen = $("#map").TqMap("getScreenExtent");
		var orgId=$('#currOrgId').val();
		var featureId = "<s:property value='#parameters.featureId'/>";
		var buildDataId = "<s:property value='#parameters.buildDataId'/>";
		var centerLon= "<s:property value='#parameters.centerLon'/>";
		var centerLat= "<s:property value='#parameters.centerLat'/>";
		var mainTableName="<s:property value='#parameters.mainTableName'/>";//父表名
		var childTableName="<s:property value='#parameters.childTableName'/>";//子表名
		var modeType="<s:property value='#parameters.modeType'/>";//Service层调用的类型
		var type="<s:property value='#parameters.type'/>";//子类类型
		var url="<s:property value='#parameters.url'/>";
		var keyType="<s:property value='#parameters.keyType'/>";//重点场所key
		var isSerachMode="<s:property value='#parameters.isSerachMode'/>";	//是否为搜索功能
		_isSerachMode=isSerachMode;
		var filedA="<s:property value='#parameters.filedA'/>";//查询条件A
		var filedB="<s:property value='#parameters.filedB'/>";//查询条件B
		var filedC="<s:property value='#parameters.filedC'/>";//查询条件C
		var functionType="<s:property value='#parameters.functionType'/>";//功能类型
		var modeTypeDetailView="<s:property value='#parameters.modeTypeDetailView'/>";//详情查看modeType
		var isIssueDistributed="<s:property value='#parameters.isIssueDistributed'/>";//是否是辖区分布详情点击
		// 红袖套成员类别
		var redCuffTeamMemberTeamType="<s:property value='#parameters.redCuffTeamMemberTeamType'/>";
		var redCuffTeamMemberSubTeamType="<s:property value='#parameters.redCuffTeamMemberSubTeamType'/>";
		clearFeaturesByMarkerId_objectName("defaultGridLayer");//清除默认的下辖区域
		clearPopupTextById("defaultPopupText");//清除默认的下辖区域的POPup
		$("#map").TqMap("deletePopup");//清除popup页面
		if(mainTableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@REDCUFFTEAMMEMBER'/>" ){// 红袖套成员位置
			$("#refreshLoad").show().click(TQ.loadRedCuffTeam);
			var page = 0;
			var totalPage = 1;
			var url  = "${path}/baseinfo/redCuffTeamManage/findRedCuffTeamForPageResult.action?sidx=bindingTime&sord=desc&allowCache=true&redCuffTeam.notNoBindingTime=true&redCuffTeam.organization.id="+orgId+"&redCuffTeam.teamType.id="+redCuffTeamMemberTeamType+"&redCuffTeam.subTeamType.id="+redCuffTeamMemberSubTeamType;
			$("#tabList #detailsList").html("");
			// 因为数据非常大一次加载完浏览器容易卡死，采用分片处理
			var intervalId = setInterval(function(){
				if(page>=totalPage||!$("#redCuffTeamMember").closest("li").hasClass("currentPosClick")||intervalIdSurvival!= intervalId){
					clearInterval(intervalId);
					return false;
				}
				page++;
				$.getJSON(url,{"rows":200,"page":page},
				function(data){
					$("#tabList #loadingValue").hide();
					$("#detailsListTotal").html(data.records);
					var listStr = "<ul class='resultlist'>";
					var len = data.rows.length;
					TQMap.log("加载红袖套队伍数据page:"+page);
					for(var i=0;i<len;i++){
						var redCuffTeam = data.rows[i];
						//if(!redCuffTeam.bindingTime)continue;// 无定位数据不显示
						var markerId = redCuffTeam.id+"_redCuffTeamMark_common";
						var imgUrl = "/resource/openLayersMap/images/redBubble/people.png";
						var mouseoverImgUrl =  "/resource/openLayersMap/images/redBubble/people_cur.png";
						if(redCuffTeam.longitudeY&&redCuffTeam.latitudeX){
							var markerData = {id:redCuffTeam.id,imgUrl:imgUrl,mouseoverImgUrl:mouseoverImgUrl,title:redCuffTeam.memeberName+"  "+redCuffTeam.bindingTime,tableName:mainTableName,lon:redCuffTeam.longitudeY,lat:redCuffTeam.latitudeX};
							markerData.phoneNumber = redCuffTeam.phoneNumber;
							markerData.wechatNo = redCuffTeam.wechatNo;
							markerData.memeberName = redCuffTeam.memeberName;
							$("#map").TqMap("addMarker",{
									iconUrl:PATH + imgUrl,
									lon:redCuffTeam.longitudeY,
									lat:redCuffTeam.latitudeX,
									markerW:28,
									markerH:33,
									markerId:markerId,
									isOnMouseOverAndOut:true,
									isOnMouseOverMarkEnlarge:false,
									data:markerData
							 });
						}
						listStr+="<li id="+redCuffTeam.id+"><div class='resAbc'><img src="+PATH + imgUrl+"></div><div class='title clearfix'><a href='javascript:void(0);' onclick=\"onclickListItemToClickMarker('"+markerId+"')\">姓名："+redCuffTeam.memeberName+"</a></div><div><div class='clearfix'><p> 联系电话："+redCuffTeam.phoneNumber+"</p><p> 定位时间："+(redCuffTeam.bindingTime?redCuffTeam.bindingTime:'无定位数据')+"</p></div></div><div class='gisBtnList'></div></div></li>";
						$("#map").TqMap("registerEvent",{objectName:"marker",eventName:"click",func:function(e){
							var lon=e.object.lonlat.lon;
							var lat=e.object.lonlat.lat;
							var data = e.object.data;
							showCommonPopup(data.id,"<s:property value='@com.tianque.openLayersMap.util.BigModeType@REDCUFFTEAMMEMBER'/>" ,'',lon,lat,functionType,mainTableName,childTableName,'commonMapDetailViewService');
						}});
					}
					listStr += "</ul>";
					$("#tabList #detailsList").append(listStr);
				});
			},2000);
			intervalIdSurvival = intervalId;
			IS_MAP_MOVE_SEARCH=false;//关闭滑动搜索
			return;
		}
		if(mainTableName=="issues"){
			if(isIssueDistributed!="true"){
				orgId = <s:property value="@com.tianque.core.util.ThreadVariable@getUser().getOrganization().getId()"/>;//我的事项,orgId为当前用户的，与组织机构树无关		
			}	
		}
		if($("#detailClick").val()!="true" && isTownDownOrganization()&&mainTableName!="issues"){//非辖区分布详情点击
			deleteSubordinateMapAreaInfo();//清除下辖地图区域的相关信息
			viewTownAboveLayerInformation(url,modeType,type,mainTableName,childTableName,orgId,screen,$("#queryString").val(),filedA,filedB,filedC);
		}else{
			viewTownUnderLayerInformation(url,modeType,type,mainTableName,childTableName,keyType,screen,orgId,$("#queryString").val(),isSerachMode,filedA,filedB,filedC,buildDataId,featureId,centerLon,centerLat,functionType,modeTypeDetailView);
		}
	}

	function rebuildMarkerByMarkerId_objectName(markerId_objectName){
		var markerLayer = $("#map").TqMap("get","markers");
		if(markerLayer!=null && markerLayer!="undefined" && markerLayer!=""
			&& markerId_objectName!=null && markerId_objectName!="" && markerLayer.markers.length>0){
			for(var i=0; i<markerLayer.markers.length; i++){
				if(markerLayer.markers[i].markerId.split("_")[1]==markerId_objectName){
					changeMarkerSize(markerLayer.markers[i]);
				}
			}
	 	}
	 }
	function changeMarkerSize(marker){
		var width=marker.icon.size.w;
		var height=marker.icon.size.h;
		var currLevel=$("#map").TqMap("get","map").getZoom();
		if(lastZoom!=currLevel){
			$(marker.icon.imageDiv).find("img").css({width:width-width*(6-eval(currLevel))*15/100,height:height-height*(6-eval(currLevel))*15/100});
		}
	}
	
	function viewTownAboveLayerInformation(url,modeType,type,mainTableName,childTableName,orgId,screen,queryStr,filedA,filedB,filedC){
		$.ajax({
			url:url,
			async:true,
			data:{
				"organization.id":orgId,
				"tableName":mainTableName,
				"childTableName":childTableName,
				"modeType":modeType,
				"filedA":filedA,
				"filedB":filedB,
				"filedC":filedC,
				"typeName":type,
	            "searchValue":queryStr,
	            "gisType":TQMap.gisType
			},
			success:function(data){
				showDetailsList();//显示详情列表
				var str="<tr class='keyPopulation'><td class='msgL'><span class='text'>所属辖区</td><td class='msgL'><span class='text'>绑定数</td>";
				for(var i=0;data && i<data.length;i++){
					var layerData = TQConvert.toPoints(data[i]);
					if(layerData && layerData.organization){
						var organization = layerData.organization;
						str+="<tr class='keyPopulation' onclick='detailedListingClick("+organization.id+")'><td class='msgL'><span class='text'>"+organization.orgName+"</span></td><td class='dataPoint'><span class='num'>" +layerData.boundMapNum+"</span></td></tr>";
						if(layerData.lon && layerData.lat){
							var color = getFillColorUrl(i);
							$("#map").TqMap("featureShow",{
								points:layerData.points,
								fillColor:color,
								featureId:organization.id+"_gridLayer"
							});
							var pop=$("#map").TqMap("addPopupText",{
								 lon:layerData.lon,
								 lat:layerData.lat,
								 popupText:organization.orgName+"【"+layerData.boundMapNum+"】",
								 data:organization.id,
								 backgroundColor:"#66CC33",
								 popupTextId:'popupText',
								 autoSize:true
							});
							//$(pop.contentDiv).attr("title",organization.orgName+" 已绑定 "+allTypeName+" 数："+layerData.boundMapNum);//乡镇以上的的数量title注释
							$("#map").TqMap("registerEvent",{objectName:"popupText",eventName:"click",func:townAbovePopClick});
						}
					}
				}
				$("#tabList").html("<div class='new_personal_tableCon'><table class='new_personal_table'>"+str+"</table></div>");
				$(".new_personal_table tr").hover(function(){
					$(this).addClass("tableCur").siblings().removeClass("tableCur");
				},function(){
					$(this).removeClass("tableCur");
				});
				$(".currentPosClick").addClass("canRemoveCurrentPosClick");
			}
		});
	}
	function viewTownUnderLayerInformation(url,modeType,type,mainTableName,childTableName,keyType,screen,orgId,queryStr,isSerachMode,filedA,filedB,filedC,buildDataId,featureId,centerLon,centerLat,functionType,modeTypeDetailView){
		var idfop={
				url:url,
				async:true,
				datatype: "json",
				data:{
					"screenCoordinateVo.minLon":screen.minLon,
					"screenCoordinateVo.maxLon":screen.maxLon,
					"screenCoordinateVo.minLat":screen.minLat,
					"screenCoordinateVo.maxLat":screen.maxLat,
					"screenCoordinateVo.searchInfoVo.gisType":gisType,
					"organization.id":orgId,
					"mainTableName":mainTableName,
					"childTableName":childTableName,
					"keyType":keyType,
					"modeType":modeType,
					"typeName":type,
					"searchValue":queryStr,
					"isSerachMode":isSerachMode,
					"filedA":filedA,
					"filedB":filedB,
					"filedC":filedC,
					"featureId":featureId,
					"centerLon":centerLon,
					"centerLat":centerLat,
					"buildDataId":buildDataId,
					"functionType":functionType,
					"page":1,
					"rows":10,
					"sidx":sordField,
		            "sord":"asc"
				}
		}
		//加载当前屏幕内所有的地图marker数据
		if("<s:property value='#parameters.modeType'/>"=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOURSEINFO_SEARCH'/>"){
	 		$.ajax($.extend( true,idfop,{
	 			data:{ "rows":10000 },
	 			success:function(data){
	 				if(data.records>0){
	 					var rows=data.rows;
	 					for(var i =0 ;i<rows.length;i++){
	 						var row = TQConvert.toLonlat(rows[i]);//选择展示25D或2D坐标
	 						if(row.lon){
	 							var imgUrl=""+row.iconUrl+"/default.png";
	 							var mouseoverImgUrl=""+row.iconUrl+"/default_cur.png";
	 							var markerW=15;
	 							var markerH=20;
	 							var markerId=row.id+"_common";
	 							if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@TWONEWGROUP'/>" 
									|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_COMPANY_PLACE'/>"
										|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_UNIT_PLACE'/>"
										|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_COMPANY_PLACE'/>"
										|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@ENTERPRISE_PLACE'/>"
											||row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@SCENICS_MANAGE'/>"){
	 									if(_isSerachMode=="true"){
	 										markerId = row.moduleType+"_common";
	 									}
	 							}
	 							if(row.dustbinType=="监控电子眼"){
	 								imgUrl="/resource/openLayersMap/images/video/video_off.png";
	 							    mouseoverImgUrl="/resource/openLayersMap/images/video/video_on.png";
	 							    markerW=24;
	 								markerH=42;
	 							}
	 							//如果是建筑物图层则加载建筑物对应marker信息
	 							if("<s:property value='#parameters.modeType'/>"=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOURSEINFO_SEARCH'/>"){
	 								imgUrl="/resource/openLayersMap/images/house-3.png";
	 								markerW=40;
	 								markerH=30;
	 								markerId=rows[i].id+"_hourse";
	 								if(rows[i]!=null&&rows[i].typeId!=null){
	 									var hourseData=getHourseTypeImgPathAndMarkerWH(rows[i].typeId);
	 									imgUrl=hourseData.path;
	 									markerW=hourseData.markerW;
	 									markerH=hourseData.markerH;
	 									if(rows[i].featureId!="undefined"&&rows[i].featureId!=null && rows[i].featureId!=""&&bindInWfs){
	 										markerId=rows[i].featureId+"_hourse";
	 									}
	 								}
	 							}
	 							if(bindInWfs==false || row.featureId==""){
	 								$("#map").TqMap("addMarker",{
	 										iconUrl:PATH + imgUrl,
	 										markerW:markerW,
	 										markerH:markerH,
	 										lon:row.lon,
	 										lat:row.lat,
	 										markerId:markerId,
	 										data:{id:row.id,imgUrl:imgUrl,mouseoverImgUrl:mouseoverImgUrl,title:row.titleName+"："+row.titleValue,tableName:row.tableName,detailsUrl:row.detailsUrl,type:keyType,lon:row.lon,lat:row.lat,functionType:row.functionType,
	 											mainTableName:mainTableName,childTableName:childTableName,modeType:modeTypeDetailView}
	 								 });
	 								if("<s:property value='#parameters.modeType'/>"=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOURSEINFO_SEARCH'/>"){
	 									$("#map").TqMap("registerEvent",{objectName:"marker",eventName:"click",func:hourseClick});
	 								}else{
	 									$("#map").TqMap("registerEvent",{objectName:"marker",eventName:"click",func:markerOnClickCommon});
	 									registerMarkerMouseoverAndMouseoutEvent();
	 								}
									
	 							}
	 						}
	 					}
	 				}else{
	 					clearDetailsListInfo();//清空详情列表的内容
	 				}
	 			}
	 		}));
		}
		rebuildMarkerByMarkerId_objectName("hourse");
		if($("#map").TqMap("get","map").getZoom()!=lastZoom){
			lastZoom=$("#map").TqMap("get","map").getZoom();
		}
		//详情列表数据显示
		$("#detailsList").GisList($.extend( true,idfop,{
			data:{ "rows":10 },
			ajaxLoad:detailsListNextPage,//翻页方法
			rowFormatter:function(row,rowNumber){
				row = TQConvert.toLonlat(row);//选择展示25D或2D坐标
				if(row==null || row == undefined){return false;}
				var $thisRow=$("<li id='"+row.id+"'/>");
				var $thisIcon=$("<div />");
				var $titleDiv=$("<div />").addClass("title clearfix");
				var $contentList=$("<div />");
				var $buttonList=$("<div />").addClass("gisBtnList");
				searchFunctionType=row.functionType;
				if(row.organization==null || row.organization==undefined){
					orgField=row.orgFiled;
				}else{
					orgField=row.organization.id;
				}
				var orgField = orgField;
				var rowIconUrl = row.iconUrl;
				var imgUrl=rowIconUrl+"/default.png";
				if(rowIconUrl == "gridTeamImgIsNull"){
					imgUrl = "/resource/system/images/avatar.jpg";
				}
				//判断是否显示图标
				if(row.isViewIcon){
					var $img=$("<img />");
					if(row.lon!=null && row.lon!=""){//已绑定
						if(modeType=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOURSEINFO_SEARCH'/>" ){
							var imgUrl=getHourseTypeImgPathAndMarkerWH(row.typeId).path;//row.typeId--楼宇类型的id
							
							$img.attr("src",imgUrl).css({
								width:30,
								height:30,
								'margin-top':10
							});
							$thisIcon.addClass("resAbc").append($img);
						}else{
							if(!isGridTeam){
								var imgUrl= getIconUrl(row.iconUrl,rowNumber);
								if(row.dustbinType=="监控电子眼"){
									imgUrl="/resource/openLayersMap/images/video/video_off.png";
								}
							}else{
								$img.attr("src",imgUrl).css({
									width:32,
									height:32
								});
							}
							$thisIcon.addClass("resAbc").append($img);
						}				
					}else{//未绑定
						
						if(isGridTeam){
							$img.attr("src",imgUrl).css({
								width:32,
								height:32
							});
						}
						$thisIcon.addClass("resNum").append($img);
					}
					$img.attr("src",imgUrl);
				}
				$thisRow.append($thisIcon);
				var $title = "";
				if(isGridTeam){
					var titleValF = "";
					var titleValL = row.titleValue;
					titleValF = titleValL.substring(0,titleValL.indexOf("("));
					titleValL = titleValL.substring(titleValL.indexOf("("),titleValL.length);
					$title = $("<a href='javascript:;'>"+row.titleName+"："+titleValF+"<span style='margin-left:15px;'>"+titleValL+"</span></a>");
				}else{
					$title = $("<a href='javascript:;'>"+row.titleName+"："+row.titleValue+"</a>");
				}
				
				if(modeType=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOURSEINFO_SEARCH'/>" ){
					if(row.titleValue!=""&&row.titleValue!=null&&row.titleValue!=undefined){
						$title=$title.click(function(){
							if(row.featureId!="undefined" && row.featureId!=""&&row.featureId!=null&&bindInWfs){
								viewHoursePopupAndFeature(row.id,row.lon,row.lat,row.imgUrl);
							}else{
								viewHoursePopup(row.id,row.lon,row.lat,row.imgUrl);
							}
						});
					}else{
						$title=$("<a href='javascript:;'>经度："+row.lon+"</a>").click(function(){
							if(row.featureId!="undefined"&&row.featureId!=""&&row.featureId!=null&&bindInWfs){
								viewHoursePopupAndFeature(row.id,row.lon,row.lat,row.imgUrl);
							}else{
								viewHoursePopup(row.id,row.lon,row.lat,row.imgUrl);
							}
						});
					}
				}else if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_PERSON'/>" || 
						row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@PERSON'/>" ||
						row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@OTHERPERSON'/>"
							|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@CAREPERSON'/>"){
					if(row.lon!=null && row.lon!=""){
						$title = $title.click(function(){
							showCommonPopup(row.id,row.moduleType,keyType,row.lon,row.lat,row.functionType,mainTableName,childTableName,modeTypeDetailView);
						});
 					}
				}else if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@GRIDLAYER'/>"){
					if(row.lon!=null && row.lon!=""){
						$title = $title.click(function(){
							gridPolygonStatisticsInfo(row.lon,row.lat,row.organization.id);
						});
 					}
				}else if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@CITYCOMPONENTS'/>"){
					if(row.lon!=null && row.lon!=""){
						$title = $title.click(function(){
							showCommonPopup(row.id,row.tableName,row.dustbinType,row.lon,row.lat,row.functionType,mainTableName,childTableName,modeTypeDetailView);
						});
 					}
				}else if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@TWONEWGROUP'/>" 
					|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_COMPANY_PLACE'/>"
						|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_UNIT_PLACE'/>"
						|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_COMPANY_PLACE'/>"
						|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@ENTERPRISE_PLACE'/>"
							||row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@SCENICS_MANAGE'/>"){
					if(row.lon!=null && row.lon!=""){
						$title = $title.click(function(){
							showCommonPopup(row.encryptId,row.tableName,row.moduleType,row.lon,row.lat,row.functionType,row.tableName,childTableName,modeTypeDetailView);
						});
					}
				}else if(mainTableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@PUBLICSECURITY'/>"){
					if(row.lon!=null && row.lon!=""){
						$title = $title.click(function(){
							showCommonPopup(row.id,row.moduleType,row.moduleType,row.lon,row.lat,row.functionType,mainTableName,childTableName,modeTypeDetailView);
						});
 					}
				}else {
					if(row.lon!=null && row.lon!=""){
						$title = $title.click(function(){
							if(row.moduleType=="undefined"||row.moduleType==""||row.moduleType==null){
								row.moduleType="";
							}
							if(row.tableName=="issues" || row.tableName=="jurisdictionsIssue"){//事件的详情查看
								if(row.moduleType!=""&&'null'!=row.moduleType&&typeof(row.moduleType)!='undefined'){
									childTableName=row.moduleType;
								}
							}
							showCommonPopup(row.encryptId,row.tableName,row.moduleType,row.lon,row.lat,row.functionType,mainTableName,childTableName,modeTypeDetailView);
						});
 					}
				}
				
				$titleDiv.append($title);
				//list
				var thisField=$("<div class='clearfix'/>");
				if(modeType=="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOURSEINFO_SEARCH'/>"){
					if(row.fieldA!=null && row.fieldA!=""&& row.fieldA!=undefined){
						thisField.append("<p> "+row.fieldNameA+"："+row.fieldA+"</p>");
					}else{
						thisField.append("<p> 纬度："+row.lat+"</p>");
					}
				}else if(row.fieldNameA!=null && row.fieldNameA!=""){
					thisField.append("<p> "+row.fieldNameA+"："+row.fieldA+"</p>");
				}
				if(row.fieldNameB!=null && row.fieldNameB!="" ){
					thisField.append("<p> "+row.fieldNameB+"："+row.fieldB+"</p>");
				}
				if(row.fieldNameC!=null && row.fieldNameC!="" ){
					thisField.append("<p> "+row.fieldNameC+"："+row.fieldC+"</p>");
				}
				if(row.fieldNameD!=null && row.fieldNameD!="" ){
					thisField.append("<p> "+row.fieldNameD+"："+row.fieldD+"</p>");
				}
				if(row.fieldNameE!=null && row.fieldNameE!="" ){
					thisField.append("<p> "+row.fieldNameE+"："+row.fieldE+"</p>");
				}
				
				$contentList.append(thisField);
				//if(row.detailsListEventInfo!=""&&row.detailsListEventInfo!=undefined&&row.detailsListEventInfo!=null && row.detailsListEventInfo.length>0){
				if(row.boundEventIsValid!=null && row.boundEventIsValid!="" && row.boundEventIsValid!=undefined){
					var event="boundOnMap";
					//for(var i=0;i<row.detailsListEventInfo.length;i++){
						var thisButton=$("<a href='javascript:;'></a>");
						if(row.lon!=null && row.lon!=""){
							if(row.unBoundEventIsValid){
								thisButton.addClass("cancelBind").click(function(){
									if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@TWONEWGROUP'/>" 
										|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_COMPANY_PLACE'/>"
											|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_UNIT_PLACE'/>"
											|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_COMPANY_PLACE'/>"
											|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@ENTERPRISE_PLACE'/>"
												||row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@SCENICS_MANAGE'/>"){
										var table = "<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_PLACE'/>";
										unBoundCommon(row.id,table,row.moduleType,row.lon,row.lat,row.featureId,"bindInBuild",rowNumber,orgField,row.functionType,mainTableName,childTableName,modeTypeDetailView,row.titleName+"："+row.titleValue);
										$thisRow.attr("class",row.moduleType);
									}else if(row.tableName=="issues"||row.tableName=="jurisdictionsIssue"){
										unBoundCommon(row.id,"issues","",row.lon,row.lat,row.featureId,event,rowNumber,orgField,row.functionType,mainTableName,childTableName,modeTypeDetailView,row.titleName+"："+row.titleValue);
										$thisRow.attr("class","");
									}else if(row.tableName=="dustbin"||row.tableName=="dustbinHasVideo"){
										unBoundCommon(row.id,row.tableName,keyType,row.lon,row.lat,row.featureId,event,rowNumber,orgField,row.functionType,mainTableName,row.dustbinType,modeTypeDetailView,row.titleName+"："+row.titleValue);
										$thisRow.attr("class",keyType);
									}else if(mainTableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@PUBLICSECURITY'/>" ){
										unBoundCommon(row.id,row.moduleType,row.moduleType,row.lon,row.lat,row.featureId,event,rowNumber,orgField,row.functionType,mainTableName,childTableName,modeTypeDetailView,row.titleName+"："+row.titleValue);
										$thisRow.attr("class",row.id+row.moduleType);
									}else{
										unBoundCommon(row.id,row.tableName,keyType,row.lon,row.lat,row.featureId,event,rowNumber,orgField,row.functionType,mainTableName,childTableName,modeTypeDetailView,row.titleName+"："+row.titleValue);
										$thisRow.attr("class",keyType);
									}
								});
								thisButton.text(row.unBoundEventName);
							}
						}else{
							if(row.boundEventIsValid){
								thisButton.addClass("addressBind").click(function(){
									if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@TWONEWGROUP'/>" 
										|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_COMPANY_PLACE'/>"
											|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_UNIT_PLACE'/>"
											|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_COMPANY_PLACE'/>"
											|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@ENTERPRISE_PLACE'/>"
											|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@SCENICS_MANAGE'/>"
											|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_PLACE'/>"	){
										var table = "<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_PLACE'/>";
										boundCommon(row.id,table,row.moduleType,row.lon,row.lat,row.featureId,"bindInBuild",rowNumber,orgField,row.functionType,mainTableName,childTableName,modeTypeDetailView,row.titleName+"："+row.titleValue);
										$thisRow.attr("class",row.moduleType);
									}else if(row.tableName=="issues"||row.tableName=="jurisdictionsIssue"){
										boundCommon(row.id,"issues","",row.lon,row.lat,row.featureId,event,rowNumber,orgField,row.functionType,mainTableName,childTableName,modeTypeDetailView,row.titleName+"："+row.titleValue);
										$thisRow.attr("class","");
									}else if(row.tableName=="dustbin"||row.tableName=="dustbinHasVideo"){
										boundCommon(row.id,row.tableName,keyType,row.lon,row.lat,row.featureId,event,rowNumber,orgField,row.functionType,mainTableName,row.dustbinType,modeTypeDetailView,row.titleName+"："+row.titleValue);
										$thisRow.attr("class",keyType);
									}else if(mainTableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@PUBLICSECURITY'/>" ){
										boundCommon(row.id,row.moduleType,row.moduleType,row.lon,row.lat,row.featureId,event,rowNumber,orgField,row.functionType,mainTableName,childTableName,modeTypeDetailView,row.titleName+"："+row.titleValue);
										$thisRow.attr("class",row.id+row.moduleType);
									}else{
										boundCommon(row.id,row.tableName,keyType,row.lon,row.lat,row.featureId,event,rowNumber,orgField,row.functionType,mainTableName,childTableName,modeTypeDetailView,row.titleName+"："+row.titleValue);
										$thisRow.attr("class",keyType);
									}
								});
								thisButton.text(row.boundEventName);
							}
						}
						$buttonList.append(thisButton);
				}
					
			//		}
			//	}
				
				$thisRow.append($titleDiv).append($contentList).append($buttonList);
				return $thisRow;
			}
		}));
	}
	
	//列表翻页方法
	function detailsListNextPage(data){
		$("#map").TqMap("deletePopup");//清除popup页面
		if("<s:property value='#parameters.modeType'/>"!="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@HOURSEINFO_SEARCH'/>"
			&&"<s:property value='#parameters.modeType'/>"!="<s:property value='@com.tianque.openLayersMap.util.ServiceImplModeType@GRIDLAYER_SEARCH'/>"){
			var keyType="<s:property value='#parameters.keyType'/>";
			var mainTableName="<s:property value='#parameters.mainTableName'/>";//父表名
			var childTableName="<s:property value='#parameters.childTableName'/>";//子表名
			var modeType="<s:property value='#parameters.modeType'/>";//Service层调用的类型
			var modeTypeDetailView="<s:property value='#parameters.modeTypeDetailView'/>";//功能类型
			var type="<s:property value='#parameters.type'/>";
			if(data.records>0){
				var rows=data.rows;
				if(detailsListPrevsPageInfo!=null && detailsListPrevsPageInfo!="undefined" && detailsListPrevsPageInfo!=""){
					for(var j = 0; j < detailsListPrevsPageInfo.length; j++){
						var row = TQConvert.toLonlat(detailsListPrevsPageInfo[j]);//选择展示25D或2D坐标
						var markerId=row.id+"_common";
						$("#map").TqMap("deleteMarkerByMarkerId",{markerId:markerId});
						if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@TWONEWGROUP'/>" 
							|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_COMPANY_PLACE'/>"
								|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_UNIT_PLACE'/>"
								|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_COMPANY_PLACE'/>"
								|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@ENTERPRISE_PLACE'/>"
								||row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@SCENICS_MANAGE'/>"
								|| mainTableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@PUBLICSECURITY'/>"){
								if(_isSerachMode=="true"){
									if(mainTableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@PUBLICSECURITY'/>"){
										markerId = row.id+row.moduleType+"_common";
									}else{
										markerId = row.moduleType+"_common";
									}
								}
							
						}
						if(row.lon!=null&&row.lon!=""&&row.lon!="undefined"){
							var imgUrl=""+row.iconUrl+"/default.png";
							var mouseoverImgUrl=""+row.iconUrl+"/default_cur.png";
							var markerW=15;
							var markerH=20;
							if(row.dustbinType=="监控电子眼"){
								imgUrl="/resource/openLayersMap/images/video/video_off.png";
								mouseoverImgUrl="/resource/openLayersMap/images/video/video_on.png";
								markerW=24;
								markerH=42;
							}
							$("#map").TqMap("addMarker",{
								iconUrl:PATH + imgUrl,
								markerW:markerW,
								markerH:markerH,
								lon:row.lon,
								lat:row.lat,
								markerId:markerId,
								isOnMouseOverAndOut:true,
								data:{id:row.id,imgUrl:imgUrl,mouseoverImgUrl:mouseoverImgUrl,title:row.titleName+"："+row.titleValue,tableName:row.tableName,detailsUrl:row.detailsUrl,type:keyType,lon:row.lon,lat:row.lat,functionType:row.functionType,
									mainTableName:mainTableName,childTableName:childTableName,modeType:modeTypeDetailView}
							});
							$("#map").TqMap("registerEvent",{objectName:"marker",eventName:"click",func:markerOnClickCommon});
							//registerMarkerMouseoverAndMouseoutEvent();
						}
					}
			 	}
				detailsListPrevsPageInfo=rows;
				for(var i =0 ;i<rows.length;i++){
					var row = TQConvert.toLonlat(rows[i]);//选择展示25D或2D坐标
					//$("#map").TqMap("deleteMarkerByMarkerId",{markerId:rows[i].id+"_common"});各个表的id可以的相等的
					if(row.lon){
						var rowIconUrl = row.iconUrl;
						if(rowIconUrl == "gridTeamImgIsNull"){
							rowIconUrl = "/resource/system/images/avatar.jpg?";
						}
						var imgUrl = getIconUrl(rowIconUrl,i);
						var mouseoverImgUrl=getMouseoverIconUrl(rowIconUrl,i);
						var markerW=20;
						var markerH=25;
						var markerId=row.id+"_common";
						var markerTableName=row.tableName;
						var markerType=keyType;
						if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_PERSON'/>" || 
								row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@PERSON'/>"||
								row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@OTHERPERSON'/>"||
								row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@CAREPERSON'/>" ){
							markerTableName = row.moduleType;
						}else if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@TWONEWGROUP'/>" 
									|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_COMPANY_PLACE'/>"
									|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_UNIT_PLACE'/>"
									|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_COMPANY_PLACE'/>"
									|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@ENTERPRISE_PLACE'/>"
									||row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@SCENICS_MANAGE'/>"
									|| mainTableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@PUBLICSECURITY'/>"){
							markerType = row.moduleType;
							if(_isSerachMode=="true"){
								if(mainTableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@PUBLICSECURITY'/>"){
									markerTableName = row.moduleType;
									markerId = row.id+markerType+"_common";
								}else{
									markerId = markerType+"_common";
								}
								
							}
						}else if(row.tableName=="issues"||row.tableName=="jurisdictionsIssue"){
							if(row.moduleType!=""&&'null'!=row.moduleType&&typeof(row.moduleType)!='undefined'){
								childTableName=row.moduleType;
							}
							markerType=type;
						}
						if(row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@TWONEWGROUP'/>" 
							|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_COMPANY_PLACE'/>"
								|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@NEW_UNIT_PLACE'/>"
								|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_COMPANY_PLACE'/>"
								|| row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@ENTERPRISE_PLACE'/>"
								||row.tableName=="<s:property value='@com.tianque.openLayersMap.util.BigModeType@SCENICS_MANAGE'/>"){
							//mainTableName = "<s:property value='@com.tianque.openLayersMap.util.BigModeType@KEY_PLACE'/>";
						}
						if(row.dustbinType=="监控电子眼"){
							imgUrl="/resource/openLayersMap/images/video/video_off.png";
							mouseoverImgUrl="/resource/openLayersMap/images/video/video_on.png";
							markerW=24;
							markerH=42;
						}
						$("#map").TqMap("addMarker",{
							iconUrl:PATH + imgUrl,
							markerW:markerW,
							markerH:markerH,
							lon:row.lon,
							lat:row.lat,
							markerId:markerId,
							isOnMouseOverAndOut:true,
							data:{id:row.id,imgUrl:imgUrl,mouseoverImgUrl:mouseoverImgUrl,title:row.titleName+"："+row.titleValue,tableName:markerTableName,detailsUrl:row.detailsUrl,type:markerType,lon:row.lon,lat:row.lat,functionType:row.functionType,
								mainTableName:mainTableName,childTableName:childTableName,modeType:modeTypeDetailView}
						});
						$("#map").TqMap("registerEvent",{objectName:"marker",eventName:"click",func:markerOnClickCommon});
						//registerMarkerMouseoverAndMouseoutEvent();
					}
				}
			}			
		}
		$(".currentPosClick").addClass("canRemoveCurrentPosClick");
	}
});

//乡镇以上级别popText的点击事件
function townAbovePopClick(e){
	detailedListingClick(e.object.data);
}

function detailedListingClick(orgId){
	var layerData=getGis2DLayerDataByOrgId(orgId);
	if(layerData!=null && layerData!=""){
		$("#map").TqMap("setCenter",{lon:layerData.lon,lat:layerData.lat,zoom:layerData.zoom});
	}else{
		$.messageBox({message:"当前部门还未划分区域!",level:"error"});
	}
}

//网格图层热区点击事件
function clickGridLayerFeature(feature){
	var centerLon=feature.data.lon;
	var centerLat=feature.data.lat;
	var lonlat={lon:centerLon,lat:centerLat};
	var zoom = $("#map").TqMap("get","map").getZoom();
	var orgId=feature.data.orgId;
	gridPolygonStatisticsInfo(centerLon,centerLat,orgId);
}

//网格图层热区点击弹出框
function gridPolygonStatisticsInfo(centerLon,centerLat,orgId){
	var lonlat={lon:centerLon,lat:centerLat};
	$("#map").TqMap("addPopup",{
		url:PATH+"/gis/twoDimensionMapStatisticCommonManage/countGridLayerInfoByOrgId.action?organization.id="+orgId,
		lon:centerLon,
		lat:centerLat,
		lonlat:lonlat,
		popupW:200,
		popupH:150
	});
}

function viewHoursePopupAndFeature(id,lon,lat,imgUrl){
	clearFeatureByLayerData();//删除自定义feature
	$.ajax({
		url:"${path}/gis/hourseTwoDimensionMapManage/getHourseInfoById.action?featureId="+id,
		success:function(responseData){
			if(responseData!=null && responseData.featureId!=null && responseData.featureId!=""){
				var feature = $("#map").TqMap("get","wfslayer").getFeatureByFid(responseData.featureId);
				var featureName=null;
				if(feature!=null){
					$("#map").TqMap("get","wfsSelectF").select(feature);
					featureName=feature.data.NAME;
				}
				
				$("#map").TqMap("addPopup",{
					url:PATH+"/gis/hourseTwoDimensionMapManage/dispatch.action?buildDataInfoVo.lon="+lon+"&buildDataInfoVo.lat="+lat+"&buildDataInfoVo.gisType="+gisType+"&buildDataId="+id+"&organization.id="+orgId,
					lon:lon,
					lat:lat,
					lonlat:{lon:lon,lat:lat},
					popupW:440,
					popupH:190,
					closeBoxCallback:function(){this.destroy();if(feature!=null) $("#map").TqMap("get","wfsSelectF").unselect(feature);}
				});
			}
		}
	});
}


function clearDetailsListInfo(){
	$("#detailsListTotal").html(0);//清空详情列表的内容
	$("#detailsList").nextAll().remove();//清空详情列表的内容
	$("#tabList #detailsList").html('');
	$("#detailsListPager").empty();//清空详情列表的内容
}
function onclickListItemToClickMarker(markerId){
	var marker = $("#map").TqMap("getMarkerBy",{'value':markerId});
	if(marker){
		$("#"+marker.icon.imageDiv.id).click();
	}else{
		$.messageBox({
			message : "没有定位数据",
			level : "error"
		});
	}
}
function chooseRedCuffByDraw(markersArray,lon,lat){
//		var html = '<textarea rows="10" cols="20" readonly="readonly">';
	var option = "<div class='tableBox' style='max-height:200px;overflow:hidden;overflow-y:auto;'><table class='newTableList' id='chooseRedCuff'>";
	var hasData = false;
	for(var i=0;i<markersArray.length;i++){
		var marker = markersArray[i];
		option = option+'<tr><td style="vertical-align:middle"><input type="checkbox" checked="checked" name="chooseRedCuffCheckbox" data-wechatno="'+marker.data.wechatNo+'" data-phonenumber="'+marker.data.phoneNumber+'"/></td><td>'+marker.data.memeberName+"</td><td>"+marker.data.phoneNumber+"</td></tr>";
		hasData = true;
	}
	option+="</table>";
	var html = '<div class="ui-corner-all" id="nav"><a href="javascript:void(0)" onclick="smsSend();"><span>发短信</span></a><a href="javascript:void(0)" onclick="weChatMassSend();"><span>发微信</span></a></div><div>';
		html = html+option;
		html = html+"</div>";
	if(hasData==false)html = "无数据";
	$("#map").TqMap("addPopupText",{
		id:'redCuffTeamMemberChoose_map',
		lon:lon,
		lat:lat,
		popupText:html,
//			popupW:200,
//			popupH:500,
		autoSize:true,
		borderColor:'red',
		backgroundColor:"#fff"
	});
}
function weChatMassSend(){
	var sendToWechatNo = "";
	var checkboxs = $("#chooseRedCuff input[name='chooseRedCuffCheckbox']:checked");
	var count = 0;
	for(var i=0;i<checkboxs.length;i++){
		var wechatNo = $(checkboxs[i]).data("wechatno");
		if(!wechatNo)continue;
		if(sendToWechatNo!='')sendToWechatNo+=",";
		sendToWechatNo+=wechatNo;
		count++;
	}
	if(sendToWechatNo==''){
		$.messageBox({message : "没有微信号",level : "error"});
		return;
	}
	if(count<2){
		$.messageBox({message : "微信群发至少2人",level : "error"});
		return;
	}
	$("#weChatResponseMaintanceDialog").createDialog({
		width: 700,
		height: 250,
		title:'群发微信',
		url:'${path}/weChatResponseManage/dispatch.action?mode=weChatMassSendDlg&isSendByWechatNo=true&sendToWechatNo='+sendToWechatNo,
		buttons: {
	   		"保存" : function(event){
	   			$("#maintainForm").submit();
	   		},
	   		"关闭" : function(event){
	        	$(this).dialog("close");
	   		}
		}
	});
}
function smsSend(){
	var sendToPhoneNumber = "";
	var checkboxs = $("#chooseRedCuff input[name='chooseRedCuffCheckbox']:checked");
	for(var i=0;i<checkboxs.length;i++){
		var phoneNumber = $(checkboxs[i]).data("phonenumber");
		if(!phoneNumber)continue;
		if(sendToPhoneNumber!='')sendToPhoneNumber+=",";
		sendToPhoneNumber+=phoneNumber;
	}
	if(sendToPhoneNumber==''){
		$.messageBox({message : "没有手机号",level : "error"});
		return;
	}
	$("#smsResponseMaintanceDialog").createDialog({
		width: 550,
		height: 450,
		title:'短信群发',
		url:'${path}/smsResponseManage/dispatch.action?mode=add&isSendByPhoneNumber=true&sendToPhoneNumber='+sendToPhoneNumber,
		buttons: {
	   		"发送" : function(event){
	   			$("#maintainForm").submit();
	   		},
	   		"关闭" : function(event){
	        	$(this).dialog("close");
	   		}
		}
	});
}

//根据网格员信息id得到网格员详细信息
function getGridTeamInfoById(id){
	$("#gridMemeberDialog").createDialog({
		width: 800,
		height: 500,
		title:'查看网格员信息',
		url:'${path}/baseinfo/gridTeamManage/dispatchOperate.action?mode=view&gridTeam.id='+id,
		buttons: {
	   		"关闭" : function(){
	        	$(this).dialog("close");
	   		}
		}
	});
}
</script>
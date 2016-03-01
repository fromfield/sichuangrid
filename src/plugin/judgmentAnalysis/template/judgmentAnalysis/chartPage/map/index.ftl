<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<link rel="stylesheet" href="/resource/judgmentAnalysis/css/analysis.css"/>
<style>
.ui-layout-center{
	height:100%;
	background-color:#fff;
}
.highcharts-container{
	height:350px!important;
}
.mainBody{
	position:relative;
}
.returnBtn{
	position: absolute;
    top: 8%;
    left: 1%;
	display: block;
    width: 60px;
    height: 26px;
    background-color: #1eaae5;
    border: 1px solid #1ca4e2;
    text-align: center;
    font: 14px/26px 'Microsoft Yahei';
    color: #fff;
    cursor:pointer;
    z-index:100;
}
.returnBtn:hover{
	background-color: #1993cb;
    border: 1px solid #187ba8;
}
#hiddengerType{
	overflow-y:auto;
}
.setCondition{
	position: absolute;
	margin-left: 415px;
	margin-top: 0px;
	width: 45px;
	height: 35px;
	margin-top: -35px;
	display: block;
	background-color: #1eaae5;
	border: 1px solid #1ca4e2;
	text-align: center;
	font: 14px/26px 'Microsoft Yahei';
	color: #fff;cursor: pointer;
	z-index: 100;
}
#mapPieChart{
	width:100%;	
	min-height:350px;
}
#mapPieChart svg{
	margin-top:-50px;
}
#setCondition{
	z-index:0
}
</style>
<div id="main" class="main">
    <div class="mCrumbs" id="mCrumbs">当前位置：研判分析 &gt; <a href="javascript:;">地图分析</a></div>
    <div id="mainBody" class="mainBody cf">
    	<a href="javascript:;" id="returnBtn" class="returnBtn">返回</a>
    	<div id="mapMain" style="height:95%">
    	</div>
		<div class="rightPieMod">
			<div class="tit">
				<h2 id="orgNameMap"></h2>
				<input type="button" value="设置" class="setCondition" id="setCondition"/>
				<input type="button" value="趋势" class="setCondition" id="getTaskListTrend" style="margin-left: 365px;"/>
			</div>
			<div class="info">
				<ul>
					<li><em id="changeType">上报</em>任务数：<em></em><b id="signCount"></b>&nbsp;条</li>
					<li>同比数据：<em></em><b id="anCount"></b>&nbsp;条 <span class="up" id="onSpan"></span><b id="anCountUp"></b></li>
					<li>环比数据：<em></em><b id="momCount"></b>&nbsp;条 <span class="down" id="momSpan"></span><b id="momCountDown"></b></li>
					<li class="pieChartMod">
						<div id="mapPieChart">
							
						</div>
					</li>
				</ul>
			</div>
			<!-- info -->
		</div>
		<!-- rightPieMod -->
		 <div class="bottomTabs">
		 	<span class="space"></span>
			<div class="tabs">
				<div class="tabsItem">
					<h2><i class="floatPopulation" id="a_floating" basesicType="a_floating"></i>流动人口</h2>
					<div class="item">
						<ul>
							<li>
								<a href="javascript:changeType('a_floating','c_exceptionalSituationRecord','');" class="itemA" detailType="c_exceptionalSituationRecord">异常情况</a>
								<div class="subitem" id="exceptionType">
									<div class="subitemBg"></div>
								</div>
							</li>
							<li>
								<a href="javascript:changeType('a_floating','b_workingSituation','');" class="itemA" detailType="b_workingSituation">民警带领下开展工作</a>
								<div class="subitem" id="policeType">
									<div class="subitemBg"></div>
								</div>
							</li>
							<li>
								<a href="javascript:changeType('a_floating','a_propagandaAndVerification','');" class="itemA" detailType="a_propagandaAndVerification">宣传核查</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="tabsItem">
					<h2><i class="specialPopulation" id="special"></i>特殊人群</h2>
					<div class="item">
						<ul>
						    <li><a href="javascript:changeType('e_positiveInfoRecord','','');" class="itemA" basesicType="e_positiveInfoRecord">刑释人员</a></li>
							<li><a href="javascript:changeType('d_termerRecord','','');" class="itemA" basesicType="d_termerRecord">社区服刑人员</a></li>
							<li><a href="javascript:changeType('c_mentalPatientTask','','');" class="itemA" basesicType="c_mentalPatientTask">严重精神病障碍患者</a></li>
							<li><a href="javascript:changeType('b_druggyTask','','');" class="itemA" basesicType="b_druggyTask">吸毒人员</a></li>
						</ul>
					</div>
				</div>
				<div class="tabsItem">
					<h2><i class="hiddenDanger" id="f_hiddendanger" basesicType="f_hiddendanger"></i>发现治安隐患</h2>
					<div class="item">
						<ul id="hiddengerType">
						</ul>
					</div>
				</div>
			</div>
		</div>    
    </div>  
</div>
<div id="conditionDiv"></div>
<script src="/resource/judgmentAnalysis/js/echarts/linecharts.js"></script>

<script>
var organizationName='四川省';
//false 查本级区域  true 查下级区域
var mapByType = false;
//如果不是admin用户，请求后台判断是否是职能部门
<@s.if test="!@com.tianque.core.util.ThreadVariable@getUser().getUserName().equals('admin')">
	$.ajax({
		async: false,
		url:"/plugin/statistics/generalSituationManage/getOrganizationInfoByOrgType.action",
		success:function(returnData){
			organizationName = returnData.split(",")[0];
			mapByType = returnData.split(",")[1];
		}
	});
</@s.if>
var basesicTypes = "";
var detailTypes = "";
var subTypes = "";
var signType=0;
var searchDateType=0;
var month='';
var quarter='';
var yearType='';
var year='';
var nameValue = "任务清单";//用来改变formatter内容
statusBySet = true;//地图分析设置弹出层记录任务状态值  true为签收  false为上报
var pieBoolean = true;
function changeType(basesicType,detailType,subType){
   getNameByType(basesicType,detailType,subType);
   if(organizationName==''){
   	organizationName="四川省";
   }
   basesicTypes = basesicType;
   detailTypes = detailType;
   if(subType == "map"){
   		subTypes = "";
   		getMapBySegin(2);
   }else if(subType == "nextMap"){//地图双击进去下一层区域
   		subTypes = "";
   		getMapBySegin(3);
   }else{
   		subTypes = subType;
   		getMapBySegin(1);
   }
   $.ajax({
		async: false,
		url:'/plugin/statistics/generalSituationManage/geTaskListMapStatistics.action?taskListStatisticsVo.isSegin='+signType+'&taskListStatisticsVo.searchDateType='+searchDateType+'&taskListStatisticsVo.year='+year+'&taskListStatisticsVo.month='+month+'&taskListStatisticsVo.quarter='+quarter+'&taskListStatisticsVo.yearType='+yearType+'&taskListStatisticsVo.basesicType='+basesicType+'&taskListStatisticsVo.detailType='+detailType+'&taskListStatisticsVo.subType='+subTypes+'&taskListStatisticsVo.orgName='+organizationName,
		success:function(data){
				if(data!=null){
				 	 $("#orgNameMap").html(data.organization.orgName);
					 $("#signCount").html(data.monthCreateSign);    
					 $("#anCount").html(data.onMonthCreateSign);
					 $("#anCountUp").html(data.onProportion);
					 $("#momCount").html(data.momMonthCreateSign);
					 $("#momCountDown").html(data.momProportion); 
					 if(data.onMonthCreateSign>0){
					 	$("#onSpan").removeClass("down").addClass("up");
					 }else{
					 	$("#onSpan").removeClass("up").addClass("down");
					 }
					 if(data.momMonthCreateSign>0){
					 	$("#momSpan").removeClass("down").addClass("up");
					 }else{
					 	$("#momSpan").removeClass("up").addClass("down");
					 }
				  }
			}
		});
		return getPieCharMap(basesicType,detailType,subType);
		
}

//根据id获得数据库字典项并设值formatter内容值 
function getPropertyInfoByID(typeID){
	$.ajax({
		async: false,
		type: "GET",
		url: "/sysadmin/propertyManage/getPropertyDictById.action",
		data:{"propertyDict.id":typeID},
		success:function(responseData){
			nameValue = responseData.displayName;
		}
	});
}

//根据任务类别设置地图formatter内容
function getNameByType(basesicType,detailType,subType){
	var reg = new RegExp("^[0-9]*$");//正则表达式只为数字
	if(basesicType != "" && basesicType != undefined){//主任务类别不为空
		if(detailType != undefined){//子任务类别不为undefined(因为详细类别有值的情况、子类别会为空，所以在这里不判断子类别为空)
			if(subType != "" && subType != undefined && subType != "map"){//详细任务类别不为空(为了作返回按钮跳转设值为map)
				if(reg.test(subType)){
					getPropertyInfoByID(subType);//判断是否是数字，是数字调用后台根据id获得数据库字典项内容
				}
				return;
			}
			if(detailType != ""){//子任务类别不能为空
				if(reg.test(detailType)){
					getPropertyInfoByID(detailType);//判断是否是数字，是数字调用后台根据id获得数据库字典项内容
				}else{
					if(detailType == "c_exceptionalSituationRecord"){//异常情况
						nameValue = "异常情况";
					}else if(detailType == "b_workingSituation"){//民警带领下开展工作
						nameValue = "民警带领下开展工作";
					}else{//宣传,核查
						nameValue = "宣传核查";
					}
				}
				return;
			}
		}
		if(basesicType == "a_floating"){//流动人口
		 	nameValue = "流动人口";
	 	}else if(basesicType == "special"){//特殊人群
	 		nameValue = "特殊人群";
	 	}else if(basesicType == "f_hiddendanger"){//发现治安隐患
	 		nameValue = "发现治安隐患";
	 	}else if(basesicType == "e_positiveInfoRecord"){//刑释人员
			nameValue = "刑释人员";
		}else if(basesicType == "d_termerRecord"){//社区服刑人员
			nameValue = "社区服刑人员";
		}else if(basesicType == "c_mentalPatientTask"){//严重精神病障碍患者
			nameValue = "严重精神病障碍患者";
		}else{//吸毒人员
			nameValue = "吸毒人员";
		}
	}
}

function getNeedData(){
		if(organizationName == '中国'){
			organizationName="四川省";
		}
		$.ajax({
		async: false,
		url:'/plugin/statistics/generalSituationManage/geTaskListMapStatistics.action?taskListStatisticsVo.isSegin='+signType+'&taskListStatisticsVo.searchDateType='+searchDateType+'&taskListStatisticsVo.year='+year+'&taskListStatisticsVo.month='+month+'&taskListStatisticsVo.quarter='+quarter+'&taskListStatisticsVo.yearType='+yearType+'&taskListStatisticsVo.basesicType=pandect&taskListStatisticsVo.orgName='+organizationName,
		success:function(data){
				if(data!=null){
				 	 $("#orgNameMap").html(data.organization.orgName);
					 $("#signCount").html(data.monthCreateSign);    
					 $("#anCount").html(data.onMonthCreateSign);
					 $("#anCountUp").html(data.onProportion);
					 $("#momCount").html(data.momMonthCreateSign);
					 $("#momCountDown").html(data.momProportion); 
					 if(data.onMonthCreateSign>0){
					 	$("#onSpan").removeClass("down").addClass("up");
					 }else{
					 	$("#onSpan").removeClass("up").addClass("down");
					 }
					 if(data.momMonthCreateSign>0){
					 	$("#momSpan").removeClass("down").addClass("up");
					 }else{
					 	$("#momSpan").removeClass("up").addClass("down");
					 }
				  }
			}
		});
		
		getPieCharMap("pandect","","");
}
function getExceptionType(){
	$.ajax({
		async: false,
		type: "GET",
		url: "/sysadmin/propertyManage/findPropertyDictByDomainName.action",
		data:{"propertyDomain.domainName":"宣传核查异常情况"},
		success:function(responseData){
			var checkValue = "";
			for(var i = 0;i<responseData.length;i++){
				checkValue+='<a href="javascript:changeType('+"\'a_floating\'"+','+"\'c_exceptionalSituationRecord\'"+','+responseData[i].id+');" class="itemB" subType="'+responseData[i].id+'">'+responseData[i].displayName+'</a>';
			}
			$("#exceptionType").append(checkValue);
		}
	});
}
function getPoliceType(){
$.ajax({
		async: false,
		type: "GET",
		url: "/sysadmin/propertyManage/findPropertyDictByDomainName.action",
		data:{"propertyDomain.domainName":"民警带领下工作内容"},
		success:function(responseData){
			var checkValue = "";
			for(var i = 0;i<responseData.length;i++){
				checkValue+='<a href="javascript:changeType('+"\'a_floating\'"+','+"\'b_workingSituation\'"+','+responseData[i].id+');" class="itemB" subType="'+responseData[i].id+'">'+responseData[i].displayName+'</a>';
			}
			$("#policeType").append(checkValue);
		}
	});
}
function getHiddengerType(){
$.ajax({
		async: false,
		type: "GET",
		url: "/sysadmin/propertyManage/findPropertyDictByDomainName.action",
		data:{"propertyDomain.domainName":"治安隐患异常类型"},
		success:function(responseData){
			var checkValue = "";
			for(var i = 0;i<responseData.length;i++){
				checkValue+='<li><a href="javascript:changeType('+"\'f_hiddendanger\'"+','+"\'f_hiddendanger\'"+','+responseData[i].id+');" class="itemA" subType="'+responseData[i].id+'">'+responseData[i].displayName+'</a></li>';
			}
			$("#hiddengerType").append(checkValue);
		}
	});
}

$(document).ready(function(){
	setTimeout(function(){
		var mHeight = $(".ui-layout-center").height()-$("#mCrumbs:visible").height()-78;
		$("#mainBody").height(mHeight);
	},100);
	
	getNeedData();
	getExceptionType();
	getPoliceType();
	getHiddengerType();
	$("#a_floating").click(function(){
		 changeType('a_floating','','');
	});
	
	$("#special").click(function(){
		 changeType('special','','');
	});
	
	$("#f_hiddendanger").click(function(){
		 changeType('f_hiddendanger','f_hiddendanger','');
	});
	
     setTimeout(function(){     
     	var itemHeight = $(".ui-layout-center").height() - $(".bottomTabs").height() - 80-60;
	     $("#hiddengerType").height(itemHeight);
     },100);
     
     $("#getTaskListTrend").click(function(){
     	$("#conditionDiv").createDialog({
		 			width: 800,
					height: 500,
					title:"",
					url:'/task/statistics/mapTrend.ftl',
					buttons: {
					   "关闭" : function(){
					        $(this).dialog("close");
					   }
		}
	 	
	 });
     });
     
     $("#setCondition").click(function(){
	     $("#conditionDiv").createDialog({
		 			width: 500,
					height: 180,
					title:"条件设置",
					url:'/task/statistics/mapCondition.ftl',
					buttons: {
						"确定" : function(event){
							if($('#report').attr('checked')){
								statusBySet = false;//记录上报状态
								signType=0;
								$("#changeType").html("上报");
							}else{
								signType=1;
								statusBySet = true;//记录签收状态
								$("#changeType").html("签收");
							}
							searchDateType=$("#timeColumn").val();
							if(searchDateType==0){
								year=$("#yearColumn").val();
								month =$("#monthColumn").val();
							}else if(searchDateType==1){
								year=$("#yearQuarterColumn").val();
								quarter=$("#quarterColumn").val();
							}else{
								year=$("#searchYearColumn").val();
								yearType=$("#yearType").val();
							}
					       $(this).dialog("close");
					       //getNeedData();
					       //getMapBySegin(0);
					   },
					   "关闭" : function(){
					        $(this).dialog("close");
					   }
		}
	 	
	 });
     });
});

function getPieCharMap(basesicType,detailType,subType){
		
	if(organizationName==''){
	   	organizationName="四川省";
	}
	//第一次加载防止饼图展现不完整加上延迟
	if(pieBoolean){
		setTimeout(function(){
			return $("#mapPieChart").pieMapChart({
				 url:"/plugin/statistics/generalSituationManage/getPieForMap.action?taskListStatisticsVo.situationType=0&taskListStatisticsVo.basesicType="+basesicType+"&taskListStatisticsVo.detailType="+detailType+"&taskListStatisticsVo.subType="+subType+"&taskListStatisticsVo.searchDateType="+searchDateType+"&taskListStatisticsVo.isSegin="+signType+"&taskListStatisticsVo.year="+year+"&taskListStatisticsVo.month="+month+"&taskListStatisticsVo.orgName="+organizationName,
				 moduleName:""
		    });	
		},100);
		pieBoolean = false;
	}else{
		//防止无法判断下层级是否有数据取消延迟
		return $("#mapPieChart").pieMapChart({
			 url:"/plugin/statistics/generalSituationManage/getPieForMap.action?taskListStatisticsVo.situationType=0&taskListStatisticsVo.basesicType="+basesicType+"&taskListStatisticsVo.detailType="+detailType+"&taskListStatisticsVo.subType="+subType+"&taskListStatisticsVo.searchDateType="+searchDateType+"&taskListStatisticsVo.isSegin="+signType+"&taskListStatisticsVo.year="+year+"&taskListStatisticsVo.month="+month+"&taskListStatisticsVo.orgName="+organizationName,
			 moduleName:""
	    });	
	}
	
}

//设置按钮修改地图数据
function getMapBySegin(val){
	var mapType = 1;
	var orgArray = organizationName.split(",");
	if(organizationName==''){
	   	organizationName="四川省";
	   	mapType = 0;
	}else if(organizationName == "四川省" || organizationName == "四川"){//如果是四川省重新刷新数据
		mapType = 0;
	}
	//alert(organizationName+"    "+option.series[0].mapType)
	var mapBaseType = "pandect";
	if(val == 1){//判断是否是任务类别点击事件
		if(basesicTypes != "" && basesicTypes != undefined){
			mapBaseType = basesicTypes;
		}
	}else if(val == 2 || val == 3){//判断是否是返回按钮的点击事件
		mapBaseType = "pandect";
		detailTypes = "";
		subTypes = "";
		mapType = 0;
		nameValue = "任务清单";
	}
	if(mapBaseType == "pandect"){
		nameValue = "任务清单";
	}
	if(mapByType == "true"){
		if(orgArray.length == 1){
			mapType = 0;
		}
	}
	//判断是否选中区域,未选中查询下级，选中查询本级
	if(orgArray[orgArray.length-1] == option.series[0].mapType){
		mapType = 0;
	}
	mapData.length = 0;//清空地图数据
	//markData.length = 0;//清空炫光特效数据
	var typeName = "";//定义地图上formatter内容
	if(signType == 0){
		typeName = nameValue+"上报数据";
	}else{
		typeName = nameValue+"签收数据";
	}
	
	//请求后台获得地图数据
	$.ajax({
		async: false,
		url: "/plugin/statistics/generalSituationManage/getMaxCreatSignOrgByType.action",
		data: {"taskListStatisticsVo.orgName":organizationName,"taskListStatisticsVo.year":year,"taskListStatisticsVo.month":month,"taskListStatisticsVo.basesicType":mapBaseType,"taskListStatisticsVo.isSegin":signType,"taskListStatisticsVo.searchDateType":searchDateType,"taskListStatisticsVo.detailType":detailTypes,"taskListStatisticsVo.subType":subTypes,"taskListStatisticsVo.mapTypeByOrg":mapType},
		success:function(responseData){
				if(responseData instanceof Array){
					var obj = {};
					var markObj = {};
					var maxNum = 200;
					for(var i = responseData.length-1;i >= 0;--i){
						var city = responseData[i].organization.orgName;
						var ranking = responseData[i].ranking;//排名
						var monthCreateSign = responseData[i].monthCreateSign;//总统计条数
						var onProportion = responseData[i].onProportion;//同比数据
						var momProportion = responseData[i].momProportion;//环比数据
						//排名前三，可能需要加地图标注，暂时未加
						if(ranking > 3){
							obj = {"name":city,"value":monthCreateSign,"tooltip":{"formatter":""+typeName+"</br>{b}:{c}</br>同比数据:"+onProportion+"</br>环比数据:"+momProportion+""}};
						}else if(ranking == 1){
							maxNum = monthCreateSign == 0 ? maxNum : monthCreateSign;
							obj = {"name":city,"value":monthCreateSign,"tooltip":{"formatter":""+typeName+"</br>{b}:{c}</br>同比数据:"+onProportion+"</br>环比数据:"+momProportion+""}};
							/*if(monthCreateSign != 0){
								markObj = {"name":city,"value":monthCreateSign,"itemStyle":{"normal":{"color":"red"}},"tooltip":{"formatter":"{a}</br>{b}:{c}</br>同比数据:"+onProportion+"</br>环比数据:"+momProportion+""}};
								markData.push(markObj);
							}*/
						}else if(ranking == 2){
							obj = {"name":city,"value":monthCreateSign,"tooltip":{"formatter":""+typeName+"</br>{b}:{c}</br>同比数据:"+onProportion+"</br>环比数据:"+momProportion+""}};
							/*if(monthCreateSign != 0){
								markObj = {"name":city,"value":monthCreateSign,"itemStyle":{"normal":{"color":"red"}},"tooltip":{"formatter":"{a}</br>{b}:{c}</br>同比数据:"+onProportion+"</br>环比数据:"+momProportion+""}};
								markData.push(markObj);
							}*/
						}else if(ranking == 3){
							obj = {"name":city,"value":monthCreateSign,"tooltip":{"formatter":""+typeName+"</br>{b}:{c}</br>同比数据:"+onProportion+"</br>环比数据:"+momProportion+""}};
							/*if(monthCreateSign != 0){
								markObj = {"name":city,"value":monthCreateSign,"itemStyle":{"normal":{"color":"red"}},"tooltip":{"formatter":"{a}</br>{b}:{c}</br>同比数据:"+onProportion+"</br>环比数据:"+momProportion+""}};
								markData.push(markObj);
							}*/
						}
						mapData.push(obj);
					}
					if(organizationName == "四川省"){
						option.series[0].mapType = "四川";
					}else{
						//返回到当前登录用户的组织机构
						if(val == 2){
							option.series[0].mapType = mapTypeToUserOrg;
						}
						//因为点击任务类别显示该层级的地图，不做下属地区跳转
						//option.series[0].mapType = organizationName;
					}
					option.dataRange.max = maxNum;
					myChart.restore();
					myChart.setOption(option,true);
				}else{
					$.messageBox({ 
						level: "error",
						message:responseData
		 			});
				}
		}
	});
}
</script>
<script src="/resource/judgmentAnalysis/js/echarts/chartMap.js"></script>

$.extend({
	desktopTips:function(message,time){
		if(message==undefined){message='提示信息';}
		if(time==undefined){time=2;}
		art.dialog.tips(message,time);
	},
	miniTools:function(o){
		var dfop={
			toolsData:[
				{id:'miniClock',title:'时钟',url:'/desktop/miniTools/clock.jsp',show:true},
				{id:'messagesList',title:'桌面消息',url:'/desktop/miniTools/messageList.jsp',show:true}
			]
		};
		$.extend(dfop,o);
		var toolsData=dfop.toolsData;
		var build=function(){
			for(var i in toolsData){
				if(toolsData.show==false){return false;}
				var $dom=$("<div />").addClass("desktopToolsBox").attr("id",toolsData[i].id).attr("title",toolsData[i].title);
				$dom.load(toolsData[i].url);
				$("#desktopTools").append($dom);
			}
		}
		build();
	},
	miniToolsDialog:function(o){
		var dfop={
			toolsData:[
				{id:'miniClock',title:'时钟',url:'/desktop/miniTools/clock.jsp',show:true},
				{id:'Notepad',title:'记事本',url:'/desktop/miniTools/Notepad.jsp',show:true},
				{id:'messagesList',title:'桌面消息',url:'/desktop/miniTools/messageList.jsp',show:true}
			]
		};
		$.extend(dfop,o);
		var toolsData=dfop.toolsData;
		var build=function(){
			for(var i in toolsData){
				var $dom=$("<li />").text(toolsData[i].title).data("toolsData",toolsData[i]);
				if(toolsData[i].show){
					$dom.attr("show","true");
				}
				else{
					$dom.attr("show","false");
				}
				$("#toolsBox ul").append($dom);
				$dom.on("click",function(){
					var thisData=$(this).data("toolsData");
					if($(this).attr("show")=="false"){
						var $thisDom=$("<div />").addClass("desktopToolsBox").attr("id",thisData.id).attr("title",thisData.title);
						$thisDom.load(thisData.url);
						$("#desktopTools").append($thisDom);
						$(this).attr("show",'true');
					}
					else{
						$("#"+thisData.id).remove();
						$(this).attr("show",'false');
					}
				})
			}
		}();
	},
	selectBg:function(o){//桌面皮肤自定义
		var img='/resource/desktop/images/skins/bg/';
		var dfop={
			bgData:[
				{title:'默认壁纸',imgUrl:'theme_default.jpg',bigImgUrl:'big/default.jpg'},
				{title:'青青草原',imgUrl:'theme_qingcao.jpg',bigImgUrl:'big/qingcao.jpg'},
				{title:'日出晨曦',imgUrl:'theme_richu.jpg',bigImgUrl:'big/richu.jpg'},
				{title:'日落黄昏',imgUrl:'theme_huanghun.jpg',bigImgUrl:'big/huanghun.jpg'},
				{title:'花盆',imgUrl:'theme_huapen.jpg',bigImgUrl:'big/huapen.jpg'},
				{title:'湖水',imgUrl:'theme_hushui.jpg',bigImgUrl:'big/hushui.jpg'},
				{title:'蒲公英',imgUrl:'theme_ktpugongying.jpg',bigImgUrl:'big/ktpugongying.jpg'},
				{title:'码头',imgUrl:'theme_mt.jpg',bigImgUrl:'big/mt.jpg'},
				{title:'草原羊群',imgUrl:'theme_muyang.jpg',bigImgUrl:'big/muyang.jpg'},
				{title:'雪山',imgUrl:'theme_xueshan.jpg',bigImgUrl:'big/xueshan.jpg'},
				{title:'蒲公英',imgUrl:'theme_pugongying.jpg',bigImgUrl:'big/pugongying.jpg'},
				{title:'水滴',imgUrl:'theme_sd.jpg',bigImgUrl:'big/sd.jpg'},
				{title:'麦田守望',imgUrl:'theme_maitian.jpg',bigImgUrl:'big/maitian.jpg'},
				{title:'水墨世界',imgUrl:'theme_shuimo.jpg',bigImgUrl:'big/shuimo.jpg'},
				{title:'情人节',imgUrl:'theme_tuoxie.jpg',bigImgUrl:'big/tuoxie.jpg'},
				{title:'梦幻光影',imgUrl:'theme_blue.jpg',bigImgUrl:'big/blue.jpg'},
				{title:'粉红之夜',imgUrl:'theme_pinky_night.jpg',bigImgUrl:'big/pinky_night.jpg'},
				{title:'酷车世界',imgUrl:'theme_car.jpg',bigImgUrl:'big/car.jpg'},
				{title:'温馨木纹',imgUrl:'theme_wood1.jpg',bigImgUrl:'big/wood1.jpg'},
				{title:'黑色木纹',imgUrl:'theme_wood2.jpg',bigImgUrl:'big/wood2.jpg'},
				{title:'神秘星际',imgUrl:'theme_universe.jpg',bigImgUrl:'big/universe.jpg'},
				{title:'酷炫金属',imgUrl:'theme_metal.jpg',bigImgUrl:'big/metal.jpg'},
				{title:'美女壁纸',imgUrl:'theme_meinv.jpg',bigImgUrl:'big/meinv.jpg'},
				{title:'绚烂繁花',imgUrl:'theme_pinky_flower.jpg',bigImgUrl:'big/pinky_flower.jpg'},
				{title:'76人',imgUrl:'theme_nba1.jpg',bigImgUrl:'big/nba/1.jpg'},
				{title:'魔术',imgUrl:'theme_nba2.jpg',bigImgUrl:'big/nba/2.jpg'},
				{title:'尼克斯',imgUrl:'theme_nba3.jpg',bigImgUrl:'big/nba/3.jpg'},
				{title:'热火',imgUrl:'theme_nba4.jpg',bigImgUrl:'big/nba/4.jpg'},
				{title:'小牛',imgUrl:'theme_nba5.jpg',bigImgUrl:'big/nba/5.jpg'},
				{title:'活塞',imgUrl:'theme_nba6.jpg',bigImgUrl:'big/nba/6.jpg'},
				{title:'爵士',imgUrl:'theme_nba7.jpg',bigImgUrl:'big/nba/7.jpg'},
				{title:'快船',imgUrl:'theme_nba8.jpg',bigImgUrl:'big/nba/8.jpg'},
				{title:'公牛',imgUrl:'theme_nba9.jpg',bigImgUrl:'big/nba/9.jpg'},
				{title:'火箭',imgUrl:'theme_nba10.jpg',bigImgUrl:'big/nba/10.jpg'},
				{title:'湖人',imgUrl:'theme_nba11.jpg',bigImgUrl:'big/nba/11.jpg'}
			],
			id:"selectSkinDlg",
		    title: '选择皮肤',
		    width:650,
		    height:400,
		    padding:0
		}
		$.extend(dfop,o);
		var bgurl=$.cookie("selectBg")?dfop.bgData[0].bigImgUrl:$.cookie("selectBg");
		var $thisCtt=$("<ul />").addClass("skinList");
		for(var i in dfop.bgData){
			$thisImg=$('<img />').attr("src",img+dfop.bgData[i].imgUrl);
			$thisText=$('<a href="javascript:;"></a>').text(dfop.bgData[i].title);
			$thisSkin=$('<li />').append($thisImg).append($thisText).attr("bigUrl",img+dfop.bgData[i].bigImgUrl);
			$thisCtt.append($thisSkin);
			$thisSkin.on("click",function(){
				$("#wallpaper").attr("src",$(this).attr("bigUrl"));
				$.cookie("selectBg",$(this).attr("bigUrl"), { path: '/', expires: 10 });
			})
		}
		var thisDialog=art.dialog(dfop);
		$.ajax({
			url:'/desktop/system/bgSelect.jsp',
			success:function(data){
				thisDialog.content(data);
				$("#skinListBox").append($thisCtt[0]);
			}
		})
	},
	deskDialog:function(o){//公共dialog组件
		var dlgWidth=document.documentElement.clientWidth;
		var dlgHeight=document.documentElement.clientHeight;
		var dfop={
			width:800,
			height:470,
			padding: '0 0',
			top:0,
			init:function(){
				var that=this;
				that.DOM.titleBar.find(".aui_close").before(min).before(max).before(restore);//插入按钮
				min.on("click",function(){//min方法
					thisDom.attr("dlgshow","false");
					that.hide();
				})
				max.on("click",function(){//max方法
					that.width=$(that.DOM.border).width();
					that.height=$(that.DOM.border).height();
					that.size(document.documentElement.clientWidth,document.documentElement.clientHeight-85);
					$(".aui_state_focus").width(document.documentElement.clientWidth);
					that.position(0,0);
					restore.show();
					max.hide();
				})
				restore.on("click",function(){//还原方法
					that.size(that.width,that.height);
					that.position("50%",'50%');
					restore.hide();
					max.show();
				})
				if(dfop.max){//参数max如果为真。则全屏
					max.click();
				}
				if(o.init!=undefined){
					o.init();
				}
			},
			close:function(){//关闭方法
				thisDom.remove();
				min.remove();
				max.remove();
				restore.remove();
			}
		};
		$.extend(dfop,o);
		var thisDom=$('<li id="dock'+dfop.id+'"> <a href="javascript:;">'+dfop.title+'</a></li>');
		var min=$('<a class="aui_min" href="javascript:;" title="缩小到任务栏">缩小到任务栏</a>');
		var max=$('<a class="aui_max" href="javascript:;" title="全屏">全屏</a>');
		var restore=$('<a class="aui_restore" href="javascript:;" title="还原" style="display:none;">还原</a>');
		if(o.close!=undefined){
			dfop.close=function(){
				thisDom.remove();
				min.remove();
				max.remove();
				restore.remove();
				o.close();
			}
		}
		if(dfop.id==undefined){
			dfop.id=new Date().getTime();
		}
		thisDom.on("click",function(){
			if(thisDom.attr("dlgshow")=="false"){
				$(this).addClass("selectCur").siblings().removeClass("selectCur");
				thisDialog.show();
				$(this).attr("dlgshow","true");
			}
			else{
				$(this).removeClass("selectCur");
				thisDialog.hide();
				$(this).attr("dlgshow","false");
			}
		})
		if(!$("#dock"+dfop.id)[0]){
			$("#bar_bottom #dock").append(thisDom);
		}
		var thisDialog;
		if(dfop.url!=undefined){
			if(dfop.iframe==true){
				thisDialog=art.dialog.open(dfop.url,dfop);
			}else{
				$.ajax({
					url: dfop.url, 
					success: function(html){
						thisDialog = art.dialog(dfop);
				    	thisDialog.content(html);
				    	return thisDialog;
					}
				});
			}
		}
		if(dfop.url==undefined){
			thisDialog=art.dialog(dfop);
		}
		return thisDialog;
	},
	sysDialog:function(o){//无最大化最小化dialog组件
		var dlgWidth=document.documentElement.clientWidth;
		var dlgHeight=document.documentElement.clientHeight-100;
		var dfop={
			width:800,
			height:470,
			padding: '0 0',
			init:function(){
			},
			close:function(){//关闭方法
				
			}
		};
		$.extend(dfop,o);
		if(dfop.id==undefined){
			dfop.id=new Date().getTime();
		}
		var thisDialog;
		if(dfop.url!=undefined){
			if(dfop.iframe==true){
				thisDialog=art.dialog.open(dfop.url,dfop);
			}else{
				$.ajax({
					url: dfop.url,
					success: function(html){
						thisDialog = art.dialog(dfop);
				    	thisDialog.content(html);
				    	return thisDialog;
					}
				});
			}
		}
		if(dfop.url==undefined){
			thisDialog=art.dialog(dfop);
		}
		return thisDialog;
	},
	addIconDlg:function(options){//添加应用窗口
		var dfop={
			id:'addIconDlg',
			title:'添加应用',
			img:'icon_add.png',
			url:'/desktop/system/addDesktopIcon.jsp',
			width:800,
			height:500,
			padding:0
		}
		$.extend(dfop,options);
		var thisDlg=art.dialog(dfop);
		$.ajax({
			url:dfop.url,
			success:function(html){
				thisDlg.content(html);
			},
			error:function(error){
				thisDlg.content(error);
			}
		})
	}
})
$.fn.extend({
	gisTabs:function(o){
		var self=$(this);
		var dfop={
			tabTemplate: "<li><a href='#{href}'>#{label}</a> <span class='ui-icon ui-icon-close'>删除</span></li>",
			add: function( event, ui ) {
				var tab_content ="加载中......";
				$(ui.panel).append( "<div>" + tab_content + "</div>" );
			}
		}
		$.extend(dfop,o);
		var $tabs = self.tabs(dfop);
		self.find("span.ui-icon-close").live( "click", function() {
			var index = $("li",$tabs).index( $( this ).parent());
			$tabs.tabs("remove", index);
		});
		return $tabs;
	},
	globalViewIcons:function(o){//全局视图图标
		var self=$(this);
		var imgPath='/resource/desktop/images/icons/';
		var dlgWidth=document.documentElement.clientWidth;
		var dlgHeight=document.documentElement.clientHeight-100;
		var dW='90%',dH='90%';
		var dfop={
			icos:[
				{id:11,title:'刑释人员',img:'positiveInfoManagement.png',url:'/desktop/module/module.jsp#positiveInfo',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:12,title:'社区矫正人员',img:'rectificativePersonManagement.png',url:'/desktop/module/module.jsp#rectify',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:13,title:'重点青少年',img:'idleYouthManagement.png',url:'/desktop/module/module.jsp#idleYouth',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:14,title:'严重精神障碍患者',img:'mentalPatientManagement.png',url:'/desktop/module/module.jsp#mentalPatient',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:15,title:'吸毒人员',img:'druggyManagement.png',url:'/desktop/module/module.jsp#druggyManage',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:16,title:'重点上访人员',img:'superiorVisitManagement.png',url:'/desktop/module/module.jsp#superiorVisit',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:17,title:'需要求助人员',img:'poorPeopleManagement.png',url:'/desktop/module/module.jsp#poorPeopleManage',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:18,title:'危险品从业人员',img:'dangerousGoodsPractitionerManagement.png',url:'/desktop/module/module.jsp#dangerousGoodsPractitioner',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:19,title:'其他人员',img:'otherAttentionPersonnelManagement.png',url:'/desktop/module/module.jsp#otherAttentionPersonnel',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:111,title:'境外人员',img:'overseaPersonManagement.png',url:'/desktop/module/module.jsp#overseaPersonnel',width:dW,height:dH,iframe:true,page:1,type:'people'},

				{id:3,title:'工作台帐',url:'/desktop/module/module.jsp#workingRecordMenu',img:'dailyLogManage.png',width:dW,height:dH,iframe:true,page:1,type:'thing'},
				{id:4,title:'服务办事',url:'/desktop/module/module.jsp#issue',img:'serviceWork.png',width:dW,height:dH,iframe:true,page:1,type:'thing'},
				{id:5,title:'研判分析',url:'/desktop/module/module.jsp#statAnalyse',img:'statAnalyseManage.png',width:dW,height:dH,iframe:true,page:1,type:'thing'},
				{id:6,title:'考核评估',url:'/desktop/module/module.jsp#evaluate',img:'evaluateManagement.png',width:dW,height:dH,iframe:true,page:1,type:'thing'},
				
				{id:21,title:'安全生产重点',img:'safetyProductionKeyManagement.png',url:'/desktop/module/module.jsp#safetyProduction',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:22,title:'消防安全重点',img:'fireSafetyKeyManagement.png',url:'/desktop/module/module.jsp#firePersonInCharge',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:23,title:'治安重点',img:'securityKeyManagement.png',url:'/desktop/module/module.jsp#personInCharge',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:24,title:'学校',img:'schoolManageMent.png',url:'/desktop/module/module.jsp#school',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:25,title:'其他场所',img:'otherLocaleManagement.png',url:'/desktop/module/module.jsp#otherLocale',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:26,title:'出租房',img:'lettingHouseManagement.png',url:'/desktop/module/module.jsp#lettingHouse',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:27,title:'规上企业',img:'enterpriseManagement.png',url:'/desktop/module/module.jsp#enterprise',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:28,title:'社会组织',img:'newSocietyFederationManagement.png',url:'/desktop/module/module.jsp#newSocietyFederations',width:dW,height:dH,iframe:true,page:1,type:'organization'},
				
				{id:4,title:'物品管理',url:'/desktop/module/module.jsp#issue',img:'物品管理.png',width:dW,height:dH,iframe:true,page:1,type:'goods'},
				
				{id:8,title:'舆情管理',url:'/desktop/module/module.jsp#issue',img:'物品管理.png',width:dW,height:dH,iframe:true,page:1,type:'situation'}
				
			]
		}
		$.extend(dfop,o);
		var icos=dfop.icos;
		function build(thisIcos){//构建图标
			var $imgSrc;
			var $tLink;
			var thisIcon=thisIcos;
			
			if(thisIcon.id==undefined){
				thisIcon.id=i;
			}
			$imgSrc=$('<img />').attr("src",imgPath+thisIcon.img);
			$tLink=$('<a href="javascript:;"></a>').text(thisIcon.title).attr("iconid",thisIcon.id).prepend($imgSrc).addClass("icon").data("option",thisIcon);
			$tLink.on("click",function(){
				var thisOption={width:dlgWidth,height:dlgHeight};
				$.extend(thisOption,$(this).data("option"));
				$.deskDialog(thisOption);
			})
			$("#global_type_"+thisIcon.type).append($tLink);
		}
		for(var i in icos){//遍历图标
			if(typeof(icos[i])=='string'){
				build(icos);
			}
			else{
				build(icos[i]);
			}
		};
	},
	addDesktopIcons:function(o){//添加窗口
		var self=$(this);
		var imgPath='/resource/desktop/images/icons/';
		var dlgWidth=document.documentElement.clientWidth;
		var dlgHeight=document.documentElement.clientHeight-100;
		var dW='90%',dH='90%';
		var dfop={
			icos:[
				{id:11,title:'刑释人员',img:'positiveInfoManagement.png',url:'/desktop/module/module.jsp#positiveInfo',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:12,title:'社区矫正人员',img:'rectificativePersonManagement.png',url:'/desktop/module/module.jsp#rectify',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:13,title:'重点青少年',img:'idleYouthManagement.png',url:'/desktop/module/module.jsp#idleYouth',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:14,title:'严重精神障碍患者',img:'mentalPatientManagement.png',url:'/desktop/module/module.jsp#mentalPatient',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:15,title:'吸毒人员',img:'druggyManagement.png',url:'/desktop/module/module.jsp#druggyManage',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:16,title:'重点上访人员',img:'superiorVisitManagement.png',url:'/desktop/module/module.jsp#superiorVisit',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:17,title:'需要求助人员',img:'poorPeopleManagement.png',url:'/desktop/module/module.jsp#poorPeopleManage',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:18,title:'危险品从业人员',img:'dangerousGoodsPractitionerManagement.png',url:'/desktop/module/module.jsp#dangerousGoodsPractitioner',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:19,title:'其他人员',img:'otherAttentionPersonnelManagement.png',url:'/desktop/module/module.jsp#otherAttentionPersonnel',width:dW,height:dH,iframe:true,page:1,type:'people'},
				{id:111,title:'境外人员',img:'overseaPersonManagement.png',url:'/desktop/module/module.jsp#overseaPersonnel',width:dW,height:dH,iframe:true,page:1,type:'people'},

				{id:3,title:'工作台帐',url:'/desktop/module/module.jsp#workingRecordMenu',img:'dailyLogManage.png',width:dW,height:dH,iframe:true,page:1,type:'thing'},
				{id:4,title:'服务办事',url:'/desktop/module/module.jsp#issue',img:'serviceWork.png',width:dW,height:dH,iframe:true,page:1,type:'thing'},
				{id:5,title:'研判分析',url:'/desktop/module/module.jsp#statAnalyse',img:'statAnalyseManage.png',width:dW,height:dH,iframe:true,page:1,type:'thing'},
				{id:6,title:'考核评估',url:'/desktop/module/module.jsp#evaluate',img:'evaluateManagement.png',width:dW,height:dH,iframe:true,page:1,type:'thing'},
				
				{id:21,title:'安全生产重点',img:'safetyProductionKeyManagement.png',url:'/desktop/module/module.jsp#safetyProduction',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:22,title:'消防安全重点',img:'fireSafetyKeyManagement.png',url:'/desktop/module/module.jsp#firePersonInCharge',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:23,title:'治安重点',img:'securityKeyManagement.png',url:'/desktop/module/module.jsp#personInCharge',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:24,title:'学校',img:'schoolManageMent.png',url:'/desktop/module/module.jsp#school',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:25,title:'其他场所',img:'otherLocaleManagement.png',url:'/desktop/module/module.jsp#otherLocale',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:26,title:'出租房',img:'lettingHouseManagement.png',url:'/desktop/module/module.jsp#lettingHouse',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:27,title:'规上企业',img:'enterpriseManagement.png',url:'/desktop/module/module.jsp#enterprise',width:dW,height:dH,iframe:true,page:1,type:'place'},
				{id:28,title:'社会组织',img:'newSocietyFederationManagement.png',url:'/desktop/module/module.jsp#newSocietyFederations',width:dW,height:dH,iframe:true,page:1,type:'organization'},
				
				{id:4,title:'物品管理',url:'/desktop/module/module.jsp#issue',img:'物品管理.png',width:dW,height:dH,iframe:true,page:1,type:'goods'}
				
			]
		}
		$.extend(dfop,o);
		var icos=dfop.icos;
		var $people=$("<div />").addClass("clearfix").attr("id","people");
		var $thing=$("<div />").addClass("clearfix").attr("id","thing");
		var $place=$("<div />").addClass("clearfix").attr("id","place");
		var $goods=$("<div />").addClass("clearfix").attr("id","goods");
		var $organization=$("<div />").addClass("clearfix").attr("id","organization");
		
		function build(thisIcos){//构建图标
			var $imgSrc;
			var $tLink;
			var thisIcon=thisIcos;
			
			if(thisIcon.id==undefined){
				thisIcon.id=i;
			}
			$imgSrc=$('<img />').attr("src",imgPath+thisIcon.img);
			$tLink=$('<a href="javascript:;"></a>').text(thisIcon.title).attr("iconid",thisIcon.id).prepend($imgSrc).addClass("icon").data("option",thisIcon);
			$tLink.on("click",function(){
				var thisOption={width:dlgWidth,height:dlgHeight};
				$.extend(thisOption,$(this).data("option"));
				$.deskDialog(thisOption);
			})
			switch (thisIcos.type){
				case 'people':
					if(!self.find("#people")[0]){
						self.append("<h1>人员管理</h1>").append($people);
					}
					$people.append($tLink);
					break;
				case 'place':
					if(!self.find("#place")[0]){
						self.append("<h1>场所管理</h1>").append($place);
					}
					$place.append($tLink);
					break;
				case 'goods':
					if(!self.find("#goods")[0]){
						self.append("<h1>物品管理</h1>").append($goods);
					}
					$goods.append($tLink);
					break;
				case 'thing':
					if(!self.find("#thing")[0]){
						self.append("<h1>事件处理</h1>").append($thing);
					}
					$thing.append($tLink);
					break;
				case 'organization':
					if(!self.find("#organization")[0]){
						self.append("<h1>组织管理</h1>").append($organization);
					}
					$organization.append($tLink);
					break;
			}
		}
		for(var i in icos){//遍历图标
			if(typeof(icos[i])=='string'){
				build(icos);
			}
			else{
				build(icos[i]);
			}
		};
	},
	desktopRight:function(o){//右键菜单
		var self=$(this);
		var dfop={
			addFold:function(){
				
			}
		}
		$.extend(dfop,o);
		
	},
	initicos:function(options){
		var self=$(this);
		var that=this;
		var dlgWidth=document.documentElement.clientWidth;
		var dlgHeight=document.documentElement.clientHeight;
		var dW='95%',dH='95%';
		var icoTime;
		var imgPath='/resource/desktop/images/icons/';
		var dfop={
			url:'',
			icos:[
			/*{id:1,title:'人员管理',url:'/desktop/system/addDesktopIcon.jsp',width:dW,height:550,page:2,children:[
				{id:11,title:'刑释人员',img:'positiveInfoManagement.png',url:'/desktop/module/module.jsp#positiveInfo',width:dW,height:dH,iframe:true,page:2,index:1},
				{id:12,title:'社区矫正人员',img:'rectificativePersonManagement.png',url:'/desktop/module/module.jsp#rectify',width:dW,height:dH,iframe:true,page:2},
				{id:13,title:'重点青少年',img:'idleYouthManagement.png',url:'/desktop/module/module.jsp#idleYouth',width:dW,height:dH,iframe:true,page:2},
				{id:14,title:'严重精神障碍患者',img:'mentalPatientManagement.png',url:'/desktop/module/module.jsp#mentalPatient',width:dW,height:dH,iframe:true,page:2},
				{id:15,title:'吸毒人员',img:'druggyManagement.png',url:'/desktop/module/module.jsp#druggyManage',width:dW,height:dH,iframe:true,page:2},
				{id:16,title:'重点上访人员',img:'superiorVisitManagement.png',url:'/desktop/module/module.jsp#superiorVisit',width:dW,height:dH,iframe:true,page:2},
				{id:17,title:'需要求助人员',img:'poorPeopleManagement.png',url:'/desktop/module/module.jsp#poorPeopleManage',width:dW,height:dH,iframe:true,page:2},
				{id:18,title:'危险品从业人员',img:'dangerousGoodsPractitionerManagement.png',url:'/desktop/module/module.jsp#dangerousGoodsPractitioner',width:dW,height:dH,iframe:true,page:2},
				{id:19,title:'其他人员',img:'otherAttentionPersonnelManagement.png',url:'/desktop/module/module.jsp#otherAttentionPersonnel',width:dW,height:dH,iframe:true,page:2},
				{id:111,title:'境外人员',img:'overseaPersonManagement.png',url:'/desktop/module/module.jsp#overseaPersonnel',width:dW,height:dH,iframe:true,page:2}
			]},
			{id:2,title:'场所管理',url:'/desktop/system/addDesktopIcon.jsp',width:800,height:550,page:2,children:[
				{id:21,title:'安全生产重点',img:'safetyProductionKeyManagement.png',url:'/desktop/module/module.jsp#safetyProduction',width:dW,height:dH,iframe:true,page:2},
				{id:22,title:'消防安全重点',img:'fireSafetyKeyManagement.png',url:'/desktop/module/module.jsp#firePersonInCharge',width:dW,height:dH,iframe:true,page:2},
				{id:23,title:'治安重点',img:'securityKeyManagement.png',url:'/desktop/module/module.jsp#personInCharge',width:dW,height:dH,iframe:true,page:2},
				{id:24,title:'学校',img:'schoolManageMent.png',url:'/desktop/module/module.jsp#school',width:dW,height:dH,iframe:true,page:2},
				{id:25,title:'其他场所',img:'otherLocaleManagement.png',url:'/desktop/module/module.jsp#otherLocale',width:dW,height:dH,iframe:true,page:2},
				{id:26,title:'出租房',img:'lettingHouseManagement.png',url:'/desktop/module/module.jsp#lettingHouse',width:dW,height:dH,iframe:true,page:2},
				{id:27,title:'规上企业',img:'enterpriseManagement.png',url:'/desktop/module/module.jsp#enterprise',width:dW,height:dH,iframe:true,page:2},
				{id:28,title:'社会组织',img:'newSocietyFederationManagement.png',url:'/desktop/module/module.jsp#newSocietyFederations',width:dW,height:dH,iframe:true,page:2}
			]},
			
			{id:3,title:'工作台帐',url:'/desktop/system/addDesktopIcon.jsp',width:dW,height:550,children:[
				{id:21,title:'我的台帐',img:'2.png',url:'/desktop/module/container.jsp#myDailyLogConfig',width:dW,height:dH,iframe:true},
				{id:32,title:'辖区台账上报情况',img:'3.png',url:'/desktop/module/container.jsp#areaDailyLogSubInfo',width:dW,height:dH,iframe:true},
				{id:33,title:'辖区台帐',img:'3.png',url:'/desktop/module/module.jsp#myAreaWorkingRecords',width:dW,height:dH,iframe:true},
				{id:34,title:'辖区目录管理',img:'3.png',url:'/desktop/module/container.jsp#areaDirectoryManage',width:dW,height:dH,iframe:true},
				{id:35,title:'工作日志',img:'3.png',url:'/desktop/module/container.jsp#workDiaryManagement',width:dW,height:dH,iframe:true}
			]},
			{id:4,title:'服务办事',url:'/desktop/system/addDesktopIcon.jsp',width:dW,height:550,children:[
				{id:41,title:'事件处理',img:'2.png',url:'/desktop/module/module.jsp#issueManage',width:dW,height:dH,iframe:true},
				{id:42,title:'历史遗留',img:'3.png',url:'/desktop/module/module.jsp#historical',width:dW,height:dH,iframe:true},
				{id:43,title:'宣传案例',img:'3.png',url:'/desktop/module/module.jsp#publicltyCass',width:dW,height:dH,iframe:true},
				{id:44,title:'下辖事项',img:'3.png',url:'/desktop/module/module.jsp#jurisdictionsIssue',width:dW,height:dH,iframe:true}
			]},
			{id:5,title:'研判分析',url:'/desktop/system/addDesktopIcon.jsp',width:dW,height:550,children:[
				{id:51,title:'刑释人员',img:'2.png',url:'/desktop/module/module.jsp#positiveInfo',width:dW,height:dH,iframe:true},
				{id:52,title:'社区矫正人员',img:'3.png',url:'/desktop/module/module.jsp#rectify',width:dW,height:dH,iframe:true}
			]},
			{id:6,title:'考核评估',url:'/desktop/system/addDesktopIcon.jsp',width:dW,height:550,children:[
				{id:61,title:'刑释人员',img:'2.png',url:'/desktop/module/module.jsp#positiveInfo',width:dW,height:dH,iframe:true},
				{id:62,title:'社区矫正人员',img:'3.png',url:'/desktop/module/module.jsp#rectify',width:dW,height:dH,iframe:true}
			]},
			{id:7,title:'互动交流',url:'/desktop/system/addDesktopIcon.jsp',width:dW,height:550,children:[
				{id:71,title:'刑释人员',img:'2.png',url:'/desktop/module/module.jsp#positiveInfo',width:dW,height:dH,iframe:true},
				{id:72,title:'社区矫正人员',img:'3.png',url:'/desktop/module/module.jsp#rectify',width:dW,height:dH,iframe:true}
			]},
			{id:1112,title:'流动人口',img:'positiveInfoManagement.png',url:'/desktop/module/module.jsp#floatingPopulation',width:dW,height:dH,iframe:true,page:1,index:1},
			{id:1113,title:'户籍人口',img:'householdStaffManagement.png',url:'/desktop/module/module.jsp#householdStaff',width:dW,height:dH,iframe:true,page:1,index:1},
			{id:1114,title:'未落户人口',img:'unsettledPopulation.png',url:'/desktop/module/module.jsp#unsettledPopulation',width:dW,height:dH,iframe:true,page:1,index:1},
			
			{id:1115,title:'困难群众',img:'unsettledPopulation.png',url:'/desktop/module/module.jsp#unsettledPopulation',width:dW,height:dH,iframe:true,page:1,index:1},
			{id:1116,title:'老年人',img:'elderlyPeopleManagement.png',url:'/desktop/module/module.jsp#elderlyPeople',width:dW,height:dH,iframe:true,page:1,index:1},
			{id:1117,title:'残疾人',img:'handicappedManagement.png',url:'/desktop/module/module.jsp#handicapped',width:dW,height:dH,iframe:true,page:1,index:1},
			{id:1118,title:'优抚对象',img:'specialCareGroupsManagement.png',url:'/desktop/module/module.jsp#specialCareGroups',width:dW,height:dH,iframe:true,page:1,index:1},
			
			{id:1119,title:'育妇',img:'birthManagement.png',url:'/desktop/module/module.jsp#birth',width:dW,height:dH,iframe:true,page:1,index:1},
			
			{id:1111,title:'刑释人员',img:'positiveInfoManagement.png',url:'/desktop/module/module.jsp#positiveInfo',width:dW,height:dH,iframe:true,page:1,index:1},
			{id:1211,title:'社区矫正人员',img:'rectificativePersonManagement.png',url:'/desktop/module/module.jsp#rectify',width:dW,height:dH,iframe:true,page:1},
			{id:1311,title:'重点青少年',img:'idleYouthManagement.png',url:'/desktop/module/module.jsp#idleYouth',width:dW,height:dH,iframe:true,page:1},
			{id:1411,title:'严重精神障碍患者',img:'mentalPatientManagement.png',url:'/desktop/module/module.jsp#mentalPatient',width:dW,height:dH,iframe:true,page:1},
			{id:1511,title:'吸毒人员',img:'druggyManagement.png',url:'/desktop/module/module.jsp#druggyManage',width:dW,height:dH,iframe:true,page:1},
			{id:1611,title:'重点上访人员',img:'superiorVisitManagement.png',url:'/desktop/module/module.jsp#superiorVisit',width:dW,height:dH,iframe:true,page:1},
			{id:1711,title:'需要求助人员',img:'poorPeopleManagement.png',url:'/desktop/module/module.jsp#poorPeopleManage',width:dW,height:dH,iframe:true,page:1},
			{id:1811,title:'危险品从业人员',img:'dangerousGoodsPractitionerManagement.png',url:'/desktop/module/module.jsp#dangerousGoodsPractitioner',width:dW,height:dH,iframe:true,page:1},
			{id:1911,title:'其他人员',img:'otherAttentionPersonnelManagement.png',url:'/desktop/module/module.jsp#otherAttentionPersonnel',width:dW,height:dH,iframe:true,page:1},
			{id:11111,title:'境外人员',img:'overseaPersonManagement.png',url:'/desktop/module/module.jsp#overseaPersonnel',width:dW,height:dH,iframe:true,page:1},
			
			{id:2111,title:'安全生产重点',img:'safetyProductionKeyManagement.png',url:'/desktop/module/module.jsp#safetyProduction',width:dW,height:dH,iframe:true,page:1},
			{id:2211,title:'消防安全重点',img:'fireSafetyKeyManagement.png',url:'/desktop/module/module.jsp#firePersonInCharge',width:dW,height:dH,iframe:true,page:1},
			{id:2311,title:'治安重点',img:'securityKeyManagement.png',url:'/desktop/module/module.jsp#personInCharge',width:dW,height:dH,iframe:true,page:1},
			{id:2411,title:'学校',img:'schoolManageMent.png',url:'/desktop/module/module.jsp#school',width:dW,height:dH,iframe:true,page:1},
			{id:2511,title:'其他场所',img:'otherLocaleManagement.png',url:'/desktop/module/module.jsp#otherLocale',width:dW,height:dH,iframe:true,page:1},
			{id:2611,title:'出租房',img:'lettingHouseManagement.png',url:'/desktop/module/module.jsp#lettingHouse',width:dW,height:dH,iframe:true,page:1},
			{id:2711,title:'规上企业',img:'enterpriseManagement.png',url:'/desktop/module/module.jsp#enterprise',width:dW,height:dH,iframe:true,page:1},
			{id:2811,title:'社会组织',img:'newSocietyFederationManagement.png',url:'/desktop/module/module.jsp#newSocietyFederations',width:dW,height:dH,iframe:true,page:1},
			
			{id:3,title:'工作台帐',url:'/desktop/module/module.jsp#workingRecordMenu',img:'dailyLogManage.png',width:dW,height:dH,iframe:true,page:1},
			{id:4,title:'服务办事',url:'/desktop/module/module.jsp#issue',img:'serviceWork.png',width:dW,height:dH,iframe:true,page:1},
			{id:5,title:'研判分析',url:'/desktop/module/module.jsp#statAnalyse',img:'statAnalyseManage.png',width:dW,height:dH,iframe:true,page:1},
			{id:6,title:'考核评估',url:'/desktop/module/module.jsp#evaluate',img:'evaluateManagement.png',width:dW,height:dH,iframe:true,page:1},
			{id:7,title:'互动交流',url:'/desktop/module/module.jsp#interactionManagement',img:'interactionManagement.png',width:dW,height:dH,iframe:true,page:1},
			{id:8,title:'系统管理',url:'/desktop/module/module.jsp#systemManagement',img:'systemManagement.png',width:dW,height:dH,iframe:true,page:1}
			*/
		]};
		$.extend(dfop,options);
		var deskMenuData = [
			[{
				text: "打开",
				func: function() {
					var thisOption={width:dlgWidth,height:dlgHeight};
					$.extend(thisOption,$(this).data("option"));
					if(thisOption.url != undefined && thisOption.openDlg != false){
						$.deskDialog(thisOption);
					}
				}
			}],
			[{
				text: "移动到",
				func:function(){
					
				},
				data: [[{
					text: "桌面1",
					func: function() {
						$.ajax({
							url:dfop.url,
							success:function(){
								$("#addIcon1").before($(this));
								pagePosition();						
							}
						});
					}
				}, {
					text: "桌面2",
					func: function() {
						$("#addIcon2").before($(this));
						pagePosition();
					}
				}, {
					text: "桌面3",
					func: function() {
						$("#addIcon3").before($(this));
						pagePosition();
					}
				}]]
			}, {
				text: "一级菜单",
				func: function() {
					
				}
			}],
			[{
				text: "删除",
				func: function() {
					if($("#childrenBox"+$(this).attr("iconid")).find("a")[0]){
						alert('文件夹不为空，不得删除')
						return false;
					}
					$(this).remove();
					position($(this).attr("page"));
				}
			}]
		];
		var position=function(page){//计算图标的top left值
			clearTimeout(icoTime);
			var docWidth=document.documentElement.clientWidth;
			var docHeight=document.documentElement.clientHeight-320;
			var icoWidth=84;
			var icoHeight=120;
			var icoFlag=0,icoLeft=0,flag=0;
			$("#desktop"+page).children("a.icon").each(function(i){
				var thisTop=icoHeight*icoFlag;
				var thisLeft=icoWidth*flag;
				$(this).css({top:thisTop,left:thisLeft});
				icoFlag++;
				if(thisTop>docHeight){
					flag++;
					icoFlag=0;
				}
			})
		}
		var init=function(icos){
			var build=function(thisIcon){//构建图标
				var $imgSrc;
				var $tLink;
				var thisIcon=thisIcon;
				
				if(thisIcon.id==undefined){
					thisIcon.id=i;
				}
				if(thisIcon.children!=undefined){//children不为空
					$imgSrc=$('<img />').attr("src",imgPath+'folder_o.png');//构建文件夹图标
					$tLink=$('<a href="javascript:;"></a>').text(thisIcon.title).attr("iconid",thisIcon.id).attr("page",thisIcon.page).prepend($imgSrc).addClass("abs icon folder").data("option",thisIcon);
					var childrenBox=$("<div />").addClass("childrenBox").attr("id","childrenBox"+thisIcon.id);
					var childrenBoxContent=$("<div />").addClass("childrenBoxContext").append('<div class="childrenBoxC_r"></div>');//容器
					if(thisIcon.children!=''){
						for(var j in thisIcon.children){//文件夹中的内容
							var cthisIcon=icos[i].children[j];
							var $cImgSrc=$('<img />').attr("src",imgPath+cthisIcon.img);
							var $cIcos=$('<a href="javascript:;"></a>').text(cthisIcon.title).attr("iconid",cthisIcon.id).attr("page",cthisIcon.page).prepend($cImgSrc).addClass("icon").data("option",cthisIcon);
							childrenBoxContent.append($cIcos);//添加图标到子菜单
							$cIcos.on("click",function(){
								var thisOption={width:dlgWidth,height:dlgHeight};
								$.extend(thisOption,$(this).data("option"));
								$.deskDialog(thisOption);
							})
							$cIcos.smartMenu(deskMenuData, {//右键菜单
								name: "menu"+i+'_'+j  
							});
							$cIcos.domDraggable({//拖动事件 到desktop容器
								appendTo: "body",
								helper: "clone"
							});
							$("#desktop"+thisIcon.page).domDroppable({//文件夹拖出事件
								drop: function(event,ui) {
									$("#addIcon"+thisIcon.page).before($(ui.draggable).addClass("abs"));
									position(thisIcon.page);
								}
							});
						}
					}
					$("#desktop"+thisIcon.page).append(childrenBox);
					//计算文件夹打开后窗口宽度以及最大度
					//childrenBox.width(thisIcon.children.length*75<360?thisIcon.children.length*75:360);
					childrenBox.append('<div class="childrenBoxR"></div>')
							   .append('<div class="childrenBoxT"></div>')
							   .append(childrenBoxContent)
							   .append('<div class="childrenBoxB"></div>')
							   .append('<div class="childrenBoxB_r"></div>')
							   .append('<div class="childrenBoxB_l"></div>')
							   .append('<div class="childrenBoxT_l"></div>')
							   .append('<div class="childrenBoxT_r"></div>')
							   .append('<div class="childrenBoxArraw"></div>')
					childrenBoxContent.domDroppable({
						drop: function(event,ui) {
							$(this).append($(ui.draggable).removeAttr("style").removeClass("abs active"));
							position(thisIcon.page);
						}
					});
					/*$tLink.domDroppable({//拖动进文件夹事件
						drop: function(event,ui) {
							$("#childrenBox"+$(this).attr("iconid")).find(".childrenBoxContext").append($(ui.draggable).removeAttr("style").removeClass("abs active"));
							position(thisIcon.page);
						}
					});*/
				}else{
					$imgSrc=$('<img />').attr("src",imgPath+thisIcon.img);
					$tLink=$('<a href="javascript:;"></a>').text(thisIcon.title).attr("iconid",thisIcon.id).attr("page",thisIcon.page).prepend($imgSrc).addClass("abs icon").data("option",thisIcon);
				}
				$("#desktop"+thisIcon.page).find("#addIcon"+thisIcon.page).before($tLink);
				
			}
			function bindEvent(){
				$("#desktop").delegate(".folder","click",function(){//文件夹点击事件
					var that=this;
					setTimeout(function(){
						var thisId=$(that).attr("iconid");
						var thisLeft=parseInt($(that).css("left"))+90+"px";
						var thisTop=$(that).css("top");
						$("#childrenBox"+thisId).css({left:thisLeft,top:thisTop})
						$("#childrenBox"+thisId).show();
					},50);
				})
				$("#desktop .icon:not(.folder)").each(function(){
					var thisId=$(this).attr("iconid");
					var baseUrl=$(this).attr("baseUrl");
					var leaderUrl=$(this).attr("leaderUrl");
					$(this).smartMenu(deskMenuData, {//右键菜单
						name: "menu"+$(this).attr("iconid")    
					});
					$(this).click(function(){
						var thisOption={
							id:thisId,
							width:dlgWidth,
							height:dlgHeight,
							iframe:true,
							title:$(this).text(),
							url:'/desktop/module/module.jsp?leaderUrl='+leaderUrl+'&baseUrl='+baseUrl
						};
						$.deskDialog(thisOption);
					})
				})
				
				$("#desktop .icon").domDroppable({
					drop: function(event,ui) {
						if(!$("#childrenBox"+$(this).attr("iconid"))[0] || $(ui.draggable).hasClass("folder")){//如果图标拖动至文件夹          或             文件夹拖进文件夹中
							$(this).before($(ui.draggable));
						}else{
							$("#childrenBox"+$(this).attr("iconid")).find(".childrenBoxContext").append($(ui.draggable).removeAttr("style").removeClass("abs active"));
						}
						pagePosition();
					},
					hoverClass:'active'
				});
				
			}
			for(var i in icos){//遍历图标
				build(icos[i]);
			};
			bindEvent();
		}
		init(dfop.icos);
		//始始化桌面图标排列
		var pagePosition=function(){
			for(var i=1;i<=3;i++){
				position(i);
				var bodyMenuData = [
					[{
						text: "显示桌面",
						func: function() {
							var list = $.dialog.list;
							for( var j in list ){
							    list[j].hide();
							    $("#dock"+j).attr("dlgshow",'false');
							}
						}
					}],
					[{
						text: "一级菜单",
						data: [[{
							text: "某菜单",
							func: function() {
								
							}
						}, {
							text: "某菜单",
							func: function() {
								
							}
						}, {
							text: "某菜单",
							func: function() {
								
							}
						}]]
					}, {
						text: "添加",
						func: function() {
							$.addIconDlg();
						}
					}, {
						text: "新建文件夹",
						func: function() {
							var thisDesktopPage=$(this).attr("page");
							init([
								{id:191111,title:'文件夹',img:'folder.png',url:'/desktop/system/addDesktopIcon.jsp',page:thisDesktopPage,width:800,height:550,children:[]}
							]);
							position(thisDesktopPage);
						}
					}],
					[{
						text: "退出",
						func: function() {
							window.location.href='/sessionManage/logout.action?isIndexJsp=true';
						}
					}]
				];
				$("#desktop"+i).attr("page",i).smartMenu(bodyMenuData, {
					name: "desktop"+i
				});
				$(" #addIcon"+i).on("click",function(){
					$.addIconDlg();
				})
				$("#desktop"+i).find("a.icon:not(:#addIcon1):not(:#addIcon2):not(:#addIcon3)").domDraggable({//绑定拖动事件
					appendTo: "body",
					helper: "clone"
				});
			}
		}
		pagePosition();
		$(window).resize(function() {
			icoTime=setTimeout(function(){
				pagePosition();
			},500)
		});
		this.init=init;
		this.pagePosition=pagePosition;
		return this;
	},
	initSystemicons:function(o){//添加应用
		var self=$(this);
		var dlgWidth=document.documentElement.clientWidth;
		var dlgHeight=document.documentElement.clientHeight-100;
		var dW=document.documentElement.clientWidth-240,dH=dlgHeight;
		this.imgPath='/resource/desktop/images/icons/';
		var dfop={
			url:'',
			icos:[
			{id:1111,title:'刑释人员',img:'positiveInfoManagement.png',url:'/desktop/module/module.jsp#positiveInfo',width:dW,height:dH,iframe:true},
			{id:1211,title:'社区矫正人员',img:'rectificativePersonManagement.png',url:'/desktop/module/module.jsp#rectify',width:dW,height:dH,iframe:true},
			{id:1311,title:'重点青少年',img:'idleYouthManagement.png',url:'/desktop/module/module.jsp#idleYouth',width:dW,height:dH,iframe:true},
			{id:1411,title:'严重精神障碍患者',img:'mentalPatientManagement.png',url:'/desktop/module/module.jsp#mentalPatient',width:dW,height:dH,iframe:true},
			{id:1511,title:'吸毒人员',img:'druggyManagement.png',url:'/desktop/module/module.jsp#druggyManage',width:dW,height:dH,iframe:true},
			{id:1611,title:'重点上访人员',img:'superiorVisitManagement.png',url:'/desktop/module/module.jsp#superiorVisit',width:dW,height:dH,iframe:true},
			{id:1711,title:'需要求助人员',img:'poorPeopleManagement.png',url:'/desktop/module/module.jsp#poorPeopleManage',width:dW,height:dH,iframe:true},
			{id:1811,title:'危险品从业人员',img:'dangerousGoodsPractitionerManagement.png',url:'/desktop/module/module.jsp#dangerousGoodsPractitioner',width:dW,height:dH,iframe:true},
			{id:1911,title:'其他人员',img:'otherAttentionPersonnelManagement.png',url:'/desktop/module/module.jsp#otherAttentionPersonnel',width:dW,height:dH,iframe:true},
			{id:11111,title:'境外人员',img:'overseaPersonManagement.png',url:'/desktop/module/module.jsp#overseaPersonnel',width:dW,height:dH,iframe:true},
			
			{id:2111,title:'安全生产重点',img:'safetyProductionKeyManagement.png',url:'/desktop/module/module.jsp#safetyProduction',width:dW,height:dH,iframe:true},
			{id:2211,title:'消防安全重点',img:'fireSafetyKeyManagement.png',url:'/desktop/module/module.jsp#firePersonInCharge',width:dW,height:dH,iframe:true},
			{id:2311,title:'治安重点',img:'securityKeyManagement.png',url:'/desktop/module/module.jsp#personInCharge',width:dW,height:dH,iframe:true},
			{id:2411,title:'学校',img:'schoolManageMent.png',url:'/desktop/module/module.jsp#school',width:dW,height:dH,iframe:true},
			{id:2511,title:'其他场所',img:'otherLocaleManagement.png',url:'/desktop/module/module.jsp#otherLocale',width:dW,height:dH,iframe:true},
			{id:2611,title:'出租房',img:'lettingHouseManagement.png',url:'/desktop/module/module.jsp#lettingHouse',width:dW,height:dH,iframe:true},
			{id:2711,title:'规上企业',img:'enterpriseManagement.png',url:'/desktop/module/module.jsp#enterprise',width:dW,height:dH,iframe:true},
			{id:2811,title:'社会组织',img:'newSocietyFederationManagement.png',url:'/desktop/module/module.jsp#newSocietyFederations',width:dW,height:dH,iframe:true}
		]};
		$.extend(dfop,o);
		var icos=dfop.icos;
		for(var i in icos){//遍历图标
			if(typeof(icos[i])=='string'){
				build(icos);
			}
			else{
				build(icos[i]);
			}
		};
		function build(thisIcos){//构建图标
			var $imgSrc;
			var $tLink;
			var thisIcon=thisIcos;
			
			if(thisIcon.id==undefined){
				thisIcon.id=i;
			}
			$imgSrc=$('<img />').attr("src",imgPath+thisIcon.img);
			$tLink=$('<a href="javascript:;"></a>').text(thisIcon.title).attr("iconid",thisIcon.id).prepend($imgSrc).addClass("icon").data("option",thisIcon);
			self.append($tLink);
		}
		for(var i in icos){//遍历图标
			if(typeof(icos[i])=='string'){
				build(icos);
			}
			else{
				build(icos[i]);
			}
		};
	},
	leastRecentlyUsed:function(o){//最近使用
		var self=$(this);
		var dlgWidth=document.documentElement.clientWidth;
		var dlgHeight=document.documentElement.clientHeight-100;
		var dW=document.documentElement.clientWidth-240,dH=dlgHeight;
		var imgPath='/resource/desktop/images/icons/';
		var dfop={icos:[
			{id:1111,title:'刑释人员',img:'positiveInfoManagement.png',url:'/desktop/module/module.jsp#positiveInfo',width:dW,height:dH,iframe:true},
			{id:1211,title:'社区矫正人员',img:'rectificativePersonManagement.png',url:'/desktop/module/module.jsp#rectify',width:dW,height:dH,iframe:true},
			{id:1311,title:'重点青少年',img:'idleYouthManagement.png',url:'/desktop/module/module.jsp#idleYouth',width:dW,height:dH,iframe:true},
			{id:1411,title:'严重精神障碍患者',img:'mentalPatientManagement.png',url:'/desktop/module/module.jsp#mentalPatient',width:dW,height:dH,iframe:true},
			{id:1511,title:'吸毒人员',img:'druggyManagement.png',url:'/desktop/module/module.jsp#druggyManage',width:dW,height:dH,iframe:true},
			{id:1611,title:'重点上访人员',img:'superiorVisitManagement.png',url:'/desktop/module/module.jsp#superiorVisit',width:dW,height:dH,iframe:true},
			{id:1711,title:'需要求助人员',img:'poorPeopleManagement.png',url:'/desktop/module/module.jsp#poorPeopleManage',width:dW,height:dH,iframe:true},
			{id:1811,title:'危险品从业人员',img:'dangerousGoodsPractitionerManagement.png',url:'/desktop/module/module.jsp#dangerousGoodsPractitioner',width:dW,height:dH,iframe:true},
			{id:1911,title:'其他人员',img:'otherAttentionPersonnelManagement.png',url:'/desktop/module/module.jsp#otherAttentionPersonnel',width:dW,height:dH,iframe:true},
			{id:11111,title:'境外人员',img:'overseaPersonManagement.png',url:'/desktop/module/module.jsp#overseaPersonnel',width:dW,height:dH,iframe:true}
		]};
		$.extend(dfop,o);
		var childrenBox=$("<div />").addClass("childrenBox").attr("id","leastRecentlyUsedBox");//容器
		var childrenBoxContent=$("<div />").addClass("childrenBoxContext").append('<div class="childrenBoxC_r"></div>');
		var icos=dfop.icos;
		function build(thisIcos){//构建图标
			var $imgSrc;
			var $tLink;
			var thisIcon=thisIcos;
			
			if(thisIcon.id==undefined){
				thisIcon.id=i;
			}
			$imgSrc=$('<img />').attr("src",imgPath+thisIcon.img);
			$tLink=$('<a href="javascript:;"></a>').text(thisIcon.title).attr("iconid",thisIcon.id).prepend($imgSrc).addClass("icon").data("option",thisIcon);
			$tLink.on("click",function(){
				var thisOption={width:dlgWidth,height:dlgHeight};
				$.extend(thisOption,$(this).data("option"));
				$.deskDialog(thisOption);
			})
			childrenBoxContent.append($tLink);
		}
		for(var i in icos){//遍历图标
			if(typeof(icos[i])=='string'){
				build(icos);
			}
			else{
				build(icos[i]);
			}
		};
		childrenBox.append('<div class="childrenBoxR"></div>')
						   .append('<div class="childrenBoxT"></div>')
						   .append(childrenBoxContent)
						   .append('<div class="childrenBoxB"></div>')
						   .append('<div class="childrenBoxB_r"></div>')
						   .append('<div class="childrenBoxB_l"></div>')
						   .append('<div class="childrenBoxT_l"></div>')
						   .append('<div class="childrenBoxT_r"></div>')
						   .append('<div class="childrenBoxArraw" style="top:auto;bottom:40px"></div>');
		$("body").append(childrenBox);
		self.on("click",function(){
			var that=this;
			setTimeout(function(){
				var thisLeft=parseInt($(that).css("left"))+60+"px";
				var thisTop=$(that).parents(".desk_Menu").css("top");
				childrenBox.css({left:thisLeft,top:'50%'})
				childrenBox.show();
			},50);
		})
	},
	//消息组件
	loadMessage:function(o){
		var self=$(this);
		var dfop={
			data:[
				{id:1,link:'',text:'系统消息1',time:'2011.11.11 11.11.11',type:'system',unread:true},
				{id:2,link:'',text:'服务办事信息1',time:'2011.11.11 11.11.11',type:'services'},
				{id:3,link:'',text:'平台消息2',time:'2011.11.11 11.11.11',type:'terrace'},
				{id:4,link:'',text:'平台消息3',time:'2011.11.11 11.11.11',type:'terrace'},
				{id:5,link:'',text:'平台消息4',time:'2011.11.11 11.11.11',type:'terrace'},
				{id:6,link:'',text:'平台消息5',time:'2011.11.11 11.11.11',type:'terrace'}
			],
			all:'#allMessageList',
			sys:'#sysMessageList',
			services:'#servicesMessageList',
			terrace:'#terraceMessageList'
		};
		$.extend(dfop,o);
		var init=function(row){
			var dom=$("<li />").attr("id",row.id);
			if(row.unread==true){
				dom.addClass("unread");
				dom.on("click",function(){
					$(this).removeClass("unread");
				})
			}
			var time=$("<span />").text(row.time);
			var link=$("<a></a>").attr("href",row.link).text(row.text).append(time);
			dom.append(link);
			switch (row.type){
				case 'system':
					dom.clone(true).appendTo(dfop.sys);
				    break;
				case 'services':
					dom.clone(true).appendTo(dfop.services);
				    break;
				case 'terrace':
					dom.clone(true).appendTo(dfop.terrace);
				    break;
			}
			dom.appendTo(dfop.all);//添加到全部信息
		}
		for(var i in dfop.data){
			init(dfop.data[i]);
		}
	},
	domDraggable:function(o){
		var self=$(this);
		var dfop={
			delay:200
		}
		$.extend(dfop,o);
		self.draggable(dfop);
	},
	domDroppable:function(o){
		var self=$(this);
		var dfop={
			
		}
		$.extend(dfop,o);
		self.droppable(dfop);
	},
	scrollBar:function(o){
		var self=$(this);
		var dfop={
			W:"10px",									//设置滚动条宽度
			BgUrl:"",									//设置滚动条背景图片地址
			Bg:"scrollbar_bgy.png",						//设置滚动条背景图片position,颜色等
			Bar:{
				Pos:"",							//设置滚动条初始化位置在底部
				Bd:{Out:"",Hover:""},				//设置滚动滚轴边框颜色：鼠标离开(默认)，经过
				Bg:{Out:"#ccc",Hover:"",Focus:"#000"}		//设置滚动条滚轴背景：鼠标离开(默认)，经过，点击
			},
			Btn:{  btn:false},							//设置下按钮背景：鼠标离开(默认)，经过，点击
			Fn:function(){}								//滚动时候触发的方法
		}
		$.extend(dfop,o);
		self.droppable(dfop);
		self.jscroll(dfop);
	},
	clearField:function(s){//<input type="text" class="clearField" value="请输入用户名" />   调用方法：$('.clearField').clearField();
		s=jQuery.extend({blurClass:'clearFieldBlurred',activeClass:'clearFieldActive',attribute:'rel',value:''},s);
		return $(this).each(function(){
			var el=$(this);
			s.value=el.val();
			if(el.attr(s.attribute)==undefined){
				el.attr(s.attribute,el.val()).addClass(s.blurClass)
			}else{
				s.value=el.attr(s.attribute)
			}
			el.focus(function(){
				if(el.val()==el.attr(s.attribute)){
					el.val('').removeClass(s.blurClass).addClass(s.activeClass)
				}
			});
			el.blur(function(){
				if(el.val()==''){
					el.val(el.attr(s.attribute)).removeClass(s.activeClass).addClass(s.blurClass)
				}
			})
		})
	}
})
<%@ page language="java" import="java.util.*,com.tianque.core.util.GridProperties" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String proxyIp = GridProperties.PROXY_SERVER_DOMAIN_NAME;
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String openId = (String)request.getAttribute("openId");
String weChatUserId = (String)request.getAttribute("weChatUserId");
String orgId = request.getAttribute("orgId").toString();
%>
<!DOCTYPE html>
<html>
	<head>
		<title>红袖套认证</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
		<link href="<%=proxyIp%>/resource/weChat/weui.min.css" media="all" rel="stylesheet"/>
		<script type="text/javascript" src="<%=proxyIp%>/resource/desktop/js/jquery.js"></script>
		<style type="text/css">
		.page_title {
			text-align: center;
			font-size: 34px;
			color: #225FBA;
			font-weight: 400;
			margin: 0 15%;
		}
		</style>
	</head>
	<body ontouchstart="">
		<div class="page cell">
		<h1 class="page_title">认证</h1>
		 <input id="openId"  type="hidden" value="<%=openId%>" />
		 <input id="orgId" name="orgId"  type="hidden" value="<%=orgId%>" />
         <input id="weChatUserId" name="weChatUserId"  type="hidden" value="<%=weChatUserId%>" />
		 <form id="mainForm" action="<%=proxyIp%>/authenticationRedCuffTeamManage/authenticationRedCuffTeam.action" method="post">
			<div class="weui_cells weui_cells_form">
				<div class="weui_cell">
                    <div class="weui_cell_hd"><label class="weui_label">姓名 </label></div>
                    <div class="weui_cell_bd weui_cell_primary">
                        <input id="name" name="name" class="weui_input" placeholder="请输入姓名" required="required" oninvalid="这是必填选项">
                    </div>
                </div>
			
				<div class="weui_cell">
                    <div class="weui_cell_hd"><label class="weui_label">手机号  </label></div>
                    <div class="weui_cell_bd weui_cell_primary">
                        <input id="phoneNumber" name="phoneNumber" type="number" class="weui_input" placeholder="请输入手机号码" required="required" oninvalid="这是必填选项" onkeyup="value=value.replace(/[^\d]/g,'') "
				onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d.]/g,''))" maxlength="11">
                    </div>
                </div>
                <div class="weui_cell">  
                    <div class="weui_cell_hd"><label class="weui_label">验证码</label></div>
                    <div class="weui_cell_bd weui_cell_primary">
                         <input id="verificationCode" class="weui_input" type="text" placeholder="请输入验证码">
                    </div>
                    <div class="weui_cell_hd weui_cell_primary" >
                        <div style="width:3em;color:red;font-style:italic;font-size:20px;background-color:#99ff99;"  id="code" onclick="createCodeClick()"></div>
                    </div>                                   
                </div>
			</div>
               <div class="weui_btn_area">
               <button type="button" id="aaaa" class="weui_btn weui_btn_primary">提交</button>
            </div>
		</form>
		</div>
	</body>
	<script type="text/javascript">
	 //防止多次点击
    var multipleClicks=true;
    var code ; 
	$(function(){
		createCodeClick();
		
		$("#aaaa").click(function(){			
			if(multipleClicks){
				multipleClicks=false;

			var param = {};
			param.orgId = $('#orgId').val();
			param.weChatUserId = $('#weChatUserId').val();
			param.openId = $("#openId").val();
			param.name = $("#name").val();
			param.phoneNumber = $("#phoneNumber").val();
			
			if(!param.orgId){
				alert("未获取打组织ID,请重新进入该界面!");
				multipleClicks=true;
				return;
			}
			
			if(!param.weChatUserId){
				alert("未获取微信号,请重新进入该界面!");
				multipleClicks=true;
				return;
			}
			
			if(!param.name){
				alert("请输入姓名");
				multipleClicks=true;
				return;
			}
			
			if(!param.phoneNumber){
				alert("获取phoneNumber失败!");
				multipleClicks=true;
				return;
			}
			
			if(!param.openId){
				alert("获取openId失败!");
				multipleClicks=true;
				return;
			}

		    var inputCode = $("#verificationCode").val().toUpperCase(); //取得输入的验证码并转化为大写 			   
		    if(inputCode.length <= 0) { //若输入的验证码长度为0  
		        alert("请输入验证码!"); //则弹出请输入验证码  
		        multipleClicks=true;
				return;
		    }else if(inputCode != code ) { //若输入的验证码与产生的验证码不一致时  
		        alert("验证码输入错误!"); //则弹出验证码输入错误  
		        createCodeClick();//刷新验证码 
		        multipleClicks=true;
				return;
		    }  
			
			//validate();
			$.post("<%=proxyIp%>/authenticationRedCuffTeamManage/authenticationRedCuffTeam.action",param,function(data){
				if (data ==true||data=="true") {
					reset();
					createCodeClick();
					alert("认证成功");
					multipleClicks=true;
					if(WeixinJSBridge)WeixinJSBridge.call('closeWindow');
				} else {
					reset();
					createCodeClick();
					alert(data);					
					multipleClicks=true;
				}
			});
		  }
		});
		
	});
    function reset(){
    	document.getElementById("mainForm").reset();
    }
    
	function createCodeClick(){ 
		code = "";
	     var codeLength = 4;//验证码的长度  
	     var random = new Array(0,1,2,3,4,5,6,7,8,9);//随机数  
	     for(var i = 0; i < codeLength; i++) {//循环操作  
	        var index = Math.floor(Math.random()*10);//取得随机数的索引（0~35）  
	        code += random[index];//根据索引取得随机数加到code上  
	    }  
	     $("#code").text(code);//把code值赋给验证码  
	}
	
	</script>
</html>
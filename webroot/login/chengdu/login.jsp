﻿<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
GlobalSettingService globalSettingService = (GlobalSettingService)WebApplicationContextUtils.getWebApplicationContext(this.getServletContext()).getBean("globalSettingService");
String sysTitle = globalSettingService.getGlobalValue(GlobalSetting.SYS_TITLE);
String frontPageBottom = globalSettingService.getGlobalValue(GlobalSetting.FRONTPAGE_BOTTOM_PAGE);
String backImage = globalSettingService.getGlobalValue(GlobalSetting.BACK_IMAGE);
String prevImage = globalSettingService.getGlobalValue(GlobalSetting.PREV_IMAGE);
String buttonImage = globalSettingService.getGlobalValue(GlobalSetting.BUTTON_IMAGE);
String mouseMoveImage = globalSettingService.getGlobalValue(GlobalSetting.MOUSE_MOVE_IMAGE);
request.setAttribute("backImage",backImage);
request.setAttribute("prevImage",prevImage);
request.setAttribute("buttonImage",buttonImage);
request.setAttribute("mouseMoveImage",mouseMoveImage);
%>
<!DOCTYPE html>
<html>
<head>
<%@page import="com.tianque.core.globalSetting.service.GlobalSettingService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="com.tianque.core.globalSetting.util.GlobalSetting"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>成都市网格化服务管理信息系统</title>
<jsp:include page="/includes/baseInclude.jsp" />
<link rel="shortcut icon" href="${resource_path}/resource/images/favicon.ico" type="image/x-icon"/>
<link type="text/css" href="${resource_path }/resource/js/poshytip/tip-error/tip-error.css" rel="stylesheet" />
<link type="text/css" href="${resource_path }/resource/js/jsValidate/css/validationEngine.jquery.css" rel="stylesheet" />
<link rel="shortcut icon" href="${resource_path }/resource/images/favicon.ico" type="image/x-icon"/>
<style type="text/css">
	body,h1,h2,h3,h4,h5,h6,p,blockquote,dl,dt,dd,ul,ol,li,pre,fieldset,lengend,button,input,textarea,th,td {margin: 0;padding: 0;}
	html,body{width:100%;height:100%;overflow:hidden;}
	.product-login-ctt{overflow:hidden;width:100%;height:100%;background:#B13B23 url(/resource/system/images/login/chengdu/cdbg.jpg) no-repeat center center;}
	.copyright{width:100%;margin:3% 0 0;_margin:1% 0 0;font:12px/45px "";color:#fff;text-align: center;}
	.product-logCon{width: 850px;margin:60px 0 0 -425px;text-align:center;position:absolute;top:60%;left:50%;}
	.product-form{margin-left: 38px;overflow: hidden;}
	.product-logform .inputSearch{float:left;width:270px;height:38px;*display:inline;*zoom:1;padding:0 0 0 13px;font:14px/38px "microsoft yahei";color:#95A2AE;background:url(/resource/system/images/login/red/textbg.png) no-repeat;}
	.product-logform .inputSearchTxt{background-position:-1px -1px;}
	.product-logform .inputSearchPwd{background-position:-1px -42px;}
	.product-logform .inputSearchSecret{width:95px;height:40px;margin:0;padding:0px;background:none;}
	.product-logform .inputSearch .searchU,.searchT{float:left;height:30px;}
	.product-logform .inputSearch .searchT{width:140px;}
	.product-logform .inputSearch .inputText{width:155px;height:23px;margin:0px 0 0 4px;padding:8px 0 0 0;border:none;outline:none;font:12px/19px "microsoft yahei";background:transparent;}
	.product-logform .inputSearch .errorInput{background:#fee; border:1px solid #DB0027;}
	.product-logform .inputSearchSecret a{width:95px;height:40px;display:inline-block;*display:inline;*zoom:1;text-decoration:none;color:#fff;text-align:center;background: url(/resource/system/images/login/red/formbtn.png) no-repeat 0 -38px;}
	.product-logform .inputSearchSecret a:hover{background-position:0 1px;}
	.product-logform .inputSearchCheckbox{margin:0 0 0 10px;_margin:10px 0 0 10px;font:12px/38px "";color:#fff;}
	.product-logform .inputSearchCheckbox input,.product-logform .inputSearchCheckbox span{vertical-align: middle;}
	#loginInfo{text-align:center;font: bold 16px/20px '';color:#9E251D;height:20px;}
</style>
<script type="text/javascript" src="${resource_path}/resource/external/jquery.min.js"></script>
<script type="text/javascript" src="${resource_path}/resource/external/jquery.md5.js"></script>
<script type="text/javascript" src="${resource_path}/resource/external/jquery.cookie.js"></script>
<script type="text/javascript" src="${resource_path}/resource/external/poshytip/jquery.poshytip.min.js"></script>
<script type="text/javascript" src="${resource_path}/resource/external/jsValidate/jquery.form.js"></script>
<script type="text/javascript" src="${resource_path}/resource/external/jsValidate/jquery.form.js"></script>
<script type="text/javascript" src="${resource_path}/resource/external/jsValidate/jquery.validate.min.js"></script>
<script type="text/javascript" src="${resource_path}/resource/system/js/formValidate.js"></script>
<script type="text/javascript" src="${resource_path}/resource/system/js/widget/widget.js"></script>
<script type="text/javascript">
$(function(){
    $("#username").focus();

    $("#sub").click(function(){
        $('#loginForm').submit();
    });
    $("#changeValidateCode").click(function(){
        $("#validateCodeImg").attr("src","${path }/validateCodeServlet?date="+new Date());
    });

    $("#username,#password").bind("keydown",function(evt){
        var evt = window.event?window.event:evt;
        if(evt.keyCode==13){
            $('#loginForm').submit();
        }
    });

    if($.cookie('username')){            //判断cookie是否为空，如果不为空继续下一步。
         $('#username').val($.cookie('username'));     //从cookie里面取出里面的值。
         $('#remuser').attr("checked","checked");
    }
    $("#loginForm").formValidate({
        submitHandler: function(form) {
        $("#loginInfo").text("系统登录中...");
        $("#submithref").attr('disabled', true);
        $("#password").val($.md5($("#password").val()));
            $(form).ajaxSubmit({
                success:function(data){
                    $("#submithref").attr('disabled', false);
                    if(data==null||data==true){
                        if($.cookie("failureTimes")){
                            $.cookie("failureTimes",0,{path: '/'});
                        }
                        var userName=$('#username').val();
                        if($('#remuser').attr('checked')){
                            $.cookie('username',userName,{ path: '/',expires:7});
                        }else{
                            $.cookie('username',null,{ path: '/',expires:0});
                        }    
                        document.location.href="${path}/module.jsp";
                    }else if(data==false){
                        document.location.href="${path}/sessionManage/toFirstPasswordUpdate.action?path=urlAddress";
                    }else if(data=='passwordOutTime'){
                        document.location.href="${path}/sessionManage/passwordOutTimeUpdate.action";
                    }else{
                    	$("#loginInfo").text("");
                        if($.cookie("failureTimes")){
                            $.cookie("failureTimes",parseInt($.cookie("failureTimes"))+1);
                        }else{
                            $.cookie("failureTimes",1,{path: '/'});
                        }
                        var jsonMsg=eval("("+data+")");
                        if(jsonMsg.userName){
                            var inputObject=$("input[name='userName']");
                            $("#loginInfo").text("用户名或密码错误，请重新输入");
                            if($.cookie("failureTimes")>=3||parseInt(jsonMsg.failureTimes)>=3){
                                $(".login-yztext").show();
                                $("#validateCodeImg").attr("src","${path }/validateCodeServlet?date="+new Date());
                            }
                        }
                        if(jsonMsg.validateCode){
                            var inputObject=$("input[name='validateCode']");
                            inputObject.dialogtip({
                                content:jsonMsg.validateCode,alignX: 'center',alignY: 'top'
                            });
                            inputObject.poshytip('show');
                        }
                    }
                }
            });
            return false;
        },
        rules: {
            userName:{
                required:true
                //isDigitStrAndUnderline:true
            },
            password:{
                required:true
            }
        },
        messages: {
            userName:{
                required:"用户名不能为空！"
                //isDigitStrAndUnderline:"用户名只能由数字、字母、下划线组成"
            },
            password:{
                required:"密码不能为空！"
            }
        }
    });
});
</script>
</head>
<body>
<div class="product-login-ctt">
	<div class="product-login" id="productLogin">
	    <div class="product-logCon">
	    	<div class="logo"><img src='/resource/system/images/login/chengdu/cdlogo.png'/></div>
	    	<div class="product-logform">
	           	<form method="post" action="${path}/sessionManage/login.action" id="loginForm">
	           		<div id="loginInfo">${errorMessage}
	                    <s:property value="#parameters.errorMessage"/>
	                </div>
	                <div class="product-form">
	                	<div class="inputSearch inputSearchTxt"><div class="searchU"><label>用户名：</label></div><div class="searchT"><input id="username" type="text" class="inputText" name="userName" /></div></div>
						<div class="inputSearch inputSearchPwd"><div class="searchU"><label>密码：</label></div><div class="searchT"><input id="password" type="password" class="inputText" name="password" /></div></div>
						<div class="inputSearch inputSearchSecret"><a href="javascript:;" class="product-login" id="submithref" name="submithref" onclick="$('#loginForm').submit();"></a></div>
						<div class="inputSearch inputSearchSecret inputSearchCheckbox"><label><input type="checkbox" id="remuser" /><span>&nbsp;记住用户名</span></label></div>
					</div>
	            </form>
	        </div>
	        <div class="copyright"><%=frontPageBottom %></div>
	    </div>
	</div>
</div>
<!--[if IE 6]>
<script type="text/javascript" src="${resource_path}/resource/js/DD_belatedPNG.js"></script>
<script type="text/javascript">
	//解决IE6下 PNG 图片兼容的JS插件
	DD_belatedPNG.fix('#productLogin .product-logCon');
	DD_belatedPNG.fix('#productLogin .product-logform .inputSearch a');
    DD_belatedPNG.fix('#productLogin .product-logform .inputSearch .searchT');
    DD_belatedPNG.fix('#productLogin .product-topBg');
	DD_belatedPNG.fix('#productLogin ..product-loginC');
    DD_belatedPNG.fix('#productLogin .product-logform .inputSearch,.product-logCon .logo img');
</script>
<![endif]-->
</body>
</html>

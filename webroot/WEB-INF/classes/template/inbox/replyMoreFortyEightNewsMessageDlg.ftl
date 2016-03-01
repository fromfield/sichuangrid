<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp"/>


<div  class="container container_24">
	<form id="maintainForm" method="post" action="">
	 <input type="hidden" id="isCloseWindow" value="true"/>
      <@pop.token />
		<input type="hidden" id="isCloseWindow" value="true"/>
	    <input type="hidden" name="textMessage.ToUserName" value="${inbox.fromUserName!}"><!-- 发送给谁 -->
		<input type="hidden" name="inbox.inboxId" value="${inbox.inboxId!}"><!-- 用天存储 每条消息对应的回复记录  -->
		<input type="hidden" name="inbox.createUser" value="${inbox.createUser!}"><!-- 存的是粉丝名，区别于系统中的ccuu字段  用于存储对应的回复消息记录列表-->
		<input type="hidden" name="inbox.toUserName" value="${inbox.toUserName!}"><!-- 用于获取微信号 -->
		
		<div class="grid_4 lable-right">
			<label>收件人：</label>
		</div>	
		<div class="grid_20">
			${inbox.createUser}
		</div>		
		<div class='clearLine'>&nbsp;</div>
		<div id="title">
			<div class="grid_4 lable-right">
				<em class="form-req">*</em><label class="form-lbl">标题：</label>
			</div>
			<div class="grid_20" id="titleDiv">
				<input type="text" name="article.Title"  id="articleTitle" class='form-txt {required:true,maxlength:50,messages:{required:"请输入标题",maxlength:$.format("标题最多可以输入{0}个字符")}}'  />
			</div>
		</div>
		<div class='clearLine'>&nbsp;</div>
		<div id="url">
			<div class="grid_4 lable-right">
				<em class="form-req">*</em><label class="form-lbl">链接地址：</label>
			</div>
			<div class="grid_20" id="urlDiv">
	                <input type="text" name="article.Url" id="articleUrl"  class='form-txt {required:true,isUrl:true,maxlength:400,messages:{required:"请输入链接地址",isUrl:"请输入正确的网址",maxlength:$.format("链接地址最多可以输入{0}个字符")}}'  />
			</div>
		</div>
		<div class='clearLine'>&nbsp;</div>
		<div id="content">
			<div class="grid_4 lable-right">
				<em class="form-req">*</em><label class="form-lbl">描述：</label>
			</div>
			<div class="grid_20 heightAuto">
		    	<textarea name="article.Description"  id="articleDescription" onkeyup="charlength(value)" style='height:70px;width: 97%' class='form-txt {required:true,maxlength:140,messages:{required:"请输入回复内容",maxlength:$.format("回复内容最多可以输入{0}个字符")}}'></textarea>
			</div>
			    <div class='clearLine'>&nbsp;</div>
				<div class="grid_4 lable-right">
					<label class="form-lbl">已输入：</label>
				</div>
				<div class="grid_20 heightAuto">
					<span id="counter" style="line-height: 30px; padding-left: 5px;font-style:normal;">0</span>个字（注意：内容不要超过140字。)
				</div>
		</div>
		
		  <select id="attachFileNames" name="attachFiles" multiple="multiple" style="display:none"></select>
	</form>
	<div class="attachImageFile">
		<div class="filePanel">
			<div class="grid_4 lable-right">
				<label class="form-lbl">附件上传：</label>
			</div>
			<div id="attachFilesDiv" class="grid_20 heightAuto">
				<div id="custom-queue"></div>
				<input id="custom_image_upload" name="uploadFile" type="file" />
		    </div>
		    <div class='clearLine'>&nbsp;</div>
			<div class="grid_4 lable-right">
				<label class="form-lbl"></label>
			</div>
			<div class="grid_20 heightAuto">
			<span style="color:red">*图片支持:</span>	<span  style="line-height: 30px; padding-left: 5px;font-style:normal;font-size:13px">jpg/1M</span>
			</div>
		</div>
	</div>
	
</div>
<div id="selectPersonDialog"></div>
<script type="text/javascript">
//计算文字长度
	function charlength(value){
		var a=value.length;
		document.getElementById("counter").innerText=a;
	 }
	
$(document).ready(function(){

	//附件上传(图片)
	$('#custom_image_upload').uploadFile({
		queueID : 'custom-queue',
		selectInputId : "attachFileNames",
		maxFileUpload:1,
		queueSizeLimit :1,
		multi:false,
		removeAction:"${path}/weChat/inbox/delelteAttachFile.action",
		fileExt        : "*.jpg",
		fileDesc       : '图片',
		chinese        :false,
		sizeLimit:1048576
	});

	   $("#maintainForm").attr("action","/weChat/inbox/replyMoreFortyEightNewsMessage.action");
	
	//提交
	$("#maintainForm").formValidate({
		promptPosition: "bottomLeft",
		submitHandler: function(form) {			
		if($("#attachFileNames").val()==""||$("#attachFileNames").val()==null){			 
			$.messageBox({message:"请上传回复图文的图片！",level: "warn"});		
			 return ;
		}
	    $(form).ajaxSubmit({
	         success: function(data){
	        	 if(data==null||data=="null"){
	        		 if($("#isCloseWindow").val()=='true'){
	        		   $("#replyMessageDlg").dialog("close");
	        		 }else{
	        				$("#attachFileNames").html('');
							$('#custom_image_upload').uploadifyClearQueue();
							$("#isCloseWindow").val("true");
							$("#articleDescription").val("");
							$("#articleUrl").val("");
							$("#articleTitle").val("");
							document.getElementById("counter").innerText=0;
							
	        		  }
					$.messageBox({message:"回复成功!"});						
					$("#inboxList").trigger("reloadGrid"); 
              }else{
         			$.messageBox({message:data,level: "error"});
         	  }
					
	  	   },
	  	   error: function(XMLHttpRequest, textStatus, errorThrown){
	  	      alert("提交错误");
	  	   }
	  	  });
		}
	});
	
});

</script>



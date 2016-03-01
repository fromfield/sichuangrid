<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@ include file="/includes/baseInclude.jsp"%>
<style type="text/css">
.ui-widget-border{border:1px solid #999999;_width:560px;height:120px;padding:0 10px;overflow-y:hidden;overflow-y:auto;}
.share_fileName{border-bottom:1px dashed #333;line-height:25px;overflow:hidden;zoom:1;}
</style>
<div id="dialog-form" title="资料共享" class="container container_24">
	 <form id="fileSharing-form" method="post" action="" >
	 <input id="ids" type="hidden" name="ids" value="${ids}" />
	 <input id="resourcePoolTypeId" type="hidden" name="resourcePoolTypeId" value="" />
	 <input id="sendMessage" type="hidden" name="sendMessage" value="0" />
	 <input id="identification" type="hidden" name="identification" value="${identification }">
         <div>
			<div id="fileName" class="ui-widget-border">    
				
				<s:if test='"docSynchro".equals(identification)'>
					<s:iterator value="documents" var="document">
						<div class="share_fileName"><lable>文件名称：</label><span>${document.title}</span></div>
					</s:iterator>
				</s:if>
				<s:if test='"workingRecord".equals(identification)'>
					<s:iterator value="workingRecords" var="workingRecord">
						<div class="share_fileName"><lable>文件名称：</lable><span>${workingRecord.name}</span></div>
					</s:iterator>
				</s:if>
				<s:else>
					<s:iterator value="myProfiles" var="file">
						<div class="share_fileName"><lable>文件名称：</label><span>${file.name }</span></div>
					</s:iterator>
				</s:else>
				
			</div>
		 </div>
		 <div class='clearLine'>&nbsp;</div>
	    <div class="grid_2 lable-left">
			<label  >存放于：</label>
		</div>
		<div class='clearLine'>&nbsp;</div>
		
			<div class="grid_24">
			    <div style="clear:both;overflow: auto;border:1px solid #999999;_width:560px;height: 150px;top:350px" class="orgTree">
			        <div id="publicDirectoryTree" style="margin-top:10px">
				</div>
			</div>
			
		</div>
		<div class='clearLine'>&nbsp;</div>


		<div class="grid_4 lable-right" style="margin-top:140px" >
			
			<input id="setPermission" type="button" value="设置查看权限" style="height: 26px;width: 130px">
			<input id="setPermissionCacheId" name="setPermissionCacheId" type="hidden">
			<input id="setPermissionText" name="setPermissionText" type="hidden">
		</div>
		
		<div class='clearLine'>&nbsp;</div>
        <br>
	    <div class="grid_5 lable-left" >
			<label >是否发送消息提示：</label>
		</div>
		<div class="grid_2 lable-right" >
			<input type="radio" name="Message" value="1">是
		</div>
		<div class="grid_2 lable-right" >
			<input type="radio" name="Message" value="0" checked>否
		</div>
	    <div class='clearLine'>&nbsp;</div>

   	</form>
 
   	
</div>

<script type="text/javascript">
var resourcePoolTypeId;
$("#setPermission").click(function(){
	$("#ObjDialog").createDialog({
		width: 650,
		height: 500,
		title:'选择对象',
		url:'${path}/daily/documentsManage/dispatchDocumentsManage/sendObjDialog.jsp?dailogName=ObjDialog&eleId=setPermission&cacheId='+$("#setPermissionCacheId").val(),
		buttons: {
		   "确定" : function(event){
			   sumitViewObject();
   			},
			"关闭" : function(){
        	   $(this).dialog("close");
		   }
		}
	});
});


$(document).ready(function(){
	var tree=$("#publicDirectoryTree").initMyProfileTree({
		url:'/resourcePool/directorySettingManage/firstPublicDirectory.action',
		dataUrl:PATH+'/resourcePool/directorySettingManage/firstPublicDirectory.action'
	});
	$.addClick(tree,afterChang);
	
	
	function afterChang(node){
		if(node.id=="publicDirectoryTree-root"){
			return ;
		}
		resourcePoolTypeId=node.id;
		$("#resourcePoolTypeId").val(resourcePoolTypeId);
	}
	
	if($("#identification").val()=="myProfile"){
		$("#fileSharing-form").attr("action","${path}/resourcePool/myProfileManage/addUserMyProfilePermission.action");
	}
	if($("#identification").val()=="docSynchro"){
		$("#fileSharing-form").attr("action","${path}/documents/dispatchDocumentsManage/synchToMyProfile.action");
	}
	if($("#identification").val()=="workingRecord"){
		$("#fileSharing-form").attr("action","${path}/workingRecord/workingRecordManage/synchToMyProfile.action");
	}
	
	
	$(":radio").each(function() {
		$(this).click(function() {
			$("#sendMessage").val($(this).val());
			});
	 });
	function hideLoddingDiv(){
		$("#loading").hide();
    	$('#showTxt').text('加载中，请稍候......');
	}
	 $("#fileSharing-form").formValidate({
			promptPosition: "bottomLeft",
			submitHandler: function(form){
				if($("#resourcePoolTypeId").val()==""||$("#resourcePoolTypeId").val()==null){
					$.messageBox({message:"必须设置文件的存放目录！",level:"warn"});
					return ;
				}
				$('#showTxt').text('正在共享资料,请稍后...');
				$("#loading").css({'z-index':9999,'position':'absolute','left':(document.body.scrollWidth)/2 - $('#loading').width()*2}).show();
			    $("#fileSharing-form").ajaxSubmit({
					success:function(data){
					
				    	if($("#identification").val()=="myProfile"){
				    		if(data!=null){
								$.messageBox({message:data,level:"error"});
								hideLoddingDiv();
								return ;
							}
				    		$("#myProfileList").trigger("reloadGrid");
				    		$.messageBox({message:"文件共享成功！"});
				    	}else{
				    		$.messageBox({message:"文件同步成功！"});
				    	}
				    	hideLoddingDiv();
			            $("#fileSharingDailog").dialog("close");
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						hideLoddingDiv();
			      		alert("提交数据时发生错误");
		   		    }
				});  
			}
		});
	

});


</script>
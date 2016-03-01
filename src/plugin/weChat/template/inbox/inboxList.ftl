<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>

<style>
</style>
<div class="content" >
	<div class="ui-corner-all contentNav" id="nav">
		<div class="btnbanner btnbannerData">
			<@s.include value="/common/orgSelectedComponent.jsp"/>
			<div class="ui-widget autosearch">
				<input class="basic-input" type="text"  id="searchByCondition" class="searchtxt" placeholder='请输入粉丝昵称'/>
				<button id="refreshSearchKey" class="ui-icon ui-icon-refresh searchbtnico"></button>
			</div>
		</div>
		<a href="javascript:;" id="fastSearchButton"><span>搜索</span></a>
		<@pop.JugePermissionTag ename="searchInbox">
			<a id="search" href="javascript:void(0)"><span>高级搜索</span></a>
			<span class="lineBetween "></span>
			<!--<select id="dealState" class="basic-input">
		  		<option value="">全部</option>
		  			<option value='<@s.property value="@com.tianque.plugin.weChat.util.Constants@NOT_ACCEPT" />'>未受理</option>
					<option value='<@s.property value="@com.tianque.plugin.weChat.util.Constants@ACCEPT" />'>已受理</option>
			</select>
				<span class="lineBetween "></span>
			<select id="keyWordMsg" class="basic-input">
		  		     <option value=1 selected='selected'>隐藏关键字消息</option>
		  			<option value=0 >显示关键字消息</option>
			</select>
			-->
		</@pop.JugePermissionTag>
		<span class="lineBetween "></span>
		<@pop.JugePermissionTag ename="replyInbox">
			<!--<a id="reply" href="javascript:void(0)"><span>回复</span></a>-->
			<!--<a href="javascript:;" class="nav-dropdownBtn"><span>回复</span><b class="nav-dropdownBtn-arr"><b class="nav-ico-dArr"></b></b></a>
			<div class="nav-sub-buttons">
				<a id="sendTextMessage" href="javascript:void(0)"><span>文本</span></a>
				<a id="sendImageMessage" href="javascript:void(0)"><span>图片</span></a>
				<a id="sendNewsMessage" href="javascript:void(0)"><span>图文</span></a>
				<a id="sendVoiceMessage" href="javascript:void(0)"><span>语音</span></a>
			</div>-->
			<#--
			<a href="javascript:;" class="nav-dropdownBtn"><span>48小时后回复</span><b class="nav-dropdownBtn-arr"><b class="nav-ico-dArr"></b></b></a>
			<div class="nav-sub-buttons">
				<a id="sendTextMessageAfterFortyEight" href="javascript:void(0)"><span>文本</span></a>
				<a id="sendImageMessageAfterFortyEight" href="javascript:void(0)"><span>图片</span></a>
				<a id="sendNewsMessageAfterFortyEight" href="javascript:void(0)"><span>图文</span></a>
				<a id="sendVoiceMessageAfterFortyEight" href="javascript:void(0)"><span>语音</span></a>
			</div>
			-->
			<#--<a id="relayMsg" href="javascript:void(0)"><span>转发</span></a>-->
		</@pop.JugePermissionTag>
		<!--
		<@pop.JugePermissionTag ename="sendTemplateMessage">
			<a href="javascript:;" class="nav-dropdownBtn"><span>模板消息</span><b class="nav-dropdownBtn-arr"><b class="nav-ico-dArr"></b></b></a>
			<div class="nav-sub-buttons" style = "left:660px;width:120px;">
				<a id="sendMessageTemplateForReportNotice" href="javascript:void(0)"><span>举报办理进度通知</span></a>
				<a id="sendMessageTemplateForEventHandling" href="javascript:void(0)"><span>待处理通知</span></a>
			</div>
		</@pop.JugePermissionTag>
		-->
	<!--	<@pop.JugePermissionTag ename="setAvailability">
			<a href="javascript:;" class="nav-dropdownBtn"><span>设置</span><b class="nav-dropdownBtn-arr"><b class="nav-ico-dArr"></b></b></a>
			<div class="nav-sub-buttons">
				<a id="availability" href="javascript:void(0)"><span>有效</span></a>
				<a id="invalid" href="javascript:void(0)"><span>无效</span></a>
			</div>
		</@pop.JugePermissionTag>	-->
		<@pop.JugePermissionTag ename="deleteInbox">
			<a id="delete" href="javascript:void(0)"><span>删除</span></a>
		</@pop.JugePermissionTag>
		<a id="reload" href="javascript:void(0)"><span>刷新</span></a>
		<!--<@pop.JugePermissionTag ename="acceptIssue">
			<a id="EventsToAccept" href="javascript:void(0)"><span>事件受理</span></a>
		</@pop.JugePermissionTag>-->
		<@pop.JugePermissionTag ename="fanManagementByInbox">	
			<a id="fanManagement" href="javascript:void(0)"><span>粉丝管理</span></a>
		</@pop.JugePermissionTag>
		<#--
		<@pop.JugePermissionTag ename="sendRedEnvelope">
			<a id="sendRedEnvelope" href="javascript:void(0)"><span>发放红包</span></a>
		</@pop.JugePermissionTag>
		-->
	</div>
	<div style="clear: both;"></div>
	<div style="width: 100%;">
		<div id="jquery_jplayer_1" class="jp-jplayer"></div>
		<table id="inboxList"> </table>
		<div id="inboxListPager"></div>
	</div>
	<!--<div id="inboxDialog"></div>-->
	<div id="issueDialog"></div>
	<!--<div id="replyMessageDlg"></div>-->
	<div id="div01"></div>
	<div id="div02"></div>
	<div id="fanManagementDlg"></div>
</div>
<script type="text/javascript">
	//clearInterval(window.getInboxListTimer);
	//window.getInboxListTimer=setInterval("getInboxList({'inbox.org.id' :getCurrentOrgId(),'inbox.isKeyWordMsg':$('#keyWordMsg').val()})",150000);
$(document).ready(function(){
	$("#playMessageSound").hide();
	$("#inboxList").jqGridFunction({
		datatype: "local",
		sortname:"createTime",
		multiselect:true,
	   	colModel:[
	   	    {name:'inboxId',index:'inboxId',hidden:true,frozen:true,sortable:false},
	   	    {name:'msgId',index:'msgId',label:'信息id（隐藏）',frozen:true,hidden:true,sortable:false},
	   	    {name:'fromUserName',index:'from_User_Name',label:'粉丝唯一标识',hidden:true,sortable:true,width:150},
	   	    {name:'toUserName',index:'to_User_Name',label:'公众平台账号（隐藏）',frozen:true,hidden:true,sortable:false},
	   	  	{name:'msgType',index:"msg_Type",label:'消息类型（隐藏）',frozen:true,hidden:true,sortable:false},
	   	  	{name:'fanId',index:'fan_id',label:'粉丝id（隐藏）',frozen:true,hidden:true,sortable:false},
	   	    {name:'lat',index:'lat',label:'纬度',frozen:true,hidden:true,sortable:false},
	   	    {name:'lng',index:'lng',label:'经度',frozen:true,hidden:true,sortable:false},
	   	    {name:"encryptIdByIssueId",index:'encryptIdByIssueId',frozen:true,hidden:true},
	   	    {name:'copyInboxAttachmentsMesg',frozen:true,hidden:true,formatter:copyInboxAttachmentsMesg},
	   	    {name:'groupName',index:'group_name',label:'所属群组',sortable:false,width:60,align:'center'},
	   	    {name:'createUser',index:'createUser',label:'粉丝昵称',sortable:true,width:80,align:'center'},
	   	    {name:'nickName',index:'nickName',label:'备注名',sortable:false,width:80,align:'center'},
	   	    {name:'content',index:'content',label:'内容',sortable:false,width:300,align:'center'},
	   	    {name:'inboxAttachments',label:'附件',sortable:false,align:'center',formatter:viewAttachFile,width:100},
	   	 //   {name:'availability',index:'availability',label:'有/无效',sortable:false,width:50,formatter:formatterAvailability},
	   	    {name:'dealStateName',index:'deal_State',label:'受理状态',sortable:false,formatter:formatterSeachIssue,width:50,align:'center'},
	   	    {name:'serviceId',index:'serviceId',label:'服务单号',sortable:false,width:50,align:'center'},
	   	 //   {name:'forwardingStateName',index:'forwardingState',label:'转发状态',sortable:false,width:50,formatter:formatterForwardingStateName,align:'center'},
	   	 //   {name:'count',label:'回复',sortable:false,formatter:formatterSeachRM,align:'center',width:80},
	   	    {name:'weChatUserName',index:'weChat_user_name',label:'公众号',sortable:false,width:80,align:'center'},
	   	    {name:'createTime',index:"createTime",label:'接收时间',sortable:true,width:120,align:'center'} 	  
		],
		shrinkToFit:true,
		loadComplete:loadFiles
	});
	getInboxList({
		"inbox.org.id" :getCurrentOrgId(),
		"inbox.dealState" :1,//dealState=0表示消息处于未处理状态
		"inbox.isKeyWordMsg" :2//isKeyWordMsg=2表示非关键字消息
	});
	// 刷新
	$("#reload").click(function() {
		getInboxList({
			"inbox.org.id" :getCurrentOrgId(),
		    "inbox.dealState" :1,//dealState=0表示消息处于未处理状态
		    "inbox.isKeyWordMsg" :2//isKeyWordMsg=2表示非关键字消息
		});
	});
	//已受理或是未受理
	$("#dealState").change(function(){
	  	getInboxList({
			"inbox.org.id" :getCurrentOrgId(),
			"inbox.isKeyWordMsg":$("#keyWordMsg").val(),
			"inbox.dealState" : $("#dealState").val()
		});
	});
	
	//隐藏/显示关键字消息
	$("#keyWordMsg").change(function(){
	  	getInboxList({
			"inbox.org.id" :getCurrentOrgId(),
			"inbox.isKeyWordMsg":$("#keyWordMsg").val()
		});
	});
	//转发
	$("#relayMsg").click(function(){
		   var allValue = getSelectedIds();
			if(allValue.length ==0||allValue.length>1){
				$.messageBox({level : 'warn',message:"请选择一条数据，再进行回复！"});
				return;
			}
		  var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
		  if(rowdata["weChatUserName"]=="已删除的公众号"){
		     $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再回复信息！"});
			 return;
		   }
		   var msgName="";
		   var msg=rowdata["msgType"];
		   var heightTemp=280;
		   if(msg=="image"){
			     heightTemp=500;
			     msgName="图片"
		   }else if(msg=="voice"){
			     msgName="语音"
		   }
		   else if(msg=="text"){
	   		      msgName="文本"
		   }
		   else if(msg=="location"){
	   		       msgName="地理位置"
		   }
		   $("#replyMessageDlg").createDialog({
			width: 800,
			height: heightTemp,
			title:'转发平台消息-'+msgName,
			url:'${path}/weChat/inbox/dispatch.action?mode=retransmissionMsg&inbox.inboxId='+allValue,
			buttons: {
				"转发" : function(event){
				      $("#maintainForm").submit();
			   },
			   "取消" : function(){
			         $(this).dialog("close");
			   }
			}
		});
			
	})
	//有效
	$("#availability").click(function(){
	   var allValue = getSelectedIds();
		if(null==allValue||""==allValue){
			$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
	 		return;
		}
		for (i = 0; i < allValue.length; i++) {
			   var rowdata=$("#inboxList").jqGrid('getRowData',allValue[i]); 
			   if(rowdata["availability"]=="有效")
			   {
				   var createUser=rowdata["createUser"];
				   $.messageBox({level:"warn",message:"发信人:["+createUser+"]有事件已经设置为有效，不能在执行此操作！"});
			 		return;  
			   } 
		  }
		  
		  $.confirm({
			title:"设置有效",
			message:"确认将该事件设置为有效，确认有效？",
			width: 300,
			okFunc: function(){
				$.ajax({
					url:"${path}/weChat/inbox/setAvailability.action?inboxIds="+allValue,
					success:function(data){
						if(data!=true && data!="true" ){
							$.messageBox({message:data,level:"error"});
							return ;
						}
						$("#inboxList").trigger("reloadGrid");
						$.messageBox({message:"设置成功！"});
					}
				});
			}
		});
	})
	
	//无效
	$("#invalid").click(function(){
	   var allValue = getSelectedIds();
		if(null==allValue||""==allValue){
			$.messageBox({level:"warn",message:"请选择一条数据再进行操作！"});
	 		return;
		}
		for (i = 0; i < allValue.length; i++) {
			   var rowdata=$("#inboxList").jqGrid('getRowData',allValue[i]); 
			   if(rowdata["availability"]=="无效")
			   {
				   var createUser=rowdata["createUser"];
				   $.messageBox({level:"warn",message:"发信人:["+createUser+"]有事件已经设置为无效，不能在执行此操作！"});
			 		return;  
			   } 
		  }
		  
		  $.confirm({
			title:"设置无效",
			message:"确认将该事件设置为无效，确认无效？",
			width: 300,
			okFunc: function(){
				$.ajax({
					url:"${path}/weChat/inbox/setInvalid.action?inboxIds="+allValue,
					success:function(data){
						if(data!=true && data!="true" ){
							$.messageBox({message:data,level:"error"});
							return ;
						}
						$("#inboxList").trigger("reloadGrid");
						$.messageBox({message:"设置成功！"});
					}
				});
			}
		});
	})
	
	//回复粉丝互动时间超过48小时之后的消息(文本)
	$("#sendTextMessageAfterFortyEight").click(function(event){
        var allValue = getSelectedIds();
		if(allValue.length ==0||allValue.length>1){
			$.messageBox({level : 'warn',message:"请选择一条数据，再进行回复！"});
			return;
		}
		var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
		if(rowdata["weChatUserName"]=="已删除的公众号"){
		     $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再回复信息！"});
			 return;
		}
	  $.ajax({
				url:"${path}/weChat/inbox/checkDateMoreThanFortyEight.action?inbox.createTime="+rowdata["createTime"],
				success:function(data){
					if(data!=true && data!="true" ){
						$.messageBox({message:data,level:"error"});
						return false ;
					}else{
						$("#replyMessageDlg").createDialog({
							width: 800,
							height: 300,
							title:'回复平台消息-文本',
							url:'${path}/weChat/inbox/dispatch.action?mode=replyMoreFortyEightTextMessage&inbox.inboxId='+allValue,
							buttons: {
								"回复" : function(event){
								      $("#maintainForm").submit();
							   },
							   "取消" : function(){
							         $(this).dialog("close");
							   },
							    "再回复一封" : function(event){
								   $("#isCloseWindow").val('false');
								   $("#maintainForm").submit();
							   }
							}
						});
					}
				}
		});		
	});
	
	//回复消息(文本)
	$("#sendTextMessage").click(function(event){
        var allValue = getSelectedIds();
		if(allValue.length ==0||allValue.length>1){
			$.messageBox({level : 'warn',message:"请选择一条数据，再进行回复！"});
			return;
		}
		  var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
		  if(rowdata["weChatUserName"]=="已删除的公众号"){
		     $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再回复信息！"});
			 return;
			}
	  $.ajax({
				url:"${path}/weChat/inbox/checkDate.action?inbox.createTime="+rowdata["createTime"],
				success:function(data){
					if(data!=true && data!="true" ){
						$.messageBox({message:data,level:"error"});
						return false ;
					}else{
						$("#replyMessageDlg").createDialog({
							width: 800,
							height: 300,
							title:'回复平台消息-文本',
							url:'${path}/weChat/inbox/dispatch.action?mode=replyTextMessage&inbox.inboxId='+allValue,
							buttons: {
								"回复" : function(event){
								      $("#maintainForm").submit();
							   },
							   "取消" : function(){
							         $(this).dialog("close");
							   },
							    "再回复一封" : function(event){
								   $("#isCloseWindow").val('false');
								   $("#maintainForm").submit();
							   }
							}
						});
					
					}
				}
			});		
	});
	//回复消息(图片)
	$("#sendImageMessage").click(function(event){
	var allValue = getSelectedIds();
		if(allValue.length ==0||allValue.length>1){
			$.messageBox({level : 'warn',message:"请选择一条数据，再进行回复！"});
			return;
		}
          var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
		  if(rowdata["weChatUserName"]=="已删除的公众号"){
		     $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再回复信息！"});
			 return;
			}
			
	  $.ajax({
				url:"${path}/weChat/inbox/checkDate.action?inbox.createTime="+rowdata["createTime"],
				success:function(data){
					if(data!=true && data!="true" ){
						$.messageBox({message:data,level:"error"});
						return false ;
					}else{
						$("#replyMessageDlg").createDialog({
							width: 800,
							height: 250,
							title:'回复平台消息-图片',
							url:'${path}/weChat/inbox/dispatch.action?mode=replyImageMessage&inbox.inboxId='+allValue,
							buttons: {
								"回复" : function(event){
								      $("#maintainForm").submit();
							   },
							   "取消" : function(){
							         $(this).dialog("close");
							   },
							   "再回复一封" : function(event){
								   $("#isCloseWindow").val('false');
								   $("#maintainForm").submit();
							   }
							}
						});
				  }
				}
			});		
	});
	//回复粉丝互动时间超过48小时之后消息(图片)
	$("#sendImageMessageAfterFortyEight").click(function(event){
		var allValue = getSelectedIds();
		if(allValue.length ==0||allValue.length>1){
			$.messageBox({level : 'warn',message:"请选择一条数据，再进行回复！"});
			return;
		}
          var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
		  if(rowdata["weChatUserName"]=="已删除的公众号"){
		     $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再回复信息！"});
			 return;
			}
			
	  $.ajax({
				url:"${path}/weChat/inbox/checkDateMoreThanFortyEight.action?inbox.createTime="+rowdata["createTime"],
				success:function(data){
					if(data!=true && data!="true" ){
						$.messageBox({message:data,level:"error"});
						return false ;
					}else{
						$("#replyMessageDlg").createDialog({
							width: 800,
							height: 250,
							title:'回复平台消息-图片',
							url:'${path}/weChat/inbox/dispatch.action?mode=replyMoreFortyEightImageMessage&inbox.inboxId='+allValue,
							buttons: {
								"回复" : function(event){
								      $("#maintainForm").submit();
							   },
							   "取消" : function(){
							         $(this).dialog("close");
							   },
							   "再回复一封" : function(event){
								   $("#isCloseWindow").val('false');
								   $("#maintainForm").submit();
							   }
							}
						});
				  }
				}
			});		
	});
	//回复消息(图文)
	$("#sendNewsMessage").click(function(event){
	var allValue = getSelectedIds();
		if(allValue.length ==0||allValue.length>1){
			$.messageBox({level : 'warn',message:"请选择一条数据，再进行回复！"});
			return;
		}
		 var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
		  if(rowdata["weChatUserName"]=="已删除的公众号"){
		     $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再回复信息！"});
			 return;
			}
		  $.ajax({
				url:"${path}/weChat/inbox/checkDate.action?inbox.createTime="+rowdata["createTime"],
				success:function(data){
					if(data!=true && data!="true" ){
						$.messageBox({message:data,level:"error"});
						return false ;
					}else{
							$("#replyMessageDlg").createDialog({
								width: 750,
								height: 400,
								title:'回复平台消息-图文',
								url:'${path}/weChat/inbox/dispatch.action?mode=replyNewsMessage&inbox.inboxId='+allValue,
								buttons: {
									"回复" : function(event){
									      $("#maintainForm").submit();
								   },
								   "取消" : function(){
								         $(this).dialog("close");
								   },
								   "再回复一封" : function(event){
									   $("#isCloseWindow").val('false');
									   $("#maintainForm").submit();
								   }
								}
							});
		              }
				}
			});	
	});
	//回复粉丝互动时间超过48小时之后消息(图文)
	$("#sendNewsMessageAfterFortyEight").click(function(event){
		var allValue = getSelectedIds();
		if(allValue.length ==0||allValue.length>1){
			$.messageBox({level : 'warn',message:"请选择一条数据，再进行回复！"});
			return;
		}
		 var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
		  if(rowdata["weChatUserName"]=="已删除的公众号"){
		     $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再回复信息！"});
			 return;
			}
		  $.ajax({
				url:"${path}/weChat/inbox/checkDateMoreThanFortyEight.action?inbox.createTime="+rowdata["createTime"],
				success:function(data){
					if(data!=true && data!="true" ){
						$.messageBox({message:data,level:"error"});
						return false ;
					}else{
							$("#replyMessageDlg").createDialog({
								width: 750,
								height: 400,
								title:'回复平台消息-图文',
								url:'${path}/weChat/inbox/dispatch.action?mode=replyMoreFortyEightNewsMessage&inbox.inboxId='+allValue,
								buttons: {
									"回复" : function(event){
									      $("#maintainForm").submit();
								   },
								   "取消" : function(){
								         $(this).dialog("close");
								   },
								   "再回复一封" : function(event){
									   $("#isCloseWindow").val('false');
									   $("#maintainForm").submit();
								   }
								}
							});
		              }
				}
			});	
	});
	//回复消息(语音)
	$("#sendVoiceMessage").click(function(event){
	   var allValue = getSelectedIds();
		if(allValue.length ==0||allValue.length>1){
			$.messageBox({level : 'warn',message:"请选择一条数据，再进行回复！"});
			return;
		}
		 var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
		  if(rowdata["weChatUserName"]=="已删除的公众号"){
		     $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再回复信息！"});
			 return;
			}
		 $.ajax({
				url:"${path}/weChat/inbox/checkDate.action?inbox.createTime="+rowdata["createTime"],
				success:function(data){
					if(data!=true && data!="true" ){
						$.messageBox({message:data,level:"error"});
						return false ;
					}else{	
							$("#replyMessageDlg").createDialog({
								width: 800,
								height: 200,
								title:'回复平台消息-语音',
							    url:'${path}/weChat/inbox/dispatch.action?mode=replyVoiceMessage&inbox.inboxId='+allValue,
								buttons: {
									"回复" : function(event){
									      $("#maintainForm").submit();
								   },
								   "取消" : function(){
								         $(this).dialog("close");
								   },
								   "再回复一封" : function(event){
									   $("#isCloseWindow").val('false');
									   $("#maintainForm").submit();
								   }
								}
							});
		             }
				}
			});	
	});
	//回复粉丝互动时间超过48小时之后消息(语音)
	$("#sendVoiceMessageAfterFortyEight").click(function(event){
	    var allValue = getSelectedIds();
		if(allValue.length ==0||allValue.length>1){
			$.messageBox({level : 'warn',message:"请选择一条数据，再进行回复！"});
			return;
		}
		 var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
		  if(rowdata["weChatUserName"]=="已删除的公众号"){
		     $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再回复信息！"});
			 return;
			}
		 $.ajax({
				url:"${path}/weChat/inbox/checkDateMoreThanFortyEight.action?inbox.createTime="+rowdata["createTime"],
				success:function(data){
					if(data!=true && data!="true" ){
						$.messageBox({message:data,level:"error"});
						return false ;
					}else{	
							$("#replyMessageDlg").createDialog({
								width: 800,
								height: 200,
								title:'回复平台消息-语音',
							    url:'${path}/weChat/inbox/dispatch.action?mode=replyMoreFortyEightVoiceMessage&inbox.inboxId='+allValue,
								buttons: {
									"回复" : function(event){
									      $("#maintainForm").submit();
								   },
								   "取消" : function(){
								         $(this).dialog("close");
								   },
								   "再回复一封" : function(event){
									   $("#isCloseWindow").val('false');
									   $("#maintainForm").submit();
								   }
								}
							});
		             }
				}
			});	
	});
	//没用
	$("#reply").click(function(){
		var allValue = getSelectedIds();
		if(allValue.length ==0||allValue.length>1){
			$.messageBox({level : 'warn',message:"请选择一条数据，再进行回复！"});
			return;
		}
		$("#inboxDialog").createDialog({
			title:"回复消息",
			width: 640,
			height: 350,
			url:'${path}/weChat/inbox/dispatch.action?mode=replyMessage&inbox.inboxId='+allValue,
			buttons: {
				"保存" : function(event){
		   			$("#replyForm").submit();
				},
				"关闭" : function(event){
					$(this).dialog("close");
				}
			}
		});
	});
	$("#jquery_jplayer_1").jPlayer({
		ready: function () {
			
		},
		swfPath: "/resource/external/jPlayer/js",
		solution: "flash, html",
		supplied: "mp3,m4a,flv,arm",
		wmode: "window",
		keyEnabled: true
	});
	$("#inboxList").delegate(".jp-play", "click", function(){
		var media=$(this).data("media");
		var type=$(this).data("type");
		$("#jquery_jplayer_1").jPlayer( "clearMedia" );
		var box=$(this).closest(".jp-audio");
		$(this).hide().next().show();
		$("#jquery_jplayer_1").jPlayer("setMedia", {
			"mp3": media
		}).jPlayer("play");
	})
	$("#inboxList").delegate(".jp-pause", "click", function(){
		$(this).hide().prev().show();
		$("#jquery_jplayer_1").jPlayer("stop");
	});
	
	$("#fanManagement").click(function(){
		var allValue = getSelectedIds();
		if(allValue.length ==0||allValue.length>1){
			$.messageBox({level : 'warn',message:"请选择一条数据，再进行粉丝管理操作！"});
			return;
		}
		var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
		$("#fanManagementDlg").createDialog({
			width: 700,
			height: 300,
			title:'粉丝管理',
			url:'${path}/fanManage/dispatch.action?mode=fanManagement&fan.fanId='+rowdata.fanId+'&fan.weChatUserId='+rowdata.toUserName+'&fanIds='+rowdata.fanId,
			buttons: {
				"保存" : function(event){
		   			$("#fanManagementForm").submit();
				},
				"关闭" : function(event){
					$(this).dialog("close");
				}
			}
		});
	
	});
});

$("#refreshSearchKey").click(function(){
	$("#searchByCondition").attr("value","请输入粉丝昵称");
    getInboxList({
		"inbox.org.id" :getCurrentOrgId(),
		"inbox.dealState" :1,//dealState=0表示消息处于未处理状态
		"inbox.isKeyWordMsg" :2//isKeyWordMsg=2表示非关键字消息
	});
});

//搜索
 $("#fastSearchButton").click(function(){
	 var createUser=$("#searchByCondition").val();
	 if(createUser!=null&&"请输入粉丝昵称"!=createUser){
		 var queryObj = {
			"inbox.org.id" : getCurrentOrgId(),
		    //"inbox.isKeyWordMsg":$("#keyWordMsg").val(),
		    "inbox.dealState" : 1,
			"inbox.createUser" : createUser
		};
		getInboxList(queryObj);
	}
});

 //高级搜索
 $("#search").click(function(event){
	$("#inboxDialog").createDialog({
			width:550,
			height:350,
			title:"消息管理查询-请输入查询条件",
			url:'${path}/weChat/inbox/dispatch.action?mode=search&inbox.org.id='+getCurrentOrgId(),
			buttons:{
				"查询" : function(event) {
					searchInbox();
					$(this).dialog("close");
				},
				"关闭" : function() {
					$(this).dialog("close");
				}
			}
	});
 });
 
function searchInbox(){
	var queryObj = {
		"inbox.org.id" : getCurrentOrgId(),
		"inbox.createUser" : $("#inputCreateUser").val(),
		"inbox.content" : $("#content").val(),
		"inbox.startCreateTime" : $("#startCreateTime").val(),
		"inbox.endCreateTime" : $("#endCreateTime").val(),
		//"inbox.availability" : $("#availabilitys").val(),
		"inbox.dealState"    : 1,
		"inbox.serviceId"    :$("#serviceId").val(),
		//"inbox.isKeyWordMsg"    :$("#keyWordMsgBySearch").val(),
		//"inbox.nickName" : $("#createUser").val(),
		"inbox.groupId":$("#groupId").val()
		//"inbox.forwardingState":$("#forwardingStateBySearch").val()
		};
	getInboxList(queryObj);
 }
function getSelectedIds(){
		var selectedIds = $("#inboxList").jqGrid("getGridParam", "selarrrow");
		return selectedIds;
}
 // 删除
$("#delete").click(function(event) {
		var allValue = getSelectedIds();
			if(allValue.length ==0){
				$.messageBox({level : 'warn',message:"请选择一条或多条记录，再进行删除！"});
				return;
			}
		$.confirm({
			message:"是否真的删除选中信息？",
			okFunc: function(){
				deleteInboxById(event,allValue);
			}
		});
});

//删除主程序
function deleteInboxById(event,allValue){
	$.ajax({
		url: PATH
		+ '/weChat/inbox/deleteInboxById.action?inboxIds='
		+ allValue,
		success : function(res) {
			if (res) {
				var idArr = allValue.toString().split(",");
				for(var i = 0; i < idArr.length; i++) {
					$("#inboxList")
					.delRowData(idArr[i]);
				}
				$.messageBox({message : "删除成功!"});
				$("#inboxList").trigger("reloadGrid"); 
				return;
			}
			$.messageBox({message : "删除失败!"});
		}
	});
}

 // 事件受理
$("#EventsToAccept").click(function(event,rowData) {
		var allValue = getSelectedIds();
		if(allValue.length ==0){
			$.messageBox({level : 'warn',message:"请选择一条或多条记录，再进行受理！"});
			return;
		}
		var inbox;
		var fromUserName;
		var dealStateName;
		for(var i=0,len=allValue.length; i<len; i++){
			inbox =  $("#inboxList").getRowData(allValue[i]);
			if(i==0){
			fromUserName=inbox.fromUserName;
			}
			dealStateName=inbox.dealStateName;
			if(dealStateName.indexOf('已受理')>0){
				$.messageBox({level : 'warn',message:"该数据已受理，请再重新选择！"});
				return;
			}
			if(fromUserName!=inbox.fromUserName){
				$.messageBox({level : 'warn',message:"请选择同一个发信人，再进行事件受理！"});
				return;
			}	
		}
		
		$("#issueDialog").createDialog({
			width:840,
			height:600,
			title: '转为事件处理',
			url: PATH+ "/issues/issueManage/dispatch.action?mode=eventsToAccept&keyId=<@s.property value='@com.tianque.core.util.ThreadVariable@getOrganization().id'/>&inboxIds="+allValue,
			
			buttons: {
		   		"保存" : function(event){
					//$("#issueMaintainForm").submit();					
	   			},
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		} 
			}
		});

});

//列表显示
function getInboxList(obj){
	$("#inboxList").setGridParam({
		url:'${path}/weChat/inbox/findInboxs.action',
		datatype: "json",
		page:1,
		mytype:"post"
	});
	$("#inboxList").setPostData(obj);
	$("#inboxList").trigger("reloadGrid"); 
}

function playMusic(){
	$.ajax({
		url: '${path}/weChat/inbox/playMessageSound.action',
		success : function(data) {
			if(data=="true"){
				var div = document.getElementById('div01');
			    div.innerHTML = '<embed src="/resource/music/您有新的消息需要处理.wav" loop="0" autostart="true" hidden="true"></embed>';
			    var emb = document.getElementsByTagName('EMBED')[0];
			    if (emb) {
			        div = document.getElementById('div02');
			        div.innerHTML = 'loading: '+emb.src;
			        setTimeout(function(){div.innerHTML='';},1000);
		    	}
			}
		}
	});
}
//查看回复
function viewReplyMessage(selectedId){
	$("#inboxDialog").createDialog({
		width: 600,
		height: 240,
		title: '回复记录',
		url:'${path}/weChat/inbox/dispatch.action?mode=viewReplyMessage&inboxId='+selectedId,
		buttons: {
			"关闭" : function(){
				$(this).dialog("close");
			}
		}
	});	
}
//加载文件
function loadFiles() {
	$.each($(".popUpMore"), function(i, n){
		var popMoreData = [];
		$.each($("#inboxList").data($(n).attr("serviceRecordId")),function(ind, fn){
			popMoreData[ind]={id:fn.inboxAttachmentId, url:'${path}/weChat/inbox/downloadInboxAttachment.action?attachmentId='+fn.inboxAttachmentId, text:fn.fileName,clickFun:function(){}};
		});
		$(n).popUpMore({data: popMoreData});
	});
}
//附件
function formatterAttachFile(el,options,rowData){
	if(rowData.inboxAttachments.length>0){
		$("#inboxList").data(String(rowData.inboxId), rowData.inboxAttachments);
		return "<div style='clear:both' align='center'><a href='javascript:;' id='inbox_"+rowData.inboxId+"' style='color:#666666' class='popUpMore' serviceRecordId='"+rowData.inboxId+"' >附件>></a></div>";
	}
	return "";
}
function viewAttachFile(el,options,rowData){
	if(rowData.inboxAttachments.length>0 && rowData.inboxAttachments[0].extFileName=='jpg'){
		return "<a href='javascript:;' onclick='viewFile("+rowData.inboxAttachments[0].inboxAttachmentId+")' ><img src='"+rowData.inboxAttachments[0].fileActualUrl+"' style='width:32px;height:32px;'/></a>";
	}else if(rowData.inboxAttachments.length>0){
		return '<div id="jp_container_1" class="jp-audio"><a href="javascript:;" class="jp-play" data-type="'+rowData.inboxAttachments[0].extFileName+'" data-media="'+rowData.inboxAttachments[0].fileActualUrl+'"><img src="/resource/system/images/jplayer/play.png" /></a><a href="javascript:;" class="jp-pause" tabindex="1"><img src="/resource/system/images/jplayer/stop.gif" /></a><div class="jp-time"><div class="jp-current-time"></div><div class="jp-duration"></div></div></div>';
	}else if(rowData.msgType!=null && rowData.msgType=='location'){
		return "<a href=javascript:; onclick=viewMap("+rowData.lat+","+rowData.lng+",'"+rowData.content+"') ><img src='/resource/openLayersMap/images/bubble.png' /></a>";
	}else{
		return '';
	}
}
//地图显示
//	function viewMap(lat,lng,content){
//	   $("#replyMessageDlg").createDialog({
//			width: 800,
//			height: 500,
//			title:'显示地理位置信息',
//			url:"${path}/wechat/mapView.jsp?lat="+lat+"&lng="+lng+"&title="+content,
//			buttons: {
//			   "关闭" : function(){
//			         $(this).dialog("close");
//			   }
//			}
//		});
//	}

//格式化有无效
function formatterAvailability(el,options,rowData){
	if(rowData.availability=='1'){
	  return "有效";
	}else if(rowData.availability=='2')
	  return "无效";
	else
	  return "无效";
}
//格式化已转发或未转发
function formatterForwardingStateName(el,options,rowData){
	 if(rowData.forwardingStateName=='已转发')
	   return "<span style='color:blue'>已转发</span>";
	 else
	  return rowData.forwardingStateName;
}


function formatterSeachIssue(el,options,rowData){
	if(rowData.dealStateName=='已受理'){
		$("#inboxList").data(String(rowData.inboxId), rowData.dealStateName);
		return "<a href='javascript:;' onclick='inspectionOperator("+rowData.inboxId+")' id='inbox_"+rowData.inboxId+"' style='color:red;' class='popUpMore' inboxId='"+rowData.inboxId+"' >已受理</a>";
	}
	return rowData.dealStateName;
}
//格式化消息类型
function formatterMsgType(el,options,rowData){
	if(rowData.msgType=='text')
	  return "文本";
	else if(rowData.msgType=='image')
	  return "图片";
	else if(rowData.msgType=='voice')
	  return "语音";
	else if(rowData.msgType=='location')
	  return "地理位置";
	else
	  return "";
}

//查询回复
function formatterSeachRM(el,options,rowData){
	var count=rowData.count;
	if(rowData.count!=0){
		$("#inboxList").data(String(rowData.inboxId), rowData.dealStateName);
		return "<div style='clear:both' align='center'><a href='javascript:;' onclick='viewReplyMessage("+rowData.inboxId+")' id='inbox_"+rowData.inboxId+"' style='color:green;' >"+count+"</a><div>";
	}
	return " ";
}
//已受理的查看页面
function inspectionOperator(inboxId){
    var selectedData=$("#inboxList").getRowData(inboxId);
	var evaluationType="";
	var statusType= "" ;
//		if("completed" == $("#jurisdictionsViewType").val()||"checkGrade" == $("#jurisdictionsViewType").val()||"publicltyCassDone" == $("#jurisdictionsViewType").val()){
//			statusType = rowData.moveMark; 
//		}else{
//			statusType = statusTypeFunction();
//		}
//		$("#_searchStatusType").val(statusType);
// 		var evaluationType =  $("#_statusTypeSelect").val();
	$("#issueDialog").createDialog({
		width: 880,
		height: 500,
		title: "查看事件详情",
		url: "${path}/issues/issueManage/dispatch.action?mode=viewNew&keyId="+selectedData.encryptIdByIssueId+"&statusType="+statusType+"&evaluationType="+evaluationType,
		buttons: {
	   		"关闭" : function(){
	        	$(this).dialog("close");
	   		}
		}
	});
}

//function viewFile(inboxAttachmentId){
//	$("#inboxDialog").createDialog({
//		title:"查看附件",
//		width: 550,
//		height: 550,
//		url:'${path}/weChat/inbox/dispatch.action?mode=playMedia&attachmentId='+inboxAttachmentId,
//		buttons: {
//			"关闭" : function(event){
//				$(this).dialog("close");
//			}
//		}
//	});
//}
//选择所需的红包配置，进行发放红包
$("#sendRedEnvelope").click(function(){
	if(USER_ORG_ID != $("#currentOrgId").val()){
		$.messageBox({message:"只能对本级部门发放红包!",level:"warn"});
		return;
	}
	var allValue = getSelectedIds();
	if(allValue.length ==0||allValue.length>1){
		$.messageBox({level : 'warn',message:"请选择一条数据，再进行操作！"});
		return;
	}
	var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
	if(rowdata["weChatUserName"]=="已删除的公众号"){
		$.messageBox({level : 'warn',message:"该公众号已经被删除，不能再操作！"});
		return;	 
	}	
	var fanId = rowdata.fanId;
	var openId ="";
	$.ajax({
		url:"${path}/fanManage/getFanObject.action?fan.fanId="+fanId,
		async:false,
		success:function(data){
			if(data != null && data.fanId && data.openId){
				openId=data.openId;
			}else{
				$.messageBox({message:data,level:"error"});
				return;
			}
		}
	});
	$("#inboxDialog").createDialog({
		width: 820,
		height: 580,
		title:'选择所需的红包配置',
		url:'${path}/hotModuel/redEnvelopeManagement/administrationRedEnvelopeForInBox.ftl?fanId='+fanId,
		buttons: {			
		   "发送" : function(){
		   		sendRedEnvelope(openId);
		   },
		   "关闭" : function(){
				$(this).dialog("close");
		   }
		}
	});
});
$("#sendMessageTemplateForReportNotice").click(function(){ 
	if(USER_ORG_ID != $("#currentOrgId").val()){
		$.messageBox({message:"只能对本级部门发送消息模板!",level:"warn"});
		return;
	}
	var allValue = getSelectedIds();
	if(allValue.length ==0||allValue.length>1){
		$.messageBox({level : 'warn',message:"请选择一条数据，再进行发送！"});
		return;
	}
	var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
	if(rowdata["weChatUserName"]=="已删除的公众号"){
	    $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再发送信息！"});
		return;
	}
	var templateType = <@s.property value='@com.tianque.plugin.weChat.constant.MessageTemplateConstant@REPORT_PROGRESS_NOTICE_VALUE'/>;
	$("#replyMessageDlg").createDialog({
		width: 800,
		height: 450,
		title:'消息模板-举报办理进度通知',
	    url:"${path}/messageTemplateManage/dispatch.action?templateType="+templateType+"&inbox.inboxId="+allValue,
		buttons: {
		   "发送" : function(event){
			      $("#maintainForm").submit();
		   },
		   "取消" : function(){
		         $(this).dialog("close");
		   }
		}
	});
});
$("#sendMessageTemplateForEventHandling").click(function(){ 
	if(USER_ORG_ID != $("#currentOrgId").val()){
		$.messageBox({message:"只能对本级部门发送消息模板!",level:"warn"});
		return;
	}
	var allValue = getSelectedIds();
	if(allValue.length ==0||allValue.length>1){
		$.messageBox({level : 'warn',message:"请选择一条数据，再进行发送！"});
		return;
	}
	var rowdata=$("#inboxList").jqGrid('getRowData',allValue); 
	if(rowdata["weChatUserName"]=="已删除的公众号"){
	    $.messageBox({level : 'warn',message:"该公众号已经被删除，不能再发送信息！"});
		return;
	}
	var templateType = <@s.property value='@com.tianque.plugin.weChat.constant.MessageTemplateConstant@NOTICE_TO_BE_PROCESSED_VALUE'/>;
	$("#replyMessageDlg").createDialog({
		width: 800,
		height: 450,
		title:'消息模板-待处理通知',
	    url:"${path}/messageTemplateManage/dispatch.action?templateType="+templateType+"&inbox.inboxId="+allValue,
		buttons: {
		   "发送" : function(event){
			      $("#maintainForm").submit();
		   },
		   "取消" : function(){
		         $(this).dialog("close");
		   }
		}
	});
});
//复制一份附件信息
function copyInboxAttachmentsMesg(el,options,rowData){
	var attachment=rowData.inboxAttachments[0];
	if(rowData.inboxAttachments.length>0 && rowData.inboxAttachments[0].extFileName=='jpg'){
		return "img,"+attachment.inboxAttachmentId+","+attachment.fileName+","+attachment.fileActualUrl;
	}else if(rowData.inboxAttachments.length>0){
		return "radio,"+attachment.inboxAttachmentId+","+attachment.fileName+","+attachment.fileActualUrl;
	}
	return '';
}
</script>



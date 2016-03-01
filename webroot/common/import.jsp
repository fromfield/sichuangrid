<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/includes/baseInclude.jsp"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<style type="text/css">
.loadmask {z-index: 9999;position: absolute;top:0;left:0;-moz-opacity: 0.5;opacity: .50;filter: alpha(opacity=50);background-color: #CCC;width: 100%;height: 100%;zoom: 1;}
.loadmask-msg {z-index: 20001;position: absolute;top: 0;left: 0;background:#fff;}
.masked {overflow: hidden !important;}
.masked-relative {position: relative !important;}
.masked-hidden {visibility: hidden !important;}
#buttons{width:300px;height:100px;background:#fff;}
#load {position:relative;}
#load .ui-button{width:80px;height:25px;}
#load .ui-dialog-buttonset{position:absolute;bottom:20px;right:15px;}
</style>

<form id="mForm" method="post" enctype="multipart/form-data" action="${path}/dataTransfer/importToDomain.action">
	<pop:token />
	<input type="hidden" value="1" name="formFlag"> 
	<div id="upload-div" class="container container_24">
		<div class="grid_24 heightAuto">
		    <label class="form-lbl heightAuto" id="templateVersion">
		            <font color="red"><s:property value="@com.tianque.core.util.BaseInfoTables@getTypeDisplayNames(#parameters.templates)"/></font>&nbsp;导入功能支持的数据模板为
		            <font color="red"><s:property value="@com.tianque.datatransfer.ImportTemplatesSetting@getImportTemplatesVo(#parameters.templates).version"/></font>
		                               版本，如数据模板版本不正确，您可以下载	<a href='${path}/dataTransfer/downloadDataTemplate.action?dataTemplatesName=<s:property value="@com.tianque.datatransfer.ImportTemplatesSetting@getImportTemplatesVo(#parameters.templates).url"/>&sid=<s:property value="@com.tianque.core.util.ThreadVariable@getSession().getSessionId()"/>'><b><font color="dimgray"><i>最新数据模板</i></font></b></a>
            </label>
		</div>
		<div id="importBox">
			<div style="clear: both;">&nbsp;</div>
			<div class="grid_6 lable-right"  >
				<label class="form-lbl">选择文件：</label>
			</div>
			<div class="grid_18" style="">
				<input id="fileToUpload" type="file" value="" name="upload">
				<input name="dataType" value="<s:property value='#parameters.dataType'/>" type="hidden">
				<input name="templates" value="<s:property value='#parameters.templates'/>" type="hidden">
				<input id="dialog" value="<s:property value='#parameters.dialog'/>" type="hidden">
				<input name="startRow" value="<s:property value='#parameters.startRow'/>" type="hidden">
				<input name="enterpriseType" value="<s:property value='#parameters.enterpriseType'/>" type="hidden">
				<input id="isNew" name="isNew" value="<s:property value='#parameters.isNew'/>" type="hidden">
				<input id="module" name="module" value="<s:property value='#parameters.module'/>" type="hidden">
				<input id="isTownLeaderImport" name="isTownLeaderImport" value="<s:property value='#parameters.isTownLeaderImport'/>" type="hidden">
			</div>
			<div id="message"></div>
		</div>
	</div>
</form>
<script>
var intarcalId;
var totalRowCount=0;
var currentRowCount=0;
var ticketId='';
var ticketNewId='';
var currentErrorRow=0;
var threadId;
var errorCount;
var errorMessageExcelName;
var userTicketNumber;

$(document).ready(function(){
	
	$("#mForm").formValidate({
		promptPosition: "bottomLeft",
		submitHandler: function(form){
			$(form).ajaxSubmit({
				type:"json",
				success: function(data){
					var dataJson=eval("("+data+")");
					userTicketNumber = dataJson.userTicketNumber;
					errorMessageExcelName = dataJson.errorMessageExcelName;
					$("#<s:property value='#parameters.dialog'/>").dialog("close");
					var str = "<div id='load' class='ui-widget-border'><div style='text-align:left;margin-left:30px;margin-top:20px;margin-bottom:-70px;margin-right:30px;' id='templateVersionLabel'>"+$("#templateVersion").html()+"</div><p class='filename'>"+dataJson.uploadFileName+"</p><p id='userTicketText'>您前面有<b id='userTicketNumber' style='color:red;'>"+userTicketNumber+"</b>位用户正在导入，请稍候...</p><p id='progressbar-msg'>文件正在上传...</p><p id='currentText'>您选择导入<b id='totalCount' style='color:red;'></b>条数据，正在处理第<b id='currentNumber' style='color:red;'>1</b>条数据</p><div id='progressbar'></div><span id='progressbar-value'>0%</span><div class='clear'>&nbsp;</div>";
					
				    str+="<div class='promptMsgDiv'><p></p></div> "
					str+="<div id='errorMsgDiv' style='margin-top:25px;margin-left:20px;'><table id='importErrorMsg'></table></div>";
					
					str += "<div class='clear'></div>";
					str += "<div class='ui-dialog-buttonset'><div id='errorMsgButton' style='float:left'><button id='reloadExcel' type='button' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'>重新上传</button><button id='cancel' type='button' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'>关闭</button></div><div style='float:left' id='closeImportDiv'><button id='closeImportDialog' type='button' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'>后台处理</button></div>";
					str +="</div>";
					$("body").mask(str);
					$("#importErrorMsg").jqGridFunction({
	                    datatype: "local",
	                    autowidth:false,
	                    width:420,
	                    height:120,
	                    shrinkToFit:true,
	                    colModel:[
	                        {name:'errorMsg',label:'错误信息',width:'350',sortable:false,formatter:autoHeightRow}
	                    ]
	                });
					$("#promptMsgDiv").hide();
					$("#errorMsgDiv").hide();
					$("#errorMsgButton").hide();
					$("#progressbar").progressbar();
					if(userTicketNumber==0||userTicketNumber==undefined){
						$("#userTicketText").hide();
					}
					$("#currentText").hide();
					$("#closeImportDiv").hide();
					ticketId = dataJson.ticketId;
					threadId = dataJson.threadId;
					intarcalId = setInterval(getTicketByIds,5000);
					
					$('#closeImportDialog').bind('click', function () {
						$('body').unmask();
					});
				}
			});
			return false;
		},
		rules:{
			"upload":{
				isExcel: true
			}
		},
		messages:{
			"upload":{
				isExcel: "只能选择后缀为.xls格式的文件"
			}
		}
	});
});


function getTicketByIds(){
	 $.ajax({
		url: '${path}/ticket/getDataImportTicketByTicketId.action',
		type: 'post',
		dataType:'json',
		data:{
			"ticketId":ticketId,
			"currentErrorRow": function(){return $("#importErrorMsg").getGridParam("records");}
		},
   	 	success: function(data){
	   	 	if(data == null){
                clearInterval(intarcalId);
	   	 	}
	   	 	userTicketNumber=data.userTicketNumber;
			totalRowCount=data.totalRowCount;
			currentRowCount=data.currentRowCount;
			errorCount = data.errorCount;
			$("#userTicketNumber").html(userTicketNumber);
			if(totalRowCount==currentRowCount&&totalRowCount!=0){
				var dataType = '<s:property value="#parameters.dataType"/>';
				var st="<div class='importInfo' style='margin-left:5px'><p>本次共导入<font color='blue'>&nbsp;"+data.totalRowCount+"&nbsp;</font>条数据，"+"成功导入<font color='blue'>&nbsp;"+(currentRowCount-errorCount-data.nullRowNum)+"&nbsp;</font>条，空数据有<font color='blue'>&nbsp;"+data.nullRowNum+"&nbsp;</font>条，导入失败&nbsp;<font color='blue'>"+errorCount+"</font>&nbsp;条<p style='text-align:left'>(请先<a href='${path}/dataTransfer/downloadErrorDataTemplate.action?dataTemplatesName="+errorMessageExcelName+"&dataType="+dataType+"'><font color='red'> 下载  </font></a>错误分析表，错误表中红色标注的数据为错误数据，修改后可再次导入)"+"</p></div>";
				$("div.promptMsgDiv p").html(st);
				$("#currentText").hide();
				$("#closeImportDiv").hide();
				$("#errorMsgButton").show();
				$("#reloadExcel").hide();
				$('#cancel').unbind('click');
			    $('#cancel').bind('click', function () {
			    	clearInterval(intarcalId);
			    	$('body').unmask();
			    	threadStop();
			    	<s:if test="!''.equals(#attr.listName)">
					$("#<s:property value='#parameters.listName'/>").trigger("reloadGrid");
					</s:if>
			    });
			    clearInterval(intarcalId);
			    threadStop();
			}
			
			$("#progressbar").progressbar("option", "value", currentRowCount/totalRowCount*100);
			if(currentRowCount==0){
				$("#progressbar-value").text("0%");
			}else{
				$("#progressbar-value").text(parseInt(currentRowCount/totalRowCount*100)+"%");
				$("#currentNumber").text(currentRowCount);
				$("#totalCount").text(totalRowCount);
				$("#currentText").show();
				$("#closeImportDiv").show();
				if(currentRowCount==totalRowCount){
					$("#currentText").hide();
					$("#closeImportDiv").hide();
				}else{
				var st = "<div id  style='margin-left:5px'><p>提示:您可以选择<font color='red'>后台处理</font>,继续系统操作.</p><p>导入结束时，系统自动发送<font color='red'>站内消息</font>提醒您,您也可以在<font color='red'>导入日志系统</font>中查询导入结果.</p></div>";
				$("div.promptMsgDiv p").html(st);
				}
			}
			var jsonMsg = eval("("+data.description+")");
			var dataJson = data.errorMsgs;
			var state = data.state;
			$("#progressbar-msg").text(jsonMsg.msg);
			if(dataJson && dataJson.length>0){
				showErrorDiv();
	            for(var i=0;i<dataJson.length;i++){
		            var str = {errorMsg:dataJson[i]};
		            $("#importErrorMsg").addRowData($("#importErrorMsg").getGridParam("records")+i,str,"last");
	            }
	            if(state == '<s:property value="@com.tianque.state.TicketState@DOING"/>'){
	            	intarcalId = setInterval(getTicketByIds,1000);
	            }
	            showErrorMsgButton();
	        }
			if(state=='<s:property value="@com.tianque.state.TicketState@DONE"/>' ){
				clearInterval(intarcalId);
				$("body").unmask();
				var succHtml = "<div id='load' class='ui-widget-border'>"+
								"<div class='ui-widget' style='margin-top:30px;'>"+
									"<div class='ui-corner-all ui-widget-border' style='width:400px;margin-top:5px;text-align:left;margin-left:5px;'><em class='ui-icon ui-icon-circle-check' style='float: left; margin-right: .3em;'></em>导入成功</div>"+
								"</div>"+
								"<div class='clear'></div>"+
								"<div class='ui-dialog-buttonset'><button id='closeImportData' type='button' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'>关闭</button></div>"+
								"</div>";
				$("body").mask(succHtml);
				$('#closeImportData').bind('click', function () {
					$('body').unmask();
					<s:if test="!''.equals(#attr.listName)">
							$("#<s:property value='#parameters.listName'/>").trigger("reloadGrid");
					</s:if>
				});
			}
			if(state=='<s:property value="@com.tianque.state.TicketState@TIMEOUT"/>' || state=='<s:property value="@com.tianque.state.TicketState@EXCEPTIONSTOP"/>'){
				clearInterval(intarcalId);
			}
	 	}
  	}); 
}

function showErrorDiv(){
	clearInterval(intarcalId);
    $("#load").attr("style","height:420px;");
    $("#errorMsgDiv").show();
}
function showErrorMsgButton(){
	$("#errorMsgButton").show();
	$('#cancel').unbind('click');
	$("#currentText").hide();
	$("#closeImportDiv").hide();
    $('#cancel').bind('click', function () {clearInterval(intarcalId);$('body').unmask(); threadStop();});
    $('#reloadExcel').bind('click',function(){
        clearInterval(intarcalId);
        $('body').unmask();
        threadStop();
        $("#<s:property value='#parameters.dialog'/>").createDialog({
            width: 400,
            height: 220,
            title:'数据导入',
            url:"${path}/common/import.jsp?isNew=<s:property value='#parameters.isNew'/>&dataType=<s:property value='#parameters.dataType'/>&dialog=<s:property value='#parameters.dialog'/>&startRow=<s:property value='#parameters.startRow'/>&templates=<s:property value='#parameters.templates'/>&isTownLeaderImport=<s:property value='#parameters.isTownLeaderImport'/>",
            buttons:{
                "重新导入" : function(event){
                      clearInterval(intarcalId);
                      threadStop();
                      $("#mForm").submit();
                      $.dialogLoading("open");
               },
               "关闭" : function(){
                    clearInterval(intarcalId);
                    $(this).dialog("close");
               }
            },
            shouldEmptyHtml:false
        });
    });
}

function autoHeightRow(el,options,rowData){
	var data = rowData.errorMsg.replace(/[&nbsp;,\t,\n]/g,"").replace(/[ ]/g,"");
	var result = "";
	var i = 0;
	for(i=0;i<data.length/30;i++){
		result = result + data.substring(i*30,(i + 1)*30)+"\n";
	}
	result = result + data.substring(i*30);
	return "<div class='heightAuto'>" + result +  "</div>";
}

function threadStop(){
	$.ajax({
		url: '${path}/dataTransfer/threadStop.action',
		data:{"threadId":threadId},
   	 	success: function(data){
	 	}
  	});
}

</script>
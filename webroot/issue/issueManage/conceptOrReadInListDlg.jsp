<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style type="text/css">
.lable-right .form-lbl,.autoHeight .form-lbl{font:12px/30px "microsoft yahei";color:#333;}
.lable-right .form-lbl{font-weight:700;}
.event-process{height:410px;height:400px\9;margin:0 0 0 5%;overflow:hidden;}
.event-processL,.event-processR{/*float:left;*/display:inline;}
.event-processL{/*height:410px;height:400px\9;*/height:350px;height:340px\9;overflow:hidden;overflow-y:auto;/*border-right:2px solid #A6C9E2;*/}
.dashedLine{height:1px;margin:20px 8px 5px 8px;border-top:1px dashed #999;overflow:hidden;}
.processContent{margin:0 0 10px 30px;border:1px solid #A6C9E2;background:#EAF4FD;}
.processMC{padding:0 0 0 8px;}
.processMsg .autoHeight .form-lbl{color:#006699;}
.processWay{font-weight:700;color:#FF6600;}
.event-processR{margin:0 0 0 2px;}
.autoHeight{height:auto;overflow:hidden;word-break:break-all;word-wrap:break-word;}
.ui-widget-content a{color:#0C5DAC;}
.ui-dialog .ui-dialog-content{padding:0;}
.ui-dialog .ui-dialog-buttonpane{margin:0;}
</style>

<div id="dialog-form" title="办理事件处理" class="container container_24">
	<div class="event-process">
		<div class="event-processL grid_24">
			<div class="clearfix">
				<div class="grid_3 lable-right">
					<label class="form-lbl">事件名称：</label>
				</div>
				<div class="grid_21 autoHeight">
					<label class="form-lbl"><s:property value="issueNew.subject"/></label>
				</div>
				<div class='clearLine'></div>
				<div class="grid_3 lable-right">
					<label class="form-lbl">发生时间：</label>
				</div>
				<div class="grid_21 autoHeight">
					<label class="form-lbl"> <s:date name="issueNew.occurDate" format="yyyy年MM月dd日"/> </label>
				</div>
				<div class='clearLine'></div>
				<div class="grid_3 lable-right">
					<label class="form-lbl">主要人物：</label>
				</div>
				<div class="grid_21 autoHeight">
					<label class="form-lbl"><s:property value="issueNew.mainCharacters"/></label>
				</div>
				<div class='clearLine'></div>
				<div class="grid_3 lable-right">
					<label class="form-lbl">发生地点：</label>
				</div>
				<div class="grid_21 autoHeight">
					<label class="form-lbl"><s:property value="issueNew.occurLocation"/></label>
				</div>
				<div class='clearLine'></div>
				<div class="grid_3 lable-right">
					<label class="form-lbl">事件类型：</label>
				</div>
				<div class="grid_21 autoHeight">
					<label class="form-lbl">
						<c:if test="${selContradictionString!=null}">${selContradictionString}
							<c:forEach items="${selContradiction}" var="type">
								${type.issueTypeName },
		                    </c:forEach><br>
	                    </c:if>
	                    <c:if test="${selSpecialisationString!=null}">${selSpecialisationString}
	                    	<c:forEach items="${selSpecialisation}" var="type">
			                    ${type.issueTypeName },
		                    </c:forEach><br>
	                    </c:if>
	                    <c:if test="${selPeopleliveServiceString!=null}">${selPeopleliveServiceString}
	                   		<c:forEach items="${selPeopleliveService}" var="type">
			                    ${type.issueTypeName },
		                    </c:forEach>
	                    </c:if>
	                    <c:if test="${selOtherTypeString!=null}">${selOtherTypeString}
	                    	<c:forEach items="${selOtherType}" var="type">
			                    ${type.issueTypeName },
		                    </c:forEach>
	                    </c:if>
					</label>
				</div>
				<div class='clearLine'></div>
				<div class="grid_3 lable-right">
					<label class="form-lbl">事件简述：</label>
				</div>
				<div class="grid_21 autoHeight">
					<div class="grid_24 heightAuto">
						<label class="form-lbl">
							<s:property value="issueNew.issueContent" />
						</label>
					</div>
				</div>
				<div class="grid_3 lable-right">
					<label class="form-lbl">附件：</label>
				</div>
				<div class="grid_21 autoHeight">
					<c:if test="${issueAttachFiles!=null && fn:length(issueAttachFiles) > 0}">
			              <div class="grid_24 filetype heightAuto">
				            	<div class="grid-accessory">
									<span class="filetype-clip"></span>
								</div>
								<c:forEach items="${issueAttachFiles}" var="issueAttachFile">
			                     	<a style="font:12px/30px '\5b8b\4f53';color:#06699B;" href="${path }/issue/issueManage/downLoadActualFile.action?fileId=${issueAttachFile.id }" >${issueAttachFile.fileName }</a>;
			                	</c:forEach>
			              </div>
			        </c:if>
				</div>
			</div>
			<div class="grid_3 lable-right">
				<label class="form-lbl">处理过程：</label>
			</div>
			<s:subset source="issueLogs" start="0">
                     <s:iterator status="index">
                    	<div class="grid_21 processContent autoHeight">
		                     <div class="grid_24 processMC autoHeight">
			                        	<span><s:date name="dealTime" format="yyyy年MM月dd HH:mm:ss" /></span>
				                	<span><s:property value="dealOrg.orgName"/></span>
				                	<span><s:property value="dealUserName"/></span>
			                    		<s:property value="dealDescription" escape="false"/>
		                     </div>
	                    	<c:if test="${(content != null && not empty content) || (issueLogAttachFilesMap[id] != null && fn:length(issueLogAttachFilesMap[id])>0 )}">
	                     	<div class="grid_24 processMsg autoHeight">
				                <div class="grid_5 lable-right">
									<label class="form-lbl">办理意见：</label>
								</div>
								<div class="grid_19 autoHeight">
									<label class="form-lbl">${content }</label>
								</div>
		                	 </div>
		                	 <div class="grid_24 processMsg autoHeight">
		                	 	<div class="grid_5 lable-right">
									<label class="form-lbl">附件：</label>
								</div>
								<c:if test="${issueLogAttachFilesMap[id]!=null && fn:length(issueLogAttachFilesMap[id]) > 0}">
		                        <div class="grid_19 filetype heightAuto">
			                    	<div class="grid-accessory">
										<span class="filetype-clip"></span>
										<c:forEach items="${issueLogAttachFilesMap[id]}" var="issueLogAttachFilesMap">
				                            <a style="font:12px/30px '\5b8b\4f53';color:#06699B;" href="${path }/issue/issueManage/downLoadActualFile.action?fileId=${issueLogAttachFilesMap.id }" >${issueLogAttachFilesMap.fileName }</a>;
				                        </c:forEach>
		                        	</div>
		                        </div>
	                    			</c:if>
		                	 </div>
	                    		</c:if>
	                    	</div>
	                    </s:iterator>
	                </s:subset>
		</div>
		<div class="event-processR grid_24">
		<div class="dashedLine clearfix"></div>
			<form id="maintainForm" method="post" action="${path }/issue/issueBusinessManage/conceptIssue.action">
				<input type="hidden" name="operation.dealOrg.id" id="dealOrgId" value="${issueLog.dealOrg.id }" />
				<input type="hidden" name="operation.dealType" id="dealType" value="${issueLog.dealType }" />
				<input type="hidden" name="operation.issue.id" id="issueId" value="${issueLog.issue.id }" />
				<input type="hidden" name="issueLog.id" id="issueLogId" value="${issueLog.id }">
				<input type="hidden" name="keyId" id="keyId" value="${issueStepId }" />
				<input type="hidden" name="dealCode" id="dealCode" value=''/>
				<input id="DialogName" name="" type="hidden" value="${DialogName}" />
				<pop:token />
				<div class="grid_3 lable-right">
					<label class="form-lbl">
					<c:if test='${mode=="conceptInList"}'>承办人</c:if>
					<c:if test='${mode=="readInList"}'>阅读人</c:if>
					：</label>
				</div>
				<div class="grid_8">
					<input type="text" id="dealUserName" name="operation.dealUserName" maxlength="20" value="${issueLog.dealUserName }" class="form-txt" />
				</div>
				<div class="grid_1">
					<em class="form-req">*</em>
				</div>  
				<div class="grid_3 lable-right">
					<label class="form-lbl">联系手机：</label>
				</div>
				<div class="grid_8">
					<input type="text" id="mobile" name="operation.mobile" maxlength="11" value="${issueLog.mobile }" class="form-txt" />
				</div>
			        <div class="grid_1">
			            <em class="form-req">*</em>
			        </div> 
				<div class='clearLine'></div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$("#dealCode").val("<s:property value="@com.tianque.issue.state.IssueOperate@CONCEPT_CODE"/>");
	<c:if test='${mode=="conceptInList"}'>
		$("#maintainForm").attr("action","${path }/issues/issueManage/dealIssue.action");
	</c:if>
	<c:if test='${mode=="readInList"}'>
		$("#maintainForm").attr("action","${path }/issue/issueBusinessManage/readIssue.action");
	</c:if>
	
	$("#maintainForm").formValidate({
		promptPosition: "bottomLeft",
		submitHandler: function(form){
			$(form).ajaxSubmit({
				success:function(data){
					if(!data.issueLogId){
	           	 		$.messageBox({
							message:data,
							level:"error"							
				 		});
	           	 	if($("#DialogName").val()=='maxConcept'){
						$("#maxIssueForBenchDialog").dialog("close");
						}else{
						$("#issueForBenchDialog").dialog("close");
						}
	            		return;
	            	}
					<c:if test='${mode=="conceptInList"}'>
					if($("#DialogName").val()=='maxConcept'){
						$("#maxIssueForBenchDialog").dialog("close");
					}else{
							$("#issueForBenchDialog").dialog("close");
						}
						$("#issueListForNeed").addRowData(data.issueLogId,data,"after",$("#issueLogId").val());
						$("#issueListForNeed").setSelection(data.issueLogId);
						$.confirm({
							title:"提示",
							message:"已经成功受理该事件处理，是否继续办理该事件？",
							okFunc: function() {
								dealIssue(data.issueLogId);
							},
							cancelFunc:function(){
							},
						    	cancelBtnName:"否",
						    	okbtnName :"是"
						});
					</c:if>
					<c:if test='${mode=="readInList"}'>
					    $.messageBox({message:"已经成功阅读该事件处理!"});
					</c:if>
					$("#issueListForNeed").deleteSubGridByRowId($("#issueLogId").val());
					$("#issueListForNeed").delRowData($("#issueLogId").val());
					refreshMyIssueCount();
                    $(".message").click();
                	$("#issueListForNeed").trigger("reloadGrid");
					$("#issueForBenchDialog").dialog("close");
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert("提交数据时发生错误");
			  	}
			});
		},
		rules:{
			"issueLog.dealUserName":{
				required:true,
				exculdeParticalChar:true,
				minlength:2
			},
			"issueLog.mobile":{
				required:true,
				mobile:true
			}
		},
		messages:{
			"issueLog.undertaker":{
				required:"请输入承办人",
				exculdeParticalChar:"不能输入非法字符",
				minlength:$.format("至少需要输入{0}个字符")
			},
			"issueLog.mobile":{
				required:"请输入联系人手机",
				mobile:$.format("手机不合法，只能输入以1开头的11位数字")
			}
		}
	});
})
</script>
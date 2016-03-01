<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
#input_involvedPersonnel{display:none !important;}
#holder_involvedPersonnel{height:22px;}
#jSIPContainer ul{height:150px !important;}
#issueMaintainForm{display:inline;}
#dialog-form{width:100%;}
.issuePeopleList{padding:5px 10px;margin:5px 20px;background:#eee;overflow:hidden;}
.issuePeopleList #addPeopleItem{color:blue;padding:0 0 0 5px;}
.dlg_innerBox label input{margin-right:5px;vertical-align: middle;}
.dlg_innerBox .delItemBox{display: block;}
.dlg_innerBox .delItemBox a{padding:0 10px;color:#f60;}
.form-select{width: 99%; font-size: 13px; margin-top: 5px; border: 1px solid #ccc;height: 24px;}
</style>
<div id="dialog-form" title="" class="container container_24" style="background: #f4f5f5;">
	<form id="issueMaintainForm" method="post" action="${path}/issues/issueManage/addIssueByTencent.action">
			<input id="issueId" name="issue.id" type="hidden" value="${issue.id}" />
			<input id="stepId" name="stepId" type="hidden" value="${issue.currentStep.id}" />
			<input id="occurOrgId" name="issue.occurOrg.id" type="hidden" value="${issue.occurOrg.id}" />
			<input id="serialNumber" name="issue.serialNumber" type="hidden" value="${issue.serialNumber}" />
			<input id="ycHours" type="hidden" value="${issue.hours}" />
			<input id="ycMinute" type="hidden" value="${issue.minute}" />
			<input id="centerLon" name="issue.centerLon" type="hidden" value="${issue.centerLon}">
			<input id="centerLat" name="issue.centerLat" type="hidden" value="${issue.centerLat}">
			<input id="zoom" name="issue.zoom" type="hidden" value="${issue.zoom}">
			<input id="gisType" name="issue.gisType" type="hidden" value="${issue.gisType}">
			<input id="isTransformat" name="issue.isTransformat" type="hidden" value="${issue.isTransformat}">
			<input id="inboxIds" name="inboxIds" type="hidden" value="${inboxIds}" />
			<input id="touser" type="hidden" name="textSendMessage.touser" value="${openId}">
			<s:if test="@com.tianque.core.util.DialogMode@ADD_MODE.equalsIgnoreCase(mode)">
				<pop:token />
			</s:if>
			<div class="grid_4 lable-right">
				<em class="form-req">*</em><label class="form-lbl">事件类型：</label>
			</div>
			<div class="grid_9 lable-right">
				<select id="issueDomain" name="issue.issueType.issueTypeDomain.id"  class="form-select {required:true,messages:{required:'事件类型必须选择'}}">
			   		<pop:IssueTypeReleationSelectTag name=
			   		"contradiction,resolveTheContradictions,securityPrecautions,specialPopulations,socialConditions,policiesAndLaws,emergencies,otherManage" 
			   		defaultValue="${issue.issueType.issueTypeDomain.id}" 
			   		reletionId="issueTypeId" isOperateDiv="1" id="issueDomain" defaultTypeValue="${issue.issueType.id }"/>
				</select>
			</div>
			<div class="grid_9 lable-right">
				<select id="issueTypeId" name="issue.issueType.id" class="form-select" disabled></select>
			</div>
			<div class="grid_4 lable-right">
				<em class="form-req">*</em><label class="form-lbl">事件名称：</label>
			</div>
			<div class="grid_7 form-left">
		    	<input type="text" id="issueSubject" name="issue.subject" maxlength="50" value="${issue.subject}" class="form-txt" />
			</div>
			<div class="grid_4 lable-right">
				<em class="form-req">*</em><label class="form-lbl">发生网格：</label>
	  		</div>
    		<div class="grid_8 form-left">
				<input type="text" id="issueOccurOrgSelector" name="selectOrgName" value="${createOrgByTencent}" class="form-txt" />
    		</div>
    		<div class='clearLine'></div>
			<div class="dlg_innerBox">
	    		<div class="grid_4 lable-right">
					<em class="form-req">*</em><label class="form-lbl" id="occurDateLabel">发生时间：</label>
				</div>
				<div class="grid_4 form-left">
			    	 <input type="text" id="occurDate" name="issue.occurDate" class="form-txt" style='width:150px;height:24px;'
						<%-- value="<s:date name="date" format="yyyy-MM-dd"/>" readonly /> --%>
						value=""  />
				</div>
				<div class="grid_5"></div>
	    		<div class="grid_4 form-left">
					<select id="hours" name="hours" ></select> 时
	    		</div>
	    		<div class="grid_4 form-left">
	    			 <select id="minute" name="minute" ></select> 分
	    		</div>
                <!--<c:choose>
				    <c:when test="${issue.emergencyLevel!=null }">
				     	<div class="grid_4 lable-right" id="emergencyLevelDiv">
							<em class="form-req"></em><label class="form-lbl">重大紧急等级：</label>	
				  		</div>
				  		<div class="grid_6" id="emergencyLevel">	
							<label><input type="radio" value="<s:property value='issue.emergencyLevel.id'/>" checked="checked" name="issue.emergencyLevel.id"  /><s:property value='issue.emergencyLevel.displayName'/></label>
				  		</div>
				    </c:when>
				    <c:otherwise>
				    	<div class="grid_4 lable-right" id="emergencyLevelDiv"></div>
			  			<div class="grid_6" id="emergencyLevel"></div>
				    </c:otherwise>
				</c:choose> -->
				<div id="occurLocationDiv">
		    		<div class='clearLine'></div>
					<div class="grid_4 lable-right">
						<div id="lab1"><label class="form-lbl">发生地点：</label></div>
					</div>
					<div class="grid_10 form-left" id="div1">
				    	<input type="text" id="issueLocation" name="issue.occurLocation" maxlength="50" value="${createOrgByTencent}" class="form-txt {required:true,messages:{required:'发生地点不能为空'}}" />
					</div>
				</div>
				<div id="importantPlaceDiv">
		    		<div class="grid_6 lable-right">
		    		<c:choose>
					    <c:when test="${issue.importantPlace==1}">
					     	<label><input type="checkbox" checked="checked" value="1" name="issue.importantPlace"/>是否重点场所</label>
					    </c:when>
					    <c:otherwise>
					    	<label><input type="checkbox" value="1"  name="issue.importantPlace"/>是否重点场所</label>
					    </c:otherwise>
					</c:choose>
					</div>
				</div>
				<div class='clearLine'></div>	
				<div class="issuePeopleList">	
					<div class="grid_6 heightAuto">
			  			<label class="form-lbl" id="issueRelatedPeoplesLabel"><em class="form-req">*</em>主要当事人：</label>
			  		</div>
			  		<div class="grid_10 lable-right "><a href="javascript:;" id="addPeopleItem">+增加</a></div>
			  		<div class='clearLine'>&nbsp;</div>	
		    		<div class="grid_24 form-left heightAuto">
		    			<ul class="issuePeopleItems" id="issuePeopleItems">
				    			<s:if test="@com.tianque.core.util.DialogMode@EDIT_MODE.equalsIgnoreCase(mode)">
				    				<s:iterator value="issue.issueRelatedPeoples" id="issueRelatedPeople">
					    				<li>
											<div class="grid_3 lable-right">姓名：</div>
					    					<div class="grid_4"><input type="text" name="issueRelatedPeopleNames" value='<s:property value="name"/>' maxlength="20" class='form-txt 
					    							{maxlength:20,minlength:2,exculdeParticalChar:true,required:true,messages:{required:"姓名不能为空",maxlength:$.format("姓名不能多于{0}个字符"),minlength:$.format("姓名不能少于{0}个字符"),exculdeParticalChar:"不能输入非法字符"}}' /></div>
					    					<div class="grid_3 lable-right">联系手机：</div>
					    					<div class="grid_4"><input type="text" name="issueRelatedPeopleTelephones" value='<s:property value="telephone"/>' maxlength="11" class='form-txt {maxlength:11,mobile:true,messages:{maxlength:$.format("联系手机不能多于{0}个字符"),mobile:"手机号码必须由1开头的11位数字组成"}}' /></div>
					    					<div class="grid_3 lable-right">固话：</div>
					    					<div class="grid_4"><input type="text" name="issueRelatedPeopleFixPhones" value='<s:property value="fixPhone"/>' maxlength="15" class='form-txt {maxlength:15,telephone:true,messages:{maxlength:$.format("固话不能多于{0}个字符"),telephone:"固话不合法，只能输数字和横杠(-)"}}' /></div>
					    					<div class="grid_3 delItemBox" style='display:block;'><a href="javascript:;" class="delPeopleItem">删除</a></div>
				    					</li>
			    					</s:iterator>
								</s:if>
								<s:else>
									<li>
										<div class="grid_3 lable-right">姓名：</div>
					    				<div class="grid_4"><input type="text" name="issueRelatedPeopleNames" value="" maxlength="20" class='form-txt 
					    				{maxlength:20,minlength:2,exculdeParticalChar:true,required:true,messages:{required:"姓名不能为空",maxlength:$.format("姓名不能多于{0}个字符"),minlength:$.format("姓名不能少于{0}个字符"),exculdeParticalChar:"不能输入非法字符"}}' /></div>
					    				<div class="grid_3 lable-right">联系手机：</div>
					    				<div class="grid_4"><input type="text" name="issueRelatedPeopleTelephones" value="" maxlength="11" class='form-txt {maxlength:11,mobile:true,messages:{maxlength:$.format("联系手机不能多于{0}个字符"),mobile:"手机号码必须由1开头的11位数字组成"}}' /></div>
					    				<div class="grid_3 lable-right">固话：</div>
					    				<div class="grid_4"><input type="text" name="issueRelatedPeopleFixPhones" value="" maxlength="15" class='form-txt {maxlength:15,telephone:true,messages:{maxlength:$.format("固话不能多于{0}个字符"),telephone:"固话不合法，只能输数字和横杠(-)"}}' /></div>
					    				<div class="grid_3 delItemBox" style='display:block;'><a href="javascript:;" class="delPeopleItem">删除</a></div>
									</li>
								</s:else>
			    			
		    			</ul>
		    			
		    		</div>
	    		</div>
	    		<div id="involvedPersonnelDiv">
	    			<div class='clearLine'>&nbsp;</div>	
					<div class="grid_4 lable-right">
		  				<label class="form-lbl">特殊人群：</label>
			  		</div>
		    		<div class="grid_15 form-left heightAuto" style="line-height:20px;">
						<input type="text" id="involvedPersonnel" value="" name="involvedPersonnel" readonly="readonly" class="form-txt" />
		    		</div>
	    		</div>
	    		
				<div id="issueKindAndCount">
					<div class='clearLine'>&nbsp;</div>	
					<div class="grid_4 lable-right">
						<label class="form-lbl"><em class="form-req">*</em>事件规模：</label>
					</div>
					<div class="grid_7 form-left">
					<select id="issueKind" name="issue.issueKind.id" class='form-txt'>
						<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@ISSUE_KIND" defaultValue="${issue.issueKind.id}"/>
					</select>
						
					</div>
					<div class="grid_4 lable-right">
						<label class="form-lbl"><em class="form-req">*</em>涉及人数：</label>
					</div>
					<div class="grid_7 form-left">
						<input type="text"  name="issue.relatePeopleCount" maxlength="6" value="${issue.relatePeopleCount}" class="form-txt" style="text-align:right;" />
					</div>
			   		<div class="grid_1">(人)</div>
				</div>
				<div class='clearLine'>&nbsp;</div>
				<div class="grid_4 lable-right">
					<em class="form-req">*</em><label class="form-lbl">事件简述：</label>
				</div>
				<div class="grid_19 heightAuto" style='line-height:18px;'>
	    			<textarea id="issueContent" name="issue.issueContent" class="form-txt"  style="height:50px;width:95%;"><s:iterator value="map" status="st" begin="0">${content}</s:iterator>
	    			</textarea>
				</div>
			</div>
			<div id="subMaintanceDialog"></div>
			<select id="attachFileNames" name="attachFiles" multiple="multiple" style="display:none"></select>
			<div class='clearLine'>&nbsp;</div>
			<div class="grid_24">
		   		<div class="grid_4 lable-right">
					<label>回复消息：</label>
				</div>	
				<div class="grid_19 heightAuto">
					<textarea name="textSendMessage.text.content" id="weChatContent" style="height:50px;width:97.1%;" class='form-txt {maxlength:1000,messages:{maxlength:"查询语句最多需要输入1000个字符"}}'>您的事件已受理！</textarea>
				</div>
			</div>
			
	</form>
	
	<div class="clearfix" style="position: relative;top:50px">
		<div class="grid_4 lable-right">
			<label class="form-lbl">上传附件：</label>
		</div>
		<div  class="grid_19 heightAuto" >
			<input id="custom_file_upload" name="uploadFile" type="file" />
			<div class='clearLine'>&nbsp;</div>
			<div id="custom-queue" style="width:94.5%;height:50px;overflow-y: auto;overflow-x: hidden;border:1px solid #ccc;background:#fff;"></div>
		</div>			
	<%-- 	<div class="grid_8 heightAuto" >
			<div>&nbsp;</div>
			<div id="issueViewMap" style="width: 250px; height: 165px;overflow-y: hidden;overflow-x: hidden;border:1px solid #7F9DB9">
			</div>
			<div>
			<c:if test='${mode!="view"}'>
				<input type="button" value="绑定" class="defaultBtn" id="bindMap"/>
				<c:if test='${mode=="edit"&& issue.centerLon != null && issue.centerLat !=null}'>
					<input type="button" class="defaultBtn" value="清除" id="cancelBind"/>
				</c:if>
			</c:if>
			</div>
		</div> --%>
		<div class='clearLine'>&nbsp;</div>
		<button id="issuePreservation" type="button"  style="margin-top:20px;margin-left:50px">受理</button>
        <button id="inboxRollOut" type="button"  style="margin-top:20px;margin-left:20px">转出</button>
	</div>

	<div id="appendIssueKindAndCount" style="display: none;">
		<div class='clearLine'>&nbsp;</div>	
		<div class="grid_4 lable-right">
			<label class="form-lbl"><em class="form-req">*</em>事件规模：</label>
		</div>
		<div class="grid_7 form-left">
		<select id="issueKind" name="issue.issueKind.id" class='form-txt'>
			<pop:OptionTag name="@com.tianque.domain.property.PropertyTypes@ISSUE_KIND" defaultValue="${issue.issueKind.id}"/>
		</select>
			
		</div>
		<div class="grid_4 lable-right">
			<label class="form-lbl"><em class="form-req">*</em>涉及人数：</label>
		</div>
		<div class="grid_7 form-left">
			<input type="text"  name="issue.relatePeopleCount" maxlength="6" value="${issue.relatePeopleCount}" class="form-txt" style="text-align:right;" />
		</div>
   		<div class="grid_1">(人)</div>
	</div>
	<!-- 
	<div id="appendEmergencyLevelDiv" style="display: none;">
		<div class="grid_4 lable-right">
			<em class="form-req">*</em><label class="form-lbl">重大紧急等级：</label>
  		</div>
  		<div class="grid_6">
  			<s:if test="issue.emergencyLevel!=null">
				<label><input type="radio" value="<s:property value='issue.emergencyLevel.id'/>" checked="checked" name="issue.emergencyLevel.id"  /><s:property value='issue.emergencyLevel.displayName'/></label>
  			</s:if>
			<s:else>
				<s:iterator value="emergencyLevels" id="emergencyLevel">
					<label><input type="radio" value='<s:property value="id"/>'  name="issue.emergencyLevel.id"/><s:property value="displayName"/></label>
				</s:iterator>
			</s:else>
  		</div>
	</div> -->
	<div id="appendImportantPlaceDiv" style="display: none;">
   		<div class="grid_4 lable-right">
   			<c:choose>
			    <c:when test="${issue.importantPlace==1}">
			     	<label><input type="checkbox" checked="checked" value="1" name="issue.importantPlace"/>是否重点场所</label>
			    </c:when>
			    <c:otherwise>
			    	<label><input type="checkbox" value="1"  name="issue.importantPlace"/>是否重点场所</label>
			    </c:otherwise>
			</c:choose>
		</div>
	</div>
	<div id="appendOccurLocationDiv" style="display: none;">
   		<div class='clearLine'></div>
		<div class="grid_4 lable-right">
			<div id="lab1"><label class="form-lbl" id="occurLocationLabel">发生地点：</label></div>
		</div>
		<div class="grid_10 form-left" id="div1">
	    	<input type="text" id="issueLocation" name="issue.occurLocation" maxlength="50" value="${issue.occurLocation}" class="form-txt" />
		</div>
	</div>
		
</div>

<script type="text/javascript" >

var issueTree;

function setEmergencyLevelDiv(){
	if($("#occurOrgId").val()==null || ""==$("#occurOrgId").val() 
			|| $("#issueDomain").find("option:selected").text()=='请选择'){
		return;
	}
// 	<s:if test="@com.tianque.core.util.DialogMode@ADD_MODE.equalsIgnoreCase(mode)">
// 		$('#emergencyLevel').empty();
// 		$('#emergencyLevelDiv').empty();
// 		$.ajax({
// 			async : true,
// 			url : "${path}/issueSkipruleManage/getUrgentLevelList.action",
// 			data :{	"issueSkiprule.issueTypeDomainId":$("#issueDomain").find("option:selected").val(),
// 					"issueSkiprule.issueTypeId":$("#issueTypeId").find("option:selected").val(),
// 					"issueSkiprule.orgId":$("#occurOrgId").val()
// 			},
// 			success : function(data) {
// 				if(data!=null&&data.length>0){
// 					var text="";
// 					for(var i=0;i<data.length;i++){
// 						text=text+'<label><input type="radio" value="'+data[i].id+'"  name="issue.emergencyLevel.id"/>'+data[i].displayName+'</label>';
// 					}	
// 					$('#emergencyLevel').empty().append(text);
// 					$('#emergencyLevelDiv').empty().append('<em class="form-req"></em><label class="form-lbl">重大紧急等级：</label>');
// 				}		
// 			}
// 		 });
// 	</s:if>
}

function operateDiv(){
	var issueType = $("#issueDomain").find("option:selected").text();
	setDivShow(issueType);
	setEmergencyLevelDiv();
}

function setDivShow(flag){
	switch(flag){
		case '<s:property value="@com.tianque.issue.constants.IssueTypes@PEOPLELIVE_SERVICE" escape="false"/>':
			$("#issueRelatedPeoplesLabel").html('<em class="form-req">*</em>主要当事人：');
			$("#issueKindAndCount").empty();
			$("#occurDateLabel").html("受理时间：");
			$("#occurLocationDiv").empty();	
			$("#importantPlaceDiv").empty();
			//$("#emergencyLevelDiv").empty();
			$("#involvedPersonnelDiv").show();
			break;
		case '<s:property value="@com.tianque.issue.constants.IssueTypes@RESOLVETHECONTRADICTIONS" escape="false"/>':
			$("#issueRelatedPeoplesLabel").html('<em class="form-req">*</em>主要当事人：');
			$("#occurDateLabel").html("发生时间：");
			$("#issueKindAndCount").empty().append($("#appendIssueKindAndCount").html());
			$("#occurLocationDiv").empty().append($("#appendOccurLocationDiv").html());	
			$("#importantPlaceDiv").empty().append($("#appendImportantPlaceDiv").html());
			//$("#emergencyLevelDiv").empty().append($("#appendEmergencyLevelDiv").html());
			$("#involvedPersonnelDiv").show();
			break;
		case '<s:property value="@com.tianque.issue.constants.IssueTypes@SECURITYPRECAUTIONS" escape="false"/>':
			$("#issueRelatedPeoplesLabel").html('联系人：');
			$("#occurDateLabel").html("发生时间：");
			$("#issueKindAndCount").empty();
			$("#occurLocationDiv").empty().append($("#appendOccurLocationDiv").html());	
			$("#importantPlaceDiv").empty().append($("#appendImportantPlaceDiv").html());
			//$("#emergencyLevelDiv").empty().append($("#appendEmergencyLevelDiv").html());
			$("#involvedPersonnelDiv").hide();
			break;
		case '<s:property value="@com.tianque.issue.constants.IssueTypes@SPECIALPOPULATIONS" escape="false"/>':
			$("#issueRelatedPeoplesLabel").html('<em class="form-req">*</em>服务对象：');
			$("#occurDateLabel").html("服务时间：");
			$("#issueKindAndCount").empty();
			$("#involvedPersonnelDiv").hide();
			$("#importantPlaceDiv").empty();
			//$("#emergencyLevelDiv").empty();
			$("#occurLocationDiv").empty().append($("#appendOccurLocationDiv").html());
			$("#occurLocationLabel").html("服务地点：");
			break;
		case '<s:property value="@com.tianque.issue.constants.IssueTypes@SOCIALCONDITIONS" escape="false"/>':
			$("#issueRelatedPeoplesLabel").html('<em class="form-req">*</em>相关人员：');
			$("#occurDateLabel").html("时间：");
			$("#issueKindAndCount").empty();
			$("#involvedPersonnelDiv").hide();
			$("#importantPlaceDiv").empty();
			//$("#emergencyLevelDiv").empty();
			$("#occurLocationDiv").empty().append($("#appendOccurLocationDiv").html());
			$("#occurLocationLabel").html("地点：");
			break;
		case '<s:property value="@com.tianque.issue.constants.IssueTypes@POLICIESANDLAWS" escape="false"/>':
			$("#issueRelatedPeoplesLabel").html('<em class="form-req">*</em>相关人员：');
			$("#occurDateLabel").html("时间：");
			$("#issueKindAndCount").empty();
			$("#involvedPersonnelDiv").hide();
			$("#importantPlaceDiv").empty();
			//$("#emergencyLevelDiv").empty();
			$("#occurLocationDiv").empty().append($("#appendOccurLocationDiv").html());
			$("#occurLocationLabel").html("地点：");
			break;
		case '<s:property value="@com.tianque.issue.constants.IssueTypes@EMERGENCIES" escape="false"/>':
			$("#issueRelatedPeoplesLabel").html('<em class="form-req">*</em>主要当事人：');
			$("#occurDateLabel").html("发生时间：");
			$("#issueKindAndCount").empty().append($("#appendIssueKindAndCount").html());
			$("#occurLocationDiv").empty().append($("#appendOccurLocationDiv").html());	
			$("#importantPlaceDiv").empty().append($("#appendImportantPlaceDiv").html());
			//$("#emergencyLevelDiv").empty().append($("#appendEmergencyLevelDiv").html());
			$("#involvedPersonnelDiv").show();
			break;
		case '<s:property value="@com.tianque.issue.constants.IssueTypes@OTHERMANAGE" escape="false"/>':
			$("#issueRelatedPeoplesLabel").html('<em class="form-req">*</em>主要当事人：');
			$("#occurDateLabel").html("时间：");
			$("#issueKindAndCount").empty();
			$("#involvedPersonnelDiv").hide();
			$("#importantPlaceDiv").empty();
			//$("#emergencyLevelDiv").empty().append($("#appendEmergencyLevelDiv").html());
			$("#occurLocationDiv").empty().append($("#appendOccurLocationDiv").html());
			$("#occurLocationLabel").html("地点：");
			break;
	}
}

//用来判断附件是否全部上传完成
var attachFileUploadComplete = false ;

function getDefaultOccurOrg(){
	<c:choose>
	    <c:when test="${null!=issue.occurOrg && null!=issue.occurOrg.id}">
	    	return "${issue.occurOrg.id}";
	    </c:when>
	    <c:otherwise>
	    	return -1;
	    </c:otherwise>
	</c:choose>
}
$(document).ready(function(){
	operateDiv();
	$("#issueTypeId").change(function(){
		setEmergencyLevelDiv();
	});
	
	<s:if test="@com.tianque.core.util.DialogMode@EDIT_MODE.equalsIgnoreCase(mode)">
		$("#issueDomain").attr("disabled","disabled");
		$("#issueTypeId").attr("disabled","disabled");
		var issueTypeId = $("#issueTypeId").find("option:selected").val();
		$("#issueMaintainForm").append('<input type="hidden" name="selectedTypes" value="'+issueTypeId+'">');	
	</s:if>
	
	$("#addPeopleItem").click(function(){
		var sum=$("#issuePeopleItems li").size()-1;
		var temp='<li style="clear:both">\
			<div class="grid_3 lable-right">姓名：</div>\
			<div class="grid_4"><input type="text" name="issueRelatedPeopleNames" maxlength="20" value="" class="form-txt {maxlength:20,minlength:2,exculdeParticalChar:true,messages:{maxlength:$.format(\'姓名不能多于{0}个字符\'),minlength:$.format(\'姓名不能少于{0}个字符\'),exculdeParticalChar:\'不能输入非法字符\'}}" /></div>\
			<div class="grid_3 lable-right">联系手机：</div>\
			<div class="grid_4"><input type="text" name="issueRelatedPeopleTelephones" value="" maxlength="11" class="form-txt {maxlength:11,mobile:true,messages:{maxlength:$.format(\'联系手机不能多于{0}个字符\'),mobile:\'手机号码必须由1开头的11位数字组成\'}}" /></div>\
			<div class="grid_3 lable-right">固话：</div>\
			<div class="grid_4"><input type="text" name="issueRelatedPeopleFixPhones" value="" maxlength="15" class="form-txt {maxlength:15,telephone:true,messages:{maxlength:$.format(\"固话不能多于{0}个字符\"),telephone:\"固话不合法，只能输数字和横杠(-)\"}}" /></div>\
			<div class="grid_3 delItemBox"><a href="javascript:;" class="delPeopleItem">删除</a></div>\
			</li>';
		$("#issuePeopleItems li").find(".delItemBox").show().end().eq(sum).after(temp);
		
	});
	$("#issuePeopleItems").delegate(".delPeopleItem","click",function(){
		if($("#issuePeopleItems li").size()==1){
			$.messageBox({level:'warn',message:"请保留至少一组姓名和联系手机!"});
			return;
		}
		$(this).closest("li").remove();
	});
	
	$("#involvedPersonnel").personnelComplete({
		url: "${path}/issues/searchIssue/searchPersonnelForAutoComplete.action",
		multiple: true,
		postDataFunction: function(){
		    var orgId=getOccurOrgId();
		    return {orgId:orgId};
		}
	});
	$("#holder_involvedPersonnel").click(function(){
		var bol = false;
		$.ajax({
			async:false,
			url:"${path}/issues/issueManage/checkOccurOrgId.action",
			data:{
				"issue.occurOrg.id":$("#occurOrgId").val()
			},
			success:function(responseData){
				bol = responseData;
			}
		});
		if(!bol){
	    	$.notice({
				level:'warn',
				message:'请先选择发生网格为乡镇(街道)或乡镇(街道)以下!'
			});
			return ;
		}
		$(this).peopleSelect(getOccurOrgId());
	});
	
	
	
	<s:iterator id="person" value="relatePersonMap">
	var key = "<s:property value='#person.key'/>";
    <s:iterator value="#person.value" status="s">
   		var value = key+"-<s:property value='worksheetid'/>"
   		var label = "<s:property value='name'/>";
    	$("#involvedPersonnel").setPersonnelCompleteVal({value:value,label:label,desc:""});
    </s:iterator>
    </s:iterator>

	$("#involvedPlace").personnelComplete({
		url: "${path}/issues/searchIssue/searchPlaceForAutoComplete.action",
		multiple: false,
		postDataFunction: function(){
		    var orgId=getOccurOrgId();
		    return {orgId:orgId};
		}
	});
	
	$("#lab2").hide();
	$("#div2").hide();
	
	<s:iterator id="place" value="relatePlacesMap">
	if(!$("#isInvolvedPlace").attr("checked")){
		$("#isInvolvedPlace").attr("checked","checked");
		showInvolvedPlaces();
	}
	var key = "<s:property value='#place.key'/>";
    <s:iterator value="#place.value" status="s">
   		var value = key+"-<s:property value='worksheetid'/>"
   		var label = "<s:property value='name'/>";
    	$("#involvedPlace").setPersonnelCompleteVal({value:value,label:label,desc:""});
    </s:iterator>
    </s:iterator>

	$("#searchPersonnel").click(function(event){
		var bol = false;
		$.ajax({
			async:false,
			url:"${path}/issues/issueManage/checkOccurOrgId.action",
			data:{
				"issue.occurOrg.id":$("#occurOrgId").val()
			},
			success:function(responseData){
				bol = responseData;
			}
		});
		if(!bol){
	    	$.notice({
				level:'warn',
				message:'请先选择发生网格为乡镇(街道)或乡镇(街道)以下!'
			});
			return ;
		}
		if(isNull()){
			$("#searchandaddDialog").createDialog({
				width:610,
				height:430,
				title:'涉及特殊人群查询',
				url:"${path}/issue/issueManage/search/searchPersonnelDlg.jsp?orgId="+getOccurOrgId(),
				buttons: {
					"确定" : function(event){
					   setCompVal();
					   $(this).dialog("close");
				   },
				   "取消" : function(){
				        $(this).dialog("close");
				   }
				}
			});
		}
	});
	
	$("#bindMap").click(function(){
		if(isTownDownOrganization()){
			$("#issueOpenLayersMapDialog").createDialog({
				width:800,
				height:600,
				title:"地图绑定",
				url:"${path}/openLayersMap/product_3.0/gisBindIssue.jsp?flag=1&currentOrgId="+$("#occurOrgId").val(),
				buttons:{
					"关闭" : function(){
			        	$("#issueOpenLayersMapDialog").dialog("close");
			   		}
				},
				shouldEmptyHtml:false
			});
		}else{
			$.messageBox({message:"发生网格不能选择乡镇（街道）以上级别",level:"error"});
		}
	});
	
	$("#cancelBind").click(function(){
		$("#centerLon").val("");
		$("#centerLat").val("");
		$("#zoom").val("")
		$("#map").TqMap("clearMarkers");
	});

	$("#searchPlace").click(function(event){
		var bol = false;
		$.ajax({
			async:false,
			url:"${path}/issues/issueManage/checkOccurOrgId.action",
			data:{
				"issue.occurOrg.id":$("#occurOrgId").val()
			},
			success:function(responseData){
				bol = responseData;
			}
		});
		if(!bol){
	    	$.notice({
				level:'warn',
				message:'请先选择发生网格为乡镇(街道)或乡镇(街道)以下!'
			});
			return ;
		}
		if(isNull()){
			$("#searchandaddDialog").createDialog({
				width:620,
				height:450,
				title:'涉及重点场所查询',
				url:"${path}/issue/issueManage/search/searchPlaceDlg.jsp?orgId="+getOccurOrgId(),
				buttons: {
					"确定" : function(event){
					   if(setCompVal()){
					   	$(this).dialog("close");
					   }
				   },
				   "取消" : function(){
				        $(this).dialog("close");
				   }
				}
			});
		}
	});
	
	 // 初始化日期
	initOccurDateSelector(); 
	// 初始化附件上传工具
	initAttachFileUploader(); 
	// 初始发生化网格 
	initOccurOrgSelector();
	// 初始化事件种类 
	initIssueTypeSelector(); 
	//修改的时候填充附件
	if(issueEditing()){
		fillIssueAttenchFiles(); 			
	}
	//  表单校验				
	bindFormValidation();				
	//事件种类填充
	renderSelectedIssueTypes();	
			
	var HH  = '<s:date name="date" format="HH"/>';
	for(i=0;i<24;i++){
		var time = i<10?"0"+i:i; 
		$('#hours').append($("<option "+(HH==i?"selected='selected'":"")+"  value='"+time+"'>"+time+"</option>"));
	};
	var mm  = '<s:date name="date" format="mm"/>';
	for(i=0;i<60;i++){ 
		var time = i<10?"0"+i:i; 
		$('#minute').append($("<option "+(mm==i?"selected='selected'":"")+"  value='"+time+"'>"+time+"</option>"));
	};
	
	if("${mode}"=="edit"){
		$('#minute').attr("disabled",false);
		$('#hours').val($('#ycHours').val());
		$('#minute').val($('#ycMinute').val());
	}
	
	$('#hours').change(function(){
		if($('#hours').val()!=""){
			$('#minute').val("00");
			$('#minute').attr("disabled",false);
		}else{
			$('#minute').val("");
			$('#minute').attr("disabled",true);
		}
	});

	function issueAdding(){
		return <s:property value='"add".equals(mode)'/>;
	}

	function issueEditing(){
		return <s:property value='"edit".equals(mode)'/>;
	}


	function renderSelectedIssueTypes(){
		var typeDesc="";
		$(":input[id^=issueTypeSelector]").each(function(index,value){
			typeDesc=typeDesc+$("[for="+value.id+"]").first().html()+":"+$.trim($(value).getTypeSelectLabels())+"<br>";
		});
		$("#issueTypeDescription").html(typeDesc);
	}


	function  getOccurOrgId(){
		return $("#occurOrgId").val();
	} 

	function initOccurDateSelector(){
		if($("#ui-datepicker-div")[0]){
			$("body").append("<div id='ui-datepicker-div' />")
		}
		$('#occurDate').datePicker({
			yearRange:'1930:2060',
			dateFormat:'yy-mm-dd',
			maxDate:'%y-%M-#{%d}'
			
		});
	}

	function initAttachFileUploader(){
		$('#custom_file_upload').uploadFile({
			queueID : 'custom-queue',
			selectInputId : "attachFileNames",
			onAllComplete:function(){attachFileUploadComplete = true ;}
		});
		$("#attachFileNames").empty();
	}

	function initOccurOrgSelector(){
			var tree=$("#issueOccurOrgSelector").treeSelect({
				inputName:"issue.occurOrg.id",
				changeFun:function(node,e){
					setEmergencyLevelDiv();
					//loadOpenLayersMap();
				},
				loadCom:function(){
					if(issueEditing()){
						$.setTreeValue(getDefaultOccurOrg(),tree); 
					}
				}
			});
			issueTree=tree;
	}
	function fillIssueAttenchFiles(){
		<s:iterator value="mapAtt">
		    $("#custom-queue").addUploadFileValue({
		     id:"<s:property value='inboxAttachmentId'/>",
		     filename:"<s:property value='fileName'/>",
		     link:"${path }/weChat/inbox/downloadInboxAttachment.action?attachmentId=<s:property value='inboxAttachmentId'/>&issueMode=<s:property value='issueMode'/>",   	     	 
			 onRemove:function(){removeAttach("<s:property value='fileName' escape='false'/>")}
		     });
		    $("<option>").attr("attachmentId","<s:property value='inboxAttachmentId'/>").val("<s:property value='inboxAttachmentId'/>,<s:property value='fileName' escape='false'/>").html('<s:property value='fileName' escape='false'/>').attr("selected",true).appendTo($("#attachFileNames"));
		    attachFileUploadComplete = true ;
	    </s:iterator>
	}

	function removeAttach(fileName){
		$("input[name='file']").removeAttr("disabled");
		$("#attachFileNames").find("option:contains("+fileName+")").remove();
	}
		
	function initIssueTypeSelector(){
		<s:iterator value="issueTypeNames" var="issueTypeName" status="st">
			<s:if test="issueTypes[#issueTypeName.typeName].size()>0">
				$("#issueTypeSelector${st.index}").typeSelect({width:${issueTypeName.width},columns:${issueTypeName.column},close:function(ids,labels){renderSelectedIssueTypes();}});
			</s:if>
		</s:iterator>
	}

	function bindFormValidation(){
		$("#issueMaintainForm").formValidate({
			promptPosition: "bottomLeft",
			submitHandler: function(form){
			/*
			if(!attachFileUploadComplete && $("#attachFileNames").val()!=null && $("#attachFileNames").val()!=''){
				$.messageBox({level:'warn',message:"附件还未上传完成，请稍候!"});
				return  ;
			}*/
			$(form).ajaxSubmit({
				success:function(data){
					if(data==null || !data.issueId){
						$.messageBox({message:data,level:"error"});
						return  ;
                	}else{
                		$.messageBox({message:"已经成功将该事件信息保存到系统中!"});
                		$("#accessCustomerList").empty();
                		$("#chatDialogTable").empty();
                		findAccessInboxByUpdateUser();
                		document.getElementById("issueMaintainForm").reset();
						/* getInboxList({ "inbox.org.id" :getCurrentOrgId() });
						getMessageByUser();
		                $("#issueDialog").dialog("close"); */
	                }
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
  	      			alert("提交数据时发生错误");
	   		  	}
			});
		},
			rules:{
				"issue.subject":{
					required:true,
					titleStr:true,
					rangelength:[2,50]
				},
				"issue.occurLocation":{
					//required:true,
					addressStr:true,
					maxlength:50
				},
				"issue.occurDate":{
					required:true
				},
				"issue.mainCharacters":{
					required:true,
					maxlength:30,
					multiNames:true
				},
				"issue.relatePeopleCount":{
					required:true,
					digits:true,
					range:[1,999999]
				},
				"issue.issueContent":{
					required:true
				},
				"selectOrgName":{
					required:true,
					orgLevelLessEqual:function(){
							return [getOccurOrgId(),<s:property value="@com.tianque.domain.property.OrganizationLevel@TOWN"/>];
						}
				},
				"issue.issueKind.id":{
					required:true
				},
				"issueDomain":{
					required:true
				},
				"issueTypes":{
					required:true
				}
// 				"issue.emergencyLevel.id":{
// 					required:true
// 				}
			},
			messages:{
				"issue.subject":{
					required:"请为该事件填写一个不小于2-50个字的主题",
					titleStr:"事件主题只能输入中英文、数字、引号、括号、空格、书名号、减号等字符",
					rangelength:$.format("事件主题不能小于{0}个或大于{1}个字符")
				},
				"issue.occurLocation":{
					//required:"请为该事件填写一个不超过50个字符的事发地点",
					maxlength:$.format("事发地点不能大于{0}个字符"),
					addressStr:"事发地点只能输入中英文、数字、括号、空格、减号、#号等字符"
				},
				"issue.occurDate":{
					required:"请输入该事件的发生日期"
				},
	            "issue.mainCharacters":{
					 required:"请输入主要当事人",
					maxlength:$.format("主要当事人不能大于{0}个字符"),
					multiNames:"主要当事人中只能输入中英文、数字、逗号、顿号等字符"
	            },
	            "issue.relatePeopleCount":{
	            	 required:"请输入涉及人数",
	            	digits:"涉及人数只能输入1到999999之间的整数",
					range:$.format("涉及人数只能输入{0}到{1}之间的整数")
	            },
				"issue.issueContent":{
					required:"请输入事件简述"
				},
				"selectOrgName":{
					required:"请选择发生网格",
					orgLevelLessEqual:"发生网格不能选择乡镇（街道）以上级别"
				},
				"issue.issueKind.id":{
					required:"请选择事件规模"
				},
				"issueDomain":{
					required:"请选择事件大类"
				},
				"issueTypes":{
					required:"请选择事件小类"
				}	
// 				"issue.emergencyLevel.id":{
// 					required:"请选择重大紧急等级"
// 				}
			}
		});
	}
	
	$("#issuePreservation").click(function(event) {
		var openId = $("#fromUserName").val();
		if(openId==null||openId.length==0){
			$.messageBox({level : 'warn',message:"受理失败，当前已接入用户为空!"});
			return;
		}
		$("#touser").val(openId);
		$("#issueMaintainForm").submit();
	});
	
	//转出
	$("#inboxRollOut").click(function(event){
		var openId = $("#fromUserName").val();
		if(openId==null||openId.length==0){
			$.messageBox({level : 'warn',message:"转出失败，当前已接入用户为空!"});
			return;
		}
		
		//dealState:0表示未做处理,dealState:3表示接入
	    var dealState=0;
		var oldDealState=3;
		var isKeyWordMsg=2;//isKeyWordMsg=2表示非关键字消息
		var dataList = 'openIds='+openId+
		'&inbox.dealState='+dealState+
		'&inbox.isKeyWordMsg='+isKeyWordMsg+
		'&oldDealState='+oldDealState;
		
	 	$.ajax({		
			type:'post',
			url:"${path}/weChat/inbox/updateDealState.action",
			async:false,
			data:dataList,
			dataType:'json',
			success : function(data) {
				if(data==true||data=="true"){
					$.messageBox({message:"转出成功!"});				
	        		$("#accessCustomerList").empty();
	        		$("#chatDialogTable").empty();
	        		findAccessInboxByUpdateUser();
	        		document.getElementById("issueMaintainForm").reset();
				}else {				
				    $.messageBox({message : "转出失败!"});
				}
			}
		});
	});
	
});

var status = 1;
function showInvolvedPlaces(){
	if($("#isInvolvedPlace").attr("checked")){
		$("#lab1").hide();
		$("#div1").hide();

		$("#lab2").show();
		$("#div2").show();
		<c:if test='${mode=="add"}'>
			if(isNull()){
				status++;
			}
		</c:if>
	}else{
		$("#lab2").hide();
		$("#div2").hide();

		$("#lab1").show();
		$("#div1").show();
		<c:if test='${mode=="add"}'>
			if(isNull()){
				status++;
			}
		</c:if>
	}
	if(status%2 == 0){
		<c:if test='${mode=="add"}'>
			$("#searchPlace").click();
		</c:if>
	}
}

function isNull(){
	if($("#issueOccurOrgSelector").val()==null||$("#issueOccurOrgSelector").val()==""){
		$.notice({
			title:"提示",
			message:"请先选择所属网格！",
			width: 300
		});
		return false;
		}
	return true;
}
/* //加载地图
function loadOpenLayersMap(){
	try{
	$("#occurOrgId").val(getCurrentOrgId());
	$("#issueViewMap").load("${path}/openLayersMap/product_3.0/gisIssue.jsp?currentOrgId="+$("#occurOrgId").val()+"&lon="+$("#centerLon").val()+"&lat="+$("#centerLat").val()+"&zoom="+$("#zoom").val());
	}catch(e){}
} */

function isTownDownOrganization(){
	return $.getSelectedNode(issueTree).attributes.orgLevelInternalId <= <s:property value="@com.tianque.domain.property.OrganizationLevel@TOWN"/>;
}
</script>
<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp" />

<div class="container container_24" >
	<div id="exceptionalSituationRecord" class="container container_24">
		<form id="exceptionalSituationRecordForm" method="post" action="${path}/plugin/taskListManage/exceptionalSituationRecord/addExceptionalSituationRecord.action"  >
			<@pop.token />
			<input type="hidden" name="mode" id="mode" value="${(mode)!}" />
			<input type="hidden" name="exceptionalSituationRecord.organization.id" id="orgId" value="${(exceptionalSituationRecord.organization.id)!}" />
			<input type="hidden" name="receipt.id" id="receiptId" value="${(exceptionalSituationRecord.id)!}" />
			<input type="hidden" name="receipt.objectType" id="objectType" value="<@s.property value='@com.tianque.plugin.taskList.constants.Constants@EXCEPTIONALSITUATIONRECORD_KEY' />" />
			
			<div class="grid_5 lable-right">
				<em class="form-req">*</em>
				<label class="form-lb1">时间：</label>
			</div>
			<div class="grid_7">
				<input type="text" name="exceptionalSituationRecord.recordDate" id="recordDate" value="${(exceptionalSituationRecord.recordDate?string('yyyy-MM-dd HH:mm:ss'))!}"  class="form-txt" readOnly/>
			</div>	
			<div class='clearLine'>&nbsp;</div>
			<div class="grid_5 lable-right">
				<em class="form-req">*</em>
				<label class="form-lbl">地点：</label>
			</div>
			<div class="grid_19">
				<input type="text" name="exceptionalSituationRecord.address" id="address" value="${(exceptionalSituationRecord.address)!}" <@s.if test="!'add'.equals(mode)">readOnly</@s.if> class="form-txt {required:true,messages:{required:'地点不能为空'}}" maxlength="50" />
			</div>	
			<div class='clearLine'>&nbsp;</div>
			
			<div class="grid_5 lable-right">
				<em class="form-req">*</em>
		        <label class="form-lbl">异常类型：</label>
		    </div>
		    <div class="grid_7">
		        <select id="exceptionalSituation" name="exceptionalSituationRecord.exceptionSituation.id" class="form-txt {required:true,messages:{required:'异常类型不能为空'}}" <@s.if test="!'add'.equals(mode)">disabled</@s.if>>
		            <@pop.OptionTag name="@com.tianque.domain.property.PropertyTypes@EXCEPTION_SITUATION_TYPE" defaultValue="${(exceptionalSituationRecord.exceptionSituation.id)!}" />
		        </select>
		    </div>
			
			<div class='clearLine'>&nbsp;</div>
			<div class="grid_5 lable-right">
				<label class="form-lbl">备注：</label>
			</div>
		
			<div class="grid_19">
				<input type="text" style="width:99%" name="exceptionalSituationRecord.mark" id="mark" value="${(exceptionalSituationRecord.mark)!}" <@s.if test="!'add'.equals(mode)">readOnly</@s.if> class="form-txt dialogtip" maxlength="300" />
			</div>	
			
			
			
		<div class='clearLine'>&nbsp;</div>
			<div id="signDiv" style="display:none;">
				<div class="grid_5 lable-right">
					<label class="form-lbl">所属网格：</label>
				</div>
				<div class="grid_19">
					<input type="text" style="width:99%" name="exceptionalSituationRecord.organization.fullOrgName" id="fullOrgName" value="${(exceptionalSituationRecord.organization.fullOrgName)!}" readOnly class="form-txt" />
				</div>
				<div class='clearLine'>&nbsp;</div>
				
				<div class="grid_5 lable-right">
					<label class="form-lbl">网格员联系电话：</label>
				</div>
				<div class="grid_19">
					<input type="text" style="width:99%" name="exceptionalSituationRecord.gridMemberPhone" id="gridMemberPhone" value="${(exceptionalSituationRecord.gridMemberPhone)!}" readOnly class="form-txt"  />
				</div>
				<div class='clearLine'>&nbsp;</div>
				
				<div class="grid_5 lable-right">
					<label class="form-lbl">签收人：</label>
				</div>
				<div class="grid_7">
					<input type="text" name="receipt.signMemberName" id="signMemberName" value="${(exceptionalSituationRecord.signMemberName)!}" readOnly class="form-txt dialogtip" maxlength="10" />
				</div>
				<div class="grid_5 lable-right">
					<label class="form-lbl">签收时间：</label>
				</div>
				<div class="grid_7">
					<input type="text" name="receipt.signDate" id="signDate" value="${(exceptionalSituationRecord.signDate?string('yyyy-MM-dd HH:mm:ss'))!}"  class="form-txt dialogtip" readOnly />
				</div>
				<div class='clearLine'>&nbsp;</div>
				
				<div class="grid_5 lable-right">
					<label class="form-lbl">签收意见：</label>
				</div>
				<div class="grid_19">
					<input type="text" style="width:99%" name="receipt.attitude" id="attitude" value="${(exceptionalSituationRecord.attitude)!}"  class="form-txt dialogtip" maxlength="50" />
				</div>	
			</div>
			<div class="grid_5 lable-right" id="fileToShow">
				<label class="form-lbl">附件：</label>
			</div>
			<div class="grid_7 lable-right" id="fileToShowMap">
		  <tr>
		    <#if (exceptionalSituationRecord.exceptionalSituationAnnexFiles??)&&(exceptionalSituationRecord.exceptionalSituationAnnexFiles?size>0)>	
				<td>
							<#list exceptionalSituationRecord.exceptionalSituationAnnexFiles as exceptionalSituationAnnexFile>
							<a  style="color: red" class="view" target="_Blank" href="${exceptionalSituationAnnexFile.physicsFullFileName }" title="${exceptionalSituationAnnexFile.fileName}">${exceptionalSituationAnnexFile.fileName}</a>;<br>      	
							</#list>
		                
					       
				</td>
		 </#if>
	     </tr>
	        </div>
			<div id="subMaintanceDialog"></div>
		    <select id="attachFileNames" name="attachFileNames" multiple="multiple" style="display:none"></select>
	
			<input name="isSubmit" id="isSubmit" type="hidden" value="">
		</form>
		<div class='clearLine'>&nbsp;</div>
	<div class="filePanel" id='filePanelForException'>
		<div class="grid_5 lable-right">
			<label class="form-lbl">附件上传：</label>
		</div>
		<div id=" " class="grid_19 heightAuto">
			<div id="custom-queue" class="ui-widget-border"></div>
			
			<input id="custom_file_upload" name="uploadFile" type="file" />
			
		</div>
	</div>
	<div class='clearLine'>&nbsp;</div>
  	</div>
</div>


<script type="text/javascript">
$(document).ready(function(){
    $('#custom_file_upload').uploadFile({
		queueID : 'custom-queue',
		selectInputId : "attachFileNames"
	});
	function removeAttach(fileName){
		$("input[name='file']").removeAttr("disabled");
		$("#attachFileNames").find("option:contains("+fileName+")").remove();
	}
	setFormDiv();
	$("#exceptionalSituationRecordForm").formValidate({
		promptPosition: "bottomLeft",
		submitHandler: function(form){
			emptyFormDivBefSubmit();
			$(form).ajaxSubmit({
				async:false,
				success:function(data){
					if(data == true){
						
					}else if(!data.id){
           	 			$.messageBox({ 
							level: "error",
							message:data
			 			});
            			return;
					}
	                if("add"==$("#mode").val()){
	                	 $.messageBox({message:"异常情况报告记录新增成功！"});
	                	 $("#exceptionalSituationRecordDialog").dialog("close");
	                }
	                if("sign"==$("#mode").val()){
	                	 $.messageBox({message:"异常情况报告记录签收成功！"});
	                	 $("#exceptionalSituationRecordDialog").dialog("close");
	                }
	                $("#exceptionalSituationRecordList").trigger("reloadGrid");
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
  	      			alert("提交数据时发生错误");
	   		    }
			});
		},
		rules:{
		},
		messages:{
		}
	});
});


function setFormDiv(){
	var mode = "${(mode)!}";
	if(mode == "add"){
		$("#signDiv").hide();
		$("#orgId").val(selectConfigTaskOrg());
		$("#fileToShow").hide();
		$("#fileToShowMap").hide();
	}
	if(mode == "sign"){
		$("#signDiv").show();
		$("#exceptionalSituationRecordForm").attr("action","${path}/plugin/taskListManage/common/signRecord.action");
		$("#signMemberName").val("<@s.property value='@com.tianque.core.util.ThreadVariable@getUser().getName()' />");
	    $("#filePanelForException").hide();
	}
}

function emptyFormDivBefSubmit(){
	var mode = "${(mode)!}";
	if(mode == "add"){
		$("#signDiv").find("input").val("");
	}
}
</script>
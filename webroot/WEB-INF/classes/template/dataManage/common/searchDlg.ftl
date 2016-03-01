<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp"/>

<form id="searchForm" method="post" enctype="multipart/form-data">
	<div id="upload-div" class="container container_24">
		<div class="grid_24 heightAuto">
		<#if bigType=="population">
			<div class="grid_3 lable-right">
				<label class="form-lbl">姓名：</label>
			</div>
			<div class="grid_5">
				<input type="text" id="name" name="searchVo.name" class="form-txt"/>
			</div>
			<div class="grid_3 lable-right">
				<label class="form-lbl">性别：</label>
			</div>
			<div class="grid_5">
				<select id="gender" name="searchVo.gender.id" class="form-txt">
					<@pop.OptionTag name="@com.tianque.domain.property.PropertyTypes@GENDER" />
				</select>
			</div>
			<div class="grid_3 lable-right">
				<label class="form-lbl">身份证号码：</label>
			</div>
			<div class="grid_5">
		    	<input type="text" name="searchVo.idCardNo" id="idCardNo" class="form-txt" maxlength="18"/>
			</div>
			<div class="clearLine">&nbsp;</div>
			<div class="grid_3 lable-right">
				<label class="form-lbl">临时居所：</label>
			</div>
			<div class="grid_21">
				<input type="text" id="currentAddress" name="searchVo.currentAddress" class="form-txt" />
			</div>
			<#elseif bigType=="location">
				<div class="grid_3 lable-right">
					<label class="form-lbl">场所名称：</label>
				</div>
				<div class="grid_21">
					<input type="text"  name="searchVo.name" class="form-txt" />
				</div>
				<div class="grid_3 lable-right">
					<label class="form-lbl">场所地址：</label>
				</div>
				<div class="grid_21">
					<input type="text" name="searchVo.address" class="form-txt" />
				</div>
			<#elseif bigType=="house">
				<div class="grid_3 lable-right">
					<label class="form-lbl">房屋名称：</label>
				</div>
				<div class="grid_21">
					<input type="text"  name="searchVo.name" class="form-txt" />
				</div>
				<div class="grid_3 lable-right">
					<label class="form-lbl">房屋地址：</label>
				</div>
				<div class="grid_21">
					<input type="text" name="searchVo.address" class="form-txt" />
				</div>
			<#elseif bigType=="dustbin">
				<div class="grid_3 lable-right">
					<label class="form-lbl">标识码：</label>
				</div>
				<div class="grid_5">
					<input type="text"  name="searchVo.dustbinCode" class="form-txt" />
				</div>
				<div class="grid_3 lable-right">
			     	<label class="form-lbl">部件类型：</label>
			  	</div>
			  	<div class="grid_5">
			  		<select name="searchVo.partType" class="form-txt" id="partType">
						<@pop.PropertyDictReleationSelectTag name="@com.tianque.domain.property.PropertyTypesYinchuan@PART_TYPE" 
				   			reletionId="partNameId" reletionName="@com.tianque.domain.property.PropertyTypesYinchuan@PART_NAME" id="partType"/>
					</select>
				</div>
				<div class="grid_3 lable-right">
					<label class="form-lbl">部件名称：</label>
				</div>
				<div class="grid_5">
					<select id="partNameId" name="searchVo.partName" class="form-txt">
						<@pop.OptionTag name="@com.tianque.domain.property.PropertyTypesYinchuan@PART_NAME" />
					</select>
			  	</div>
			<#elseif bigType=="builddatas">
				<div class="grid_4 lable-right">
					<label class="form-lbl">楼宇名称：</label>
				</div>
				<div class="grid_8">
					<input type="text" name="searchVo.buildingname" id="buildingname"  class="form-txt" maxlength="50" />
				</div>
				
				<div class="grid_4 lable-right">
					<label class="form-lbl">楼宇地址：</label>
				</div>
				<div class="grid_8">
					<input type="text" name="searchVo.buildingaddress" id="buildingaddress"  class="form-txt" maxlength="50" />
				</div>
				<div class='clearLine'></div>
				<div class="grid_4 lable-right">
					<label class="form-lbl">业主：</label>
				</div>
				<div class="grid_8">
					<input type="text" name="searchVo.owner" id="owner" class="form-txt" maxlength="20" />
				</div>
				
				<div class="grid_4 lable-right">
					<label class="form-lbl">负责人：</label>
				</div>
				<div class="grid_8">
					<input type="text" name="searchVo.responsibleperson" id="responsibleperson"  class="form-txt" maxlength="20" />
				</div>
				<div class='clearLine'></div>
				<div class="grid_4 lable-right">
					<label class="form-lbl">联系电话：</label>
				</div>
				
				<div class="grid_8">
					<input type="text" name="searchVo.phone" id="phone"  class="form-txt" maxlength="15" />
				</div>
				
				<div class="grid_4 lable-right">
					<label class="form-lbl">建筑结构：</label>
				</div>
				<div class="grid_8">
					<select name="searchVo.buildingstructures" id="buildingstructures" class="form-select">
						<@pop.OptionTag name="@com.tianque.domain.property.PropertyTypes@LETTINGHOUSE_STRUTS" />
					</select>
				</div>
			<#else>
				action里没有设置getBigType()方法
			</#if>
			<div class="clearLine">&nbsp;</div>
			<div id="orgTreeDiv">
				<div class="grid_3 lable-right">
					<label class="form-lbl">组织结构：</label>
				</div>
				<div class="grid_21">
					<input name="selectOrgName"  id="claimOrgSelector"  type="text" class="form-txt">
					<input name="searchVo.orgId" id="orgIdValue" type="hidden"/>
				</div>
				<div class="clearLine">&nbsp;</div>
			</div>
			<div class="grid_3 lable-right">
				<label class="form-lbl">数据状态：</label>
			</div>
			<div class="grid_3">
		    	<select id="dataState" name="searchVo.dataState"  class="form-txt">
		    		<option value="<@s.property value="@com.tianque.plugin.dataManage.util.Constants$ClaimState@UNCLAIM"/>">未认领</option>
		    		<option value="<@s.property value="@com.tianque.plugin.dataManage.util.Constants$ClaimState@CLAIMED"/>">已认领</option>
		    		<option value="-1">全部</option>
		    	</select>
			</div>
			<div class="grid_3 lable-right">
				<label class="form-lbl">查询时间：</label>
			</div>
			<div class="grid_4">
				<select id="dateType" name="searchVo.dateType"  class="form-txt">
		    		<option value="import">导入时间</option>
		    	</select>
			</div>
			<div class="grid_5">
				<input type="text" id="beginDate" name="searchVo.beginDate" readonly="readonly" class="form-txt" />
			</div>
			 <div class="grid_1 lable-right">
				<label class="form-lbl">至：</label>
			</div>
			<div class="grid_5">
				<input type="text" id="endDate" name="searchVo.endDate" readonly="readonly" class="form-txt" />
			</div>
		</div>
	</div>
</form>
<script>
$(document).ready(function(){
	var rootOrgId=USER_ORG_ID;
	<#if tempClassName=="newSocietyOrganizationsTemp"><#else>
		if(<@s.property value="@com.tianque.domain.property.OrganizationLevel@DISTRICT"/> > USER_ORG_LEVEL){
			$.ajax({
				async:false,
				url:'${path}/plugin/dataManage/'+$("#lowerCaseModuleName").val()+'Manage/getDistrictOrgIdForSearch.action?currentOrgId='+rootOrgId,
				success:function(responseData){
					rootOrgId = responseData;
				}
			});
		}
	</#if>	
	if($("#dmType").val()=="import"){
		$("#orgTreeDiv").remove();
	}else{
		var orgSelector;
	 	orgSelector=$("#claimOrgSelector").treeSelect({
	 		rootId:rootOrgId,
			inputName:"targetOrgId"
		});
		$.addClick(orgSelector,getOrgValue);
			
		function getOrgValue(){
			var selectOrgId=$.getSelectedNode(orgSelector).attributes.id;
			if (selectOrgId!=null){
				$("#orgIdValue").val(selectOrgId);
			}
		}
	}
//根据选择的数据类型调整时间选项
	$("#dataState").change(function(){ 
		if($("#dataState").val()==<@s.property value="@com.tianque.plugin.dataManage.util.Constants$ClaimState@UNCLAIM"/>){
			if($("#dateType option[value='claim']").length==1){
				$("#dateType option:last").remove();
			}
		}else{
			if($("#dateType option[value='claim']").length==0){
				$("#dateType").append("<option value='claim' selected>认领时间</option>");
			}
		}
	});
	
	$('#beginDate').datePicker({
		yearRange:'1900:2030',
		dateFormat:'yy-mm-dd',
    	maxDate:'+0d',
   		onSelect:function(dateText, inst) {
		if(dateText!=null&&dateText!=''){
			var dateUnit=dateText.split('-');
			var date=new Date(dateUnit[0],dateUnit[1]-1,dateUnit[2]);
			$("#endDate").datepicker("option", "minDate",date);
			}
		}
	});
	var currentDate = new Date();
	currentDate.setDate(1);
	$("#beginDate").datepicker("setDate",currentDate);
	$('#endDate').datePicker({
		yearRange: '1900:2030',
		dateFormat:'yy-mm-dd',
        maxDate:'+0d',
        onSelect: function(dateText, inst) {
		if(dateText!=null&&dateText!=''){
			var dateUnit=dateText.split('-');
			var date=new Date(dateUnit[0],dateUnit[1]-1,dateUnit[2]);
			$("#beginDate").datepicker("option", "maxDate",date);
			}
		}
	});
	$("#endDate").datepicker("setDate",new Date());
});
</script>
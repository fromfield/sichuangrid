<%@	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<jsp:include page="/includes/baseInclude.jsp" />
<div class="container container_24">
	<form id="searchMobileUserForm" action="" method="post">
		<input type="hidden" name="userVo.mobileusable" value='true'/>
		<%-- <input type="hidden" name="searchLockStatus" value='<s:property value="#parameters.isLock"/>'/> --%>
		<div class="grid_5 lable-right">
			<label class="form-lbl">用户名：</label>
		</div>
		<div class="grid_6">
			<input type="text" name="userVo.userName" class="form-txt" />
		</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">用户姓名：</label>
		</div>
		<div class="grid_6">
	    	<input type="text" name="userVo.name" class="form-txt" />
		</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">是否验证IMSI号：</label>
		</div>
		<div class="grid_6">
			<input type="hidden" name="userVo.ignoreIsValidatorImsiOrNot" id="isValidatorImsi">
	    	 <select id="userVo.validatorImsi" name="userVo.ignoreIsValidatorImsiOrNot">
	    	 	<option value="0"></option>
		       <option value="1">否</option>
		       <option value="2">是</option>
		    </select>
		</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">是否管理员：</label>
		</div>
		<div class="grid_6">
		<input type="hidden" name="userVo.ignoreIsAdminOrNot" id="isAdmin">
		    <select  id="userVo.admin" name="userVo.ignoreIsAdminOrNot">
		    	<option value="0"></option>
		       <option value="1">否</option>
		       <option value="2">是</option>
		    </select>
		</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">住宅电话：</label>
		</div>
		<div class="grid_6">
	    	<input type="text" name="userVo.homePhone" maxlength="15" class="form-txt" />
		</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">工作电话：</label>
		</div>
		<div class="grid_6">
	    	<input type="text" name="userVo.workPhone" maxlength="15" class="form-txt" />
		</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">手机号码：</label>
		</div>
		<div class="grid_6">
	    	<input type="text" name="userVo.mobile" maxlength="11" class="form-txt" />
		</div>
		<div class="grid_6 lable-right">
				<label class="form-lbl">是否匹配网格：</label>
			</div>
			<div class="grid_5">
			    <select name="userVo.matchupOrgOrNot" id="userVo.matchupOrgOrNot">
			       <option value="0"></option>
			       <option value="1">否</option>
			       <option value="2">是</option>
			    </select>
			</div>
		<div class='clearLine'></div>
			<div class="grid_6 lable-right">
				<label class="form-lbl">是否开启GPS定位：</label>
			</div>
			<div class="grid_5">
			    <select name="userVo.gpsOrNot" id="userVo.gpsOrNot">
			       <option value="0"></option>
			       <option value="1">否</option>
			       <option value="2">是</option>
			    </select>
			</div>
			<div class="grid_6 lable-right">
				<label class="form-lbl">是否开启四支队伍：</label>
			</div>
			<div class="grid_5">
			    <select name="userVo.fourTeamsOrNot" id="userVo.fourTeamsOrNot">
			       <option value="0"></option>
			       <option value="1">否</option>
			       <option value="2">是</option>
			    </select>
			</div>
		<div class='clearLine'>&nbsp;</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">所属部门：</label>
		</div>
		<div class="grid_6">
	    	<input id="userOrganization" type="text" name="userVo.organization.orgName" class="form-txt" />
	    	<input id="userOrganizationId" type="hidden" name="userVo.organization.id" class="form-txt" />
		</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">在线状态：</label>
		</div>
		<div class="grid_6">
		    <select name="userVo.onLineState" id="userVo.onLineState">
		       <option value="0"></option>
		       <option value="1">不在线</option>
		       <option value="2">在线</option>
		    </select>
		</div>
		<div class="grid_4 lable-right">
			<label class="form-lbl">账号状态：</label>
		</div>
		<div class="grid_4">
		    <select name="userVo.state" id="userVo.state">
		       <option value="0"></option>
		       <option value="1">待激活</option>
		       <option value="2">正常</option>
		        <option value="3">已停用</option>
		    </select>
		</div>
		<div class='clearLine'>&nbsp;</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">IMSI号：</label>
		</div>
		<div class="grid_7">
	    	<input id="userImsiMin" type="text" maxlength="15" name="userVo.imsiMin" class="form-txt" />
		</div>
		<div class="grid_1 lable-right">
			<label class="form-lbl">到</label>
		</div>
		<div class="grid_7">
	    	<input id="userImsiMax" type="text" maxlength="15" name="userVo.imsiMax" class="form-txt" />
		</div>
		<div class='clearLine'>&nbsp;</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">IMEI号：</label>
		</div>
		<div class="grid_7">
	    	<input id="imei" type="text" maxlength="15" name="userVo.imei" class="form-txt" />
		</div>
		<div class="grid_4 lable-right">
			<label class="form-lbl">手机型号：</label>
		</div>
		<div class="grid_6">
	    	<input id="mobileType" type="text" maxlength="15" name="userVo.mobileType" class="form-txt" />
		</div>
		<div class='clearLine'>&nbsp;</div>
		<div class="grid_5 lable-right">
			<label class="form-lbl">手机操作系统版本：</label>
		</div>
		<div class="grid_7">
	    	<input id="mobileSystemVersion" type="text" maxlength="15" name="userVo.mobileSystemVersion" class="form-txt" />
		</div>
	</form>
</div>

<script type="text/javascript">
$(document).ready(function(){
	
	
    var self=$("#userOrganization");
	var selfId=self.attr("id");
	var defaultOption={
		store:new Ext.data.SimpleStore({fields:[],data:[[]]}),
	    editable:false, //禁止手写及联想功能
	    mode: 'local',
	    triggerAction:'all',
	    name:'org',
	    fieldLabel : '组织机构',
	    maxHeight: 250,
	    tpl: "<div id="+selfId+"-tree"+" style='width:100%;overflow:auto;'>"+"</div>", //html代码
	    selectedClass:'',
	    onSelect:Ext.emptyFn,
	    //emptyText:'请选择...',
	    listWidth:180,
	    inputName:"userVo.organization.id",
	    allOrg:false,
	    url:false
	};
	function style(){
		$("#"+selfId+"-tree").parent().parent().remove();
		self.width(self.width()-25);
		$("#"+selfId+"tree").bgiframe();
	};
	style();
	var comboWithTooltip = new Ext.form.ComboBox(defaultOption);
	comboWithTooltip.applyTo(selfId);
	var url;
	if(defaultOption.url){
		url = defaultOption.url;
	}else{
		url = "/sysadmin/orgManage/firstLoadExtTreeData.action";
	}
	var tree ;
	$("#"+selfId+"-tree").height(defaultOption.maxHeight).width(defaultOption.listWidth);
	$.ajax({
		url:PATH+"/sysadmin/orgManage/ajaxSearchParentNodeIds.action?organization.id="+1,
		success:function(data){
			tree = $("#"+selfId+"-tree").initAdministrativeTree({shouldJugeMultizones:true,isFuncDep:true,allOrg:defaultOption.allOrg,url:url});
			tree.on("click",function(node,e) {
		        comboWithTooltip.setRawValue(node.text);
		        comboWithTooltip.collapse();
		        $("input[name='"+defaultOption.inputName+"']").val(node.id);
			});
			$.searchChild(tree,data);
		}
	});
	
	
	
	$("#userVo\\.admin").change(function (){
			var temp=$("#userVo\\.admin").attr("value");
			if(temp==1){
				$("#isAdmin").attr("value",false);
			}else if(temp==2){
				$("#isAdmin").attr("value",true);
			}
		});
	$("#userVo\\.validatorImsi").change(function (){
		var temp=$("#userVo\\.validatorImsi").attr("value");
		if(temp==1){
			$("#isValidatorImsi").attr("value",false);
		}else if(temp==2){
			$("#isValidatorImsi").attr("value",true);
		}
	});
	
});
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/PopGrid-taglib" prefix="pop"%>
<%@ include file="/includes/baseInclude.jsp"%>
<%
 request.setAttribute("populationName",java.net.URLDecoder.decode(request.getParameter("populationName"),"utf-8"));
%>
<style>
#pList tr.jqgrow td {
  white-space: normal !important;
  height:auto;
  vertical-align:text-top;
  padding-top:2px;
 }
</style>
<input type="hidden" id="idCardNo_search" name="idCardNo" value="<s:property value="#parameters.idCardNo"/>"/>
<input type="hidden" id="populationName" name="populationName" value="${populationName }"/>
<input type="hidden" id="populationType_search" name="populationType" value="<s:property value="#parameters.populationType"/>"/>
<input type="hidden" id="populationId_search" name="populationId" value="<s:property value="#parameters.populationId"/>"/>
<div class="content">
	<div style="width: 100%;">
		<table id="pList"></table>
		<div id="pListPager"></div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	    $("#pList").jqGridFunction({
		url:"${path}/systemOperateLogManage/findSystemOperateLogsPagerBySearchVo.action",
		postData: {
	        "systemOperateLogVo.dataKeyword": $("#idCardNo_search").val(),
	        "systemOperateLogVo.searchType": $("#populationType_search").val(),
	        "systemOperateLogVo.dataId" : $("#populationId_search").val()
        },
		datatype: "json",
		colModel:[
	    	{name:"id", index:"id", hidden:true},
	    	{name:"encryptId", index:"encryptId", hidden:true,frozen:true,hidedlg:true},
	    	{name:"operateDate", index:"operateDate",label:"时间",width:130},
	    	{name:"operatePerson", index:"operatePerson",label:"操作账号",formatter:operationUserFormatter,width:135,align:"center"},
	    	{name:"businessType", index:"businessType",label:"操作详情",width:458,formatter:operationDetailsFormatter},
	    	{name:"operateType", index:"operateType",label:"操作类型",width:300,hidedlg:true,hidden:true},
	    	{name:"dataOrgId.orgName", index:"dataOrgId.orgName", width:200, label:"数据所属网格",hidedlg:true,hidden:true},
			{name:"dataBeforeOrgId.orgName", index:"dataBeforeOrgId.orgName", width:160, label:"数据操作后所属网格",hidedlg:true,hidden:true},
			{name:"operateSource", index:"operateSource", width:160, label:"操作源",hidedlg:true,hidden:true}
//			

  		],
  		page:1,
  		width: <s:property value="#parameters.width"/>,
		height: <s:property value="#parameters.height"/>
	});
});
function operationTypeFormatter(el,options,rowData){
	var datavalue = rowData.operationType;
	if(datavalue=='1'){
		return "关注";
	}
	if(datavalue=='2'){
		return "取消关注";
	}
	if(datavalue=='3'){
		return "重新关注";
	}
	if(datavalue=='4'){
		return "转移";
	}
	if(datavalue=='5'){
		return "迁入到";
	}
	if(datavalue=='6'){
		return "迁出";
	}
	if(datavalue=='7'){
		return "录入";
	}
	if(datavalue=='9'){
		return "注销";
	}
	if(datavalue=='10'){
		return "删除";
	}
	if(datavalue=='11'){
		return "取消注销";
	}
	return "";
}
function qq(datavalue){
	if(datavalue=='1'){
		return "关注";
	}
	if(datavalue=='2'){
		return "取消关注";
	}
	if(datavalue=='3'){
		return "重新关注";
	}
	if(datavalue=='4'){
		return "转移";
	}
	if(datavalue=='5'){
		return "迁入到";
	}
	if(datavalue=='6'){
		return "迁出";
	}
	if(datavalue=='7'){
		return "录入";
	}
	if(datavalue=='9'){
		return "注销";
	}
	if(datavalue=='10'){
		return "删除";
	}
	if(datavalue=='11'){
		return "取消注销";
	}
	return "";
}
function personnelTypeFormatter(el,options,rowData){
	var datavalue = rowData.personnelType;
	if(datavalue.toUpperCase()=='POSITIVEINFO'){
		return "刑释人员";
	}
    if(datavalue.toUpperCase()=='IDLEYOUTH'){
        return "重点青少年";
    }
    if(datavalue.toUpperCase()=='DANGEROUSGOODSPRACTITIONER'){
         return "危险品从业人员";
    }
    if(datavalue.toUpperCase()=='DRUGGY'){
        return "吸毒人员";
    }
    if(datavalue.toUpperCase()=='AIDSPOPULATION'){
        return "艾滋病人员";
    }
    if(datavalue.toUpperCase()=='MENTALPATIENT'){
       return "严重精神障碍患者";
    }
    if(datavalue.toUpperCase()=='RECTIFICATIVEPERSON'){
       return "社区矫正人员";
    }
    if(datavalue.toUpperCase()=='SUPERIORVISIT'){
       return "重点上访人员";
    }
    if(datavalue.toUpperCase()=='POORPEOPLE'){
       return "需救助人员";
    }
    if(datavalue.toUpperCase()=='OTHERATTENTIONPERSONNEL'){
        return "其他人员";
     }
    if(datavalue.toUpperCase()=='FLOATINGPOPULATION'){
        return "流动人口";
     }
    if(datavalue.toUpperCase()=='INHABITANT'){
        return "常住人口";
     }
    if(datavalue.toUpperCase()=='OVERSEAPERSONNEL'){
    	return "境外人员";
    }
    if(datavalue.toUpperCase()=="HOUSEHOLDSTAFF"){
    	return "户籍人口";
    }
    return "";
}
function aa(datavalue){
	if(datavalue.toUpperCase()=='POSITIVEINFO'){
		return "刑释人员";
	}
    if(datavalue.toUpperCase()=='IDLEYOUTH'){
        return "重点青少年";
    }
    if(datavalue.toUpperCase()=='DANGEROUSGOODSPRACTITIONER'){
         return "危险品从业人员";
    }
    if(datavalue.toUpperCase()=='DRUGGY'){
        return "吸毒人员";
    }
    if(datavalue.toUpperCase()=='AIDSPOPULATION'){
        return "艾滋病人员";
    }
    if(datavalue.toUpperCase()=='MENTALPATIENT'){
       return "严重精神障碍患者";
    }
    if(datavalue.toUpperCase()=='RECTIFICATIVEPERSON'){
       return "社区矫正人员";
    }
    if(datavalue.toUpperCase()=='SUPERIORVISIT'){
       return "重点上访人员";
    }
    if(datavalue.toUpperCase()=='POORPEOPLE'){
       return "需救助人员";
    }
    if(datavalue.toUpperCase()=='OTHERATTENTIONPERSONNEL'){
        return "其他人员";
     }
    if(datavalue.toUpperCase()=='FLOATINGPOPULATION'){
        return "流动人口";
     }
    if(datavalue.toUpperCase()=='INHABITANT'){
        return "常住人口";
     }
    if(datavalue.toUpperCase()=='OVERSEAPERSONNEL'){
    	return "境外人员";
    }
    if(datavalue.toUpperCase()=='HOUSEHOLDSTAFF'){
    	return "户籍人口";
    }
    return "";
}
function residentTypeFormatter(el,options,rowData){
	var datavalue = rowData.personinitType;
	if(datavalue=='1'){
		return "特殊人群信息类";
	}
	if(datavalue=='2'){
		return "转移流动信息类";
	}
	if(datavalue=='3'){
		return "迁户注销信息类";
	}
	return "";

}

function operationContentFormatter(el,options,rowData){
    var datavalue=qq(rowData.operationType);
    if(datavalue=='录入'){
    	return rowData.personnelName+"在"+rowData.personnelOrganization.orgName+"的"+aa(rowData.personnelType)+"中被"+qq(rowData.operationType);
    }
	if(datavalue=='关注'||datavalue=='重新关注'||datavalue=='取消关注'){
		return rowData.personnelName+"在"+aa(rowData.personnelType)+"中被"+qq(rowData.operationType);
	}
	if(datavalue=='转移'){
		return rowData.personnelName+"从"+rowData.oldPersonnelOrganization.orgName+"的"+aa(rowData.personnelType)+"中被"+qq(rowData.operationType);
	}
	if(datavalue=='迁出'){
		return rowData.personnelName+"从"+rowData.oldPersonnelOrganization.orgName+"中"+qq(rowData.operationType);
	}
	if(datavalue=='迁入到'){
		return rowData.personnelName+""+qq(rowData.operationType)+""+rowData.oldPersonnelOrganization.orgName;
	}
	if(datavalue=="注销"){
		return rowData.personnelName+"在"+aa(rowData.personnelType)+"中"+qq(rowData.operationType);
	}
	if(datavalue=='删除'){
		return rowData.personnelName+"在"+aa(rowData.personnelType)+"中被"+qq(rowData.operationType);
	}
	if(datavalue=="取消注销"){
		return rowData.personnelName+"在"+aa(rowData.personnelType)+"中"+qq(rowData.operationType);
	}

}
function operationType(operateType){
	if(operateType=='1'){
	   return "【<font color='blue'>新增</font>】";
	}
	if(operateType=='2'){
		   return "【<font color='blue'>修改</font>】";
		}
	if(operateType=='3'){
		   return "【<font color='blue'>删除</font>】";
		}
	if(operateType=='4'){
		   return "【<font color='blue'>注销</font>】";
		}
	if(operateType=='5'){
		   return "【<font color='blue'>取消注销</font>】";
		}
	if(operateType=='6'){
		   return "【<font color='blue'>取消死亡</font>】";
		}
	if(operateType=='7'){
		   return "【<font color='blue'>死亡</font>】";
		}
	if(operateType=='8'){
		   return "【<font color='blue'>导入</font>】";
		}
	if(operateType=='9'){
		   return "【<font color='blue'>转为户籍人口</font>】";
		}
	if(operateType=='10'){
		   return "【<font color='blue'>转为流动人口</font>】";
		}
	if(operateType=='11'){
		   return "【<font color='blue'>转为刑释解救</font>】";
		}
	if(operateType=='12'){
		   return "【<font color='blue'>转移</font>】";
		}
	if(operateType=='13'){
		   return "【<font color='blue'>落户</font>】";
		}
	if(operateType=='24'){
		   return "【<font color='blue'>认领</font>】";
		}
	return "";
}
function operationDetailsFormatter(el,options,rowData){
	var type=$("#houseType").val();
	var result ="";
	if(type!=null && type!='' && type=="house" ){
		 result = "【"+$("#address").val()+"】";
	}else{
		result = "【"+$("#populationName").val()+"】";
	}
	if(rowData.dataOrgId != null && rowData.operateSource != null){
		if(rowData.operateType == '12'){
			result = result + "在【"+rowData.dataBeforeOrgId.orgName+"】的";
		}else{
			result = result + "在【"+rowData.dataOrgId.orgName+"】的";
		}
		result = result +"【"+ rowData.operateSource +"】模块中";
	}
	result = result + operationType(rowData.operateType);
	if(rowData.operateType != '9' && rowData.operateType != '10'
			&& rowData.operateType != '11'&& rowData.operateType != '12'){
		result = result +"【"+rowData.businessType+"】";
	}
	if(rowData.operateType == '12'){
		result = result +"【"+rowData.businessType+"】"+"至【"+rowData.dataOrgId.orgName+"】"; 
	}
	if(rowData.operateType == '2'){
		result = result + '，查看<a href="javascript:void(0)" onclick="viewCompareData('+rowData.id+')"><span style="color:blue;">详情</span></a>'
	}
	return result;
}

function operationUserFormatter(el,options,rowData){
	if(rowData.operatePerson=='admin'){
		return "系统消息";
	}
	return rowData.operatePerson;
}

function viewCompareData(systemoOperateLogId){
	var systemOperateLog = $("#pList").getRowData(systemoOperateLogId);
	$("#compareDataDialog").createDialog({
		width:550,
		height:400,
		zIndex:9999,
		title:'数据对比',
		url:'${path}/systemOperateLogManage/viewCompareData.action?systemoOperateLogId='+systemOperateLog.encryptId,
		buttons: {
			"关闭" : function(){
				$(this).dialog("close");
				$("#systemLogList").trigger("reloadGrid");
			}
		}
	});
}
</script>
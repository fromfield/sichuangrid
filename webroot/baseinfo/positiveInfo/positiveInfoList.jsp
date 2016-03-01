<%@	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>
<jsp:include page="/baseinfo/commonPopulation/jsFunctionInclude.jsp">
	<jsp:param value="PositiveInfo" name="moduleName"/>
</jsp:include>
<script type="text/javascript">
<pop:formatterProperty name="gender" domainName="@com.tianque.domain.property.PropertyTypes@GENDER" />
<pop:formatterProperty name="schooling" domainName="@com.tianque.domain.property.PropertyTypes@SCHOOLING" />
<pop:formatterProperty name="agoProfession" domainName="@com.tianque.domain.property.PropertyTypes@CAREER" />
<pop:formatterProperty name="positiveInfoType" domainName="@com.tianque.domain.property.PropertyTypes@POSITIVEINFO" />
<pop:formatterProperty name="attentionExtent" domainName="@com.tianque.domain.property.PropertyTypes@ATTENTION_EXTENT" />
function rendIsRepeat(el, options, rowData){
	if(1==rowData.isRepeat){
		return "是";
	}else{
		return "否";
	}
}

var dialogWidth=800;
var dialogHeight=650;
var gridOption = {
  	colModel:[
		{name:"id",index:"id",sortable:false,hidden:true,frozen:true},
		{name:"encryptId",index:"id",sortable:false,hidden:true,frozen:true},
		{name:"organization.id", index:"organization.id",sortable:false,hidden:true,hidedlg:true},
		{name:"操作",index:'id',label:'操作',width:90,formatter:operateFormatter,sortable:false,frozen:true,align:"center"},
		{name:'attentionExtent',index:"attentionExtent",label:'关注程度',width:100,formatter :attentionExtentColor,sortable:false},
		{name:"name",index:'name',label:'姓名', sortable:false,formatter:nameFont,width:100,frozen:true},
		{name:'gender',sortable:false,label:'性别',formatter : genderFormatter,align:"center",width:50},
		{name:'idCardNo',index:'idCardNo',label:'身份证号码',align:"center",width:160,sortable:false,frozen:true},
		{name:'organization.orgName',label:'所属网格',index:'orgInternalCode',width:150,hidden:true,sortable:false},
		{name:"mobileNumber",label:'联系手机',index:'mobileNumber',align:"center",sortable:false,hidden:true,width:100},
		{name:"telephone",label:'联系电话',index:'telephone',align:"center",sortable:false,hidden:true,width:110},
		{name:"birthday",index:'birthday',label:'出生日期',align:"center",sortable:false, hidden:true,width:90},
		{name:'schooling',label:'文化程度',sortable:false,formatter : schoolingFormatter,width:80,hidden:true},
		{name:"province",label:'户籍地',hidden:true, sortable:false,formatter:householdRegisterFormatter,width:120},
		{name:'nativePlaceAddress',label:'户籍地详址',sortable:false,index:'nativePlaceAddress',width:120,hidden:true},
		{name:'nativePoliceStation',label:'户籍派出所',sortable:false,index:'nativePoliceStation',width:120,hidden:true},
		{name:'currentAddress',label:'常住地址',index:'currentAddress',sortable:false,width:200},
		{name:'caseReason',label:'原罪名（错）',index:'caseReason',sortable:false,width:120,hidden:true},
		{name:"positiveInfoType",label:'人员类型',index:'positiveInfoType',sortable:false,hidden:true,formatter:positiveInfoTypeFormatter},
		{name:'laborEduAddress',label:'劳教(服刑)场所',index:'laborEduAddress',sortable:false,width:120,hidden:true},
		{name:'imprisonmentDate',label:'原判刑期',hidden:true,index:'imprisonmentDate',sortable:false,width:150},
		{name:'releaseOrBackDate',index:'releaseOrBackDate',sortable:false,label:'解教（刑释）日期',align:"center",width:130},
		{name:'isRepeat',index:'isRepeat',label:'是否累犯',sortable:false,hidden:true,formatter : rendIsRepeat,align:"center",width:75},
		{name:'agoProfession',label:'原职业',sortable:false,formatter : agoProfessionFormatter,width:80,hidden:true},
		{name:'resettlementDate',index:'resettlementDate',label:'安置日期',align:"center",sortable:false,width:80,hidden:true},
		{name:'noResettlementReason',label:'未安置原因',index:'noResettlementReason',width:150,sortable:false,hidden:true},
		{name:'hasServiceTeamMember',label:'有无服务成员',index:'hasServiceTeamMember',width:100,sortable:false,align:'center',formatter:hasServiceTeamMemberFormatter},
		{name:'lastRecordTime',label:'最新服务时间',index:'hasServiceTeamRecord',sortable:false,align:'center',width:100},
		{name:"isExpired",index:'isExpired',label:'是否过期',sortable:false,align:"center",hidden:true,hidedlg:true,width:90},
		{name:"isEmphasis",sortable:false,label:'是否关注',align:"center",hidden:true,hidedlg:true,width:100},
		{name:'sourcesState',index:'sourcesState',label:"数据来源",sortable:false,hidden:true,formatter:sourceStateFormatter,width:80,align:'center'},
		{name:'updateDate', sortable:false, label:'数据更新时间',align:"center", width:160},
		{name:'interviewCount',index:'interviewCount',sortable:false, label:'走访次数',align:"center", width:80},
		{name:'death',sortable:false,hidden:true,hidedlg:true,width:80}
  	]
}
</script>
<jsp:include page="/baseinfo/commonPopulation/commonPopulationList.jsp">
	<jsp:param value="PositiveInfo" name="moduleName"/>
	<jsp:param value="刑释人员" name="moduleCName"/>
	<jsp:param value="服务人员" name="supervisorPerson"/>
</jsp:include>
<div style="display:none;">
	<input type="hidden" id="_populationType_" name="population.populationType" value='<s:property value="@com.tianque.core.util.BaseInfoTables@POSITIVEINFO_KEY"/>'/>
		<input type="hidden" id="_supervisorName_"
	value='<s:property value="@com.tianque.service.util.ServiceTeamMemberOrRecord@getMemberAlias(@com.tianque.core.util.BaseInfoTables@POSITIVEINFO_KEY)" escape="false"/>'/>
	<input type="hidden" id="_superviceRecordName_"
	value='<s:property value="@com.tianque.service.util.ServiceTeamMemberOrRecord@getRecordAlias(@com.tianque.core.util.BaseInfoTables@POSITIVEINFO_KEY)" escape="false"/>'/>
</div>
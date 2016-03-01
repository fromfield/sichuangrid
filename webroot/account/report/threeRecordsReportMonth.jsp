<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />
<jsp:include page="/account/report/mould/threeRecordsReportMonthMould.jsp" />
<script type="text/javascript">
function getPrimaryOrgStat(statisticalGrid){
	$.ajax({
		url:'${path}/threeRecordsIssue/ledgerAccountReportManage/findAccountReportBySearchVo.action',
		data:{
			"accountReport.organization.id":$("#currentOrgId").val(),
			"accountReport.reportYear":$("#year").val(),
			"accountReport.reportMonth":$("#month").val(),
			"accountReport.accountType":0,
			"accountReport.reportType":$("#reportType").val(),
			"accountReport.orgLevelInternalId":$("#currentOrgId").attr("orgLevelInternalId")
		},
		success:function(data){
			if(data == null){
				var message = (data == null) ? '获取报表失败' : dataObj.message;
				$.messageBox({
					message: dataObj.message,
					level: "error"
				});
			}
			statisticalGrid.bindData(data);
		}
	})
}


$(document).ready(function(){
	var tableTitleName = organizationLevelInternalString()+"三本台账工作月";
	var primaryOrgStatGrid = initReportGrid(tableTitleName,false);
	getPrimaryOrgStat(primaryOrgStatGrid);
})
</script>



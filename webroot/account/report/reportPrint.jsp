<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />
<script type="text/javascript" src="${resource_path }/resource/external/jquery.PrintArea.js"></script>

<div id="threeRecordsReportPrint" style="height:100%;width:100%">
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#threeRecordsReportPrint").html($(".reportData").html());
})
</script>



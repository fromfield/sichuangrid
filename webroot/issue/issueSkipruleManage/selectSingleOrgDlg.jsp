<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib"%>
<%@ include file="/includes/baseInclude.jsp"%>

<div id="dialog-form" title="规则" class="container container_24">
		<div id="evaluate_tree_navigation" style="padding:10px 0 0 10px;"></div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	var tree = $("#evaluate_tree_navigation").initTree({
		rootId:"<s:property value='@com.tianque.core.util.ThreadVariable@getUser().getOrganization().getId()'/>"
	});
	
	tree.on('click', function(node, flag) {
		$("#selectSingleOrgNameHid").val(node.text);
		$("#selectSingleOrgIdHid").val(node.id);
		$("#selectSingleOrgTypeHid").val(node.attributes["orgTypeInternalId"]);
	});
});

</script>
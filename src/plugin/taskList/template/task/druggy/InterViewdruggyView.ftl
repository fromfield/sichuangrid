<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp"/> 
<table class="tablelist" id="infoList">
	<tr>
		 <td class="title"><label>走访人</label></td>
		 <td class="content" colspan="3"><span>${(druggyTask.createUserName)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>走访时间</label></td>
		 <td class="content" colspan="3"><span><@s.date name="druggyTask.createDate" format="yyyy-MM-dd HH:mm:ss" /></span></td>
	</tr>
	<tr>
		 <td class="title"><label>帮扶人员</label></td>
		 <td class="content" colspan="3"><span>${(druggyTask.helpPeople)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>有无异常</label></td>
		 <td class="content" colspan="3"><span><#if druggyTask.hasException == 1>有</#if><#if druggyTask.hasException == 0>无</#if></span></td>
	</tr>
	<tr>
		 <td class="title"><label>异常详情</label></td>
		 <td class="content" colspan="3"><span>${(druggyTask.exception)!}</span></td>
	</tr>
	
</table>
<div id="showTaskListReply"></div>
<script type="text/javascript">
	
</script>

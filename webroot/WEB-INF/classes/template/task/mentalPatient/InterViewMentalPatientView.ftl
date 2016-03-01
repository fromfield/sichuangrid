<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp"/> 
<table class="tablelist" id="infoList">
     <tr>
		 <td class="title"><label>走访人</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.createUserName)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>走访时间</label></td>
		 <td class="content" colspan="3"><span><@s.date name="mentalPatientTask.createDate" format="yyyy-MM-dd HH:mm:ss" /></span></td>
	</tr>
	<tr>
		 <td class="title"><label>帮扶人员</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.helpPeople)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>有无异常</label></td>
		 <td class="content" colspan="3"><span><#if mentalPatientTask.hasException == 1>有<#else>无</#if></span></td>
	</tr>
	<tr>
		 <td class="title"><label>异常情况</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.exception)!}</span></td>
	</tr>
</div>	

</table>
<div id="showTaskListReply"></div>
<script type="text/javascript">
	
</script>

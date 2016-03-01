<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp"/> 
<div id="tabList">
	<ul>
		<li><a  href="javascript:;" id="infoTab">信息</a> </li>
		<li><a  href="javascript:;" id="taskListReplyTab">回复列表</a> </li>
	</ul>
</div>
<table class="tablelist" id="infoList">
     <tr>
		 <td class="title"><label>姓名</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.name)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>身份证号码</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.idCard)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>电话号码</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.phone)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>时间</label></td>
		 <td class="content" colspan="3"><span><@s.date name="mentalPatientTask.time" format="yyyy-MM-dd HH:mm:ss" /></span></td>
	</tr>
	<tr>
		 <td class="title"><label>地点</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.place)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>帮扶人员</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.helpPeople)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>监护人姓名</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.guardianName)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>监护人电话</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.guardianTel)!}</span></td>
	</tr>
	<tr>
	     <td class="title"><label>外出</label></td>
	     <@s.if test="${(mentalPatientTask.isout)!}==1">
			<td class="content" colspan="3"><span>是</span></td>
		</@s.if>
		<@s.else>
			<td class="content" colspan="3"><span>否</span></td>
		</@s.else>
	</tr>
	<tr>
	     <td class="title"><label>已经服药</label></td>
	     <@s.if test="${(mentalPatientTask.isDriinked)!}==1">
			<td class="content" colspan="3"><span>已服药</span></td>
		</@s.if>
		<@s.else>
			<td class="content" colspan="3"><span>未服药</span></td>
		</@s.else>
	</tr>
	<tr>
		 <td class="title"><label>有无异常</label></td>
		 <td class="content" colspan="3"><span><#if mentalPatientTask.hasException == 1>有<#else>无</#if></span></td>
	</tr>
	<tr>
		 <td class="title"><label>异常情况</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.exception)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>所属网格</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.organization.fullOrgName)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>网格员联系电话</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.reporterTel)!}</span></td>
	</tr>
    <@s.if test='mentalPatientTask.statusPolice == 1'>
    <tr>
		 <td class="title"><label>派出所签收人</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.signMemberNamePolice)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>派出所签收时间</label></td>
		 <td class="content" colspan="3"><span><@s.date name="mentalPatientTask.signDatePolice" format="yyyy-MM-dd HH:mm:ss" /></span></td>
	</tr>
	<tr>
		 <td class="title"><label>派出所签收意见</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.attitudePolice)!}</span></td>
	</tr>
	</@s.if>
	<@s.if  test='mentalPatientTask.statusJustice == 1'>
	 <tr>
		 <td class="title"><label>卫生所签收人</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.signMemberNameJustice)!}</span></td>
	</tr>
	<tr>
		 <td class="title"><label>卫生所签收时间</label></td>
		 <td class="content" colspan="3"><span><@s.date name="mentalPatientTask.signDateJustice" format="yyyy-MM-dd HH:mm:ss" /></span></td>
	</tr>
	<tr>
		 <td class="title"><label>卫生所签收意见</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.attitudeJustice)!}</span></td>
	</tr>
	</@s.if>
	<tr>
		 <td class="title"><label>备注</label></td>
		 <td class="content" colspan="3"><span>${(mentalPatientTask.remark)!}</span></td>
	</tr>
	<tr id="fatesonid">
		<td class="title"><label>附件上传</label></td>
		<td class="content" colspan="3">
		    <div id="custom-queue"></div>
		</td>
	</tr>
</div>	

</table>
<div id="showTaskListReply"></div>
<script type="text/javascript">
	$(document).ready(function(){
	var  fileNames="";
	    <@s.if test="mentalPatientTask.annexFiles!=null && mentalPatientTask.annexFiles.size > 0">
				<@s.iterator value="mentalPatientTask.annexFiles" var="att">
				 fileNames += "<a href='${path}/plugin/taskListManage/common/downLoadAttachFile.action?attachFileId=${(att.id)!}'>${(att.fileName)!}</a><br/>";
				</@s.iterator>
			</@s.if>
			<@s.else>
			$("#fatesonid").hide();  
			</@s.else>
	$("#custom-queue").html(fileNames);		
	
	$( "#tabList" ).tabs({ selected: 0});
	$("#infoTab").click(function(){
		$("#infoList").show();
		$("#showTaskListReply").hide();
	});
	$("#taskListReplyTab").click(function(){
		$("#infoList").hide();
		$("#showTaskListReply").show();
		if($("#showTaskListReply").html()==""){
			$.get(PATH+"/plugin/taskListManage/common/taskListReplyListDlg.action",{'taskListReply.moduleKey':'reply_mentalPatientTask','taskListReply.taskId':'${id}'},function(data){
				$("#showTaskListReply").html(data);
			});
		}
	});
	});
</script>

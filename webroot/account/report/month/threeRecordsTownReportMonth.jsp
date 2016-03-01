<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/baseInclude.jsp" />
<% request.setAttribute("userName1",request.getParameter("userName"));%>
<% request.setAttribute("orgName1",request.getParameter("orgName"));%>
<style>
.countlistHead td{
	width: 55px;
}
</style>

<script type="text/javascript">
var thisTime=new Date();
var addMonth=thisTime.getMonth()+1;
var formatdate= thisTime.getFullYear()+"-"+addMonth+"-"+thisTime.getDate();
$("#time").text("填报日期："+formatdate);
timeShow();

$(function(){//初始化表格
	for(var y = 1; y <= 49; y ++){
		var td = "";
		for(var x = 1; x <= 37; x++){
			td = td + "<td id='"+ y + "_" + x +"'>0</td>";
		}
		$(".rowCount_" + y).append(td).html();
	}
})

function getReportData(){
	timeShow();
	$.ajax({
		url:'${path}/threeRecords/accountReport/getDataReport.action',
		data:{
			"orgId":$("#currentOrgId").attr("value"),
			"year":$("#year").val(),
			"month":$("#month").val()
		},
		success:function(data){
			var yCount = getJsonObjLength(data);
			for(var y = 1; y <= yCount; y ++){
				for(var x = 1; x <= 37; x++){
					$("#" + y + "_" + x).text(data[y.toString()][x.toString()]);
				}
			}
		}
	})
}

function timeShow(){
	$("#timeShow").text('中江县三本台账工作信息收集、处理、办结、情况统计表' + $("#year").val()+'年'+$("#month").val()+'月' + '（乡镇用）');
	$("#orgName").text("填报单位：" + "${orgName1}");
	//$("#userName").text("填报人：" + "${userName1}");
	//$("#chargePerson").text("负责人：" + "${userName1}");
}

function getJsonObjLength(jsonObj) {
    var Length = 0;
    for (var item in jsonObj) {
        Length++;
    }
    return Length;
}
</script>
<div style="overflow: auto;height: 470px;width: 1150px;" class="reportData">
<table style="width: 2500px" class="countlist" id="monthReport">
	<tr> 
		<td colspan="41" id="timeShow" style="height: 50px;text-align: center;font-size: 22px;color: black;font-weight: bold;">
		中江县三本台账工作信息收集、处理、办结、情况统计表XXXX年XX月（乡镇用）
		</td>
	</tr>
	<tr>
		<td colspan="8" id="orgName" style="text-align: center;font-size: 14px;height: 35px;">填报单位：${orgName}</td>
		<td colspan="8" id="userName" style="text-align: center;">填报人：</td>
		<td colspan="8" id="chargePerson" style="text-align: center;">负责人：</td>
		<td colspan="8" id="time" style="text-align: center;">填报日期：</td>
		<td colspan="9" style="text-align: center;">(单位：件)</td>
	</tr>


	<tr class="countlistHead">
		<td colspan="4" rowspan="2" style="text-align: center;">内容</td>
		<td rowspan="2" style="text-align: center;">合计</td>
		<td colspan="12" style="text-align: center;">民生工作</td>
		<td colspan="7" style="text-align: center;">困难工作</td>
		<td colspan="17" style="text-align: center;">稳定工作</td>
	</tr>
	<tr class="countlistHead">
		<td>小计</td><td>水利</td><td>交通</td><td>能源</td><td>教育</td><td>科技文本</td><td>医疗卫生</td><td>劳动与社会保障</td>
		<td>环境保护</td><td>城乡规划建设与管理</td><td>农业</td><td>其他</td><td>小计</td><td>住房</td><td>生活</td><td>医疗</td>
		<td>就业</td><td>就学</td><td>其他</td><td>小计</td><td>涉法涉诉</td><td>林水土</td><td>惠农政策及村（社区）政务财务</td>
		<td>民政问题</td><td>人口与医疗卫生</td><td>劳动保障</td><td>交通运输</td><td>城镇及综合执法</td><td>党纪政纪</td><td>教育</td>
		<td>企业改制</td><td>环境保护</td><td>组织人事</td><td>其他类</td><td>重点人员</td><td>其他</td>
	</tr>
	<tr class="rowCount_1">
		<td rowspan="7">村级累计</td>
		<td colspan="3">累计建账数</td>
	</tr>
	<tr class="rowCount_2">
		<td colspan="3">其中上年接转数</td>
	</tr>
	<tr class="rowCount_3">
		<td colspan="3">累计办结数</td>
	</tr>
	<tr class="rowCount_4">
		<td colspan="2" rowspan="4">其中</td>
		<td>实质性办结数</td>
	</tr>
	<tr class="rowCount_5">
		<td>阶段性办结数</td>
	</tr>
	<tr class="rowCount_6">
		<td>程序性办结数</td>
	</tr>
	<tr class="rowCount_7">
		<td>其中呈报乡镇数</td>
	</tr>
	<tr class="rowCount_8">
		<td   rowspan="8">村级本月</td>
		<td colspan="3">上月办理中</td>
	</tr>
	<tr class="rowCount_9">
		<td colspan="3">本月建账数</td>
	</tr>
	<tr class="rowCount_10">
		<td colspan="3">本月办结数</td>
	</tr>
	<tr class="rowCount_11">
		<td colspan="2" rowspan="4">其中</td>
		<td>实质性办结数</td>
	</tr>
	<tr class="rowCount_12">
		<td>阶段性办结数</td>
	</tr>
	<tr class="rowCount_13">
		<td>程序性办结数</td>
	</tr>
	<tr  class="rowCount_14">
		<td>其中呈报乡镇数</td>
	</tr>
	<tr class="rowCount_15">
		<td colspan="3">本月办理中</td>
	</tr>
	<tr class="rowCount_16">
		<td  rowspan="17">乡镇累计</td>
		<td  rowspan="9">累计收集</td>
		<td colspan="2">合计</td>
	</tr>
	<tr class="rowCount_17">
		<td rowspan="2">村级呈报数</td>
		<td>小计</td>
	</tr>
	<tr class="rowCount_18">
		<td>其中上年转接数</td>
	</tr>
	<tr class="rowCount_19">
		<td rowspan="2">乡镇建账数</td>
		<td>小计</td>
	</tr>
	<tr class="rowCount_20">
		<td>其中上年转接数</td>
	</tr>
	<tr class="rowCount_21">
		<td rowspan="4">其中</td>
		<td>乡镇本级直接收集数</td>
	</tr>
	<tr class="rowCount_22">
		<td>县委县政府及县级领导班子有关领导交办数</td>
	</tr>
	<tr class="rowCount_23">
		<td>县人大议案建议意见交办数</td>
	</tr>
	<tr class="rowCount_24">
		<td>县政协提案建议意见交办数</td>
	</tr>
	<tr class="rowCount_25">
		<td  rowspan="8">累计办结</td>
		<td colspan="2">合计</td>
	</tr>
	<tr class="rowCount_26">
		<td colspan="2">乡镇建账办结数</td>
	</tr>
	<tr class="rowCount_27">
		<td colspan="2">村级呈报件办结数</td>
	</tr>
	<tr class="rowCount_28">
		<td rowspan="5">其中</td>
		<td>实质性办结数</td>
	</tr>
	<tr class="rowCount_29">
		<td>阶段性办结数</td>
	</tr>
	<tr class="rowCount_30">
		<td>程序性办结数</td>
	</tr>
	<tr class="rowCount_31">
		<td>其中乡镇建账呈报县台账办数</td>
	</tr>
	<tr class="rowCount_32">
		<td>其中村级呈报件呈报县台账办数</td>
	</tr>
	<tr class="rowCount_33">
		<td  rowspan="17">乡镇本月</td>
		<td colspan="3">上月办理中</td>
	</tr>
	<tr class="rowCount_34">
		<td  rowspan="7">本月收集</td>
		<td colspan="2">合计</td>
	</tr>
	<tr class="rowCount_35">
		<td colspan="2">村级呈报数</td>
	</tr>
	<tr class="rowCount_36">
		<td colspan="2">乡镇建账数</td>
	</tr>
	<tr class="rowCount_37">
		<td rowspan="4">其中</td>
		<td>乡镇本级直接收集数</td>
	</tr>
	<tr class="rowCount_38">
		<td>县委县政府及县级领导班子有关领导交办数</td>
	</tr>
	<tr class="rowCount_39">
		<td>县人大议案建议意见交办数</td>
	</tr>
	<tr class="rowCount_40">
		<td>县政协提案建议意见交办数</td>
	</tr>
	<tr class="rowCount_41">
		<td  rowspan="8">本月办结</td>
		<td colspan="2">合计</td>
	</tr>
	<tr class="rowCount_42">
		<td colspan="2">乡镇建账办结数</td>
	</tr>
	<tr class="rowCount_43">
		<td colspan="2">村级呈报件办结数</td>
	</tr>
	<tr class="rowCount_44">
		<td rowspan="5">其中</td>
		<td>实质性办结数</td>
	</tr>
	<tr class="rowCount_45">
		<td>阶段性办结数</td>
	</tr>
	<tr class="rowCount_46">
		<td>程序性办结数</td>
	</tr>
	<tr class="rowCount_47">
		<td>其中乡镇建账呈报县台账办数</td>
	</tr>
	<tr class="rowCount_48">
		<td>其中村级呈报件呈报县台账办数</td>
	</tr>
	<tr class="rowCount_49">
		<td colspan="3">本月办理中</td>
	</tr>
</table>
</div>
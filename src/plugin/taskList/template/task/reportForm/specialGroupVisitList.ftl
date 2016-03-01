<#assign pop=JspTaglibs["/WEB-INF/taglib/pop-taglib.tld"]>
<#assign s=JspTaglibs["/WEB-INF/taglib/struts-tags.tld"]>
<@s.include value="/includes/baseInclude.jsp" />
<div id="nav" class="newChartsStyle cf" style="margin-left:5px;">
     <div class="btnbanner btnbannerData">
			<@s.include value="/common/orgSelectedComponent.jsp" />
     </div>
     时间： <select id="searchType">
	    		<option value="0" selected>按月统计</option>
	    		<option value="1">按周统计</option>
	    		<option value="2">按年统计</option>
	    	</select>
	    	<span id="searchByMonth">
				<select id="year"></select> 
				年 
				<select id="month"></select>
			</span>
			<span id="searchByWeek">
				<select id="week">
					<option value="0">本周</option>
					<option value="1">上周</option>
				</select>
			</span>
			<span id="searchByYear">
				<select id="yearVal"></select> 
				年 
			</span>
	        <a id="search" href="javascript:void(0)"><span>查询</span></a>
     <#-- 导出按钮功能 -->
      &nbsp;&nbsp;<a id="export" href="javascript:void(0)"><span>导出</span></a>
</div>


<div>
	<div id="gridbox" class="SigmaReport"></div>
</div>
<div id="PrintDlg"></div>
<script type="text/javascript">
function getmonth(){
	$.ajax({
		async: false,
		url: "${path }/stat/currentTime/getCurrentTimeForMonth.action?currenYear="+$("#year").val(),
		success:function(responseData){
			for(var i = 0;i<responseData.length;i++){
				$("#month").append("<option value='"+responseData[i]+"'>"+responseData[i]+"   月</option>");
			}
		}
	});
}
function getYear(){
	$.ajax({
		async: false,
		url: "${path }/stat/currentTime/getCurrentTimeForYear.action",
		success:function(responseData){
			for(var i = 0;i<responseData.length;i++){
				$("#year").append("<option value='"+responseData[i]+"'>"+responseData[i]+"</option>"); 
				$("#yearVal").append("<option value='"+responseData[i]+"'>"+responseData[i]+"</option>"); 
			}
			getmonth();
		}
	});
}
function typeChange(){
	var val = $("#searchType").val();
	if(val==0){
		  $("#searchByMonth").show();
		  $("#searchByWeek").hide();
		  $("#searchByYear").hide();
	}else if(val ==1 ){
		  $("#searchByMonth").hide();
		  $("#searchByWeek").show();
		  $("#searchByYear").hide();
	}else if(val==2){
		  $("#searchByMonth").hide();
		  $("#searchByWeek").hide();
		  $("#searchByYear").show();
	}
}
	var fitColumns=true;
		var columns = [
			{name:"orgname",caption:"区域",mode:"string"},
				{name:"general",caption:"吸毒人员",children:[
					{name:"druggySum",caption:"网格员发送",width:60,mode:"string"},
					{name:"druggyVisit",caption:"已签收",width:60,mode:"string"},
					{name:"druggyException",caption:"异常",width:40,mode:"string"},
					{name:"druggyReply",caption:"已回复",width:60,mode:"string"}
				]},
				{name:"general",caption:"严重精神障碍患者",children:[
					{name:"mentalPatientSum",caption:"网格员发送",width:60,mode:"string"},
					{name:"mentalPatientJusticeVisit",caption:"卫生所签收",width:60,mode:"string"},
					{name:"mentalPatientPoliceVisit",caption:"派出所签收",width:60,mode:"string"},
					{name:"mentalPatientException",caption:"异常",width:40,mode:"string"},
					{name:"mentalPatientJusticeReply",caption:"已回复",width:60,mode:"string"}
				]},
				{name:"general",caption:"社区服刑人员",children:[
					{name:"rectificativeSum",caption:"网格员发送",width:60,mode:"string"},
					{name:"rectificativeVisit",caption:"已签收",width:60,mode:"string"},
					{name:"rectificativeException",caption:"异常",width:40,mode:"string"},
					{name:"rectificativeReply",caption:"已回复",width:60,mode:"string"}
				]},
				{name:"general",caption:"刑释人员",children:[
					{name:"positiveSum",caption:"网格员发送",width:60,mode:"string"},
					{name:"positiveVisit",caption:"已签收",width:60,mode:"string"},
					{name:"positiveException",caption:"异常",width:40,mode:"string"},
					{name:"positiveReply",caption:"已回复",width:60,mode:"string"}
				]}
		];


var grid = null;


function onOrgChanged(orgId){
    var orgId=getCurrentOrgId();
	$.ajax({
		dataType:"json",
		url:'${path }/plugin/taskListManage/common/getSpecialGroupSumAndVisitList.action?orgId='+orgId+'&searchType='+$("#searchType").val()+'&year='+$("#year").val()+'&month='+$("#month").val()+'&week='+$("#week").val()+'&searchYear='+$("#yearVal").val(),
		success:function(data){
			grid.bindData(data);
		}
	})
}

$(document).ready(function(){

	$.gridboxHeight();
	var context = {};
	grid = new SigmaReport("gridbox",context,columns,null,null,"特殊人群",null,null);
	$("#title_gridbox").html("特殊人群统计表<a href='javascript:;' class='print' title='打印'></a>");
	//setTimeout('onOrgChanged()',350);
	getYear();
	typeChange();
	onOrgChanged();
	$("#year").change(function(){
		$("#month").empty();
		getmonth();
	});
	$(".print").click(function(){
		
		var url = '${path}/task/specialGroupVisitPrint.ftl?parentOrgId='+getCurrentOrgId()+"&moduleName="+document.title;
		$("#PrintDlg").createDialog({
			width: 1200,
			height:490,
			title:document.title,
			url:url,
			buttons: {
			   "打印" : function(){
				print();
		  	   },
			   "关闭" : function(){
			        $("#PrintDlg").dialog("close");
			   }
			}
		});
	});
	
	function print(){
		$("#Print").printArea();
		$("#PrintDlg").dialog("close");
	}
	
	$("#export").click(function(){
		var url = '${path }/plugin/taskListManage/common/downloadSpecial.action?orgId='+getCurrentOrgId()+'&searchType='+$("#searchType").val()+'&year='+$("#year").val()+'&month='+$("#month").val()+'&week='+$("#week").val()+'&searchYear='+$("#yearVal").val();
		downloadFile(url);
	});
	
	$("#search").click(function(){
		onOrgChanged();
	});
	
	$("#searchType").change(function(){
		 typeChange();
	});	
	function downloadFile(url){  
	    var elemIF = document.createElement("iframe");  
	    elemIF.src = url;  
	    elemIF.style.display = "none";  
	    document.body.appendChild(elemIF);  
	}
})



</script>


TQ.issueForViewButtons = function (dfop){

	$('#skipDealBox').hover(function(){
		if(getSelectedId()==null){
			$.messageBox({level:'warn',message:"请选择一条数据再进行操作！"});
			return;
		}
		$(this).find('.loadPage').css({'background':'#fff','display':'block'}).load(PATH+'/issues/issueManage/dispatchUrgentLevel.action?keyId='+getSelectedId(),function(){})
	},function(){
		$("div.loadPage").height(0);
		$("div.loadPage").width(0);
		$(this).find('.loadPage').css({'background':'#fff','display':'none'}).empty()
	})
	
	
	 
	function initOccurOrgSelector(){
			var orgLevelId = $("#jurisdictionsOrgLevel").val();
			var orgFuntionalTypeId = $("#jurisdictionsFunctionalOrgType").val();	
			orgTree=$("#fastSearchIssueOrg").treeSelect({
				nodeUrl:'/sysadmin/orgManage/ajaxOrgsForExtTreeByLevel.action?orgFuntionalTypeId='+orgFuntionalTypeId+'&orgLevelInternalId='+orgLevelId,
				allOrg:false,
				isRootSelected:false,
				showClearButton:false,
				emptyText:'',
				rootId:$("#jurisdictionsKeyId").val()
			});
			orgTree.on("click",function(node,e) {
				if(node != null){
					var nodeId = node.attributes.id;
					var nodeName = node.attributes.text;
					var nodeLevel = node.attributes.orgLevelInternalId;
					var nodeType = node.attributes.orgTypeInternalId;
					$("#selectNodeId").val(nodeId);
					$("#selectnodeLevel").val(nodeLevel);
					$("#selectnodeType").val(nodeType);
					$("#fastSearchIssueOrg").val(nodeName);
					$("#selectNodeName").val(nodeName);
				}
			});
			$("#fastSearchIssueOrg").width(155);
		}
		$("#fastSearchIssueOrg").one("click", function(){
			//initOccurOrgSelector();
		});
		var userOrgLevel = dfop.orgLevel;
		var orgLevelTemp = $("#jurisdictionsOrgLevel").val();
		var sourceType = dfop.sourceType;
		if(userOrgLevel==orgLevelTemp || sourceType == dfop.wechatInput){
			$("#searchDiv").css("display","none");
		}else{
			initOccurOrgSelector();
		}
		
		$("#searchOrgTree").click(function(){
			var orgLevelId = $("#jurisdictionsOrgLevel").val();
			var orgFuntionalTypeId = $("#jurisdictionsFunctionalOrgType").val();	
			var nodeLevel = $("#selectnodeLevel").val();	
			var nodeType = $("#selectnodeType").val();	
			if(orgFuntionalTypeId==""||orgFuntionalTypeId==null){
					if($("#selectNodeId").val()==""||$('#fastSearchIssueOrg').val()==null||$('#fastSearchIssueOrg').val()==""){
						$.messageBox({level:'warn',message:"请选择组织机构！"});
						return;
					}
					searchIsssueByOrgId();
			}else{
				var orgTypeInternal=dfop.orgTypeInternal;
				if($("#selectNodeId").val()==""||$('#fastSearchIssueOrg').val()==null||$('#fastSearchIssueOrg').val()==""){
						$.messageBox({level:'warn',message:"请选择组织机构！"});
						return;
					}
					searchIsssueByOrgId();
			}
		});
	$("#add").click(function(event){
		$("#issueDialog").createDialog({
			width:840,
			height:570,
			title:'新增事件处理信息',
			url:PATH+'/issues/issueManage/dispatch.action?mode=add&keyId='+$("#currentOrgId").val(),
			buttons: {
		   		"保存" : function(event){
		   			$("#issueMaintainForm").submit();
		   		},
   				"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	});

	$("#delete").click(function(event){
		if (hasRowSelected()){
			var rowData = getSelectedData();
			if('待阅读' == rowData.dealState || "待阅读" == rowData.dealState ){
				$.messageBox({level:'warn',message:"待阅读的事件不可以删除！"});
				return ;
			}
			$.confirm({
				title:"确认删除",
				message:"该事件处理信息删除后,将无法恢复,您确认删除该事件处理信息吗?",
				width:400,
				okFunc:function(){
					removeIssue(getSelectedData().encryptIdByIssueId);
				}
			});
		}else{
			$.messageBox({level:'warn',message:"没有可删除的数据！"});
			return;
		}
	});

	$("#update").click(function(event){
		if (hasRowSelected()){
			var rowData = getSelectedData();
			if('待阅读' == rowData.dealState || "待阅读" == rowData.dealState ){
				$.messageBox({level:'warn',message:"待阅读的事件不可以修改！"});
				return ;
			}else if('待处理' == rowData.dealState || "待处理" == rowData.dealState ){
				$.messageBox({level:'warn',message:"待办理的事件不可以修改！"});
				return ;
			}
			editIssue(getSelectedData().encryptIdByIssueStepId)
		}else{
			$.messageBox({level:'warn',message:"没有可修改的数据！"});
		}
	});

	$("#view").click(function(){
		viewIssue();
	});
	$("#refresh").click(function(){
		reloadIssue();
	});

	$("#search").click(function(event){
		var status = '';//<s:property value="@com.tianque.issue.state.IssueState@DEALING"/>
		$("#issueDialog").createDialog({
			width: 750,
			height: 400,
			title: "事项查询-请输入查询条件",
			url: PATH+"/issues/issueManage/dispatch.action?mode=search&keyId="+$("#currentOrgId").val()+'&issue.status='+status+'&tag='+viewType.value+'&selectedIssueType='+$("#issueTypeAccordion").data("selectedIssueType"),
			buttons: {
		   		"查询" : function(event){
		   			if($("#searchIssueForm").valid()){
		   				searchIssue();
			        	$(this).dialog("close");
		   			}
	   			},
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	});

	$("#normalIssue").click(function(event){
		if (hasRowSelected()){
			var selectedIssue = getSelectedData();
			var supervisionstate = selectedIssue.supervisionState;
			if(supervisionstate >= dfop.normalSupervise){
				$.messageBox({level:'warn',message:"该事件已被普通督办或正处于更高级别的督办中！"});
				return;
			}
			var	selectedId = selectedIssue.issueStepId;
			superviseIssue(selectedIssue.encryptIdByIssueStepId,dfop.normalSuperviseCode);
		}else{
			$.messageBox({level:'warn',message:"没有可督办的数据！"});
			return;
		}
	});

	$("#yellowCardIssue").click(function(event){
		if (hasRowSelected()){
			var selectedIssue = getSelectedData();
			var supervisionstate = selectedIssue.supervisionState;
			if(supervisionstate >= dfop.yellowCardSup){
				$.messageBox({level:'warn',message:"该事件已被黄牌督办或正处于更高级别的督办中！"});
				return;
			}
			var	selectedId = selectedIssue.issueStepId;
			superviseIssue(selectedIssue.encryptIdByIssueStepId,dfop.yellowSupCode);
		}else{
			$.messageBox({level:'warn',message:"没有可督办的数据！"});
			return;
		}
	});

	$("#redCardIssue").click(function(event){
		if (hasRowSelected()){
			var selectedIssue = getSelectedData();
			var supervisionstate = selectedIssue.supervisionState;
			if(supervisionstate == dfop.redCardSup){
				$.messageBox({level:'warn',message:"该事件已被红牌督办！"});
				return;
			}
			var	selectedId = selectedIssue.issueStepId;
			superviseIssue(selectedIssue.encryptIdByIssueStepId,dfop.redSupCode);
		}else{
			$.messageBox({level:'warn',message:"没有可督办的数据！"});
			return;
		}
	});

	$("#cancleSupervise").click(function(event){
		if (hasRowSelected() ){
			var selectedIssue = getSelectedData();
			var supervisionstate = selectedIssue.supervisionState;
			if(supervisionstate == dfop.noSup){
				$.messageBox({level:'warn',message:"该事件未被督办！"});
				return;
			}
			var	selectedId = selectedIssue.issueStepId;
			//确认取消前设置一个随机数已防出现重复提交的提示
			var tokenId = Math.round(Math.random()*10000000);
			$.confirm({
				title:"系统提示",
				message:"是否确定要取消对该事件处理的督办!",
				width:400,
				okFunc:function(){
					cancelSupervise(selectedIssue.encryptIdByIssueStepId, dfop.cancelSupCode,dfop.token,tokenId);
				}
			});
		}else{
			$.messageBox({level:'warn',message:"没有可取消督办的数据！"});
			return;
		}
	});

	$("#command").click(function(event){
		if (hasRowSelected() && $("#command").isButtonEnabled()){
			var	selectedId = Number(getSelectedId());
			var encryptIds=deleteOperatorByEncrypt("issue",selectedId,"encryptIdByIssueStepId");
			$("#issueDialog").createDialog({
				width: 600,
				height: 400,
				title: '领导批示',
				url:PATH+'/issues/issueManage/dispatchDeal.action?dealCode='+dfop.instructCode+'&keyId='+encryptIds,
				buttons: {
			   		"确定" : function(event){
		   				$("#singleContentDealForm").submit();
		   			},
			   		"关闭" : function(){
			        	$(this).dialog("close");
			   		}
				}
			});
		}else{
			$.messageBox({level:'warn',message:"没有可作领导批示的数据！"});
			return;
		}
	});
	

	$("#historicalIssue").click(function(event){
		if (hasRowSelected()){
			var selectedIssue = getSelectedData();
			if('待处理' == selectedIssue.dealState){
				$.messageBox({level:'warn',message:"该事件还未受理，不能设为历史遗留！"});
				return;
			}
			$.confirm({
				title:"系统提示",
				message:"是否将该事件设置为历史遗留?",
				width:400,
				okFunc:function(){
					var	selectedId = selectedIssue.issueStepId;
					settingIssueHistorical(selectedId,dfop.historicCode,dfop.token);
				}
			});
		}else{
			$.messageBox({level:'warn',message:"没有可作历史遗留的数据！"});
			return;
		}
	});

	//置顶操作
	$("#topIssue").click(function(event){
		var selectedIssue = getSelectedData();
			if (hasRowSelected()){
				var issueTag = dfop.done;
			if(viewType.value=="need"){
				issueTag =  dfop.needdo;
			}else if(viewType.value=="completed"){
				issueTag =  dfop.completed;
			}else if(viewType.value=="submit"){
				issueTag = dfop.submit;
			}else if(viewType.value=="assign"){
				issueTag = dfop.assign;
			}else if(viewType.value=="skip"){
				issueTag =  dfop.skip;
			}else if(viewType.value=="verification"){
				issueTag =  dfop.veritfication;
			}else if(viewType.value=="checkGrade"){
				issueTag =  dfop.checkGrade;
			}
			$.ajax({
				url:"/issues/issueManage/topNeedDoIssue.action",
				data:{
					"topIssue.issueId":selectedIssue.encryptIdByIssueId,
					"topIssue.issueTag":issueTag
				},
				success:function(responseData){
					if (responseData==true){
						$.messageBox({message:$("#topIssue").text()+"成功!"});
						setTimeout(reloadIssue,1000);
					}else{
						$.messageBox({level:'error',message:$("#topIssue").text()+"失败!"});
					}
				}
			});
		}else{
			$.messageBox({level:'warn',message:"没有可"+$(this).text()+"的事件！"});
			return;
		}
	});	

	//加急事件,取消加急事件
	$("#urgent").click(function(event){
		var dealCode = dfop.urgent
		var cancelCode = dfop.cancelUrgentCode
		var token =dfop.token
		var selectedIssue = getSelectedData();
		if(selectedIssue.urgent=='1'){
			bindCancleUrgentById(selectedIssue.encryptIdByIssueStepId,cancelCode,token);
		}else{
			bindUrgentById(dealCode,selectedIssue.encryptIdByIssueStepId);
		}
	});

	//打印
	$("#printIssue").click(function(event){
		if(!hasRowSelected()){
			$.messageBox({level:'warn',message:"没有可作打印的数据！"});
			return ;
		}
		var selectedIssue = getSelectedData();
		var source= $("#jurisdictionsViewType").val();
		$("#issueDialog").createDialog({
			width: 900,
			height: 600,
			title: '打印派单',
			url:PATH+'/issues/issueManage/viewSubDetail.action?mode=print&source='+source+'&keyId='+selectedIssue.encryptIdByIssueStepId,
			buttons: {
		   		"打印" : function(event){
					$("#issueAccordingPrint").printArea();
	   			},
	   			"导出word" : function(event){
					exportWord();
	   			},
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	});
	/**
	*验证按钮改为办理按钮
	$("#evaluate").click(function(event){
		var selectedIssue = getSelectedData();
		if(selectedIssue.dealState!=null && '待验证' == selectedIssue.dealState){
			//dealIssue(selectedIssue.encryptIdByIssueStepId);
			var issueStepId = selectedIssue.encryptIdByIssueStepId;
			if(issueStepId==null){
		 		return;
			}
			var selectedIssue = getSelectedData();
			var issuesKeyId = selectedIssue.encryptIdByIssueId;
			$("#issueDialog").createDialog({
				width:720,
				height:550,
				title:'验证事件',
				url:PATH+'/issues/issueManage/dispatchDeal.action?mode=deal&keyId='+issueStepId+'&issuesKeyId='+issuesKeyId,
				buttons: {
					"确定" : function(event){
						$("#issueDealForm").submit();
					},
					"关闭" : function(){
						$(this).dialog("close");
					}
				}
			});
		}else{
			$.messageBox({level:'warn',message:"该事件不可办理，请进行其它操作！"});
		}
	});
	*/
/*	$("#evaluate").click(function(event){
		if (hasRowSelected() && $("#evaluate").isButtonEnabled()){
			var selectedIssue = getSelectedData();
			$("#issueDialog").createDialog({
				width: 700,
				height: 500,
				title: "事件验证",
				url: "PATH/issues/issueManage/dispatchIssueEvaluate.action?issueEvaluate.issue.id="+selectedIssue.encryptIdByIssueId,
				buttons: {
			   		"验证" : function(event){
			   			$("#issueEvaluateForm").submit();
		   			},
			   		"关闭" : function(){
			        	$(this).dialog("close");
			   		}
				}
			});
		}else{
			$.messageBox({level:'warn',message:"没有可验证的数据！"});
			return;
		}
	});
*/
	//转为工作台帐
	$("#convertToWorkingRecord").click(function(event){
		if (hasRowSelected() && $("#convertToWorkingRecord").isButtonEnabled()){
			var selectedIssue = getSelectedData();
			$("#issueDialog").createDialog({
				width: 800,
				height: 480,
				title: "转为台帐",
				url: PATH+"/issues/issueManage/dispatch.action?mode=convertToWorkingRecord&keyId="+selectedIssue.encryptIdByIssueId,
				buttons: {
					"保存" : function(event){
		   				$("#workingRecordForm").submit();
		   			},
			   		"关闭" : function(){
			        	$(this).dialog("close");
			   		}
				}
			});
		}else{
			$.messageBox({level:'warn',message:"没有可"+$(this).text()+"的事件！"});
			return;
		}
	});

	$("#viewProcess").click(function(){
		var data = $.extend($("#issueList").getPostData(),{"viewProcess":1,"leaderView":1,"orgLevelInternalId":dfop.orgLevelInternalId,"orgLevel":"",statusType:statusTypeFunction()});
		$("#viewProcessDialog").createDialog({
			width: document.documentElement.clientWidth,
			height: document.documentElement.clientHeight,
			title: "下辖"+viewType.name+"事件--动态列表",
			create:function(event,ui){
				$(event.target).prev().hide();
			},
			url: PATH+"/issues/issueManage/findJurisdictionsForProcess.action?"+$.param(data)
		});
		$("#viewProcessDialog").css("overflow","hidden");
	});

	$("#publicltyCass").click(function(event){
		var selectedIssue = getSelectedData();
		if (!hasRowSelected()){
			$.messageBox({level:'warn',message:"没有可设为宣传案例的事件！"});
			return;
		}
		if(selectedIssue.publicltycass==1){
			$.messageBox({message:"该事件处理已经被设为宣传案例!",level:"warn"});
			return;
		}
		$.confirm({
			title:"系统提示",
			message:"是否要将该事件处理设置为宣传案例?",
			width:400,
			okFunc:publicltyCass
		});
	});
	$("#cancelPublicltyCass").click(function(event){
		var selectedIssue = getSelectedData();
		if (!hasRowSelected()){
			$.messageBox({level:'warn',message:"没有可设为宣传案例的事件！"});
			return;
		}
		if(selectedIssue.publicltycass==0){
			$.messageBox({message:"该事件处理不是宣传案例!",level:"warn"});
			return;
		}
		$.confirm({
			title:"系统提示",
			message:"是否要将该事件处理取消宣传案例?",
			width:400,
			okFunc:cancelPublicltyCass
		});
	});

	$("#applyDelay").click(function (){
		if(!hasRowSelected()){
			$.messageBox({level:'warn',message:"请选择一条数据再进行操作！"});
			return;
		}
		var selectedIssue = getSelectedData();
		if(selectedIssue == null || '办理中' != selectedIssue.dealState){
			$.messageBox({level:'warn',message:"非处理中的数据，不能进行延期申请！"});
			return;
		}
		if('200' == selectedIssue.supervisionState || 200 == selectedIssue.supervisionState){
			$.messageBox({level:'warn',message:"该事件已被红牌督办，不能进行延期申请！"});
			return;
		}
		if('审核中' == selectedIssue.delayState){
			$.messageBox({level:'warn',message:"该事件正处于申请延期中，请等待领导审批！"});
			return;
		}
		$("#issueDialog").createDialog({
			width: 560,
			height: 230,
			title: "申请延期",
			url: PATH+"/issue/issueManage/applyDelayDlg.jsp?issueStepId="+selectedIssue.encryptIdByIssueStepId,
			buttons: {
		   		"申请" : function(event){
		   			$("#issueApplyDelayForm").submit();
	   			},
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	});
	
	$("#auditDelay").click(function (){
		if(!hasRowSelected()){
			$.messageBox({level:'warn',message:"请选择一条数据再进行操作！"});
			return;
		}
		var selectedIssue = getSelectedData();
		if(selectedIssue == null || selectedIssue.delayState=='' || typeof(selectedIssue.delayState)=='undefined'){
			$.messageBox({level:'warn',message:"该事件没有延期申请！"});
			return;
		}
		if('200' == selectedIssue.supervisionState || 200 == selectedIssue.supervisionState){
			$.messageBox({level:'warn',message:"该事件已被红牌督办，申请已失效！"});
			return;
		}
		if('已失效' == selectedIssue.delayState){
			$.messageBox({level:'warn',message:"申请已失效"});
			return;
		}
		if('审核中' == selectedIssue.delayState){
			$("#issueDialog").createDialog({
				width: 780,
				height: 440,
				title: "申请延期",
				url: PATH+"/issues/issueApplyDelay/dispatch.action?issueStepId="+selectedIssue.encryptIdByIssueStepId,
				buttons: {
					"保存" : function(event){
			   			$("#auditDelayForm").submit();
		   			},
			   		"关闭" : function(){
			        	$(this).dialog("close");
			   		}
				}
			});
		}
	});
	
	$("#delayDetails").click(function(){
		viewDelay();
	});
	
	$("#viewDelay").click(function (){
		viewDelay();
	});

	$("#readTop,#readBottom").click(function(event){
		var selectedIssue = getSelectedData();
		if(selectedIssue.dealState!=null && "待阅读" == selectedIssue.dealState){
			simpleDealIssue(selectedIssue.encryptIdByIssueStepId,dfop.readCode);
		}else{
			$.messageBox({level:'warn',message:"该事件不可阅读，请进行其它操作！"});
		}
	});
	$("#conceptTop,#conceptBottom").click(function(event){
		var selectedIssue = getSelectedData();
		if(selectedIssue.dealState!=null && '待处理' == selectedIssue.dealState){
			simpleDealIssue(selectedIssue.encryptIdByIssueStepId,dfop.conceptCode);
		}else{
			$.messageBox({level:'warn',message:"该事件不可受理，请进行其它操作！"});
		}
	});
	//由于该页面是动态的，使用click会重复绑定事件,所有使用以下方法
	$("#dealTop,#dealBottom").die().live("click",function(event){
		var selectedIssue = getSelectedData();
		if(selectedIssue.dealState!=null && ('办理中' == selectedIssue.dealState || '待验证' == selectedIssue.dealState)){
			dealIssue(selectedIssue.encryptIdByIssueStepId);
		}else{
			$.messageBox({level:'warn',message:"该事件不可办理，请进行其它操作！"});
		}
	});
	$("#reportToTop,#reportToBottom").click(function(event){
		var selectedIssue = getSelectedData();
		if(selectedIssue.dealState!=null){
			simpleDealIssue(selectedIssue.encryptIdByIssueStepId,dfop.reportCode);
		}else{
			$.messageBox({level:'warn',message:"该事件不可 上报指挥中心，请进行其它操作！"});
		}
	});

	$("#grade").click(function(){
		if(!hasRowSelected()){
			$.messageBox({level:'warn',message:"请选择可评分的数据！"});
			return;
		}
		var selectedIssue = getSelectedData();
		$.post(PATH+'/issues/issueManage/issueGradeIsVisabled.action?keyId=' + selectedIssue.encryptIdByIssueId, function (data) {
			if(isNaN(data)){
				$.messageBox({level:'warn',message: data});
				return;
			}
			$("#gradeDialog").createDialog({
				width: 700,
				height: 400,
				title: "给部门打分",
				url: PATH+'/issues/issueManage/issueGrade.action?keyId=' + selectedIssue.encryptIdByIssueId,
				buttons: {
			   		"评分" : function(event){
			   			$("#gradeIssueForm").submit();
		   			},
			   		"关闭" : function(){
			        	$(this).dialog("close");
			   		}
				}
			});
		});
	});
	$("#gradeHistory").click(function(){
		if(!hasRowSelected()){
			$.messageBox({level:'warn',message:"请选择一条数据再进行操作！"});
			return;
		}
		var selectedIssue = getSelectedData();
		$("#gradeDialog").createDialog({
			width: 855,
			height: 550,
			title: "评分详情",
			url:PATH+ '/issues/issueManage/dispatch.action?mode=gradeHistory&keyId='+ selectedIssue.encryptIdByIssueId,
			buttons: {
		   		"关闭" : function(){
		        	$(this).dialog("close");
		   		}
			}
		});
	});
	$("#refreshSearchKey").click(function(){
		$("#selectNodeId").val(null);
		initOccurOrgSelector();
		$("#fastSearchIssueOrg").val("");
		$("#selectNodeName").val("");
	});

function searchIssue(){
	setConditionImportant();
	var data=$("#searchIssueForm").serializeArray();
	var searchIssueVo={};
	for(i=0;i<data.length;i++){
		 if (searchIssueVo[data[i].name]) {
           searchIssueVo[data[i].name]=searchIssueVo[data[i].name]+","+data[i].value;
		} else {
            searchIssueVo[data[i].name] = data[i].value;
		}
	}
	var pageData = $.extend(
			{
			"searchIssueVo.sortField":"issueId",
			"searchIssueVo.order":"desc",
			"searchIssueVo.orgLevelInternalId":$("#jurisdictionsOrgLevel").val(),
			"searchIssueVo.functionalOrgType":$("#jurisdictionsFunctionalOrgType").val(),
			"searchIssueVo.leaderView":1,
			"viewType":$("#jurisdictionsViewType").val(),
			"type":$("#jurisdictionsIssueType").val(),
			"keyId":$("#jurisdictionsKeyId").val(),
			"orgLevel":$("#jurisdictionsOrgLevel").val(),
			"sourceTypeInternalId":$("#jurisdictionsSourceType").val(),
			"superviseType":$("#_timeOutTypeSelect").val(),
			"searchIssueVo.searchOrgId":$("#selectNodeId").val()
			},
			searchIssueVo);
	$("#issueList").setGridParam({
		url:PATH+"/issues/searchIssueByLevelManage/findIssueForView.action",
		datatype: "json",
		page : 1
	});
	$("#issueList").setPostData(pageData);
	$("#issueList").trigger("reloadGrid");
	$("#_statusTypeSelect").val('');
}
function searchIsssueByOrgId(stateType){
	var searchIssueVo={};
	var pageData = $.extend(
			{
			"searchIssueVo.sortField":"issueId",
			"searchIssueVo.order":"desc",
			"searchIssueVo.statusType": stateType,
			"searchIssueVo.orgLevelInternalId":$("#jurisdictionsOrgLevel").val(),
			"searchIssueVo.functionalOrgType":$("#jurisdictionsFunctionalOrgType").val(),
			"searchIssueVo.leaderView":1,
			"searchIssueVo.searchOrgId":$("#selectNodeId").val(),
			"searchIssueVo.targeOrgId":$("#jurisdictionsKeyId").val(),
			"viewType":$("#jurisdictionsViewType").val(),
			"type":$("#jurisdictionsIssueType").val(),
			"statusType":$("#_searchStatusType").val(),
			"searchIssueVo.evaluateType":$("#_statusTypeSelect").val(),
			"superviseType":$("#_timeOutTypeSelect").val()
			},
			searchIssueVo);
	$("#issueList").setGridParam({
		url:PATH+"/issues/searchIssueByLevelManage/findIssueForView.action",
		datatype: "json",
		page : 1
	});
	$("#issueList").setPostData(pageData);
	$("#issueList").trigger("reloadGrid");
}

function setConditionImportant(){
	//是否重大事件
	var conditionImportant = $("#conditionImportant").val();
	if($("#conditionImportant").val()==""){
		$("#conditionImportant").attr("disabled","disabled");
	}
}


function publicltyCass(){
	var selectedIssue = getSelectedData();
	$.ajax({
		url:PATH+'/issues/issueManage/publicltyCass.action',
		data:{
			"keyId":selectedIssue.encryptIdByIssueId
		},
		success:function(data){
			if (data.issueId){
				setTimeout(reloadIssue,1000);
				$.messageBox({message:"该事件处理已设置为宣传案例!"});
			}else{
			 	$.messageBox({message:data});
			}
		}
	});
}
function cancelPublicltyCass(){
	var selectedIssue = getSelectedData();
	$.ajax({
		url:PATH+'/issues/issueManage/cancelPublicltyCass.action',
		data:{
			"keyId":selectedIssue.encryptIdByIssueId
		},
		success:function(data){
			if (data.issueId){
				setTimeout(reloadIssue,1000);
				$.messageBox({message:"该事件处理已取消宣传案例!"});
			}else{
			 	$.messageBox({message:data});
			}
		}
	});
}

function issueIsCurrntOrg(issueStepId){
	var cando = 1;
	$.ajax({
		async:false,
		url:PATH+'/issues/issueManage/issueCanDeal.action',
		data:{
			"keyId":issueStepId
		},
		success:function(data){
			if (data == true || data == 'true'){
				cando = 1;
			}else{
				$.messageBox({level:'warn',message:data});
				cando = 0 ;
			}
		}
	});
	return cando ;
}

function dealIssue(issueStepId){
	if(issueStepId==null){
 		return;
	}
	if(issueIsCurrntOrg(issueStepId)== 0){
		return ;
	}
	var selectedIssue = getSelectedData();
	var issuesKeyId = selectedIssue.encryptIdByIssueId;
	var location=PATH+'/issues/issueManage/dispatchDeal.action?mode=deal&keyId='+issueStepId+'&issuesKeyId='+issuesKeyId;
	if($("#isSkip").val()!='undefined' && $("#isSkip").val()!=undefined){
		location=location+"&isSkip="+$("#isSkip").val();
	}
	$("#issueDialog").createDialog({
		width:720,
		height:550,
		title:'办理',
		url:location,
		buttons: {
			"确定" : function(event){
				$("#issueDealForm").submit();
			},
			"关闭" : function(){
				$(this).dialog("close");
			}
		}
	});
}


function simpleDealIssue(issueStepId,dealType){
	if(issueStepId==null){
 		return;
	}
	if(issueIsCurrntOrg(issueStepId)== 0){
		return ;
	}
	var dealTitil = "受理";
	if(dealType == dfop.readCode){
		dealTitil = "阅读";
	}else if(dealType == dfop.reportCode){
		dealTitil = "上报指挥中心";
	}
	$("#issueDialog").createDialog({
		width:350,
		height:200,
		title:dealTitil,
		url:PATH+'/issues/issueManage/dispatchDeal.action?dealCode='+dealType+'&keyId='+issueStepId,
		buttons: {
			"确定" : function(event){
				$("#issueDealForm").submit();
			},
			"关闭" : function(){
				$(this).dialog("close");
			}
		}
	});
}

function viewDelay() {
	if(!hasRowSelected()){
		$.messageBox({level:'warn',message:"请选择一条数据再进行操作！"});
		return;
	}
	var selectedIssue = getSelectedData();
	if(selectedIssue == null || '办理中' != selectedIssue.dealState){
		$.messageBox({level:'warn',message:"该事件没有延期申请！"});
		return;
	}
	$("#issueDialog").createDialog({
		width: 820,
		height: 460,
		title: "延期申请情况列表",
		url: PATH+"/issue/issueManage/delayList.jsp?issueStepId="+selectedIssue.encryptIdByIssueStepId,
		buttons: {
	   		"关闭" : function(){
	        	$(this).dialog("close");
	   		}
		}
	});
}
$("#toChangeIntoThreeRecords").click(function (){
	if (hasRowSelected()){
		var selectedIssue = getSelectedData();
		if(selectedIssue.dealState!=null && '办理中' == selectedIssue.dealState){
			//确认取消前设置一个随机数已防出现重复提交的提示
			var tokenId = Math.round(Math.random()*10000000);
			$.confirm({
				title:"系统提示",
				message:"是否确定要转入三本台账!",
				width:400,
				okFunc:function(){
					changeIntoThreeRecords(selectedIssue.encryptIdByIssueStepId,selectedIssue.encryptIdByIssueId,dfop.token,tokenId);
				}
			});
		}else{
			$.messageBox({level:'warn',message:"该事件不可受理，请进行其它操作！"});
		}
	}else{
		$.messageBox({level:'warn',message:"没有可转入三本台帐的数据！"});
		return;
	}
});
function changeIntoThreeRecords(keyId,issueId,token,tokenId){
	if (!isNullObject(keyId)){
		$.ajax({
			url:'/issues/issueManage/toChangeIntoThreeRecords.action',
	        data:{
	            "keyId":keyId,
	            "operation.issue.id":issueId,
	            "struts.token":token,
	            "SUPERVISE_TOKEN_ID":tokenId
	        },
	        success:function(data){
	            if(data.issueStepId>0){
					$("#issueList").setRowData(keyId,data);
	                $.messageBox({message:"成功转入三本台帐!"});
	                setTimeout(reloadIssue,1000);
	            }else{
	                $.messageBox({message:data});
	            }
	        }
	    });
	}
}
}
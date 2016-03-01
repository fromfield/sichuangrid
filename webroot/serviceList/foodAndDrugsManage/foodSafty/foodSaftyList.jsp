
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="pop" uri="/PopGrid-taglib" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/includes/baseInclude.jsp"%>	
<div class="content">
	<div class="ui-corner-all contentNav" id="nav">
		<div class="btnbanner">
		 	<jsp:include page="/common/orgSelectedserviceListComponent.jsp"/>
		</div>
		<div class="btnbanner btnbannerData">
			<div class="ui-widget autosearch">
				<input class="basic-input" type="text" value="请输入地点" id="searchText"  name="searchText" maxlength="18" class="searchtxt" style="width:180px;" onblur="value=(this.value=='')?'请输入地点':this.value;" onfocus="value=(this.value=='请输入地点')?'':this.value;"/>
				<button id="refreshSearchKey" class="ui-icon ui-icon-refresh searchbtnico"></button>
			</div>
		</div>
		 <pop:JugePermissionTag ename="searchFoodSafty">
         	<a href="javascript:;" id="fastSearchButton" ><span>搜索</span></a>
         </pop:JugePermissionTag>
        <pop:JugePermissionTag ename="addFoodSafty">
        	<a id="add" href="javascript:void(0)"><span><strong class="ui-ico-xz"></strong>新增</span></a>
        </pop:JugePermissionTag>
        <pop:JugePermissionTag ename="updateFoodSafty">
        	<a id="update" href="javascript:void(0)"><span><strong class="ui-ico-xz"></strong>修改</span></a>
        </pop:JugePermissionTag>
        <pop:JugePermissionTag ename="deleteFoodSafty">
        	<a id="delete" href="javascript:void(0)"><span><strong class="ui-ico-sc"></strong>批量删除</span></a>
        </pop:JugePermissionTag>
        <pop:JugePermissionTag ename="importFoodSafty">
		<a href="javascript:;" class="nav-dropdownBtn"><span>导入|导出</span><b class="nav-dropdownBtn-arr"><b class="nav-ico-dArr"></b></b></a>
		</pop:JugePermissionTag> 
			<div class="nav-sub-buttons">
			 <pop:JugePermissionTag ename="importFoodSafty">
			 <div id="importBox">
				<a id="import" href="javascript:void(0)"><span><strong
					class="ui-ico-dr"></strong>Excel导入</span></a>
			</div>
			</pop:JugePermissionTag> 
<%-- 			<pop:JugePermissionTag ename="newDown${modul}"> --%>
<%-- 				<a id="export" href="javascript:void(0)"><span><strong --%>
<%-- 					class="ui-ico-dc"></strong>导出Excel</span></a> --%>
<%-- 			</pop:JugePermissionTag> --%>
			</div>
        
        <a id="reload" href="javascript:void(0)"><span><strong class="ui-ico-sc"></strong>刷新</span></a>
	</div>
	<div style="clear: both;"></div>
	<div style="width: 100%">
		<table id="foodSaftyList"></table>
		<div id="foodSaftyListPager"></div>
	</div>
	<div id="serviceListDialog"></div>
</div>

<script type="text/javascript" src="/serviceList/serviceListCommom/serviceListCommom.js"></script>

<script type="text/javascript">
	//窗口宽度大小常量
	var dialogWidth=700;
	var dialogHeight=550;
	
	function fastSearch(){
		var name = $('#searchText').val();
		if(name == '请输入地点'){
			return;
		}
		var initParam ={
			 'foodSafty.address':name,
			 "policyPropaganda.mode":"gridConfigService",
			 "foodSafty.organization.id":selectConfigTaskOrg()
		};
	    $('#foodSaftyList').setPostData(initParam);
		$('#foodSaftyList').trigger('reloadGrid');
	}
	function signStateFormatter(el, options, rowData){
		return rowData.isSign;
	}
	
	function signFormatter(el, options, rowData){
		if(rowData.isSign == 1){
			return "已签收";
		}
		var flag = "<pop:JugePermissionTag ename='healthCareSignFoodSafty'>true</pop:JugePermissionTag>";
		var flag1 = "<pop:JugePermissionTag ename='poisoningSignFoodSafty'>true</pop:JugePermissionTag>";
		if(flag && flag1){
			return "<a href='javascript:' onclick='updateOperator("+rowData.id+")'><span style='color:#ff0000;'>签收</span></a>";
		}
		result = categoryData[rowData.category.id];
		if(flag && result=="<s:property value='@com.tianque.domain.property.PropertyTypes@HEALTH_CARE_PRODUCTS'/>"){
			return "<a href='javascript:' onclick='updateOperator("+rowData.id+")'><span style='color:#ff0000;'>签收</span></a>";
		}else if(flag1 && (result=="<s:property value='@com.tianque.domain.property.PropertyTypes@FOOD_POISONING'/>" || result=="<s:property value='@com.tianque.domain.property.PropertyTypes@RURAL_FAMILY'/>")){
			return "<a href='javascript:' onclick='updateOperator("+rowData.id+")'><span style='color:#ff0000;'>签收</span></a>";
		}else{
			return "否";
		}
	}
	
	function declarationFormatter(el, options, rowData){
		if(rowData.declaration == null||rowData.declaration==undefined||rowData.declaration==0){
			return "否";
		}else {
			return "是";
		}
		return "否";
	}
	
	<pop:formatterProperty name="category" domainName="@com.tianque.domain.property.PropertyTypes@FOOD_SAFTY_CATEGORY" />
	//初始化表单
	$(document).ready(function(){
		var postData={
				"foodSafty.organization.id":selectConfigTaskOrg()
	        };
		if(isConfigTaskSelect()){
			$.extend(postData,{"foodSafty.mode":"gridConfigService","foodSafty.funOrgId": $("#funOrgId").val()})
		}
		
		//表格 jqGrid初始化
		$('#foodSaftyList').jqGridFunction({
			url:'${path}/serviceList/foodSaftyManage/getFoodSaftyList.action',
			datatype: "json",
			postData:postData,
		   	colModel:[
		   	       {name:'id',index:'id',sortable:false,hidden:true,hidedlg:true,key:true},
		   	       {name:'inputTime',label:"时间",width:130,align:'center',frozen:true,sortable:false,align:"center"},
			       {name:'address',label:"地点",index:'address',frozen:true,sortable:false,width:260,formatter:addressFormatter },
			       {name:'category.id',label:"类别",index:'category',sortable:false,width:90,formatter:categoryFormatter,align:"center"},
			       {name:'declaration',label:"5桌以上申报",index:'declaration',sortable:false,width:90,formatter:declarationFormatter,align:"center"},
			       {name:'personnel',label:"参与人员",index:'personnel',sortable:false,width:90,align:"center"},
			       {name:'details',label:"详细情况",index:'details',sortable:false,width:200},
			       {name:'remake',label:"备注",index:'remake',sortable:false,width:120},
			       {name:'signState',hidden:true,formatter:signStateFormatter,hidedlg:true},
			       {name:'isSign',label:"签收状态",index:'isSign',formatter:signFormatter,sortable:false,width:80,align:"center"},
			       {name:'signDate',label:"签收时间",index:'signDate',sortable:false,width:130,align:"center"},
// 			       {name:'supervise',label:"督办",index:'supervise',formatter:superviseFormatter,sortable:false,width:80},
			       {name:'doReply',label:"回复",formatter:doReplyFormatter,sortable:false,width:80,align:"center"}
		   	],
		   	multiselect:true,
	        altclass:true,
	        onSelectRow:selectRow,
	        onSelectAll:selectRow,
	        showColModelButton:true,
	        ondblClickRow:viewfoodSafty
		});
		
		//新增食品安全协管
		$('#add').click(function(){
			if(!isConfigTaskGrid()){
				$.messageBox({level:"warn",message:"请先选择网格级别组织机构进行新增！"});
			 return;
			}
			$('#serviceListDialog').createDialog({
				width:dialogWidth,
				height:dialogHeight,
				title:'新增食品安全协管',
				url:'${path}/serviceList/foodSaftyManage/dispatchOperate.action?mode=add&foodSafty.organization.id='+selectConfigTaskOrg(),
				buttons:{
					'确定':function(){
						$('#maintainForm').submit();
					},
					'关闭':function(){
						$(this).dialog('close');
					}
				}
			});
		});
		
		//修改任务
		$('#update').click(function(){
			 var id = $("#foodSaftyList").jqGrid("getGridParam", "selarrrow");
			 if(id==null || id.length==0){
				 $.messageBox({
						level:'warn',
						message:'请先选择一条数据'
				});
				 return;
			 }
			 if(id.length>1){
				 $.messageBox({level:'warn',message:'只能选择一条数据进行修改'});
				 return;
			 }
			 updateFoodSaftyById(id);
		});
		
		//批量删除任务
		$('#delete').click(function(){
			var ids = $('#foodSaftyList').getSelectedRowIds();
			if(ids.length <=0 ){
				 $.messageBox({
						level:'warn',
						message:'请先选择一个任务'
				});
				 return;
			}
			var idStr = 'ids='+ids.toString();
			$.confirm({
				title:'删除确认',
				message:'任务删除后不可恢复，请确认是否删除?',
				width: 400,
				okFunc: function(){
					$.ajax({
						url:'${path}/serviceList/foodSaftyManage/deleteFoodSafty.action?'+idStr,
						type:'get',
						dataType:'json',
						success : function(data){
							if(data){
								$.messageBox({
									message : '删除成功'
								});
								$('#foodSaftyList').trigger('reloadGrid');
							}else{
								$.messageBox({
									message : "删除失败，请联系管理员！",
									level : 'error'
								});
							}
						},
						error : function(){
							$.messageBox({
								message : '加载失败，请刷新页面！',
								level : 'error'
							});
						}
					});
				}
			});
		});
		
		$("#import").click(function(event){
			serviceListCommonImport("foodSafty","FOODSAFTY","foodSaftyList");
		});
		
		//搜索
		$('#fastSearchButton').click(fastSearch);
		$('#refreshSearchKey').click(function(){
			$("#searchText").val('请输入地点');
		});
		//刷新
		$('#reload').click(function(){
			$("#searchText").val('请输入地点');
			var postData={
					"foodSafty.organization.id":selectConfigTaskOrg()
			};
			if(isConfigTaskSelect()){
				$.extend(postData,{"foodSafty.mode":"gridConfigService","foodSafty.funOrgId": $("#funOrgId").val()})
			}
			$('#foodSaftyList').setPostData(postData);
			$('#foodSaftyList').trigger('reloadGrid');
		});
	});
	//根据id修改
	function updateFoodSaftyById(id){
// 		var id =  $('#foodSaftyList').getRowData(id);
		$('#serviceListDialog').createDialog({
			width:dialogWidth,
			height:dialogHeight,
			title:'修改食品安全协管',
			url:'${path}/serviceList/foodSaftyManage/dispatchOperate.action?mode=edit&foodSafty.id='+id,
			buttons:{
				'确定':function(){
					$("#maintainForm").attr("action","${path}/serviceList/foodSaftyManage/updateFoodSafty.action?");
					$('#maintainForm').submit();
				},
				'关闭':function(){
					$(this).dialog('close');
				}
			}
		});
	}
	
	function addressFormatter(el, options, rowData){
		return "<a href='javascript:' onclick='viewfoodSafty("+rowData.id+")'>"+rowData.address+"</a>"
	}
	
	//根据id查看
	function viewfoodSafty(id){
		$("#serviceListDialog").createDialog({
			width:dialogWidth,
			height:dialogHeight,
			title:"查看食品安全协管",
			url:"${path}/serviceList/foodSaftyManage/viewFoodSaftyDetail.action?foodSafty.id="+id,
			buttons:{
				"关闭":function(){
					$(this).dialog("close");
				}
			}
		});
	}

	function selectRow(){
	    var selectedIds = $("#foodSaftyList").jqGrid("getGridParam", "selarrrow");
	    if(selectedIds.length==0){
	        $("#delete,#update").addClass("disabled");
	        return ;
	    }else if(selectedIds.length==1){
	        $("#delete,#update").removeClass("disabled");
	        return ;
        }else if(selectedIds.length>1){
            $("#delete").removeClass("disabled");
            $("#update").addClass("disabled");
            return ;
        }
	}
	
	function updateOperator(id){
		if(id==null){
			return;
		}
		var builddata=$("#foodSaftyList").getRowData(id);
		if(builddata.signState!=0){
			$.messageBox({
				level:'warn',
				message:'请选择一条未签收数据进行签收'
			});
		}
		$("#serviceListDialog").createDialog({
			width: 600,
			height:470,
			title: '签收',
			url:'${path}/serviceList/foodSaftyManage/dispatchOperate.action?mode=sign&foodSafty.organization.id='+ selectConfigTaskOrg()+'&foodSafty.id='+id,
			buttons: {
				"签收" : function(){
					$("#maintainForm").submit();
				},
				"关闭" : function(){
					$(this).dialog("close");
				}
			}
		});
	}
	
	function doReplyFormatter(el, options, rowData){
		if(rowData.isSign==0){
			return "";
		}
		var flag = "<@pop.JugePermissionTag ename='signFoodSafty'>true</@pop.JugePermissionTag>";
		if(!flag){
			if(rowData.isReply==undefined || rowData.isReply==0){
				return "否";
			}else{
				return "已回复";
			}
		}else{
			if(rowData.isReply==undefined || rowData.isReply==0){
				return "<a href='javascript:' onclick='doReply("+rowData.id+")'>回复</a>";
			}else{
				return "<a href='javascript:' onclick='doReply("+rowData.id+")'>已回复</a>";
			}
		}
		return "";
	}
	
	function doReply(id){
		$("#serviceListDialog").createDialog({
			width: 600,
			height:470,
			title: '回复',
			url:'${path}/serviceList/foodSaftyManage/dispatchOperate.action?mode=reply&foodSafty.organization.id='+ selectConfigTaskOrg()+'&foodSafty.id='+id,
			buttons: {
				"回复" : function(){
					$("#maintainForm").submit();
				},
				"关闭" : function(){
					$(this).dialog("close");
				}
			}
		});
	}
	
	function refreshList(searchText){
		$("#foodSaftyList").setGridParam({
			url:'${path}/serviceList/foodSaftyManage/getFoodSaftyList.action',
			datatype: "json",
			page:1
		});
		var postData={
				"foodSafty.organization.id":selectConfigTaskOrg()
		};
		if(isConfigTaskSelect()){
			$.extend(postData,{"foodSafty.mode":"gridConfigService","foodSafty.funOrgId": $("#funOrgId").val()})
		}
		$("#foodSaftyList").setPostData(postData);
		$("#foodSaftyList").trigger("reloadGrid");
	}

	
</script>
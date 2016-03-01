
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
			    <input class="basic-input" type="text" value="请输入地点" name="searchText" id="searchText" maxlength="30" class="searchtxt" onblur="value=(this.value=='')?'请输入地点':this.value;" onfocus="value=(this.value=='请输入地点')?'':this.value;"/>
				<button id="refreshSearchKey" class="ui-icon ui-icon-refresh searchbtnico"></button>
			</div>
		</div>
		 <pop:JugePermissionTag ename="searchPolicyPropaganda">
         	<a href="javascript:void(0)" id="fastSearchButton" ><span>搜索 </span></a>
         </pop:JugePermissionTag>
        <pop:JugePermissionTag ename="addPolicyPropaganda">
        	<a id="add" href="javascript:void(0)"><span><strong class="ui-ico-xz"></strong>新增</span></a>
        </pop:JugePermissionTag>
        <pop:JugePermissionTag ename="updatePolicyPropaganda">
        	<a id="update" href="javascript:void(0)"><span><strong class="ui-ico-xz"></strong>修改</span></a>
        </pop:JugePermissionTag>
        <pop:JugePermissionTag ename="deletePolicyPropaganda">
        	<a id="delete" href="javascript:void(0)"><span><strong class="ui-ico-sc"></strong>批量删除</span></a>
        </pop:JugePermissionTag>
        <pop:JugePermissionTag ename="importPolicyPropaganda">
		<a href="javascript:;" class="nav-dropdownBtn"><span>导入|导出</span><b class="nav-dropdownBtn-arr"><b class="nav-ico-dArr"></b></b></a>
		</pop:JugePermissionTag> 
			<div class="nav-sub-buttons">
			 <pop:JugePermissionTag ename="importPolicyPropaganda">
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
		<table id="policyPropagandaList"></table>
		<div id="policyPropagandaListPager"></div>
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
			 'policyPropaganda.address':name,
			 "policyPropaganda.mode":"gridConfigService",
			 "policyPropaganda.organization.id":selectConfigTaskOrg()
		};
	    $('#policyPropagandaList').setPostData(initParam);
		$('#policyPropagandaList').trigger('reloadGrid');
	}
	function signStateFormatter(el, options, rowData){
		return rowData.isSign;
	}
	
	function signFormatter(el, options, rowData){
		var flag = "<@pop.JugePermissionTag ename='signPolicyPropaganda'>true</@pop.JugePermissionTag>";
		if(rowData.isSign == 0 && flag ){
			return "<a href='javascript:' onclick='updateOperator("+rowData.id+")'><span style='color:#ff0000;'>签收</span></a>";
		}else if(rowData.isSign == 0 && flag != 'true'){
			return "否";
		}
		if(rowData.isSign == 1){
			return "已签收";
		}
	}

	<pop:formatterProperty name="category" domainName="@com.tianque.domain.property.PropertyTypes@POLICY_PROPAGANDA_CATEGORY" />
	//初始化表单
	$(document).ready(function(){
		var postData={
				"policyPropaganda.organization.id":selectConfigTaskOrg()
	        };
		if(isConfigTaskSelect()){
			$.extend(postData,{"policyPropaganda.mode":"gridConfigService","policyPropaganda.funOrgId": $("#funOrgId").val()})
		}
		//表格 jqGrid初始化
		$('#policyPropagandaList').jqGridFunction({
			url:'${path}/serviceList/policyPropagandaManage/getPolicyPropagandaList.action',
			datatype: "json",
			postData:postData,
		   	colModel:[
		   	       {name:'id',index:'id',sortable:false,hidden:true,hidedlg:true,key:true},
		   	       {name:'inputTime',label:"时间",width:130,align:'center',frozen:true,sortable:false,align:"center"},
			       {name:'address',label:"地点",index:'address',frozen:true,sortable:false,width:250,formatter:addressFormatter },
			       {name:'category.id',label:"类别",index:'category',sortable:false,width:90,formatter:categoryFormatter,align:"center"},
			       {name:'details',label:"详细情况",index:'details',sortable:false,width:180},
			       {name:'remake',label:"备注",index:'remake',sortable:false,width:125},
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
	        ondblClickRow:viewpolicyPropaganda
		});
		
		//新增政策法规宣传
		$('#add').click(function(){
			if(!isConfigTaskGrid()){
				$.messageBox({level:"warn",message:"请先选择网格级别组织机构进行新增！"});
			 return;
			}
			$('#serviceListDialog').createDialog({
				width:dialogWidth,
				height:dialogHeight,
				title:'新增政策法规宣传',
				url:'${path}/serviceList/policyPropagandaManage/dispatchOperate.action?mode=add&policyPropaganda.organization.id='+selectConfigTaskOrg(),
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
			var id = $("#policyPropagandaList").jqGrid("getGridParam", "selarrrow");
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
			 updatePolicyPropagandaById(id);
		});
		
		//批量删除任务
		$('#delete').click(function(){
			var ids = $('#policyPropagandaList').getSelectedRowIds();
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
						url:'${path}/serviceList/policyPropagandaManage/deletePolicyPropaganda.action?'+idStr,
						type:'get',
						dataType:'json',
						success : function(data){
							if(data){
								$.messageBox({
									message : '删除成功'
								});
								$('#policyPropagandaList').trigger('reloadGrid');
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
			serviceListCommonImport("policyPropaganda","POLICYPROPAGANDA","policyPropagandaList");
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
					"policyPropaganda.organization.id":selectConfigTaskOrg()
			};
			if(isConfigTaskSelect()){
				$.extend(postData,{"policyPropaganda.mode":"gridConfigService","policyPropaganda.funOrgId": $("#funOrgId").val()})
			}
			$('#policyPropagandaList').setPostData(postData);
			$('#policyPropagandaList').trigger('reloadGrid');
		});
	});
	//根据id修改
	function updatePolicyPropagandaById(id){
// 		var id =  $('#policyPropagandaList').getRowData(id);
		$('#serviceListDialog').createDialog({
			width:dialogWidth,
			height:dialogHeight,
			title:'修改政策法规宣传',
			url:'${path}/serviceList/policyPropagandaManage/dispatchOperate.action?mode=edit&policyPropaganda.id='+id,
			buttons:{
				'确定':function(){
					$("#maintainForm").attr("action","${path}/serviceList/policyPropagandaManage/updatePolicyPropaganda.action?");
					$('#maintainForm').submit();
				},
				'关闭':function(){
					$(this).dialog('close');
				}
			}
		});
	}
	
	function addressFormatter(el, options, rowData){
		return "<a href='javascript:' onclick='viewpolicyPropaganda("+rowData.id+")'>"+rowData.address+"</a>"
	}
	
	//根据id查看
	function viewpolicyPropaganda(id){
		$("#serviceListDialog").createDialog({
			width:dialogWidth,
			height:dialogHeight,
			title:"查看政策法规宣传",
			url:"${path}/serviceList/policyPropagandaManage/viewPolicyPropagandaDetail.action?policyPropaganda.id="+id,
			buttons:{
				"关闭":function(){
					$(this).dialog("close");
				}
			}
		});
	}

	function selectRow(){
	    var selectedIds = $("#policyPropagandaList").jqGrid("getGridParam", "selarrrow");
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
		var builddata=$("#policyPropagandaList").getRowData(id);
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
			url:'${path}/serviceList/policyPropagandaManage/dispatchOperate.action?mode=sign&policyPropaganda.organization.id='+ selectConfigTaskOrg()+'&policyPropaganda.id='+id,
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
		var flag = "<@pop.JugePermissionTag ename='signPolicyPropaganda'>true</@pop.JugePermissionTag>";
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
			url:'${path}/serviceList/policyPropagandaManage/dispatchOperate.action?mode=reply&policyPropaganda.organization.id='+ selectConfigTaskOrg()+'&policyPropaganda.id='+id,
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
		$("#policyPropagandaList").setGridParam({
			url:'${path}/serviceList/policyPropagandaManage/getPolicyPropagandaList.action',
			datatype: "json",
			page:1
		});
		var postData={
				"policyPropaganda.organization.id":selectConfigTaskOrg()
		};
		if(isConfigTaskSelect()){
			$.extend(postData,{"policyPropaganda.mode":"gridConfigService","policyPropaganda.funOrgId": $("#funOrgId").val()})
		}
		$("#policyPropagandaList").setPostData(postData);
		$("#policyPropagandaList").trigger("reloadGrid");
	}

	
</script>
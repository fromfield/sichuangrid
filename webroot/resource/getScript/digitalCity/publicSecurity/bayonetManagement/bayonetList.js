TQ.bayonetList = function (dfop){

	function bayonetOperatorFormatter(el,options,rowData){
		return (dfop.hasUpdateBayonet == 'true' ? "<a href='javascript:bayonetUpdateOperator("+rowData.id+")'><span>修改</span></a> "+
				   "&nbsp;|&nbsp;" : '' )+
				   (dfop.hasDeleteBayonet == 'true' ? "<a href='javascript:bayonetDeleteOperator("+rowData.id+")'><span>删除</span></a>" : '');
	}
	$(document).ready(function(){
		loadList();
		if(dfop.useOrgDepartmentNo.indexOf("511622") == 0){
			gisType = "3D";
		}
		function loadList(){
			// 生成列表
			$("#bayonetList").jqGridFunction({
				mtype:'post',
				datatype: "local",
			   	colModel:[
					{name:"id",index:'id',hidden:true},
					{name:"encryptId",index:'id',frozen:true,hidden:true},
			    	{name:"operator", index:'id',label:'操作',formatter:bayonetOperatorFormatter,width:100,frozen:true,sortable:false,align:'center' },
			    	{name:'bayonetNo', index:'code',label:'编号', width:150, sortable:true, align:'center', hidden:false,formatter:bayonetNameFormatter}, 	
			    	{name:'organization.orgName',index:'orgId',label:'所属区域', width:360,hidden:false,sortable:true},
			    	{name:'address', index:'address',label:'地址', width:400, sortable:true, align:'center', hidden:false}, 	
			    	{name:'createUser', index:'createUser',label:'创建人', width:100, sortable:true, align:'center', hidden:true}, 	
			    	{name:'updateUser', index:'updateUser',label:'修改人', width:100, sortable:true, align:'center', hidden:true}, 	
			    	{name:'createDate', index:'createDate',label:'创建时间', width:100, sortable:true, align:'center', hidden:true}, 	
			    	{name:'updateDate', index:'updateDate',label:'修改时间', width:100, sortable:true, align:'center', hidden:true},
			    	{name:"isEmphasis",label:"是否关注",hidden:true,hidedlg:true,width:100},
			    	{name:'isBind',index:'isBind',label:'绑定地图',sortable:false,width:120,align:"center"},
					{name:'openLayersMapInfo.centerLon',sortable:false,index:'openLayersMapInfo.centerLon',label:'卡口中心坐标X',width:120,hidden:true},
					{name:'openLayersMapInfo.centerLat',sortable:false,index:'openLayersMapInfo.centerLat',label:'卡口中心坐标Y',width:120,hidden:true},
					{name:'openLayersMapInfo.centerLon2',sortable:false,index:'openLayersMapInfo.centerLon2',label:'卡口中心2D坐标X',width:120,hidden:true},
					{name:'openLayersMapInfo.centerLat2',sortable:false,index:'openLayersMapInfo.centerLat2',label:'卡口中心2D坐标Y',width:120,hidden:true}
			   	],
				gridComplete:function(){
			    	 var ids=jQuery("#bayonetList").jqGrid('getDataIDs');
			    	 for(var i=0; i<ids.length; i++){
			    		 var id=ids[i];
			    		 var isBind = $("#bayonetList").getCell(id,"isBind");
			    		 var lon=""
			    		 var lat="";
			    		 if(gisType=="2D"){
			    			 lon = $("#bayonetList").getCell(id,"openLayersMapInfo.centerLon2");
			    			 lat = $("#bayonetList").getCell(id,"openLayersMapInfo.centerLat2");
			    		 }else if(gisType=="3D"){
			    			 lon = $("#bayonetList").getCell(id,"openLayersMapInfo.centerLon");
			    			 lat = $("#bayonetList").getCell(id,"openLayersMapInfo.centerLat");
			    		 }
			    		 if(lon!="" && lon!=null && lat!="" && lat!=null){
			    			 modify = "<a href='javascript:viewBindMap("+lon+","+lat+")' style='color:#f60; text-decoration: underline;' >查看地图</a>";//查看
			    		}else{
			    			modify="未绑定";
			    		}
			    		 jQuery("#bayonetList").jqGrid('setRowData', ids[i], { isBind: modify});
			    	 }

			     },
			  	multiselect:true,
			  	onSelectAll:function(data){
			  		toggleButtonState(data);
			  	},
		    	loadComplete: function(data){
		    		afterLoad(data);
		    	},	
		    	ondblClickRow:function (rowid){
					if(dfop.hasViewBayonet=='true'){
						viewBayonet(rowid);
					}
				},
				onSelectRow: function(data){
					toggleButtonState(data);
				}
			});
			if(getCurrentOrgId()!="" && getCurrentOrgId()!=null){
				onOrgChanged(getCurrentOrgId(),isGrid());
			}
		}
		
		
		jQuery("#bayonetList").jqGrid('setFrozenColumns');
		
		$("#fastSearchButton").click(function(){
			search(getCurrentOrgId());
		});
		$("#searchText").focus(function(){
	        this.select();
		 });
		$("#refreshSearchKey").click(function(){
			$("#searchText").attr("value","请输入卡口编号");
		});
		$("#add").click(function(){
			if (!isGrid()){
				$.messageBox({level:'warn',message:"请先选择网格级别组织机构进行新增！"});
				return;
			}
			$("#bayonetDialog").createDialog({
				model :"add",
				title:"新增卡口信息",
				width: dialogWidth,
				height: dialogHeight,
				url:PATH+'/bayonetManage/dispatch.action?mode=add&organization.id='+getCurrentOrgId()+"&gisType="+gisType,
				buttons: {
					"保存" : function(){
						$("#maintainForm").submit();
					},
					"关闭" : function(){
						$(this).dialog("close");
					}
				}
				
			});
		});
		$("#update").click(function(){
			var selectedIds = $("#bayonetList").jqGrid("getGridParam", "selarrrow");
			if(selectedIds==null || selectedIds.length>1){return;}
			var selectedId = getSelectedIdLast();
			if(selectedId==null){
				 return;
			}
			bayonetUpdateOperator(selectedId);
		});
		$("#delete").click(function(){
			var allValue = getSelectedIds();
			if(allValue.length ==0){
				$.messageBox({level:'warn',message:"请选择一条或多条记录，再进行删除！"});
				 return;
			}
			bayonetDeleteOperator(allValue);
		});
		$("#view").click(function(){
			if($("#view").attr("disabled")){
				return ;
			}
			var selectedId = getSelectedIdLast();
			if(selectedId==null){
		 		return;
			}
			viewBayonet(selectedId);
		});
		$("#reload").click(function(){
			if(getCurrentOrgId()!="" && getCurrentOrgId()!=null){
				onOrgChanged(getCurrentOrgId(),isGrid());
			}
		});

		$("#search").click(function(event){
			$("#bayonetDialog").createDialog({
				width:650,
				height:320,
				title:'卡口查询-请输入查询条件',
	 	 		url:PATH+'/digitalCity/publicSecurity/bayonetManagement/searchBayonetDlg.jsp?orgId=' + getCurrentOrgId(),
				buttons: {
			   		"查询" : function(event){
						searchBayonet();
			        	$(this).dialog("close");
		   			},
			   		"关闭" : function(){
			        	$(this).dialog("close");
			   		}
				}
			});
		});
		
		
		$("#cancelEmphasise").click(function(event){
			if($(this).attr("disabled")=="disabled"){
				return;
			}
			var selectedId =getSelectedIds();
			var cancelEmphasise=new Array();
			var temp=new Array();
			if(selectedId == null || selectedId.length<=0){
				$.messageBox({level:'warn',message:"请选择一条或多条记录，再进行取消关注！"});
				return;
			}
			for(var i=0;i<selectedId.length;i++){
				var rowData = $("#bayonetList").getRowData(selectedId[i]);
				if(rowData.isEmphasis==false || rowData.isEmphasis=="false"){
					cancelEmphasise.push(selectedId[i]);
				}else{
					temp.push(selectedId[i]);
				}
			}
			selectedId=cancelEmphasise;
			if(selectedId==null||selectedId.length==0){
				$.messageBox({level:'warn',message:"没有可取消关注的数据！"});
				return;
			}
			var encryptIds=deleteOperatorByEncrypt("bayonet",selectedId,"encryptId");
			$("#bayonetDialog").createDialog({
				width:450,
				height:210,
				title:'取消关注提示',
				modal:true,
				url:PATH+'/digitalCity/publicSecurity/emphasiseConditionDlg.jsp?publicSecurityType='+dfop.publicSecurityType+'&locationIds='+encryptIds+'&isEmphasis=true&dailogName=bayonet&temp='+temp,
				buttons: {
				   "保存" : function(event){
					   $("#emphasisForm").submit();
				   },
				   "关闭" : function(){
				        $(this).dialog("close");
				   }
				}
			});
		});
		
		$("#reEmphasise").click(function(){
			if($(this).attr("disabled")=="disabled"){
				return;
			}
			var selectedId = getSelectedIds();
			var reEmphasise=new Array();
			var temp=new Array();
			if(selectedId == null || selectedId.length<=0){
				$.messageBox({level:'warn',message:"请选择一条或多条记录，再重新关注！"});
				return;
			}
			for(var i=0;i<selectedId.length;i++){
				var rowData = $("#bayonetList").getRowData(selectedId[i]);
				if(rowData.isEmphasis==true||rowData.isEmphasis=="true"){
					reEmphasise.push(selectedId[i]);
				}else{
					temp.push(selectedId[i]);
				}
			}
			selectedId=reEmphasise;
			if(selectedId==null||selectedId.length==0){
				$.messageBox({level:'warn',message:"没有可重新关注的数据！"});
				return;
			}
			var encryptIds=deleteOperatorByEncrypt("bayonet",selectedId,"encryptId");
			$.ajax({
				url:PATH+"/bayonetManage/updateEmphasiseByEncryptId.action",
				data:{
					"ids": encryptIds,
					"bayonet.isEmphasis":0
				},
				success:function(responseData){
					if(null==temp || temp.length==0){
						$.messageBox({message:" "+dfop.moduleCName+"重新关注成功 ！ "});
					}else{
						$.messageBox({level:'warn',message:"除选中的红色数据外,其余"+dfop.moduleCName+"重新关注成功 ！ "});
					}
					notExecute=temp;
					$("#bayonetList").trigger("reloadGrid");
				}
			});
		});
		
		
		$("#transfer").click(function(e){
			if(isTownOrganization()){
				$.messageBox({level:'warn',message:"请先选择乡镇（街道）级别组织机构进行转移！"});
				 return;
			}
			var allValue = $("#bayonetList").jqGrid("getGridParam", "selarrrow");
			if(allValue.length ==0){
				$.messageBox({level:'warn',message:"请选择一条或多条记录，再进行转移！"});
				 return;
			}
			for(var i=0;i<allValue.length;i++){
				var rowData=$("#bayonetList").getRowData(allValue[i]);
				if(rowData.isBind!="未绑定"){
					$.messageBox({level:'warn',message:"所选记录已绑定地图，无法转移！"});
					 return;
				}
				if(rowData.isEmphasis==true || rowData.isEmphasis=="true"){
					$.messageBox({level:'warn',message:"所选记录是已注销记录，无法转移！"});
					 return;
				}
			}
			var orgid=	getCurrentOrgId();
			if(orgid==""||orgid==null){
				$.messageBox({level:'warn',message:"没有获取到当前的组织机构id"});
				 return;
			}
			$.confirm({
				title:"转移卡口",
				message:"转移卡口时,若目标网格存在相同数据,该数据不进行转移。",
				okFunc: function() {
					moveOperator(e,allValue,orgid);
				}
			});
		});

		function moveOperator(event,allValue,orgid){
			var encryptIds=deleteOperatorByEncrypt("bayonet",allValue,"encryptId");
			$("#moveDataDialog").createDialog({
				width: 400,
				height: 230,
				title:"数据转移",
				url:PATH+"/publicSecurity/transferManage/transferDispatchByEncrypt.action?orgId="+orgid+"&ids="+encryptIds+"&type=bayonet",
				buttons: {
					"保存" : function(event){
						$("#maintainShiftForm").submit();
					},
					"关闭" : function(){
						$(this).dialog("close");
					}
				}
			});
			var evt = event || window.event;
			if (window.event) { 
			evt.cancelBubble=true; 
			} else { 
			evt.stopPropagation(); 
			} 
		}

		
		function parseObj(strData) {
			return (new Function("return " + strData))();
		}
		function searchBayonet(){
			var formdata = $("#searchBayonetForm").serialize();
			if (formdata != '') {
				formdata = formdata.replace(/\+/g," "); 
				formdata = formdata.replace(/=/g, '":"');
				formdata = formdata.replace(/&/g, '","');
				formdata += '"';
			}
			formdata = decodeURIComponent('{"' + formdata + '}');
			$("#bayonetList").setGridParam({
				url:PATH+'/bayonetManage/findBayonetPagerBySearchVo.action',
				datatype: "json",
				page:1,
				mtype:"post"
			});
			$("#bayonetList").setPostData(parseObj(formdata));
			$("#bayonetList").trigger("reloadGrid");
		}
		function search(orgId){
			var fastSearchVal = $("#searchText").val();
			if(fastSearchVal == '请输入卡口编号' || fastSearchVal==''){
				onOrgChanged(getCurrentOrgId(),isGrid());
				return;
			}
			var	postData = {
				 "organization.id":orgId,
				 "searchBayonetVo.bayonetNo":fastSearchVal
			}
			$("#bayonetList").setGridParam({
		 		url:PATH+'/bayonetManage/findBayonetPagerBySearchVo.action',
				datatype: "json",
				page:1
			});
			$("#bayonetList").setPostData(postData);
			$("#bayonetList").trigger("reloadGrid");
		}
		function getSelectedIdLast(){
			var selectedId;
			var selectedIds = $("#bayonetList").jqGrid("getGridParam", "selarrrow");
			for(var i=0;i<selectedIds.length;i++){
				selectedId = selectedIds[i];
			}
			return selectedId;
		}
		function getSelectedIds(){
			var selectedIds = $("#bayonetList").jqGrid("getGridParam", "selarrrow");
			return selectedIds;
		}
		function isTownOrganization(){
			return $("#currentOrgId").attr("orgLevelInternalId") > dfop.townOrganization;
		}
	});

}

function bayonetUpdateOperator(selectedId){
	var ent =  $("#bayonetList").getRowData(selectedId);
	if(ent.isEmphasis==true || ent.isEmphasis=="true"){
		 $.messageBox({level : 'warn',message:"该卡口信息已经注销，不能修改!"});
		 return;
	}
	var encryptId=ent.encryptId;
	$("#bayonetDialog").createDialog({
		model :"edit",
		title:"修改卡口信息",
		width: dialogWidth,
		height: dialogHeight,
		url:PATH+'/bayonetManage/dispatchByEncrypt.action?mode=edit&bayonet.id='+encryptId+"&gisType="+gisType,
		buttons: {
			"保存" : function(){
				$("#maintainForm").submit();
			},
			"关闭" : function(){
				$(this).dialog("close");
			}
		}		
	});
}
function bayonetDeleteOperator(allValue){
	var id=deleteOperatorByEncrypt("bayonet",allValue,"encryptId");
	$.confirm({
		title:"确认删除",
		message:"确定要删除吗?一经删除将无法恢复",
		okFunc: function() {
			$.ajax({
 				url:PATH+'/bayonetManage/deleteBayonetByIds.action',
 				type:"post",
 				data:{
 					"ids":id
 				},
				success:function(data){
				    $.messageBox({message:"已经成功删除该卡口信息!"});
					$("#bayonetList").trigger("reloadGrid");
				}
			});
		}
	});
}
function toggleButtonState(){
  	var selectedIds=$("#bayonetList").jqGrid("getGridParam", "selarrrow");
  	var selectedRowCount=selectedIds.length;
}
function afterLoad(){

}

function viewBindMap(lon,lat){
	$("#gisbayonetDialog").createDialog({
		zIndex:1020,
        width: 800,
        height: 600,
        title:'查看建筑物',
        url:PATH+"/openLayersMap/product_3.0/gisPublicSecurity.jsp?flag=3&dailogName=bayonet&organizationId="+getCurrentOrgId()+"&viewLon="+lon+"&viewLat="+lat+"&gisType="+gisType,
        buttons: {
            "关闭" : function(){
          	  $("#bayonetList").trigger("reloadGrid");
               $(this).dialog("close");
            }
        },
        shouldEmptyHtml:false
	});
}


function bayonetNameFormatter(el,options,rowData){
	if(null == rowData.bayonetNo) {
		return "&nbsp;&nbsp;"
	}else if(rowData.isEmphasis==1){
		return "<a href='javascript:viewBayonet("+rowData.id+")'><font color='#778899'>"+rowData.bayonetNo+"</font></a>";
	}
	return "<a href='javascript:viewBayonet("+rowData.id+")'><font color='#6633FF'>"+rowData.bayonetNo+"</font></a>";
}
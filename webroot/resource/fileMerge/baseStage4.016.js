function proccessResourcePoolPremissionTreeOption(o,self){
	var defaultOption={
		shouldJugeMultizones:false, //是否把责任区作为根节点
		rootId:false,	//树的根节点ID
		allOrg:false,	//是否不通过判断orgId
		excludeRoot:false,	//树中是否包含根节点
		orgType:false,  //树中包含的org类型
		url:'/interation/resourcePool/firstLoadExtTreeData.action',
		isLocalData:false,
		isRootSelected:true, //是否选中根节点
		loadCom:function(){}
	};
	$.extend(defaultOption,o);
	
	var url=PATH+defaultOption.url;
	if(defaultOption.orgType){
		if(url.indexOf("?")==-1){
			url=url+'?orgType='+defaultOption.orgType;
		}else{
			url=url+'&orgType='+defaultOption.orgType;
		}
	}
	if(defaultOption.rootId!=false){
		if(url.indexOf("?")==-1){
			url=url+'?rootId='+defaultOption.rootId;
		}else{
			url=url+'&rootId='+defaultOption.rootId;
		}
	}
	if(defaultOption.excludeRoot){
		if(url.indexOf("?")==-1){
			url=url+'?excludeRoot='+defaultOption.excludeRoot;
		}else{
			url=url+'&excludeRoot='+defaultOption.excludeRoot;
		}
	}
	if(defaultOption.allOrg){
		if(url.indexOf("?")==-1){
			url=url+'?allOrg='+defaultOption.allOrg;
		}else{
			url=url+'&allOrg='+defaultOption.allOrg;
		}
	}
	if(defaultOption.shouldJugeMultizones){
		if(url.indexOf("?")==-1){
			url=url+'?shouldJugeMultizones=true';
		}else{
			url=url+'&shouldJugeMultizones=true';
		}
	}
	var viewObjtypeId = defaultOption.viewObjtypeId;
	if(viewObjtypeId!=null && typeof(viewObjtypeId)!="undefined"){
		if(url.indexOf("?")==-1){
			url=url+'?viewObjtypeId='+viewObjtypeId;
		}else{
			url=url+'&viewObjtypeId='+viewObjtypeId;
		}
	}
	var resourcePoolId = defaultOption.resourcePoolId;
	if(resourcePoolId!=null && typeof(resourcePoolId)!="undefined"){
		if(url.indexOf("?")==-1){
			url=url+'?resourcePoolId='+resourcePoolId;
		}else{
			url=url+'&resourcePoolId='+resourcePoolId;
		}
	}
	var treePanelId=self.attr("id");
	var Tree=Ext.tree;
	
	var treePanelOption={
        animate:false, 
        enableDD:false,
        containerScroll: true,
        dropConfig: {appendOnly:true},
        rootVisible : false
    };
	if(!defaultOption.isLocalData){
		treePanelOption.loader = new Tree.TreeLoader({dataUrl:url});
	}
	var treePanel = new Tree.TreePanel(treePanelId, treePanelOption);
	
	treePanel.on('beforeload',function(node){ 
    	if(node.id!=(treePanelId+"-root")){
    		var param = '?parentId='+node.id;
    		if(defaultOption.orgType){
    			param = param + '&orgType=' + defaultOption.orgType;
    		}
    		if(resourcePoolId!=null && typeof(resourcePoolId)!="undefined"){
    			param = param + '&resourcePoolId=' + resourcePoolId;
    		}
    		treePanel.loader.dataUrl = PATH+'/interation/resourcePool/ajaxOrgsForExtTree.action'+param;
    	}
    	node.attributes.isLoaded = true;
    });
	
	//treePanel.on('checkchange', function(node, checked) {
	//	if(node.attributes.isLoaded){
	//		node.expand();  
	//	}
	//	node.attributes.checked = checked; 
	//	node.eachChild(function(child) { 
	//		child.ui.toggleCheck(checked);  
	//		child.attributes.checked = checked;  
	//		child.fireEvent('checkchange', child, checked);  
	//	});  
	//});
    var root = new Tree.AsyncTreeNode({
    	text : 'orgManage',
        draggable : false,
        id : (treePanelId+"-root")
    });
    treePanel.setRootNode(root);
    treePanel.render();
    if(!defaultOption.isLocalData){
		root.expand(false,false,function(n){
			if(null!=root.childNodes&&undefined!=root.childNodes){
				for(var i = 0; i < root.childNodes.length; i++){
					root.childNodes[i].expand();
				}
			}
		});
    }
    root.expand(false,false,function(){
    	treePanel.exFunc();
    	defaultOption.loadCom();
    });
    treePanel.exFunc = function(){}
	return treePanel;
}
jQuery.fn.extend({
	initResourcePoolPremissionTree  : function(o){
	    //取消双击事件
		Ext.override(Ext.tree.TreeNodeUI, { 
		    onDblClick : function(e) { 
				e.preventDefault(); 
				if (this.node.disabled) {
					return; 
				} 
				if (this.checkbox && !this.node.hasChildNodes()) { 
				     return;
				} 
				if (!this.animating && this.node.hasChildNodes()) { 
				     var isExpand = this.node.ownerTree.doubleClickExpand; 
				    if (isExpand) { 
				    	return;
				    }else{
				    	 this.node.toggle(); 
				    }	 
				} 
		        this.fireEvent("dblclick", this.node, e); 
			} 
		});

	
		return proccessResourcePoolPremissionTreeOption(o,$(this));
	},
	disableNode : function(tree,nodeId){
		tree.getNodeById(nodeId).disable();
	}
});

function processResourcePoolTreeOption(o,self){
	
	var defaultOption={
		shouldJugeMultizones:false, //是否把责任区作为根节点
		rootId:false,	//树的根节点ID
		allOrg:false,	//是否不通过判断orgId
		excludeRoot:false,	//树中是否包含根节点
		url:'/interation/resourcePool/firstLoadDailydirectory.action',
		isLocalData:false,
		isRootSelected:true, //是否选中根节点
		isLoadDailyLogs:false,
		afterNodeExpanded:false
	};
	$.extend(defaultOption,o);
	var url=PATH+defaultOption.url;

	if(defaultOption.rootId!=false){
		if(url.indexOf("?")==-1){
			url=url+'?rootId='+defaultOption.rootId;
		}else{
			url=url+'&rootId='+defaultOption.rootId;
		}
	}
	if(defaultOption.excludeRoot){
		if(url.indexOf("?")==-1){
			url=url+'?excludeRoot='+defaultOption.excludeRoot;
		}else{
			url=url+'&excludeRoot='+defaultOption.excludeRoot;
		}
	}
	if(defaultOption.allOrg){
		if(url.indexOf("?")==-1){
			url=url+'?allOrg='+defaultOption.allOrg;
		}else{
			url=url+'&allOrg='+defaultOption.allOrg;
		}
	}
	if(defaultOption.shouldJugeMultizones){
		if(url.indexOf("?")==-1){
			url=url+'?shouldJugeMultizones=true';
		}else{
			url=url+'&shouldJugeMultizones=true';
		}
	}
	var treePanelId=self.attr("id");
	var Tree=Ext.tree;
	
	var treePanelOption={
        animate:true, 
        enableDD:false,
        containerScroll: true,
        dropConfig: {appendOnly:true},
        rootVisible : false
    };
	if(!defaultOption.isLocalData){
		treePanelOption.loader = new Tree.TreeLoader({dataUrl:url});
	}
	var treePanel = new Tree.TreePanel(treePanelId, treePanelOption);
	treePanel.on('beforeload',function(node){
    	if(node.id!=(treePanelId+"-root")){

    	}
    });  
	if(defaultOption.afterNodeExpanded){
		treePanel.on("load",defaultOption.afterNodeExpanded);
	}
	var customRoot=new Tree.TreeNode({
		text : 'orgManage',
        draggable : false,
        id : (treePanelId+"resourcePoolDirectory-root")
    });
    var root = new Tree.AsyncTreeNode({
    	text : '资料库目录树',
        draggable : false,
        id : (treePanelId+"-root"),
        leaf:false
    });

    customRoot.appendChild(root)

    treePanel.setRootNode(customRoot);

    treePanel.render();
    
    if(!defaultOption.isLocalData){
    	root.expand(false,false,function(n){
    		treePanel.getSelectionModel().select(root);treePanel.fireEvent("click",root);
		});
    }
	return treePanel;
}

jQuery.fn.extend({
	initResourcedirectoryTree : function(p){
		return processResourcePoolTreeOption(p,$(this));
	}
});
function processPermissionTreeOption(o,self){
	var defaultOption={
		shouldJugeMultizones:false, //是否把责任区作为根节点
		rootId:false,	//树的根节点ID
		allOrg:false,	//是否不通过判断orgId
		excludeRoot:false,	//树中是否包含根节点
		orgType:false,  //树中包含的org类型
		url:'/sysadmin/permissionManage/firstLoadPermission.action',
		isLocalData:false,
		isRootSelected:true //是否选中根节点
	};
	$.extend(defaultOption,o);
	
	var url=PATH+defaultOption.url;
	if(defaultOption.orgType){
		if(url.indexOf("?")==-1){
			url=url+'?orgType='+defaultOption.orgType;
		}else{
			url=url+'&orgType='+defaultOption.orgType;
		}
	}
	if(defaultOption.rootId!=false){
		if(url.indexOf("?")==-1){
			url=url+'?rootId='+defaultOption.rootId;
		}else{
			url=url+'&rootId='+defaultOption.rootId;
		}
	}
	if(defaultOption.excludeRoot){
		if(url.indexOf("?")==-1){
			url=url+'?excludeRoot='+defaultOption.excludeRoot;
		}else{
			url=url+'&excludeRoot='+defaultOption.excludeRoot;
		}
	}
	if(defaultOption.allOrg){
		if(url.indexOf("?")==-1){
			url=url+'?allOrg='+defaultOption.allOrg;
		}else{
			url=url+'&allOrg='+defaultOption.allOrg;
		}
	}
	if(defaultOption.shouldJugeMultizones){
		if(url.indexOf("?")==-1){
			url=url+'?shouldJugeMultizones=true';
		}else{
			url=url+'&shouldJugeMultizones=true';
		}
	}
	var treePanelId=self.attr("id");
	var Tree=Ext.tree;
	
	var treePanelOption={
        animate:true, 
        enableDD:false,
        containerScroll: true,
        dropConfig: {appendOnly:true},
        rootVisible : false
    };
	if(!defaultOption.isLocalData){
		treePanelOption.loader = new Tree.TreeLoader({dataUrl:url});
	}
	var treePanel = new Tree.TreePanel(treePanelId, treePanelOption);
	
	treePanel.on('beforeload',function(node){ 
    	if(node.id!=(treePanelId+"-root")){
    		var param = '?parentId='+node.id;
    		if(defaultOption.orgType){
    			param = param + '&orgType=' + defaultOption.orgType;
    		}
    		treePanel.loader.dataUrl = PATH+'/sysadmin/permissionManage/firstLoadPermission.action'+param;
    	}
    });  
	var customRoot=new Tree.TreeNode({
		text : 'orgManage',
        draggable : false,
        id : (treePanelId+"-root")
    });
    var root = new Tree.AsyncTreeNode({
    	text : '权限树',
        draggable : false,
        id : (treePanelId+"-root")
    });
    customRoot.appendChild(root)
    treePanel.setRootNode(customRoot);
    treePanel.render();
    
    if(!defaultOption.isLocalData){
    	root.expand(false,false,function(n){root.firstChild.expand(false,false,function(){if(defaultOption.isRootSelected){treePanel.getSelectionModel().select(root.firstChild);treePanel.fireEvent("click",root.firstChild);}})});
    }
	return treePanel;
}
jQuery.fn.extend({
	initPermissionTree : function(p){
		return processPermissionTreeOption(p,$(this));
	}
});
function processDailydirectoryTreeOption(o,self){
	
	
	var defaultOption={
		shouldJugeMultizones:false, //是否把责任区作为根节点
		rootId:false,	//树的根节点ID
		allOrg:false,	//是否不通过判断orgId
		excludeRoot:false,	//树中是否包含根节点
		url:'/daily/dailyDirectoryManage/firstLoadDailydirectory.action',
		isLocalData:false,
		isRootSelected:true, //是否选中根节点
		isLoadDailyLogs:false,
		afterNodeExpanded:false
	};
	$.extend(defaultOption,o);
	
	var url=PATH+defaultOption.url;
	if(defaultOption.rootId!=false){
		if(url.indexOf("?")==-1){
			url=url+'?rootId='+defaultOption.rootId;
		}else{
			url=url+'&rootId='+defaultOption.rootId;
		}
	}
	if(defaultOption.excludeRoot){
		if(url.indexOf("?")==-1){
			url=url+'?excludeRoot='+defaultOption.excludeRoot;
		}else{
			url=url+'&excludeRoot='+defaultOption.excludeRoot;
		}
	}
	if(defaultOption.allOrg){
		if(url.indexOf("?")==-1){
			url=url+'?allOrg='+defaultOption.allOrg;
		}else{
			url=url+'&allOrg='+defaultOption.allOrg;
		}
	}
	if(defaultOption.shouldJugeMultizones){
		if(url.indexOf("?")==-1){
			url=url+'?shouldJugeMultizones=true';
		}else{
			url=url+'&shouldJugeMultizones=true';
		}
	}
	var treePanelId=self.attr("id");
	var Tree=Ext.tree;
	
	var treePanelOption={
        animate:true, 
        enableDD:false,
        containerScroll: true,
        dropConfig: {appendOnly:true},
        rootVisible : false
    };
	if(!defaultOption.isLocalData){
		treePanelOption.loader = new Tree.TreeLoader({dataUrl:url+'?dailyYearId='+o.dailyYearId+'&initTree='+self.attr("id")});
	}
	var treePanel = new Tree.TreePanel(treePanelId, treePanelOption);
	treePanel.on('beforeload',function(node){ 
    	if(node.id!=(treePanelId+"-root")){
    		var param = '?dailyYearId='+o.dailyYearId + '&parentId='+node.id;
    		if(defaultOption.isLoadDailyLogs && node.attributes.leaf==2){
    			treePanel.loader.dataUrl = PATH+'/workingRecord/workingRecordManage/findExtTreeDataByDirectoryId.action'+param+'&initTree='+self.attr("id");
    		}else{
    			treePanel.loader.dataUrl = PATH+defaultOption.url+param+'&initTree='+self.attr("id");
    		}
    	}
    });  
	if(defaultOption.afterNodeExpanded){
		treePanel.on("load",defaultOption.afterNodeExpanded);
	}
	var customRoot=new Tree.TreeNode({
		text : 'orgManage',
        draggable : false,
        id : (treePanelId+"dailyDirectory-root"),
        dailyYearId : o.dailyYearId
    });
    var root = new Tree.AsyncTreeNode({
    	text : '台账目录树',
        draggable : false,
        id : (treePanelId+"-root"),
        leaf:false,
        dailyYearId : o.dailyYearId
    });
    customRoot.appendChild(root);
    treePanel.setRootNode(customRoot);
    treePanel.render();
    
    function expandNode(node){
    	node.expand(false,false,function(){
    		if(!node.firstChild.leaf){
    			expandNode(node.firstChild);
    			/*
    			node.firstChild.expand(false,false,function(){
    				if(defaultOption.isRootSelected){
    					treePanel.getSelectionModel().select(node.firstChild);
    					treePanel.fireEvent("click",node.firstChild);
    				}
    			})
    			*/
    		}else{
    			if(defaultOption.isRootSelected){
					treePanel.fireEvent("click",node);
				}
    		}
    	});
    }
    
    if(!defaultOption.isLocalData){
    	expandNode(root);
    	/*
    	root.expand(false,false,function(){
    		if(root.firstChild){
    			root.firstChild.expand(false,false,function(){
    				if(defaultOption.isRootSelected){
    					treePanel.getSelectionModel().select(root.firstChild);
    					treePanel.fireEvent("click",root.firstChild);
    				}
    			})
    		}
		});
		*/
    }
	return treePanel;
}

jQuery.fn.extend({
	initDailydirectoryTree : function(p){
		return processDailydirectoryTreeOption(p,$(this));
	}
});

$.fn.extend({
	treeSelect:function(options){
		var self=$(this);
		var selfId=self.attr("id");
		var defaultOption={
			store:new Ext.data.SimpleStore({fields:[],data:[[]]}), 
		    editable:false, //禁止手写及联想功能
		    showClearButton:false,
		    mode: 'local', 
		    triggerAction:'all',
		    name:'org',
		    fieldLabel : '组织机构',
		    maxHeight: 300, 
		    maxWidth:250,
		    listWidth:250,
		    tpl: "<div id='"+selfId+"-div'><div id='"+selfId+"-tree' style='overflow:auto'></div></div>", //html代码
		    selectedClass:'', 
		    onSelect:Ext.emptyFn,
		    emptyText:'请选择...',
		    inputName:"",
		    allOrg:false,
		    url:false,
		    nodeUrl:false,
		    rootId:false,
		    inputCodeName:"",
		    isRootSelected:true,
		    isFuncDep:false,
		    directlySupervisor:false,
		    changeFun:function(node,e){
				
			}
		};
		
		function style(){
			$("#"+selfId+"-div").parent().parent().remove();
			self.width(self.width()-25);
			$("#"+selfId+"-div").bgiframe();
		};
		$.extend(defaultOption, options);
		style();
		var comboWithTooltip = new Ext.form.ComboBox(defaultOption);
		comboWithTooltip.applyTo(selfId);
		var url;
		if(defaultOption.url){
			url = defaultOption.url;
		}else{
			url = "/sysadmin/orgManage/firstLoadExtTreeData.action";
		}
		var nodeUrl;
		if(defaultOption.nodeUrl){
			nodeUrl = defaultOption.nodeUrl;
		}else{
			nodeUrl = "/sysadmin/orgManage/ajaxOrgsForExtTree.action";
		}
		var tree = null;
		if(defaultOption.treeFunc === 'initTree'){
			tree = $("#"+selfId+"-tree").initTree({
				shouldJugeMultizones:true,
				allOrg:defaultOption.allOrg,url:url,nodeUrl:nodeUrl,
				directlySupervisor:defaultOption.directlySupervisor,
				rootId:defaultOption.rootId,
				loadCom:defaultOption.loadCom,
				isFuncDep:defaultOption.isFuncDep,
				isRootSelected:defaultOption.isRootSelected
			});
		}else{
			tree = $("#"+selfId+"-tree").initAdministrativeTree({
				shouldJugeMultizones:true,
				allOrg:defaultOption.allOrg,url:url,nodeUrl:nodeUrl,
				directlySupervisor:defaultOption.directlySupervisor,
				rootId:defaultOption.rootId,
				loadCom:defaultOption.loadCom,
				isFuncDep:defaultOption.isFuncDep,
				isRootSelected:defaultOption.isRootSelected
			});
		}
		$("#"+selfId+"-div").height(defaultOption.maxHeight).width(defaultOption.listWidth);
		
		
		var construct=function(){
			var inputId = "org_autocomplete"+selfId;
			if(defaultOption.showClearButton)
				$("#"+selfId+"-div").parent().parent().prepend("<div class='ui-widget currentOrgTxt' style='width:100%;background:#fff;'><input id="+inputId+" type='text' value='请输入层级' style='height:24px;line-height:24px;border:1px solid #ccc;padding-left:5px;margin:5px 10px;width:160px;' /><a href='javascript:clearTreeSelected_org_autocomplete(\""+selfId+"\")'>清空</a></div>");
			else
				$("#"+selfId+"-div").parent().parent().prepend("<div class='ui-widget currentOrgTxt' style='width:100%;background:#fff;'><input id="+inputId+" type='text' value='请输入层级' style='height:24px;line-height:24px;border:1px solid #ccc;padding-left:5px;margin:5px 10px;width:160px;' /></div>");
		}()
		$("#org_autocomplete"+selfId).autocomplete({
			source: function(request, response) {
				$.ajax({
					url: PATH+"/sysadmin/orgManage/ajaxFindOrganizationsByOrgName.action",
					data:{"organization.orgName":request.term},
					success: function(data) {
						response($.map(data, function(item) {
							return {
								label: item.orgName+","+stringFormatter(item.contactWay),
								value: item.orgName,
								id: item.id
							}
						}))
					},
					error : function(){
						$.messageBox({
							message:"搜索失败，请重新登入！",
							level:"error"
						});
					}
				})
			},
			select: function(event, ui) {
				var url = "/sysadmin/orgManage/ajaxSearchParentNodeIds.action?organization.id="+ui.item.id;
				if(options.rootId != undefined ){
					url = url +"&rootId="+options.rootId;
				}
				$("#user_autocomplete").removeAttr("userId");
				$("#user_autocomplete").val("");
				$.ajax({
					url:PATH+url,
					success:function(data){
						$.searchChild(tree,data);
					}
				});
			}
		});
		
		$("#org_autocomplete"+selfId).bind('focusin',function(){
            if( this.value === this.defaultValue ){
                this.value = '';
            }
		}).bind("focusout",function(){
            if( this.value === '' ){
                this.value = this.defaultValue
            }
		})

		function stringFormatter(str){
			if(str==undefined){
				return "";
			}
			return str;
		}
		
		tree.on("click",function(node,e) {
			if(node != null){
				comboWithTooltip.setRawValue(node.text);
		        comboWithTooltip.collapse();
		        if ($("input[name='"+defaultOption.inputName+"']").val()!=node.id){
			        $("input[name='"+defaultOption.inputName+"']").val(node.id);
		        }
		        if ($("input[name='"+defaultOption.inputCodeName+"']").val()!=node.attributes.orgInternalCode){
			        $("input[name='"+defaultOption.inputCodeName+"']").val(node.attributes.orgInternalCode);
		        }
			}
			defaultOption.changeFun(node,e);
		})
		$("#"+selfId+"-tree").height( defaultOption.maxHeight - 20 );
		return tree;
	}
});

function clearTreeSelected_org_autocomplete(selfId){
	$('#'+selfId).val('');
	$('#org_autocomplete'+selfId).val('');
}
function rendSupervise(el, options, rowData){
	if(1==rowData.supervisionState || 1==el){
		return "<img src='/resource/system/images/normalcard.gif'>";
	}else if(100==rowData.supervisionState){
		return "<img src='/resource/system/images/yellowcard.gif'>";
	}else if(200==rowData.supervisionState){
		return "<img src='/resource/system/images/redcard.gif'>";
	}else{
		return "";
	}
	
}
function rendUrgent(el, options, rowData){
	if(1==rowData.urgent || el==true){
		return "<img src='/resource/system/images/immediate.gif'>";
	}else{
		return "";
	}
}

function updateIssue(){
	var selectedId = $("#issueList").getGridParam("selrow");
	if(selectedId == null){
 		return;
	}
	var rowData = $("#issueList").getRowData(selectedId);
	$("#issueDialog").createDialog({
		width:840,
		height:570,
		title: '修改事件处理信息',
		url:'/issue/issueManage/dispatch.action?issueMode=edit&issueNew.id='+rowData.issueId+'&issueLogId='+rowData.issueLogId+'&organization.id='+$("#currentOrgId").val(),
		buttons: {
	   		"保存" : function(event){
   				$("#issueMaintainForm").submit();
   			},
	   		"关闭" : function(){
	        	$(this).dialog("close");
	   		}
		}
	});
}

function editIssue(keyId){
	$("#issueDialog").createDialog({
		width:840,
		height:570,
		title: '修改事件处理信息',
		url:'/issues/issueManage/dispatch.action?mode=editIssueForTab&keyId='+keyId,
		buttons: {
	   		"保存" : function(event){
				$("#issueMaintainForm").submit();
   			},
	   		"关闭" : function(){
	        	$(this).dialog("close");
	   		}
		}
	});
}


function deleteIssue(){
	var	selectedId = $("#issueList").getGridParam("selrow");
	var rowData = $("#issueList").getRowData(selectedId);
	if(null == selectedId){
		return;
	}
	$.ajax({
		url:"/issue/issueManage/deleteIssueById.action",
		data:{
			"issueNew.id":rowData.issueId
		},
		success:function(responseData){
			if (responseData>0){
			    $.messageBox({message:"已经成功删除该事件处理信息!"});
			    getMessageByUser();
			}else{
				$.messageBox({level:'error',message:"找不到要删除的事件处理信息，不能删除!"});
			}
		}
	});
}

function removeIssue(keyId){
	$.ajax({
		url:"/issues/issueManage/deleteIssue.action",
		data:{
			"keyId":keyId,
			"viewType":$("#jurisdictionsViewType").val()
		},
		success:function(responseData){
			if (responseData==true){
				$.messageBox({message:"已经成功删除该事件处理信息!"});
				setTimeout(reloadIssue,1000);
				getMessageByUser();
			}else{
				$.messageBox({level:'error',message:"删除事件失败!"});
			}
		}
	});
}

function removeIssueByIssueId(issueId){
	$.ajax({
		url:"/issues/issueManage/deleteIssue.action",
		data:{
			"keyId":issueId
		},
		success:function(responseData){
			if (responseData==true){
			    $.messageBox({message:"已经成功删除该事件!"});
			    setTimeout(reloadIssue,1000);
			    getMessageByUser();
			}else{
				$.messageBox({level:'error',message:"删除事件失败!"});
			}
		}
	});
}

function settingIssueHistorical(keyId,type,token){
	if (!isNullObject(keyId)){
		$.ajax({
			url:'/issues/issueManage/dealIssue.action',
			data:{
				"keyId":keyId,
				"dealCode":type,
				"struts.token":token
			},
			success:function(data){
				if (data.issueStepId>0){			
					$.messageBox({message:"成功设置该事件的历史遗留状态!"});
					setTimeout(reloadIssue,1000);
					getMessageByUser();
				}else{
				 	$.messageBox({level:"error",message:data});
				}
			}
		});
	}
}

function historicalIssue(){
	var selectedId= $("#issueList").getGridParam("selrow");
	if(null ==selectedId ){
		return;
	}
		$.ajax({
		url:'/issue/issueManage/historicalIssue.action',
		data:{
			"step.id":selectedId
		},
		success:function(data){
			if (data>0){			
				$.messageBox({message:"该事件处理已设置为历史遗留!"});
                $(".message").click();
			}else{
			 	$.messageBox({message:data});
			}
		}
	});
}

function issueRightHeight(){
	function getHeight(){
		var tempHeight=$(".ui-layout-center").height()-$("#thisCrumbs").height()-$("#nav").height()-$(".ui-tabs .ui-tabs-nav li").height()
		var centerLayerHeight=tempHeight-15;
		var issueListHeight=tempHeight-$(".issueLeft .issueTitle").height()-65;
		$(".issueProgram").height(centerLayerHeight);
		$(".issueLeft").height(centerLayerHeight);
		$(".issueLeft .issueList").height(issueListHeight);
		$(".issueRight").height(centerLayerHeight);
	}
	getHeight();
	
	$(window).resize(function(){
		clearTimeout(window._issueRightTimer);
		window._issueRightTimer=setTimeout(function(){getHeight()},300);
	})
}

function mouseOverOrOut(){
	$(".issueLeft div").delegate(".issueList li","mouseover",function(){
		$(this).addClass("hoverCur").siblings().removeClass("hoverCur");
	});

	$(".issueLeft div").delegate(".issueList li","mouseout",function(){
		$(this).removeClass("hoverCur");
	});
}
function initIssueList(){
	$(".issueList li a.handleLink").each(function(){
		if($(this).html()==110){
			$(this).html("待受理").addClass("backlog");
		}else if($(this).html()==140){
			$(this).html("待阅读").addClass("state-read");
		}else if($(this).html()==500){
			$(this).html("已办");
		}else if($(this).html()==1000){
			$(this).html("已完成");
		}else{
			$(this).html("办理中").addClass("state-proceed");
		}
	});	
}

function getData(){
	var dataObject={
			id:($(".issueList li.current").attr("id")),
			issueStepId:($(".issueList li.current").attr("issueStepId")),
			supervisionState:($(".issueList li.current").attr("supervisionState")),
			issueLogId:($(".issueList li.current").attr("issueLogId"))
	};
	return dataObject;
}

function setSuperviseButtons(){
	//resetSuperviseButtonsState();
}

function resetSuperviseButtonsState(){
	var	selectedId = $("#issueList").getGridParam("selrow");
	//var	selectedId = $(".issueList li.current").attr("issueStepId");
	var hasSelected=!isNullObject(selectedId);
	resetCancelSuperviseButtonState(hasSelected);
	resetRedSuperviseButtonState(hasSelected);
	resetYellowSuperviseButtonState(hasSelected);
	resetNormalSuperviseButtonState(hasSelected);
}

function resetRedSuperviseButtonState(hasSelected){
	if (hasSelected && !redSupervised()){
		$("#redCardIssue").buttonEnable();
	}else{
		$("#redCardIssue").buttonDisable();
	}
}

function resetYellowSuperviseButtonState(hasSelected){
	if (hasSelected && !redSupervised() && !yellowSupervised()){
		$("#yellowCardIssue").buttonEnable();
	}else{
		$("#yellowCardIssue").buttonDisable();
	}
}

function resetNormalSuperviseButtonState(hasSelected){
	if (hasSelected && !redSupervised() && !yellowSupervised() && !normalSupervised()){
		$("#normalIssue").buttonEnable();
	}else{
		$("#normalIssue").buttonDisable();
	}
}

function resetCancelSuperviseButtonState(hasSelected){
	if (hasSelected && (normalSupervised() || yellowSupervised() || redSupervised())){
		$("#cancleSupervise").buttonEnable();
	}else{
		$("#cancleSupervise").buttonDisable();
	}
}

function redSupervised(){
	//var selectedIssue=$("#issueList").getRowData($("#issueList").getGridParam("selrow"));
	var selectedIssue = getData();
	return !isNullObject(selectedIssue) && (selectedIssue.supervisionState == 200 || (selectedIssue.supervisionState!=undefined && selectedIssue.supervisionState.indexOf("redcard.gif")!=-1));
}

function yellowSupervised(){
	//var selectedIssue=$("#issueList").getRowData($("#issueList").getGridParam("selrow"));
	var selectedIssue = getData();
	return !isNullObject(selectedIssue) && (selectedIssue.supervisionState == 100 || (selectedIssue.supervisionState!=undefined && selectedIssue.supervisionState.indexOf("yellowcard.gif")!=-1));
}

function normalSupervised(){
	//var selectedIssue=$("#issueList").getRowData($("#issueList").getGridParam("selrow"));
	var selectedIssue = getData();
	return !isNullObject(selectedIssue) && (selectedIssue.supervisionState == 1 || (selectedIssue.supervisionState!=undefined && selectedIssue.supervisionState.indexOf("normalcard.gif")!=-1));
}

function superviseIssue(keyId,typeCode){
	if (!isNullObject(keyId)){
		$("#issueDialog").createDialog({
	        width:550,
	        height:370,
	        title:'督办',
			url:'/issues/issueManage/dispatchDeal.action?dealCode='+typeCode+'&keyId='+keyId,
	        buttons: {
	            "确定" : function(event){
	                $("#superviseIssueForm").submit();
	            },
	            "关闭" : function(){
	                $(this).dialog("close");
	            }
	        }
	    });
	}
}

function cancelSupervise(keyId,typeCode,token,tokenId){
	if (!isNullObject(keyId)){
		$.ajax({
			url:'/issues/issueManage/dealIssue.action',
	        data:{
	            "dealCode":typeCode,
	            "keyId":keyId,
	            "struts.token":token,
	            "SUPERVISE_TOKEN_ID":tokenId
	        },
	        success:function(data){
	            if(data.issueStepId>0){
					$("#issueList").setRowData(keyId,data);
	                $.messageBox({message:"成功取消对该部门的督办!"});
	                setTimeout(reloadIssue,1000);
	               // resetSuperviseButtonsState();
	            }else{
	                $.messageBox({message:data});
	            }
	        }
	    });
	}
	
}

function normalIssue(){
	//var selectedIssue=$("#issueList").getRowData($("#issueList").getGridParam("selrow"));
	var selectedIssue = getData();
	if(isNullObject(selectedIssue) || isNullObject(selectedIssue.issueLogId)){
		return;
	}
	$("#issueDialog").createDialog({
        width:550,
        height:350,
        title:'普通督办',
		url:'/issue/issueBusinessManage/dispatchDeal.action?dealType=81&stepId='+selectedIssue.issueLogId,
        buttons: {
            "确定" : function(event){
                $("#superviseIssueForm").submit();
            },
            "关闭" : function(){
                $(this).dialog("close");
            }
        }
    });
}

function yellowCardIssue(){
	//var selectedIssue=$("#issueList").getRowData($("#issueList").getGridParam("selrow"));
	var selectedIssue = getData();
	if(isNullObject(selectedIssue) || isNullObject(selectedIssue.issueLogId)){
		return;
	}
    $("#issueDialog").createDialog({
        width:550,
        height:350,
        title:'黄牌督办',
		url:'/issue/issueBusinessManage/dispatchDeal.action?dealType=83&stepId='+selectedIssue.issueLogId,
        buttons: {
            "确定" : function(event){
                $("#superviseIssueForm").submit();
            },
            "关闭" : function(){
                $(this).dialog("close");
            }
        }
    });
}

function redCardIssue(){
	//var selectedIssue=$("#issueList").getRowData($("#issueList").getGridParam("selrow"));
	var selectedIssue = getData();
	if(isNullObject(selectedIssue) || isNullObject(selectedIssue.issueLogId)){
		return;
	}
    $("#issueDialog").createDialog({
        width:550,
        height:350,
        title:'红牌督办',
		url:'/issue/issueBusinessManage/dispatchDeal.action?dealType=86&stepId='+selectedIssue.issueLogId,
        buttons: {
            "确定" : function(event){
                $("#superviseIssueForm").submit();
            },
            "关闭" : function(){
                $(this).dialog("close");
            }
        }
    });
}


function cancleSuperviseIssue(){
	//var selectedIssue=$("#issueList").getRowData($("#issueList").getGridParam("selrow"));
	var selectedIssue = getData();
	if(isNullObject(selectedIssue) || isNullObject(selectedIssue.issueLogId)){
		return;
	}
	var oldIssueLogId = selectedIssue.issueLogId;
	$.ajax({
		url:'/issue/issueBusinessManage/cancelSupervise.action?stepId='+selectedIssue.issueLogId,
        data:{
            "issueLogNew.issue.id":selectedIssue.issueId,
            "issueLogNew.id":selectedIssue.issueLogId
        },
        success:function(data){
            if(data.issueLogId>0){
                $.messageBox({message:"对此处理过程的督办取消成功!"});
                resetSuperviseButtonsState();
            }else{
                $.messageBox({message:data});
            }
        }
    });
}

(function($){
	$.fn.extend({
		columnChart : function(option,columnOptions){
			Highcharts.theme = {
				colors: ["#514F78", "#42A07B", "#9B5E4A", "#72727F", "#1F949A", "#82914E", "#86777F", "#DF5353", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee"]
			};
			Highcharts.setOptions(Highcharts.theme);
			var self=$(this);
			var selfHeight=self.height();
			var chart = '';
			var defaultOption = {
					url:'',
					quantity:'',
					moduleName:'',
					renderTo: self.attr('id'),
					defaultSeriesType: 'column',
					width:null,
					ajax:true,
					textx:'',
					events:{
						load:function(){
							$.sigmaReportLayout();
						}
					},
					margin:40,
					marginTop:60,
					marginBottom:60,
					options3d: {
		                enabled: true,
		                alpha: 0,
		                beta: 0,
		                depth: 120,
		                viewDistance:250
		            }
			};
			if(defaultOption.renderTo==undefined){
				return;
			}
			
			$.extend(defaultOption,option);
			var chartOptions = {
					chart:defaultOption,
					title: {
						align:'center',
						text: '',
						margin:30
					},
					style: {
						fontFamily: 'Arial'
					},
					xAxis: {
						categories:[]
					},
					yAxis: {
						allowDecimals: false,
						opposite: false,
						min: 0,
						title: {
							text: ''
						},
						labels: {
			                align: 'right',
			                x: 1
			            }
					},
					legend: {
						align: 'left',
						x: 70,
						verticalAlign: 'top',
						y: 30,
						floating: true,
						backgroundColor: '#FFFFFF',
						borderColor: '#CCC',
						borderWidth: 1,
						shadow: false
					},
					tooltip: {
						formatter: function() {
							return '<b>'+ this.x +'</b><br/>'+
								 this.series.name +': '+ this.y +(option.isShowSum=='false'?'':'<br/>'+defaultOption.moduleName+'总数量: '+ this.point.stackTotal);
						}
					},
					plotOptions: {
						column: {
							stacking: 'normal',
							depth: 25
						}
					},
				    series: [],
				    credits: {
						enabled: true,
						text: '',
						href: 'javascript:;',
						position: {
							align: 'right',
							x: -10,
							verticalAlign: 'bottom',
							y: -5
						},
						style: {
							cursor: 'pointer',
							color: '#000000',
							fontSize: '10px'
						}
					},
					lang: {
						downloadPNG : "下载成 PNG 格式",
						downloadJPEG : "下载成 JPEG 格式",
						downloadPDF : "下载成 PDF 格式",
						downloadSVG : "",
						exportButtonTitle : "导出图片",
						printButtonTitle : "打印"
					},
					exporting:{
						buttons:{
							printButton:{
								enabled:false,
								onclick:function(){
									$(this.container).printArea();
								}
							},
							exportButton:{
								enabled:false,
								align:'right',
								x:-30,
								y:45
							}
						}
					}
			};
			
			
			if(defaultOption.ajax){
				$.ajax({
					async: false,
					url: defaultOption.url,
					success:function(responseData){
						var moduleName='';
						if(responseData==null || responseData.series==null){return false;}
						if(defaultOption.moduleName != ''){
							moduleName = defaultOption.moduleName;
						}else{
							moduleName = responseData.moduleName;
						}
						var origChartWidth = 90;
						if(responseData!=null && responseData.categories!=null && responseData.categories.length>13){
							var num = responseData.categories.length;
							chartOptions.chart.width = origChartWidth*num;
						}
						var sum = 0;
						var i,j;
						//alert("series:"+responseData.series.length+",categories:"+responseData.categories.length);
						var display="";
						if(responseData.series.length<=2){
							for(i=0;i<responseData.series.length;i++){
								for(j=0;j<responseData.categories.length;j++){
									if(display==""){
										display=responseData.series[i].stack;
									}
									if(display==responseData.series[i].stack){
									sum += responseData.series[i].data[j];
									}
								}
							}
						}else if(responseData.series.length==4 && responseData.categories.length==1){
							for(i=0;i<responseData.series.length;i++){
								for(j=0;j<responseData.categories.length;j++){
									if(display==""){
										display=responseData.series[i].stack;
									}
									if(display==responseData.series[i].stack){
									sum += responseData.series[i].data[j];
									}
								}
							}
						}else{
							for(i=0;i<responseData.series.length;i++){
								for(j=0;j<responseData.categories.length;j++){
									if(display==""){
										display=responseData.series[i].stack;
									}
									if(display==responseData.series[i].stack){
									sum += responseData.series[i].data[j];
									}
								}
							}
						}
						chartOptions.title.text = moduleName + "(总计: " + sum + "个)";
						chartOptions.yAxis.title.text = moduleName+ 'y轴（'+defaultOption.quantity+'）（1k=1000）';
						chartOptions.title.x =defaultOption.textx;
						if(defaultOption.legend != ''){
							$.extend(chartOptions.legend,defaultOption.legend);
						}
						chartOptions.xAxis.categories = responseData.categories ;
						chartOptions.series = responseData.series;
						$.extend(true,chartOptions,columnOptions);//深度copy传入的参数
						if(chartOptions.workbenchColum==true && responseData.categories.length>5){
							var label={
								labels:{
									rotation: -45,
				                    style: {
				                        fontSize: '11px'
				                    }
								}
							}
							$.extend(true,chartOptions.xAxis,label);
						}
						try
						{
							chart=new Highcharts.Chart(chartOptions);
						}
						catch(err)
						{
							$.messageBox({message:err,level:'error'});
							throw new Error(err);
						}
						
					}
				});
			}else{
				var visualizeOptions={
					title:{
						text:'',
						margin:15
					},
					plotOptions:{
						column:{
							stacking:null
						}
					},
					tooltip: {
						formatter: function() {
							return '<b>'+ this.x +'</b><br/>'+
								 this.series.name +': '+ this.y;
						}
					},
					exporting:{
						buttons:{
							exportButton:{
							enabled:false,
								align:'right'
							},
							printButton:{
								enabled:false
							}
						}
					},
					legend:{
						align: 'left',
						x: 70,
						verticalAlign: 'top',
						y: -10,
						floating: true,
						backgroundColor: '#FFFFFF',
						borderColor: '#CCC',
						borderWidth: 1,
						shadow: false
					}
				}
				$.extend(chartOptions,visualizeOptions);
				chart=Highcharts.visualize(defaultOption.table, chartOptions);
			}
			$("#"+defaultOption.renderTo).children(".highcharts-container").css({
				overflow:"auto",width:"100%","overflow-y":"auto"
			})
			self.data("chart",chart);
			return chart;
		}
	});
	
	$.fn.extend({
		columnChartOfTaskList : function(option,columnOptions){
			Highcharts.theme = {
				colors: ["#514F78", "#42A07B", "#9B5E4A", "#72727F", "#1F949A", "#82914E", "#86777F", "#DF5353", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee"]
			};
			Highcharts.setOptions(Highcharts.theme);
			var self=$(this);
			var selfHeight=self.height();
			var chart = '';
			var defaultOption = {
					url:'',
					quantity:'',
					moduleName:'',
					renderTo: self.attr('id'),
					defaultSeriesType: 'column',
					width:null,
					ajax:true,
					textx:'',
					events:{
						load:function(){
							$.sigmaReportLayout();
						}
					},
					margin:40,
					marginTop:60,
					marginBottom:60,
					options3d: {
		                enabled: true,
		                alpha: 0,
		                beta: 0,
		                depth: 120,
		                viewDistance:250
		            }
			};
			if(defaultOption.renderTo==undefined){
				return;
			}
			
			$.extend(defaultOption,option);
			var chartOptions = {
					chart:defaultOption,
					title: {
						align:'center',
						text: '',
						margin:30
					},
					style: {
						fontFamily: 'Arial'
					},
					xAxis: {
						categories:[]
					},
					yAxis: {
						allowDecimals: false,
						opposite: false,
						min: 0,
						title: {
							text: ''
						},
						labels: {
			                align: 'right',
			                x: 1
			            }
					},
					legend: {
						align: 'left',
						x: 70,
						verticalAlign: 'top',
						y: 30,
						floating: true,
						backgroundColor: '#FFFFFF',
						borderColor: '#CCC',
						borderWidth: 1,
						shadow: false
					},
					tooltip: {
						formatter: function() {
							return '<b>'+ this.x +'</b><br/>'+
								 this.series.name +': '+ this.y +(option.isShowSum=='false'?'':'<br/>');
						}
					},
					plotOptions: {
//						column: {
//							stacking: 'normal',
//							depth: 25
//						}
						column: {
			                pointPadding: 0.2,
			                borderWidth: 0
			            }
					},
				    series: [],
				    credits: {
						enabled: true,
						text: '',
						href: 'javascript:;',
						position: {
							align: 'right',
							x: -10,
							verticalAlign: 'bottom',
							y: -5
						},
						style: {
							cursor: 'pointer',
							color: '#000000',
							fontSize: '10px'
						}
					},
					lang: {
						downloadPNG : "下载成 PNG 格式",
						downloadJPEG : "下载成 JPEG 格式",
						downloadPDF : "下载成 PDF 格式",
						downloadSVG : "",
						exportButtonTitle : "导出图片",
						printButtonTitle : "打印"
					},
					exporting:{
						buttons:{
							printButton:{
								enabled:false,
								onclick:function(){
									$(this.container).printArea();
								}
							},
							exportButton:{
								enabled:false,
								align:'right',
								x:-30,
								y:45
							}
						}
					}
			};
			
			
			if(defaultOption.ajax){
				$.ajax({
					async: false,
					url: defaultOption.url,
					success:function(responseData){
						var moduleName='';
						if(responseData==null || responseData.series==null){return false;}
						if(defaultOption.moduleName != ''){
							moduleName = defaultOption.moduleName;
						}else{
							moduleName = responseData.moduleName;
						}
						var origChartWidth = 90;
						if(responseData!=null && responseData.categories!=null && responseData.categories.length>13){
							var num = responseData.categories.length;
							chartOptions.chart.width = origChartWidth*num;
						}
						var sum = 0;
						var i,j;
						//alert("series:"+responseData.series.length+",categories:"+responseData.categories.length);
						var display="";
						if(responseData.series.length<=2){
							for(i=0;i<responseData.series.length;i++){
								for(j=0;j<responseData.categories.length;j++){
									if(display==""){
										display=responseData.series[i].stack;
									}
									if(display==responseData.series[i].stack){
									sum += responseData.series[i].data[j];
									}
								}
							}
						}else if(responseData.series.length==4 && responseData.categories.length==1){
							for(i=0;i<responseData.series.length;i++){
								for(j=0;j<responseData.categories.length;j++){
									if(display==""){
										display=responseData.series[i].stack;
									}
									if(display==responseData.series[i].stack){
									sum += responseData.series[i].data[j];
									}
								}
							}
						}else{
							for(i=0;i<responseData.series.length;i++){
								for(j=0;j<responseData.categories.length;j++){
									if(display==""){
										display=responseData.series[i].stack;
									}
									if(display==responseData.series[i].stack){
									sum += responseData.series[i].data[j];
									}
								}
							}
						}
						chartOptions.title.text = moduleName;
						chartOptions.yAxis.title.text = moduleName+ 'y轴（'+defaultOption.quantity+'）（1k=1000）';
						chartOptions.title.x =defaultOption.textx;
						if(defaultOption.legend != ''){
							$.extend(chartOptions.legend,defaultOption.legend);
						}
						chartOptions.xAxis.categories = responseData.categories ;
						chartOptions.series = responseData.series;
						$.extend(true,chartOptions,columnOptions);//深度copy传入的参数
						if(chartOptions.workbenchColum==true && responseData.categories.length>5){
							var label={
								labels:{
									rotation: -45,
				                    style: {
				                        fontSize: '11px'
				                    }
								}
							}
							$.extend(true,chartOptions.xAxis,label);
						}
						try
						{
							chart=new Highcharts.Chart(chartOptions);
						}
						catch(err)
						{
							$.messageBox({message:err,level:'error'});
							throw new Error(err);
						}
						
					}
				});
			}else{
				var visualizeOptions={
					title:{
						text:'',
						margin:15
					},
					plotOptions:{
						column:{
							stacking:null
						}
					},
					tooltip: {
						formatter: function() {
							return '<b>'+ this.x +'</b><br/>'+
								 this.series.name +': '+ this.y;
						}
					},
					exporting:{
						buttons:{
							exportButton:{
							enabled:false,
								align:'right'
							},
							printButton:{
								enabled:false
							}
						}
					},
					legend:{
						align: 'left',
						x: 70,
						verticalAlign: 'top',
						y: -10,
						floating: true,
						backgroundColor: '#FFFFFF',
						borderColor: '#CCC',
						borderWidth: 1,
						shadow: false
					}
				}
				$.extend(chartOptions,visualizeOptions);
				chart=Highcharts.visualize(defaultOption.table, chartOptions);
			}
			$("#"+defaultOption.renderTo).children(".highcharts-container").css({
				overflow:"auto",width:"100%","overflow-y":"auto"
			})
			self.data("chart",chart);
			return chart;
		}
	});

	$.fn.extend({
		pieChart : function(option,pieChartOption){
			var bol='';
			Highcharts.theme = {
				colors: ["#514F78", "#42A07B", "#9B5E4A", "#72727F", "#1F949A", "#82914E", "#86777F", "#DF5353", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee"]
			};
			Highcharts.setOptions(Highcharts.theme);
			
			var defaultOption = {
				url:"",
				moduleName:"",
				renderTo: $(this).attr('id'),
		        plotBackgroundColor: null,
		        plotBorderWidth: null,
		        plotShadow: false,
		        msgInfo:"",
				onClick:function(event){},
				margin:50,
				options3d: {
					enabled: true,
	                alpha: 45,
	                beta: 0
	            }
			};

			$.extend(defaultOption, option);
			var self=$(this);
			var chart = '';
			var msg_ = option.msgInfo;
			var chartOptions = {
				chart: defaultOption,
			    title: {
			        text: defaultOption.moduleName+'类型分布图',
			        margin:30
			    },
			    tooltip: {
			        formatter: function() {
			    		return '<b>'+ this.point.name +'</b>: '+ (this.y==0.001?'0':this.y) +' %';
			        }
			    },
			    plotOptions: {
			        pie: {
			    		allowPointSelect: true,
			            cursor: 'pointer',
		                depth: 35,
			            dataLabels: {
			            	enabled: true,
			            	color: '#000000',
			                connectorColor: '#000000',
			                formatter: function() {
			    	            if(this.y && ""==this.y.toString()){
			    	            	return '<b>'+ this.point.name +'</b>';
			    	            }else{
			    	            	return '<b>'+ this.point.name +'</b>: '+ (this.y==0.001?'0':this.y) +' %';
			    	            }
			                }
			             },
			             events: {
			                 click: defaultOption.onClick
			             }
			         }
			      },
			      series: [{
			    	  type: 'pie',
			    	  name: 'Browser share',
			          data: []
			      }],
			      credits: {
						enabled: true,
						text: '',
						href: 'javascript:;',
						position: {
							align: 'right',
							x: -10,
							verticalAlign: 'bottom',
							y: -5
						},
						style: {
							cursor: 'pointer',
							color: '#000000',
							fontSize: '10px'
						}
					},
					lang: {
						downloadPNG : "下载成 PNG 格式",
						downloadJPEG : "下载成 JPEG 格式",
						downloadPDF : "下载成 PDF 格式",
						downloadSVG : "",
						exportButtonTitle : "",
						printButtonTitle : "打印"
					},
					exporting:{
						buttons:{
							exportButton:{
								enabled:false
							},
							printButton:{
								enabled:false,
								onclick:function(){
									$(this.container).printArea();
								}
							}
						}
					}
			};
			$.ajax({
				async: false,
				url: defaultOption.url,
				success:function(data){
					if(data == null || data== "" || data.indexOf("errorCode")!=-1){
						$.messageBox({message:"查询的月份没有数据生成",level: "error"});
						return false;
					}else{
						for(var j=data.length-1;j>=0;j--){
							if( !data[j]['1'] ){
								data[j]['1'] = 0.001
							}
						}
						chartOptions.series[0].data=data;
						$.extend(true,chartOptions,pieChartOption);//深度copy传入的参数
						chart=new Highcharts.Chart(chartOptions);
					}
				}
			});
			self.data("chart",chart);
			return chart;
		}
	});
	
	
	
	$.fn.extend({
		lineChart : function(option,lineOptions){
			var defaultOption = {
					url:'',
					moduleName:'',
					ajax:true,
					options3d: {
						enabled: true
					},
					isReverse:true,
					renderTo: $(this).attr('id'),
					defaultSeriesType: 'spline',
					isIssue:false//是否是事件的趋势图,事件的趋势图允许为负数
			};
			var self=$(this);
			$.extend(defaultOption,option);
			var min=0;
			if(defaultOption.isIssue){
				min=null;
			}
			var line = '';
			var chartOptions = {
					chart:defaultOption,
					title: {
						text: ''
					},
					xAxis: {
						categories:[]
					},
					yAxis: {
						allowDecimals: false,
						min: min,
						title: {
							text: ''
						}
					},
				      tooltip: {
				          crosshairs: true,
				          shared: true
				       },
				       plotOptions: {
				          spline: {
				             marker: {
				                radius: 4,
				                lineColor: '#666666',
				                lineWidth: 1
				             }
				          }
				       },
					series:{},
					  credits: {
							enabled: true,
							text: '',
							href: 'javascript:;',
							position: {
								align: 'right',
								x: -10,
								verticalAlign: 'bottom',
								y: -5
							},
							style: {
								cursor: 'pointer',
								color: '#000000',
								fontSize: '10px'
							}
						},
						legend: {
							align: 'left',
							x: 70,
							verticalAlign: 'top',
							y: 18,
							floating: true,
							backgroundColor: '#FFFFFF',
							borderColor: '#CCC',
							borderWidth: 1,
							shadow: false
						},
						lang: {
							downloadPNG : "下载成 PNG 格式",
							downloadJPEG : "下载成 JPEG 格式",
							downloadPDF : "下载成 PDF 格式",
							downloadSVG : "",
							exportButtonTitle : "",
							printButtonTitle : "打印"
						},
						exporting:{
							exportButton:{
								align:'right',
								x:-30,
								y:45
							},
						    buttons:{
								exportButton:{
									enabled:false
								},
							    printButton:{
									enabled:false,
								    onclick:function(){
									    $(this.container).printArea();
								    }
							    }
						    }
						}

			};
			
			if(defaultOption.ajax){
				$.get(defaultOption.url, function(data) {
					var moduleName='';
					
					if(defaultOption.moduleName != ''){
						moduleName = defaultOption.moduleName;
					}else{
						moduleName = data.moduleName;
					}
					
					chartOptions.title.text = moduleName;
					chartOptions.yAxis.title.text = moduleName;

					chartOptions.xAxis.categories = data.categories;
					chartOptions.series = data.series;
					$.extend(true,chartOptions,lineOptions);//深度copy传入的参数
				    line=new Highcharts.Chart(chartOptions);
				});
			}else{
				var visualizeOptions = {
					isReverse:defaultOption.isReverse,
					legend: {
						align: 'left',
						x: 70,
						verticalAlign: 'top',
						y: -10,
						floating: true,
						backgroundColor: '#FFFFFF',
						borderColor: '#CCC',
						borderWidth: 1,
						shadow: false
					}
				}
				$.extend(chartOptions,visualizeOptions);
				line = Highcharts.visualize(defaultOption.table, chartOptions);
			}
			self.data("chart",line);
			return line;
		}
	});
	
	/**
	 * Visualize an HTML table using Highcharts. The top (horizontal) header 
	 * is used for series names, and the left (vertical) header is used 
	 * for category names. This function is based on jQuery.
	 * @param {Object} table The reference to the HTML table to visualize
	 * @param {Object} options Highcharts options
	 */
	Highcharts.visualize = function(table, options) {
		
		var indexOfHeJi = -1;
		// the categories
		var tableId=$(table).attr("id").substring(5,$(table).attr("id").length);
		options.xAxis.categories = [];
		
		var arrayData = jQuery('#'+tableId+' tr.ui-row-ltr:visible').get();
		if(options.isReverse){
			arrayData.reverse();
		}
		
		$(arrayData).each( function(i) {
			var thisVal=$(this).find("td:visible").first().text();
			if(thisVal!=''){
				if(thisVal == '合计'){
					indexOfHeJi = i;
				}else{
					options.xAxis.categories.push(thisVal);
					indexOfHeJi = -1;
				}
			}
		});
		
		
		// the data series
		options.series = [];
		
		jQuery("#"+$(table).attr("id")+' .ui-jqgrid-htable .ui-th-ltr:visible').each( function(i) {
			var thisVal=$(this).find(".ui-jqgrid-sortable:visible").first().text();
			options.series[i-1] = { 
				name: thisVal,
				data: []
			};
		});
		
		$(arrayData).each( function(i) {
			var tr = this;
			if(indexOfHeJi != i){
				jQuery('td:visible',tr).each( function(j) {
					if (j > 0) { // skip first column
						options.series[j - 1].data.push(parseFloat(this.innerHTML));
					}
				});
			}
		});
		var origChartWidth = 120;//柱状图横坐标间隔
		if(options.xAxis.categories.length>13){
			var num = options.xAxis.categories.length;
			options.chart.width = origChartWidth*num;
		}
		var chart = new Highcharts.Chart(options);
		return chart;
	}
})(jQuery)

//绑定按钮文本
function setUrgentButtons(dealCode,cancelCode,token){
	if($(".issueList li.current").attr("urgent")=='1'){
		$("#urgent").html('<span>取消加急</span>');
		$("#urgent").attr("id","cancelUrgent");
		$("#cancelUrgent").unbind('click').bind('click',function(){
				bindCancleUrgent(cancelCode,token);
			});
		
	}else{
		$("#cancelUrgent").html('<span>加急</span>');
		$("#cancelUrgent").attr("id","urgent");
		$("#urgent").unbind('click').bind('click',function(){
			bindUrgent(dealCode);
		});
	}
}

//绑定加急事件
function bindUrgent(dealCode){
	var	selectedId = $(".issueList li.current").attr("issueStepId");
	if (hasRowSelected()){
		bindUrgentById(dealCode,selectedId)
	}else{
		$.messageBox({level:'warn',message:"没有可加急的事件！"});
	}
}
//绑定加急事件
function bindUrgentById(dealCode,selectedId){
	if (isNullObject(selectedId)){
		$.messageBox({level:'warn',message:"没有可加急的事件！"});
	}else{
			$("#issueDialog").createDialog({
				width:600,
				height:400,
				title:'加急',
				url:'/issues/issueManage/dispatchDeal.action?dealCode='+dealCode+'&keyId='+selectedId,
				buttons: {
					"确定" : function(event){
						$("#singleContentDealForm").submit();
					  $("#urgent").find("span").html("取消加急");
					  var urgenButton=$("#urgent").attr("id","urgent");
					},
					"关闭" : function(){
						$(this).dialog("close");
					}
				}
			});
	}
}
//绑定取消加急事件
function bindCancleUrgent(cancelCode,token){
	if (hasRowSelected()){
		var	keyId = $(".issueList li.current").attr("issueStepId");
		bindCancleUrgentById(keyId,cancelCode,token);
	}else{
		$.messageBox({level:'warn',message:"没有可取消加急的事件！"});
	}
}

//绑定取消加急事件
function bindCancleUrgentById(keyId,cancelCode,token){
	if (!isNullObject(keyId)){
		$.confirm({
			title:"系统提示",
			message:"是否确定要取消对该事件处理的加急!",
			width:400,
			okFunc:function(){
				$.ajax({
					url:"/issues/issueManage/dealIssue.action",
					data:{
						"keyId":keyId,
						"dealCode":cancelCode,
						"struts.token":token
					},
					success:function(data){
						if (data != null && data.issueStepId){
							$.messageBox({message:"已经成功取消该事件处理的加急!"});
							$("#urgent").find("span").html("加急");
							var urgenButton=$("#cancelUrgent").attr("id","urgent");
						}else{
							$.messageBox({message:data,level:"error"});
						}
						reloadIssue();
					}
				});
			}
		});
	}
}


/********************************/
function setUrgentButton(){
	resetUrgentButtonState();
}

//设置加急/取消加急按钮
function resetUrgentButton(rowSelected,keyId,urgentCode,cancelCode,token){
	if (rowSelected ){
		if (isNullObject(keyId)){
			return ;
		}else{
			if(isUrgented($("#issueList"))){
				bindCancelIssueUrgentEvent(keyId,cancelCode,token);
			}else{
				bindUrgentIssueEvent(keyId,urgentCode);
			}
		}
	}else{
		$.messageBox({level:'warn',message:"请选择一条事件后再操作！"});
	}
}

//加急
function bindUrgentIssueEvent(keyId,urgentCode){
	var urgenButton=$("#urgent");
	if (urgenButton==null || typeof(urgenButton)=="undefined"){
		return;
	}
	urgenButton.html('<span><strong class="ui-ico-jiaji"></strong>加急</span>');
	urgenButton.unbind("click");
	urgenButton.click(function(event){
		$("#issueDialog").createDialog({
			width:600,
			height:400,
			title:'加急',
			url:'/issues/issueManage/dispatchDeal.action?dealCode='+urgentCode+'&keyId='+keyId,
			buttons: {
				"确定" : function(event){
					$("#singleContentDealForm").submit();
				},
				"关闭" : function(){
					$(this).dialog("close");
				}
			}
		});
	});
}

//取消加急
function bindCancelIssueUrgentEvent(keyId,cancelCode,token){
	var urgenButton=$("#urgent");
	if (isNullObject(urgenButton)){
		return;
	}
	urgenButton.html('<span><strong class="ui-ico-qxjj"></strong>取消加急</span>');
	urgenButton.unbind("click");
	urgenButton.click(function(event){
		if (!isNullObject(keyId)){
			$.confirm({
				title:"系统提示",
				message:"是否确定要取消对该事件处理的加急!",
				width:400,
				okFunc:function(){
					$.ajax({
						url:"/issues/issueManage/dealIssue.action",
						data:{
							"keyId":keyId,
							"dealCode":cancelCode,
							"struts.token":token
						},
						success:function(data){
							if (data != null && data.issueStepId){
								$.messageBox({message:"已经成功取消该事件处理的加急!"});
							}else{
								$.messageBox({message:data,level:"error"});
							}
							reloadIssue();
						}
					});
				}
			});
		}
	});
}

function resetUrgentButtonState(){
	var	selectedId = $(".issueList li.current").attr("issueStepId");
	if (isNullObject(selectedId)){
		$("#urgent").buttonDisable();
	}else{
		$("#urgent").buttonEnable();
		if(isUrgented($("#issueList"))){
			bindCancelUrgentEvent();
		}else{
			bindUrgentEvent();
		}
	}
}

function isUrgented(listGrid){
	var selectedIssue = {urgent:$(".issueList li.current").attr("urgent")};
	return selectedIssue.urgent == 1 || (selectedIssue.urgent!=undefined && selectedIssue.urgent.indexOf("immediate.gif")!=-1);
}

function bindCancelUrgentEvent(){
	var urgenButton=$("#urgent");
	if (isNullObject(urgenButton)){
		return;
	}
	urgenButton.html('<span><strong class="ui-ico-qxjj"></strong>取消加急</span>');
	urgenButton.unbind("click");
	urgenButton.click(function(event){
		var	selectedId = $(".issueList li.current").attr("issueStepId");
		if (isNullObject(selectedId)){
			return;
		}
		$.confirm({
			title:"系统提示",
			message:"是否确定要取消对该事件处理的加急!",
			width:400,
			okFunc:cancelUrgent
		});
	});
}

function bindUrgentEvent(){
	var urgenButton=$("#urgent");
	if (urgenButton==null || typeof(urgenButton)=="undefined"){
		return;
	}
	urgenButton.html('<span><strong class="ui-ico-jiaji"></strong>加急</span>');
	urgenButton.unbind("click");
	urgenButton.click(function(event){
		urgentIssue();
	});
}

function cancelUrgent(){
	var	selectedId = $(".issueList li.current").attr("issueStepId");
	if (isNullObject(selectedId) || $("#urgent").attr("disabled")=="true"){
		return;
	}
	$.ajax({
		url:"/issue/issueManage/cancelUrgentIssue.action",
		data:{
			"step.id":selectedId
		},
		success:function(data){
			if (data.issueLogId){
			    $.messageBox({message:"已经成功取消该事件处理的加急!"});
			    resetUrgentButtonState();
			}else{
				$.messageBox({message:data,level:"error"});
				resetUrgentButtonState();
			}
			reloadIssue();
		}
	});
}

function urgentIssue(){
	var	selectedId = $(".issueList li.current").attr("issueStepId");
	if (isNullObject(selectedId) || $("#urgent").attr("disabled")=="true"){
		return;
	}
	$("#issueDialog").createDialog({
		width:690,
		height:430,
		title:'加急',
		url:'/issue/issueManage/dispatch.action?mode=urgent&step.id='+selectedId,
		buttons: {
			"确定" : function(event){
				$("#urgentIssueForm").submit();
			},
			"关闭" : function(){
				$(this).dialog("close");
			}
		}
	});
}
/**
 *  Version 2.1
 *      -Contributors: "mindinquiring" : filter to exclude any stylesheet other than print.
 *  Tested ONLY in IE 8 and FF 3.6. No official support for other browsers, but will
 *      TRY to accomodate challenges in other browsers.
 *  Example:
 *      Print Button: <div id="print_button">Print</div>
 *      Print Area  : <div class="PrintArea"> ... html ... </div>
 *      Javascript  : <script>
 *                       $("div#print_button").click(function(){
 *                           $("div.PrintArea").printArea( [OPTIONS] );
 *                       });
 *                     </script>
 *  options are passed as json (json example: {mode: "popup", popClose: false})
 *
 *  {OPTIONS} | [type]    | (default), values      | Explanation
 *  --------- | --------- | ---------------------- | -----------
 *  @mode     | [string]  | ("iframe"),"popup"     | printable window is either iframe or browser popup
 *  @popHt    | [number]  | (500)                  | popup window height
 *  @popWd    | [number]  | (400)                  | popup window width
 *  @popX     | [number]  | (500)                  | popup window screen X position
 *  @popY     | [number]  | (500)                  | popup window screen Y position
 *  @popTitle | [string]  | ('')                   | popup window title element
 *  @popClose | [boolean] | (false),true           | popup window close after printing
 *  @strict   | [boolean] | (undefined),true,false | strict or loose(Transitional) html 4.01 document standard or undefined to not include at all (only for popup option)
 */
(function($) {
    var counter = 0;
    var modes = { iframe : "iframe", popup : "popup" };
    var defaults = { mode     : modes.iframe,
                     popHt    : 500,
                     popWd    : 400,
                     popX     : 200,
                     popY     : 200,
                     popTitle : '',
                     popClose : false };

    var settings = {};//global settings

    $.fn.printArea = function( options )
        {
            $.extend( settings, defaults, options );

            counter++;
            var idPrefix = "printArea_";
            $( "[id^=" + idPrefix + "]" ).remove();
            var ele = getFormData( $(this) );

            settings.id = idPrefix + counter;

            var writeDoc;
            var printWindow;

            switch ( settings.mode )
            {
                case modes.iframe :
                    var f = new Iframe();
                    writeDoc = f.doc;
                    printWindow = f.contentWindow || f;
                    break;
                case modes.popup :
                    printWindow = new Popup();
                    writeDoc = printWindow.doc;
            }

            writeDoc.open();
            writeDoc.write( docType() + "<html>" + getBody(ele) + "</html>" );
            writeDoc.close();

            printWindow.focus();
            printWindow.print();

            if ( settings.mode == modes.popup && settings.popClose )
                printWindow.close();
        }

    function docType()
    {
        if ( settings.mode == modes.iframe || !settings.strict ) return "";

        var standard = settings.strict == false ? " Trasitional" : "";
        var dtd = settings.strict == false ? "loose" : "strict";

        return '<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01' + standard + '//EN" "http://www.w3.org/TR/html4/' + dtd +  '.dtd">';
    }

    function getHead()
    {
        var head = "<head><title>" + settings.popTitle + "</title>";
        $(document).find("link")
            .filter(function(){
                    return "stylesheet" == $(this).attr("rel").toLowerCase();//.toLowerCase()
                })
            /*.filter(function(){ // this filter contributed by "mindinquiring"
                    var media = $(this).attr("media");
                    return (media.toLowerCase() == "" || media.toLowerCase() == "print")
                })*/
            .each(function(){
                    head += '<link type="text/css" rel="stylesheet" href="' + $(this).attr("href") + '" >';
                });
        head += "</head>";
        return head;
    }

    function getBody( printElement )
    {
        return '<body><div class="' + $(printElement).attr("class") + '">' + $(printElement).html() + '</div></body>';
    }

    function getFormData( ele )
    {
        $("input,select,textarea", ele).each(function(){
            // In cases where radio, checkboxes and select elements are selected and deselected, and the print
            // button is pressed between select/deselect, the print screen shows incorrectly selected elements.
            // To ensure that the correct inputs are selected, when eventually printed, we must inspect each dom element
            var type = $(this).attr("type");
            if ( type == "radio" || type == "checkbox" )
            {
                if ( $(this).is(":not(:checked)") ) this.removeAttribute("checked");
                else this.setAttribute( "checked", true );
            }
            else if ( type == "text" )
                this.setAttribute( "value", $(this).val() );
            else if ( type == "select-multiple" || type == "select-one" )
                $(this).find( "option" ).each( function() {
                    if ( $(this).is(":not(:selected)") ) this.removeAttribute("selected");
                    else this.setAttribute( "selected", true );
                });
            else if ( type == "textarea" )
            {
                var v = $(this).attr( "value" );
                if ($.browser.mozilla)
                {
                    if (this.firstChild) this.firstChild.textContent = v;
                    else this.textContent = v;
                }
                else this.innerHTML = v;
            }
        });
        return ele;
    }

    function Iframe()
    {
        var frameId = settings.id;
        var iframeStyle = 'border:0;position:absolute;width:0px;height:0px;left:0px;top:0px;';
        var iframe;

        try
        {
            iframe = document.createElement('iframe');
            document.body.appendChild(iframe);
            $(iframe).attr({ style: iframeStyle, id: frameId, src: "" });
            iframe.doc = null;
            iframe.doc = iframe.contentDocument ? iframe.contentDocument : ( iframe.contentWindow ? iframe.contentWindow.document : iframe.document);
        }
        catch( e ) { throw e + ". iframes may not be supported in this browser."; }

        if ( iframe.doc == null ) throw "Cannot find document.";

        return iframe;
    }

    function Popup()
    {
        var windowAttr = "location=yes,statusbar=no,directories=no,menubar=no,titlebar=no,toolbar=no,dependent=no";
        windowAttr += ",width=" + settings.popWd + ",height=" + settings.popHt;
        windowAttr += ",resizable=yes,screenX=" + settings.popX + ",screenY=" + settings.popY + ",personalbar=no,scrollbars=no";

        var newWin = window.open( "", "_blank",  windowAttr );

        newWin.doc = newWin.document;

        return newWin;
    }
})(jQuery);
	function jqGridMultiSelectState(jqgridId, selected){
		if (selected){
			$("#cb_"+jqgridId).attr("checked",'true');
		}else{
			$("#cb_"+jqgridId).removeAttr("checked");
		}
	}
	
	function getActualjqGridMultiSelectCount(jqgridId){
		var selectedIds=getActualjqGridMultiSelectIds(jqgridId);
		if (selectedIds==null || typeof(selectedIds)=="undefined"){
			return 0;
		}else{
			return selectedIds.length;
		}
	}

	function getActualjqGridMultiSelectIds(jqgridId){
		return $("#"+jqgridId).jqGrid("getGridParam", "selarrrow");
	}
	
	function _existedInArray(array,value){
		if (array==null || typeof(array)=="undefined") return false;
		for (var index=0;index<array.length;index++){
			var existedValue=array[index];
			if (existedValue==value) return true;
		}
		return false;
	}

	
function excelDownload(actionUrl,gridName,dialogId,title){
    var ieset = navigator.userAgent;  
    if(ieset.indexOf("MSIE 6.0") > -1){//浏览器判断 如果是IE6
		$("#"+dialogId).createDialog({
			width: 250,
			height: 200,
			title:title,
			url:'${path}/common/exportExcel.jsp',
			postData:{
				gridName:gridName,
				downloadUrl:actionUrl
				},
			buttons: {
	   			"导出" : function(event){
					$("#exceldownload").submit();
	        		$(this).dialog("close");
   				},
	   			"关闭" : function(){
	        		$(this).dialog("close");
	   			}
			},
			shouldEmptyHtml:false
		});
    }else{
    	if(gridName != ""){
    		actionUrl=actionUrl+"?"+$.param($("#"+gridName).getPostData());
    	}
    	var htmlIF = "<iframe style='display: none;' src='"+actionUrl+"'></iframe>";
    	$("body").append(htmlIF);
    }
}
$.fn.issueFlow = function(option){
	var self=$(this);
	var selfId=self.attr("id");
	var dfop={
		data:[],
		stepHeight:200,
		stepWidth:200
    }
    $.extend(dfop,option);
    var curColourIndex = 1, maxColourIndex = 24, nextColour = function() {
		var R,G,B;
		R = parseInt(128+Math.sin((curColourIndex*3+0)*1.3)*128);
		G = parseInt(128+Math.sin((curColourIndex*3+1)*1.3)*128);
		B = parseInt(128+Math.sin((curColourIndex*3+2)*1.3)*128);
		curColourIndex = curColourIndex + 1;
		if (curColourIndex > maxColourIndex) curColourIndex = 1;
		return "rgb(" + R + "," + G + "," + B + ")";
	};	
    this.PopData=[];
	this.popup=function(options){
		var that=this;
		var dfop={
			top:0,
			left:0,
			url:''
		};
		$.extend(dfop,options);
		var build=function(){
			var $dom;
			var buildFlag=true;
			if($("#holderBoxPop")[0]){
				$dom=$("#holderBoxPop");
			}else{
				$dom=$('<div class="raphaelTips" id="holderBoxPop"><a href="javascript:;" class="tip-close">关闭</a><div class="raphaelTips-text"></div><div class="raphaelTips-angle diamond"></div></div>');
				$dom.find(".tip-close").click(function(){
					$("#holderBoxPop").fadeOut(300);
				})
				$dom.appendTo("body");
			}
			var $popContent=$("#holderBoxPop").find(".raphaelTips-text").empty();;
			var thisData;
			var opts = {
			  lines: 10,
			  length: 10,
			  width: 5,
			  radius: 5,
			  corners: 1, 
			  rotate: 0, 
			  direction: 1,
			  color: '#999',
			  speed: 1,
			  trail: 100,
			  shadow: false,
			  hwaccel: false,
			  className: 'spinner',
			  zIndex: 2e9,
			  top: 'auto',
			  left: 'auto' 
			};
			$("#holderBoxPop").show().animate({
				top:$(dfop.thatDom[0]).offset().top-dfop.thatDom.height()-110,
				left:$(dfop.thatDom[0]).offset().left+dfop.thatDom.width()/2-130
			},50);
			$("#holderBoxPop").click(function(event){
				event.stopPropagation();
			})
			for(var i=0;i<that.PopData.length;i++){
				if(that.PopData[i].id==dfop.thatDom.data("id")){
					thisData=that.PopData[i];
					buildFlag=false;
				}
			}
			if(dfop.url!='' && buildFlag==true){
				var spinner = new Spinner(opts).spin($popContent[0]);
				$.ajax({
					url:dfop.url,
					success:function(data){
						$popContent.html(data);
						thisData={id:dfop.thatDom.data("id"),data:''}
						thisData.data=data;
						that.PopData.push(thisData);
					}
				})
			}else{
				$popContent.html(thisData.data);
			}
			$(document).one("click",function(){
				$("#holderBoxPop").hide();
			});
			$(".issueRight").scroll(function(){
				$("#holderBoxPop").hide();
			})
		}()
	};
	this.build=function(data){
    	var stepHeight=dfop.stepHeight+10;
    	var stepWidth=dfop.stepWidth;
    	var $stepBox='';
    	var domData=new Array();
    	var maxOrgLevel=0;
    	for(var i=0;i<data.length;i++){
	    	var bool=true;
	    	var indexBool=true;
	    	if(maxOrgLevel<data[i].orgLevelInternalId){
	    		maxOrgLevel=data[i].orgLevelInternalId
	    	}
			for(var j=0;j<domData.length;j++){
				if(data[i].orgId==domData[j].orgId){bool=false;}
				
			}
			if(bool==true){
				var index=0;
				for(var j=0;j<domData.length;j++){
					if(data[i].orgLevelInternalId==domData[j].orgLevelInternalId){
						index++;
					}
				}
				data[i].index=index;
				domData.push(data[i]);
			}
	    }
		for(var i=0;i<domData.length;i++){
			var top=(maxOrgLevel/10-(domData[i].orgLevelInternalId/10))*stepHeight;
			var left=(stepWidth+250)*domData[i].index;
			var thisStep='<div class="step" style="top:'+top+'px;left:'+left+'px;" id="'+selfId+'step'+domData[i].orgId+'" data-id="'+domData[i].id+'" data-orgid='+domData[i].orgId+'>'+'<span class="name">'+domData[i].name+'</span>'+'</div>';
			$stepBox=$stepBox+thisStep;
		}
		self.append($stepBox);
    };
    this.connect = function(data){
    	this.connects=[];
	    for(var i=0;i<data.length;i++){
	    	var toStep=data[i].to;
	    	$(data).each(function(){
	    		if(this.id==toStep){
	    			toStep=this.orgId;
	    		}
	    	})
    	    if(toStep){
    	    	var connectOption={
    	    		source:selfId+"step"+data[i].orgId, 
					target:selfId+"step"+toStep, 
					ConnectionsDetachable :false,
					joinstyle:"round",
					connector:[ "StateMachine", { curviness:1 } ],
					connectorStyle:{
						lineWidth:4,
						strokeStyle:"#deea18",
						joinstyle:"round",
						outlineColor:"#EAEDEF",
						outlineWidth:2
					},
					paintStyle:{ 
						lineWidth:3,
						strokeStyle:"#c6591e",
						dashstyle:"4 2",
						joinstyle:"miter"
					},
					detachable:false,
					anchor:"", 
					endpointsOnTop:true,
					overlays:[
						["Label", {
							label :'<div class="relation" id="label_'+data[i].id+'" data-id="'+data[i].id+'" data-orgid="'+data[i].orgId+'"><div class="number">'+(i+1)+'</div>'+'<div class="text">'+data[i].relation+'</div></div>'
						}],
						["Arrow",{
							location:1,
							id:"arrow",
		                    length:14,
		                    foldback:0.8
						}]
					]
    	    	}
		    	/*if(data[i].relation=="回退"){
		    		$.extend(connectOption,{
		    			anchors:[[0.75,0,0,0],[0.75,0,0,0]]
		    		})
		    	}*/
    			var thisConnect=jsPlumb.connect(connectOption); 
    			$(thisConnect.canvas).attr("data-id",data[i].id).attr("data-orgid",data[i].orgId);
    			this.connects.push(thisConnect);
    	    }
	    }
	    /*function initStates(thisData){
    		var state='';
			for(var i=0;i<thisData.states.length;i++){//构建状态
				switch(thisData.states[i]){
					case '加急':
						state=state+'<div class="states"><img src="/resource/system/images/issue/icon_Emerignce.png" /></div>';
						break;
					case '普通督办':
						state=state+'<div class="states"><img src="/resource/system/images/issue/icon_Emerignce.png" /></div>'
						break;
					case '黄牌督办':
						state=state+'<div class="states"><img src="/resource/system/images/issue/icon_yHandle.png" /></div>'
						break;
					case '红牌督办':
						state=state+'<div class="states"><img src="/resource/system/images/issue/icon_rHandle.png" /></div>'
						break;
					case '蓝牌督办':
						state=state+'<div class="states"><img src="/resource/system/images/issue/icon_rHandle.png" /></div>'
						break;
				}
			} 
			return state;
    	}
	    for(var i=0;i<data.length;i++){
		    var state=initStates(data[i]);
		    if(state!=''){
		    	$("#issueFlowstep"+data[i].orgId).append(state);
		    }
	    }*/
	};
	this.init = function(data) {
		var that=this;
		that.build(data);
		jsPlumb.reset();
		//初始化
		jsPlumb.importDefaults({
			Endpoint : ["Dot", {radius:0.1}],
			Connector:"StateMachine",
			HoverPaintStyle : {strokeStyle:"#42a62c", lineWidth:2 },
			ConnectionOverlays : [
				["Arrow",{ 
					location:1,
					id:"arrow",
                    length:14,
                    foldback:0.8
				}]
			]
		});
        //拖动
		jsPlumb.draggable($("#"+selfId+" .step"),{
			create:function(){
				$(this).data("defaultLeft",$(this).css("left")).data("defaultTop",$(this).css("top"));
			},
			stop:function(){
				jsPlumb.animate($(this).attr("id"), {left:$(this).data("defaultLeft"), top:$(this).data("defaultTop")}, { duration:1400, easing:'easeOutBack' });
			}
		});
		
        //label点击
		$("#"+selfId).delegate(".relation","click", function(event) {
			var thatDom=$(this);
			var thisId=thatDom.data("id");
			var thisOrgId=thatDom.data("orgid");
			that.popup({thatDom:thatDom,url:"/issues/issueManage/viewIssueDealLog.action?issueMap.id="+thisId+"&issueMap.orgId="+thisOrgId});
			event.stopPropagation();
		})

		//jsPlumb.bind("jsPlumbConnection", function(connInfo, originalEvent) { 
			//that.initRelation(connInfo);
		//});
		
        jsPlumb.makeTarget($("#"+selfId+" .step"), {
			dropOptions:{ hoverClass:"dragHover" },
			anchor:"Continuous"				
		});
		$("#"+selfId+" .step").each(function(i,e) {			
			jsPlumb.makeSource($(e), {
				anchor:"Continuous",
				connectorStyle:{ strokeStyle:nextColour(), lineWidth:2 }
			});
		});
        that.connect(data);
        //jsPlumb.getAllConnections();获取所有连线
	}
	this.init(dfop.data);
	return this;
}
    
;function isUpdate(list){
	$("#update").buttonDisable();
	$("#delete").buttonDisable();
	var rowid = list.jqGrid('getGridParam','selrow');
	var row = list.jqGrid('getRowData',rowid);	
	var isupdate =  false;
	$.ajax({
		async: false,
		url: "/sentiments/sentimentsManage/isUpdate.action",
		data:{
			"issueNew.id":row.issueId
		},
		success:function(isOk){
			isupdate= isOk;
		}
	});
	if(isupdate){
		$("#update").buttonEnable();
		$("#delete").buttonEnable();
	}
}
;function isUpdate1(list){
	$("#update").buttonDisable();
	$("#delete").buttonDisable();
	var rowid = list.jqGrid('getGridParam','selrow');
	var row = list.jqGrid('getRowData',rowid);
	var isupdate1 =  false;
	$.ajax({
		async: false,
		url: "/sentiments/sentimentsManage/isUpdate1.action",
		data:{
			"issueNew.id":row.issueId
		},
		success:function(isOk){
			isupdate1= isOk;
		}
	});
	if(isupdate1){
		$("#update").buttonEnable();
		$("#delete").buttonEnable();
	}
}
$.fn.extend({
	mailUtil:function(option){
		var self=$(this);
		var selfId=self.attr("id");
		var defaultOption={
			url:'',
			mailBoxUrl:'',
			subGridPostData:{},
			colModel:[],
			mailData:[],
			rowNum:15,
			datatype: "json",
			rowList:[10,15,20,30],
			viewrecords:true,
			multiselect: false,
			subGrid: true,
			jsonReader:{
				repeatitems:false,
				id:"0"
			},
			height: 'auto',
			width:'auto',
			sidx: 'id',
		    sord: "asc",
			pager: '#'+$(this).attr("id")+'Pager',
			page:1,
			showColModelButton:false,
			subGridRowExpanded: function(subgrid_id, row_id) {
			},
			subGridRowColapsed: function(subgrid_id, row_id) {
			},
			ondblClickRow : function(rowid){
				self.toggleSubGridRow(rowid);
			},
			caption:false,
			gridComplete:function(){},
			rowSelect:function(selectValue){alert(selectValue);},
			allSelect:function(selectValue){alert(selectValue);}
		};
		var selectValue='';
		$.extend(defaultOption, option);
		mailMain(defaultOption);
		self.height(defaultOption.height);
		function mailMainInit(defaultOption){
			$.ajax({
			   type: "GET",
			   url:defaultOption.url,
			   dataType:defaultOption.datatype,
			   data:{"page":defaultOption.page,"rows":defaultOption.rowNum,"sidx":defaultOption.sidx,"sord":defaultOption.sord},
			   success: function(data){
					defaultOption.mailData=data;
					initMailRow(defaultOption);
					clickMailRow(defaultOption);
					selectAllFun(defaultOption);
					rowSelect(selectValue);
					initPager(defaultOption);
					clickSelectPage(defaultOption);
			   }
			});
		};
		function mailMain(defaultOption){
			$.ajax({
			   type: "GET",
			   url:defaultOption.url,
			   dataType:defaultOption.datatype,
			   data:{"page":defaultOption.page,"rows":defaultOption.rowNum,"sidx":defaultOption.sidx,"sord":defaultOption.sord},
			   success: function(data){
					defaultOption.mailData=data;
					self.addClass("mailBox");
					initMailThead(defaultOption);
					initMailRow(defaultOption);
					clickMailRow(defaultOption);
					selectAllFun(defaultOption);
					rowSelect(selectValue);
					initPager(defaultOption);
					clickSelectPage(defaultOption);
			   }
			});
		};
		//构建Mail头部
		function initMailThead(defaultOption){
			var colTheadId="colThead";
			var rowContentId="rowContent";
			var colNumber=defaultOption.colModel.length;
			var colModelName=eval(defaultOption.colModel);
			var colWidthNum=0;
			var colContent='';
			var colWidth=0;
			var colThead=$('<div id="'+colTheadId+'"><strong class="checkboxItem"><input type="checkbox" class="form-checkbox" id="selectAll" /><input type="checkbox" class="form-checkbox" id="canelSelectAll" style="display:none;" /></strong></div><div class="clear"></div>');
			for(var i=0;i<colNumber;i++){
				if(!colModelName[i].hidden){
					colThead.append('<span class="rowItem" sidx="'+colModelName[i].name+'" id="'+selfId+colModelName[i].name+'" style="width:'+colModelName[i].width+'px;text-align:'+colModelName[i].align+';">'+colModelName[i].label+'</span>');
					if(colModelName[i].width){
						colWidthNum++;
						colWidth=colWidth+Number(colModelName[i].width);
					}
					
				}
			};
			self.append(colThead);
			sortMail(defaultOption);
			//头部
			for(var i=0;i<colNumber;i++){
				if(!colModelName[i].hidden){
					if(!colModelName[i].width){
						$("#"+selfId+colModelName[i].name).width((self.width()-colWidth-50)/($("#"+colTheadId).find(".rowItem").length-colWidthNum));
					};
				};
			};
		}
		//构建Mail主体
		function initMailRow(defaultOption){
			var colTheadId="colThead";
			var rowContentId="rowContent";
			var colNumber=defaultOption.colModel.length;
			var colModelName=eval(defaultOption.colModel);
			var colWidthNum=0;
			var colContent='';
			var colWidth=0;
			//列宽计算
			for(var i=0;i<colNumber;i++){
				if(!colModelName[i].hidden){
					if(colModelName[i].width){
						colWidthNum++;
						colWidth=colWidth+Number(colModelName[i].width);
					}
					
				}
			};
			// row
			var rowNumber=defaultOption.mailData.rows.length;
			var rowData=defaultOption.mailData.rows;
			var rowContent=$("<div />").attr("id",rowContentId).width(defaultOption.width).height(defaultOption.height-30).css("overflow","auto");
			for(var i=0;i<rowNumber;i++){
				var rowCon=$('<div class="rowCon" id="'+rowData[i].id+'" loading="false"><strong class="checkboxItem"><input class="form-checkbox" type="checkbox" rowid="'+rowData[i].id+'" /></strong></div>');
				for(var j=0;j<colNumber;j++){
					if(!colModelName[j].hidden){//是否显示
						rowCon.append('<span class="rowItem" id=rowItem'+rowData[i].id+'-'+j+' title="'+rowData[i][colModelName[j].name]+'" style="width:'+colModelName[j].width+'px;">'+rowData[i][colModelName[j].name]+'</span>');
					};
					if(colModelName[j].formatter){//格式化
						rowData[i][colModelName[j].name]=colModelName[j].formatter;
					};
				};
				rowContent.append(rowCon);
			};
			self.append(rowContent);
			//列表样式设置

			//列表
			for(var i=0;i<rowNumber;i++){
				for(var j=0;j<colNumber;j++){
					if(!colModelName[j].hidden){
						if(!colModelName[j].width){
							$('#rowItem'+rowData[i].id+'-'+j).width((self.width()-colWidth-60)/($("#"+colTheadId).find(".rowItem").length-colWidthNum));
						};
						if(colModelName[j].align){
							$('#rowItem'+rowData[i].id+'-'+j).css("text-align",colModelName[j].align);
						};
					};
				};
			};
			clickRowScrollTop();
		};
		function sortMail(defaultOption){
			$("#colThead .rowItem").toggle(function(){
				var sidx=$(this).attr("sidx");
				$(defaultOption.pager).empty();
				$("#rowContent").remove();
				defaultOption.sidx=sidx;
				defaultOption.sord="desc";
				mailMainInit(defaultOption);
			},
			function(){
				var sidx=$(this).attr("sidx");
				$(defaultOption.pager).empty();
				$("#rowContent").remove();
				defaultOption.sidx=sidx;
				defaultOption.sord="asc";
				mailMainInit(defaultOption);
			});
		}
		//构建底部页码
		function initPager(defaultOption){
			var pageNumber=defaultOption.mailData.records/defaultOption.rowNum;
			if(pageNumber<=0){
				$(defaultOption.pager).append('');
				$(".pagePrev").bind("click",function(){
					reload(defaultOption);
				})
				return;
			};
			if(Math.floor(pageNumber)==pageNumber){
				pageNumber=Math.floor(pageNumber);
			}else{
				pageNumber=Math.floor(pageNumber)+1;
			}
			var firstPage='<input type="button" class="firstPage defaultButton" value="第一页" />';
			var lastPage='<input type="button" class="lastPage defaultButton" value="最后一页" />';
			var prevPage='<input type="button" class="prevPage defaultButton" value="上一页" />';
			var nextPage='<input type="button" class="nextPage defaultButton" value="下一页" />';
			var rowPage='<select id="rowSelect">';
			for(var i=0;i<defaultOption.rowList.length;i++){
				rowPage=rowPage+'<option value="'+defaultOption.rowList[i]+'">'+defaultOption.rowList[i]+'</option>';
			};
			rowPage=rowPage+'</select>';
			var pageInfo='<div class="pageInfo">共'+defaultOption.mailData.records+'条数据&nbsp;&nbsp;当前第'+defaultOption.page+'/'+pageNumber+'页</div>'
			var pageList='';
			$(defaultOption.pager).append(firstPage+prevPage+nextPage+lastPage+pageInfo+rowPage);
			$("#rowSelect").val(defaultOption.rowNum);
			$(".firstPage").bind("click",function(){
				if(defaultOption.page!=1){
					toPager(defaultOption,1);
					defaultOption.page=1;
				}
			});
			$(".lastPage").bind("click",function(){
				if(defaultOption.page != pageNumber){
					toPager(defaultOption,pageNumber);
					defaultOption.page=pageNumber;
				}
			});
			$(".prevPage").bind("click",function(){
				if(defaultOption.page>1){
					defaultOption.page=defaultOption.page-1;
					toPager(defaultOption,defaultOption.page);
				}
			});
			$(".nextPage").bind("click",function(){
				if(defaultOption.page!=pageNumber){
					defaultOption.page=defaultOption.page+1;
					toPager(defaultOption,defaultOption.page);
				}
			});
		};
		//复选框 点击事件
		function rowSelect(selectValue){
			$(".rowCon .form-checkbox").bind('click',function(){
				selectValue="";
				self.find(".rowCon .form-checkbox").each(function(){
					if($(this).attr("checked")==true || $(this).attr("checked")=="checked"){
						selectValue=selectValue+$(this).parent().parent().attr("id")+",";
					}
				});
				defaultOption.rowSelect(selectValue);
			})
		}
		//列表项点击展开事件
		function clickMailRow(defaultOption){
			self.find(".rowCon span").bind('click',function() {
				var selfRow=$(this).parent();
				var selfRowId=selfRow.attr("id");
				if(selfRow.attr("selected")=="true"){
					selfRow.addClass("selectRow");
					$("#mailBoxContent"+selfRowId).hide();
					selfRow.removeClass("borderTop").attr("selected","false");
				}else{
					$(".mailBoxContent").hide();
					$('.rowCon').removeClass("borderTop").removeClass("selectRow").attr("selected","false");
					selfRow.addClass("borderTop");
					if(selfRow.attr("loading")=="false"){
						selfRow.after("<div class='mailBoxContent' id=mailBoxContent"+selfRowId+"></div>").addClass("borderTop");
						$("#mailBoxContent"+selfRowId).attr("selecked","true").show();
						$("#mailBoxContent"+selfRowId).load(defaultOption.mailBoxUrl+selfRowId, function(){
							selfRow.attr("loading","true");
						});
					}
					else{
						$("#mailBoxContent"+selfRowId).show();
					}
					selfRow.attr("selected","true");
				}
			}
			);
		};
		function clickRowScrollTop(){
			//点击自动滚到当前屏
			self.find(".rowCon").bind('click',function() {
				var thisId=$(this).attr("id");
				var scrHeight=0;
				$("#rowContent").find(".rowCon").each(function(i,n){
					if($(this).attr("id")==thisId){
						return false;
					}
					scrHeight=scrHeight+$(this).height();
				});
				$("#rowContent").scrollTop(scrHeight);
			});
		}
		function clickSelectPage(defaultOption){
			$("#rowSelect").bind("change",function(){
				defaultOption.rowNum=$(this).attr("value");
				$("#rowContent").remove();
				$(defaultOption.pager).empty();
				mailMainInit(defaultOption);
			})
		};
		function selectAllFun(defaultOption){
			$("#selectAll").click(function(){
				self.find(".rowCon .form-checkbox").attr("checked",true);
				$("#canelSelectAll").attr("checked",true);
				$(this).attr("checked",true);
				$(this).hide();
				$("#canelSelectAll").show();
				selectValue='';
				self.find(".rowCon .form-checkbox").each(function(){
					selectValue=selectValue+$(this).parent().parent().attr("id")+',';
				});
				defaultOption.allSelect(selectValue);
			}
			);
			$("#canelSelectAll").click(function(){
				self.find(".rowCon .form-checkbox").attr("checked",false);
				$("#selectAll").attr("checked",false);
				$(this).attr("checked",false);
				$(this).hide();
				$("#selectAll").show();
				selectValue='';
			})
		};
		function toPager(defaultOption,pager){
			$(defaultOption.pager).empty();
			$("#rowContent").remove();
			defaultOption.page=pager;
			mailMainInit(defaultOption);
		}
	}
})
;function processMyProfileTreeOption(o,self){
	
	var defaultOption={
		shouldJugeMultizones:false, //是否把责任区作为根节点
		rootId:true,	//树的根节点ID
		allOrg:false,	//是否不通过判断orgId
		excludeRoot:false,	//树中是否包含根节点
		url:'/resourcePool/directorySettingManage/firstLoadDirectory.action',
		isLocalData:false,
		isRootSelected:true, //是否选中根节点
		isLoadDailyLogs:false,
		afterNodeExpanded:false
	};
	$.extend(defaultOption,o);
	var url=PATH+defaultOption.url;
	if(defaultOption.orgType){
		if(url.indexOf("?")==-1){
			url=url+'?orgType='+defaultOption.orgType;
		}else{
			url=url+'&orgType='+defaultOption.orgType;
		}
	}
	if(defaultOption.rootId!=false){
		if(url.indexOf("?")==-1){
			url=url+'?rootId='+defaultOption.rootId;
		}else{
			url=url+'&rootId='+defaultOption.rootId;
		}
	}
	if(defaultOption.excludeRoot){
		if(url.indexOf("?")==-1){
			url=url+'?excludeRoot='+defaultOption.excludeRoot;
		}else{
			url=url+'&excludeRoot='+defaultOption.excludeRoot;
		}
	}
	if(defaultOption.allOrg){
		if(url.indexOf("?")==-1){
			url=url+'?allOrg='+defaultOption.allOrg;
		}else{
			url=url+'&allOrg='+defaultOption.allOrg;
		}
	}
	if(defaultOption.shouldJugeMultizones){
		if(url.indexOf("?")==-1){
			url=url+'?shouldJugeMultizones=true';
		}else{
			url=url+'&shouldJugeMultizones=true';
		}
	}
	var treePanelId=self.attr("id");
	var Tree=Ext.tree;
	
	var treePanelOption={
        animate:true, 
        enableDD:false,
        containerScroll: true,
        dropConfig: {appendOnly:true},
        rootVisible : true
    };
	if(!defaultOption.isLocalData){
		treePanelOption.loader = new Tree.TreeLoader({dataUrl:url});
	}
	var treePanel = new Tree.TreePanel(treePanelId, treePanelOption);
	treePanel.on('beforeload',function(node){
		//alert(node);
		//alert(node.id);
		//alert(node.id!=(treePanelId+"-root"));
    	if(node.id!=(treePanelId+"-root")){
    		if(node.id!=(treePanelId+"myProfileDirectory-root")){
        		var param = '?parentId='+node.id;
        		if(defaultOption.orgType){
        			param = param + '&orgType=' + defaultOption.orgType;
        		}
        		treePanel.loader.dataUrl = PATH+'/resourcePool/directorySettingManage/firstLoadDirectory.action'+param;
        	}

    	}
    });  
	if(defaultOption.afterNodeExpanded){
		treePanel.on("load",defaultOption.afterNodeExpanded);
	}
    var root = new Tree.AsyncTreeNode({
    	text : '资料目录',
        draggable : false,
        id : (treePanelId+"-root"),
        leaf:false
       
    });

    treePanel.setRootNode(root);

    treePanel.render();
    
    if(!defaultOption.isLocalData){
    	root.expand(false,false,function(n){
    		root.firstChild.expand(false,false,function(){
    			if(defaultOption.isRootSelected){
    				treePanel.getSelectionModel().select(root);
    				treePanel.fireEvent("click",root);
    			}
    		})
		});
    }
	return treePanel;
}




jQuery.fn.extend({
	initMyProfileTree : function(p){
		return processMyProfileTreeOption(p,$(this));
	}
	
});



;(function(t,e){if(typeof exports=="object")module.exports=e();else if(typeof define=="function"&&define.amd)define(e);else t.Spinner=e()})(this,function(){"use strict";var t=["webkit","Moz","ms","O"],e={},i;function o(t,e){var i=document.createElement(t||"div"),o;for(o in e)i[o]=e[o];return i}function n(t){for(var e=1,i=arguments.length;e<i;e++)t.appendChild(arguments[e]);return t}var r=function(){var t=o("style",{type:"text/css"});n(document.getElementsByTagName("head")[0],t);return t.sheet||t.styleSheet}();function s(t,o,n,s){var a=["opacity",o,~~(t*100),n,s].join("-"),f=.01+n/s*100,l=Math.max(1-(1-t)/o*(100-f),t),d=i.substring(0,i.indexOf("Animation")).toLowerCase(),u=d&&"-"+d+"-"||"";if(!e[a]){r.insertRule("@"+u+"keyframes "+a+"{"+"0%{opacity:"+l+"}"+f+"%{opacity:"+t+"}"+(f+.01)+"%{opacity:1}"+(f+o)%100+"%{opacity:"+t+"}"+"100%{opacity:"+l+"}"+"}",r.cssRules.length);e[a]=1}return a}function a(e,i){var o=e.style,n,r;if(o[i]!==undefined)return i;i=i.charAt(0).toUpperCase()+i.slice(1);for(r=0;r<t.length;r++){n=t[r]+i;if(o[n]!==undefined)return n}}function f(t,e){for(var i in e)t.style[a(t,i)||i]=e[i];return t}function l(t){for(var e=1;e<arguments.length;e++){var i=arguments[e];for(var o in i)if(t[o]===undefined)t[o]=i[o]}return t}function d(t){var e={x:t.offsetLeft,y:t.offsetTop};while(t=t.offsetParent)e.x+=t.offsetLeft,e.y+=t.offsetTop;return e}var u={lines:12,length:7,width:5,radius:10,rotate:0,corners:1,color:"#000",direction:1,speed:1,trail:100,opacity:1/4,fps:20,zIndex:2e9,className:"spinner",top:"auto",left:"auto",position:"relative"};function p(t){if(typeof this=="undefined")return new p(t);this.opts=l(t||{},p.defaults,u)}p.defaults={};l(p.prototype,{spin:function(t){this.stop();var e=this,n=e.opts,r=e.el=f(o(0,{className:n.className}),{position:n.position,width:0,zIndex:n.zIndex}),s=n.radius+n.length+n.width,a,l;if(t){t.insertBefore(r,t.firstChild||null);l=d(t);a=d(r);f(r,{left:(n.left=="auto"?l.x-a.x+(t.offsetWidth>>1):parseInt(n.left,10)+s)+"px",top:(n.top=="auto"?l.y-a.y+(t.offsetHeight>>1):parseInt(n.top,10)+s)+"px"})}r.setAttribute("role","progressbar");e.lines(r,e.opts);if(!i){var u=0,p=(n.lines-1)*(1-n.direction)/2,c,h=n.fps,m=h/n.speed,y=(1-n.opacity)/(m*n.trail/100),g=m/n.lines;(function v(){u++;for(var t=0;t<n.lines;t++){c=Math.max(1-(u+(n.lines-t)*g)%m*y,n.opacity);e.opacity(r,t*n.direction+p,c,n)}e.timeout=e.el&&setTimeout(v,~~(1e3/h))})()}return e},stop:function(){var t=this.el;if(t){clearTimeout(this.timeout);if(t.parentNode)t.parentNode.removeChild(t);this.el=undefined}return this},lines:function(t,e){var r=0,a=(e.lines-1)*(1-e.direction)/2,l;function d(t,i){return f(o(),{position:"absolute",width:e.length+e.width+"px",height:e.width+"px",background:t,boxShadow:i,transformOrigin:"left",transform:"rotate("+~~(360/e.lines*r+e.rotate)+"deg) translate("+e.radius+"px"+",0)",borderRadius:(e.corners*e.width>>1)+"px"})}for(;r<e.lines;r++){l=f(o(),{position:"absolute",top:1+~(e.width/2)+"px",transform:e.hwaccel?"translate3d(0,0,0)":"",opacity:e.opacity,animation:i&&s(e.opacity,e.trail,a+r*e.direction,e.lines)+" "+1/e.speed+"s linear infinite"});if(e.shadow)n(l,f(d("#000","0 0 4px "+"#000"),{top:2+"px"}));n(t,n(l,d(e.color,"0 0 1px rgba(0,0,0,.1)")))}return t},opacity:function(t,e,i){if(e<t.childNodes.length)t.childNodes[e].style.opacity=i}});function c(){function t(t,e){return o("<"+t+' xmlns="urn:schemas-microsoft.com:vml" class="spin-vml">',e)}r.addRule(".spin-vml","behavior:url(#default#VML)");p.prototype.lines=function(e,i){var o=i.length+i.width,r=2*o;function s(){return f(t("group",{coordsize:r+" "+r,coordorigin:-o+" "+-o}),{width:r,height:r})}var a=-(i.width+i.length)*2+"px",l=f(s(),{position:"absolute",top:a,left:a}),d;function u(e,r,a){n(l,n(f(s(),{rotation:360/i.lines*e+"deg",left:~~r}),n(f(t("roundrect",{arcsize:i.corners}),{width:o,height:i.width,left:i.radius,top:-i.width>>1,filter:a}),t("fill",{color:i.color,opacity:i.opacity}),t("stroke",{opacity:0}))))}if(i.shadow)for(d=1;d<=i.lines;d++)u(d,-2,"progid:DXImageTransform.Microsoft.Blur(pixelradius=2,makeshadow=1,shadowopacity=.3)");for(d=1;d<=i.lines;d++)u(d);return n(e,l)};p.prototype.opacity=function(t,e,i,o){var n=t.firstChild;o=o.shadow&&o.lines||0;if(n&&e+o<n.childNodes.length){n=n.childNodes[e+o];n=n&&n.firstChild;n=n&&n.firstChild;if(n)n.opacity=i}}}var h=f(o("group"),{behavior:"url(#default#VML)"});if(!a(h,"transform")&&h.adj)c();else i=a(h,"animation");return p});
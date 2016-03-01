(function ($) {
	$.fn.uploadFile=function(option){
		function   GetCookie(sName){     
		    var   aCookie   =   document.cookie.split("; "); 
		    for(var i=0;i<aCookie.length;i++) {      
		        var aCrumb=aCookie[i].split("=");
		        if(sName==aCrumb[0])     
		            return unescape(aCrumb[1]);   
		    }       
		    return null;  
		}
		var self = $(this);
		var selfId=self.attr("id")
		var thisTitle=document.title;
		var rename=false;
		var fileExtBol=false;
		var flashMessage=$.flashVersion();
		var sid=GetCookie("sid");
		var returnBoo=true;
		var targetId = "";
		if($("#targetId").length>0){
			targetId  = $("#targetId").val();
		 }
		var targetType = "";
		//安全检测*.rtf;*.tar;*.vsd;*.tif;验证去除增加音频文件*.mp3;*.wma;*.wav;*.rm;*.amr;*.3gpp;
		var filenameExt='*.jpg;*.gif;*.png;*.zip;*.jpeg;*.pdf;*.pptx;*.xlsx;*.rar;*.bmp;*.xls;*.docx;*.doc;*.txt;*.ceb;*.mp3;*.wma;*.wav;*.rm;*.amr;*.3gpp';
		var defaultOption={
			queueID        : "",
			sizeLimit      : 6291456,
			selectInputId  : "",
			targetType	   : "",
			containId      : true,
			fileDataName   : 'uploadFile',  
			method 		   : "GET",
			scriptData	   : {sid:sid,isFlash:true,targetType:"",targetId:targetId},
			uploader       : PATH+'/resource/external/uploadify/uploadify.swf',
			script         : PATH+'/enclosure/enclosureUpload.action',
			cancelImg      : RESOURCE_PATH+'/resource/external/uploadify/cancel.png',
			buttonImg	   : RESOURCE_PATH+'/resource/external/uploadify/uploadButton.jpg',
			folder         : '/',
			multi          : true,
			auto           : true,
			queueSizeLimit : 10,
			maxFileUpload : 10,
			onQueueFull    :function(){
					//alert("单次文件上传，最多选择"+defaultOption.queueSizeLimit+"个文件");
					$.messageBox({message:"单次文件上传，最多选择"+defaultOption.queueSizeLimit+"个文件",level: "error"});
					return false;
				},
			removeCompleted: false,
			width : 60,
			height: 20,
			fileExt        : filenameExt,
			fileDesc       : '文档及图片',
			onSelect:function(event,ID,fileObj){
				document.getElementById(self.attr("id")+"Uploader").updateSettings("script",PATH+'/enclosure/enclosureUpload.action');
				document.title=thisTitle;
				returnBoo=true;
				$("#"+defaultOption.selectInputId+" option").each(function(){
					//修改BUG避免重复上传同一文件.
					var str=$(this).attr("value");
					str = str.replace(/,/g, "");
					if(returnBoo && str==fileObj.name){
						$.messageBox({level:'error',message:"文件不允许重名。请修改文件名后再上传"});
						//$(this).remove();
						returnBoo=false;
					};
				});
				var fileExtNumber=4;
				if(fileObj.name.substring(fileObj.name.length-5,fileObj.name.length-4)=='.'){
					fileExtNumber=5;
				}
				if(fileObj.name.substring(fileObj.name.length-3,fileObj.name.length-2)=='.'){
					fileExtNumber=3;
				}
				var flieExtName=fileObj.name.substring(fileObj.name.length-fileExtNumber,fileObj.name.length);
				var flieExtNameArr=defaultOption.fileExt.split(";");
				for(var i=0;i<flieExtNameArr.length;i++){
					if(flieExtNameArr[i]==('*'+flieExtName.toLowerCase())){
						fileExtBol=true;
					};
				};
				if(returnBoo && !fileExtBol){
					$.messageBox({level:'error',message:"该类型文件不允许上传"});
					$(this).remove();
					returnBoo = false;
				};
				if(returnBoo && $("#"+defaultOption.queueID+" .uploadifyQueueItem").size()>=defaultOption.maxFileUpload){
					$.messageBox({level:'error',message:"最多允许上传"+defaultOption.maxFileUpload+"个文件"});
					returnBoo = false;
				};
				if(returnBoo && fileObj.size>defaultOption.sizeLimit){//如果文件大小大于默认文件大小
					$.messageBox({level:'error',message:"文件不能大于"+parseInt(defaultOption.sizeLimit/1024/1024)+"M。请重新上传文件"});
					returnBoo = false;
				}
				if(returnBoo && fileObj.size<=0){
					$.messageBox({level:'error',message:"不允许上传空文件"});
					returnBoo = false;
				}
				$(".upload-panel").show();
				if(!returnBoo){
					document.getElementById(self.attr("id")+"Uploader").updateSettings("script",'');
				}
				return returnBoo;
			}
        };
		
		$.extend(defaultOption,option);
		if(flashMessage){
			$("#custom-queue").html(flashMessage);
			$("#"+selfId+"Uploader").remove();
		}
		var events={
		  	onAllComplete  : function(event,data) {
			  	var size=$("#"+defaultOption.queueID).attr("totalSize");
			  	if(size==undefined){
			  		$("#"+defaultOption.queueID).attr("totalSize",data.allBytesLoaded);
			  	}else{
			  		$("#"+defaultOption.queueID).attr("totalSize",(parseInt(size)+data.allBytesLoaded));
			  	}
			  	if(option.onAllComplete){
			  		option.onAllComplete.call(null,event,data);
			  	}
			  	//wangxiaohu add 20140504 用户行为分析 文件上传统计功能添加 wsmalltiger@163.com
			  	if(self.attr('UBA_TABLE_ID') != null && self.attr('UBA_TABLE_ID') != '' && self.attr('UBA_useTime_startTime') != null && self.attr('UBA_useTime_startTime') != ''){
			  		var _endTime = new Date().getTime() - self.attr('UBA_useTime_startTime');
			  		if(!isNaN(_endTime) && _endTime > 0){
			  			//上传文件个数:文件总大小:上传平均速度KB/s:出现错误个数
				  		var _jsonData = '{"text": "文件上传", "useTime": ' + _endTime +', "oldValue": "", "newValue": "'+ (data.filesUploaded +":"+ data.allBytesLoaded +":"+ data.speed +":"+ data.errors) + '", "writeIndex": '+ (self.attr('uba_writeIndex') == null || self.attr('uba_writeIndex') == '' ? 0 : self.attr('uba_writeIndex')) +', "tabIndex": '+$("#"+self.attr('UBA_TABLE_ID')).attr('uba_tabId_index')+"}";
				  		$("#"+self.attr('UBA_TABLE_ID')).attr('uba_trajectoryInfo', ($("#"+self.attr('UBA_TABLE_ID')).attr('uba_trajectoryInfo') == null ? '' : $("#"+self.attr('UBA_TABLE_ID')).attr('uba_trajectoryInfo')) + "," +  _jsonData);
			  		}
			  	}
			  	//wangxiaohu end
			},
			onComplete	: function(e,queueId,fileObj,response,data){
				if(response=="false"){
					$.messageBox({level:'error',message:"该类型文件不允许上传"});
					$("#"+self.attr("id")+queueId).remove();
					return;
				}
				$("a","#"+self.attr("id")+queueId).data("filename",fileObj.name);
				if(returnBoo && $("#"+defaultOption.selectInputId+" option").size()<=defaultOption.maxFileUpload){
					var upFileName = fileObj.name.replace(/'/g, "&apos;");//如果文件名含单引号，HTML中单引号需要转义
					if (defaultOption.containId){
						$("#"+defaultOption.selectInputId).append("<option value=',"+upFileName+"' selected></option>");
					}else{
						$("#"+defaultOption.selectInputId).append("<option value='"+upFileName+"' selected></option>");
					}
				}
				if(option.onComplete){
			  		option.onComplete.call(null,e,queueId,fileObj,response,data);
			  	}
				var queueID = $("#"+defaultOption.queueID);
				queueID.scrollTop=queueID.scrollHeight-queueID.offsetHeight;
			},
			onCancel:function(event,ID,fileObj){
				if(confirm("该操作将直接删除上传的文件，确认删除吗？")){
					
				}else{
					return false;
				}
				//var fileName=$("#"+selfId+ID).find(".fileName").text();
				var fileName=$("a","#"+selfId+ID).data("filename");
				$.ajax({
	        		url:defaultOption.removeAction,
					type:"post",
					data:{fileName: fileName},
	        		success:function(){
						if (defaultOption.containId){
							$("option[value=',"+fileName+"']",$("#"+defaultOption.selectInputId)).remove();
						}else{
							$("option[value='"+fileName+"']",$("#"+defaultOption.selectInputId)).remove();
						}
	        		}
	        	});
			}
		};
		if(option.targetType != null || option.targetType != ""){
			defaultOption.scriptData.targetType=option.targetType;//反填
			targetType = option.targetType;//反填
		}
		$.extend(defaultOption,events);
		self.uploadify(defaultOption); 
		var settings=jQuery(this).data('settings');
		if(settings==null){
			settings = defaultOption;
		}
		self.unbind("uploadifySelectOnce").bind("uploadifySelectOnce", {'action': settings.onSelectOnce}, function(event, data) {
			if($("#"+defaultOption.selectInputId+" option").size()>=defaultOption.maxFileUpload){
				return false;
			}
			event.data.action(event, data);
			if (settings.auto) {
				if (settings.checkScript) { 
					jQuery(this).uploadifyUpload(null, false);
				} else {
					jQuery(this).uploadifyUpload(null, true);
				}
			}
		});
		document.title=thisTitle;
		$("#"+selfId+"Uploader").attr("title","仅支持JPG、GIF、PNG、ZIP、JPEG、PDF、PPTX、XLSX、RAR、BMP、XLS、DOCX、DOC、TXT、CEB、MP3、WMA、WAV、RM格式的文件").css({"margin":"5px 0"});
	};
	
	$.fn.addUploadFileValue = function(option){
		var self = $(this);
		function removeItem(id){
			$("#item"+self.attr("id")+id).remove();
		};
		var defaultOption={
			filename:"",
			filesize:"",
			id:"",
			link:"javascript:void(0)",
			showCloseButton:true,
			onRemove:function(id){}
		};
		$.extend(defaultOption,option);
		if(option.onRemove){
			defaultOption.onRemove=function(){
				option.onRemove.call(null,defaultOption.id);
			};
		};
		var fileSizeMsg="";
		if(defaultOption.filesize!=""&&defaultOption.filesize!=0){
			fileSizeMsg = '('+defaultOption.filesize+')';
		};
		if(defaultOption.showCloseButton){
			var canelHtml='<div class="cancel"><a href="javascript:void(0)" id="'+$(this).attr("id")+defaultOption.id+'"><img src="'+RESOURCE_PATH+'/resource/external/uploadify/delete.jpg" border="0"></a></div>';
		}
		else{
			var canelHtml='';
			$("#custom_file_uploadUploader").remove();
		};
		var itemHtml = '<div id="item'+self.attr("id")+defaultOption.id+'" class="uploadifyQueueItem completed">'+canelHtml+'<a href="'+defaultOption.link+'" target="_blank"><span class="fileName">'+defaultOption.filename+' '+fileSizeMsg+'</span></a></div>';
		$(this).append($(itemHtml));
		if(defaultOption.showCloseButton){
			$("#"+$(this).attr("id")+defaultOption.id).click(function(){
				if(confirm("该操作将直接删除上传的文件，确认删除吗？")){
					
				}else{
					return false;
				}
				defaultOption.onRemove(defaultOption.id);
				removeItem(defaultOption.id);
			})
		};
	}
	
	$.fn.getTotalUploadFiles = function(){
		
	}
	
	$.fn.getTotalUploadSize = function(){
		return $(this).attr("totalSize");
	}
	$.flashVersion=function(){
		var f;
		var up=false;
		var p = navigator.plugins;
        if (p && p.length) {
            for (var i = 0; i < p.length; i++) {
                if (p[i].name.indexOf('Shockwave Flash') > -1) {
                    if(p[i].description.split('Shockwave ')[1]<="Flash 6.0 r154"){
                    	//up=false;
                    }
                    break;
                }
            }
        } else if (window.ActiveXObject) {
            for (var j=9;j>=6;j--) {
                   try {   
                    var fl=eval("new ActiveXObject('ShockwaveFlash.ShockwaveFlash."+j+"');");
                    if (fl) {
                        f=j + '.0';
                        break;
                    }
                   }
                   catch(e) {}
            }
            if(f<="6.0"){
            	up=true;
            }
        }
        if(up){
        	return '<div id="flashMessage">您当前的flash版本过低，导致上传功能暂时无法使用，请<a href="http://get.adobe.com/cn/flashplayer/" target="_blank">点击这里</a>进行升级。</div>';
        }
        else{
        	return false;
        }
	}
})(jQuery);
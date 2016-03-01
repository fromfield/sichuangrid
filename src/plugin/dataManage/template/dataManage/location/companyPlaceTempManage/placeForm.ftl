<!-- 商贸场所私有 -->
<div id="privateTradeFromDiv">
	<div class="grid_4 lable-right">
		<label class="form-lb1">通道口：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.area"   maxlength="100" style="width: 99%" value='${population.area! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:100, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('通道口至少需要输入{0}个字符'),maxlength:$.format('通道口最多需要输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">小件寄存处：</label>
	</div>
	<div class="grid_8">
		<select class="form-txt" value="${population.cloakRoom!}" name="companyPlace.cloakRoom">
			<option value="">请选择</option>
			<option value="1" <#if companyPlace.cloakRoom??&&companyPlace.cloakRoom=="1">selected</#if>>是</option>
			<option value="0" <#if companyPlace.cloakRoom??&&companyPlace.cloakRoom=="0">selected</#if>>否</option>
		</select>
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">总面积：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.coveredArea"   maxlength="11" style="width: 90%" value='${population.coveredArea! }' class="form-txt {isLawful:true,number:true,min:0,max:999999999,messages:{isLawful:'您输入了非法脚本，请重新输入！',number:'总面积需要输入正数',min:'总面积需要输入正数',max:'总面积最大输入999999999'}}" />㎡
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">营业面积：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.businessArea"   maxlength="11" style="width: 90%" value='${population.businessArea! }' class="form-txt {number:true,min:0,max:999999999,messages:{number:'营业面积需要输入正数',min:'营业面积需要输入正数',max:'营业面积最大输入999999999'}}" />㎡
	</div>
	<div class='clearLine'>&nbsp;</div>
</div>
<!-- 上网服务场所私有 -->
<div id="InternetInfoFromDiv">
	<div class="grid_4 lable-right">
		<label class="form-lb1">所在派出所：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.area"   maxlength="100" style="width: 99%" value='${population.area! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:100, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('所在派出所至少需要输入{0}个字符'),maxlength:$.format('所在派出所最多需要输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">面积：</label>
	</div>
	<div class="grid_8">
				<input type="text" name="companyPlace.coveredArea"   maxlength="11" style="width: 90%" value='${population.coveredArea! }' class="form-txt {number:true,min:0,max:999999999,messages:{number:'面积需要输入正数',min:'面积需要输入正数',max:'面积最大输入999999999'}}" />㎡
	</div>
	<div class="grid_6 lable-right">
		<label class="form-lb1">宽带服务接入商：</label>
	</div>
	<div class="grid_6">
			<input type="text" name="companyPlace.generalType"   maxlength="50" style="width: 99%" value='${population.generalType! }' class="form-txt {isLawful:true,exculdeParticalChar:true,messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符'}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">现使用IP：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.nowip"   maxlength="50" style="width: 99%" value='${population.nowip! }' class="form-txt {ip:true,messages:{ip:'请输入目前在使用的ip地址，多个ip用逗号‘,’隔开'}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">电脑台数：</label>
	</div>
	<div class="grid_8">
			<input type="text" name="companyPlace.countNo"   maxlength="9" style="width: 99%" value='${population.countNo! }' class="form-txt {positiveInteger:true,maxlength:9,messages:{positiveInteger:$.format('电脑台数只能输入正整数'),maxlength:$.format('电脑台数最大输入999999999')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">接入方式：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.generalStorage"   maxlength="20" style="width: 99%" value='${population.generalStorage! }'  class="form-txt {isLawful:true,exculdeParticalChar:true,messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符'}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">临时上网卡数：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.networkCardNo"   maxlength="9" style="width: 99%" value='${population.networkCardNo! }' class="form-txt {positiveInteger:true,maxlength:9,messages:{positiveInteger:$.format('临时上网卡数只能输入正整数'),maxlength:$.format('临时上网卡数最大输入999999999')}}" />
	</div>
	<div class='clearLine'>&nbsp;</div>
</div>
<div id="InternetSeniorityFormDiv">
	<div class="grid_6 lable-right">
		<label class="form-lb1">网络文化经营许可证号：</label>
	</div>
	<div class="grid_18">
		<input type="text" name="companyPlace.generalManage"   maxlength="20" style="width: 99%" value='${population.generalManage! }'  class="form-txt {isLawful:true,exculdeParticalChar:true,messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符'}}" />
	</div>
	<div class='clearLine'>&nbsp;</div>
	<div class="grid_6 lable-right">
		<label class="form-lb1">网络安全审核意见书号：</label>
	</div>
	<div class="grid_18">
		<input type="text" name="companyPlace.generalMente"   maxlength="20" style="width: 99%" value='${population.generalMente! }'  class="form-txt {isLawful:true,exculdeParticalChar:true,messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符'}}" />
	</div>
	<div class='clearLine'>&nbsp;</div>
	<div class="grid_6 lable-right">
		<label class="form-lb1">消防审核意见书号：</label>
	</div>
	<div class="grid_6">
		<input type="text" title="${population.fireAuditOpinionNo!}" name="companyPlace.fireAuditOpinionNo"  maxlength="20" style="width: 99%" value='${population.fireAuditOpinionNo! }' class="form-txt {isLawful:true,exculdeParticalChar:true,messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符'}}" />
	</div>
	<div class="grid_6 lable-right">
		<label class="form-lb1">网吧编号：</label>
	</div>
	<div class="grid_6">
		<input type="text" name="companyPlace.internetBarNo"   maxlength="20" style="width: 99%" value='${population.internetBarNo! }' class="form-txt {isLawful:true,exculdeParticalChar:true,messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符'}}" />
	</div>
	<div class='clearLine'>&nbsp;</div>
</div>
<!-- 施工单位私有 -->
<div id="constructionFormDiv">
	<div class="grid_4 lable-right">
		<label class="form-lb1">施工单位：</label>
	</div>
	<div class="grid_18">
		<input type="text" name="companyPlace.area"   maxlength="100" style="width: 111%" value='${population.area! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:100, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('施工单位至少需要输入{0}个字符'),maxlength:$.format('施工单位最多需要输入{0}个字符')}}" />
	</div>
	<div class='clearLine'>&nbsp;</div>
	
	<div class="grid_4 lable-right">
			<label class="form-lb1">施工日期：</label>
		</div>
		<div class="grid_12">
			<input type="text" name="companyPlace.begintime"  readonly="readonly" maxlength="50" style="width: 45%" value="<@s.date name='population.begintime' 
	
	format='yyyy-MM-dd'/>" class="form-txt" />
			至
			<input type="text" name="companyPlace.endtime"  readonly="readonly" maxlength="50" style="width: 45%" value="<@s.date name='population.endtime' 
	
	format='yyyy-MM-dd'/>" class="form-txt" />
		</div>
	
	<div class="grid_4 lable-right">
		<label class="form-lb1">施工面积：</label>
	</div>
	<div class="grid_4">
		<input type="text" name="companyPlace.coveredArea"   maxlength="11" style="width: 78%" value='${population.coveredArea! }' class="form-txt {number:true,min:0,max:999999999,messages:{number:'施工面积需要输入正数',min:'施工面积需要输入正数',max:'施工面积最大输入999999999'}}" />㎡
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">施工挖方量：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.digVolume"   maxlength="11" style="width: 90%" value='${population.digVolume! }' class="form-txt {number:true,min:0,max:999999999,messages:{number:'施工挖方量需要输入正数',min:'施工挖方量需要输入正数',max:'施工挖方量最大输入999999999'}}" />m³
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">施工填方量：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.fillVolume"   maxlength="11" style="width: 90%" value='${population.fillVolume! }' class="form-txt {number:true,min:0,max:999999999,messages:{number:'施工填方量需要输入正数',min:'施工填方量需要输入正数',max:'施工填方量最大输入999999999'}}" />m³
	</div>
</div>
<script type="text/javascript">
jQuery.validator.addMethod("ip", function(value, element) {
    var ipAddress = /^(\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3},?)+$/;
    // var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
    if (value==""){
	     return true;
	 }
    if(value!=null && value!=""){
    	return ipAddress.test(value);
    }
    return false;
});
</script>
<!-- 教育私有 -->
<div id="eduFormDiv">
	<div class="grid_4 lable-right">
		<label class="form-lb1">校长：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.userName"    maxlength="20" style="width: 99%" value='${population.userName! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:20, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('校长至少需要输入{0}个字符'),maxlength:$.format('校长最多需要输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">联系手机：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.mobileNumber"   maxlength="11" style="width: 99%" value='${population.mobileNumber! }' class="form-txt {mobile:true,messages:{mobile:'联系手机输入只能是以1开头的11位数字'}}" title="请输入11位以1开头的联系手机  例如：13988888888" />
	</div>
</div>
<div id="eduFormInfoDiv">
	<div class="grid_4 lable-right">
		<label class="form-lb1">法制副校长：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.legalVicePrincipal"   maxlength="20" style="width: 99%" value='${population.legalVicePrincipal! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:20, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('法制副校长至少需要输入{0}个字符'),maxlength:$.format('法制副校长最多需要输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">学校性质：</label>
	</div>
	<div class="grid_8">
		<select class="form-txt" name="companyPlace.schoolNature.id">
			<@pop.OptionTag name="@com.tianque.domain.property.PropertyTypes@SCHOOL_PROPERTY" defaultValue="${(population.schoolNature.id)!}"/>
		</select>
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">学校英文名称：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.schoolNameEn"   maxlength="60" style="width: 99%" value='${population.schoolNameEn! }' class="form-txt {isLawful:true,notChinese:true,minlength:2,maxlength:60, messages:{isLawful:'您输入了非法脚本，请重新输入！',notChinese:'英文名只能输入英文!',minlength:$.format('学校英文名称至少需要输入{0}个字符'),maxlength:$.format('学校英文名称最多需要输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">电子邮箱：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.email"   maxlength="30" style="width: 99%" value='${population.email! }' class="form-txt {isLawful:true,email:true,maxlength:30, messages:{isLawful:'您输入了非法脚本，请重新输入！',email:'电子邮箱格式输入有误!',maxlength:$.format('最多只能输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">学校网址：</label>
	</div>
	<div class="grid_18">
		<input type="text" name="companyPlace.schoolWebSite"   maxlength="30" style="width: 111%" value='${population.schoolWebSite! }' class="form-txt {isLawful:true,url:true,maxlength:30, messages:{isLawful:'您输入了非法脚本，请重新输入！',url:'网址输入有误!',maxlength:$.format('最多只能输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">周边情况：</label>
	</div>
	<div class="grid_18">
		<input type="text" name="companyPlace.area"   maxlength="100" style="width: 111%" value='${population.area! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:100, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('周边情况至少需要输入{0}个字符'),maxlength:$.format('周边情况最多需要输入{0}个字符')}}" />
	</div>
</div>
<!-- 医疗卫生私有 -->
<div id="hospitalFormDiv">
	<div class="grid_4 lable-right">
		<label class="form-lb1">电子邮箱：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.email"   maxlength="30" style="width: 99%" value='${population.email! }' class="form-txt {isLawful:true,email:true,maxlength:30, messages:{isLawful:'您输入了非法脚本，请重新输入！',email:'电子邮箱格式输入有误!',maxlength:$.format('最多只能输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">医院性质：</label>
	</div>
	<div class="grid_8">
		<select class="form-txt"  name="companyPlace.hospitalNature.id">
			 <@pop.OptionTag name="@com.tianque.domain.property.PropertyTypes@HOSPITALS_KIND" defaultValue="${(population.hospitalNature.id)!}"/>
		</select>
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">所属单位：</label>
	</div>
	<div class="grid_18">
		<input type="text" name="companyPlace.area"   maxlength="100" style="width: 111%" value='${population.area! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:100, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('所属单位至少需要输入{0}个字符'),maxlength:$.format('所属单位最多需要输入{0}个字符')}}" />
	</div>
</div>
<!-- 危险品存放单位 私有 -->
<div id="dangerousFormDiv">
	<div class="grid_4 lable-right">
		<label class="form-lb1">存储设备：</label>
	</div>
	<div class="grid_18">
		<input type="text" name="companyPlace.generalStorage"   maxlength="50" style="width: 111%" value='${population.generalStorage! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:50, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('存储设备至少需要输入{0}个字符'),maxlength:$.format('存储设备最多需要输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">副本许可范围：</label>
	</div>
	<div class="grid_18">
		<input type="text" name="companyPlace.area"   maxlength="100" title='${population.area! }' style="width: 111%" value='${population.area! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:100, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('副本许可范围至少需要输入{0}个字符'),maxlength:$.format('副本许可范围最多需要输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">货物类别：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.generalType"   maxlength="50" title='${population.generalType! }' style="width: 99%" value='${population.generalType! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:50, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('货物类别至少需要输入{0}个字符'),maxlength:$.format('货物类别最多需要输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">传真号码：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.faxNo"   maxlength="15" style="width: 99%" value='${population.faxNo! }' class="form-txt {telephone:true,messages:{telephone:'传真号码不合法，只能输数字和横杠(-)'}}" title="请输入由数字和-组成的传真号码,例如：0577-88888888"/>
	</div>
</div>
<!-- 单位-其他私有 -->
<div id="otherCompanyFormDiv">
	<div class="grid_4 lable-right">
		<label class="form-lb1">注册资本：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.registeredCapitalNo"   maxlength="11" style="width: 85%" value='${population.registeredCapitalNo! }' class="form-txt {number:true,min:0,max:999999999,messages:{number:'注册资本需要输入正数',min:'注册资本需要输入正数',max:'注册资本最大输入999999999'}}" />万元
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">经济性质：</label>
	</div>
	<div class="grid_8">
		<select class="form-txt"  name="companyPlace.economicNature.id" >
			<@pop.OptionTag name="@com.tianque.domain.property.PropertyTypes@ACTUALCOMPANY_ECONOMICNATURE" defaultValue="${(population.economicNature.id)!}"/>
		</select>
	</div>
	
	<div class="grid_4 lable-right">
		<label class="form-lb1">注册日期：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.begintime"  readonly="readonly" maxlength="50" style="width: 99%" value="<@s.date name='population.begintime' 

format='yyyy-MM-dd'/>" class="form-txt" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">有效期至：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.endtime"  readonly="readonly" maxlength="50" style="width: 99%" value="<@s.date name='population.endtime' 

format='yyyy-MM-dd'/>" class="form-txt" />
	</div>
	
	<div class="grid_4 lable-right">
		<label class="form-lb1">经营范围：</label>
	</div>
	<div class="grid_18" style="height:200%;">
		<textarea rows="3"  name="companyPlace.area"  maxlength="100" class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:100, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('经营范围至少需要输入{0}个字符'),maxlength:$.format('经营范围最多需要输入{0}个字符')}}" style="width: 111%">${population.area! }</textarea>
	</div>
	<div class='clearLine'></div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">注册地址：</label>
	</div>
	<div class="grid_18">
		<input type="text" name="companyPlace.generalStorage"   maxlength="50" style="width: 111%" value='${population.generalStorage! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:50, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('注册地址至少需要输入{0}个字符'),maxlength:$.format('注册地址最多需要输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">从业人数：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.countNo"   maxlength="9" style="width: 99%" value='${population.countNo! }' class="form-txt {positiveInteger:true,maxlength:9, messages:{positiveInteger:'请输入正整数',maxlength:$.format('从业人数最大输入999999999')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">主管部门：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.generalManage"   maxlength="50" style="width: 99%" value='${population.generalManage! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:50, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('主管部门至少需要输入{0}个字符'),maxlength:$.format('主管部门最多需要输入{0}个字符')}}" />
	</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">管理等级：</label>
	</div>
	<div class="grid_8">
		<select name="companyPlace.managementLevel.id"  class="form-txt" >
			<@pop.OptionTag name="@com.tianque.domain.property.PropertyTypes@ACTUALCOMPANY_SUPERVISORYLEVEL" defaultValue="${(population.managementLevel.id)!}"/>
		</select>
	</div> 
	<div class="grid_4 lable-right">
		<label class="form-lb1">管理部门：</label>
	</div>
	<div class="grid_8">
		<input type="text" name="companyPlace.generalMente"   maxlength="50" style="width: 99%" value='${population.generalMente! }' class="form-txt {isLawful:true,exculdeParticalChar:true,minlength:2,maxlength:50, messages:{isLawful:'您输入了非法脚本，请重新输入！',exculdeParticalChar:'不能输入非法字符',minlength:$.format('管理部门至少需要输入{0}个字符'),maxlength:$.format('管理部门最多需要输入{0}个字符')}}" />
	</div>
	<div class='clearLine'>&nbsp;</div>
	<div class="grid_4 lable-right">
		<label class="form-lb1">消防等级：</label>
	</div>
	<div class="grid_8">
		<select name="companyPlace.fireLevel.id"  class="form-txt" >
			<@pop.OptionTag name="@com.tianque.domain.property.PropertyTypes@ACTUALCOMPANY_FIREFIGHTINGLEVEL" defaultValue="${(population.fireLevel.id)!}"/>
		</select>
	</div>
	<div class='clearLine'>&nbsp;</div>
</div>
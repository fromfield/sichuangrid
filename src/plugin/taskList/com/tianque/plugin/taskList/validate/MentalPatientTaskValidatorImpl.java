package com.tianque.plugin.taskList.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tianque.core.datatransfer.dataconvert.ValidateHelper;
import com.tianque.core.validate.DomainValidator;
import com.tianque.core.validate.ValidateResult;
import com.tianque.plugin.taskList.domain.MentalPatientTask;

@Component("mentalPatientTaskValidator")
public class MentalPatientTaskValidatorImpl implements DomainValidator<MentalPatientTask> {
	@Autowired
	public ValidateHelper validateHelper;

	@Override
	public ValidateResult validate(MentalPatientTask domain) {
		ValidateResult result = new ValidateResult();
		if (domain.getName() == null) {
			result.addErrorMessage("姓名不能为空！");
		} else if (validateHelper.illegalStringLength(1, 10, domain.getName())) {
			result.addErrorMessage("姓名不能超过10个字符！");
		}
		if (domain.getPlace() == null) {
			result.addErrorMessage("地点不能为空！");
		} else if (validateHelper.illegalStringLength(1, 50, domain.getPlace())) {
			result.addErrorMessage("地点不能超过50个字符！");
		}
		if (domain.getGuardianTel() == null) {
			result.addErrorMessage("监护人电话不能为空！");
		}
		if (domain.getIsDriinked() == null) {
			result.addErrorMessage("是否服药不能为空！");
		}
//		if(domain.getHelpPeople()==null){
//			result.addErrorMessage("帮扶人员不能为空！");
//		}
		if(domain.getIdCard()!=null&&!domain.getIdCard().equals("")&&
				validateHelper.illegalIdcard(domain.getIdCard())){
			result.addErrorMessage("身份证输入不合法！");
		}
		return result;
	}
}

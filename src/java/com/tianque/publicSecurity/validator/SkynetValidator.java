package com.tianque.publicSecurity.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tianque.core.datatransfer.dataconvert.ValidateHelper;
import com.tianque.core.validate.DomainValidator;
import com.tianque.core.validate.ValidateResult;
import com.tianque.publicSecurity.domain.Skynet;

/**
 * 
 * @author
 * @date 2014-02-10 14:21:16
 */
@Component("skynetValidator")
public class SkynetValidator implements DomainValidator<Skynet> {

	@Autowired
	private ValidateHelper validateHelper;

	public void setValidateHelper(ValidateHelper validateHelper) {
		this.validateHelper = validateHelper;
	}

	@Override
	public ValidateResult validate(Skynet domain) {
		ValidateResult validateResult = new ValidateResult();
		if (validateHelper.emptyString(domain.getSkynetNo())) {
			validateResult.addErrorMessage("天网编号必须输入");
		} else if (validateHelper.illegalNumber3(domain.getSkynetNo())) {
			validateResult.addErrorMessage("天网编号只能输入3位正数");
		}
		if (!validateHelper.emptyString(domain.getAddress())
				&& validateHelper.illegalStringLength(0, 30,
						domain.getAddress())) {
			validateResult.addErrorMessage("地址只能输入0-30个字符");
		}

		return validateResult;
	}
}
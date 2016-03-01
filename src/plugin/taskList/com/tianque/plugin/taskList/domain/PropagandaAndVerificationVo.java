package com.tianque.plugin.taskList.domain;

import java.util.Date;

public class PropagandaAndVerificationVo extends PropagandaAndVerification {

	
	/**
	 * 快速查询字段
	 */
	private String fastSearchKeyWords;
	
	/**
	 * 日期搜索起始时间
	 */
	private Date occurrenceDateStart;
	
	/**
	 * 日期搜索结束时间
	 */
	private Date occurrenceDateEnd;
	
	private Long exceptionSituationId;
	
	/**
	 * 判断是否走网格配置清单查询
	 */
	private String mode;
	
	/**
	 * 登录的职能部门的网格id
	 */
	private Long funOrgId;
	/**
	 * 身份证号码
	 */
	private String idCard;
	/**
	 * 电话号码
	 */
	private String phone;

	public String getFastSearchKeyWords() {
		return fastSearchKeyWords;
	}

	public void setFastSearchKeyWords(String fastSearchKeyWords) {
		this.fastSearchKeyWords = fastSearchKeyWords;
	}

	public Date getOccurrenceDateStart() {
		return occurrenceDateStart;
	}

	public void setOccurrenceDateStart(Date occurrenceDateStart) {
		this.occurrenceDateStart = occurrenceDateStart;
	}

	public Date getOccurrenceDateEnd() {
		return occurrenceDateEnd;
	}

	public void setOccurrenceDateEnd(Date occurrenceDateEnd) {
		this.occurrenceDateEnd = occurrenceDateEnd;
	}

	public Long getExceptionSituationId() {
		return exceptionSituationId;
	}

	public void setExceptionSituationId(Long exceptionSituationId) {
		this.exceptionSituationId = exceptionSituationId;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Long getFunOrgId() {
		return funOrgId;
	}

	public void setFunOrgId(Long funOrgId) {
		this.funOrgId = funOrgId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

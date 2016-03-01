package com.tianque.baseInfo.rectificativePerson.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.tianque.baseInfo.base.domain.AttentionPopulation;
import com.tianque.core.util.BaseInfoTables;
import com.tianque.domain.PropertyDict;

@SuppressWarnings("serial")
public class RectificativePerson extends AttentionPopulation {
	public RectificativePerson() {
		setAttentionPopulationType(BaseInfoTables.RECTIFICATIVEPERSON_KEY);
	}

	/** 业务信息 */

	/** 刑法执行类别 */
	private PropertyDict executeType;
	/** 原判刑期 */
	private String penaltyTerm;
	/** 近况描述 */
	private String recentSituation;
	/** 社区矫正开始时间 */
	private Date rectifyStartDate;
	/** 社区矫正结束时间 */
	private Date rectifyEndDate;
	/** 户籍派出所 */
	// private String nativePoliceStation;

	/** 帮教人员 */
	private String helpEducator;
	/** 帮教人员电话 */
	private String educatorTelephone;
	/** 帮教人员手机号码 */
	private String educatorMobileNumber;

	private String bussinessRemark;

	/**
	 * 罪名
	 */
	private String accusation;

	private Long isRemind;
	
	/***
	 * 用于手机接口返回走访数量
	 */
	private Long interviewCount;
	/**临时代替身份证的字段**/
	private String demoIdCardNo;

	public Long getIsRemind() {
		return isRemind;
	}

	public void setIsRemind(Long isRemind) {
		this.isRemind = isRemind;
	}

	public String getBussinessRemark() {
		return bussinessRemark;
	}

	public void setBussinessRemark(String bussinessRemark) {
		this.bussinessRemark = bussinessRemark;
	}

	public PropertyDict getExecuteType() {
		return executeType;
	}

	public void setExecuteType(PropertyDict executeType) {
		this.executeType = executeType;
	}

	public String getPenaltyTerm() {
		return penaltyTerm;
	}

	public void setPenaltyTerm(String penaltyTerm) {
		this.penaltyTerm = penaltyTerm;
	}

	public String getRecentSituation() {
		return recentSituation;
	}

	public void setRecentSituation(String recentSituation) {
		this.recentSituation = recentSituation;
	}

	public String getHelpEducator() {
		return helpEducator;
	}

	public void setHelpEducator(String helpEducator) {
		this.helpEducator = helpEducator;
	}

	public String getEducatorTelephone() {
		return educatorTelephone;
	}

	public void setEducatorTelephone(String educatorTelephone) {
		this.educatorTelephone = educatorTelephone;
	}

	public String getEducatorMobileNumber() {
		return educatorMobileNumber;
	}

	public void setEducatorMobileNumber(String educatorMobileNumber) {
		this.educatorMobileNumber = educatorMobileNumber;
	}

	/*
	 * public String getNativePoliceStation() { return nativePoliceStation; }
	 * public void setNativePoliceStation(String nativePoliceStation) {
	 * this.nativePoliceStation = nativePoliceStation; }
	 */

	@JSON(format = "yyyy-MM-dd")
	public Date getRectifyStartDate() {
		return rectifyStartDate;
	}

	public void setRectifyStartDate(Date rectifyStartDate) {
		this.rectifyStartDate = rectifyStartDate;
	}

	@JSON(format = "yyyy-MM-dd")
	public Date getRectifyEndDate() {
		return rectifyEndDate;
	}

	public void setRectifyEndDate(Date rectifyEndDate) {
		this.rectifyEndDate = rectifyEndDate;
	}

	public String getAccusation() {
		return accusation;
	}

	public void setAccusation(String accusation) {
		this.accusation = accusation;
	}

	public Long getInterviewCount() {
		return interviewCount;
	}

	public void setInterviewCount(Long interviewCount) {
		this.interviewCount = interviewCount;
	}

	public String getDemoIdCardNo() {
		return demoIdCardNo;
	}

	public void setDemoIdCardNo(String demoIdCardNo) {
		this.demoIdCardNo = demoIdCardNo;
	}

	
}
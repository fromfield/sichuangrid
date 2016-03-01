package com.tianque.plugin.taskList.domain;

import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.tianque.core.base.BaseDomain;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;

/**
 * 发现安全隐患实体类
 * 
 * @author GAOHU
 *
 */
public class HiddenDanger extends BaseDomain {
	/**
	 * 用于手机接口返回被回复数量
	 */
	private long replyCount;
	/**
	 * 发现时间
	 */
	private Date discoverDate;

	/**
	 * 发现地点
	 */
	private String address;

	/**
	 * 异常类型
	 */
	private PropertyDict exceptionType;

	/**
	 * 异常情况
	 */
	private String exceptionSituation;

	private String remark;

	/**
	 * 组织机构
	 */
	private Organization organization;

	private String orgInternalCode;

	private Long ishandle;

	/**
	 * 签收建议
	 */
	private String advice;

	/**
	 * 签收时间
	 */
	private Date signDate;

	/**
	 * 签收用户
	 */
	private String signUserName;

	/**
	 * 网格员姓名
	 */
	private String cellName;
	/**
	 * 网格员电话
	 */
	private String telephone;

	/** 图像路径 */
	private String imgUrl;

	/**是否有回复*/
	private Integer hasReplay;
	/**回复时间*/
	private Date replayDate;

	public Date getReplayDate() {
		return replayDate;
	}

	public void setReplayDate(Date replayDate) {
		this.replayDate = replayDate;
	}

	/**任务清单回复列表*/
	private List<TaskListReply> taskListReplyList;

	private String[] attachFiles;
	private String attachFilesForMobile;

	/* 附件 */
	private List<TaskListAttachFile> hiddenDangerAnnexFiles;

	/**有无异常*/
	private Integer hasException;

	public Integer getHasException() {
		return hasException;
	}

	public void setHasException(Integer hasException) {
		this.hasException = hasException;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getDiscoverDate() {
		return discoverDate;
	}

	public void setDiscoverDate(Date discoverDate) {
		this.discoverDate = discoverDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PropertyDict getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(PropertyDict exceptionType) {
		this.exceptionType = exceptionType;
	}

	public String getExceptionSituation() {
		return exceptionSituation;
	}

	public void setExceptionSituation(String exceptionSituation) {
		this.exceptionSituation = exceptionSituation;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getOrgInternalCode() {
		return orgInternalCode;
	}

	public void setOrgInternalCode(String orgInternalCode) {
		this.orgInternalCode = orgInternalCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getIshandle() {
		return ishandle;
	}

	public void setIshandle(Long ishandle) {
		this.ishandle = ishandle;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getSignUserName() {
		return signUserName;
	}

	public void setSignUserName(String signUserName) {
		this.signUserName = signUserName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<TaskListAttachFile> getHiddenDangerAnnexFiles() {
		return hiddenDangerAnnexFiles;
	}

	public void setHiddenDangerAnnexFiles(List<TaskListAttachFile> hiddenDangerAnnexFiles) {
		this.hiddenDangerAnnexFiles = hiddenDangerAnnexFiles;
	}

	public String[] getAttachFiles() {
		return attachFiles;
	}

	public void setAttachFiles(String[] attachFiles) {
		this.attachFiles = attachFiles;
	}

	public String getAttachFilesForMobile() {
		return attachFilesForMobile;
	}

	public void setAttachFilesForMobile(String attachFilesForMobile) {
		this.attachFilesForMobile = attachFilesForMobile;
	}

	public Integer getHasReplay() {
		return hasReplay;
	}

	public void setHasReplay(Integer hasReplay) {
		this.hasReplay = hasReplay;
	}

	public List<TaskListReply> getTaskListReplyList() {
		return taskListReplyList;
	}

	public void setTaskListReplyList(List<TaskListReply> taskListReplyList) {
		this.taskListReplyList = taskListReplyList;
	}

	public long getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(long replyCount) {
		this.replyCount = replyCount;
	}

}

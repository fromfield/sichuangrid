package com.tianque.plugin.taskList.domain;

import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.tianque.core.base.BaseDomain;
import com.tianque.domain.Organization;

public class TermerRecord extends BaseDomain {
	private long replyCount;//用于手机接口返回被回复数量
	/** 层级 **/
	private Organization organization;
	/** 时间 **/
	private Date recordDate;
	/** 地点 **/
	private String address;
	/** 姓名 **/
	private String name;
	/** 是否在家(0不在家，1在家) **/
	private Long homeOrNot;
	/** 备注 **/
	private String mark;
	/** 网格员联系电话 **/
	private String gridMemberPhone;
	/** 签收人姓名  **/
	private String signMemberName;
	/** 签收状态 **/
	private Long status;
	/**是否有回复*/
	private Integer hasReplay;
	/**任务清单回复列表*/
	private List<TaskListReply> taskListReplyList;
	/** 签收时间 **/
	private Date signDate;
	/** 签收意见 **/
	private String attitude;
	/** 异常情况 **/
	private String exceptionSituationInfo;
	/** 附件名 **/
	private String[] attachFileNames;
	/** 附件 **/
	private List<TaskListAttachFile> taskListAttachFiles;
	/**有无异常*/
	private Integer hasException;
	/**
	 * 帮扶人员
	 */
	private String helpPeople;
	/**
	 * 身份证号码
	 */
	private String idCard;
	/**
	 * 电话号码
	 */
	private String phone;
	/***
	 * 人口信息社区矫正人员Id
	 */
	private Long termerId;

	/**回复时间*/
	private Date replayDate;

	public Date getReplayDate() {
		return replayDate;
	}

	public void setReplayDate(Date replayDate) {
		this.replayDate = replayDate;
	}

	private String createUserName;
	
	public Integer getHasException() {
		return hasException;
	}

	public void setHasException(Integer hasException) {
		this.hasException = hasException;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGridMemberPhone() {
		return gridMemberPhone;
	}

	public void setGridMemberPhone(String gridMemberPhone) {
		this.gridMemberPhone = gridMemberPhone;
	}

	public String getSignMemberName() {
		return signMemberName;
	}

	public void setSignMemberName(String signMemberName) {
		this.signMemberName = signMemberName;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getAttitude() {
		return attitude;
	}

	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}

	public String getExceptionSituationInfo() {
		return exceptionSituationInfo;
	}

	public void setExceptionSituationInfo(String exceptionSituationInfo) {
		this.exceptionSituationInfo = exceptionSituationInfo;
	}

	public Long getHomeOrNot() {
		return homeOrNot;
	}

	public void setHomeOrNot(Long homeOrNot) {
		this.homeOrNot = homeOrNot;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String[] attachFileNames) {
		this.attachFileNames = attachFileNames;
	}

	public List<TaskListAttachFile> getTaskListAttachFiles() {
		return taskListAttachFiles;
	}

	public void setTaskListAttachFiles(List<TaskListAttachFile> taskListAttachFiles) {
		this.taskListAttachFiles = taskListAttachFiles;
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

	public String getHelpPeople() {
		return helpPeople;
	}

	public void setHelpPeople(String helpPeople) {
		this.helpPeople = helpPeople;
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

	public Long getTermerId() {
		return termerId;
	}

	public void setTermerId(Long termerId) {
		this.termerId = termerId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	
}

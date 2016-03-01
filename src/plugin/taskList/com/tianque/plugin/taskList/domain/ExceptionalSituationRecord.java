package com.tianque.plugin.taskList.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.tianque.core.base.BaseDomain;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;

/**
 *异常情况实体类
 * 
 * @author GAOHU
 *
 */
public class ExceptionalSituationRecord extends BaseDomain {
	/**
	 * 用于手机接口返回被回复数量
	 */
	private long replyCount;
	/**
	 * 时间
	 */
	private Date recordDate;
	/**
	 * 地点
	 */
	private String address;

	private String orgCode;
	/**
	 * 异常情况
	 */
	private PropertyDict exceptionSituation;
	/**
	 * 组织机构
	 */
	private Organization organization;
	/**
	 * 是否签收
	 */
	private Long status;
	/**
	 * 签收时间
	 */
	private Date signDate;
	/**
	 * 签收用户
	 */
	private String signMemberName;
	/**
	 * 签收意见
	 */
	private String attitude;
	/**
	 * 网格员电话
	 */
	private String gridMemberPhone;
	/**
	 * 备注
	 */
	private String mark;
	/**是否有回复*/
	private Integer hasReplay;
	/**回复时间*/
	private Date replayDate;

	/**任务清单回复列表*/
	private List<TaskListReply> taskListReplyList;

	/* 附件 */
	private List<TaskListAttachFile> exceptionalSituationAnnexFiles = new ArrayList<TaskListAttachFile>();
	/**有无异常*/
	private Integer hasException;

	public Integer getHasException() {
		return hasException;
	}

	public void setHasException(Integer hasException) {
		this.hasException = hasException;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PropertyDict getExceptionSituation() {
		return exceptionSituation;
	}

	public void setExceptionSituation(PropertyDict exceptionSituation) {
		this.exceptionSituation = exceptionSituation;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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

	public String getSignMemberName() {
		return signMemberName;
	}

	public void setSignMemberName(String signMemberName) {
		this.signMemberName = signMemberName;
	}

	public String getAttitude() {
		return attitude;
	}

	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}

	public String getGridMemberPhone() {
		return gridMemberPhone;
	}

	public void setGridMemberPhone(String gridMemberPhone) {
		this.gridMemberPhone = gridMemberPhone;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public List<TaskListAttachFile> getExceptionalSituationAnnexFiles() {
		return exceptionalSituationAnnexFiles;
	}

	public void setExceptionalSituationAnnexFiles(
			List<TaskListAttachFile> exceptionalSituationAnnexFiles) {
		this.exceptionalSituationAnnexFiles = exceptionalSituationAnnexFiles;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Integer getHasReplay() {
		return hasReplay;
	}

	public void setHasReplay(Integer hasReplay) {
		this.hasReplay = hasReplay;
	}

	public Date getReplayDate() {
		return replayDate;
	}

	public void setReplayDate(Date replayDate) {
		this.replayDate = replayDate;
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
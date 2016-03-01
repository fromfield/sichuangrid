package com.tianque.plugin.account.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.tianque.core.base.BaseDomain;
import com.tianque.domain.Organization;

@SuppressWarnings("serial")
public class ThreeRecordsIssueLogNew extends BaseDomain {
	/** 服务办事 **/
	/** 处理目标id **/
	private Organization dealOrg;
	/** 处理用户名称 **/
	private String dealUserName;
	/** 处理时间 **/
	private Date dealTime;
	/** 处理人 电话 **/
	private String mobile;
	/** 处理类型 **/
	private Long dealType;
	/** 处理描述 **/
	private String dealDescription;
	/** 处理意见 **/
	private String content;
	/** 目标部门id **/
	private Organization targeOrg;
	/** 台账处理步骤 **/
	private ThreeRecordsIssueStep issueStep;
	/** 台账交办时 给主办部门指定的办理截止时间 **/
	private Date dealDeadline;
	/** 延期申请天数 */
	private Integer applyDate;

	private Long ledgerId;
	private int ledgerType;
	private Date completeDate;
	private Integer completeType;
	private Long dealOrgId;

	/** 交流地址 */
	private String address;
	/** 交流时间 */
	private Date exchangeDate;
	/** 是否同意呈报县委 */
	private boolean submitToCommittee;
	/* 当事人意见* */
	private String opinion;

	/** 台账办理时间 **/
	private Date operateTime;
	/** 稳定台账，参与人**/
	private String joinMen;

	public Integer getCompleteType() {
		return completeType;
	}

	public void setCompleteType(Integer completeType) {
		this.completeType = completeType;
	}

	@JSON(format = "yyyy-MM-dd")
	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	@JSON(format = "yyyy-MM-dd")
	public Date getDealDeadline() {
		return dealDeadline;
	}

	public void setDealDeadline(Date dealDeadline) {
		this.dealDeadline = dealDeadline;
	}

	public Organization getDealOrg() {
		return dealOrg;
	}

	public void setDealOrg(Organization dealOrg) {
		this.dealOrg = dealOrg;
	}

	public String getDealUserName() {
		return dealUserName;
	}

	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getDealType() {
		return dealType;
	}

	public void setDealType(Long dealType) {
		this.dealType = dealType;
	}

	public String getDealDescription() {
		return dealDescription;
	}

	public void setDealDescription(String dealDescription) {
		this.dealDescription = dealDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Organization getTargeOrg() {
		return targeOrg;
	}

	public void setTargeOrg(Organization targeOrg) {
		this.targeOrg = targeOrg;
	}

	public void setIssueStep(ThreeRecordsIssueStep issueStep) {
		this.issueStep = issueStep;
	}

	public ThreeRecordsIssueStep getIssueStep() {
		return issueStep;
	}

	public Long getDealOrgId() {
		return dealOrgId;
	}

	public void setDealOrgId(Long dealOrgId) {
		this.dealOrgId = dealOrgId;
	}

	public Integer getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Integer applyDate) {
		this.applyDate = applyDate;
	}

	public Long getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(Long ledgerId) {
		this.ledgerId = ledgerId;
	}

	public int getLedgerType() {
		return ledgerType;
	}

	public void setLedgerType(int ledgerType) {
		this.ledgerType = ledgerType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JSON(format = "yyyy-MM-dd")
	public Date getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

	public boolean isSubmitToCommittee() {
		return submitToCommittee;
	}

	public void setSubmitToCommittee(boolean submitToCommittee) {
		this.submitToCommittee = submitToCommittee;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	@JSON(format = "yyyy-MM-dd")
	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getJoinMen() {
		return joinMen;
	}

	public void setJoinMen(String joinMen) {
		this.joinMen = joinMen;
	}

}

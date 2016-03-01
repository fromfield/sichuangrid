package com.tianque.working.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.tianque.core.base.BaseDomain;
import com.tianque.core.util.BaseDomainIdEncryptUtil;
import com.tianque.domain.PropertyDict;

public class Document extends BaseDomain {
	// 主送对象
	private Long sendObjId;
	// 抄送对象
	private Long copySendObjId;
	// 文件标题
	private String title;
	// 文件号
	private String documentNo;
	// 发文状态
	private String dispatchState;
	// 发文日期
	private Date dispatchDate;
	// 转发日期
	private Date transmitDate;
	// 发文单位
	private String dispatchUnit;
	// 主题词
	private String theme;
	// 机密程度
	private PropertyDict secretDegree;
	// 紧急程度
	private PropertyDict urgentDegree;
	// 受否同步资料库
	private Boolean synchroDocs;
	// 是否有附件
	private Boolean attachFiles;
	// 内容
	private String contents;
	// 全拼
	private String fullPinyin;
	// 简拼
	private String simplePinyin;
	// 所属网格
	private Long organizationId;
	// 收文部门
	private Long orgId;
	// 签收状态
	private String signState;
	// 签收日期
	private Date signDate;
	// 签收人真是姓名
	private String signer;
	// 签收回执
	private String receiptContent;
	// 用户id
	private Long userId;
	// 阅读状态
	private Long readState;
	// 阅读时间
	private Date readDate;
	// 状态（公文查询的签收状态和发文状态）
	private Integer postObj;

	private String receiversNames;
	private String receiversNamesCopy;
	/** 主送的用户ID字符串 */
	private String sendUserIds;
	/** 抄送的用户ID字符串 */
	private String copyUserIds;
	/** 转发的审批意见 */
	private String approvalOpinion;

	
	public Integer getPostObj() {
		return postObj;
	}

	public void setPostObj(Integer postObj) {
		this.postObj = postObj;
	}

	public String getSendUserIds() {
		return sendUserIds;
	}

	public void setSendUserIds(String sendUserIds) {
		this.sendUserIds = sendUserIds;
	}

	public String getCopyUserIds() {
		return copyUserIds;
	}

	public void setCopyUserIds(String copyUserIds) {
		this.copyUserIds = copyUserIds;
	}

	public String getReceiversNames() {
		return receiversNames;
	}

	public void setReceiversNames(String receiversNames) {
		this.receiversNames = receiversNames;
	}

	public String getReceiversNamesCopy() {
		return receiversNamesCopy;
	}

	public void setReceiversNamesCopy(String receiversNamesCopy) {
		this.receiversNamesCopy = receiversNamesCopy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getDispatchState() {
		return dispatchState;
	}

	public void setDispatchState(String dispatchState) {
		this.dispatchState = dispatchState;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public String getDispatchUnit() {
		return dispatchUnit;
	}

	public void setDispatchUnit(String dispatchUnit) {
		this.dispatchUnit = dispatchUnit;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public PropertyDict getSecretDegree() {
		return secretDegree;
	}

	public void setSecretDegree(PropertyDict secretDegree) {
		this.secretDegree = secretDegree;
	}

	public PropertyDict getUrgentDegree() {
		return urgentDegree;
	}

	public void setUrgentDegree(PropertyDict urgentDegree) {
		this.urgentDegree = urgentDegree;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Boolean getSynchroDocs() {
		return synchroDocs;
	}

	public void setSynchroDocs(Boolean synchroDocs) {
		this.synchroDocs = synchroDocs;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getSigner() {
		return signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}

	public String getReceiptContent() {
		return receiptContent;
	}

	public void setReceiptContent(String receiptContent) {
		this.receiptContent = receiptContent;
	}

	public String getFullPinyin() {
		return fullPinyin;
	}

	public void setFullPinyin(String fullPinyin) {
		this.fullPinyin = fullPinyin;
	}

	public String getSimplePinyin() {
		return simplePinyin;
	}

	public void setSimplePinyin(String simplePinyin) {
		this.simplePinyin = simplePinyin;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getReadState() {
		return readState;
	}

	public void setReadState(Long readState) {
		this.readState = readState;
	}

	public Boolean getAttachFiles() {
		return attachFiles;
	}

	public void setAttachFiles(Boolean attachFiles) {
		this.attachFiles = attachFiles;
	}

	public String getSignState() {
		return signState;
	}

	public void setSignState(String signState) {
		this.signState = signState;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}


	public Long getSendObjId() {
		return sendObjId;
	}

	public void setSendObjId(Long sendObjId) {
		this.sendObjId = sendObjId;
	}

	public Long getCopySendObjId() {
		return copySendObjId;
	}

	public void setCopySendObjId(Long copySendObjId) {
		this.copySendObjId = copySendObjId;
	}

	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}

	public Date getTransmitDate() {
		return transmitDate;
	}

	public void setTransmitDate(Date transmitDate) {
		this.transmitDate = transmitDate;
	}

	public String getEncryptId() {
		return BaseDomainIdEncryptUtil.encryptDomainId(super.getId(), null,
				null);
	}

	public String getApprovalOpinion() {
		return approvalOpinion;
	}

	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}

}

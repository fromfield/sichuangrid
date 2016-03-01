package com.tianque.fourTeams.fourTeamsIssue.domain;

import com.tianque.core.base.BaseDomain;
import com.tianque.core.util.BaseDomainIdEncryptUtil;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;

public class FourTeamsIssueStandardForFunOrg extends BaseDomain {
	private Organization organization;
	private Long userLevel;
	private String orgInternalCode;
	private Integer yellowLimitAccept;// 黄牌受理时限
	private Integer yellowLimitHandle;// 黄牌处理时限
	private Integer redLimitAccept;// 红牌受理时限
	private Integer redLimitHandle;// 红牌办理时限
	private String remark;// 备注
	private PropertyDict itemName;// 项目名称

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

	public Integer getYellowLimitAccept() {
		return yellowLimitAccept;
	}

	public void setYellowLimitAccept(Integer yellowLimitAccept) {
		this.yellowLimitAccept = yellowLimitAccept;
	}

	public Integer getYellowLimitHandle() {
		return yellowLimitHandle;
	}

	public void setYellowLimitHandle(Integer yellowLimitHandle) {
		this.yellowLimitHandle = yellowLimitHandle;
	}

	public Integer getRedLimitAccept() {
		return redLimitAccept;
	}

	public void setRedLimitAccept(Integer redLimitAccept) {
		this.redLimitAccept = redLimitAccept;
	}

	public Integer getRedLimitHandle() {
		return redLimitHandle;
	}

	public void setRedLimitHandle(Integer redLimitHandle) {
		this.redLimitHandle = redLimitHandle;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public PropertyDict getItemName() {
		return itemName;
	}

	public void setItemName(PropertyDict itemName) {
		this.itemName = itemName;
	}

	public Long getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Long userLevel) {
		this.userLevel = userLevel;
	}

	public String getEncryptId() {
		return BaseDomainIdEncryptUtil.encryptDomainId(getId(), null, null);
	}
}

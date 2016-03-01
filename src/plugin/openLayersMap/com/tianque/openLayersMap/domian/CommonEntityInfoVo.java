package com.tianque.openLayersMap.domian;

import com.tianque.core.util.BaseDomainIdEncryptUtil;
import com.tianque.domain.Organization;

/**
 * 详情列表要显示的字段对象
 * 
 */
@SuppressWarnings("serial")
public class CommonEntityInfoVo extends PermissionVo {

	
	/** 模块名称 */
	private String moduleName;
	/** 模块类型 */
	private String moduleType;
	/** 图标路径 */
	private String iconUrl;
	/** 是否显示图标 */
	private Boolean isViewIcon;
	/** 绑定事件中文名称 */
	private String boundEventName;
	/** 未绑事件中文名称 */
	private String unBoundEventName;
	/** 绑定事件 */
	private Long event;
	/** 绑定事件是否有效 */
	private Boolean boundEventIsValid;
	/** 未绑事件是否有效 */
	private Boolean unBoundEventIsValid;
	/** 标题名称 */
	private String titleName;
	/** 标题Value */
	private String titleValue;
	/** 是否存在子类 */
	private Integer isHasSonClass;
	/** 详情url */
	private String detailsUrl;
	/** 经度 */
	private String lon;
	/** 纬度 */
	private String lat;
	/** 热区id */
	private String featureId;
	/** 子类id */
	private Long sonClassId;
	/** 表名 */
	private String tableName;
	/** 要显示的字段名称A */
	private String fieldNameA;
	/** 字段属性A */
	private String fieldA;
	/** 要显示的字段名称B */
	private String fieldNameB;
	/** 字段属性B */
	private String fieldB;
	/** 要显示的字段名称C */
	private String fieldNameC;
	/** 字段属性C */
	private String fieldC;
	/** 要显示的字段名称D */
	private String fieldNameD;
	/** 字段属性D */
	private String fieldD;
	/** 要显示的字段名称E */
	private String fieldNameE;
	/** 字段属性E */
	private String fieldE;
	/** gisModuleManageId */
	private Long gisModuleManageId;
	/** 搜索字段A */
	private String searchFieldA;
	/** 搜索字段B */
	private String searchFieldB;
	/** 搜索条件A中文名 */
	private String searchFieldAName;
	/** 搜索条件B中文名 */
	private String searchFieldBName;
	/** typeId */
	private String typeId;
	/** 地图区域对应组织机构 */
	private Organization organization;
	/** 地图区域坐标集合 */
	private String points;
	/** 功能类型 */
	private String functionType;
	/** 实现类型 */
	private String modeType;
	/** 所属网格字段 */
	private String orgFiled;
	
	/**要显示的详情查看内容字段名称A*/
	private String detailFieldNameA;
	
	/**详情查看内容字段属性A*/
	private String detailFieldA;
	
	/**要显示的详情查看内容字段名称B*/
	private String detailFieldNameB;
	
	/**详情查看内容字段属性B*/
	private String detailFieldB;
	
	/**要显示的详情查看内容字段名称C*/
	private String detailFieldNameC;
	
	/**详情查看内容字段属性C*/
	private String detailFieldC;
	
	/**要显示的详情查看内容字段名称D*/
	private String detailFieldNameD;
	
	/**详情查看内容字段属性D*/
	private String detailFieldD;
	
	/**要显示的详情查看内容字段名称E*/
	private String detailFieldNameE;
	
	/**详情查看内容字段属性E*/
	private String detailFieldE;
	
	/**事件日志id*/
	private Long issueLogId;
	
	/**城市部件类型 */
	private String dustbinType;
	
	/** 经度 */
	private String lon2;
	/** 纬度 */
	private String lat2;
	
	private String orgInternalCode;

	public String getLon2() {
		return lon2;
	}

	public void setLon2(String lon2) {
		this.lon2 = lon2;
	}

	public String getLat2() {
		return lat2;
	}

	public void setLat2(String lat2) {
		this.lat2 = lat2;
	}

	public Long getIssueLogId() {
		return issueLogId;
	}

	public void setIssueLogId(Long issueLogId) {
		this.issueLogId = issueLogId;
	}

	public Long getGisModuleManageId() {
		return gisModuleManageId;
	}

	public void setGisModuleManageId(Long gisModuleManageId) {
		this.gisModuleManageId = gisModuleManageId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getTitleValue() {
		return titleValue;
	}

	public void setTitleValue(String titleValue) {
		this.titleValue = titleValue;
	}

	public String getDetailsUrl() {
		return detailsUrl;
	}

	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public Long getSonClassId() {
		return sonClassId;
	}

	public void setSonClassId(Long sonClassId) {
		this.sonClassId = sonClassId;
	}

	public Boolean getIsViewIcon() {
		return isViewIcon;
	}

	public void setIsViewIcon(Boolean isViewIcon) {
		this.isViewIcon = isViewIcon;
	}

	public Integer getIsHasSonClass() {
		return isHasSonClass;
	}

	public void setIsHasSonClass(Integer isHasSonClass) {
		this.isHasSonClass = isHasSonClass;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFieldNameA() {
		return fieldNameA;
	}

	public void setFieldNameA(String fieldNameA) {
		this.fieldNameA = fieldNameA;
	}

	public String getFieldA() {
		return fieldA;
	}

	public void setFieldA(String fieldA) {
		this.fieldA = fieldA;
	}

	public String getFieldNameB() {
		return fieldNameB;
	}

	public void setFieldNameB(String fieldNameB) {
		this.fieldNameB = fieldNameB;
	}

	public String getFieldB() {
		return fieldB;
	}

	public void setFieldB(String fieldB) {
		this.fieldB = fieldB;
	}

	public String getFieldNameC() {
		return fieldNameC;
	}

	public void setFieldNameC(String fieldNameC) {
		this.fieldNameC = fieldNameC;
	}

	public String getFieldC() {
		return fieldC;
	}

	public void setFieldC(String fieldC) {
		this.fieldC = fieldC;
	}

	public String getFieldNameD() {
		return fieldNameD;
	}

	public void setFieldNameD(String fieldNameD) {
		this.fieldNameD = fieldNameD;
	}

	public String getFieldD() {
		return fieldD;
	}

	public void setFieldD(String fieldD) {
		this.fieldD = fieldD;
	}

	public String getFieldNameE() {
		return fieldNameE;
	}

	public void setFieldNameE(String fieldNameE) {
		this.fieldNameE = fieldNameE;
	}

	public String getFieldE() {
		return fieldE;
	}

	public void setFieldE(String fieldE) {
		this.fieldE = fieldE;
	}

	public String getSearchFieldA() {
		return searchFieldA;
	}

	public void setSearchFieldA(String searchFieldA) {
		this.searchFieldA = searchFieldA;
	}

	public String getSearchFieldB() {
		return searchFieldB;
	}

	public void setSearchFieldB(String searchFieldB) {
		this.searchFieldB = searchFieldB;
	}

	public String getSearchFieldAName() {
		return searchFieldAName;
	}

	public void setSearchFieldAName(String searchFieldAName) {
		this.searchFieldAName = searchFieldAName;
	}

	public String getSearchFieldBName() {
		return searchFieldBName;
	}

	public void setSearchFieldBName(String searchFieldBName) {
		this.searchFieldBName = searchFieldBName;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getBoundEventName() {
		return boundEventName;
	}

	public void setBoundEventName(String boundEventName) {
		this.boundEventName = boundEventName;
	}

	public String getUnBoundEventName() {
		return unBoundEventName;
	}

	public void setUnBoundEventName(String unBoundEventName) {
		this.unBoundEventName = unBoundEventName;
	}

	public Long getEvent() {
		return event;
	}

	public void setEvent(Long event) {
		this.event = event;
	}

	public Boolean getBoundEventIsValid() {
		return boundEventIsValid;
	}

	public void setBoundEventIsValid(Boolean boundEventIsValid) {
		this.boundEventIsValid = boundEventIsValid;
	}

	public Boolean getUnBoundEventIsValid() {
		return unBoundEventIsValid;
	}

	public void setUnBoundEventIsValid(Boolean unBoundEventIsValid) {
		this.unBoundEventIsValid = unBoundEventIsValid;
	}

	public String getFunctionType() {
		return functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	public String getModeType() {
		return modeType;
	}

	public void setModeType(String modeType) {
		this.modeType = modeType;
	}

	public String getOrgFiled() {
		return orgFiled;
	}

	public void setOrgFiled(String orgFiled) {
		this.orgFiled = orgFiled;
	}

	public String getDetailFieldNameA() {
		return detailFieldNameA;
	}

	public void setDetailFieldNameA(String detailFieldNameA) {
		this.detailFieldNameA = detailFieldNameA;
	}

	public String getDetailFieldA() {
		return detailFieldA;
	}

	public void setDetailFieldA(String detailFieldA) {
		this.detailFieldA = detailFieldA;
	}

	public String getDetailFieldNameB() {
		return detailFieldNameB;
	}

	public void setDetailFieldNameB(String detailFieldNameB) {
		this.detailFieldNameB = detailFieldNameB;
	}

	public String getDetailFieldB() {
		return detailFieldB;
	}

	public void setDetailFieldB(String detailFieldB) {
		this.detailFieldB = detailFieldB;
	}

	public String getDetailFieldNameC() {
		return detailFieldNameC;
	}

	public void setDetailFieldNameC(String detailFieldNameC) {
		this.detailFieldNameC = detailFieldNameC;
	}

	public String getDetailFieldC() {
		return detailFieldC;
	}

	public void setDetailFieldC(String detailFieldC) {
		this.detailFieldC = detailFieldC;
	}

	public String getDetailFieldNameD() {
		return detailFieldNameD;
	}

	public void setDetailFieldNameD(String detailFieldNameD) {
		this.detailFieldNameD = detailFieldNameD;
	}

	public String getDetailFieldD() {
		return detailFieldD;
	}

	public void setDetailFieldD(String detailFieldD) {
		this.detailFieldD = detailFieldD;
	}

	public String getDetailFieldNameE() {
		return detailFieldNameE;
	}

	public void setDetailFieldNameE(String detailFieldNameE) {
		this.detailFieldNameE = detailFieldNameE;
	}

	public String getDetailFieldE() {
		return detailFieldE;
	}

	public void setDetailFieldE(String detailFieldE) {
		this.detailFieldE = detailFieldE;
	}

	public String getDustbinType() {
		return dustbinType;
	}

	public void setDustbinType(String dustbinType) {
		this.dustbinType = dustbinType;
	}

	public String getOrgInternalCode() {
		return orgInternalCode;
	}

	public void setOrgInternalCode(String orgInternalCode) {
		this.orgInternalCode = orgInternalCode;
	}
	
	public String getEncryptId() {
		String orgCode = this.orgInternalCode;
		return BaseDomainIdEncryptUtil.encryptDomainId(getId(), orgCode, null);
	}
	
}

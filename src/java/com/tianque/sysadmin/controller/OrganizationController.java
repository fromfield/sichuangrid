package com.tianque.sysadmin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.tianque.controller.ControllerHelper;
import com.tianque.controller.annotation.PermissionFilter;
import com.tianque.controller.vo.OrgDataWhenAdd;
import com.tianque.controller.vo.OrganizationTreeData;
import com.tianque.controller.vo.TreeData;
import com.tianque.core.base.BaseAction;
import com.tianque.core.datatransfer.dataconvert.ValidateHelper;
import com.tianque.core.util.DateUtil;
import com.tianque.core.util.DialogMode;
import com.tianque.core.util.GridProperties;
import com.tianque.core.util.StringUtil;
import com.tianque.core.util.ThreadVariable;
import com.tianque.core.vo.ExtTreeData;
import com.tianque.core.vo.GridPage;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.Session;
import com.tianque.domain.User;
import com.tianque.domain.property.OrganizationLevel;
import com.tianque.domain.property.OrganizationType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.plugin.orgchange.service.BackupOrganizationService;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PermissionService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.sysadmin.service.impl.ReferType;

@Controller("organizationController")
@Namespace("/sysadmin/orgManage")
@Scope("prototype")
@Transactional
public class OrganizationController extends BaseAction {
	private static Logger logger = LoggerFactory
			.getLogger(OrganizationController.class);
	@Autowired
	private OrganizationDubboService organizationDubboService;
	@Autowired
	private PropertyDictService propertyDictService;
	@Autowired
	private BackupOrganizationService backupOrganizationService;
	@Autowired
	private PermissionService permissionService;
	private Organization organization;
	private Long parentId;
	private Long rootId;
	private Long id;
	private Long orgLevel;
	private Long orgType;
	private List<Organization> organizations;
	private List<Organization> childs;
	private PageInfo<Organization> pageInfo;
	private GridPage gridPage;
	private List<TreeData> treeData = new ArrayList<TreeData>();
	private List<ExtTreeData> extTreeDatas = new ArrayList<ExtTreeData>();
	private ExtTreeData extTreeData;
	private String position;
	private String operation;
	private String searchContext;
	private Long referOrgId;
	private Integer countChildren;
	private Map dispalyNames;
	private List<String> nodeIds = new ArrayList<String>();
	private String parentNodeIdsForSearch = "";
	private List<PropertyDict> orgTypes;
	private List<PropertyDict> orgLevels;
	private OrgDataWhenAdd orgDataWhenAdd;
	private boolean shouldJugeMultizones;
	private boolean excludeRoot;
	private boolean allOrg;
	private String simpleCode;
	private String newParentId;
	@Autowired
	private ValidateHelper validateHelper;
	private String fieldCode;
	private boolean initCountry = true;
	private String departmentNoF = "";
	private String departmentNoC = "";
	private String cityOrgName;
	private Map<Long, String> funOrgs;

	private Integer orgTypeInternalId;
	private Integer orgLevelInternalId;
	private Long orgFuntionalTypeId;
	private String plateName;// 党建模块组织机构树要传的参数
	private Integer number;// 用于查询特定层级组织信息
	private boolean directlySupervisor;// 用于判断是否在展现组织机构树时只显示直属上级
	private Long orgId;
	/**增加一个参数，用于三本台账的数据显示*/
	private String selectType;

	private Boolean isVillage=false;//用于判断是否是社区层级
	
	/**
	 * 为污染源改造提供的根据网格获取街道
	 */
	@Action(value = "findTownOrgInfo", results = { @Result(name = "success", type = "json", params = {
			"root", "organization", "ignoreHierarchy", "false" }) })
	public String findTownOrgInfo() throws Exception {
		if (orgId == null) {
			errorMessage = "参数错误";
			return ERROR;
		}
		organization = organizationDubboService.findTownOrgInfoByOrgId(orgId);
		return SUCCESS;
	}

	/**
	 * 党建模块如果是网格级别显示其父类，（找到父类）
	 * */
	@Action(value = "isGridChangeOrg", results = { @Result(name = "success", type = "json", params = {
			"root", "organization", "ignoreHierarchy", "false" }) })
	public String isGridChangeOrg() throws Exception {
		if (id == null || orgLevelInternalId > OrganizationLevel.VILLAGE) {
			errorMessage = "参数错误";
			return ERROR;
		}
		organization = organizationDubboService
				.getParentOrgByOrgTypeAndChildOrgId(id,
						OrganizationLevel.VILLAGE);
		organization.setOrgLevel(propertyDictService
				.getPropertyDictById(organization.getOrgLevel().getId()));
		return SUCCESS;

	}

	@Action(value = "getSimpleOrgById", results = { @Result(name = "success", type = "json", params = {
			"root", "organization", "ignoreHierarchy", "false" }) })
	public String getSimpleOrgById() throws Exception {
		if (id == null) {
			return ERROR;
		}
		organization = organizationDubboService.getSimpleOrgById(id);
		return SUCCESS;
	}

	@Action(value = "loadAllOrgTree", results = { @Result(type = "json", params = {
			"root", "extTreeDatas", "ignoreHierarchy", "false" }) })
	public String loadAllOrgTree() throws Exception {
		ajaxAllOrgsForExtTree();
		if (extTreeDatas == null || extTreeDatas.size() == 0) {
			return SUCCESS;
		}
		ExtTreeData extTreeData = extTreeDatas.get(0);
		if (!excludeRoot) {
			extTreeData.setChildren(getAllOrgChildOrgs(extTreeData.getId(),
					orgType));
		} else {
			extTreeDatas = getAllOrgChildOrgs(extTreeData.getId(), orgType);
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: ajaxAllOrgsForExtTree
	 * @Description: TODO加载allorganization数据
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wanggz
	 * @date 2014-10-22 下午02:52:31
	 */
	@Action(value = "ajaxAllOrgsForExtTree", results = { @Result(type = "json", params = {
			"root", "extTreeDatas", "ignoreHierarchy", "false",
			"excludeNullProperties", "true" }) })
	public String ajaxAllOrgsForExtTree() throws Exception {
		if (allOrg) {
			extTreeDatas.add(new OrganizationTreeData(backupOrganizationService
					.getFullAllOrgById(backupOrganizationService
							.findAllOrganizationsByParentId(null).get(0)
							.getId())));
		} else {
			extTreeDatas = getAllOrgChildOrgs(parentId, orgType);
		}
		return SUCCESS;
	}

	private List<ExtTreeData> getAllOrgChildOrgs(Long parentId, Long orgType) {
		List<ExtTreeData> extTreeDatas = new ArrayList<ExtTreeData>();
		List<Organization> organizations = null;
		if (orgType != null && orgType.longValue() == 0L) {
			organizations = backupOrganizationService
					.findAllOrgsByParentIdAndOrgTypeInternalIds(
							parentId,
							new Long[] {
									Long.valueOf(OrganizationType.ADMINISTRATIVE_REGION),
									Long.valueOf(OrganizationType.OTHER) });
			if ("213".equals(simpleCode)) {
				organizations = compareUserHasOrgRight(organizations);
			}
		} else if (orgType != null && orgType.longValue() == 1L) {
			organizations = backupOrganizationService
					.findAllFunOrgsByParentId(parentId);
		} else if (orgType != null && orgType.longValue() == 11L) {
			organizations = backupOrganizationService
					.findAllFunOrgsByParentOrgId(parentId);
		} else if (orgType != null && orgType.longValue() == 2L) {
			organizations = backupOrganizationService
					.findAllOrgsByParentIdAndOrgTypeInternalIds(
							parentId,
							new Long[] {
									Long.valueOf(OrganizationType.ADMINISTRATIVE_REGION),
									Long.valueOf(OrganizationType.OTHER),
									Long.valueOf(OrganizationType.PARTYWORK) });
		} else {
			organizations = backupOrganizationService
					.findAllOrgsByParentIdAndOrgTypeInternalIds(
							parentId,
							new Long[] {
									Long.valueOf(OrganizationType.ADMINISTRATIVE_REGION),
									Long.valueOf(OrganizationType.OTHER),
									Long.valueOf(OrganizationType.FUNCTIONAL_ORG),
									Long.valueOf(OrganizationType.PARTYWORK) });
		}
		Organization userOrganization = ThreadVariable.getOrganization();
		if (ThreadVariable.getOrganization().getOrgType() != null
				&& ThreadVariable.getOrganization().getOrgType()
						.getInternalId() == OrganizationType.FUNCTIONAL_ORG
				&& ThreadVariable.getOrganization().getParentOrg() != null) {
			userOrganization = ThreadVariable.getOrganization().getParentOrg();
		}
		for (int i = 0; i < organizations.size(); i++) {
			Organization organization = organizations.get(i);
			if (directlySupervisor
					&& userOrganization.getOrgInternalCode().indexOf(
							organization.getOrgInternalCode()) != 0
					&& organization.getOrgInternalCode().indexOf(
							userOrganization.getOrgInternalCode()) != 0) {
				continue;
			}
			organization.setOrgType(propertyDictService
					.getPropertyDictById(organization.getOrgType().getId()));
			organization.setOrgLevel(propertyDictService
					.getPropertyDictById(organization.getOrgLevel().getId()));
			if (organization.getChangeType().equals(1L)) {
				organization.setOrgName(organization.getOrgName() + "("
						+ DateUtil.formateYMD(organization.getChangeDate())
						+ "迁移)");
			} else if (organization.getChangeType().equals(2L)) {
				organization.setOrgName(organization.getOrgName() + "("
						+ DateUtil.formateYMD(organization.getChangeDate())
						+ "删除)");
			}
			extTreeDatas.add(new OrganizationTreeData(organization));
		}
		return extTreeDatas;
	}
	
	/***
	 * 三本台账，组织机构选择时，需要展示职能部门数据
	 * @return
	 * @throws Exception
	 */
	@Action(value = "getOrgSelectForThreeAccount", results = { @Result(name = "success", location = "/includes/orgSelect.jsp") })
	public String getOrgSelectForThreeAccount(){
		organization = organizationDubboService.getSimpleOrgById(id);
		if (ThreadVariable.getUser().isAdmin()) {
			childs = organizationDubboService.findChildOrgs(
					organizationDubboService.getRootOrganization().getId(), id);

			// 如果登录的用户属于职能部门 ，那么就显示该职能部门用户父组织下的所有行政职能部门数据
		} else if (ThreadVariable.getOrganization().getOrgType()
				.getInternalId() == OrganizationType.FUNCTIONAL_ORG) {

			childs = organizationDubboService.findChildOrgs(ThreadVariable
					.getOrganization().getParentOrg().getId(), id);


		} else {

			childs = organizationDubboService.findChildOrgs(ThreadVariable
					.getOrganization().getId(), id);
		}

		if (organization.getSubCount() > 0) {

			organizations = organizationDubboService
					.findOrgsByParentIdAndOrgTypeInternalIds(id, new Long[] {
							new Long(OrganizationType.ADMINISTRATIVE_REGION),
							new Long(OrganizationType.OTHER) });
			organizations.addAll(organizationDubboService.findOrganizationByParentIdAndOrgType(ThreadVariable
					.getOrganization().getParentOrg().getId(), propertyDictService
					.findPropertyDictByDomainNameAndDictDisplayName(
							OrganizationType.ORG_TYPE_KEY,
							OrganizationType.FUNCTION_KEY).getId()));
			organizations = compareUserHasOrgRight(organizations);
		} else {

			organizations = new ArrayList<Organization>();

			organizations.add(organization);
		}
		for (Organization org : organizations) {

			org.setOrgLevel(propertyDictService.getPropertyDictById(org
					.getOrgLevel().getId()));
		}
		organization.setOrgLevel(propertyDictService
				.getPropertyDictById(organization.getOrgLevel().getId()));
		return SUCCESS;
	}

	@Action(value = "orgSelectComponent", results = { @Result(name = "success", location = "/includes/orgSelect.jsp") })
	public String orgSelectComponent() throws Exception {

		organization = organizationDubboService.getSimpleOrgById(id);

		if (ThreadVariable.getUser().isAdmin()) {

			childs = organizationDubboService.findChildOrgs(
					organizationDubboService.getRootOrganization().getId(), id);

			// 如果登录的用户属于职能部门 组织树就从职能部门所在的行政单位开始显示
		} else if (ThreadVariable.getOrganization().getOrgType()
				.getInternalId() == OrganizationType.FUNCTIONAL_ORG) {

			childs = organizationDubboService.findChildOrgs(ThreadVariable
					.getOrganization().getParentOrg().getId(), id);

		} else {

			childs = organizationDubboService.findChildOrgs(ThreadVariable
					.getOrganization().getId(), id);
		}

		if (organization.getSubCount() > 0) {

			organizations = organizationDubboService
					.findOrgsByParentIdAndOrgTypeInternalIds(id, new Long[] {
							new Long(OrganizationType.ADMINISTRATIVE_REGION),
							new Long(OrganizationType.OTHER) });
			organizations = compareUserHasOrgRight(organizations);
		} else {

			organizations = new ArrayList<Organization>();

			organizations.add(organization);
		}
		for (Organization org : organizations) {

			org.setOrgLevel(propertyDictService.getPropertyDictById(org
					.getOrgLevel().getId()));
		}
		organization.setOrgLevel(propertyDictService
				.getPropertyDictById(organization.getOrgLevel().getId()));
		return SUCCESS;
	}

	private List<Organization> compareUserHasOrgRight(
			List<Organization> organizations) {
		/*
		 * if (!ThreadVariable.getUser().isAdmin()) { List<Organization>
		 * multiZones = organizationService
		 * .findMultizonesByUserId(ThreadVariable.getUser().getId()); if
		 * (multiZones == null || multiZones.size() == 0) { return
		 * organizations; } List<Organization> list = new
		 * ArrayList<Organization>(); // 当前的组织结构multZone内的 for (int i = 0; i <
		 * organizations.size(); i++) { Organization organization =
		 * organizations.get(i); int count = 0, orgInternalCodeLength =
		 * (organization .getOrgInternalCode() == null ? "" : organization
		 * .getOrgInternalCode()).split("\\.").length; if (orgInternalCodeLength
		 * != 7) { count++; } else { for (Organization multiZone : multiZones) {
		 * if (organization != null && organization.getId() != null &&
		 * organization.getId().equals( multiZone.getId())) { count++; break; }
		 * } } if (count != 0) { list.add(organization); } } organizations =
		 * list; }
		 */
		return organizations;
	}

	@Action(value = "findChildOrgs", results = { @Result(name = "success", type = "json", params = {
			"root", "childs", "ignoreHierarchy", "false" }) })
	public String findChildOrgs() throws Exception {
		if (ThreadVariable.getUser().isAdmin()) {
			childs = organizationDubboService.findChildOrgs(
					organizationDubboService.getRootOrganization().getId(), id);
		} else {
			childs = organizationDubboService.findChildOrgs(ThreadVariable
					.getOrganization().getId(), id);
		}
		return SUCCESS;
	}

	@Action(value = "getUserCityOrganizationName", results = { @Result(name = "success", type = "json", params = {
			"root", "cityOrgName", "ignoreHierarchy", "false" }) })
	public String getUserCityOrganizationName() throws Exception {
		if (ThreadVariable.getOrganization().getOrgInternalCode().split("\\.").length > 3) {
			cityOrgName = "city";
		} else {
			cityOrgName = organizationDubboService
					.getUserCityOrganizationName();
		}
		return SUCCESS;
	}

	/**
	 * 查找父节点
	 * 
	 * @return
	 */
	@Action(value = "ajaxSearchParentNodeIds", results = { @Result(name = "success", type = "json", params = {
			"root", "parentNodeIdsForSearch", "ignoreHierarchy", "false" }) })
	public String searchParentNodeIds() throws Exception {
		List<Long> ids = organizationDubboService.searchParentOrgIds(
				organization.getId(), rootId);
		fillSearchParentNodeIds(ids);
		return SUCCESS;
	}

	@Action(value = "ajaxSearchParentNodeIdsWhenRootIsTown", results = { @Result(name = "success", type = "json", params = {
			"root", "parentNodeIdsForSearch", "ignoreHierarchy", "false" }) })
	public String searchParentNodeIdsWhenRootIsTown() throws Exception {
		List<Long> ids = organizationDubboService
				.searchParentOrgIdsWhenRootIsTown(organization.getId());
		fillSearchParentNodeIds(ids);
		return SUCCESS;
	}

	private void fillSearchParentNodeIds(List<Long> ids) {

		for (int i = ids.size() - 1; i >= 0; i--) {
			if (i == ids.size() - 1) {
				parentNodeIdsForSearch = ids.get(i).toString();
			} else {
				parentNodeIdsForSearch = parentNodeIdsForSearch + "/"
						+ ids.get(i);
			}
		}
		parentNodeIdsForSearch = parentNodeIdsForSearch + "/"
				+ organization.getId();
	}

	@PermissionFilter(ename = "addOrganization")
	@Action(value = "ajaxAddOrganization", results = {
			@Result(name = "success", type = "json", params = { "root",
					"orgDataWhenAdd", "ignoreHierarchy", "false" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String addOrganization() throws Exception {
		if (organization.getParentOrg() == null
				|| organization.getParentOrg().getId() == null) {
			errorMessage = "请选择所属网格！";
			return ERROR;
		}
		organization.setDepartmentNo(departmentNoF + departmentNoC);
		String str = validateDepartmentNo();
		if (str.equals(ERROR)) {
			errorMessage = "部门编号已存在！";
			return ERROR;
		}
		organization = organizationDubboService.addOrganization(organization);
		organization.setOrgType(propertyDictService
				.getPropertyDictById(organization.getOrgType().getId()));
		organization.setOrgLevel(propertyDictService
				.getPropertyDictById(organization.getOrgLevel().getId()));
		orgDataWhenAdd = new OrgDataWhenAdd(new OrganizationTreeData(
				organization), organization);
		return SUCCESS;
	}

	@Action(value = "findMultizonesWithParentOrgNameByUserId", results = { @Result(type = "json", params = {
			"root", "organizations", "ignoreHierarchy", "false" }) })
	public String findMultizonesWithParentOrgNameByUserId() throws Exception {
		organizations = organizationDubboService
				.findMultizonesWithParentOrgNameByUserId(ThreadVariable
						.getSession().getUserId());
		return SUCCESS;
	}

	@PermissionFilter(ename = "deleteGridOrganization")
	@Action(value = "ajaxDeleteById", results = {
			@Result(name = "success", type = "json", params = { "root", "true" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String deleteById() throws Exception {
		if (ERROR.equals(checkDeleteOrgById())) {
			return ERROR;
		}
		String info = organizationDubboService.deleteOrgById(organization
				.getId());
		if (!("success".equals(info))) {
			errorMessage = info;
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "ajaxDeletegridById", results = { @Result(name = "success", type = "json", params = {
			"root", "true" }) })
	public String ajaxDeletegridById() throws Exception {
		if (ERROR.equals(checkDeleteOrgById())) {
			return ERROR;
		}
		String info = organizationDubboService.deleteOrgById(organization
				.getId());
		if (!("success".equals(info))) {
			errorMessage = info;
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "getOrgByDepartmentNo", results = { @Result(name = "success", type = "json", params = {
			"root", "organization", "ignoreHierarchy", "false",
			"excludeNullProperties", "true" }) })
	public String getOrgByDepartmentNo() throws Exception {
		organization = organizationDubboService
				.getOrgByDepartmentNo(organization.getDepartmentNo());
		return SUCCESS;
	}

	@Action(value = "orgCreateJsp", results = { @Result(name = "success", location = "/sysadmin/orgManage/orgCreateDLG.jsp") })
	public String dispatch() throws Exception {
		if (organization != null && organization.getParentOrg() != null) {

			Organization orgParent = organizationDubboService
					.getSimpleOrgById(organization.getParentOrg().getId());

			organization.setParentOrg(orgParent);

			orgParent.setOrgType(propertyDictService
					.getPropertyDictById(orgParent.getOrgType().getId()));
			organization.setOrgType(orgParent.getOrgType());

			orgParent.setOrgLevel(propertyDictService
					.getPropertyDictById(orgParent.getOrgLevel().getId()));
			organization.setOrgLevel(orgParent.getOrgLevel());
			orgLevels = propertyDictService
					.findPropertyDictByDomainNameAndInternalId(
							PropertyTypes.ORGANIZATION_LEVEL, OrganizationLevel
									.getLowerLevel(orgParent.getOrgLevel()
											.getInternalId()));
			if (!orgLevels.isEmpty()) {
				number = orgLevels.get(0).getInternalId();
			}
			getOrgTypeListWhenAdd();
		}

		return SUCCESS;
	}

	@Actions(value = {
			@Action(value = "ajaxOrganization", results = { @Result(type = "json", params = {
					"root", "organization", "ignoreHierarchy", "false" }) }),
			@Action(value = "toUpdateOrgJsp", results = { @Result(name = "success", location = "/sysadmin/orgManage/orgUpdateDLG.jsp") }),
			@Action(value = "toMoveOrgJsp", results = { @Result(name = "success", location = "/sysadmin/orgManage/orgMoveDLG.jsp") }),
			@Action(value = "toOrgDetailJsp", results = { @Result(name = "success", location = "/sysadmin/orgManage/orgDetailDLG.jsp") }) })
	public String findById() throws Exception {
		Organization loginOrganization = ThreadVariable.getOrganization();
		if (loginOrganization != null
				&& organization != null
				&& organization.getId() != null
				&& loginOrganization.getId() != null
				&& loginOrganization.getId().longValue() == organization
						.getId().longValue()) {
			organization = loginOrganization;
			dispalyNames = new HashMap<Long, String>();
			dispalyNames.put(organization.getId(), organization.getOrgName());
		} else {
			organization = organizationDubboService
					.getSimpleOrgById(organization.getId());
			dispalyNames = organizationDubboService
					.getOrganizationDisplayName(new Long[] { organization
							.getId() });
		}
		if (organization.getParentOrg() != null
				&& organization.getParentOrg().getId() != null) {
			organization.setParentOrg(organizationDubboService
					.getSimpleOrgById(organization.getParentOrg().getId()));
		}

		processOrgLevelAndOrgType();

		return SUCCESS;
	}

	private void processOrgLevelAndOrgType() throws Exception {
		organization.setOrgType(propertyDictService
				.getPropertyDictById(organization.getOrgType().getId()));
		organization.setOrgLevel(propertyDictService
				.getPropertyDictById(organization.getOrgLevel().getId()));
		if (DialogMode.EDIT_MODE.toString().equals(mode)) {
			if (organization.getSubCount().intValue() > 0) {
				orgTypes = propertyDictService
						.findPropertyDictByDomainNameAndInternalId(
								OrganizationType.ORG_TYPE_KEY,
								OrganizationType.ADMINISTRATIVE_REGION);
			} else {
				if (OrganizationLevel.GRID == organization.getOrgLevel()
						.getInternalId()) {
					orgTypes = propertyDictService
							.findPropertyDictByDomainNameAndInternalIds(
									OrganizationType.ORG_TYPE_KEY,
									new int[] {
											OrganizationType.ADMINISTRATIVE_REGION,
											OrganizationType.PARTYWORK });
				} else if (OrganizationLevel.VILLAGE == organization
						.getOrgLevel().getInternalId()) {
					orgTypes = propertyDictService
							.findPropertyDictByDomainNameAndInternalIds(
									OrganizationType.ORG_TYPE_KEY,
									new int[] {
											OrganizationType.ADMINISTRATIVE_REGION,
											OrganizationType.PARTYWORK });
				} else {
					orgTypes = propertyDictService
							.findPropertyDictByDomainNameAndInternalIds(
									OrganizationType.ORG_TYPE_KEY,
									new int[] {
											OrganizationType.ADMINISTRATIVE_REGION,
											OrganizationType.FUNCTIONAL_ORG,
											OrganizationType.PARTYWORK });
				}
			}
		}
	}

	private Organization getOrgByUserId(User user) {
		organization = organizationDubboService.getSimpleOrgById(user
				.getOrganization().getId());
		organization.setOrgType(propertyDictService
				.getPropertyDictById(organization.getOrgType().getId()));
		organization.setOrgLevel(propertyDictService
				.getPropertyDictById(organization.getOrgLevel().getId()));
		return organization;
	}

	private User getUserFromSession() throws Exception {
		Session session = ThreadVariable.getSession();
		User user = permissionService.getSimpleUserById(session.getUserId());
		return user;
	}

	@Action(value = "getFullOrgById", results = { @Result(type = "json", params = {
			"root", "organization", "ignoreHierarchy", "false" }) })
	public String getFullOrgById() throws Exception {
		organization = organizationDubboService.getFullOrgById(organization
				.getId());
		return SUCCESS;
	}

	@Action(value = "getOrgXZ", results = { @Result(name = "success", type = "json", params = {
			"root", "gridPage", "ignoreHierarchy", "false" }) })
	public String getOrgXZ() throws Exception {
		orgTypes = propertyDictService
				.findPropertyDictByDomainName(PropertyTypes.ORGANIZATION_LEVEL);
		List<PropertyDict> pdList = new ArrayList<PropertyDict>();
		if (organization != null) {
			organization = organizationDubboService
					.getSimpleOrgById(organization.getId());
			for (PropertyDict pd : orgTypes) {
				if (pd.getId() < organization.getOrgLevel().getId()) {
					pd.setSimplePinyin(organization.getId() + "_" + pd.getId());
					pdList.add(pd);
				}
			}
		}
		gridPage = new GridPage();
		gridPage.setRows(pdList);
		return SUCCESS;
	}

	@Action(value = "getOrgZN", results = { @Result(name = "success", type = "json", params = {
			"root", "gridPage", "ignoreHierarchy", "false" }) })
	public String getOrgZN() throws Exception {
		if (organization != null) {
			organizations = organizationDubboService.getOrgZN(organization
					.getId());
			gridPage = new GridPage();
			gridPage.setRows(organizations);
		}
		return SUCCESS;
	}

	/**
	 * 获取当前部门的上级部门
	 * 
	 * @return
	 */
	@Action(value = "getFullParentOrgById", results = { @Result(type = "json", params = {
			"root", "organization", "ignoreHierarchy", "false" }) })
	public String getFullParentOrgById() throws Exception {
		organization = organizationDubboService.getFullOrgById(organization
				.getId());
		if (organization != null && organization.getParentOrg() != null
				&& organization.getParentOrg().getId() != null) {
			organization = organizationDubboService.getFullOrgById(organization
					.getParentOrg().getId());
		}
		return SUCCESS;
	}

	private void isAdmin() {
		User user = ThreadVariable.getUser();
		if (user.isAdmin()) {
			allOrg = true;
		}
	}

	@Action(value = "firstLoadExtTreeData", results = { @Result(type = "json", params = {
			"root", "extTreeDatas", "ignoreHierarchy", "false" }) })
	public String firstLoadExtTreeData() throws Exception {
		// isAdmin();
		if (shouldJugeMultizones) {
			organizations = organizationDubboService
					.findMultizonesByUserId(ThreadVariable.getUser().getId());
			if (organizations.size() > 0) {
				for (int i = 0; i < organizations.size(); i++) {
					extTreeDatas.add(new OrganizationTreeData(
							organizationDubboService
									.getFullOrgById(organizations.get(i)
											.getId())));
				}
				return SUCCESS;
			}
		}
		ajaxOrgsForExtTree();
		if (extTreeDatas == null || extTreeDatas.size() == 0) {
			return SUCCESS;
		}
		ExtTreeData extTreeData = extTreeDatas.get(0);
		if (!excludeRoot) {
			extTreeData.setChildren(getChildOrgs(extTreeData.getId(), orgType));
		} else {
			extTreeDatas = getChildOrgs(extTreeData.getId(), orgType);
		}
		return SUCCESS;
	}

	/**
	 * 根据当前的网格层级ID查询该网格层级对应的省级别组织机构
	 * 
	 * @return
	 */
	@Action(value = "getOrgProvinceByOrgId", results = { @Result(type = "json", params = {
			"root", "rootId", "ignoreHierarchy", "false" }) })
	public String getOrgProvinceByOrgId() throws Exception {
		User user = ThreadVariable.getUser();
		if (user == null) {
			errorMessage = "登录超时，请重新登录";
			return ERROR;
		}
		if (!user.isAdmin()) {
			rootId = organizationDubboService
					.findProvinceOrganizationsByOrgId(
							user.getOrganization().getId()).get(0).getId();
		} else {
			rootId = user.getOrganization().getId();
		}

		return SUCCESS;
	}

	/**
	 * 根据当前OrgId查询某个层级的组织机构信息
	 * 
	 * @return
	 */
	@Action(value = "getOrgnizationByOrgId", results = { @Result(type = "json", params = {
			"root", "organization", "ignoreHierarchy", "false" }) })
	public String getOrgnizationByOrgId() throws Exception {
		User user = ThreadVariable.getUser();
		if (user == null || user.getOrganization() == null
				|| user.getOrganization().getId() == null) {
			errorMessage = "登录超时，请重新登录";
			return ERROR;
		}
		if (orgLevel == null) {
			errorMessage = "添加出错，请重试";
			return ERROR;
		}
		if (OrganizationLevel.PROVINCE == orgLevel) {// 省级
			number = OrganizationType.PROVINCE_LEVEL;
		} else if (OrganizationLevel.CITY == orgLevel) {
			number = OrganizationType.CITY_LEVEL;
		} else if (OrganizationLevel.DISTRICT == orgLevel) {
			number = OrganizationType.DISTRICT_LEVEL;
		} else if (OrganizationLevel.TOWN == orgLevel) {
			number = OrganizationType.TOWN_LEVEL;
		} else if (OrganizationLevel.VILLAGE == orgLevel) {
			number = OrganizationType.VILLAGE_LEVEL;
		} else if (OrganizationLevel.GRID == orgLevel) {
			number = OrganizationType.GRID_LEVEL;
		} else {
			errorMessage = "查询组织机构出错，请重试!";
			return ERROR;
		}
		organizations = organizationDubboService.findOrganizationByOrgIdAndNum(
				user.getOrganization().getId(), number);
		if (organizations != null && organizations.size() != 0) {
			organization = organizations.get(0);
		}
		return SUCCESS;
	}

	@Action(value = "firstLoadExtTreeDataWithCheckedBox", results = { @Result(type = "json", params = {
			"root", "extTreeDatas", "ignoreHierarchy", "false" }) })
	public String firstLoadExtTreeDataWithCheckedBox() throws Exception {
		firstLoadExtTreeData();
		if (extTreeDatas != null && extTreeDatas.size() > 0) {
			for (int i = 0; i < extTreeDatas.size(); i++) {
				ExtTreeData extTreeData = extTreeDatas.get(i);
				extTreeData.setChecked(false);
				checkChildTreeData(extTreeData);
			}
		}
		return SUCCESS;
	}

	private void checkChildTreeData(ExtTreeData extTreeData) {
		if (extTreeData.getChildren() != null
				&& extTreeData.getChildren().size() > 0) {
			for (int j = 0; j < extTreeData.getChildren().size(); j++) {
				ExtTreeData childData = extTreeData.getChildren().get(j);
				childData.setChecked(false);
				checkChildTreeData(childData);
			}
		}
	}

	@Action(value = "ajaxOrgsForExtTreeWithCheckedBox", results = { @Result(type = "json", params = {
			"root", "extTreeDatas", "ignoreHierarchy", "false" }) })
	public String ajaxOrgsForExtTreeWithCheckedBox() throws Exception {
		// isAdmin();
		ajaxOrgsForExtTree();
		if (extTreeDatas != null && extTreeDatas.size() > 0) {
			for (int i = 0; i < extTreeDatas.size(); i++) {
				ExtTreeData extTreeData = extTreeDatas.get(i);
				extTreeData.setChecked(false);
			}
		}
		return SUCCESS;
	}

	/**
	 * 异步查找组织机构树
	 * 
	 * @return
	 */
	@Action(value = "ajaxOrgsForExtTree", results = { @Result(type = "json", params = {
			"root", "extTreeDatas", "ignoreHierarchy", "false",
			"excludeNullProperties", "true" }) })
	public String ajaxOrgsForExtTree() throws Exception {
		User user = getUserFromSession();
		if (allOrg) {
			extTreeDatas
					.add(new OrganizationTreeData(organizationDubboService
							.getFullOrgById(organizationDubboService
									.findOrganizationsByParentId(null).get(0)
									.getId())));
		} else if (rootId != null) {
			extTreeDatas.add(new OrganizationTreeData(organizationDubboService
					.getFullOrgById(rootId)));
		} else if ((parentId == null || parentId == 0) && !user.isAdmin()) {
			organization = getOrgByUserId(user);
			if (orgType != null
					&& organization.getOrgType().getInternalId() == OrganizationType.FUNCTIONAL_ORG
					&& orgType.intValue() == OrganizationType.ADMINISTRATIVE_REGION) {
				organization = organizationDubboService
						.getFullOrgById(organization.getParentOrg().getId());
			}
			extTreeDatas.add(new OrganizationTreeData(organization, orgType));
		} else {
			if(StringUtil.isStringAvaliable(selectType)&&"account".equals(selectType)){
				extTreeDatas = getChildOrgs(parentId, null);
			}else{
				extTreeDatas = getChildOrgs(parentId, orgType);
			}
		}

		return SUCCESS;
	}

	@Action(value = "ajaxOrgsForExtTreeByLevel", results = { @Result(type = "json", params = {
			"root", "extTreeDatas", "ignoreHierarchy", "false",
			"excludeNullProperties", "true" }) })
	public String ajaxOrgsForExtTreeByLevel() throws Exception {
		User user = getUserFromSession();
		if (orgLevelInternalId == null) {
			this.errorMessage = "参数不正确！";
			return ERROR;
		}
		if (allOrg) {
			extTreeDatas
					.add(new OrganizationTreeData(organizationDubboService
							.getFullOrgById(organizationDubboService
									.findOrganizationsByParentId(null).get(0)
									.getId())));
		} else if (rootId != null) {
			extTreeDatas.add(new OrganizationTreeData(organizationDubboService
					.getFullOrgById(rootId)));
		} else if ((parentId == null || parentId == 0) && !user.isAdmin()) {
			organization = getOrgByUserId(user);
			if (orgType != null
					&& organization.getOrgType().getInternalId() == OrganizationType.FUNCTIONAL_ORG
					&& orgType.intValue() == OrganizationType.ADMINISTRATIVE_REGION) {
				organization = organizationDubboService
						.getFullOrgById(organization.getParentOrg().getId());
			}
			extTreeDatas.add(new OrganizationTreeData(organization, orgType));
		} else {

			if (parentId != null && parentId != 0L
					&& orgLevelInternalId != null) {
				Organization org = organizationDubboService
						.getOrgAndLevelInfo(parentId);

				List<PropertyDict> orgLevels = propertyDictService
						.findPropertyDictByDomainNameAndInternalId(
								PropertyTypes.ORGANIZATION_LEVEL,
								orgLevelInternalId);
				if (orgLevels != null && orgLevels.get(0) != null) {
					orgLevel = orgLevels.get(0).getId();
				}
				if (org != null && org.getOrgLevel() != null) {
					Long orgLevelId = org.getOrgLevel().getId();
					if (orgFuntionalTypeId == null || orgFuntionalTypeId == 0) {
						if (orgLevelId.intValue() == orgLevel.intValue()) {
							return SUCCESS;
						}
						extTreeDatas = getChildOrgsByLevel(parentId, 0L);
					} else {
						if (orgLevelId.intValue() == orgLevel.intValue()) {
							extTreeDatas = getChildOrgsByLevel(parentId, 1L);
						} else {
							extTreeDatas = getChildOrgsByLevel(parentId, 0L);
						}
					}

				}
			}

		}
		return SUCCESS;
	}

	private List<ExtTreeData> getChildOrgsByLevel(Long parentId, Long orgType) {
		List<ExtTreeData> extTreeDatas = new ArrayList<ExtTreeData>();
		List<Organization> organizations = null;
		if (orgType != null && orgType.longValue() == 0L) {
			organizations = organizationDubboService
					.findOrgsByParentIdAndOrgTypeInternalIds(
							parentId,
							new Long[] {
									Long.valueOf(OrganizationType.ADMINISTRATIVE_REGION),
									Long.valueOf(OrganizationType.OTHER) });
			if ("213".equals(simpleCode)) {
				organizations = compareUserHasOrgRight(organizations);
			}
		} else if (orgType != null && orgType.longValue() == 1L) {
			organizations = organizationDubboService
					.findOrgsByParentIdAndOrgTypeInternalIdsAndFunctionalType(
							parentId,
							new Long[] { Long
									.valueOf(OrganizationType.FUNCTIONAL_ORG) },
							orgFuntionalTypeId);
		} else if (orgType != null && orgType.longValue() == 2L) {
			organizations = organizationDubboService
					.findOrgsByParentIdAndOrgTypeInternalIds(
							parentId,
							new Long[] {
									Long.valueOf(OrganizationType.ADMINISTRATIVE_REGION),
									Long.valueOf(OrganizationType.OTHER),
									Long.valueOf(OrganizationType.PARTYWORK) });
		} else {
			organizations = organizationDubboService
					.findOrgsByParentIdAndOrgTypeInternalIds(
							parentId,
							new Long[] {
									Long.valueOf(OrganizationType.ADMINISTRATIVE_REGION),
									Long.valueOf(OrganizationType.OTHER),
									Long.valueOf(OrganizationType.FUNCTIONAL_ORG),
									Long.valueOf(OrganizationType.PARTYWORK) });
		}
		for (int i = 0; i < organizations.size(); i++) {
			Organization organization = organizations.get(i);
			organization.setOrgType(propertyDictService
					.getPropertyDictById(organization.getOrgType().getId()));
			organization.setOrgLevel(propertyDictService
					.getPropertyDictById(organization.getOrgLevel().getId()));
			extTreeDatas.add(new OrganizationTreeData(organization));
		}
		return extTreeDatas;
	}

	private List<ExtTreeData> getChildOrgs(Long parentId, Long orgType) {
		Long start = System.currentTimeMillis();
		logger.error("=============================================");
		List<ExtTreeData> extTreeDatas = new ArrayList<ExtTreeData>();
		List<Organization> organizations = null;
		if (orgType != null && orgType.longValue() == 0L) {
			organizations = organizationDubboService
					.findOrgsByParentIdAndOrgTypeInternalIds(
							parentId,
							new Long[] {
									Long.valueOf(OrganizationType.ADMINISTRATIVE_REGION),
									Long.valueOf(OrganizationType.OTHER) });
			if ("213".equals(simpleCode)) {
				organizations = compareUserHasOrgRight(organizations);
			}
		} else if (orgType != null && orgType.longValue() == 1L) {
			organizations = organizationDubboService
					.findFunOrgsByParentId(parentId);
		} else if (orgType != null && orgType.longValue() == 11L) {
			organizations = organizationDubboService
					.findFunOrgsByParentOrgId(parentId);
		} else if (orgType != null && orgType.longValue() == 2L) {
			organizations = organizationDubboService
					.findOrgsByParentIdAndOrgTypeInternalIds(
							parentId,
							new Long[] {
									Long.valueOf(OrganizationType.ADMINISTRATIVE_REGION),
									Long.valueOf(OrganizationType.OTHER),
									Long.valueOf(OrganizationType.PARTYWORK) });
		} else {
			organizations = organizationDubboService
					.findOrgsByParentIdAndOrgTypeInternalIds(
							parentId,
							new Long[] {
									Long.valueOf(OrganizationType.ADMINISTRATIVE_REGION),
									Long.valueOf(OrganizationType.OTHER),
									Long.valueOf(OrganizationType.FUNCTIONAL_ORG),
									Long.valueOf(OrganizationType.PARTYWORK) });
		}
		Organization userOrganization = ThreadVariable.getOrganization();
		if (ThreadVariable.getOrganization().getOrgType() != null
				&& ThreadVariable.getOrganization().getOrgType()
						.getInternalId() == OrganizationType.FUNCTIONAL_ORG
				&& ThreadVariable.getOrganization().getParentOrg() != null) {
			userOrganization = ThreadVariable.getOrganization().getParentOrg();
		}
		logger.error("组织机构获取耗时:" + (System.currentTimeMillis() - start));
		Long start1 = System.currentTimeMillis();
		Map<Long, PropertyDict> orgTypeMap = new HashMap<Long, PropertyDict>();
		Map<Long, PropertyDict> orgLevelMap = new HashMap<Long, PropertyDict>();
		for (int i = 0; i < organizations.size(); i++) {
			Organization organization = organizations.get(i);
			if (directlySupervisor
					&& userOrganization.getOrgInternalCode().indexOf(
							organization.getOrgInternalCode()) != 0
					&& organization.getOrgInternalCode().indexOf(
							userOrganization.getOrgInternalCode()) != 0) {
				continue;
			}
			PropertyDict orgTypeDict = orgTypeMap.get(organization.getOrgType()
					.getId());
			if (orgTypeDict == null) {
				orgTypeDict = propertyDictService
						.getPropertyDictById(organization.getOrgType().getId());
				if (orgTypeDict == null) {
					continue;
				}
				orgTypeMap.put(organization.getOrgType().getId(), orgTypeDict);
			}
			organization.setOrgType(orgTypeDict);

			PropertyDict orgLevelDict = orgLevelMap.get(organization
					.getOrgLevel().getId());
			if (orgLevelDict == null) {
				orgLevelDict = propertyDictService
						.getPropertyDictById(organization.getOrgLevel().getId());
				if (orgLevelDict == null) {
					continue;
				}
				orgLevelMap.put(organization.getOrgLevel().getId(),
						orgLevelDict);
			}
			organization.setOrgLevel(orgLevelDict);
			extTreeDatas.add(new OrganizationTreeData(organization));
		}
		logger.error("组织机构字典项填充耗时:" + (System.currentTimeMillis() - start1));
		logger.error("组织机构总耗时:" + (System.currentTimeMillis() - start));
		return extTreeDatas;
	}

	@Action(value = "findOrganizationsByParentIdAndFunctionalOrgType", results = { @Result(type = "json", params = {
			"root", "organizations", "ignoreHierarchy", "false" }) })
	public String findOrganizationsByParentIdAndFunctionalOrgType()
			throws Exception {
		organizations = organizationDubboService
				.findOrgsByParentIdAndFunTypes(parentId);
		return SUCCESS;
	}

	@Action(value = "findOrganizationsByParent", results = { @Result(type = "json", params = {
			"root", "organizations", "ignoreHierarchy", "false" }) })
	public String findOrganizationsByParent() throws Exception {
		if (parentId == null) {
			organizations = new ArrayList<Organization>();
		} else {
			organizations = organizationDubboService
					.findOrganizationsByParentId(parentId);
		}
		return SUCCESS;
	}

	@Action(value = "findFunOrgsByParentOrgId", results = { @Result(type = "json", params = {
			"root", "funOrgs", "ignoreHierarchy", "false" }) })
	public String findFunOrgsByParentOrgId() throws Exception {
		funOrgs = new HashMap<Long, String>();
		if (parentId != null) {
			organizations = organizationDubboService
					.findFunOrgsByParentOrgId(parentId);
			if (organizations != null && organizations.size() > 0) {
				for (Organization organization : organizations) {
					funOrgs.put(organization.getId(), organization.getOrgName());
				}
			}
		}
		return SUCCESS;
	}

	@Action(value = "ajaxFunOrgTree", results = { @Result(type = "json", params = {
			"root", "treeData", "ignoreHierarchy", "false" }) })
	public String ajaxFunOrgTree() throws Exception {
		boolean isRoot = false;
		if (id == null) {
			isRoot = true;
			parentId = permissionService
					.getSimpleUserById(ThreadVariable.getSession().getUserId())
					.getOrganization().getId();
		}
		if (isRoot) {
			treeData.add(new TreeData(organizationDubboService
					.getSimpleOrgById(id), isRoot));
		} else {
			organizations = organizationDubboService.findFunOrgsByParentId(id);
			for (int i = 0; i < organizations.size(); i++) {
				Organization organization = organizations.get(i);
				organization
						.setOrgType(propertyDictService
								.getPropertyDictById(organization.getOrgType()
										.getId()));
				organization.setSubCount(Long.valueOf(organizationDubboService
						.findFunOrgsByParentId(id).size()));
				treeData.add(new TreeData(organization, isRoot));
			}
		}
		return SUCCESS;
	}

	@Action(value = "ajaxOrgPage", results = { @Result(name = "success", type = "json", params = {
			"root", "gridPage", "ignoreHierarchy", "false",
			"excludeNullProperties", "true", "excludeProperties",
			"page,total,records" }) })
	public String ajaxOrgPage() throws Exception {
		gridPage = new GridPage(
				organizationDubboService.findOrganizationsByParentId(parentId));
		return SUCCESS;
	}

	@PermissionFilter(ename = "updateOrganization")
	@Action(value = "ajaxUpdateOrganization", results = { @Result(name = "success", type = "json", params = {
			"root", "organization", "ignoreHierarchy", "false",
			"excludeNullProperties", "true" }) })
	public String updateOrganization() throws Exception {
		if (validateDepartmentNo().equals("ERROR")) {
			errorMessage = "部门编号已存在！";
			return ERROR;
		}
		try {
			organization = organizationDubboService
					.updateOrgNameAndOrgTypeAndContactWay(organization);
			organization.setOrgType(propertyDictService
					.getPropertyDictById(organization.getOrgType().getId()));
		} catch (Exception e) {
			errorMessage = e.getMessage();
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "ajaxFindOrganizationsByOrgNameAndOrgType", results = { @Result(name = "success", type = "json", params = {
			"root", "organizations", "ignoreHierarchy", "false",
			"excludeNullProperties", "true" }) })
	public String findOrganizationsByOrgNameAndOrgType() throws Exception {
		organizations = organizationDubboService
				.findOrganizationsByorgNameAndOrgType(
						organization.getOrgName(), 1,
						GridProperties.ORG_TREE_AUTOCOMPLETE_SEARCH_NUM);
		if ("213".equals(simpleCode)) {
			organizations = compareUserHasOrgRight(organizations);
		}
		return SUCCESS;
	}

	@Action(value = "ajaxFindOrganizationsByOrgName", results = { @Result(name = "success", type = "json", params = {
			"root", "organizations", "ignoreHierarchy", "false",
			"excludeNullProperties", "true" }) })
	public String findOrganizationsByOrgName() throws Exception {
		try {
			organizations = organizationDubboService
					.findOrganizationsByOrgNameForPage(
							organization.getOrgName(), 1,
							GridProperties.ORG_TREE_AUTOCOMPLETE_SEARCH_NUM);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PermissionFilter(ename = "organizationManagement")
	@Action(value = "validateOrgName", results = {
			@Result(name = "success", type = "json", params = { "root", "true" }),
			@Result(name = "error", type = "json", params = { "root", "false" }) })
	public String validateOrgName() throws Exception {
		organizations = organizationDubboService
				.findOrganizationsByOrgNameAndParentId(organization.getId(),
						organization.getOrgName(), parentId);
		if (organizations.size() >= 1) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	@PermissionFilter(ename = "organizationManagement")
	@Action(value = "validateDepartmentNo", results = {
			@Result(name = "success", type = "json", params = { "root", "true" }),
			@Result(name = "error", type = "json", params = { "root", "false" }) })
	public String validateDepartmentNo() throws Exception {
		boolean bol = organizationDubboService
				.isDistrictOfAdministrativeRegion(organization);

		if (!bol) {
			return SUCCESS;
		} else if (bol
				&& !validateHelper.emptyString(organization.getDepartmentNo())) {
			organizations = organizationDubboService
					.findOrganizationsByDepartmentNoAndTypeAndLevel(organization);
			if (organizations.size() > 0) {
				return ERROR;
			}
		} else if (bol
				&& validateHelper.emptyString(organization.getDepartmentNo())) {
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "validateRepeatDepartmentNo", results = {
			@Result(name = "success", type = "json", params = { "root", "true" }),
			@Result(name = "error", type = "json", params = { "root", "false" }) })
	public String validateRepeatDepartmentNo() throws Exception {
		organization = new Organization();
		organization.setDepartmentNo(departmentNoF + departmentNoC);
		if (organizationDubboService.validateRepeatDepartmentNo(organization)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@PermissionFilter(ename = "moveOrganization")
	@Action(value = "ajaxMoveOrganization", results = { @Result(name = "success", type = "json", params = {
			"root", "true" }) })
	public String moveOrganization() throws Exception {
		organizationDubboService
				.moveOrganization(organization.getId(), organization
						.getParentOrg().getId(), getReferType(), referOrgId);
		return SUCCESS;
	}

	private ReferType getReferType() throws Exception {
		ReferType referType = null;
		ReferType[] values = ReferType.values();
		for (ReferType r : values) {
			if (r.toString().equals(position)) {
				referType = r;
			}
		}
		return referType;
	}

	@Action(value = "getOrgRelativePath", results = { @Result(name = "success", type = "json", params = {
			"root", "organization.orgName", "excludeNullProperties", "true" }) })
	public String getOrgRelativePath() throws Exception {
		Long orgId = organization.getId();
		organization.setOrgName(ControllerHelper.getRelativeOrgNameByOrgId(
				orgId, organizationDubboService));
		return SUCCESS;
	}

	@Action(value = "getOrgTypeListWhenAdd", results = { @Result(name = "success", type = "json", params = {
			"root", "orgTypes", "excludeNullProperties", "true" }) })
	public String getOrgTypeListWhenAdd() throws Exception {
		int parentLevelInternalId = organization.getOrgLevel().getInternalId();
		int parentTypeInternalId = organization.getOrgType().getInternalId();
		if (parentLevelInternalId > OrganizationLevel.TOWN
				&& parentTypeInternalId == OrganizationType.ADMINISTRATIVE_REGION) {
			orgTypes = propertyDictService
					.findPropertyDictByDomainName(OrganizationType.ORG_TYPE_KEY);
		} else if (parentLevelInternalId == OrganizationLevel.TOWN
				&& parentTypeInternalId == OrganizationType.ADMINISTRATIVE_REGION) {
			orgTypes = propertyDictService
					.findPropertyDictByDomainNameAndInternalIds(
							OrganizationType.ORG_TYPE_KEY, new int[] {
									OrganizationType.OTHER,
									OrganizationType.ADMINISTRATIVE_REGION,
									OrganizationType.PARTYWORK,
									OrganizationType.FUNCTIONAL_ORG });
		} else if (parentLevelInternalId >= OrganizationLevel.TOWN
				&& parentTypeInternalId == OrganizationType.FUNCTIONAL_ORG) {
			orgTypes = propertyDictService
					.findPropertyDictByDomainNameAndInternalId(
							OrganizationType.ORG_TYPE_KEY,
							OrganizationType.FUNCTIONAL_ORG);
		} else if (parentLevelInternalId == OrganizationLevel.VILLAGE
				&& parentTypeInternalId == OrganizationType.ADMINISTRATIVE_REGION) {
			orgTypes = propertyDictService
					.findPropertyDictByDomainNameAndInternalIds(
							OrganizationType.ORG_TYPE_KEY, new int[] {
									OrganizationType.ADMINISTRATIVE_REGION,
									OrganizationType.PARTYWORK });
		} else {
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "checkDeleteOrgById", results = {
			@Result(name = "success", type = "json", params = { "root", "true" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String checkDeleteOrgById() throws Exception {
		try {
			organization = organizationDubboService
					.getSimpleOrgById(organization.getId());

			if (organizationDubboService
					.countOrgsByOrgInternalCode(organization
							.getOrgInternalCode()) > 1) {
				this.errorMessage = "此部门下有子部门，不能删除！";
				return ERROR;
			}
			organization.setOrgType(propertyDictService
					.getPropertyDictById(organization.getOrgType().getId()));
			if (organization.getOrgType().getInternalId() == OrganizationType.FUNCTIONAL_ORG
					&& organizationDubboService.findFunOrgsByParentId(
							organization.getId()).size() > 0) {
				this.errorMessage = "此部门下有职能部门，不能删除！";
				return ERROR;
			}

			if (permissionService.countUsersByOrgInternalCode(organization
					.getOrgInternalCode()) > 0) {
				this.errorMessage = "此部门下有用户，不能删除！";
				return ERROR;
			}

		} catch (Exception e) {
			logger.error("异常信息", e);
		}

		return SUCCESS;
	}

	/**
	 * 检查网格下是否存在用户
	 * 
	 * @return
	 */
	@Action(value = "checkIsExistUserById", results = {
			@Result(name = "success", type = "json", params = { "root", "true" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String checkIsExistUserById() throws Exception {
		organization = organizationDubboService.getSimpleOrgById(organization
				.getId());
		if (permissionService.countUsersByOrgInternalCode(organization
				.getOrgInternalCode()) > 0) {
			this.errorMessage = "此部门下有用户，不能删除！";
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "loadTownForExtTree", results = { @Result(name = "success", type = "json", params = {
			"root", "extTreeDatas", "excludeNullProperties", "true",
			"ignoreHierarchy", "false" }) })
	public String loadTownForExtTree() throws Exception {
		organization = organizationDubboService.getFullOrgById(ThreadVariable
				.getUser().getOrganization().getId());
		int orgLevelInternald = propertyDictService.getPropertyDictById(
				organization.getOrgLevel().getId()).getInternalId();
		if (orgLevelInternald > OrganizationLevel.TOWN) {
			this.firstLoadExtTreeData();
			return SUCCESS;
		} else if (orgLevelInternald == OrganizationLevel.TOWN) {
			parentId = organization.getId();
		} else if (orgLevelInternald == OrganizationLevel.GRID) {
			parentId = organization.getParentOrg().getParentOrg().getId();
		} else if (orgLevelInternald == OrganizationLevel.VILLAGE) {
			parentId = organization.getParentOrg().getId();
		}
		extTreeDatas.add(new OrganizationTreeData(organizationDubboService
				.getFullOrgById(parentId)));
		return SUCCESS;
	}

	@Action(value = "getOrganizationBySimpleCode", results = { @Result(name = "success", type = "json", params = {
			"root", "organization", "excludeNullProperties", "true",
			"ignoreHierarchy", "false" }) })
	public String getOrganizationBySimpleCode() throws Exception {
		organization = organizationDubboService
				.getSimplePinyinBySimpleCode(simpleCode);
		return SUCCESS;
	}

	@Action(value = "getTitleProvinceName")
	public String getTitleProvinceName() throws Exception {
		List<Organization> organizations = organizationDubboService
				.findOrganizationsByParentId(null);
		organization = organizations.get(0);
		if (null == organization.getDepartmentNo()) {
			Organization provinceOrganization = organizationDubboService
					.findOrganizationsByParentId(organization.getId()).get(0);
			organization = provinceOrganization;
			initCountry = true;
		} else {
			initCountry = false;
		}
		return SUCCESS;
	}

	@Action(value = "isGridOrganization", results = {
			@Result(name = "success", type = "json", params = { "root", "true" }),
			@Result(name = "error", type = "json", params = { "root", "false" }) })
	public String isGridOrg() throws Exception {
		if (organization == null || organization.getId() == null) {
			return ERROR;
		}
		return organizationDubboService
				.isGridOrganization(organization.getId()) ? SUCCESS : ERROR;
	}

	@Action(value = "isDistrictOfAdministrativeRegion", results = {
			@Result(name = "success", type = "json", params = { "root", "true" }),
			@Result(name = "error", type = "json", params = { "root", "false" }) })
	public String isDistrictOfAdministrativeRegion() throws Exception {
		String dis = (organizationDubboService
				.isDistrictOfAdministrativeRegion(organization) && validateHelper
				.emptyString(organization.getDepartmentNo())) ? SUCCESS : ERROR;
		return dis;
	}

	@Action(value = "getMaxDepartmentNoByParentId", results = {
			@Result(name = "success", type = "json", params = { "root",
					"newParentId" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String getMaxDepartmentNoByParentId() throws Exception {
		if (parentId == null || orgLevel == null) {
			this.errorMessage = "参数不正确！";
			return ERROR;
		}
		newParentId = organizationDubboService.getMaxDepartmentNoByParentId(
				parentId, orgLevel);
		return SUCCESS;
	}

	@Action(value = "findOrgsByOrgTypeAndOrgLevel", results = {
			@Result(name = "success", type = "json", params = { "root",
					"organizations" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String findOrgsByOrgTypeAndOrgLevel() throws Exception {
		if (orgTypeInternalId == null || orgLevelInternalId == null) {
			this.errorMessage = "参数不正确！";
			return ERROR;
		}
		organizations = organizationDubboService.findOrgsByOrgTypeAndOrgLevel(
				orgTypeInternalId, orgLevelInternalId, ThreadVariable.getUser()
						.getOrganization().getId());
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: getOrganizationByIdAndDictName
	 * @Description: TODO根据当前登录用户获取到中国层级对象
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wanggz
	 * @date 2014-9-2 上午10:55:12
	 */
	@Action(value = "getOrganizationByIdAndDictName", results = {
			@Result(name = "success", type = "json", params = { "root",
					"organization" }),
			@Result(name = "error", type = "json", params = { "root",
					"errorMessage" }) })
	public String getOrganizationByIdAndDictName() throws Exception {
		organization = organizationDubboService
				.getOrganizationByIdAndDictName(ThreadVariable.getUser()
						.getOrganization().getId(),
						PropertyTypes.ORGANIZATION_LEVEL,
						OrganizationLevel.COUNTRY_KEY);
		return SUCCESS;
	}

	@Action(value = "getOrgForFirstCity", results = { @Result(name = "success", type = "json", params = {
			"root", "organization" }) })
	public String getorgForChengdu() throws Exception {
		if (null == orgId) {
			this.errorMessage = "参数不正确！";
			return ERROR;
		}
		organization = organizationDubboService.getOrgForFirstCity(orgId);
		return SUCCESS;
	}
	
	@Action(value = "isVillageOrg", results = { @Result(name = "success", type = "json", params = {
			"root", "isVillage" }) })
	public String isVillageOrg(){
		if(organization==null||organization.getId()==null){
			isVillage=false;
		}else{
			isVillage=organizationDubboService.isVillageOrganization(organization.getId());
		}
		return SUCCESS;
	}
	
	public String getNewParentId() {
		return newParentId;
	}

	public void setNewParentId(String newParentId) {
		this.newParentId = newParentId;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public GridPage getGridPage() {
		return gridPage;
	}

	public void setGridPage(GridPage gridPage) {
		this.gridPage = gridPage;
	}

	public PageInfo<Organization> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<Organization> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<TreeData> getTreeData() {
		return treeData;
	}

	public void setTreeData(List<TreeData> treeData) {
		this.treeData = treeData;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<String> getNodeIds() {
		return nodeIds;
	}

	public void setNodeIds(List<String> nodeIds) {
		this.nodeIds = nodeIds;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getReferOrgId() {
		return referOrgId;
	}

	public void setReferOrgId(Long referOrgId) {
		this.referOrgId = referOrgId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map getDispalyNames() {
		return dispalyNames;
	}

	public void setDispalyNames(Map dispalyNames) {
		this.dispalyNames = dispalyNames;
	}

	public String getSearchContext() {
		return searchContext;
	}

	public void setSearchContext(String searchContext) {
		this.searchContext = searchContext;
	}

	public Integer getCountChildren() {
		return countChildren;
	}

	public void setCountChildren(Integer countChildren) {
		this.countChildren = countChildren;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(Long orgLevel) {
		this.orgLevel = orgLevel;
	}

	public Long getOrgType() {
		return orgType;
	}

	public void setOrgType(Long orgType) {
		this.orgType = orgType;
	}

	public List<PropertyDict> getOrgTypes() {
		return orgTypes;
	}

	public void setOrgTypes(List<PropertyDict> orgTypes) {
		this.orgTypes = orgTypes;
	}

	public List<PropertyDict> getOrgLevels() {
		return orgLevels;
	}

	public void setOrgLevels(List<PropertyDict> orgLevels) {
		this.orgLevels = orgLevels;
	}

	public List<ExtTreeData> getExtTreeDatas() {
		return extTreeDatas;
	}

	public void setExtTreeDatas(List<ExtTreeData> extTreeDatas) {
		this.extTreeDatas = extTreeDatas;
	}

	public String getParentNodeIdsForSearch() {
		return parentNodeIdsForSearch;
	}

	public void setParentNodeIdsForSearch(String parentNodeIdsForSearch) {
		this.parentNodeIdsForSearch = parentNodeIdsForSearch;
	}

	public ExtTreeData getExtTreeData() {
		return extTreeData;
	}

	public void setExtTreeData(ExtTreeData extTreeData) {
		this.extTreeData = extTreeData;
	}

	public OrgDataWhenAdd getOrgDataWhenAdd() {
		return orgDataWhenAdd;
	}

	public void setOrgDataWhenAdd(OrgDataWhenAdd orgDataWhenAdd) {
		this.orgDataWhenAdd = orgDataWhenAdd;
	}

	public boolean isShouldJugeMultizones() {
		return shouldJugeMultizones;
	}

	public void setShouldJugeMultizones(boolean shouldJugeMultizones) {
		this.shouldJugeMultizones = shouldJugeMultizones;
	}

	public Long getRootId() {
		return rootId;
	}

	public void setRootId(Long rootId) {
		this.rootId = rootId;
	}

	public boolean isExcludeRoot() {
		return excludeRoot;
	}

	public void setExcludeRoot(boolean excludeRoot) {
		this.excludeRoot = excludeRoot;
	}

	public boolean isAllOrg() {
		return allOrg;
	}

	public void setAllOrg(boolean allOrg) {
		this.allOrg = allOrg;
	}

	public String getSimpleCode() {
		return simpleCode;
	}

	public void setSimpleCode(String simpleCode) {
		this.simpleCode = simpleCode;
	}

	public List<Organization> getChilds() {
		return childs;
	}

	public void setChilds(List<Organization> childs) {
		this.childs = childs;
	}

	public boolean isInitCountry() {
		return initCountry;
	}

	public void setInitCountry(boolean initCountry) {
		this.initCountry = initCountry;
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getDepartmentNoF() {
		return departmentNoF;
	}

	public void setDepartmentNoF(String departmentNoF) {
		this.departmentNoF = departmentNoF;
	}

	public String getDepartmentNoC() {
		return departmentNoC;
	}

	public void setDepartmentNoC(String departmentNoC) {
		this.departmentNoC = departmentNoC;
	}

	public String getCityOrgName() {
		return cityOrgName;
	}

	public void setCityOrgName(String cityOrgName) {
		this.cityOrgName = cityOrgName;
	}

	public Map<Long, String> getFunOrgs() {
		return funOrgs;
	}

	public void setFunOrgs(Map<Long, String> funOrgs) {
		this.funOrgs = funOrgs;
	}

	public Integer getOrgTypeInternalId() {
		return orgTypeInternalId;
	}

	public void setOrgTypeInternalId(Integer orgTypeInternalId) {
		this.orgTypeInternalId = orgTypeInternalId;
	}

	public Integer getOrgLevelInternalId() {
		return orgLevelInternalId;
	}

	public void setOrgLevelInternalId(Integer orgLevelInternalId) {
		this.orgLevelInternalId = orgLevelInternalId;
	}

	public Long getOrgFuntionalTypeId() {
		return orgFuntionalTypeId;
	}

	public void setOrgFuntionalTypeId(Long orgFuntionalTypeId) {
		this.orgFuntionalTypeId = orgFuntionalTypeId;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}

	public String getPlateName() {
		return plateName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public boolean isDirectlySupervisor() {
		return directlySupervisor;
	}

	public void setDirectlySupervisor(boolean directlySupervisor) {
		this.directlySupervisor = directlySupervisor;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

	public boolean getIsVillage() {
		return isVillage;
	}

	public void setIsVillage(boolean isVillage) {
		this.isVillage = isVillage;
	}
	
}

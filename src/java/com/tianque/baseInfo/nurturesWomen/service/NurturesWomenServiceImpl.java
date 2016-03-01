package com.tianque.baseInfo.nurturesWomen.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianque.baseInfo.actualHouse.domain.HouseInfo;
import com.tianque.baseInfo.actualHouse.service.ActualHouseService;
import com.tianque.baseInfo.base.domain.ActualPopulation;
import com.tianque.baseInfo.base.domain.Countrymen;
import com.tianque.baseInfo.base.domain.LogoutDetail;
import com.tianque.baseInfo.base.service.BaseInfoPopulationTemplateImpl;
import com.tianque.baseInfo.base.service.BaseInfoService;
import com.tianque.baseInfo.base.service.PopulationRelationService;
import com.tianque.baseInfo.floatingPopulation.service.FloatingPopulationService;
import com.tianque.baseInfo.householdStaff.service.HouseholdStaffService;
import com.tianque.baseInfo.nurturesWomen.dao.NurturesWomenDao;
import com.tianque.baseInfo.nurturesWomen.domain.NurturesWomen;
import com.tianque.baseInfo.utils.CollectionsUtil;
import com.tianque.cache.PageInfoCacheThreadLocal;
import com.tianque.cache.UpdateType;
import com.tianque.core.cache.constant.MemCacheConstant;
import com.tianque.core.cache.service.CacheService;
import com.tianque.core.datatransfer.ExcelImportHelper;
import com.tianque.core.globalSetting.service.GlobalSettingService;
import com.tianque.core.globalSetting.util.GlobalSetting;
import com.tianque.core.util.BaseInfoTables;
import com.tianque.core.util.Chinese2pinyin;
import com.tianque.core.util.ConstantsProduct;
import com.tianque.core.util.NewBaseInfoTables;
import com.tianque.core.util.StringUtil;
import com.tianque.core.util.ThreadVariable;
import com.tianque.core.validate.ValidateResult;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Organization;
import com.tianque.domain.property.CurrentAddressType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.domain.vo.SearchNurturesWomenVo;
import com.tianque.excel.definition.SpecialGroupsContext;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.exception.base.ServiceValidationException;
import com.tianque.service.ActualPopulationProcessorService;
import com.tianque.service.HousePopulationMaintanceService;
import com.tianque.service.PopulationProccessorService;
import com.tianque.service.helper.ManagePopulationByHouseHelper;
import com.tianque.service.util.PopulationCatalog;
import com.tianque.service.util.PopulationType;
import com.tianque.service.vo.IsEmphasis;
import com.tianque.shard.util.ShardConversion;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.userAuth.api.PermissionDubboService;
import com.tianque.util.Arrays;
import com.tianque.util.IdCardUtil;
import com.tianque.util.PluginServiceHelpUtil;
import com.tianque.util.PropertyUtil;
import com.tianque.validate.AbstractCountrymenValidator;

@Service("nurturesWomenService")
@Transactional
public class NurturesWomenServiceImpl extends BaseInfoPopulationTemplateImpl
		implements NurturesWomenService, PopulationProccessorService {

	private static final String CACHE_ADDNURTURESWOMEN_VALUE = "CACHE_ADDNURTURESWOMEN";
	private static final String CACHE_ADDNURTURESWOMENBASEINFO_VALUE = "CACHE_ADDNURTURESWOMENBASEINFO";
	@Autowired
	protected FloatingPopulationService floatingPopulationService;
	@Autowired
	private ShardConversion shardConversion;
	@Autowired
	private NurturesWomenDao nurturesWomenDao;
	@Autowired
	private OrganizationDubboService organizationDubboService;
	@Qualifier("nurturesWomenValidator")
	@Autowired
	private AbstractCountrymenValidator<NurturesWomen> domainValidator;
	@Autowired
	private GlobalSettingService globalSettingService;
	@Autowired
	private PropertyDictService propertyDictService;
	@Autowired
	private ActualHouseService actualHouseService;
	@Autowired
	private ManagePopulationByHouseHelper managePopulationByHouseHelper;
	@Autowired
	private HousePopulationMaintanceService housePopulationMaintanceService;
	@Autowired
	private PopulationRelationService populationRelationService;
	@Autowired
	private BaseInfoService baseInfoService;
	@Autowired
	private CacheService cacheService;
	@Autowired
	protected ActualPopulationProcessorService actualPopulationProcessorService;
	@Autowired
	private HouseholdStaffService householdStaffService;
	@Autowired
	private PermissionDubboService permissionDubboService;

	// @Autowired
	// private AddressInfoService addressInfoService;

	// @Autowired
	// private PageInfoCacheHelper pageInfoCacheHelper;

	@Resource(name = "nurturesWomenDao")
	public void setBaseInfoPopulationBaseDao(NurturesWomenDao nurturesWomenDao) {
		super.setBaseInfoPopulationBaseDao(nurturesWomenDao);
	}

	public NurturesWomenServiceImpl() {
		setNurturesWomenService(this);
	}

	@Override
	public boolean hasDuplicateNurturesWomen(Long orgId, String idCardNo,
			Long exceptedId) {
		if (idCardNo == null || "".equals(idCardNo.trim()) || orgId == null) {
			return false;
		}
		idCardNo = idCardNo.toUpperCase();
		Countrymen countrymen = baseInfoService.getBaseInfoByIdCardNo(idCardNo);
		if (countrymen == null) {
			return false;
		}
		String shardCode = shardConversion.getShardCode(orgId);
		Long exsitedId = nurturesWomenDao.getIdByBaseinfoIdAndOrgId(
				countrymen.getId(), orgId, shardCode);
		return exceptedId == null ? exsitedId != null
				: (exsitedId != null && !exceptedId.equals(exsitedId));
	}

	@Override
	public PageInfo<NurturesWomen> findNurturesWomenForPageByOrgId(
			Long organizationId, Integer pageNum, Integer pageSize,
			String sidx, String sord, Long isEmphasis) {
		if (organizationId == null) {
			return constructEmptyPageInfo();
		} else {
			Organization org = organizationDubboService
					.getSimpleOrgById(organizationId);
			if (org == null) {
				return constructEmptyPageInfo();
			} else {
				String shardCode = shardConversion.getShardCode(org
						.getDepartmentNo());
				NurturesWomen nurturesWomen = new NurturesWomen();
				nurturesWomen.setOrgInternalCode(organizationDubboService
						.getSimpleOrgById(organizationId).getOrgInternalCode());
				nurturesWomen.setSortField(sidx);
				nurturesWomen.setOrder(sord);
				nurturesWomen.setIsEmphasis(isEmphasis);
				nurturesWomen.setShardCode(shardCode);
				PageInfo<NurturesWomen> pageInfo = nurturesWomenDao
						.findPagerUsingCacheBySearchVo(organizationId,
								nurturesWomen, pageNum, pageSize,
								"NurturesWomen", MemCacheConstant
										.getCachePageKey(NurturesWomen.class
												.getSimpleName()));

				// PageInfo<NurturesWomen> pageInfo = nurturesWomenDao
				// .findNurturesWomenForPageByOrgInternalCode(
				// org.getOrgInternalCode(), pageNum, pageSize,
				// sidx, sord, isEmphasis);
				fitCountrymen(pageInfo);
				fitServiceMemberHasObject(BaseInfoTables.NURTURESWOMEN_KEY,
						pageInfo);

				new CollectionsUtil<NurturesWomen>().sortList(
						pageInfo.getResult(), sord, sidx);
				//隐藏身份证中间4位
				pageInfo=hiddenIdCard(pageInfo);
				return pageInfo;
			}
		}
	}
	
	//隐藏身份证中间4位
	  private PageInfo<NurturesWomen> hiddenIdCard(PageInfo<NurturesWomen> pageInfo){
						//判断权限，有权限不隐藏
						if(permissionDubboService.
								isUserHasPermission(ThreadVariable.getUser().getId(), "isNurturesWomenNotHidCard")){
							return pageInfo;
						}
						List<NurturesWomen> list = pageInfo.getResult();
						int index=0;
						for (NurturesWomen verification:list) {
							verification.setIdCardNo(IdCardUtil.hiddenIdCard(verification.getIdCardNo()));
							list.set(index, verification);
							index++;
						}
						pageInfo.setResult(list);
						return pageInfo;
	}

	private PageInfo<NurturesWomen> constructEmptyPageInfo() {
		PageInfo<NurturesWomen> result = new PageInfo<NurturesWomen>();
		result.setResult(new ArrayList<NurturesWomen>());
		return result;
	}

	@Override
	public NurturesWomen getNurturesWomenById(Long id) {
		if (null == id || id < 0L) {
			throw new BusinessValidationException("育妇id不合法");
		}
		return nurturesWomenDao.getShard(id);
	}

	@Override
	public NurturesWomen addNurturesWomen(NurturesWomen nurturesWomen) {
		if (!ExcelImportHelper.isImport.get()) {
			ValidateResult validateResult = domainValidator
					.validate(nurturesWomen);
			if (validateResult.hasError()) {
				throw new BusinessValidationException(
						validateResult.getErrorMessages());
			} else if (hasDuplicateNurturesWomen(nurturesWomen
					.getOrganization().getId(), nurturesWomen.getIdCardNo(),
					nurturesWomen.getId())) {
				throw new BusinessValidationException("该网格下已存在相同身份证号码");
			}
		}
		try {
			if (checkDataExitInCache(nurturesWomen,
					MemCacheConstant.CACHE_ADDNURTURESWOMEN,
					CACHE_ADDNURTURESWOMEN_VALUE)) {
				return nurturesWomen;
			}
			return add(nurturesWomen);
		} catch (Exception e) {
			logger.error("NurturesWomenServiceImpl addNurturesWomen", e);
			if (!ExcelImportHelper.isImport.get()) {
				throw new BusinessValidationException("新增信息出现错误");
			} else {
				return null;
			}
		} finally {
			cleanDataInCache(nurturesWomen,
					MemCacheConstant.CACHE_ADDNURTURESWOMEN);
		}
	}

	// private NurturesWomen checkAddOrUpdate(NurturesWomen nurturesWomen) {
	// NurturesWomen women = null;
	// if (nurturesWomen != null && nurturesWomen.getId() != null) {
	// women = getNurturesWomenById(nurturesWomen.getId());
	// } else {
	// women = getNurturesWomenByIdCardNoAndOrgId(
	// nurturesWomen.getIdCardNo(), nurturesWomen
	// .getOrganization().getId());
	// }
	// if (women != null) {
	// nurturesWomen.setOrganization(women.getOrganization());
	// nurturesWomen.setOrgInternalCode(women.getOrgInternalCode());
	// nurturesWomen.setBaseInfoId(women.getBaseInfoId());
	// nurturesWomen.setAddressInfoId(women.getAddressInfoId());
	// nurturesWomen.setId(women.getId());
	// nurturesWomen.setActualPopulationType(women
	// .getActualPopulationType());
	// return updateNurturesWomenBaseInfo(nurturesWomen);
	// } else {
	// return add(nurturesWomen);
	// }
	// }

	private NurturesWomen add(NurturesWomen nurturesWomen) {
		try {
			autoFilled(nurturesWomen);
			autoIsDeath(nurturesWomen);
			contructCurrentAddress(nurturesWomen);
			nurturesWomen.setShardCode(shardConversion
					.getShardCode(nurturesWomen.getOrganization().getId()));
			Countrymen temp = populationRelationService.businessOption(
					nurturesWomen, nurturesWomen.getActualPopulationType());
			nurturesWomen.setBaseInfoId(temp.getBaseInfoId());
			nurturesWomen.setAddressInfoId(temp.getAddressInfoId());
			nurturesWomen.setSourcesState(null);
			nurturesWomen = nurturesWomenDao.addShard(nurturesWomen);
			populationRelationService.addPopulationRelation(temp.getId(),
					nurturesWomen.getActualPopulationType(),
					nurturesWomen.getId(), BaseInfoTables.NURTURESWOMEN_KEY);
			nurturesWomen.setHouseId(temp.getHouseId());
			rebuildHouseAddress(nurturesWomen);

			if (IsEmphasis.Emphasis.equals(nurturesWomen.getIsEmphasis())) {
				// 缓存计数器
				PageInfoCacheThreadLocal.increment(MemCacheConstant
						.getCachePageKey(NurturesWomen.class.getSimpleName()),
						nurturesWomen, 1);
			}
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类NurturesWomenServiceImpl的addNurturesWomen方法出现异常，原因：",
					"新增孕妇信息出现错误", e);
		}
		return nurturesWomen;
	}

	@Override
	public NurturesWomen addNurturesWomenForJob(Countrymen countrymen,
			Long sourcesState) {
		if (countrymen == null || countrymen.getAddressInfoId() == null
				|| countrymen.getBaseInfoId() == null
				|| countrymen.getId() == null) {
			throw new BusinessValidationException("基础信息不全");
		}
		NurturesWomen nurturesWomen = new NurturesWomen();
		try {
			PropertyUtil.copyPropertiesWithRecursion(Countrymen.class,
					nurturesWomen, countrymen, new String[] { "id" });
		} catch (Exception e) {
			return null;
		}
		nurturesWomen.setSourcesState(sourcesState);
		nurturesWomen.setIsEmphasis(IsEmphasis.Emphasis);
		nurturesWomen
				.setCreateDate(ThreadVariable.getSession().getAccessTime());
		nurturesWomen.setCreateUser(ThreadVariable.getSession().getUserName());
		nurturesWomen
				.setUpdateDate(ThreadVariable.getSession().getAccessTime());
		String shardCode = shardConversion.getShardCode(nurturesWomen
				.getOrganization().getId());
		nurturesWomen.setShardCode(shardCode);
		Long nurturesWomenId = nurturesWomenDao
				.saveNurturesWomenForJob(nurturesWomen);
		nurturesWomen.setId(nurturesWomenId);
		populationRelationService.addPopulationRelation(countrymen.getId(),
				nurturesWomen.getActualPopulationType(), nurturesWomenId,
				BaseInfoTables.NURTURESWOMEN_KEY);
		if (countrymen.getHouseId() != null) {
			managePopulationByHouseHelper.reBindHouseIfNecc(
					PopulationCatalog.NURTURES_WOMEN, nurturesWomen,
					countrymen.getHouseId());
		}
		// JOB的不累加缓存计数器
		if (!ConstantsProduct.SourcesState.JOB.equals(sourcesState)) {
			// 缓存计数器
			PageInfoCacheThreadLocal.increment(MemCacheConstant
					.getCachePageKey(NurturesWomen.class.getSimpleName()),
					nurturesWomen, 1);
		}
		return nurturesWomen;
	}

	/**
	 * 如果人口的房屋信息（CurrentAddress）不为空，并且房屋id不存在，新增一个房屋，并且建立关联关系, 如果房屋id不为空直接建立关联关系
	 * 如果房屋信息为空,并且有房屋id不为空，则删除人房关系
	 * 
	 * @param householdStaff
	 */
	private void rebuildHouseAddress(NurturesWomen householdStaff) {

		if (householdStaff.getIsHaveHouse() != null
				&& householdStaff.getIsHaveHouse()
				&& StringUtil.isStringAvaliable(householdStaff
						.getCurrentAddress())) {

			if (null == householdStaff.getHouseId()
					|| householdStaff.getHouseId().equals(01L)) {
				// 新增一个实有房屋,并且建立人房关系
				HouseInfo houseInfo = new HouseInfo();
				houseInfo.setAddress(householdStaff.getCurrentAddress());
				houseInfo.setAddressType(propertyDictService
						.findPropertyDictByDomainNameAndDictDisplayName(
								PropertyTypes.CURRENT_ADDRESS_TYPE, "其他"));
				houseInfo.setOrganization(householdStaff.getOrganization());
				houseInfo
						.setHouseOperateSource(NewBaseInfoTables.NURTURESWOMEN_KEY);
				houseInfo = actualHouseService.addHouseInfo(houseInfo);

				managePopulationByHouseHelper.reBindHouseIfNecc(
						PopulationCatalog.NURTURES_WOMEN, householdStaff,
						houseInfo.getId());
			} else if (householdStaff.getHouseId() != null) {
				managePopulationByHouseHelper.reBindHouseIfNecc(
						PopulationCatalog.NURTURES_WOMEN, householdStaff,
						householdStaff.getHouseId());
			}
		} else {
			housePopulationMaintanceService.releaseHouse(
					PopulationCatalog.NURTURES_WOMEN, householdStaff.getId(),
					householdStaff.getHouseId());
		}
	}

	@Override
	public NurturesWomen updateNurturesWomen(NurturesWomen nurturesWomen) {

		try {
			autoFilled(nurturesWomen);
			// if (nurturesWomen.isDeath()) {
			// nurturesWomen.setIsEmphasis(IsEmphasis.IsNotEmphasis);
			// this.deletePopulationTypeByPopulationIdAndType(
			// nurturesWomen.getId(), PopulationType.NURTURES_WOMEN);
			// }
			contructCurrentAddress(nurturesWomen);
			proccessHouseBind(nurturesWomen);
			updateNurturesWomenBaseInfo(nurturesWomen);
			// nurturesWomen = nurturesWomenDao.update(nurturesWomen);
		} catch (Exception e) {
			logger.error(
					"类NURTURES_WOMENServiceImpl的updateNurturesWomen方法出现异常，原因：",
					e);
			if (!ExcelImportHelper.isImport.get()) {
				throw new BusinessValidationException("更改孕妇出现错误");
			} else {
				return null;
			}
		}

		return nurturesWomen;
	}

	private void autoFilled(NurturesWomen domain) {
		domain.setIdCardNo(domain.getIdCardNo().toUpperCase());
		autoFillOrganizationInternalCode(domain);
		autoFillChinesePinyin(domain);
		autoFillBirthday(domain);
	}

	private void autoIsDeath(NurturesWomen domain) {
		if (domain.isDeath()) {
			domain.setIsEmphasis(IsEmphasis.IsNotEmphasis);
		} else {
			domain.setIsEmphasis(IsEmphasis.Emphasis);
		}
	}

	private void autoFillOrganizationInternalCode(NurturesWomen domain) {
		Organization org = organizationDubboService.getSimpleOrgById(domain
				.getOrganization().getId());
		if (org == null) {
			throw new BusinessValidationException("找不到指定的网格");
		}
		domain.setOrgInternalCode(org.getOrgInternalCode());
	}

	private void autoFillBirthday(NurturesWomen domain) {
		if (StringUtil.isStringAvaliable(domain.getIdCardNo())) {
			Date idCardDate = IdCardUtil.parseBirthday(domain.getIdCardNo());
			if (idCardDate == null) {
				throw new BusinessValidationException("身份证号码输入不正确");
			} else {
				Date afterDate = null, beforeDate = null;
				Date date = new Date();
				String dates = new SimpleDateFormat("yyyy-MM-dd").format(date);
				String afterDateStr = (Integer.parseInt(dates.substring(0, 4)) - 15)
						+ dates.substring(4, 10);
				String beforeDateStr = (Integer.parseInt(dates.substring(0, 4)) - 49)
						+ dates.substring(4, 10);
				try {
					afterDate = new SimpleDateFormat("yyyy-MM-dd")
							.parse(afterDateStr);

					beforeDate = new SimpleDateFormat("yyyy-MM-dd")
							.parse(beforeDateStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if (idCardDate.before(beforeDate)) {
					throw new BusinessValidationException("育龄妇女年龄应在15-49岁之间");
				}
				if (idCardDate.after(afterDate)) {
					throw new BusinessValidationException("育龄妇女年龄应在15-49岁之间");
				}
				String idCardNo = domain.getIdCardNo();
				if (15 == idCardNo.length()) { // 15位身份证号码
					if (idCardNo.charAt(14) / 2 * 2 != idCardNo.charAt(14)) {
						throw new BusinessValidationException("育龄妇女性别应为女性!");
					}
				}
				if (18 == idCardNo.length()) { // 18位身份证号码
					if (idCardNo.charAt(16) / 2 * 2 != idCardNo.charAt(16)) {
						throw new BusinessValidationException("育龄妇女性别应为女性!");
					}
				}
			}
			domain.setBirthday(IdCardUtil.parseBirthday(domain.getIdCardNo()));
		}
	}

	@Override
	public NurturesWomen updateNurturesWomenBaseInfo(NurturesWomen nurturesWomen) {
		try {
			nurturesWomen
					.setIdCardNo(nurturesWomen.getIdCardNo().toUpperCase());
			autoFillBirthday(nurturesWomen);
			autoFillChinesePinyin(nurturesWomen);
			autoFillOrganizationInternalCode(nurturesWomen);
			if (nurturesWomen.isDeath()) {
				nurturesWomen.setLogoutDetail(buildLogoutDetail(nurturesWomen
						.isDeath()));
				// 缓存计数器
				PageInfoCacheThreadLocal.decrease(MemCacheConstant
						.getCachePageKey(NurturesWomen.class.getSimpleName()),
						nurturesWomen, 1);
			}
			// this.proccessHouseBind(nurturesWomen);
			Countrymen temp = populationRelationService.businessOption(
					nurturesWomen, nurturesWomen.getActualPopulationType());
			nurturesWomen.setHouseId(temp.getHouseId());
			this.rebuildHouseAddress(nurturesWomen);
			nurturesWomenDao.updateTableUpdateDateById(nurturesWomen.getId());
			return nurturesWomen;
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类NurturesWomenServiceImpl的updateNurturesWomenBaseInfo方法出现异常，原因：",
					"修改孕妇基本信息出现错误", e);
		}
	}

	private LogoutDetail buildLogoutDetail(Boolean death) {
		LogoutDetail result = new LogoutDetail();
		if (death) {
			result.setLogoutDate(new Date());
			result.setLogoutReason(LogoutDetail.LOGOUT_REASON_FOR_DEATH);
			result.setLogout(IsEmphasis.IsNotEmphasis);
		} else if (!death) {
			result.setLogout(IsEmphasis.Emphasis);
		}

		return result;
	}

	@Override
	public NurturesWomen updateNurturesWomenBusiness(NurturesWomen nurturesWomen) {
		try {
			if (!ExcelImportHelper.isImport.get()) {
				ValidateResult specializedValidator = domainValidator
						.validateSpecializedInfo(nurturesWomen);
				if (specializedValidator.hasError()) {
					throw new BusinessValidationException(
							specializedValidator.getErrorMessages());
				}
			}
			nurturesWomen
					.setManCurrentAddress(loadManCurrentAddress(nurturesWomen));
			nurturesWomen.setShardCode(shardConversion
					.getShardCode(nurturesWomen.getOrganization().getId()));
			nurturesWomen = nurturesWomenDao.updateBusinessShard(nurturesWomen);
			PageInfoCacheThreadLocal.update(
					MemCacheConstant.getCachePageKey(NurturesWomen.class),
					nurturesWomen, UpdateType.BUSINESS);
			return nurturesWomen;
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类NurturesWomenServiceImpl的updateNurturesWomenBusiness方法出现异常，原因：",
					"修改孕妇基本信息出现错误", e);
		}
	}

	private String loadManCurrentAddress(NurturesWomen nurturesWomen) {
		StringBuffer currentAddress = new StringBuffer("");
		if (null == nurturesWomen.getManCurrentAddressType()) {
			return "";
		} else if (nurturesWomen
				.getManCurrentAddressType()
				.getId()
				.equals(propertyDictService
						.findPropertyDictByDomainNameAndInternalId(
								CurrentAddressType.ADDRESS_KEY,
								CurrentAddressType.BUSINESS_HOUSE).get(0)
						.getId())) {
			currentAddress.append(trimString(nurturesWomen.getManCommunity())
					+ "小区" + trimString(nurturesWomen.getManBlock()) + "幢"
					+ trimString(nurturesWomen.getManUnit()) + "单元"
					+ trimString(nurturesWomen.getManRoom()) + "室");
		} else {
			currentAddress.append(nurturesWomen.getManCurrentAddress());
		}
		return currentAddress.toString();
	}

	private String trimString(String str) {
		if (null == str) {
			return "";
		} else {
			return str.trim();
		}
	}

	@Override
	public void deleteNurturesWomenByIdList(List<Long> idList) {
		if (null == idList) {
			throw new BusinessValidationException("育妇idList不能为空");
		}
		try {
			for (Long id : idList) {
				if (null == id || id < 0L) {
					throw new BusinessValidationException("育妇id不合法");
				}
				NurturesWomen domain = getNurturesWomenById(id);
				if (domain == null) {
					throw new BusinessValidationException("育妇人员不合法");
				}

				domain.setPopulationTypeBean(getPopulationRelationService()
						.getBusinessPopulationTypeBean(id,
								PopulationType.NURTURES_WOMEN));
				getRecoverDatasService().deleteActualPopulation(domain);
				populationRelationService.businessDeletePopulationRelation(id,
						PopulationType.NURTURES_WOMEN);

				nurturesWomenDao.deleteShard(id);

				PluginServiceHelpUtil.doService("routerService",
						"deleteServiceTeamHasObjectsAndServiceMemberHasObject",
						new Class[] { String.class, Long.class },
						PopulationType.NURTURES_WOMEN, id);
				/** 删除时对关联的事件和服务记录进行orgId和idCardNo赋值 */
				PluginServiceHelpUtil.doService("routerService",
						"setOrgIdAndCardNoOrName", new Class[] { Long.class,
								String.class, String.class, Long.class },
						domain.getOrganization().getId(), domain.getIdCardNo(),
						PopulationType.NURTURES_WOMEN, id);

				if (IsEmphasis.Emphasis.equals(domain.getIsEmphasis())) {
					// 缓存计数器
					PageInfoCacheThreadLocal.decrease(MemCacheConstant
							.getCachePageKey(NurturesWomen.class
									.getSimpleName()), domain, 1);
				}

			}
		} catch (Exception e) {
			throw new ServiceValidationException(
					"类NurturesWomenServiceImpl的deleteNurturesWomenByIdList方法出现异常，原因：",
					"删除育龄妇女出现错误", e);
		}
	}

	@Override
	public List<NurturesWomen> updateDeathOfNurturesWomenByIdList(
			List<Long> populationIds, Boolean death) {
		List<NurturesWomen> list = new ArrayList<NurturesWomen>();
		for (Long id : populationIds) {
			NurturesWomen population = this.getNurturesWomenById(id);
			updateLogOutByPopulationTypeAndId(
					LogoutDetail.buildLogoutDetail(death),
					BaseInfoTables.NURTURESWOMEN_KEY, population.getId());
			baseInfoService.updateDeathStateById(population.getBaseInfoId(),
					death, population.getIdCardNo(), population
							.getOrganization().getId(), population
							.getOrgInternalCode(),
					NewBaseInfoTables.NURTURESWOMEN_KEY);
			list.add(population);
			// 缓存计数器
			PageInfoCacheThreadLocal.increment(MemCacheConstant
					.getCachePageKey(NurturesWomen.class.getSimpleName()),
					population, 1);
		}
		return list;
	}

	@Override
	public PageInfo<NurturesWomen> searchNurturesWomen(Integer pageNum,
			Integer pageSize, String sidx, String sord,
			SearchNurturesWomenVo searchNurturesWomenVo) {
		PageInfo<NurturesWomen> pageInfo = nurturesWomenDao
				.searchNurturesWomen(pageNum, pageSize, sidx, sord,
						searchNurturesWomenVo);
		for (NurturesWomen nui : pageInfo.getResult()) {
			ActualPopulation actualPopulation = actualPopulationProcessorService
					.getActualPopulationbyOrgIdAndIdCardNo(nui
							.getOrganization().getId(), nui.getIdCardNo());
			nui.setHouseCode(actualPopulation.getHouseCode());
		}
		//隐藏身份证中间4位
		pageInfo=hiddenIdCard(pageInfo);
		return pageInfo;
	}

	@Override
	public List<NurturesWomen> searchAllNurturesWomen(String sidx, String sord,
			SearchNurturesWomenVo searchNurturesWomenVo) {
		return nurturesWomenDao.searchAllNurturesWomen(sidx, sord,
				searchNurturesWomenVo);
	}

	@Override
	public Long proccessPopulationSpecializedInfo(
			ActualPopulation actualPopulation, String[] populationType,
			Map<String, Object> population) {
		actualPopulation
				.setAttentionPopulationType(NewBaseInfoTables.NURTURESWOMEN_KEY);
		Long orgId = Long
				.valueOf(((String[]) population.get("organization.id"))[0]);
		String idCardNo = ((String[]) population.get("idCardNo"))[0];
		NurturesWomen nurturesWomen = nurturesWomenDao.getByOrgIdAndIdCardNo(
				orgId, idCardNo);
		if (!com.tianque.util.Arrays.hasObjectInArray(populationType,
				PopulationType.NURTURES_WOMEN)) {
			if (null != nurturesWomen) {
				nurturesWomen.setIsEmphasis(IsEmphasis.IsNotEmphasis);
				updateEmphasiseById(nurturesWomen.getId(),
						IsEmphasis.IsNotEmphasis);
			}
		} else {
			if (null == nurturesWomen) {
				nurturesWomen = new NurturesWomen();
				copyProperty(actualPopulation, population, nurturesWomen);
				addNurturesWomen(nurturesWomen);
			} else {
				Long id = nurturesWomen.getId();
				copyProperty(actualPopulation, population, nurturesWomen);
				nurturesWomen.setId(id);
				nurturesWomen.setIsEmphasis(IsEmphasis.Emphasis);
				updateNurturesWomenBusiness(nurturesWomen);
				updateEmphasiseById(nurturesWomen.getId(), IsEmphasis.Emphasis);
			}
		}
		return nurturesWomen == null
				|| nurturesWomen.getIsEmphasis() == IsEmphasis.IsNotEmphasis
						.longValue() ? null : nurturesWomen.getId();
	}

	private void updateEmphasiseById(Long id, Long isEmphasis) {
		LogoutDetail logoutDetail = new LogoutDetail();
		logoutDetail.setLogout(isEmphasis);
		updateLogOutByPopulationTypeAndId(logoutDetail,
				BaseInfoTables.NURTURESWOMEN_KEY, id);
	}

	@Override
	public void updatePopulationBaseInfo(ActualPopulation actualPopulation) {
		NurturesWomen nurturesWomen = nurturesWomenDao.getByOrgIdAndIdCardNo(
				actualPopulation.getOrganization().getId(),
				actualPopulation.getIdCardNo());
		if (null == nurturesWomen) {
			return;
		}
		Long id = nurturesWomen.getId();
		copyProperties(nurturesWomen, actualPopulation);
		nurturesWomen.setId(id);
		updateNurturesWomen(nurturesWomen);
	}

	@Override
	public void deletePopulationByPopulationId(Long populationId) {
		if (null != populationId) {
			List idList = new ArrayList();
			idList.add(populationId);
			this.deleteNurturesWomenByIdList(idList);
			this.deletePopulationTypeByPopulationIdAndType(populationId,
					PopulationType.NURTURES_WOMEN);
		}
	}

	@Override
	public NurturesWomen getNurturesWomenByIdCardNoAndOrganizationId(
			String idCardNo, Long orgId) {
		if (idCardNo == null || "".equals(idCardNo.trim()) || orgId == null) {
			return null;
		}
		String shardCode = shardConversion.getShardCode(orgId);
		return nurturesWomenDao.getNurturesWomenByIdCardNoAndOrganizationId(
				idCardNo, orgId, shardCode);
	}

	@Override
	public Long getNurturesWomenByBaseinfoIdAndOrgId(Long baseInfoId, Long orgId) {
		if (baseInfoId == null || orgId == null) {
			return null;
		}
		String shardCode = shardConversion.getShardCode(orgId);
		return nurturesWomenDao.getIdByBaseinfoIdAndOrgId(baseInfoId, orgId,
				shardCode);
	}

	@Override
	public Map<String, Map<String, Object>> getPopulationSpecializedInfoByOrgIdAndIdCardNo(
			Long orgId, String idCardNo) {
		NurturesWomen nurturesWomen = nurturesWomenDao.getByOrgIdAndIdCardNo(
				orgId, idCardNo);
		if (null == nurturesWomen) {
			return null;
		}
		Map<String, Object> nurturesWomenMap = new HashMap<String, Object>();
		nurturesWomenMap.put("id", nurturesWomen.getId());
		nurturesWomenMap.put("isEmphasis", nurturesWomen.getIsEmphasis());
		nurturesWomenMap.put("firstMarriageTime",
				nurturesWomen.getFirstMarriageTime());
		nurturesWomenMap.put("marriageRegistrationTime",
				nurturesWomen.getMarriageRegistrationTime());
		nurturesWomenMap.put("licenseSituation",
				nurturesWomen.getLicenseSituation());
		nurturesWomenMap.put("marriageOrDivorceTime",
				nurturesWomen.getMarriageOrDivorceTime());
		nurturesWomenMap.put("fertilityServicesNo",
				nurturesWomen.getFertilityServicesNo());
		nurturesWomenMap.put("licenseTime", nurturesWomen.getLicenseTime());
		nurturesWomenMap.put("contraceptiveMethod",
				nurturesWomen.getContraceptiveMethod());
		nurturesWomenMap.put("contraceptiveTime",
				nurturesWomen.getContraceptiveTime());
		nurturesWomenMap.put("boyNumber", nurturesWomen.getBoyNumber());
		nurturesWomenMap.put("girlNumber", nurturesWomen.getGirlNumber());
		nurturesWomenMap.put("onechildOfCouple",
				nurturesWomen.getOnechildOfCouple());
		nurturesWomenMap.put("manIdcardNo", nurturesWomen.getManIdcardNo());
		nurturesWomenMap.put("manName", nurturesWomen.getManName());
		nurturesWomenMap.put("manMaritalState",
				nurturesWomen.getManMaritalState());
		nurturesWomenMap.put("manFirstMarriageTime",
				nurturesWomen.getManFirstMarriageTime());
		nurturesWomenMap.put("manMobileNumber",
				nurturesWomen.getManMobileNumber());
		nurturesWomenMap.put("manTelephone", nurturesWomen.getManTelephone());
		nurturesWomenMap.put("manBirthday", nurturesWomen.getManBirthday());
		nurturesWomenMap.put("manNation", nurturesWomen.getManNation());
		nurturesWomenMap.put("manPoliticalBackground",
				nurturesWomen.getManPoliticalBackground());
		nurturesWomenMap.put("manSchooling", nurturesWomen.getManSchooling());
		nurturesWomenMap.put("manCareer", nurturesWomen.getManCareer());
		nurturesWomenMap.put("manWorkUnit", nurturesWomen.getManWorkUnit());
		nurturesWomenMap.put("manProvince", nurturesWomen.getManProvince());
		nurturesWomenMap.put("manCity", nurturesWomen.getManCity());
		nurturesWomenMap.put("manDistrict", nurturesWomen.getManDistrict());
		nurturesWomenMap.put("manNativeplaceAddress",
				nurturesWomen.getManNativeplaceAddress());
		nurturesWomenMap.put("manCurrentAddressType",
				nurturesWomen.getManCurrentAddressType());
		nurturesWomenMap.put("manCommunity", nurturesWomen.getManCommunity());
		nurturesWomenMap.put("manBlock", nurturesWomen.getManBlock());
		nurturesWomenMap.put("manUnit", nurturesWomen.getManUnit());
		nurturesWomenMap.put("manRoom", nurturesWomen.getManRoom());
		nurturesWomenMap.put("manCurrentAddress",
				nurturesWomen.getManCurrentAddress());
		nurturesWomenMap.put("singleChildCardno",
				nurturesWomen.getSingleChildCardno());
		nurturesWomenMap.put("certifiedUnit", nurturesWomen.getCertifiedUnit());
		nurturesWomenMap.put("isLevied", nurturesWomen.getIsLevied());
		nurturesWomenMap.put("isUnmarriedPregnant",
				nurturesWomen.getIsUnmarriedPregnant());
		nurturesWomenMap.put("isMaternityCard",
				nurturesWomen.getIsMaternityCard());
		nurturesWomenMap.put("singleChildCDIssueTime",
				nurturesWomen.getSingleChildCDIssueTime());
		nurturesWomenMap.put("maternityCardCheckTime",
				nurturesWomen.getMaternityCardCheckTime());
		nurturesWomenMap.put("maternityCardUnit",
				nurturesWomen.getMaternityCardUnit());
		nurturesWomenMap.put("maternityCardNo",
				nurturesWomen.getMaternityCardNo());
		nurturesWomenMap.put("maternityCardIssueTime",
				nurturesWomen.getMaternityCardIssueTime());
		nurturesWomenMap.put("maternityCardValidityTime",
				nurturesWomen.getMaternityCardValidityTime());
		nurturesWomenMap.put("maternityCardRemark",
				nurturesWomen.getMaternityCardRemark());
		nurturesWomenMap.put("manRemark", nurturesWomen.getManRemark());
		nurturesWomenMap.put("attentionExtent",
				nurturesWomen.getAttentionExtent());
		Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
		map.put(PopulationType.NURTURES_WOMEN, nurturesWomenMap);
		return map;
	}

	private void autoFillChinesePinyin(NurturesWomen nurturesWomen) {
		Map<String, String> pinyin = Chinese2pinyin
				.changeChinese2Pinyin(nurturesWomen.getName());
		nurturesWomen.setFullPinyin((String) pinyin.get("fullPinyin"));
		nurturesWomen.setSimplePinyin((String) pinyin.get("simplePinyin"));
	}

	private void copyProperty(ActualPopulation actualPopulation,
			Map<String, Object> population, NurturesWomen nurturesWomen) {
		copyProperties(nurturesWomen, actualPopulation);

		nurturesWomen.setFirstMarriageTime(Arrays.getDateValueFromArray(
				population, "firstMarriageTime"));
		nurturesWomen.setMarriageRegistrationTime(Arrays.getDateValueFromArray(
				population, "marriageRegistrationTime"));

		nurturesWomen.setLicenseSituation(Arrays.getPropertyDictFromArray(
				population, "licenseSituation.id"));
		nurturesWomen.setMarriageOrDivorceTime(Arrays.getDateValueFromArray(
				population, "marriageOrDivorceTime"));
		nurturesWomen.setFertilityServicesNo(Arrays.getStringValueFromArray(
				population, "fertilityServicesNo"));
		nurturesWomen.setLicenseTime(Arrays.getDateValueFromArray(population,
				"licenseTime"));
		nurturesWomen.setContraceptiveMethod(Arrays.getStringValueFromArray(
				population, "contraceptiveMethod"));
		nurturesWomen.setContraceptiveTime(Arrays.getDateValueFromArray(
				population, "contraceptiveTime"));
		nurturesWomen.setBoyNumber(Arrays.getIntValueFromArray(population,
				"boyNumber"));
		nurturesWomen.setGirlNumber(Arrays.getIntValueFromArray(population,
				"girlNumber"));

		nurturesWomen.setOnechildOfCouple(Arrays.getPropertyDictFromArray(
				population, "onechildOfCouple.id"));
		nurturesWomen.setManIdcardNo(Arrays.getStringValueFromArray(population,
				"manIdcardNo"));
		nurturesWomen.setManName(Arrays.getStringValueFromArray(population,
				"manName"));

		nurturesWomen.setManMaritalState(Arrays.getPropertyDictFromArray(
				population, "manMaritalState.id"));

		nurturesWomen.setManFirstMarriageTime(Arrays.getDateValueFromArray(
				population, "manFirstMarriageTime"));
		nurturesWomen.setManMobileNumber(Arrays.getStringValueFromArray(
				population, "manMobileNumber"));
		nurturesWomen.setManTelephone(Arrays.getStringValueFromArray(
				population, "manTelephone"));
		nurturesWomen.setManBirthday(Arrays.getDateValueFromArray(population,
				"manBirthday"));
		nurturesWomen.setManNation(Arrays.getPropertyDictFromArray(population,
				"manNation.id"));
		nurturesWomen.setManPoliticalBackground(Arrays
				.getPropertyDictFromArray(population,
						"manPoliticalBackground.id"));
		nurturesWomen.setManSchooling(Arrays.getPropertyDictFromArray(
				population, "manSchooling.id"));
		nurturesWomen.setManCareer(Arrays.getPropertyDictFromArray(population,
				"manCareer.id"));

		nurturesWomen.setManWorkUnit(Arrays.getStringValueFromArray(population,
				"manWorkUnit"));
		nurturesWomen.setManProvince(Arrays.getStringValueFromArray(population,
				"manProvince"));
		nurturesWomen.setManCity(Arrays.getStringValueFromArray(population,
				"manCity"));
		nurturesWomen.setManDistrict(Arrays.getStringValueFromArray(population,
				"manDistrict"));
		nurturesWomen.setManNativeplaceAddress(Arrays.getStringValueFromArray(
				population, "manNativeplaceAddress"));
		nurturesWomen.setManCurrentAddressType(Arrays.getPropertyDictFromArray(
				population, "manCurrentAddressType.id"));
		nurturesWomen.setManCommunity(Arrays.getStringValueFromArray(
				population, "manCommunity"));
		nurturesWomen.setManBlock(Arrays.getStringValueFromArray(population,
				"manBlock"));
		nurturesWomen.setManUnit(Arrays.getStringValueFromArray(population,
				"manUnit"));
		nurturesWomen.setManRoom(Arrays.getStringValueFromArray(population,
				"manRoom"));
		nurturesWomen.setManCurrentAddress(Arrays.getStringValueFromArray(
				population, "manCurrentAddress"));
		nurturesWomen.setSingleChildCardno(Arrays.getStringValueFromArray(
				population, "singleChildCardno"));
		nurturesWomen.setCertifiedUnit(Arrays.getStringValueFromArray(
				population, "certifiedUnit"));
		nurturesWomen.setLicenseTime(Arrays.getDateValueFromArray(population,
				"licenseTime"));
		nurturesWomen.setIsLevied(Arrays.getStringValueFromArray(population,
				"isLevied"));
		nurturesWomen.setIsUnmarriedPregnant(Arrays.getStringValueFromArray(
				population, "isUnmarriedPregnant"));
		nurturesWomen.setIsMaternityCard(Arrays.getStringValueFromArray(
				population, "isMaternityCard"));
		nurturesWomen.setSingleChildCDIssueTime(Arrays.getDateValueFromArray(
				population, "singleChildCDIssueTime"));
		nurturesWomen.setMaternityCardCheckTime(Arrays.getDateValueFromArray(
				population, "maternityCardCheckTime"));
		nurturesWomen.setMaternityCardUnit(Arrays.getStringValueFromArray(
				population, "maternityCardUnit"));
		nurturesWomen.setMaternityCardNo(Arrays.getStringValueFromArray(
				population, "maternityCardNo"));
		nurturesWomen.setMaternityCardRemark(Arrays.getStringValueFromArray(
				population, "maternityCardRemark"));

		nurturesWomen.setMaternityCardIssueTime(Arrays.getDateValueFromArray(
				population, "maternityCardIssueTime"));

		nurturesWomen
				.setMaternityCardValidityTime(Arrays.getDateValueFromArray(
						population, "maternityCardValidityTime"));
		nurturesWomen.setManRemark(Arrays.getStringValueFromArray(population,
				"manRemark"));
		nurturesWomen.setAttentionExtent(Arrays.getPropertyDictFromArray(
				population, "attentionExtent.id"));
		nurturesWomen
				.setAttentionPopulationType(BaseInfoTables.NURTURESWOMEN_KEY);
	}

	@Override
	public String[][] getExportPopertyArray() {
		if (GlobalSetting.NOT_DEPENDENT
				.equals(globalSettingService
						.getGlobalValue(GlobalSetting.BUSINESS_DEPENDENT_ACTUAL_POPULATION))) {
			return SpecialGroupsContext.getNurturesWomenPropertyArraySlf();
		} else {
			return SpecialGroupsContext.getNurturesWomenPropertyArrayRla();
		}
	}

	@Override
	public NurturesWomen hasDuplicateNurturesWomen(Long orgId, String idCardNo) {
		if (idCardNo == null || "".equals(idCardNo.trim()) || orgId == null) {
			return null;
		}
		String shardCode = shardConversion.getShardCode(orgId);
		return nurturesWomenDao.getNurturesWomenByIdCardNoAndOrganizationId(
				idCardNo, orgId, shardCode);
	}

	@Override
	public void deleteNurturesWomenByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			throw new BusinessValidationException("传入参数为空");
		}
		for (Long id : ids) {
			if (null == id || id < 0L) {
				throw new BusinessValidationException("育妇id不合法");
			}
			NurturesWomen nurturesWomen = nurturesWomenDao.getShard(id);
			nurturesWomenDao.deleteShard(id);

			if (IsEmphasis.Emphasis.equals(nurturesWomen.getIsEmphasis())) {
				// 缓存计数器
				PageInfoCacheThreadLocal.decrease(MemCacheConstant
						.getCachePageKey(NurturesWomen.class.getSimpleName()),
						nurturesWomen, 1);
			}
		}
	}

	@Override
	public NurturesWomen addNurturesWomenBaseInfo(NurturesWomen nurturesWomen) {
		if (!ExcelImportHelper.isImport.get()) {
			ValidateResult validateResult = domainValidator
					.validateBaseInfo(nurturesWomen);
			if (validateResult.hasError()) {
				throw new BusinessValidationException(
						validateResult.getErrorMessages());
			} else if (hasDuplicateNurturesWomen(nurturesWomen
					.getOrganization().getId(), nurturesWomen.getIdCardNo(),
					nurturesWomen.getId())) {
				throw new BusinessValidationException("该网格下已存在相同身份证号码");
			}
		}
		try {
			if (checkDataExitInCache(nurturesWomen,
					MemCacheConstant.CACHE_ADDNURTURESWOMENBASEINFO,
					CACHE_ADDNURTURESWOMENBASEINFO_VALUE)) {
				return nurturesWomen;
			}
			return add(nurturesWomen);
		} catch (Exception e) {
			logger.error("NurturesWomenServiceImpl addNurturesWomenBaseInfo", e);
			if (!ExcelImportHelper.isImport.get()) {
				throw new BusinessValidationException("新增信息出现错误");
			} else {
				return null;
			}
		} finally {
			cleanDataInCache(nurturesWomen,
					MemCacheConstant.CACHE_ADDNURTURESWOMENBASEINFO);
		}
	}

	@Override
	public Integer getCount(SearchNurturesWomenVo searchNurturesWomenVo) {
		return nurturesWomenDao.getCount(searchNurturesWomenVo);
	}

	@Override
	public NurturesWomen updateNurturesWomeForMobile(NurturesWomen nurturesWomen) {
		try {
			autoFilled(nurturesWomen);
			contructCurrentAddress(nurturesWomen);
			proccessHouseBind(nurturesWomen);
			updateNurturesWomenBaseInfo(nurturesWomen);

			nurturesWomen = nurturesWomenDao.updateBusinessShard(nurturesWomen);
			PageInfoCacheThreadLocal.update(
					MemCacheConstant.getCachePageKey(NurturesWomen.class),
					nurturesWomen, UpdateType.BUSINESS);
		} catch (Exception e) {
			logger.error(
					"类NURTURES_WOMENServiceImpl的updateNurturesWomen方法出现异常，原因：",
					e);
			if (!ExcelImportHelper.isImport.get()) {
				throw new BusinessValidationException("更改孕妇出现错误");
			} else {
				return null;
			}
		}

		return nurturesWomen;
	}

	@Override
	public void deleteBusinessPopulationDuplicate(Long id) {
		if (id != null) {
			List<Long> ids = new ArrayList<Long>();
			ids.add(id);
			deleteNurturesWomenByIdList(ids);
		}
	}

}

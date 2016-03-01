package com.tianque.baseInfo.floatingPopulation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tianque.baseInfo.actualHouse.domain.HouseInfo;
import com.tianque.baseInfo.actualHouse.service.ActualHouseService;
import com.tianque.baseInfo.base.domain.ActualPopulation;
import com.tianque.baseInfo.base.domain.Countrymen;
import com.tianque.baseInfo.base.domain.LogoutDetail;
import com.tianque.baseInfo.base.domain.People;
import com.tianque.baseInfo.base.helper.CardNoHelper;
import com.tianque.baseInfo.base.service.AddressInfoService;
import com.tianque.baseInfo.base.service.BaseInfoIdCardChangeProcessorService;
import com.tianque.baseInfo.base.service.BaseInfoPopulationTemplateImpl;
import com.tianque.baseInfo.base.service.BaseInfoService;
import com.tianque.baseInfo.earlyWarning.domain.EarlyWarning;
import com.tianque.baseInfo.earlyWarning.service.EarlyWarningService;
import com.tianque.baseInfo.familyInfo.domain.GroupFamily;
import com.tianque.baseInfo.familyInfo.service.GroupFamilyService;
import com.tianque.baseInfo.floatingPopulation.dao.FloatingPopulationDao;
import com.tianque.baseInfo.floatingPopulation.domain.FloatingPopulation;
import com.tianque.baseInfo.householdStaff.domain.HouseholdStaff;
import com.tianque.baseInfo.householdStaff.service.HouseholdStaffService;
import com.tianque.baseInfo.utils.CollectionsUtil;
import com.tianque.baseInfo.utils.PopulationCopyUtil;
import com.tianque.cache.PageInfoCacheThreadLocal;
import com.tianque.cache.UpdateType;
import com.tianque.controller.annotation.SolrServerIndex;
import com.tianque.core.cache.constant.MemCacheConstant;
import com.tianque.core.cache.service.CacheService;
import com.tianque.core.datatransfer.ExcelImportHelper;
import com.tianque.core.util.BaseInfoTables;
import com.tianque.core.util.Chinese2pinyin;
import com.tianque.core.util.CollectionUtil;
import com.tianque.core.util.EarlyWarningName;
import com.tianque.core.util.GridProperties;
import com.tianque.core.util.NewBaseInfoTables;
import com.tianque.core.util.PeopleHelper;
import com.tianque.core.util.StringUtil;
import com.tianque.core.util.ThreadVariable;
import com.tianque.core.validate.ValidateResult;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Organization;
import com.tianque.domain.PopulationTypeBean;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.domain.vo.SearchFloatingPopulationVo;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.exception.base.ServiceValidationException;
import com.tianque.gis.domain.vo.PopulationVo;
import com.tianque.gis.service.SearchGisPopulationService;
import com.tianque.jms.OperateMode;
import com.tianque.jms.sender.ActiveMQMessageSender;
import com.tianque.jms.util.TransferData;
import com.tianque.plugin.tqSearch.domain.TqSearchResults;
import com.tianque.plugin.tqSearch.domain.TqSearchVo;
import com.tianque.plugin.tqSearch.dubboService.TqSearchService;
import com.tianque.plugin.tqSearch.sqlMap.DeleteSqlMap;
import com.tianque.plugin.tqSearch.sqlMap.UpdateSqlMap;
import com.tianque.plugin.tqSearch.syncSolrIndex.SyncPopulationSolrIndexForMQ;
import com.tianque.service.ActualBaseInfoSyncService;
import com.tianque.service.ActualPopulationService;
import com.tianque.service.HouseInfoService;
import com.tianque.service.HousePopulationMaintanceService;
import com.tianque.service.PopulationTypeService;
import com.tianque.service.helper.ManagePopulationByHouseHelper;
import com.tianque.service.util.PopulationCatalog;
import com.tianque.service.util.PopulationType;
import com.tianque.service.vo.IsEmphasis;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.systemOperateLog.service.SystemOperateLogService;
import com.tianque.systemOperateLog.util.SystemOperateType;
import com.tianque.userAuth.api.PermissionDubboService;
import com.tianque.util.IdCardUtil;
import com.tianque.util.PropertyUtil;
import com.tianque.validate.AbstractCountrymenValidator;

@Service("floatingPopulationService")
@Transactional
public class FloatingPopulationServiceImpl extends
		BaseInfoPopulationTemplateImpl implements FloatingPopulationService,
		ActualPopulationService, SearchGisPopulationService,
		ActualBaseInfoSyncService, BaseInfoIdCardChangeProcessorService {

	private static final String CACHE_ADDFLOATINGPOPULATIONBASEINFO_VALUE = "ADDFLOATINGPOPULATIONBASEINFO";
	@Autowired
	private PropertyDictService propertyDictService;
	@Autowired
	private FloatingPopulationDao floatingPopulationDao;
	@Autowired
	private OrganizationDubboService organizationDubboService;
	@Autowired
	private ManagePopulationByHouseHelper managePopulationByHouseHelper;
	@Autowired
	private ActualHouseService actualHouseService;
	@Autowired
	private HouseInfoService houseInfoService;
	@Autowired
	private GroupFamilyService groupFamilyService;
	@Autowired
	private HouseholdStaffService householdStaffService;
	@Autowired
	private PopulationTypeService populationTypeService;
	@Autowired
	private HousePopulationMaintanceService housePopulationMaintanceService;
	@Autowired
	private BaseInfoService baseInfoService;
	@Autowired
	private AddressInfoService addressInfoService;
	@Autowired
	private SystemOperateLogService systemOperateLogService;
	@Autowired
	private EarlyWarningService earlyWarningService;
	@Autowired
	private TqSearchService tqSearchService;
	@Autowired
	private PermissionDubboService permissionDubboService;

	@Qualifier("floatingPopulationValidator")
	@Autowired
	private AbstractCountrymenValidator<FloatingPopulation> validator;
	@Qualifier("peopleHelper")
	@Autowired
	private PeopleHelper peopleHelper;
	@Autowired
	private CacheService cacheService;
	@Autowired
	private ActiveMQMessageSender activeMQMessageSender;
	@Autowired
	private SyncPopulationSolrIndexForMQ syncPopulationSolrIndexForMQ;

	@Resource(name = "floatingPopulationDao")
	public void setBaseInfoPopulationBaseDao(
			FloatingPopulationDao floatingPopulationDao) {
		super.setBaseInfoPopulationBaseDao(floatingPopulationDao);
	}

	@Override
	public FloatingPopulation addFloatingPopulation(
			FloatingPopulation floatingPopulation) {
		String key = "";
		try {
			OperateMode mode = OperateMode.IMPORT;
			if (!ExcelImportHelper.isImport.get()) {
				mode = OperateMode.ADD;
				validate(floatingPopulation);
			}
			if (floatingPopulation != null
					&& floatingPopulation.getIdCardNo() != null
					&& floatingPopulation.getOrganization() != null
					&& floatingPopulation.getOrganization().getId() != null) {
				key = MemCacheConstant.getPopulationKey(
						MemCacheConstant.CACHE_ADDFLOATINGPOPULATION,
						floatingPopulation.getIdCardNo(), floatingPopulation
								.getOrganization().getId());
				String value = (String) cacheService.get(
						MemCacheConstant.POPULATION_NAMESPACE, key);
				if (value == null || "".equals(value)) {
					cacheService.set(MemCacheConstant.POPULATION_NAMESPACE,
							key, 300, "CACHE_ADDFLOATINGPOPULATION");
				} else {
					return floatingPopulation;
				}
			}
			FloatingPopulation temp = add(floatingPopulation, mode);
			syncPopulationSolrIndexForMQ.sendPopulationSolrIndexForMQ(temp,
					BaseInfoTables.FLOATINGPOPULATION_KEY, OperateMode.ADD);
			return temp;
		} catch (Exception e) {
			logger.error("FloatingPopulationServiceImpl addFloatingPopulation",
					e);
			if (!ExcelImportHelper.isImport.get()) {
				throw new BusinessValidationException("新增信息出现错误");
			} else {
				return null;
			}
		} finally {
			if (!"".equals(key)) {
				cacheService.remove(MemCacheConstant.POPULATION_NAMESPACE, key);
			}
		}
	}

	@Override
	public FloatingPopulation addFloatingPopulationForMobile(
			FloatingPopulation floatingPopulation) {
		ValidateResult result = new ValidateResult();
		String key = "";
		try {
			if (!ExcelImportHelper.isImport.get()) {
				validate(floatingPopulation);
			}

			if (floatingPopulation.getOrganization() != null
					&& floatingPopulation.getOrganization().getId() != null) {
				result = validator.validatorIdCardNoExistedMessage(
						floatingPopulation.getOrganization().getId(),
						floatingPopulation.getIdCardNo(),
						floatingPopulation.getActualPopulationType(), null,
						result);
				String errorMessages = result.getErrorMessages();
				if (errorMessages != null && !"".equals(errorMessages)) {
					throw new BusinessValidationException(errorMessages
							+ "重复身份证");
				}
			}
			if (floatingPopulation != null
					&& floatingPopulation.getIdCardNo() != null
					&& floatingPopulation.getOrganization() != null
					&& floatingPopulation.getOrganization().getId() != null) {
				key = MemCacheConstant.getPopulationKey(
						MemCacheConstant.CACHE_ADDFLOATINGPOPULATIONFORMOBILE,
						floatingPopulation.getIdCardNo(), floatingPopulation
								.getOrganization().getId());
				String value = (String) cacheService.get(
						MemCacheConstant.POPULATION_NAMESPACE, key);
				if (value == null || "".equals(value)) {
					cacheService.set(MemCacheConstant.POPULATION_NAMESPACE,
							key, 300, "CACHE_ADDFLOATINGPOPULATION");
				} else {
					return floatingPopulation;
				}
			}
			FloatingPopulation temp = add(floatingPopulation, null);
			syncPopulationSolrIndexForMQ.sendPopulationSolrIndexForMQ(temp,
					BaseInfoTables.FLOATINGPOPULATION_KEY, OperateMode.ADD);
			return temp;
		} catch (Exception e) {
			logger.error(
					"FloatingPopulationServiceImpl addFloatingPopulationForMobile",
					e);
			if (!ExcelImportHelper.isImport.get()) {
				throw new BusinessValidationException("新增信息出现错误");
			} else {
				return null;
			}
		} finally {
			if (!"".equals(key)) {
				cacheService.remove(MemCacheConstant.POPULATION_NAMESPACE, key);
			}
		}
	}

	private FloatingPopulation add(FloatingPopulation floatingPopulation,
			OperateMode mode) {
		try {
			String attentionPopulationType = floatingPopulation
					.getAttentionPopulationType();
			autoFillFieldsValue(floatingPopulation);
			Long houseId = floatingPopulation.getHouseId();
			Countrymen temp;
			if (floatingPopulation.getBaseInfoId() == null) {
				temp = baseInfoService.getBaseInfoByIdCardNo(floatingPopulation
						.getIdCardNo());
				if (temp != null) {
					floatingPopulation.setBaseInfoId(temp.getId());
					temp = baseInfoService.update(floatingPopulation);
				} else {
					temp = baseInfoService.add(floatingPopulation);
				}
			} else {
				temp = baseInfoService.update(floatingPopulation);
			}
			floatingPopulation.setBaseInfoId(temp.getId());
			maintainAddressInfo(floatingPopulation);
			if (floatingPopulation.getLogOut() == null) {
				floatingPopulation.setLogOut(IsEmphasis.Emphasis);
			}
			floatingPopulation = floatingPopulationDao.add(floatingPopulation);
			floatingPopulation.setHouseId(houseId);
			proccessHouseBind(floatingPopulation);
			// 在新增修改业务人员返回实口信息时，把新增的房屋id返回
			if (floatingPopulation.getIsHaveHouse() != null
					&& floatingPopulation.getIsHaveHouse()) {
				floatingPopulation.setHouseId(managePopulationByHouseHelper
						.getPopulationLivingHouseId(
								PopulationCatalog.FLOATING_POPULATION,
								floatingPopulation.getId()));
			}
			if (mode != null
					&& !BaseInfoTables.NURTURESWOMEN_KEY
							.equals(attentionPopulationType)
					&& !BaseInfoTables.ELDERLYPEOPLE_KEY
							.equals(attentionPopulationType)) {
				sendActiveMQ(floatingPopulation, mode);
			}

			if (IsEmphasis.Emphasis.equals(floatingPopulation.getLogOut())) {
				// 缓存计数器
				PageInfoCacheThreadLocal.increment(MemCacheConstant
						.getCachePageKey(floatingPopulation.getClass()
								.getSimpleName()), floatingPopulation, 1);
			}
		} catch (Exception e) {
			throw new ServiceValidationException("保存数据错误", e);
		}
		return floatingPopulation;
	}

	private void validate(FloatingPopulation floatingPopulation) {
		ValidateResult dataValidator = validator.validate(floatingPopulation);
		if (dataValidator.hasError()) {
			throw new BusinessValidationException(
					dataValidator.getErrorMessages());
		}
	}

	@Override
	public FloatingPopulation updateFloatingPopulation(
			FloatingPopulation floatingPopulation) {
		try {
			autoFileIdCardNoOrgInternalCodeAndPinyin(floatingPopulation);
			if (!ExcelImportHelper.isImport.get()) {
				validateUnmodifiedFields(floatingPopulation);
			}
			contructCurrentAddress(floatingPopulation);
			proccessHouseBind(floatingPopulation);

			if (floatingPopulation.isDeath() == true) {
				floatingPopulation.setLogOut(IsEmphasis.IsNotEmphasis);
			}
			updateIsDeath(floatingPopulation);
			baseInfoService.update(floatingPopulation);
			maintainAddressInfo(floatingPopulation);
			if (floatingPopulation.getLogOut() == null) {
				floatingPopulation.setLogOut(IsEmphasis.Emphasis);
			}
			floatingPopulation = floatingPopulationDao
					.updateFloatingPopulation(floatingPopulation);

			groupFamilyService.updateGroupFamilyByObj(
					parseToGroupFamilyByFloatingPopulation(floatingPopulation),
					floatingPopulation.getId(),
					BaseInfoTables.FLOATINGPOPULATION_KEY,
					floatingPopulation.isDeath());
			FloatingPopulation temp = getFloatingPopulationById(floatingPopulation
					.getId());
			syncPopulationSolrIndexForMQ.sendPopulationSolrIndexForMQ(temp,
					BaseInfoTables.FLOATINGPOPULATION_KEY, OperateMode.EDIT);
			return temp;
		} catch (Exception e) {
			logger.error(
					"FloatingPopulationServiceImpl updateFloatingPopulation", e);
			if (!ExcelImportHelper.isImport.get()) {
				throw new BusinessValidationException("修改信息出现错误");
			} else {
				return null;
			}
		}
	}

	private GroupFamily parseToGroupFamilyByFloatingPopulation(
			FloatingPopulation floatingPopulation) {
		GroupFamily groupFamily = new GroupFamily();
		groupFamily.setFamilyMaster(floatingPopulation.getName());
		groupFamily.setMasterCardNo(floatingPopulation.getIdCardNo());
		groupFamily.setMasterMobileNumber(floatingPopulation.getMobileNumber());
		groupFamily.setMasterTelephone(floatingPopulation.getTelephone());
		return groupFamily;
	}

	@Override
	public ActualPopulation updateActualPopulationBaseInfo(
			ActualPopulation actualPopulation) {
		try {
			FloatingPopulation floatingPopulation = getFloatingPopulationById(actualPopulation
					.getId());
			PropertyUtil.copyPropertiesWithRecursion(ActualPopulation.class,
					floatingPopulation, actualPopulation, new String[] { "id",
							"houseCode", "houseId" });
			return updateFloatingPopulationBaseInfo(floatingPopulation);
		} catch (Exception e) {
			throw new ServiceValidationException("修改流动人口基本信息出错", e);
		}
	}

	@Override
	@SolrServerIndex(mode = OperateMode.EDIT, value = UpdateSqlMap.FLOATINGPOPULATION_KEY)
	public FloatingPopulation updateFloatingPopulationBaseInfo(
			FloatingPopulation population) {
		try {
			autoFileIdCardNoOrgInternalCodeAndPinyin(population);
			contructCurrentAddress(population);
			updateIsDeath(population);
			baseInfoService.update(population);
			maintainAddressInfo(population);
			proccessHouseBind(population);
			FloatingPopulation temp = getFloatingPopulationById(population
					.getId());
			syncPopulationSolrIndexForMQ.sendPopulationSolrIndexForMQ(temp,
					BaseInfoTables.FLOATINGPOPULATION_KEY, OperateMode.EDIT);
			floatingPopulationDao.updateTableUpdateDateById(population.getId());
			return temp;
		} catch (Exception e) {
			throw new ServiceValidationException("修改流动人口基本信息出错", e);
		}
	}

	private void updateIsDeath(FloatingPopulation population) {
		if (population.isDeath() == true) {
			LogoutDetail logoutDetail = new LogoutDetail();
			logoutDetail.setLogout(IsEmphasis.IsNotEmphasis);
			logoutDetail.setLogoutDate(new Date());
			logoutDetail.setLogoutReason(LogoutDetail.LOGOUT_REASON_FOR_DEATH);
			// updateLogOutByPopulationTypeAndId(logoutDetail,
			// population.getActualPopulationType(), population.getId());
			List<FloatingPopulation> floatingPopulations = getFloatingPopulationByBaseInfoId(population
					.getBaseInfoId());
			if (floatingPopulations != null) {
				for (FloatingPopulation f : floatingPopulations) {
					updateLogOutByPopulationTypeAndId(logoutDetail,
							BaseInfoTables.FLOATINGPOPULATION_KEY, f.getId());
				}
			}
			List<HouseholdStaff> householdStaffs = householdStaffService
					.getHouseholdStaffByBaseInfoId(population.getBaseInfoId());
			if (householdStaffs != null) {
				for (HouseholdStaff h : householdStaffs) {
					updateLogOutByPopulationTypeAndId(logoutDetail,
							BaseInfoTables.HOUSEHOLDSTAFF_KEY, h.getId());
				}
			}
		}
	}

	private void maintainAddressInfo(FloatingPopulation population) {
		Countrymen temp = null;
		Long id = population.getId();
		if (population.getAddressInfoId() != null) {
			temp = addressInfoService.update(population);
		} else {
			temp = addressInfoService.add(population);
		}
		population.setId(id);
		population.setAddressInfoId(temp.getId());
	}

	@Override
	public void updateLogOutByPopulationTypeAndId(LogoutDetail logoutDetail,
			String populationType, Long id) {
		super.updateLogOutByPopulationTypeAndId(logoutDetail, populationType,
				id);
	}

	/**
	 * 如果人口的房屋信息（CurrentAddress）不为空，并且房屋id不存在，新增一个房屋，并且建立关联关系, 如果房屋id不为空直接建立关联关系
	 * 
	 * 如果房屋信息为空,并且有房屋id不为空，则删除人房关系
	 * 
	 * @param population
	 */
	private void proccessHouseBind(FloatingPopulation population) {
		if (null != population.getIsHaveHouse() && population.getIsHaveHouse()
				&& population.getCurrentAddress() != null) {

			if (null == population.getHouseId()
					|| population.getHouseId().equals(01L)) {
				// 新增一个实有房屋,并且建立人房关系
				HouseInfo houseInfo = new HouseInfo();
				houseInfo.setAddress(population.getCurrentAddress());
				houseInfo.setAddressType(propertyDictService
						.findPropertyDictByDomainNameAndDictDisplayName(
								PropertyTypes.CURRENT_ADDRESS_TYPE, "其他"));
				houseInfo.setOrganization(population.getOrganization());
				houseInfo
						.setHouseOperateSource(NewBaseInfoTables.FLOATINGPOPULATION_KEY);
				houseInfo = actualHouseService.addHouseInfo(houseInfo);

				managePopulationByHouseHelper.reBindHouseIfNecc(
						PopulationCatalog.FLOATING_POPULATION, population,
						houseInfo.getId());
				population.setHouseId(houseInfo.getId());
				businessPopulationHouseRelationUpdate(population);
			} else if (population.getHouseId() != null) {
				managePopulationByHouseHelper.reBindHouseIfNecc(
						PopulationCatalog.FLOATING_POPULATION, population,
						population.getHouseId());
				businessPopulationHouseRelationUpdate(population);
			}

		} else {
			housePopulationMaintanceService.releaseHouse(
					PopulationCatalog.FLOATING_POPULATION, population.getId(),
					population.getHouseId());
			businessPopulationHouseRelationDelete(population);
		}
	}

	// 清除房屋流口地址时 对应清楚业务人员房屋的关联关系
	private void businessPopulationHouseRelationDelete(
			FloatingPopulation population) {
		List<PopulationTypeBean> list = populationTypeService
				.getPopulationTypeByActualIdAndType(population.getId(),
						population.getActualtype());
		for (PopulationTypeBean temp : list) {
			housePopulationMaintanceService.releaseHouse(PopulationCatalog
					.populationCatalog(temp.getPopulationType()), temp
					.getPopulationId(), population.getHouseId());
		}
	}

	// 修改房屋流口地址时 对应修改业务人员房屋的关联关系
	private void businessPopulationHouseRelationUpdate(
			FloatingPopulation population) {
		List<PopulationTypeBean> list = populationTypeService
				.getPopulationTypeByActualIdAndType(population.getId(),
						population.getActualtype());
		People tempPeople = null;
		for (PopulationTypeBean temp : list) {
			tempPeople = new People();
			tempPeople.setId(temp.getPopulationId());
			managePopulationByHouseHelper.reBindHouseIfNecc(PopulationCatalog
					.populationCatalog(temp.getPopulationType()), tempPeople,
					population.getHouseId());
		}
	}

	private void loadHouseInfo(FloatingPopulation population) {
		managePopulationByHouseHelper.loadLivingHouseIfNecc(
				PopulationCatalog.FLOATING_POPULATION, population);
	}

	private void autoFileIdCardNoOrgInternalCodeAndPinyin(
			FloatingPopulation floatingPopulation) {
		floatingPopulation.setIdCardNo(floatingPopulation.getIdCardNo()
				.toUpperCase());
		floatingPopulation.setOrgInternalCode(organizationDubboService
				.getSimpleOrgById(floatingPopulation.getOrganization().getId())
				.getOrgInternalCode());
		autoFillChinesePinyin(floatingPopulation);
		autoFillGender(floatingPopulation);
		if (floatingPopulation.getBirthday() != null) {
			autoFillBirthday(floatingPopulation);
		}
	}

	@Override
	public void syncActualPopulationByDeleteHousePopulationRela(
			Long populationId, Boolean isHaveHouse, String noHouseReason) {

		floatingPopulationDao
				.updateFloatingPopulationByDeleteHousePopulationRela(
						populationId, isHaveHouse, noHouseReason);
	}

	@Override
	public FloatingPopulation findFloatingPopulationByCardNoAndOrgId(
			String idCardNo, Long orgId) {
		if (idCardNo == null || "".equals(idCardNo.trim()) || orgId == null) {
			return null;
		}
		idCardNo = idCardNo.toUpperCase();
		// String idCardNo15 = "";
		// String idCardNo18 = "";
		// if (idCardNo.length() == 15) {
		// idCardNo15 = idCardNo;
		// idCardNo18 = IdCardUtil.idCardNo15to18(idCardNo, "19");
		// } else if (idCardNo.length() == 18) {
		// idCardNo15 = IdCardUtil.idCardNo18to15(idCardNo);
		// idCardNo18 = idCardNo;
		// }
		Countrymen countrymen = baseInfoService.getBaseInfoByIdCardNo(idCardNo);
		if (countrymen == null) {
			return null;
		}
		return getFloatingPopulationByBaseInfoId(countrymen.getId(), orgId);

	}

	private void autoFillFieldsValue(FloatingPopulation floatingPopulation) {
		autoFileIdCardNoOrgInternalCodeAndPinyin(floatingPopulation);
		if (floatingPopulation.isDeath()) {
			floatingPopulation.setLogOut(IsEmphasis.IsNotEmphasis);
		} else {
			floatingPopulation.setLogOut(IsEmphasis.Emphasis);
		}
		contructCurrentAddress(floatingPopulation);
	}

	@Override
	public PageInfo<FloatingPopulation> searchFloatingPopulations(
			Integer pageNum, Integer pageSize, String sortField, String order,
			SearchFloatingPopulationVo searchFloatingPopulationVo) {
		PageInfo<FloatingPopulation> fpPage = floatingPopulationDao
				.searchFloatingPopulations(pageNum, pageSize, sortField, order,
						searchFloatingPopulationVo);
		for (FloatingPopulation fp : fpPage.getResult()) {
			// 获取人员信息（需要）
			managePopulationByHouseHelper.loadLivingHouseIfNecc(
					PopulationCatalog.FLOATING_POPULATION, fp);
		}
		fpPage=hiddenIdCard(fpPage);
		return fpPage;
	}

	@Override
	public PageInfo<FloatingPopulation> fastSearchFloatingPopulations(
			Integer pageNum, Integer pageSize, String sortField, String order,
			SearchFloatingPopulationVo searchFloatingPopulationVo) {
		if (searchFloatingPopulationVo.getOrgInternalCode() == null) {
			return constructEmptyPageInfo();
		}
		PageInfo<FloatingPopulation> fpPage = new PageInfo<FloatingPopulation>();
		boolean isTqSearch = GridProperties.ISTQSEARCH;
		if (isTqSearch) {
			try {
				fpPage = fastSearchFormTqSearch(
						searchFloatingPopulationVo.getFastSearchKeyWords(),
						searchFloatingPopulationVo.getOrgInternalCode(),
						pageNum, pageSize);
				fillMeassgesByPageInfo(fpPage, true);
				return fpPage;
			} catch (Exception e) {
				isTqSearch = false;
				logger.error("流动人口统一搜索快速检索失败：" + e);
			}
		}
		if (!isTqSearch) {
			fpPage = floatingPopulationDao.fastSearchFloatingPopulations(
					pageNum, pageSize, sortField, order,
					searchFloatingPopulationVo);
		}
		Set<Long> houseInfoIds = new HashSet<Long>();
		for (FloatingPopulation floatingPopulation : fpPage.getResult()) {
			houseInfoIds.add(floatingPopulation.getAddressInfoId());
		}
		List<Countrymen> houseList = addressInfoService
				.getAddressInfoByIdForList(new ArrayList<Long>(houseInfoIds));
		for (FloatingPopulation fp : fpPage.getResult()) {
			for (Countrymen countrymen : houseList) {
				if (countrymen.getId().equals(fp.getAddressInfoId())) {
					PopulationCopyUtil.copyAddressInfoMessage(countrymen, fp);
				}
			}
			if (fp.getIsHaveHouse() != null && fp.getIsHaveHouse()
					&& fp.getHouseId() != null) {
				fp.setHouseId(managePopulationByHouseHelper
						.getPopulationLivingHouseId(
								PopulationCatalog.FLOATING_POPULATION,
								fp.getId()));
				fp.setHouseCode(houseInfoService.getSimpleHouseInfoById(
						fp.getHouseId()).getHouseCode());
			}
		}
		//隐藏身份证中间4位
		fpPage=hiddenIdCard(fpPage);
		return fpPage;
	}

	private PageInfo<FloatingPopulation> fastSearchFormTqSearch(
			String fastSearchKeyWords, String orgInternalCode, Integer pageNum,
			Integer pageSize) {
		PageInfo<FloatingPopulation> hhsPage = new PageInfo<FloatingPopulation>();
		TqSearchVo tqSearchVo = new TqSearchVo();
		tqSearchVo.setPage(pageNum);
		tqSearchVo.setRows(pageSize);
		tqSearchVo.setType("populationFastSearch");
		tqSearchVo.getSearchs().put("orgInternalCode", orgInternalCode + "*");
		tqSearchVo.getSearchs().put("dataType", "floatingPopulation");
		tqSearchVo.getSearchs().put("logOut", 0);
		String sql = "idCardNo:?* OR name:?* OR simplepinyin:?* OR fullpinyin:?*";
		sql = sql.replaceAll("\\?", fastSearchKeyWords);
		tqSearchVo.setSql(sql);
		TqSearchResults tqSearchResults = tqSearchService
				.queryForResult(tqSearchVo);
		hhsPage = new PageInfo(tqSearchResults.getPageNum(),
				tqSearchResults.getPageSize(),
				(int) tqSearchResults.getCountNum(),
				convertFloatingPopulationList(tqSearchResults.getResult()));
		return hhsPage;
	}

	private PageInfo<FloatingPopulation> constructEmptyPageInfo() {
		PageInfo<FloatingPopulation> result = new PageInfo<FloatingPopulation>();
		result.setResult(new ArrayList<FloatingPopulation>());
		return result;
	}

	private List<FloatingPopulation> convertFloatingPopulationList(
			List<Map<String, Object>> valueMaps) {
		List<FloatingPopulation> floatingPopulations = new ArrayList<FloatingPopulation>();
		for (Map<String, Object> valueMap : valueMaps) {
			floatingPopulations.add(convertFloatingPopulation(valueMap));
		}
		return floatingPopulations;
	}

	private FloatingPopulation convertFloatingPopulation(Map<String, Object> map) {
		FloatingPopulation floatingPopulation = new FloatingPopulation();
		floatingPopulation.setId(convertLong(map.get("dataId")));
		floatingPopulation.setBaseInfoId(convertLong(map.get("baseinfoId")));
		floatingPopulation.setAddressInfoId(convertLong(map
				.get("addressinfoId")));
		return floatingPopulation;
	}

	@Override
	public List<FloatingPopulation> searchAllFloatingPopulations(String sidx,
			String sord, SearchFloatingPopulationVo searchFloatingPopulationVo) {
		List<FloatingPopulation> fplist = floatingPopulationDao
				.searchAllFloatingPopulations(sidx, sord,
						searchFloatingPopulationVo);
		for (FloatingPopulation fp : fplist) {
			// fateson add 导出时候 出错
			if (fp.getIsHaveHouse() == null) {
				continue;
			}
			if (fp.getIsHaveHouse()) {
				fp.setHouseId(managePopulationByHouseHelper
						.getPopulationLivingHouseId(
								PopulationCatalog.FLOATING_POPULATION,
								fp.getId()));
				fp.setHouseCode(houseInfoService.getSimpleHouseInfoById(
						fp.getHouseId()).getHouseCode());
			}

		}
		return fplist;
	}

	@Override
	public PageInfo<FloatingPopulation> findFloatingPopulationsForPageByOrgId(
			Long organizationId, Integer pageNum, Integer pageSize,
			String sortField, String order, Long logOut, Boolean isDeath) {
		return floatingPopulationDao
				.findFloatingPopulationsForPageByOrgInternalCode(
						organizationDubboService.getSimpleOrgById(
								organizationId).getOrgInternalCode(), pageNum,
						pageSize, sortField, order, logOut, isDeath);
	}

	@Override
	public PageInfo<FloatingPopulation> findFloatingPopulationsForPageByOrgIdDefaultList(
			Long organizationId, Integer pageNum, Integer pageSize,
			final String sortField, final String order, Long logOut,
			Boolean isDeath) {

		Map<String, Object> query = new HashMap<String, Object>();
		query.put("orgInternalCode",
				organizationDubboService.getSimpleOrgById(organizationId)
						.getOrgInternalCode());
		query.put("logOut", logOut);
		query.put("isDeath", isDeath);
		query.put("sortField", "id");
		query.put("order", "desc");

		PageInfo<FloatingPopulation> pageInfo = floatingPopulationDao
				.findPagerUsingCacheBySearchVo(organizationId, query, pageNum,
						pageSize, "FloatingPopulationsDefaultList",
						MemCacheConstant
								.getCachePageKey(FloatingPopulation.class
										.getSimpleName()));

		// PageInfo<FloatingPopulation> pageInfo = floatingPopulationDao
		// .findFloatingPopulationsForPageByOrgInternalCodeDefaultList(
		// organizationDubboService.getSimpleOrgById(organizationId)
		// .getOrgInternalCode(), pageNum, pageSize, "id",
		// "desc", logOut, isDeath);
		fillMeassgesByPageInfo(pageInfo, false);
		new CollectionsUtil<FloatingPopulation>().sortList(
				pageInfo.getResult(), order, sortField);
		//隐藏身份证中间4位
		pageInfo=hiddenIdCard(pageInfo);
		return pageInfo;
	}
	
	//隐藏身份证中间4位
	private PageInfo<FloatingPopulation> hiddenIdCard(PageInfo<FloatingPopulation> pageInfo){
				//判断权限，有权限不隐藏
				if(permissionDubboService.
						isUserHasPermission(ThreadVariable.getUser().getId(), "isFloatingPopulationNotHidCard")){
					return pageInfo;
				}
				List<FloatingPopulation> list = pageInfo.getResult();
				int index=0;
				for (FloatingPopulation verification:list) {
					verification.setIdCardNo(IdCardUtil.hiddenIdCard(verification.getIdCardNo()));
					list.set(index, verification);
					index++;
				}
				pageInfo.setResult(list);
				return pageInfo;
		}

	private void fillMeassgesByPageInfo(PageInfo<FloatingPopulation> hhsPage,
			boolean fillFloatingMessage) {
		if (hhsPage.getResult() == null || hhsPage.getResult().size() < 1) {
			return;
		}
		Set<Long> baseInfoIds = new HashSet<Long>();
		Set<Long> houseInfoIds = new HashSet<Long>();
		List<Long> floatingPopulationIds = new ArrayList<Long>();
		for (FloatingPopulation floatingPopulation : hhsPage.getResult()) {
			houseInfoIds.add(floatingPopulation.getAddressInfoId());
			baseInfoIds.add(floatingPopulation.getBaseInfoId());
			floatingPopulationIds.add(floatingPopulation.getId());
		}

		List<Countrymen> houseList = addressInfoService
				.getAddressInfoByIdForList(new ArrayList<Long>(houseInfoIds));
		List<Countrymen> baseInfoList = baseInfoService
				.getBaseInfoByIdForList(new ArrayList<Long>(baseInfoIds));
		List<FloatingPopulation> floatingPopulationList = new ArrayList<FloatingPopulation>();
		if (fillFloatingMessage) {
			floatingPopulationList = findFloatingPopulationByIds(floatingPopulationIds);
		}
		List<FloatingPopulation> notExisted = new ArrayList<FloatingPopulation>();
		for (FloatingPopulation floatingPopulation : hhsPage.getResult()) {
			for (Countrymen countrymen : houseList) {
				if (countrymen.getId().equals(
						floatingPopulation.getAddressInfoId())) {
					PopulationCopyUtil.copyAddressInfoMessage(countrymen,
							floatingPopulation);
				}
			}
			for (Countrymen countrymen : baseInfoList) {
				if (countrymen.getId().equals(
						floatingPopulation.getBaseInfoId())) {
					PopulationCopyUtil.copyBaseInfoMessage(countrymen,
							floatingPopulation);
				}
			}
			if (fillFloatingMessage) {
				boolean isExisted = false;
				for (FloatingPopulation countrymen : floatingPopulationList) {
					if (countrymen.getId().equals(floatingPopulation.getId())) {
						PopulationCopyUtil.copyFloatingPopulationMessage(
								countrymen, floatingPopulation);
						isExisted = true;
					}
				}
				if (!isExisted) {
					notExisted.add(floatingPopulation);
				}
			}
		}
		hhsPage.getResult().removeAll(notExisted);
		hhsPage.setTotalRowSize(hhsPage.getTotalRowSize() - notExisted.size());
	}

	private void autoFillChinesePinyin(FloatingPopulation floatingPopulation) {
		Map<String, String> pinyin = Chinese2pinyin
				.changeChinese2Pinyin(floatingPopulation.getName());
		floatingPopulation.setFullPinyin((String) pinyin.get("fullPinyin"));
		floatingPopulation.setSimplePinyin((String) pinyin.get("simplePinyin"));
	}

	/**
	 * 填充性别
	 * 
	 * @param householdStaff
	 */
	private void autoFillGender(FloatingPopulation floatingPopulation) {
		floatingPopulation.setGender(peopleHelper.autoFillGender(
				PropertyTypes.GENDER, floatingPopulation.getIdCardNo()));
	}

	/**
	 * 填充出生日期
	 * 
	 * @param householdStaff
	 */
	private void autoFillBirthday(FloatingPopulation floatingPopulation) {
		peopleHelper.autoFillBirthday(floatingPopulation);
	}

	@Override
	public FloatingPopulation getFloatingPopulationById(Long id) {
		if (null == id || id < 0L) {
			throw new BusinessValidationException("流动人口id不合法");
		}
		FloatingPopulation population = floatingPopulationDao
				.getFloatingPopulationById(id);
		loadHouseInfo(population);
		return population;
	}

	@Override
	public void deleteFloatingPopulationByIds(Long[] ids) {
		for (int i = 0; null != ids && i < ids.length; i++) {
			deleteFloatingPopulationById(ids[i]);
		}
	}

	@Override
	public void deleteFloatingPopulationById(Long id) {
		try {
			if (null == id || id < 0L) {
				throw new BusinessValidationException("流动人口id不合法");
			}
			FloatingPopulation floatingPopulation = getFloatingPopulationById(id);
			if (floatingPopulation == null) {
				return;
			}
			floatingPopulation.setCreateDate(new Date());
			floatingPopulation
					.setPopulationTypes(getPopulationRelationService()
							.getActualPopulationTypeBeans(
									floatingPopulation.getId(),
									BaseInfoTables.FLOATINGPOPULATION_KEY));
			getRecoverDatasService().deleteActualPopulation(floatingPopulation);
			getPopulationRelationService().actualPopulationDel(id,
					BaseInfoTables.FLOATINGPOPULATION_KEY);
			getPopulationRelationService().actualDeletePopulationRelation(id,
					BaseInfoTables.FLOATINGPOPULATION_KEY);

			addressInfoService.delete(floatingPopulation.getAddressInfoId());

			managePopulationByHouseHelper.releasePopulationBindedHouses(
					PopulationCatalog.FLOATING_POPULATION, id);

			floatingPopulationDao.deleteFloatingPopulationById(id);

			groupFamilyService
					.deleteGroupFamilyByPopulationIdAndPopulationTypeAndIdCardNo(
							floatingPopulation.getId(),
							BaseInfoTables.FLOATINGPOPULATION_KEY,
							floatingPopulation.getIdCardNo());
			if (IsEmphasis.Emphasis.equals(floatingPopulation.getLogOut())) {
				// 缓存计数器
				PageInfoCacheThreadLocal.decrease(MemCacheConstant
						.getCachePageKey(floatingPopulation.getClass()
								.getSimpleName()), floatingPopulation, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FloatingPopulation> updateDeathOfFloatingPopulationByIdList(
			List<Long> idList, Boolean death) {
		if (null == idList) {
			throw new BusinessValidationException("流动人口idList不能为空");
		}
		List<FloatingPopulation> populationList = new ArrayList<FloatingPopulation>();
		Long logoutState = death ? IsEmphasis.IsNotEmphasis
				: IsEmphasis.Emphasis;
		for (Long id : idList) {
			FloatingPopulation population = getFloatingPopulationById(id);
			LogoutDetail logoutDetail = new LogoutDetail();
			logoutDetail.setLogout(logoutState);
			updateLogOutByPopulationTypeAndId(logoutDetail,
					population.getActualPopulationType(), population.getId());
			baseInfoService.updateDeathStateById(population.getBaseInfoId(),
					death, population.getIdCardNo(), population
							.getOrganization().getId(), population
							.getOrgInternalCode(),
					NewBaseInfoTables.FLOATINGPOPULATION_KEY);
			groupFamilyService
					.deleteGroupFamilyByPopulationIdAndPopulationTypeAndIdCardNo(
							id, BaseInfoTables.FLOATINGPOPULATION_KEY, null);
			FloatingPopulation temp = getFloatingPopulationById(id);
			populationList.add(temp);
			syncPopulationSolrIndexForMQ.sendPopulationSolrIndexForMQ(temp,
					BaseInfoTables.FLOATINGPOPULATION_KEY, OperateMode.EDIT);
		}
		return populationList;
	}

	public List<Long> updateLogOutOfFloatingPopulationByIds(
			LogoutDetail logoutDetail, String populationType, Long[] ids) {
		List<Long> resultList = new ArrayList<Long>();
		resultList = updateLogOutDetailByPopulationTypeAndIds(logoutDetail,
				populationType, ids);
		for (Long resultId : resultList) {
			FloatingPopulation population = getFloatingPopulationById(resultId);
			syncPopulationSolrIndexForMQ.sendPopulationSolrIndexForMQ(
					population, BaseInfoTables.FLOATINGPOPULATION_KEY,
					OperateMode.EDIT);
		}
		return resultList;
	}

	@Override
	@SolrServerIndex(mode = OperateMode.DELETE, value = DeleteSqlMap.FLOATINGPOPULATION_KEY)
	public void deleteFloatingPopulationsByIdList(List<Long> idList) {
		if (null == idList) {
			throw new BusinessValidationException("流动人口idList不能为空");
		}
		for (Long id : idList) {
			deleteFloatingPopulationById(id);
		}
	}

	@Override
	public boolean hasDuplicateFloatingPopulation(Long orgId, String idCardNo,
			Long exceptedId) {
		if (idCardNo == null || "".equals(idCardNo.trim()) || orgId == null) {
			return false;
		}
		idCardNo = idCardNo.toUpperCase();
		String idCardNo15 = "";
		String idCardNo18 = "";
		if (idCardNo.length() == 15) {
			idCardNo15 = idCardNo;
			idCardNo18 = IdCardUtil.idCardNo15to18(idCardNo, "19");
		} else if (idCardNo.length() == 18) {
			idCardNo15 = IdCardUtil.idCardNo18to15(idCardNo);
			idCardNo18 = idCardNo;
		}
		FloatingPopulation exsited = floatingPopulationDao
				.getFloatingPopulationByIdCardNoAndOrganizationId(idCardNo15,
						idCardNo18, orgId);
		return exceptedId == null ? exsited != null
				: (exsited != null && !exceptedId.equals(exsited.getId()));
	}

	public FloatingPopulation hasDuplicateFloatingPopulation(Long orgId,
			String idCardNo) {
		if (idCardNo == null || "".equals(idCardNo.trim()) || orgId == null) {
			return null;
		}
		idCardNo = idCardNo.toUpperCase();
		String idCardNo15 = "";
		String idCardNo18 = "";
		if (idCardNo.length() == 15) {
			idCardNo15 = idCardNo;
			idCardNo18 = IdCardUtil.idCardNo15to18(idCardNo, "19");
		} else if (idCardNo.length() == 18) {
			idCardNo15 = IdCardUtil.idCardNo18to15(idCardNo);
			idCardNo18 = idCardNo;
		}
		FloatingPopulation exsited = floatingPopulationDao
				.getFloatingPopulationByIdCardNoAndOrganizationId(idCardNo15,
						idCardNo18, orgId);
		return exsited;
	}

	private void validateUnmodifiedFields(FloatingPopulation update) {
		FloatingPopulation floatingPopulation = this.floatingPopulationDao
				.getFloatingPopulationById(update.getId());
		if (null != update.getOrganization()
				&& null != update.getOrganization().getId()
				&& !update.getOrganization().getId()
						.equals(floatingPopulation.getOrganization().getId())) {
			throw new BusinessValidationException("所属网格不能修改");
		}
		if (null != update.getCreateUser()
				&& !update.getCreateUser().equals(
						floatingPopulation.getCreateUser())) {
			throw new BusinessValidationException("创建人不能修改");
		}
		if (null != update.getCreateDate()
				&& !update.getCreateDate().equals(
						floatingPopulation.getCreateDate())) {
			throw new BusinessValidationException("创建时间不能修改");
		}
	}

	@Override
	public ActualPopulation getActualPopulationById(Long id) {
		FloatingPopulation result = getFloatingPopulationById(id);
		loadHouseInfo(result);
		return result;
	}

	@Override
	public FloatingPopulation updateFloatingPopulationBusinessInfo(
			FloatingPopulation population) {
		ValidateResult dataValidator = validator
				.validateSpecializedInfo(population);
		if (dataValidator.hasError()) {
			throw new BusinessValidationException(
					dataValidator.getErrorMessages());
		}
		FloatingPopulation temp = floatingPopulationDao
				.updateBusiness(population);
		syncPopulationSolrIndexForMQ.sendPopulationSolrIndexForMQ(temp,
				BaseInfoTables.FLOATINGPOPULATION_KEY, OperateMode.EDIT);
		PageInfoCacheThreadLocal.update(
				MemCacheConstant.getCachePageKey(FloatingPopulation.class),
				temp, UpdateType.BUSINESS);
		return temp;
	}

	/**
	 * gis列表查询
	 */
	@Override
	public PageInfo<PopulationVo> findPopulationsByOrgId(Long orgId,
			Integer page, Integer rows, String sidx, String sord) {
		if (orgId == null) {
			return new PageInfo<PopulationVo>();
		} else {
			Organization org = organizationDubboService.getSimpleOrgById(orgId);
			PageInfo<FloatingPopulation> fInfo = floatingPopulationDao
					.findFloatingPopulationByorgCodeForGis(
							org.getOrgInternalCode(), page, rows, sidx, sord);
			return exchageFloatingPopulationToPopulationVoPageInfo(fInfo);
		}
	}

	private PageInfo<PopulationVo> exchageFloatingPopulationToPopulationVoPageInfo(
			PageInfo<FloatingPopulation> fInfo) {
		List<PopulationVo> populationVos = new ArrayList<PopulationVo>();
		for (FloatingPopulation floatingPopulation : fInfo.getResult()) {
			populationVos
					.add(shiftGisPopulationFromFloatingPopulation(floatingPopulation));
		}
		PageInfo<PopulationVo> pageInfo = new PageInfo<PopulationVo>();
		pageInfo.setCurrentPage(fInfo.getCurrentPage());
		pageInfo.setPerPageSize(fInfo.getPerPageSize());
		pageInfo.setTotalRowSize(fInfo.getTotalRowSize());
		pageInfo.setResult(populationVos);
		return pageInfo;
	}

	private PopulationVo shiftGisPopulationFromFloatingPopulation(
			FloatingPopulation floatingPopulation) {
		PopulationVo populationVo = new PopulationVo();
		if (floatingPopulation.getIsHaveHouse() != null
				&& floatingPopulation.getIsHaveHouse()) {
			loadHouseInfo(floatingPopulation);
			if (null != floatingPopulation.getHouseId()) {
				HouseInfo houInfo = actualHouseService
						.getHouseInfoById(floatingPopulation.getHouseId());
				populationVo.setOrgId(houInfo.getOrganization().getId());
				populationVo.setHouseId(floatingPopulation.getHouseId());
				populationVo.setAddress(houInfo.getAddress());
				populationVo.setGisInfo(houInfo.getGisInfo());
				if (houInfo != null && houInfo.getGisInfo() != null
						&& houInfo.getGisInfo().getCenterX() != null) {
					populationVo.setEnableBind(true);
				} else {
					populationVo.setEnableBind(false);
				}
			}
		} else {
			populationVo.setEnableBind(false);
			if (null != floatingPopulation.getNoHouseReason()) {
				populationVo.setNoHouseReason(floatingPopulation
						.getNoHouseReason());
			} else {
				populationVo.setNoHouseReason("暂未填写");
			}
		}
		populationVo.setKeyPersonType(PopulationType.FLOATING_POPULATION);
		populationVo.setIsHaveHouse(floatingPopulation.getIsHaveHouse());
		populationVo.setName(floatingPopulation.getName());
		populationVo.setGender(floatingPopulation.getGender());
		populationVo.setGenderName(getPropertyDictText(PropertyTypes.GENDER,
				floatingPopulation.getGender().getId()));
		populationVo.setPersonId(floatingPopulation.getId());
		populationVo.setIdCardNo(floatingPopulation.getIdCardNo());
		populationVo.setImgUrl(floatingPopulation.getImgUrl());
		return populationVo;
	}

	@Override
	public List<PopulationVo> findPopulationByPersonId(Long personId) {
		List<FloatingPopulation> floatingPopulation = floatingPopulationDao
				.findGisHouseHoldStaffById(personId);

		List<PopulationVo> populationVos = new ArrayList<PopulationVo>();
		for (FloatingPopulation fPopulation : floatingPopulation) {
			PopulationVo populationVo = new PopulationVo();
			populationVo.setAddress(fPopulation.getCurrentAddress());
			populationVo.setName(fPopulation.getName());
			populationVo.setGenderName(getPropertyDictText(
					PropertyTypes.GENDER, fPopulation.getGender().getId()));
			populationVo.setIdCardNo(fPopulation.getIdCardNo());
			populationVo.setPersonId(fPopulation.getId());
			populationVo.setImgUrl(fPopulation.getImgUrl());
			populationVo
					.setPopulationType(PopulationType
							.getCnameByPopulationType(fPopulation
									.getPopulationtypes())); // 管理类别
			populationVo.setActulType(PopulationType
					.getCnameByActualType(fPopulation.getActualtype())); // 实口类别
			populationVo.setKeyPersonType(fPopulation.getActualtype()); // 实口标识符
			populationVos.add(populationVo);
		}
		return populationVos;
	}

	@Override
	public List<ActualPopulation> getActualPopulationByOrgIdAndIdCardNoExcludePopulationIdList(
			Long excludePopulationId, Long orgId, String idCardNo) {
		List<ActualPopulation> actualPopulationList = new ArrayList<ActualPopulation>();
		try {
			List<FloatingPopulation> floatingPopulationList = this.floatingPopulationDao
					.getActualPopulationByOrgIdAndIdCardNoExcludePopulationId(
							excludePopulationId, orgId, idCardNo, idCardNo);
			for (FloatingPopulation floatingPopulation : floatingPopulationList) {
				floatingPopulation
						.setActualPopulationType(PopulationType.FLOATING_POPULATION);
				actualPopulationList.add(floatingPopulation);
			}
		} catch (Exception e) {
			throw new ServiceValidationException("查询流动人口出现异常", e);
		}
		return actualPopulationList;
	}

	@Override
	public ActualPopulation getActualPopulationByOrgIdAndIdCardNoExcludePopulationId(
			Long excludePopulationId, Long orgId, String idCardNo) {
		if (idCardNo == null || "".equals(idCardNo.trim()) || orgId == null) {
			return null;
		}
		idCardNo = idCardNo.toUpperCase();
		String idCardNo15 = "";
		String idCardNo18 = "";
		if (idCardNo.length() == 15) {
			idCardNo15 = idCardNo;
			idCardNo18 = IdCardUtil.idCardNo15to18(idCardNo, "19");
		} else if (idCardNo.length() == 18) {
			idCardNo15 = IdCardUtil.idCardNo18to15(idCardNo);
			idCardNo18 = idCardNo;
		}
		ActualPopulation actualPopulation = null;
		List<FloatingPopulation> floatingPopulationList = this.floatingPopulationDao
				.getActualPopulationByOrgIdAndIdCardNoExcludePopulationId(
						excludePopulationId, orgId, idCardNo15, idCardNo18);
		if (!floatingPopulationList.isEmpty()) {
			actualPopulation = floatingPopulationList.get(0);
		}
		return actualPopulation;
	}

	@Override
	public ActualPopulation getActualPopulationByOrgIdAndIdCardNoExcludePopulationIdIncludeLogout(
			Long excludePopulationId, Long orgId, String idCardNo) {
		if (idCardNo == null || "".equals(idCardNo.trim()) || orgId == null) {
			return null;
		}
		idCardNo = idCardNo.toUpperCase();
		String idCardNo15 = "";
		String idCardNo18 = "";
		if (idCardNo.length() == 15) {
			idCardNo15 = idCardNo;
			idCardNo18 = IdCardUtil.idCardNo15to18(idCardNo, "19");
		} else if (idCardNo.length() == 18) {
			idCardNo15 = IdCardUtil.idCardNo18to15(idCardNo);
			idCardNo18 = idCardNo;
		}
		ActualPopulation actualPopulation = null;
		List<FloatingPopulation> floatingPopulationList = this.floatingPopulationDao
				.getActualPopulationByOrgIdAndIdCardNoExcludePopulationIdIncludeLogout(
						excludePopulationId, orgId, idCardNo15, idCardNo18);
		if (!floatingPopulationList.isEmpty()) {
			actualPopulation = floatingPopulationList.get(0);
		}
		return actualPopulation;
	}

	private String getPropertyDictText(String domainName, Long id) {
		if (null == id) {
			return "";
		} else {
			PropertyDict dict = propertyDictService.getPropertyDictById(id);
			return dict == null ? "" : dict.getDisplayName();
		}
	}

	@Override
	public ActualPopulation getActualPopulationHouseId(
			ActualPopulation actualPopulation) {
		actualPopulation.setHouseId(managePopulationByHouseHelper
				.getPopulationLivingHouseId(
						PopulationCatalog.FLOATING_POPULATION,
						actualPopulation.getId()));
		return actualPopulation;
	}

	@Override
	public PageInfo<PopulationVo> getFurtherStepGisPopulationInfoByPersonType(
			Long orgId, String personType, String queryStr, Integer page,
			Integer rows, String sidx, String sord) {
		if (orgId == null) {
			return new PageInfo<PopulationVo>();
		} else {
			Organization org = organizationDubboService.getSimpleOrgById(orgId);
			PageInfo<FloatingPopulation> floatPageInfo = floatingPopulationDao
					.getFurtherStepGisPopulationInfoByPersonType(
							org.getOrgInternalCode(), personType, page, rows,
							sidx, sord);
			return exchangeFloatingPlpulationToPopulationVoPageInfo(floatPageInfo);
		}
	}

	private PageInfo<PopulationVo> exchangeFloatingPlpulationToPopulationVoPageInfo(
			PageInfo<FloatingPopulation> floatPageInfo) {
		List<PopulationVo> populationVos = new ArrayList<PopulationVo>();
		List<FloatingPopulation> floatingPopulations = floatPageInfo
				.getResult();
		shiftViewForFloatingPopulationToPopulationVo(populationVos,
				floatingPopulations);
		PageInfo<PopulationVo> pageInfo = new PageInfo<PopulationVo>();
		pageInfo.setResult(populationVos);
		pageInfo.setTotalRowSize(floatPageInfo.getTotalRowSize());
		pageInfo.setPerPageSize(floatPageInfo.getPerPageSize());
		return pageInfo;
	}

	private void shiftViewForFloatingPopulationToPopulationVo(
			List<PopulationVo> populationVos,
			List<FloatingPopulation> floatingPopulations) {
		for (FloatingPopulation floatingPopulation : floatingPopulations) {
			populationVos
					.add(shiftGisPopulationFromFloatingPopulation(floatingPopulation));

		}
	}

	@Override
	public PageInfo<PopulationVo> getFurtherStepGisPopulationInfoByPersonTypeList(
			Long orgId, List personType, String queryStr, Integer page,
			Integer rows, String sidx, String sord) {
		if (null == orgId) {
			return new PageInfo<PopulationVo>();
		} else {
			Organization org = organizationDubboService.getSimpleOrgById(orgId);
			PageInfo<FloatingPopulation> floatPageInfo = floatingPopulationDao
					.findFurtherStepGisPersonInfoSearchByPersonTypeListAndOrgId(
							org.getOrgInternalCode(), personType, page, rows,
							sidx, sord);
			return exchangeFloatingPlpulationToPopulationVoPageInfo(floatPageInfo);
		}

	}

	@Override
	public void asynActualPopulation(ActualPopulation actualPopulation) {
		if (null != actualPopulation.getId())
			updateFloatingPopulationBaseInfo((FloatingPopulation) actualPopulation);
	}

	@Override
	public ActualPopulation getFullActualPopulationByCardNoAndOrgId(
			String idCardNo, Long orgId) {
		return findFloatingPopulationByCardNoAndOrgId(idCardNo, orgId);
	}

	@Override
	public void sysActualPopulationByAddHousePopulationRela(Long populationId,
			String address) {
		floatingPopulationDao.updateActualPopulationToHasHouseState(
				populationId, address);
	}

	@Override
	public Boolean updateActualPopulationToHasHouseState(
			FloatingPopulation floatingPopulation) {
		return floatingPopulationDao
				.updateActualPopulationToHasHouseState(floatingPopulation);
	}

	@Override
	public List<PopulationVo> findGisPopulationByOrgid(Long orgid) {
		if (null == orgid) {
			return new ArrayList<PopulationVo>();
		} else {
			Organization org = organizationDubboService.getSimpleOrgById(orgid);
			List<FloatingPopulation> floatingPopulations = floatingPopulationDao
					.findAllBindingFloatingPopulationByorgCodeForGis(
							PopulationCatalog.FLOATING_POPULATION,
							org.getOrgInternalCode());
			return exchangeFloatingPlpulationToPopulationVoPageInfo(floatingPopulations);
		}
	}

	private List<PopulationVo> exchangeFloatingPlpulationToPopulationVoPageInfo(
			List<FloatingPopulation> floatingPopulations) {
		List<PopulationVo> populationVos = new ArrayList<PopulationVo>();
		shiftViewForFloatingPopulationToPopulationVo(populationVos,
				floatingPopulations);
		return populationVos;
	}

	@Override
	public List<FloatingPopulation> findFloatingPopulationsWhenIsOld(
			int pageSize, Organization org) {
		try {
			// return floatingPopulationDao.findFloatingPopulationsWhenIsOld(
			// pageNum, pageSize);
			return floatingPopulationDao
					.findFloatingPopulationsWhenIsOldForMark(pageSize, org);
		} catch (Exception e) {
			throw new ServiceValidationException("在流动人口获取老年人时出错", e);
		}
	}

	@Override
	public Integer countFloatingPopulationsWhenIsOld() {
		try {
			// return floatingPopulationDao.countFloatingPopulationsWhenIsOld();
			return floatingPopulationDao
					.countFloatingPopulationsWhenIsOldForMark();
		} catch (Exception e) {
			throw new ServiceValidationException("在流动人口统计老年人数量时出错", e);
		}
	}

	@Override
	public List<FloatingPopulation> findFloatingPopulationsWhenIsNurtuesWomen(
			int pageSize, Organization org) {
		try {
			// /return floatingPopulationDao
			// .findFloatingPopulationsWhenIsNurtuesWomen(pageNum,
			// pageSize);
			return floatingPopulationDao
					.findFloatingPopulationsWhenIsNurtuesWomenForMark(pageSize,
							org);
		} catch (Exception e) {
			throw new ServiceValidationException("在流动人口获取育龄妇女时出错", e);
		}
	}

	@Override
	public Integer countFloatingPopulationsWhenIsNurtuesWomen(String shardCode) {
		try {
			// return floatingPopulationDao
			// .countFloatingPopulationsWhenIsNurtuesWomen();
			return floatingPopulationDao
					.countFloatingPopulationsWhenIsNurtuesWomenForMark(shardCode);
		} catch (Exception e) {
			throw new ServiceValidationException("在流动人口统计育龄妇女数量时出错", e);
		}
	}

	@Override
	public PopulationVo shiftGisPopulationById(Long id) {
		return shiftGisPopulationFromFloatingPopulation(floatingPopulationDao
				.getFloatingPopulationById(id));
	}

	@Override
	public void sysActualPopulationByAddHousePopulationRela(Long populationId,
			HouseInfo houseInfo) {
		floatingPopulationDao.updateActualPopulationToHasHouseState(
				populationId, houseInfo);

	}

	@Override
	public FloatingPopulation getFloatingPopulationByIdCardNoAndOrgId(
			Long organizationId, String idCardNo) {
		if (idCardNo == null || "".equals(idCardNo.trim())
				|| organizationId == null) {
			return null;
		}
		idCardNo = idCardNo.toUpperCase();
		// String idCardNo15 = "";
		// String idCardNo18 = "";
		// if (idCardNo.length() == 15) {
		// idCardNo15 = idCardNo;
		// idCardNo18 = IdCardUtil.idCardNo15to18(idCardNo, "19");
		// } else if (idCardNo.length() == 18) {
		// idCardNo15 = IdCardUtil.idCardNo18to15(idCardNo);
		// idCardNo18 = idCardNo;
		// }
		Countrymen countrymen = baseInfoService.getBaseInfoByIdCardNo(idCardNo);
		if (countrymen == null) {
			return null;
		}
		return getFloatingPopulationByBaseInfoId(countrymen.getId(),
				organizationId);
	}

	@Override
	public FloatingPopulation getFloatingPopulationByIdAndBusinessType(Long id,
			String type) {
		return floatingPopulationDao.getFloatingPopulationByIdAndBusinessType(
				id, type);
	}

	@Override
	public FloatingPopulation addFloatingPopulationBaseInfo(
			FloatingPopulation floatingPopulation) {
		String key = "";
		try {
			OperateMode mode = OperateMode.IMPORT;
			if (!ExcelImportHelper.isImport.get()) {
				mode = OperateMode.ADD;
				ValidateResult dataValidator = validator
						.validateBaseInfo(floatingPopulation);
				if (dataValidator.hasError()) {
					throw new BusinessValidationException(
							dataValidator.getErrorMessages());
				}
			}
			ValidateResult result = new ValidateResult();
			if (floatingPopulation.getOrganization() != null
					&& floatingPopulation.getOrganization().getId() != null) {
				result = validator.validatorIdCardNoExistedMessage(
						floatingPopulation.getOrganization().getId(),
						floatingPopulation.getIdCardNo(),
						floatingPopulation.getActualPopulationType(), null,
						result);
				String errorMessages = result.getErrorMessages();
				if (errorMessages != null && !"".equals(errorMessages)) {
					throw new BusinessValidationException(errorMessages);
				}
			}
			if (floatingPopulation != null
					&& floatingPopulation.getIdCardNo() != null
					&& floatingPopulation.getOrganization() != null
					&& floatingPopulation.getOrganization().getId() != null) {
				key = MemCacheConstant.getPopulationKey(
						MemCacheConstant.CACHE_ADDFLOATINGPOPULATIONBASEINFO,
						floatingPopulation.getIdCardNo(), floatingPopulation
								.getOrganization().getId());
				String value = (String) cacheService.get(
						MemCacheConstant.POPULATION_NAMESPACE, key);
				if (value == null || "".equals(value)) {
					cacheService
							.set(MemCacheConstant.POPULATION_NAMESPACE, key,
									300,
									CACHE_ADDFLOATINGPOPULATIONBASEINFO_VALUE);
				} else {
					return floatingPopulation;
				}
			}
			FloatingPopulation temp = add(floatingPopulation, mode);
			syncPopulationSolrIndexForMQ.sendPopulationSolrIndexForMQ(temp,
					BaseInfoTables.FLOATINGPOPULATION_KEY, OperateMode.ADD);
			return temp;
		} catch (Exception e) {
			logger.error(
					"FloatingPopulationServiceImpl addFloatingPopulationBaseInfo",
					e);
			if (!ExcelImportHelper.isImport.get()) {
				throw new BusinessValidationException("新增信息出现错误");
			} else {
				return null;
			}
		} finally {
			if (!"".equals(key)) {
				cacheService.remove(MemCacheConstant.POPULATION_NAMESPACE, key);
			}

		}
	}

	private void sendActiveMQ(FloatingPopulation floatingPopulation,
			OperateMode mode) {
		// 判断是否为育龄妇女
		if (IdCardUtil.autoIdCardNoWhenIsNurturesWomen(floatingPopulation
				.getIdCardNo())) {
			activeMQMessageSender
					.send(TransferData.convertToBaseMsg(floatingPopulation,
							BaseInfoTables.NURTURESWOMEN_KEY, mode));
		} else if (IdCardUtil
				.autoIdCardNoWhenIsElderlyPeople(floatingPopulation
						.getIdCardNo())) {
			// 判断是否为老年人
			activeMQMessageSender
					.send(TransferData.convertToBaseMsg(floatingPopulation,
							BaseInfoTables.ELDERLYPEOPLE_KEY, mode));
		}
	}

	// fateson add move function start
	@Override
	public void moveTempByIds(String[] peoperIds, Long targetOrgId) {
		Organization organization = organizationDubboService
				.getSimpleOrgById(targetOrgId);
		for (String id : peoperIds) {
			Long peoperId = Long.parseLong(id);
			if (!StringUtils.isEmpty(id)) {
				// get peoper
				FloatingPopulation people = getFloatingPopulationById(peoperId);
				if (people == null) {
					continue;
				}
				Long currentOrgid = people.getOrganization().getId();
				people.setOrganization(organization);
				// String orgCode = people.getOrgInternalCode();
				String orgCode = people.getOrganization().getOrgInternalCode();
				String idCardNo = people.getIdCardNo();
				// 验证目标组织机构是否存在这个人
				boolean result = hasDuplicateFloatingPopulation(targetOrgId,
						idCardNo, peoperId);
				if (result) {
					// 把存在的旧数据成为修改现在现在要移动的新数据
					if (currentOrgid.longValue() != targetOrgId.longValue()) {
						updateMovePersonByIdCardNo(idCardNo, targetOrgId,
								people);
						// 删掉要移动的数据 删除掉不在同一个网格
						deleteFloatingPopulationById(peoperId);
					}

				} else {
					// 转移网格数据
					floatingPopulationDao.updateData(id, targetOrgId, orgCode,
							people);
				}
				people.setCreateDate(null);
			}

		}

	}

	public void updateMovePersonByIdCardNo(String idcard, Long targetorgId,
			FloatingPopulation people) {
		List<String> cardnos = CardNoHelper.createIdCardNo(idcard);
		// 获取
		FloatingPopulation older = floatingPopulationDao.getByIdCard(cardnos,
				targetorgId);
		people.setId(older.getId());
		people.setCreateDate(older.getCreateDate());
		people.setCreateUser(older.getCreateUser());
		floatingPopulationDao.update(people);
	}

	// fateson add move end

	@Override
	@SolrServerIndex(mode = OperateMode.DELETE, value = DeleteSqlMap.FLOATINGPOPULATION_KEY)
	public void toHouseholdStaff(Long id) {
		FloatingPopulation floatingPopulation = this
				.getFloatingPopulationById(id);
		copyAndUpdate(floatingPopulation);
	}

	@Override
	@SolrServerIndex(mode = OperateMode.DELETE, value = DeleteSqlMap.FLOATINGPOPULATION_KEY)
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void toHouseholdStaffByIds(List<Long> ids) {
		if (!CollectionUtil.isAvaliable(ids)) {
			throw new BusinessValidationException("参数错误！");
		}
		String toHouseholdStaffMessage = "";
		FloatingPopulation floatingPopulation = null;
		for (Long id : ids) {
			try {
				floatingPopulation = this.getFloatingPopulationById(id);
				copyAndUpdate(floatingPopulation);
			} catch (Exception e) {
				toHouseholdStaffMessage += (floatingPopulation.getId() + "-"
						+ floatingPopulation.getIdCardNo() + ";");
			}
		}
		if (StringUtil.isStringAvaliable(toHouseholdStaffMessage)) {
			throw new BusinessValidationException("流动人口转为户籍人口失败信息：{"
					+ toHouseholdStaffMessage + "}");
		}
	}

	// 根据户籍人口是否存在及存在状态，进行insert/update
	@Override
	public Countrymen copyAndUpdate(FloatingPopulation floatingPopulation) {
		HouseholdStaff householdStaff = householdStaffService
				.findHouseholdStaffByCardNoAndOrgId(floatingPopulation
						.getIdCardNo(), floatingPopulation.getOrganization()
						.getId());
		systemOperateLogService.addSystemOperateLog(
				NewBaseInfoTables.HOUSEHOLDSTAFF_KEY,
				floatingPopulation.getIdCardNo(),
				floatingPopulation.getOrganization(),
				floatingPopulation.getOrgInternalCode(),
				NewBaseInfoTables.FLOATINGPOPULATION_KEY,
				SystemOperateType.TOHOUSEHOLDSTAFF, null, null);
		if (null == householdStaff) {
			householdStaff = new HouseholdStaff();
			copyProperties(householdStaff, floatingPopulation);
			deleteFloatingPopulation(floatingPopulation);
			// updateLogOut(floatingPopulation);
			HouseholdStaff newHouseholdStaff = householdStaffService
					.addHouseholdStaffBaseInfo(householdStaff);
			updateGroupFamily(floatingPopulation, newHouseholdStaff.getId(),
					newHouseholdStaff.getActualPopulationType());
		} else {
			if (householdStaff.isDeath()) {
				throw new BusinessValidationException(
						"此身份证号码在户籍人口中为已死亡状态不允许转为户籍人口!");
			} else {
				copyProperties(householdStaff, floatingPopulation);
				deleteFloatingPopulation(floatingPopulation);
				// updateLogOut(floatingPopulation);
				householdStaff.setLogOut(IsEmphasis.Emphasis);
				HouseholdStaff newHouseholdStaff = householdStaffService
						.updateHouseholdStaffBaseInfo(householdStaff);
				updateGroupFamily(floatingPopulation,
						newHouseholdStaff.getId(),
						newHouseholdStaff.getActualPopulationType());
			}
		}
		shiftRelation(householdStaff, floatingPopulation);
		return householdStaff;
	}

	// 流口转户籍时删除流口
	private void deleteFloatingPopulation(FloatingPopulation floatingPopulation) {
		housePopulationMaintanceService.releaseHouse(
				PopulationCatalog.FLOATING_POPULATION,
				floatingPopulation.getId(), floatingPopulation.getHouseId());
		floatingPopulationDao.deleteFloatingPopulation(floatingPopulation
				.getId());
		getRecoverDatasService().deleteActualPopulation(floatingPopulation);
		if (IsEmphasis.Emphasis.equals(floatingPopulation.getLogOut())) {
			PageInfoCacheThreadLocal.decrease(MemCacheConstant
					.getCachePageKey(floatingPopulation.getClass()
							.getSimpleName()), floatingPopulation, 1);
		}
	}

	// 流口转户籍时修改家庭关联关系
	private void updateGroupFamily(FloatingPopulation floatingPopulation,
			Long floatId, String newType) {
		Map map = new HashMap();
		map.put("oldId", floatingPopulation.getId());
		map.put("type", floatingPopulation.getActualPopulationType());
		map.put("newType", newType);
		map.put("newId", floatId);
		floatingPopulationDao.updateGroupFamily(map);
	}

	// 拷贝基本信息，流动人口—>户籍人口
	private void copyProperties(HouseholdStaff householdStaff,
			FloatingPopulation floatingPopulation) {
		try {
			PropertyUtil.copyPropertiesWithRecursion(ActualPopulation.class,
					householdStaff, floatingPopulation, new String[] { "id",
							"logOut", "actualPopulationType" });
		} catch (Exception e) {
			throw new ServiceValidationException("拷贝基本信息出错！", e);
		}
	}

	// 注销流动人口
	/*
	 * private void updateLogOut(FloatingPopulation floatingPopulation) {
	 * LogoutDetail ld = new LogoutDetail();
	 * ld.setLogout(IsEmphasis.IsNotEmphasis); ld.setLogoutDate(new Date());
	 * ld.setLogoutReason("已转为户籍人口"); floatingPopulation.setLogoutDetail(ld);
	 * floatingPopulationDao.updateLogOutPopulationById(
	 * floatingPopulation.getLogoutDetail(), floatingPopulation.getId()); }
	 */

	// 根据流动人口的人员关联关系，新增户籍的人员关系{根据流动人口的信息取人员关联关系，}
	private void shiftRelation(HouseholdStaff householdStaff,
			FloatingPopulation floatingPopulation) {
		List<PopulationTypeBean> populationTypes = populationTypeService
				.getPopulationTypeByActualIdAndType(floatingPopulation.getId(),
						floatingPopulation.getActualPopulationType());
		for (PopulationTypeBean populationType : populationTypes) {
			populationType.setActualId(householdStaff.getId());
			populationType.setActualType(householdStaff
					.getActualPopulationType());
			populationTypeService.addPopulationType(populationType);
			populationTypeService.deletePopulationTypeByActualIdAndType(
					floatingPopulation.getId(),
					floatingPopulation.getActualPopulationType());
		}
		GroupFamily groupFamily = groupFamilyService
				.getGroupFamilyByPopulation(floatingPopulation);
		groupFamily.setOrgInternalCode(householdStaff.getOrgInternalCode());
		if (groupFamily.getId() != null) {
			groupFamilyService.practiseGroupFamilyForSynchro(groupFamily,
					householdStaff.getId(),
					householdStaff.getActualPopulationType());
			groupFamilyService.deleteGroupFamilyMember(groupFamily.getId(),
					floatingPopulation.getId(),
					floatingPopulation.getActualPopulationType());
		}
	}

	@Override
	public FloatingPopulation getFloatingPopulationByBaseInfoId(
			Long baseInfoId, Long orgId) {
		return floatingPopulationDao.getFloatingPopulationByBaseInfoId(
				baseInfoId, orgId);
	}

	@Override
	public List<FloatingPopulation> getFloatingPopulationByBaseInfoId(
			Long baseInfoId) {
		return floatingPopulationDao
				.getFloatingPopulationByBaseInfoId(baseInfoId);
	}

	@Override
	public Integer getCount(
			SearchFloatingPopulationVo searchFloatingPopulationVo) {
		return floatingPopulationDao.getCount(searchFloatingPopulationVo);
	}

	@Override
	public boolean getActualPopulationHasTypes(Long id) {
		List<PopulationTypeBean> businessTypes = null;
		try {
			businessTypes = getPopulationRelationService()
					.getActualPopulationTypeBeans(id,
							BaseInfoTables.FLOATINGPOPULATION_KEY);
		} catch (Exception e) {
			throw new ServiceValidationException("查询人口信息业务类型失败", e);
		}
		return businessTypes == null || businessTypes.size() <= 0 ? false
				: true;
	}

	@Override
	public List<FloatingPopulation> findFloatingPopulationByExpectedDatedue(
			int pageNum, int pageSize) {
		EarlyWarning earlyWarning = earlyWarningService
				.getEarlyWarningByName(EarlyWarningName.EXPECTEDDATEDUEREMIND);
		if (earlyWarning == null) {
			throw new BusinessValidationException("获取社区矫正到期时间出错");
		}
		try {
			Long remindTime = earlyWarning.getRemindTime();
			return floatingPopulationDao
					.findFloatingPopulationByExpectedDatedue(pageNum, pageSize,
							remindTime);
		} catch (Exception e) {
			throw new ServiceValidationException("在流动人口获取到期的人口时出错", e);
		}
	}

	@Override
	public Integer countFloatingPopulationByExpectedDatedue() {
		EarlyWarning earlyWarning = earlyWarningService
				.getEarlyWarningByName(EarlyWarningName.EXPECTEDDATEDUEREMIND);
		if (earlyWarning == null) {
			throw new BusinessValidationException("获取社区矫正到期时间出错");
		}
		try {
			Long remindTime = earlyWarning.getRemindTime();
			return floatingPopulationDao
					.countFloatingPopulationByExpectedDatedue(remindTime);
		} catch (Exception e) {
			throw new ServiceValidationException("在流动人口统计到期人口的数量时出错", e);
		}
	}

	@Override
	public FloatingPopulation updateIsRemindByid(Long id) {
		return floatingPopulationDao.updateIsRemindByid(id);
	}

	@Override
	public Countrymen updateBaseInfoIdCardNo(Countrymen countrymen,
			String idCardNo) {
		if (countrymen == null || countrymen.getIdCardNo() == null
				|| countrymen.getId() == null || idCardNo == null
				|| countrymen.getOrganization() == null
				|| countrymen.getOrganization().getId() == null
				|| "".equals(countrymen.getIdCardNo()) || "".equals(idCardNo)) {
			throw new BusinessValidationException("参数错误");
		}
		try {
			// 是修改家庭信息家长身份证号
			updateGroupFamily(countrymen);
			// 业务人员相关（老年人、{青少年【青少年、少先队员、共青团员】由于是实时查询的不需要做处理}、育龄妇女、重点青少年）
			updateBusinessPopulation(countrymen, idCardNo);
			Countrymen result = baseInfoService.updateBaseInfoIdCardNo(
					countrymen, idCardNo);
			// 修改身份证号码所对应的出生日期和性别
			updateBirthdayAndGender(result.getId(), countrymen);
			return result;
		} catch (Exception e) {
			throw new ServiceValidationException("流动人员修改身份证号错误", e);
		}
	}

	/**
	 * 修改身份证号码和性别
	 * 
	 * @param baseInfoId
	 */
	private void updateBirthdayAndGender(Long baseInfoId, Countrymen countrymen) {
		floatingPopulationDao.updateBirthdayAndGender(baseInfoId,
				countrymen.getBirthday(), countrymen.getGender().getId());
	}

	@Override
	public Countrymen existBaseInfo(String actualPopulationType,
			String idCardNo, Long orgId) {
		if (!StringUtils.isNotBlank(actualPopulationType)
				|| !StringUtils.isNotBlank(idCardNo) || orgId == null) {
			throw new BusinessValidationException("参数错误");
		}
		try {
			return baseInfoService.existBaseInfo(idCardNo);
		} catch (Exception e) {
			throw new ServiceValidationException("验证流动人口重复错误", e);
		}
	}

	@Override
	public List<FloatingPopulation> findFloatingPopulationByIds(List<Long> ids) {
		if (null == ids) {
			throw new BusinessValidationException("参数错误");
		}
		return floatingPopulationDao.findFloatingPopulationByIds(ids);
	}

	@Override
	public List<Organization> findOrgByAddress(Long addressId) {
		return floatingPopulationDao.findOrgByAddress(addressId);
	}
}

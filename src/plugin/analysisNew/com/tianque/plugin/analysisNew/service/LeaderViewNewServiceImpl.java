package com.tianque.plugin.analysisNew.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.tianque.baseInfo.companyPlace.constacts.ModulTypes;
import com.tianque.baseInfo.leaderViewCache.constants.LeaderViewCacheType;
import com.tianque.baseInfo.leaderViewCache.domain.LeaderViewCache;
import com.tianque.baseInfo.leaderViewCache.service.LeaderViewCacheService;
import com.tianque.baseInfo.youths.constants.YouthsType;
import com.tianque.baseInfo.youths.vo.SearchYouthsVo;
import com.tianque.core.cache.constant.MemCacheConstant;
import com.tianque.core.cache.service.CacheService;
import com.tianque.core.exception.ServiceException;
import com.tianque.core.util.BaseInfoTables;
import com.tianque.core.util.CalendarUtil;
import com.tianque.core.util.NewBaseInfoTables;
import com.tianque.core.util.StringUtil;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.property.OrganizationLevel;
import com.tianque.domain.property.OrganizationType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.exception.base.ServiceValidationException;
import com.tianque.job.SessionHelper;
import com.tianque.plugin.analysisNew.dao.LeaderViewNewDao;
import com.tianque.plugin.analysisNew.util.AnalyseUtilNew;
import com.tianque.plugin.analysisNew.util.PopulationCatalog;
import com.tianque.plugin.analyzing.domain.StatisticsBaseInfoAddCountVo;
import com.tianque.plugin.analyzing.domain.StatisticsNode;
import com.tianque.service.util.PopulationType;
import com.tianque.shard.util.ShardConversion;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.tableManage.service.TableManageService;

@Service("leaderViewNewService")
public class LeaderViewNewServiceImpl implements LeaderViewNewService {

	private final static Logger logger = LoggerFactory
			.getLogger(LeaderViewNewServiceImpl.class);

	// private final static int CACHE_TIME = 36000;// 缓存时间10个小时
	@Autowired
	private LeaderViewNewDao leaderViewNewDao;
	@Autowired
	private OrganizationDubboService organizationDubboService;
	@Autowired
	private CacheService cacheService;
	@Autowired
	private PropertyDictService propertyDictService;
	// 分表存储时用的service
	@Autowired
	private TableManageService tableService;

	@Autowired
	private LeaderViewCacheService leaderViewCacheService;
	@Autowired
	private ShardConversion shardConversion;
	@Autowired
	private CompanyPlaceLeaderViewNewService companyPlaceLeaderViewNewService;

	@Override
	public List<StatisticsBaseInfoAddCountVo> statisticsBaseInfoAddCountByOrgIdForArea(
			Long orgId, String tableName, boolean isGrid) {
		String table = BaseInfoTables.getKeytables().get(tableName);
		if (table == null) {
			table = tableName;
		}
		return statisticsBaseInfoCurrent(orgId, table, isGrid);

	}

	@Override
	public void statisticsPopulationAddCountByOrgIdForJob() {
		// 户籍
		countPopulationLeaderView(BaseInfoTables.HOUSEHOLDSTAFF_KEY);
		logger.error("户籍完成");
		// 流口
		countPopulationLeaderView(BaseInfoTables.FLOATINGPOPULATION_KEY);
		logger.error("流口完成");
		// 未落户
		countPopulationLeaderView(BaseInfoTables.UNSETTEDPOPULATION_KEY);
		logger.error("未落户完成");
		// 境外人员
		countPopulationLeaderView(BaseInfoTables.OVERSEAPERSONNEL_KEY);
		logger.error("境外人员完成");
	}

	@Override
	public void statisticsHouseInfoAddCountByOrgIdForJob() {
		countHouseInfoLeaderView(BaseInfoTables.HOUSEINFO_KEY);
		logger.error("房屋完成");
		countHouseInfoLeaderView(BaseInfoTables.RENTALHOUSE_KEY);
		logger.error("出租房完成");
	}

	@Override
	public void statisticsAttentionPopulationAddCountByOrgIdForJob() {
		// 老年人
		countPopulationLeaderView(BaseInfoTables.ELDERLYPEOPLE_KEY);
		logger.error("老年人完成");
		// 育龄妇女
		countPopulationLeaderView(BaseInfoTables.NURTURESWOMEN_KEY);
		logger.error("育龄妇女完成");
		// 刑释人员
		countPopulationLeaderView(BaseInfoTables.POSITIVEINFO_KEY);
		logger.error("刑释人员完成");
		// 社区矫正人员
		countPopulationLeaderView(BaseInfoTables.RECTIFICATIVEPERSON_KEY);
		logger.error("吸毒人员完成");
		// 严重精神障碍患者
		countPopulationLeaderView(BaseInfoTables.MENTALPATIENT_KEY);
		logger.error("吸毒人员完成");
		// 吸毒人员
		countPopulationLeaderView(BaseInfoTables.DRUGGY_KEY);
		logger.error("吸毒人员完成");
		// 艾滋病人员
		countPopulationLeaderView(BaseInfoTables.AIDSPOPULATIONS_KEY);
		logger.error("艾滋病人员完成");
		// 重点青少年
		countPopulationLeaderView(BaseInfoTables.IDLEYOUTH_KEY);
		logger.error("重点青少年完成");
		// 重点上访人员
		countPopulationLeaderView(BaseInfoTables.SUPERIORVISIT_KEY);
		logger.error("重点上访人员完成");
		// 危险品从业人员
		countPopulationLeaderView(BaseInfoTables.DANGEROUSGOODSPRACTITIONER_KEY);
		logger.error("危险品从业人员完成");
		// 其他人员
		countPopulationLeaderView(BaseInfoTables.OTHERATTENTIONPERSONNEL_KEY);
		logger.error("其他人员完成");
		// 残疾人
		countPopulationLeaderView(BaseInfoTables.HANDICAPPED_KEY);
		logger.error("残疾人完成");
		// 优抚对象
		countPopulationLeaderView(BaseInfoTables.OPTIMALOBJECT_KEY);
		logger.error("优抚对象完成");
		// 需救助人员
		countPopulationLeaderView(BaseInfoTables.AIDNEEDPOPULATION_KEY);
		logger.error("需救助人员完成");
		// 失业人员
		countPopulationLeaderView(BaseInfoTables.UNEMPLOYEDPEOPLE_KEY);
		logger.error("失业人员完成");
	}

	@Override
	public void statisticsPopulationSingleContentForJob(String singleJobType) {
		if (StringUtil.isStringAvaliable(singleJobType)) {
			countPopulationLeaderView(singleJobType);
		}
	}

	private void countPopulationLeaderView(String type) {
		String table = PopulationCatalog.parse(type).getStatisticListSetting()
				.getTableName();
		if (table == null) {
			table = type;
		}
		countBaseInfoCurrent(table);
	}

	private void countHouseInfoLeaderView(String type) {
		String table = BaseInfoTables.getKeytables().get(type);
		if (table == null) {
			table = type;
		}
		countBaseInfoCurrent(table);
	}

	public void countBaseInfoCurrent(final String table) {

		// 直接查询 所有的网格数据
		Organization country = organizationDubboService.getRootOrganization();

		final StatisticsNode root = AnalyseUtilNew.getRootNode(cacheService,
				organizationDubboService, country, true);

		logger.error("开始查询数据[" + table + "]");
		long start = System.currentTimeMillis();
		List<StatisticsBaseInfoAddCountVo> temp = statisticsBaseInfo(table,
				country);
		logger.error("查询数据耗时[" + table + "]:"
				+ (System.currentTimeMillis() - start) / 1000 + "s,结果记录数："
				+ temp.size());
		AnalyseUtilNew.totalResult(leaderViewCacheService, table, temp, root,
				table, null, true);
		logger.error("拼装数据耗时[" + table + "]:"
				+ (System.currentTimeMillis() - start) / 1000 + "s,结果记录数："
				+ temp.size());
	}

	/**
	 * 支持分表的查询，则用多线程的方式实现市级以上的查询，不支持分表则当线程的方式查询，当前只有户籍人口支持分表
	 * 
	 * @param tableName
	 * @param organization
	 * @return
	 */
	private List<StatisticsBaseInfoAddCountVo> statisticsBaseInfo(
			final String tableName, Organization organization) {
		String column = "isEmphasis";
		if (BaseInfoTables.personnelTables.containsValue(tableName)) {
			column = "logOut";
		}
		if (tableName.equalsIgnoreCase("houseinfo")
				|| tableName.equalsIgnoreCase("builddatas")) {
			column = null;
		}

		// 判断是否分表，当前只有户籍人口,房屋支持分表
		if (!BaseInfoTables.personnelTables.get(
				BaseInfoTables.HOUSEHOLDSTAFF_KEY).equalsIgnoreCase(tableName)
				&& !BaseInfoTables.HOUSEINFO_KEY.equals(tableName)) {
			return leaderViewNewDao.statisticsBaseInfoAddCountByOrg(tableName,
					column, organization.getOrgInternalCode(), null);
		} else {
			List<Organization> orgs = organizationDubboService
					.findOrgsByOrgTypeAndOrgLevelAndParentId(
							OrganizationType.ADMINISTRATIVE_REGION,
							OrganizationLevel.CITY, organization.getId());
			if (orgs.isEmpty()) {// 市级以下组织，需要传入orgcode来过滤数据
				return leaderViewNewDao.statisticsBaseInfoAddCountByOrg(
						tableName, column, organization.getOrgInternalCode(),
						shardConversion.getShardCode(organization));
			} else if (orgs.size() == 1) {// 市级组织，无需传入orgcode过滤数据，提升查询效率
				return leaderViewNewDao.statisticsBaseInfoAddCountByOrg(
						tableName, column, "",
						shardConversion.getShardCode(orgs.get(0)));
			} else {// 市级以上组织需要使用多线程跨表查询
				final List<StatisticsBaseInfoAddCountVo> result = Collections
						.synchronizedList(new ArrayList<StatisticsBaseInfoAddCountVo>());
				ExecutorService pool = Executors.newFixedThreadPool(5 > orgs
						.size() ? orgs.size() : 5);
				final CountDownLatch latch = new CountDownLatch(orgs.size());
				final String temp = column;
				for (final Organization org : orgs) {
					Runnable command = new Runnable() {
						@Override
						public void run() {
							try {
								result.addAll(leaderViewNewDao
										.statisticsBaseInfoAddCountByOrg(
												tableName, temp, "",
												shardConversion
														.getShardCode(org)));
							} finally {
								latch.countDown();
							}
						}
					};
					pool.execute(command);
				}
				try {
					latch.await();
				} catch (InterruptedException e) {
					logger.error("", e);
				}
				return result;
			}
		}
	}

	private List<Long> getOrganizationsByLevel(String level) {
		PropertyDict levelDict = propertyDictService
				.getPropertyDictByDomainName(level);

		PropertyDict typeDict = propertyDictService
				.getPropertyDictByDomainName(OrganizationType.ADMINISTRATIVE_KEY);

		if (levelDict != null && levelDict.getId() != null && typeDict != null
				&& typeDict.getId() != null) {
			return organizationDubboService.getOrganizationsByLevel(
					typeDict.getId(), levelDict.getId());
		}
		return null;
	}

	public List<StatisticsBaseInfoAddCountVo> statisticsBaseInfo(Long orgId,
			String tableName, boolean isGrid) {
		String table = PopulationCatalog.parse(tableName)
				.getStatisticListSetting().getTableName();
		return statisticsBaseInfoCurrent(orgId, table, isGrid);
	}

	private List<StatisticsBaseInfoAddCountVo> statisticsBaseInfoCurrent(
			Long orgId, String tableName, boolean isGrid) {
		String key = MemCacheConstant.getCurrentKey(orgId, tableName);
		List<StatisticsBaseInfoAddCountVo> result = null;
		result = leaderViewCacheService.getDatasByCacheKeyForJob(
				MemCacheConstant.LEADERVIEW_NAMESPACE, key,
				StatisticsBaseInfoAddCountVo.class);
		
		if (result == null) {
			Organization organization = organizationDubboService
					.getSimpleOrgById(orgId);
			StatisticsNode root = AnalyseUtilNew.getRootNode(cacheService,
					organizationDubboService, organization, false);
			long start = System.currentTimeMillis();
			List<StatisticsBaseInfoAddCountVo> baseInfoAddCountVoList = statisticsBaseInfo(
					tableName, organization);
			logger.error("统计[" + tableName + "]："
					+ baseInfoAddCountVoList.size() + "条数据量耗时"
					+ (System.currentTimeMillis() - start) / 1000 + "s");
			// 根据获取的统计数据类别计算本月减少的数据
			// 只有户籍和流口才计算
			if (BaseInfoTables.personnelTables.get(
					BaseInfoTables.HOUSEHOLDSTAFF_KEY).equalsIgnoreCase(
					tableName)
					|| BaseInfoTables.personnelTables.get(
							BaseInfoTables.FLOATINGPOPULATION_KEY)
							.equalsIgnoreCase(tableName)) {
				String populationType = "";
				if (BaseInfoTables.personnelTables.get(
						BaseInfoTables.HOUSEHOLDSTAFF_KEY).equalsIgnoreCase(
						tableName)) {
					populationType = BaseInfoTables.HOUSEHOLDSTAFF_KEY;
				} else {
					populationType = BaseInfoTables.FLOATINGPOPULATION_KEY;
				}
				// 根据类别获取上月数据集合
				Date lastMonthDate = CalendarUtil.getLastMonthEnd(
						CalendarUtil.getNowYear(), CalendarUtil.getNowMonth());
				int year = CalendarUtil.getYear(lastMonthDate);
				int month = CalendarUtil.getMonth(lastMonthDate);
				Long orgType = propertyDictService
						.findPropertyDictByDomainNameAndDictDisplayName(
								OrganizationType.ORG_TYPE_KEY,
								OrganizationType.ADMINISTRATIVE_KEY).getId();
				List<StatisticsBaseInfoAddCountVo> lastMonthData = leaderViewNewDao
						.getPopulationInfoByDate(orgId, year, month,
								populationType, orgType);
				// 循环遍历计算本月减少数据
				if (baseInfoAddCountVoList != null
						&& baseInfoAddCountVoList.size() != 0
						&& lastMonthData != null && lastMonthData.size() != 0) {
					for (StatisticsBaseInfoAddCountVo currentData : baseInfoAddCountVoList) {
						for (StatisticsBaseInfoAddCountVo lastData : lastMonthData) {
							Organization lastOrg = organizationDubboService
									.getOrganizationByOrgInternalCode(lastData
											.getStatisticsType());
							if (lastOrg != null && lastOrg.getId() != null) {
								if (currentData.getStatisticsType().equals(
										lastOrg.getId().toString())) {
									// 本月减少=|本月新增-（本月总数-上月总数）|
									currentData
											.setThisMonthReduceCount(Math.abs(currentData
													.getThisMonthCount()
													- (currentData
															.getAllCount() - lastData
															.getAllCount())));
								}
							}
						}

					}
				}
			}
			result = AnalyseUtilNew.totalResult(leaderViewCacheService,
					tableName, baseInfoAddCountVoList, root, tableName, key,
					false);
		}
		return result;

	}

	@Override
	public List<StatisticsBaseInfoAddCountVo> statisticsBaseInfoSummary(
			Long orgId, String tableName) {
		List<StatisticsBaseInfoAddCountVo> result = statisticsDateByTableType(
				orgId, BaseInfoTables.getTypeDisplayNames(tableName), "old");
		return result;
	}

	public List<StatisticsBaseInfoAddCountVo> statisticsPopulationSummary(
			Long orgId, String tableName) {
		List<StatisticsBaseInfoAddCountVo> result = statisticsDateByTableType(
				orgId, tableName, "population");
		return result;
	}

	public List<StatisticsBaseInfoAddCountVo> statisticsSummary(Long orgId,
			String tableName) {
		List<StatisticsBaseInfoAddCountVo> result = statisticsDateByTableType(
				orgId, tableName, "civil");
		return result;
	}

	/**
	 * @param orgId
	 * @param tableName
	 * @return
	 */
	private List<StatisticsBaseInfoAddCountVo> statisticsDateByTableType(
			Long orgId, String tableName, String type) {
		String[] time = new String[12];
		time = getTime(time);
		String catchKey = MemCacheConstant.getSummaryKey(tableName, time[0],
				orgId);
		List<StatisticsBaseInfoAddCountVo> result = leaderViewCacheService
				.getDatasByCacheKeyForJob(
						MemCacheConstant.LEADERVIEW_NAMESPACE, catchKey,
						StatisticsBaseInfoAddCountVo.class);
		if (result == null) {
			Organization currentOrg = organizationDubboService
					.getSimpleOrgById(orgId);
			if (currentOrg == null) {
				return new ArrayList<StatisticsBaseInfoAddCountVo>();
			}
			result = new ArrayList<StatisticsBaseInfoAddCountVo>();
			for (int j = 0; j < time.length; j++) {
				String strTime = time[j];
				String year = strTime.substring(0, strTime.indexOf("-"));
				String month = strTime.substring(strTime.indexOf("-") + 1);
				StatisticsBaseInfoAddCountVo vo = null;
				vo = createBaseinfo(tableName, type, orgId, strTime, year,
						month);
				vo.setStatisticsType(strTime);
				result.add(vo);
			}
			Collections.sort(result);
			leaderViewCacheService
					.addOrUpdateCacheByKey(
							MemCacheConstant.LEADERVIEW_NAMESPACE,
							new LeaderViewCache<StatisticsBaseInfoAddCountVo>(
									catchKey, result,
									LeaderViewCacheType.STATISTICS_SUMMARY_TYPE),
							StatisticsBaseInfoAddCountVo.class);
		}

		return result;
	}

	/**
	 * 为job提供
	 * 
	 * @param orgId
	 * @param tableName
	 * @return
	 */
	private List<StatisticsBaseInfoAddCountVo> statisticsDateByTableTypeForJob(
			Long orgId, String tableName, String type) {

		String[] time = new String[12];
		time = getTime(time);
		String catchKey = MemCacheConstant.getSummaryKey(tableName, time[0],
				orgId);

		List<StatisticsBaseInfoAddCountVo> result = null;

		Organization currentOrg = organizationDubboService
				.getSimpleOrgById(orgId);
		if (currentOrg == null) {
			return new ArrayList<StatisticsBaseInfoAddCountVo>();
		}
		result = new ArrayList<StatisticsBaseInfoAddCountVo>();
		for (int j = 0; j < time.length; j++) {
			String strTime = time[j];
			String year = strTime.substring(0, strTime.indexOf("-"));
			String month = strTime.substring(strTime.indexOf("-") + 1);
			StatisticsBaseInfoAddCountVo vo = null;
			vo = createBaseinfo(tableName, type, orgId, strTime, year, month);
			vo.setStatisticsType(strTime);
			result.add(vo);
		}
		Collections.sort(result);
		leaderViewCacheService.addOrUpdateCacheByKey(
				MemCacheConstant.LEADERVIEW_NAMESPACE,
				new LeaderViewCache<StatisticsBaseInfoAddCountVo>(catchKey,
						result, LeaderViewCacheType.STATISTICS_SUMMARY_TYPE),
				StatisticsBaseInfoAddCountVo.class);
		// }

		return result;
	}

	private StatisticsBaseInfoAddCountVo createBaseinfo(String tableName,
			String type, Long orgId, String strTime, String year, String month) {
		StatisticsBaseInfoAddCountVo vo = null;
		if ("population".equals(type)) {
			vo = leaderViewNewDao.statisticsPopulationSummary(orgId, strTime,
					tableName, Integer.parseInt(year), Integer.parseInt(month));
		} else if ("old".equals(type)) {
			vo = leaderViewNewDao.statisticsBaseInfoSummary(orgId, strTime,
					tableName, Integer.parseInt(year), Integer.parseInt(month));
		} else if ("civil".equals(type)) {
			vo = leaderViewNewDao.statisticsSummary(orgId, strTime, tableName,
					Integer.parseInt(year), Integer.parseInt(month));
		}
		return vo;
	}

	@Override
	public List<StatisticsBaseInfoAddCountVo> personGeneralCondition(
			Long orgId, String tableType) {
		List<String> keyNameList = null;
		List<StatisticsBaseInfoAddCountVo> datas = new ArrayList<StatisticsBaseInfoAddCountVo>();
		// List<Organization> orgList = organizaitonService
		// .findAdminOrgsByParentId(orgId);
		// if (orgList.size() == 0) {
		// orgList.add(organizaitonService.getSimpleOrgById(orgId));
		// }
		keyNameList = new ArrayList<String>(BaseInfoTables.keyTablesMaps.get(
				tableType).keySet());
		// String column = "isEmphasis";
		// if ("POPULATION".equals(tableType)) {
		// column = "logOut";
		// }
		String catchKey = MemCacheConstant.getCurrentKey(orgId, tableType);
		// datas = (List<StatisticsBaseInfoAddCountVo>)
		// cacheService.get(catchKey);
		datas = leaderViewCacheService.getDatasByCacheKey(
				MemCacheConstant.LEADERVIEW_NAMESPACE, catchKey,
				StatisticsBaseInfoAddCountVo.class);
		if (datas == null) {
			String catchKeyLock = AnalyseUtilNew.STATCOUNTBYORGIDKEY + orgId
					+ tableType + AnalyseUtilNew.LOCK_KEY;
			if (!cacheService.add(catchKeyLock, 60, tableType)) {
				return new ArrayList<StatisticsBaseInfoAddCountVo>();
			}
			datas = new ArrayList<StatisticsBaseInfoAddCountVo>();
			// for (Organization org : orgList) {
			// datas.add(getStatisticsBaseInfoAddCountVoResult(org,
			// keyNameList, column));
			// }
			for (String tableName : keyNameList) {
				List<StatisticsBaseInfoAddCountVo> result = statisticsBaseInfoCurrent(
						orgId, BaseInfoTables.getTypeValue(tableName), false);
				if (datas == null || datas.size() == 0) {
					datas.addAll(result);
				} else {
					accumulativeResult(datas, result);
				}
			}
			// getLastResult(datas);
			leaderViewCacheService.addOrUpdateCacheByKey(
					MemCacheConstant.LEADERVIEW_NAMESPACE,
					new LeaderViewCache<StatisticsBaseInfoAddCountVo>(catchKey,
							datas), StatisticsBaseInfoAddCountVo.class);
		}

		return datas;
	}

	@Override
	public List<StatisticsBaseInfoAddCountVo> personMonthGeneralCondition(
			Long orgId, String tableType) {
		return statisticsData(orgId, tableType, "old");
	}

	private List<StatisticsBaseInfoAddCountVo> statisticsData(Long orgId,
			String tableType, String type) {
		Organization currentOrg = organizationDubboService
				.getSimpleOrgById(orgId);
		int internalId = propertyDictService.getPropertyDictById(
				currentOrg.getOrgLevel().getId()).getInternalId();
		if (internalId == OrganizationLevel.GRID) {
			currentOrg = organizationDubboService.getSimpleOrgById(currentOrg
					.getParentOrg().getId());
		}
		String[] time = new String[12];
		time = getTime(time);
		String catchKey = MemCacheConstant.getSummaryKey(tableType, time[0],
				orgId);
		// datas = (List<StatisticsBaseInfoAddCountVo>)
		// cacheService.get(catchKey);
		List<StatisticsBaseInfoAddCountVo> datas = leaderViewCacheService
				.getDatasByCacheKeyForJob(
						MemCacheConstant.LEADERVIEW_NAMESPACE, catchKey,
						StatisticsBaseInfoAddCountVo.class);
		// datas=null; //测试
		if (datas == null) {
			datas = new ArrayList<StatisticsBaseInfoAddCountVo>();
			List<String> keyNameList = new ArrayList<String>();
			if (tableType.equals(BaseInfoTables.IMPORTANTPLACE_KEY)) {
				keyNameList.add(tableType);
			} else {
				keyNameList = createTables(tableType, type);
			}

			for (int j = 0; j < time.length; j++) {
				String strTime = time[j];
				String year = strTime.substring(0, strTime.indexOf("-"));
				String month = strTime.substring(strTime.indexOf("-") + 1);
				StatisticsBaseInfoAddCountVo voResult = getPersonMonthGeneralConditionResult(
						orgId, strTime, keyNameList, year, month, type);
				voResult.setStatisticsType(strTime);
				datas.add(voResult);
			}
			Collections.sort(datas);
			leaderViewCacheService
					.addOrUpdateCacheByKey(
							MemCacheConstant.LEADERVIEW_NAMESPACE,
							new LeaderViewCache<StatisticsBaseInfoAddCountVo>(
									catchKey, datas,
									LeaderViewCacheType.STATISTICS_SUMMARY_TYPE),
							StatisticsBaseInfoAddCountVo.class);
		}
		return datas;
	}

	@Override
	public List<StatisticsBaseInfoAddCountVo> populationMonthGeneralCondition(
			Long orgId, String tableType) {
		return statisticsData(orgId, tableType, "population");
	}

	@Override
	public List<StatisticsBaseInfoAddCountVo> monthGeneralCondition(Long orgId,
			String tableType) {
		return statisticsData(orgId, tableType, "civil");
	}

	private StatisticsBaseInfoAddCountVo getPersonMonthGeneralConditionResult(
			Long orgId, String time, List<String> keyNameList, String year,
			String month, String type) {
		StatisticsBaseInfoAddCountVo voResult = new StatisticsBaseInfoAddCountVo();
		Integer todayAddCount = 0;
		Integer thisMonthCount = 0;
		Integer attentionCount = 0;
		Integer allCount = 0;

		for (int j = 0; j < keyNameList.size(); j++) {
			StatisticsBaseInfoAddCountVo vo = createBaseinfo(
					keyNameList.get(j), type, orgId, time, year, month);
			todayAddCount += vo.getTodayAddCount();
			thisMonthCount += vo.getThisMonthCount();
			attentionCount += vo.getAttentionCount();
			allCount += vo.getAllCount();
		}
		voResult.setTodayAddCount(todayAddCount);
		voResult.setThisMonthCount(thisMonthCount);
		voResult.setAttentionCount(attentionCount);
		voResult.setAllCount(allCount);
		return voResult;
	}

	private List<String> createTables(String tableType, String type) {
		if ("civil".equals(type)) {
			return new ArrayList<String>(PopulationCatalog.getCatalogs(
					tableType).keySet());
		}
		return new ArrayList<String>(BaseInfoTables.keyTablesMaps
				.get(tableType).keySet());
	}

	private void accumulativeResult(List<StatisticsBaseInfoAddCountVo> datas,
			List<StatisticsBaseInfoAddCountVo> result) {
		for (StatisticsBaseInfoAddCountVo statisticsBaseInfoAddCountVo : datas) {
			for (StatisticsBaseInfoAddCountVo tempStatisticsBaseInfoAddCountVo : result) {
				// 判断层级的名称是否相同,如相同各统计数值相加
				if (statisticsBaseInfoAddCountVo.getStatisticsType().equals(
						tempStatisticsBaseInfoAddCountVo.getStatisticsType())) {
					statisticsBaseInfoAddCountVo
							.setAllCount(statisticsBaseInfoAddCountVo
									.getAllCount()
									+ tempStatisticsBaseInfoAddCountVo
											.getAllCount());
					statisticsBaseInfoAddCountVo
							.setAttentionCount(statisticsBaseInfoAddCountVo
									.getAttentionCount()
									+ tempStatisticsBaseInfoAddCountVo
											.getAttentionCount());
					statisticsBaseInfoAddCountVo
							.setInvolveSinkiangCount(statisticsBaseInfoAddCountVo
									.getInvolveSinkiangCount()
									+ tempStatisticsBaseInfoAddCountVo
											.getInvolveSinkiangCount());
					statisticsBaseInfoAddCountVo
							.setInvolveTibetCount(statisticsBaseInfoAddCountVo
									.getInvolveTibetCount()
									+ tempStatisticsBaseInfoAddCountVo
											.getInvolveTibetCount());
					statisticsBaseInfoAddCountVo
							.setThisMonthCount(statisticsBaseInfoAddCountVo
									.getThisMonthCount()
									+ tempStatisticsBaseInfoAddCountVo
											.getThisMonthCount());
					statisticsBaseInfoAddCountVo
							.setTodayAddCount(statisticsBaseInfoAddCountVo
									.getTodayAddCount()
									+ tempStatisticsBaseInfoAddCountVo
											.getTodayAddCount());
				}
			}
		}
	}

	private String[] getTime(String[] time) {
		Date nowDate = new Date();
		Calendar nowCalendar = Calendar.getInstance();
		nowCalendar.setTime(nowDate);
		nowCalendar.add(Calendar.MONTH, -12);
		for (int i = 0; i < 12; i++) {
			SimpleDateFormat timePattern = new SimpleDateFormat("yyyy-MM");
			time[i] = timePattern.format(nowCalendar.getTime());
			nowCalendar.add(Calendar.MONTH, 1);
		}
		return sortTime(time);
	}

	private static String[] sortTime(String[] time) {
		String[] sortTime = new String[12];
		for (int j = time.length - 1; j >= 0; j--) {
			sortTime[time.length - 1 - j] = time[j];
		}
		return sortTime;
	}

	@Override
	public Map personGeneralConditionForMobile(Long orgId, String tableType) {
		Map result = new HashMap();
		String displayname = BaseInfoTables.getKeyName().get(tableType);
		List histogram = generateHistogramForMobile(orgId, tableType);

		result.put("displayname", displayname);
		result.put("histogram", histogram);
		result.put("histogramFirstName", "今日");
		result.put("histogramSecondName", "本月");
		return result;
	}

	private List generateHistogramForMobile(Long orgId, String tableType) {
		/**
		 * 正常情况下都应该从BaseInfoTables中获取表的信息，但是现在BaseInfoTables表中只包含出租房的信息没有实有房屋的信息
		 * ， 在保持BaseInfoTables不变的情况，对于查询实有房屋信息临时采用别的方法，如果可能该方法应该被修改。
		 **/
		if (orgId == null || StringUtils.isEmpty(tableType)) {
			throw new BusinessValidationException("参数错误!");
		}
		if (BaseInfoTables.ACTUALHOUSE_KEY.equals(tableType)) {
			return generateActualHouseHistogramForMobile(orgId, tableType);
		}

		List<String> keyNameList = new ArrayList<String>(
				BaseInfoTables.keyTablesMaps.get(tableType).keySet());

		if (keyNameList == null || keyNameList.isEmpty()) {
			throw new BusinessValidationException("系统异常!");
		}
		List result = new ArrayList();
		Organization org = organizationDubboService.getSimpleOrgById(orgId);

		for (int i = 0; i < keyNameList.size(); i++) {
			Map item = new HashMap();
			String keyName = keyNameList.get(i);

			int nowYear = CalendarUtil.getNowYear();
			int nowMonth = CalendarUtil.getNowMonth();

			StatisticsBaseInfoAddCountVo vo = leaderViewNewDao
					.personGeneralConditionForMobile(org.getOrgInternalCode(),
							CalendarUtil.today(), CalendarUtil.getTomorrow(),
							CalendarUtil.getMonthStart(nowYear, nowMonth),
							CalendarUtil.getNextMonthStart(nowYear, nowMonth),
							BaseInfoTables.getTypeValue(keyName));

			int todayData = vo.getTodayAddCount();
			int thisMonthCount = vo.getThisMonthCount();
			String dispalyName = BaseInfoTables.getKeyName().get(keyName);

			item.put("dispalyName", dispalyName);
			item.put("sequence", i + 1);
			item.put("todayData", todayData);
			item.put("thisMonthCount", thisMonthCount);

			result.add(item);
		}

		return result;
	}

	/**
	 * 统计实有房屋今天和本月新增的数据
	 * 
	 * @param orgId
	 * @param tableType
	 * @return
	 */
	private List generateActualHouseHistogramForMobile(Long orgId,
			String tableType) {
		if (orgId == null || StringUtils.isEmpty(tableType)) {
			throw new BusinessValidationException("参数错误!");
		}

		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		List result = new ArrayList();

		Map<String, String> tableNameMap = new HashMap<String, String>();
		Map<String, String> tableMap = new HashMap<String, String>();

		tableNameMap.put("houseinfo_key", "房屋信息");
		tableMap.put("houseinfo_key", "houseinfo");
		tableNameMap.put("rentalhouse_key", "出租房");
		tableMap.put("rentalhouse_key", "rentalhouse");

		List<String> keyNameList = new ArrayList<String>(tableNameMap.keySet());

		for (int i = 0; i < keyNameList.size(); i++) {
			Map item = new HashMap();
			String keyName = keyNameList.get(i);

			int nowYear = CalendarUtil.getNowYear();
			int nowMonth = CalendarUtil.getNowMonth();

			StatisticsBaseInfoAddCountVo vo = leaderViewNewDao
					.personGeneralConditionForMobile(org.getOrgInternalCode(),
							CalendarUtil.today(), CalendarUtil.getTomorrow(),
							CalendarUtil.getMonthStart(nowYear, nowMonth),
							CalendarUtil.getNextMonthStart(nowYear, nowMonth),
							tableMap.get(keyName));

			int todayData = vo.getTodayAddCount();
			int thisMonthCount = vo.getThisMonthCount();
			String dispalyName = tableNameMap.get(keyName);

			item.put("dispalyName", dispalyName);
			item.put("sequence", i + 1);
			item.put("todayData", todayData);
			item.put("thisMonthCount", thisMonthCount);

			result.add(item);
		}
		return result;
	}

	public void statisticsYouthsAddCountByOrgIdForJob() {
		List<Long> countryList = getOrganizationsByLevel(OrganizationLevel.COUNTRY_KEY);
		for (Long countryOrgId : countryList) {
			final Organization country = organizationDubboService
					.getSimpleOrgById(countryOrgId);
			final CountDownLatch latch = new CountDownLatch(
					YouthsType.youthsTypes.size());
			for (final Map.Entry<String, String> youthsTypesEntry : YouthsType.youthsTypes
					.entrySet()) {
				Thread youthsThread = new Thread(youthsTypesEntry.getValue()) {
					@Override
					public void run() {
						SearchYouthsVo searchYouthsVo = new SearchYouthsVo();
						searchYouthsVo.setKeyType(youthsTypesEntry.getKey());
						searchYouthsVo.setOrganization(country);
						SessionHelper.createMockAdminSession();
						try {
							logger.error("查询[" + searchYouthsVo.getKeyType()
									+ "]数据开始");
							long start = System.currentTimeMillis();
							final List<StatisticsBaseInfoAddCountVo> baseInfoAddCountVoList = statisticsYouth(searchYouthsVo);
							logger.error("查询" + searchYouthsVo.getKeyType()
									+ "数据耗时:"
									+ (System.currentTimeMillis() - start)
									/ 1000l + "s，结果记录数:"
									+ baseInfoAddCountVoList.size());
							StatisticsNode root = AnalyseUtilNew.getRootNode(
									cacheService, organizationDubboService,
									country, true);
							AnalyseUtilNew.totalResult(leaderViewCacheService,
									youthsTypesEntry.getValue(),
									baseInfoAddCountVoList, root,
									searchYouthsVo.getKeyType(), null, true);
						} catch (Exception e) {
							logger.error("", e);
						} finally {
							latch.countDown();
						}
					}
				};
				youthsThread.start();
			}
			try {
				latch.await();
			} catch (InterruptedException e) {
				logger.error("", e);
			}
		}
	}

	@Override
	public List<StatisticsBaseInfoAddCountVo> statisticsYouthsCount(
			SearchYouthsVo searchYouthsVo, boolean isGrid) {
		Long orgId = null;
		if (searchYouthsVo.getOrganization() != null) {
			orgId = searchYouthsVo.getOrganization().getId();
		} else {
			throw new BusinessValidationException("请输入正确的组织机构");
		}
		String key = MemCacheConstant.getCurrentKey(orgId,
				searchYouthsVo.getKeyType());
		/*
		 * Object cacheResult = cacheService.get(key);
		 * List<StatisticsBaseInfoAddCountVo> result = new
		 * ArrayList<StatisticsBaseInfoAddCountVo>(); if (cacheResult != null) {
		 * result = (List<StatisticsBaseInfoAddCountVo>) cacheResult; } else {
		 * result = getStatisticsYouthsCountCacheValue(key, result,
		 * searchYouthsVo, orgId); }
		 */
		List<StatisticsBaseInfoAddCountVo> result = leaderViewCacheService
				.getDatasByCacheKeyForJob(
						MemCacheConstant.LEADERVIEW_NAMESPACE, key,
						StatisticsBaseInfoAddCountVo.class);
		if (result == null) {
			Organization organization = organizationDubboService
					.getSimpleOrgById(orgId);
			StatisticsNode root = AnalyseUtilNew.getRootNode(cacheService,
					organizationDubboService, organization, false);
			logger.error("查询[" + searchYouthsVo.getKeyType() + "]数据开始");
			long start = System.currentTimeMillis();
			final List<StatisticsBaseInfoAddCountVo> baseInfoAddCountVoList = statisticsYouth(searchYouthsVo);
			logger.error("查询" + searchYouthsVo.getKeyType() + "数据耗时:"
					+ (System.currentTimeMillis() - start) / 1000l + "s");
			result = AnalyseUtilNew.totalResult(leaderViewCacheService,
					searchYouthsVo.getKeyType(), baseInfoAddCountVoList, root,
					searchYouthsVo.getKeyType(), key, false);
		}
		return result;
	}

	private List<StatisticsBaseInfoAddCountVo> statisticsYouth(
			SearchYouthsVo searchYouthsVo) {
		YouthsType.fillBeginAgeAndEndAge(searchYouthsVo, propertyDictService);
		List<StatisticsBaseInfoAddCountVo> baseInfoAddCountVoList = Collections
				.synchronizedList(new ArrayList<StatisticsBaseInfoAddCountVo>());
		CountDownLatch countDownLatch = new CountDownLatch(
				YouthsType.THREADE_AMOUNT);

		// 户籍人口
		SearchYouthsVo householdstaffsVo = searchYouthsVo.clone();
		householdstaffsVo.setTableName(YouthsType.YOUTHS_HOUSEHOLDSTAFFS);
		startStatisticsThread(householdstaffsVo, baseInfoAddCountVoList,
				countDownLatch);
		// 流动人口
		SearchYouthsVo floatingpopulationsVo = searchYouthsVo.clone();
		floatingpopulationsVo
				.setTableName(YouthsType.YOUTHS_FLOATINGPOPULATIONS);
		startStatisticsThread(floatingpopulationsVo, baseInfoAddCountVoList,
				countDownLatch);

		// 未落户人口
		SearchYouthsVo unsettledpopulationsVo = searchYouthsVo.clone();
		unsettledpopulationsVo
				.setTableName(YouthsType.YOUTHS_UNSETTLEDPOPULATIONS);
		startStatisticsThread(unsettledpopulationsVo, baseInfoAddCountVoList,
				countDownLatch);

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			logger.error("", e);
		}
		return baseInfoAddCountVoList;
	}

	private void startStatisticsThread(final SearchYouthsVo householdstaffsVo,
			final List<StatisticsBaseInfoAddCountVo> baseInfoAddCountVoList,
			final CountDownLatch countDownLatch) {
		Thread thread = new Thread(householdstaffsVo.getTableName()) {
			@Override
			public void run() {
				try {
					if (!YouthsType.YOUTHS_HOUSEHOLDSTAFFS
							.equalsIgnoreCase(householdstaffsVo.getTableName())) {
						baseInfoAddCountVoList.addAll(leaderViewNewDao
								.statisticsYouthsCount(householdstaffsVo));
					} else {
						if (shardConversion.isOverCity(householdstaffsVo
								.getOrganization())) {
							List<Organization> orgs = organizationDubboService
									.findOrgsByOrgTypeAndOrgLevelAndParentId(
											OrganizationType.ADMINISTRATIVE_REGION,
											OrganizationLevel.CITY,
											householdstaffsVo.getOrganization()
													.getId());
							for (Organization org : orgs) {
								householdstaffsVo.setOrgInternalCode(org
										.getOrgInternalCode());
								householdstaffsVo.setShardCode(shardConversion
										.getShardCode(org));
								baseInfoAddCountVoList
										.addAll(leaderViewNewDao
												.statisticsYouthsCount(householdstaffsVo));
							}
						} else {
							householdstaffsVo.setShardCode(shardConversion
									.getShardCode(householdstaffsVo
											.getOrganization()));
							baseInfoAddCountVoList.addAll(leaderViewNewDao
									.statisticsYouthsCount(householdstaffsVo));
						}
					}
				} catch (Throwable t) {
					logger.error("", t);
				} finally {
					countDownLatch.countDown();
				}
			}
		};
		thread.start();
	}

	@Override
	public List<StatisticsBaseInfoAddCountVo> statisticsYouthsMonthSummary(
			Long orgId, String keyType, boolean isGrid) {
		// Organization currentOrg = organizationDubboService
		// .getSimpleOrgById(orgId);
		// String orgCode = currentOrg.getOrgInternalCode();
		String[] time = new String[12];
		time = getTime(time);
		String catchKey = MemCacheConstant.getSummaryKey(keyType, time[0],
				orgId);
		List<StatisticsBaseInfoAddCountVo> result = leaderViewCacheService
				.getDatasByCacheKeyForJob(
						MemCacheConstant.LEADERVIEW_NAMESPACE, catchKey,
						StatisticsBaseInfoAddCountVo.class);
		if (result == null) {
			result = new ArrayList<StatisticsBaseInfoAddCountVo>();
			for (int j = 0; j < time.length; j++) {
				String strTime = time[j];
				String year = strTime.substring(0, strTime.indexOf("-"));
				String month = strTime.substring(strTime.indexOf("-") + 1);

				tableService.createAnalyseTable(
						AnalyseUtilNew.YOUTH_TABLE_NAME,
						AnalyseUtilNew.ACTUALPERSONSQL, Integer.parseInt(year),
						Integer.parseInt(month));
				StatisticsBaseInfoAddCountVo vo = leaderViewNewDao
						.statisticsYouthSummary(orgId, keyType,
								Integer.parseInt(year), Integer.parseInt(month));
				vo.setStatisticsType(strTime);
				result.add(vo);
			}
			Collections.sort(result);
			leaderViewCacheService
					.addOrUpdateCacheByKey(
							MemCacheConstant.LEADERVIEW_NAMESPACE,
							new LeaderViewCache<StatisticsBaseInfoAddCountVo>(
									catchKey, result,
									LeaderViewCacheType.STATISTICS_SUMMARY_TYPE),
							StatisticsBaseInfoAddCountVo.class);
		}
		return result;
	}

	private List<StatisticsBaseInfoAddCountVo> statisticsYouthsMonthSummaryForJob(
			Long orgId, String keyType, boolean isGrid) {
		String[] time = new String[12];
		time = getTime(time);
		String catchKey = MemCacheConstant.getSummaryKey(keyType, time[0],
				orgId);

		List<StatisticsBaseInfoAddCountVo> result = null;
		result = new ArrayList<StatisticsBaseInfoAddCountVo>();
		for (int j = 0; j < time.length; j++) {
			String strTime = time[j];
			String year = strTime.substring(0, strTime.indexOf("-"));
			String month = strTime.substring(strTime.indexOf("-") + 1);

			tableService.createAnalyseTable(AnalyseUtilNew.YOUTH_TABLE_NAME,
					AnalyseUtilNew.ACTUALPERSONSQL, Integer.parseInt(year),
					Integer.parseInt(month));
			StatisticsBaseInfoAddCountVo vo = leaderViewNewDao
					.statisticsYouthSummary(orgId, keyType,
							Integer.parseInt(year), Integer.parseInt(month));
			vo.setStatisticsType(strTime);
			result.add(vo);
		}
		Collections.sort(result);
		leaderViewCacheService.addOrUpdateCacheByKey(
				MemCacheConstant.LEADERVIEW_NAMESPACE,
				new LeaderViewCache<StatisticsBaseInfoAddCountVo>(catchKey,
						result, LeaderViewCacheType.STATISTICS_SUMMARY_TYPE),
				StatisticsBaseInfoAddCountVo.class);
		return result;
	}

	@Override
	public void createLeaderViewSummaryData() {
		try {
			List<String> companyPlaceMayKey = new ArrayList<String>(
					ModulTypes.allCompanyPlaceMapKey);
			companyPlaceMayKey.add(ModulTypes.ALL_COMPANY_PLACE_KEY);

			/** 清除数据 */
			// leaderViewCacheService
			// .deleteLeaderViewCache(LeaderViewCacheType.STATISTICS_SUMMARY_TYPE);
			/** 行政部门 */
			PropertyDict adminDict = propertyDictService
					.findPropertyDictByDomainNameAndInternalId(
							PropertyTypes.ORGANIZATION_TYPE,
							OrganizationType.ADMINISTRATIVE_REGION).get(0);
			/** 乡镇层级 */
			PropertyDict townOrgLevelDict = propertyDictService
					.findPropertyDictByDomainNameAndInternalId(
							PropertyTypes.ORGANIZATION_LEVEL,
							OrganizationLevel.TOWN).get(0);
			/** 获取所有的县级及以上行政部门id */
			List<Long> orgIds = organizationDubboService
					.getOrganizationByOrgLevelAndOrgType(
							townOrgLevelDict.getId(), adminDict.getId());
			if (orgIds != null && orgIds.size() != 0) {
				for (Long orgId : orgIds) {
					// 实有人口
					for (Entry<String, String> map : NewBaseInfoTables.actualPopulationTypes
							.entrySet()) {
						statisticsPopulationSummary(orgId, map.getKey());
					}
					// 业务人口
					for (Entry<String, String> map : NewBaseInfoTables.bussinessPopulationTypes
							.entrySet()) {
						statisticsSummary(orgId, map.getKey());
					}

					// 青少年
					for (Entry<String, String> map : NewBaseInfoTables.youthsTypes
							.entrySet()) {
						statisticsYouthsMonthSummary(orgId, map.getKey(), false);
					}
					// 单位场所
					for (String moduleKey : companyPlaceMayKey) {
						companyPlaceLeaderViewNewService.statisticsSummary(
								orgId, moduleKey);
					}
					// 房屋
					for (Entry<String, String> map : NewBaseInfoTables.houseTypes
							.entrySet()) {
						statisticsSummary(orgId, map.getKey());
					}
				}
			}
		} catch (Exception e) {
			throw new ServiceValidationException(
					"LeaderViewServiceImpl的createLeaderViewSummaryData方法错误：job调用生成领导视图历史月份数据出现错误",
					e);
		}

	}

	@Override
	public void createLeaderViewSummaryDataByType(String jobType) {
		if (!StringUtil.isStringAvaliable(jobType)) {
			throw new BusinessValidationException("类型错误");
		}
		try {
			List<Long> orgIds = getDistrictUpOrgIds();
			// 单位场所
			List<String> companyPlaceMayKey = new ArrayList<String>(
					ModulTypes.allCompanyPlaceMapKey);
			companyPlaceMayKey.add(ModulTypes.ALL_COMPANY_PLACE_KEY);
			if (orgIds != null && orgIds.size() != 0) {
				for (Long orgId : orgIds) {
					if (NewBaseInfoTables.COMPANYPLACEKEY.equals(jobType)) {

						for (String moduleKey : companyPlaceMayKey) {
							companyPlaceLeaderViewNewService
									.statisticsSummaryForJob(orgId, moduleKey);
						}
					} else if (NewBaseInfoTables.actualPopulationTypes
							.containsKey(jobType)) {
						statisticsDateByTableTypeForJob(orgId, jobType,
								"population");
					} else if (NewBaseInfoTables.bussinessPopulationTypes
							.containsKey(jobType)) {
						statisticsDateByTableTypeForJob(orgId, jobType, "civil");
					} else if (NewBaseInfoTables.youthsTypes
							.containsKey(jobType)) {
						statisticsYouthsMonthSummaryForJob(orgId, jobType,
								false);
					} else if (NewBaseInfoTables.houseTypes
							.containsKey(jobType)) {
						statisticsDateByTableTypeForJob(orgId, jobType, "civil");
					}
				}
			}
		} catch (Exception e) {
			throw new ServiceValidationException(
					"LeaderViewServiceImpl的createLeaderViewSummaryDataByType方法错误：手动调用生成领导视图历史月份数据出现错误",
					e);
		}
	}

	@Override
	public void createCompanyplaceLeaderViewSummaryData() {
		try {
			List<Long> orgIds = getDistrictUpOrgIds();
			if (orgIds != null && orgIds.size() != 0) {
				List<String> companyPlaceMayKey = new ArrayList<String>(
						ModulTypes.allCompanyPlaceMapKey);
				companyPlaceMayKey.add(ModulTypes.ALL_COMPANY_PLACE_KEY);
				for (Long orgId : orgIds) {
					for (String moduleKey : companyPlaceMayKey) {
						companyPlaceLeaderViewNewService
								.statisticsSummaryForJob(orgId, moduleKey);
					}
				}
			}
		} catch (Exception e) {
			throw new ServiceValidationException(
					"LeaderViewServiceImpl的createCompanyplaceLeaderViewSummaryData方法错误:",
					e);
		}

	}

	@Override
	public void createActualPopulationLeaderViewSummaryData() {
		try {
			List<Long> orgIds = getDistrictUpOrgIds();
			if (orgIds != null && orgIds.size() != 0) {
				for (Long orgId : orgIds) {
					// 实有人口
					for (Entry<String, String> map : NewBaseInfoTables.actualPopulationTypes
							.entrySet()) {
						statisticsDateByTableTypeForJob(orgId, map.getKey(),
								"population");
					}
				}
			}
		} catch (Exception e) {
			throw new ServiceValidationException(
					"LeaderViewServiceImpl的createActualPopulationLeaderViewSummaryData方法错误:",
					e);
		}

	}

	@Override
	public void createBussinessPopulationLeaderViewSummaryData() {
		try {
			List<Long> orgIds = getDistrictUpOrgIds();
			if (orgIds != null && orgIds.size() != 0) {
				for (Long orgId : orgIds) {
					// 业务人口
					for (Entry<String, String> map : NewBaseInfoTables.bussinessPopulationTypes
							.entrySet()) {
						statisticsDateByTableTypeForJob(orgId, map.getKey(),
								"civil");
					}

				}
			}
		} catch (Exception e) {
			throw new ServiceValidationException(
					"LeaderViewServiceImpl的createBussinessPopulationLeaderViewSummaryData方法错误:",
					e);
		}

	}

	@Override
	public void createYouthsLeaderViewSummaryData() {
		try {
			List<Long> orgIds = getDistrictUpOrgIds();
			if (orgIds != null && orgIds.size() != 0) {
				for (Long orgId : orgIds) {
					// 青少年
					for (Entry<String, String> map : NewBaseInfoTables.youthsTypes
							.entrySet()) {
						statisticsYouthsMonthSummaryForJob(orgId, map.getKey(),
								false);
					}
				}
			}
		} catch (Exception e) {
			throw new ServiceValidationException(
					"LeaderViewServiceImpl的createYouthsLeaderViewSummaryData方法错误:",
					e);
		}

	}

	@Override
	public void createHouseLeaderViewSummaryData() {
		try {
			List<Long> orgIds = getDistrictUpOrgIds();
			if (orgIds != null && orgIds.size() != 0) {
				for (Long orgId : orgIds) {
					// 房屋
					for (Entry<String, String> map : NewBaseInfoTables.houseTypes
							.entrySet()) {
						statisticsDateByTableTypeForJob(orgId, map.getKey(),
								"civil");
					}
				}
			}
		} catch (Exception e) {
			throw new ServiceValidationException(
					"LeaderViewServiceImpl的createHouseLeaderViewSummaryData方法错误:",
					e);
		}

	}

	private List<Long> getDistrictUpOrgIds() {
		/** 行政部门 */
		PropertyDict adminDict = propertyDictService
				.findPropertyDictByDomainNameAndInternalId(
						PropertyTypes.ORGANIZATION_TYPE,
						OrganizationType.ADMINISTRATIVE_REGION).get(0);
		/** 乡镇层级 */
		PropertyDict townOrgLevelDict = propertyDictService
				.findPropertyDictByDomainNameAndInternalId(
						PropertyTypes.ORGANIZATION_LEVEL,
						OrganizationLevel.TOWN).get(0);
		/** 获取所有的县级及以上行政部门id */
		return organizationDubboService.getOrganizationByOrgLevelAndOrgType(
				townOrgLevelDict.getId(), adminDict.getId());

	}

	/* 
	 * 计算特殊人群的总况月统计
	 */
	@Override
	public void setMothDataToLeaderViewCacheByType(String level, String type) {
//		Long time1=System.currentTimeMillis();
		String[] time = new String[12];
		time = getTime(time);
		List<String> allAttenCur=new ArrayList<String>();
		if(type.equals(PopulationCatalog.ALL_ATTENTION_POPULATION)){
			allAttenCur=createTables(PopulationCatalog.ALL_ATTENTION_POPULATION, "civil");
		}else if(type.equals(PopulationType.NURTURES_WOMEN)){
			allAttenCur.add(PopulationType.NURTURES_WOMEN);
		}else if(type.equals(PopulationType.ELDERLY_PEOPLE)){
			allAttenCur.add(PopulationType.ELDERLY_PEOPLE);
		}
		if(allAttenCur.size()<1){
			throw new ServiceException("类型错误");
		}
		Map<Long, List<StatisticsBaseInfoAddCountVo>>map=new HashMap<Long, List<StatisticsBaseInfoAddCountVo>>();
		PropertyDict levelDict = propertyDictService
				.getPropertyDictByDomainName(level);
		int i=0;
		for (String timeStr : time) {
			//计算出月份指定层级以上层级
			List<StatisticsBaseInfoAddCountVo>vos=leaderViewNewDao.
					getMothDataByType(timeStr,allAttenCur,levelDict.getId());
			//给每个层级加上月份的数据
			for (StatisticsBaseInfoAddCountVo vo:vos) {
				if(map.get(vo.getOrgId())==null){
					List<StatisticsBaseInfoAddCountVo>countVos=new ArrayList<StatisticsBaseInfoAddCountVo>();
					vo.setStatisticsType(time[i]);
					countVos.add(vo);
					map.put(vo.getOrgId(), countVos);
				}else {
					List<StatisticsBaseInfoAddCountVo>countVos=map.get(vo.getOrgId());
					vo.setStatisticsType(time[i]);
					countVos.add(vo);
				}
			}
			i++;
		}
		//把每个层级统计好的总况放入leaderViewCache表
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()){
			Entry e = (Entry)iter.next();
			String cacheKey=MemCacheConstant.getSummaryKey(type, time[0],(Long)e.getKey());
			//添加或覆盖数据
			List<StatisticsBaseInfoAddCountVo>countVos=(List<StatisticsBaseInfoAddCountVo>) e.getValue();
			Collections.sort(countVos);
			leaderViewCacheService
			.addOrUpdateCacheByKey(
					MemCacheConstant.LEADERVIEW_NAMESPACE,
					new LeaderViewCache<StatisticsBaseInfoAddCountVo>(
							cacheKey, countVos,
							LeaderViewCacheType.STATISTICS_SUMMARY_TYPE),
					StatisticsBaseInfoAddCountVo.class);
		}
//		Long time2=System.currentTimeMillis()-time1;
//		System.out.println(time2);
	}
}

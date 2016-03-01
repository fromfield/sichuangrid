package com.tianque.plugin.analysisNew.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianque.baseInfo.actualHouse.dao.ActualHouseDao;
import com.tianque.core.base.AbstractBaseService;
import com.tianque.core.cache.constant.MemCacheConstant;
import com.tianque.core.cache.service.CacheService;
import com.tianque.core.util.BaseInfoTables;
import com.tianque.core.util.CalendarUtil;
import com.tianque.core.util.StringUtil;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.property.OrganizationLevel;
import com.tianque.domain.property.OrganizationType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.issue.service.IssueService;
import com.tianque.plugin.analysisNew.dao.BaseInfoStatisticNewDao;
import com.tianque.plugin.analysisNew.domain.BaseinfoStatisticDetailVo;
import com.tianque.plugin.analysisNew.domain.BaseinfoStatisticVo;
import com.tianque.plugin.analysisNew.domain.HighchartColumnVo;
import com.tianque.plugin.analysisNew.domain.HighchartDataColumnVo;
import com.tianque.plugin.analysisNew.domain.StatisticSearchVo;
import com.tianque.plugin.analysisNew.util.AnalyseUtilNew;
import com.tianque.plugin.analysisNew.util.PacketStatisticsTables;
import com.tianque.plugin.analysisNew.util.PopulationCatalog;
import com.tianque.plugin.analysisNew.util.PopulationType;
import com.tianque.shard.util.ShardConversion;
import com.tianque.shard.util.ShardTables;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.sysadmin.service.PropertyDomainService;
import com.tianque.tableManage.service.TableManageService;

@Service("baseinfoStatisticNewService")
public class BaseinfoStatisticNewServiceImpl extends AbstractBaseService
		implements BaseinfoStatisticNewService {
	private static Logger logger = LoggerFactory
			.getLogger(BaseinfoStatisticNewServiceImpl.class);
	@Autowired
	private PropertyDictService propertyDictService;
	@Autowired
	private PropertyDomainService propertyDomainService;

	@Autowired
	private OrganizationDubboService organizationDubboService;
	@Autowired
	private BaseInfoStatisticNewDao baseInfoStatisticsNewDao;
	@Autowired
	private ActualHouseDao actualHouseDao;
	// 分表存储时用的service
	@Autowired
	private TableManageService tableService;
	@Autowired
	private IssueService issueService;

	@Autowired
	private PacketStatisticsService packetStatisticsService;
	@Autowired
	private ShardConversion shardConversion;
	@Autowired
	private CacheService cacheService;
	@Autowired
	private LeaderViewNewService leaderViewNewService;
	
	// private static final int INTERNAL_ID = 0;
	// private static final String DOMAIN_NAME = "网格类型";

	/**
	 * 列表信息
	 */
	@Override
	public List<BaseinfoStatisticVo> getStatisticInfoForList(long orgId,
			int year, int month, String type, String domainName,
			Integer orgLevelDistance) {
		checkHistoryStatisticTable(year, month);
		List<Map<String, Object>> lists;
		// 当月记录，先判断是不是总况
		if (year == Calendar.getInstance().get(Calendar.YEAR)
				&& month == (Calendar.getInstance().get(Calendar.MONTH) + 1)) {
			if (PopulationCatalog.ALL_YOUTH_POPULATION.equals(type)) {
				StatisticSearchVo statisticSearchVo = createYouthStatisticSearchVo(
						type, orgId, domainName);
				return getRealData(statisticSearchVo, null);
			}
			List<PopulationCatalog> list = getPopulationCatalogListByType(type);
			if (list != null && list.size() > 0) {
				// 总况的情况
				lists = baseInfoStatisticsNewDao.getTotalStatisticList(
						getStatisticSearchVoList(list, orgId),
						orgLevelDistance, getAdminsOrgType());
				return createBaseinfoStatisticVoByResultList(lists,
						new StatisticSearchVo());
			}
			// 单独某一个表当前月份
			StatisticSearchVo statisticSearchVo = createStatisticSearchVo(type,
					orgId, domainName);

			return getRealData(statisticSearchVo, orgLevelDistance);

		} else {// 单独某一个表历史记录
			String orginternalcode = organizationDubboService.getSimpleOrgById(
					orgId).getOrgInternalCode();
			List<PopulationCatalog> list = getPopulationCatalogListByType(type);
			if (!PopulationCatalog.ALL_YOUTH_POPULATION.equals(type)
					&& list != null && list.size() > 0) {
				//获取（'0~6岁'，'6~12岁'，'12~25岁'，'25~35岁'）
				String typeName = getIdleYouth_TypeName();
				// 总况的历史记录列表
				lists = baseInfoStatisticsNewDao
						.getTotalStatisticListFromHistory(
								getStatisticSearchVoList(list, orgId, year,
										month, orginternalcode),
								orgLevelDistance, getAdminsOrgType(),typeName);
				return createBaseinfoStatisticVoByResultList(lists,
						new StatisticSearchVo());
			}
			// 单独某一个表历史记录列表
			StatisticSearchVo statisticSearchVo = createStatisticSearchVo(type,
					orgId, domainName);
			statisticSearchVo.setYear(year);
			statisticSearchVo.setMonth(month);
			statisticSearchVo.setOrgId(orgId);
			statisticSearchVo.setType(type);
			statisticSearchVo.setOrgLevelDistance(orgLevelDistance);
			return getHistoryStatistic(statisticSearchVo);
		}

	}

	// private List<BaseinfoStatisticVo> sortByOrgSeq(
	// List<BaseinfoStatisticVo> realDatas, long orgId) {
	// List<BaseinfoStatisticVo> sortedBaseinfoStatisticVo = new
	// ArrayList<BaseinfoStatisticVo>();
	// List<Organization> organizations = organizationDubboService
	// .findAdminOrgsByParentId(orgId);
	// for (Organization org : organizations) {
	// for (BaseinfoStatisticVo realData : realDatas) {
	// if (org.getId().longValue() == realData.getOrgId()) {
	// sortedBaseinfoStatisticVo.add(realData);
	// }
	// }
	// }
	// sortedBaseinfoStatisticVo.add(realDatas.get(realDatas.size() - 1));
	// return sortedBaseinfoStatisticVo;
	// }

	class ComparatorList implements Comparator {

		public int compare(Object arg0, Object arg1) {
			Map<String, Object> map0 = (Map<String, Object>) arg0;
			Map<String, Object> map1 = (Map<String, Object>) arg1;
			// 姣旇緝缃戞牸
			int flag = ((BigDecimal) map0.get("ORGID"))
					.compareTo(((BigDecimal) map1.get("ORGID")));
			return flag;
		}
	}
	//关于重点青少年添加查询条件('0~6岁'，'6~18岁'，'12~25岁'，'25~35岁')
	public String getIdleYouth_TypeName(){
		PopulationCatalog populationCatalog = PopulationCatalog.parse(PopulationType.IDLE_YOUTH);
		String domain = populationCatalog.getStatisticListSetting().getDomainName();
		List<PropertyDict> propertyDictList = propertyDictService.findPropertyDictByDomainName(domain);
		StringBuilder result=new StringBuilder();
        boolean flag=false;
        if(propertyDictList != null && propertyDictList.size()>0){
        	for (PropertyDict propertyDict : propertyDictList) {
    			if (flag) {
                    result.append(",");
                }else {
                    flag=true;
                }
                result.append("'"+ propertyDict.getDisplayName()+"'");
            }
        }
		String typeName = result.toString();
		return typeName;
	}
	/**
	 * 获取单独某一个表当前月份的数据
	 * 
	 * @param statisticSearchVo
	 * @return
	 */
	private List<BaseinfoStatisticVo> getRealData(
			StatisticSearchVo statisticSearchVo, Integer orgLevelDistance) {
		statisticSearchVo.setOrgType(getOrgType(statisticSearchVo));
		List<Map<String, Object>> lists;
		if (isIdleYouth(statisticSearchVo.getType())) {
			List<PropertyDict> dicts = propertyDictService
					.findPropertyDictByDomainName(statisticSearchVo
							.getDomainName());
			List<Map<String, Object>> baseLists = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < dicts.size(); i++) {
				statisticSearchVo.setDisplayName(dicts.get(i).getDisplayName());
				statisticSearchVo.setPropertyDict(dicts.get(i));
				List<Map<String, Object>> helpList = new ArrayList<Map<String, Object>>();
				if (PropertyTypes.IDLEYOUTH_STAFF_TYPE.equals(statisticSearchVo
						.getDomainName())) {
					helpList = baseInfoStatisticsNewDao
							.countIdleYouthHelpedByType(statisticSearchVo);
				} else {
					helpList = baseInfoStatisticsNewDao
							.countIdleYouthHelpedByAge(statisticSearchVo);
				}
				baseLists.addAll(helpList);
			}
			Collections.sort(baseLists, new ComparatorList());
			return createBaseinfoStatisticVoByResultList(baseLists,
					statisticSearchVo);
		}
		// 刑释解教列表实时
		if (isPositiveinfos(statisticSearchVo)) {
			List<PropertyDict> dicts = propertyDictService
					.findPropertyDictByDomainName(statisticSearchVo
							.getDomainName());
			List<Map<String, Object>> baseLists = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < dicts.size(); i++) {
				statisticSearchVo.setDisplayName(dicts.get(i).getDisplayName());
				statisticSearchVo.setPropertyDict(dicts.get(i));
				List<Map<String, Object>> helpList = baseInfoStatisticsNewDao
						.countPositiveinfosByField(statisticSearchVo);
				baseLists.addAll(helpList);
			}
			Collections.sort(baseLists, new ComparatorList());
			return createPositiveinfosByResultList(baseLists, statisticSearchVo);
		}

		// 青少年
		if (isYouth(statisticSearchVo)) {
			List<Map<String, Object>> baseLists = new ArrayList<Map<String, Object>>();
			if (PropertyTypes.POLITICAL_BACKGROUND.equals(statisticSearchVo
					.getDomainName())) {
				baseLists = getYouthByType(statisticSearchVo);
			} else {
				List<PropertyDict> dicts = propertyDictService
						.findPropertyDictByDomainName(statisticSearchVo
								.getDomainName());
				for (int i = 0; i < dicts.size(); i++) {
					statisticSearchVo.setPropertyDict(dicts.get(i));
					statisticSearchVo.setDisplayName(dicts.get(i)
							.getDisplayName());
					List<Map<String, Object>> subList = new ArrayList<Map<String, Object>>();
					subList = baseInfoStatisticsNewDao
							.countYouthByAge(statisticSearchVo);
					baseLists.addAll(subList);
				}
			}
			Collections.sort(baseLists, new ComparatorList());
			return createBaseinfoStatisticVoByResultList(baseLists,
					statisticSearchVo);
		}

		if (isGroupByProperty(statisticSearchVo)) {
			List<PropertyDict> dicts = propertyDictService
					.findPropertyDictByDomainName(statisticSearchVo
							.getDomainName());
			List<Map<String, Object>> baseLists = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < dicts.size(); i++) {
				statisticSearchVo.setDisplayName(dicts.get(i).getDisplayName());
				statisticSearchVo.setPropertyDict(dicts.get(i));
				List<Map<String, Object>> helpList = baseInfoStatisticsNewDao
						.countHelpedByField(statisticSearchVo);
				baseLists.addAll(helpList);
			}
			Collections.sort(baseLists, new ComparatorList());
			return createBaseinfoStatisticVoByResultList(baseLists,
					statisticSearchVo);
		} else if (isGroupByCount(statisticSearchVo)) {
			statisticSearchVo.setOrgLevelDistance(orgLevelDistance);
			// 实有房屋
			lists = baseInfoStatisticsNewDao
					.getRealTimeStatisticNoType(statisticSearchVo);
			Collections.sort(lists, new ComparatorList());
			return createBaseinfoStatisticVoByResultListGroupByCountFiled(
					lists, statisticSearchVo);
		} else {// 没有类型的要用特殊的sql
			statisticSearchVo.setOrgLevelDistance(orgLevelDistance);
			lists = baseInfoStatisticsNewDao
					.countHelpedByFieldNoType(statisticSearchVo);
			Collections.sort(lists, new ComparatorList());
			return createBaseinfoStatisticVoByResultListNotype(lists,
					statisticSearchVo);
		}
	}

	private List<BaseinfoStatisticVo> createPositiveinfosByResultList(
			List<Map<String, Object>> list, StatisticSearchVo statisticSearchVo) {

		List<BaseinfoStatisticVo> statisticList = new ArrayList<BaseinfoStatisticVo>();
		if (list != null && list.size() > 0) {
			long temp = -1;
			long orgId = 0;

			long summaionSum = 0;// 分组织机构的总数的合计
			long summaionHelp = 0;// 分组织机构的帮教的合计
			long summaionResited = 0;// 分组织机构的安置情况的合计
			long summaionRecidivism = 0;// 分组织机构的犯罪的合计
			long summaionConuntValue = 0;// 分组织机构的统计的字段的合计
			long totalSum = 0;// 总数的合计
			long totalHelp = 0;// 已帮教的合计
			long totalResited = 0;// 犯罪的合计
			long totalRecidivism = 0;// 已安置的合计
			long totalCountValue = 0;// 统计的总数合计
			int size = list.size();

			BaseinfoStatisticDetailVo detailVo;
			for (int i = 0; i < size; i++) {
				detailVo = new BaseinfoStatisticDetailVo();

				// 从查询结果中取一条记录
				orgId = ((BigDecimal) list.get(i).get("ORGID")).longValue();
				String orgName = (String) list.get(i).get("ORGNAME");
				long sum = ((BigDecimal) list.get(i).get("SUMNUM")).longValue();// 本条记录的总数
				long ishelp = 0;
				long nohelp = 0;
				long resited = 0; // 犯罪情况
				long recidivism = 0; // 安置情况
				// 处理实时月份的情况
				ishelp = ((BigDecimal) list.get(i).get("ISHELP")).longValue();
				nohelp = ((BigDecimal) list.get(i).get("NOHELP")).longValue();
				resited = ((BigDecimal) list.get(i).get("RESITED")).longValue();
				recidivism = ((BigDecimal) list.get(i).get("RECIDIVISM"))
						.longValue();
				String typeName = (String) list.get(i).get("TYPENAME");
				// COUNTVALUE目前好像都为null
				if (statisticSearchVo.getCountFieldMap() != null
						&& !statisticSearchVo.getCountFieldMap().isEmpty()
						&& list.get(i).get("COUNTVALUE") != null) {
					long countValue = ((BigDecimal) list.get(i).get(
							"COUNTVALUE")).longValue();// 本条记录的某一个属性的数量
					totalCountValue = totalCountValue + countValue;
					detailVo.setCountValue(countValue);
				}
				totalSum = totalSum + sum;
				totalHelp = totalHelp + ishelp;
				totalResited = totalResited + resited;
				totalRecidivism = totalRecidivism + recidivism;
				detailVo.setOrgId(orgId);
				detailVo.setOrgName(orgName);
				detailVo.setSum(sum);
				detailVo.setTypeName(typeName);
				detailVo.setHelped(ishelp);
				detailVo.setNoHelp(nohelp);
				detailVo.setResited(resited);
				detailVo.setNoResite(sum - resited);
				detailVo.setNoRecidivism(sum - recidivism);
				detailVo.setRecidivism(recidivism);
				// 第一次循环，该if语句只在第一次时执行，且只执行一次
				if (temp == -1) {
					statisticList = createStatistic(detailVo, statisticList);
					temp = orgId;
					summaionSum = summaionSum + detailVo.getSum();
					summaionHelp = summaionHelp + detailVo.getHelped();
					summaionResited = summaionResited + detailVo.getResited();
					summaionRecidivism = summaionRecidivism
							+ detailVo.getRecidivism();
					summaionConuntValue = summaionConuntValue
							+ detailVo.getCountValue();

					// 执行的最后加上一个总的合计
					if (i == list.size() - 1) {
						statisticList = addPositiveDetailVoToStatistic(
								statisticList, summaionSum, summaionHelp,
								summaionResited, summaionRecidivism,
								summaionConuntValue);
						statisticList = addPositiveSummationToStatistic(
								statisticList, totalSum, totalHelp,
								totalResited, totalRecidivism, totalCountValue,
								statisticSearchVo);
					}

					continue;
				}

				// 该语句在取到的数据为一个新的组织机构开始时执行
				if (temp != orgId) {
					// 在每一个区域下面添加合计，除了最后一个
					statisticList = addPositiveDetailVoToStatistic(
							statisticList, summaionSum, summaionHelp,
							summaionResited, summaionRecidivism,
							summaionConuntValue);
					statisticList = createStatistic(detailVo, statisticList);
					summaionSum = 0;
					summaionConuntValue = 0;
					summaionHelp = 0;
					summaionResited = 0;
					summaionRecidivism = 0;
					summaionSum = summaionSum + detailVo.getSum();
					summaionHelp = summaionHelp + detailVo.getHelped();
					summaionResited = summaionResited + detailVo.getResited();
					summaionRecidivism = summaionRecidivism
							+ detailVo.getRecidivism();
					summaionConuntValue = summaionConuntValue
							+ detailVo.getCountValue();
					temp = orgId;

					// 执行的最后加上一个总的合计,最后面的合计
					if (i == list.size() - 1) {
						statisticList = addPositiveDetailVoToStatistic(
								statisticList, summaionSum, summaionHelp,
								summaionResited, summaionRecidivism,
								summaionConuntValue);
						statisticList = addPositiveSummationToStatistic(
								statisticList, totalSum, totalHelp,
								totalResited, totalRecidivism, totalCountValue,
								statisticSearchVo);
					}

					continue;
				}

				summaionSum = summaionSum + detailVo.getSum();
				summaionHelp = summaionHelp + detailVo.getHelped();
				summaionResited = summaionResited + detailVo.getResited();
				summaionRecidivism = summaionRecidivism
						+ detailVo.getRecidivism();
				summaionConuntValue = summaionConuntValue
						+ detailVo.getCountValue();

				statisticList = addDetailVoToStatistic(statisticList, detailVo);

				// 执行的最后加上一个总的合计
				if (i == list.size() - 1) {
					statisticList = addPositiveDetailVoToStatistic(
							statisticList, summaionSum, summaionHelp,
							summaionResited, summaionRecidivism,
							summaionConuntValue);
					statisticList = addPositiveSummationToStatistic(
							statisticList, totalSum, totalHelp, totalResited,
							totalRecidivism, totalCountValue, statisticSearchVo);
				}
			}
		}
		return statisticList;
	}

	private List<BaseinfoStatisticVo> addPositiveDetailVoToStatistic(
			List<BaseinfoStatisticVo> statisticList, long summaionSum,
			long summaionHelp, long summaionResited, long summaionRecidivism,
			long summaionConuntValue) {
		BaseinfoStatisticVo statisticVo = statisticList.get(statisticList
				.size() - 1);
		BaseinfoStatisticDetailVo summationDetail = new BaseinfoStatisticDetailVo();
		summationDetail.setTypeName("合计");
		summationDetail.setSum(summaionSum);
		summationDetail.setHelped(summaionHelp);
		summationDetail.setNoHelp(summaionSum - summaionHelp);
		summationDetail.setResited(summaionResited);
		summationDetail.setNoResite(summaionSum - summaionResited);
		summationDetail.setRecidivism(summaionRecidivism);
		summationDetail.setNoRecidivism(summaionSum - summaionRecidivism);
		summationDetail.setCountValue(summaionConuntValue);
		statisticVo.getBaseinfoStatisticDetailVo().add(summationDetail);

		return statisticList;
	}

	private List<BaseinfoStatisticVo> addPositiveSummationToStatistic(
			List<BaseinfoStatisticVo> statisticList, long totalSum,
			long totalHelp, long totalResited, long totalRecidivism,
			long totalCountValue, StatisticSearchVo statisticSearchVo) {
		BaseinfoStatisticVo summation = new BaseinfoStatisticVo();
		summation.setAmount(totalSum);
		summation.setOrgName("合计");

		List<BaseinfoStatisticDetailVo> summationDetailList = new ArrayList<BaseinfoStatisticDetailVo>();
		BaseinfoStatisticDetailVo summationDetail = new BaseinfoStatisticDetailVo();
		summationDetail.setTypeName("/");
		summationDetail.setSum(totalSum);
		summationDetail.setHelped(totalHelp);

		summationDetail.setNoHelp(totalSum - totalHelp);
		summationDetail.setResited(totalResited);
		summationDetail.setNoResite(totalSum - totalResited);
		summationDetail.setRecidivism(totalRecidivism);
		summationDetail.setNoRecidivism(totalSum - totalRecidivism);

		summationDetail.setCountValue(totalCountValue);
		summationDetailList.add(summationDetail);

		summation.setBaseinfoStatisticDetailVo(summationDetailList);

		statisticList.add(summation);
		// 在最后添加百分比
		addAmountPercentage(statisticList, totalSum);
		return statisticList;
	}

	/**
	 * 区域图数据
	 */
	private HighchartColumnVo getArealDistributionList(
			StatisticSearchVo statisticSearchVo) {
		statisticSearchVo.setOrgType(getOrgType(statisticSearchVo));
		if (isIdleYouth(statisticSearchVo.getType())) {

			List<Map<String, Object>> list = baseInfoStatisticsNewDao
					.getRealTimeIdleYouth(statisticSearchVo);
			return createHighchartColumnVoByCurrent(list, statisticSearchVo);
		}

		if (isYouth(statisticSearchVo)) {
			List<Map<String, Object>> list = baseInfoStatisticsNewDao
					.getRealTimeYouth(statisticSearchVo);
			return createHighchartColumnVoByList(list, statisticSearchVo,
					new HighchartColumnVo());
		}

		if (isActualHouse(statisticSearchVo)) {
			return getArealDistributionListForWorkBench(statisticSearchVo
					.getOrgId());
		}
		if (isGroupByProperty(statisticSearchVo)) {
			getPropertyDomainId(statisticSearchVo);
			List<Map<String, Object>> list = baseInfoStatisticsNewDao
					.getStatisticList(statisticSearchVo);
			return createHighchartColumnVoByCurrent(list, statisticSearchVo);

		} else {
			List<Map<String, Object>> list = baseInfoStatisticsNewDao
					.getRealTimeStatisticNoType(statisticSearchVo);
			return createHighchartColumnVoByListNoTypeCurrent(list,
					statisticSearchVo);
		}

	}

	// 实时记录添加帮教情况数据
	private HighchartColumnVo createHighchartColumnVoByCurrent(
			List<Map<String, Object>> list, StatisticSearchVo statisticSearchVo) {
		HighchartColumnVo chartColumn = new HighchartColumnVo();
		// 查询帮教情况，并组装数据
		statisticSearchVo.setOrgType(getOrgType(statisticSearchVo));
		List<Map<String, Object>> helpLists = baseInfoStatisticsNewDao
				.getIsHelpStatisticList(statisticSearchVo);
		chartColumn = createHighchartColumnVoByList(list, statisticSearchVo,
				chartColumn);
		return findHelpData(helpLists, statisticSearchVo, chartColumn);
	}

	// 实时记录添加帮教情况数据,没有分组的情况
	private HighchartColumnVo createHighchartColumnVoByListNoTypeCurrent(
			List<Map<String, Object>> list, StatisticSearchVo statisticSearchVo) {
		HighchartColumnVo chartColumn = new HighchartColumnVo();
		// 查询帮教情况，并组装数据
		statisticSearchVo.setOrgType(getOrgType(statisticSearchVo));
		List<Map<String, Object>> helpLists = baseInfoStatisticsNewDao
				.getIsHelpStatisticList(statisticSearchVo);
		chartColumn = createHighchartColumnVoByListNoTypeName(list,
				statisticSearchVo, chartColumn);
		return findHelpData(helpLists, statisticSearchVo, chartColumn);
	}

	/**
	 * 总况的区域分布图
	 * 
	 * @param list
	 * @param orgId
	 * @return
	 */
	private HighchartColumnVo getTotalArealDistributionList(
			List<PopulationCatalog> list, Long orgId) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		String type = null;
		List<String> tables = new ArrayList<String>();
		for (PopulationCatalog catalog : list) {
			type = catalog.getParentCatalog();
			tables.add(catalog.getStatisticListSetting().getTableName());
		}
		queryMap.put("orgId", orgId);
		queryMap.put("tables", tables);
		queryMap.put("orgType", getAdminsOrgType());
		List<Map<String, Object>> resultList = baseInfoStatisticsNewDao
				.getTotalArealDistributionList(queryMap);
		StatisticSearchVo vo = new StatisticSearchVo();
		PopulationCatalog catalog = PopulationCatalog.parse(type);
		vo.setTableDisplayName(catalog.getDisplayName());
		HighchartColumnVo chartColumn = new HighchartColumnVo();
		return createHighchartColumnVoByListNoTypeName(resultList, vo,
				chartColumn);
	}

	private HighchartColumnVo createHighchartColumnVoByListNoTypeName(
			List<Map<String, Object>> list,
			StatisticSearchVo statisticSearchVo, HighchartColumnVo chartColumn) {
		chartColumn.setModuleName(statisticSearchVo.getTableDisplayName());
		if (list == null || list.size() == 0) {
			return chartColumn;
		}

		List<HighchartDataColumnVo> series = new ArrayList<HighchartDataColumnVo>(); // 各类型对应的数据
		HighchartDataColumnVo column = new HighchartDataColumnVo();

		List<String> categoriesList = new ArrayList<String>();
		List<Integer> values = new ArrayList<Integer>();
		int len = list.size();

		for (int i = 0; i < len; i++) {
			String orgName = (String) list.get(i).get("ORGNAME");
			Integer sum = Integer.parseInt(((BigDecimal) list.get(i).get(
					"SUMNUM")).toString());
			categoriesList.add(orgName);
			values.add(sum);
		}
		String[] categories = new String[categoriesList.size()];
		categoriesList.toArray(categories);
		chartColumn.setCategories(categories);
		column.setName(statisticSearchVo.getTableDisplayName());
		column.setStack(statisticSearchVo.getTableDisplayName());
		Integer[] data = new Integer[values.size()];
		values.toArray(data);
		column.setData(getIntByInteger(data));
		series.add(column);
		chartColumn.setSeries(series);
		return chartColumn;
	}

	private int[] getIntByInteger(Integer[] integers) {

		int len = integers.length;
		int[] results = new int[len];
		for (int i = 0; i < len; i++) {
			if (null == integers[i]) {
				results[i] = 0;
			} else {
				results[i] = integers[i];
			}
		}
		return results;
	}

	// 历史记录添加帮教情况数据
	private HighchartColumnVo createResultByHistory(
			List<Map<String, Object>> list, StatisticSearchVo statisticSearchVo) {
		statisticSearchVo.setOrgType(getOrgType(statisticSearchVo));
		statisticSearchVo
				.setPropertyDomainId(getPropertyDomainId(statisticSearchVo));
		// 查询帮教情况，并组装数据
		List<Map<String, Object>> helpLists = baseInfoStatisticsNewDao
				.getIsHelpFromHistory(statisticSearchVo);
		HighchartColumnVo chartColumn = new HighchartColumnVo();
		chartColumn = createHighchartColumnVoByList(list, statisticSearchVo,
				chartColumn);
		return findHelpData(helpLists, statisticSearchVo, chartColumn);
	}

	private HighchartColumnVo findHelpData(List<Map<String, Object>> list,
			StatisticSearchVo statisticSearchVo, HighchartColumnVo chartColumn) {
		if (list == null || list.size() == 0) {
			return new HighchartColumnVo();
		}
		String[] propertyDictList = AnalyseUtilNew.groupMap
				.get(statisticSearchVo.getTableDisplayName());
		int DictSize = 0;
		if (propertyDictList != null) {
			DictSize = propertyDictList.length - 2;// 属性的条目
		}

		int size = list.size();// 地区条目

		List<List<Integer>> datas = new ArrayList<List<Integer>>();// 存放各类型对应的数量
		HighchartDataColumnVo column;

		List<Organization> categoriesList = new ArrayList<Organization>();
		// 获取组织机构
		categoriesList = organizationDubboService
				.findAdminOrgsByParentId(statisticSearchVo.getOrgId());
		List<Integer> isHelpLists = new ArrayList<Integer>();
		List<Integer> noHelpLists = new ArrayList<Integer>();
		for (int i = 0; i < categoriesList.size(); i++) {
			// 从查询结果中取一条记录
			isHelpLists.add(Integer.parseInt(((BigDecimal) list.get(i).get(
					"ISHELP")).toString()));
			noHelpLists.add(Integer.parseInt(((BigDecimal) list.get(i).get(
					"NOHELP")).toString()));
		}
		datas.add(isHelpLists);
		datas.add(noHelpLists);
		Integer[] data = new Integer[size];
		for (int i = 0; i < DictSize; i++) {

			column = new HighchartDataColumnVo();
			column.setName(propertyDictList[i]);
			column.setStack(propertyDictList[DictSize]);
			datas.get(i).toArray(data);
			column.setData(getIntByInteger(data));
			chartColumn.getSeries().add(column);
		}
		return chartColumn;
	}

	private HighchartColumnVo createHighchartColumnVoByList(
			List<Map<String, Object>> list,
			StatisticSearchVo statisticSearchVo, HighchartColumnVo chartColumn) {
		chartColumn.setModuleName(statisticSearchVo.getTableDisplayName());
		if (list == null || list.size() == 0) {
			return new HighchartColumnVo();
		}

		List<PropertyDict> propertyDictList = propertyDictService
				.findPropertyDictByDomainName(statisticSearchVo.getDomainName());
		int DictSize = propertyDictList.size();// 属性的条目
		int size = list.size() / DictSize;// 地区条目

		List<List<Integer>> datas = new ArrayList<List<Integer>>();// 存放各类型对应的数量
		for (int i = 0; i < DictSize; i++) {
			datas.add(new ArrayList<Integer>());
		}
		List<HighchartDataColumnVo> series = new ArrayList<HighchartDataColumnVo>(); // 各类型对应的数据
		HighchartDataColumnVo column;

		List<String> categoriesList = new ArrayList<String>();
		int len = list.size();

		for (int i = 0; i < len; i++) {
			// 从查询结果中取一条记录
			String orgName = (String) list.get(i).get("ORGNAME");
			Integer sum = Integer.parseInt(((BigDecimal) list.get(i).get(
					"SUMNUM")).toString());

			if (i % DictSize == 0) {
				categoriesList.add(orgName);
				datas.get(i % DictSize).add(sum);

			} else {
				datas.get(i % DictSize).add(sum);
			}
		}

		String[] categories = new String[categoriesList.size()];
		categoriesList.toArray(categories);
		chartColumn.setCategories(categories);
		Integer[] data = new Integer[size];
		for (int i = 0; i < DictSize; i++) {

			column = new HighchartDataColumnVo();

			column.setStack(statisticSearchVo.getDomainName());
			datas.get(i).toArray(data);
			column.setData(getIntByInteger(data));
			if (null != chartColumn.getSeries()) {
				String[] propertyDictLists = AnalyseUtilNew.groupMap
						.get(statisticSearchVo.getTableDisplayName());
				column.setName(propertyDictLists[i]);
				column.setStack(propertyDictLists[propertyDictLists.length - 1]);
				chartColumn.getSeries().add(column);
			} else {
				column.setName(propertyDictList.get(i).getDisplayName());
				series.add(column);
			}

		}
		if (null == chartColumn.getSeries()) {
			chartColumn.setSeries(series);
		}
		return chartColumn;
	}

	/**
	 * 历史记录的列表
	 */
	private List<BaseinfoStatisticVo> getHistoryStatistic(
			StatisticSearchVo statisticSearchVo) {
		List<Map<String, Object>> list;
		statisticSearchVo.setOrgType(getOrgType(statisticSearchVo));
		statisticSearchVo
				.setPropertyDomainId(getPropertyDomainId(statisticSearchVo));
		// 刑释解教列表历史
		if (isPositiveinfos(statisticSearchVo)) {
			list = baseInfoStatisticsNewDao
					.getStatisticListFromHistory(statisticSearchVo);
			return createPositiveinfosByResultList(list, statisticSearchVo);
		}

		if (isGroupByProperty(statisticSearchVo)) {// 社区 精神病 吸毒 危险品 艾滋 残疾 需救助
													// 出租房 新经济 型社会
			list = baseInfoStatisticsNewDao
					.getStatisticListFromHistory(statisticSearchVo);
			return createBaseinfoStatisticVoByResultList(list,
					statisticSearchVo);
		} else if (isIdleYouth(statisticSearchVo.getType()) // 重点青少年 房屋
				|| isActualHouse(statisticSearchVo)) {
			list = baseInfoStatisticsNewDao
					.getStatisticListFromHistory(statisticSearchVo);
			return createBaseinfoStatisticVoByResultList(list,
					statisticSearchVo);
		} else if (isYouth(statisticSearchVo)) { // 青少年
			list = baseInfoStatisticsNewDao
					.getStatisticListFromHistory(statisticSearchVo);
			List removeList = new ArrayList();
			if (PropertyTypes.POLITICAL_BACKGROUND.equals(statisticSearchVo
					.getDomainName()))
				for (Map map : list) {
					if (!PropertyTypes.YOUNG_MEMBERS
							.equals(map.get("TYPENAME"))
							&& !PropertyTypes.YOUNG_PIONEERS.equals(map
									.get("TYPENAME"))
							&& !PropertyTypes.OTHER_YOUNGS.equals(map
									.get("TYPENAME"))) {
						removeList.add(map);
					}
				}
			list.removeAll(removeList);
			return createBaseinfoStatisticVoByResultList(list,
					statisticSearchVo);
		} else {// 重点上访 其他 老年 优抚 失业 育龄
			list = baseInfoStatisticsNewDao
					.getStatisticListFromHistoryNoType(statisticSearchVo);
			return createBaseinfoStatisticVoByResultListNotype(list,
					statisticSearchVo);
		}
	}

	private List<BaseinfoStatisticVo> createBaseinfoStatisticVoByResultList(
			List<Map<String, Object>> list, StatisticSearchVo statisticSearchVo) {
		List<BaseinfoStatisticVo> statisticList = new ArrayList<BaseinfoStatisticVo>();
		if (list != null && list.size() > 0) {
			long temp = -1;
			long orgId = 0;

			long summaionSum = 0;// 分组织机构的总数的合计
			long summaionHelp = 0;// 分组织机构的帮教的合计
			long summaionConuntValue = 0;// 分组织机构的统计的字段的合计
			long totalSum = 0;// 总数的合计
			long totalHelp = 0;// 已帮教的合计
			long totalCountValue = 0;// 统计的总数合计
			int size = list.size();

			BaseinfoStatisticDetailVo detailVo;
			for (int i = 0; i < size; i++) {
				detailVo = new BaseinfoStatisticDetailVo();

				// 从查询结果中取一条记录
				orgId = ((BigDecimal) list.get(i).get("ORGID")).longValue();
				String orgName = (String) list.get(i).get("ORGNAME");
				long sum = ((BigDecimal) list.get(i).get("SUMNUM")).longValue();// 本条记录的总数
				long monthCreate = ((BigDecimal) list.get(i).get("MONTHCREATE"))
						.longValue();
				long ishelp = 0;
				long nohelp = 0;
				// 处理实时月份的情况
				if (null != list.get(i).get("ISHELP")
						&& null != list.get(i).get("NOHELP")) {
					ishelp = ((BigDecimal) list.get(i).get("ISHELP"))
							.longValue();
					nohelp = ((BigDecimal) list.get(i).get("NOHELP"))
							.longValue();
				}
				String typeName = (String) list.get(i).get("TYPENAME");
				// COUNTVALUE目前好像都为null
				if (statisticSearchVo.getCountFieldMap() != null
						&& !statisticSearchVo.getCountFieldMap().isEmpty()
						&& list.get(i).get("COUNTVALUE") != null) {
					long countValue = ((BigDecimal) list.get(i).get(
							"COUNTVALUE")).longValue();// 本条记录的某一个属性的数量
					totalCountValue = totalCountValue + countValue;
					detailVo.setCountValue(countValue);
				}
				totalSum = totalSum + sum;
				totalHelp = totalHelp + ishelp;
				detailVo.setOrgId(orgId);
				detailVo.setOrgName(orgName);
				detailVo.setSum(sum);
				detailVo.setTypeName(typeName);
				detailVo.setHelped(ishelp);
				detailVo.setNoHelp(nohelp);
				detailVo.setMonthCreate(monthCreate);
				// 第一次循环，该if语句只在第一次时执行，且只执行一次
				if (temp == -1) {
					statisticList = createStatistic(detailVo, statisticList);
					temp = orgId;
					summaionSum = summaionSum + detailVo.getSum();
					summaionHelp = summaionHelp + detailVo.getHelped();
					summaionConuntValue = summaionConuntValue
							+ detailVo.getCountValue();

					// 执行的最后加上一个总的合计
					if (i == list.size() - 1) {
						statisticList = addDetailVoToStatistic(statisticList,
								summaionSum, summaionHelp, summaionConuntValue);
						statisticList = addSummationToStatistic(statisticList,
								totalSum, totalHelp, totalCountValue,
								statisticSearchVo);
					}

					continue;
				}

				// 该语句在取到的数据为一个新的组织机构开始时执行
				if (temp != orgId) {
					// 在每一个区域下面添加合计，除了最后一个
					statisticList = addDetailVoToStatistic(statisticList,
							summaionSum, summaionHelp, summaionConuntValue);
					statisticList = createStatistic(detailVo, statisticList);
					summaionSum = 0;
					summaionConuntValue = 0;
					summaionHelp = 0;
					summaionSum = summaionSum + detailVo.getSum();
					summaionHelp = summaionHelp + detailVo.getHelped();
					summaionConuntValue = summaionConuntValue
							+ detailVo.getCountValue();
					temp = orgId;

					// 执行的最后加上一个总的合计,最后面的合计
					if (i == list.size() - 1) {
						statisticList = addDetailVoToStatistic(statisticList,
								summaionSum, summaionHelp, summaionConuntValue);
						statisticList = addSummationToStatistic(statisticList,
								totalSum, totalHelp, totalCountValue,
								statisticSearchVo);
					}

					continue;
				}

				summaionSum = summaionSum + detailVo.getSum();
				summaionHelp = summaionHelp + detailVo.getHelped();
				summaionConuntValue = summaionConuntValue
						+ detailVo.getCountValue();

				statisticList = addDetailVoToStatistic(statisticList, detailVo);

				// 执行的最后加上一个总的合计
				if (i == list.size() - 1) {
					statisticList = addDetailVoToStatistic(statisticList,
							summaionSum, summaionHelp, summaionConuntValue);
					statisticList = addSummationToStatistic(statisticList,
							totalSum, totalHelp, totalCountValue,
							statisticSearchVo);
				}
			}
		}
		return statisticList;
	}

	private List<BaseinfoStatisticVo> createBaseinfoStatisticVoByResultListNotype(
			List<Map<String, Object>> list, StatisticSearchVo statisticSearchVo) {
		List<BaseinfoStatisticVo> statisticList = new ArrayList<BaseinfoStatisticVo>();
		if (list != null && list.size() > 0) {
			int size = list.size();
			long totalSum = 0;// 总数的合计
			long totalHelp = 0; // 帮教的合计
			BaseinfoStatisticDetailVo detailVo;
			for (int i = 0; i < size; i++) {
				detailVo = new BaseinfoStatisticDetailVo();

				// 从查询结果中取一条记录
				long orgId = ((BigDecimal) list.get(i).get("ORGID"))
						.longValue();
				String orgName = (String) list.get(i).get("ORGNAME");
				long sum = ((BigDecimal) list.get(i).get("SUMNUM")).longValue();
				String typeName = list.get(i).get("TYPENAME") == null ? statisticSearchVo
						.getTableDisplayName() : (String) list.get(i).get(
						"TYPENAME");
				long monthCreate = ((BigDecimal) list.get(i).get("MONTHCREATE"))
						.longValue();
				long ishelp = 0;
				long nohelp = 0;
				// 处理实时月份的情况
				if (null != list.get(i).get("ISHELP")
						&& null != list.get(i).get("NOHELP")) {
					ishelp = ((BigDecimal) list.get(i).get("ISHELP"))
							.longValue();
					nohelp = ((BigDecimal) list.get(i).get("NOHELP"))
							.longValue();
				}
				totalSum = totalSum + sum;
				totalHelp = totalHelp + ishelp;
				detailVo.setOrgId(orgId);
				detailVo.setOrgName(orgName);
				detailVo.setSum(sum);
				detailVo.setHelped(ishelp);
				detailVo.setNoHelp(nohelp);
				detailVo.setTypeName(typeName);
				detailVo.setMonthCreate(monthCreate);
				statisticList = createStatistic(detailVo, statisticList);

				// 执行的最后加上一个总的合计
				if (i == list.size() - 1) {

					statisticList = addSummationToStatistic(statisticList,
							totalSum, totalHelp, 0, statisticSearchVo);
				}

			}
		}
		return statisticList;
	}

	/**
	 * 判断是否是重点青少年
	 * 
	 * @param statisticSearchVo
	 * @return
	 */
	private boolean isIdleYouth(String type) {
		return PopulationType.IDLE_YOUTH.equals(type);
	}

	/**
	 * 判断是否是刑释解教
	 * 
	 * @param statisticSearchVo
	 * @return
	 */
	private boolean isPositiveinfos(StatisticSearchVo statisticSearchVo) {
		String type = statisticSearchVo.getType();
		return PopulationType.POSITIVE_INFO.equals(type);
	}

	/**
	 * 判断是否有分组字段
	 * 
	 * @param statisticSearchVo
	 * @return
	 */
	private boolean isGroupByProperty(StatisticSearchVo statisticSearchVo) {
		String propertyField = statisticSearchVo.getPropertyField();
		return propertyField != null && !propertyField.trim().equals("")
				&& !propertyField.isEmpty();
	}

	/**
	 * 判断是否没有分组字段，但是有统计字段
	 * 
	 * @param statisticSearchVo
	 * @return
	 */
	private boolean isGroupByCount(StatisticSearchVo statisticSearchVo) {
		String propertyField = statisticSearchVo.getPropertyField();
		Map<String, Object> map = statisticSearchVo.getCountFieldMap();
		return propertyField == null && map != null && !map.isEmpty();

	}

	private boolean isActualHouse(StatisticSearchVo statisticSearchVo) {
		String type = statisticSearchVo.getType().toLowerCase();
		return type.indexOf("actualHouse".toLowerCase()) >= 0;
	}

	/**
	 * 根据统计的小类，把结果分组
	 * 
	 * @param list
	 * @param statisticSearchVo
	 * @return
	 */
	private List<BaseinfoStatisticVo> createBaseinfoStatisticVoByResultListGroupByCountFiled(
			List<Map<String, Object>> list, StatisticSearchVo statisticSearchVo) {
		List<BaseinfoStatisticVo> statisticList = new ArrayList<BaseinfoStatisticVo>();
		if (list != null && list.size() > 0) {
			int size = list.size();
			long totalSum = 0;// 总数的合计
			long totalHelp = 0; // 帮教的合计
			BaseinfoStatisticDetailVo detailVo;
			for (int i = 0; i < size; i++) {
				detailVo = new BaseinfoStatisticDetailVo();

				// 从查询结果中取一条记录
				long orgId = ((BigDecimal) list.get(i).get("ORGID"))
						.longValue();
				String orgName = (String) list.get(i).get("ORGNAME");
				long sum = ((BigDecimal) list.get(i).get("SUMNUM")).longValue();
				long ishelp = 0;
				long nohelp = 0;
				// 处理实时月份的情况
				if (null != list.get(i).get("ISHELP")
						&& null != list.get(i).get("NOHELP")) {
					ishelp = ((BigDecimal) list.get(i).get("ISHELP"))
							.longValue();
					nohelp = ((BigDecimal) list.get(i).get("NOHELP"))
							.longValue();
				}

				String typeName = list.get(i).get("TYPENAME") == null ? statisticSearchVo
						.getTableDisplayName() : (String) list.get(i).get(
						"TYPENAME");

				if (statisticSearchVo.getCountFieldMap() != null
						&& !statisticSearchVo.getCountFieldMap().isEmpty()) {
					long countValue = ((BigDecimal) list.get(i).get(
							"COUNTVALUE")).longValue();// 本条记录的某一个属性的数量

					detailVo.setCountValue(countValue);
				}

				totalSum = totalSum + sum;
				totalHelp = totalHelp + ishelp;
				detailVo.setOrgId(orgId);
				detailVo.setOrgName(orgName);
				detailVo.setSum(sum);
				detailVo.setHelped(ishelp);
				detailVo.setNoHelp(nohelp);
				detailVo.setTypeName(typeName);
				statisticList = createStatisticGroupByCount(detailVo,
						statisticList);

				// 执行的最后加上一个总的合计
				if (i == list.size() - 1) {

					statisticList = addSummationToStatistic(statisticList,
							totalSum, totalHelp, totalSum, statisticSearchVo);
				}

			}
		}
		return statisticList;
	}

	private List<BaseinfoStatisticVo> createStatisticGroupByCount(
			BaseinfoStatisticDetailVo detailVo,
			List<BaseinfoStatisticVo> statisticList) {
		long sum = detailVo.getSum();
		BaseinfoStatisticVo statisticVo = new BaseinfoStatisticVo();
		statisticVo.setOrgId(detailVo.getOrgId());
		statisticVo.setAmount(detailVo.getSum());
		statisticVo.setOrgName(detailVo.getOrgName());
		List<BaseinfoStatisticDetailVo> list = new ArrayList<BaseinfoStatisticDetailVo>();
		detailVo.setSum(detailVo.getCountValue());
		detailVo.setTypeName("出租房");
		list.add(detailVo);

		BaseinfoStatisticDetailVo actualHouse = new BaseinfoStatisticDetailVo();
		actualHouse.setSum(sum - detailVo.getCountValue());
		actualHouse.setTypeName("非出租房");
		list.add(actualHouse);

		BaseinfoStatisticDetailVo totalHouse = new BaseinfoStatisticDetailVo();
		totalHouse.setTypeName("合计");
		totalHouse.setSum(sum);
		list.add(totalHouse);

		statisticVo.setBaseinfoStatisticDetailVo(list);
		statisticList.add(statisticVo);
		return statisticList;
	}

	private List<BaseinfoStatisticVo> addSummationToStatistic(
			List<BaseinfoStatisticVo> statisticList, long totalSum,
			long totalHelp, long totalCountValue,
			StatisticSearchVo statisticSearchVo) {
		BaseinfoStatisticVo summation = new BaseinfoStatisticVo();
		summation.setAmount(totalSum);
		summation.setOrgName("合计");

		List<BaseinfoStatisticDetailVo> summationDetailList = new ArrayList<BaseinfoStatisticDetailVo>();
		BaseinfoStatisticDetailVo summationDetail = new BaseinfoStatisticDetailVo();
		summationDetail.setTypeName("/");
		summationDetail.setSum(totalSum);
		summationDetail.setHelped(totalHelp);
		summationDetail.setNoHelp(totalSum - totalHelp);
		summationDetail.setCountValue(totalCountValue);
		summationDetailList.add(summationDetail);

		summation.setBaseinfoStatisticDetailVo(summationDetailList);

		statisticList.add(summation);
		// 在最后添加百分比
		addAmountPercentage(statisticList, totalSum);
		return statisticList;
	}

	// 添加百分比
	private void addAmountPercentage(List<BaseinfoStatisticVo> statisticList,
			long total) {

		for (int i = 0; i < statisticList.size(); i++) {
			for (int j = 0; j < statisticList.get(i)
					.getBaseinfoStatisticDetailVo().size(); j++) {
				BaseinfoStatisticDetailVo DetailVo = statisticList.get(i)
						.getBaseinfoStatisticDetailVo().get(j);

				statisticList
						.get(i)
						.getBaseinfoStatisticDetailVo()
						.get(j)
						.setAmountPercentage(
								Double.parseDouble(new java.text.DecimalFormat(
										"#.0000").format(DetailVo.getSum()
										/ (double) (total == 0 ? 1 : total))));
			}
		}
	}

	private List<BaseinfoStatisticVo> createStatistic(
			BaseinfoStatisticDetailVo detailVo,
			List<BaseinfoStatisticVo> statisticList) {
		BaseinfoStatisticVo statisticVo = new BaseinfoStatisticVo();
		statisticVo.setOrgId(detailVo.getOrgId());
		statisticVo.setAmount(detailVo.getSum());
		statisticVo.setOrgName(detailVo.getOrgName());
		List<BaseinfoStatisticDetailVo> list = new ArrayList<BaseinfoStatisticDetailVo>();
		list.add(detailVo);

		statisticVo.setBaseinfoStatisticDetailVo(list);
		statisticList.add(statisticVo);
		return statisticList;
	}

	private List<BaseinfoStatisticVo> addDetailVoToStatistic(
			List<BaseinfoStatisticVo> statisticList,
			BaseinfoStatisticDetailVo detailVo) {
		BaseinfoStatisticVo statisticVo = statisticList.get(statisticList
				.size() - 1);
		statisticVo.setAmount(statisticVo.getAmount() + detailVo.getSum());
		statisticVo.getBaseinfoStatisticDetailVo().add(detailVo);
		return statisticList;
	}

	private List<BaseinfoStatisticVo> addDetailVoToStatistic(
			List<BaseinfoStatisticVo> statisticList, long summaionSum,
			long summaionHelp, long summaionConuntValue) {
		BaseinfoStatisticVo statisticVo = statisticList.get(statisticList
				.size() - 1);
		BaseinfoStatisticDetailVo summationDetail = new BaseinfoStatisticDetailVo();
		summationDetail.setTypeName("合计");
		summationDetail.setSum(summaionSum);
		summationDetail.setHelped(summaionHelp);
		summationDetail.setNoHelp(summaionSum - summaionHelp);
		summationDetail.setCountValue(summaionConuntValue);
		statisticVo.getBaseinfoStatisticDetailVo().add(summationDetail);

		return statisticList;
	}

	private List<PopulationCatalog> getPopulationCatalogListByType(String type) {
		if (type.equals(PopulationCatalog.ALL_BIRTH_POPULATION)) {
			return PopulationCatalog.getAllBirthPopulationCatalog();
		} else if (type.equals(PopulationCatalog.ALL_UNEMPLOYED_POPULATION)) {
			return PopulationCatalog.getAllUnemployPopulationCatalog();
		} else if (type.equals(PopulationCatalog.ALL_CIVIL_POPULATION)) {
			return PopulationCatalog.getAllCivilPopulationCatalog();
		} else if (type.equals(PopulationCatalog.ALL_ATTENTION_POPULATION)) {
			List<PopulationCatalog> populationCatalogs = PopulationCatalog
					.getAllAttentionPopulationCatalog();
			if (populationCatalogs == null) {
				return populationCatalogs;
			}
			for (int i = 0; i < populationCatalogs.size(); i++) {
				if (PopulationType.AIDSPOPULATIONS.equals(populationCatalogs
						.get(i).getCatalog())) {
					populationCatalogs.remove(i--);
				}
				if (PopulationType.F_PERSONNEL.equals(populationCatalogs.get(i)
						.getCatalog())) {
					populationCatalogs.remove(i--);
				}
				if (PopulationType.Q_PERSONNEL.equals(populationCatalogs.get(i)
						.getCatalog())) {
					populationCatalogs.remove(i--);
				}
				if (PopulationType.M_PERSONNEL.equals(populationCatalogs.get(i)
						.getCatalog())) {
					populationCatalogs.remove(i--);
				}
				if (PopulationType.GOOD_SAMARITAN.equals(populationCatalogs
						.get(i).getCatalog())) {
					populationCatalogs.remove(i--);
				}
			}
			return populationCatalogs;
		} else if (type.equals(PopulationCatalog.ALL_YOUTH_POPULATION)) {
			return PopulationCatalog.getAllYouthPopulationCatalog();
		} else {
			return null;
		}
	}

	private List<StatisticSearchVo> getStatisticSearchVoList(
			List<PopulationCatalog> list, long orgId) {
		if (list == null || list.size() < 0) {
			return new ArrayList<StatisticSearchVo>();
		}
		List<StatisticSearchVo> resultList = new ArrayList<StatisticSearchVo>();
		String type;
		for (PopulationCatalog catalog : list) {
			type = catalog.getCatalog();
			resultList.add(createStatisticSearchVo(type, orgId, ""));
		}
		return resultList;
	}

	private List<StatisticSearchVo> getStatisticSearchVoList(
			List<PopulationCatalog> list, long orgId, int year, int month,
			String orginternalcode) {
		if (list == null || list.size() < 0) {
			return new ArrayList<StatisticSearchVo>();
		}
		List<StatisticSearchVo> resultList = new ArrayList<StatisticSearchVo>();
		String type;
		for (PopulationCatalog catalog : list) {
			type = catalog.getCatalog();
			resultList.add(createStatisticSearchVo(type, orgId, year, month,
					orginternalcode));
		}
		return resultList;
	}

	private StatisticSearchVo createStatisticSearchVo(String type, long orgId,
			String domainName) {
		PopulationCatalog populationCatalog = PopulationCatalog.parse(type);
		StatisticSearchVo statisticSearchVo = new StatisticSearchVo();
		statisticSearchVo.setType(type);
		statisticSearchVo.setTableDisplayName(PopulationType
				.getCnameByPopulationType(type));
		if (null != populationCatalog.getStatisticListSetting()) {
			if ("".equals(domainName) || null == domainName) {
				statisticSearchVo.setDomainName(populationCatalog
						.getStatisticListSetting().getDomainName());
			} else {
				statisticSearchVo.setDomainName(domainName);
			}
			statisticSearchVo.setTable(populationCatalog
					.getStatisticListSetting().getTableName());
			statisticSearchVo.setPropertyField(populationCatalog
					.getStatisticListSetting().getPropertyField());
			statisticSearchVo.setCountFieldMap(populationCatalog
					.getStatisticListSetting().getCountMap());
		}
		if (type.equalsIgnoreCase(PopulationType.ACTUAL_HOUSE)) {
			statisticSearchVo.setIsemphasis(null);
		}
		statisticSearchVo.setOrgId(orgId);
		Organization org = organizationDubboService.getSimpleOrgById(orgId);
		if (org != null) {
			statisticSearchVo.setOrginternalcode(org.getOrgInternalCode());
		}
		return statisticSearchVo;
	}

	private StatisticSearchVo createStatisticSearchVo(String type, long orgId,
			int year, int month, String orginternalcode) {
		StatisticSearchVo statisticSearchVo = createStatisticSearchVo(type,
				orgId, "");
		statisticSearchVo.setYear(year);
		statisticSearchVo.setMonth(month);
		statisticSearchVo.setOrginternalcode(orginternalcode);
		return statisticSearchVo;
	}

	/**
	 * 判断时间是否超出了时间范围
	 * 
	 * @param year
	 * @param month
	 */
	private void checkDate(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		if (c.after(Calendar.getInstance())) {
			throw new BusinessValidationException("所查月份有误，请重新选择要生成报表的月份！");
		}

	}

	/**
	 * 删除原有记录
	 * 
	 * @param year
	 * @param month
	 * @param type
	 * @param orgInternalCode
	 */
	private void deleteOldDatasFromTable(int year, int month, String type,
			String orgInternalCode) {
		baseInfoStatisticsNewDao.deleteHistoryStatistic(orgInternalCode, year,
				month, type);
	}

	/**
	 * 判断数据库表是否存在
	 * 
	 * @param year
	 * @param month
	 */
	private boolean checkHistoryStatisticTable(int year, int month) {
		boolean isCreate = tableService.createAnalyseTable(
				AnalyseUtilNew.IMPORTPERSONTABLENAME,
				AnalyseUtilNew.IMPORTPERSONSQL, year, month);
		tableService.createAnalyseIndex("statistichistory", "baseinfoType",
				"orgInternalCode");
		return isCreate;
	}

	/**
	 * 类型分布图
	 */
	@Override
	public List<Object[]> getStatisticInfo(int year, int month, String type,
			Organization org, String domainName) {
		checkDate(year, month);

		if (year == Calendar.getInstance().get(Calendar.YEAR)
				&& month == (Calendar.getInstance().get(Calendar.MONTH) + 1)) {
			StatisticSearchVo statisticSearchVo = null;
			if (!PopulationCatalog.ALL_YOUTH_POPULATION.equals(type)) {
				List<PopulationCatalog> list = getPopulationCatalogListByType(type);
				if (list != null && list.size() > 0) {
					return getTotalTablePieStatisticList(list,
							org.getOrgInternalCode());
				}
				statisticSearchVo = createStatisticSearchVo(type, 0, domainName);
			} else {
				statisticSearchVo = createYouthStatisticSearchVo(type, 0,
						domainName);
			}
			statisticSearchVo.setOrginternalcode(org.getOrgInternalCode());
			statisticSearchVo
					.setPropertyDomainId(getPropertyDomainId(statisticSearchVo));
			return getRealTimeCountByTypeName(statisticSearchVo);
		}
		if (!PopulationCatalog.ALL_YOUTH_POPULATION.equals(type)) {
			// 总况的类型分布图
			List<PopulationCatalog> list = getPopulationCatalogListByType(type);
			// 判断是否要创建表
			tableService.createAnalyseTable(
					AnalyseUtilNew.IMPORTPERSONTABLENAME,
					AnalyseUtilNew.IMPORTPERSONSQL, year, month);
			if (list != null && list.size() > 0) {
				return getTotalTablePieStatisticListFromHistory(list,
						org.getId(), year, month);
			}
		}

		if (year == Calendar.getInstance().get(Calendar.YEAR)
				&& month == (Calendar.getInstance().get(Calendar.MONTH) + 1)) {
			List<PopulationCatalog> list = getPopulationCatalogListByType(type);
			if (list != null && list.size() > 0) {
				return getTotalTablePieStatisticList(list,
						org.getOrgInternalCode());
			}
			StatisticSearchVo statisticSearchVo = createStatisticSearchVo(type,
					0, domainName);
			statisticSearchVo.setOrginternalcode(org.getOrgInternalCode());
			statisticSearchVo
					.setPropertyDomainId(getPropertyDomainId(statisticSearchVo));
			return getRealTimeCountByTypeName(statisticSearchVo);
		}
		if (!PopulationCatalog.ALL_YOUTH_POPULATION.equals(type)) {
			// 总况的类型分布图
			List<PopulationCatalog> list = getPopulationCatalogListByType(type);
			// 判断是否要创建表
			tableService.createAnalyseTable(
					AnalyseUtilNew.IMPORTPERSONTABLENAME,
					AnalyseUtilNew.IMPORTPERSONSQL, year, month);
			if (list != null && list.size() > 0) {
				return getTotalTablePieStatisticListFromHistory(list,
						org.getId(), year, month);
			}
		}
		// 单个表类型分布图
		StatisticSearchVo statisticSearchVo = createStatisticSearchVo(type,
				org.getId(), domainName);
		statisticSearchVo.setYear(year);
		statisticSearchVo.setMonth(month);
		statisticSearchVo.setOrginternalcode(org.getOrgInternalCode());
		statisticSearchVo.setType(type);

		return getStatisticInfoFromHistory(statisticSearchVo);

	}

	/**
	 * 类型分布图
	 * 
	 * @param statisticSearchVo
	 * @return
	 */

	private List<Object[]> getRealTimeCountByTypeName(
			StatisticSearchVo statisticSearchVo) {
		statisticSearchVo
				.setPropertyDomainId(getPropertyDomainId(statisticSearchVo));
		List<Map<String, Object>> mapList;
		if (isIdleYouth(statisticSearchVo.getType())) {
			if (PropertyTypes.IDLEYOUTH_STAFF_TYPE.equals(statisticSearchVo
					.getDomainName())) {
				mapList = new ArrayList<Map<String, Object>>();
				List<PropertyDict> dicts = propertyDictService
						.findPropertyDictByDomainName(statisticSearchVo
								.getDomainName());
				for (int i = 0; i < dicts.size(); i++) {
					statisticSearchVo.setPropertyDict(dicts.get(i));
					mapList.addAll(baseInfoStatisticsNewDao
							.getIdleYouthRealTimeCountGroupByType(statisticSearchVo));
				}
			} else {
				mapList = baseInfoStatisticsNewDao
						.getIdleYouthRealTimeCountGroupByAge(statisticSearchVo);
			}
		} else if (isGroupByCount(statisticSearchVo)) {
			mapList = baseInfoStatisticsNewDao
					.getRealTimeCountByCountField(statisticSearchVo);
			if (mapList != null && !mapList.isEmpty()) {
				List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
				Map<String, Object> newMap;
				BigDecimal sum;
				BigDecimal countValue;
				for (Map<String, Object> map : mapList) {
					sum = (BigDecimal) (map.get("NUM") == null ? new BigDecimal(
							0) : map.get("NUM"));
					countValue = (BigDecimal) (map.get("COUNTVALUE") == null ? new BigDecimal(
							0) : map.get("COUNTVALUE"));
					newMap = new HashMap<String, Object>();
					newMap.put("DISPLAYNAME", "非出租房");
					newMap.put("COUNTNUM", countValue);
					resultList.add(newMap);

					newMap = new HashMap<String, Object>();
					newMap.put("DISPLAYNAME", "出租房");
					newMap.put("COUNTNUM", sum.subtract(countValue));
					resultList.add(newMap);
				}
				double total = Double
						.parseDouble(String.valueOf(baseInfoStatisticsNewDao
								.getTotalFromTableByOrgCode(
										statisticSearchVo.getTable(),
										statisticSearchVo.getOrginternalcode())));

				return getTypePieList(resultList, total);
			}
		} else if (isYouth(statisticSearchVo)) {
			if (PropertyTypes.POLITICAL_BACKGROUND.equals(statisticSearchVo
					.getDomainName())) {
				mapList = getYouthListByPoliticalBackGround(statisticSearchVo);
			} else {
				mapList = baseInfoStatisticsNewDao
						.getYouthRealTimeCountGroupByAge(statisticSearchVo);
			}
			double total = Double.parseDouble(String
					.valueOf(baseInfoStatisticsNewDao
							.getTotalYouthByOrgCode(statisticSearchVo)));
			return getTypePieList(mapList, total);
		} else {
			mapList = baseInfoStatisticsNewDao
					.getRealTimeCountByTypeName(statisticSearchVo);
		}

		double sum = Double.parseDouble(String.valueOf(baseInfoStatisticsNewDao
				.getTotalFromTableByOrgCode(statisticSearchVo.getTable(),
						statisticSearchVo.getOrginternalcode())));

		return getTypePieList(mapList, sum);
	}

	/**
	 * 总况的类型分布图 ，历史记录
	 * 
	 * @param list
	 * @param orgInternalCode
	 * @param year
	 * @param month
	 * @return
	 */
	private List<Object[]> getTotalTablePieStatisticListFromHistory(
			List<PopulationCatalog> list, Long orgId, int year, int month) {

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		Map<String, Object> queryMap;
		int total = 0;// 所以表的记录
		Integer sum = 0;// 单独一个表的记录数
		for (PopulationCatalog catalog : list) {
			queryMap = new HashMap<String, Object>();
			queryMap.put("type", catalog.getCatalog());
			queryMap.put("orgId", orgId);
			queryMap.put("year", year);
			queryMap.put("month", month);
			if(catalog.getCatalog() != null && catalog.getCatalog().equals(PopulationType.IDLE_YOUTH)){
				//获取（'0~6岁','6~18岁','12~25岁','25~35岁'）
				String typeName = getIdleYouth_TypeName();
				queryMap.put("typeNames", typeName);
			}
			// 读取缓存
			sum = (Integer) cacheService.get(MemCacheConstant
					.getHistoryStaCachKey(orgId, year, month,
							catalog.getCatalog()));
			if (sum == null) {
				sum = baseInfoStatisticsNewDao
						.countByMapFromHistorySta(queryMap);
				cacheService.set(MemCacheConstant.getHistoryStaCachKey(orgId,
						year, month, catalog.getCatalog()), sum);
			}

			map = new HashMap<String, Object>();
			map.put("DISPLAYNAME", PopulationType
					.getCnameByPopulationType(catalog.getCatalog()));
			map.put("COUNTNUM", new BigDecimal(sum));

			mapList.add(map);
			total = total + sum;

		}
		return getTypePieList(mapList, total);
	}

	/**
	 * 获取总况的实时分类数据
	 */
	private List<Object[]> getTotalTablePieStatisticList(
			List<PopulationCatalog> list, String orgInternalCode) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		int total = 0;// 所以表的记录
		int sum = 0;// 单独一个表的记录数
		for (PopulationCatalog catalog : list) {

			map = new HashMap<String, Object>();
			sum = baseInfoStatisticsNewDao.getTotalFromTableByOrgCode(catalog
					.getStatisticListSetting().getTableName(), orgInternalCode);
			total = total + sum;
			map.put("DISPLAYNAME", PopulationType
					.getCnameByPopulationType(catalog.getCatalog()));
			map.put("COUNTNUM", new BigDecimal(sum));
			mapList.add(map);

		}
		return getTypePieList(mapList, total);
	}

	private List<Object[]> getTypePieList(List<Map<String, Object>> mapList,
			double sum) {
		if (mapList == null || mapList.size() == 0) {
			return new ArrayList<Object[]>();
		}
		List<Object[]> resultList = new ArrayList<Object[]>();
		Object[] objs;
		for (Map<String, Object> map : mapList) {
			String typeName = (String) map.get("DISPLAYNAME");
			int countValue = Integer.valueOf(((BigDecimal) map.get("COUNTNUM"))
					.toString());
			objs = new Object[2];

			objs[0] = typeName + "( "
					+ new java.text.DecimalFormat("#").format(countValue)
					+ " )";
			if (countValue == 0) {
				objs[1] = Double.parseDouble("0");
			} else {
				objs[1] = Double
						.parseDouble(new java.text.DecimalFormat("#.00")
								.format(countValue / sum * 100));
			}
			resultList.add(objs);
		}
		return resultList;
	}

	/**
	 * 从历史报表中获取类型分布图需要的数据
	 * 
	 * @param statisticSearchVo
	 * @return
	 */
	private List<Object[]> getStatisticInfoFromHistory(
			StatisticSearchVo statisticSearchVo) {

		List<Object[]> resultList = new ArrayList<Object[]>();
		Object[] objs;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", statisticSearchVo.getType());
		map.put("year", statisticSearchVo.getYear());
		map.put("month", statisticSearchVo.getMonth());
		map.put("orgInternalCode", statisticSearchVo.getOrginternalcode());
		map.put("orgId", statisticSearchVo.getOrgId());
		double total = 0;
		// 由于青少年历时数据表统计了年龄层与类型2种统计的数据,所以统计青少年总数要去掉一半
		if (PopulationCatalog.ALL_YOUTH_POPULATION.equals(statisticSearchVo
				.getType()) || PopulationType.IDLE_YOUTH.equals(statisticSearchVo
						.getType())) {
			total = Double.parseDouble(String.valueOf(baseInfoStatisticsNewDao
					.countByMapFromHistorySta(map))) / 2;
		} else {
			total = Double.parseDouble(String.valueOf(baseInfoStatisticsNewDao
					.countByMapFromHistorySta(map)));
		}

		List<PropertyDict> propertyDictList = propertyDictService
				.findPropertyDictByDomainName(statisticSearchVo.getDomainName());
		for (PropertyDict propertyDict : propertyDictList) {
			if (PropertyTypes.POLITICAL_BACKGROUND.equals(statisticSearchVo
					.getDomainName())) {
				if (!PropertyTypes.YOUNG_MEMBERS.equals(propertyDict
						.getDisplayName())
						&& !PropertyTypes.YOUNG_PIONEERS.equals(propertyDict
								.getDisplayName())
						&& !PropertyTypes.OTHER_YOUNGS.equals(propertyDict
								.getDisplayName())) {
					continue;
				}
			}
			objs = new Object[2];

			map.put("typeName", propertyDict.getDisplayName());
			int sum = baseInfoStatisticsNewDao.countByMapFromHistorySta(map);

			objs[0] = propertyDict.getDisplayName() + "( "
					+ new java.text.DecimalFormat("#").format(sum) + " )";
			if (sum == 0) {
				objs[1] = Double.parseDouble("0");
			} else {
				objs[1] = Double
						.parseDouble(new java.text.DecimalFormat("#.00")
								.format(sum / total * 100));
			}

			resultList.add(objs);
		}
		return resultList;

	}

	/**
	 * 区域图数据
	 */
	@Override
	public HighchartColumnVo getArealDistributionList(String type, Long orgId) {
		StatisticSearchVo statisticSearchVo = null;
		if (!PopulationCatalog.ALL_YOUTH_POPULATION.equals(type)) {
			List<PopulationCatalog> list = getPopulationCatalogListByType(type);
			if (list != null && list.size() > 0) {
				return getTotalArealDistributionList(list, orgId);
			}
			statisticSearchVo = createStatisticSearchVo(type, orgId, "");
		} else {
			statisticSearchVo = createYouthStatisticSearchVo(type, orgId, "");
		}
		statisticSearchVo.setOrgId(orgId);
		return getArealDistributionList(statisticSearchVo);

	}

	// 根据时间加载历史数据
	@Override
	public HighchartColumnVo getArealDistributionListFromHistory(Long orgId,
			String type, int year, int month) {
		// 判断是否要创建表
		tableService.createAnalyseTable(AnalyseUtilNew.IMPORTPERSONTABLENAME,
				AnalyseUtilNew.IMPORTPERSONSQL, year, month);
		StatisticSearchVo statisticSearchVo = null;
		if (PopulationCatalog.ALL_YOUTH_POPULATION.equals(type)) {
			statisticSearchVo = createYouthStatisticSearchVo(type, orgId, "");
		} else {
			statisticSearchVo = createStatisticSearchVo(type, orgId, "");
		}
		statisticSearchVo.setYear(year);
		statisticSearchVo.setMonth(month);
		statisticSearchVo.setOrgType(getOrgType(statisticSearchVo));
		statisticSearchVo
				.setPropertyDomainId(getPropertyDomainId(statisticSearchVo));
		if (null == statisticSearchVo.getTableDisplayName()) {
			PopulationCatalog catalog = PopulationCatalog.parse(type);
			statisticSearchVo.setTableDisplayName(catalog.getDisplayName());
		}
		if (PopulationCatalog.ALL_YOUTH_POPULATION.equals(type)) {
			return getArealDistributionListFromHistory(statisticSearchVo);
		}
		List<PopulationCatalog> list = getPopulationCatalogListByType(type);
		if (list != null && list.size() > 0) {
			// 总况的情况
			return getTotalArealDistributionListFromHistory(list,
					statisticSearchVo);
		}
		return retrunGetArealDistributionListFromHistory(statisticSearchVo);
		// return getArealDistributionListFromHistory(statisticSearchVo);
	}

	private HighchartColumnVo retrunGetArealDistributionListFromHistory(
			StatisticSearchVo statisticSearchVo) {
		HighchartColumnVo highchartColumnVo = null;
		// 刑释人员特殊处理
		if (BaseInfoTables.POSITIVEINFO_KEY.equals(statisticSearchVo.getType())) {
			highchartColumnVo = getArealDistributionListFromHistory(statisticSearchVo);
			List<HighchartDataColumnVo> list = highchartColumnVo.getSeries();
			if (list != null && list.size() > 0) {
				int[] date = new int[list.get(0).getData().length];
				for (HighchartDataColumnVo highchartDataColumnVo : list) {
					int[] datas = highchartDataColumnVo.getData();
					for (int i = 0; i < datas.length; i++) {
						int idata = datas[i];
						date[i] += idata;
					}
				}
				HighchartDataColumnVo dataColumnVo = new HighchartDataColumnVo();
				dataColumnVo.setName("刑释人员");
				dataColumnVo.setStack("刑释解教类型");
				dataColumnVo.setData(date);
				list.removeAll(list);
				list.add(dataColumnVo);
				highchartColumnVo.setSeries(list);
			}
			return highchartColumnVo;
		} else {
			return getArealDistributionListFromHistory(statisticSearchVo);
		}
	}

	/**
	 * 获得区域分布图数据从历史记录表中,有type 总况的情况
	 * 
	 * @param list
	 * @param orgId
	 * @return
	 */
	private HighchartColumnVo getTotalArealDistributionListFromHistory(
			List<PopulationCatalog> list, StatisticSearchVo statisticSearchVo) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		List<String> types = new ArrayList<String>();
		for (PopulationCatalog catalog : list) {
			types.add(catalog.getCatalog());
		}
		queryMap = new HashMap<String, Object>();
		queryMap.put("orgId", statisticSearchVo.getOrgId());
		queryMap.put("year", statisticSearchVo.getYear());
		queryMap.put("month", statisticSearchVo.getMonth());
		queryMap.put("types", types);
		queryMap.put(
				"orgType",
				propertyDictService
						.findPropertyDictByDomainNameAndInternalId(
								PropertyTypes.ORGANIZATION_TYPE,
								OrganizationType.ADMINISTRATIVE_REGION).get(0)
						.getId());
		//获取（'0~6岁','6~12岁','12~25岁','25~35岁'）
		String typeName = getIdleYouth_TypeName();
		queryMap.put("typeName", typeName);
		List<Map<String, Object>> resultList = baseInfoStatisticsNewDao
				.getTotalArealListFromHistory(queryMap);
		HighchartColumnVo highchartColumnVo = new HighchartColumnVo();
		return createHighchartColumnVoByListNoTypeName(resultList,
				statisticSearchVo, highchartColumnVo);
	}

	private HighchartColumnVo getArealDistributionListFromHistory(
			StatisticSearchVo statisticSearchVo) {
		statisticSearchVo.setOrgType(getOrgType(statisticSearchVo));
		statisticSearchVo
				.setPropertyDomainId(getPropertyDomainId(statisticSearchVo));
		if (null != statisticSearchVo.getDomainName()) {
			List<Map<String, Object>> list = baseInfoStatisticsNewDao
					.getArealDistributionListFromHistory(statisticSearchVo);
			return createResultByHistory(list, statisticSearchVo);
		} else {
			// 没有分组的情况
			List<Map<String, Object>> lists = baseInfoStatisticsNewDao
					.getArealDistributionListFromHistoryNoType(statisticSearchVo);
			HighchartColumnVo highchartColumnVo = new HighchartColumnVo();

			highchartColumnVo = createHighchartColumnVoByListNoTypeName(lists,
					statisticSearchVo, highchartColumnVo);
			// 查询帮教情况，并组装数据
			List<Map<String, Object>> helpLists = baseInfoStatisticsNewDao
					.getIsHelpFromHistory(statisticSearchVo);
			return findHelpData(helpLists, statisticSearchVo, highchartColumnVo);
		}

	}

	@Override
	public void addCurrentMonthHistoryStatisticInfoByType(String type) {
		Organization org = organizationDubboService.getRootOrganization();
		String orgCode = org.getOrgInternalCode();

		int year = CalendarUtil.getLastMonthYearValue();
		int month = CalendarUtil.getLastMonth();

		checkDate(year, month);
		checkHistoryStatisticTable(year, month);

		logger.info("开始运行：" + type);
		generateStatisticByType(year, month, orgCode, type);
		logger.info("运行结束：" + type);
	}

	/**
	 * 每月生成的统计信息，job调用
	 */
	@Override
	public void generateHistoryStatistic() {

		int year = CalendarUtil.getLastMonthYearValue();
		int month = CalendarUtil.getLastMonth();

		checkDate(year, month);
		checkHistoryStatisticTable(year, month);

		String orgCode = organizationDubboService.getRootOrganization()
				.getOrgInternalCode();

		for (String type : getCreateHistoryStatisticTypes()) {
			createHistoryStatisticByType(year, month, type, orgCode);
		}
		//加上计算特殊人群每个层级(网格以上)的总数的类型放入leaderViewCache表
		leaderViewNewService.
			setMothDataToLeaderViewCacheByType(
				OrganizationLevel.GRID_KEY, PopulationCatalog.ALL_ATTENTION_POPULATION);
		//加上计算老年人每个层级（县级以上）的总数的类型放入leaderViewCache表
		leaderViewNewService.
			setMothDataToLeaderViewCacheByType(
				OrganizationLevel.DISTRICT_KEY, PopulationType.ELDERLY_PEOPLE);
		//加上育龄妇女每个层级（县级以上）的总数的类型放入leaderViewCache表
		leaderViewNewService.
			setMothDataToLeaderViewCacheByType(
				OrganizationLevel.DISTRICT_KEY, PopulationType.NURTURES_WOMEN);
	}

	private void generateStatisticByType(int year, int month, String orgCode,
			String type) {
		deleteOldDatasFromTable(year, month, type, orgCode);
		if (isIdleYouth(type)) {
			generateIdleYouthHistoryStatistic(year, month, type, orgCode);
		} else if (isActualHouse(type)) {
			generateActualHouseHistoryStatistic(year, month, type, orgCode);
		} else if (isPositiveInfo(type)) {
			generatePositiveInfoHistoryStatistic(year, month, type, orgCode);
		} else if (isGroupByProperty(type)) {
			generateHistoryStatisticByType(year, month, type, orgCode);
		} else if (PopulationCatalog.ALL_YOUTH_POPULATION.equals(type)) {
			// generateYouthHistoryStatistic(year, month, type, orgCode);
			generateYouthHistoryStatisticForSimple(year, month, type, orgCode);

		} else {
			generateHistoryStatisticWithoutPropertyDict(year, month, type,
					orgCode);
		}
	}

	/**
	 * 新的，不需要生成total、monthcreate、attentionnum的方法
	 * 
	 * @param year
	 * @param month
	 * @param type
	 * @param orgCode
	 */

	private void generateYouthHistoryStatisticForSimple(int year, int month,
			String type, String orgCode) {
		Organization organization = organizationDubboService
				.getOrganizationByOrgInternalCode(orgCode);
		if (shardConversion.isOverCity(organization)) {
			List<Organization> orgs = organizationDubboService
					.findOrgsByOrgTypeAndOrgLevelAndParentId(
							OrganizationType.ADMINISTRATIVE_REGION,
							OrganizationLevel.CITY, organization.getId());

			for (Organization org : orgs) {
				StatisticSearchVo statisticSearchVo = createYouthStatisticSearchVo(
						type, org.getId(), "");
				statisticSearchVo.setOrginternalcode(org.getOrgInternalCode());
				fillStatisticSearchVoForYouthHistoryStatistic(year, month,
						type, statisticSearchVo);
				addYouthHistoryStatistic(statisticSearchVo);

				statisticSearchVo
						.setDomainName(PropertyTypes.POLITICAL_BACKGROUND);
				addYouthHistoryStatistic(statisticSearchVo);
			}
		} else {
			StatisticSearchVo statisticSearchVo = createYouthStatisticSearchVo(
					type, organization.getId(), "");
			statisticSearchVo.setOrginternalcode(organization
					.getOrgInternalCode());
			fillStatisticSearchVoForYouthHistoryStatistic(year, month, type,
					statisticSearchVo);

			addYouthHistoryStatistic(statisticSearchVo);

			statisticSearchVo.setDomainName(PropertyTypes.POLITICAL_BACKGROUND);
			addYouthHistoryStatistic(statisticSearchVo);
		}

	}

	/**
	 * 为青少年的统计所用
	 * 
	 * @param year
	 * @param month
	 * @param type
	 * @param statisticSearchVo
	 */
	private void fillStatisticSearchVoForYouthHistoryStatistic(int year,
			int month, String type, StatisticSearchVo statisticSearchVo) {
		statisticSearchVo.setYear(year);
		statisticSearchVo.setMonth(month);
		statisticSearchVo.setEndDate(CalendarUtil
				.getNextMonthStart(year, month));
		statisticSearchVo.setStartDate(CalendarUtil.getMonthStart(year, month));
		statisticSearchVo.setType(type);
		statisticSearchVo.setTotal(0L);
		statisticSearchVo.setAttentionNum(0L);
		statisticSearchVo.setMonthCreate(0L);
	}

	// private void generateYouthHistoryStatistic(int year, int month,
	// String type, String orgCode) {
	// Organization organization = organizationDubboService
	// .getOrganizationByOrgInternalCode(orgCode);
	// if (shardConversion.isOverCity(organization)) {
	// List<Organization> orgs = organizationDubboService
	// .findOrgsByOrgTypeAndOrgLevelAndParentId(
	// OrganizationType.ADMINISTRATIVE_REGION,
	// OrganizationLevel.CITY, organization.getId());
	//
	// for (Organization org : orgs) {
	// StatisticSearchVo statisticSearchVo = createYouthStatisticSearchVo(
	// type, org.getId(), "");
	// statisticSearchVo.setOrginternalcode(org.getOrgInternalCode());
	// statisticSearchVo = constructionStatisticSerchVo(year, month,
	// type, statisticSearchVo);
	//
	// addYouthHistoryStatistic(statisticSearchVo);
	//
	// statisticSearchVo
	// .setDomainName(PropertyTypes.POLITICAL_BACKGROUND);
	// addYouthHistoryStatistic(statisticSearchVo);
	// }
	// } else {
	// StatisticSearchVo statisticSearchVo = createYouthStatisticSearchVo(
	// type, organization.getId(), "");
	// statisticSearchVo.setOrginternalcode(organization
	// .getOrgInternalCode());
	// statisticSearchVo = constructionStatisticSerchVo(year, month, type,
	// statisticSearchVo);
	//
	// addYouthHistoryStatistic(statisticSearchVo);
	//
	// statisticSearchVo.setDomainName(PropertyTypes.POLITICAL_BACKGROUND);
	// addYouthHistoryStatistic(statisticSearchVo);
	// }
	//
	// }

	// private StatisticSearchVo constructionStatisticSerchVo(int year, int
	// month,
	// String type, StatisticSearchVo statisticSearchVo) {
	// statisticSearchVo.setYear(year);
	// statisticSearchVo.setMonth(month);
	// statisticSearchVo.setEndDate(CalendarUtil
	// .getNextMonthStart(year, month));
	// statisticSearchVo.setStartDate(CalendarUtil.getMonthStart(year, month));
	// statisticSearchVo.setType(type);
	// // 查询本月新增，关注人数，人员总数更新历史表
	// Map<String, Object> map = new HashMap<String, Object>();
	// if (PopulationCatalog.ALL_YOUTH_POPULATION.equals(type)) {
	// map = baseInfoStatisticsNewDao
	// .getYouthMonthCreateAttentionNumAndTotal(statisticSearchVo);
	// }
	// statisticSearchVo.setMonthCreate(((BigDecimal) map.get("MONTHCREATE"))
	// .longValue());
	// statisticSearchVo
	// .setAttentionNum(((BigDecimal) map.get("ATTENTIONNUM"))
	// .longValue());
	// statisticSearchVo.setTotal(((BigDecimal) map.get("TOTAL")).longValue());
	// return statisticSearchVo;
	// }

	private void addYouthHistoryStatistic(StatisticSearchVo statisticSearchVo) {
		List<PropertyDict> dicts = propertyDictService
				.findPropertyDictByDomainName(statisticSearchVo.getDomainName());
		List<StatisticSearchVo> list = new ArrayList<StatisticSearchVo>();
		for (int i = 0; i < dicts.size(); i++) {
			if (PropertyTypes.POLITICAL_BACKGROUND.equals(statisticSearchVo
					.getDomainName())) {
				if (PropertyTypes.OTHER_YOUNGS.equals(dicts.get(i)
						.getDisplayName())) {
					statisticSearchVo.setDisplayName(dicts.get(i)
							.getDisplayName());
					statisticSearchVo.setPropertyDict(null);
					List<StatisticSearchVo> temp = baseInfoStatisticsNewDao
							.countHistoryDataByType(statisticSearchVo);
					list.addAll(temp);
					continue;
				}
				if (!PropertyTypes.YOUNG_MEMBERS.equals(dicts.get(i)
						.getDisplayName())
						&& !PropertyTypes.YOUNG_PIONEERS.equals(dicts.get(i)
								.getDisplayName())) {
					continue;
				}
			}
			statisticSearchVo.setDisplayName(dicts.get(i).getDisplayName());
			statisticSearchVo.setPropertyDict(dicts.get(i));
			List<StatisticSearchVo> temp = baseInfoStatisticsNewDao
					.countHistoryDataByType(statisticSearchVo);
			list.addAll(temp);
		}
		// if (PropertyTypes.POLITICAL_BACKGROUND.equals(statisticSearchVo
		// .getDomainName())) {
		// long countValue = 0;
		// StatisticSearchVo otherYoungs = new StatisticSearchVo();
		// for (int i = 0; i < list.size(); i++) {
		// if (!PropertyTypes.OTHER_YOUNGS.equals(list.get(i)
		// .getDisplayName())) {
		// countValue += list.get(i).getSumNum();
		// } else {
		// otherYoungs = list.get(i);
		// }
		// if (i == list.size() - 1) {
		// otherYoungs.setSumNum(otherYoungs.getSumNum() - countValue);
		// }
		// }
		// }
		baseInfoStatisticsNewDao.addHistoryStatistic(list);
	}

	private void generatePositiveInfoHistoryStatistic(int year, int month,
			String type, String orgCode) {
		baseInfoStatisticsNewDao.generatePositiveInfoHistoryStatistic(year,
				month, CalendarUtil.getMonthStart(year, month),
				CalendarUtil.getNextMonthStart(year, month), type,
				PopulationCatalog.parse(type).getStatisticListSetting()
						.getTableName(), PopulationCatalog.parse(type)
						.getStatisticListSetting().getPropertyField());
	}

	private void generateHistoryStatisticWithoutPropertyDict(int year,
			int month, String type, String orgCode) {
		List<Long> countryList = getOrganizationsByLevel(OrganizationLevel.COUNTRY_KEY);
		String tableName = PopulationCatalog.parse(type)
				.getStatisticListSetting().getTableName();
		for (Long countryOrgId : countryList) {
			final Organization organization = organizationDubboService
					.getSimpleOrgById(countryOrgId);
			if (!ShardTables.isShardTables(tableName)) {
				baseInfoStatisticsNewDao
						.generateHistoryStatisticWithoutPropertyDict(year,
								month, CalendarUtil.getMonthStart(year, month),
								CalendarUtil.getNextMonthStart(year, month),
								type, tableName, PopulationCatalog.parse(type)
										.getDisplayName(), null);
			} else {
				if (shardConversion.isOverCity(organization)) {
					List<Organization> orgs = organizationDubboService
							.findOrgsByOrgTypeAndOrgLevelAndParentId(
									OrganizationType.ADMINISTRATIVE_REGION,
									OrganizationLevel.CITY,
									organization.getId());
					for (Organization org : orgs) {
						baseInfoStatisticsNewDao
								.generateHistoryStatisticWithoutPropertyDict(
										year, month, CalendarUtil
												.getMonthStart(year, month),
										CalendarUtil.getNextMonthStart(year,
												month), type, tableName,
										PopulationCatalog.parse(type)
												.getDisplayName(),
										shardConversion.getShardCode(org));
					}
				}

			}
		}
	}

	private void generateActualHouseHistoryStatistic(int year, int month,
			String type, String orgCode) {
		List<Long> countryList = getOrganizationsByLevel(OrganizationLevel.COUNTRY_KEY);
		String tableName = PopulationCatalog.parse(type)
				.getStatisticListSetting().getTableName();
		for (Long countryOrgId : countryList) {
			final Organization organization = organizationDubboService
					.getSimpleOrgById(countryOrgId);
			if (!BaseInfoTables.HOUSEINFO_KEY.equals(tableName)) {
				baseInfoStatisticsNewDao.generateActualHouseHistoryStatistic(
						year, month, CalendarUtil.getMonthStart(year, month),
						CalendarUtil.getNextMonthStart(year, month), type,
						PopulationCatalog.parse(type).getStatisticListSetting()
								.getTableName(), null);
			} else {
				if (shardConversion.isOverCity(organization)) {
					List<Organization> orgs = organizationDubboService
							.findOrgsByOrgTypeAndOrgLevelAndParentId(
									OrganizationType.ADMINISTRATIVE_REGION,
									OrganizationLevel.CITY,
									organization.getId());
					for (Organization org : orgs) {
						baseInfoStatisticsNewDao
								.generateActualHouseHistoryStatistic(year,
										month, CalendarUtil.getMonthStart(year,
												month),
										CalendarUtil.getNextMonthStart(year,
												month), type, PopulationCatalog
												.parse(type)
												.getStatisticListSetting()
												.getTableName(),
										shardConversion.getShardCode(org));
					}
				}

			}
		}
	}

	private void generateIdleYouthHistoryStatistic(int year, int month,
			String type, String orgCode) {
		baseInfoStatisticsNewDao.generateIdleYouthHistoryStatisticByType(year,
				month, CalendarUtil.getMonthStart(year, month),
				CalendarUtil.getNextMonthStart(year, month), type,
				PopulationCatalog.parse(type).getStatisticListSetting()
						.getTableName());

		baseInfoStatisticsNewDao.generateIdleYouthHistoryStatisticByAge(year,
				month, CalendarUtil.getMonthStart(year, month),
				CalendarUtil.getNextMonthStart(year, month), type,
				PopulationCatalog.parse(type).getStatisticListSetting()
						.getTableName());

		// baseInfoStatisticsNewDao.generateIdleYouthByAgeAndLeaderCount(year,
		// month,
		// CalendarUtil.getMonthStart(year, month),
		// CalendarUtil.getNextMonthStart(year, month), type,
		// PopulationCatalog.parse(type).getStatisticListSetting()
		// .getTableName());
	}

	private boolean isGroupByProperty(String type) {
		String propertyField = null;
		if (PopulationCatalog.parse(type) != null
				&& PopulationCatalog.parse(type).getStatisticListSetting() != null) {
			propertyField = PopulationCatalog.parse(type)
					.getStatisticListSetting().getPropertyField();
		}
		return propertyField != null && !propertyField.trim().equals("")
				&& !propertyField.isEmpty();
	}

	private boolean isPositiveInfo(String type) {
		return PopulationType.POSITIVE_INFO.equals(type);
	}

	private boolean isActualHouse(String type) {
		return PopulationType.ACTUAL_HOUSE.equals(type);
	}

	private void generateHistoryStatisticByType(int year, int month,
			String type, String orgCode) {
		baseInfoStatisticsNewDao.generateHistoryStatisticByType(year, month,
				CalendarUtil.getMonthStart(year, month),
				CalendarUtil.getNextMonthStart(year, month), type,
				PopulationCatalog.parse(type).getStatisticListSetting()
						.getTableName(), PopulationCatalog.parse(type)
						.getStatisticListSetting().getPropertyField());
	}

	/**
	 * 获取需要生成研判分析的模块
	 * 
	 * @return
	 */
	private List<String> getCreateHistoryStatisticTypes() {
		List<String> types = new ArrayList<String>();
		// 重点人员的
		for (PopulationCatalog populationCatalog : PopulationCatalog
				.getAllAttentionPopulationCatalog()) {
			types.add(populationCatalog.getCatalog());
		}
		// 计生的
		for (PopulationCatalog populationCatalog : PopulationCatalog
				.getAllBirthPopulationCatalog()) {
			types.add(populationCatalog.getCatalog());
		}
		// 民政的
		for (PopulationCatalog populationCatalog : PopulationCatalog
				.getAllCivilPopulationCatalog()) {
			types.add(populationCatalog.getCatalog());
		}
		// 失业人员
		for (PopulationCatalog populationCatalog : PopulationCatalog
				.getAllUnemployPopulationCatalog()) {
			types.add(populationCatalog.getCatalog());
		}
		// 实有单位
		types.add(PopulationType.ACTUAL_COMPANY);
		// 新经济组织
		types.add(PopulationType.NEW_SOCIETY);
		// 新社会组织
		types.add(PopulationType.NEW_ECONOMIC);
		// 出租房
		types.add(PopulationType.RENTAL_HOUSE);
		// 实有房屋
		types.add(PopulationType.ACTUAL_HOUSE);
		// 楼宇
		types.add(PopulationCatalog.parse(BaseInfoTables.BUILDDATA_KEY)
				.getCatalog());
		return types;
	}

	/***
	 * 获取特殊人群生成报表集合
	 */
	public List<String> getCreateHistoryStatisticTypesForAllAttentionPopulation() {
		List<String> types = new ArrayList<String>();
		// 重点人员的
		for (PopulationCatalog populationCatalog : PopulationCatalog
				.getAllAttentionPopulationCatalog()) {
			types.add(populationCatalog.getCatalog());
		}
		return types;
	}

	/***
	 * 获取关怀对象生成报表集合
	 */
	public List<String> getCreateHistoryStatisticTypesForAllCivilPopulation() {
		List<String> types = new ArrayList<String>();
		// 关怀对象的
		for (PopulationCatalog populationCatalog : PopulationCatalog
				.getAllCivilPopulationCatalog()) {
			types.add(populationCatalog.getCatalog());
		}
		return types;
	}

	@Override
	public HighchartColumnVo getArealDistributionListForWorkBench(Long orgId) {
		HighchartColumnVo personnelColumn = new HighchartColumnVo();
		List<Organization> organizations = new ArrayList<Organization>();
		organizations = organizationDubboService
				.findOrganizationsByParentId(orgId);
		String[] categories = new String[organizations.size()];
		int[] unRentData = new int[organizations.size()];
		int[] rentData = new int[organizations.size()];
		List<HighchartDataColumnVo> series = new ArrayList<HighchartDataColumnVo>();
		HighchartDataColumnVo unRentHighchartDataColumn = new HighchartDataColumnVo();
		unRentHighchartDataColumn.setName("非出租房");
		HighchartDataColumnVo rentHighchartDataColumn = new HighchartDataColumnVo();
		rentHighchartDataColumn.setName("出租房");
		Integer i = 0;
		for (Organization organization : organizations) {
			String orgInternalCode = organization.getOrgInternalCode();
			categories[i] = organization.getOrgName();
			unRentData[i] = actualHouseDao
					.countUnRentHouseByOrgInternalCode(orgInternalCode);
			rentData[i] = actualHouseDao
					.countRentHouseByOrgInternalCode(orgInternalCode);
			i++;
		}
		unRentHighchartDataColumn.setData(unRentData);
		rentHighchartDataColumn.setData(rentData);
		String stack = "stack";
		unRentHighchartDataColumn.setStack(stack);
		rentHighchartDataColumn.setStack(stack);
		series.add(unRentHighchartDataColumn);
		series.add(rentHighchartDataColumn);
		personnelColumn.setCategories(categories);
		personnelColumn.setModuleName("房屋信息");
		personnelColumn.setSeries(series);
		return personnelColumn;
	}

	@Override
	public HighchartColumnVo getIssueListForWorkBench(Long orgId) {
		HighchartColumnVo personnelColumn = new HighchartColumnVo();
		List<Organization> organizations = new ArrayList<Organization>();
		organizations = organizationDubboService
				.findOrganizationsByParentId(orgId);
		String[] categories = new String[organizations.size()];
		int[] unRentData = new int[organizations.size()];
		int[] rentData = new int[organizations.size()];
		List<HighchartDataColumnVo> series = new ArrayList<HighchartDataColumnVo>();
		HighchartDataColumnVo unRentHighchartDataColumn = new HighchartDataColumnVo();
		unRentHighchartDataColumn.setName("在办");
		HighchartDataColumnVo rentHighchartDataColumn = new HighchartDataColumnVo();
		rentHighchartDataColumn.setName("已办");
		Integer i = 0;
		int numData = 0;
		for (Organization organization : organizations) {
			categories[i] = organization.getOrgName();
			numData = issueService.getJurisdictionsNeedDoCount(organization);
			numData += issueService.getJurisdictionsVerification(organization);
			unRentData[i] = numData;
			rentData[i] = issueService.getMyDoneCount(organization);
			i++;
		}
		unRentHighchartDataColumn.setData(unRentData);
		rentHighchartDataColumn.setData(rentData);
		String stack = "stack";
		unRentHighchartDataColumn.setStack(stack);
		rentHighchartDataColumn.setStack(stack);
		series.add(unRentHighchartDataColumn);
		series.add(rentHighchartDataColumn);
		personnelColumn.setCategories(categories);
		personnelColumn.setModuleName("事件");
		personnelColumn.setSeries(series);
		return personnelColumn;
	}

	@Override
	public int getImportPersonCount(Long orgId) {
		List<PopulationCatalog> list = getPopulationCatalogListByType("all_attention_population");
		HighchartColumnVo highchartColumnVo = baseInfoStatisticsNewDao
				.getTotalArealDistributionList(list, orgId, getAdminsOrgType());

		int sum = 0;
		if (highchartColumnVo != null && highchartColumnVo.getSeries() != null) {
			HighchartDataColumnVo vo = highchartColumnVo.getSeries().get(0);
			for (int num : vo.getData()) {
				sum += num;
			}
		}

		return sum;
	}

	@Override
	public int getrentalHouseCountByTypeAndId(String type, Long orgId) {
		HighchartColumnVo highchartColumnVo = getArealDistributionList(type,
				orgId);
		int sum = 0;
		if (highchartColumnVo != null && highchartColumnVo.getSeries() != null) {
			for (HighchartDataColumnVo vo : highchartColumnVo.getSeries()) {
				for (int num : vo.getData()) {
					sum += num;
				}
			}
		}

		return sum;
	}

	@Override
	public void createHistoryStatisticByType(int year, int month, String type,
			String orgInternalCode) {
		checkDate(year, month);
		boolean isCreateTable = checkHistoryStatisticTable(year, month);
		// 清除数据
		if (!isCreateTable) {
			baseInfoStatisticsNewDao.deleteHistoryStatistic(null, year, month,
					type);
		}
		/** 新的有旧的没有 */
		// generateStatisticByType(year, month, orgInternalCode, type);
		orgInternalCode = organizationDubboService.getRootOrganization()
				.getOrgInternalCode();
		if (isAllAttentionPopulationType(type)) {// 判断是否是特殊人群总况的情况
			for (String populationType : getCreateHistoryStatisticTypesForAllAttentionPopulation()) {
				generateStatisticByType(year, month, orgInternalCode,
						populationType);
				packetStatisticsService.createPacketStatisticsByTypeAndTime(
						PacketStatisticsTables.STATISTICHISTORY_KEY,
						populationType, year, month);
			}
			//加上计算重点人员每个层级的总数的类型放入leaderViewCache表
			leaderViewNewService.
				setMothDataToLeaderViewCacheByType(
						OrganizationLevel.GRID_KEY, PopulationCatalog.ALL_ATTENTION_POPULATION);
		} else if (isAllCivilPopulationTypes(type)) {
			for (String populationType : getCreateHistoryStatisticTypesForAllCivilPopulation()) {
				generateStatisticByType(year, month, orgInternalCode,
						populationType);
				packetStatisticsService.createPacketStatisticsByTypeAndTime(
						PacketStatisticsTables.STATISTICHISTORY_KEY,
						populationType, year, month);
			}
		} else {
			generateStatisticByType(year, month, orgInternalCode, type);
			packetStatisticsService.createPacketStatisticsByTypeAndTime(
					PacketStatisticsTables.STATISTICHISTORY_KEY, type, year,
					month);
		}
	}

	@Override
	public void createHistoryStatisticByType(int year, int month) {
		checkDate(year, month);
		boolean isCreateTable = checkHistoryStatisticTable(year, month);
		// 清除数据
		if (!isCreateTable) {
			baseInfoStatisticsNewDao.deleteHistoryStatistic(null, year, month,
					null);
		}
		String orgCode = organizationDubboService.getRootOrganization()
				.getOrgInternalCode();

		for (String type : getCreateHistoryStatisticTypes()) {
			generateStatisticByType(year, month, orgCode, type);
		}
	}

	/**
	 * 判断是否是青少年
	 * 
	 * @param statisticSearchVo
	 * @return
	 */
	private boolean isYouth(StatisticSearchVo statisticSearchVo) {
		String type = statisticSearchVo.getType();
		return PopulationType.ALL_YOUTH_POPULATION.equals(type);
	}

	/***
	 * 判断是否是特殊人群总况的情况
	 * 
	 * @param type
	 * @param orgId
	 * @param domainName
	 * @return
	 * 
	 */
	private boolean isAllAttentionPopulationType(String type) {
		return PopulationCatalog.ALL_ATTENTION_POPULATION.equals(type);
	}

	/***
	 * 判断是否是关怀对象总况的情况
	 * 
	 * @param type
	 * @param orgId
	 * @param domainName
	 * @return
	 */
	private boolean isAllCivilPopulationTypes(String type) {
		return PopulationCatalog.ALL_CIVIL_POPULATION.equals(type);
	}

	private StatisticSearchVo createYouthStatisticSearchVo(String type,
			long orgId, String domainName) {
		PopulationCatalog populationCatalog = PopulationCatalog.parse(type);
		List<PopulationCatalog> list = getPopulationCatalogListByType(type);
		StatisticSearchVo statisticSearchVo = new StatisticSearchVo();
		statisticSearchVo.setType(type);
		statisticSearchVo.setTableDisplayName(PopulationType
				.getCnameByPopulationType(type));
		Organization organization = organizationDubboService
				.getOrgAndLevelInfo(orgId);

		if (null != populationCatalog.getStatisticListSetting()) {
			if ("".equals(domainName) || null == domainName) {
				statisticSearchVo.setDomainName(populationCatalog
						.getStatisticListSetting().getDomainName());
			} else {
				statisticSearchVo.setDomainName(domainName);
			}
			String tableName = "";
			for (PopulationCatalog pc : list) {
				if (ShardTables.SHARD_HOUSEHOLDSTAFFS.equalsIgnoreCase(pc
						.getStatisticListSetting().getTableName())
						&& !shardConversion.isOverCity(organization)) {
					String shardCode = shardConversion.getShardCode(orgId);
					tableName += pc.getStatisticListSetting().getTableName()
							+ "_" + shardCode;
				} else {
					tableName += pc.getStatisticListSetting().getTableName();
				}
				tableName += ",";
			}
			statisticSearchVo.setTable(tableName.substring(0,
					tableName.length() - 1));
			statisticSearchVo.setPropertyField(populationCatalog
					.getStatisticListSetting().getPropertyField());
			statisticSearchVo.setCountFieldMap(populationCatalog
					.getStatisticListSetting().getCountMap());
		}
		statisticSearchVo.setOrgId(orgId);
		return statisticSearchVo;
	}

	private List getYouthByType(StatisticSearchVo statisticSearchVo) {
		List<PropertyDict> dicts = propertyDictService
				.findPropertyDictByDomainName(statisticSearchVo.getDomainName());
		List<Map<String, Object>> baseLists = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < dicts.size(); i++) {
			PropertyDict dict = dicts.get(i);
			if (PropertyTypes.OTHER_YOUNGS.equals(dict.getDisplayName())) {
				statisticSearchVo.setPropertyDict(null);
			} else if (!PropertyTypes.YOUNG_MEMBERS.equals(dict
					.getDisplayName())
					&& !PropertyTypes.YOUNG_PIONEERS.equals(dict
							.getDisplayName())) {
				continue;
			} else {
				statisticSearchVo.setPropertyDict(dict);
			}
			statisticSearchVo.setDisplayName(dict.getDisplayName());
			statisticSearchVo.setOrgType(getOrgType(statisticSearchVo));
			List<Map<String, Object>> subList = new ArrayList<Map<String, Object>>();
			subList = baseInfoStatisticsNewDao
					.countYouthByType(statisticSearchVo);
			baseLists.addAll(subList);
		}
		for (int i = 0, countValue = 0; i < baseLists.size(); i++) {
			Map otherYoungsMap = new HashMap<String, Object>();
			if (!PropertyTypes.OTHER_YOUNGS.equals(baseLists.get(i).get(
					"TYPENAME"))) {
				countValue -= Integer.valueOf(((BigDecimal) baseLists.get(i)
						.get("SUMNUM")).toString());
			} else {
				otherYoungsMap = baseLists.get(i);
				countValue += Integer.valueOf(((BigDecimal) baseLists.get(i)
						.get("SUMNUM")).toString());
			}
			if (i == baseLists.size() - 1) {
				otherYoungsMap.put("SUMNUM", BigDecimal.valueOf(countValue));
			}
		}
		return baseLists;
	}

	private List getYouthListByPoliticalBackGround(
			StatisticSearchVo statisticSearchVo) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		List<PropertyDict> dicts = propertyDictService
				.findPropertyDictByDomainName(statisticSearchVo.getDomainName());
		for (int i = 0; i < dicts.size(); i++) {
			PropertyDict dict = dicts.get(i);
			if (!PropertyTypes.YOUNG_MEMBERS.equals(dict.getDisplayName())
					&& !PropertyTypes.YOUNG_PIONEERS.equals(dict
							.getDisplayName())) {
				continue;
			}
			statisticSearchVo.setPropertyDict(dict);
			mapList.addAll(baseInfoStatisticsNewDao
					.getYouthRealTimeCountGroupByType(statisticSearchVo));
		}
		int total = Integer.parseInt(String.valueOf(baseInfoStatisticsNewDao
				.getTotalYouthByOrgCode(statisticSearchVo)));
		int exceptOthers = 0;
		for (Map map : mapList) {
			exceptOthers += Integer.valueOf(((BigDecimal) map.get("COUNTNUM"))
					.toString());
		}
		Map<String, Object> totalOthers = new HashMap<String, Object>();
		totalOthers.put("DISPLAYNAME", PropertyTypes.OTHER_YOUNGS);
		totalOthers.put("COUNTNUM", BigDecimal.valueOf(total - exceptOthers));
		mapList.add(totalOthers);
		return mapList;
	}

	private Long getOrgType(StatisticSearchVo statisticSearchVo) {
		return propertyDictService
				.findPropertyDictByDomainNameAndInternalId(
						statisticSearchVo.getOrganizationType(),
						OrganizationType.ADMINISTRATIVE_REGION).get(0).getId();
	}

	private Long getPropertyDomainId(StatisticSearchVo statisticSearchVo) {
		Long domainId = null;
		if (StringUtil.isStringAvaliable(statisticSearchVo.getDomainName())) {
			domainId = propertyDomainService.getPropertyDomainByDomainName(
					statisticSearchVo.getDomainName()).getId();
		}
		return domainId;
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

	/***
	 * 获得行政部门的字典ID
	 * 
	 * @return
	 */
	private Long getAdminsOrgType() {
		Long orgType = propertyDictService
				.findPropertyDictByDomainNameAndInternalId(
						PropertyTypes.ORGANIZATION_TYPE,
						OrganizationType.ADMINISTRATIVE_REGION).get(0).getId();
		return orgType;
	}
}

package com.tianque.plugin.analyzing.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tianque.baseInfo.utils.CustomDateUtil;
import com.tianque.baseInfo.youths.vo.SearchYouthsVo;
import com.tianque.core.base.AbstractBaseDao;
import com.tianque.core.util.BaseInfoTables;
import com.tianque.core.util.CalendarUtil;
import com.tianque.plugin.analyzing.domain.StatisticsBaseInfoAddCountVo;

@Repository("leaderViewDao")
public class LeaderViewDaoImpl extends AbstractBaseDao implements LeaderViewDao {

	@Override
	public StatisticsBaseInfoAddCountVo personGeneralConditionForMobile(
			String orgInternalCode, Date today, Date nextDay, Date monthStart,
			Date nextMonthStart, String tableName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgInternalCode", orgInternalCode);
		map.put("today", today);
		map.put("nextDateStart", nextDay);
		map.put("monthStart", monthStart);
		map.put("nextMonthStart", nextMonthStart);
		map.put("tableName", tableName);

		return (StatisticsBaseInfoAddCountVo) getSqlMapClientTemplate()
				.queryForObject(
						"statisticsBaseInfoAddCount.personGeneralCondition",
						map);
	}

	@Override
	public StatisticsBaseInfoAddCountVo statisticsBaseInfoSummary(
			String orgInternalCode, String time, String tableName, int year,
			int month) {
		Map<String, Object> map = new HashMap<String, Object>();
		// if(tableName.equals(BaseInfoTables.getTypeValue(BaseInfoTables.FIRESAFETYKEY_KEY))
		// ||
		// tableName.equals(BaseInfoTables.getTypeValue(BaseInfoTables.SAFETYPRODUCTIONKEY_KEY))
		// ||
		// tableName.equals(BaseInfoTables.getTypeValue(BaseInfoTables.SECURITYKEY_KEY))||
		// tableName.equals(BaseInfoTables.getTypeValue(BaseInfoTables.ENTERPRISEKEY_KEY))){
		// map.put("tableName", "enterprises");
		map.put("keyType", tableName);
		// }else{
		// map.put("tableName", tableName);
		// map.put("keyType", null);
		// }
		map.put("orgInternalCode", orgInternalCode);
		map.put("time", time);
		map.put("year", year);
		map.put("month", month);
		StatisticsBaseInfoAddCountVo vo = new StatisticsBaseInfoAddCountVo();
		vo = (StatisticsBaseInfoAddCountVo) getSqlMapClientTemplate()
				.queryForObject(
						"statisticsBaseInfoAddCount.statisticsBaseInfoSummary",
						map);
		return vo;
	}

	@Override
	public StatisticsBaseInfoAddCountVo statisticsPopulationSummary(
			String orgInternalCode, String time, String tableName, int year,
			int month) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyType", tableName);
		map.put("orgInternalCode", orgInternalCode);
		map.put("time", time);
		map.put("year", year);
		map.put("month", month);
		StatisticsBaseInfoAddCountVo vo = new StatisticsBaseInfoAddCountVo();
		try {
			vo = (StatisticsBaseInfoAddCountVo) getSqlMapClientTemplate()
					.queryForObject(
							"statisticsBaseInfoAddCount.statisticsPopulationSummary",
							map);
		} catch (Exception e) {
			logger.error("statisticsPopulationSummary", e);
		}
		return vo;
	}

	public StatisticsBaseInfoAddCountVo statisticsSummary(
			String orgInternalCode, String time, String tableType, int year,
			int month) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyType", tableType);
		map.put("orgInternalCode", orgInternalCode);
		map.put("time", time);
		map.put("year", year);
		map.put("month", month);
		StatisticsBaseInfoAddCountVo vo = new StatisticsBaseInfoAddCountVo();
		List<StatisticsBaseInfoAddCountVo> list = getSqlMapClientTemplate()
				.queryForList("statisticsBaseInfoAddCount.statisticsSummary",
						map);
		vo = processStatisticsBaseInfoAddCountList(list);
		return vo;
	}

	private StatisticsBaseInfoAddCountVo processStatisticsBaseInfoAddCountList(
			List<StatisticsBaseInfoAddCountVo> list) {
		StatisticsBaseInfoAddCountVo vo = new StatisticsBaseInfoAddCountVo();
		if (list == null || list.size() == 0) {
			return vo;
		}
		return list.get(0);
		/*
		 * String statisticsType = null; int thisMonthCountTotal=0; int
		 * attentionCountTotal=0; int allCountTotal=0; int temp=0; for(int
		 * i=0;i<list.size();i++){ temp = i; if(temp != 0){
		 * if(statisticsType.equals(list.get(i).getStatisticsType())){
		 * statisticsType = list.get(i).getStatisticsType(); continue; } }
		 * statisticsType = list.get(i).getStatisticsType(); thisMonthCountTotal
		 * += list.get(i).getThisMonthCount(); attentionCountTotal
		 * +=list.get(i).getAttentionCount(); allCountTotal +=
		 * list.get(i).getAllCount(); }
		 * vo.setAttentionCount(attentionCountTotal);
		 * vo.setThisMonthCount(thisMonthCountTotal);
		 * vo.setAllCount(allCountTotal); return vo;
		 */
	}

	@Override
	public StatisticsBaseInfoAddCountVo personGeneralCondition(
			String orgInternalCode, Date today, Date nextDate, Date monthStart,
			Date nextMonth, String tableName, String column, String shardCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (tableName.equals(BaseInfoTables
				.getTypeValue(BaseInfoTables.FIRESAFETYKEY_KEY))
				|| tableName.equals(BaseInfoTables
						.getTypeValue(BaseInfoTables.SAFETYPRODUCTIONKEY_KEY))
				|| tableName.equals(BaseInfoTables
						.getTypeValue(BaseInfoTables.SECURITYKEY_KEY))
				|| tableName.equals(BaseInfoTables
						.getTypeValue(BaseInfoTables.ENTERPRISEKEY_KEY))) {
			map.put("tableName", "enterprises");
			map.put("keyType", tableName);
		} else {
			map.put("tableName", tableName);
			map.put("keyType", null);
		}
		map.put("shardCode", shardCode);
		map.put("orgInternalCode", orgInternalCode);
		map.put("today", today);
		map.put("nextDateStart", nextDate);
		map.put("monthStart", monthStart);
		map.put("nextMonthStart", nextMonth);
		map.put("column", column);
		return (StatisticsBaseInfoAddCountVo) getSqlMapClientTemplate()
				.queryForObject(
						"statisticsBaseInfoAddCount.personGeneralCondition",
						map);
	}

	@Override
	public List<StatisticsBaseInfoAddCountVo> statisticsYouthsCount(
			SearchYouthsVo searchYouthsVo) {
		searchYouthsVo
				.setCurrentDate(CalendarUtil.format(CalendarUtil.today()));
		searchYouthsVo.setCurrentYearMonth(CalendarUtil.format("yyyy-MM",
				CalendarUtil.now("yyyy-MM")));
		// searchYouthsVo.setNowDate(CalendarUtil.now());
		searchYouthsVo.setStartBirthday(CustomDateUtil
				.dateBeforeNowDateByMonth(searchYouthsVo.getBeginAge() * 12));
		searchYouthsVo.setEndBirthday(CustomDateUtil
				.dateBeforeNowDateByMonth(searchYouthsVo.getEndAge() * 12));

		return getSqlMapClientTemplate().queryForList(
				"statisticsBaseInfoAddCount.statisticsYouthsCount",
				searchYouthsVo);
	}

	@Override
	public StatisticsBaseInfoAddCountVo statisticsYouthSummary(
			String orgInternalCode, String keyType, int year, int month) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyType", keyType);
		map.put("orgInternalCode", orgInternalCode);
		map.put("year", year);
		map.put("month", month);
		StatisticsBaseInfoAddCountVo vo = new StatisticsBaseInfoAddCountVo();
		try {
			vo = (StatisticsBaseInfoAddCountVo) getSqlMapClientTemplate()
					.queryForObject(
							"statisticsBaseInfoAddCount.statisticsYouthSummary",
							map);
		} catch (Exception e) {
			logger.error("statisticsYouthSummary", e);
		}
		return vo;
	}

	@Override
	public List<StatisticsBaseInfoAddCountVo> statisticsBaseInfoAddCountByOrg(
			String tableName, String column, String orginternalcode,
			String shardCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (tableName.equals(BaseInfoTables
				.getTypeValue(BaseInfoTables.FIRESAFETYKEY_KEY))
				|| tableName.equals(BaseInfoTables
						.getTypeValue(BaseInfoTables.SAFETYPRODUCTIONKEY_KEY))
				|| tableName.equals(BaseInfoTables
						.getTypeValue(BaseInfoTables.SECURITYKEY_KEY))
				|| tableName.equals(BaseInfoTables
						.getTypeValue(BaseInfoTables.ENTERPRISEKEY_KEY))
				|| tableName.equals(BaseInfoTables
						.getTypeValue(BaseInfoTables.ENTERPRISEDOWNKEY_KEY))) {
			map.put("tableName", "enterprises");
			map.put("keyType", tableName);
		} else {
			map.put("tableName", tableName);
			map.put("keyType", null);
		}
		/** 如果是流动人口，则增加涉藏、涉疆人员查询条件 */
		if (tableName.equals(BaseInfoTables
				.getTypeValue(BaseInfoTables.FLOATINGPOPULATION_KEY))) {
			// map.put("involveTibet", "西藏");
			map.put("involveSinkiang", "新疆维吾尔自治区");
		}
		map.put("shardCode", shardCode);
		map.put("tableName", tableName);
		map.put("column", column);
		map.put("orgInternalCode", orginternalcode);
		map.put("nowDate", CalendarUtil.format(CalendarUtil.today()));
		map.put("nowYearMonth",
				CalendarUtil.format("yyyy-MM", CalendarUtil.now("yyyy-MM")));
		if (tableName.equals(BaseInfoTables
				.getTypeValue(BaseInfoTables.FLOATINGPOPULATION_KEY))) {
			logger.error("执行特别的" + tableName + "的job的sql。");
			return getSqlMapClientTemplate()
					.queryForList(
							"statisticsBaseInfoAddCount.statisticsFloatingPopulationsAddCountByOrg",
							map);
		}
		if (tableName.equalsIgnoreCase("houseinfo")
				|| tableName.equalsIgnoreCase("rentalHouse")) {
			logger.error("执行特别的" + tableName + "的job的sql。");
			return getSqlMapClientTemplate()
					.queryForList(
							"statisticsBaseInfoAddCount.statisticsHouseinfoAddCountByOrg",
							map);
		}
		logger.error("执行" + tableName + shardCode + "的job的sql。");
		return getSqlMapClientTemplate().queryForList(
				"statisticsBaseInfoAddCount.statisticsBaseInfoAddCountByOrg",
				map);
	}

	@Override
	public List<StatisticsBaseInfoAddCountVo> getPopulationInfoByDate(
			Long orgId, int year, int month, String populationType, Long orgType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		map.put("year", year);
		map.put("month", month);
		map.put("populationType", populationType);
		map.put("orgType", orgType);
		return (List<StatisticsBaseInfoAddCountVo>) getSqlMapClientTemplate()
				.queryForList(
						"statisticsBaseInfoAddCount.getPopulationInfoByDate",
						map);
	}

}

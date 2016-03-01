package com.tianque.plugin.analyzing.domain;

import com.tianque.core.base.BaseDomain;
import com.tianque.domain.Organization;

public class BaseSituationStatement extends BaseDomain {
	private Organization organization;// 组织机构
	private int preventionCount;// 截止上月总数群防群治组织人数
	private int floatingPersionCount;// 截止上月流口数
	private int positivePersionCount;// 截止上月总数刑释人员
	private int rectificativePersonCount;// 截止上月总数矫正人员
	private int mentalPatientPersionCount;// 截止上月总数精神病
	private int druggyPersionCount;// 截止上月总数吸毒人员
	private int idleYouthCount;// 截止上月总数重点青少年
	private String statisticsData;
	private int year;
	private int month;
	private Integer statisticsType;// 报表类型 1：报表1 2：报表2

	// 2015-3-19更改
	private int countyCount;// 区县数量
	private int functionDepartmentCount;// 职能部门加入数量
	private int specialCrowdCount;// 特殊人群走访数量

	private int currentFloatingPersionCount;// 本月流口净产量
	private int currentPositivePersionCount;// 本月刑释人员净产量
	private int currentRectificativePersonCount;// 本月矫正人员净产量
	private int currentMentalPatientPersionCount;// 本月精神病净产量
	private int currentDruggyPersionCount;// 本月吸毒人员净产量
	private int currentIdleYouthCount;// 本月重点青少年净产量
	private int currentPreventionCount;// 本月群防群治人数净产量

	private int floatingPersionAddCount;// 本月流口新增量
	private int positivePersionAddCount;// 本月刑释人员新增量
	private int rectificativePersonAddCount;// 本月矫正人员新增量
	private int mentalPatientPersionAddCount;// 本月精神病新增量
	private int druggyPersionAddCount;// 本月吸毒人员新增量
	private int idleYouthAddCount;// 本月重点青少年新增量
	private int preventionAddCount;// 本月群防群治人数新增量

	/** 以下两个参数是2015.6.9日唐杰报表需求更改增加的 */
	private int agencyOfOpinionCount;// 本月社情民意收集数量
	private int issueDealCount;// 本月事件处理总数量

	public int getAgencyOfOpinionCount() {
		return agencyOfOpinionCount;
	}

	public void setAgencyOfOpinionCount(int agencyOfOpinionCount) {
		this.agencyOfOpinionCount = agencyOfOpinionCount;
	}

	public int getIssueDealCount() {
		return issueDealCount;
	}

	public void setIssueDealCount(int issueDealCount) {
		this.issueDealCount = issueDealCount;
	}

	public int getFloatingPersionAddCount() {
		return floatingPersionAddCount;
	}

	public void setFloatingPersionAddCount(int floatingPersionAddCount) {
		this.floatingPersionAddCount = floatingPersionAddCount;
	}

	public int getPositivePersionAddCount() {
		return positivePersionAddCount;
	}

	public void setPositivePersionAddCount(int positivePersionAddCount) {
		this.positivePersionAddCount = positivePersionAddCount;
	}

	public int getRectificativePersonAddCount() {
		return rectificativePersonAddCount;
	}

	public void setRectificativePersonAddCount(int rectificativePersonAddCount) {
		this.rectificativePersonAddCount = rectificativePersonAddCount;
	}

	public int getMentalPatientPersionAddCount() {
		return mentalPatientPersionAddCount;
	}

	public void setMentalPatientPersionAddCount(int mentalPatientPersionAddCount) {
		this.mentalPatientPersionAddCount = mentalPatientPersionAddCount;
	}

	public int getDruggyPersionAddCount() {
		return druggyPersionAddCount;
	}

	public void setDruggyPersionAddCount(int druggyPersionAddCount) {
		this.druggyPersionAddCount = druggyPersionAddCount;
	}

	public int getIdleYouthAddCount() {
		return idleYouthAddCount;
	}

	public void setIdleYouthAddCount(int idleYouthAddCount) {
		this.idleYouthAddCount = idleYouthAddCount;
	}

	public int getPreventionAddCount() {
		return preventionAddCount;
	}

	public void setPreventionAddCount(int preventionAddCount) {
		this.preventionAddCount = preventionAddCount;
	}

	public Organization getOrganization() {
		return organization;
	}

	public int getFloatingPersionCount() {
		return floatingPersionCount;
	}

	public void setFloatingPersionCount(int floatingPersionCount) {
		this.floatingPersionCount = floatingPersionCount;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public int getPreventionCount() {
		return preventionCount;
	}

	public void setPreventionCount(int preventionCount) {
		this.preventionCount = preventionCount;
	}

	public int getPositivePersionCount() {
		return positivePersionCount;
	}

	public void setPositivePersionCount(int positivePersionCount) {
		this.positivePersionCount = positivePersionCount;
	}

	public int getRectificativePersonCount() {
		return rectificativePersonCount;
	}

	public void setRectificativePersonCount(int rectificativePersonCount) {
		this.rectificativePersonCount = rectificativePersonCount;
	}

	public int getMentalPatientPersionCount() {
		return mentalPatientPersionCount;
	}

	public void setMentalPatientPersionCount(int mentalPatientPersionCount) {
		this.mentalPatientPersionCount = mentalPatientPersionCount;
	}

	public int getDruggyPersionCount() {
		return druggyPersionCount;
	}

	public void setDruggyPersionCount(int druggyPersionCount) {
		this.druggyPersionCount = druggyPersionCount;
	}

	public int getIdleYouthCount() {
		return idleYouthCount;
	}

	public void setIdleYouthCount(int idleYouthCount) {
		this.idleYouthCount = idleYouthCount;
	}

	public String getStatisticsData() {
		return statisticsData;
	}

	public void setStatisticsData(String statisticsData) {
		this.statisticsData = statisticsData;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Integer getStatisticsType() {
		return statisticsType;
	}

	public void setStatisticsType(Integer statisticsType) {
		this.statisticsType = statisticsType;
	}

	public int getCountyCount() {
		return countyCount;
	}

	public void setCountyCount(int countyCount) {
		this.countyCount = countyCount;
	}

	public int getFunctionDepartmentCount() {
		return functionDepartmentCount;
	}

	public void setFunctionDepartmentCount(int functionDepartmentCount) {
		this.functionDepartmentCount = functionDepartmentCount;
	}

	public int getSpecialCrowdCount() {
		return specialCrowdCount;
	}

	public void setSpecialCrowdCount(int specialCrowdCount) {
		this.specialCrowdCount = specialCrowdCount;
	}

	public int getCurrentFloatingPersionCount() {
		return currentFloatingPersionCount;
	}

	public void setCurrentFloatingPersionCount(int currentFloatingPersionCount) {
		this.currentFloatingPersionCount = currentFloatingPersionCount;
	}

	public int getCurrentPositivePersionCount() {
		return currentPositivePersionCount;
	}

	public void setCurrentPositivePersionCount(int currentPositivePersionCount) {
		this.currentPositivePersionCount = currentPositivePersionCount;
	}

	public int getCurrentRectificativePersonCount() {
		return currentRectificativePersonCount;
	}

	public void setCurrentRectificativePersonCount(
			int currentRectificativePersonCount) {
		this.currentRectificativePersonCount = currentRectificativePersonCount;
	}

	public int getCurrentMentalPatientPersionCount() {
		return currentMentalPatientPersionCount;
	}

	public void setCurrentMentalPatientPersionCount(
			int currentMentalPatientPersionCount) {
		this.currentMentalPatientPersionCount = currentMentalPatientPersionCount;
	}

	public int getCurrentDruggyPersionCount() {
		return currentDruggyPersionCount;
	}

	public void setCurrentDruggyPersionCount(int currentDruggyPersionCount) {
		this.currentDruggyPersionCount = currentDruggyPersionCount;
	}

	public int getCurrentIdleYouthCount() {
		return currentIdleYouthCount;
	}

	public void setCurrentIdleYouthCount(int currentIdleYouthCount) {
		this.currentIdleYouthCount = currentIdleYouthCount;
	}

	public int getCurrentPreventionCount() {
		return currentPreventionCount;
	}

	public void setCurrentPreventionCount(int currentPreventionCount) {
		this.currentPreventionCount = currentPreventionCount;
	}

}
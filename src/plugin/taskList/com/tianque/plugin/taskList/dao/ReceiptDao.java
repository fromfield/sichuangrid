package com.tianque.plugin.taskList.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tianque.plugin.taskList.domain.BaseTaskVisit;
import com.tianque.plugin.taskList.domain.FloatingPopulationTask;
import com.tianque.plugin.taskList.domain.HiddenDangerTask;
import com.tianque.plugin.taskList.domain.Receipt;
import com.tianque.plugin.taskList.domain.TaskListStatistics;

/**
 * 任务清单签收
 * 
 * @author lanhaifeng
 * 
 */
public interface ReceiptDao {
	/**
	 * 
	 * @param receipt
	 *            签收信息
	 */
	public void updateReceiptStatus(Receipt receipt, String signType);

	/**
	 * 任务清单报表数据
	 * @param orgType
	 * @param orgId
	 * @return
	 */
	public List<BaseTaskVisit> getTaskSumAndVisitByParentOrgId(Map<String,Object> map);

	/**
	 * 流动人口报表数据
	 * @param orgType
	 * @param orgId
	 * @return
	 */
	public List<FloatingPopulationTask> getFloatingPopulationVisitByParentOrgId(Map<String,Object> map);

	/**
	 * 发现治安隐患报表数据
	 * @param orgType
	 * @param orgId
	 * @return
	 */
	public List<HiddenDangerTask> getHiddenDangerVisitByParentOrgId(Map<String,Object> map);

	/**
	 * 特殊人群统计报表数据获取
	 * @param orgType 组织层级类型
	 * @param orgId 组织层级id
	 * @return
	 */
	public List<BaseTaskVisit> getSpecialGroupSumAndVisitList(Map<String,Object> map);
	/***
	 * 任务清单新报表数据查询
	 */
	public List<TaskListStatistics> getTaskListStatistics(Map<String,Object> map);
}

package com.tianque.job.persistenceJob;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tianque.job.JobHelper;
import com.tianque.plugin.analysisNew.service.LeaderViewNewService;
import com.tianque.plugin.analysisNew.util.AnalyseUtilNew;
import com.tianque.plugin.analyzing.service.LeaderViewService;
import com.tianque.sysadmin.service.JobMonitorService;

/**
 * @Description:生成房屋的领导视图历史月份job每个月跑一次并且生成后的数据存入缓存表里面（县级以上的数据）
 * @author zhangyouwei@hztianque.com
 * @date: 2015-4-7 下午04:30:55
 */
@Component("houseLeaderViewSummaryCountDispatch")
public class HouseLeaderViewSummaryCountDispatch implements Serializable {
	private static Logger logger = LoggerFactory
			.getLogger(HouseLeaderViewSummaryCountDispatch.class);
	@Autowired
	private LeaderViewService leaderViewService;
	@Autowired
	private LeaderViewNewService leaderViewNewService;

	@Autowired
	private JobMonitorService jobMonitorService;

	public void createHouseLeaderViewSummaryData() {
		JobHelper.createMockAdminSession();
		Long id = jobMonitorService.addJobMonitor(this.getClass().getName());
		try {
			logger.error("生成房屋的领导视图历史月份job开始执行");
			long startTime = System.currentTimeMillis();
			if (AnalyseUtilNew.IS_NEWANALYSE_JOB) {
				leaderViewNewService.createHouseLeaderViewSummaryData();
			} else {

				leaderViewService.createHouseLeaderViewSummaryData();
			}
			jobMonitorService.updateJobMonitor(id,
					"花了" + (System.currentTimeMillis() - startTime)
							+ "执行生成房屋的领导视图历史月份job", true);
			logger.error("生成房屋的领导视图历史月份job执行完成");
		} catch (Exception e) {
			logger.error("生成房屋的领导视图历史月份job出现异常：", e);
			jobMonitorService.updateJobMonitor(id, "执行生成房屋的领导视图历史月份job出现异常："
					+ e.getMessage(), false);
		}
	}
}

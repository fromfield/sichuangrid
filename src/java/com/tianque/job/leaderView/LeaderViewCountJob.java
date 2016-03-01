package com.tianque.job.leaderView;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tianque.job.JobHelper;
import com.tianque.plugin.analyzing.service.LeaderViewService;
import com.tianque.sysadmin.service.JobMonitorService;

@Component("leaderViewCountJob")
public class LeaderViewCountJob implements Job {
	private final static Logger logger = LoggerFactory
			.getLogger(LeaderViewCountJob.class);
	@Autowired
	private LeaderViewService leaderViewService;
	@Autowired
	private JobMonitorService jobMonitorService;
	private boolean run;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		leaderViewHourMessage();
	}

	public void leaderViewHourMessage() {
		JobHelper.createMockAdminSession();
		Long id = jobMonitorService.addJobMonitor(this.getClass().getName());
		logger.error("开始执行leaderViewCountJob。");
		synchronized (logger) {
			if (run) {
				jobMonitorService.updateJobMonitor(id, "上一次任务未执行完毕", false);
				return;
			}
			run = true;
			logger.error("判断是否上次执行结束。");
		}
		try {
			long startTime = System.currentTimeMillis();
			leaderViewService.statisticsPopulationAddCountByOrgIdForJob();
			jobMonitorService.updateJobMonitor(id,
					"花了" + (System.currentTimeMillis() - startTime)
							+ "执行人口模型领导视图job", true);
		} catch (Exception e) {
			logger.error("", e);
			jobMonitorService.updateJobMonitor(id,
					"执行人口模型领导视图job出现异常：" + e.getMessage(), false);
		} finally {
			run = false;
		}
	}
}

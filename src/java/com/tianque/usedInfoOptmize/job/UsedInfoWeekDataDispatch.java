package com.tianque.usedInfoOptmize.job;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tianque.sysadmin.service.JobMonitorService;
import com.tianque.usedInfoOptmize.service.UsedInfoDataService;

/**
 * @Description:信息系统使用情况周数据生成
 * @author zhangyouwei@hztianque.com
 * @date: 2015-7-1 下午02:22:13
 */
@Component("usedInfoWeekDataDispatch")
public class UsedInfoWeekDataDispatch implements Serializable {
	private static Logger logger = LoggerFactory
			.getLogger(UsedInfoWeekDataDispatch.class);
	@Autowired
	private JobMonitorService jobMonitorService;
	@Autowired
	private UsedInfoDataService usedInfoDataService;

	public void createUsedInfoWeekData() {
		Long id = jobMonitorService.addJobMonitor(this.getClass().getName());
		try {
			long startTime = System.currentTimeMillis();
			logger.error("执行信息系统使用情况周数据生成job开始执行");
			usedInfoDataService.createUsedInfoWeekData();
			jobMonitorService.updateJobMonitor(id,
					"花了" + (System.currentTimeMillis() - startTime)
							+ "执行信息系统使用情况周数据生成job", true);
			logger.error("执行信息系统使用情况周数据生成job完成");
		} catch (Exception e) {
			logger.error("信息系统使用情况周数据生成job出现异常：", e);
			jobMonitorService.updateJobMonitor(id,
					"信息系统使用情况周数据生成job出现异常：" + e.getMessage(), false);
		}
	}
}

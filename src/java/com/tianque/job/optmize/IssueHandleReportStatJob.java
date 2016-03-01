package com.tianque.job.optmize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taobao.pamirs.schedule.TaskItemDefine;
import com.tianque.core.util.CalendarUtil;
import com.tianque.domain.property.ReportDateType;
import com.tianque.job.JobHelper;
import com.tianque.plugin.tbSchedule.IScheduleTaskDealSingleBase;
import com.tianque.plugin.tbSchedule.constant.ScheduleNameConstant;
import com.tianque.statAnalyse.issueManage.listManage.constant.QueryType;
import com.tianque.statAnalyse.issueManage.listManage.service.IssueReportService;
import com.tianque.statRegrad.util.RegradedPointUtil;

/**
 * <pre>
 * @author: bing
 * @date: 2014年11月12日 上午10:11:28
 * @company: tianque
 * @version: 1.0
 * @Mail: yangbing@hztianque.com
 * 
 * 办理情况 job
 * </pre>
 * 
 */
@Component("issueHandleReportStatJob")
public class IssueHandleReportStatJob extends IScheduleTaskDealSingleBase<Long> {
	@Autowired
	private IssueReportService issueReportService;

	@Override
	public Comparator getComparator() {// 多个处理时 有用
		return null;
	}

	@Override
	public List<Long> queryTasks(String taskParameter, String ownSign,
			int taskItemNum, List<TaskItemDefine> queryCondition, int fetchNum)
			throws Exception {
		JobHelper.createMockAdminSession();
		List<Long> idModList = new ArrayList<Long>();
		for (int i = 0; i < queryCondition.size(); i++) {
			String taskItemId = ((TaskItemDefine) queryCondition.get(i))
					.getTaskItemId();
			if (taskItemId != null && !"".equals(taskItemId.trim())) {
				idModList.add(Long.parseLong(taskItemId.trim()));
			}
		}
		List<Long> result = issueReportService.findOrgByCondition(taskItemNum,
				idModList, fetchNum, CalendarUtil.getNowYear(),
				CalendarUtil.getNowMonth(), QueryType.ISSUE_HANDLE_STAT_TAB);
		return result;
	}

	@Override
	public boolean execute(Long taskId, String ownSign) throws Exception {
		JobHelper.createMockAdminSession();
		Map<String, Date> date = RegradedPointUtil.getStartDateAndEndDate(
				CalendarUtil.getNowYear(), CalendarUtil.getNowMonth(),
				ReportDateType.GROUPBYMONTH_KEY);
		issueReportService.addIssueHandleStats(date, taskId,null);
		return true;
	}

	@Override
	public void callBack() {
	}

	@Override
	public String getJobRemark() {
		return ScheduleNameConstant.ISSUE_HANDLE_REPORTSTAT_JOB_REMARK;
	}

}

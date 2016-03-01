package com.tianque.plugin.taskList.service;

import java.util.List;

import com.tianque.core.vo.PageInfo;
import com.tianque.plugin.taskList.domain.ExceptionalSituationRecord;
import com.tianque.plugin.taskList.domain.ExceptionalSituationRecordVo;

/**
 * 异常情况记录业务层
 * 任务清单使用
 * @author lanhaifeng
 *
 */
public interface ExceptionalSituationRecordService {
	/**
	 * 新增记录信息
	 * 
	 * @param exceptionalSituationRecord
	 *            记录信息domain
	 * @return ExceptionalSituationRecord
	 */
	public void addExceptionalSituationRecord(ExceptionalSituationRecord exceptionalSituationRecord,String[] attachFile,String[] attachFiles,String[] attachFileNames);

	/**
	 * 返回单个记录
	 * 
	 * @param id  记录id
	 * @return ExceptionalSituationRecord
	 */
	public ExceptionalSituationRecord getExceptionalSituationRecordById(Long id);

	/**
	 * 获取记录分页数
	 * 
	 * @param exceptionalSituationRecordVo 查询domain
	 * @param pageNum
	 * @param pageSize
	 * @return PageInfo
	 */
	public PageInfo<ExceptionalSituationRecord> findExceptionalSituationRecords(
			ExceptionalSituationRecordVo exceptionalSituationRecordVo, Integer pageNum, 
			Integer pageSize, String sidx, String sord);

	/**
	 * 更新记录信息
	 * 
	 * @param exceptionalSituationRecord   记录信息domain
	 * @return ExceptionalSituationRecord
	 */
	public ExceptionalSituationRecord updateExceptionalSituationRecord(ExceptionalSituationRecord exceptionalSituationRecord);

	/**
	 * 删除记录
	 * 
	 * @param ids 记录id数组
	 * @return Integer 删除条数
	 */
	public Integer deleteExceptionalSituationRecords(List<Long> ids);
	
}

package com.tianque.plugin.taskList.dao;

import java.util.List;

import com.tianque.core.vo.PageInfo;
import com.tianque.plugin.taskList.domain.PositiveInfoRecord;
import com.tianque.plugin.taskList.domain.PositiveInfoRecordVo;

/**
 * 刑释人员记录
 * 任务清单使用
 * @author lanhaifeng
 *
 */
public interface PositiveInfoRecordDao{
	/**
	 * 新增记录信息
	 * 
	 * @param PositiveInfoRecord
	 *            记录信息domain
	 * @return PositiveInfoRecord
	 */
	public PositiveInfoRecord addPositiveInfoRecord(PositiveInfoRecord positiveInfoRecord);

	/**
	 * 返回单个记录
	 * 
	 * @param id  记录id
	 * @return PositiveInfoRecord
	 */
	public PositiveInfoRecord getPositiveInfoRecordById(Long id);

	/**
	 * 获取记录分页数
	 * 
	 * @param positiveInfoRecordVo 查询domain
	 * @param pageNum
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @return PageInfo
	 */
	public PageInfo<PositiveInfoRecord> findPositiveInfoRecords(
			PositiveInfoRecordVo positiveInfoRecordVo, Integer pageNum, Integer pageSize,String sidx, String sord);

	/**
	 * 获取记录条数
	 * @param positiveInfoRecord  查询domain
	 * @return
	 */
	public Integer countPositiveInfoRecords(PositiveInfoRecord positiveInfoRecord);

	/**
	 * 更新记录信息
	 * 
	 * @param positiveInfoRecord   记录信息domain
	 * @return PositiveInfoRecord
	 */
	public PositiveInfoRecord updatePositiveInfoRecord(PositiveInfoRecord positiveInfoRecord);

	/**
	 * 删除记录
	 * 
	 * @param ids  记录id数组
	 * @return Integer 删除条数
	 */
	public Integer deletePositiveInfoRecords(List<Long> ids);
	
	/**
	 * 根据姓名获取记录
	 * 
	 * @param positiveInfoRecordVo 查询domain
	 * @return List
	 */
	public List<PositiveInfoRecord> findPositiveInfoRecordsByName(PositiveInfoRecordVo positiveInfoRecordVo);
	
	/**
	 * 人口信息特殊人群走访记录转移处理
	 * 
	 */
	public void updateTransferPositiveInfoRecord(Long id,Long orgId,String orgCode);

}

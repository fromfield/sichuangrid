package com.tianque.plugin.taskList.dao;

import java.util.List;

import com.tianque.core.vo.PageInfo;
import com.tianque.plugin.taskList.domain.HiddenDanger;
import com.tianque.plugin.taskList.domain.HiddenDangerVo;

/**
 * 发现隐患模块dao层
 * 
 * @author GAOHU
 *
 */
public interface HiddenDangerDao {

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public HiddenDanger getHiddenDangerById(Long id);

	/**
	 * 新增
	 * 
	 * @param hiddenDanger
	 * @return
	 */
	public HiddenDanger addHiddenDanger(HiddenDanger hiddenDanger);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public void deleteHiddenDanger(List<Long> ids);

	/**
	 * 更新
	 * 
	 * @param hiddenDanger
	 * @return
	 */
	public HiddenDanger updateHiddenDanger(HiddenDanger hiddenDanger);

	/**
	 * 查询
	 * 
	 * @param hiddenDangerVo
	 * @param pageNum
	 * @param pageSize
	 * @param sortField
	 * @param order
	 * @return
	 */
	public PageInfo<HiddenDanger> searchHiddenDanger(HiddenDangerVo hiddenDangerVo,
			Integer pageNum, Integer pageSize, String sortField, String order);
    
	/**
	 * 更新签发字段
	 * 
	 * @param hiddenDanger
	 * @return
	 */
	public HiddenDanger updateHiddenDangerSignDetail(HiddenDanger hiddenDanger);

}

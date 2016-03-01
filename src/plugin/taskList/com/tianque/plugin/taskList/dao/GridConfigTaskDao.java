package com.tianque.plugin.taskList.dao;

import java.util.List;
import java.util.Map;

import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Organization;
import com.tianque.plugin.taskList.domain.OrgTreeNode;

public interface GridConfigTaskDao {

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
	public PageInfo<Organization> findGridConfigTasks(
			Long parentId,Long orgType, Integer pageNum,
			Integer pageSize, String sortField, String order);
	
	/**
	 * 查询登录账号是否有配置职能部门配置清单
	 * @return
	 */
	public Long countHasGridTaskList(Long orgId,String tableName);
	
	/**
	 * 加载职能部门配置清单树
	 */
	public List<Organization> getOrgSelectComponent(Long funOrgId,Long parentId,String tableName);

	/**
	 * 更据父id查询直属子级org
	 * @param pId
	 * @return
	 */
	public List<OrgTreeNode> getOrganizationTreeByParentId(Long pId);
	
	/**
	 * 更据orgids用sql批量插入选择的org数据
	 * @param map
	 */
	public void addGridConfigTaskByOrgids(Map<String, Object>map);
	/**
	 * 更据职能部门id查询选中的行政部门的id
	 * @param funOrgId
	 * @return
	 */
	public List<Long> getCheckedIds(Long funOrgId,String tableName);
	/**
	 * 更据职能部门id删除选中的行政部门的id
	 */
	public void deleteCheckedOrg(Long funOrgId,String tableName);

	/**
	 * 任务清单配置：查询职能部门by行政部门id，查表-GRIDCONFIGTASK
	 * @param areaOrgId
	 * @return
	 */
	public List<Long> getTaskListFunOrgIdByAreaOrgId(Long areaOrgId);
}

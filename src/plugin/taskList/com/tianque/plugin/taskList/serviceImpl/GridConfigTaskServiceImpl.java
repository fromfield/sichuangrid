package com.tianque.plugin.taskList.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exolab.core.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.tianque.controller.vo.OrganizationTreeData;
import com.tianque.core.vo.ExtTreeData;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.property.OrganizationType;
import com.tianque.domain.property.PropertyTypes;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.exception.base.ServiceValidationException;
import com.tianque.plugin.taskList.constants.Constants;
import com.tianque.plugin.taskList.dao.GridConfigTaskDao;
import com.tianque.plugin.taskList.domain.GridConfigTaskVo;
import com.tianque.plugin.taskList.domain.OrgTreeNode;
import com.tianque.core.cache.service.impl.MemCacheService;
import com.tianque.core.util.StringUtil;
import com.tianque.core.util.ThreadVariable;
import com.tianque.plugin.taskList.service.GridConfigTaskService;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.userAuth.api.PropertyDictDubboService;
@Transactional
@Service("gridConfigTaskService")
public class GridConfigTaskServiceImpl implements GridConfigTaskService {
	private static Logger logger = LoggerFactory
			.getLogger(GridConfigTaskServiceImpl.class);
	private static final String KEY="GRID_CONFIG_TASK_";
	private static final String HAS_CONFIG=KEY+"HAS_CONFIG_";
//	private static final String ORG_TREE=KEY+"ORG_TREE_";
	private static final String FUNORG_TREE=KEY+"FUNORG_TREE_";
	@Autowired
	private GridConfigTaskDao gridConfigTaskDao;
	@Autowired
	private PropertyDictDubboService propertyDictDubboService;

	@Autowired
	private OrganizationDubboService organizationDubboService;

	@Autowired
	private PropertyDictService propertyDictService;
	
	@Autowired
	private MemCacheService memCacheService;
	
	/* 
	 * 查询登录账号是否有配置职能部门配置清单
	 */
	@Override
	public Boolean isHasGridTaskList(String type) {
		String tableName = Constants.gridTableNameMap.get(type);
		if(!StringUtil.isStringAvaliable(type)){
			throw new BusinessValidationException("操作失败，未获得操作表");
		}
		Organization organization=ThreadVariable.getOrganization();
		String isHasConfigKey=HAS_CONFIG+type+organization.getId();
		if(memCacheService.get(isHasConfigKey)!=null){
			return (Boolean)memCacheService.get(isHasConfigKey);
		}
		PropertyDict dict=propertyDictDubboService.
				findPropertyDictByDomainNameAndDictDisplayName(OrganizationType.
						ORG_TYPE_KEY, OrganizationType.FUNCTION_KEY);
		if(!organization.getOrgType().getId().equals(dict.getId())){
			memCacheService.set(isHasConfigKey, false);
			return false;
		}
		
		Long num=gridConfigTaskDao.countHasGridTaskList(organization.getId(),tableName);
		if(num==null || num==0){
			memCacheService.set(isHasConfigKey, false);
			return false;
		}
		memCacheService.set(isHasConfigKey, true);
		return true;
	}
	
	/* 
	 * 加载职能部门配置清单树
	 */
	@Override
	public List<Organization> getOrgSelectComponent(Long parentId,String type) {
		String tableName = Constants.gridTableNameMap.get(type);
		if(!StringUtil.isStringAvaliable(type)){
			throw new BusinessValidationException("操作失败，未获得操作表");
		}
		Long funOrgId=ThreadVariable.getOrganization().getId();
		if(parentId==null){
			parentId=funOrgId;
		}
		List<Organization>organizations=gridConfigTaskDao.getOrgSelectComponent(funOrgId,parentId,tableName);
		return organizations;
	}
	
//	/* 
//	 * 加载职能部门配置清单树(异步)
//	 */
//	@Override
//	public List<ExtTreeData> ajaxOrgConfigTaskTree(Long parentId,PropertyDict orgType) {
//		List<Organization>organizations=getOrgSelectComponent(parentId);
//		if(organizations==null){
//			organizations=new ArrayList<Organization>();
//		}
//		List<ExtTreeData> extTreeDatas = new ArrayList<ExtTreeData>();
//		if(organizations.size()>0){
//			orgType=propertyDictDubboService.getPropertyDictById(organizations.get(0).getOrgLevel().getId());
//			
//		}
//		for(Organization organization:organizations){
//			organization.setOrgLevel(orgType);
//			extTreeDatas.add(new OrganizationTreeData(organization));
//		}
//		return extTreeDatas;
//	}
	
	/*
	 * 分页查询职能部门列表
	 */
	@Override
	public PageInfo<GridConfigTaskVo> findGridConfigTasks(
			Long parentId,String type ,Integer pageNum, Integer pageSize,
			String sortField, String order) {

		try {
			PropertyDict orgTypeDict = propertyDictService
					.findPropertyDictByDomainNameAndDictDisplayName(
							PropertyTypes.ORGANIZATION_TYPE,
							OrganizationType.FUNCTION_KEY);
			PageInfo<Organization> orgPageInfo=gridConfigTaskDao.findGridConfigTasks(
					parentId,orgTypeDict.getId(), pageNum, pageSize, sortField, order);
			List<Organization> orgs=orgPageInfo.getResult();
			List<GridConfigTaskVo> taskVos=new ArrayList<GridConfigTaskVo>();
			for (Organization org:orgs) {
				GridConfigTaskVo vo=new GridConfigTaskVo();
				vo.setOrganization(org);
				vo.setIsHasConfig(isHasGridTaskList(org.getId(),type));
				taskVos.add(vo);
			}
			PageInfo<GridConfigTaskVo> taskVoPageInfo=new PageInfo<GridConfigTaskVo>();
			taskVoPageInfo.setResult(taskVos);
			taskVoPageInfo.setCurrentPage(orgPageInfo.getCurrentPage());
			taskVoPageInfo.setPerPageSize(orgPageInfo.getPerPageSize());
			taskVoPageInfo.setTotalRowSize(orgPageInfo.getTotalRowSize());
			return taskVoPageInfo;

		} catch (Exception e) {
			throw new ServiceValidationException(
					"类GridTaskListServiceImpl的findGridConfigTasks方法出现异常，原因：",
					"查询网格员配置清单出现错误", e);
		}
	}
	/**
	 * 配置清单查询子级org
	 */
	@Override
	public List<OrgTreeNode> getOrganizationTreeByParentId(Long orgId,String pId,String mode,String type) {
//		String funOrgTreeKey=FUNORG_TREE+orgId;
		List<OrgTreeNode> nodes;
		if (orgId!=null&&pId == null) {
		}else{
			return nodes=new ArrayList<OrgTreeNode>();
		}
//		if(memCacheService.get(funOrgTreeKey)==null){
			List<Long> idList=organizationDubboService.
					searchParentOrgIds(orgId, organizationDubboService.getRootOrganization().getId());
			pId=idList.get(1).toString();
			nodes=gridConfigTaskDao.getOrganizationTreeByParentId(Long.parseLong(pId));
			nodes.remove(0);
//			if(nodes.size()>0){
//				memCacheService.set(funOrgTreeKey,nodes);
//			}
//		}else{
//			nodes=(List<OrgTreeNode>)memCacheService.get(funOrgTreeKey);
//		}
		//修改查看时设置新增的节点为选中状态
		if((mode.equals("update")||mode.equals("view"))&&orgId!=null){
			nodes=checkNodes(nodes,orgId,type);
		}
		return nodes;
	}
	
	/**
	 * 修改配置清单时设置组织树让新增的节点为选中状态
	 */
	private List<OrgTreeNode> checkNodes(List<OrgTreeNode> nodes,Long funOrgId,String type){
		String tableName = Constants.gridTableNameMap.get(type);
		if(!StringUtil.isStringAvaliable(type)){
			throw new BusinessValidationException("操作失败，未获得操作表");
		}
		List<Long> checkedIds=gridConfigTaskDao.getCheckedIds(funOrgId,tableName);
		// 选中
		if (checkedIds != null && checkedIds.size()>0) {
			//把选中的orgid放进map,避免双重循环
			Map<String, String> idsMap = new HashMap<String, String>();
			for (Long id:checkedIds) {
				idsMap.put(id.toString(), id.toString());
			}
			//设置新增的节点为选中状态
			for (OrgTreeNode node : nodes) {
				String id = idsMap.get(node.getId());
				if (id != null) {
					node.setChecked(true);
				}
			}
		}
		return nodes;
	}
	
	/* 
	 * 新增选择的org
	 */
	@Override
	public void addGridConfigTaskByOrgids(String ids, Organization funorg,String mode,String type) throws ServiceException {
		if(!StringUtil.isStringAvaliable(ids)){
			logger.error("配置职能部门清单模块新增时：ids为空");
			throw new ServiceException("配置职能部门清单模块新增时：ids为空");
		}
		String tableName = Constants.gridTableNameMap.get(type);
		if(!StringUtil.isStringAvaliable(tableName)){
			throw new BusinessValidationException("操作失败，未获得操作表");
		}
		Map<String, Object>map=new HashMap<String, Object>();
		List<Long>orgids=new ArrayList<Long>();
		String[] orgidStrs=ids.split(",");
		for(String orgId:orgidStrs){
			orgids.add(Long.parseLong(orgId));
		}
		map.put("orgids", orgids);
		map.put("funOrgId", funorg.getId());
		map.put("funOrgLevel", funorg.getOrgLevel().getId());
		map.put("tableName", tableName);
		map.put("createUser", ThreadVariable.getUser().getUserName());
		if(mode.equals("update")){
			gridConfigTaskDao.deleteCheckedOrg(funorg.getId(),tableName);
		}
		//分段插入数据库
		addGridConfigTask(map);
		memCacheService.set(HAS_CONFIG+type+funorg.getId(), true);
	}
	//分段插入数据库
	private void addGridConfigTask(Map<String, Object>map){
		List<Long>orgids=(List<Long>)map.get("orgids");
		int size=orgids.size();
		//因为in 里面不能超过1000，所以这里必须进行分批次新增
		List<Long> idList=new ArrayList<Long>(); 
		//循环遍历
		for(int i=0;i<size;i++){
		   idList.add(orgids.get(i));
		   //每900个执行
		   if(i!=0&&i%900==0){
			   map.put("orgids", idList);
			   gridConfigTaskDao.addGridConfigTaskByOrgids(map);
			   idList=new ArrayList<Long>();
		   } 
		}
		//上面循环后执行最后不足900个的插入
		if(idList.size()!=0){
			map.put("orgids", idList);
			gridConfigTaskDao.addGridConfigTaskByOrgids(map);
		}
	}
	
	/* 
	 * 更据职能部门id删除选中的行政部门的id
	 */
	@Override
	public void deleteCheckedOrg(String ids,String type) {
		String tableName = Constants.gridTableNameMap.get(type);
		if(!StringUtil.isStringAvaliable(type)){
			throw new BusinessValidationException("操作失败，未获得操作表");
		}
		String[] orgidStrs=ids.split(",");
		for(String orgId:orgidStrs){
			gridConfigTaskDao.deleteCheckedOrg(Long.parseLong(orgId),tableName);
			memCacheService.set(HAS_CONFIG+type+Long.parseLong(orgId), false);
		}
	}

	/* 
	 * 根据职能部门id查询是否有配置职能部门配置清单
	 */
	@Override
	public Boolean isHasGridTaskList(Long funId,String type) {
		String tableName = Constants.gridTableNameMap.get(type);
		if(!StringUtil.isStringAvaliable(type)){
			throw new BusinessValidationException("操作失败，未获得操作表");
		}
		String isHasConfigKey=HAS_CONFIG+type+funId;
		if(memCacheService.get(isHasConfigKey)!=null){
			return (Boolean)memCacheService.get(isHasConfigKey);
		}
		Long num=gridConfigTaskDao.countHasGridTaskList(funId,tableName);
		if(num==null || num==0){
			memCacheService.set(isHasConfigKey, false);
			return false;
		}
		memCacheService.set(isHasConfigKey, true);
		return true;
	}
}

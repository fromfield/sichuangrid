package com.tianque.baseInfo.primaryOrg.dao;

import java.util.Date;
import java.util.List;

import com.tianque.baseInfo.primaryOrg.domain.RedCuffTeam;
import com.tianque.core.vo.PageInfo;

public interface RedCuffTeamDao {

	/***
	 * 红袖套队伍成员列表查询
	 */
	public PageInfo<RedCuffTeam> findRedCuffTeamForList(RedCuffTeam redCuffTeam,Integer page,
			Integer rows, String sidx, String sord);
	
	/***
	 * 新增
	 */
	public RedCuffTeam addRedCuffTeam(RedCuffTeam redCuffTeam);
	
	/***
	 * 修改
	 */
	public RedCuffTeam updateRedCuffTeam(RedCuffTeam redCuffTeam);
	
	/***
	 * 删除
	 */
	public void deleteRedCuffTeamByIds(String[] ids);
	
	/**
	 * 通过ID查询数据
	 */
	public RedCuffTeam getRedCuffTeamById(Long id);
	
	/**
	 * 通过唯一电话号码查询数据
	 */
	public RedCuffTeam getRedCuffTeamByPhoneNumber(String phoneNumber);
	/***
	 * 根据电话号码和姓名查询成员信息
	 */
	public RedCuffTeam getRedCuffTeamByPhoneAndName(String phoneNumber,String name);
	/***
	 * 根据微信号查询成员信息
	 */
	public RedCuffTeam getRedCuffTeamByWechatno(String wechatNo);
	/***
	 * 红袖套成员微信绑定
	 */
	public Integer weChatBindingRedCuffTeam(Integer isCertification,String wechatNo,Date wechatAuthenticationDate,Long id);
	/***
	 * 根据微信号绑定成员坐标
	 */
	public void bindingRedCuffTeamCoordinate(String latitudeX,String longitudeY,String precision,Date bindingTime,String wechatNo);

	/**
	 * 类别查询微信号
	 * @Title: getWeChatNoByTeamType 
	 * @param orgCode 该组织下辖
	 * @param teamType
	 * @param subTeamType
	 * @return
	 */
	public String[] getWeChatNoByTeamType(String orgCode, String[] teamType, String[] subTeamType);

	public List<RedCuffTeam> getRedCuffTeamListByTeamType(String orgCode, String[] teamType,
			String[] subTeamType);

	public int countRedCuffTeamListByTeamType(String orgCode, String[] teamType,
			String[] subTeamType);

	/**
	 * 查询组织的所有红袖套成员名字和电话
	 * @param orgCode
	 * @return
	 */
	public List<RedCuffTeam> getRedCuffTeamNameAndPhoneListByOrgCode(String orgCode);
}

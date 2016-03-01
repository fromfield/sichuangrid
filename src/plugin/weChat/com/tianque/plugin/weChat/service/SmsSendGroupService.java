package com.tianque.plugin.weChat.service;

import com.tianque.baseInfo.primaryOrg.domain.RedCuffTeam;
import com.tianque.core.vo.PageInfo;
import com.tianque.plugin.weChat.domain.sms.SmsSendGroup;
import com.tianque.plugin.weChat.domain.sms.SmsSendResult;

import java.util.List;

public interface SmsSendGroupService {
	/**
	 * 发送保存短信
	 * @Title: saveSmsSendGroup 
	 * @param smsSendGroup
	 * @return: 
	 */
	public Long sendSaveSmsSendGroup(SmsSendGroup smsSendGroup, String[] phoneNumber);

	public int countRedCuffTeamListByTeamType(String orgCode, String type);

	/**
	 * id获取短信发送组
	 * @Title: getById 
	 * @Description: TODO
	 * @param id
	 * @return: SmsSendGroup
	 */
	public SmsSendGroup getById(Long id);

	/**
	 * 分页查询短信发送组
	 * @Title: findSmsSendGroup 
	 * @param smsSendGroup
	 * @param pageNum
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @return: PageInfo<SmsSendGroup>
	 */
	public PageInfo<SmsSendGroup> findSmsSendGroup(SmsSendGroup smsSendGroup, Integer pageNum,
			Integer pageSize, String sidx, String sord);

	/**
	 * 短信发送状态报告回调
	 * @Title: smsSendCallBack 
	 * @param sendId
	 * @param time
	 * @param mobile
	 * @param state
	 * @return: boolean
	 */
	public boolean smsSendCallBack(String name, String pwd, String sendId, String time,
			String mobile, String state);

	/**
	 * 分页查询短信发送结果
	 * @Title: findSmsSendResult 
	 * @param smsSendResult
	 * @param pageNum
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @return: PageInfo<SmsSendResult>
	 */
	public PageInfo<SmsSendResult> findSmsSendResult(SmsSendResult smsSendResult, Integer pageNum,
			Integer pageSize, String sidx, String sord);

	/**
	 * 查询组织的所有红袖套成员名字和电话
	 * @param orgCode
	 * @return
	 */
	public List<RedCuffTeam> getRedCuffTeamNameAndPhoneListByOrgCode(String orgCode);
}
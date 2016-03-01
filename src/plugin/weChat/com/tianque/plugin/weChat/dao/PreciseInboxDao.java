package com.tianque.plugin.weChat.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tianque.core.vo.PageInfo;
import com.tianque.plugin.weChat.domain.inbox.PreciseInbox;
import com.tianque.plugin.weChat.domain.user.TencentUser;


public interface PreciseInboxDao {
	/**列表查询*/
	public PageInfo<PreciseInbox> findPreciseInboxs(Map<String, Object> parameterMap, Integer pageNum,
			Integer pageSize);

	/**新增*/
	public Long savePreciseInbox(PreciseInbox preciseInbox);

	/**根据preciseInboxId删除*/
	public void deletePreciseInboxById(List<Long> preciseInboxId);

	/****
	 * 设置有无效
	 */
	public void setAvailabilityOrInvalid(PreciseInbox preciseInbox);

	/**根据id获取单个对象*/
	public PreciseInbox getPreciseInboxById(Long id);

	public void update(PreciseInbox preciseInbox);

	/**查找最大Id*/
	public Long getMaxPreciseInboxId();
	
	/**
	 * 根据微信号和粉丝号，修改粉丝所在的群组Id
	 * @param preciseInbox
	 */

	public Integer setGroupIdByWeChatUserIdAndFanId(PreciseInbox preciseInbox);
	/**
	 * 在mq端保存信息（文本，语音，图片）
	 * @param messageMap
	 * @param tencentUser
	 * @param msgType
	 * @param access_Token
	 */
	public void saveMsgByMq(Map<String, String> messageMap,TencentUser tencentUser,String msgType,String access_Token);
	
    /**根据用户openId查询事件总数*/
	public Long findPreciseInboxByFromUserNameTotal(String fromUserName);
	/**手机端分页查询*/
	public ArrayList<PreciseInbox> findPreciseInboxPaging(Map<String,Object> map);
	
	/** 查看未读的精确消息(流动人口消息、治安隐患消息、综合服务消息) */
	public List<PreciseInbox> findPreciseInboxsByDealStateAndIsRead(PreciseInbox preciseInbox);

}

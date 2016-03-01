package com.tianque.plugin.weChat.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianque.baseInfo.primaryOrg.dao.RedCuffTeamDao;
import com.tianque.core.exception.ServiceException;
import com.tianque.core.util.GridProperties;
import com.tianque.core.util.ThreadVariable;
import com.tianque.core.vo.PageInfo;
import com.tianque.domain.Organization;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.property.WeChatType;
import com.tianque.exception.base.BusinessValidationException;
import com.tianque.plugin.weChat.dao.WeChatResponseDao;
import com.tianque.plugin.weChat.domain.WeChatResponse;
import com.tianque.plugin.weChat.domain.WeiXinMedia;
import com.tianque.plugin.weChat.domain.sendMessage.News;
import com.tianque.plugin.weChat.domain.user.TencentUser;
import com.tianque.plugin.weChat.domain.user.WeChatSource;
import com.tianque.plugin.weChat.service.TencentUserService;
import com.tianque.plugin.weChat.service.UploadFileService;
import com.tianque.plugin.weChat.service.WeChatResponseService;
import com.tianque.plugin.weChat.service.WeChatService;
import com.tianque.plugin.weChat.service.WeChatSourceService;
import com.tianque.sysadmin.service.OrganizationDubboService;
import com.tianque.userAuth.api.PropertyDictDubboService;

@Service("weChatResponseService")
@Transactional
public class WeChatResponseServiceImpl implements WeChatResponseService {
	@Autowired
	private WeChatResponseDao weChatResponseDao;
	@Autowired
	private OrganizationDubboService orgService;
	@Autowired
	private WeChatService weChatService;
	@Autowired
	private TencentUserService tencentUserService;
	@Autowired
	private RedCuffTeamDao redCuffTeamDao;
	@Autowired
	private WeChatSourceService weChatSourceService;
	@Autowired
	private UploadFileService uploadFileService;
	@Autowired
	private PropertyDictDubboService propertyDictDubboService;

	@Override
	public String saveAndSendWeChatResponse(WeChatResponse weChatResponse, String[] sendToWechatNo) {
		//		int sendCount = weChatResponseDao.countByWechatName(weChatResponse.getWechatUserName(),
		//				getTimesMonthmorning());
		Organization org = weChatResponse.getOrg();
		if (org != null && weChatResponse.getOrg().getId() != null) {
			org = orgService.getSimpleOrgById(weChatResponse.getOrg().getId());
		}
		if (org == null) {
			throw new ServiceException("未获取到组织");
		}
		weChatResponse.setOrg(org);
		weChatResponse.setUserId(ThreadVariable.getUser().getId());
		weChatResponse.setUserName(ThreadVariable.getUser().getUserName());

		String[] wechatNo = null;
		if (sendToWechatNo != null) {
			wechatNo = sendToWechatNo;
		} else {
		//根据红袖套类别查询微信用户
			String[] teamTypes = null;
			if (StringUtils.isNotBlank(weChatResponse.getSendType())) {
				teamTypes = weChatResponse.getSendType().replaceAll(" ", "").split(",");
			} else {
				throw new ServiceException("红袖套成员类别错误");
			}
			wechatNo = redCuffTeamDao.getWeChatNoByTeamType(org.getOrgInternalCode(),
				teamTypes, null);
		}
		// 去除重复、无效微信号数据
		//		if (wechatNo != null) {
		//			Set<String> set = new HashSet<String>();
		//			for (String str : wechatNo) {
		//				if (StringUtils.isNotBlank(str))
		//					set.add(str);
		//			}
		//			wechatNo = set.toArray(wechatNo);
		//		}
		if (wechatNo == null || wechatNo.length < 2) {
			throw new ServiceException("消息接收人数至少2人");
		} else if (wechatNo.length > 10000) {
			throw new ServiceException("消息接收人数最多10000人,当前选中类别有" + wechatNo.length + "人");
		}
		// 调用微信发送
		TencentUser tencentUser = tencentUserService.getTencentUserByWeChatUserId(weChatResponse
				.getWechatUserName());
		String accessToken = weChatService.getAccessToken(tencentUser);
		// 素材上传 START ==========================
		WeChatSource weChatSource = weChatSourceService.getWeChatSource(weChatResponse
				.getSourceId());
		if (weChatSource == null) {
			throw new BusinessValidationException("未找到该素材");
		}
		// 素材类型
		PropertyDict sourceTypeDict = propertyDictDubboService.getPropertyDictById(weChatSource
				.getSourceTypeDict().getId());
		String msgId = null;
		if (WeChatType.tuwen_CN.equals(sourceTypeDict.getDisplayName())) {// 图文
			//图片上传
			WeiXinMedia picMedia = uploadFileService.uploadMedia(accessToken, "image",
					GridProperties.PROXY_SERVER_DOMAIN_NAME + weChatSource.getPath());
			if (picMedia == null) {
				throw new BusinessValidationException("素材图片上传失败");
			}
			List<News> lists = new ArrayList<News>();
			News news = new News();
			news.setAuthor(tencentUser.getName());
			news.setContent(weChatSource.getContent());
			news.setContentSourceUrl(weChatSource.getUrl());
			news.setTitle(weChatSource.getTitle());
			news.setDigest(weChatSource.getDescription());
			news.setThumbMediaId(picMedia.getMediaId());
			lists.add(news);

			//上传图文
			WeiXinMedia weiXinMedia = uploadFileService.uploadNews(accessToken, lists);
			// 素材上传 END ====================

			//				WeiXinMedia weiXinMedia = weChatService.localMediaIdUploadToWeChat(
			//						weChatResponse.getSourceId(), tencentUser);
			msgId = weChatService.sendNewsToMassUserByMediaId(weiXinMedia.getMediaId(),
					tencentUser, wechatNo);
			weChatResponse.setText(weChatSource.getSourceDescription());
		} else if (WeChatType.wenben_CN.equals(sourceTypeDict.getDisplayName())) {//文本
			msgId = weChatService.sendTextToMassUser(weChatSource.getContent(), tencentUser,
					wechatNo);

			//HttpClientUtils.postProxyToOutside(proxiedUrl, paramMap)
			weChatResponse.setText(weChatSource.getContent());
		} else {
			throw new BusinessValidationException("不支持该类型素材群发：" + sourceTypeDict.getDisplayName()
					+ "-" + sourceTypeDict.getInternalId());
		}
		if (msgId == null) {
			throw new BusinessValidationException("微信群发失败");
		}
		weChatResponse.setMsgId(msgId);
		weChatResponse.setStatus("提交到微信服务器");
		// 保存发送记录
		weChatResponseDao.saveWeChatResponse(weChatResponse);
		return "success";
	}

	// 获得本月第一天0点时间
	private static Date getTimesMonthmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH),
				0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	@Override
	public WeChatResponse getById(Long id) {
		return weChatResponseDao.getById(id);
	}

	@Override
	public void updateWeChatResponse(WeChatResponse weChatResponse) {

	}

	@Override
	public PageInfo<WeChatResponse> findWeChatResponse(WeChatResponse weChatResponse,
			Integer pageNum, Integer pageSize, String sidx, String sord) {
		return weChatResponseDao.findWeChatResponse(weChatResponse, pageNum, pageSize, sidx, sord);
	}

	@Override
	public int countByWechatName(String wechatUserName, Date startDate) {
		return weChatResponseDao.countByWechatName(wechatUserName, startDate);
	}

}

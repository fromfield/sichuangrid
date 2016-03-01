package com.tianque.resourcePool.dao;

import java.util.List;

import com.tianque.resourcePool.domain.MyProfileAttachFile;

public interface MyProfileAttachFileDao {
	public MyProfileAttachFile addMyProfileAttachFile(
			MyProfileAttachFile myProfileAttachFile);

	public List<MyProfileAttachFile> getMyProfileAttachFileByMyProfileId(
			Long myProfileId);

	public MyProfileAttachFile getSimpleMyProfileAttachFileById(Long id);

	public void deleteMyProfileAttachFileById(Long id);

	public void deleteMyProfileAttachFileByMyProfileId(Long myProfileId);

	public void deleteMyProfileAttachFileByMyProfileIds(String[] myProfileIds);

}

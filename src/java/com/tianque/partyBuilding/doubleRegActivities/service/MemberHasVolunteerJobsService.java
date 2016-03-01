package com.tianque.partyBuilding.doubleRegActivities.service;

import java.util.List;

import com.tianque.partyBuilding.doubleRegActivities.domain.MemberHasVolunteerJobs;

public interface MemberHasVolunteerJobsService {

	void addMemberHasVolunteerJobs(MemberHasVolunteerJobs memberHasVolunteerJobs);

	void deleteMemberHasVolunteerJobsById(Long id);

	List<MemberHasVolunteerJobs> getMemberHasVolunteerJobsById(Long id);

	/**
	 * 根据volunteerJobsId删除关联表
	 * 
	 * @param volunteerJobsId
	 */
	void deleteMemberHasVolunteerJobsByVolunteerJobsId(Long volunteerJobsId);

	/**
	 * 根据volunteerJobsIds删除关联表
	 * 
	 * @param volunteerJobsId
	 */
	void deleteMemberHasVolunteerJobsByVolunteerJobsIds(Long[] volunteerJobsIds);

}

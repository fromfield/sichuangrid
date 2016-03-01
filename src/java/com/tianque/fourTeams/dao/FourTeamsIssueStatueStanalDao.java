package com.tianque.fourTeams.dao;

import com.tianque.domain.IssueStatueStanal;

public interface FourTeamsIssueStatueStanalDao {

	public IssueStatueStanal addIssueStatueStanal(IssueStatueStanal issueStatueStanal);

	public IssueStatueStanal getIssueStatueStanalById(Long id);

	public void deleteIssueStatueStanal(IssueStatueStanal issueStatueStanal);

	public IssueStatueStanal getIssueStatueStanalStatCount(IssueStatueStanal issueStatueStanal);

	public IssueStatueStanal getIssueStatueStanalStatCountByYearAndMonth(Long orgId,
			Integer sysBeginYear, Integer month);

}

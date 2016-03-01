alter table userAccountLoginDetailWeek add(orgType number(10),lastLoginTime Date,pcUsable number(1),mobileUsable number(1) );
alter table userAccountLoginDetailMonth add(orgType number(10),activationTime Date,lastLoginTime Date,pcUsable number(1),mobileUsable number(1) );

insert into permissions(ID,CNAME,ENAME,PERMISSIONTYPE,MODULENAME,ENABLE,PARENTID,DESCRIPTION,NORMALURL,LEADERURL,INDEXID,GRIDURL)
values (s_permissions.nextval,'任务清单统计表（新）','taskListStatisticsNewManagement',1,'任务清单统计表',1,(select id from permissions where ename = 'taskListReportForm'),
   '','/hotModuel/task/reportForm/taskListStatistics.ftl','', 1,'');
   
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '查看报表', 'viewAccountLoginStatistics', 0, '账号活跃度', 1, (select id from permissions where 
ename='accountActivityDegreeManage'), '', '', '', 0, '');
commit;



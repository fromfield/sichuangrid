--账号活跃度统计权限
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '账号活跃度', 'accountActivityDegreeManage', 1, '账号统计管理', 1, (select id from permissions where 
ename='accountStatisticsManagement'), '', '/hotModuel/userCount/accountActivityDegree.jsp', '', 1, '');

insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '导出', 'accountActivityExport', 0, '账号活跃度', 1, (select id from permissions where 
ename='accountActivityDegreeManage'), '', '', '', 0, '');



--各个账号周活跃度统计 每周一凌晨4点12分12秒
insert into taskploy(id, cname, ename, type, description, code)values(s_TASKPLOY.nextval,'各层级账号周活跃度统计job','userAccountLoginDetailWeekJob',(select id from propertydicts where displayname = 'java方法'),'各层级账号周活跃度统计job','userAccountLoginDetailWeekJob.createUserAccountLoginDetail');
insert into task(id, name, taskgroup, description, ployId, config, closed)values(s_TASK.nextval,'userAccountLoginDetailWeekJob','userAccountLoginDetailWeekJob','userAccountLoginDetailWeekJob',(select id from taskploy where ename = 'userAccountLoginDetailWeekJob'),'12 12 4 ? * MON',1);
--各个账号月活跃度统计 每月1号凌晨42分12秒
insert into taskploy(id, cname, ename, type, description, code)values(s_TASKPLOY.nextval,'各层级账号周活跃度统计job','userAccountLoginDetailMonthJob',(select id from propertydicts where displayname = 'java方法'),'各层级账号周活跃度统计job','userAccountLoginDetailMonthJob.createUserAccountLoginDetail');
insert into task (id, name, taskgroup, description, ployId, config, closed)values(s_TASK.nextval, 'userAccountLoginDetailMonthJob','userAccountLoginDetailMonthJob','userAccountLoginDetailMonthJob',(select id from taskploy where ename = 'userAccountLoginDetailMonthJob'),'12 42 0 1 * ?', 1);

commit;

create table userAccountLoginDetailWeek(
id number(10) not null,
orgId number(10) not null,
orgCode varchar2(32),
userId number(10),
userName varchar2(32),
name varchar2(32),
weekCount number(2),
activationTime Date,
createUser varchar2(32),
createDate Date,
updateUser varchar2(32),
updateDate Date,
CONSTRAINT pk_userAccountLoginDetailWeek PRIMARY KEY (ID)
);

create table userAccountLoginDetailMonth(
id number(10) not null,
orgId number(10) not null,
orgCode varchar2(32),
userId number(10),
userName varchar2(32),
name varchar2(32),
monthCount number(2),
createUser varchar2(32),
createDate Date,
updateUser varchar2(32),
updateDate Date,
CONSTRAINT pk_userAccountLoginDetailMonth PRIMARY KEY (ID)
);
  
CREATE SEQUENCE S_userAccountLoginDetail
MINVALUE 1
MAXVALUE 9999999999
START WITH 1
INCREMENT BY 1
CACHE 20;

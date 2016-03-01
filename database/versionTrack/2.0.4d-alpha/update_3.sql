--吴柳林 2015/8/26晚
--严重精神障碍患者任务清单表字段修改
update mentalpatienttask set isException = null;
alter table mentalpatienttask drop(isException);

update mentalpatienttask set GUARDIAN = null;
alter table mentalpatienttask drop(GUARDIAN);

update mentalpatienttask set GUARDIANISHASCOME = null;
alter table mentalpatienttask drop(GUARDIANISHASCOME);

update mentalpatienttask set GUARDIANISHASCOMPARE = null;
alter table mentalpatienttask drop(GUARDIANISHASCOMPARE);

update mentalpatienttask set OUTREASON = null;
alter table mentalpatienttask drop(OUTREASON);

update mentalpatienttask set ISDANGER = null;
alter table mentalpatienttask drop(ISDANGER);

alter table mentalpatienttask modify exception varchar2(750);

alter table mentalpatienttask modify remark varchar2(750);

--吸毒人员任务清单表修改
update druggytask set isException = null;
alter table druggytask drop(isException);

alter table druggytask add exception varchar2(750);
comment on column druggytask.exception is '异常情况';

alter table druggytask modify remark varchar2(750);

--2015/8/28 上午 字段长度修改
alter table druggytask modify place varchar2(120);

alter table mentalPatientTask modify place varchar2(120);

update druggyTask set isLifeResource = null;
alter table druggyTask drop(isLifeResource);

--2015/8/28 下午 字段长度修改
alter table druggytask modify attitude varchar2(700);
alter table mentalPatientTask modify attitudePolice varchar2(700);
alter table mentalPatientTask modify attitudeJustice varchar2(700);

insert into permissions
  (ID,CNAME,ENAME,PERMISSIONTYPE,MODULENAME,ENABLE,PARENTID,DESCRIPTION,NORMALURL,LEADERURL,INDEXID,GRIDURL)
values
  (s_permissions.nextval,'异常情形报告工作报表','exceptionSituationReportForm',0,'任务清单报表',1,(select id from permissions where ename = 'tasksListsVisitManagement'),
   '','','', 9,'');
   
--2015/8/28凌晨
update permissions set cname='异常情况报告工作报表' where ename='exceptionSituationReportForm';
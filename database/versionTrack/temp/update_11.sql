--删除步骤表无用索引
drop index PLATFORM_TARGETORGLEVEL;
--日志表根据步骤ID建索引
CREATE INDEX pltFormLog_stepId ON platformAccountLogs (stepId);
--日志表根据台账ID和类型创建聚合索引
create index PLATFORM_LEDGERTYPEANDLEDGERID on platformaccountlogs (ledgerId, ledgerType);
--步骤表根据台账ID和类型建聚合索引
CREATE INDEX pltFormStep_LedgerIdType ON platformAccountSteps (ledgerId,ledgerType);

insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '当年分月建账', 'currentYearCollectByMonth', 1, '台账信息分析', 1, (select id from permissions where ename='informationAnalysis'),
 '', '/account/informationAnalysis/currentYearCollectByMonth.jsp', '', 2, '');
 
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '当年建账办结情况', 'currentYearCollectDoneRate', 1, '台账信息分析', 1, (select id from permissions where ename='informationAnalysis'),
 '', '/account/informationAnalysis/currentYearCollectDoneRate.jsp', '', 3, '');
 
 commit;
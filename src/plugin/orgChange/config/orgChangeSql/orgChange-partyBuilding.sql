--迁移合并业务配置：党建
insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'partyBuilding', 1, 'MEMBER_ASSOCIATE_PARTYORG', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, '');

insert into moduletable (ID, ENAME, ACTIVE, BEANNAME, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE)
values (s_MODULETABLE.NEXTVAL, 'basicCaseManagement', 1, '', 'CASEIMAGEUPLOAD', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', 'select id dataId,#ORGIDCOLUMN# dataOrgId,'''' expansionData from #TABLENAME# where #ORGIDCOLUMN#= #OLDORGID# and #OLDORGID#!=#NEWORGID#', '', 'delete #TABLENAME# where #ORGIDCOLUMN#= #OLDORGID# and #OLDORGID#!=#NEWORGID#', 'admin', sysdate, '', sysdate);

insert into moduletable (ID, ENAME, ACTIVE, BEANNAME, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE)
values (s_MODULETABLE.NEXTVAL, 'basicCaseManagement', 1, '', 'DISTRICT_BASICCASE', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', 'select id dataId,#ORGIDCOLUMN# dataOrgId,'''' expansionData from #TABLENAME# where #ORGIDCOLUMN#= #OLDORGID# and #OLDORGID#!=#NEWORGID#', '', 'delete #TABLENAME# where #ORGIDCOLUMN#= #OLDORGID# and #OLDORGID#!=#NEWORGID#', 'admin', sysdate, '', sysdate);

insert into moduletable (ID, ENAME, ACTIVE, BEANNAME, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE)
values (s_MODULETABLE.NEXTVAL, 'basicCaseManagement', 1, '', 'BASIC_CASE', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', 'select id dataId,#ORGIDCOLUMN# dataOrgId,'''' expansionData from #TABLENAME# where #ORGIDCOLUMN#= #OLDORGID# and #OLDORGID#!=#NEWORGID#', '', 'delete #TABLENAME# where #ORGIDCOLUMN#= #OLDORGID# and #OLDORGID#!=#NEWORGID#', 'admin',sysdate, '', sysdate);

insert into moduletable (ID, ENAME, ACTIVE, BEANNAME, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE)
values (s_MODULETABLE.NEXTVAL, 'basicCaseManagement', 1, '', 'PARTYWORK_MEMBERS', 'ORGID', 'ORGCODE', 0, 0, 1, 1, '', 'select id dataId,#ORGIDCOLUMN# dataOrgId,'''' expansionData from #TABLENAME# where #ORGIDCOLUMN#= #OLDORGID# and #OLDORGID#!=#NEWORGID#', '', 'delete #TABLENAME# where #ORGIDCOLUMN#= #OLDORGID# and #OLDORGID#!=#NEWORGID#', 'admin', sysdate, '', sysdate);

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'systemPartyManagement', 1, 'SYSTEM_PARTY', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, '');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'regionalPartyManagement', 1, 'PARTYORGINFOS', 'ORGID', 'ORGINTERNALCODE', 1, 0, 1, 1, '', '', '', 'select t1.id||'',''||t2.id as RESULT from (select id from #TABLENAME# where #ORGIDCOLUMN# = #OLDORGID#) t1,(select id from #TABLENAME# where #ORGIDCOLUMN# = #NEWORGID#) t2', 'admin', sysdate, 'admin', sysdate, 'partyOrgHandler');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'regionalPartyMemberManagement', 1, 'REGIONALPARTYMEMBERS', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, '');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'provideVolunteerPositionsManagement', 1, 'VOLUNTEERJOBS', 'ORGID', 'ORGINTERNALCODE', 1, 0, 1, 1, '', '', '', '', 'admin', sysdate, 'admin', sysdate, 'partyOrgHandler');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'partyMemberRegistrationSituationManagement', 1, 'PARTY_MEMBERS_ENROLL', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, '');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'partyOrganizationToReportForDutyManagement', 1, 'PARTYORG_REPORT', 'ORGID', 'ORGINTERNALCODE', 1, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, 'partyOrgHandler');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'organPartyOrganizationBaseManagement', 1, 'ORGANS_PARTY', 'ORGID', 'ORGINTERNALCODE', 1, 0, 1, 1, '', '', '', '', 'admin', sysdate, 'admin', sysdate, 'partyOrgHandler');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'customizedServicesManagement', 1, 'SERVICEPROJECT', 'ORGID', 'ORGINTERNALCODE', 1, 0, 1, 1, '', '', '', 'select t1.id||'',''||t2.id as RESULT from (select id,PROJECTNAME from #TABLENAME# where #ORGIDCOLUMN# = #OLDORGID#) t1,(select id,PROJECTNAME from #TABLENAME# where #ORGIDCOLUMN# = #NEWORGID#) t2 where t1.PROJECTNAME = t2.PROJECTNAME', 'admin', sysdate, 'admin', sysdate, 'partyOrgHandler');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'newPartyOrgManagement', 1, 'NEW_PARTY_ORG', 'ORGID', 'ORGINTERNALCODE', 1, 0, 1, 1, '', '', '', '', 'admin', sysdate, 'admin', sysdate, 'partyOrgHandler');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'partyBuilding', 1, 'PARTY_MEMBERS', 'REPORTORGANIZATION', '', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, '');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'partyBuilding', 1, 'ACTIVITYRECORDS', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, '');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'townPartyOrgManagement', 1, 'TOWN_PARTY_ORG', 'ORGID', 'ORGINTERNALCODE', 1, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, 'partyOrgHandler');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'townPartyOrgManagement', 1, 'PARTY_ORG_MEMBER', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, '');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'partyresourceManagement', 1, 'PARTYRESOURCE', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, '');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'regionalBuildInfoManagement', 1, 'REGIONALBUILDINFOS', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, '');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'partyMemberVolunteerTeamManagement', 1, 'VOLUNTEER_TEAM', 'ORGID', 'ORGINTERNALCODE', 1, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, 'partyOrgHandler');

insert into moduleTable (ID, ENAME, ACTIVE, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE, BEANNAME)
values (s_MODULETABLE.NEXTVAL, 'partyMemberVolunteerTeamManagement', 1, 'VOLUNTEER_MEMBER', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate, '');

commit;
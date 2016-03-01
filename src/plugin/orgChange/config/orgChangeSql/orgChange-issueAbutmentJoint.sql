----事件对接  事件表 修改创建网格
insert into moduletable (ID, ENAME, ACTIVE, BEANNAME, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE)
values (S_MODULETABLE.NEXTVAL, 'issueAbutmentJointManagement', 1, '', 'ISSUEJOINTS', 'CREATEORG', 'CREATEORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate);
----事件对接  事件表 修改事件发生网格
insert into moduletable (ID, ENAME, ACTIVE, BEANNAME, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE)
values (S_MODULETABLE.NEXTVAL, 'issueAbutmentJointManagement', 1, '', 'ISSUEJOINTS', 'OCCURORG', 'OCCURORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate);
----事件对接  步骤表 修改 该步骤的目标处理部门
insert into moduletable (ID, ENAME, ACTIVE, BEANNAME, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE)
values (S_MODULETABLE.NEXTVAL, 'issueAbutmentJointManagement', 1, '', 'ISSUEJOINTSTEPS', 'TARGET', 'TARGETINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate);
----事件对接  步骤表 修改  该步骤来源部门
insert into moduletable (ID, ENAME, ACTIVE, BEANNAME, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE)
values (S_MODULETABLE.NEXTVAL, 'issueAbutmentJointManagement', 1, '', 'ISSUEJOINTSTEPS', 'SOURCE', 'SOURCEINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate);
----事件对接  日志表 修改 处理部门
insert into moduletable (ID, ENAME, ACTIVE, BEANNAME, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE)
values (S_MODULETABLE.NEXTVAL, 'issueAbutmentJointManagement', 1, '', 'ISSUEJOINTLOGS', 'DEALORGID', 'DEALORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, '', sysdate);

commit;
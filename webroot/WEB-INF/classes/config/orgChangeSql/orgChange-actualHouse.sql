--实有房屋信息
insert into moduleTable (ID, ENAME, ACTIVE, BEANNAME, TABLENAME, ORGIDCOLUMN, ORGCODECOLUMN, EXECUTETYPE, ISMAINTABLE, EXECUTELEVEL, OPERATEMODE, COUNTSCRIPT, SELECTSCRIPT, UPDATESCRIPT, DELETESCRIPT, CREATEUSER, CREATEDATE, UPDATEUSER, UPDATEDATE,SPLIT)
values (s_MODULETABLE.NEXTVAL, 'actualHouseManagement', 1, '', 'HOUSEINFO', 'ORGID', 'ORGINTERNALCODE', 0, 0, 1, 1, '', '', '', '', 'admin', sysdate, 'admin', sysdate, 1);

commit;
--数据字典全拼和简拼字段长度调整
alter table propertydicts modify (SIMPLEPINYIN varchar(40));
alter table propertydicts modify (FULLPINYIN varchar(130));

--三本台账综合查询菜单
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '综合查询', 'comprehensiveQueryManagement', 1, '新三本台账', 1, (select id from permissions where ename='serviceWork4ThreeRecords'),
 '', '/account/query/comprehensiveQuery.jsp', '', 6, '');

--三本台账民生台账数据字典
insert into propertydomains(id, domainname)values(s_propertydomains.NEXTVAL, '三本台账类型');
  
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,0,'水利信息','slxx','shuilixinxi','admin','',sysdate,null);
   
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,1,'交通信息','jtxx','jiaotongxinxi','admin',
   '',sysdate,null);
   
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,2,'能源信息','nyxx','nengyuanxinxi','admin',
   '',sysdate,null);
   
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,3,'教育信息','jyxx','jiaoyuxinxi','admin','', sysdate, null);


insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,4,'科技文本信息','kjwbxx','kejiwenbenxinxi','admin',
   '',sysdate,null);
   
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,5,'医疗卫生信息','ylwsxx','yiliaoweishengxinxi','admin',
   '',sysdate,null);   
   
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,6,'劳动和社会保障信息','ldhshbzxx','laodongheshehuibaozhangxinxi','admin','',sysdate,null);

insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,7,'环境保护信息','hjbhxx','huanjingbaohuxinxi','admin','',sysdate,null);

insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,8,'城乡规划建设管理信息','cxghjsglxx','chengxiangguihuajiansheguanlixinxi','admin','',sysdate,null);

insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,9,'农业信息','nyxx','nongyexinxi','admin','',sysdate,null);

insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,10,'其它信息','qtxx','qitaxinxi','admin','',sysdate,null);

--insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
--values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,11,'困难群众信息','knqzxx','kunnanqunzhongxinxi','admin','',sysdate,null);

--insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
--values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账类型'),0,12,'稳定信息','wdxx','wendingxinxi','admin','',sysdate,null);

commit;

--三本台账状态数据字典
insert into propertydomains(id, domainname)values(s_propertydomains.NEXTVAL, '三本台账状态');
  
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账状态'),0,0,'待办','db','daiban','admin','',sysdate,null);
   
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账状态'),0,1,'程序性办结','cxxbj','chengxuxingbanjie','admin',
   '',sysdate,null);
   
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账状态'),0,2,'阶段性办结','jdxbj','jieduanxingbanjie','admin',
   '',sysdate,null);
   
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账状态'),0,3,'实质性办结','szxbj','shizhixingbanjie','admin','', sysdate, null);


insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账状态'),0,4,'已办','yb','yiban','admin',
   '',sysdate,null);
   
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账状态'),0,5,'待反馈','dfk','daifankui','admin',
   '',sysdate,null);   
   
insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账状态'),0,6,'上级交办','sjjb','shangjijiaoban','admin','',sysdate,null);

insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账状态'),0,7,'上报','sb','shangbao','admin','',sysdate,null);

insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账状态'),0,8,'协办','xb','xieban','admin','',sysdate,null);

insert into propertydicts(ID,PROPERTYDOMAINID,INTERNALID,DISPLAYSEQ,DISPLAYNAME,SIMPLEPINYIN,FULLPINYIN,CREATEUSER,UPDATEUSER,CREATEDATE,UPDATEDATE)
values(s_propertydicts.nextval,(select id from propertydomains p where domainname = '三本台账状态'),0,9,'抄告','cg','chaogao','admin','',sysdate,null);

commit;
                  
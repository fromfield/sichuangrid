-- 将上网服务单位改为网吧
comment on table INTERNETBAR is '网吧信息';
comment on column INTERNETBAR.id is '网吧Id';
comment on table DM_INTERNETBAR_TEMP is '数据管理_网吧';
comment on column DM_INTERNETBAR_TEMP.id is '网吧Id';
update gisTypeManages set name = '网吧' where name = '上网服务单位';
commit;

update permissions set cname = replace(cname, '上网服务单位', '网吧'), 
modulename = replace(modulename, '上网服务单位', '网吧') 
where cname like '%上网服务单位%' or modulename like '%上网服务单位%';
commit;


-- 修改 实有人口－重点人口 重点青少年 类型
alter table PROPERTYDICTS modify simplepinyin VARCHAR2(20);
alter table PROPERTYDICTS modify fullpinyin VARCHAR2(60);

update propertydicts set displayname = '有不良行为或严重不良行为青少年', simplepinyin = 'yblxwhyzblxwqsn', fullpinyin = 'youbuliangxingweihuoyanzhongbuliangxingweiqingshaonian'
where displayname = '不良行为的青少年' and propertydomainid = (select id from propertyDomains where domainName= '闲散青少年人员类型');
update propertydicts set displayname = '流浪乞讨未成年人', simplepinyin = 'llqtwcnr', fullpinyin = 'liulangqitaoweichengnianren'
where displayname = '流浪乞讨青少年' and propertydomainid = (select id from propertyDomains where domainName= '闲散青少年人员类型');
update propertydicts set displayseq = '7' where displayname = '其他' and propertydomainid = (select id from propertyDomains where domainName= '闲散青少年人员类型');
commit;

insert into propertydicts values (s_propertyDicts.NEXTVAL, (select id from propertyDomains where domainName= '闲散青少年人员类型'), 0
, 6, '受艾滋病影响致孤儿童', 'sazbyxzget', 'shouaizibingyingxiangzhiguertong', 'admin', '', sysdate, '');
commit;

-- 严重精神障碍患者 增加“目前是否在接受治疗”  --
alter table DM_mentalPatients_Temp add isUndergo_treatment NUMBER(1) default 0;
alter table mentalPatients add isUndergo_treatment NUMBER(1) default 0 ;

commit;

-- 吸毒人员 增加“目前是否在接受康复治疗”  --
alter table DM_druggys_Temp add isUndergo_treatment NUMBER(1) default 0;
alter table druggys add isUndergo_treatment NUMBER(1) default 0;

commit;
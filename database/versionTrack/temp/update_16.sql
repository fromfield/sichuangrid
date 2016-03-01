--加上类型字段
alter table MOBILEDICTIONARY add type number(1);
comment on column MOBILEDICTIONARY.type is '类型（1：所有的数据字典项，2：增量的数据字典项）';
--给类型设置值为1
update MOBILEDICTIONARY set type=1;
--生成手机数据字典job，每个小时更新一次
insert into taskploy(id,cname,ename,type,description,code) values(s_TASKPLOY.nextval,'生成手机端数据字典job','mobileDictionaryJob',(select id from propertydicts where displayname='java方法'),'生成手机端数据字典job','mobileDictionaryJob.createMobileDictionary');
insert into task(id,name,taskgroup,description,ployId,config,closed) values(s_TASK.nextval,'mobileDictionaryJob','mobileDictionaryJob','mobileDictionaryJob',(select id from taskploy where ename='mobileDictionaryJob'),'0 0 */1 * * ?',1);

--新建数据字典操作日志
create sequence s_propertyDictLogs
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;

create table propertyDictLogs
(
       id  number(10),
       operateType number(1),
       dictId number(10),
       domainId number(10),
       createDate date,
       constraint pk_propertyDictLogs primary key (id)
);

 comment on table propertyDictLogs is '数据字典操作日志';
 comment on column propertyDictLogs.operateType is '操作类型1:新增，2:修改，3：删除';
 comment on column propertyDictLogs.dictId is '关联的字典项id';
 comment on column propertyDictLogs.dictId is '关联的字典大类id';
 
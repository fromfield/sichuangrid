--食药工商数据字典与权限
insert into propertydomains(id,domainname)
  values(s_propertydomains.NEXTVAL,'政策法规宣传类别');
insert into propertydomains(id,domainname)
  values(s_propertydomains.NEXTVAL,'食品安全协管类别');
insert into propertydomains(id,domainname)
  values(s_propertydomains.NEXTVAL,'药品安全协管类别');
insert into propertydomains(id,domainname)
  values(s_propertydomains.NEXTVAL,'工商行政管理协管类别');
insert into propertydomains(id,domainname)
  values(s_propertydomains.NEXTVAL,'打击非法传销协管类别');
insert into propertydomains(id,domainname)
  values(s_propertydomains.NEXTVAL,'传销类别');
insert into propertydomains(id,domainname)
  values(s_propertydomains.NEXTVAL,'查处取缔无证无照经营协管类别');

commit; 

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='政策法规宣传类别'), 0, 0, '食品类', 'spl', 'shipinglei', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='政策法规宣传类别'), 0, 1, '药品类', 'ypl', 'yaopinglei', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='政策法规宣传类别'), 0, 2, '工商类', 'gsl', 'gongshanglei', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='政策法规宣传类别'), 0, 3, '打击非法传销', 'djffcx', 'dajifeifachuanxiao', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='食品安全协管类别'), 0, 0, '农村家宴', 'ncjy', 'nongcunjiayan', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='食品安全协管类别'), 0, 1, '食品保健食品', 'spbjsp', 'shipingbaojianshiping', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='食品安全协管类别'), 0, 2, '食品中毒', 'spzd', 'shipingzhongdu', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='药品安全协管类别'), 0, 0, '药品医疗器械化妆品', 'ypylqxhzp', 'yaopinyiliaoqixiehuazhuangpin', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='药品安全协管类别'), 0, 1, '药品不良反应', 'ypblfy', 'yaopingbuliangfanying', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='工商行政管理协管类别'), 0, 0, '商品质量', 'spzl', 'shangpingzhiliang', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='工商行政管理协管类别'), 0, 1, '商标', 'sb', 'shangbiao', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='工商行政管理协管类别'), 0, 2, '广告', 'gg', 'guanggao', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='工商行政管理协管类别'), 0, 3, '网络', 'wangluo', 'wangluo', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='工商行政管理协管类别'), 0, 4, '报废及拼装车', 'bfjpzc', 'baofeijipingzhuangche', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='打击非法传销协管类别'), 1, 0, '聚集地点', 'jjdd', 'jujididian', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='打击非法传销协管类别'), 2, 1, '传销方式', 'cxfs', 'chuanxiaofangshi', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='打击非法传销协管类别'), 3, 2, '其他异常情况', 'qtycqk', 'qitayichangqingkuang', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='传销类别'), 1, 0, '居民居住地', 'jmjzd', 'jumingjuzhudi', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='传销类别'), 1, 1, '公共场所', 'ggcs', 'gonggongchangsuo', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='传销类别'), 1, 2, '城乡结合部或农村', 'cxjhbhnc', 'chengxiangjiehebuhuonongcun', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='传销类别'), 2, 3, '是否拉人头', 'sflrt', 'shifoularentou', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='传销类别'), 2, 4, '缴纳入门费', 'jnrmf', 'jiaonarumenfei', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='传销类别'), 2, 5, '网络传销', 'wlcx', 'wangluochuanxiao', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='传销类别'), 3, 6, '其他', 'qt', 'qita', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='查处取缔无证无照经营协管类别'), 0, 0, '食品生产或经营许可', 'spschjyxk', 'shipingshengchanhuojinyingxuke', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='查处取缔无证无照经营协管类别'), 0, 1, '药品生产或经营许可', 'ypschjyxk', 'yaopingshengchanhuojinyingxuke', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='查处取缔无证无照经营协管类别'), 0, 2, '营业执照', 'yyzz', 'yingyezhizhao', 'admin', '', sysdate, null);

insert into propertydicts (ID, PROPERTYDOMAINID, INTERNALID, DISPLAYSEQ, DISPLAYNAME, SIMPLEPINYIN, FULLPINYIN, CREATEUSER, UPDATEUSER, CREATEDATE, UPDATEDATE)
values (s_propertydicts.nextval, (select id from propertydomains p where domainname='查处取缔无证无照经营协管类别'), 0, 3, '其他行政许可', 'qtxzxk', 'qitaxingzhenxuke', 'admin', '', sysdate, null);

commit; 

insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '食药工商', 'serviceListVisitManagement', 1, ' ', 1, null, null, null, null, null, null);
--食品药品工商管理
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
	values (s_permissions.NEXTVAL, '食品药品工商管理', 'foodAndDrugsManagement', 1, '食药工商', 1, (select id from permissions where ename='serviceListVisitManagement'), null, null, null, 0, null);  
--食品药品工商管理下政策法规宣传
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '政策法规宣传', 'policyPropaganda', 1, '食品药品工商管理', 1, (select id from permissions where ename='foodAndDrugsManagement'), null, '/serviceList/foodAndDrugsManage/policyPropaganda/policyPropagandaList.jsp', '/serviceList/foodAndDrugsManage/policyPropaganda/policyPropagandaList.jsp', 0, null);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '新增', 'addPolicyPropaganda', 0, '政策法规宣传', 1, (select id from permissions where ename='policyPropaganda'), null, null, null, 0);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '修改', 'updatePolicyPropaganda', 0, '政策法规宣传', 1, (select id from permissions where ename='policyPropaganda'), null, null, null, 1);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '删除', 'deletePolicyPropaganda', 0, '政策法规宣传', 1, (select id from permissions where ename='policyPropaganda'), null, null, null, 2);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查看', 'viewPolicyPropaganda', 0, '政策法规宣传', 1, (select id from permissions where ename='policyPropaganda'), null, null, null, 3);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查询', 'searchPolicyPropaganda', 0, '政策法规宣传', 1, (select id from permissions where ename='policyPropaganda'), null, null, null, 4);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '签收', 'signPolicyPropaganda', 0, '政策法规宣传', 1, (select id from permissions where ename='policyPropaganda'), null, null, null, 5);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '回复', 'replyPolicyPropaganda', 0, '政策法规宣传', 1, (select id from permissions where ename='policyPropaganda'), null, null, null, 6);
--食品药品工商管理下食品安全协管
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '食品安全协管', 'foodSafty', 1, '食品药品工商管理', 1, (select id from permissions where ename='foodAndDrugsManagement'), null, '/serviceList/foodAndDrugsManage/foodSafty/foodSaftyList.jsp', '/serviceList/foodAndDrugsManage/foodSafty/foodSaftyList.jsp', 1, null);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '新增', 'addFoodSafty', 0, '食品安全协管', 1, (select id from permissions where ename='foodSafty'), null, null, null, 0);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '修改', 'updateFoodSafty', 0, '食品安全协管', 1, (select id from permissions where ename='foodSafty'), null, null, null, 1);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '删除', 'deleteFoodSafty', 0, '食品安全协管', 1, (select id from permissions where ename='foodSafty'), null, null, null, 2);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查看', 'viewFoodSafty', 0, '食品安全协管', 1, (select id from permissions where ename='foodSafty'), null, null, null, 3);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查询', 'searchFoodSafty', 0, '食品安全协管', 1, (select id from permissions where ename='foodSafty'), null, null, null, 4);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '保健食品签收', 'healthCareSignFoodSafty', 0, '食品安全协管', 1, (select id from permissions where ename='foodSafty'), null, null, null, 5);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '家宴食品中毒签收', 'poisoningSignFoodSafty', 0, '食品安全协管', 1, (select id from permissions where ename='foodSafty'), null, null, null, 5);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '回复', 'replyFoodSafty', 0, '食品安全协管', 1, (select id from permissions where ename='foodSafty'), null, null, null, 6);
--食品药品工商管理下药品安全协管
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '药品安全协管', 'drugysSafty', 1, '食品药品工商管理', 1, (select id from permissions where ename='foodAndDrugsManagement'), null, '/serviceList/foodAndDrugsManage/drugysSafty/drugysSaftyList.jsp', '/serviceList/foodAndDrugsManage/drugysSafty/drugysSaftyList.jsp', 2, null);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '新增', 'addDrugysSafty', 0, '药品安全协管', 1, (select id from permissions where ename='drugysSafty'), null, null, null, 0);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '修改', 'updateDrugysSafty', 0, '药品安全协管', 1, (select id from permissions where ename='drugysSafty'), null, null, null, 1);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '删除', 'deleteDrugysSafty', 0, '药品安全协管', 1, (select id from permissions where ename='drugysSafty'), null, null, null, 2);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查看', 'viewDrugysSafty', 0, '药品安全协管', 1, (select id from permissions where ename='drugysSafty'), null, null, null, 3);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查询', 'searchDrugysSafty', 0, '药品安全协管', 1, (select id from permissions where ename='drugysSafty'), null, null, null, 4);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '签收', 'signDrugysSafty', 0, '药品安全协管', 1, (select id from permissions where ename='drugysSafty'), null, null, null, 5);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '回复', 'replyDrugysSafty', 0, '药品安全协管', 1, (select id from permissions where ename='drugysSafty'), null, null, null, 6);
--食品药品工商管理下工商行政管理协管
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '工商行政管理协管', 'businessManage', 1, '食品药品工商管理', 1, (select id from permissions where ename='foodAndDrugsManagement'), null, '/serviceList/foodAndDrugsManage/businessManage/businessManageList.jsp', '/serviceList/foodAndDrugsManage/businessManage/businessManageList.jsp', 3, null);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '新增', 'addBusinessManage', 0, '工商行政管理协管', 1, (select id from permissions where ename='businessManage'), null, null, null, 0);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '修改', 'updateBusinessManage', 0, '工商行政管理协管', 1, (select id from permissions where ename='businessManage'), null, null, null, 1);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '删除', 'deleteBusinessManage', 0, '工商行政管理协管', 1, (select id from permissions where ename='businessManage'), null, null, null, 2);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查看', 'viewBusinessManage', 0, '工商行政管理协管', 1, (select id from permissions where ename='businessManage'), null, null, null, 3);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查询', 'searchBusinessManage', 0, '工商行政管理协管', 1, (select id from permissions where ename='businessManage'), null, null, null, 4);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '签收', 'signBusinessManage', 0, '工商行政管理协管', 1, (select id from permissions where ename='businessManage'), null, null, null, 5);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '回复', 'replyBusinessManage', 0, '工商行政管理协管', 1, (select id from permissions where ename='businessManage'), null, null, null, 6);
--食品药品工商管理下打击非法传销协管
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '打击非法传销协管', 'pyramidSalesManage', 1, '食品药品工商管理', 1, (select id from permissions where ename='foodAndDrugsManagement'), null, '/serviceList/foodAndDrugsManage/pyramidSalesManage/pyramidSalesManageList.jsp', '/serviceList/foodAndDrugsManage/pyramidSalesManage/pyramidSalesManageList.jsp', 4, null);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '新增', 'addPyramidSalesManage', 0, '打击非法传销协管', 1, (select id from permissions where ename='pyramidSalesManage'), null, null, null, 0);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '修改', 'updatePyramidSalesManage', 0, '打击非法传销协管', 1, (select id from permissions where ename='pyramidSalesManage'), null, null, null, 1);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '删除', 'deletePyramidSalesManage', 0, '打击非法传销协管', 1, (select id from permissions where ename='pyramidSalesManage'), null, null, null, 2);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查看', 'viewPyramidSalesManage', 0, '打击非法传销协管', 1, (select id from permissions where ename='pyramidSalesManage'), null, null, null, 3);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查询', 'searchPyramidSalesManage', 0, '打击非法传销协管', 1, (select id from permissions where ename='pyramidSalesManage'), null, null, null, 4);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '签收', 'signPyramidSalesManage', 0, '打击非法传销协管', 1, (select id from permissions where ename='pyramidSalesManage'), null, null, null, 5);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '回复', 'replyPyramidSalesManage', 0, '打击非法传销协管', 1, (select id from permissions where ename='pyramidSalesManage'), null, null, null, 6);
--食品药品工商管理下查处取缔无证无照经营协管
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '查处取缔无证无照经营协管', 'unlicensedManage', 1, '食品药品工商管理', 1, (select id from permissions where ename='foodAndDrugsManagement'), null, '/serviceList/foodAndDrugsManage/unlicensedManage/unlicensedManageList.jsp', '/serviceList/foodAndDrugsManage/unlicensedManage/unlicensedManageList.jsp',5, null);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '新增', 'addUnlicensedManage', 0, '查处取缔无证无照经营协管', 1, (select id from permissions where ename='unlicensedManage'), null, null, null, 0);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '修改', 'updateUnlicensedManage', 0, '查处取缔无证无照经营协管', 1, (select id from permissions where ename='unlicensedManage'), null, null, null, 1);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '删除', 'deleteUnlicensedManage', 0, '查处取缔无证无照经营协管', 1, (select id from permissions where ename='unlicensedManage'), null, null, null, 2);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查看', 'viewUnlicensedManage', 0, '查处取缔无证无照经营协管', 1, (select id from permissions where ename='unlicensedManage'), null, null, null, 3);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查询', 'searchUnlicensedManage', 0, '查处取缔无证无照经营协管', 1, (select id from permissions where ename='unlicensedManage'), null, null, null, 4);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '签收', 'signUnlicensedManage', 0, '查处取缔无证无照经营协管', 1, (select id from permissions where ename='unlicensedManage'), null, null, null, 5);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '回复', 'replyUnlicensedManage', 0, '查处取缔无证无照经营协管', 1, (select id from permissions where ename='unlicensedManage'), null, null, null, 6);
--食品药品工商管理下其它情况
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
values (s_permissions.NEXTVAL, '其它情况', 'otherSituationManage', 1, '食品药品工商管理', 1, (select id from permissions where ename='foodAndDrugsManagement'), null, '/serviceList/foodAndDrugsManage/otherSituationManage/otherSituationManageList.jsp', '/serviceList/foodAndDrugsManage/otherSituationManage/otherSituationManageList.jsp',6, null);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '新增', 'addOtherSituationManage', 0, '其它情况', 1, (select id from permissions where ename='otherSituationManage'), null, null, null, 0);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '修改', 'updateOtherSituationManage', 0, '其它情况', 1, (select id from permissions where ename='otherSituationManage'), null, null, null, 1);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '删除', 'deleteOtherSituationManage', 0, '其它情况', 1, (select id from permissions where ename='otherSituationManage'), null, null, null, 2);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查看', 'viewOtherSituationManage', 0, '其它情况', 1, (select id from permissions where ename='otherSituationManage'), null, null, null, 3);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '查询', 'searchOtherSituationManage', 0, '其它情况', 1, (select id from permissions where ename='otherSituationManage'), null, null, null, 4);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '签收', 'signOtherSituationManage', 0, '其它情况', 1, (select id from permissions where ename='otherSituationManage'), null, null, null, 5);
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '回复', 'replyOtherSituationManage', 0, '其它情况', 1, (select id from permissions where ename='otherSituationManage'), null, null, null, 6);

commit;

--报表权限
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
  values (s_permissions.NEXTVAL, '食药工商统计表', 'servicListStatistics', 1, '食药工商', 1, (select id from permissions where ename='serviceListVisitManagement'), null, null, null, 1, null);
insert into permissions (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID, GRIDURL)
  values (s_permissions.NEXTVAL, '食药工商报表', 'servicListReportForm', 1, '食药工商统计表', 1, (select id from permissions where ename='servicListStatistics'), null, '/serviceList/servicListStatistics/serviceReportList.jsp', '/serviceList/servicListStatistics/serviceReportList.jsp', 0, null);


insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
  values (s_permissions.NEXTVAL, '政策法规宣传报表', 'policyPropagandaForm', 0, '食药工商报表', 1, (select id from permissions where ename='servicListReportForm'), null, null, null, 0);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
  values (s_permissions.NEXTVAL, '食品安全协管报表', 'foodSaftyForm', 0, '食药工商报表', 1, (select id from permissions where ename='servicListReportForm'), null, null, null, 1);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
  values (s_permissions.NEXTVAL, '药品安全协管报表', 'drugysSaftyForm', 0, '食药工商报表', 1, (select id from permissions where ename='servicListReportForm'), null, null, null, 2);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
  values (s_permissions.NEXTVAL, '工商行政管理协管报表', 'businessManageForm', 0, '食药工商报表', 1, (select id from permissions where ename='servicListReportForm'), null, null, null, 3);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
  values (s_permissions.NEXTVAL, '打击非法传销协管报表', 'pyramidSalesManageForm', 0, '食药工商报表', 1, (select id from permissions where ename='servicListReportForm'), null, null, null, 4);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
  values (s_permissions.NEXTVAL, '查处取缔无证无照经营协管报表', 'unlicensedManageForm', 0, '食药工商报表', 1, (select id from permissions where ename='servicListReportForm'), null, null, null, 5);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
  values (s_permissions.NEXTVAL, '其它情况报表', 'otherSituationManageForm', 0, '食药工商报表', 1, (select id from permissions where ename='servicListReportForm'), null, null, null, 6);

commit;


--导入权限
insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '导入', 'importPolicyPropaganda', 0, '政策法规宣传', 1, (select id from permissions where ename='policyPropaganda'), null, null, null, 7);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '导入', 'importFoodSafty', 0, '食品安全协管', 1, (select id from permissions where ename='foodSafty'), null, null, null, 7);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '导入', 'importDrugysSafty', 0, '药品安全协管', 1, (select id from permissions where ename='drugysSafty'), null, null, null, 7);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '导入', 'importBusinessManage', 0, '工商行政管理协管', 1, (select id from permissions where ename='businessManage'), null, null, null, 7);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '导入', 'importPyramidSalesManage', 0, '打击非法传销协管', 1, (select id from permissions where ename='pyramidSalesManage'), null, null, null, 7);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '导入', 'importUnlicensedManage', 0, '查处取缔无证无照经营协管', 1, (select id from permissions where ename='unlicensedManage'), null, null, null, 7);

insert into PERMISSIONS (ID, CNAME, ENAME, PERMISSIONTYPE, MODULENAME, ENABLE, PARENTID, DESCRIPTION, NORMALURL, LEADERURL, INDEXID)
values (s_permissions.NEXTVAL, '导入', 'importOtherSituationManage', 0, '其它情况', 1, (select id from permissions where ename='otherSituationManage'), null, null, null, 7);

commit;
--------------------------------------------
-- Table: TABLENAME						ROW
--------------------------------------------
-- Table: BASEINFO						28		*
-- Table: HOUSEHOLDSTAFFS				184		*
-- Table: FLOATINGPOPULATIONS			345		*
-- Table: DRUGGYS						506		*
-- Table: AIDNEEDPOPULATION				599		*
-- Table: AIDSPOPULATIONS				688		*
-- Table: DANGEROUSGOODSPRACTITIONERS	781		*
-- Table: ELDERLYPEOPLE					875		*
-- Table: HANDICAPPEDS					983		*
-- Table: IDLEYOUTHS					1087	*
-- Table: MENTALPATIENTS				1165	*
-- Table: UNEMPLOYEDPEOPLE				1282	*
-- Table: SUPERIORVISITS				1419	*
-- Table: RECTIFICATIVEPERSONS			1492	*
-- Table: POSITIVEINFOS							*
-- Table: OTHERATTENTIONPERSONNELS				*
-- Table: OPTIMALOBJECTS						*
-- Table: NURTURESWOMEN							*
-- Table: ADDRESSINFO							*
-- Table: 
-- Table: 
--------------------------------------------
create sequence S_BASEINFO
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;

create sequence s_addressInfo
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;
create sequence s_RECOVERDATAINFOS
increment by 1
start with 1
 maxvalue 9999999999
 minvalue 1
 cache 20;

/*==============================================================*/
/* Table: BASEINFO                                              */
/*==============================================================*/
create table BASEINFO 
(
   ID                   NUMBER(10)           not null,
   NAME                 VARCHAR2(60)         not null,
   FULLPINYIN           VARCHAR2(30),
   SIMPLEPINYIN         VARCHAR2(10),
   USEDNAME             VARCHAR2(60),
   IDCARDNO             VARCHAR2(60),
   TELEPHONE            VARCHAR2(80),
   MOBILENUMBER         VARCHAR2(50),
   BIRTHDAY             DATE,
   GENDER               NUMBER(10)           not null,
   WORKUNIT             VARCHAR2(150),
   IMGURL               VARCHAR2(300),
   EMAIL                VARCHAR2(150),
   ISDEATH              NUMBER(1)            default 0,
   NATION               NUMBER(10),
   POLITICALBACKGROUND  NUMBER(10),
   SCHOOLING            NUMBER(10),
   CAREER               NUMBER(10),
   MARITALSTATE         NUMBER(10),
   BLOODTYPE            NUMBER(10),
   FAITH                NUMBER(10),
   STATURE              NUMBER(10),
   PROVINCE             VARCHAR2(60),
   CITY                 VARCHAR2(60),
   DISTRICT             VARCHAR2(60),
   NATIVEPLACEADDRESS   VARCHAR2(150),
   NATIVEPOLICESTATION  VARCHAR2(160),
   CREATEUSER           VARCHAR2(32)         not null,
   UPDATEUSER           VARCHAR2(32),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PKBASEINFO primary key (ID)
);

comment on table BASEINFO is
'人员基本信息';

comment on column BASEINFO.ID is
'人员id';

comment on column BASEINFO.NAME is
'姓名';

comment on column BASEINFO.FULLPINYIN is
'全拼';

comment on column BASEINFO.SIMPLEPINYIN is
'简拼';

comment on column BASEINFO.USEDNAME is
'曾用名';

comment on column BASEINFO.IDCARDNO is
'身份证号';

comment on column BASEINFO.TELEPHONE is
'固定电话';

comment on column BASEINFO.MOBILENUMBER is
'手机号码';

comment on column BASEINFO.BIRTHDAY is
'出生日期';

comment on column BASEINFO.GENDER is
'性别';

comment on column BASEINFO.WORKUNIT is
'工作单位';

comment on column BASEINFO.IMGURL is
'图片链接地址';

comment on column BASEINFO.EMAIL is
'电子邮箱';

comment on column BASEINFO.ISDEATH is
'是否死亡';

comment on column BASEINFO.NATION is
'民族';

comment on column BASEINFO.POLITICALBACKGROUND is
'政治面貌';

comment on column BASEINFO.SCHOOLING is
'文化程度';

comment on column BASEINFO.CAREER is
'职业';

comment on column BASEINFO.MARITALSTATE is
'婚姻状况';

comment on column BASEINFO.BLOODTYPE is
'血型';

comment on column BASEINFO.FAITH is
'宗教信仰';

comment on column BASEINFO.STATURE is
'身高';

comment on column BASEINFO.PROVINCE is
'省';

comment on column BASEINFO.CITY is
'市';

comment on column BASEINFO.DISTRICT is
'区县';

comment on column BASEINFO.NATIVEPLACEADDRESS is
'户籍地详址';

comment on column BASEINFO.NATIVEPOLICESTATION is
'户籍派出所';

comment on column BASEINFO.CREATEUSER is
'创建用户';

comment on column BASEINFO.UPDATEUSER is
'修改用户';

comment on column BASEINFO.CREATEDATE is
'创建日期';

comment on column BASEINFO.UPDATEDATE is
'修改时间';

/*==============================================================*/
/* index: indexBaseinfoIdCardNo                                 */
/*==============================================================*/
create index indexBaseinfoIdCardNo on BASEINFO (IDCARDNO);


/*==============================================================*/
/* Table: HOUSEHOLDSTAFFS                                       */
/*==============================================================*/
create table HOUSEHOLDSTAFFS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32),
   FAMILYID             NUMBER(10),
   ACCOUNTNUMBER        VARCHAR2(150),
   RESIDENCETYPE        NUMBER(10),
   RELATIONSHIPWITHHEAD NUMBER(10),
   OUTGONE              NUMBER(1)            default 0,
   OUTREASONS           NUMBER(10),
   REASONSDATE          DATE,
   OUTPROVINCE          VARCHAR2(150),
   OUTCITY              VARCHAR2(150),
   OUTDISTRICT          VARCHAR2(150),
   GOOUTDETAILEDADDRESS VARCHAR2(900),
   HOMEPHONE            VARCHAR2(80),
   RESIDENTSTATUS       NUMBER(10),
   SETTLETIME           VARCHAR2(30),
   SOURCESSTATE         NUMBER(1)            default 1,
   OLDCURRENTADDRESS    VARCHAR2(150),
   IMMIGRATIONDATE      DATE,
   PROPERSTATIONCODE    VARCHAR2(18),
   PROPERSTATION        VARCHAR2(150),
   IMMIGRATIONSORT      NUMBER(10),
   IMMIGRATIONCAUSE     NUMBER(10),
   EMIGRATIONDATE       DATE,
   EMIGRATIONCODE       VARCHAR2(18),
   EMIGRATIONLAND       VARCHAR2(150),
   EMIGRATIONSORT       NUMBER(10),
   EMIGRATIONCAUSE      NUMBER(10),
   HEALTHSTATE          NUMBER(10),
   MILITARYSERVICE      NUMBER(10),
   ANNUALINCOME         NUMBER(15,2),
   INSURED              NUMBER(1)            default 0,
   OUTGONEDIRECTION     VARCHAR2(150),
   SOLDIERDEPENDENTS    NUMBER(1),
   LOWINCOME            NUMBER(1),
   HARDSTATE            VARCHAR2(150),
   ABROADDEPENDENTS     NUMBER(1),
   ABROADDEPENDENTSTYPE NUMBER(10),
   STATUS               NUMBER(1)            default 0,
   ISMOVED              NUMBER(1)            default 0,
   OCCUPATION           VARCHAR2(150),
   LOGOUT               NUMBER(1)            default 0 not null,
   LOGOUTREASON         VARCHAR2(300),
   LOGOUTDATE           DATE,
   CREATEUSER           VARCHAR2(60)         not null,
   UPDATEUSER           VARCHAR2(60),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PK_HOUSEHOLDSTAFFS_ID primary key (ID),
   constraint FK_CENSUSREGISTER_FAMILYID foreign key (FAMILYID)
   references CENSUSREGISTERFAMILYS (ID),
   constraint FK_ORGANIZATIONS_ORGID foreign key (ORGID)
   references ORGANIZATIONS (ID)
);

comment on column HOUSEHOLDSTAFFS.ORGID is
'所属网格';

comment on column HOUSEHOLDSTAFFS.ORGINTERNALCODE is
'所属网格编号';

comment on column HOUSEHOLDSTAFFS.FAMILYID is
'户籍家庭ID';

comment on column HOUSEHOLDSTAFFS.ACCOUNTNUMBER is
'户号';

comment on column HOUSEHOLDSTAFFS.RESIDENCETYPE is
'户口类别';

comment on column HOUSEHOLDSTAFFS.RELATIONSHIPWITHHEAD is
'与户主关系';

comment on column HOUSEHOLDSTAFFS.HOMEPHONE is
'住宅电话';

comment on column HOUSEHOLDSTAFFS.RESIDENTSTATUS is
'人户状态';

comment on column HOUSEHOLDSTAFFS.SETTLETIME is
'落户时间';

comment on column HOUSEHOLDSTAFFS.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column HOUSEHOLDSTAFFS.IMMIGRATIONDATE is
'迁入日期';

comment on column HOUSEHOLDSTAFFS.PROPERSTATIONCODE is
'原驻地代码';

comment on column HOUSEHOLDSTAFFS.PROPERSTATION is
'原驻地';

comment on column HOUSEHOLDSTAFFS.IMMIGRATIONSORT is
'迁入类别';

comment on column HOUSEHOLDSTAFFS.IMMIGRATIONCAUSE is
'迁入原因';

comment on column HOUSEHOLDSTAFFS.EMIGRATIONDATE is
'迁出日期';

comment on column HOUSEHOLDSTAFFS.EMIGRATIONCODE is
'迁出地代码';

comment on column HOUSEHOLDSTAFFS.EMIGRATIONLAND is
'迁出地';

comment on column HOUSEHOLDSTAFFS.EMIGRATIONSORT is
'迁出类别';

comment on column HOUSEHOLDSTAFFS.EMIGRATIONCAUSE is
'迁出原因';

comment on column HOUSEHOLDSTAFFS.HEALTHSTATE is
'健康状况';

comment on column HOUSEHOLDSTAFFS.MILITARYSERVICE is
'兵役状况';

comment on column HOUSEHOLDSTAFFS.ANNUALINCOME is
'年收入(万)';

comment on column HOUSEHOLDSTAFFS.INSURED is
'是否参加保险';

comment on column HOUSEHOLDSTAFFS.OUTGONEDIRECTION is
'外出去向';

comment on column HOUSEHOLDSTAFFS.SOLDIERDEPENDENTS is
'是否军属';

comment on column HOUSEHOLDSTAFFS.LOWINCOME is
'低保户';

comment on column HOUSEHOLDSTAFFS.HARDSTATE is
'困难状况';

comment on column HOUSEHOLDSTAFFS.ABROADDEPENDENTS is
'是否侨属';

comment on column HOUSEHOLDSTAFFS.ABROADDEPENDENTSTYPE is
'侨属类别';

comment on column HOUSEHOLDSTAFFS.STATUS is
'人员状态';

comment on column HOUSEHOLDSTAFFS.ISMOVED is
'是否迁移';

comment on column HOUSEHOLDSTAFFS.OCCUPATION is
'字符串类型职业';

comment on column HOUSEHOLDSTAFFS.LOGOUT is
'是否注销 0否 1是';

/*==============================================================*/
/* index: indexHouseholdStaffOrgCode                            */
/* index: indexHhsOrgCodeCreateDate                             */
/*==============================================================*/
Create index indexHouseholdStaffOrgCode on householdStaffs(orginternalcode);
Create index indexHhsOrgCodeCreateDate on householdStaffs(orginternalcode,createdate);
create index IDX_HOUSEHOLD_BASEINFOID on HOUSEHOLDSTAFFS (BASEINFOID);
create index IDX_HOUSEHOLD_ADSID on HOUSEHOLDSTAFFS (ADDRESSINFOID);
create index  IDX_HOUSEHOLD_FAMILYID  on  householdstaffs (FAMILYID ASC);
/*==============================================================*/
/* Table: FLOATINGPOPULATIONS                                   */
/*==============================================================*/
create table FLOATINGPOPULATIONS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(50),
   ISINFLOWING          NUMBER(1)            default 0,
   INFLOWINGREASON      NUMBER(10),
   INFLOWINGDATE        DATE,
   INFLOWINGPROVINCE    VARCHAR2(60),
   INFLOWINGCITY        VARCHAR2(60),
   INFLOWINGDISTRICT    VARCHAR2(60),
   REGISTRATIONTYPE     NUMBER(10),
   REGISTERDATE         DATE,
   EXPECTEDDATEDUE      DATE,
   RESIDENCETYPE        NUMBER(10),
   CERTIFICATENUMBER    VARCHAR2(60),
   STAYLOCATIONTYPEID   NUMBER(10),
   ECONOMYSOURCEID      NUMBER(10),
   STAYTIMELIMITID      NUMBER(10),
   PREPAREDSTAYTIMELIMITID NUMBER(10),
   HASMARRIEDPROVE      NUMBER(1),
   SETTLETIME           VARCHAR2(30),
   SOURCESSTATE         NUMBER(1)            default 1,
   OLDCURRENTADDRESS    VARCHAR2(150),
   TOBERASTATE          NUMBER(10),
   HOUSEHOLDTYPE        NUMBER(10),
   PROFESSIONALQUALIFICATIONS NUMBER(10),
   ISCOUPLESPEER        NUMBER(1),
   PREGNANCYANDCONTRACEPTIONCASE NUMBER(10),
   FERTILITYNO          VARCHAR2(45),
   BOYCHILDRENNO        NUMBER(2),
   GIRLCHILDRENNO       NUMBER(2),
   CARTYPE              VARCHAR2(60),
   CARCOLOR             VARCHAR2(30),
   CARPLATE             VARCHAR2(45),
   LOGOUT               NUMBER(1)            default 0,
   LOGOUTREASON         VARCHAR2(300),
   LOGOUTDATE           DATE,
   CREATEUSER           VARCHAR2(60)         not null,
   UPDATEUSER           VARCHAR2(60),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PKFLOATINGPOPULATIONS primary key (ID),
   constraint fkFloatingPopulationsOrg foreign key (orgId)
         references organizations (id)
);

comment on table FLOATINGPOPULATIONS is
'流动人口';

comment on column FLOATINGPOPULATIONS.ORGID is
'所属网格';

comment on column FLOATINGPOPULATIONS.ORGINTERNALCODE is
'部门内部编码';

comment on column FLOATINGPOPULATIONS.ISINFLOWING is
'是否流入';

comment on column FLOATINGPOPULATIONS.INFLOWINGREASON is
'流入原因';

comment on column FLOATINGPOPULATIONS.INFLOWINGDATE is
'流入时间';

comment on column FLOATINGPOPULATIONS.INFLOWINGPROVINCE is
'流入来源省';

comment on column FLOATINGPOPULATIONS.INFLOWINGCITY is
'流入来源市';

comment on column FLOATINGPOPULATIONS.INFLOWINGDISTRICT is
'流入来源县';

comment on column FLOATINGPOPULATIONS.REGISTRATIONTYPE is
'登记证情况';

comment on column FLOATINGPOPULATIONS.REGISTERDATE is
'登记日期';

comment on column FLOATINGPOPULATIONS.EXPECTEDDATEDUE is
'预期到期日期';

comment on column FLOATINGPOPULATIONS.RESIDENCETYPE is
'文化程度';

comment on column FLOATINGPOPULATIONS.CERTIFICATENUMBER is
'证件编号';

comment on column FLOATINGPOPULATIONS.STAYLOCATIONTYPEID is
'暂住处所';

comment on column FLOATINGPOPULATIONS.ECONOMYSOURCEID is
'经济来源';

comment on column FLOATINGPOPULATIONS.STAYTIMELIMITID is
'居住时限';

comment on column FLOATINGPOPULATIONS.PREPAREDSTAYTIMELIMITID is
'预居住时限';

comment on column FLOATINGPOPULATIONS.HASMARRIEDPROVE is
'是否有婚育证明';

comment on column FLOATINGPOPULATIONS.SETTLETIME is
'转为流动人口的时间';

comment on column FLOATINGPOPULATIONS.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column FLOATINGPOPULATIONS.TOBERASTATE is
'生育状况';

comment on column FLOATINGPOPULATIONS.HOUSEHOLDTYPE is
'原户口类型';

comment on column FLOATINGPOPULATIONS.PROFESSIONALQUALIFICATIONS is
'职称技术等级';

comment on column FLOATINGPOPULATIONS.ISCOUPLESPEER is
'夫妻是否同行';

comment on column FLOATINGPOPULATIONS.PREGNANCYANDCONTRACEPTIONCASE is
'怀孕避孕情况';

comment on column FLOATINGPOPULATIONS.FERTILITYNO is
'婚育证明号';

comment on column FLOATINGPOPULATIONS.BOYCHILDRENNO is
'拥有子女中的男孩数';

comment on column FLOATINGPOPULATIONS.GIRLCHILDRENNO is
'拥有子女中的女孩数';

comment on column FLOATINGPOPULATIONS.CARTYPE is
'车辆类型';

comment on column FLOATINGPOPULATIONS.CARCOLOR is
'车辆颜色';

comment on column FLOATINGPOPULATIONS.CARPLATE is
'车辆号牌';

comment on column FLOATINGPOPULATIONS.LOGOUT is
'是否注销';

comment on column FLOATINGPOPULATIONS.CREATEUSER is
'创建用户';

comment on column FLOATINGPOPULATIONS.UPDATEUSER is
'修改用户';

comment on column FLOATINGPOPULATIONS.CREATEDATE is
'创建日期';

comment on column FLOATINGPOPULATIONS.UPDATEDATE is
'修改时间';

/*==============================================================*/
/* index: indexFloatingPopulationOrgCode                        */
/* index: indexFpOrgCodeCreateDate                              */
/*==============================================================*/
Create index indexFloatingPopulationOrgCode on floatingpopulations(orginternalcode);
Create index indexFpOrgCodeCreateDate on floatingpopulations(orginternalcode,createdate);
create index IDX_FLOATING_BASEINFOID on FLOATINGPOPULATIONS (BASEINFOID);
create index IDX_FLOATING_ADSID on FLOATINGPOPULATIONS (ADDRESSINFOID);
/*==============================================================*/
/* Table: DRUGGYS                                               */
/*==============================================================*/
create table DRUGGYS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32)         not null,
   DRUGREASON           NUMBER(10),
   DRUGSOURCE           NUMBER(10),
   DETOXICATECASE       NUMBER(10),
   DETOXICATECONDITION  NUMBER(10),
   ISADANON             NUMBER(1)            default 0,
   CONTROLACTUALITY     VARCHAR2(150),
   DRUGTYPE             VARCHAR2(150),
   FERRETOUTDATE        DATE,
   DRUGFRISTDATE        DATE,
   ISUNDERGO_TREATMENT  NUMBER(1),
   OLDCURRENTADDRESS    VARCHAR2(150),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   UPDATEUSER           VARCHAR2(32),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PKDRUGGYS primary key (ID),
   constraint fkDruggysOrg foreign key (orgId)
         references organizations (id)
);

comment on table DRUGGYS is
'吸毒者信息';

comment on column DRUGGYS.ID is
'人员id';

comment on column DRUGGYS.ORGID is
'所属网格';

comment on column DRUGGYS.ORGINTERNALCODE is
'所属责任区编号';

comment on column DRUGGYS.DRUGREASON is
'吸毒原因';

comment on column DRUGGYS.DRUGSOURCE is
'毒品来源';

comment on column DRUGGYS.DETOXICATECASE is
'戒毒情况';

comment on column DRUGGYS.DETOXICATECONDITION is
'是否在吸';

comment on column DRUGGYS.ISADANON is
'是否服美沙酮戒毒';

comment on column DRUGGYS.CONTROLACTUALITY is
'管控现状';

comment on column DRUGGYS.DRUGTYPE is
'滥用毒品种类';

comment on column DRUGGYS.FERRETOUTDATE is
'查获日期';

comment on column DRUGGYS.ISUNDERGO_TREATMENT is
'目前是否在接受治疗';

comment on column DRUGGYS.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column DRUGGYS.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column DRUGGYS.ISEMPHASIS is
'是否关注';

comment on column DRUGGYS.CREATEUSER is
'创建用户';

comment on column DRUGGYS.UPDATEUSER is
'修改用户';

comment on column DRUGGYS.CREATEDATE is
'创建日期';

comment on column DRUGGYS.UPDATEDATE is
'修改时间';


/*==============================================================*/
/* Index: idx_D_orgIntCodeAndisEmphasis                           */
/*==============================================================*/
create index idx_D_orgIntCodeAndisEmphasis on druggys (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_DRUGGYS_BASEINFOID on DRUGGYS (BASEINFOID);
create index IDX_DRUGGYS_ADSID on DRUGGYS (ADDRESSINFOID);
/*==============================================================*/
/* Table: AIDNEEDPOPULATION                                     */
/*==============================================================*/
create table AIDNEEDPOPULATION 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32),
   AIDREASON            NUMBER(10),
   ISLOWHOUSEHOLDS      NUMBER(1)            default 0,
   DIFFICULTCARDNO      VARCHAR2(90),
   DIFFICULTTYPE        NUMBER(10),
   SUBSIDIESAMOUNT      NUMBER(10,4),
   SUBSIDIESGETTIME     DATE,
   SUBSIDIESSTARTTIME   DATE,
   SUBSIDIESPOPULATION  NUMBER(3),
   SUBSIDIESAREA        VARCHAR2(150),
   OLDCURRENTADDRESS    VARCHAR2(150),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   UPDATEUSER           VARCHAR2(32),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PKAIDNEEDPOPULATION primary key (ID),
   constraint fkAidNeedPopulationOrg foreign key (orgId)
         references organizations (id)
);

comment on table AIDNEEDPOPULATION is
'需救助人员';

comment on column AIDNEEDPOPULATION.ORGID is
'所属网格';

comment on column AIDNEEDPOPULATION.ORGINTERNALCODE is
'所属网格编号';

comment on column AIDNEEDPOPULATION.AIDREASON is
'救助原因';

comment on column AIDNEEDPOPULATION.ISLOWHOUSEHOLDS is
'是否低保户';

comment on column AIDNEEDPOPULATION.DIFFICULTCARDNO is
'困难证号';

comment on column AIDNEEDPOPULATION.DIFFICULTTYPE is
'困难类型';

comment on column AIDNEEDPOPULATION.SUBSIDIESAMOUNT is
'领取金额';

comment on column AIDNEEDPOPULATION.SUBSIDIESGETTIME is
'领取时间';

comment on column AIDNEEDPOPULATION.SUBSIDIESSTARTTIME is
'享受起始时间';

comment on column AIDNEEDPOPULATION.SUBSIDIESPOPULATION is
'享受人数';

comment on column AIDNEEDPOPULATION.SUBSIDIESAREA is
'享受地区';

comment on column AIDNEEDPOPULATION.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column AIDNEEDPOPULATION.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column AIDNEEDPOPULATION.ISEMPHASIS is
'是否关注';

comment on column AIDNEEDPOPULATION.CREATEUSER is
'创建用户';

comment on column AIDNEEDPOPULATION.UPDATEUSER is
'修改用户';

comment on column AIDNEEDPOPULATION.CREATEDATE is
'创建日期';

comment on column AIDNEEDPOPULATION.UPDATEDATE is
'修改时间';


/*==============================================================*/
/* Index: idx_ai_orgIntCodeAndisEmphasis                     */
/*==============================================================*/
create index idx_ai_orgIntCodeAndisEmphasis on aidNeedPopulation (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_AIDNEED_BASEINFOID on AIDNEEDPOPULATION (BASEINFOID);
create index IDX_AIDNEED_ADSID on AIDNEEDPOPULATION (ADDRESSINFOID);
/*==============================================================*/
/* Table: AIDSPOPULATIONS                                       */
/*==============================================================*/
create table AIDSPOPULATIONS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(50),
   ADDRESSNO            VARCHAR2(60),
   INFECTWAY            NUMBER(10),
   VIOLATIONSOFTHELAW   NUMBER(10),
   CRIMETYPE            NUMBER(10),
   RECEIVEDORGANIZATION VARCHAR2(60),
   RECEIVEDLEVEL        NUMBER(10),
   HELPCIRCUMSTANCES    NUMBER(10),
   ACTUALPOPULATIONTYPE VARCHAR2(50),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   UPDATEUSER           VARCHAR2(32),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PKAIDSPOPULATIONS primary key (ID),
   constraint fkAidsPopulationsOrg foreign key (orgId)
         references organizations (id)  
);

comment on table AIDSPOPULATIONS is
'艾滋病人员';

comment on column AIDSPOPULATIONS.ID is
'ID';

comment on column AIDSPOPULATIONS.ORGID is
'所属网格id';

comment on column AIDSPOPULATIONS.ORGINTERNALCODE is
'所属网格code';

comment on column AIDSPOPULATIONS.ADDRESSNO is
'地址编号';

comment on column AIDSPOPULATIONS.INFECTWAY is
'感染途径';

comment on column AIDSPOPULATIONS.VIOLATIONSOFTHELAW is
'违法情况';

comment on column AIDSPOPULATIONS.CRIMETYPE is
'犯罪类型';

comment on column AIDSPOPULATIONS.RECEIVEDORGANIZATION is
'收治机构';

comment on column AIDSPOPULATIONS.RECEIVEDLEVEL is
'收治机构所属层级';

comment on column AIDSPOPULATIONS.HELPCIRCUMSTANCES is
'帮扶情况';

comment on column AIDSPOPULATIONS.ACTUALPOPULATIONTYPE is
'实口类型';

comment on column AIDSPOPULATIONS.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column AIDSPOPULATIONS.ATTENTIONEXTENT is
'关注程度';

comment on column AIDSPOPULATIONS.ISEMPHASIS is
'是否关注';

comment on column AIDSPOPULATIONS.ISEMPHASISREASON is
'关注原因';

comment on column AIDSPOPULATIONS.ISEMPHASISDATE is
'关注日期';

comment on column AIDSPOPULATIONS.CREATEUSER is
'创建用户';

comment on column AIDSPOPULATIONS.UPDATEUSER is
'修改用户';

comment on column AIDSPOPULATIONS.CREATEDATE is
'创建日期';

comment on column AIDSPOPULATIONS.UPDATEDATE is
'修改时间';

/*==============================================================*/
/* index: index_Ai_OrgCodeAndIsemphasis                           */
/*==============================================================*/
create index index_Ai_OrgCodeAndIsemphasis on AIDSPOPULATIONS (ORGINTERNALCODE, ISEMPHASIS);
create index IDX_AIDSPOPULATION_BASEINFOID on AIDSPOPULATIONS (BASEINFOID);
create index IDX_AIDSPOPULATION_ADSID on AIDSPOPULATIONS (ADDRESSINFOID);

/*==============================================================*/
/* Table: DANGEROUSGOODSPRACTITIONERS                           */
/*==============================================================*/
create table DANGEROUSGOODSPRACTITIONERS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32)         not null,
   DANGEROUSWORKINGTYPE NUMBER(10),
   LEGALPERSON          VARCHAR2(60),
   LEGALPERSONTELEPHONE VARCHAR2(80),
   LEGALPERSONMOBILENUMBER VARCHAR2(50),
   WORKINGCERTIFICATE   VARCHAR2(150),
   WORKINGCERTIFICATENO VARCHAR2(150),
   HEALTHSTATE          NUMBER(10),
   PERIODOFVALIDITYSTART DATE,
   PERIODOFVALIDITYEND  DATE,
   SCHOOL               VARCHAR2(150),
   RESIDENCETYPE        NUMBER(10),
   OLDCURRENTADDRESS    VARCHAR2(150),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(60)         not null,
   UPDATEUSER           VARCHAR2(60),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PKDANGEROUSGOODSPRACTITIONERS primary key (ID),
   constraint fkDangerGoodsPractitionersOrg foreign key (orgId)
         references organizations (id)
);

comment on table DANGEROUSGOODSPRACTITIONERS is
'危险品从业人员';

comment on column DANGEROUSGOODSPRACTITIONERS.ID is
'主键';

comment on column DANGEROUSGOODSPRACTITIONERS.ORGID is
'所属网格';

comment on column DANGEROUSGOODSPRACTITIONERS.ORGINTERNALCODE is
'所属责任区编号';

comment on column DANGEROUSGOODSPRACTITIONERS.DANGEROUSWORKINGTYPE is
'危险从业类别';

comment on column DANGEROUSGOODSPRACTITIONERS.LEGALPERSON is
'法人';

comment on column DANGEROUSGOODSPRACTITIONERS.LEGALPERSONTELEPHONE is
'法人电话';

comment on column DANGEROUSGOODSPRACTITIONERS.LEGALPERSONMOBILENUMBER is
'法人手机';

comment on column DANGEROUSGOODSPRACTITIONERS.WORKINGCERTIFICATE is
'从业资格证';

comment on column DANGEROUSGOODSPRACTITIONERS.WORKINGCERTIFICATENO is
'从业资格证号';

comment on column DANGEROUSGOODSPRACTITIONERS.HEALTHSTATE is
'健康状态';

comment on column DANGEROUSGOODSPRACTITIONERS.PERIODOFVALIDITYSTART is
'有效开始日期';

comment on column DANGEROUSGOODSPRACTITIONERS.PERIODOFVALIDITYEND is
'有效结束日期';

comment on column DANGEROUSGOODSPRACTITIONERS.SCHOOL is
'就读学校';

comment on column DANGEROUSGOODSPRACTITIONERS.RESIDENCETYPE is
'户口类别';

comment on column DANGEROUSGOODSPRACTITIONERS.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column DANGEROUSGOODSPRACTITIONERS.CREATEUSER is
'创建用户';

comment on column DANGEROUSGOODSPRACTITIONERS.UPDATEUSER is
'修改用户';

comment on column DANGEROUSGOODSPRACTITIONERS.CREATEDATE is
'创建日期';

comment on column DANGEROUSGOODSPRACTITIONERS.UPDATEDATE is
'修改时间';


/*==============================================================*/
/* Index: idx_DGP_orgIntCodeAndisEmphasis                       */
/*==============================================================*/
create index idx_DGP_orgCodeAndisEmphasis on dangerousGoodsPractitioners (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_DANGEROUS_BASEINFOID on DANGEROUSGOODSPRACTITIONERS (BASEINFOID);
create index IDX_DANGEROUS_ADSID on DANGEROUSGOODSPRACTITIONERS (ADDRESSINFOID);
/*==============================================================*/
/* Table: ELDERLYPEOPLE                                         */
/*==============================================================*/
create table ELDERLYPEOPLE 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32)         not null,
   ENTERWORKDATE        DATE,
   RETIREDATE           DATE,
   PENSION              NUMBER(11,2),
   LIVESTATUS           NUMBER(10),
   PEOPLETYPE           NUMBER(10),
   SPOUSESTATUS         NUMBER(10),
   CURRENTSTATUS        NUMBER(10),
   INCOMESOURCE         NUMBER(10),
   RETIREUNITANDDUTY    VARCHAR2(100),
   ELDERPEOPLEID        VARCHAR2(60),
   ZHIWU                VARCHAR2(60),
   BEIZHU               VARCHAR2(160),
   OLDCURRENTADDRESS    VARCHAR2(150),
   RESIDENCETYPE        NUMBER(10),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   CREATEDATE           DATE                 not null,
   UPDATEUSER           VARCHAR2(32),
   UPDATEDATE           DATE,
   constraint PKELDERLYPEOPLE primary key (ID),
   constraint fkelderlyPeopleOrg foreign key (orgId)
		references organizations (id)
);

comment on table ELDERLYPEOPLE is
'老年人';

comment on column ELDERLYPEOPLE.ID is
'ID';

comment on column ELDERLYPEOPLE.ORGID is
'所属网格';

comment on column ELDERLYPEOPLE.ORGINTERNALCODE is
'所属网格编号';

comment on column ELDERLYPEOPLE.ENTERWORKDATE is
'参加工作日期';

comment on column ELDERLYPEOPLE.RETIREDATE is
'离退休日期';

comment on column ELDERLYPEOPLE.PENSION is
'退休金';

comment on column ELDERLYPEOPLE.LIVESTATUS is
'居住情况';

comment on column ELDERLYPEOPLE.PEOPLETYPE is
'特殊人员';

comment on column ELDERLYPEOPLE.SPOUSESTATUS is
'配偶情况';

comment on column ELDERLYPEOPLE.CURRENTSTATUS is
'目前情况';

comment on column ELDERLYPEOPLE.INCOMESOURCE is
'经济来源';

comment on column ELDERLYPEOPLE.RETIREUNITANDDUTY is
'离退休单位';

comment on column ELDERLYPEOPLE.ELDERPEOPLEID is
'老年人证号';

comment on column ELDERLYPEOPLE.ZHIWU is
'离退休单位职位';

comment on column ELDERLYPEOPLE.BEIZHU is
'业务信息备注';

comment on column ELDERLYPEOPLE.RESIDENCETYPE is
'户口类别';

comment on column ELDERLYPEOPLE.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column ELDERLYPEOPLE.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column ELDERLYPEOPLE.ISEMPHASIS is
'是否注销';

comment on column ELDERLYPEOPLE.CREATEUSER is
'创建用户';

comment on column ELDERLYPEOPLE.CREATEDATE is
'创建时间';

comment on column ELDERLYPEOPLE.UPDATEUSER is
'修改用户';

comment on column ELDERLYPEOPLE.UPDATEDATE is
'修改时间';


/*==============================================================*/
/* Index: idx_IY_orgIntCodeAndisEmphasis                        */
/*==============================================================*/
create index idx_el_orgIntCodeAndisEmphasis on ELDERLYPEOPLE (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_ELDERLY_BASEINFOID on ELDERLYPEOPLE (BASEINFOID);
create index IDX_ELDERLY_ADSID on ELDERLYPEOPLE (ADDRESSINFOID);
/*==============================================================*/
/* Table: HANDICAPPEDS                                          */
/*==============================================================*/
create table HANDICAPPEDS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32),
   HADDISABILITYCARD    NUMBER(1),
   DISABILITYREASON     VARCHAR2(150),
   DISABILITYTYPE       NUMBER(10),
   DISABILITYCARDNO     VARCHAR2(30),
   DISABILITY           NUMBER(10),
   DISABILITYDATE       DATE,
   WORKPROFILE          NUMBER(10),
   SKILLPROFILE         NUMBER(10),
   GUARDIANNAME         VARCHAR2(60),
   GUARDIANTELEPHONE    VARCHAR2(15),
   GUARDIANMOBILENUMBER VARCHAR2(11),
   OLDCURRENTADDRESS    VARCHAR2(150),
   RESIDENCETYPE        NUMBER(10),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   UPDATEUSER           VARCHAR2(32),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PK_HANDICAPPEDS primary key (ID),
   constraint fk_HandicappedsOrg foreign key (orgId)
         references organizations (id)
);

comment on table HANDICAPPEDS is
'残疾人';

comment on column HANDICAPPEDS.ID is
'残疾人ID';

comment on column HANDICAPPEDS.ORGID is
'所属网格';

comment on column HANDICAPPEDS.ORGINTERNALCODE is
'所属网格编号';

comment on column HANDICAPPEDS.HADDISABILITYCARD is
'是否有残疾证';

comment on column HANDICAPPEDS.DISABILITYREASON is
'残疾原因';

comment on column HANDICAPPEDS.DISABILITYTYPE is
'残疾类别';

comment on column HANDICAPPEDS.DISABILITYCARDNO is
'残疾证号';

comment on column HANDICAPPEDS.DISABILITY is
'残疾状况';

comment on column HANDICAPPEDS.DISABILITYDATE is
'残疾时间';

comment on column HANDICAPPEDS.WORKPROFILE is
'劳动能力';

comment on column HANDICAPPEDS.SKILLPROFILE is
'技能特长';

comment on column HANDICAPPEDS.GUARDIANNAME is
'监护人名字';

comment on column HANDICAPPEDS.GUARDIANTELEPHONE is
'监护人电话';

comment on column HANDICAPPEDS.GUARDIANMOBILENUMBER is
'监护人手机号码';

comment on column HANDICAPPEDS.RESIDENCETYPE is
'户口类别';

comment on column HANDICAPPEDS.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column HANDICAPPEDS.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column HANDICAPPEDS.ISEMPHASIS is
'是否注销';

comment on column HANDICAPPEDS.CREATEUSER is
'创建用户';

comment on column HANDICAPPEDS.UPDATEUSER is
'修改用户';

comment on column HANDICAPPEDS.CREATEDATE is
'创建时间';

comment on column HANDICAPPEDS.UPDATEDATE is
'修改时间';


/*==============================================================*/
/* Index: idx_ha_orgIntCodeAndisEmphasis                        */
/*==============================================================*/
create index idx_ha_orgIntCodeAndisEmphasis on HANDICAPPEDS (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_HANDICAPPED_BASEINFOID on HANDICAPPEDS (BASEINFOID);
create index IDX_HANDICAPPED_ADSID on HANDICAPPEDS (ADDRESSINFOID);
/*==============================================================*/
/* Table: IDLEYOUTHS                                            */
/*==============================================================*/
create table IDLEYOUTHS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32),
   WORKCONDITION        VARCHAR2(300),
   STAFFTYPE            NUMBER(10),
   GUARDIANNAME         VARCHAR2(60),
   GUARDIANTELEPHONE    VARCHAR2(15),
   GUARDIANMOBILENUMBER VARCHAR2(11),
   ISSTAYINSCHOOL       NUMBER(1)            default 0,
   SCHOOLNAME           VARCHAR2(90),
   OLDCURRENTADDRESS    VARCHAR2(150),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   UPDATEUSER           VARCHAR2(32),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PKIDLEYOUTHS primary key (ID),
   constraint fkIdleYouthsOrg foreign key (orgId)
         references organizations (id)
);

comment on table IDLEYOUTHS is
'重点青少年';

comment on column IDLEYOUTHS.ORGID is
'所属网格';

comment on column IDLEYOUTHS.ORGINTERNALCODE is
'所属网格编号';

comment on column IDLEYOUTHS.STAFFTYPE is
'人员类型';

comment on column IDLEYOUTHS.GUARDIANNAME is
'监护人';

comment on column IDLEYOUTHS.GUARDIANTELEPHONE is
'监护人电话';

comment on column IDLEYOUTHS.GUARDIANMOBILENUMBER is
'监护人手机号码';

comment on column IDLEYOUTHS.ISSTAYINSCHOOL is
'是否在校住宿';

comment on column IDLEYOUTHS.SCHOOLNAME is
'学校名称';

comment on column IDLEYOUTHS.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column IDLEYOUTHS.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column IDLEYOUTHS.ISEMPHASIS is
'是否关注';

comment on column IDLEYOUTHS.CREATEUSER is
'创建用户';

comment on column IDLEYOUTHS.UPDATEUSER is
'修改用户';

comment on column IDLEYOUTHS.CREATEDATE is
'创建日期';

comment on column IDLEYOUTHS.UPDATEDATE is
'修改时间';


/*==============================================================*/
/* Index: idx_IY_orgIntCodeAndisEmphasis                        */
/*==============================================================*/
create index idx_IY_orgIntCodeAndisEmphasis on idleYouths (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_IDLEYOUTH_BASEINFOID on IDLEYOUTHS (BASEINFOID);
create index IDX_IDLEYOUTH_ADSID on IDLEYOUTHS (ADDRESSINFOID);
/*==============================================================*/
/* Table: MENTALPATIENTS                                        */
/*==============================================================*/
create table MENTALPATIENTS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32)         not null,
   HEALTHSTATE          NUMBER(10),
   ADDRESS              VARCHAR2(150),
   PSYCHOSISNAME        VARCHAR2(150),
   PSYCHOSISTYPE        NUMBER(10),
   DANGERLEVEL          NUMBER(10),
   ISTREAT              NUMBER(1),
   CUREDEPARTMENT       VARCHAR2(150),
   BUSINESSREMARK       VARCHAR2(900),
   GUARDIAN             VARCHAR2(60),
   GUARDIANTELEPHONE    VARCHAR2(80),
   GUARDIANMOBILENUMBER VARCHAR2(50),
   DISEASETIME          DATE,
   TREATMENTSTATE       NUMBER(10),
   RECOVERYTIME         DATE,
   ISUNDERGO_TREATMENT  NUMBER(1),
   SCHOOL               VARCHAR2(150),
   OLDCURRENTADDRESS    VARCHAR2(150),
   RESIDENCETYPE        NUMBER(10),
   SOURCESSTATE         NUMBER(1)            default 1,
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   CREATEDATE           DATE                 not null,
   UPDATEUSER           VARCHAR2(32),
   UPDATEDATE           DATE,
   constraint PKMENTALPATIENTS primary key (ID),
   constraint fkMentalPatientsOrg foreign key (orgId)
         references organizations (id)
);

comment on table MENTALPATIENTS is
'严重精神障碍患者';

comment on column MENTALPATIENTS.ID is
'ID';

comment on column MENTALPATIENTS.ORGID is
'所属网格';

comment on column MENTALPATIENTS.ORGINTERNALCODE is
'所属责任区编号';

comment on column MENTALPATIENTS.HEALTHSTATE is
'健康状况';

comment on column MENTALPATIENTS.PSYCHOSISNAME is
'患病名称';

comment on column MENTALPATIENTS.PSYCHOSISTYPE is
'精神病类型';

comment on column MENTALPATIENTS.DANGERLEVEL is
'发病危险等级';

comment on column MENTALPATIENTS.ISTREAT is
'是否接受过精神病治疗';

comment on column MENTALPATIENTS.CUREDEPARTMENT is
'康复机构';

comment on column MENTALPATIENTS.BUSINESSREMARK is
'业务信息备注';

comment on column MENTALPATIENTS.GUARDIAN is
'监护人';

comment on column MENTALPATIENTS.GUARDIANTELEPHONE is
'监护人联系电话';

comment on column MENTALPATIENTS.GUARDIANMOBILENUMBER is
'监护人移动电话';

comment on column MENTALPATIENTS.DISEASETIME is
'发病时间';

comment on column MENTALPATIENTS.TREATMENTSTATE is
'治疗状态';

comment on column MENTALPATIENTS.RECOVERYTIME is
'康复时间';

comment on column MENTALPATIENTS.ISUNDERGO_TREATMENT is
'目前是否在接受治疗';

comment on column MENTALPATIENTS.SCHOOL is
'就读学校';

comment on column MENTALPATIENTS.RESIDENCETYPE is
'户口类别';

comment on column MENTALPATIENTS.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column MENTALPATIENTS.ISEMPHASIS is
'是否关注';

comment on column MENTALPATIENTS.CREATEUSER is
'创建用户';

comment on column MENTALPATIENTS.CREATEDATE is
'创建日期';

comment on column MENTALPATIENTS.UPDATEUSER is
'修改用户';

comment on column MENTALPATIENTS.UPDATEDATE is
'修改时间';

/*==============================================================*/
/* Index: idx_MP_orgIntCodeAndisEmphasis                        */
/*==============================================================*/
create index idx_MP_orgIntCodeAndisEmphasis on mentalPatients (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_MENTALPATIENT_BASEINFOID on MENTALPATIENTS (BASEINFOID);
create index IDX_MENTALPATIENT_ADSID on MENTALPATIENTS (ADDRESSINFOID);

/*==============================================================*/
/* Table: UNEMPLOYEDPEOPLE                                      */
/*==============================================================*/
create table UNEMPLOYEDPEOPLE 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32)         not null,
   RESIDENCETYPE        NUMBER(10),
   UNEMPLOYEDPEOPLETYPE NUMBER(10),
   REGISTERNUMBER       VARCHAR2(60),
   ORIGINALWORKUNIT     VARCHAR2(100),
   ORIGINALWORKUNITTYPE VARCHAR2(60),
   ENTERWORKDATE        DATE,
   UNEMPLOYMENTDATE     DATE,
   TECHNOLOGYLEVEL      NUMBER(10),
   SPECIALTYSKILLS      VARCHAR2(150),
   UNEMPLOYMENTREASON   NUMBER(10),
   TITLE                VARCHAR2(30),
   PARTICIPATEDPROGRAMS VARCHAR2(600),
   WORKSTATE            NUMBER(10),
   SKILL                NUMBER(10),
   JOBINTENTION         VARCHAR2(100),
   MONTHLYWAGES         NUMBER(10,2),
   ISDEALWITHLOW        NUMBER(1)            default 0,
   ISENJOYUNEMPLOYMENTMONEY NUMBER(1)            default 0,
   ENDDATEOFUNEMPLOYMENTMONEY DATE,
   HEADNAME             VARCHAR2(60),
   FAMILYID             VARCHAR2(32),
   OLDCURRENTADDRESS    VARCHAR2(150),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   CREATEDATE           DATE                 not null,
   UPDATEUSER           VARCHAR2(32),
   UPDATEDATE           DATE,
   constraint PKUNEMPLOYEDPEOPLE primary key (ID),
   constraint fkunemployedPeopleOrg foreign key (orgId)
		references organizations (id)
);

comment on table UNEMPLOYEDPEOPLE is
'失业人员';

comment on column UNEMPLOYEDPEOPLE.ID is
'ID';

comment on column UNEMPLOYEDPEOPLE.ORGID is
'所属网格';

comment on column UNEMPLOYEDPEOPLE.ORGINTERNALCODE is
'所属网格编号';

comment on column UNEMPLOYEDPEOPLE.RESIDENCETYPE is
'户口类别';

comment on column UNEMPLOYEDPEOPLE.UNEMPLOYEDPEOPLETYPE is
'人员类型';

comment on column UNEMPLOYEDPEOPLE.REGISTERNUMBER is
'就业/失业登记证号';

comment on column UNEMPLOYEDPEOPLE.ORIGINALWORKUNIT is
'原工作单位';

comment on column UNEMPLOYEDPEOPLE.ORIGINALWORKUNITTYPE is
'原工作单位类型';

comment on column UNEMPLOYEDPEOPLE.ENTERWORKDATE is
'参加工作时间';

comment on column UNEMPLOYEDPEOPLE.UNEMPLOYMENTDATE is
'失业时间';

comment on column UNEMPLOYEDPEOPLE.TECHNOLOGYLEVEL is
'技术等级';

comment on column UNEMPLOYEDPEOPLE.SPECIALTYSKILLS is
'特长技能';

comment on column UNEMPLOYEDPEOPLE.UNEMPLOYMENTREASON is
'失业原因';

comment on column UNEMPLOYEDPEOPLE.TITLE is
'职称';

comment on column UNEMPLOYEDPEOPLE.WORKSTATE is
'就业状况';

comment on column UNEMPLOYEDPEOPLE.SKILL is
'技能特长';

comment on column UNEMPLOYEDPEOPLE.JOBINTENTION is
'求职意向';

comment on column UNEMPLOYEDPEOPLE.MONTHLYWAGES is
'求职月工资';

comment on column UNEMPLOYEDPEOPLE.ISDEALWITHLOW is
'已办理低保（是否）0否1是';

comment on column UNEMPLOYEDPEOPLE.ISENJOYUNEMPLOYMENTMONEY is
'享受失业保障金（是否）0否1是';

comment on column UNEMPLOYEDPEOPLE.ENDDATEOFUNEMPLOYMENTMONEY is
'失业保障金结束日期';

comment on column UNEMPLOYEDPEOPLE.HEADNAME is
'户主姓名';

comment on column UNEMPLOYEDPEOPLE.FAMILYID is
'户号';

comment on column UNEMPLOYEDPEOPLE.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column UNEMPLOYEDPEOPLE.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column UNEMPLOYEDPEOPLE.ISEMPHASIS is
'是否注销';

comment on column UNEMPLOYEDPEOPLE.CREATEUSER is
'创建用户';

comment on column UNEMPLOYEDPEOPLE.CREATEDATE is
'创建时间';

comment on column UNEMPLOYEDPEOPLE.UPDATEUSER is
'修改用户';

comment on column UNEMPLOYEDPEOPLE.UPDATEDATE is
'修改时间';

/*==============================================================*/
/* Index: idx_unem_orgIntCodeAndisEmphasis                       */
/*==============================================================*/
create index idx_unem_orgCodeAndisEmphasis on UNEMPLOYEDPEOPLE (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_UNEMPLOYED_BASEINFOID on UNEMPLOYEDPEOPLE (BASEINFOID);
create index IDX_UNEMPLOYED_ADSID on UNEMPLOYEDPEOPLE (ADDRESSINFOID);

/*==============================================================*/
/* Table: SUPERIORVISITS                                        */
/*==============================================================*/
create table SUPERIORVISITS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32)         not null,
   VISITSTATE           NUMBER(10),
   VISITTYPE            NUMBER(10),
   VISITREASON          VARCHAR2(900),
   NATIVEPLACE          VARCHAR2(60),
   RESIDENCETYPE        NUMBER(10),
   OLDCURRENTADDRESS    VARCHAR2(150),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   CREATEDATE           DATE                 not null,
   UPDATEUSER           VARCHAR2(32),
   UPDATEDATE           DATE,
   constraint PKSUPERIORVISITS primary key (ID),
   constraint fkSuperiorVisitsOrg foreign key (orgId)
         references organizations (id)
);

comment on table SUPERIORVISITS is
'信访上访人员';

comment on column SUPERIORVISITS.ID is
'信访上访人员ID';

comment on column SUPERIORVISITS.ORGID is
'所属网格';

comment on column SUPERIORVISITS.ORGINTERNALCODE is
'所属责任区编号';

comment on column SUPERIORVISITS.VISITSTATE is
'上访状态';

comment on column SUPERIORVISITS.VISITTYPE is
'上访类型';

comment on column SUPERIORVISITS.VISITREASON is
'信访原因';

comment on column SUPERIORVISITS.NATIVEPLACE is
'户籍';

comment on column SUPERIORVISITS.RESIDENCETYPE is
'户口类别';

comment on column SUPERIORVISITS.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column SUPERIORVISITS.ISEMPHASIS is
'是否关注';

comment on column SUPERIORVISITS.CREATEUSER is
'创建用户';

comment on column SUPERIORVISITS.CREATEDATE is
'创建日期';

comment on column SUPERIORVISITS.UPDATEUSER is
'修改用户';

comment on column SUPERIORVISITS.UPDATEDATE is
'修改时间';

/*==============================================================*/
/* Index: idx_SV_orgIntCodeAndisEmphasis                        */
/* Index: idx_SuperiorVisit_orgInteCode                         */
/* Index: idx_SuperiorVisit_orgId                               */
/*==============================================================*/
create index idx_SV_orgIntCodeAndisEmphasis on superiorVisits (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index idx_SuperiorVisit_orgInteCode on superiorVisits (
   orgInternalCode ASC
);
create index idx_SuperiorVisit_orgId on superiorVisits (
   orgId ASC
);
create index IDX_SUPERIORVISIT_BASEINFOID on SUPERIORVISITS (BASEINFOID);
create index IDX_SUPERIORVISIT_ADSID on SUPERIORVISITS (ADDRESSINFOID);

/*==============================================================*/
/* Table: RECTIFICATIVEPERSONS                                  */
/*==============================================================*/
create table RECTIFICATIVEPERSONS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32)         not null,
   EXECUTETYPE          NUMBER(10),
   PENALTYTERM          VARCHAR2(60),
   RECENTSITUATION      VARCHAR2(900),
   HELPEDUCATOR         VARCHAR2(60),
   EDUCATORTELEPHONE    VARCHAR2(80),
   EDUCATORMOBILENUMBER VARCHAR2(50),
   RECTIFYSTARTDATE     DATE,
   RECTIFYENDDATE       DATE,
   BUSSINESSREMARK      VARCHAR2(600),
   ACCUSATION           VARCHAR2(150),
   OLDCURRENTADDRESS    VARCHAR2(150),
   RESIDENCETYPE        NUMBER(10),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(60)         not null,
   CREATEDATE           DATE                 not null,
   UPDATEUSER           VARCHAR2(60),
   UPDATEDATE           DATE,
   constraint PKRECTIFICATIVEPERSONS primary key (ID),
   constraint fkRectificativePersonsOrg foreign key (orgId)
         references organizations (id)
);


/*==============================================================*/
/* Index: idx_RP_orgIntCodeAndisEmphasis                        */
/*==============================================================*/
create index idx_RP_orgIntCodeAndisEmphasis on rectificativePersons (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_RECTIFICATIVE_BASEINFOID on RECTIFICATIVEPERSONS (BASEINFOID);
create index IDX_RECTIFICATIVE_ADSID on RECTIFICATIVEPERSONS (ADDRESSINFOID);
/*==============================================================*/
/* Table: POSITIVEINFOS                                         */
/*==============================================================*/
create table POSITIVEINFOS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32)         not null,
   ISREPEAT             NUMBER(1),
   IMPRISONMENTDATE     VARCHAR2(32),
   CASEREASON           VARCHAR2(150),
   LABOREDUADDRESS      VARCHAR2(150),
   NORESETTLEMENTREASON VARCHAR2(150),
   AGOPROFESSION        NUMBER(10),
   HOUSEHOLDID          VARCHAR2(32),
   HELPEDUCATOR         VARCHAR2(60),
   EDUCATORTELEPHONE    VARCHAR2(80),
   EDUCATORMOBILENUMBER VARCHAR2(50),
   RESETTLEMENTDATE     DATE,
   RELEASEORBACKDATE    DATE,
   POSITIVEINFOTYPE     NUMBER(10),
   ISCRIME              NUMBER(1),
   CRIMEDATE            DATE,
   CRIMINALBEHAVIOR     VARCHAR2(900),
   RESETTLEMENT         VARCHAR2(60)         default '0',
   RESIDENCETYPE        NUMBER(10),
   OLDCURRENTADDRESS    VARCHAR2(150),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   CREATEDATE           DATE                 not null,
   UPDATEUSER           VARCHAR2(32),
   UPDATEDATE           DATE,
   constraint PKPOSITIVEINFOS primary key (ID),
   constraint fkPositiveInfosOrg foreign key (orgId)
         references organizations (id)
);

comment on table POSITIVEINFOS is
'刑释解教人员';

comment on column POSITIVEINFOS.ORGID is
'所属网格';

comment on column POSITIVEINFOS.ORGINTERNALCODE is
'所属责任区编号';

comment on column POSITIVEINFOS.ISREPEAT is
'是否累犯';

comment on column POSITIVEINFOS.IMPRISONMENTDATE is
'刑期';

comment on column POSITIVEINFOS.CASEREASON is
'原罪(错)';

comment on column POSITIVEINFOS.LABOREDUADDRESS is
'劳教(服刑)场所';

comment on column POSITIVEINFOS.NORESETTLEMENTREASON is
'未安置原因';

comment on column POSITIVEINFOS.AGOPROFESSION is
'原职业';

comment on column POSITIVEINFOS.HOUSEHOLDID is
'户号';

comment on column POSITIVEINFOS.HELPEDUCATOR is
'帮教人员';

comment on column POSITIVEINFOS.EDUCATORTELEPHONE is
'帮教人员电话';

comment on column POSITIVEINFOS.EDUCATORMOBILENUMBER is
'帮教人员手机号码';

comment on column POSITIVEINFOS.RESETTLEMENTDATE is
'安置时间';

comment on column POSITIVEINFOS.RELEASEORBACKDATE is
'解教（刑释）日期';

comment on column POSITIVEINFOS.CRIMINALBEHAVIOR is
'犯罪行为';

comment on column POSITIVEINFOS.RESIDENCETYPE is
'户口类别';

comment on column POSITIVEINFOS.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column POSITIVEINFOS.ATTENTIONEXTENT is
'关注程度';

comment on column POSITIVEINFOS.ISEMPHASIS is
'是否关注';

comment on column POSITIVEINFOS.CREATEUSER is
'创建用户';

comment on column POSITIVEINFOS.CREATEDATE is
'创建日期';

comment on column POSITIVEINFOS.UPDATEUSER is
'修改用户';

comment on column POSITIVEINFOS.UPDATEDATE is
'修改时间';

/*==============================================================*/
/* Index: idx_P_orgIntCodeAndisEmphasis                         */
/*==============================================================*/
create index idx_P_orgIntCodeAndisEmphasis on positiveInfos (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_POSITIVEINFO_BASEINFOID on POSITIVEINFOS (BASEINFOID);
create index IDX_POSITIVEINFO_ADSID on POSITIVEINFOS (ADDRESSINFOID);

/*==============================================================*/
/* Table: OTHERATTENTIONPERSONNELS                              */
/*==============================================================*/
create table OTHERATTENTIONPERSONNELS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32)         not null,
   FERRETOUTDATE        DATE,
   DRUGFRISTDATE        DATE,
   ATTENTIONREASON      VARCHAR2(300),
   WORKCONDITION        VARCHAR2(300),
   MEREMARK             VARCHAR2(900),
   OLDCURRENTADDRESS    VARCHAR2(150),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   CREATEDATE           DATE                 not null,
   UPDATEUSER           VARCHAR2(32),
   UPDATEDATE           DATE,
   constraint PK_OTHERATTENTIONPERSONNELS primary key (ID)
);

comment on table OTHERATTENTIONPERSONNELS is
'其他人员信息';

comment on column OTHERATTENTIONPERSONNELS.ID is
'人员id';

comment on column OTHERATTENTIONPERSONNELS.ORGID is
'所属网格';

comment on column OTHERATTENTIONPERSONNELS.ORGINTERNALCODE is
'所属责任区编号';

comment on column OTHERATTENTIONPERSONNELS.FERRETOUTDATE is
'查获日期';

comment on column OTHERATTENTIONPERSONNELS.ATTENTIONREASON is
'关注原因';

comment on column OTHERATTENTIONPERSONNELS.WORKCONDITION is
'工作情况';

comment on column OTHERATTENTIONPERSONNELS.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column OTHERATTENTIONPERSONNELS.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column OTHERATTENTIONPERSONNELS.ISEMPHASIS is
'是否关注';

comment on column OTHERATTENTIONPERSONNELS.CREATEUSER is
'创建用户';

comment on column OTHERATTENTIONPERSONNELS.CREATEDATE is
'创建日期';

comment on column OTHERATTENTIONPERSONNELS.UPDATEUSER is
'修改用户';

comment on column OTHERATTENTIONPERSONNELS.UPDATEDATE is
'修改时间';

/*==============================================================*/
/* index: index_otp_orgcodeIsemphasis                           */
/*==============================================================*/
create index index_otp_orgcodeIsemphasis on OTHERATTENTIONPERSONNELS (ORGINTERNALCODE, ISEMPHASIS);
create index IDX_OTHERPERSONNEL_BASEINFOID on OTHERATTENTIONPERSONNELS (BASEINFOID);
create index IDX_OTHERPERSONNEL_ADSID on OTHERATTENTIONPERSONNELS (ADDRESSINFOID);

/*==============================================================*/
/* Table: OPTIMALOBJECTS                                        */
/*==============================================================*/
create table OPTIMALOBJECTS 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(32)         not null,
   OPTIMALCARDNO        VARCHAR2(90),
   OPTIMALCARDTYPE      NUMBER(10),
   LABORABILITY         NUMBER(10),
   ABILITYLIVING        NUMBER(10),
   EMPLOYMENTSITUATION  NUMBER(10),
   SUPPORTSITUATION     NUMBER(10),
   MONTHLIVINGEXPENSES  NUMBER(15,5)         default 0,
   FERRETOUTDATE        DATE,
   DRUGFRISTDATE        DATE,
   INHABITANTID         NUMBER(10),
   OLDCURRENTADDRESS    VARCHAR2(150),
   RESIDENCETYPE        NUMBER(10),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(32)         not null,
   CREATEDATE           DATE                 not null,
   UPDATEUSER           VARCHAR2(32),
   UPDATEDATE           DATE,
   constraint PKOPTIMALOBJECTS primary key (ID),
   constraint fkOptimalObjects foreign key (orgId)
         references organizations (id)
);

comment on table OPTIMALOBJECTS is
'优抚对象信息';

comment on column OPTIMALOBJECTS.ID is
'人员id';

comment on column OPTIMALOBJECTS.ORGID is
'所属网格';

comment on column OPTIMALOBJECTS.ORGINTERNALCODE is
'所属责任区编号';

comment on column OPTIMALOBJECTS.OPTIMALCARDNO is
'优待证号';

comment on column OPTIMALOBJECTS.OPTIMALCARDTYPE is
'优抚类型';

comment on column OPTIMALOBJECTS.LABORABILITY is
'劳动能力';

comment on column OPTIMALOBJECTS.ABILITYLIVING is
'生活能力';

comment on column OPTIMALOBJECTS.EMPLOYMENTSITUATION is
'就业情况';

comment on column OPTIMALOBJECTS.SUPPORTSITUATION is
'供养情况';

comment on column OPTIMALOBJECTS.MONTHLIVINGEXPENSES is
'月生活费';

comment on column OPTIMALOBJECTS.FERRETOUTDATE is
'查获日期';

comment on column OPTIMALOBJECTS.INHABITANTID is
'常住人口ID';

comment on column OPTIMALOBJECTS.RESIDENCETYPE is
'户口类别';

comment on column OPTIMALOBJECTS.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column OPTIMALOBJECTS.ISEMPHASIS is
'是否关注';

comment on column OPTIMALOBJECTS.CREATEUSER is
'创建用户';

comment on column OPTIMALOBJECTS.CREATEDATE is
'创建日期';

comment on column OPTIMALOBJECTS.UPDATEUSER is
'修改用户';

comment on column OPTIMALOBJECTS.UPDATEDATE is
'修改时间';

/*==============================================================*/
/* Index: idx_O_orgIntCodeAndisEmphasis                         */
/*==============================================================*/
create index idx_O_orgIntCodeAndisEmphasis on optimalObjects (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_OPTIMALOBJECT_BASEINFOID on OPTIMALOBJECTS (BASEINFOID);
create index IDX_OPTIMALOBJECT_ADSID on OPTIMALOBJECTS (ADDRESSINFOID);

/*==============================================================*/
/* Table: NURTURESWOMEN                                         */
/*==============================================================*/
create table NURTURESWOMEN 
(
   ID                   NUMBER(10)           not null,
   BASEINFOID           NUMBER(10),
   ADDRESSINFOID        NUMBER(10),
   ORGID                NUMBER(10)           not null,
   ORGINTERNALCODE      VARCHAR2(50),
   FERTILITYSERVICESNO  VARCHAR2(150),
   MARRIAGEREGISTRATIONTIME DATE,
   ONECHILDOFCOUPLE     NUMBER(10),
   LICENSESITUATION     NUMBER(10),
   BOYNUMBER            NUMBER(2),
   GIRLNUMBER           NUMBER(2),
   LICENSETIME          DATE,
   CONTRACEPTIVEMETHOD  VARCHAR2(150),
   CONTRACEPTIVETIME    DATE,
   MANNAME              VARCHAR2(60),
   MARRIAGEORDIVORCETIME DATE,
   MANMARITALSTATE      NUMBER(10),
   MANIDCARDNO          VARCHAR2(60),
   MANFIRSTMARRIAGETIME DATE,
   MANMOBILENUMBER      VARCHAR2(50),
   MANTELEPHONE         VARCHAR2(80),
   MANBIRTHDAY          DATE,
   MANNATION            NUMBER(10),
   MANPOLITICALBACKGROUND NUMBER(10),
   MANRESIDENCETYPE     NUMBER(10),
   MANSCHOOLING         NUMBER(10),
   MANCAREER            NUMBER(10),
   MANWORKUNIT          VARCHAR2(150),
   MANPROVINCE          VARCHAR2(60),
   MANCITY              VARCHAR2(60),
   MANDISTRICT          VARCHAR2(60),
   MANNATIVEPLACEADDRESS VARCHAR2(60),
   MANCURRENTADDRESS    VARCHAR2(150),
   MANCURRENTADDRESSTYPE NUMBER(10),
   MANCOMMUNITY         VARCHAR2(60),
   MANBLOCK             VARCHAR2(24),
   MANUNIT              VARCHAR2(18),
   MANROOM              VARCHAR2(30),
   MANREMARK            VARCHAR2(900),
   SINGLECHILDCARDNO    VARCHAR2(150),
   CERTIFIEDUNIT        VARCHAR2(150),
   ISUNMARRIEDPREGNANT  NUMBER(1),
   ISLEVIED             NUMBER(1),
   ISMATERNITYCARD      NUMBER(1),
   MATERNITYCARDUNIT    VARCHAR2(60),
   MATERNITYCARDNO      VARCHAR2(30),
   MATERNITYCARDISSUETIME DATE,
   MATERNITYCARDVALIDITYTIME DATE,
   MATERNITYCARDCHECKTIME DATE,
   MATERNITYCARDREMARK  VARCHAR2(900),
   PREGNANTPHOTO        VARCHAR2(200),
   PREGNANTHEALTHSTATUS VARCHAR2(10),
   PREGNANTMOTHERHOUSE  VARCHAR2(150),
   HUSBANDHEALTHSTATUS  VARCHAR2(10),
   CONCEPTIONCONTROLDATE DATE,
   PAUSIMENIADATE       DATE,
   ISSIGNCOMPACT        NUMBER               default 0,
   CHILDCOUNT           NUMBER,
   DRAWLETTERCONDITION  NUMBER,
   CANCELDATE           DATE,
   ISCANCEL             NUMBER               default 0,
   CANCELREASON         VARCHAR2(4000),
   PERSONTYPE           VARCHAR2(10),
   RESIDENCENUMBER      VARCHAR2(32),
   HOUSEMASTERNAME      VARCHAR2(20),
   HOUSEMASTERRELATION  VARCHAR2(10),
   SINGLECHILDCDISSUETIME DATE,
   FIRSTMARRIAGETIME    DATE,
   ISDELETE             NUMBER(1)            default 0,
   RESIDENCETYPE        NUMBER(10),
   OLDCURRENTADDRESS    VARCHAR2(150),
   SOURCESSTATE         NUMBER(1)            default 1,
   ATTENTIONEXTENT      NUMBER(10),
   ISEMPHASIS           NUMBER(1)            default 0,
   ISEMPHASISREASON     VARCHAR2(300),
   ISEMPHASISDATE       DATE,
   CREATEUSER           VARCHAR2(60)         not null,
   UPDATEUSER           VARCHAR2(60),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PKNURTURESWOMEN primary key (ID),
   constraint FKNURTURESWOMENORG foreign key (ORGID)
   references ORGANIZATIONS (ID)
);

comment on table NURTURESWOMEN is
'育妇对象表';

comment on column NURTURESWOMEN.ORGID is
'所属网格';

comment on column NURTURESWOMEN.ORGINTERNALCODE is
'部门内部编号';

comment on column NURTURESWOMEN.FERTILITYSERVICESNO is
'生育服务证号';

comment on column NURTURESWOMEN.MARRIAGEREGISTRATIONTIME is
'离婚时间';

comment on column NURTURESWOMEN.ONECHILDOFCOUPLE is
'夫妻双方独生子女情况';

comment on column NURTURESWOMEN.LICENSESITUATION is
'领证情况';

comment on column NURTURESWOMEN.BOYNUMBER is
'男孩数';

comment on column NURTURESWOMEN.GIRLNUMBER is
'女孩数';

comment on column NURTURESWOMEN.LICENSETIME is
'领证时间';

comment on column NURTURESWOMEN.CONTRACEPTIVEMETHOD is
'避孕方法';

comment on column NURTURESWOMEN.CONTRACEPTIVETIME is
'避孕起始时间';

comment on column NURTURESWOMEN.MANNAME is
'丈夫姓名';

comment on column NURTURESWOMEN.MARRIAGEORDIVORCETIME is
'最近再婚时间';

comment on column NURTURESWOMEN.MANMARITALSTATE is
'丈夫婚姻状况';

comment on column NURTURESWOMEN.MANIDCARDNO is
'丈夫身份证号码';

comment on column NURTURESWOMEN.MANFIRSTMARRIAGETIME is
'丈夫初婚时间';

comment on column NURTURESWOMEN.MANMOBILENUMBER is
'丈夫联系手机';

comment on column NURTURESWOMEN.MANTELEPHONE is
'丈夫固定电话';

comment on column NURTURESWOMEN.MANBIRTHDAY is
'丈夫出生日期';

comment on column NURTURESWOMEN.MANNATION is
'丈夫民族';

comment on column NURTURESWOMEN.MANPOLITICALBACKGROUND is
'丈夫政治面貌';

comment on column NURTURESWOMEN.MANRESIDENCETYPE is
'丈夫户口类型';

comment on column NURTURESWOMEN.MANSCHOOLING is
'丈夫文化程度';

comment on column NURTURESWOMEN.MANCAREER is
'丈夫职业';

comment on column NURTURESWOMEN.MANWORKUNIT is
'丈夫工作单位或就读学校';

comment on column NURTURESWOMEN.MANPROVINCE is
'丈夫户籍地 省';

comment on column NURTURESWOMEN.MANCITY is
'丈夫户籍地 市';

comment on column NURTURESWOMEN.MANDISTRICT is
'丈夫户籍地 区县';

comment on column NURTURESWOMEN.MANNATIVEPLACEADDRESS is
'丈夫户籍地详址';

comment on column NURTURESWOMEN.MANCURRENTADDRESS is
'丈夫常住地址';

comment on column NURTURESWOMEN.MANCURRENTADDRESSTYPE is
'丈夫常住地址类型';

comment on column NURTURESWOMEN.MANCOMMUNITY is
'丈夫常住地址 商品房 小区';

comment on column NURTURESWOMEN.MANBLOCK is
'丈夫常住地址 商品房 幢';

comment on column NURTURESWOMEN.MANUNIT is
'丈夫常住地址 商品房  单元';

comment on column NURTURESWOMEN.MANROOM is
'丈夫常住地址 商品房 室';

comment on column NURTURESWOMEN.MANREMARK is
'丈夫备注';

comment on column NURTURESWOMEN.SINGLECHILDCARDNO is
'独生子女证号';

comment on column NURTURESWOMEN.CERTIFIEDUNIT is
'发证单位';

comment on column NURTURESWOMEN.ISUNMARRIEDPREGNANT is
'是否未婚先孕';

comment on column NURTURESWOMEN.ISLEVIED is
'是否征收';

comment on column NURTURESWOMEN.ISMATERNITYCARD is
'是否有婚育证';

comment on column NURTURESWOMEN.MATERNITYCARDUNIT is
'孕育证发证单位';

comment on column NURTURESWOMEN.MATERNITYCARDNO is
'证书编号';

comment on column NURTURESWOMEN.MATERNITYCARDISSUETIME is
'发放证书时间';

comment on column NURTURESWOMEN.MATERNITYCARDVALIDITYTIME is
'孕育证有效期';

comment on column NURTURESWOMEN.MATERNITYCARDCHECKTIME is
'查验时间';

comment on column NURTURESWOMEN.MATERNITYCARDREMARK is
'查验情况';

comment on column NURTURESWOMEN.PREGNANTPHOTO is
'照片';

comment on column NURTURESWOMEN.PREGNANTHEALTHSTATUS is
'健康状况';

comment on column NURTURESWOMEN.PREGNANTMOTHERHOUSE is
'娘家地址';

comment on column NURTURESWOMEN.HUSBANDHEALTHSTATUS is
'丈夫健康状况';

comment on column NURTURESWOMEN.CONCEPTIONCONTROLDATE is
'节育年月';

comment on column NURTURESWOMEN.PAUSIMENIADATE is
'绝经年月';

comment on column NURTURESWOMEN.ISSIGNCOMPACT is
'已签订计生合同';

comment on column NURTURESWOMEN.CHILDCOUNT is
'现有子女数';

comment on column NURTURESWOMEN.DRAWLETTERCONDITION is
'独生证领证情况';

comment on column NURTURESWOMEN.CANCELDATE is
'注销年月';

comment on column NURTURESWOMEN.ISCANCEL is
'是否注销';

comment on column NURTURESWOMEN.CANCELREASON is
'注销原因';

comment on column NURTURESWOMEN.PERSONTYPE is
'人户状况';

comment on column NURTURESWOMEN.RESIDENCENUMBER is
'户口簿号';

comment on column NURTURESWOMEN.HOUSEMASTERNAME is
'户主姓名';

comment on column NURTURESWOMEN.HOUSEMASTERRELATION is
'与户主关系';

comment on column NURTURESWOMEN.FIRSTMARRIAGETIME is
'初婚时间';

comment on column NURTURESWOMEN.ISDELETE is
'是否删除';

comment on column NURTURESWOMEN.RESIDENCETYPE is
'户口类型';

comment on column NURTURESWOMEN.SOURCESSTATE is
'数据来源：1.录入；2.认领；3.已核实';

comment on column NURTURESWOMEN.ATTENTIONEXTENT is
'关注程度：1.一般；2.中等；3.严重';

comment on column NURTURESWOMEN.ISEMPHASIS is
'是否关注';

comment on column NURTURESWOMEN.CREATEUSER is
'创建用户';

comment on column NURTURESWOMEN.UPDATEUSER is
'修改用户';

comment on column NURTURESWOMEN.CREATEDATE is
'创建时间';

comment on column NURTURESWOMEN.UPDATEDATE is
'修改时间';

/*==============================================================*/
/* Index: idx_ai_orgIntCodeAndisEmphasis                        */
/*==============================================================*/
create index idx_nu_orgIntCodeAndisEmphasis on nurturesWomen (
   orgInternalCode ASC,
   isEmphasis ASC
);
create index IDX_NURTURESWOMEN_BASEINFOID on NURTURESWOMEN (BASEINFOID);
create index IDX_NURTURESWOMEN_ADSID on NURTURESWOMEN (ADDRESSINFOID);

/*==============================================================*/
/* Table: ADDRESSINFO                                           */
/*==============================================================*/
create table ADDRESSINFO 
(
   ID                   NUMBER(10)           not null,
   ISHAVEHOUSE          NUMBER(1)            default 0,
   NOHOUSEREASON        VARCHAR2(800),
   CURRENTADDRESS       VARCHAR2(150),
   OTHERADDRESS         VARCHAR2(150),
   REMARK               VARCHAR2(900),
   CREATEUSER           VARCHAR2(32)         not null,
   UPDATEUSER           VARCHAR2(32),
   CREATEDATE           DATE                 not null,
   UPDATEDATE           DATE,
   constraint PKADDRESSINFO primary key (ID)
);

comment on table ADDRESSINFO is
'地址信息';

comment on column ADDRESSINFO.ID is
'人员id';

comment on column ADDRESSINFO.ISHAVEHOUSE is
'是否有房屋';

comment on column ADDRESSINFO.NOHOUSEREASON is
'无房原因';

comment on column ADDRESSINFO.CURRENTADDRESS is
'现在居住地';

comment on column ADDRESSINFO.OTHERADDRESS is
'其他地址';

comment on column ADDRESSINFO.REMARK is
'备注';

comment on column ADDRESSINFO.CREATEUSER is
'创建用户';

comment on column ADDRESSINFO.UPDATEUSER is
'修改用户';

comment on column ADDRESSINFO.CREATEDATE is
'创建日期';

comment on column ADDRESSINFO.UPDATEDATE is
'修改时间';


-- Create table
create table RECOVERDATAINFOS
(
  id            	NUMBER(10)		not null,
  moduletype		VARCHAR2(50)	not null,
  businessid		NUMBER(10)		not null,
  businesstype		VARCHAR2(50)	not null,
  baseinfoid		NUMBER(10),
  orgid				NUMBER(10)		not null,
  orgCode         	VARCHAR2(60)	not null,
  name				VARCHAR2(60)	not null,
  fullpinyin		VARCHAR2(30),
  simplepinyin		VARCHAR2(10),
  IDCARDNO			VARCHAR2(60),
  contents			CLOB,
  createuser		VARCHAR2(32)	not null,
  updateuser		VARCHAR2(32),
  createdate		DATE not null,
  updatedate		DATE,
  constraint pkRECOVERDATAINFOS primary key (id)
);
-- Add comments to the columns 
comment on table RECOVERDATAINFOS
  is '数据恢复中心';
comment on column RECOVERDATAINFOS.ID
  is 'ID';
comment on column RECOVERDATAINFOS.MODULETYPE
  is '所属模块';
comment on column RECOVERDATAINFOS.BUSINESSID
  is '业务ID';
comment on column RECOVERDATAINFOS.BUSINESSTYPE
  is '业务类型';
comment on column RECOVERDATAINFOS.BASEINFOID
  is '基础信息ID';
comment on column RECOVERDATAINFOS.ORGID
  is '组织机构ID';
comment on column RECOVERDATAINFOS.ORGCODE
  is '组织机构内置编号';
comment on column RECOVERDATAINFOS.NAME
  is '名称';
comment on column RECOVERDATAINFOS.FULLPINYIN
  is '全拼';
comment on column RECOVERDATAINFOS.SIMPLEPINYIN
  is '简拼';
comment on column RECOVERDATAINFOS.IDCARDNO
  is '身份证号';
comment on column RECOVERDATAINFOS.CONTENTS
  is '存储所有删除信息(GSON对象)';
package com.tianque.datatransfer;

import java.util.HashMap;
import java.util.Map;

import com.tianque.core.globalSetting.util.GlobalSetting;
import com.tianque.core.util.BaseInfoTables;
import com.tianque.domain.vo.ImportTemplatesVo;

public class ImportTemplatesSetting {

	public final static Map<String, ImportTemplatesVo> keyImportTemplates = new HashMap<String, ImportTemplatesVo>();
	public static final String UNSETTLED_POPULATION = BaseInfoTables.UNSETTEDPOPULATION_KEY
			.toUpperCase();
	public static final String HOUSEHOLD_STAFF = BaseInfoTables.HOUSEHOLDSTAFF_KEY
			.toUpperCase();
	public static final String DRUGGY_KEY = "DRUGGY";
	public static final String AIDSPOPULATIONS_KEY = "AIDSPOPULATIONS";
	public static final String FLOATINGPOPULATION_KEY = BaseInfoTables.FLOATINGPOPULATION_KEY
			.toUpperCase();
	public static final String OTHERATTENTIONPERSONNEL_KEY = BaseInfoTables.OTHERATTENTIONPERSONNEL_KEY
			.toUpperCase();
	public static final String OVERSEAPERSONNEL_KEY = BaseInfoTables.OVERSEAPERSONNEL_KEY
			.toUpperCase();
	public static final String DANGEROUSGOODSPRACTITIONER_KEY = "DANGEROUSGOODSPRACTITIONER";
	public static final String IDLEYOUTH_KEY = "IDLEYOUTH";
	public static final String AIDNEEDPOPULATION_KEY = "AIDNEEDPOPULATION";
	public static final String SPECIALCAREGROUPS_KEY = BaseInfoTables.SPECIALCAREGROUPS_KEY
			.toUpperCase();
	public static final String MENTALPATIENT_KEY = "MENTALPATIENT";
	public static final String POSITIVEINFO_KEY = "POSITIVEINFO";
	public static final String RECTIFICATIVEPERSON_KEY = "RECTIFICATIVEPERSON";
	public static final String RESIDENT_KEY = "RESIDENT";
	public static final String SUPERIORVISIT_KEY = "SUPERIORVISIT";
	public static final String TRAMPRESIDENT_KEY = "TRAMPRESIDENT";
	public static final String NEWSOCIETYFEDERATION_KEY = "NEWSOCIETYFEDERATION";
	public static final String NEWSOCIETYORGANIZATIONS_KEY = "NEWSOCIETYORGANIZATIONS";
	public static final String LETTINGHOUSE_KEY = "LETTINGHOUSE";
	public static final String OTHERLOCALE_KEY = "OTHERLOCALE";
	public static final String SCHOOL_KEY = "SCHOOL";
	public static final String ENTERPRISEKEY_KEY = "ENTERPRISEKEY";
	public static final String ENTERPRISEDOWNKEY_KEY = "ENTERPRISEDOWNKEY";
	public static final String PROTECTIONKEY_KEY = "PROTECTIONKEY";
	public static final String SAFETYPRODUCTIONKEY_KEY = "SAFETYPRODUCTIONKEY";
	public static final String FIRESAFETYKEY_KEY = "FIRESAFETYKEY";
	public static final String SECURITYKEY_KEY = "SECURITYKEY";
	public static final String ORGANIZATION_KEY = "ORGANIZATION";
	public static final String POORPEOPLE_KEY = "POORPEOPLE";

	public static final String PROVINCEUSER_KEY = "PROVINCEUSER";
	public static final String CITYUSER_KEY = "CITYUSER";
	public static final String DISTRICTUSER_KEY = "DISTRICTUSER";
	public static final String TOWNUSER_KEY = "TOWNUSER";
	public static final String VILLAGEUSER_KEY = "VILLAGEUSER";

	public static final String INHABITANT_KEY = "INHABITANT";
	public static final String ESTATEINFORMATION_KEY = "ESTATEINFORMATION";
	public static final String ELDERLYPEOPLE_KEY = "ELDERLYPEOPLE";

	public static final String HANDICAPPED_KEY = "HANDICAPPED";
	public static final String NURTURESWOMEN_KEY = "NURTURESWOMEN";
	public static final String NEWECONOMICORGANIZATIONS_KEY = "NEWECONOMICORGANIZATIONS";

	public static final String COMPOSITE_KEY = "COMPOSITE";
	public static final String MASSES_KEY = "MASSES";
	public static final String POSTULANT_KYE = "POSTULANT";
	public static final String LEADERGROUP_KEY = "LEADERGROUP";
	public static final String GRASSROOTSPARTY_KEY = "GRASSROOTSPARTY";
	public static final String AUTONOMYORG_KEY = "AUTONOMYORG";
	public static final String OPTIMALOBJECT_KEY = "OPTIMALOBJECT";
	public static final String PARTYMEMBERINFO_KEY = "PARTYMEMBERINFO";
	public static final String PARTYORGACTIVITY_KEY = "PARTYORGACTIVITY";

	public static final String HOUSEINFO = "HOUSEINFO";
	public static final String ACTUALHOUSE_KEY = "ACTUALHOUSE";
	public static final String RENTALHOUSE_KEY = "RENTALHOUSE";
	public static final String ACTUALCOMPANY_KEY = "ACTUALCOMPANY";
	public static final String UNEMPLOYEDPEOPLE_Key = "UNEMPLOYEDPEOPLE";
	public static final String PUBLICPLACE_KEY = "PUBLICPLACE";
	public static final String PUBLICCOMPLEXPLACES_KEY = "PUBLICCOMPLEXPLACES";
	public static final String DANGEROUSCHEMICALSUNIT_KEY = "DANGEROUSCHEMICALSUNIT";
	public static final String INTERNETBAR_KEY = "INTERNETBAR";
	public static final String POSITIVEINFOTEMP_KEY = "POSITIVEINFOTEMP";
	public static final String DRUGGYTemp_KEY = "DRUGGYTEMP";
	public static final String IDLEYOUTHTEMP_KEY = "IDLEYOUTHTEMP";
	public static final String MENTALPATIENTTemp_KEY = "MENTALPATIENTTEMP";
	public static final String RECTIFICATIVEPERSONTEMP_KEY = "RECTIFICATIVEPERSONTEMP";
	public static final String SUPERIORVISITTEMP_KEY = "SUPERIORVISITTEMP";
	public static final String DANGEROUSGOODSPRACTITIONERTEMP_KEY = "DANGEROUSGOODSPRACTITIONERTEMP";
	public static final String OTHERATTENTIONPERSONNELTEMP_KEY = "OTHERATTENTIONPERSONNELTEMP";// 其他人员
	public static final String UNEMPLOYEDPEOPLETEMP_KEY = "UNEMPLOYEDPEOPLETEMP";
	public static final String FLOATINGPOPULATIONTEMP_KEY = "FLOATINGPOPULATIONTEMP";
	public static final String HOUSEHOLDSTAFFTEMP_KEY = "HOUSEHOLDSTAFFTEMP";// 数据管理户籍人口

	public static final String MOBILEUSER_KEY = "MOBILEUSER";// 手机账号
	
	public static final String FOUR_TEAM_MEMBERS_KEY = "FOURTEAMMEMBERS";// 四支队伍成员
	
	public static final String RED_CUFF_TEAM_KEY="REDCUFFTEAM";
	
	public static final String GRID_TEAM_KEY="GRIDTEAM";
	// 十户联防用户
	public static final String IMPORT_TEN_HOUSEHOLDS_FAMILY_KEY = "IMPORTTENHOUSEHOLDSFAMILY";
	// 十户联防分组
	public static final String IMPORT_TEN_HOUSEHOLDS_GROUP_KEY = "IMPORTTENHOUSEHOLDSGROUP";

	public static final String ISSUE_JOINT_KEY = "ISSUEJOINT";// 事件对接
	public static final String AIDNEEDPOPULATIONTEMP_KEY = "AIDNEEDPOPULATIONTEMP";// 数据管理需救助人员
	public static final String SAFETYPRODUCTIONKEYTEMP_KEY = "SAFETYPRODUCTIONKEYTEMP";
	public static final String ELDERLYPEOPLETEMP_KEY = "ELDERLYPEOPLETEMP";// 数据管理老年人

	public static final String NURTURESWOMENTEMP_KEY = "NURTURESWOMENTEMP";// 数据管理育龄妇女
	public static final String RENTALHOUSETEMP_KEY = "RENTALHOUSETEMP";// 数据管理

	public static final String INTERNET_BAR_TEMP_KEY = "INTERNETBARTEMP";// 数据管理网吧
	public static final String UNSETTLED_POPULATION_TEMP_KEY = "UNSETTLEDPOPULATIONTEMP";// 数据管理未落户人口
	public static final String SCHOOL_TEMP_KEY = "SCHOOLTEMP";// 数据管理学校
	public static final String SAFETY_PRODUCTION_TEMP_KEY = "SAFETYPRODUCTIONTEMP";// 数据管理安全生产重点
	public static final String FIRE_SAFETY_TEMP_KEY = "FIRESAFETYENTERPRISETEMP";// 数据管理消防安全重点
	public static final String SECURITY_TEMP_KEY = "SECURITYENTERPRISETEMP";// 数据管理治安重点
	public static final String ENTERPRISEKEY_TEMP_KEY = "ENTERPRISEKEYTEMP";// 规上企业
	public static final String ENTERPRISEDOWNKEY_TEMP_KEY = "ENTERPRISEDOWNKEYTEMP";// 规下企业

	public static final String DANGEROUS_CHEMICALS_UNIT_TEMP_KEY = "DANGEROUSCHEMICALSUNITTEMP";// 数据管理危险化学品单位
	public static final String PUBLIC_PLACE_TEMP_KEY = "PUBLICPLACETEMP";// 数据管理公共场所
	public static final String NEW_SOCIETY_ORGANIZATIONS_TEMP_KEY = "NEWSOCIETYORGANIZATIONSTEMP";// 数据管理新社会组织
	public static final String NEW_ECONOMIC_ORGANIZATIONS_TEMP_KEY = "NEWECONOMICORGANIZATIONSTEMP";// 数据管理新经济组织
	public static final String ACTUAL_HOUSE_TEMP_KEY = "ACTUALHOUSETEMP";// 数据管理实有房屋
	public static final String RENTAL_HOUSE_TEMP_KEY = "RENTALHOUSETEMP";// 数据管理出租房
	public static final String ACTUAL_COMPANY_TEMP_KEY = "ACTUALCOMPANYTEMP";// 数据管理实有单位

	public static final String OTHER_LOCALE_TEMP_KEY = "OTHERLOCALETEMP";// 数据管理其他场所
	public static final String OVERSEA_PERSONNEL_TEMP_KEY = "OVERSEAPERSONNELTEMP";// 数据管理境外人口
	public static final String AIDSPOPULATIONSTEMP_KEY = "AIDSPOPULATIONSTEMP";// 数据管理艾滋病人员
	// getImportTemplatesVo
	public static final String OPTIMALOBJECTTEMP_KEY = "OPTIMALOBJECTTEMP";
	public static final String HANDICAPPEDTEMP_KEY = "HANDICAPPEDTEMP";
	public static final String BUILDDATAS_KEY = "BUILDDATAS";
	public static final String HOSPITAL_KEY = "HOSPITAL";
	public static final String HOSPITAL_TEMP_KEY = "HOSPITALTEMP";
	// public static final String SPECIALTRADE_KEY="SPECIALTRADE";
	// public static final String COMMONCOMPLEXPLACE_KEY="COMMONCOMPLEXPLACE";
	// public static final String DANGERTRAMPRESIDENT_KEY="DANGERTRAMPRESIDENT";
	public static final String DUSTBIN_KEY = "DUSTBIN";
	public static final String DUSTBIN_TEMP_KEY = "DUSTBINTEMP";
	public static final String BUILDDATAS_TEMP_KEY = "BUILDDATASTEMP";

	private static String dir = "resource/datatemplate/";

	public static final String NEW_HOSPITAL_TEMP_KEY = "NEWMEDICALHYGIENECOMPANYTEMP";
	public static final String NEW_SCHOOLS_TEMP_KEY = "NEWEDUCATIONCOMPANYTEMP";
	public static final String NEW_PARTYGOVERNMENTORGANCOMPANY_TEMP_KEY = "NEWPARTYGOVERNMENTORGANCOMPANYTEMP";
	public static final String NEW_DANGEROUSCHEMICALSUNIT_TEMP_KEY = "NEWDANGEROUSSTORECOMPANYTEMP";
	public static final String NEW_OTHERCOMPANY_TEMP_KEY = "NEWOTHERCOMPANYTEMP";
	public static final String NEW_PUBLICPLACE_TEMP_KEY = "NEWPUBLICPLACETEMP";
	public static final String NEW_TRAFFICPLACE_TEMP_KEY = "NEWTRAFFICPLACETEMP";
	public static final String NEW_ENTERTAINMENTPLACE_TEMP_KEY = "NEWENTERTAINMENTPLACETEMP";
	public static final String NEW_TRADEPLACE_TEMP_KEY = "NEWTRADEPLACETEMP";
	public static final String NEW_INTERNETSERVICESPLACE_TEMP_KEY = "NEWINTERNETSERVICESPLACETEMP";
	public static final String NEW_ACCOMMODATIONSERVICESPLACE_TEMP_KEY = "NEWACCOMMODATIONSERVICESPLACETEMP";
	public static final String NEW_FOODSERVICESPLACE_TEMP_KEY = "NEWFOODSERVICESPLACETEMP";
	public static final String NEW_TRAVELINGPLACE_TEMP_KEY = "NEWTRAVELINGPLACETEMP";
	public static final String NEW_CONSTRUCTIONPLACE_TEMP_KEY = "NEWCONSTRUCTIONPLACETEMP";
	public static final String NEW_OTHERPLACE_TEMP_KEY = "NEWOTHERPLACETEMP";
	// 单位场所系统
	public static final String NEWPUBLICPLACE_KEY = "NEWPUBLICPLACE";
	public static final String TRAFFICPLACE_KEY = "TRAFFICPLACE";
	public static final String ENTERTAINMENTPLACE_KEY = "ENTERTAINMENTPLACE";
	public static final String TRADEPLACE_KEY = "TRADEPLACE";
	public static final String NEWINTERNETBAR_KEY = "NEWINTERNETBAR";
	public static final String ACCOMMODATIONSERVICESPLACE_KEY = "ACCOMMODATIONSERVICESPLACE";
	public static final String NEWFOODSERVICESPLACE_KEY = "NEWFOODSERVICESPLACE";
	public static final String TRAVELINGPLACE_KEY = "TRAVELINGPLACE";
	public static final String CONSTRUCTIONPLACE_KEY = "CONSTRUCTIONPLACE";
	public static final String OTHERPLACE_KEY = "OTHERPLACE";
	public static final String PARTYGOVERNMENTORGANCOMPANY_KEY = "PARTYGOVERNMENTORGANCOMPANY";
	public static final String NEWSCHOOLS_KEY = "NEWSCHOOLS";
	public static final String NEWHOSPITAL_KEY = "NEWHOSPITAL";
	public static final String NEWDANGEROUSCHEMICALSUNIT_KEY = "NEWDANGEROUSCHEMICALSUNIT";
	public static final String OTHERCOMPANY_KEY = "OTHERCOMPANY";
	public static final String GIS2DLAYER_KEY = "GIS2DLAYER";
	public static final String UPDATELONLAT_KEY = "UPDATELONLAT";
	public static final String Logistics_KEY = "LOGISTICS";

	// 实有人口系统FXJ模块
	public static final String FPERSONNEL_KEY = "FPERSONNEL";
	public static final String QPERSONNEL_KEY = "QPERSONNEL";
	public static final String MPERSONNEL_KEY = "MPERSONNEL";
	// 见义勇为
	public static final String GOODSAMARITAN_KEY = "GOODSAMARITAN";
	
	//食药工商导入
	public static final String POLICY_PROPAGANDA_KEY="POLICYPROPAGANDA";
	public static final String FOOD_SAFTY_KEY="FOODSAFTY";
	public static final String DRUGS_SAFTY_KEY="DRUGSSAFTY";
	public static final String BUSINESS_MANAGE_KEY="BUSINESSMANAGE";
	public static final String PYRAMID_SALES_MANAGE_KEY="PYRAMIDSALESMANAGE";
	public static final String UNLICENSED_MANAGE_KEY="UNLICENSEDMANAGE";
	public static final String OTHER_SITUATION_MANAGE_KEY="OTHERSITUATIONMANAGE";

	static {
		keyImportTemplates.put(FLOATINGPOPULATION_KEY, new ImportTemplatesVo(
				"1.0", dir + FLOATINGPOPULATION_KEY + ".xls"));// 流动人口
		keyImportTemplates.put(UNSETTLED_POPULATION, new ImportTemplatesVo(
				"1.0", dir + UNSETTLED_POPULATION + ".xls"));// 未落户人员
		keyImportTemplates.put(HOUSEHOLD_STAFF, new ImportTemplatesVo("1.0",
				dir + HOUSEHOLD_STAFF + ".xls"));// 户籍人口
		keyImportTemplates.put(OVERSEAPERSONNEL_KEY, new ImportTemplatesVo(
				"1.0", dir + OVERSEAPERSONNEL_KEY + ".xls"));// 境外人员
		keyImportTemplates.put(UNEMPLOYEDPEOPLE_Key, new ImportTemplatesVo(
				"1.0", dir + UNEMPLOYEDPEOPLE_Key + ".xls"));// 失业人员
		keyImportTemplates.put(OTHERATTENTIONPERSONNEL_KEY,
				new ImportTemplatesVo("1.0", dir + OTHERATTENTIONPERSONNEL_KEY
						+ ".xls"));// 其他人员
		keyImportTemplates.put(DRUGGY_KEY, new ImportTemplatesVo("1.0", dir
				+ DRUGGY_KEY + ".xls"));// 吸毒人员
		keyImportTemplates.put(AIDSPOPULATIONS_KEY, new ImportTemplatesVo(
				"1.0", dir + AIDSPOPULATIONS_KEY + ".xls"));// 艾滋病人员
		keyImportTemplates.put(DANGEROUSGOODSPRACTITIONER_KEY,
				new ImportTemplatesVo("1.0", dir
						+ DANGEROUSGOODSPRACTITIONER_KEY + ".xls"));// 危险品从业人员
		keyImportTemplates.put(IDLEYOUTH_KEY, new ImportTemplatesVo("1.0", dir
				+ IDLEYOUTH_KEY + ".xls"));// 重点青少年
		keyImportTemplates.put(AIDNEEDPOPULATION_KEY, new ImportTemplatesVo(
				"1.0", dir + AIDNEEDPOPULATION_KEY + ".xls"));// 需救助人员
		keyImportTemplates.put(SPECIALCAREGROUPS_KEY, new ImportTemplatesVo(
				"1.0", dir + SPECIALCAREGROUPS_KEY + ".xls"));// 优抚对象
		keyImportTemplates.put(MENTALPATIENT_KEY, new ImportTemplatesVo("1.0",
				dir + MENTALPATIENT_KEY + ".xls"));// 严重精神障碍患者
		keyImportTemplates.put(POSITIVEINFO_KEY, new ImportTemplatesVo("1.0",
				dir + POSITIVEINFO_KEY + ".xls"));// 刑释解教人员
		keyImportTemplates.put(RECTIFICATIVEPERSON_KEY, new ImportTemplatesVo(
				"1.0", dir + RECTIFICATIVEPERSON_KEY + ".xls"));// 矫正人员
		keyImportTemplates.put(RESIDENT_KEY, new ImportTemplatesVo("1.0", dir
				+ RESIDENT_KEY + ".xls"));// 户籍人口
		keyImportTemplates.put(SUPERIORVISIT_KEY, new ImportTemplatesVo("1.0",
				dir + SUPERIORVISIT_KEY + ".xls"));// 重点信访人员
		keyImportTemplates.put(TRAMPRESIDENT_KEY, new ImportTemplatesVo("1.0",
				dir + TRAMPRESIDENT_KEY + ".xls"));// 流动人口
		keyImportTemplates.put(NEWSOCIETYFEDERATION_KEY, new ImportTemplatesVo(
				"1.0", dir + NEWSOCIETYFEDERATION_KEY + ".xls"));// 社会组织
		keyImportTemplates.put(NEWSOCIETYORGANIZATIONS_KEY,
				new ImportTemplatesVo("1.0", dir + NEWSOCIETYORGANIZATIONS_KEY
						+ ".xls"));// 新社会组织
		keyImportTemplates.put(LETTINGHOUSE_KEY, new ImportTemplatesVo("1.0",
				dir + LETTINGHOUSE_KEY + ".xls"));// 出租房
		keyImportTemplates.put(OTHERLOCALE_KEY, new ImportTemplatesVo("1.0",
				dir + OTHERLOCALE_KEY + ".xls"));// 其他场所
		keyImportTemplates.put(SCHOOL_KEY, new ImportTemplatesVo("1.0", dir
				+ SCHOOL_KEY + ".xls"));// 学校
		keyImportTemplates.put(ENTERPRISEKEY_KEY, new ImportTemplatesVo("1.0",
				dir + ENTERPRISEKEY_KEY + ".xls"));// 企业

		// fateson add 规下企业 加入
		keyImportTemplates.put(ENTERPRISEDOWNKEY_KEY, new ImportTemplatesVo(
				"1.0", dir + ENTERPRISEDOWNKEY_KEY + ".xls"));

		keyImportTemplates.put(PROTECTIONKEY_KEY, new ImportTemplatesVo("1.0",
				dir + PROTECTIONKEY_KEY + ".xls"));// 重点保障
		keyImportTemplates.put(SAFETYPRODUCTIONKEY_KEY, new ImportTemplatesVo(
				"1.0", dir + SAFETYPRODUCTIONKEY_KEY + ".xls"));// 安全生产重点
		keyImportTemplates.put(FIRESAFETYKEY_KEY, new ImportTemplatesVo("1.0",
				dir + FIRESAFETYKEY_KEY + ".xls"));// 消防安全重点
		keyImportTemplates.put(SECURITYKEY_KEY, new ImportTemplatesVo("1.0",
				dir + SECURITYKEY_KEY + ".xls"));// 治安重点
		keyImportTemplates.put(POORPEOPLE_KEY, new ImportTemplatesVo("1.0", dir
				+ POORPEOPLE_KEY + ".xls"));// 困难群众

		keyImportTemplates.put(ORGANIZATION_KEY, new ImportTemplatesVo("1.0",
				dir + ORGANIZATION_KEY + ".xls"));// 组织机构

		keyImportTemplates.put(PROVINCEUSER_KEY, new ImportTemplatesVo("", dir
				+ PROVINCEUSER_KEY + ".xls"));// 省级用户导入
		keyImportTemplates.put(CITYUSER_KEY, new ImportTemplatesVo("", dir
				+ CITYUSER_KEY + ".xls"));// 市级用户导入
		keyImportTemplates.put(DISTRICTUSER_KEY, new ImportTemplatesVo("", dir
				+ DISTRICTUSER_KEY + ".xls"));// 县级用户导入
		keyImportTemplates.put(TOWNUSER_KEY, new ImportTemplatesVo("", dir
				+ TOWNUSER_KEY + ".xls"));// 乡镇村居用户导入
		keyImportTemplates.put(VILLAGEUSER_KEY, new ImportTemplatesVo("", dir
				+ VILLAGEUSER_KEY + ".xls"));// 网格用户导入

		keyImportTemplates.put(INHABITANT_KEY, new ImportTemplatesVo("1.0", dir
				+ INHABITANT_KEY + ".xls"));// 常住人口
		keyImportTemplates.put(ESTATEINFORMATION_KEY, new ImportTemplatesVo(
				"1.0", dir + ESTATEINFORMATION_KEY + ".xls"));// 房产信息
		keyImportTemplates.put(ELDERLYPEOPLE_KEY, new ImportTemplatesVo("1.0",
				dir + ELDERLYPEOPLE_KEY + ".xls"));// 老年人

		keyImportTemplates.put(HANDICAPPED_KEY, new ImportTemplatesVo("1.0",
				dir + HANDICAPPED_KEY + ".xls"));// 残疾人
		keyImportTemplates.put(NURTURESWOMEN_KEY, new ImportTemplatesVo("1.0",
				dir + NURTURESWOMEN_KEY + ".xls"));// 育妇

		keyImportTemplates.put(COMPOSITE_KEY, new ImportTemplatesVo("1.0", dir
				+ COMPOSITE_KEY + ".xls"));// 基层综治组织
		keyImportTemplates.put(MASSES_KEY, new ImportTemplatesVo("1.0", dir
				+ MASSES_KEY + ".xls"));// 群防群治组织队伍
		keyImportTemplates.put(POSTULANT_KYE, new ImportTemplatesVo("1.0", dir
				+ POSTULANT_KYE + ".xls"));// 社会志愿者队伍
		keyImportTemplates.put(LEADERGROUP_KEY, new ImportTemplatesVo("1.0",
				dir + LEADERGROUP_KEY + ".xls"));// 专项工作领导小组
		keyImportTemplates.put(GRASSROOTSPARTY_KEY, new ImportTemplatesVo(
				"1.0", dir + GRASSROOTSPARTY_KEY + ".xls"));// 基层党组织
		keyImportTemplates.put(AUTONOMYORG_KEY, new ImportTemplatesVo("1.0",
				dir + AUTONOMYORG_KEY + ".xls"));// 基层自治组织

		keyImportTemplates.put(HOSPITAL_KEY, new ImportTemplatesVo("1.0", dir
				+ HOSPITAL_KEY + ".xls"));// 医院
		keyImportTemplates.put(HOSPITAL_TEMP_KEY, new ImportTemplatesVo("1.0",
				dir + HOSPITAL_TEMP_KEY + ".xls"));// 数据管理医院
		// keyImportTemplates.put(SPECIALTRADE_KEY,new
		// ImportTemplatesVo("1.0",dir+SPECIALTRADE_KEY+".xls"));//特种行业
		// keyImportTemplates.put(COMMONCOMPLEXPLACE_KEY, new
		// ImportTemplatesVo("1.0",dir+COMMONCOMPLEXPLACE_KEY+".xls"));//公共复杂场所
		// keyImportTemplates.put(DANGERTRAMPRESIDENT_KEY, new
		// ImportTemplatesVo("1.0",dir+DANGERTRAMPRESIDENT_KEY+".xls"));//高危流动人口

		keyImportTemplates.put(OPTIMALOBJECT_KEY, new ImportTemplatesVo("1.0",
				dir + OPTIMALOBJECT_KEY + ".xls"));// 优抚对象
		keyImportTemplates.put(PARTYMEMBERINFO_KEY, new ImportTemplatesVo(
				"1.0", dir + PARTYMEMBERINFO_KEY + ".xls"));// 本级党建党员信息
		keyImportTemplates.put(PARTYORGACTIVITY_KEY, new ImportTemplatesVo(
				"1.0", dir + PARTYORGACTIVITY_KEY + ".xls"));// 本级党建党组织活动
		keyImportTemplates.put(NEWECONOMICORGANIZATIONS_KEY,
				new ImportTemplatesVo("1.0", dir + NEWECONOMICORGANIZATIONS_KEY
						+ ".xls"));// 优抚对象

		keyImportTemplates.put(HOUSEINFO, new ImportTemplatesVo("1.0", dir
				+ HOUSEINFO + ".xls"));// 住房信息
		keyImportTemplates.put(ACTUALHOUSE_KEY, new ImportTemplatesVo("1.0",
				dir + ACTUALHOUSE_KEY + ".xls"));// 实有房屋
		keyImportTemplates.put(RENTALHOUSE_KEY, new ImportTemplatesVo("1.0",
				dir + RENTALHOUSE_KEY + ".xls"));// 出租房
		keyImportTemplates.put(ACTUALCOMPANY_KEY, new ImportTemplatesVo("1.0",
				dir + ACTUALCOMPANY_KEY + ".xls"));// 实有单位
		keyImportTemplates.put(PUBLICPLACE_KEY, new ImportTemplatesVo("1.0",
				dir + PUBLICPLACE_KEY + ".xls"));// 公共场所
		keyImportTemplates.put(PUBLICCOMPLEXPLACES_KEY, new ImportTemplatesVo(
				"1.0", dir + PUBLICCOMPLEXPLACES_KEY + ".xls"));// 公共复杂场所
		keyImportTemplates.put(INTERNETBAR_KEY, new ImportTemplatesVo("1.0",
				dir + INTERNETBAR_KEY + ".xls"));// 网吧
		keyImportTemplates.put(DANGEROUSCHEMICALSUNIT_KEY,
				new ImportTemplatesVo("1.0", dir + DANGEROUSCHEMICALSUNIT_KEY
						+ ".xls"));// 危险化学品单位
		// keyImportTemplates.put(POSITIVETEMP_KEY, new ImportTemplatesVo("1.0",
		// dir + POSITIVETEMP_KEY + ".xls"));// 刑释解教人员
		keyImportTemplates.put(DRUGGYTemp_KEY, new ImportTemplatesVo("1.0", dir
				+ DRUGGYTemp_KEY + ".xls"));// 吸毒人员
		keyImportTemplates.put(IDLEYOUTHTEMP_KEY, new ImportTemplatesVo("1.0",
				dir + IDLEYOUTHTEMP_KEY + ".xls"));// 重点青少年人员
		keyImportTemplates.put(OPTIMALOBJECT_KEY, new ImportTemplatesVo("1.0",
				dir + OPTIMALOBJECT_KEY + ".xls"));// 优抚对象
		keyImportTemplates.put(PARTYMEMBERINFO_KEY, new ImportTemplatesVo(
				"1.0", dir + PARTYMEMBERINFO_KEY + ".xls"));// 本级党建党员信息
		keyImportTemplates.put(PARTYORGACTIVITY_KEY, new ImportTemplatesVo(
				"1.0", dir + PARTYORGACTIVITY_KEY + ".xls"));// 本级党建党组织活动
		keyImportTemplates.put(NEWECONOMICORGANIZATIONS_KEY,
				new ImportTemplatesVo("1.0", dir + NEWECONOMICORGANIZATIONS_KEY
						+ ".xls"));// 优抚对象

		keyImportTemplates.put(HOUSEINFO, new ImportTemplatesVo("1.0", dir
				+ HOUSEINFO + ".xls"));// 住房信息
		keyImportTemplates.put(ACTUALHOUSE_KEY, new ImportTemplatesVo("1.0",
				dir + ACTUALHOUSE_KEY + ".xls"));// 实有房屋
		keyImportTemplates.put(RENTALHOUSE_KEY, new ImportTemplatesVo("1.0",
				dir + RENTALHOUSE_KEY + ".xls"));// 出租房
		keyImportTemplates.put(ACTUALCOMPANY_KEY, new ImportTemplatesVo("1.0",
				dir + ACTUALCOMPANY_KEY + ".xls"));// 实有单位
		keyImportTemplates.put(PUBLICPLACE_KEY, new ImportTemplatesVo("1.0",
				dir + PUBLICPLACE_KEY + ".xls"));// 公共场所
		keyImportTemplates.put(PUBLICCOMPLEXPLACES_KEY, new ImportTemplatesVo(
				"1.0", dir + PUBLICCOMPLEXPLACES_KEY + ".xls"));// 公共复杂场所
		keyImportTemplates.put(INTERNETBAR_KEY, new ImportTemplatesVo("1.0",
				dir + INTERNETBAR_KEY + ".xls"));// 网吧
		keyImportTemplates.put(DANGEROUSCHEMICALSUNIT_KEY,
				new ImportTemplatesVo("1.0", dir + DANGEROUSCHEMICALSUNIT_KEY
						+ ".xls"));// 危险化学品单位
		keyImportTemplates.put(POSITIVEINFOTEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + POSITIVEINFOTEMP_KEY + ".xls"));// 刑释解教人员
		keyImportTemplates.put(DRUGGYTemp_KEY, new ImportTemplatesVo("1.0", dir
				+ DRUGGYTemp_KEY + ".xls"));// 吸毒人员
		keyImportTemplates.put(IDLEYOUTHTEMP_KEY, new ImportTemplatesVo("1.0",
				dir + IDLEYOUTHTEMP_KEY + ".xls"));// 重点青少年人员
		keyImportTemplates.put(MENTALPATIENTTemp_KEY, new ImportTemplatesVo(
				"1.0", dir + MENTALPATIENTTemp_KEY + ".xls"));// 严重精神障碍患者
		keyImportTemplates.put(AIDSPOPULATIONSTEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + AIDSPOPULATIONSTEMP_KEY + ".xls"));// 艾滋病人员

		keyImportTemplates.put(RECTIFICATIVEPERSONTEMP_KEY,
				new ImportTemplatesVo("1.0", dir + RECTIFICATIVEPERSONTEMP_KEY
						+ ".xls"));// 社区矫正人员
		keyImportTemplates.put(SUPERIORVISITTEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + SUPERIORVISITTEMP_KEY + ".xls"));// 重点上访人员
		keyImportTemplates.put(DANGEROUSGOODSPRACTITIONERTEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ DANGEROUSGOODSPRACTITIONERTEMP_KEY + ".xls"));// 危险品从业人员
		keyImportTemplates.put(UNEMPLOYEDPEOPLETEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + UNEMPLOYEDPEOPLETEMP_KEY + ".xls"));// 危险品从业人员
		keyImportTemplates.put(FLOATINGPOPULATIONTEMP_KEY,
				new ImportTemplatesVo("1.0", dir + FLOATINGPOPULATIONTEMP_KEY
						+ ".xls"));// 流动人口
		keyImportTemplates.put(HOUSEHOLDSTAFFTEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + HOUSEHOLDSTAFFTEMP_KEY + ".xls"));// 数据管理户籍人口

		keyImportTemplates.put(AIDNEEDPOPULATIONTEMP_KEY,
				new ImportTemplatesVo("1.0", dir + AIDNEEDPOPULATIONTEMP_KEY
						+ ".xls"));// 数据管理需救助人员
		keyImportTemplates.put(OPTIMALOBJECTTEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + OPTIMALOBJECTTEMP_KEY + ".xls"));// 优抚对象
		keyImportTemplates.put(HANDICAPPEDTEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + HANDICAPPEDTEMP_KEY + ".xls"));// 残疾人员
		keyImportTemplates.put(OTHERATTENTIONPERSONNELTEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ OTHERATTENTIONPERSONNELTEMP_KEY + ".xls"));// 其他人员
		keyImportTemplates.put(SAFETYPRODUCTIONKEYTEMP_KEY,
				new ImportTemplatesVo("1.0", dir + SAFETYPRODUCTIONKEYTEMP_KEY
						+ ".xls"));// 安全生产重点

		keyImportTemplates.put(MOBILEUSER_KEY, new ImportTemplatesVo("1.0", dir
				+ MOBILEUSER_KEY + ".xls"));// 手机账号
		keyImportTemplates.put(FOUR_TEAM_MEMBERS_KEY, new ImportTemplatesVo(
				"1.0", dir + FOUR_TEAM_MEMBERS_KEY + ".xls"));// 四支队伍成员
		
		keyImportTemplates.put(RED_CUFF_TEAM_KEY, new ImportTemplatesVo(
				"1.0", dir + RED_CUFF_TEAM_KEY + ".xls"));// 红袖套成员
		
		keyImportTemplates.put(GRID_TEAM_KEY, new ImportTemplatesVo(
				"1.0", dir + GRID_TEAM_KEY + ".xls"));// 网格成员
		
		keyImportTemplates.put(ISSUE_JOINT_KEY, new ImportTemplatesVo("1.0",
				dir + ISSUE_JOINT_KEY + ".xls"));// 事件对接
		keyImportTemplates.put(ELDERLYPEOPLETEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + ELDERLYPEOPLETEMP_KEY + ".xls"));// 数据管理 老年人

		keyImportTemplates.put(NURTURESWOMENTEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + NURTURESWOMENTEMP_KEY + ".xls"));// 数据管理 育龄妇女
		keyImportTemplates.put(RENTALHOUSETEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + RENTALHOUSETEMP_KEY + ".xls"));// 数据管理 出租房

		keyImportTemplates.put(ACTUAL_HOUSE_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + ACTUAL_HOUSE_TEMP_KEY + ".xls"));// 数据管理 实有房屋

		keyImportTemplates.put(BUILDDATAS_KEY, new ImportTemplatesVo("1.0", dir
				+ BUILDDATAS_KEY + ".xls"));
		keyImportTemplates.put(BUILDDATAS_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + BUILDDATAS_TEMP_KEY + ".xls"));

		keyImportTemplates.put(INTERNET_BAR_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + INTERNET_BAR_TEMP_KEY + ".xls"));// 数据管理网吧

		keyImportTemplates.put(NEW_ECONOMIC_ORGANIZATIONS_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ NEW_ECONOMIC_ORGANIZATIONS_TEMP_KEY + ".xls"));// 数据管理新经济组织

		keyImportTemplates.put(NEW_SOCIETY_ORGANIZATIONS_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ NEW_SOCIETY_ORGANIZATIONS_TEMP_KEY + ".xls"));// 数据管理新社会组织

		keyImportTemplates.put(UNSETTLED_POPULATION_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ UNSETTLED_POPULATION_TEMP_KEY + ".xls"));// 数据管理未落户人口

		keyImportTemplates.put(SCHOOL_TEMP_KEY, new ImportTemplatesVo("1.0",
				dir + SCHOOL_TEMP_KEY + ".xls"));// 数据管理学校

		keyImportTemplates.put(SAFETY_PRODUCTION_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir + SAFETY_PRODUCTION_TEMP_KEY
						+ ".xls"));// 数据管理安全生产重点
		keyImportTemplates.put(FIRE_SAFETY_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + FIRE_SAFETY_TEMP_KEY + ".xls"));// 数据管理消防安全重点
		keyImportTemplates.put(SECURITY_TEMP_KEY, new ImportTemplatesVo("1.0",
				dir + SECURITY_TEMP_KEY + ".xls"));// 数据管理治安重点
		keyImportTemplates.put(ENTERPRISEKEY_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + ENTERPRISEKEY_TEMP_KEY + ".xls"));// 数据管理规上企业
		keyImportTemplates.put(ENTERPRISEDOWNKEY_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir + ENTERPRISEDOWNKEY_TEMP_KEY
						+ ".xls"));// 数据管理规下企业

		keyImportTemplates.put(OVERSEA_PERSONNEL_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir + OVERSEA_PERSONNEL_TEMP_KEY
						+ ".xls"));// 数据管理境外人员

		keyImportTemplates.put(OTHER_LOCALE_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + OTHER_LOCALE_TEMP_KEY + ".xls"));// 数据管理其他场所
		keyImportTemplates.put(PUBLIC_PLACE_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + PUBLIC_PLACE_TEMP_KEY + ".xls"));// 数据管理公共场所
		keyImportTemplates.put(DANGEROUS_CHEMICALS_UNIT_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ DANGEROUS_CHEMICALS_UNIT_TEMP_KEY + ".xls"));// 数据管理
		// 危险品单位
		keyImportTemplates.put(ACTUAL_COMPANY_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + ACTUAL_COMPANY_TEMP_KEY + ".xls"));// 数据管理实有单位
		// 城市管理系统 部件管理 部件信息
		keyImportTemplates.put(DUSTBIN_KEY, new ImportTemplatesVo("1.0", dir
				+ DUSTBIN_KEY + ".xls"));
		// 数据管理子系统 部件管理 部件信息
		keyImportTemplates.put(DUSTBIN_TEMP_KEY, new ImportTemplatesVo("1.0",
				dir + DUSTBIN_TEMP_KEY + ".xls"));
		// 成华党建党员导入
		keyImportTemplates.put(
				BaseInfoTables.MEMBER_KEY,
				new ImportTemplatesVo("1.0", dir
						+ BaseInfoTables.MEMBER_KEY.toUpperCase() + ".xls"));
		// 单位场所数据管理：
		keyImportTemplates.put(NEW_PARTYGOVERNMENTORGANCOMPANY_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ NEW_PARTYGOVERNMENTORGANCOMPANY_TEMP_KEY + ".xls"));// 数据管理党政机关
		keyImportTemplates.put(NEW_SCHOOLS_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + NEW_SCHOOLS_TEMP_KEY + ".xls"));// 数据管理教育
		keyImportTemplates.put(NEW_HOSPITAL_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + NEW_HOSPITAL_TEMP_KEY + ".xls"));// 数据管理医疗卫生
		keyImportTemplates.put(NEW_DANGEROUSCHEMICALSUNIT_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ NEW_DANGEROUSCHEMICALSUNIT_TEMP_KEY + ".xls"));// 数据管理危化品存放单位
		keyImportTemplates.put(NEW_OTHERCOMPANY_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir + NEW_OTHERCOMPANY_TEMP_KEY
						+ ".xls"));// 数据管理其他单位
		keyImportTemplates.put(NEW_PUBLICPLACE_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + NEW_PUBLICPLACE_TEMP_KEY + ".xls"));// 数据管理公共活动场所
		keyImportTemplates.put(NEW_TRAFFICPLACE_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir + NEW_TRAFFICPLACE_TEMP_KEY
						+ ".xls"));// 数据管理交通场所
		keyImportTemplates.put(NEW_ENTERTAINMENTPLACE_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ NEW_ENTERTAINMENTPLACE_TEMP_KEY + ".xls"));// 数据管理娱乐场所
		keyImportTemplates.put(NEW_TRADEPLACE_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + NEW_TRADEPLACE_TEMP_KEY + ".xls"));// 数据管理商贸场所
		keyImportTemplates.put(NEW_INTERNETSERVICESPLACE_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ NEW_INTERNETSERVICESPLACE_TEMP_KEY + ".xls"));// 数据管理上网服务场所
		keyImportTemplates.put(NEW_ACCOMMODATIONSERVICESPLACE_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ NEW_ACCOMMODATIONSERVICESPLACE_TEMP_KEY + ".xls"));// 数据管理住宿服务场所
		keyImportTemplates.put(NEW_FOODSERVICESPLACE_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ NEW_FOODSERVICESPLACE_TEMP_KEY + ".xls"));// 数据管理餐饮服务场所
		keyImportTemplates.put(NEW_TRAVELINGPLACE_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir + NEW_TRAVELINGPLACE_TEMP_KEY
						+ ".xls"));// 数据管理旅游场所
		keyImportTemplates.put(NEW_CONSTRUCTIONPLACE_TEMP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ NEW_CONSTRUCTIONPLACE_TEMP_KEY + ".xls"));// 数据管理施工场所
		keyImportTemplates.put(NEW_OTHERPLACE_TEMP_KEY, new ImportTemplatesVo(
				"1.0", dir + NEW_OTHERPLACE_TEMP_KEY + ".xls"));// 数据管理其它场所
		// 单位场所系统
		keyImportTemplates.put(NEWPUBLICPLACE_KEY, new ImportTemplatesVo("1.0",
				dir + NEWPUBLICPLACE_KEY + ".xls"));
		keyImportTemplates.put(TRAFFICPLACE_KEY, new ImportTemplatesVo("1.0",
				dir + TRAFFICPLACE_KEY + ".xls"));
		keyImportTemplates.put(ENTERTAINMENTPLACE_KEY, new ImportTemplatesVo(
				"1.0", dir + ENTERTAINMENTPLACE_KEY + ".xls"));
		keyImportTemplates.put(TRADEPLACE_KEY, new ImportTemplatesVo("1.0", dir
				+ TRADEPLACE_KEY + ".xls"));
		keyImportTemplates.put(NEWINTERNETBAR_KEY, new ImportTemplatesVo("1.0",
				dir + NEWINTERNETBAR_KEY + ".xls"));
		keyImportTemplates.put(ACCOMMODATIONSERVICESPLACE_KEY,
				new ImportTemplatesVo("1.0", dir
						+ ACCOMMODATIONSERVICESPLACE_KEY + ".xls"));
		keyImportTemplates.put(NEWFOODSERVICESPLACE_KEY, new ImportTemplatesVo(
				"1.0", dir + NEWFOODSERVICESPLACE_KEY + ".xls"));
		keyImportTemplates.put(TRAVELINGPLACE_KEY, new ImportTemplatesVo("1.0",
				dir + TRAVELINGPLACE_KEY + ".xls"));
		keyImportTemplates.put(CONSTRUCTIONPLACE_KEY, new ImportTemplatesVo(
				"1.0", dir + CONSTRUCTIONPLACE_KEY + ".xls"));
		keyImportTemplates.put(OTHERPLACE_KEY, new ImportTemplatesVo("1.0", dir
				+ OTHERPLACE_KEY + ".xls"));
		keyImportTemplates.put(PARTYGOVERNMENTORGANCOMPANY_KEY,
				new ImportTemplatesVo("1.0", dir
						+ PARTYGOVERNMENTORGANCOMPANY_KEY + ".xls"));
		keyImportTemplates.put(NEWSCHOOLS_KEY, new ImportTemplatesVo("1.0", dir
				+ NEWSCHOOLS_KEY + ".xls"));
		keyImportTemplates.put(NEWHOSPITAL_KEY, new ImportTemplatesVo("1.0",
				dir + NEWHOSPITAL_KEY + ".xls"));
		keyImportTemplates.put(NEWDANGEROUSCHEMICALSUNIT_KEY,
				new ImportTemplatesVo("1.0", dir
						+ NEWDANGEROUSCHEMICALSUNIT_KEY + ".xls"));
		keyImportTemplates.put(OTHERCOMPANY_KEY, new ImportTemplatesVo("1.0",
				dir + OTHERCOMPANY_KEY + ".xls"));
		keyImportTemplates.put(GIS2DLAYER_KEY, new ImportTemplatesVo("1.0", dir
				+ GIS2DLAYER_KEY + ".xls"));
		keyImportTemplates.put(UPDATELONLAT_KEY, new ImportTemplatesVo("1.0",
				dir + UPDATELONLAT_KEY + ".xls"));
		// 实有人口系统FXJ模块
		keyImportTemplates.put(FPERSONNEL_KEY, new ImportTemplatesVo("1.0", dir
				+ FPERSONNEL_KEY + ".xls"));
		keyImportTemplates.put(QPERSONNEL_KEY, new ImportTemplatesVo("1.0", dir
				+ QPERSONNEL_KEY + ".xls"));
		keyImportTemplates.put(MPERSONNEL_KEY, new ImportTemplatesVo("1.0", dir
				+ MPERSONNEL_KEY + ".xls"));

		// 见义勇为
		keyImportTemplates.put(GOODSAMARITAN_KEY, new ImportTemplatesVo("1.0",
				dir + GOODSAMARITAN_KEY + ".xls"));

		// 十户联防用户
		keyImportTemplates.put(IMPORT_TEN_HOUSEHOLDS_FAMILY_KEY,
				new ImportTemplatesVo("1.0", dir
						+ IMPORT_TEN_HOUSEHOLDS_FAMILY_KEY + ".xls"));
		// 十户联防分组
		keyImportTemplates.put(IMPORT_TEN_HOUSEHOLDS_GROUP_KEY,
				new ImportTemplatesVo("1.0", dir
						+ IMPORT_TEN_HOUSEHOLDS_GROUP_KEY + ".xls"));
		// 寄递物流点
		keyImportTemplates.put(Logistics_KEY,
				new ImportTemplatesVo("1.0", dir
						+ Logistics_KEY + ".xls"));
		//食药工商导入
		keyImportTemplates.put(POLICY_PROPAGANDA_KEY,
				new ImportTemplatesVo("1.0", dir
						+ POLICY_PROPAGANDA_KEY + ".xls"));
		keyImportTemplates.put(FOOD_SAFTY_KEY,
				new ImportTemplatesVo("1.0", dir
						+ FOOD_SAFTY_KEY + ".xls"));
		keyImportTemplates.put(DRUGS_SAFTY_KEY,
				new ImportTemplatesVo("1.0", dir
						+ DRUGS_SAFTY_KEY + ".xls"));
		keyImportTemplates.put(BUSINESS_MANAGE_KEY,
				new ImportTemplatesVo("1.0", dir
						+ BUSINESS_MANAGE_KEY + ".xls"));
		keyImportTemplates.put(PYRAMID_SALES_MANAGE_KEY,
				new ImportTemplatesVo("1.0", dir
						+ PYRAMID_SALES_MANAGE_KEY + ".xls"));
		keyImportTemplates.put(UNLICENSED_MANAGE_KEY,
				new ImportTemplatesVo("1.0", dir
						+ UNLICENSED_MANAGE_KEY + ".xls"));
		keyImportTemplates.put(OTHER_SITUATION_MANAGE_KEY,
				new ImportTemplatesVo("1.0", dir
						+ OTHER_SITUATION_MANAGE_KEY + ".xls"));
	}

	public static ImportTemplatesVo getImportTemplatesVo(String key) {
		ImportTemplatesVo tv = null;
		for (String initKey : keyImportTemplates.keySet()) {
			if (key.equals(initKey)) {
				tv = keyImportTemplates.get(initKey);
				return tv;
			}
		}
		for (String initKey : keyImportTemplates.keySet()) {
			if (key.startsWith(initKey)) {
				tv = keyImportTemplates.get(initKey);
				if (key.endsWith(GlobalSetting.NOT_ADD_POPULATION))
					tv.setUrl(dir + initKey + "1.xls");
				else if (key.endsWith(GlobalSetting.SYNC_ACTUAL_POPULATION))
					tv.setUrl(dir + initKey + "2.xls");
				else if (key.endsWith(GlobalSetting.NOT_DEPENDENT))
					tv.setUrl(dir + initKey + ".xls");
				break;
			}
		}
		return tv;
	}
}

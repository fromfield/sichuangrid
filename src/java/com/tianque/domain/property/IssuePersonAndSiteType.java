package com.tianque.domain.property;

import java.util.HashMap;
import java.util.Map;

public class IssuePersonAndSiteType {
	private final static Map<String, String> keyValues = new HashMap<String, String>();

	static {
		keyValues.put("LETTING_HOUSE", "出租房");
		keyValues.put("ENTERPRISEKEY", "规上企业");
		keyValues.put("SCHOOL", "学校周边");
		keyValues.put("HOSPITAL", "医院");
		keyValues.put("COMMON_COMPLEXPLACE", "公共复杂场所");
		keyValues.put("SPECIAL_TRADE", "特种行业");
		keyValues.put("NEWSOCIETYFEDERATION", "社会组织");
		keyValues.put("OTHER_LOCALE", "其他场所");
		keyValues.put("TRAMPRESIDENT", "流动人口");
		keyValues.put("SUPERIOR_VISIT", "信访上访人员");
		keyValues.put("RECTIFICATIVEPERSON", "矫正人员");
		keyValues.put("POSITIVE_INFO", "刑释人员");
		keyValues.put("ATTENTION_OBJECT", "其他关注人员");
		keyValues.put("MENTAL_PATIENT", "严重精神障碍患者");
		keyValues.put("IDLE_YOUTH", "重点青少年");
		keyValues.put("AIDNEED_POPULATION", "需救助人员");
		keyValues.put("DRUGGY", "吸毒人员");
		keyValues.put("DANGEROUS_GOODS_PRACTITIONER", "危险品从业人员");
		keyValues.put("lettinghouse", "出租房");
		keyValues.put("enterprise", "规上企业");
		keyValues.put("school", "学校周边");
		keyValues.put("hospital", "医院");
		keyValues.put("commoncomplexplace", "公共复杂场所");
		keyValues.put("specialtrade", "特种行业");
		keyValues.put("newsocietyfederation", "社会组织");
		keyValues.put("otherlocale", "其他场所");
		keyValues.put("trampresident", "流动人口");
		keyValues.put("superiorVisit", "重点上访人员");
		keyValues.put("rectificativePerson", "社区矫正人员");
		keyValues.put("positiveInfo", "刑释人员");
		keyValues.put("otherAttentionPersonnel", "其他关注人员");
		keyValues.put("mentalPatient", "严重精神障碍患者");
		keyValues.put("idleYouth", "重点青少年");
		keyValues.put("druggy", "吸毒人员");
		keyValues.put("aidspopulation", "艾滋病人员");
		keyValues.put("dangerousGoodsPractitioner", "危险品从业人员");
		keyValues.put("POORPEOPLE", "需救助人员");
		keyValues.put("DANGER_TRAMP_RESIDENT", "高危流动人口");
		keyValues.put("SAFETYPRODUCTIONKEY", "安全生产重点");
		keyValues.put("FIRESAFETYKEY", "消防安全重点");
		keyValues.put("SECURITYKEY", "治安重点");
		keyValues.put("OVERSEAPERSONNEL", "境外人员");
		keyValues.put("INTERNETBAR", "网吧");
		keyValues.put("DANGEROUSCHEMICALSUNIT", "危险化学品单位");
		keyValues.put("PUBLICPLACE", "公共场所");
		keyValues.put("RENTALHOUSE", "出租房");
		keyValues.put("ENTERPRISEKEY", "规上企业");
		keyValues.put("OTHERLOCALES", "其他场所");
		keyValues.put("SCHOOLS", "学校");
	}

	public final static String LETTINGHOUSE = "出租房";
	public final static String ENTERPRISE = "规上企业";
	public final static String SCHOOL = "学校周边";
	public final static String HOSPITAL = "医院";
	public final static String COMMONCOMPLEXPLACE = "公共复杂场所";
	public final static String SPECIALTRADE = "特种行业";
	public final static String OTHERLOCALE = "其他场所";
	public final static String INTERNETBAR = "网吧";

	public final static String LETTINGHOUSES = "LETTINGHOUSE";

	public final static String ENTERPRISES = "ENTERPRISEKEY";

	public final static String SCHOOLS = "SCHOOL";
	public final static String HOSPITALS = "HOSPITAL";
	public final static String COMMONCOMPLEXPLACES = "COMMONCOMPLEXPLACE";
	public final static String SPECIALTRADES = "SPECIALTRADE";
	public final static String OTHERLOCALES = "OTHERLOCALE";

	public final static String LETTINGHOUSE_SEARCH_TITLE = "出租房查询-请输入查询条件";
	public final static String ENTERPRISE_SEARCH_TITLE = "规上企业查询-请输入查询条件";
	public final static String SCHOOL_SEARCH_TITLE = "学校周边查询-请输入查询条件";
	public final static String HOSPITAL_SEARCH_TITLE = "医院查询-请输入查询条件";
	public final static String COMMONCOMPLEXPLACE_SEARCH_TITLE = "公共复杂场所查询-请输入查询条件";
	public final static String SPECIALTRADE_SEARCH_TITLE = "特种行业查询-请输入查询条件";
	public final static String OTHERLOCALE_SEARCH_TITLE = "其他场所查询-请输入查询条件";

	public final static String LETTINGHOUSE_ADD_TITLE = "新增出租房信息";
	public final static String ENTERPRISE_ADD_TITLE = "新增规上企业信息";
	public final static String SCHOOL_ADD_TITLE = "新增学校周边信息";
	public final static String HOSPITAL_ADD_TITLE = "新增医院信息";
	public final static String COMMONCOMPLEXPLACE_ADD_TITLE = "新增公共复杂场所信息";
	public final static String SPECIALTRADE_ADD_TITLE = "新增特种行业信息";
	public final static String OTHERLOCALE_ADD_TITLE = "新增其他场所信息";
	public final static String OVERSEATTENTION = "境外人员";

	public final static int HOSPITAL_SEARCH_WITH = 760;
	public final static int HOSPITAL_SEARCH_HIGTH = 550;

	public final static int COMMONCOMPLEXPLACE_SEARCH_WITH = 760;
	public final static int COMMONCOMPLEXPLACE_SEARCH_HIGTH = 520;

	public final static int SCHOOL_SEARCH_WITH = 760;
	public final static int SCHOOL_SEARCH_HIGTH = 520;

	public final static int SPECIALTRADE_SEARCH_WITH = 760;
	public final static int SPECIALTRADE_SEARCH_HIGTH = 490;

	public final static int ENTERPRISE_SEARCH_WITH = 760;
	public final static int ENTERPRISE_SEARCH_HIGTH = 600;

	public final static int OTHERLOCALE_SEARCH_WITH = 760;
	public final static int OTHERLOCALE_SEARCH_HIGTH = 400;

	public final static int LETTINGHOUSE_SEARCH_WITH = 780;
	public final static int LETTINGHOUSE_SEARCH_HIGTH = 600;

	public final static int LETTINGHOUSE_ADD_WITH = 760;
	public final static int LETTINGHOUSE_ADD_HIGTH = 550;
	public final static int ENTERPRISE_ADD_WITH = 950;
	public final static int ENTERPRISE_ADD_HIGTH = 600;
	public final static int SCHOOL_ADD_WITH = 800;
	public final static int SCHOOL_ADD_HIGTH = 480;
	public final static int HOSPITAL_ADD_WITH = 680;
	public final static int HOSPITAL_ADD_HIGTH = 420;
	public final static int COMMONCOMPLEXPLACE_ADD_WITH = 660;
	public final static int COMMONCOMPLEXPLACE_ADD_HIGTH = 420;
	public final static int SPECIALTRADE_ADD_WITH = 900;
	public final static int SPECIALTRADE_ADD_HIGTH = 500;
	public final static int OTHERLOCALE_ADD_WITH = 640;
	public final static int OTHERLOCALE_ADD_HIGTH = 300;
	public final static String LETTINGHOUSE_ADD_PATH = "/baseinfo/lettingHouseManage/dispatch.action";
	public final static String SCHOOL_ADD_PATH = "/baseinfo/schoolManage/dispatchOperate.action";
	public final static String ENTERPRISE_ADD_PATH = "/baseinfo/enterpriseManage/dispatchOperate.action";
	public final static String SUPERIORVISIT_ADD_PATH = "/baseinfo/superiorVisit/getSuperiorVisitById.action";
	public final static String HOSPITAL_ADD_PATH = "/baseinfo/hospital/dispatch.action";
	public final static String COMMONCOMPLEXPLACE_ADD_PATH = "/baseinfo/commonComplexPlaceManage/dispatchOperate.action";
	public final static String SPECIALTRADE_ADD_PATH = "/baseinfo/specialTradeManage/dispatchOperate.action";
	public final static String NEWSOCIETYFEDERATION_ADD_PATH = "/baseinfo/newSocietyFederationManage/dispatch.action";
	public final static String OTHERLOCALE_ADD_PATH = "/baseinfo/otherLocaleManage/dispatch.action";
	public final static String DANGEROUSGOODSPRACTITRIONER_ADD_PATH = "/baseinfo/dangerousGoodsPractitionerManage/dispatch.action";
	public final static String DRUGGY_ADD_PATH = "/baseinfo/druggyManage/dispatchOperate.action";
	public final static String IDLEYOUTH_ADD_PATH = "/baseinfo/idleYouthManage/dispatch.action";
	public final static String MENTALPATIENT_ADD_PATH = "/baseinfo/mentalPatient/dispatchOperate.action";
	public final static String OTHERATTENTION_ADD_PATH = "/baseinfo/attentionPersonnelManage/dispatchOperate.action";
	public final static String POSITIVEINFO_ADD_PATH = "/baseinfo/positiveInfo/getPositiveInfosById.action";
	public final static String RECTIFY_ADD_PATH = "/baseinfo/rectificativePersonManage/dispatchOperate.action";
	public final static String LETTINGHOUSE_SEARCH_PATH = "/issue/issueManage/search/searchLettingHouseDlg.jsp";
	public final static String ENTERPRISE_SEARCH_PATH = "/issue/issueManage/search/searchEnterpriseCondition.jsp";
	public final static String SCHOOL_SEARCH_PATH = "/issue/issueManage/search/searchSchool.jsp";
	public final static String HOSPITAL_SEARCH_PATH = "/issue/issueManage/search/searchHospitalDlg.jsp";
	public final static String COMMONCOMPLEXPLACE_SEARCH_PATH = "/issue/issueManage/search/searchCommonComplexPlaceDlg.jsp";
	public final static String SPECIALTRADE_SEARCH_PATH = "/issue/issueManage/search/searchSpecialTradeCondition.jsp";
	public final static String NEWSOCIETYFEDERATION_SEARCH_PATH = "/issue/issueManage/search/searchNewSocietyFederationDlg.jsp";
	public final static String OTHERLOCALE_SEARCH_PATH = "/issue/issueManage/search/searchOtherLocaleCondition.jsp";
	public final static String DANGEROUSGOODSPRACTITIONER_SEARCH_PATH = "/issue/issueManage/search/dangerousGoodsPractitionerConditionDlg.jsp";
	public final static String TRAMPRESIDENT_SEARCH_PATH = "/issue/issueManage/search/searchTrampResidentDlg.jsp";
	public final static String SUPERIORVISIT_SEARCH_PATH = "/issue/issueManage/search/searchSuperiorVisit.jsp";
	public final static String RECTIFY_SEARCH_PATH = "/issue/issueManage/search/searchRectificativePerson.jsp";
	public final static String POSITIVEINFO_SEARCH_PATH = "/issue/issueManage/search/searchPositiveInfosDlg.jsp";
	public final static String OTHERATTENTION_SEARCH_PATH = "/issue/issueManage/search/otherAttentionPersonnelConditionDlg.jsp";
	public final static String MENTALPATIENT_SEARCH_PATH = "/issue/issueManage/search/mentalPatientQueryDlg.jsp";
	public final static String IDLEYOUTH_SEARCH_PATH = "/issue/issueManage/search/searchIdleYouth.jsp";
	public final static String DRUGGY_SEARCH_PATH = "/issue/issueManage/search/searchDruggyDlg.jsp";
	public final static String SUPERIORVISIT_COMM_PATH = "/baseinfo/searchSuperiorVisit/searchSuperiorVsitForAutoComplete.action";
	public final static String HOSPITAL_COMM_PATH = "/baseinfo/searchHospital/searchHospitalForAutoComplete.action";
	public final static String POSITIVEINFO_COMM_PATH = "/baseinfo/searchPositiveInfos/searchPositiveInfosForAutoComplete.action";
	public final static String DRUGGY_COMM_PATH = "/baseinfo/searchDruggy/searchDruggyForAutoComplete.action";
	public final static String MENTALPATIENT_COMM_PATH = "/baseinfo/searchMentalPatient/searchMentalPatientForAutoComplete.action";
	public final static String RECTIFY_COMM_PATH = "/baseinfo/searchRectificativePerson/searchRectificativePersonForAutoComplete.action";
	public final static String IDLEYOUTH_COMM_PATH = "/baseinfo/searchIdleYouth/searchIdleYouthForAutoComplete.action";
	public final static String DANGEROUSGOODSPRACTITIONER_COMM_PATH = "/baseinfo/searchDangerousGoodsPractitionerManager/searchDangerousGoodsPractitionersForAutoComplete.action";
	public final static String LETTINGHOUSE_COMM_PATH = "/baseinfo/lettingHouseManage/searchLettingHouseForAutoComplete.action";
	public final static String ENTERPRISE_COMM_PATH = "/baseinfo/searchEnterprise/searchEnterpriseForAutoComplete.action";
	public final static String SCHOOL_COMM_PATH = "/baseinfo/searSchool/searchSchoolForAutoComplete.action";
	public final static String COMMONCOMPLEXPLACE_COMM_PATH = "/baseinfo/searchCommonComplexPlaceManage/searchCommonComplexPlaceForAutoComplete.action";
	public final static String SPECIALTRADE_COMM_PATH = "/baseinfo/searchSpecialTrade/searchSpecialTradeForAutoComplete.action";
	public final static String OTHERLOCALE_COMM_PATH = "/baseinfo/searchOtherLocale/searchOtherLocaleForAutoComplete.action";
	public final static String OTHERATTENTION_COMM_PATH = "/baseinfo/importantPersonnelSearch/searchAttentionObjectForAutoComplete.action";

	public final static String SUPERIORVISIT = "信访上访人员";
	public final static String RECTIFY = "矫正人员";
	public final static String POSITIVEINFO = "刑释人员";
	public final static String OTHERATTENTION = "其他人员";
	public final static String MENTALPATIENT = "严重精神障碍患者";
	public final static String IDLEYOUTH = "重点青少年";
	public final static String AIDNEEDPOPULATION = "需救助人员";
	public final static String DRUGGY = "吸毒人员";
	public final static String DANGEROUSGOODSPRACTITIONER = "危险品从业人员";

	public final static String SUPERIORVISITS = "SUPERIORVISIT";
	public final static String RECTIFYS = "RECTIFY";
	public final static String POSITIVEINFOS = "POSITIVEINFO";
	public final static String OTHERATTENTIONS = "OTHERATTENTION";
	public final static String MENTALPATIENTS = "MENTALPATIENT";
	public final static String IDLEYOUTHS = "IDLEYOUTH";
	public final static String AIDNEEDPOPULATIONS = "AIDNEEDPOPULATION";
	public final static String FLOATINGPOPULATIONS = "FLOATINGPOPULATION";
	public final static String DRUGGYS = "DRUGGY";
	public final static String DANGEROUSGOODSPRACTITIONERS = "DANGEROUSGOODSPRACTITIONER";
	public final static String OVERSEATTENTIONS = "OVERSEATTENTION";
	public final static String PARTYMEMBERINFOS = "PARTYMEMBERINFO";

	public final static String OPTIMALOBJECTS = "OPTIMALOBJECT";

	public final static String SUPERIORVISIT_SEARCH_TITLE = "信访上访人员查询-输入查询条件";
	public final static String RECTIFY_SEARCH_TITLE = "矫正人员查询-请输入查询";
	public final static String POSITIVEINFO_SEARCH_TITLE = "刑释人员查询-请输入查询条件";
	public final static String OTHERATTENTION_SEARCH_TITLE = "其他关注人员查询-请输入查询条件";
	public final static String MENTALPATIENT_SEARCH_TITLE = "严重精神障碍患者查询-请输入查询条件";
	public final static String IDLEYOUTH_SEARCH_TITLE = "重点青少年查询-请输入查询条件";

	public final static String DRUGGY_SEARCH_TITLE = "吸毒人员查询-请输入查询条件";
	public final static String DANGEROUSGOODSPRACTITIONER_SEARCH_TITLE = "危险品从业人员查询-请输入查询条件";

	public final static String SUPERIORVISIT_ADD_TITLE = "新增信访上访人员信息";
	public final static String RECTIFY_ADD_TITLE = "新增矫正人员信息";
	public final static String POSITIVEINFO_ADD_TITLE = "新增刑释人员信息";
	public final static String OTHERATTENTION_ADD_TITLE = "新增其他关注人员信息";
	public final static String MENTALPATIENT_ADD_TITLE = "新增严重精神障碍患者信息";
	public final static String IDLEYOUTH_ADD_TITLE = "新增重点青少年信息";
	public final static String DRUGGY_ADD_TITLE = "新增吸毒人员信息";
	public final static String DANGEROUSGOODSPRACTITIONER_ADD_TITLE = "新增危险品从业人员信息";
	public final static int SUPERIORVISIT_ADD_WITH = 680;
	public final static int SUPERIORVISIT_ADD_HIGTH = 500;
	public final static int RECTIFY_ADD_WITH = 710;
	public final static int RECTIFY_ADD_HIGTH = 470;
	public final static int POSITIVEINFO_ADD_WITH = 730;
	public final static int POSITIVEINFO_ADD_HIGTH = 580;
	public final static int OTHERATTENTION_ADD_WITH = 800;
	public final static int OTHERATTENTION_ADD_HIGTH = 450;
	public final static int MENTALPATIENT_ADD_WITH = 670;
	public final static int MENTALPATIENT_ADD_HIGTH = 430;
	public final static int IDLEYOUTH_ADD_WITH = 800;
	public final static int IDLEYOUTH_ADD_HIGTH = 460;
	public final static int DRUGGY_ADD_WITH = 700;
	public final static int DRUGGY_ADD_HIGTH = 500;
	public final static int DANGEROUSGOODSPRACTITIONER_ADD_WITH = 780;
	public final static int DANGEROUSGOODSPRACTITIONER_ADD_HIGTH = 480;

	public final static int DANGEROUSGOODSPRACTITIONER_SEARCH_WITH = 760;
	public final static int DANGEROUSGOODSPRACTITIONER_SEARCH_HIGTH = 600;
	public final static int IDLEYOUTH_SEARCH_WITH = 760;
	public final static int IDLEYOUTH_SEARCH_HIGTH = 570;
	public final static int RECTIFY_SEARCH_WITH = 760;
	public final static int RECTIFY_SEARCH_HIGTH = 560;
	public final static int MENTALPATIENT_SEARCH_WITH = 760;
	public final static int MENTALPATIENT_SEARCH_HIGTH = 560;
	public final static int SUPERIORVISIT_SEARCH_WITH = 760;
	public final static int SUPERIORVISIT_SEARCH_HIGTH = 560;
	public final static int DRUGGY_SEARCH_WITH = 760;
	public final static int DRUGGY_SEARCH_HIGTH = 620;
	public final static int POSITIVEINFO_SEARCH_WITH = 760;
	public final static int POSITIVEINFO_SEARCH_HIGTH = 600;
	public final static int OTHERATTENTION_SEARCH_WITH = 760;
	public final static int OTHERATTENTION_SEARCH_HIGTH = 550;

	public static String toString(String key) {
		if (key == null || "".equalsIgnoreCase(key))
			return "未知";
		return keyValues.get(key);
	}
}

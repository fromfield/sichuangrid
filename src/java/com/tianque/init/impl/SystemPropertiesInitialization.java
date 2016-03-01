package com.tianque.init.impl;

import com.tianque.core.property.GridInternalProperty;
import com.tianque.core.util.Chinese2pinyin;
import com.tianque.domain.PropertyDict;
import com.tianque.domain.PropertyDomain;
import com.tianque.domain.property.*;
import com.tianque.init.Initialization;
import com.tianque.issue.constants.IssueConstants;
import com.tianque.plugin.taskList.constant.TaskListItemNameInternalId;
import com.tianque.sysadmin.service.PropertyDictService;
import com.tianque.sysadmin.service.PropertyDomainService;
import com.tianque.xichang.working.domain.property.ItemCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class SystemPropertiesInitialization implements Initialization {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private PropertyDomainService propertyDomainService;

	private PropertyDictService propertyDictService;

	private PropertyDomain propertyDomain = new PropertyDomain();

	public SystemPropertiesInitialization(
			PropertyDomainService propertyDomainService,
			PropertyDictService propertyDictService) {
		this.propertyDictService = propertyDictService;
		this.propertyDomainService = propertyDomainService;
	}

	@Override
	public void init() {
		inttObjTypeProperty();
		logger.info("公共设施类型字典初始化结束!");
		initGrowingProperty();
		logger.info("古树长势字典初始化结束!");
		initSecretDegree();
		logger.info("紧急程度字典初始化结束!");
		initUrgentDegree();
		logger.info("机密程度字典初始化结束!");
		initIsFarmingProperty();
		logger.info("农业及非农业字典初始化结束!");
		initStateProperty();
		logger.info("状态字典初始化结束!");
		initDustbinTypeProperty();
		logger.info("环卫环保字典初始化结束!");
		initAidReasonProperty();
		logger.info("救助原因字典初始化结束!");
		initDifficultTypeProperty();
		logger.info("困难类型字典初始化结束!");
		initCertificateHoldTypeProperty();
		logger.info("持证种类字典初始化结束!");
		initUnSettedReasonProperty();
		logger.info("未落户原因字典初始化结束!");
		initGenderProperty();
		logger.info("性别字典初始化结束!");
		initGenderForBaseOrg();
		logger.info("性别字典初始化结束(去除不明)!");
		initResidentStatusProperty();
		logger.info("常住人口状态字典初始化结束!");
		initFaithProperty();
		logger.info("宗教信仰字典初始化结束!");
		initBloodTypeProperty();
		logger.info("血型字典初始化结束!");
		initHealthStateProperty();
		logger.info("健康状况字典初始化结束!");
		initMaritalStatusProperty();
		logger.info("婚姻状况字典初始化结束!");
		initPoliticalBackgroundProperty();
		logger.info("政治面貌字典初始化结束!");
		initRelationShipWithHeadProperty();
		logger.info("户籍家庭关系字典初始化结束!");
		initRelationShipWithMasterProperty();
		logger.info("家庭信息关系字典初始化结束!");
		initResidenceTypeProperty();
		logger.info("户口类型字典初始化结束!");
		initMilitaryServiceProperty();
		logger.info("服役状况字典初始化结束!");
		initSchoolingProperty();
		logger.info("学历字典初始化结束!");
		initOrganizationLevel();
		logger.info(PropertyTypes.ORGANIZATION_LEVEL + "字典初始化结束!");
		initOrganizationType();
		logger.info(PropertyTypes.ORGANIZATION_TYPE + "字典初始化结束!");
		initNation();
		logger.info(PropertyTypes.NATION + "字典初始化结束!");
		initOccupation();
		logger.info(PropertyTypes.CAREER + "字典初始化结束!");
		initResident_Reason();
		logger.info(PropertyTypes.RESIDENT_REASON + "字典初始化结束!");
		initResident_Premises();
		logger.info(PropertyTypes.RESIDENT_PREMISES + "字典初始化结束!");
		initExecuteType();
		logger.info(PropertyTypes.ORGANIZATION_TYPE + "刑法类型初始化完毕!");
		initIdleYouthStaffType();
		logger.info(PropertyTypes.IDLEYOUTH_STAFF_TYPE + "字典初始化结束!");
		initDrugReason();
		logger.info(PropertyTypes.DRUG_REASON + "字典初始化结束!");
		initDrugSource();
		logger.info(PropertyTypes.DRUG_SOURCE + "字典初始化结束!");
		initDetoxicateCase();
		logger.info(PropertyTypes.DETOXICATE_CASE + "字典初始化结束!");
		initDetoxicateCondition();
		logger.info(PropertyTypes.DETOXICATE_CONDITION + "字典初始化结束!");
		initLettingHouseType();
		logger.info(PropertyTypes.LETTINGHOUSE_TYPE + "字典初始化结束!");
		initLettingHouseStruts();
		logger.info(PropertyTypes.LETTINGHOUSE_STRUTS + "字典初始化结束!");
		initLettingHouseProperty();
		logger.info(PropertyTypes.LETTINGHOUSE_PROPERTY + "字典初始化结束!");
		initLettingHouseUsage();
		logger.info(PropertyTypes.LETTINGHOUSE_USAGE + "字典初始化结束!");
		initHiddenTroubleLevel();
		logger.info(PropertyTypes.HIDDEN_TROUBLE_LEVEL + "字典初始化结束!");
		initSchoolProperty();
		logger.info(PropertyTypes.SCHOOL_PROPERTY + "字典初始化结束!");
		initSchoolType();
		logger.info(PropertyTypes.SCHOOL_TYPE + "字典初始化结束!");
		initComprehensiveManagementPost();
		logger.info(PropertyTypes.COMPREHENSIVE_MANAGEMENT_POST + "字典初始化结束!");
		initEnterpriseType();
		logger.info(PropertyTypes.ENTERPRISE_TYPE + "字典初始化结束!");
		initHospitalKind();
		logger.info(PropertyTypes.HOSPITALS_KIND + "字典初始化结束!");
		initHospitalType();
		logger.info(PropertyTypes.HOSPITALS_TYPE + "字典初始化结束!");
		initHospitalLevel();
		logger.info(PropertyTypes.HOSPITAL_LEVEL + "字典初始化结束!");
		initCommonEntertainmentKindProperty();
		logger.info(PropertyTypes.ENTERTAINMENT_KIND + "字典初始化结束!");
		initMarketKindProperty();
		logger.info(PropertyTypes.MARKET_KIND + "字典初始化结束!");
		initSpecialTradeType();
		logger.info(PropertyTypes.SPECIALTRADE_TYPE + "字典初始化结束!");
		initComplexPlaceBusinessProperty();
		logger.info(PropertyTypes.COMPLEX_PLACE_TYPE + "字典初始化结束!");
		initOtherLocaleType();
		logger.info(PropertyTypes.OTHER_LOCALE_TYPE + "字典初始化结束!");
		initEexceptionSuperiorVisitpProperty();
		logger.info(PropertyTypes.EXCEPTION_SUPERIOR_VISIT + "字典初始化结束!");
		initNormalSuperiorVisitProperty();
		logger.info(PropertyTypes.NORMAL_SUPERIOR_VISIT + "字典初始化结束!");
		initSuperiorVisitTypeProperty();
		logger.info(PropertyTypes.SUPERIOR_VISIT_TYPE + "字典初始化结束!");
		initDangerousWorkingTypeProperty();
		logger.info(PropertyTypes.DANGEROUS_WORKING_TYPE + "字典初始化结束!");
		initDangerousLevelProperty();
		logger.info(PropertyTypes.MENTALPATIENT_DANGEROUS_LEVEL + "字典初始化结束!");
		initToBearStatusProperty();
		logger.info(PropertyTypes.TO_BEAR_STATUS + "字典初始化结束!");
		initSuperiorVisitpStatusProperty();
		logger.info(PropertyTypes.SUPERIOR_VISIT_STATUS + "字典初始化结束!");
		initNewSocietyTypeProperty();
		logger.info(PropertyTypes.NEW_SOCIETY_TYPE + "字典初始化结束!");
		initSocietyGroup();
		logger.info(PropertyTypes.SOCIETY_GROUP + "字典初始化结束!");
		initOTherComplexPlaceKindProperty();
		logger.info(PropertyTypes.OTHER_COMPLEX_PLACE_TYPE_KIND + "字典初始化结束!");
		initIssueEventProperty();
		logger.info(PropertyTypes.ISSUE_KIND + "字典初始化结束");
		eventSourceState();
		logger.info(PropertyTypes.EVENTSOURCE_STATE + "字典初始化结束!");
		initIssueFromMethod();
		logger.info(PropertyTypes.SOURCE_KIND + "字典初始化结束!");
		initStatementStatisticType();
		logger.info(PropertyTypes.STATEMENT_STATISTIC_TYPE + "字典初始化结束!");
		initDailyDirectoryType();
		logger.info(PropertyTypes.TRAMPRESIDEN_REASON + "字典初始化结束!");
		initDangerTrampresionReasonType();
		logger.info(PropertyTypes.DAILYDIRECTORY_TYPE + "字典初始化结束!");
		initPoorSource();
		logger.info(PropertyTypes.POOR_SOURCE + "字典初始化结束!");
		initPositiveInfo();
		logger.info(PropertyTypes.POSITIVEINFO + "字典初始化结束!");
		initCompositeDutyInfo();
		logger.info(PropertyTypes.COMPOSITEDUTY + "字典初始化结束!");
		initPartyDutyInfo();
		logger.info(PropertyTypes.PARTYDUTY + "字典初始化结束!");
		initUtonomyDutyInfo();
		logger.info(PropertyTypes.UTONOMYDUTY + "字典初始化结束!");
		initMassesDutyInfo();
		logger.info(PropertyTypes.MASSESDUTY + "字典初始化结束!");
		initPostulantDutyInfo();
		logger.info(PropertyTypes.POSTULANTDUTY + "字典初始化结束!");
		initLeaderGroupDutyInfo();
		logger.info(PropertyTypes.LEADERGROUPDUTY + "字典初始化结束!");
		initGridmanagementTeamDuty();
		logger.info(PropertyTypes.GRIDMANAGEMENTTEAMDUTY + "字典初始化结束!");
		initLeaderGroupTypeInfo();
		logger.info(PropertyTypes.LEADERGROUP_TYPE + "字典初始化结束!");
		initBasicOrgType();
		logger.info(PropertyTypes.BASICORGTYPE + "字典初始化结束!");
		initTeamClass();
		logger.info(PropertyTypes.TEAMCLAZZ + "字典初始化结束!");
		initWorkDiaryType();
		logger.info(PropertyTypes.WORKDIARY_DIARY_TYPE + "字典初始化结束!");
		initEvaluateType();
		logger.info(PropertyTypes.EVALUATE_TYPE + "字典初始化结束!");
		initDetailedRuleType();
		logger.info(PropertyTypes.DETAILED_RULE_TYPE + "字典初始化结束!");
		initScoresStandard();
		logger.info(PropertyTypes.SCORES_STANDARDS + "字典初始化结束!");
		initPrimaryOrganization();
		logger.info(PropertyTypes.PERMARY_ORGANIZATION_TYPE + "字典初始化结束!");
		initFireSafetyType();
		logger.info(PropertyTypes.FIRESAFETY_TYPE + "字典初始化结束!");
		initSecurityType();
		logger.info(PropertyTypes.SECURITY_TYPE + "字典初始化结束!");

		initStructureYear();
		logger.info(PropertyTypes.STRUCTURE_YEAR + "字典初始化结束!");
		initBuildingStructure();
		logger.info(PropertyTypes.BUILDING_STRUCTURE + "字典初始化结束!");
		initHouseEquity();
		logger.info(PropertyTypes.HOUSE_EQUITY + "字典初始化结束!");
		initMassyDutyType();
		logger.info(PropertyTypes.MASSEDUTY_TYPE + "字典初始化结束!");
		initPostulantDutyType();
		logger.info(PropertyTypes.POSTULANTDUTY_TYPE + "字典初始化结束!");
		initWorkingRecordSubmitState();
		logger.info(PropertyTypes.WORKING_RECORD_SUBMITSTATE + "字典初始化结束!");

		initPregnancyAndContraceptionCase();
		logger.info(PropertyTypes.PREGNANCYANDCONTRACEPTIONCASE + "字典初始化结束!");
		initProfessionalQualifications();
		logger.info(PropertyTypes.PROFESSIONALQUALIFICATIONS + "字典初始化结束!");
		initRegistrationType();
		logger.info(PropertyTypes.REGISTRATIONTYPE + "字典初始化结束!");
		initLaborContract();
		logger.info(PropertyTypes.LABORCONTRACT + "字典初始化结束!");
		initInsuranceCase();
		logger.info(PropertyTypes.INSURANCECASE + "字典初始化结束!");
		initAbroadDependentsTypeProperty();
		logger.info(PropertyTypes.ABROADDEPENDENTS_TYPE + "字典初始化结束!");
		initCertificatetype();
		logger.info(PropertyTypes.CERTIFICATE_TYPE + "字典初始化结束!");
		initStatementsReportedType();
		logger.info(PropertyTypes.STATEMENTS_REPORTED_TYPE + "字典初始化结束!");
		initDirectoryReportType();
		initDirectoryReportCheckType();
		initDirectoryReportIssueDealType();
		logger.info(PropertyTypes.DIRECTORY_REPORT_TYPE + "字典初始化结束!");
		initServiceManagementType();
		logger.info("社会服务管理" + "字典初始化结束!");
		initSpecialCareType();
		logger.info(PropertyTypes.SPECIAL_CARE_TYPE + "字典初始化结束!");
		initLabourCapacity();
		logger.info(PropertyTypes.LABOUR_CAPACITY + "字典初始化结束!");
		initViability();
		logger.info(PropertyTypes.VIABILITY + "字典初始化结束!");
		initEmploymentStatus();
		logger.info(PropertyTypes.EMPLOYMENT_STATUS + "字典初始化结束!");
		initSupportStatus();
		logger.info(PropertyTypes.SUPPORT_STATUS + "字典初始化结束!");
		initDisabilityStatus();
		logger.info(PropertyTypes.DISABILITY_STATUS + "字典初始化结束!");
		initSkillsAndSpecialities();
		logger.info(PropertyTypes.SKILLS_AND_SPECIALITIES + "字典初始化结束!");
		initLiveStatus();
		logger.info(PropertyTypes.LIVE_STATUS + "字典初始化结束!");
		initSpecialPerson();
		logger.info(PropertyTypes.SPECIAL_PERSON + "字典初始化结束!");
		initSpouseStatus();
		logger.info(PropertyTypes.SPOUSE_STATUS + "字典初始化结束!");
		initCurrentStatus();
		logger.info(PropertyTypes.CURRENT_STATUS + "字典初始化结束!");
		initIncomeSource();
		logger.info(PropertyTypes.INCOME_SOURCE + "字典初始化结束!");
		initInflowingReason();
		logger.info(PropertyTypes.INFLOWING_REASON + "字典初始化结束!");
		initHousingInfoType();
		logger.info(PropertyTypes.HOUSEING_INFO_TYPE + "字典初始化结束!");
		initProfessionType();
		logger.info(PropertyTypes.PROFESSION_TYPE + "字典初始化结束!");
		initCurrentAddressType();
		logger.info(PropertyTypes.CURRENT_ADDRESS_TYPE + "字典初始化结束!");
		initOutReasons();
		logger.info(PropertyTypes.INFRASTRUCTURE + "字典初始化结束!");
		initInfrastructure();
		logger.info(PropertyTypes.LICENSE_SITUATION + "字典初始化结束!");
		initLicenseSituation();
		logger.info(PropertyTypes.ONE_CHILD_SITUATION + "字典初始化结束!");
		initOneChildSituation();
		logger.info(PropertyTypes.DISABILITY_TYPE + "字典初始化结束!");
		initDisabilityTypes();

		initNewEconomicOrganizationsStyle();
		logger.info(PropertyTypes.NEWECONOMICORGANIZATIONS_STYLE + "字典初始化结束!");
		initPartyMemberType();
		logger.info(PropertyTypes.PARTYMEMBER_TYPE + "字典初始化结束!");
		initBecomesState();
		logger.info(PropertyTypes.BECOMES_STATE + "字典初始化结束!");
		initTrainingState();
		logger.info(PropertyTypes.TRAINING_STATE + "字典初始化结束!");

		initTechnologyLevel();
		logger.info(PropertyTypes.TECHNOLOGYLEVEL + "字典初始化结束!");
		initUnemploymentReason();
		logger.info(PropertyTypes.UNEMPLOYMENTREASON + "字典初始化结束!");
		initUnemployedPeopleType();
		logger.info(PropertyTypes.UNEMPLOYEDPEOPLETYPE + "字典初始化结束!");
		initEmploymentIntention();
		logger.info(PropertyTypes.EMPLOYMENTINTENTION + "字典初始化结束!");
		initTrainingIntention();
		logger.info(PropertyTypes.TRAININGINTENTION + "字典初始化结束!");
		initStayLocationType();
		logger.info(PropertyTypes.STAY_LOCATION_TYPE + "字典初始化结束!");
		initEconomySource();
		logger.info(PropertyTypes.ECONOMY_SOURCE + "字典初始化结束!");
		initStayTimeLimit();
		logger.info(PropertyTypes.STAY_TIME_LIMIT + "字典初始化结束!");
		initPreparedStayTimeLimit();
		logger.info(PropertyTypes.PREPARED_STAY_TIME_LIMIT + "字典初始化结束!");
		initBuildingUses();
		logger.info(PropertyTypes.BUILDING_USES + "字典初始化结束!");
		initHouseUses();
		logger.info(PropertyTypes.HOUSE_USES + "字典初始化结束!");
		initHouseSource();
		logger.info(PropertyTypes.HOUSE_SOURCE + "字典初始化结束!");
		initOwnProperty();
		logger.info(PropertyTypes.OWN_PROPERTY + "字典初始化结束!");
		initRentalBuildings();
		logger.info(PropertyTypes.RENTAL_BUILDINGS + "字典初始化结束!");
		initHousingVouchers();
		logger.info(PropertyTypes.HOUSING_VOUCHERS + "字典初始化结束!");
		initLandDocuments();
		logger.info(PropertyTypes.LAND_DOCUMENTS + "字典初始化结束!");
		initPropertyTypes();
		logger.info(PropertyTypes.PROPERTY_TYPES + "字典初始化结束!");
		initLettingCertificateType();
		logger.info(PropertyTypes.LETTINGCERTIFICATE_TYPE + "字典初始化结束!");
		initMangerTypes();
		logger.info(PropertyTypes.MANGER_TYPES + "字典初始化结束!");
		initLessorType();
		logger.info(PropertyTypes.LESSOR_TYPE + "字典初始化结束!");
		initPublicPlaceCloakRomm();
		logger.info(PropertyTypes.PUBLICPLACE_CLOAKROOM + "字典初始化结束");
		initECONOMICNATURE();
		logger.info(PropertyTypes.ACTUALCOMPANY_ECONOMICNATURE + "字典初始化结束");
		initFIREFIGHTINGLEVEL();
		logger.info(PropertyTypes.ACTUALCOMPANY_FIREFIGHTINGLEVEL + "字典初始化结束");
		initSECURITYCLASSIFICATION();
		logger.info(PropertyTypes.ACTUALCOMPANY_SECURITYCLASSIFICATION
				+ "字典初始化结束");
		initSUPERVISORYLEVEL();
		logger.info(PropertyTypes.ACTUALCOMPANY_SUPERVISORYLEVEL + "字典初始化结束");
		initCOMPANYTYPE();
		logger.info(PropertyTypes.ACTUALCOMPANY_COMPANYTYPE + "字典初始化结束");
		initIdleYouthAgeGroup();
		logger.info(PropertyTypes.IDLE_YOUTH_AGE_GROUP + "字典初始化结束");
		initHouseType();
		logger.info(PropertyTypes.HOUSE_TYPE + "字典初始化结束");
		initFHOUSEMARCHTYPE();
		logger.info(PropertyTypes.HOUSE_MARCH_TYPE + "字典初始化结束");
		initLogType();
		logger.info(PropertyTypes.PEOPLELOG_LOGTYPE + "字典初始化结束");
		initSUBJECTION();
		logger.info(PropertyTypes.PEOPLELOG_LOGTYPE + "字典初始化结束");
		initDEGREE();
		logger.info(PropertyTypes.PEOPLELOG_LOGTYPE + "字典初始化结束");
		initSourcePoolType();
		initWorkingRecordType();
		logger.info(PropertyTypes.WORKINGRECORD_TYPE + "字典初始化结束");
		logger.info(PropertyTypes.FILE_SOURCE + "字典初始化结束!");
		initItemMatterKind();
		logger.info(PropertyTypes.ITEM_MATTER_KIND + "字典初始化结束!");
		initWorkBenchType();
		logger.info(PropertyTypes.WORKBENCH_TYPE + "字典初始化结束!");
		initDataFrom();
		logger.info(PropertyTypes.DATAFROM_TYPE + "字典初始化结束!");
		initBuilddatasType();
		logger.info(PropertyTypes.BUILDDATAS_TYPE + "字典初始化结束!");
		initAttentionExtent();
		logger.info(PropertyTypes.ATTENTION_EXTENT + "字典初始化结束!");
		// 新增字典初始化
		initSupportingEffect();
		logger.error(PropertyTypes.SUPPORTINGEFFECT + "字典初始化结束!");
		initCompensationMethod();
		logger.error(PropertyTypes.COMPENSATION_METHOD + "字典初始化结束!");
		initResourcePoolVoewObjType();
		logger.error(PropertyTypes.RESOURCEPOOL_VIEWOBJ_TYPE + "字典初始化结束!");
		initEngageProfession();
		logger.error(PropertyTypes.ENGAEPROFESSINO + "字典初始化结束!");
		initPartyVillagePositions();
		logger.error(PropertyTypes.VILLAGE_LEADER + "字典初始化结束!");
		initPartyPosition();
		logger.error(PropertyTypes.PARTY_POSITION + "字典初始化结束!");
		initAppraisalResultPartJias();
		logger.error(PropertyTypes.APPRAISAL_RESULT_PART_JIAS + "字典初始化结束!");
		initPartyStarts();
		logger.error(PropertyTypes.PARTY_STARTS + "字典初始化结束!");
		initPostJias();
		logger.error(PropertyTypes.POST_JIAS + "字典初始化结束!");
		initVolunteerServiceType();
		logger.error(PropertyTypes.VOLUNTEER_SERVICE_TYPE + "字典初始化结束!");
		initFimilyStance();
		logger.error(PropertyTypes.FIMILY_STANCE + "字典初始化结束!");
		initHaiNingGuardian();
		logger.error(PropertyTypes.GUARDIANRELATIONSHIP + "字典初始化结束!");
		initLiveCause();
		logger.error(PropertyTypes.LIVECAUSE + "字典初始化结束!");
		initContactOffice();
		logger.error(PropertyTypes.CONTACTOFFICE + "字典初始化结束!");
		initPeopleConditionsJudgedType();
		logger.error(PropertyTypes.PEOPLECONDITIONSJUDGEDTYPE + "字典初始化结束!");
		initOtherDuty();
		logger.error(PropertyTypes.OTHER_DUTY + "字典初始化结束!");
		initBarometer();
		logger.error(PropertyTypes.BAROMETER + "字典初始化结束!");
		initLostEarthReason();
		logger.error(PropertyTypes.LOST_EARTH_REASON + "字典初始化结束!");
		initPartyIssueType();
		logger.error(PropertyTypes.PARTY_ISSUE_TYPE + "字典初始化结束!");
		initVolunteerServiceCompletion();
		logger.error(PropertyTypes.VOLUNTEER_SERVICE_COMPLETION + "字典初始化结束!");
		initVolunteerServiceResults();
		logger.error(PropertyTypes.VOLUNTEER_SERVICE_RESULTS + "字典初始化结束!");
		initUncontractingReason();
		logger.error(PropertyTypes.UNCONTRACTING_REASON + "字典初始化结束!");
		initProblemType();
		logger.error(PropertyTypes.PROBLEMTYPE + "字典初始化结束!");
		initNowLocalAddress();
		logger.error(PropertyTypes.NOW_LOCALADDRESS + "字典初始化结束!");
		// 海宁行业类别 2013-04-15 HHY
		initHaiNingBusinessType();
		logger.error(PropertyTypes.BUSINESSTYPE + "字典初始化结束!");
		initVolunteerOccupation();
		logger.error(PropertyTypes.VOLUNTEER_OCCUPATION + "字典初始化结束!");
		initPartyTownPositions();
		logger.error(PropertyTypes.TOWN_LEADER + "字典初始化结束!");
		// 海宁职业类别 2013-04-15 HHY
		initHaiNingOccupationType();
		logger.error(PropertyTypes.OCCUPATIONTYPE + "字典初始化结束!");
		initMostlyWork();
		logger.error(PropertyTypes.MOSTLY_WORK + "字典初始化结束!");
		initDomicileCategory();
		logger.error(PropertyTypes.DOMICILECATEGORY + "字典初始化结束!");
		initStructureHandle();
		logger.error(PropertyTypes.STRUCTURE_HANDLE + "字典初始化结束!");

		initPartType();
		logger.error(PropertyTypesYinchuan.PART_TYPE + "字典初始化结束!");
		initPartName();
		logger.error(PropertyTypesYinchuan.PART_NAME + "字典初始化结束!");

		initPositions();
		logger.error(PropertyTypes.POSITION + "字典初始化结束!");

		initPersonTypes();
		logger.error(PropertyTypes.PERSON_TYPES + "字典初始化结束!");

		initBoundType();
		logger.info(PropertyTypes.BOUNDTYPE + "字典初始化结束!");

		initTerminalCategory();
		logger.info(PropertyTypes.TERMINAL_CATEGORY + "字典初始化结束!");

		initViolationsOfTheLaw();
		logger.info(PropertyTypes.VIOLATIONSOFTHELAW + "字典初始化结束!");

		initCrimeType();
		logger.info(PropertyTypes.CRIMETYPE + "字典初始化结束!");

		initPsychosisType();
		logger.info(PropertyTypes.PSYCHOSIS_TYPES + "字典初始化结束!");

		initScenicEquipType();
		logger.info(PropertyTypes.SCENICEQUIP_TYPES + "字典初始化结束!");

		initScenicTrafficType();
		logger.info(PropertyTypes.SCENICTRAFFIC_TYPES + "字典初始化结束!");

		initPraiseScenicSpotType();
		logger.info(PropertyTypes.PRAISESCENICSPOT_TYPES + "字典初始化结束!");

		initItemName();
		logger.info(PropertyTypes.ITEM_NAME + "字典初始化结束!");
		initTreatmentState();
		logger.info(PropertyTypes.TREATMENTSTATE + "字典初始化结束!");

		initPublicComplexPlacesType();
		logger.info(PropertyTypes.PUBLICCOMPLEXPLACES_TYPE + "字典初始化结束!");
		initPublicComplexPlacesDetailedType();
		logger
				.info(PropertyTypes.PUBLICCOMPLEXPLACES_DETAILEDTYPE
						+ "字典初始化结束!");
		initYouthAges();
		logger.info(PropertyTypes.YOUTH_AGES + "字典初始化结束!");
		initReportDateType();
		logger.info(PropertyTypes.REPORT_DATE_TYPE + "字典初始化结束!");
		initFunctionalOrgType();
		logger.info(PropertyTypes.FUNCTIONAL_ORG_TYPE + "字典初始化结束!");
		initUrgentLevelProperty();
		logger.info(PropertyTypes.URGENT_LEVEL + "字典初始化结束!");

		// 民生诉求台账
		initPositionOrStatus();
		logger.info(PropertyTypes.POSITION_OR_STATUS + "字典初始化结束!");
		initAppealHumanType();
		logger.info(PropertyTypes.APPEAL_HUMAN_TYPE + "字典初始化结束!");
		initItemCategory();
		logger.info(PropertyTypes.ITEM_CATEGORY + "字典初始化结束!");
		initItemCategorySub();
		logger.info(PropertyTypes.ITEM_CATEGORY_SUB + "字典初始化结束!");
		initCreateTableType();
		logger.info(PropertyTypes.CREATE_TABLE_TYPE + "字典初始化结束!");

		initPoorBigInfoType();
		logger.info(PropertyTypes.POORBIGINFO + "字典初始化结束!");
		initPoorInfType();
		logger.info(PropertyTypes.POORINFO + "字典初始化结束!");
		initInsuranceType();
		logger.info(PropertyTypes.INSURANCETYPE + "字典初始化结束!");
		initPositionorIdentityType();
		logger.info(PropertyTypes.POSITIONORIDENTITY + "字典初始化结束!");

		initInvolvingSteadyType();
		logger.info(PropertyTypes.INVOLVING_STEADY_TYPE + "字典初始化结束!");

		initBasicLevelPartyType();
		logger.info(PropertyTypes.BASICLEVELPARTY_TYPE + "字典初始化结束!");

		initBasicLevelPartyDuty();
		logger.info(PropertyTypes.BASICLEVELPARTYDUTY + "字典初始化结束!");

		initDepartmentPartyType();
		logger.info(PropertyTypes.DEPARTMENTPARTY_TYPE + "字典初始化结束!");

		initDepartmentPartyDuty();
		logger.info(PropertyTypes.DEPARTMENTPARTYDUTY + "字典初始化结束!");

		initGovernmentDepartmentType();
		logger.info(PropertyTypes.GOVERNMENTDEPARTMENT_TYPE + "字典初始化结束!");

		initGovernmentDepartmentDuty();
		logger.info(PropertyTypes.GOVERNMENTDEPARTMENTDUTY + "字典初始化结束!");

		initMassOrgManagementDuty();
		logger.info(PropertyTypes.MASSORGMANAGEMENTDUTY + "字典初始化结束!");

		initAspirationType();
		logger.info(PropertyTypes.ASPIRATIONTYPE + "字典初始化结束!");

		initBelongOrg();
		logger.info(PropertyTypes.BELONG_ORG + "字典初始化结束!");

		initPartyOrgType();
		logger.info(PropertyTypes.PARTYORGTYPE + "字典初始化结束!");

		initDemocracy();
		logger.info(PropertyTypes.DEMOCRACY + "字典初始化结束!");

		initPartyOrgDuty();
		logger.info(PropertyTypes.PARTYORGDUTY + "字典初始化结束!");

		initMassOrganization();
		logger.info(PropertyTypes.MASSORGANIZATION_TYPE + "字典初始化结束!");

		initAccountTimeLimitLevel();
		logger.info(PropertyTypes.ACCOUNT_TIME_LIMIT_LEVEL + "字典初始化结束!");

		initPlatformDuty();
		logger.info(PropertyTypes.PLATFORMDUTY + "字典初始化结束!");
		initManagementType();
		logger.info(PropertyTypes.MANAGEMENT_TYPE + "字典初始化结束!");
		// 部门党委级别
		initDepartmentPartyLevel();
		logger.info(PropertyTypes.DEPARTMENTPARTY_LEVEL + "字典初始化结束!");
		initCompanyPlaceType();
		logger.info(PropertyTypes.COMPANY_PLACE_TYPE + "字典初始化结束!");
		initCompanyPlaceClassification();
		logger.info(PropertyTypes.COMPANY_PLACE_CLASSIFICATION + "字典初始化结束!");
		initCompanyPlaceCateory();
		logger.info(PropertyTypes.COMPANY_PLACE_CATEGORY + "字典初始化结束!");
		initPollutionType();
		logger.info(PropertyTypes.POLLUTION_TYPE + "字典初始化结束!");
		initEffectEvaluationType();
		logger.info(PropertyTypes.EFFECT_EVALUATION_TYPE + "字典初始化结束!");
		initManagementLevelType();
		logger.info(PropertyTypes.MANAGEMENT_LEVEL + "字典初始化结束!");
		// 四支队伍主管部门
		initFourteamsCompetentDepartment();
		logger.info(PropertyTypes.FOURTEAMS_COMPETENT_DEPARTMENT + "字典初始化结束!");
		// 事件对接事件类型
		initIssueJointType();
		logger.info(PropertyTypes.ISSUE_JOINT_TYPE + "字典初始化结束!");
		initIssueJointTypeSub();
		logger.info(PropertyTypes.ISSUE_JOINT_TYPE_SUB + "字典初始化结束!");

		initIndustryType();
		logger.info(PropertyTypes.INDUSTRY_TYPE + "字典初始化结束!");
		initWasteWaterType();
		logger.info(PropertyTypes.WASTEWATER_TYPE + "字典初始化结束!");
		initWasteSolidType();
		logger.info(PropertyTypes.WASTESOLID_TYPE + "字典初始化结束!");
		initRadioactionType();
		logger.info(PropertyTypes.RADIOACTION_TYPE + "字典初始化结束!");
		initNoiseType();
		logger.info(PropertyTypes.NOISE_TYPE + "字典初始化结束!");
		initWastegasType();
		logger.info(PropertyTypes.WASTEGAS_TYPE + "字典初始化结束!");
		initAssessmentType();
		logger.info(PropertyTypes.ASSESSMENT_TYPE + "字典初始化结束!");
		initLowasicsType();
		logger.info(PropertyTypes.LOWASICS_TYPE + "字典初始化结束!");
		initConcernType();
		logger.info(PropertyTypes.CONCERN_TYPE + "字典初始化结束!");
		initRelationShipType();
		logger.info(PropertyTypes.RELATIONSHIP_TYPE + "字典初始化结束!");
		initUnitType();
		logger.info(PropertyTypes.UNIT_TYPE + "字典初始化结束!");
		initScaleType();
		logger.info(PropertyTypes.SCALE_TYPE + "字典初始化结束!");
		initKeyinDustryType();
		logger.info(PropertyTypes.KEYINDUSTRY_TYPE + "字典初始化结束!");
		initSuperviseType();
		logger.info(PropertyTypes.SUPERVISE_TYPE + "字典初始化结束!");
		initContaminationType();
		logger.info(PropertyTypes.CONTAMINATION_TYPE + "字典初始化结束!");
		initTradeType();
		logger.info(PropertyTypes.TRADE_TYPE + "字典初始化结束!");
		initTradeTypeSmall();
		logger.info(PropertyTypes.TRADE_TYPE_SMALL + "字典初始化结束!");
		initBasin();
		logger.info(PropertyTypes.BASIN + "字典初始化结束!");
		initLicensingType();
		logger.info(PropertyTypes.LICENSING_TYPE + "字典初始化结束!");
		initAlarmCenter();
		logger.info(PropertyTypes.ALARMCENTER + "字典初始化结束!");
		initPoliceRoom();
		logger.info(PropertyTypes.POLICEROOM + "字典初始化结束!");
		initMessageType();
		logger.info(PropertyTypes.MESSAGETYPE + "字典初始化结束!");
		initInsureSituation();
		logger.info(PropertyTypes.INSURE_SITUATION + "字典初始化结束!");
		initInsureSituationSub();
		logger.info(PropertyTypes.INSURE_SITUATION_SUB + "字典初始化结束!");
		initDisableGrade();
		logger.info(PropertyTypes.DISABLE_GRADE + "字典初始化结束!");
		initSacrifice();
		logger.info(PropertyTypes.IS_SACRIFICE + "字典初始化结束!");
		initAward();
		logger.info(PropertyTypes.AWARD + "字典初始化结束!");
		initDifficuleTypeOfGoodSamaritan();
		logger.info(PropertyTypes.DIFFICULT_TYPE_GOOD_SAMARITAN + "字典初始化结束!");

		/** 三本台账字典项初始化 */
		initWaterCategory();
		logger.info(PropertyTypes.LEDGER_WATEER_PROJECT + "字典初始化结束!");
		initWaterSubCategory();
		logger.info(PropertyTypes.LEDGER_WATEER_PROJECT_SUB_TYPE + "字典初始化结束!");

		initWaterBuildCategory();
		logger.info(PropertyTypes.LEDGER_WATEER_BUILD_TYPE + "字典初始化结束!");
		initTrafficBuildType();
		logger.info(PropertyTypes.TRAFFIC_BUILD_TYPE + "字典初始化结束!");
		initTrafficPassenger();
		logger.info(PropertyTypes.TRAFFIC_PASSENGER + "字典初始化结束!");
		initTrafficPassengerBuild();
		logger.info(PropertyTypes.TRAFFIC_PASSENGER_BUILD + "字典初始化结束!");
		initTrafficPassengerManage();
		logger.info(PropertyTypes.TRAFFIC_PASSENGER_MANAGE + "字典初始化结束!");
		initTrafficProject();
		logger.info(PropertyTypes.TRAFFIC_PROJECT + "字典初始化结束!");
		initTrafficPublic();
		logger.info(PropertyTypes.TRAFFIC_PUBLIC_TRANSPORT + "字典初始化结束!");
		initTrafficRoad();
		logger.info(PropertyTypes.TRAFFIC_ROAD + "字典初始化结束!");
		initSecurity();
		logger.info(PropertyTypes.TRAFFIC_SECURITY + "字典初始化结束!");
		initTrafficSurface();
		logger.info(PropertyTypes.TRAFFIC_ROADSURFACE + "字典初始化结束!");
		initLedgerOther();
		logger.info(PropertyTypes.LEDGER_OTHER_BUILD_TYPE + "字典初始化结束!");
		initLedgerAgriculture();
		logger.info(PropertyTypes.AGRICULTURE_PROJECT_BUILD_TYPE + "字典初始化结束!");
		initLedgerAgricultureCategory();
		logger.info(PropertyTypes.AGRICULTURE_PROJECT + "字典初始化结束!");
		initLedgerAgricultureSubCategory();
		logger.info(PropertyTypes.AGRICULTURE_PROJECT_SUB + "字典初始化结束!");
		initLedgerTownCategroy();
		logger.info(PropertyTypes.TOWN_PROJECT + "字典初始化结束!");
		initLedgerTownSubCategroy();
		logger.info(PropertyTypes.TOWN_PROJECT_SUB + "字典初始化结束!");
		initLedgeEnviroUnit();
		logger.info(PropertyTypes.ENVIRONMENT_UNIT + "字典初始化结束!");
		initLedgeEnviroCategroy();
		logger.info(PropertyTypes.ENVIRONMENT_PROJECT + "字典初始化结束!");
		initLedgeEnviroSubCategroy();
		logger.info(PropertyTypes.ENVIRONMENT_PROJECT_SUB + "字典初始化结束!");
		initLedgeMedicalBuildType();
		logger.info(PropertyTypes.MEDICAL_BUILD_TYPE + "字典初始化结束!");
		initLedgeMedicalCategroy();
		logger.info(PropertyTypes.MEDICAL_PROJECT + "字典初始化结束!");
		initLedgeMedicalSubCategroy();
		logger.info(PropertyTypes.MEDICAL_PROJECT_SUB + "字典初始化结束!");
		initLedgeEducationBuildType();
		logger.info(PropertyTypes.EDUCATION_BUILD_TYPE + "字典初始化结束!");
		initLedgeEducationCategroy();
		logger.info(PropertyTypes.EDUCATION_PROJECT + "字典初始化结束!");
		initLedgeEducationSubCategroy();
		logger.info(PropertyTypes.EDUCATION_PROJECT_SUB + "字典初始化结束!");
		initLedgeScienceBuildType();
		logger.info(PropertyTypes.SCIENCE_BUILD_TYPE + "字典初始化结束!");
		initLedgeScienceLevel();
		logger.info(PropertyTypes.SCIENCE_PROJECT_LEVEL + "字典初始化结束!");
		initLedgeScienceProject();
		logger.info(PropertyTypes.SCIENCE_PROJECT + "字典初始化结束!");
		initLedgeScienceSubProject();
		logger.info(PropertyTypes.SCIENCE_PROJECT_SUB + "字典初始化结束!");
		initLedgeEnergyBuildType();
		logger.info(PropertyTypes.ENERGY_BUILD_TYPE + "字典初始化结束!");
		initLedgeEnergyUnit();
		logger.info(PropertyTypes.ENERGY_UNIT + "字典初始化结束!");
		initLedgeEnergyLine();
		logger.info(PropertyTypes.ENERGY_LINE_CATEGORY + "字典初始化结束!");
		initLedgeEnergyPipeLine();
		logger.info(PropertyTypes.ENERGY_PIPELINE_CATEGORY + "字典初始化结束!");
		initLedgeEnergyPipeMaterial();
		logger.info(PropertyTypes.ENERGY_PIPE_MATERIAL_CATEGORY + "字典初始化结束!");
		initLedgeEnergyProject();
		logger.info(PropertyTypes.ENERGY_PROJECT + "字典初始化结束!");
		initLedgeEnergySubProject();
		logger.info(PropertyTypes.ENERGY_PROJECT_SUB_TYPE + "字典初始化结束!");
		initLedgeEnergySecurity();
		logger.info(PropertyTypes.ENERGY_SECURITY_CATEGORY + "字典初始化结束!");
		initLedgeLabor();
		logger.info(PropertyTypes.LABOR_PROJECT + "字典初始化结束!");
		initLedgeLaborSub();
		logger.info(PropertyTypes.LABOR_PROJECT_SUB + "字典初始化结束!");
		initLedgeLaborContent();
		logger.info(PropertyTypes.LABOR_PROJECT_CONTENT + "字典初始化结束!");
		initLedgeTownBuildType();
		logger.info(PropertyTypes.TOWN_PROJECT_BUILD_TYPE + "字典初始化结束!");
		initLedgeEnviroBuildType();
		logger.info(PropertyTypes.ENVIRONMENT_BUILD_TYPE + "字典初始化结束!");
		initLedgerPoorPeopleSecurityType();
		logger
				.info(PropertyTypes.LEDGER_POOR_PEOPLE_SECURITY_TYPE
						+ "字典初始化结束!");
		initLedgerPoorPeopleDifficultType();
		logger.info(PropertyTypes.LEDGER_POOR_PEOPLE_DIFFICULT_TYPE
				+ "字典初始化结束!");
		initLedgerPoorPeopleDifficultCause();
		logger.info(PropertyTypes.LEDGER_POOR_PEOPLE_DIFFICULT_CAUSE
				+ "字典初始化结束!");
		initLedgerPoorPeopleSpecificNeed();
		logger
				.info(PropertyTypes.LEDGER_POOR_PEOPLE_SPECIFIC_NEED
						+ "字典初始化结束!");
		initLedgerSteadyWorkInvolvingSteadyType();
		logger.info(PropertyTypes.STEADY_RECORD_WORK_INVOLVING_STEADY_TYPE
				+ "字典初始化结束!");
		initLedgerSteadyWorkType();
		logger.info(PropertyTypes.STEADY_RECORD_WORK_TYPE + "字典初始化结束!");
		initLedgerSteadyWorkProblemType();
		logger.info(PropertyTypes.STEADY_RECORD_WORK_PROBLEM_TYPE + "字典初始化结束!");
		initPeopleAspirationCreateTableType();
		logger.info(PropertyTypes.LEDGER_PEOPLEASPIRATION_CREATE_TABLE_TYPE
				+ "字典初始化结束!");
		initPeopleAspirationAppealHumanType();
		logger.info(PropertyTypes.LEDGER_APPEAL_HUMAN_TYPE + "字典初始化结束!");
		initTrafficSecurityService();
		logger.info(PropertyTypes.TRAFFIC_SECURITY_SERVICE + "字典初始化结束!");
		initTrafficLevel();
		logger.info(PropertyTypes.TRAFFIC_LEVEL + "字典初始化结束!");
		initScienceBroadcast();
		logger.info(PropertyTypes.SCIENCE_BROADCAST + "字典初始化结束!");
		initLaborDignity();
		logger.info(PropertyTypes.LABOR_DIGNITY + "字典初始化结束!");
		initLaborCripple();
		logger.info(PropertyTypes.LABOR_CRIPPLE + "字典初始化结束!");
		initLaborAge();
		logger.info(PropertyTypes.LABOR_AGE + "字典初始化结束!");
		initDegreeProperty();
		logger.info(PropertyTypes.LEDGER_DEGREE + "字典初始化结束!");
		initTownSecurity();
		logger.info(PropertyTypes.TOWN_SECURITY_TYPE + "字典初始化结束!");
		initAgricultureFraming();
		logger.info(PropertyTypes.AGRICULTURE_FARMING_TRAIN + "字典初始化结束!");
		initAgricultureMachine();
		logger.info(PropertyTypes.AGRICULTURE_MACHINERY_TRAIN + "字典初始化结束!");
		initOtherProject();
		logger.info(PropertyTypes.OTHER_PROJECT + "字典初始化结束!");
		initTrafficType();
		logger.info(PropertyTypes.TRAFFIC_PASSTYPE + "字典初始化结束!");
		initEduScopeType();
		logger.info(PropertyTypes.EDUCATION_SCOPE_TYPE + "字典初始化结束!");
		initEduModeType();
		logger.info(PropertyTypes.EDUCATION_MODE_TYPE + "字典初始化结束!");
		initEduItemType();
		logger.info(PropertyTypes.EDUCATION_ITEM_TYPE + "字典初始化结束!");
		initEduRoadType();
		logger.info(PropertyTypes.EDUCATION_ROAD_TYPE + "字典初始化结束!");
		initEduDistanceType();
		logger.info(PropertyTypes.EDUCATION_DISTANCE_TYPE + "字典初始化结束!");
		initEduRoadConditionType();
		logger.info(PropertyTypes.EDUCATION_ROAD_CONDITION_TYPE + "字典初始化结束!");
		initEduDegreeType();
		logger.info(PropertyTypes.EDUCATION_DEGREE_TYPE + "字典初始化结束!");
		initEduAddressType();
		logger.info(PropertyTypes.EDUCATION_ADDRESS_TYPE + "字典初始化结束!");
		initSteadyRecordWorkWarnLevel();
		logger.info(PropertyTypes.STEADY_RECORD_WORK_WARN_LEVEL + "字典项初始化结束");
		/** 三本台账字典项初始化 */
		initHelpingSituation();
		logger.info(PropertyTypes.HELPING_SITUATION_TYPE + "字典项初始化结束");
		/** job策略 */
		initTaskNature();
		logger.info(PropertyTypes.TASKPLOY_TYPE + "字典初始化结束!");
		initTaskFrequencyNature();
		logger.info(PropertyTypes.TASK_FREQUENCY + "字典初始化结束!");
		initAssignMeetingType();
		logger.info(PropertyTypes.ASSGIN_MEETING_TYPE + "字典初始化结束!");
		initWorkingContentType();
		logger.info(PropertyTypes.WORKING_CONTENT_TYPE + "字典初始化结束!");

		initExceptionSituationType();
		logger.info(PropertyTypes.EXCEPTION_SITUATION_TYPE + "字典初始化结束!");

		initDangerExceptionType();
		logger.info(PropertyTypes.DANGER_EXCEPTION_TYPE + "字典初始化结束!");

		initMentalPatientOutReason();
		logger.info(PropertyTypes.MENTALPATIENT_OUT_REASON + "字典初始化结束!");

		initDruggyLifeResource();
		logger.info(PropertyTypes.DRUGGY_LIFE_RESOURCE + "字典初始化结束!");

		initFormType();
		logger.info(PropertyTypes.FORM_TYPE + "字典初始化结束!");

		initRedCuffTeamType();
		logger.info(PropertyTypes.RED_CUFF_TEAM_TYPE + "字典初始化结束!");
		initLedgerType();
		logger.info(PropertyTypes.LEDGER_TYPE + "字典初始化结束!");
		initLedgerStatus();
		logger.info(PropertyTypes.LEDGER_STATUS + "字典初始化结束!");

		initRedCuffSubTeamType();
		logger.info(PropertyTypes.RED_CUFF_TEAM_SUB_TYPE + "字典初始化结束!");

		initWeChatType();
		logger.info(PropertyTypes.WECHAT_TYPE + "字典初始化结束!");

		initGridPositionType();
		logger.info(PropertyTypes.GRID_POSITIONTYPE + "字典初始化结束!");

		//食药工商 数据字典
		initPolicyPropagandaCategory();
		logger.info(PropertyTypes.POLICY_PROPAGANDA_CATEGORY + "字典初始化结束!");//政策法规宣传类别
		initFoodSaftyCategory();
		logger.info(PropertyTypes.FOOD_SAFTY_CATEGORY + "字典初始化结束!");//食品安全协管类别
		initDrugsSaftyCategory();
		logger.info(PropertyTypes.DRUGS_SAFTY_CATEGORY + "字典初始化结束!");//药品安全协管类别
		initBusinessManageCategory();
		logger.info(PropertyTypes.BUSINESS_MANAGE_CATEGORY + "字典初始化结束!");//工商行政管理协管类别
		initPyramidCategory();
		logger.info(PropertyTypes.PYRAMID_CATEGORY + "字典初始化结束!");//打击非法传销协管类别
		initPyramidSalesCategory();
		logger.info(PropertyTypes.PYRAMID_SALES_CATEGORY + "字典初始化结束!");//传销类别
		initUnlicensedCategory();
		logger.info(PropertyTypes.UNLICENSED_CATEGORY + "字典初始化结束!");//查处取缔无证无照经营协管类别

		initTaskListItemName();
		logger.info(PropertyTypes.TASKLIST_ITEM_NAME + "字典初始化结束!");
		
		//新农村 龙头企业管理 --经济性质字典初始化
		initEconomicCharacter();
		logger.info(PropertyTypes.ECONOMICCHARACTER+ "字典初始化结束!");
	}
	private void initEconomicCharacter(){
		propertyDomain = addPropertyDomain(PropertyTypes.ECONOMICCHARACTER,
				false, null);
		addPropertyDict("非公司企业法人", 0, 1);
		addPropertyDict("有限责任公司", 0, 2);
		addPropertyDict("股份有限责任公司", 0, 3);
		addPropertyDict("个体工商户", 0, 4);
		addPropertyDict("私营独资企业", 0, 5);
		addPropertyDict("私营合伙企业", 0, 6);
	}
	
	private void initPolicyPropagandaCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.POLICY_PROPAGANDA_CATEGORY,
				false, null);
		addPropertyDict("食品类", 0, 1);
		addPropertyDict("药品类", 0, 2);
		addPropertyDict("工商类", 0, 3);
		addPropertyDict("打击非法传销", 0, 4);
	}

	private void initFoodSaftyCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.FOOD_SAFTY_CATEGORY,
				false, null);
		addPropertyDict(PropertyTypes.RURAL_FAMILY, 0, 1);
		addPropertyDict(PropertyTypes.HEALTH_CARE_PRODUCTS, 0, 2);
		addPropertyDict(PropertyTypes.FOOD_POISONING, 0, 3);
	}

	private void initDrugsSaftyCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.DRUGS_SAFTY_CATEGORY,
				false, null);
		addPropertyDict("药品医疗器械化妆品", 0, 1);
		addPropertyDict("药品不良反应", 0, 2);
	}

	private void initBusinessManageCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.BUSINESS_MANAGE_CATEGORY,
				false, null);
		addPropertyDict("商品质量", 0, 1);
		addPropertyDict("商标", 0, 2);
		addPropertyDict("广告", 0, 3);
		addPropertyDict("网络", 0, 4);
		addPropertyDict("报废及拼装车", 0, 4);
	}

	private void initPyramidCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.PYRAMID_CATEGORY,
				false, null);
		addPropertyDict("聚集地点", 1, 1);
		addPropertyDict("传销方式", 2, 2);
		addPropertyDict("其他异常情况", 3, 3);
	}

	private void initPyramidSalesCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.PYRAMID_SALES_CATEGORY,
				false, null);
		addPropertyDict("居民居住地", 1, 1);
		addPropertyDict("公共场所", 1, 2);
		addPropertyDict("城乡结合部或农村", 1, 3);

		addPropertyDict("是否拉人头", 2, 4);
		addPropertyDict("缴纳入门费", 2, 5);
		addPropertyDict("网络传销", 2, 6);

		addPropertyDict("其他", 3, 7);
	}

	private void initUnlicensedCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.UNLICENSED_CATEGORY,
				false, null);
		addPropertyDict("食品生产或经营许可", 0, 1);
		addPropertyDict("药品生产或经营许可", 0, 2);
		addPropertyDict("营业执照", 0, 3);
		addPropertyDict("其他行政许可", 0, 4);
	}

	/**
	 * **************************** 新增字段初始化
	 * *************************************
	 */


	/**
	 * 帮扶成效
	 */
	private void initSupportingEffect() {
		propertyDomain = addPropertyDomain(PropertyTypes.SUPPORTINGEFFECT,
				true, JiasPartyBuildSupportingEffect.getInternalProperties());
		addPropertyDict("非常好", JiasPartyBuildSupportingEffect.FEICHANGHAO, 1);
		addPropertyDict("好", JiasPartyBuildSupportingEffect.HAO, 2);
		addPropertyDict("一般", JiasPartyBuildSupportingEffect.YIBAN, 3);
		addPropertyDict("不好", JiasPartyBuildSupportingEffect.BUHAO, 4);
	}

	private void initCompensationMethod() {
		propertyDomain = addPropertyDomain(PropertyTypes.COMPENSATION_METHOD,
				false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("货币补偿", 0, 2);
		addPropertyDict("安排招工", 0, 3);
		addPropertyDict("生活补助", 0, 4);
		addPropertyDict("养老保障", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	private void initResourcePoolVoewObjType() {
		propertyDomain = addPropertyDomain(
				ResourcePoolPremissionType.RESOURCEPOOL_VIEWOBJ_TYPE_KEY, true,
				ResourcePoolPremissionType.getInternalProperties());
		addPropertyDict("本级", ResourcePoolPremissionType.OWN, 1);
		addPropertyDict("直属下级", ResourcePoolPremissionType.DIRECTLY_UNDER, 2);
		addPropertyDict("所有下辖", ResourcePoolPremissionType.ALL_UNDER, 3);
	}

	private void initEngageProfession() {
		propertyDomain = addPropertyDomain(PropertyTypes.ENGAEPROFESSINO,
				false, null);
		addPropertyDict("生产制造加工", 0, 1);
		addPropertyDict("工程施工", 0, 2);
		addPropertyDict("运输服务", 0, 3);
		addPropertyDict("装饰装修", 0, 4);
		addPropertyDict("餐饮服务", 0, 5);
		addPropertyDict("休闲娱乐服务", 0, 6);
		addPropertyDict("家政服务", 0, 7);
		addPropertyDict("保安物管", 0, 8);
		addPropertyDict("维修服务", 0, 9);
		addPropertyDict("废旧物品收购", 0, 10);
		addPropertyDict("其他商业服务", 0, 11);
		addPropertyDict("农林牧渔生产", 0, 12);
		addPropertyDict("其他职业", 0, 13);
		addPropertyDict("失业", 0, 14);
	}

	public void initPartyVillagePositions() {
		propertyDomain = addPropertyDomain(PropertyTypes.VILLAGE_LEADER, false,
				null);
		addPropertyDict("书记", 0, 1);
		addPropertyDict("大学生村官", 1, 2);
		addPropertyDict("主任", 2, 3);
		addPropertyDict("其他村干部", 3, 4);
	}

	private void initPartyPosition() {
		propertyDomain = addPropertyDomain(PropertyTypes.PARTY_POSITION, false,
				null);
		addPropertyDict("书记", 0, 1);
		addPropertyDict("副书记", 1, 2);
		addPropertyDict("组织委员", 2, 3);
		addPropertyDict("宣传委员", 3, 4);
		addPropertyDict("纪检委员", 4, 5);
		addPropertyDict("青年委员", 5, 6);
		addPropertyDict("其他", 6, 7);
	}

	private void initAppraisalResultPartJias() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.APPRAISAL_RESULT_PART_JIAS, false, null);
		addPropertyDict("合格", 0, 1);
		addPropertyDict("较好", 0, 2);
		addPropertyDict("优秀", 0, 3);
		addPropertyDict("履诺中", 0, 4);
	}

	private void initPartyStarts() {
		propertyDomain = addPropertyDomain(PropertyTypes.PARTY_STARTS, false,
				null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("一星级", 0, 2);
		addPropertyDict("二星级", 0, 3);
		addPropertyDict("三星级", 0, 4);
		addPropertyDict("四星级", 0, 5);
		addPropertyDict("五星级", 0, 6);
	}

	private void initPostJias() {
		propertyDomain = addPropertyDomain(PropertyTypes.POST_JIAS, false, null);
		addPropertyDict("党委书记", 0, 1);
		addPropertyDict("党委副书记", 0, 2);
		addPropertyDict("党委委员", 0, 3);
		addPropertyDict("镇长（办事处主任）", 0, 4);
		addPropertyDict("副镇长（副主任）", 0, 5);
		addPropertyDict("人大主席（人大工委主任）", 0, 6);
		addPropertyDict("政协联络室主任", 0, 7);
		addPropertyDict("政协联络室副主任", 0, 8);
		addPropertyDict("镇长助理（主任助理）", 0, 9);
		addPropertyDict("正科级巡视员", 0, 10);
		addPropertyDict("副科级巡视员", 0, 11);
		addPropertyDict("正科级干部", 0, 12);
		addPropertyDict("副科级干部", 0, 13);
		addPropertyDict("其他", 0, 14);
	}

	private void initVolunteerServiceType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.VOLUNTEER_SERVICE_TYPE, false, null);
		addPropertyDict("家电维护", 0, 1);
		addPropertyDict("法律援助", 0, 2);
		addPropertyDict("环保宣传", 0, 3);
		addPropertyDict("医疗服务", 0, 4);
		addPropertyDict("网络服务", 0, 5);
		addPropertyDict("文艺服务", 0, 6);
		addPropertyDict("心理咨询", 0, 7);
		addPropertyDict("电脑维修", 0, 8);
		addPropertyDict("社区活动", 0, 9);
		addPropertyDict("公益活动", 0, 10);
		addPropertyDict("网站设计与维护", 0, 11);
		addPropertyDict("助老", 0, 12);
		addPropertyDict("助残", 0, 13);
		addPropertyDict("探访", 0, 14);
		addPropertyDict("助学", 0, 15);
		addPropertyDict("助困", 0, 16);
		addPropertyDict("助病", 0, 17);
	}

	private void initFimilyStance() {
		propertyDomain = addPropertyDomain(PropertyTypes.FIMILY_STANCE, false,
				null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("小康", 0, 2);
		addPropertyDict("困难", 0, 3);
		addPropertyDict("富裕", 0, 4);
		addPropertyDict("温饱", 0, 5);
		addPropertyDict("特困", 0, 6);
		addPropertyDict("其他", 0, 7);
	}

	// 海宁监护关系 2013-04-15 HHY
	private void initHaiNingGuardian() {
		propertyDomain = addPropertyDomain(PropertyTypes.GUARDIANRELATIONSHIP,
				false, null);
		addPropertyDict("父母", 0, 1);
		addPropertyDict("成年子女", 0, 2);
		addPropertyDict("配偶", 0, 3);
		addPropertyDict("兄弟姐妹", 0, 4);
		addPropertyDict("祖父母", 0, 5);
		addPropertyDict("外祖父母", 0, 6);
		addPropertyDict("孙子女", 0, 7);
		addPropertyDict("外孙子女", 0, 8);
		addPropertyDict("其他", 0, 9);
	}

	private void initLiveCause() {
		propertyDomain = addPropertyDomain(PropertyTypes.LIVECAUSE, false, null);
		addPropertyDict("务工", 0, 1);
		addPropertyDict("务农", 0, 2);
		addPropertyDict("经商", 0, 3);
		addPropertyDict("保姆", 0, 4);
		addPropertyDict("服务", 0, 5);
		addPropertyDict("因公出差", 0, 6);
		addPropertyDict("借读培训", 0, 7);
		addPropertyDict("治疗养伤", 0, 8);
		addPropertyDict("投靠亲友", 0, 9);
		addPropertyDict("探亲访友", 0, 10);
		addPropertyDict("旅游观光", 0, 11);
		addPropertyDict("其他", 0, 12);

	}

	private void initContactOffice() {
		propertyDomain = addPropertyDomain(PropertyTypes.CONTACTOFFICE, false,
				null);
		addPropertyDict("干部科", 0, 1);
		addPropertyDict("组织科", 0, 2);
		addPropertyDict("党联办", 0, 3);
		addPropertyDict("电教中心", 0, 4);
		addPropertyDict("办公室", 0, 5);
		addPropertyDict("人才科", 0, 6);
	}

	/**
	 * 民情研判会类别
	 */
	public void initPeopleConditionsJudgedType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.PEOPLECONDITIONSJUDGEDTYPE, false, null);
		addPropertyDict("民情分析会", 0, 1);
		addPropertyDict("民情恳谈会", 0, 2);
	}

	private void initOtherDuty() {
		propertyDomain = addPropertyDomain(PropertyTypes.OTHER_DUTY, false,
				null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("党委书记", 0, 2);
		addPropertyDict("支部副书记", 0, 3);
		addPropertyDict("党小组长", 0, 4);
		addPropertyDict("党委委员", 0, 5);
		addPropertyDict("纪委副书记", 0, 6);
		addPropertyDict("总支书记", 0, 7);
		addPropertyDict("总支委员", 0, 8);
		addPropertyDict("支部书记", 0, 9);
		addPropertyDict("支部委员", 0, 10);
		addPropertyDict("党委副书记", 0, 11);
		addPropertyDict("纪委书记", 0, 12);
		addPropertyDict("纪委委员", 0, 13);
		addPropertyDict("总支副书记", 0, 14);
		addPropertyDict("其他", 0, 15);
	}

	/**
	 * 晴雨表
	 */
	private void initBarometer() {
		propertyDomain = addPropertyDomain(PropertyTypes.BAROMETER, true,
				JiasPartyBuildBarometerType.getInternalProperties());
		addPropertyDict("晴", JiasPartyBuildBarometerType.QING, 1);
		addPropertyDict("多云", JiasPartyBuildBarometerType.DUOYUN, 2);
		addPropertyDict("阴", JiasPartyBuildBarometerType.YIN, 3);
		addPropertyDict("雨", JiasPartyBuildBarometerType.YU, 4);
	}

	private void initLostEarthReason() {
		propertyDomain = addPropertyDomain(PropertyTypes.LOST_EARTH_REASON,
				false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("征收征用", 0, 2);
		addPropertyDict("镇公益使用", 0, 3);
		addPropertyDict("村集体使用", 0, 4);
		addPropertyDict("流转转让", 0, 5);
		addPropertyDict("本人未承包", 0, 6);
		addPropertyDict("其他", 0, 7);
	}

	public void initPartyIssueType() {
		propertyDomain = addPropertyDomain(PropertyTypes.PARTY_ISSUE_TYPE,
				false, null);
		addPropertyDict("征地拆迁", 0, 1);
		addPropertyDict("创业帮扶", 1, 2);
		addPropertyDict("子女就学", 2, 3);
		addPropertyDict("矛盾纠纷", 3, 4);
		addPropertyDict("环境卫生", 4, 5);
		addPropertyDict("生活困难", 5, 6);
		addPropertyDict("政策咨询", 6, 7);
		addPropertyDict("其它", 7, 8);
	}

	private void initVolunteerServiceCompletion() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.VOLUNTEER_SERVICE_COMPLETION, false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("完成", 0, 2);
		addPropertyDict("未完成", 0, 3);
	}

	private void initVolunteerServiceResults() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.VOLUNTEER_SERVICE_RESULTS, false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("满意", 0, 2);
		addPropertyDict("一般", 0, 3);
		addPropertyDict("不满意", 0, 4);
	}

	private void initUncontractingReason() {
		propertyDomain = addPropertyDomain(PropertyTypes.UNCONTRACTING_REASON,
				false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("自愿放弃", 0, 2);
		addPropertyDict("长期在外", 0, 3);
		addPropertyDict("待三轮承包", 0, 4);
		addPropertyDict("老弱病残", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	/**
	 * 问题类型
	 */
	private void initProblemType() {
		propertyDomain = addPropertyDomain(PropertyTypes.PROBLEMTYPE, false,
				null);
		addPropertyDict("民生类", 0, 1);
		addPropertyDict("创业类", 0, 2);
		addPropertyDict("矛盾纠纷类", 0, 3);
	}

	private void initNowLocalAddress() {
		propertyDomain = addPropertyDomain(PropertyTypes.NOW_LOCALADDRESS,
				false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("未持流动证", 0, 2);
		addPropertyDict("持流动证", 0, 3);
		addPropertyDict("本地", 0, 4);
	}

	// 海宁行业类别 2013-04-15 HHY
	private void initHaiNingBusinessType() {
		propertyDomain = addPropertyDomain(PropertyTypes.BUSINESSTYPE, false,
				null);
		addPropertyDict("农、林、牧、渔业", 0, 1);
		addPropertyDict("采矿业", 0, 2);
		addPropertyDict("制造业", 0, 3);
		addPropertyDict("电力、燃气及水的生产和供应业", 0, 4);
		addPropertyDict("建筑业", 0, 5);
		addPropertyDict("交通运输、仓储和邮政业", 0, 6);
		addPropertyDict("信息传输、计算机服务和软件业", 0, 7);
		addPropertyDict("批发和零售业", 0, 8);
		addPropertyDict("住宿和餐饮业", 0, 9);
		addPropertyDict("金融业", 0, 10);
		addPropertyDict("房地产业", 0, 11);
		addPropertyDict("租赁和商务服务业", 0, 12);
		addPropertyDict("科学研究、技术服务和地质勘杳业", 0, 13);
		addPropertyDict("水利、环境和公共设施管理业", 0, 14);
		addPropertyDict("居民服务和其他服务业", 0, 15);
		addPropertyDict("教育", 0, 16);
		addPropertyDict("卫生、社会保障和社会福利业", 0, 17);
		addPropertyDict("文化、体育和娱乐业", 0, 18);
		addPropertyDict("公共管理和社会组织", 0, 19);
		addPropertyDict("国际组织", 0, 20);
	}

	private void initVolunteerOccupation() {
		propertyDomain = addPropertyDomain(PropertyTypes.VOLUNTEER_OCCUPATION,
				false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("待业", 0, 2);
		addPropertyDict("以农林牧副渔为主的农民", 0, 3);
		addPropertyDict("退休", 0, 4);
		addPropertyDict("医生", 0, 5);
		addPropertyDict("教师", 0, 6);
		addPropertyDict("个体工商户", 0, 7);
		addPropertyDict("海员", 0, 8);
		addPropertyDict("以工为主的农民", 0, 9);
		addPropertyDict("以商业服务业为主的农民", 0, 10);
		addPropertyDict("厂矿的工人", 0, 11);
		addPropertyDict("农林牧副渔场的工人", 0, 12);
		addPropertyDict("事业商业服务业人员", 0, 13);
		addPropertyDict("国家干部", 0, 14);
		addPropertyDict("学生", 0, 15);
		addPropertyDict("军人", 0, 16);
		addPropertyDict("其他劳动者", 0, 17);
	}

	public void initPartyTownPositions() {
		propertyDomain = addPropertyDomain(PropertyTypes.TOWN_LEADER, false,
				null);
		addPropertyDict("镇(街道)班子成员", 0, 1);
		addPropertyDict("镇(街道)中层干部", 1, 2);
		addPropertyDict("镇(街道)普通干部", 2, 3);
	}

	// 海宁职业类别 2013-04-15 HHY
	private void initHaiNingOccupationType() {
		propertyDomain = addPropertyDomain(PropertyTypes.OCCUPATIONTYPE, false,
				null);

		addPropertyDict("领导与管理人员", 0, 1);
		addPropertyDict("事业单位人员", 0, 2);
		addPropertyDict("公务员", 0, 3);
		addPropertyDict("服务业人员", 0, 4);
		addPropertyDict("农林牧渔人员", 0, 5);
		addPropertyDict("制造业人员", 0, 6);
		addPropertyDict("军人", 0, 7);
		addPropertyDict("简单体力劳动人员", 0, 8);
		addPropertyDict("其他从业人员", 0, 9);
	}

	private void initMostlyWork() {
		propertyDomain = addPropertyDomain(PropertyTypes.MOSTLY_WORK, false,
				null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("党委书记", 0, 2);
		addPropertyDict("支部副书记", 0, 3);
		addPropertyDict("党小组长", 0, 4);
		addPropertyDict("党委委员", 0, 5);
		addPropertyDict("纪委副书记", 0, 6);
		addPropertyDict("总支书记", 0, 7);
		addPropertyDict("总支委员", 0, 8);
		addPropertyDict("支部书记", 0, 9);
		addPropertyDict("支部委员", 0, 10);
		addPropertyDict("党委副书记", 0, 11);
		addPropertyDict("纪委书记", 0, 12);
		addPropertyDict("纪委委员", 0, 13);
		addPropertyDict("总支副书记", 0, 14);
		addPropertyDict("其他", 0, 15);
	}

	private void initDomicileCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.DOMICILECATEGORY,
				false, null);
		addPropertyDict("租赁房屋", 0, 1);
		addPropertyDict("单位内部", 0, 2);
		addPropertyDict("工地现场", 0, 3);
		addPropertyDict("居民家中", 0, 4);
		addPropertyDict("集中公寓", 0, 5);
		addPropertyDict("自购房", 0, 6);
		addPropertyDict("旅店", 0, 7);
		addPropertyDict("医院", 0, 8);
		addPropertyDict("学校", 0, 9);
		addPropertyDict("培训机构", 0, 10);
		addPropertyDict("救助站", 0, 11);
		addPropertyDict("水上船舶", 0, 12);
		addPropertyDict("其他", 0, 13);
	}

	private void initStructureHandle() {
		propertyDomain = addPropertyDomain(PropertyTypes.STRUCTURE_HANDLE,
				false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("开除党籍", 0, 2);
		addPropertyDict("严重警告", 0, 3);
		addPropertyDict("留党察看", 0, 4);
		addPropertyDict("取消预备", 0, 5);
		addPropertyDict("退党除名", 0, 6);
		addPropertyDict("警告", 0, 7);
		addPropertyDict("无不良记录", 0, 8);
		addPropertyDict("撤消党职", 0, 9);
		addPropertyDict("限期改正", 0, 10);
		addPropertyDict("脱党除名", 0, 11);
		addPropertyDict("劝退除名", 0, 12);
	}

	/**
	 * *************************************************************************
	 * ********************
	 */
	private void initTeamClass() {
		propertyDomain = addPropertyDomain(PropertyTypes.TEAMCLAZZ, false, null);
		addPropertyDict("综治组织", BasicOrgType.PERMARY_ORGANIZATION, 1);
		addPropertyDict("基层党组织", BasicOrgType.PERMARY_PARTY, 2);
		addPropertyDict("基层自治组织", BasicOrgType.AUTONOMY_ORG, 3);
		addPropertyDict("群防群治队伍", BasicOrgType.MASS_TREAT_TEAM, 4);
		addPropertyDict("社会志愿者队伍", BasicOrgType.VOLUNTARY_TEAM, 5);
		addPropertyDict("专项工作领导小组", BasicOrgType.LEADER_GROUP, 6);
		addPropertyDict("网格化管理服务团队", BasicOrgType.GRIDMANAGEMENT_TEAM, 7);
		addPropertyDict("其他", BasicOrgType.OTHER, 8);
		addPropertyDict("基层党委", BasicOrgType.BASICLEVEL_PARTY, 9);
		addPropertyDict("部门党委", BasicOrgType.DEPARTMENT_PARTY, 10);
		addPropertyDict("政府部门", BasicOrgType.GOVERNMENT_DEPARTMENT, 11);
		addPropertyDict("群团组织", BasicOrgType.MASS_ORGANIZATION, 12);

		/** 新增加 非公有制经济组织和社会组织 */
		addPropertyDict("社会组织", BasicOrgType.SOCIALORGANIZATION, 13);
		addPropertyDict("非公有制经济组织", BasicOrgType.NEWECONOMICORGANIZATIONS, 14);
	}

	private void initItemMatterKind() {
		propertyDomain = addPropertyDomain(PropertyTypes.ITEM_MATTER_KIND,
				false, null);
		addPropertyDict("行政审批类", 0, 1);
		addPropertyDict("行政审核类", 0, 2);
		addPropertyDict("行政许可类", 0, 3);
		addPropertyDict("登记备案类", 0, 4);
		addPropertyDict("非行政审批类", 0, 5);
	}

	private void initIdleYouthAgeGroup() {
		propertyDomain = addPropertyDomain(PropertyTypes.IDLE_YOUTH_AGE_GROUP,
				false, null);
		addPropertyDict("0~6岁", 0, 1);
		addPropertyDict("6~18岁", 0, 2);
		addPropertyDict("18~25岁", 0, 3);
		addPropertyDict("25~35岁", 0, 4);

	}

	// 实有房屋和出租房
	private void initHouseType() {
		propertyDomain = addPropertyDomain(PropertyTypes.HOUSE_TYPE, false,
				null);
		addPropertyDict("出租房", 0, 1);
		addPropertyDict("非出租房", 0, 2);

	}

	private void initLessorType() {
		propertyDomain = addPropertyDomain(PropertyTypes.LESSOR_TYPE, false,
				null);
		addPropertyDict("个人", 0, 1);
		addPropertyDict("单位", 0, 2);
	}

	private void initMangerTypes() {
		propertyDomain = addPropertyDomain(PropertyTypes.MANGER_TYPES, false,
				null);
		addPropertyDict("甲", 0, 1);
		addPropertyDict("乙", 0, 2);
		addPropertyDict("丙", 0, 3);
	}

	private void initLettingCertificateType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.LETTINGCERTIFICATE_TYPE, false, null);
		addPropertyDict("营业执照", LettingcertificateType.BUSINESS_LICENSE, 1);
		addPropertyDict("身份证", LettingcertificateType.IDENTITY_CARD, 2);
		addPropertyDict("其他", LettingcertificateType.OTHER, 3);
	}

	private void initPropertyTypes() {
		propertyDomain = addPropertyDomain(PropertyTypes.PROPERTY_TYPES, false,
				null);
		addPropertyDict("单位", 0, 1);
		addPropertyDict("个人", 0, 2);
	}

	private void initLandDocuments() {
		propertyDomain = addPropertyDomain(PropertyTypes.LAND_DOCUMENTS, false,
				null);
		addPropertyDict("国有土地使用权证", 0, 1);
		addPropertyDict("集体土地使用权证", 0, 2);
		addPropertyDict("宅基地证明", 0, 3);
	}

	private void initHousingVouchers() {
		propertyDomain = addPropertyDomain(PropertyTypes.HOUSING_VOUCHERS,
				false, null);
		addPropertyDict("房屋所有权证", 0, 1);
		addPropertyDict("房屋使用权证", 0, 2);
	}

	private void initHouseSource() {
		propertyDomain = addPropertyDomain(PropertyTypes.HOUSE_SOURCE, false,
				null);
		addPropertyDict("自有产权", CurrentHouseSource.OWN_PROPERTY, 1);
		addPropertyDict("租赁公房", CurrentHouseSource.RENTAL_BUILDINGS, 2);
	}

	private void initOwnProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.OWN_PROPERTY, false,
				null);
		addPropertyDict("购买商品房", 0, 1);
		addPropertyDict("购买房改房", 0, 2);
		addPropertyDict("购买经济适用房", 0, 3);
		addPropertyDict("个人自建房", 0, 4);
		addPropertyDict("其他形式取得", 0, 5);
	}

	private void initRentalBuildings() {
		propertyDomain = addPropertyDomain(PropertyTypes.RENTAL_BUILDINGS,
				false, null);
		addPropertyDict("单位自管公房", 0, 1);
		addPropertyDict("政府公管公房", 0, 2);
		addPropertyDict("个人私有", 0, 3);
	}

	private void initHouseUses() {
		propertyDomain = addPropertyDomain(PropertyTypes.HOUSE_USES, false,
				null);
		addPropertyDict("个人住宅", 0, 1);
		addPropertyDict("集体宿舍", 0, 2);
		addPropertyDict("临时工棚", 0, 3);
		addPropertyDict("办公用房", 0, 4);
		addPropertyDict("商业用房", 0, 5);
		addPropertyDict("科教文体医用房", 0, 6);
		addPropertyDict("工业用房", 0, 7);
		addPropertyDict("其他民用用房", 0, 8);
	}

	private void initBuildingUses() {
		propertyDomain = addPropertyDomain(PropertyTypes.BUILDING_USES, false,
				null);
		addPropertyDict("住宅", 0, 1);
		addPropertyDict("商业", 0, 2);
		addPropertyDict("办公", 0, 3);
		addPropertyDict("工业", 0, 4);
		addPropertyDict("综合", 0, 5);
		addPropertyDict("仓储", 0, 6);
		addPropertyDict("其他", 0, 7);
	}

	public void initPreparedStayTimeLimit() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.PREPARED_STAY_TIME_LIMIT, false, null);
		addPropertyDict("长期", 0, 1);
		addPropertyDict("短期", 0, 2);
		addPropertyDict("临时", 0, 3);
	}

	public void initStayTimeLimit() {
		propertyDomain = addPropertyDomain(PropertyTypes.STAY_TIME_LIMIT,
				false, null);
		addPropertyDict("一个月以下", 0, 1);
		addPropertyDict("一个月至一年", 0, 2);
		addPropertyDict("一年以上", 0, 3);
	}

	public void initEconomySource() {
		propertyDomain = addPropertyDomain(PropertyTypes.ECONOMY_SOURCE, false,
				null);
		addPropertyDict("有", 0, 1);
		addPropertyDict("无", 0, 2);
	}

	public void initStayLocationType() {
		propertyDomain = addPropertyDomain(PropertyTypes.STAY_LOCATION_TYPE,
				false, null);
		addPropertyDict("租赁房屋", 0, 1);
		addPropertyDict("自建房屋", 0, 2);
		addPropertyDict("购买房屋", 0, 3);
		addPropertyDict("单位内部", 0, 4);
		addPropertyDict("工地场所", 0, 5);
		addPropertyDict("居民家中", 0, 6);
		addPropertyDict("旅馆（包租）", 0, 7);
		addPropertyDict("个体摊点", 0, 8);
		addPropertyDict("家教场所", 0, 9);
		addPropertyDict("流动性单位", 0, 10);
		addPropertyDict("其他", 0, 11);
	}

	public void initTrainingState() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAINING_STATE, false,
				null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("党校培训", 0, 2);
		addPropertyDict("院校代培", 0, 3);
		addPropertyDict("挂职培训", 0, 4);
		addPropertyDict("业余党校", 0, 5);
		addPropertyDict("集中培训", 0, 6);
		addPropertyDict("其他培训", 0, 7);
	}

	public void initBecomesState() {
		propertyDomain = addPropertyDomain(PropertyTypes.BECOMES_STATE, false,
				null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("按期转正", 0, 2);
		addPropertyDict("延长预备期", 0, 3);
		addPropertyDict("取消预备期", 0, 4);
		addPropertyDict("其他", 0, 5);
	}

	public void initPartyMemberType() {
		propertyDomain = addPropertyDomain(PropertyTypes.PARTYMEMBER_TYPE,
				false, null);
		addPropertyDict("失业党员", 0, 1);
		addPropertyDict("下岗党员", 0, 2);
		addPropertyDict("困难党员", 0, 3);
		addPropertyDict("大学生党员", 0, 4);
		addPropertyDict("社区工作者党员", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	public void initOutReasons() {
		propertyDomain = addPropertyDomain(PropertyTypes.OUT_REASON, false,
				null);
		addPropertyDict("求学入托", 0, 1);
		addPropertyDict("探亲靠友", 0, 2);
		addPropertyDict("务工经商", 0, 3);
		addPropertyDict("房屋拆迁", 0, 4);
		addPropertyDict("他处另有住房", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	private void initDisabilityTypes() {
		propertyDomain = addPropertyDomain(PropertyTypes.DISABILITY_TYPE,
				false, null);
		addPropertyDict("视力残疾", 0, 1);
		addPropertyDict("智力残疾", 0, 2);
		addPropertyDict("肢体残疾", 0, 3);
		addPropertyDict("精神残疾", 0, 4);
		addPropertyDict("听力残疾", 0, 5);
		addPropertyDict("言语残疾", 0, 6);
		addPropertyDict("多重残疾", 0, 7);

	}

	public void initAbroadDependentsTypeProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.ABROADDEPENDENTS_TYPE,
				false, null);
		addPropertyDict("归侨", 0, 1);
		addPropertyDict("侨眷", 0, 2);
		addPropertyDict("台胞", 0, 3);
		addPropertyDict("台属", 0, 4);
		addPropertyDict("港属", 0, 5);
		addPropertyDict("澳属", 0, 6);
		addPropertyDict("留学生家属", 0, 7);
		addPropertyDict("其他", 0, 8);
	}

	private void initInsuranceCase() {
		propertyDomain = addPropertyDomain(PropertyTypes.INSURANCECASE, false,
				Insurance.getInternalProperties());
		addPropertyDict("养老保险", Insurance.PENSION, 1);
		addPropertyDict("医疗保险", Insurance.MEDICAL, 2);
		addPropertyDict("失业保险", Insurance.UNEMPLOYMENT, 3);
		addPropertyDict("工伤保险", Insurance.BUSINESS, 4);
		addPropertyDict("生育保险", Insurance.FERTILITY, 5);
	}

	private void initLaborContract() {
		propertyDomain = addPropertyDomain(PropertyTypes.LABORCONTRACT, false,
				null);
		addPropertyDict("未签", 0, 1);
		addPropertyDict("一年以下", 0, 2);
		addPropertyDict("一年以上", 0, 3);
	}

	private void initRegistrationType() {
		propertyDomain = addPropertyDomain(PropertyTypes.REGISTRATIONTYPE,
				false, null);
		addPropertyDict("登记类", 0, 1);
		addPropertyDict("临时居住证", 0, 2);
		addPropertyDict("居住证", 0, 3);
	}

	private void initProfessionalQualifications() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.PROFESSIONALQUALIFICATIONS, false, null);
		addPropertyDict("高级", 0, 1);
		addPropertyDict("中级", 0, 2);
		addPropertyDict("初级", 0, 3);
		addPropertyDict("高级技师", 0, 4);
		addPropertyDict("技师", 0, 5);
		addPropertyDict("高级工", 0, 6);
		addPropertyDict("中级工", 0, 7);
		addPropertyDict("初级工", 0, 8);
		addPropertyDict("无等级", 0, 9);
	}

	private void initPregnancyAndContraceptionCase() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.PREGNANCYANDCONTRACEPTIONCASE, false, null);
		addPropertyDict("已孕", 0, 1);
		addPropertyDict("待孕", 0, 2);
		addPropertyDict("结扎", 0, 3);
		addPropertyDict("放环", 0, 4);
		addPropertyDict("药", 0, 5);
		addPropertyDict("套", 0, 6);
		addPropertyDict("其他措施", 0, 7);
		addPropertyDict("无措施", 0, 8);
	}

	private void initPostulantDutyType() {
		propertyDomain = addPropertyDomain(PropertyTypes.POSTULANTDUTY_TYPE,
				false, null);
		addPropertyDict("治安巡防队伍", 0, 1);
		addPropertyDict("矛盾化解队伍", 0, 2);
		addPropertyDict("帮教服务队伍", 0, 3);
		addPropertyDict("法律援助队伍", 0, 4);
		addPropertyDict("消防安全队伍", 0, 5);
		addPropertyDict("交通道路安全队伍", 0, 6);
		addPropertyDict("养老服务队伍", 0, 7);
		addPropertyDict("助残服务队伍", 0, 8);
		addPropertyDict("助教服务队伍", 0, 9);
		addPropertyDict("扶贫济困队伍", 0, 10);
		addPropertyDict("文体类服务队伍", 0, 11);
		addPropertyDict("其他", 0, 12);
	}

	private void initMassyDutyType() {
		propertyDomain = addPropertyDomain(PropertyTypes.MASSEDUTY_TYPE, false,
				null);
		addPropertyDict("专职治安巡逻队", 0, 1);
		addPropertyDict("义务治安巡逻队", 0, 2);
		addPropertyDict("守楼护院人员", 0, 3);
		addPropertyDict("保安人员", 0, 4);
		addPropertyDict("平安志愿者", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	private void initSecurityType() {
		propertyDomain = addPropertyDomain(PropertyTypes.SECURITY_TYPE, false,
				null);
		addPropertyDict("城乡结合部", 0, 1);
		addPropertyDict("城中村", 0, 2);
		addPropertyDict("流动人口聚集地", 0, 3);
		addPropertyDict("宾馆与旅馆", 0, 4);
		addPropertyDict("出租房屋区", 0, 5);
		addPropertyDict("娱乐场所", 0, 6);
		addPropertyDict("批发市场", 0, 7);
		addPropertyDict("矿山市场", 0, 8);
		addPropertyDict("车站码头", 0, 9);
		addPropertyDict("其他", 0, 10);
	}

	private void initTerminalCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.TERMINAL_CATEGORY,
				false, null);
	}

	private void initFireSafetyType() {
		propertyDomain = addPropertyDomain(PropertyTypes.FIRESAFETY_TYPE,
				false, null);
		addPropertyDict("商场", 0, 1);
		addPropertyDict("市场", 0, 2);
		addPropertyDict("娱乐场所", 0, 3);
		addPropertyDict("重点单位", 0, 4);
		addPropertyDict("其他", 0, 5);
	}

	private void initDetailedRuleType() {
		propertyDomain = addPropertyDomain(PropertyTypes.DETAILED_RULE_TYPE,
				true, DetailedRuleType.getInternalProperties());
		addPropertyDict("其他类型", DetailedRuleType.OTHER_TYPE, 1);
		// addPropertyDict("台帐类型", DetailedRuleType.DAILY_LOG, 2);
	}

	private void initEvaluateType() {
		propertyDomain = addPropertyDomain(PropertyTypes.EVALUATE_TYPE, true,
				EvaluateType.getInternalProperties());
		addPropertyDict("考核标准", EvaluateType.STANDARD_EVALUATE, 1);
		addPropertyDict("考核结果", EvaluateType.NORMAL_EVALUATE, 2);
	}

	private void initNewSocietyTypeProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.NEW_SOCIETY_TYPE,
				false, null);

		addPropertyDict("学术性团体", NewSocietyType.SOCIETY_GROUP, 1);
		addPropertyDict("行业性团体", NewSocietyType.SOCIETY_GROUP, 2);
		addPropertyDict("专业性团体", NewSocietyType.SOCIETY_GROUP, 3);
		addPropertyDict("联合性团体", NewSocietyType.SOCIETY_GROUP, 4);
		addPropertyDict("行业协会", NewSocietyType.SOCIETY_GROUP, 5);
		addPropertyDict("非盈利机构", NewSocietyType.SOCIETY_GROUP, 6);
		addPropertyDict("教育事业", NewSocietyType.NON_ENTERPRISE, 7);
		addPropertyDict("卫生事业", NewSocietyType.NON_ENTERPRISE, 8);
		addPropertyDict("文化事业", NewSocietyType.NON_ENTERPRISE, 9);
		addPropertyDict("科学研究事业", NewSocietyType.NON_ENTERPRISE, 10);
		addPropertyDict("体育事业", NewSocietyType.NON_ENTERPRISE, 11);
		addPropertyDict("劳动和保障事业", NewSocietyType.NON_ENTERPRISE, 12);
		addPropertyDict("民政事业", NewSocietyType.NON_ENTERPRISE, 13);
		addPropertyDict("商务咨询类", NewSocietyType.AGENT_ORGANIZATION, 14);
		addPropertyDict("社会公益类", NewSocietyType.AGENT_ORGANIZATION, 15);
		addPropertyDict("鉴证监督类", NewSocietyType.AGENT_ORGANIZATION, 16);
		addPropertyDict("准司法类", NewSocietyType.AGENT_ORGANIZATION, 17);
		addPropertyDict("准行政类", NewSocietyType.AGENT_ORGANIZATION, 18);
	}

	private void initSocietyGroup() {
		propertyDomain = addPropertyDomain(PropertyTypes.SOCIETY_GROUP, false,
				null);
		addPropertyDict("慈善类", NewSocietyType.SOCIETY_GROUP, 1);
		addPropertyDict("科技类", NewSocietyType.FOUNDATION_GROUP, 2);
		addPropertyDict("社区公益类", NewSocietyType.NON_ENTERPRISE, 3);
		addPropertyDict("文体类", NewSocietyType.AGENT_ORGANIZATION, 4);
		addPropertyDict("法律服务", NewSocietyType.ACTIVITY_TEAM, 5);
		addPropertyDict("民生服务类", NewSocietyType.OTHER, 6);

	}

	private void initSuperiorVisitpStatusProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.SUPERIOR_VISIT_STATUS,
				false, null);
		addPropertyDict("问题已解决", 0, 1);
		addPropertyDict("问题未解决", 0, 2);
	}

	private void initPositiveInfo() {
		propertyDomain = addPropertyDomain(PropertyTypes.POSITIVEINFO, false,
				null);
		addPropertyDict("刑释人员", 0, 1);
		addPropertyDict("解教人员", 0, 2);
	}

	private void initEexceptionSuperiorVisitpProperty() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.EXCEPTION_SUPERIOR_VISIT, false, null);
		addPropertyDict("进京访", 0, 1);
		addPropertyDict("进省访", 0, 2);
		addPropertyDict("进市访", 0, 3);
		addPropertyDict("进县访", 0, 4);
		addPropertyDict("集体访", 0, 5);
		addPropertyDict("个人访", 0, 6);
		addPropertyDict("越级访", 0, 7);
		addPropertyDict("重复访", 0, 8);
	}

	private void initNormalSuperiorVisitProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.NORMAL_SUPERIOR_VISIT,
				false, null);
		addPropertyDict("重复访", 0, 1);
		addPropertyDict("集体访", 0, 2);
	}

	private void initSuperiorVisitTypeProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.SUPERIOR_VISIT_TYPE,
				false, null);
		addPropertyDict("正常上访", 0, 1);
		addPropertyDict("异常上访", 0, 2);
	}

	private void initDangerousWorkingTypeProperty() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.DANGEROUS_WORKING_TYPE, false, null);
		addPropertyDict("民爆", 0, 1);
		addPropertyDict("化工", 0, 2);
		addPropertyDict("其他", 0, 3);
	}

	private void initDangerousLevelProperty() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.MENTALPATIENT_DANGEROUS_LEVEL, false, null);
		addPropertyDict("高", 0, 1);
		addPropertyDict("中", 0, 2);
		addPropertyDict("低", 0, 3);
	}

	private void initToBearStatusProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.TO_BEAR_STATUS, false,
				null);
		addPropertyDict("未生育", 0, 1);
		addPropertyDict("一胎", 0, 2);
		addPropertyDict("两胎", 0, 3);
		addPropertyDict("三胎", 0, 4);
		addPropertyDict("其他", 0, 5);
	}

	private void initComplexPlaceBusinessProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.COMPLEX_PLACE_TYPE,
				false, null);
		addPropertyDict("公共娱乐场所", 0, 1);
		addPropertyDict("市场", 0, 2);
		addPropertyDict("车站码头", 0, 3);
		addPropertyDict("其他", 0, 4);
	}

	private void initMarketKindProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.MARKET_KIND, false,
				null);
		addPropertyDict("商场", 0, 1);
		addPropertyDict("超市", 0, 2);
		addPropertyDict("菜市场", 0, 3);
		addPropertyDict("其他", 0, 4);
	}

	private void initCommonEntertainmentKindProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.ENTERTAINMENT_KIND,
				false, null);
		addPropertyDict("KTV", 0, 1);
		addPropertyDict("舞厅", 0, 2);
		addPropertyDict("迪吧", 0, 3);
		addPropertyDict("酒吧", 0, 4);
		addPropertyDict("网吧", 0, 5);
		addPropertyDict("球馆", 0, 6);
		addPropertyDict("电玩", 0, 7);
		addPropertyDict("棋牌室", 0, 8);
		addPropertyDict("其他", 0, 9);
	}

	private void initOTherComplexPlaceKindProperty() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.OTHER_COMPLEX_PLACE_TYPE_KIND, false, null);
		addPropertyDict("按摩", 0, 1);
		addPropertyDict("理发", 0, 2);
		addPropertyDict("桑拿", 0, 3);
		addPropertyDict("其他", 0, 4);
	}

	private void initSchoolProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCHOOL_PROPERTY,
				false, null);
		addPropertyDict("公办", 0, 1);
		addPropertyDict("民办", 0, 2);
		addPropertyDict("其他", 0, 3);
	}

	private void initSchoolType() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCHOOL_TYPE, false,
				null);
		addPropertyDict("小学", 0, 1);
		addPropertyDict("幼儿园", 0, 2);
		addPropertyDict("托管机构", 0, 3);
		addPropertyDict("中学", 0, 4);
		addPropertyDict("大专院校", 0, 5);
		addPropertyDict("职业学校", 0, 6);
		addPropertyDict("其它", 0, 7);
	}

	private void initDrugReason() {
		propertyDomain = addPropertyDomain(PropertyTypes.DRUG_REASON, false,
				null);
		addPropertyDict("受亲友吸毒影响", 0, 1);
		addPropertyDict("被人诱骗", 0, 2);
		addPropertyDict("被人逼迫", 0, 3);
		addPropertyDict("好奇", 0, 4);
		addPropertyDict("为治病", 0, 5);
		addPropertyDict("人生受挫", 0, 6);
		addPropertyDict("寻求刺激", 0, 7);
		addPropertyDict("其他", 0, 8);
	}

	private void initDrugSource() {
		propertyDomain = addPropertyDomain(PropertyTypes.DRUG_SOURCE, false,
				null);
		addPropertyDict("黑市购买", 0, 1);
		addPropertyDict("亲朋提供", 0, 2);
		addPropertyDict("偷窃", 0, 3);
		addPropertyDict("医生处方", 0, 4);
		addPropertyDict("其他", 0, 5);
	}

	private void initDetoxicateCase() {
		propertyDomain = addPropertyDomain(PropertyTypes.DETOXICATE_CASE,
				false, null);
		addPropertyDict("强制戒毒", 0, 1);
		addPropertyDict("劳教戒毒", 0, 2);
		addPropertyDict("限期戒毒", 0, 3);
		addPropertyDict("自愿戒毒", 0, 4);
		addPropertyDict("社区戒毒", 0, 5);
		addPropertyDict("其他", 0, 6);
		addPropertyDict("社区康复", 0, 7);

	}

	private void initDetoxicateCondition() {
		propertyDomain = addPropertyDomain(PropertyTypes.DETOXICATE_CONDITION,
				false, null);
		addPropertyDict("在吸", 0, 1);
		addPropertyDict("停吸", 0, 2);
	}

	private void initExecuteType() {
		propertyDomain = addPropertyDomain(PropertyTypes.EXECUTE_TYPE, false,
				null);
		addPropertyDict("监外执行罪犯", 0, 1);
		addPropertyDict("管制人员", 0, 2);
		addPropertyDict("缓刑人员", 0, 3);
		addPropertyDict("假释人员", 0, 4);
		addPropertyDict("剥夺政治权利人员", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	private void initOrganizationType() {
		propertyDomain = addPropertyDomain(PropertyTypes.ORGANIZATION_TYPE,
				true, OrganizationType.getInternalProperties());
		addPropertyDict("行政区域", OrganizationType.ADMINISTRATIVE_REGION, 1);
		addPropertyDict("职能部门", OrganizationType.FUNCTIONAL_ORG, 2);
		addPropertyDict("其他", OrganizationType.OTHER, 3);
		// addPropertyDict("党工委", OrganizationType.PARTYWORK, 4);
	}

	private void initOrganizationLevel() {
		propertyDomain = addPropertyDomain(PropertyTypes.ORGANIZATION_LEVEL,
				true, OrganizationLevel.getInternalProperties());
		addPropertyDict("片组片格", OrganizationLevel.GRID, 1);
		addPropertyDict("村（社区）", OrganizationLevel.VILLAGE, 2);
		addPropertyDict(OrganizationLevel.TOWN_KEY, OrganizationLevel.TOWN, 3);
		addPropertyDict(OrganizationLevel.DISTRICT_KEY,
				OrganizationLevel.DISTRICT, 4);
		addPropertyDict(OrganizationLevel.CITY_KEY, OrganizationLevel.CITY, 5);
		addPropertyDict("省", OrganizationLevel.PROVINCE, 6);
		addPropertyDict("全国", OrganizationLevel.COUNTRY, 7);
	}

	private void initSchoolingProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCHOOLING, false, null);
		addPropertyDict("博士", 0, 1);
		addPropertyDict("研究生", 0, 2);
		addPropertyDict("大学本科", 0, 3);
		addPropertyDict("大专", 0, 4);
		addPropertyDict("高中\\中专", 0, 5);
		addPropertyDict("初中", 0, 6);
		addPropertyDict("小学", 0, 7);
		addPropertyDict("文盲", 0, 8);
		addPropertyDict("学龄前", 0, 9);
	}

	private void initMilitaryServiceProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.MILITARY_SERVICE,
				false, null);
		addPropertyDict("未服役", 0, 1);
		addPropertyDict("现服役", 0, 2);
		addPropertyDict("退出现役", 0, 3);
		addPropertyDict("士兵预备役", 0, 4);
		addPropertyDict("军官预备役", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	private void initResidenceTypeProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.RESIDENCE_TYPE, false,
				null);
		addPropertyDict("未落实常住户口", 0, 1);
		addPropertyDict("非农家庭户口", 0, 2);
		addPropertyDict("农业家庭户口", 0, 3);
		addPropertyDict("非农集体户口", 0, 4);
		addPropertyDict("农业集体户口", 0, 5);
		addPropertyDict("自理口粮户", 0, 6);
		addPropertyDict("寄住户口", 0, 7);
		addPropertyDict("暂住户口", 0, 8);
		addPropertyDict("渔业户口", 0, 9);
		addPropertyDict("其他户口", 0, 10);
	}

	private void initRelationShipWithHeadProperty() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.RELATION_SHIP_WITH_HEAD, false, null);

		addPropertyDict("户主", RelationShipWithHead.HEADER, 1);
		addPropertyDict("小集体户主", RelationShipWithHead.HEADER, 2);

		List displayNames = new ArrayList();
		displayNames.add("配偶");
		displayNames.add("子女");
		displayNames.add("孙子（女）");
		displayNames.add("外孙（女）");
		displayNames.add("父母");
		displayNames.add("配偶父母");
		displayNames.add("祖父母");
		displayNames.add("外祖父母");
		displayNames.add("曾孙子（女）");
		displayNames.add("曾外孙（女）");
		displayNames.add("曾祖父母");
		displayNames.add("外曾父母");
		displayNames.add("儿媳");
		displayNames.add("女婿");

		/** 迭代1.9.1新添加该字典项 wangchao */
		displayNames.add("兄弟姐妹");

		addDetailPropertyDict(displayNames,
				RelationShipWithHead.RELATION_SHIP_WITH_HEAD, 3);

		addPropertyDict("其他", RelationShipWithHead.OTHER, 4);
	}

	private void initRelationShipWithMasterProperty() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.RELATION_SHIP_WITH_MASTER, false, null);
		addPropertyDict("家长", RelationShipWithHead.HEADER, 1);
		List displayNames = new ArrayList();
		displayNames.add("直系亲属");
		displayNames.add("非直系亲属");
		displayNames.add("朋友");
		displayNames.add("同事");
		displayNames.add("未知");
		addDetailPropertyDict(displayNames,
				RelationShipWithHead.RELATION_SHIP_WITH_HEAD, 2);
		addPropertyDict("其他", RelationShipWithHead.OTHER, 3);
	}

	private void initPoliticalBackgroundProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.POLITICAL_BACKGROUND,
				false, null);
		addPropertyDict("中国共产党党员", 0, 1);
		addPropertyDict("九三学社社员", 0, 2);
		addPropertyDict("台湾民主自治同盟盟员", 0, 3);
		addPropertyDict("无党派民主人士", 0, 4);
		addPropertyDict("群众", 0, 5);
		addPropertyDict("中国共产党预备党员", 0, 6);
		addPropertyDict("中国共产主义青年团团员", 0, 7);
		addPropertyDict("中国国民党革命委员会会员", 0, 8);
		addPropertyDict("中国民主同盟盟员", 0, 9);
		addPropertyDict("中国民主建国会会员", 0, 10);
		addPropertyDict("中国民主促进会会员", 0, 11);
		addPropertyDict("中国农工民主党党员", 0, 12);
		addPropertyDict("中国致公党党员", 0, 13);
		addPropertyDict("中国少年先锋队", 0, 14);
		addPropertyDict("其他", 0, 15);
	}

	private void initMaritalStatusProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.MARITAL_STATUS, true,
				MaritalState.getInternalProperties());
		addPropertyDict("未婚", MaritalState.NEVERMARRIED, 1);
		addPropertyDict("已婚", MaritalState.ALREADYMARRIED, 2);
		addPropertyDict("离婚", MaritalState.ALREADYMARRIED, 3);
		addPropertyDict("丧偶", MaritalState.ALREADYMARRIED, 4);
		addPropertyDict("其他", MaritalState.UNKNOWN, 5);
	}

	private void initAidReasonProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.AIDRREASON, false,
				null);
		addPropertyDict("无劳力（孤幼）", AidReasonType.Single_Child_NoLabor, 1);
		addPropertyDict("医疗支出过大", AidReasonType.Medical_Spending_Much, 2);
		addPropertyDict("突发性事件", AidReasonType.EMERGENCY_INCIDENT, 3);
		addPropertyDict("无劳力（孤老）", AidReasonType.Single_Elder_NoLabor, 4);
		addPropertyDict("无劳力（因残）", AidReasonType.Handicapped_NoLabor, 5);
		addPropertyDict("无劳力（因病）", AidReasonType.Ill_NoLabor, 6);
		addPropertyDict("劳力不全（因残）", AidReasonType.Handicapped_LessLabor, 7);
		addPropertyDict("劳力不全（因病）", AidReasonType.Ill_LessLabor, 8);
		addPropertyDict("未充分就业", AidReasonType.Not_Full_Employment, 9);
		addPropertyDict("未就业", AidReasonType.Unemployment, 10);
		addPropertyDict("教育支出过大", AidReasonType.Education_Spending_Much, 11);
		addPropertyDict("其它", AidReasonType.OTHER, 12);
	}

	private void initHealthStateProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.HEALTH_STATE, false,
				null);
		addPropertyDict("健康", 0, 1);
		addPropertyDict("体质较弱", 0, 2);
		addPropertyDict("高血压", 0, 3);
		addPropertyDict("视力残", 0, 4);
		addPropertyDict("听力残", 0, 5);
		addPropertyDict("精神残", 0, 6);
		addPropertyDict("智力残", 0, 7);
		addPropertyDict("上肢残", 0, 8);
		addPropertyDict("语言残", 0, 9);
		addPropertyDict("下肢残", 0, 10);
		addPropertyDict("肠胃病", 0, 11);
		addPropertyDict("糖尿病", 0, 12);
		addPropertyDict("脑卒中", 0, 13);
		addPropertyDict("冠心病", 0, 14);
		addPropertyDict("肿瘤", 0, 15);
		addPropertyDict("侏儒", 0, 16);
		addPropertyDict("其他重大疾病", 0, 17);
		addPropertyDict("已故", 0, 18);
		addPropertyDict("其他", 0, 19);
	}

	private void initResidentStatusProperty() {
		propertyDomain = addPropertyDomain(ResidentStatus.KEY, true,
				ResidentStatus.getInternalProperties());
		addPropertyDict("人户同在", ResidentStatus.HAS_RESIDENT_HAS_FAMILY, 1);
		addPropertyDict("户在人不在", ResidentStatus.NO_RESIDENT_HAS_FAMILY, 2);
		addPropertyDict("人在户不在", ResidentStatus.RESIDENT_NO_FAMILY, 3);
	}

	private void initDifficultTypeProperty() {
		propertyDomain = addPropertyDomain(DifficultType.DIFFICULT_KEY, true,
				DifficultType.getInternalProperties());
		addPropertyDict("因教致贫", DifficultType.POVERTYFORTEACH, 0);
		addPropertyDict("突发困难", DifficultType.SUDDENDIFFICULTY, 1);
		addPropertyDict("三无对象", DifficultType.OBJECTOFTHREENOES, 2);
		addPropertyDict("五保对象", DifficultType.FIVEGURANTEESSUPPORTINGOBJECT, 3);
		addPropertyDict("低保户", DifficultType.LOWHOUSEHOLD, 4);
		addPropertyDict("精减职工", DifficultType.STRESSANDSCRARE, 5);
		addPropertyDict("重点优抚", DifficultType.STRESSANDSCRARE, 6);
		addPropertyDict("特困职工", DifficultType.POORWORKER, 7);
		addPropertyDict("特困残疾", DifficultType.POORDISABLED, 8);
		addPropertyDict("低保边缘", DifficultType.EDGELOW, 9);
		addPropertyDict("因病致贫", DifficultType.POVERTYBYILLNESS, 10);
		addPropertyDict("其他困难", DifficultType.OTHERDIFFICULTY, 11);
		addPropertyDict("未知", DifficultType.UNKNOWN, 12);

	}

	private void initCertificateHoldTypeProperty() {
		propertyDomain = addPropertyDomain(
				CertificateType.CERTIFICATEHOLDTYPE_KEY, true, CertificateType
						.getInternalProperties());
		addPropertyDict("户口迁移证", CertificateType.HOUSEHOLDMIGRATION_CARD, 0);
		addPropertyDict("刑释解教证", CertificateType.POSITIVE_CARD, 1);
		addPropertyDict("复转证", CertificateType.RECOVERY_CARD, 2);
		addPropertyDict("出生证", CertificateType.BIRTH_CARD, 3);
		addPropertyDict("其他", CertificateType.UNKNOWN, 4);
	}

	private void initUnSettedReasonProperty() {
		propertyDomain = addPropertyDomain(UnSettedReason.UNSETTEDREASON_KEY,
				true, UnSettedReason.getInternalProperties());
		addPropertyDict("持证未落", UnSettedReason.CERTIFICATE_NO, 0);
		addPropertyDict("证件遗失", UnSettedReason.CERTIFICATE_LOST, 1);
		addPropertyDict("出生未落", UnSettedReason.BIRTH_NO, 2);
		addPropertyDict("外流注销", UnSettedReason.OUTFLOW_CANCELLE, 3);
		addPropertyDict("其他", UnSettedReason.UNKNOWN, 4);
	}

	private void initDustbinTypeProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.DUSTBINTYPE, false,
				null);
		addPropertyDict("公共厕所", 0, 1);
		addPropertyDict("化粪池", 0, 2);
		addPropertyDict("公厕指示牌", 0, 3);
		addPropertyDict("垃圾间（楼）", 0, 4);
		addPropertyDict("垃圾箱", 0, 5);
		addPropertyDict("灯箱霓虹灯", 0, 6);
		addPropertyDict("广告牌匾", 0, 7);
		addPropertyDict("环保监侧站", 0, 8);
		addPropertyDict("气象监测站", 0, 9);
		addPropertyDict("污水口监测站", 0, 10);
		addPropertyDict("噪声显示屏", 0, 11);

	}

	private void initGrowingProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.GROWING, false, null);
		addPropertyDict("茂盛", 0, 1);
		addPropertyDict("良好", 0, 2);
		addPropertyDict("一般", 0, 3);
		addPropertyDict("差", 0, 4);
	}

	private void initSecretDegree() {
		propertyDomain = addPropertyDomain(PropertyTypes.SECRETDEGREE, false,
				null);
		addPropertyDict("普通", 0, 1);
		addPropertyDict("绝密", 0, 2);
		addPropertyDict("机密", 0, 3);
		addPropertyDict("秘密", 0, 4);
		addPropertyDict("密码", 0, 5);
	}

	private void initUrgentDegree() {
		propertyDomain = addPropertyDomain(PropertyTypes.URGENTDEGREE, false,
				null);
		addPropertyDict("常规公文", 0, 1);
		addPropertyDict("紧急公文", 0, 2);
		addPropertyDict("特急公文", 0, 3);

	}

	private void initStateProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.STATE, false, null);
		addPropertyDict("完全", 0, 1);
		addPropertyDict("破损", 0, 2);
		addPropertyDict("丢失", 0, 3);
		addPropertyDict("占用", 0, 4);
	}

	private void inttObjTypeProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.OBJTYPE, false, null);
		addPropertyDict("监控电子眼", 0, 1);
		addPropertyDict("过街天桥", 0, 2);
		addPropertyDict("交通护栏", 0, 3);
		addPropertyDict("户外广告", 0, 4);
		addPropertyDict("立杆", 0, 5);
		addPropertyDict("上水井盖", 0, 6);
		addPropertyDict("污水井盖", 0, 7);
		addPropertyDict("雨水井盖", 0, 8);
		addPropertyDict("电力井盖", 0, 9);
		addPropertyDict("路灯井盖", 0, 10);
		addPropertyDict("通讯井盖", 0, 11);
		addPropertyDict("电视井盖", 0, 12);
		addPropertyDict("网络井盖", 0, 13);
		addPropertyDict("热力井盖", 0, 14);
		addPropertyDict("燃气井盖", 0, 15);
		addPropertyDict("公安井盖", 0, 16);
		addPropertyDict("无主井盖", 0, 17);
		addPropertyDict("中水井盖", 0, 18);
		addPropertyDict("公交井盖", 0, 19);
		addPropertyDict("输油（气）井盖", 0, 20);
		addPropertyDict("特殊井盖", 0, 21);
		addPropertyDict("园林井盖", 0, 22);
		addPropertyDict("化粪池井盖", 0, 23);
	}

	private void initIsFarmingProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.ISFARMING, false, null);
		addPropertyDict("农业", 0, 1);
		addPropertyDict("非农业", 0, 2);

	}

	private void initGenderProperty() {
		propertyDomain = addPropertyDomain(Gender.GENDER_KEY, true, Gender
				.getInternalProperties());
		addPropertyDict("男", Gender.MALE, 1);
		addPropertyDict("女", Gender.FEMALE, 2);
		addPropertyDict("不明", Gender.UNKNOWN, 3);
	}

	private void initGenderForBaseOrg() {
		propertyDomain = addPropertyDomain(PropertyTypes.GENDERFORBASEORG,
				false, null);
		addPropertyDict("男", Gender.MALE, 1);
		addPropertyDict("女", Gender.FEMALE, 2);
	}

	private void initBloodTypeProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.BLOOD_TYPE, false,
				null);
		addPropertyDict("A型", 0, 1);
		addPropertyDict("B型", 0, 2);
		addPropertyDict("O型", 0, 3);
		addPropertyDict("AB型", 0, 4);
		addPropertyDict("O型rh阴性", 0, 5);
		addPropertyDict("A型rh阴性", 0, 6);
		addPropertyDict("B型rh阴性", 0, 7);
		addPropertyDict("AB型rh阴性", 0, 8);
		addPropertyDict("其他", 0, 9);
	}

	private void initPrimaryOrganization() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.PERMARY_ORGANIZATION_TYPE, false, null);
		addPropertyDict("综治委", 0, 1);
		addPropertyDict("综治办", 0, 2);
		// addPropertyDict("社会服务管理室", 0, 3);
		// addPropertyDict("社会服务管理中心", 0, 4);
	}

	private void initFaithProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.FAITH, false, null);
		addPropertyDict("无", 0, 1);
		addPropertyDict("佛教", 0, 2);
		addPropertyDict("道教", 0, 3);
		addPropertyDict("基督教", 0, 4);
		addPropertyDict("天主教", 0, 5);
		addPropertyDict("伊斯兰教", 0, 6);
		addPropertyDict("其他", 0, 7);
	}

	private void initNation() {
		propertyDomain = addPropertyDomain(PropertyTypes.NATION, false, null);
		addPropertyDict("汉族", 0, 1);
		addPropertyDict("蒙古族", 0, 2);
		addPropertyDict("满族", 0, 3);
		addPropertyDict("朝鲜族", 0, 4);
		addPropertyDict("赫哲族", 0, 5);
		addPropertyDict("达斡尔族", 0, 6);
		addPropertyDict("鄂温克族", 0, 7);
		addPropertyDict("鄂伦春族", 0, 8);
		addPropertyDict("回族", 0, 9);
		addPropertyDict("东乡族", 0, 10);
		addPropertyDict("土族", 0, 11);
		addPropertyDict("撒拉族", 0, 12);
		addPropertyDict("保安族", 0, 13);
		addPropertyDict("裕固族", 0, 14);
		addPropertyDict("维吾尔族", 0, 15);
		addPropertyDict("哈萨克族", 0, 16);
		addPropertyDict("柯尔克孜族", 0, 17);
		addPropertyDict("锡伯族", 0, 18);
		addPropertyDict("塔吉克族", 0, 19);
		addPropertyDict("乌孜别克族", 0, 20);
		addPropertyDict("俄罗斯族", 0, 21);
		addPropertyDict("塔塔尔族", 0, 22);
		addPropertyDict("藏族", 0, 23);
		addPropertyDict("门巴族", 0, 24);
		addPropertyDict("珞巴族", 0, 25);
		addPropertyDict("羌族", 0, 26);
		addPropertyDict("彝族", 0, 27);
		addPropertyDict("白族", 0, 28);
		addPropertyDict("哈尼族", 0, 29);
		addPropertyDict("傣族", 0, 30);
		addPropertyDict("傈僳族", 0, 31);
		addPropertyDict("佤族", 0, 32);
		addPropertyDict("拉祜族", 0, 33);
		addPropertyDict("纳西族", 0, 34);
		addPropertyDict("景颇族", 0, 35);
		addPropertyDict("布朗族", 0, 36);
		addPropertyDict("阿昌族", 0, 37);
		addPropertyDict("普米族", 0, 38);
		addPropertyDict("怒族", 0, 39);
		addPropertyDict("德昂族", 0, 40);
		addPropertyDict("独龙族", 0, 41);
		addPropertyDict("基诺族", 0, 42);
		addPropertyDict("苗族", 0, 43);
		addPropertyDict("布依族", 0, 44);
		addPropertyDict("侗族", 0, 45);
		addPropertyDict("水族", 0, 46);
		addPropertyDict("仡佬族", 0, 47);
		addPropertyDict("壮族", 0, 48);
		addPropertyDict("瑶族", 0, 49);
		addPropertyDict("仫佬族", 0, 50);
		addPropertyDict("毛南族", 0, 51);
		addPropertyDict("京族", 0, 52);
		addPropertyDict("土家族", 0, 53);
		addPropertyDict("黎族", 0, 54);
		addPropertyDict("畲族", 0, 55);
		addPropertyDict("高山族", 0, 56);
		addPropertyDict("混血儿族", 0, 56);
		addPropertyDict("中外血统", 0, 57);
		addPropertyDict("其他", 0, 58);
	}

	private void initOccupation() {
		propertyDomain = addPropertyDomain(PropertyTypes.CAREER, false, null);
		addPropertyDict("国家工作人员", 0, 1);
		addPropertyDict("教师", 0, 2);
		addPropertyDict("军人", 0, 3);
		addPropertyDict("生产企业工作人员", 0, 4);
		addPropertyDict("流通企业工作人员", 0, 5);
		addPropertyDict("服务业从业人员", 0, 6);
		addPropertyDict("专业技术人员", 0, 7);
		addPropertyDict("个体工商户", 0, 8);
		addPropertyDict("农民", 0, 9);
		addPropertyDict("学生", 0, 10);
		addPropertyDict("待业", 0, 11);
		addPropertyDict("其他", 0, 12);
	}

	private void initResident_Reason() {
		propertyDomain = addPropertyDomain(PropertyTypes.RESIDENT_REASON,
				false, null);
		addPropertyDict("务工", 0, 1);
		addPropertyDict("务农", 0, 2);
		addPropertyDict("经商", 0, 3);
		addPropertyDict("盲流", 0, 4);
		addPropertyDict("其他", 0, 5);
	}

	private void initResident_Premises() {
		propertyDomain = addPropertyDomain(PropertyTypes.RESIDENT_PREMISES,
				false, null);
		addPropertyDict("居民家中", 0, 1);
		addPropertyDict("自建房屋", 0, 2);
		addPropertyDict("购买房屋", 0, 3);
		addPropertyDict("租赁房屋", 0, 4);
		addPropertyDict("公寓", 0, 5);
		addPropertyDict("宾馆", 0, 6);
		addPropertyDict("部队", 0, 7);
		addPropertyDict("学校周边", 0, 8);
		addPropertyDict("旅馆", 0, 9);
		addPropertyDict("旅店", 0, 10);
		addPropertyDict("企事业单位内部", 0, 10);
		addPropertyDict("宗教场所", 0, 12);
		addPropertyDict("外地常驻机构", 0, 13);
		addPropertyDict("流动性施工单位", 0, 14);
		addPropertyDict("临时工棚", 0, 15);
		addPropertyDict("水上船舶", 0, 16);
		addPropertyDict("车站码头", 0, 17);
		addPropertyDict("个体摊点", 0, 18);
		addPropertyDict("招待所", 0, 19);
		addPropertyDict("医院", 0, 20);
		addPropertyDict("疗养院", 0, 21);
		addPropertyDict("康复中心", 0, 22);
		addPropertyDict("机关", 0, 23);
		addPropertyDict("暂住处所不详", 0, 24);
		addPropertyDict("其他", 0, 25);
	}

	private void initIdleYouthStaffType() {
		propertyDomain = addPropertyDomain(PropertyTypes.IDLEYOUTH_STAFF_TYPE,
				false, null);
		addPropertyDict("闲散青少年", 0, 1);
		addPropertyDict("有不良行为或严重不良行为青少年", 0, 2);
		addPropertyDict("流浪乞讨未成年人", 0, 3);
		addPropertyDict("服刑在教人员未成年子女", 0, 4);
		addPropertyDict("农村留守儿童", 0, 5);
		addPropertyDict("受艾滋病影响致孤儿童", 0, 6);
		addPropertyDict("其他", 0, 7);
	}

	private void initLettingHouseType() {
		propertyDomain = addPropertyDomain(PropertyTypes.LETTINGHOUSE_TYPE,
				false, null);
		addPropertyDict("套房", 0, 1);
		addPropertyDict("平房", 0, 2);
		addPropertyDict("地下室", 0, 3);
		addPropertyDict("通天房", 0, 4);
		addPropertyDict("其他", 0, 5);
	}

	private void initLettingHouseStruts() {
		propertyDomain = addPropertyDomain(PropertyTypes.LETTINGHOUSE_STRUTS,
				false, null);
		addPropertyDict("钢结构", 0, 1);
		addPropertyDict("钢、钢筋混凝土结构", 0, 2);
		addPropertyDict("钢筋混凝土结构", 0, 3);
		addPropertyDict("混合结构", 0, 4);
		addPropertyDict("砖木结构", 0, 5);
		addPropertyDict("木结构", 0, 6);
		addPropertyDict("简易棚", 0, 7);
		addPropertyDict("其他", 0, 8);
	}

	private void initLettingHouseProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.LETTINGHOUSE_PROPERTY,
				false, null);
		addPropertyDict("私房", 0, 1);
		addPropertyDict("公房", 0, 2);
		addPropertyDict("企业产房", 0, 3);
		addPropertyDict("其他", 0, 4);
	}

	private void initLettingHouseUsage() {
		propertyDomain = addPropertyDomain(PropertyTypes.LETTINGHOUSE_USAGE,
				false, null);
		addPropertyDict("宿舍", 0, 1);
		addPropertyDict("住房", 0, 2);
		addPropertyDict("店面", 0, 3);
		addPropertyDict("仓库", 0, 4);
		addPropertyDict("工厂、工场", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	private void initHiddenTroubleLevel() {
		propertyDomain = addPropertyDomain(PropertyTypes.HIDDEN_TROUBLE_LEVEL,
				false, null);
		addPropertyDict("严重", 0, 1);
		addPropertyDict("一般", 0, 2);
		addPropertyDict("安全", 0, 3);
	}

	private void initComprehensiveManagementPost() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.COMPREHENSIVE_MANAGEMENT_POST, false, null);
		addPropertyDict("综治负责人", 0, 1);
		addPropertyDict("综治专干", 0, 2);
		addPropertyDict("信息员", 0, 3);
		addPropertyDict("保安队长", 0, 4);
		addPropertyDict("治保员", 0, 5);
		addPropertyDict("调解员", 0, 6);
		addPropertyDict("综治宣传员", 0, 7);
		addPropertyDict("禁毒协管员", 0, 8);
		addPropertyDict("消防协管员", 0, 9);
		addPropertyDict("重点人口管理信息员", 0, 10);
		addPropertyDict("流动人口协管员", 0, 11);
		addPropertyDict("维稳和反邪教信息员", 0, 12);
		addPropertyDict("特殊人群管理信息员", 0, 13);
	}

	private void initEnterpriseType() {
		propertyDomain = addPropertyDomain(PropertyTypes.ENTERPRISE_TYPE,
				false, null);
		addPropertyDict("规上企业", 0, 1);
		addPropertyDict("规下企业", 0, 2);
	}

	private void initSpecialTradeType() {
		propertyDomain = addPropertyDomain(PropertyTypes.SPECIALTRADE_TYPE,
				false, null);
		addPropertyDict("旅馆", 0, 1);
		addPropertyDict("印章刻制", 0, 2);
		addPropertyDict("拍卖", 0, 3);
		addPropertyDict("典当", 0, 4);
		addPropertyDict("印刷", 0, 5);
		addPropertyDict("复印", 0, 6);
		addPropertyDict("废旧回收", 0, 7);
		addPropertyDict("二手车交易", 0, 8);
		addPropertyDict("报废汽车回收", 0, 9);
		addPropertyDict("旧货市场", 0, 10);
		addPropertyDict("汽车修理", 0, 11);
		addPropertyDict("金银古玩", 0, 12);
		addPropertyDict("其他", 0, 13);
	}

	private void initHospitalKind() {
		propertyDomain = addPropertyDomain(PropertyTypes.HOSPITALS_KIND, false,
				null);
		addPropertyDict("公办", 0, 1);
		addPropertyDict("民办", 0, 2);
		addPropertyDict("合资", 0, 3);
		addPropertyDict("外资", 0, 4);
		addPropertyDict("其他", 0, 5);
	}

	private void initHospitalType() {
		propertyDomain = addPropertyDomain(PropertyTypes.HOSPITALS_TYPE, false,
				null);
		addPropertyDict("综合医院", 0, 1);
		addPropertyDict("专科医院", 0, 2);
		addPropertyDict("门诊", 0, 3);
		addPropertyDict("其他", 0, 4);
	}

	private void initDangerTrampresionReasonType() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAMPRESIDEN_REASON,
				false, null);
		addPropertyDict("有前科", 0, 1);
		addPropertyDict("无固定收入", 0, 2);
		addPropertyDict("从事特殊行业", 0, 3);
		addPropertyDict("其他", 0, 4);
	}

	private void initHospitalLevel() {
		propertyDomain = addPropertyDomain(PropertyTypes.HOSPITAL_LEVEL, false,
				null);
		addPropertyDict("三等特级", 0, 1);
		addPropertyDict("三等甲级", 0, 2);
		addPropertyDict("三等乙级", 0, 3);
		addPropertyDict("三等丙级", 0, 4);
		addPropertyDict("二等甲级", 0, 5);
		addPropertyDict("二等乙级", 0, 6);
		addPropertyDict("二等丙级", 0, 7);
		addPropertyDict("一等甲级", 0, 8);
		addPropertyDict("一等乙级", 0, 9);
		addPropertyDict("一等丙级", 0, 10);
		addPropertyDict("未评等级", 0, 11);
		addPropertyDict("不详", 0, 12);
	}

	private void initFourteamsCompetentDepartment() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.FOURTEAMS_COMPETENT_DEPARTMENT, false, null);
		addPropertyDict("县政务服务中心", 0, 1);
		addPropertyDict("县综治办", 0, 2);
		addPropertyDict("县委组织部", 0, 3);
		addPropertyDict("县委宣传部", 0, 4);
	}

	private void initOtherLocaleType() {
		propertyDomain = addPropertyDomain(PropertyTypes.OTHER_LOCALE_TYPE,
				false, null);
		addPropertyDict("个体诊所", 0, 1);
		addPropertyDict("电镀", 0, 2);
		addPropertyDict("煤气点", 0, 3);
		addPropertyDict("加油站", 0, 4);
		addPropertyDict("餐饮服务", 0, 5);
		addPropertyDict("化妆品", 0, 6);
		addPropertyDict("药品", 0, 7);
		addPropertyDict("医疗器械", 0, 8);
		addPropertyDict("其他", 0, 9);
	}

	private PropertyDomain addPropertyDomain(String domainName,
			 boolean systemSensitive, List<GridInternalProperty> properties) {
		propertyDomain.setDomainName(domainName);
		propertyDomain.setSystemSensitive(systemSensitive);
		propertyDomain.setInternaleProperties(properties);
		return propertyDomainService.addPropertyDomain(propertyDomain);
	}

	private PropertyDict addPropertyDict(String displayName, int internalId,
			 int displaySeq) {
		PropertyDict propertyDict = new PropertyDict();
		propertyDict.setDisplayName(displayName);
		Map<String, String> pinyin = Chinese2pinyin
				.changeChinese2Pinyin(propertyDict.getDisplayName());
		propertyDict.setFullPinyin((String) pinyin.get("fullPinyin"));
		propertyDict.setSimplePinyin((String) pinyin.get("simplePinyin"));
		propertyDict.setCreateDate(Calendar.getInstance().getTime());
		propertyDict.setPropertyDomain(propertyDomain);
		propertyDict.setInternalId(internalId);
		propertyDict.setDisplaySeq(displaySeq);

		propertyDict.setCreateUser("admin");
		return propertyDictService.addPropertyDictForInit(propertyDict);
	}

	private void initIssueEventProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.ISSUE_KIND, false,
				null);
		addPropertyDict("个体性事件", 0, 1);
		addPropertyDict("群体性事件", 0, 2);
	}

	// 指挥中心——信息状态
	private void eventSourceState() {
		propertyDomain = addPropertyDomain(PropertyTypes.EVENTSOURCE_STATE,
				false, null);
		addPropertyDict("已转入事件并分流", EventSourceState.EVENTSOURCESHIFTANDFLOW, 1);
		addPropertyDict("已转入事件但未分流", EventSourceState.EVENTSOURCESHIFTNOTFLOW,
				2);
		addPropertyDict("无需转入事件", EventSourceState.EVENTSOURCEFORNOTSHIFT, 3);

	}

	private void initIssueFromMethod() {
		propertyDomain = addPropertyDomain(PropertyTypes.SOURCE_KIND, false,
				null);
		addPropertyDict(IssueConstants.MANUAL_INPUT,
				IssueSourceType.MANUAL_INPUT, 1);
		addPropertyDict(IssueConstants.SMS_INPUT, IssueSourceType.SMS_INPUT, 2);
		addPropertyDict(IssueConstants.WEB_INPUT, IssueSourceType.WEB_INPUT, 3);
		addPropertyDict(IssueConstants.CITYMANAGE_INPUT,
				IssueSourceType.CITYMANAGE_INPUT, 4);
		addPropertyDict(IssueConstants.CALLCENTER_INPUT,
				IssueSourceType.CALLCENTER_INPUT, 5);
		addPropertyDict(IssueConstants.TELEPHONE_HOTLINE,
				IssueSourceType.TELEPHONE_HOTLINE, 6);
		addPropertyDict(IssueConstants.APPROVAL_INPUT,
				IssueSourceType.APPROVAL_INPUT, 7);
		addPropertyDict(IssueConstants.VISIT_INPUT,
				IssueSourceType.VISIT_INPUT, 8);
		addPropertyDict(IssueConstants.MOBILE_INPUT,
				IssueSourceType.MOBILE_INPUT, 9);
		addPropertyDict(IssueConstants.WECHAT_INPUT,
				IssueSourceType.WECHAT_INPUT, 10);
		// 事件流入方式PC录入增加
		addPropertyDict(IssueConstants.PC_INPUT, IssueSourceType.PC_INPUT, 11);
		// 事件流入方式同步增加
		addPropertyDict(IssueConstants.JOINT_INPUT,
				IssueSourceType.JOINT_INPUT, 12);
	}

	private void initStatementStatisticType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.STATEMENT_STATISTIC_TYPE, false, null);
		addPropertyDict("年报", 0, 1);
		addPropertyDict("月报", 0, 2);
	}

	private void initDailyDirectoryType() {
		propertyDomain = addPropertyDomain(
				DailyDirectoryTypes.DAILY_DIRECTORY_TYPES_KEY, true,
				DailyDirectoryTypes.getInternalProperties());

		addPropertyDict("会议类", DailyDirectoryTypes.MEET, 1);
		addPropertyDict("文件类", DailyDirectoryTypes.FILE, 2);
		addPropertyDict("活动类", DailyDirectoryTypes.ACTIVITIES, 3);
		addPropertyDict("治安重点排查整治类", DailyDirectoryTypes.CHECK, 4);
		addPropertyDict("矛盾纠纷排查调处类", DailyDirectoryTypes.ISSUEDEAL, 5);

		addPropertyDict(DailyDirectoryTypes.INVESTIGATION_NAME + "类",
				DailyDirectoryTypes.INVESTIGATION, 6);
		addPropertyDict(DailyDirectoryTypes.SIGNIFICANT_ISSUEDEAL_NAME + "类",
				DailyDirectoryTypes.SIGNIFICANT_ISSUEDEAL, 7);

		addPropertyDict(DailyDirectoryTypes.INVESTIGATION_REMEDIATION_NAME
				+ "类", DailyDirectoryTypes.INVESTIGATION_REMEDIATION, 8);

		addPropertyDict("报表上报", DailyDirectoryTypes.STATEMENTS_REPORTED, 4);
		addPropertyDict("社会治安防控体系建设", DailyDirectoryTypes.SOCIETY_SECURITY, 5);
		addPropertyDict("平安综治宣传", DailyDirectoryTypes.SECURITY_PROPAGANDA, 6);
		addPropertyDict("系列平安创建", DailyDirectoryTypes.SERIES_SECURITY, 7);
		addPropertyDict("社会服务管理", DailyDirectoryTypes.SERVICE_MANAGEMENT, 8);
		/*
		 * addPropertyDict("社会服务管理中心建设(县及以上使用)",
		 * DailyDirectoryTypes.SERVICE_MANAGEMENT_CITY, 9);
		 * addPropertyDict("社会服务管理中心建设(乡镇使用)",
		 * DailyDirectoryTypes.SERVICE_MANAGEMENT_TOWN, 10);
		 * addPropertyDict("社会服务管理室（站）建设(村社区使用)",
		 * DailyDirectoryTypes.SERVICE_MANAGEMENT_VILLAGE, 11);
		 */

		addPropertyDict("平时开展工作情况(网格化管理、组团式服务)",
				DailyDirectoryTypes.GRID_MANAGEMENT_NORMAL, 9);

	}

	private void initStatementsReportedType() {
		propertyDomain = addPropertyDomain(
				StatementsReportedType.STATEMENTS_REPORTED_TYPE_KEY, true,
				StatementsReportedType.getInternalProperties());

		addPropertyDict("治安重点排查整治类", StatementsReportedType.CHECK, 1);
		addPropertyDict("矛盾纠纷排查调处类", StatementsReportedType.ISSUEDEAL, 2);
		addPropertyDict("治安重点排查情况", StatementsReportedType.INVESTIGATION, 3);
		addPropertyDict("重大矛盾纠纷排查调处情况",
				StatementsReportedType.SIGNIFICANT_ISSUEDEAL, 4);
		addPropertyDict("排查整治强基促稳情况类",
				StatementsReportedType.INVESTIGATION_REMEDIATION, 5);
	}

	private void initServiceManagementType() {
		propertyDomain = addPropertyDomain(
				DailyDirectoryTypes.SERVICE_MANAGEMENT_NAME, true,
				ServiceManagementTypes.getInternalProperties());

		addPropertyDict("社会服务管理中心建设(县及以上使用)",
				ServiceManagementTypes.SERVICE_MANAGEMENT_CITY, 1);
		addPropertyDict("社会服务管理中心建设(乡镇使用)",
				ServiceManagementTypes.SERVICE_MANAGEMENT_TOWN, 2);
		addPropertyDict("社会服务管理室（站）建设(村社区使用)",
				ServiceManagementTypes.SERVICE_MANAGEMENT_VILLAGE, 3);
	}

	private void initDirectoryReportType() {
		propertyDomain = addPropertyDomain(
				DirectoryReportType.DIRECTORY_REPORT_TYPE_KEY, true,
				DirectoryReportType.getInternalProperties());

		addPropertyDict("月报", DirectoryReportType.MONTH_REPORT, 1);
		addPropertyDict("季报", DirectoryReportType.QUARTER_REPORT, 2);
		addPropertyDict("半年报", DirectoryReportType.SEMIYEARLY_REPORT, 3);
		addPropertyDict("年报", DirectoryReportType.YEAR_REPORT, 4);
	}

	private void initDirectoryReportCheckType() {
		propertyDomain = addPropertyDomain(StatementsReportedType.CHECK_NAME,
				true, DirectoryReportType.getInternalProperties());

		addPropertyDict("月报", DirectoryReportType.MONTH_REPORT, 1);
		addPropertyDict("季报", DirectoryReportType.QUARTER_REPORT, 2);
		addPropertyDict("半年报", DirectoryReportType.SEMIYEARLY_REPORT, 3);
		addPropertyDict("年报", DirectoryReportType.YEAR_REPORT, 4);
	}

	private void initDirectoryReportIssueDealType() {
		propertyDomain = addPropertyDomain(
				StatementsReportedType.ISSUEDEAL_NAME, true,
				DirectoryReportType.getInternalProperties());

		addPropertyDict("月报", DirectoryReportType.MONTH_REPORT, 1);
		addPropertyDict("季报", DirectoryReportType.QUARTER_REPORT, 2);
		addPropertyDict("半年报", DirectoryReportType.SEMIYEARLY_REPORT, 3);
		addPropertyDict("年报", DirectoryReportType.YEAR_REPORT, 4);
	}

	private void initPoorSource() {
		propertyDomain = addPropertyDomain(PropertyTypes.POOR_SOURCE, false,
				null);
		addPropertyDict("无劳力(孤幼)", 0, 1);
		addPropertyDict("医疗支出过大", 0, 2);
		addPropertyDict("突发性事件", 0, 3);
		addPropertyDict("无劳力(孤老)", 0, 4);
		addPropertyDict("无劳力(因残)", 0, 5);
		addPropertyDict("无劳力(因病)", 0, 6);
		addPropertyDict("劳力不全(因残)", 0, 7);
		addPropertyDict("劳力不全(因病)", 0, 8);
		addPropertyDict("未充分就业", 0, 9);
		addPropertyDict("未就业", 0, 10);
		addPropertyDict("教育支出过大", 0, 11);
		addPropertyDict("其它", 0, 12);
	}

	/**
	 * 综治组织职务
	 */
	private void initCompositeDutyInfo() {
		propertyDomain = addPropertyDomain(PropertyTypes.COMPOSITEDUTY, false,
				null);
		addPropertyDict("主任", 0, 1);
		addPropertyDict("常务副主任", 0, 2);
		addPropertyDict("副主任", 0, 3);
		addPropertyDict("组长", 0, 4);
		addPropertyDict("常务副组长", 0, 5);
		addPropertyDict("第一副组长", 0, 6);
		addPropertyDict("副组长", 0, 7);
		addPropertyDict("成员", 0, 8);
		addPropertyDict("网格长", 0, 9);
		addPropertyDict("网格员", 0, 10);
	}

	/**
	 * 党组织职务
	 */
	private void initPartyDutyInfo() {
		propertyDomain = addPropertyDomain(PropertyTypes.PARTYDUTY, false, null);
		addPropertyDict("党委书记", 0, 1);
		addPropertyDict("党委副书记", 0, 2);
		addPropertyDict("纪委书记", 0, 3);
		addPropertyDict("党支部书记", 0, 4);
		addPropertyDict("党支部副书记", 0, 5);
		addPropertyDict("党委委员", 0, 6);
		addPropertyDict("成员", 0, 7);
	}

	/**
	 * 基层自治组织职务
	 */
	private void initUtonomyDutyInfo() {
		propertyDomain = addPropertyDomain(PropertyTypes.UTONOMYDUTY, false,
				null);
		addPropertyDict("书记", 0, 1);
		addPropertyDict("主任", 0, 2);
		addPropertyDict("副主任", 0, 3);
		addPropertyDict("董事长", 0, 4);
		addPropertyDict("董事", 0, 5);
		addPropertyDict("成员", 0, 6);
	}

	/**
	 * 群防群治队伍职务
	 */
	private void initMassesDutyInfo() {
		propertyDomain = addPropertyDomain(PropertyTypes.MASSESDUTY, false,
				null);
		addPropertyDict("主任", 0, 1);
		addPropertyDict("常务副主任", 0, 2);
		addPropertyDict("副主任", 0, 3);
		addPropertyDict("组长", 0, 4);
		addPropertyDict("常务副组长", 0, 5);
		addPropertyDict("副组长	", 0, 6);
		addPropertyDict("队长", 0, 7);
		addPropertyDict("副队长", 0, 8);
		addPropertyDict("成员", 0, 9);
	}

	/**
	 * 社会志愿者队伍职务
	 */
	private void initPostulantDutyInfo() {
		propertyDomain = addPropertyDomain(PropertyTypes.POSTULANTDUTY, false,
				null);
		addPropertyDict("主任", 0, 1);
		addPropertyDict("常务副主任", 0, 2);
		addPropertyDict("副主任", 0, 3);
		addPropertyDict("组长", 0, 4);
		addPropertyDict("常务副组长", 0, 5);
		addPropertyDict("副组长	", 0, 6);
		addPropertyDict("队长", 0, 7);
		addPropertyDict("常务副队长", 0, 8);
		addPropertyDict("副队长", 0, 9);
		addPropertyDict("成员", 0, 10);
	}

	/**
	 * 专项工作小组职务
	 */
	private void initLeaderGroupDutyInfo() {
		propertyDomain = addPropertyDomain(PropertyTypes.LEADERGROUPDUTY,
				false, null);
		addPropertyDict("主任", 0, 1);
		addPropertyDict("常务副主任", 0, 2);
		addPropertyDict("副主任", 0, 3);
		addPropertyDict("组长", 0, 4);
		addPropertyDict("副组长	", 0, 5);
		addPropertyDict("所长", 0, 6);
		addPropertyDict("副所长", 0, 7);
		addPropertyDict("站长", 0, 8);
		addPropertyDict("副站长", 0, 9);
		addPropertyDict("成员", 0, 10);
	}

	/**
	 * 网格化管理服务团队职务
	 */
	private void initGridmanagementTeamDuty() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.GRIDMANAGEMENTTEAMDUTY, false, null);

		addPropertyDict("管理员", 0, 1);
		addPropertyDict("协管员", 0, 2);
		addPropertyDict("督导员", 0, 3);
		addPropertyDict("执法队员和警员", 0, 3);
	}

	/**
	 * 专项工作小组类别
	 */
	private void initLeaderGroupTypeInfo() {
		propertyDomain = addPropertyDomain(PropertyTypes.LEADERGROUP_TYPE,
				false, null);
		addPropertyDict("预防青少年犯罪", DepartmentPartyOrgType.LEADER_GROUP_TYPE, 1);
		addPropertyDict("特殊人群", DepartmentPartyOrgType.LEADER_GROUP_TYPE, 2);
		addPropertyDict("人口信息", DepartmentPartyOrgType.LEADER_GROUP_TYPE, 3);
		addPropertyDict("校园及周边治理", DepartmentPartyOrgType.LEADER_GROUP_TYPE, 4);
		addPropertyDict("铁路护路", DepartmentPartyOrgType.LEADER_GROUP_TYPE, 5);
		addPropertyDict("两新组织", DepartmentPartyOrgType.LEADER_GROUP_TYPE, 6);
		addPropertyDict("三电专项组", DepartmentPartyOrgType.LEADER_GROUP_TYPE, 7);
		addPropertyDict("社会治安综合治理", DepartmentPartyOrgType.LEADER_GROUP_TYPE, 8);
		addPropertyDict("军地共建平安", DepartmentPartyOrgType.LEADER_GROUP_TYPE, 9);
	}

	private void initBasicOrgType() {
		propertyDomain = addPropertyDomain(PropertyTypes.BASICORGTYPE, false,
				null);
		addPropertyDict("综治委", BasicOrgType.PERMARY_ORGANIZATION, 1);
		addPropertyDict("综治办", BasicOrgType.PERMARY_ORGANIZATION, 2);
		addPropertyDict("综治工作室", BasicOrgType.PERMARY_ORGANIZATION, 3);
		addPropertyDict("综治工作中心", BasicOrgType.PERMARY_ORGANIZATION, 4);
		addPropertyDict("村委会", BasicOrgType.AUTONOMY_ORG, 5);
		addPropertyDict("社区居民委员会", BasicOrgType.AUTONOMY_ORG, 6);
		addPropertyDict("经济合作社", BasicOrgType.AUTONOMY_ORG, 7);
		addPropertyDict("业主委员会", BasicOrgType.AUTONOMY_ORG, 8);
		addPropertyDict("治保调解会", BasicOrgType.AUTONOMY_ORG, 9);
		addPropertyDict("协警队伍", BasicOrgType.MASS_TREAT_TEAM, 10);
		addPropertyDict("综治管理队伍", BasicOrgType.MASS_TREAT_TEAM, 11);
		addPropertyDict("义务防范队伍", BasicOrgType.MASS_TREAT_TEAM, 12);
		addPropertyDict("保安公司", BasicOrgType.MASS_TREAT_TEAM, 13);
		addPropertyDict("治安巡防队伍", BasicOrgType.VOLUNTARY_TEAM, 14);
		addPropertyDict("矛盾化解队伍", BasicOrgType.VOLUNTARY_TEAM, 15);
		addPropertyDict("帮教服务队伍", BasicOrgType.VOLUNTARY_TEAM, 16);
		addPropertyDict("法律援助队伍", BasicOrgType.VOLUNTARY_TEAM, 17);
		addPropertyDict("消防安全队伍", BasicOrgType.VOLUNTARY_TEAM, 18);
		addPropertyDict("交通道路安全队伍", BasicOrgType.VOLUNTARY_TEAM, 19);
		addPropertyDict("平安", BasicOrgType.LEADER_GROUP, 20);
		addPropertyDict("维稳", BasicOrgType.LEADER_GROUP, 21);
		addPropertyDict("信访", BasicOrgType.LEADER_GROUP, 22);
		addPropertyDict("人民防线", BasicOrgType.LEADER_GROUP, 23);
		addPropertyDict("预防青少年违法犯罪", BasicOrgType.LEADER_GROUP, 24);
		addPropertyDict("禁毒", BasicOrgType.LEADER_GROUP, 25);
		addPropertyDict("社区戒毒康复", BasicOrgType.LEADER_GROUP, 26);
		addPropertyDict("应急管理", BasicOrgType.LEADER_GROUP, 27);
		addPropertyDict("司法所", BasicOrgType.LEADER_GROUP, 28);
		addPropertyDict("五五普法和依法治理", BasicOrgType.LEADER_GROUP, 29);
		addPropertyDict("刑释人员安置", BasicOrgType.LEADER_GROUP, 30);
		addPropertyDict("社区矫正", BasicOrgType.LEADER_GROUP, 31);
		addPropertyDict("流动人口服务管理", BasicOrgType.LEADER_GROUP, 32);
		addPropertyDict("学校及周边治安综合治理", BasicOrgType.LEADER_GROUP, 33);
		addPropertyDict("铁路护路联防", BasicOrgType.LEADER_GROUP, 34);
		addPropertyDict("海事渔事纠纷调处", BasicOrgType.LEADER_GROUP, 35);
		addPropertyDict("综合治理执行难", BasicOrgType.LEADER_GROUP, 36);
		addPropertyDict("消防安全", BasicOrgType.LEADER_GROUP, 37);
	}

	private void initWorkDiaryType() {
		propertyDomain = addPropertyDomain(PropertyTypes.WORKDIARY_DIARY_TYPE,
				false, null);
		addPropertyDict(WorkDiaryTypes.HELP_PERSONNEL, 0, 1);
		addPropertyDict(WorkDiaryTypes.LOVINGCARE, 0, 2);
		addPropertyDict(WorkDiaryTypes.UNEMPLOYED, 0, 3);
		addPropertyDict(WorkDiaryTypes.NURTURESWOMEN, 0, 4);
		addPropertyDict(WorkDiaryTypes.FLOORPERSONS, 0, 5);
		addPropertyDict(WorkDiaryTypes.LETTINGHOUSE_FLOORPERSONS, 0, 6);
		addPropertyDict(WorkDiaryTypes.ENTERPRISE_FLOORPERSONS, 0, 7);
		addPropertyDict(WorkDiaryTypes.NEWSOCIETY_FLOORPERSONS, 0, 8);
		addPropertyDict(WorkDiaryTypes.ISSUE_DEAL, 0, 9);
		addPropertyDict(WorkDiaryTypes.OTHER, 0, 10);
	}

	private void initScoresStandard() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCORES_STANDARDS,
				true, ScoresStandardsType.getInternalProperties());

		addPropertyDict("优秀", ScoresStandardsType.GREAT, 1);
		addPropertyDict("良好", ScoresStandardsType.GOOD, 2);
		addPropertyDict("合格", ScoresStandardsType.QULIFIED, 3);
		addPropertyDict("不合格", ScoresStandardsType.FAILED, 4);
	}

	public void initStructureYear() {
		propertyDomain = addPropertyDomain(PropertyTypes.STRUCTURE_YEAR, false,
				null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("祖屋", 0, 2);
		addPropertyDict("十九世纪", 0, 3);
		addPropertyDict("建国前", 0, 4);
		addPropertyDict("五十年代", 0, 5);
		addPropertyDict("六十年代", 0, 6);
		addPropertyDict("七十年代", 0, 7);
		addPropertyDict("八十年代", 0, 8);
		addPropertyDict("九十年代", 0, 9);
		addPropertyDict("廿一世纪", 0, 10);
		addPropertyDict("待定", 0, 11);
	}

	public void initBuildingStructure() {
		propertyDomain = addPropertyDomain(PropertyTypes.BUILDING_STRUCTURE,
				false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("木质", 0, 2);
		addPropertyDict("钢砼", 0, 3);
		addPropertyDict("石混", 0, 4);
		addPropertyDict("石木", 0, 5);
		addPropertyDict("砖木", 0, 6);
		addPropertyDict("砖混", 0, 7);
		addPropertyDict("其他", 0, 8);
	}

	public void initHouseEquity() {
		propertyDomain = addPropertyDomain(PropertyTypes.HOUSE_EQUITY, false,
				null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("自有", 0, 2);
		addPropertyDict("公房", 0, 3);
		addPropertyDict("租赁", 0, 4);
		addPropertyDict("借住", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	public void initWorkingRecordSubmitState() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.WORKING_RECORD_SUBMITSTATE, true,
				WorkingRecordSubmitstate.getInternalProperties());

		addPropertyDict("未上报", WorkingRecordSubmitstate.HAS_NOT_SUBMIT, 1);
		addPropertyDict("已上报", WorkingRecordSubmitstate.HAS_SUBMIT, 2);
		addPropertyDict("回退", WorkingRecordSubmitstate.BACK_STATE, 3);

	}

	private void addDetailPropertyDict(List<String> displayNames,
			int internalId, int startDisplaySeq) {
		for (int i = 0; i < displayNames.size(); i++) {
			addPropertyDict(displayNames.get(i), internalId, startDisplaySeq
					+ i);
		}
	}

	private void initCertificatetype() {
		propertyDomain = addPropertyDomain(PropertyTypes.CERTIFICATE_TYPE,
				false, null);
		addPropertyDict("旅游证", 0, 1);
		addPropertyDict("港澳出入证", 0, 2);
		addPropertyDict("护照", 0, 3);
		addPropertyDict("台胞证", 0, 3);

	}

	private void initSpecialCareType() {
		propertyDomain = addPropertyDomain(PropertyTypes.SPECIAL_CARE_TYPE,
				false, null);
		addPropertyDict("未知", OptimalObjectType.UNKNOWN, 1);
		addPropertyDict("无", OptimalObjectType.NONE, 2);
		addPropertyDict("因公牺牲军人家属",
				OptimalObjectType.DiedOnduty_Armyman_Family, 3);
		addPropertyDict("病故军人家属", OptimalObjectType.DiedOnill_Armyman_Family, 4);
		addPropertyDict("在乡退伍军人老战士", OptimalObjectType.Veteran, 5);
		addPropertyDict("在乡复员军人", OptimalObjectType.Exserviceman, 6);
		addPropertyDict("带病回乡退伍军人", OptimalObjectType.Veteran_WithIll, 7);
		addPropertyDict("精神病人", OptimalObjectType.Psychopath, 8);
		addPropertyDict("军属", OptimalObjectType.Armyman_Family, 9);
		addPropertyDict("孤儿", OptimalObjectType.Orphan, 10);
		addPropertyDict("孤寡老人", OptimalObjectType.NO_FAMILY_ELDER, 11);
		addPropertyDict("残疾人", OptimalObjectType.Handicapped, 12);
		addPropertyDict("伤残革命军人", OptimalObjectType.Disable_Armyman, 13);
		addPropertyDict("伤残国际机关工作人员",
				OptimalObjectType.Disable_International_Staff, 14);
		addPropertyDict("伤残人民警察", OptimalObjectType.Disable_Police, 15);
		addPropertyDict("伤残民兵民工", OptimalObjectType.Disable_Militia, 16);
		addPropertyDict("烈士家属", OptimalObjectType.Died_Armyman_Family, 17);
		addPropertyDict("其他", OptimalObjectType.OTHER, 18);

	}

	private void initLabourCapacity() {
		propertyDomain = addPropertyDomain(PropertyTypes.LABOUR_CAPACITY,
				false, null);
		addPropertyDict("有", 0, 1);
		addPropertyDict("无", 0, 2);
		addPropertyDict("部分", 0, 3);

	}

	private void initViability() {
		propertyDomain = addPropertyDomain(PropertyTypes.VIABILITY, false, null);
		addPropertyDict("自理", 0, 1);
		addPropertyDict("护理", 1, 2);

	}

	private void initEmploymentStatus() {
		propertyDomain = addPropertyDomain(PropertyTypes.EMPLOYMENT_STATUS,
				false, null);
		addPropertyDict("未就业", 0, 1);
		addPropertyDict("已就业", 0, 2);
		addPropertyDict("患病无法就业", 0, 3);

	}

	private void initSupportStatus() {
		propertyDomain = addPropertyDomain(PropertyTypes.SUPPORT_STATUS, false,
				null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("自理", 0, 2);
		addPropertyDict("子女供养", 0, 3);
		addPropertyDict("分散供养", 0, 4);
		addPropertyDict("集体供养", 0, 5);
		addPropertyDict("其它", 0, 6);

	}

	private void initDisabilityStatus() {
		propertyDomain = addPropertyDomain(PropertyTypes.DISABILITY_STATUS,
				false, null);
		addPropertyDict("视力残疾一级", 0, 1);
		addPropertyDict("视力残疾二级", 0, 2);
		addPropertyDict("智力残疾一级", 0, 3);
		addPropertyDict("智力残疾二级", 0, 4);
		addPropertyDict("智力残疾三级", 0, 5);
		addPropertyDict("智力残疾四级", 0, 6);
		addPropertyDict("肢体残疾一级", 0, 7);
		addPropertyDict("肢体残疾二级", 0, 8);
		addPropertyDict("肢体残疾三级", 0, 9);
		addPropertyDict("肢体残疾四级", 0, 10);
		addPropertyDict("精神残疾一级", 0, 11);
		addPropertyDict("精神残疾二级", 0, 12);
		addPropertyDict("精神残疾三级", 0, 13);
		addPropertyDict("精神残疾四级", 0, 14);
		addPropertyDict("听力残疾一级", 0, 15);
		addPropertyDict("听力残疾二级", 0, 16);
		addPropertyDict("听力残疾三级", 0, 17);
		addPropertyDict("听力残疾四级", 0, 18);
		addPropertyDict("言语残疾一级", 0, 19);
		addPropertyDict("言语残疾二级", 0, 20);
		addPropertyDict("言语残疾三级", 0, 21);
		addPropertyDict("言语残疾四级", 0, 22);
		addPropertyDict("视力残疾三级", 0, 23);

		addPropertyDict("视力残疾四级", 0, 24);
		addPropertyDict("多重残疾一级", 0, 25);
		addPropertyDict("多重残疾二级", 0, 26);
		addPropertyDict("多重残疾三级", 0, 27);
		addPropertyDict("多重残疾四级", 0, 28);

	}

	private void initSkillsAndSpecialities() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.SKILLS_AND_SPECIALITIES, false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("木工", 0, 2);
		addPropertyDict("导游员", 0, 3);
		addPropertyDict("厨师", 0, 4);
		addPropertyDict("手工业", 0, 5);
		addPropertyDict("瓦工", 0, 6);
		addPropertyDict("石匠", 0, 7);
		addPropertyDict("油漆工", 0, 8);
		addPropertyDict("电焊工", 0, 9);
		addPropertyDict("机加工", 0, 10);
		addPropertyDict("氨机工", 0, 11);
		addPropertyDict("船员", 0, 12);
		addPropertyDict("驾驶员", 0, 13);
		addPropertyDict("其他", 0, 14);

	}

	private void initLiveStatus() {
		propertyDomain = addPropertyDomain(PropertyTypes.LIVE_STATUS, false,
				null);
		addPropertyDict("与家人同居", 0, 2);
		addPropertyDict("独居", 0, 3);
		addPropertyDict("敬老院集体居住", 0, 1);

	}

	private void initSpecialPerson() {
		propertyDomain = addPropertyDomain(PropertyTypes.SPECIAL_PERSON, false,
				null);
		addPropertyDict("未知", ElderPersonType.UNKNOWN_ELDER, 1);
		addPropertyDict("孤寡老人", ElderPersonType.NOFAMILY_ELDER, 2);
		addPropertyDict("生产", ElderPersonType.PRODUCTER_ELDER, 3);
		addPropertyDict("低保", ElderPersonType.LOWERINCOME_ELDER, 4);
		addPropertyDict("劳模", ElderPersonType.LABORHERO_ELDER, 5);
		addPropertyDict("特困", ElderPersonType.LOWERINCOME_ELDER, 6);
		addPropertyDict("重病", ElderPersonType.TERRIBLYILL_ELDER, 7);
		addPropertyDict("70岁以上高龄老人", ElderPersonType.ELDERLY_ELDER, 8);
		addPropertyDict("建国前参加工作", ElderPersonType.OLDWORKER_ELDER, 9);
		addPropertyDict("一老养一老", ElderPersonType.PENSION_ELDER, 10);
		addPropertyDict("自理", ElderPersonType.SELFCARE_ELDER, 11);
		addPropertyDict("其它", ElderPersonType.OTHER, 12);

	}

	private void initSpouseStatus() {
		propertyDomain = addPropertyDomain(PropertyTypes.SPOUSE_STATUS, false,
				null);
		addPropertyDict("单位在职", 0, 2);
		addPropertyDict("离退休", 0, 3);
		addPropertyDict("无职业", 0, 4);
		addPropertyDict("去世", 0, 5);
		addPropertyDict("离婚", 0, 6);
		addPropertyDict("自由职业", 0, 1);
		addPropertyDict("其它", 0, 7);

	}

	private void initCurrentStatus() {
		propertyDomain = addPropertyDomain(PropertyTypes.CURRENT_STATUS, false,
				null);
		addPropertyDict("继续工作", 0, 1);
		addPropertyDict("在家休养", 0, 2);
		addPropertyDict("参加社区管理工作", 0, 3);
		addPropertyDict("从事社会公益活动", 0, 4);
		addPropertyDict("生产劳动", 0, 5);
		addPropertyDict("个体经营", 0, 6);
		addPropertyDict("其它", 0, 7);

	}

	private void initIncomeSource() {
		propertyDomain = addPropertyDomain(PropertyTypes.INCOME_SOURCE, false,
				null);
		addPropertyDict("自理", 0, 1);
		addPropertyDict("子女赡养", 0, 3);
		addPropertyDict("离退休费", 0, 4);
		addPropertyDict("社会救济", 0, 5);
		addPropertyDict("以奖代保", 0, 6);
		addPropertyDict("政府补助", 0, 2);

	}

	private void initInflowingReason() {
		propertyDomain = addPropertyDomain(PropertyTypes.INFLOWING_REASON,
				false, null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("务工经商", 0, 2);
		addPropertyDict("房屋拆迁", 0, 3);
		addPropertyDict("投亲靠友", 0, 4);
		addPropertyDict("两处以上住房", 0, 5);
		addPropertyDict("求学入托", 0, 6);
		addPropertyDict("分配调动工作", 0, 7);
		addPropertyDict("分换住房", 0, 8);
		addPropertyDict("其他", 0, 9);
	}

	private void initHousingInfoType() {
		propertyDomain = addPropertyDomain(PropertyTypes.HOUSEING_INFO_TYPE,
				false, null);
		addPropertyDict("自住房", HouseInfoType.OWNLIVE_HOUSE, 1);
		addPropertyDict("出租房", HouseInfoType.RENTAL_HOUSE, 2);
		addPropertyDict("集体（单位福利）房", HouseInfoType.COMPANY_HOUSE, 3);
		addPropertyDict("闲置房", HouseInfoType.IDLE_HOUSE, 4);
		addPropertyDict("其他", HouseInfoType.OTHER, 5);
		addPropertyDict("实有房屋", HouseInfoType.ACTUAL_HOUSE, 6);
	}

	private void initCurrentAddressType() {
		propertyDomain = addPropertyDomain(PropertyTypes.CURRENT_ADDRESS_TYPE,
				false, null);
		addPropertyDict("商品房", CurrentAddressType.BUSINESS_HOUSE, 1);
		addPropertyDict("其他", CurrentAddressType.OTHER, 2);
	}

	private void initProfessionType() {
		propertyDomain = addPropertyDomain(PropertyTypes.PROFESSION_TYPE,
				false, null);
		addPropertyDict("工程师", 0, 1);
		addPropertyDict("教师", 0, 2);
		addPropertyDict("医生", 0, 3);
	}

	private void initInfrastructure() {
		propertyDomain = addPropertyDomain(PropertyTypes.INFRASTRUCTURE, true,
				Infrastructure.getInternalProperties());
		addPropertyDict("水", Infrastructure.WATER, 1);
		addPropertyDict("电", Infrastructure.ELECTRICITY, 2);
		addPropertyDict("气", Infrastructure.GAS, 3);
		addPropertyDict("暖", Infrastructure.WARM, 4);
	}

	private void initLicenseSituation() {
		propertyDomain = addPropertyDomain(PropertyTypes.LICENSE_SITUATION,
				true, LicenseSituation.getInternalProperties());
		addPropertyDict("未知", LicenseSituation.UNKNOWN, 1);
		addPropertyDict("未领证", LicenseSituation.NEVERLICENSE, 2);
		addPropertyDict("领证，现有效", LicenseSituation.ALREADYLICENSE, 3);
		addPropertyDict("领证，超14周岁", LicenseSituation.ALREADYLICENSE, 4);
		addPropertyDict("领证，子女死亡", LicenseSituation.ALREADYLICENSE, 5);
		addPropertyDict("计内二孩，证废", LicenseSituation.NEVERLICENSE, 6);
		addPropertyDict("计外二孩，证废", LicenseSituation.NEVERLICENSE, 7);
	}

	private void initNewEconomicOrganizationsStyle() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.NEWECONOMICORGANIZATIONS_STYLE, false, null);
		addPropertyDict("个体工商户", 0, 1);
		addPropertyDict("私营企业", 0, 2);
		addPropertyDict("外商经济控制企业", 0, 3);
		addPropertyDict("港澳台经济控制企业", 0, 4);
		addPropertyDict("非国有控股股份制企业", 0, 5);
		addPropertyDict("非国有控股混合所有制企业", 0, 6);
		addPropertyDict("其他", 0, 7);

	}

	private void initOneChildSituation() {
		propertyDomain = addPropertyDomain(PropertyTypes.ONE_CHILD_SITUATION,
				false, null);
		addPropertyDict("女方独生", 0, 1);
		addPropertyDict("男方独生", 0, 2);
		addPropertyDict("双方独生", 0, 3);
		addPropertyDict("双方非独生", 0, 4);
	}

	private void initTechnologyLevel() {
		propertyDomain = addPropertyDomain(PropertyTypes.TECHNOLOGYLEVEL,
				false, null);
		addPropertyDict("初级技工", 0, 1);
		addPropertyDict("中级技工", 0, 2);
		addPropertyDict("高级技工", 0, 3);
		addPropertyDict("技师", 0, 4);
		addPropertyDict("初级技师", 0, 5);
		addPropertyDict("高级技师", 0, 6);
		addPropertyDict("初级专业技术职务", 0, 7);
		addPropertyDict("中级专业技术", 0, 8);
		addPropertyDict("高级专业技术", 0, 9);
		addPropertyDict("无", 0, 10);
	}

	private void initUnemploymentReason() {
		propertyDomain = addPropertyDomain(PropertyTypes.UNEMPLOYMENTREASON,
				false, null);
		addPropertyDict("年满16周岁，从各类学校毕业、肄业、未能继续升学的",
				UnemploymentReasonType.Leave_School, 1);
		addPropertyDict("与企业解除或终止劳动关系的",
				UnemploymentReasonType.Remove_Enterprise, 2);
		addPropertyDict("从机关事业单位辞职或被辞退解聘的",
				UnemploymentReasonType.Out_Institutions, 3);
		addPropertyDict("由农业户口转为非农业户口，并失去承包土地的",
				UnemploymentReasonType.Lost_Land, 4);
		addPropertyDict("军人退出现役、且未纳入国家统一安置的",
				UnemploymentReasonType.Ex_serviceman, 5);
		addPropertyDict("刑满释放（未成年人除外）",
				UnemploymentReasonType.Release_After_Serving, 6);
		addPropertyDict("劳动教养期满或提前解除劳动教养的（未成年人除外）",
				UnemploymentReasonType.Reeducation_Through_Labor, 7);
		addPropertyDict("个体工商户业主或私营业主停止经营的",
				UnemploymentReasonType.Individual_Business_Down, 8);
		addPropertyDict("灵活就业失业的", UnemploymentReasonType.Flexible_Employment,
				9);
		addPropertyDict("本地区农村劳动力", UnemploymentReasonType.Rural_Labor_Force,
				10);
		addPropertyDict("外来失业人口",
				UnemploymentReasonType.Foreign_Unemployed_Population, 11);
		addPropertyDict("其他", UnemploymentReasonType.OTHER, 12);
		addPropertyDict("假释、缓刑、暂予监外外执行、管制、剥夺政治权利等社区矫正人员（未成年人除外）",
				UnemploymentReasonType.Other_Community_Correction, 13);
	}

	private void initUnemployedPeopleType() {
		propertyDomain = addPropertyDomain(PropertyTypes.UNEMPLOYEDPEOPLETYPE,
				false, null);
		addPropertyDict("城镇新增劳动力", 0, 1);
		addPropertyDict("城镇就业转失业", 0, 2);
		addPropertyDict("农村新增劳动力", 0, 3);
		addPropertyDict("农村就业转失业", 0, 4);
		addPropertyDict("其它", 0, 4);
	}

	private void initEmploymentIntention() {
		propertyDomain = addPropertyDomain(PropertyTypes.EMPLOYMENTINTENTION,
				false, null);
		addPropertyDict("社会招聘", 0, 1);
		addPropertyDict("公益性岗位", 0, 2);
		addPropertyDict("自谋职业", 0, 3);
		addPropertyDict("自主创业", 0, 4);
		addPropertyDict("其他就业", 0, 5);
	}

	private void initTrainingIntention() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAININGINTENTION,
				false, null);
		addPropertyDict("技能培训", 0, 1);
		addPropertyDict("劳动预备制培训", 0, 2);
		addPropertyDict("创业培训", 0, 3);
		addPropertyDict("自主创业", 0, 4);
	}

	private void initPublicPlaceCloakRomm() {
		propertyDomain = addPropertyDomain(PropertyTypes.PUBLICPLACE_CLOAKROOM,
				false, null);
		addPropertyDict("是", 0, 1);
		addPropertyDict("否", 0, 2);

	}

	/**
	 * 实有单位数据字典开始
	 */
	private void initECONOMICNATURE() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ACTUALCOMPANY_ECONOMICNATURE, false, null);
		addPropertyDict("非公司企业法人", 0, 1);
		addPropertyDict("有限责任公司", 0, 2);
		addPropertyDict("股份有限责任公司", 0, 3);
		addPropertyDict("个体工商户", 0, 4);
		addPropertyDict("私营独资企业", 0, 5);
		addPropertyDict("私营合伙企业", 0, 6);
	}

	private void initFIREFIGHTINGLEVEL() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ACTUALCOMPANY_FIREFIGHTINGLEVEL, false, null);
		addPropertyDict("一级", 0, 1);
		addPropertyDict("二级", 0, 2);
		addPropertyDict("三级", 0, 3);
		addPropertyDict("四级", 0, 4);
	}

	private void initSECURITYCLASSIFICATION() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ACTUALCOMPANY_SECURITYCLASSIFICATION, false, null);
		addPropertyDict("BSS", 0, 1);
		addPropertyDict("OSS", 0, 2);
		addPropertyDict("MSS", 0, 3);
	}

	private void initSUPERVISORYLEVEL() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ACTUALCOMPANY_SUPERVISORYLEVEL, false, null);
		addPropertyDict("A级", 0, 1);
		addPropertyDict("B级", 0, 2);
		addPropertyDict("C级", 0, 3);
	}

	private void initCOMPANYTYPE() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ACTUALCOMPANY_COMPANYTYPE, false, null);
		addPropertyDict("国有企业", 0, 1);
		addPropertyDict("国有控股企业", 0, 2);
		addPropertyDict("外资企业", 0, 3);
		addPropertyDict("合资企业", 0, 4);
		addPropertyDict("私营企业", 0, 5);
		addPropertyDict("事业单位", 0, 6);
		addPropertyDict("国家行政机关", 0, 7);
		addPropertyDict("政府", 0, 8);
	}

	private void initFHOUSEMARCHTYPE() {
		propertyDomain = addPropertyDomain(PropertyTypes.HOUSE_MARCH_TYPE,
				false, null);
		addPropertyDict("五好家庭", 0, 1);
		addPropertyDict("平安家庭", 0, 2);
	}

	/**
	 * 民情日志数据字典
	 */
	private void initLogType() {
		propertyDomain = addPropertyDomain(PropertyTypes.PEOPLELOG_LOGTYPE,
				false, null);
		addPropertyDict("管理服务", 0, 1);
		addPropertyDict("日常走访", 0, 2);
		addPropertyDict("工作记录", 0, 3);
		addPropertyDict("其他", 0, 4);
	}

	private void initSUBJECTION() {
		propertyDomain = addPropertyDomain(PropertyTypes.INCIDENT_SUBJECTION,
				false, null);
		addPropertyDict("自然灾害", 0, 1);
		addPropertyDict("事故灾害", 0, 2);
		addPropertyDict("公共卫生事件", 0, 3);
		addPropertyDict("社会安全事件", 0, 4);
		addPropertyDict("大型活动", 0, 5);
	}

	private void initDEGREE() {
		propertyDomain = addPropertyDomain(PropertyTypes.INCIDENT_DEGREE,
				false, IncidentDegreeSituation.getInternalProperties());
		addPropertyDict("I级", IncidentDegreeSituation.FIRET_DEGREE, 1);
		addPropertyDict("II级", IncidentDegreeSituation.SECOND_DEGREE, 2);
		addPropertyDict("III级", IncidentDegreeSituation.THRID_DEGREE, 3);
		addPropertyDict("IV级", IncidentDegreeSituation.FOURTH_DEGREE, 4);

	}

	private void initSourcePoolType() {
		propertyDomain = addPropertyDomain(
				SourceType.DAILY_DIRECTORY_TYPES_KEY, true, SourceType
						.getInternalProperties());

		addPropertyDict(SourceType.LAW_REGULATION, SourceType.LAW, 1);
		addPropertyDict(SourceType.RULE_REGULATION, SourceType.RULE, 2);
		addPropertyDict(SourceType.POLICY_DOCUMENT, SourceType.POLICY, 3);
		addPropertyDict(SourceType.EXPERIENCE_MATERIAL, SourceType.EXPERIENCE,
				4);
		addPropertyDict(SourceType.RESEARCH_REPORT, SourceType.RESEARCH, 5);
		addPropertyDict(SourceType.BRIEFINGS, SourceType.BRIEFING, 6);
	}

	private void initWorkingRecordType() {
		propertyDomain = addPropertyDomain(
				WorkingRecordTypes.WORKING_RECORD_TYPES_KEY, true,
				WorkingRecordTypes.getInternalProperties());

		addPropertyDict(WorkingRecordTypes.MEETING_RECORD_NAME,
				WorkingRecordTypes.MEETING_RECORD, 1);
		addPropertyDict(WorkingRecordTypes.FILE_NAME, WorkingRecordTypes.FILE,
				2);
		addPropertyDict(WorkingRecordTypes.ACTIVITY_RECORD_NAME,
				WorkingRecordTypes.ACTIVITY_RECORD, 3);
		addPropertyDict(WorkingRecordTypes.DOCUMENT_NAME,
				WorkingRecordTypes.DOCUMENT, 4);
		addPropertyDict(WorkingRecordTypes.OTHER_NAME,
				WorkingRecordTypes.OTHER, 5);
	}

	private void initWorkBenchType() {
		propertyDomain = addPropertyDomain(PropertyTypes.WORKBENCH_TYPE, false,
				null);
		addPropertyDict(WorkBenchType.SUPER_LEVEL_NAME,
				WorkBenchType.SUPER_LEVEL, 1);
		addPropertyDict(WorkBenchType.MIDDLE_LEVEL_NAME,
				WorkBenchType.MIDDLE_LEVEL, 2);
		addPropertyDict(WorkBenchType.LOWER_LEVEL_NAME,
				WorkBenchType.LOWER_LEVEL, 3);
	}

	/**
	 * 数据来源字典项
	 */
	private void initDataFrom() {
		propertyDomain = addPropertyDomain(DataFromTypes.DATAFROM_TYPES_KEY,
				false, null);
		addPropertyDict(DataFromTypes.ENTRY_DATA_NAME, 0,
				DataFromTypes.ENTRY_DATA_SEQ);
		addPropertyDict(DataFromTypes.MODE_IMPORT_NAME, 0,
				DataFromTypes.MODE_IMPORT_SEQ);
		addPropertyDict(DataFromTypes.HOUSEHOLD_IMPORT_NAME, 0,
				DataFromTypes.HOUSEHOLD_IMPORT_SEQ);
		addPropertyDict(DataFromTypes.FLOATINGPOPULATION_IMPORT_NAME, 0,
				DataFromTypes.FLOATINGPOPULATION_IMPORT_SEQ);
		addPropertyDict(DataFromTypes.ACTUALHOUSE_IMPORT_NAME, 0,
				DataFromTypes.ACTUALHOUSE_IMPORT_SEQ);
		addPropertyDict(DataFromTypes.DATA_CLAIM_NAME, 0,
				DataFromTypes.DATA_CLAIM_SEQ);
		addPropertyDict(DataFromTypes.DATA_CHECK_CLAIM_NAME, 0,
				DataFromTypes.DATA_CHECK_CLAIM_SEQ);
	}

	private void initBuilddatasType() {
		propertyDomain = addPropertyDomain(PropertyTypes.BUILDDATAS_TYPE,
				false, null);
		addPropertyDict("普通住宅", BuildDatasType.COMMON_BUILD, 1);
		addPropertyDict("商铺", BuildDatasType.STORE, 2);
		addPropertyDict("写字楼", BuildDatasType.OFFICE_BUILDING, 3);
		addPropertyDict("高层建筑", BuildDatasType.HIGH_BUILDING, 4);
		addPropertyDict("其他", BuildDatasType.OTHER_BUILDING, 5);
	}

	private void initAttentionExtent() {
		propertyDomain = addPropertyDomain(PropertyTypes.ATTENTION_EXTENT,
				false, null);
		addPropertyDict("一般", 0, 1);
		addPropertyDict("中等", 0, 2);
		addPropertyDict("严重", 0, 3);
	}

	private void initPositions() {
		propertyDomain = addPropertyDomain(PropertyTypes.POSITION, false, null);
		addPropertyDict("村干部", 0, 1);
		addPropertyDict("镇(街道)干部", 1, 2);
	}

	private void initPartType() {
		propertyDomain = addPropertyDomain(PropertyTypesYinchuan.PART_TYPE,
				false, null);
		addPropertyDict("公共设施类", PartType.PUBLIC_FACILITIES, 1);
		addPropertyDict("道路交通类", PartType.ROAD_TRAFFIC, 2);
		addPropertyDict("市容环境类", PartType.CITY_ENVIRONMENT, 3);
		addPropertyDict("园林绿化类", PartType.LANDSCAPING, 4);
		addPropertyDict("房屋土地类", PartType.HOUSELAND, 5);
		addPropertyDict("其他设施类", PartType.OTHER_FACILITIES, 6);
		addPropertyDict("扩展部件类", PartType.EXPANSION_COMPONENTS, 7);
	}

	private void initPartName() {
		propertyDomain = addPropertyDomain(PropertyTypesYinchuan.PART_NAME,
				false, null);
		addPropertyDict("上水井盖", PartType.PUBLIC_FACILITIES, 1);
		addPropertyDict("污水井盖", PartType.PUBLIC_FACILITIES, 2);
		addPropertyDict("雨水井盖", PartType.PUBLIC_FACILITIES, 3);
		addPropertyDict("雨水算子", PartType.PUBLIC_FACILITIES, 4);
		addPropertyDict("电力井盖", PartType.PUBLIC_FACILITIES, 5);
		addPropertyDict("路灯井盖", PartType.PUBLIC_FACILITIES, 6);
		addPropertyDict("通讯井盖", PartType.PUBLIC_FACILITIES, 7);
		addPropertyDict("电视井盖", PartType.PUBLIC_FACILITIES, 8);
		addPropertyDict("网络井盖", PartType.PUBLIC_FACILITIES, 9);
		addPropertyDict("热力井盖", PartType.PUBLIC_FACILITIES, 10);
		addPropertyDict("燃气井盖", PartType.PUBLIC_FACILITIES, 11);
		addPropertyDict("公安井盖", PartType.PUBLIC_FACILITIES, 12);
		addPropertyDict("消防设施", PartType.PUBLIC_FACILITIES, 13);
		addPropertyDict("无主井盖", PartType.PUBLIC_FACILITIES, 14);
		addPropertyDict("通讯交接箱", PartType.PUBLIC_FACILITIES, 15);
		addPropertyDict("电力设施", PartType.PUBLIC_FACILITIES, 16);
		addPropertyDict("立杆", PartType.PUBLIC_FACILITIES, 17);
		addPropertyDict("路灯", PartType.PUBLIC_FACILITIES, 18);
		addPropertyDict("地灯", PartType.PUBLIC_FACILITIES, 19);
		addPropertyDict("景观灯", PartType.PUBLIC_FACILITIES, 20);
		addPropertyDict("报刊亭", PartType.PUBLIC_FACILITIES, 21);
		addPropertyDict("电话亭", PartType.PUBLIC_FACILITIES, 22);
		addPropertyDict("邮筒", PartType.PUBLIC_FACILITIES, 23);
		addPropertyDict("信息亭", PartType.PUBLIC_FACILITIES, 24);
		addPropertyDict("自动售货机", PartType.PUBLIC_FACILITIES, 25);
		addPropertyDict("健身设施", PartType.PUBLIC_FACILITIES, 26);
		addPropertyDict("中水井盖", PartType.PUBLIC_FACILITIES, 27);
		addPropertyDict("公交井盖", PartType.PUBLIC_FACILITIES, 28);
		addPropertyDict("输油（气）井盖", PartType.PUBLIC_FACILITIES, 29);
		addPropertyDict("特殊井盖", PartType.PUBLIC_FACILITIES, 30);
		addPropertyDict("民用水井", PartType.PUBLIC_FACILITIES, 31);
		addPropertyDict("供水器", PartType.PUBLIC_FACILITIES, 32);
		addPropertyDict("高压线铁塔", PartType.PUBLIC_FACILITIES, 33);
		addPropertyDict("变压器（箱）", PartType.PUBLIC_FACILITIES, 34);
		addPropertyDict("燃气调压站（箱）", PartType.PUBLIC_FACILITIES, 35);
		addPropertyDict("监控电子眼", PartType.PUBLIC_FACILITIES, 36);
		addPropertyDict("售货亭", PartType.PUBLIC_FACILITIES, 37);
		addPropertyDict("治安岗亭", PartType.PUBLIC_FACILITIES, 38);
		addPropertyDict("停车场", PartType.ROAD_TRAFFIC, 39);
		addPropertyDict("停车咪表", PartType.ROAD_TRAFFIC, 40);
		addPropertyDict("公交站亭", PartType.ROAD_TRAFFIC, 41);
		addPropertyDict("出租车站牌", PartType.ROAD_TRAFFIC, 42);
		addPropertyDict("过街天桥", PartType.ROAD_TRAFFIC, 43);
		addPropertyDict("地下通道", PartType.ROAD_TRAFFIC, 44);
		addPropertyDict("高架立交桥", PartType.ROAD_TRAFFIC, 45);
		addPropertyDict("跨河桥", PartType.ROAD_TRAFFIC, 46);
		addPropertyDict("交通标志牌", PartType.ROAD_TRAFFIC, 47);
		addPropertyDict("交通信号灯", PartType.ROAD_TRAFFIC, 48);
		addPropertyDict("交通护栏", PartType.ROAD_TRAFFIC, 49);
		addPropertyDict("存车支架", PartType.ROAD_TRAFFIC, 50);
		addPropertyDict("路名牌", PartType.ROAD_TRAFFIC, 51);
		addPropertyDict("交通信号设施", PartType.ROAD_TRAFFIC, 52);
		addPropertyDict("道路信息显示屏", PartType.ROAD_TRAFFIC, 53);
		addPropertyDict("道路隔音屏", PartType.ROAD_TRAFFIC, 54);
		addPropertyDict("交通岗亭", PartType.ROAD_TRAFFIC, 55);
		addPropertyDict("公共厕所", PartType.CITY_ENVIRONMENT, 56);
		addPropertyDict("化粪池", PartType.CITY_ENVIRONMENT, 57);
		addPropertyDict("公厕指示牌", PartType.CITY_ENVIRONMENT, 58);
		addPropertyDict("垃圾间（楼）", PartType.CITY_ENVIRONMENT, 59);
		addPropertyDict("垃圾箱", PartType.CITY_ENVIRONMENT, 60);
		addPropertyDict("灯箱霓虹灯", PartType.CITY_ENVIRONMENT, 61);
		addPropertyDict("广告牌匾", PartType.CITY_ENVIRONMENT, 62);
		addPropertyDict("环保监测站", PartType.CITY_ENVIRONMENT, 63);
		addPropertyDict("气象监测站", PartType.CITY_ENVIRONMENT, 64);
		addPropertyDict("污水口监测站", PartType.CITY_ENVIRONMENT, 65);
		addPropertyDict("噪声显示屏", PartType.CITY_ENVIRONMENT, 66);
		addPropertyDict("古树名木", PartType.LANDSCAPING, 67);
		addPropertyDict("行道树", PartType.LANDSCAPING, 68);
		addPropertyDict("护树设施", PartType.LANDSCAPING, 69);
		addPropertyDict("花架花钵", PartType.LANDSCAPING, 70);
		addPropertyDict("绿地", PartType.LANDSCAPING, 71);
		addPropertyDict("雕塑", PartType.LANDSCAPING, 72);
		addPropertyDict("街头坐椅", PartType.LANDSCAPING, 73);
		addPropertyDict("绿地护栏", PartType.LANDSCAPING, 74);
		addPropertyDict("绿地维护设施", PartType.LANDSCAPING, 75);
		addPropertyDict("喷泉", PartType.LANDSCAPING, 76);
		addPropertyDict("宣传栏", PartType.HOUSELAND, 77);
		addPropertyDict("人防工事", PartType.HOUSELAND, 78);
		addPropertyDict("公房地下室", PartType.HOUSELAND, 79);
		addPropertyDict("重大危险源", PartType.OTHER_FACILITIES, 80);
		addPropertyDict("工地", PartType.OTHER_FACILITIES, 81);
		addPropertyDict("水域附属设施", PartType.OTHER_FACILITIES, 82);
		addPropertyDict("水域护栏", PartType.OTHER_FACILITIES, 83);
		addPropertyDict("港监设施", PartType.OTHER_FACILITIES, 84);
		addPropertyDict("防汛墙", PartType.OTHER_FACILITIES, 85);
		addPropertyDict("屋（楼）顶广告", PartType.EXPANSION_COMPONENTS, 86);
		addPropertyDict("墙面广告", PartType.EXPANSION_COMPONENTS, 87);
		addPropertyDict("高立柱（擎天柱）广告", PartType.EXPANSION_COMPONENTS, 88);
		addPropertyDict("大型支架广告", PartType.EXPANSION_COMPONENTS, 89);
		addPropertyDict("跨街桥梁广告", PartType.EXPANSION_COMPONENTS, 90);
		addPropertyDict("围墙（栏）广告", PartType.EXPANSION_COMPONENTS, 91);
		addPropertyDict("小型立式广告", PartType.EXPANSION_COMPONENTS, 92);
		addPropertyDict("悬挂广告", PartType.EXPANSION_COMPONENTS, 93);
		addPropertyDict("牌匾标识", PartType.EXPANSION_COMPONENTS, 94);
		addPropertyDict("街路", PartType.EXPANSION_COMPONENTS, 95);
		addPropertyDict("巷道", PartType.EXPANSION_COMPONENTS, 96);
		addPropertyDict("无名街巷", PartType.EXPANSION_COMPONENTS, 97);
		addPropertyDict("在建道路", PartType.EXPANSION_COMPONENTS, 98);
		addPropertyDict("便道", PartType.EXPANSION_COMPONENTS, 99);
		addPropertyDict("公交调度站亭", PartType.EXPANSION_COMPONENTS, 100);
		addPropertyDict("食品销售亭", PartType.EXPANSION_COMPONENTS, 101);
		addPropertyDict("菜篮子销售亭", PartType.EXPANSION_COMPONENTS, 102);
		addPropertyDict("停车场看护亭", PartType.EXPANSION_COMPONENTS, 103);
		addPropertyDict("园林井盖", PartType.EXPANSION_COMPONENTS, 104);
		addPropertyDict("大门", PartType.EXPANSION_COMPONENTS, 105);
		addPropertyDict("门牌", PartType.EXPANSION_COMPONENTS, 106);
		addPropertyDict("跨河管道", PartType.EXPANSION_COMPONENTS, 107);
		addPropertyDict("示范街牌", PartType.EXPANSION_COMPONENTS, 108);
		addPropertyDict("果皮箱", PartType.EXPANSION_COMPONENTS, 109);
		addPropertyDict("垃圾中转站", PartType.EXPANSION_COMPONENTS, 110);
		addPropertyDict("单位指示牌", PartType.EXPANSION_COMPONENTS, 111);
		addPropertyDict("自行车停车场", PartType.EXPANSION_COMPONENTS, 112);
		addPropertyDict("自助取款机", PartType.EXPANSION_COMPONENTS, 113);
		addPropertyDict("自助售电机", PartType.EXPANSION_COMPONENTS, 114);
		addPropertyDict("台阶", PartType.EXPANSION_COMPONENTS, 115);
		addPropertyDict("旅游设施", PartType.EXPANSION_COMPONENTS, 116);
		addPropertyDict("文物保护设施", PartType.EXPANSION_COMPONENTS, 117);
		addPropertyDict("水域标示牌", PartType.EXPANSION_COMPONENTS, 118);
		addPropertyDict("张贴栏", PartType.EXPANSION_COMPONENTS, 119);
		addPropertyDict("减速带", PartType.EXPANSION_COMPONENTS, 120);
		addPropertyDict("防撞柱", PartType.EXPANSION_COMPONENTS, 121);
		addPropertyDict("充电桩", PartType.EXPANSION_COMPONENTS, 122);
		addPropertyDict("交通隔离墩", PartType.EXPANSION_COMPONENTS, 123);
		addPropertyDict("公用旗杆", PartType.EXPANSION_COMPONENTS, 124);
		addPropertyDict("单位旗杆", PartType.EXPANSION_COMPONENTS, 125);
		addPropertyDict("盲道", PartType.EXPANSION_COMPONENTS, 126);
		addPropertyDict("小公园", PartType.EXPANSION_COMPONENTS, 127);
		addPropertyDict("铁道口设施", PartType.EXPANSION_COMPONENTS, 128);
		addPropertyDict("自行车租赁点", PartType.EXPANSION_COMPONENTS, 129);
		addPropertyDict("公交站牌", PartType.EXPANSION_COMPONENTS, 130);
		addPropertyDict("射灯", PartType.EXPANSION_COMPONENTS, 131);
		addPropertyDict("无障碍设施指示牌", PartType.EXPANSION_COMPONENTS, 132);
		addPropertyDict("公安指示牌", PartType.EXPANSION_COMPONENTS, 133);
		addPropertyDict("电信电力指示牌", PartType.EXPANSION_COMPONENTS, 134);
	}

	private void initPersonTypes() {
		propertyDomain = addPropertyDomain(PropertyTypes.PERSON_TYPES, false,
				null);
		addPropertyDict("未知", 0, 1);
		addPropertyDict("社区后备干部", 0, 2);
		addPropertyDict("正式党员", 0, 3);
		addPropertyDict("积极分子", 0, 4);
		addPropertyDict("党员干部", 0, 5);
		addPropertyDict("村后备干部", 0, 6);
		addPropertyDict("预备党员", 0, 7);
		addPropertyDict("村老干部", 0, 8);
		addPropertyDict("其他", 0, 9);
	}

	private void initBoundType() {
		propertyDomain = addPropertyDomain(PropertyTypes.BOUNDTYPE, false, null);
		addPropertyDict("绑定房屋", 0, 1);
		addPropertyDict("绑定地图", 0, 2);
	}

	private void initViolationsOfTheLaw() {
		// 违法情况

		propertyDomain = addPropertyDomain(PropertyTypes.VIOLATIONSOFTHELAW,
				false, null);
		addPropertyDict("扰乱公共秩序", 0, 1);
		addPropertyDict("妨害公共安全", 0, 2);
		addPropertyDict("侵犯人身权利、财产权利", 0, 3);
		addPropertyDict("妨害社会管理", 0, 4);
		addPropertyDict("具有社会危害性", 0, 5);
		addPropertyDict("无", 0, 6);
	}

	private void initCrimeType() {
		// 犯罪类型

		propertyDomain = addPropertyDomain(PropertyTypes.CRIMETYPE, false, null);
		addPropertyDict("危害国家安全罪", 0, 1);
		addPropertyDict("危害公共安全罪", 0, 2);
		addPropertyDict("破坏社会主义市场经济秩序罪", 0, 3);
		addPropertyDict("侵犯公民人身权利、民主权利罪", 0, 4);
		addPropertyDict("侵犯财产罪", 0, 5);
		addPropertyDict("妨害社会管理秩序罪", 0, 6);
		addPropertyDict("危害国防利益罪", 0, 7);
		addPropertyDict("贪污贿赂罪", 0, 8);
		addPropertyDict("渎职罪", 0, 9);
		addPropertyDict("无", 0, 10);

	}

	private void initPsychosisType() {
		// 精神病类型

		propertyDomain = addPropertyDomain(PropertyTypes.PSYCHOSIS_TYPES,
				false, null);
		addPropertyDict("易肇事肇祸精神病", 0, 1);
		addPropertyDict("间歇性精神病", 0, 2);
	}

	private void initScenicEquipType() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCENICEQUIP_TYPES,
				false, null);
		addPropertyDict("景区餐馆", 0, 1);
		addPropertyDict("景区宾馆", 0, 2);
		addPropertyDict("景区购物点", 0, 3);
		addPropertyDict("娱乐设施", 0, 4);
		addPropertyDict("自驾车宿营地", 0, 5);
	}

	private void initScenicTrafficType() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCENICTRAFFIC_TYPES,
				false, null);
		addPropertyDict("公交", 0, 1);
		addPropertyDict("自行车", 0, 2);
		addPropertyDict("游船", 0, 3);
		addPropertyDict("其他", 0, 4);
	}

	private void initPraiseScenicSpotType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.PRAISESCENICSPOT_TYPES, false, null);
		addPropertyDict("咨询", 0, 1);
		addPropertyDict("表扬", 0, 2);
		addPropertyDict("投诉", 0, 3);
	}

	private void initItemName() {
		propertyDomain = addPropertyDomain(PropertyTypes.ITEM_NAME, false, null);
		addPropertyDict("企业投资建设项目", 0, 1);
		addPropertyDict("外商投资项目核准", 1, 2);
		addPropertyDict("固定资产投资项目", 2, 3);
		addPropertyDict("设立民办学校审批", 3, 4);
	}

	private void initTreatmentState() {
		propertyDomain = addPropertyDomain(PropertyTypes.TREATMENTSTATE, false,
				null);
		addPropertyDict("已康复", 0, 1);
		addPropertyDict("治疗中", 1, 2);
	}

	private void initPublicComplexPlacesType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.PUBLICCOMPLEXPLACES_TYPE, false, null);
		addPropertyDict("公共娱乐场所", PublicComplexPlacesType.PUBLIC_AMENITIES, 1);
		addPropertyDict("景点", PublicComplexPlacesType.SCENIC_SPOTS, 2);
		addPropertyDict("车站码头", PublicComplexPlacesType.STATION_WHARF, 3);
		addPropertyDict("市场", PublicComplexPlacesType.MARKET_PLACE, 4);

	}

	private void initPublicComplexPlacesDetailedType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.PUBLICCOMPLEXPLACES_DETAILEDTYPE, false, null);
		addPropertyDict("KTV", PublicComplexPlacesType.PUBLIC_AMENITIES, 1);
		addPropertyDict("舞厅", PublicComplexPlacesType.PUBLIC_AMENITIES, 2);
		addPropertyDict("迪吧", PublicComplexPlacesType.PUBLIC_AMENITIES, 3);
		addPropertyDict("酒吧", PublicComplexPlacesType.PUBLIC_AMENITIES, 4);
		addPropertyDict("网吧", PublicComplexPlacesType.PUBLIC_AMENITIES, 5);
		addPropertyDict("球馆", PublicComplexPlacesType.PUBLIC_AMENITIES, 6);
		addPropertyDict("电玩", PublicComplexPlacesType.PUBLIC_AMENITIES, 7);
		addPropertyDict("棋牌室", PublicComplexPlacesType.PUBLIC_AMENITIES, 8);
		addPropertyDict("其他", PublicComplexPlacesType.PUBLIC_AMENITIES, 9);
		addPropertyDict("商场", PublicComplexPlacesType.MARKET_PLACE, 10);
		addPropertyDict("超市", PublicComplexPlacesType.MARKET_PLACE, 11);
		addPropertyDict("菜市场", PublicComplexPlacesType.MARKET_PLACE, 12);
		addPropertyDict("其它", PublicComplexPlacesType.MARKET_PLACE, 13);
	}

	private void initYouthAges() {
		propertyDomain = addPropertyDomain(PropertyTypes.YOUTH_AGES, false,
				null);
		addPropertyDict("0~6岁", 0, 1);
		addPropertyDict("6~14岁", 1, 2);
		addPropertyDict("14~18岁", 2, 3);
		addPropertyDict("18~28岁", 3, 4);
		addPropertyDict("28~35岁", 4, 5);
	}

	private void initReportDateType() {
		propertyDomain = addPropertyDomain(PropertyTypes.REPORT_DATE_TYPE,
				false, null);
		addPropertyDict("按月份统计", ReportDateType.GROUPBYMONTH, 1);
		addPropertyDict("按季度统计", ReportDateType.GROUPBYQUARTER, 2);
		addPropertyDict("按年度统计", ReportDateType.GROUPBYYEAR, 3);
	}

	private void initFunctionalOrgType() {
		propertyDomain = addPropertyDomain(PropertyTypes.FUNCTIONAL_ORG_TYPE,
				false, null);
		addPropertyDict("经信部门", 0, 1);
		addPropertyDict("民政部门", 0, 2);
		addPropertyDict("公安部门", 0, 3);
		addPropertyDict("司法部门", 0, 4);
		addPropertyDict("工商部门", 0, 5);
		addPropertyDict("信访部门", 0, 6);
		addPropertyDict("计生部门", 0, 7);
		addPropertyDict("安监部门", 0, 8);
		addPropertyDict("城管部门", 0, 9);
		addPropertyDict("卫生部门", 0, 10);
		addPropertyDict("国土部门", 0, 11);
		addPropertyDict("环保部门", 0, 12);
		addPropertyDict("药监部门", 0, 13);
		addPropertyDict("团委", 0, 14);
		addPropertyDict("人社部门", 0, 15);
		addPropertyDict("住建部门", 0, 16);
		addPropertyDict("教育部门", 0, 17);
		addPropertyDict("残联", 0, 18);
		addPropertyDict("文广新局", 0, 19);
	}

	private void initUrgentLevelProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.URGENT_LEVEL, false,
				null);
		addPropertyDict("低", 0, 1);
		addPropertyDict("中", 1, 2);
		addPropertyDict("高", 2, 3);
	}

	private void initPositionOrStatus() {
		propertyDomain = addPropertyDomain(PropertyTypes.POSITION_OR_STATUS,
				false, null);
		addPropertyDict("教师", 0, 1);
		addPropertyDict("医生", 1, 2);
		addPropertyDict("公务人员", 2, 3);
		addPropertyDict("企业人员", 3, 4);
		addPropertyDict("学生", 4, 5);
		addPropertyDict("城镇居民", 5, 6);
		addPropertyDict("在家农民", 6, 7);
		addPropertyDict("外出农民", 7, 8);
		addPropertyDict("其他", 8, 9);

	}

	private void initAppealHumanType() {
		propertyDomain = addPropertyDomain(PropertyTypes.APPEAL_HUMAN_TYPE,
				false, null);
		addPropertyDict("反应人", 0, 1);
		addPropertyDict("反应群体代表", 1, 2);
	}

	private void initItemCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.ITEM_CATEGORY, false,
				null);
		addPropertyDict("水利类", ItemCategory.WATER_RESOURCE, 1);
		addPropertyDict("交通类", ItemCategory.TRAFFIC_CATEGORIES, 2);
		addPropertyDict("能源类", ItemCategory.ENERGY_SOURCES, 3);
		addPropertyDict("教育科技类", ItemCategory.EDUCATION_TECHNOLOGY, 4);
		addPropertyDict("文体类", ItemCategory.GENRE_CLASS, 5);
		addPropertyDict("医疗卫生", ItemCategory.HEALTH_CARE, 6);
		addPropertyDict("劳动和社会保障", ItemCategory.LABOUR_SOCIAL_PROTECTION, 7);
		addPropertyDict("环境保护类", ItemCategory.ENVIRONMENT_PROTECTION, 8);
		addPropertyDict("城乡规划建设管理类",
				ItemCategory.URBAN_RURAL_PLANNING_CONSTRUCTION, 9);
		addPropertyDict("农业类", ItemCategory.AGRICULTURE_RELATED_SCIENCES, 10);
	}

	public void initItemCategorySub() {
		propertyDomain = addPropertyDomain(PropertyTypes.ITEM_CATEGORY_SUB,
				false, null);
		addPropertyDict("饮水工程", ItemCategory.WATER_RESOURCE, 1);
		addPropertyDict("山坪塘", ItemCategory.WATER_RESOURCE, 2);
		addPropertyDict("蓄水池", ItemCategory.WATER_RESOURCE, 3);
		addPropertyDict("水窖", ItemCategory.WATER_RESOURCE, 4);
		addPropertyDict("提灌站", ItemCategory.WATER_RESOURCE, 5);
		addPropertyDict("渠道", ItemCategory.WATER_RESOURCE, 6);
		addPropertyDict("中小河流治理", ItemCategory.WATER_RESOURCE, 7);
		addPropertyDict("水利-其他", ItemCategory.WATER_RESOURCE, 8);

		addPropertyDict("道路建设", ItemCategory.TRAFFIC_CATEGORIES, 9);
		addPropertyDict("道路维护", ItemCategory.TRAFFIC_CATEGORIES, 10);
		addPropertyDict("桥梁建设", ItemCategory.TRAFFIC_CATEGORIES, 11);
		addPropertyDict("桥梁维护", ItemCategory.TRAFFIC_CATEGORIES, 12);
		addPropertyDict("安全设施工程", ItemCategory.TRAFFIC_CATEGORIES, 13);
		addPropertyDict("客运", ItemCategory.TRAFFIC_CATEGORIES, 14);
		addPropertyDict("交通-其它", ItemCategory.TRAFFIC_CATEGORIES, 15);

		addPropertyDict("电力", ItemCategory.ENERGY_SOURCES, 16);
		addPropertyDict("沼气", ItemCategory.ENERGY_SOURCES, 17);
		addPropertyDict("太阳能", ItemCategory.ENERGY_SOURCES, 18);
		addPropertyDict("石油液化气", ItemCategory.ENERGY_SOURCES, 19);
		addPropertyDict("汽柴油", ItemCategory.ENERGY_SOURCES, 20);
		addPropertyDict("煤碳", ItemCategory.ENERGY_SOURCES, 21);

		addPropertyDict("教育设施建设", ItemCategory.EDUCATION_TECHNOLOGY, 22);
		addPropertyDict("就学", ItemCategory.EDUCATION_TECHNOLOGY, 23);
		addPropertyDict("科技", ItemCategory.EDUCATION_TECHNOLOGY, 24);
		addPropertyDict("科协", ItemCategory.EDUCATION_TECHNOLOGY, 25);
		addPropertyDict("教育-其它", ItemCategory.EDUCATION_TECHNOLOGY, 26);

		addPropertyDict("广播电视", ItemCategory.GENRE_CLASS, 27);
		addPropertyDict("旅游", ItemCategory.GENRE_CLASS, 28);
		addPropertyDict("文化", ItemCategory.GENRE_CLASS, 29);
		addPropertyDict("体育", ItemCategory.GENRE_CLASS, 30);

		addPropertyDict("医疗服务", ItemCategory.HEALTH_CARE, 31);
		addPropertyDict("食品卫生", ItemCategory.HEALTH_CARE, 32);
		addPropertyDict("公共卫生服务", ItemCategory.HEALTH_CARE, 33);
		addPropertyDict("新农合", ItemCategory.HEALTH_CARE, 34);
		addPropertyDict("服务能力建设", ItemCategory.HEALTH_CARE, 35);
		addPropertyDict("医疗-其他", ItemCategory.HEALTH_CARE, 36);

		addPropertyDict("就业", ItemCategory.LABOUR_SOCIAL_PROTECTION, 37);
		addPropertyDict("社会保障", ItemCategory.LABOUR_SOCIAL_PROTECTION, 38);
		addPropertyDict("农民工工资", ItemCategory.LABOUR_SOCIAL_PROTECTION, 39);
		addPropertyDict("社保-其他", ItemCategory.LABOUR_SOCIAL_PROTECTION, 40);

		addPropertyDict("工业企业", ItemCategory.ENVIRONMENT_PROTECTION, 41);
		addPropertyDict("农村环保", ItemCategory.ENVIRONMENT_PROTECTION, 42);
		addPropertyDict("生活污染源", ItemCategory.ENVIRONMENT_PROTECTION, 43);
		addPropertyDict("电磁辐射", ItemCategory.ENVIRONMENT_PROTECTION, 44);
		addPropertyDict("环境-其他", ItemCategory.ENVIRONMENT_PROTECTION, 45);

		addPropertyDict("城市管理", ItemCategory.URBAN_RURAL_PLANNING_CONSTRUCTION,
				46);
		addPropertyDict("城市街道", ItemCategory.URBAN_RURAL_PLANNING_CONSTRUCTION,
				47);
		addPropertyDict("市政公共设施",
				ItemCategory.URBAN_RURAL_PLANNING_CONSTRUCTION, 48);
		addPropertyDict("市政环卫", ItemCategory.URBAN_RURAL_PLANNING_CONSTRUCTION,
				49);
		addPropertyDict("村镇规划建设管理",
				ItemCategory.URBAN_RURAL_PLANNING_CONSTRUCTION, 50);
		addPropertyDict("住房保障", ItemCategory.URBAN_RURAL_PLANNING_CONSTRUCTION,
				51);
		addPropertyDict("建筑质量安全",
				ItemCategory.URBAN_RURAL_PLANNING_CONSTRUCTION, 52);
		addPropertyDict("城乡-其他",
				ItemCategory.URBAN_RURAL_PLANNING_CONSTRUCTION, 53);

		addPropertyDict("农业产业化", ItemCategory.AGRICULTURE_RELATED_SCIENCES, 54);
		addPropertyDict("田间工程", ItemCategory.AGRICULTURE_RELATED_SCIENCES, 55);
		addPropertyDict("农业培训", ItemCategory.AGRICULTURE_RELATED_SCIENCES, 56);
		addPropertyDict("农业-其它", ItemCategory.AGRICULTURE_RELATED_SCIENCES, 57);

	}

	public void initCreateTableType() {
		propertyDomain = addPropertyDomain(PropertyTypes.CREATE_TABLE_TYPE,
				false, null);
		addPropertyDict("新建", 0, 1);
		addPropertyDict("上年接转", 1, 2);
		addPropertyDict("其他台账转入", 2, 3);
		addPropertyDict("上级主管部门和市级领导班子有关领导交办(市级部门选填)", 3, 4);
		addPropertyDict("市委市政府及市级领导班子有关领导交办(乡镇选填)", 4, 5);
		addPropertyDict("市人大议案、建议、意见交办", 5, 6);
		addPropertyDict("市政协提案、建议、意见交办", 6, 7);

	}

	public void initPoorBigInfoType() {
		propertyDomain = addPropertyDomain(PropertyTypes.POORBIGINFO, false,
				null);
		addPropertyDict("生活", 0, 1);
		addPropertyDict("生产", 1, 2);
		addPropertyDict("医疗", 2, 3);
		addPropertyDict("住房", 3, 4);
		addPropertyDict("就学", 4, 5);
		addPropertyDict("就业", 5, 6);

	}

	public void initPoorInfType() {
		propertyDomain = addPropertyDomain(PropertyTypes.POORINFO, false, null);
		addPropertyDict("因病", 0, 1);
		addPropertyDict("因残", 0, 2);
		addPropertyDict("因灾", 0, 3);
		addPropertyDict("缺乏劳动能力", 0, 4);
		addPropertyDict("生活-其他", 0, 5);

		addPropertyDict("缺乏资金", 1, 6);
		addPropertyDict("缺乏技术", 1, 7);
		addPropertyDict("缺乏劳动力", 1, 8);
		addPropertyDict("生产-其他", 1, 9);

		addPropertyDict("重大疾病", 2, 10);
		addPropertyDict("医疗-其他", 2, 11);

		addPropertyDict("危房改造", 3, 12);
		addPropertyDict("水灾", 3, 13);
		addPropertyDict("地灾", 3, 14);
		addPropertyDict("火灾", 3, 15);
		addPropertyDict("贫困", 3, 16);
		addPropertyDict("住房-其他", 3, 17);

		addPropertyDict("学前教育", 4, 18);
		addPropertyDict("小学", 4, 19);
		addPropertyDict("初中", 4, 20);
		addPropertyDict("高中职高", 4, 21);
		addPropertyDict("大学", 4, 22);
		addPropertyDict("就学-其他", 4, 23);

		addPropertyDict("困难群体就业", 5, 24);
		addPropertyDict("新增就业", 5, 25);
		addPropertyDict("就业-其他", 5, 26);

	}

	public void initInsuranceType() {
		propertyDomain = addPropertyDomain(PropertyTypes.INSURANCETYPE, false,
				null);
		addPropertyDict("城镇低保", 0, 1);
		addPropertyDict("农村低保", 1, 2);
		addPropertyDict("农村五保", 2, 3);

	}

	public void initPositionorIdentityType() {
		propertyDomain = addPropertyDomain(PropertyTypes.POSITIONORIDENTITY,
				false, null);
		addPropertyDict("城镇居民", 0, 1);
		addPropertyDict("农民", 1, 2);
		addPropertyDict("企业人员", 2, 3);
		addPropertyDict("其他", 3, 4);

	}

	public void initInvolvingSteadyType() {
		propertyDomain = addPropertyDomain(PropertyTypes.INVOLVING_STEADY_TYPE,
				false, null);
		addPropertyDict("涉稳人", 0, 1);
		addPropertyDict("涉稳群体代表", 1, 2);
	}

	/**
	 * 基层党委组织类别
	 */
	private void initBasicLevelPartyType() {
		propertyDomain = addPropertyDomain(PropertyTypes.BASICLEVELPARTY_TYPE,
				false, null);
		addPropertyDict("区党委", 0, 1);
		addPropertyDict("镇党委", 0, 2);
		addPropertyDict("党支部", 0, 3);
	}

	/**
	 * 基层党委组织职务
	 */
	private void initBasicLevelPartyDuty() {
		propertyDomain = addPropertyDomain(PropertyTypes.BASICLEVELPARTYDUTY,
				false, null);
		addPropertyDict("书记", 0, 1);
		addPropertyDict("副书记", 0, 2);
		addPropertyDict("常委", 0, 3);
		addPropertyDict("委员", 0, 4);
	}

	/**
	 * 部门党委组织类别
	 */
	private void initDepartmentPartyType() {
		propertyDomain = addPropertyDomain(PropertyTypes.DEPARTMENTPARTY_TYPE,
				false, null);
		addPropertyDict("组织部", 0, 1);
		addPropertyDict("宣传部", 0, 2);
		addPropertyDict("统战部", 0, 3);
		addPropertyDict("政法委", 0, 4);
		addPropertyDict("防邪办", 0, 5);
		addPropertyDict("信访办", 0, 6);
		addPropertyDict("综治办", DepartmentPartyOrgType.MANAGEMENT_TYPE, 7);
		addPropertyDict("综治成员单位", 0, 8);
		addPropertyDict("专项工作领导小组", DepartmentPartyOrgType.LEADER_GROUP_TYPE, 9);
		addPropertyDict("综治委", 0, 10);
	}

	/**
	 * 部门党委组织职务
	 */
	private void initDepartmentPartyDuty() {
		propertyDomain = addPropertyDomain(PropertyTypes.DEPARTMENTPARTYDUTY,
				false, null);
		addPropertyDict("主任", 0, 1);
		addPropertyDict("副主任", 0, 2);
		addPropertyDict("委员", 0, 3);
		addPropertyDict("处长", 0, 4);
		addPropertyDict("科长", 0, 5);
	}

	/**
	 * 政府部门组织类别
	 */
	private void initGovernmentDepartmentType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.GOVERNMENTDEPARTMENT_TYPE, false, null);
		addPropertyDict("行政部门", 0, 1);
		addPropertyDict("发改局", 0, 2);
		addPropertyDict("经信局", 0, 3);
		addPropertyDict("教育局", 0, 4);
		addPropertyDict("公安局", 0, 5);
		addPropertyDict("民政局", 0, 6);
		addPropertyDict("司法局", 0, 7);
		addPropertyDict("人社局", 0, 8);
		addPropertyDict("国土局", 0, 9);
		addPropertyDict("环保局", 0, 10);
		addPropertyDict("住建局", 0, 11);
		addPropertyDict("交通局", 0, 12);
		addPropertyDict("水务局", 0, 13);
		addPropertyDict("农业局", 0, 14);
		addPropertyDict("林业局", 0, 15);
		addPropertyDict("商务局", 0, 16);
		addPropertyDict("文广新局", 0, 17);
		addPropertyDict("卫生局", 0, 18);
		addPropertyDict("计生局", 0, 19);
		addPropertyDict("工商局", 0, 20);
		addPropertyDict("质监局", 0, 21);
		addPropertyDict("安监局", 0, 22);
		addPropertyDict("旅游局", 0, 23);
		addPropertyDict("宗教局", 0, 24);
		addPropertyDict("城管局", 0, 25);
		addPropertyDict("食品药品监督管理局", 0, 26);
	}

	/**
	 * 政府部门组织职务
	 */
	private void initGovernmentDepartmentDuty() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.GOVERNMENTDEPARTMENTDUTY, false, null);
		addPropertyDict("县长", 0, 1);
		addPropertyDict("副县长", 0, 2);
		addPropertyDict("镇长", 0, 3);
		addPropertyDict("副镇长", 0, 4);
		addPropertyDict("局长", 0, 5);
		addPropertyDict("副局长", 0, 6);
		addPropertyDict("主任", 0, 7);
		addPropertyDict("副主任", 0, 8);
		addPropertyDict("处长", 0, 9);
		addPropertyDict("科长", 0, 10);
		addPropertyDict("科员", 0, 11);
	}

	/**
	 * 群团组织职务
	 */
	private void initMassOrgManagementDuty() {
		propertyDomain = addPropertyDomain(PropertyTypes.MASSORGMANAGEMENTDUTY,
				false, null);
		addPropertyDict("局长", 0, 1);
		addPropertyDict("副局长", 0, 2);
		addPropertyDict("主任", 0, 3);
		addPropertyDict("副主任", 0, 4);
		addPropertyDict("处长", 0, 5);
		addPropertyDict("科长", 0, 6);
		addPropertyDict("科员", 0, 7);
	}

	/**
	 * 诉求类别
	 */
	private void initAspirationType() {
		propertyDomain = addPropertyDomain(PropertyTypes.ASPIRATIONTYPE, false,
				null);
		addPropertyDict("党纪政纪", 0, 1);
		addPropertyDict("组织人事", 0, 2);
		addPropertyDict("涉法涉诉", 0, 3);
		addPropertyDict("土地、林权", 0, 4);
		addPropertyDict("征地拆迁", 0, 5);
		addPropertyDict("水利电力", 0, 6);
		addPropertyDict("环保", 0, 7);
		addPropertyDict("扶贫济困", 0, 8);
		addPropertyDict("惠农政策及村(社区)政务、财务", 0, 9);
		addPropertyDict("人口与医疗卫生", 0, 10);
		addPropertyDict("劳动保障", 0, 11);
		addPropertyDict("交通运输", 0, 12);
		addPropertyDict("城建", 0, 13);
		addPropertyDict("安全生产", 0, 14);
		addPropertyDict("旅游", 0, 15);
		addPropertyDict("教育", 0, 16);
		addPropertyDict("企业改制", 0, 17);
		addPropertyDict("移民", 0, 18);
		addPropertyDict("涉军", 0, 19);
		addPropertyDict("其他", 0, 20);
	}

	/**
	 * 所属部门
	 */
	private void initBelongOrg() {
		propertyDomain = addPropertyDomain(PropertyTypes.BELONG_ORG, false,
				null);
		addPropertyDict("区委办", 0, 1);
		addPropertyDict("人大办", 1, 2);
		addPropertyDict("政府办", 2, 3);
		addPropertyDict("政协办", 3, 4);
		addPropertyDict("纪委(监察局)", 4, 5);
		addPropertyDict("组织部(老干局)", 5, 6);
		addPropertyDict("宣传部", 6, 7);
		addPropertyDict("统战部", 7, 8);
		addPropertyDict("政法委", 8, 9);
		addPropertyDict("编办", 9, 10);
		addPropertyDict("机关工委", 10, 11);
		addPropertyDict("信访和群众工作局", 11, 22);
		addPropertyDict("党校", 12, 13);
		addPropertyDict("规服办", 13, 14);
		addPropertyDict("法院", 14, 15);
		addPropertyDict("检察院", 15, 16);
		addPropertyDict("发改局", 16, 17);
		addPropertyDict("物价局", 17, 18);
		addPropertyDict("教育局", 18, 19);
		addPropertyDict("经科局", 19, 20);
		addPropertyDict("民政局", 20, 21);
		addPropertyDict("司法局", 21, 22);
		addPropertyDict("财政局", 22, 23);
		addPropertyDict("人社局", 23, 24);
		addPropertyDict("环保局", 24, 25);
		addPropertyDict("建设局", 25, 26);
		addPropertyDict("房管局", 26, 27);
		addPropertyDict("城管局", 27, 28);
		addPropertyDict("交通市政局", 28, 29);
		addPropertyDict("统筹局", 29, 30);
		addPropertyDict("商务局", 30, 31);
		addPropertyDict("投促局", 31, 32);
		addPropertyDict("旅体局", 32, 33);
		addPropertyDict("卫生局", 33, 34);
		addPropertyDict("人口计生局", 34, 35);
		addPropertyDict("审计局", 35, 36);
		addPropertyDict("文广新局", 36, 37);
		addPropertyDict("安监局", 37, 38);
		addPropertyDict("统计局", 38, 39);
		addPropertyDict("公安分局", 39, 40);
		addPropertyDict("工商局", 40, 41);
		addPropertyDict("质监局", 41, 42);
		addPropertyDict("食药监局", 42, 43);
		addPropertyDict("国税局", 43, 44);
		addPropertyDict("地税局", 44, 45);
		addPropertyDict("国土分局", 45, 46);
		addPropertyDict("机关事务局", 46, 47);
		addPropertyDict("档案局", 47, 48);
		addPropertyDict("统建办", 48, 49);
		addPropertyDict("危改办", 49, 50);
		addPropertyDict("新客站商旅城管委会", 50, 51);
		addPropertyDict("龙潭总部经济城管委会", 51, 52);
		addPropertyDict("北湖管委会", 52, 53);
		addPropertyDict("北改办", 53, 54);
		addPropertyDict("建设路商圈推进办", 54, 55);
		addPropertyDict("昭觉寺推进办", 55, 56);
		addPropertyDict("工商联", 56, 57);
		addPropertyDict("总工会", 57, 58);
		addPropertyDict("妇联", 58, 59);
		addPropertyDict("团区委", 59, 60);
		addPropertyDict("残联", 60, 61);
		addPropertyDict("红十字会", 61, 62);
		addPropertyDict("科协", 62, 63);
	}

	/**
	 * 党组织类型
	 */
	private void initPartyOrgType() {
		propertyDomain = addPropertyDomain(PropertyTypes.PARTYORGTYPE, true,
				PartyOrgType.getInternalProperties());
		addPropertyDict("党委", PartyOrgType.COMMITTEE, 1);
		addPropertyDict("党总支", PartyOrgType.ALL_BRANCH, 2);
		addPropertyDict("党支部", PartyOrgType.BRANCH, 3);
	}

	/**
	 * 民生评议情况
	 */
	private void initDemocracy() {
		propertyDomain = addPropertyDomain(PropertyTypes.DEMOCRACY, false, null);
		addPropertyDict("优秀", 0, 1);
		addPropertyDict("合格", 1, 2);
		addPropertyDict("不合格", 2, 3);
	}

	/**
	 * 区域党委职务
	 */
	private void initPartyOrgDuty() {
		propertyDomain = addPropertyDomain(PropertyTypes.PARTYORGDUTY, false,
				null);
		addPropertyDict("书记", 0, 1);
		addPropertyDict("副书记", 1, 2);
		addPropertyDict("委员", 2, 3);
	}

	/**
	 * 群团组织类型
	 */
	private void initMassOrganization() {
		propertyDomain = addPropertyDomain(PropertyTypes.MASSORGANIZATION_TYPE,
				false, null);
		addPropertyDict("工会", 0, 1);
		addPropertyDict("团委", 1, 2);
		addPropertyDict("妇联", 2, 3);
	}

	/**
	 * 三本台账时限设置层级
	 */

	private void initAccountTimeLimitLevel() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ACCOUNT_TIME_LIMIT_LEVEL, false, null);
		addPropertyDict("村、社区", 0, 1);
		addPropertyDict("乡镇、街道", 0, 2);
		addPropertyDict("区县市职能部门", 0, 3);
		addPropertyDict("乡镇街道职能部门", 0, 4);
		addPropertyDict("台账办公室", 0, 5);
	}

	/**
	 * 四级平台职务
	 */
	private void initPlatformDuty() {
		propertyDomain = addPropertyDomain(PropertyTypes.PLATFORMDUTY, false,
				null);
		addPropertyDict("县长", 0, 1);
		addPropertyDict("副县长", 0, 2);
		addPropertyDict("镇长", 0, 3);
		addPropertyDict("副镇长", 0, 4);
		addPropertyDict("局长", 0, 5);
		addPropertyDict("副局长", 0, 6);
		addPropertyDict("主任", 0, 7);
		addPropertyDict("副主任", 0, 8);
		addPropertyDict("处长", 0, 9);
		addPropertyDict("科长", 0, 10);
		addPropertyDict("科员", 0, 11);
	}

	/**
	 * 综治办
	 */
	private void initManagementType() {
		propertyDomain = addPropertyDomain(PropertyTypes.MANAGEMENT_TYPE,
				false, null);
		addPropertyDict("综治办", DepartmentPartyOrgType.MANAGEMENT_TYPE, 1);
		addPropertyDict("综治工作中心", DepartmentPartyOrgType.MANAGEMENT_TYPE, 2);
		addPropertyDict("综治工作站", DepartmentPartyOrgType.MANAGEMENT_TYPE, 3);
	}

	private void initDepartmentPartyLevel() {
		propertyDomain = addPropertyDomain(PropertyTypes.DEPARTMENTPARTY_LEVEL,
				false, null);
		addPropertyDict("省部级正职", 0, 1);
		addPropertyDict("省部级副职", 1, 2);
		addPropertyDict("厅局级正职", 2, 3);
		addPropertyDict("厅局级副职", 3, 4);
		addPropertyDict("县处级正职", 4, 5);
		addPropertyDict("县处级副职", 5, 6);
		addPropertyDict("乡科级正职", 6, 7);
		addPropertyDict("乡科级副职", 7, 8);
		addPropertyDict("科员级", 8, 9);
		addPropertyDict("办事员级", 9, 10);
	}

	/**
	 * 单位场所
	 **/

	private void initCompanyPlaceType() {
		propertyDomain = addPropertyDomain(PropertyTypes.COMPANY_PLACE_TYPE,
				false, null);
		addPropertyDict("单位", 1, 1);
		addPropertyDict("场所", 2, 2);
	}

	private void initCompanyPlaceClassification() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.COMPANY_PLACE_CLASSIFICATION, false, null);

		addPropertyDict("党政机关", 101, 1);
		addPropertyDict("学校", 102, 2);
		addPropertyDict("医院", 103, 3);
		addPropertyDict("危化品存放单位", 104, 4);
		addPropertyDict("单位-其他", 105, 5);

		addPropertyDict("公共活动场所", 201, 6);
		addPropertyDict("交通场所", 202, 7);
		addPropertyDict("娱乐场所", 203, 8);
		addPropertyDict("商贸场所", 204, 9);
		addPropertyDict("网吧", 205, 10);
		addPropertyDict("住宿服务场所", 206, 11);
		addPropertyDict("餐饮服务场所", 207, 12);
		addPropertyDict("旅游场所", 208, 13);
		addPropertyDict("施工场所", 209, 14);
		addPropertyDict("场所-其他", 210, 15);

	}

	private void initCompanyPlaceCateory() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.COMPANY_PLACE_CATEGORY, false, null);

		addPropertyDict("国家行政机关", 10101, 1);
		addPropertyDict("政府", 10102, 2);

		addPropertyDict("小学", 10201, 3);
		addPropertyDict("幼儿园", 10202, 4);
		addPropertyDict("托管机构", 10203, 5);
		addPropertyDict("中学", 10204, 6);
		addPropertyDict("大专院校", 10205, 7);
		addPropertyDict("成人教育、职高、技校等", 10206, 8);
		addPropertyDict("广播、函授、培训", 10207, 9);
		addPropertyDict("特殊教育", 10208, 10);
		addPropertyDict("电视学校", 10209, 11);
		addPropertyDict("教育-其他", 10210, 12);

		addPropertyDict("综合医院", 10301, 13);
		addPropertyDict("中医院", 10302, 14);
		addPropertyDict("中西结合医院", 10303, 15);
		addPropertyDict("民族医院", 10304, 16);
		addPropertyDict("专科医院", 10305, 17);
		addPropertyDict("疗养院、康复中心", 10306, 18);
		addPropertyDict("城镇街道、社区医院", 10307, 19);
		addPropertyDict("门诊部、医务室、诊所", 10308, 20);
		addPropertyDict("妇幼保健所（站）", 10309, 21);
		addPropertyDict("卫生防疫中心（站）", 10310, 22);
		addPropertyDict("急救中心", 10311, 23);
		addPropertyDict("整形美容", 10312, 24);
		addPropertyDict("药品检验所（室、中心）", 10313, 25);
		addPropertyDict("动物医院、兽医站", 10314, 26);
		addPropertyDict("药店、药房", 10315, 27);
		addPropertyDict("医疗器械", 10316, 28);

		addPropertyDict("危险品存放站点", 10401, 29);
		addPropertyDict("油库", 10402, 30);
		addPropertyDict("天然气、煤气、液化气", 10403, 31);
		addPropertyDict("剧毒物品存放站点", 10404, 32);
		addPropertyDict("放射性物品存放站点", 10405, 33);
		addPropertyDict("民用爆炸物存储点", 10406, 34);

		addPropertyDict("国有企业", 10501, 35);
		addPropertyDict("国有控股企业", 10502, 36);
		addPropertyDict("外资企业", 10503, 37);
		addPropertyDict("合资企业", 10504, 38);
		addPropertyDict("私营企业", 10505, 39);
		addPropertyDict("事业单位", 10506, 40);
		addPropertyDict("单位-其他", 10507, 41);

		addPropertyDict("大型广场", 20101, 42);
		addPropertyDict("社区广场", 20102, 43);

		addPropertyDict("长途汽车站", 20201, 44);
		addPropertyDict("火车站", 20202, 45);
		addPropertyDict("航空港", 20203, 46);
		addPropertyDict("货运站", 20204, 47);
		addPropertyDict("码头（港口）", 20205, 48);
		addPropertyDict("交通场所-其他", 20206, 49);

		addPropertyDict("KTV", 20301, 50);
		addPropertyDict("舞厅", 20302, 51);
		addPropertyDict("迪吧", 20303, 52);
		addPropertyDict("酒吧", 20304, 53);
		addPropertyDict("球馆", 20305, 54);
		addPropertyDict("电玩", 20306, 55);
		addPropertyDict("棋牌室", 20307, 56);
		addPropertyDict("娱乐场所-其他", 20308, 57);

		addPropertyDict("大型商场、超市", 20401, 58);
		addPropertyDict("贸易市场", 20402, 59);
		addPropertyDict("商业点", 20403, 60);
		addPropertyDict("商铺", 20404, 61);
		addPropertyDict("商业片区", 20405, 62);

		addPropertyDict("网吧", 20501, 63);
		addPropertyDict("ISP网络服务供应商", 20502, 64);

		addPropertyDict("宾馆、饭店（可住宿）", 20601, 65);
		addPropertyDict("商务会馆", 20602, 66);
		addPropertyDict("度假型酒店", 20603, 67);
		addPropertyDict("公寓式酒店", 20604, 68);
		addPropertyDict("经济型酒店", 20605, 69);
		addPropertyDict("会议酒店", 20606, 70);
		addPropertyDict("一般旅馆", 20607, 71);
		addPropertyDict("度假村", 20608, 72);
		addPropertyDict("农家院", 20609, 73);
		addPropertyDict("住宿场所-其他", 20610, 74);

		addPropertyDict("中式、西式餐厅", 20701, 75);
		addPropertyDict("中式、西式快餐店", 20702, 76);
		addPropertyDict("特色小吃店", 20703, 77);
		addPropertyDict("自助餐厅", 20704, 78);
		addPropertyDict("茶（艺）馆", 20705, 79);
		addPropertyDict("食品店", 20706, 80);
		addPropertyDict("餐饮服务场所-其他", 20707, 81);

		addPropertyDict("公园", 20801, 82);
		addPropertyDict("风景名胜区", 20802, 83);
		addPropertyDict("游乐园", 20803, 84);
		addPropertyDict("历史古迹", 20804, 85);
		addPropertyDict("动物园", 20805, 86);
		addPropertyDict("植物园", 20806, 87);

		addPropertyDict("工程建设区域", 20901, 88);
		addPropertyDict("施工工地", 20902, 89);
		addPropertyDict("施工作业区", 20903, 90);

		addPropertyDict("个体场所", 21001, 91);
		addPropertyDict("电镀站", 21002, 92);
		addPropertyDict("化妆品", 21003, 93);
		addPropertyDict("城乡结合部", 21004, 94);
		addPropertyDict("城中村", 21005, 95);
		addPropertyDict("流动人口聚集地", 21006, 96);
		addPropertyDict("出租房屋区", 21007, 97);
		addPropertyDict("矿山市场", 21008, 98);
		addPropertyDict("场所-其他", 21009, 99);
	}

	private void initPollutionType() {
		propertyDomain = addPropertyDomain(PropertyTypes.POLLUTION_TYPE, false,
				null);
		addPropertyDict("大气环境污染源", 0, 1);
		addPropertyDict("地表水体环境污染源", 0, 2);
		addPropertyDict("地下水体环境污染源", 0, 3);
		addPropertyDict("海洋环境污染源", 0, 4);
		addPropertyDict("土壤环境污染源", 0, 5);
		addPropertyDict("声环境污染源", 0, 6);
		addPropertyDict("振动环境污染源", 0, 7);
		addPropertyDict("放射性环境污染源", 0, 8);
		addPropertyDict("电磁环境污染源", 0, 9);
		addPropertyDict("其他污染对象的污染源", 0, 10);
	}

	private void initEffectEvaluationType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.EFFECT_EVALUATION_TYPE, false, null);
		addPropertyDict("好", 0, 1);
		addPropertyDict("较好", 0, 2);
		addPropertyDict("差", 0, 3);
		addPropertyDict("较差", 0, 4);
	}

	private void initManagementLevelType() {
		propertyDomain = addPropertyDomain(PropertyTypes.MANAGEMENT_LEVEL,
				false, null);
		addPropertyDict("A", 0, 1);
		addPropertyDict("B", 0, 2);
		addPropertyDict("C", 0, 3);
	}

	private void initIssueJointType() {
		propertyDomain = addPropertyDomain(PropertyTypes.ISSUE_JOINT_TYPE,
				false, null);
		addPropertyDict("民生服务", 0, 1);
		addPropertyDict("矛盾劝解", 1, 2);
		addPropertyDict("参与治安防控", 2, 3);
		addPropertyDict("参与特殊人群服务管理", 3, 4);
		addPropertyDict("社情民意收集", 4, 5);
		addPropertyDict("政策法规宣传", 5, 6);
		addPropertyDict("突发事件报告", 6, 7);
		addPropertyDict("其它", 7, 8);
	}

	public void initIssueJointTypeSub() {
		propertyDomain = addPropertyDomain(PropertyTypes.ISSUE_JOINT_TYPE_SUB,
				false, null);
		// 民生服务
		addPropertyDict("教育服务", 0, 1);
		addPropertyDict("社保服务", 0, 2);
		addPropertyDict("就业服务", 0, 3);
		addPropertyDict("医疗服务", 0, 4);
		addPropertyDict("住房服务", 0, 5);
		addPropertyDict("交通服务", 0, 6);
		addPropertyDict("证件办理", 0, 7);
		addPropertyDict("企业服务", 0, 8);
		addPropertyDict("资质服务", 0, 9);
		addPropertyDict("经营纳税", 0, 10);
		addPropertyDict("婚育收养", 0, 11);
		addPropertyDict("公共事业", 0, 12);
		// 矛盾劝解
		addPropertyDict("婚姻家庭", 1, 13);
		addPropertyDict("邻里纠纷", 1, 14);
		addPropertyDict("环境生态", 1, 15);
		addPropertyDict("建筑工程", 1, 16);
		addPropertyDict("物业管理", 1, 17);
		addPropertyDict("企业改制", 1, 18);
		addPropertyDict("司法活动", 1, 19);
		addPropertyDict("干部作风", 1, 20);
		addPropertyDict("劳资纠纷", 1, 21);
		addPropertyDict("征地拆迁", 1, 22);
		addPropertyDict("军人安置", 1, 23);
		addPropertyDict("房屋和宅基地", 1, 24);
		addPropertyDict("农村“三资”", 1, 25);
		addPropertyDict("农民负担", 1, 26);
		addPropertyDict("院校问题", 1, 27);
		addPropertyDict("民族宗教", 1, 28);
		addPropertyDict("经济活动", 1, 29);
		addPropertyDict("山林土地", 1, 30);
		addPropertyDict("医患纠纷", 1, 31);
		addPropertyDict("村（社区）务管理", 1, 32);
		addPropertyDict("行政执法活动", 1, 33);
		addPropertyDict("海事渔事", 1, 34);
		addPropertyDict("交通及生产安全", 1, 35);
		addPropertyDict("计划生育", 1, 36);
		addPropertyDict("合同履行", 1, 37);
		addPropertyDict("信访问题处理", 1, 38);
		addPropertyDict("不稳定因素报告", 1, 39);
		addPropertyDict("其他", 1, 40);
		// 参与治安防控
		addPropertyDict("物防设施", 2, 41);
		addPropertyDict("技防设施", 2, 42);
		addPropertyDict("刑事治安案件发生情况", 2, 43);
		addPropertyDict("治安隐患或线索", 2, 44);
		addPropertyDict("守楼护院", 2, 45);
		addPropertyDict("防毒控毒", 2, 46);
		// 参与特殊人群服务管理
		addPropertyDict("精神病人是否落实", 3, 47);
		addPropertyDict("社区帮教落实", 3, 48);
		addPropertyDict("刑释", 3, 49);
		addPropertyDict("吸毒人员", 3, 50);
		addPropertyDict("重点青少年", 3, 51);
		// 社情民意收集
		addPropertyDict("社情民意收集", 4, 52);
		// 政策法规宣传
		addPropertyDict("咨询、宣传", 5, 53);
		// 突发事件报告
		addPropertyDict("突发事件", 6, 54);
		// 其它
		addPropertyDict("其它", 7, 55);
	}

	private void initIndustryType() {
		propertyDomain = addPropertyDomain(PropertyTypes.INDUSTRY_TYPE, false,
				null);
		addPropertyDict("一般工业企业", 0, 1);
		addPropertyDict("污水处理厂", 0, 2);
		addPropertyDict("小型企业", 0, 3);
		addPropertyDict("三产企业", 0, 4);
		addPropertyDict("固废处置单位", 0, 5);
		addPropertyDict("建筑施工", 0, 6);
	}

	private void initWasteWaterType() {
		propertyDomain = addPropertyDomain(PropertyTypes.WASTEWATER_TYPE,
				false, null);
		addPropertyDict("是否进污水处理厂", 0, 1);
		addPropertyDict("直排环境", 0, 2);
		addPropertyDict("处理后排放", 0, 3);
	}

	private void initWasteSolidType() {
		propertyDomain = addPropertyDomain(PropertyTypes.WASTESOLID_TYPE,
				false, null);
		addPropertyDict("一般固废", 0, 1);
		addPropertyDict("危废", 0, 2);
		addPropertyDict("医废", 0, 3);
	}

	private void initRadioactionType() {
		propertyDomain = addPropertyDomain(PropertyTypes.RADIOACTION_TYPE,
				false, null);
		addPropertyDict("放射性废物", 0, 2);
	}

	private void initNoiseType() {
		propertyDomain = addPropertyDomain(PropertyTypes.NOISE_TYPE, false,
				null);
		addPropertyDict("社会生活噪声", 0, 1);
		addPropertyDict("工业厂界噪声", 0, 2);
		addPropertyDict("建筑施工噪声", 0, 3);
	}

	private void initWastegasType() {
		propertyDomain = addPropertyDomain(PropertyTypes.WASTEGAS_TYPE, false,
				null);
		addPropertyDict("直排", 0, 1);
		addPropertyDict("处理后排放", 0, 2);
	}

	private void initAssessmentType() {
		propertyDomain = addPropertyDomain(PropertyTypes.ASSESSMENT_TYPE,
				false, null);
		addPropertyDict("有环评", 0, 1);
		addPropertyDict("验收", 0, 2);
		addPropertyDict("办理排污许可", 0, 3);
		addPropertyDict("编制报告表", 0, 4);
		addPropertyDict("填报登记表", 0, 5);
		addPropertyDict("编制报告书", 0, 6);
		addPropertyDict("辐射安全许可证", 0, 7);
		addPropertyDict("监督管理", 0, 8);
	}

	private void initLowasicsType() {
		propertyDomain = addPropertyDomain(PropertyTypes.LOWASICS_TYPE, false,
				null);
		addPropertyDict("是", 0, 1);
		addPropertyDict("否", 0, 2);
	}

	private void initConcernType() {
		propertyDomain = addPropertyDomain(PropertyTypes.CONCERN_TYPE, false,
				null);
		addPropertyDict("国控", 0, 1);
		addPropertyDict("省控", 0, 2);
		addPropertyDict("市控", 0, 3);
		addPropertyDict("非重点", 0, 4);
	}

	private void initRelationShipType() {
		propertyDomain = addPropertyDomain(PropertyTypes.RELATIONSHIP_TYPE,
				false, null);
		addPropertyDict("中央", 0, 1);
		addPropertyDict("省", 0, 2);
		addPropertyDict("市/地区", 0, 3);
		addPropertyDict("县", 0, 4);
		addPropertyDict("街道", 0, 5);
		addPropertyDict("镇", 0, 6);
		addPropertyDict("乡", 0, 7);
		addPropertyDict("居民委员会", 0, 8);
		addPropertyDict("村民委员会", 0, 9);
	}

	private void initUnitType() {
		propertyDomain = addPropertyDomain(PropertyTypes.UNIT_TYPE, false, null);
		addPropertyDict("县以上工业企业", 0, 1);
		addPropertyDict("县以上非工业", 0, 2);
		addPropertyDict("事业单位", 0, 3);
		addPropertyDict("乡镇街道工业", 0, 4);
		addPropertyDict("乡镇街道非工业", 0, 5);
		addPropertyDict("部队", 0, 6);
		addPropertyDict("其他", 0, 7);
	}

	private void initScaleType() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCALE_TYPE, false,
				null);
		addPropertyDict("特大型", 0, 1);
		addPropertyDict("大型一档", 0, 2);
		addPropertyDict("大型二档", 0, 3);
		addPropertyDict("中一型", 0, 4);
		addPropertyDict("中二型", 0, 5);
		addPropertyDict("小型", 0, 6);
		addPropertyDict("其他", 0, 7);
	}

	private void initKeyinDustryType() {
		propertyDomain = addPropertyDomain(PropertyTypes.KEYINDUSTRY_TYPE,
				false, null);
		addPropertyDict("钢铁", 0, 1);
		addPropertyDict("水泥", 0, 2);
		addPropertyDict("平板玻璃", 0, 3);
		addPropertyDict("石化", 0, 4);
		addPropertyDict("垃圾焚烧厂", 0, 5);
		addPropertyDict("电解铝", 0, 6);
		addPropertyDict("火力发电", 0, 7);
		addPropertyDict("造纸", 0, 8);
		addPropertyDict("医药", 0, 9);
		addPropertyDict("发酵和酿造", 0, 10);
		addPropertyDict("化工", 0, 11);
		addPropertyDict("印染", 0, 12);
		addPropertyDict("畜禽养殖", 0, 13);
		addPropertyDict("餐饮娱乐业", 0, 14);
		addPropertyDict("煤炭开采", 0, 15);
		addPropertyDict("黑色金属采矿", 0, 16);
		addPropertyDict("有色金属采矿", 0, 17);
		addPropertyDict("石油", 0, 18);
		addPropertyDict("制革", 0, 19);
	}

	private void initSuperviseType() {
		propertyDomain = addPropertyDomain(PropertyTypes.SUPERVISE_TYPE, false,
				null);
		addPropertyDict("严管企业", 0, 1);
		addPropertyDict("一般企业", 0, 2);
		addPropertyDict("守法企业", 0, 3);
	}

	private void initContaminationType() {
		propertyDomain = addPropertyDomain(PropertyTypes.CONTAMINATION_TYPE,
				false, null);
		addPropertyDict("工业源", 0, 1);
		addPropertyDict("生活源", 0, 2);
	}

	private void initTradeType() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRADE_TYPE, false,
				null);
		addPropertyDict("农业", 1, 1);
		addPropertyDict("林业", 2, 2);
		addPropertyDict("牧业", 3, 3);
		addPropertyDict("渔业", 4, 4);
		addPropertyDict("采矿业", 5, 5);
		addPropertyDict("制造业", 6, 6);
		addPropertyDict("农业服务业", 7, 7);
		addPropertyDict("石油和天然气开采业", 8, 8);
		addPropertyDict("黑色金属矿采选业", 9, 9);
		addPropertyDict("有色金属矿采选业", 10, 10);
		addPropertyDict("贵金属矿采选", 11, 11);
		addPropertyDict("土砂石开采", 12, 12);
		addPropertyDict("化学矿采选", 13, 13);
		addPropertyDict("食品制造业", 14, 14);
		addPropertyDict("饮料制造业", 15, 15);
		addPropertyDict("烟草制品业", 16, 16);
		addPropertyDict("纺织业", 17, 17);
		addPropertyDict("纺织服装、鞋、帽制造业", 18, 18);
		addPropertyDict("皮革、毛皮、羽毛(绒)及其制品业", 19, 19);
		addPropertyDict("木材加工及木、竹、藤、棕、草制品业", 20, 20);
		addPropertyDict("家具制造业", 21, 21);
		addPropertyDict("造纸及纸制品业", 22, 22);
		addPropertyDict("印刷业和记录媒介的复制", 23, 23);
		addPropertyDict("文教体育用品制造业", 24, 24);
		addPropertyDict("乐器制造", 25, 25);
		addPropertyDict("玩具制造", 26, 26);
		addPropertyDict("石油加工、炼焦及核燃料加工业", 27, 27);
		addPropertyDict("化学原料及化学制品制造业", 28, 28);
		addPropertyDict("肥料制造", 29, 29);
		addPropertyDict("农药制造", 30, 30);
		addPropertyDict("涂料、油墨、颜料及类似产品制造", 31, 31);
		addPropertyDict("合成材料制造", 32, 32);
		addPropertyDict("专用化学产品制造", 33, 33);
		addPropertyDict("日用化学产品制造", 34, 34);
		addPropertyDict("医药制造业", 35, 35);
		addPropertyDict("化学纤维制造业", 36, 36);
		addPropertyDict("橡胶制品业", 37, 37);
		addPropertyDict("塑料制品业", 38, 38);
		addPropertyDict("非金属矿物制品业", 39, 39);
		addPropertyDict("砖瓦、石材及其他建筑材料制造", 40, 40);
		addPropertyDict("玻璃及玻璃制品制造", 41, 41);
		addPropertyDict("陶瓷制品制造", 42, 42);
		addPropertyDict("石墨及其他非金属矿物制品制造", 43, 43);
		addPropertyDict("黑色金属冶炼及压延加工业", 44, 44);
		addPropertyDict("有色金属冶炼及压延加工业", 45, 45);
		addPropertyDict("贵金属冶炼", 46, 46);
		addPropertyDict("稀有稀土金属冶炼", 47, 47);
		addPropertyDict("有色金属压延加工", 48, 48);
		addPropertyDict("金属制品业", 49, 49);
		addPropertyDict("集装箱及金属包装容器制造", 50, 50);
		addPropertyDict("金属丝绳及其制品的制造", 51, 51);
		addPropertyDict("金属表面处理及热处理加工", 52, 52);
		addPropertyDict("通用设备制造业", 53, 53);
		addPropertyDict("金属加工机械制造", 54, 54);
		addPropertyDict("起重运输设备制造", 55, 55);
		addPropertyDict("通用零部件制造及机械修理", 56, 56);
		addPropertyDict("金属铸、锻加工", 57, 57);
		addPropertyDict("专用设备制造业", 58, 58);
		addPropertyDict("化工、木材、非金属加工专用设备制造", 59, 59);
		addPropertyDict("食品、饮料、烟草及饲料生产专用设备制造", 60, 60);
		addPropertyDict("印刷、制药、日化生产专用设备制造", 61, 61);
		addPropertyDict("纺织、服装和皮革工业专用设备制造", 62, 62);
		addPropertyDict("电子和电工机械专用设备制造", 63, 63);
		addPropertyDict("农、林、牧、渔专用机械制造", 64, 64);
		addPropertyDict("医疗仪器设备及器械制造", 65, 65);
		addPropertyDict("环保、社会公共安全及其他专用设备制造", 66, 66);
		addPropertyDict("交通运输设备制造业", 67, 67);
		addPropertyDict("汽车制造", 68, 68);
		addPropertyDict("摩托车制造", 69, 69);
		addPropertyDict("自行车制造", 70, 70);
		addPropertyDict("船舶及浮动装置制造", 71, 71);
		addPropertyDict("航空航天器制造", 72, 72);
		addPropertyDict("交通器材及其他交通运输设备制造", 73, 73);
		addPropertyDict("电气机械及器材制造业", 74, 74);
		addPropertyDict("输配电及控制设备制造", 75, 75);
		addPropertyDict("电线、电缆、光缆及电工器材制造", 76, 76);
		addPropertyDict("家用电力电器制造", 77, 77);
		addPropertyDict("非电力家用器具制造", 78, 78);
		addPropertyDict("照明器具制造", 79, 79);
		addPropertyDict("车辆专用照明及电气信号设备装置制造", 80, 80);
		addPropertyDict("通信设备、计算机及其他电子设备制造业", 81, 81);
		addPropertyDict("广播电视设备制造", 82, 82);
		addPropertyDict("电子计算机制造", 83, 83);
		addPropertyDict("电子器件制造", 84, 84);
		addPropertyDict("电子元件制造", 85, 85);
		addPropertyDict("家用视听设备制造", 86, 86);
		addPropertyDict("仪器仪表及文化、办公用机械制造业", 87, 87);
		addPropertyDict("专用仪器仪表制造", 88, 88);
		addPropertyDict("光学仪器制造", 89, 89);
		addPropertyDict("文化、办公用机械制造", 90, 90);
		addPropertyDict("工艺品及其他制造业", 91, 91);
		addPropertyDict("日用杂品制造", 92, 92);
		addPropertyDict("废弃资源和废旧材料回收加工业", 93, 93);
		addPropertyDict("电力、燃气及水的生产和供应业", 94, 94);
		addPropertyDict("水的生产和供应业", 95, 95);
		addPropertyDict("建筑业", 96, 96);
		addPropertyDict("工程准备", 97, 97);
		addPropertyDict("交通运输、仓储和邮政业", 98, 98);
		addPropertyDict("道路运输业", 99, 99);
		addPropertyDict("城市公共交通业", 100, 100);
		addPropertyDict("水上运输业", 101, 101);
		addPropertyDict("航空运输业", 102, 102);
		addPropertyDict("F56", 103, 103);
		addPropertyDict("装卸搬运和其他运输服务业", 104, 104);
		addPropertyDict("仓储业", 105, 105);
		addPropertyDict("邮政业", 106, 106);
		addPropertyDict("信息传输、计算机服务和软件业", 107, 107);
		addPropertyDict("计算机服务业", 108, 108);
		addPropertyDict("软件业", 109, 109);
		addPropertyDict("批发和零售业", 110, 110);
		addPropertyDict("食品、饮料及烟草制品批发", 111, 111);
		addPropertyDict("纺织、服装及日用品批发", 112, 112);
		addPropertyDict("文化、体育用品及器材批发", 113, 113);
		addPropertyDict("医药及医疗器材批发", 114, 114);
		addPropertyDict("矿产品、建材及化工产品批发", 115, 115);
		addPropertyDict("机械设备、五金交电及电子产品批发", 116, 116);
		addPropertyDict("零售业", 117, 117);
		addPropertyDict("食品、饮料及烟草制品专门零售", 118, 118);
		addPropertyDict("纺织、服装及日用品专门零售", 119, 119);
		addPropertyDict("文化、体育用品及器材专门零售", 120, 120);
		addPropertyDict("医药及医疗器材专门零售", 121, 121);
		addPropertyDict("汽车、摩托车、燃料及零配件专门零售", 122, 122);
		addPropertyDict("家用电器及电子产品专门零售", 123, 123);
		addPropertyDict("五金、家具及室内装修材料专门零售", 124, 124);
		addPropertyDict("无店铺及其他零售", 125, 125);
		addPropertyDict("住宿和餐饮业", 126, 126);
		addPropertyDict("金融业", 127, 127);
		addPropertyDict("保险业", 128, 128);
		addPropertyDict("房地产业", 129, 129);
		addPropertyDict("租赁和商务服务业", 130, 130);
		addPropertyDict("商务服务业", 131, 131);
		addPropertyDict("法律服务", 132, 132);
		addPropertyDict("咨询与调查", 133, 133);
		addPropertyDict("其他商务服务", 134, 134);
		addPropertyDict("科学研究、技术服务和地质勘查", 135, 135);
		addPropertyDict("专业技术服务业", 136, 136);
		addPropertyDict("科技交流和推广服务业", 137, 137);
		addPropertyDict("地质勘查业", 138, 138);
		addPropertyDict("水利、环境和公共设施管理业", 139, 139);
		addPropertyDict("环境管理业", 140, 140);
		addPropertyDict("环境治理", 141, 141);
		addPropertyDict("公共设施管理业", 142, 142);
		addPropertyDict("居民服务和其他服务业", 143, 143);
		addPropertyDict("其他服务业", 144, 144);
		addPropertyDict("教育", 145, 145);
		addPropertyDict("职业技能培训", 146, 146);
		addPropertyDict("卫生、社会保障和社会福利业", 147, 147);
		addPropertyDict("文化、体育和娱乐业", 148, 148);
		addPropertyDict("广播、电视、电影和音像业", 149, 149);
		addPropertyDict("公共管理和社会组织", 150, 150);
	}

	private void initTradeTypeSmall() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRADE_TYPE_SMALL,
				false, null);
		addPropertyDict("谷物及其他作物的种植", 101, 1);
		addPropertyDict("谷物的种植", 102, 2);
		addPropertyDict("薯类的种植", 103, 3);
		addPropertyDict("油料的种植", 104, 4);
		addPropertyDict("豆类的种植", 105, 5);
		addPropertyDict("棉花的种植", 106, 6);
		addPropertyDict("麻类的种植", 107, 7);
		addPropertyDict("糖料的种植", 108, 8);
		addPropertyDict("烟草的种植", 109, 9);
		addPropertyDict("其他作物的种植", 110, 10);
		addPropertyDict("蔬菜、园艺作物的种植", 111, 11);
		addPropertyDict("蔬菜的种植", 112, 12);
		addPropertyDict("花卉的种植", 113, 13);
		addPropertyDict("其他园艺作物的种植", 114, 14);
		addPropertyDict("水果、坚果、饮料和香料作物的种植", 115, 15);
		addPropertyDict("水果、坚果的种植", 116, 16);
		addPropertyDict("茶及其他饮料作物的种植", 117, 17);
		addPropertyDict("香料作物的种植", 118, 18);
		addPropertyDict("中药材的种植", 119, 19);

		addPropertyDict("林木的培育和种植", 201, 1);
		addPropertyDict("育种和育苗", 202, 2);
		addPropertyDict("造林", 203, 3);
		addPropertyDict("林木的抚育和管理", 204, 4);
		addPropertyDict("木材和竹材的采运", 205, 5);
		addPropertyDict("木材的采运", 206, 6);
		addPropertyDict("竹材的采运", 207, 7);
		addPropertyDict("林产品的采集", 208, 8);

		addPropertyDict("牲畜的饲养", 301, 1);
		addPropertyDict("猪的饲养", 302, 2);
		addPropertyDict("家禽的饲养", 303, 3);
		addPropertyDict("狩猎和捕捉动物", 304, 4);
		addPropertyDict("其他畜牧业", 305, 5);

		addPropertyDict("海洋渔业", 401, 1);
		addPropertyDict("海水养殖", 402, 2);
		addPropertyDict("海洋捕捞", 403, 3);
		addPropertyDict("内陆渔业", 404, 4);
		addPropertyDict("内陆养殖", 405, 5);
		addPropertyDict("内陆捕捞", 406, 6);

		addPropertyDict("煤炭开采和洗选业", 501, 1);
		addPropertyDict("烟煤和无烟煤的开采洗选", 502, 2);
		addPropertyDict("褐煤的开采洗选", 503, 3);
		addPropertyDict("其他煤炭采选", 504, 4);

		addPropertyDict("农副食品加工业", 601, 1);
		addPropertyDict("谷物磨制", 602, 2);
		addPropertyDict("饲料加工", 603, 3);
		addPropertyDict("植物油加工", 604, 4);
		addPropertyDict("食用植物油加工", 605, 5);
		addPropertyDict("非食用植物油加工", 606, 6);
		addPropertyDict("制糖", 607, 7);
		addPropertyDict("屠宰及肉类加工", 608, 8);
		addPropertyDict("畜禽屠宰", 609, 9);
		addPropertyDict("肉制品及副产品加工", 610, 10);
		addPropertyDict("水产品加工", 611, 11);
		addPropertyDict("水产品冷冻加工", 612, 12);
		addPropertyDict("鱼糜制品及水产品干腌制加工", 613, 13);
		addPropertyDict("水产饲料制造", 614, 14);
		addPropertyDict("鱼油提取及制品的制造", 615, 15);
		addPropertyDict("其他水产品加工", 616, 16);
		addPropertyDict("蔬菜、水果和坚果加工", 617, 17);
		addPropertyDict("其他农副食品加工", 618, 18);
		addPropertyDict("淀粉及淀粉制品的制造", 619, 19);
		addPropertyDict("豆制品制造", 620, 20);
		addPropertyDict("蛋品加工", 621, 21);
		addPropertyDict("其他未列明的农副食品加工", 622, 22);

		addPropertyDict("灌溉服务", 701, 1);
		addPropertyDict("农产品初加工服务", 702, 2);
		addPropertyDict("其他农业服务", 703, 3);
		addPropertyDict("林业服务业", 704, 4);
		addPropertyDict("畜牧服务业", 705, 5);
		addPropertyDict("兽医服务", 706, 6);
		addPropertyDict("其他畜牧服务", 707, 7);

		addPropertyDict("天然原油和天然气开采", 801, 1);
		addPropertyDict("与石油和天然气开采有关的服务活动", 802, 2);

		addPropertyDict("铁矿采选", 901, 1);
		addPropertyDict("其他黑色金属矿采选", 902, 2);

		addPropertyDict("常用有色金属矿采选", 1001, 1);
		addPropertyDict("铜矿采选", 1002, 2);
		addPropertyDict("铅锌矿采选", 1003, 3);
		addPropertyDict("镍钴矿采选", 1004, 4);
		addPropertyDict("锡矿采选", 1005, 5);
		addPropertyDict("锑矿采选", 1006, 6);
		addPropertyDict("铝矿采选", 1007, 7);
		addPropertyDict("镁矿采选", 1008, 8);
		addPropertyDict("其他常用有色金属矿采选", 1009, 9);

		addPropertyDict("金矿采选", 1101, 1);
		addPropertyDict("银矿采选", 1102, 2);
		addPropertyDict("其他贵金属矿采选", 1103, 3);
		addPropertyDict("稀有稀土金属矿采选", 1104, 4);
		addPropertyDict("钨钼矿采选", 1105, 5);
		addPropertyDict("稀土金属矿采选", 1106, 6);
		addPropertyDict("放射性金属矿采选", 1107, 7);
		addPropertyDict("其他稀有金属矿采选", 1108, 8);
		addPropertyDict("非金属矿采选业", 1109, 9);

		addPropertyDict("石灰石、石膏开采", 1201, 1);
		addPropertyDict("建筑装饰用石开采", 1202, 2);
		addPropertyDict("耐火土石开采", 1203, 3);
		addPropertyDict("粘土及其他土砂石开采", 1204, 4);

		addPropertyDict("采盐", 1301, 1);
		addPropertyDict("石棉及其他非金属矿采选", 1302, 2);
		addPropertyDict("石棉、云母矿采选", 1303, 3);
		addPropertyDict("石墨、滑石采选", 1304, 4);
		addPropertyDict("宝石、玉石开采", 1305, 5);
		addPropertyDict("其他非金属矿采选", 1306, 6);
		addPropertyDict("其他采矿业", 1307, 7);

		addPropertyDict("焙烤食品制造", 1401, 1);
		addPropertyDict("糕点、面包制造", 1402, 2);
		addPropertyDict("饼干及其他焙烤食品制造", 1403, 3);
		addPropertyDict("糖果、巧克力及蜜饯制造", 1404, 4);
		addPropertyDict("糖果、巧克力制造", 1405, 5);
		addPropertyDict("蜜饯制作", 1406, 6);
		addPropertyDict("方便食品制造", 1407, 7);
		addPropertyDict("米、面制品制造", 1408, 8);
		addPropertyDict("速冻食品制造", 1409, 9);
		addPropertyDict("方便面及其他方便食品制造", 1410, 10);
		addPropertyDict("液体乳及乳制品制造", 1411, 11);
		addPropertyDict("罐头制造", 1412, 12);
		addPropertyDict("肉、禽类罐头制造", 1413, 13);
		addPropertyDict("水产品罐头制造", 1414, 14);
		addPropertyDict("蔬菜、水果罐头制造", 1415, 15);
		addPropertyDict("其他罐头食品制造", 1416, 16);
		addPropertyDict("调味品、发酵制品制造", 1417, 17);
		addPropertyDict("味精制造", 1418, 18);
		addPropertyDict("酱油、食醋及类似制品的制造", 1419, 19);
		addPropertyDict("其他调味品、发酵制品制造", 1420, 20);
		addPropertyDict("其他食品制造", 1421, 21);
		addPropertyDict("营养、保健食品制造", 1422, 22);
		addPropertyDict("冷冻饮品及食用冰制造", 1423, 23);
		addPropertyDict("盐加工", 1424, 24);
		addPropertyDict("食品及饲料添加剂制造", 1425, 25);
		addPropertyDict("其他未列明的食品制造", 1426, 26);

		addPropertyDict("酒精制造", 1501, 1);
		addPropertyDict("酒的制造", 1502, 2);
		addPropertyDict("白酒制造", 1503, 3);
		addPropertyDict("啤酒制造", 1504, 4);
		addPropertyDict("黄酒制造", 1505, 5);
		addPropertyDict("葡萄酒制造", 1506, 6);
		addPropertyDict("其他酒制造", 1507, 7);
		addPropertyDict("软饮料制造", 1508, 8);
		addPropertyDict("碳酸饮料制造", 1509, 9);
		addPropertyDict("瓶（罐）装饮用水制造", 1510, 10);
		addPropertyDict("果菜汁及果菜汁饮料制造", 1511, 11);
		addPropertyDict("含乳饮料和植物蛋白饮料制造", 1512, 12);
		addPropertyDict("固体饮料制造", 1513, 13);
		addPropertyDict("茶饮料及其他软饮料制造", 1514, 14);
		addPropertyDict("精制茶加工", 1515, 15);

		addPropertyDict("烟叶复烤", 1601, 1);
		addPropertyDict("卷烟制造", 1602, 2);
		addPropertyDict("其他烟草制品加工", 1603, 3);

		addPropertyDict("棉、化纤纺织及印染精加工", 1701, 1);
		addPropertyDict("棉、化纤纺织加工", 1702, 2);
		addPropertyDict("棉、化纤印染精加工", 1703, 3);
		addPropertyDict("毛纺织和染整精加工", 1704, 4);
		addPropertyDict("毛条加工", 1705, 5);
		addPropertyDict("毛纺织", 1706, 6);
		addPropertyDict("毛染整精加工", 1707, 7);
		addPropertyDict("麻纺织", 1708, 8);
		addPropertyDict("丝绢纺织及精加工", 1709, 9);
		addPropertyDict("缫丝加工", 1710, 10);
		addPropertyDict("绢纺和丝织加工", 1711, 11);
		addPropertyDict("丝印染精加工", 1712, 12);
		addPropertyDict("纺织制成品制造", 1713, 13);
		addPropertyDict("棉及化纤制品制造", 1714, 14);
		addPropertyDict("毛制品制造", 1715, 15);
		addPropertyDict("麻制品制造", 1716, 16);
		addPropertyDict("丝制品制造", 1717, 17);
		addPropertyDict("绳、索、缆的制造", 1718, 18);
		addPropertyDict("纺织带和帘子布制造", 1719, 19);
		addPropertyDict("无纺布制造", 1720, 20);
		addPropertyDict("其他纺织制成品制造", 1721, 21);
		addPropertyDict("针织品、编织品及其制品制造", 1722, 22);
		addPropertyDict("棉、化纤针织品及编织品制造", 1723, 23);
		addPropertyDict("毛针织品及编织品制造", 1724, 24);
		addPropertyDict("丝针织品及编织品制造", 1725, 25);
		addPropertyDict("其他针织品及编织品制造", 1726, 26);

		addPropertyDict("纺织服装制造", 1801, 1);
		addPropertyDict("纺织面料鞋的制造", 1802, 2);
		addPropertyDict("制帽", 1803, 3);

		addPropertyDict("皮革鞣制加工", 1901, 1);
		addPropertyDict("皮革制品制造", 1902, 2);
		addPropertyDict("皮鞋制造", 1903, 3);
		addPropertyDict("皮革服装制造", 1904, 4);
		addPropertyDict("皮箱、包(袋)制造", 1905, 5);
		addPropertyDict("皮手套及皮装饰制品制造", 1906, 6);
		addPropertyDict("其他皮革制品制造", 1907, 7);
		addPropertyDict("毛皮鞣制及制品加工", 1908, 8);
		addPropertyDict("毛皮鞣制加工", 1909, 9);
		addPropertyDict("毛皮服装加工", 1910, 10);
		addPropertyDict("其他毛皮制品加工", 1911, 11);
		addPropertyDict("羽毛(绒)加工及制品制造", 1912, 12);
		addPropertyDict("羽毛(绒)加工", 1913, 13);
		addPropertyDict("羽毛(绒)制品加工", 1914, 14);

		addPropertyDict("锯材、木片加工", 2001, 1);
		addPropertyDict("锯材加工", 2002, 2);
		addPropertyDict("木片加工", 2003, 3);
		addPropertyDict("人造板制造", 2004, 4);
		addPropertyDict("胶合板制造", 2005, 5);
		addPropertyDict("纤维板制造", 2006, 6);
		addPropertyDict("刨花板制造", 2007, 7);
		addPropertyDict("其他人造板、材制造", 2008, 8);
		addPropertyDict("木制品制造", 2009, 9);
		addPropertyDict("建筑用木料及木材组件加工", 2010, 10);
		addPropertyDict("木容器制造", 2011, 11);
		addPropertyDict("软木制品及其他木制品制造", 2012, 12);
		addPropertyDict("竹、藤、棕、草制品制造", 2013, 13);

		addPropertyDict("木质家具制造", 2101, 1);
		addPropertyDict("竹、藤家具制造", 2102, 2);
		addPropertyDict("金属家具制造", 2103, 3);
		addPropertyDict("塑料家具制造", 2104, 4);
		addPropertyDict("其他家具制造", 2105, 5);

		addPropertyDict("纸浆制造", 2201, 1);
		addPropertyDict("造纸", 2202, 2);
		addPropertyDict("机制纸及纸板制造", 2203, 3);
		addPropertyDict("手工纸制造", 2204, 4);
		addPropertyDict("加工纸制造", 2205, 5);
		addPropertyDict("纸制品制造", 2206, 6);
		addPropertyDict("纸和纸板容器的制造", 2207, 7);
		addPropertyDict("其他纸制品制造", 2208, 8);

		addPropertyDict("印刷", 2301, 1);
		addPropertyDict("书、报、刊印刷", 2302, 2);
		addPropertyDict("本册印制", 2303, 3);
		addPropertyDict("包装装潢及其他印刷", 2304, 4);
		addPropertyDict("装订及其他印刷服务活动", 2305, 5);
		addPropertyDict("记录媒介的复制", 2306, 6);

		addPropertyDict("文化用品制造", 2401, 1);
		addPropertyDict("文具制造", 2402, 2);
		addPropertyDict("笔的制造", 2403, 3);
		addPropertyDict("教学用模型及教具制造", 2404, 4);
		addPropertyDict("墨水、墨汁制造", 2405, 5);
		addPropertyDict("其他文化用品制造", 2406, 6);
		addPropertyDict("体育用品制造", 2407, 7);
		addPropertyDict("球类制造", 2408, 8);
		addPropertyDict("体育器材及配件制造", 2409, 9);
		addPropertyDict("训练健身器材制造", 2410, 10);
		addPropertyDict("运动防护用具制造", 2411, 11);
		addPropertyDict("其他体育用品制造", 2412, 12);

		addPropertyDict("中乐器制造", 2501, 1);
		addPropertyDict("西乐器制造", 2502, 2);
		addPropertyDict("电子乐器制造", 2503, 3);
		addPropertyDict("其他乐器及零件制造", 2504, 4);

		addPropertyDict("游艺器材及娱乐用品制造", 2601, 1);
		addPropertyDict("露天游乐场所游乐设备制造", 2601, 1);
		addPropertyDict("游艺用品及室内游艺器材制造", 2603, 3);

		addPropertyDict("精炼石油产品的制造", 2701, 1);
		addPropertyDict("原油加工及石油制品制造", 2702, 2);
		addPropertyDict("人造原油生产", 2703, 3);
		addPropertyDict("炼焦", 2704, 4);
		addPropertyDict("核燃料加工", 2705, 5);

		addPropertyDict("基础化学原料制造", 2801, 1);
		addPropertyDict("无机酸制造", 2802, 2);
		addPropertyDict("无机碱制造", 2803, 3);
		addPropertyDict("无机盐制造", 2804, 4);
		addPropertyDict("有机化学原料制造", 2805, 5);
		addPropertyDict("其他基础化学原料制造", 2806, 6);

		addPropertyDict("氮肥制造", 2901, 1);
		addPropertyDict("磷肥制造", 2902, 2);
		addPropertyDict("钾肥制造", 2903, 3);
		addPropertyDict("复混肥料制造", 2904, 4);
		addPropertyDict("有机肥料及微生物肥料制造", 2905, 5);
		addPropertyDict("其他肥料制造", 2906, 6);

		addPropertyDict("化学农药制造", 3001, 1);
		addPropertyDict("生物化学农药及微生物农药制造", 3002, 2);

		addPropertyDict("涂料制造", 3101, 1);
		addPropertyDict("油墨及类似产品制造", 3102, 2);
		addPropertyDict("颜料制造", 3103, 3);
		addPropertyDict("染料制造", 3104, 4);
		addPropertyDict("密封用填料及类似品制造", 3105, 5);

		addPropertyDict("初级形态的塑料及合成树脂制造", 3201, 1);
		addPropertyDict("合成橡胶制造", 3202, 2);
		addPropertyDict("合成纤维单(聚合)体的制造", 3203, 3);
		addPropertyDict("其他合成材料制造", 3204, 4);

		addPropertyDict("化学试剂和助剂制造", 3301, 1);
		addPropertyDict("专项化学用品制造", 3302, 2);
		addPropertyDict("林产化学产品制造", 3303, 3);
		addPropertyDict("炸药及火工产品制造", 3304, 4);
		addPropertyDict("信息化学品制造", 3305, 5);
		addPropertyDict("环境污染处理专用药剂材料制造", 3306, 6);
		addPropertyDict("动物胶制造", 3307, 7);
		addPropertyDict("其他专用化学产品制造", 3308, 8);

		addPropertyDict("肥皂及合成洗涤剂制造", 3401, 1);
		addPropertyDict("化妆品制造", 3402, 2);
		addPropertyDict("口腔清洁用品制造", 3403, 3);
		addPropertyDict("香料、香精制造", 3404, 4);
		addPropertyDict("其他日用化学产品制造", 3405, 5);

		addPropertyDict("化学药品原药制造", 3501, 1);
		addPropertyDict("化学药品制剂制造", 3502, 2);
		addPropertyDict("中药饮片加工", 3503, 3);
		addPropertyDict("中成药制造", 3504, 4);
		addPropertyDict("兽用药品制造", 3505, 5);
		addPropertyDict("生物、生化制品的制造", 3506, 6);
		addPropertyDict("卫生材料及医药用品制造", 3507, 7);

		addPropertyDict("纤维素纤维原料及纤维制造", 3601, 1);
		addPropertyDict("化纤浆粕制造", 3602, 2);
		addPropertyDict("人造纤维（纤维素纤维）制造", 3603, 3);
		addPropertyDict("合成纤维制造", 3604, 4);
		addPropertyDict("锦纶纤维制造", 3605, 5);
		addPropertyDict("涤纶纤维制造", 3606, 6);
		addPropertyDict("腈纶纤维制造", 3607, 7);
		addPropertyDict("维纶纤维制造", 3608, 8);
		addPropertyDict("其他合成纤维制造", 3609, 9);

		addPropertyDict("轮胎制造", 3701, 1);
		addPropertyDict("车辆、飞机及工程机械轮胎制造", 3702, 2);
		addPropertyDict("力车胎制造", 3703, 3);
		addPropertyDict("轮胎翻新加工", 3704, 4);
		addPropertyDict("橡胶板、管、带的制造", 3705, 5);
		addPropertyDict("橡胶零件制造", 3706, 6);
		addPropertyDict("再生橡胶制造", 3707, 7);
		addPropertyDict("日用及医用橡胶制品制造", 3708, 8);
		addPropertyDict("橡胶靴鞋制造", 3709, 9);
		addPropertyDict("其他橡胶制品制造", 3710, 10);

		addPropertyDict("塑料薄膜制造", 3801, 1);
		addPropertyDict("塑料板、管、型材的制造", 3802, 2);
		addPropertyDict("塑料丝、绳及编织品的制造", 3803, 3);
		addPropertyDict("泡沫塑料制造", 3804, 4);
		addPropertyDict("塑料人造革、合成革制造", 3805, 5);
		addPropertyDict("塑料包装箱及容器制造", 3806, 6);
		addPropertyDict("塑料零件制造", 3807, 7);
		addPropertyDict("日用塑料制造", 3808, 8);
		addPropertyDict("塑料鞋制造", 3809, 9);
		addPropertyDict("日用塑料杂品制造", 3810, 10);
		addPropertyDict("其他塑料制品制造", 3811, 11);

		addPropertyDict("水泥、石灰和石膏的制造", 3901, 1);
		addPropertyDict("水泥制造", 3902, 2);
		addPropertyDict("石灰和石膏制造", 3903, 3);
		addPropertyDict("水泥及石膏制品制造", 3904, 4);
		addPropertyDict("水泥制品制造", 3905, 5);
		addPropertyDict("砼结构构件制造", 3906, 6);
		addPropertyDict("石棉水泥制品制造", 3907, 7);
		addPropertyDict("轻质建筑材料制造", 3908, 8);
		addPropertyDict("其他水泥制品制造", 3909, 9);

		addPropertyDict("粘土砖瓦及建筑砌块制造", 4001, 1);
		addPropertyDict("建筑陶瓷制品制造", 4002, 2);
		addPropertyDict("建筑用石加工", 4003, 3);
		addPropertyDict("防水建筑材料制造", 4004, 4);
		addPropertyDict("隔热和隔音材料制造", 4005, 5);
		addPropertyDict("其他建筑材料制造", 4006, 6);

		addPropertyDict("平板玻璃制造", 4101, 1);
		addPropertyDict("技术玻璃制品制造", 4102, 2);
		addPropertyDict("光学玻璃制造", 4103, 3);
		addPropertyDict("玻璃仪器制造", 4104, 4);
		addPropertyDict("日用玻璃制品及玻璃包装容器制造", 4105, 5);
		addPropertyDict("玻璃保温容器制造", 4106, 6);
		addPropertyDict("玻璃纤维及制品制造", 4107, 7);
		addPropertyDict("玻璃纤维增强塑料制品制造", 4108, 8);
		addPropertyDict("其他玻璃制品制造", 4109, 9);

		addPropertyDict("卫生陶瓷制品制造", 4201, 1);
		addPropertyDict("特种陶瓷制品制造", 4202, 2);
		addPropertyDict("日用陶瓷制品制造", 4203, 3);
		addPropertyDict("园林、陈设艺术及其他陶瓷制品制造", 4204, 4);
		addPropertyDict("耐火材料制品制造", 4205, 5);
		addPropertyDict("石棉制品制造", 4206, 6);
		addPropertyDict("云母制品制造", 4207, 7);
		addPropertyDict("耐火陶瓷制品及其他耐火材料制造", 4208, 8);

		addPropertyDict("石墨及碳素制品制造", 4301, 1);
		addPropertyDict("其他非金属矿物制品制造", 4302, 2);

		addPropertyDict("炼铁", 4401, 1);
		addPropertyDict("炼钢", 4402, 2);
		addPropertyDict("钢压延加工", 4403, 3);
		addPropertyDict("铁合金冶炼", 4404, 4);

		addPropertyDict("常用有色金属冶炼", 4501, 1);
		addPropertyDict("铜冶炼", 4502, 2);
		addPropertyDict("铅锌冶炼", 4503, 3);
		addPropertyDict("镍钴冶炼", 4504, 4);
		addPropertyDict("锡冶炼", 4505, 5);
		addPropertyDict("锑冶炼", 4506, 6);
		addPropertyDict("铝冶炼", 4507, 7);
		addPropertyDict("镁冶炼", 4508, 8);
		addPropertyDict("其他常用有色金属冶炼", 4509, 9);

		addPropertyDict("金冶炼", 4601, 1);
		addPropertyDict("银冶炼", 4602, 2);
		addPropertyDict("其他贵金属冶炼", 4603, 3);

		addPropertyDict("钨钼冶炼", 4701, 1);
		addPropertyDict("稀土金属冶炼", 4702, 2);
		addPropertyDict("其他稀有金属冶炼", 4703, 3);

		addPropertyDict("有色金属合金制造", 4801, 1);
		addPropertyDict("常用有色金属压延加工", 4802, 2);
		addPropertyDict("贵金属压延加工", 4803, 3);
		addPropertyDict("稀有稀土金属压延加工", 4804, 4);

		addPropertyDict("结构性金属制品制造", 4901, 1);
		addPropertyDict("金属结构制造", 4902, 2);
		addPropertyDict("金属门窗制造", 4903, 3);
		addPropertyDict("金属工具制造", 4904, 4);
		addPropertyDict("切削工具制造", 4905, 5);
		addPropertyDict("手工具制造", 4906, 6);
		addPropertyDict("农用及园林用金属工具制造", 4907, 7);
		addPropertyDict("刀剪及类似日用金属工具制造", 4908, 8);
		addPropertyDict("其他金属工具制造", 4909, 9);

		addPropertyDict("集装箱制造", 5001, 1);
		addPropertyDict("金属压力容器制造", 5002, 2);
		addPropertyDict("金属包装容器制造", 5003, 3);

		addPropertyDict("建筑、安全用金属制品制造", 5101, 1);
		addPropertyDict("建筑、家具用金属配件制造", 5102, 2);
		addPropertyDict("建筑装饰及水暖管道零件制造", 5103, 3);
		addPropertyDict("安全、消防用金属制品制造", 5104, 4);
		addPropertyDict("其他建筑、安全用金属制品制造", 5105, 5);

		addPropertyDict("搪瓷制品制造", 5201, 1);
		addPropertyDict("工业生产配套用搪瓷制品制造", 5202, 2);
		addPropertyDict("搪瓷卫生洁具制造", 5203, 3);
		addPropertyDict("搪瓷日用品及其他搪瓷制品制造", 5204, 4);
		addPropertyDict("不锈钢及类似日用金属制品制造", 5205, 5);
		addPropertyDict("金属制厨房调理及卫生器具制造", 5206, 6);
		addPropertyDict("金属制厨用器皿及餐具制造", 5207, 7);
		addPropertyDict("其他日用金属制品制造", 5208, 8);

		addPropertyDict("铸币及贵金属制实验室用品制造", 5210, 10);
		addPropertyDict("其他未列明的金属制品制造", 5211, 11);

		addPropertyDict("锅炉及原动机制造", 5301, 1);
		addPropertyDict("锅炉及辅助设备制造", 5302, 2);
		addPropertyDict("内燃机及配件制造", 5303, 3);
		addPropertyDict("汽轮机及辅机制造", 5304, 4);
		addPropertyDict("水轮机及辅机制造", 5305, 5);
		addPropertyDict("其他原动机制造", 5306, 6);

		addPropertyDict("金属切削机床制造", 5401, 1);
		addPropertyDict("金属成形机床制造", 5402, 2);
		addPropertyDict("铸造机械制造", 5403, 3);
		addPropertyDict("金属切割及焊接设备制造", 5404, 4);
		addPropertyDict("机床附件制造", 5405, 5);
		addPropertyDict("其他金属加工机械制造", 5406, 6);

		addPropertyDict("泵、阀门、压缩机及类似机械的制造", 5501, 1);
		addPropertyDict("泵及真空设备制造", 5502, 2);
		addPropertyDict("气体压缩机械制造", 5503, 3);
		addPropertyDict("阀门和旋塞的制造", 5504, 4);
		addPropertyDict("液压和气压动力机械及元件制造", 5505, 5);
		addPropertyDict("轴承、齿轮、传动和驱动部件的制造", 5506, 6);
		addPropertyDict("轴承制造", 5507, 7);
		addPropertyDict("齿轮、传动和驱动部件制造", 5508, 8);
		addPropertyDict("烘炉、熔炉及电炉制造", 5509, 9);
		addPropertyDict("风机、衡器、包装设备等通用设备制造", 5510, 10);
		addPropertyDict("风机、风扇制造", 5511, 11);
		addPropertyDict("气体、液体分离及纯净设备制造", 5512, 12);
		addPropertyDict("制冷、空调设备制造", 5513, 13);
		addPropertyDict("风动和电动工具制造", 5514, 14);
		addPropertyDict("喷枪及类似器具制造", 5515, 15);
		addPropertyDict("包装专用设备制造", 5516, 16);
		addPropertyDict("衡器制造", 5517, 17);
		addPropertyDict("其他通用设备制造", 5518, 18);

		addPropertyDict("金属密封件制造", 5601, 1);
		addPropertyDict("紧固件、弹簧制造", 5602, 2);
		addPropertyDict("机械零部件加工及设备修理", 5603, 3);
		addPropertyDict("其他通用零部件制造", 5604, 4);

		addPropertyDict("钢铁铸件制造", 5701, 1);
		addPropertyDict("锻件及粉末冶金制品制造", 5702, 2);

		addPropertyDict("矿山、冶金、建筑专用设备制造", 5801, 1);
		addPropertyDict("采矿、采石设备制造", 5802, 2);
		addPropertyDict("石油钻采专用设备制造", 5803, 3);
		addPropertyDict("建筑工程用机械制造", 5804, 4);
		addPropertyDict("建筑材料生产专用机械制造", 5805, 5);
		addPropertyDict("冶金专用设备制造", 5806, 6);

		addPropertyDict("炼油、化工生产专用设备制造", 5901, 1);
		addPropertyDict("橡胶加工专用设备制造", 5902, 2);
		addPropertyDict("塑料加工专用设备制造", 5903, 3);
		addPropertyDict("木材加工机械制造", 5904, 4);
		addPropertyDict("模具制造", 5905, 5);
		addPropertyDict("其他非金属加工专用设备制造", 5906, 6);

		addPropertyDict("食品、饮料、烟草工业专用设备制造", 6001, 1);
		addPropertyDict("农副食品加工专用设备制造", 6002, 2);
		addPropertyDict("饲料生产专用设备制造", 6003, 3);

		addPropertyDict("制浆和造纸专用设备制造", 6101, 1);
		addPropertyDict("印刷专用设备制造", 6102, 2);
		addPropertyDict("日用化工专用设备制造", 6103, 3);
		addPropertyDict("制药专用设备制造", 6104, 4);
		addPropertyDict("照明器具生产专用设备制造", 6105, 5);
		addPropertyDict("玻璃、陶瓷和搪瓷制品生产专用设备制造", 6106, 6);
		addPropertyDict("其他日用品生产专用设备制造", 6107, 7);

		addPropertyDict("纺织专用设备制造", 6201, 1);
		addPropertyDict("皮革、毛皮及其制品加工专用设备制造", 6202, 2);
		addPropertyDict("缝纫机械制造", 6203, 3);
		addPropertyDict("其他服装加工专用设备制造", 6204, 4);

		addPropertyDict("电工机械专用设备制造", 6301, 1);
		addPropertyDict("电子工业专用设备制造", 6302, 2);
		addPropertyDict("武器弹药制造", 6303, 3);
		addPropertyDict("航空、航天及其他专用设备制造", 6304, 4);

		addPropertyDict("拖拉机制造", 6401, 1);
		addPropertyDict("机械化农业及园艺机具制造", 6402, 2);
		addPropertyDict("营林及木竹采伐机械制造", 6403, 3);
		addPropertyDict("畜牧机械制造", 6404, 4);
		addPropertyDict("渔业机械制造", 6405, 5);
		addPropertyDict("农林牧渔机械配件制造", 6406, 6);
		addPropertyDict("其他农林牧渔业机械制造及机械修理", 6407, 7);

		addPropertyDict("医疗诊断、监护及治疗设备制造", 6501, 1);
		addPropertyDict("口腔科用设备及器具制造", 6502, 2);
		addPropertyDict("实验室及医用消毒设备和器具的制造", 6503, 3);
		addPropertyDict("医疗、外科及兽医用器械制造", 6504, 4);
		addPropertyDict("机械治疗及病房护理设备制造", 6505, 5);
		addPropertyDict("假肢、人工器官及植（介）入器械制造", 6506, 6);
		addPropertyDict("其他医疗设备及器械制造", 6507, 7);

		addPropertyDict("环境污染防治专用设备制造", 6601, 1);
		addPropertyDict("地质勘查专用设备制造", 6602, 2);
		addPropertyDict("邮政专用机械及器材制造", 6603, 3);
		addPropertyDict("商业、饮食、服务业专用设备制造", 6604, 4);
		addPropertyDict("社会公共安全设备及器材制造", 6605, 5);
		addPropertyDict("交通安全及管制专用设备制造", 6606, 6);
		addPropertyDict("水资源专用机械制造", 6607, 7);
		addPropertyDict("其他专用设备制造", 6608, 8);

		addPropertyDict("铁路运输设备制造", 6701, 1);
		addPropertyDict("铁路机车车辆及动车组制造", 6702, 2);
		addPropertyDict("工矿有轨专用车辆制造", 6703, 3);
		addPropertyDict("铁路机车车辆配件制造", 6704, 4);
		addPropertyDict("铁路专用设备及器材、配件制造", 6705, 5);
		addPropertyDict("其他铁路设备制造及设备修理", 6706, 6);

		addPropertyDict("汽车整车制造", 6801, 1);
		addPropertyDict("改装汽车制造", 6802, 2);
		addPropertyDict("电车制造", 6803, 3);
		addPropertyDict("汽车车身、挂车的制造", 6804, 4);
		addPropertyDict("汽车零部件及配件制造", 6805, 5);
		addPropertyDict("汽车修理", 6806, 6);

		addPropertyDict("摩托车整车制造", 6901, 1);
		addPropertyDict("摩托车零部件及配件制造", 6902, 2);

		addPropertyDict("脚踏自行车及残疾人座车制造", 7001, 1);
		addPropertyDict("助动自行车制造", 7002, 2);

		addPropertyDict("金属船舶制造", 7101, 1);
		addPropertyDict("非金属船舶制造", 7102, 2);
		addPropertyDict("娱乐船和运动船的建造和修理", 7103, 3);
		addPropertyDict("船用配套设备制造", 7104, 4);
		addPropertyDict("船舶修理及拆船", 7105, 5);
		addPropertyDict("航标器材及其他浮动装置的制造", 7106, 6);

		addPropertyDict("飞机制造及修理", 7201, 1);
		addPropertyDict("航天器制造", 7202, 2);
		addPropertyDict("其他飞行器制造", 7203, 3);

		addPropertyDict("潜水及水下救捞装备制造", 7301, 1);
		addPropertyDict("交通管理用金属标志及设施制造", 7302, 2);
		addPropertyDict("其他交通运输设备制造", 7303, 3);

		addPropertyDict("电机制造", 7401, 1);
		addPropertyDict("发电机及发电机组制造", 7402, 2);
		addPropertyDict("电动机制造", 7403, 3);
		addPropertyDict("微电机及其他电机制造", 7404, 4);

		addPropertyDict("变压器、整流器和电感器制造", 7501, 1);
		addPropertyDict("电容器及其配套设备制造", 7502, 2);
		addPropertyDict("配电开关控制设备制造", 7503, 3);
		addPropertyDict("电力电子元器件制造", 7504, 4);
		addPropertyDict("其他输配电及控制设备制造", 7505, 5);

		addPropertyDict("电线电缆制造", 7601, 1);
		addPropertyDict("光纤、光缆制造", 7602, 2);
		addPropertyDict("绝缘制品制造", 7603, 3);
		addPropertyDict("其他电工器材制造", 7604, 4);
		addPropertyDict("电池制造", 7605, 5);

		addPropertyDict("家用电力器具制造", 7701, 1);
		addPropertyDict("家用制冷电器具制造", 7702, 2);
		addPropertyDict("家用空气调节器制造", 7703, 3);
		addPropertyDict("家用通风电器具制造", 7704, 4);
		addPropertyDict("家用厨房电器具制造", 7705, 5);
		addPropertyDict("家用清洁卫生电器具制造", 7706, 6);
		addPropertyDict("家用美容、保健电器具制造", 7707, 7);
		addPropertyDict("家用电力器具专用配件制造", 7708, 8);
		addPropertyDict("其他家用电力器具制造", 7709, 9);

		addPropertyDict("燃气、太阳能及类似能源的器具制造", 7801, 1);
		addPropertyDict("其他非电力家用器具制造", 7802, 2);

		addPropertyDict("电光源制造", 7901, 1);
		addPropertyDict("照明灯具制造", 7902, 2);
		addPropertyDict("灯用电器附件及其他照明器具制造", 7903, 3);
		addPropertyDict("其他电气机械及器材制造", 7904, 4);

		addPropertyDict("车辆专用照明及电气信号设备装置制造", 8001, 1);
		addPropertyDict("其他未列明的电气机械制造", 8002, 2);

		addPropertyDict("通信设备制造", 8101, 1);
		addPropertyDict("通信传输设备制造", 8102, 2);
		addPropertyDict("通信交换设备制造", 8103, 3);
		addPropertyDict("通信终端设备制造", 8104, 4);
		addPropertyDict("移动通信及终端设备制造", 8105, 5);
		addPropertyDict("其他通信设备制造", 8106, 6);
		addPropertyDict("雷达及配套设备制造", 8107, 7);

		addPropertyDict("广播电视节目制作及发射设备制造", 8201, 1);
		addPropertyDict("广播电视接收设备及器材制造", 8202, 2);
		addPropertyDict("应用电视设备及其他广播电视设备制造", 8203, 3);

		addPropertyDict("电子计算机整机制造", 8301, 1);
		addPropertyDict("计算机网络设备制造", 8302, 2);
		addPropertyDict("电子计算机外部设备制造", 8303, 3);

		addPropertyDict("电子真空器件制造", 8401, 1);
		addPropertyDict("半导体分立器件制造", 8402, 2);
		addPropertyDict("集成电路制造", 8403, 3);
		addPropertyDict("光电子器件及其他电子器件制造", 8404, 4);

		addPropertyDict("电子元件及组件制造", 8501, 1);
		addPropertyDict("印制电路板制造", 8502, 2);

		addPropertyDict("家用影视设备制造", 8601, 1);
		addPropertyDict("家用音响设备制造", 8602, 2);
		addPropertyDict("其他电子设备制造", 8603, 3);

		addPropertyDict("通用仪器仪表制造", 8701, 1);
		addPropertyDict("工业自动控制系统装置制造", 8702, 2);
		addPropertyDict("电工仪器仪表制造", 8703, 3);
		addPropertyDict("绘图、计算及测量仪器制造", 8704, 4);
		addPropertyDict("实验分析仪器制造", 8705, 5);
		addPropertyDict("试验机制造", 8706, 6);
		addPropertyDict("供应用仪表及其他通用仪器制造", 8707, 7);

		addPropertyDict("环境监测专用仪器仪表制造", 8801, 1);
		addPropertyDict("汽车及其他用计数仪表制造", 8802, 2);
		addPropertyDict("导航、气象及海洋专用仪器制造", 8803, 3);
		addPropertyDict("农林牧渔专用仪器仪表制造", 8804, 4);
		addPropertyDict("地质勘探和地震专用仪器制造", 8805, 5);
		addPropertyDict("教学专用仪器制造", 8806, 6);
		addPropertyDict("核子及核辐射测量仪器制造", 8807, 7);
		addPropertyDict("电子测量仪器制造", 8808, 8);
		addPropertyDict("其他专用仪器制造", 8809, 9);
		addPropertyDict("钟表与计时仪器制造", 8810, 10);

		addPropertyDict("光学仪器及眼镜制造", 8901, 1);
		addPropertyDict("光学仪器制造", 8902, 2);
		addPropertyDict("眼镜制造", 8903, 3);
		addPropertyDict("其他仪器仪表的制造及修理", 8904, 4);

		addPropertyDict("电影机械制造", 9001, 1);
		addPropertyDict("幻灯及投影设备制造", 9002, 2);
		addPropertyDict("照相机及器材制造", 9003, 3);
		addPropertyDict("复印和胶印设备制造", 9004, 4);
		addPropertyDict("计算器及货币专用设备制造", 9005, 5);
		addPropertyDict("其他文化、办公用机械制造", 9006, 6);

		addPropertyDict("工艺美术品制造", 9101, 1);
		addPropertyDict("雕塑工艺品制造", 9102, 2);
		addPropertyDict("金属工艺品制造", 9103, 3);
		addPropertyDict("漆器工艺品制造", 9104, 4);
		addPropertyDict("花画工艺品制造", 9105, 5);
		addPropertyDict("天然植物纤维编织工艺品制造", 9106, 6);
		addPropertyDict("抽纱刺绣工艺品制造", 9107, 7);
		addPropertyDict("地毯、挂毯制造", 9108, 8);
		addPropertyDict("珠宝首饰及有关物品的制造", 9109, 9);
		addPropertyDict("其他工艺美术品制造", 9110, 10);

		addPropertyDict("制镜及类似品加工", 9201, 1);
		addPropertyDict("鬃毛加工、制刷及清扫工具的制造", 9202, 2);
		addPropertyDict("其他日用杂品制造", 9203, 3);
		addPropertyDict("煤制品制造", 9204, 4);
		addPropertyDict("核辐射加工", 9205, 5);
		addPropertyDict("其他未列明的制造业", 9206, 6);

		addPropertyDict("金属废料和碎屑的加工处理", 9301, 1);
		addPropertyDict("非金属废料和碎屑的加工处理", 9302, 2);

		addPropertyDict("电力、热力的生产和供应业", 9401, 1);
		addPropertyDict("电力生产", 9402, 2);
		addPropertyDict("火力发电", 9403, 3);
		addPropertyDict("水力发电", 9404, 4);
		addPropertyDict("核力发电", 9405, 5);
		addPropertyDict("其他能源发电", 9406, 6);
		addPropertyDict("电力供应", 9407, 7);
		addPropertyDict("热力生产和供应", 9408, 8);
		addPropertyDict("燃气生产和供应业", 9409, 9);

		addPropertyDict("自来水的生产和供应", 9501, 1);
		addPropertyDict("污水处理及其再生利用", 9502, 2);
		addPropertyDict("其他水的处理、利用与分配", 9503, 3);

		addPropertyDict("房屋和土木工程建筑业", 9601, 1);
		addPropertyDict("房屋工程建筑", 9602, 2);
		addPropertyDict("土木工程建筑", 9603, 3);
		addPropertyDict("铁路、道路、隧道和桥梁工程建筑", 9604, 4);
		addPropertyDict("水利和港口工程建筑", 9605, 5);
		addPropertyDict("工矿工程建筑", 9606, 6);
		addPropertyDict("架线和管道工程建筑", 9607, 7);
		addPropertyDict("其他土木工程建筑", 9608, 8);
		addPropertyDict("建筑安装业", 9609, 9);
		addPropertyDict("建筑装饰业", 9610, 10);

		addPropertyDict("提供施工设备服务", 9701, 1);
		addPropertyDict("其他未列明的建筑活动", 9702, 2);

		addPropertyDict("铁路运输业", 9801, 1);
		addPropertyDict("铁路旅客运输", 9802, 2);
		addPropertyDict("铁路货物运输", 9803, 3);
		addPropertyDict("铁路运输辅助活动", 9804, 4);
		addPropertyDict("客运火车站", 9805, 5);
		addPropertyDict("货运火车站", 9806, 6);
		addPropertyDict("其他铁路运输辅助活动", 9807, 7);

		addPropertyDict("公路旅客运输", 9901, 1);
		addPropertyDict("道路货物运输", 9902, 2);
		addPropertyDict("道路运输辅助活动", 9903, 3);
		addPropertyDict("客运汽车站", 9904, 4);
		addPropertyDict("公路管理与养护", 9905, 5);
		addPropertyDict("其他道路运输辅助活动", 9906, 6);

		addPropertyDict("公共电汽车客运", 10001, 1);
		addPropertyDict("轨道交通", 10002, 2);
		addPropertyDict("出租车客运", 10003, 3);
		addPropertyDict("城市轮渡", 10004, 4);
		addPropertyDict("其他城市公共交通", 10005, 5);

		addPropertyDict("水上旅客运输", 10101, 1);
		addPropertyDict("远洋旅客运输", 10102, 2);
		addPropertyDict("沿海旅客运输", 10103, 3);
		addPropertyDict("内河旅客运输", 10104, 4);
		addPropertyDict("水上货物运输", 10105, 5);
		addPropertyDict("远洋货物运输", 10106, 6);
		addPropertyDict("沿海货物运输", 10107, 7);
		addPropertyDict("内河货物运输", 10108, 8);
		addPropertyDict("水上运输辅助活动", 10109, 9);
		addPropertyDict("客运港口", 10110, 10);
		addPropertyDict("货运港口", 10111, 11);
		addPropertyDict("其他水上运输辅助活动", 10112, 12);

		addPropertyDict("航空客货运输", 10201, 1);
		addPropertyDict("航空旅客运输", 10202, 2);
		addPropertyDict("航空货物运输", 10203, 3);
		addPropertyDict("通用航空服务", 10204, 4);
		addPropertyDict("航空运输辅助活动", 10205, 5);
		addPropertyDict("机场", 10206, 6);
		addPropertyDict("空中交通管理", 10207, 7);
		addPropertyDict("其他航空运输辅助活动", 10208, 8);

		addPropertyDict("管道运输业", 10301, 1);

		addPropertyDict("装卸搬运", 10401, 1);
		addPropertyDict("运输代理服务", 10402, 2);

		addPropertyDict("谷物、棉花等农产品仓储", 10501, 1);
		addPropertyDict("其他仓储", 10502, 2);

		addPropertyDict("国家邮政", 10601, 1);
		addPropertyDict("其他寄递服务", 10602, 2);

		addPropertyDict("电信和其他信息传输服务业", 10701, 1);
		addPropertyDict("电信", 10702, 2);
		addPropertyDict("固定电信服务", 10703, 3);
		addPropertyDict("移动电信服务", 10704, 4);
		addPropertyDict("其他电信服务", 10705, 5);
		addPropertyDict("互联网信息服务", 10706, 6);
		addPropertyDict("广播电视传输服务", 10707, 7);
		addPropertyDict("有线广播电视传输服务", 10708, 8);
		addPropertyDict("无线广播电视传输服务", 10709, 9);
		addPropertyDict("卫星传输服务", 10710, 10);

		addPropertyDict("计算机系统服务", 10801, 1);
		addPropertyDict("数据处理", 10802, 2);
		addPropertyDict("计算机维修", 10803, 3);
		addPropertyDict("其他计算机服务", 10804, 4);

		addPropertyDict("公共软件服务", 10901, 1);
		addPropertyDict("基础软件服务", 10902, 2);
		addPropertyDict("应用软件服务", 10903, 3);
		addPropertyDict("其他软件服务", 10904, 4);

		addPropertyDict("批发业", 11001, 1);
		addPropertyDict("农畜产品批发", 11002, 2);
		addPropertyDict("谷物、豆及薯类批发", 11003, 3);
		addPropertyDict("种子、饲料批发", 11004, 4);
		addPropertyDict("棉、麻批发", 11005, 5);
		addPropertyDict("牲畜批发", 11006, 6);
		addPropertyDict("其他农畜产品批发", 11007, 7);

		addPropertyDict("米、面制品及食用油批发", 11101, 1);
		addPropertyDict("糕点、糖果及糖批发", 11102, 2);
		addPropertyDict("果品、蔬菜批发", 11103, 3);
		addPropertyDict("肉、禽、蛋及水产品批发", 11104, 4);
		addPropertyDict("盐及调味品批发", 11105, 5);
		addPropertyDict("饮料及茶叶批发", 11106, 6);
		addPropertyDict("烟草制品批发", 11107, 7);
		addPropertyDict("其他食品批发", 11108, 8);

		addPropertyDict("纺织品、针织品及原料批发", 11201, 1);
		addPropertyDict("服装批发", 11202, 2);
		addPropertyDict("鞋帽批发", 11203, 3);
		addPropertyDict("厨房、卫生间用具及日用杂货批发", 11204, 4);
		addPropertyDict("化妆品及卫生用品批发", 11205, 5);
		addPropertyDict("其他日用品批发", 11206, 6);

		addPropertyDict("文具用品批发", 11301, 1);
		addPropertyDict("体育用品批发", 11302, 2);
		addPropertyDict("图书批发", 11303, 3);
		addPropertyDict("报刊批发", 11304, 4);
		addPropertyDict("音像制品及电子出版物批发", 11305, 5);
		addPropertyDict("首饰、工艺品及收藏品批发", 11306, 6);
		addPropertyDict("其他文化用品批发", 11307, 7);

		addPropertyDict("西药批发", 11401, 1);
		addPropertyDict("中药材及中成药批发", 11402, 2);
		addPropertyDict("医疗用品及器材批发", 11403, 3);

		addPropertyDict("煤炭及制品批发", 11501, 1);
		addPropertyDict("石油及制品批发", 11502, 2);
		addPropertyDict("非金属矿及制品批发", 11503, 3);
		addPropertyDict("金属及金属矿批发", 11504, 4);
		addPropertyDict("建材批发", 11505, 5);
		addPropertyDict("化肥批发", 11506, 6);
		addPropertyDict("农药批发", 11507, 7);
		addPropertyDict("农用薄膜批发", 11508, 8);
		addPropertyDict("其他化工产品批发", 11509, 9);

		addPropertyDict("农业机械批发", 11601, 1);
		addPropertyDict("汽车、摩托车及零配件批发", 11602, 2);
		addPropertyDict("五金、交电批发", 11603, 3);
		addPropertyDict("家用电器批发", 11604, 4);
		addPropertyDict("计算机、软件及辅助设备批发", 11605, 5);
		addPropertyDict("通讯及广播电视设备批发", 11606, 6);
		addPropertyDict("其他机械设备及电子产品批发", 11607, 7);
		addPropertyDict("贸易经纪与代理", 11608, 8);
		addPropertyDict("再生物资回收与批发", 11609, 9);
		addPropertyDict("其他未列明的批发", 11610, 10);

		addPropertyDict("综合零售", 11701, 1);
		addPropertyDict("百货零售", 11702, 2);
		addPropertyDict("超级市场零售", 11703, 3);
		addPropertyDict("其他综合零售", 11704, 4);

		addPropertyDict("粮油零售", 11801, 1);
		addPropertyDict("糕点、面包零售", 11802, 2);
		addPropertyDict("果品、蔬菜零售", 11803, 3);
		addPropertyDict("肉、禽、蛋及水产品零售", 11804, 4);
		addPropertyDict("饮料及茶叶零售", 11805, 5);
		addPropertyDict("烟草制品零售", 11806, 6);
		addPropertyDict("其他食品零售", 11807, 7);

		addPropertyDict("纺织品及针织品零售", 11901, 1);
		addPropertyDict("服装零售", 11902, 2);
		addPropertyDict("鞋帽零售", 11903, 3);
		addPropertyDict("钟表、眼镜零售", 11904, 4);
		addPropertyDict("化妆品及卫生用品零售", 11905, 5);
		addPropertyDict("其他日用品零售", 11906, 6);

		addPropertyDict("文具用品零售", 12001, 1);
		addPropertyDict("体育用品零售", 12002, 2);
		addPropertyDict("图书零售", 12003, 3);
		addPropertyDict("报刊零售", 12004, 4);
		addPropertyDict("音像制品及电子出版物零售", 12005, 5);
		addPropertyDict("珠宝首饰零售", 12006, 6);
		addPropertyDict("工艺美术品及收藏品零售", 12007, 7);
		addPropertyDict("照相器材零售", 12008, 8);
		addPropertyDict("其他文化用品零售", 12009, 9);

		addPropertyDict("药品零售", 12101, 1);
		addPropertyDict("医疗用品及器材零售", 12102, 2);

		addPropertyDict("汽车零售", 12201, 1);
		addPropertyDict("汽车零配件零售", 12202, 2);
		addPropertyDict("摩托车及零配件零售", 12203, 3);
		addPropertyDict("机动车燃料零售", 12204, 4);

		addPropertyDict("家用电器零售", 12301, 1);
		addPropertyDict("计算机、软件及辅助设备零售", 12302, 2);
		addPropertyDict("通信设备零售", 12303, 3);
		addPropertyDict("其他电子产品零售", 12304, 4);

		addPropertyDict("五金零售", 12401, 1);
		addPropertyDict("家具零售", 12402, 2);
		addPropertyDict("涂料零售", 12403, 3);
		addPropertyDict("其他室内装修材料零售", 12404, 4);

		addPropertyDict("流动货摊零售", 12501, 1);
		addPropertyDict("邮购及电子销售", 12502, 2);
		addPropertyDict("生活用燃料零售", 12503, 3);
		addPropertyDict("花卉零售", 12504, 4);
		addPropertyDict("旧货零售", 12505, 5);
		addPropertyDict("其他未列明的零售", 12506, 6);

		addPropertyDict("住宿业", 12601, 1);
		addPropertyDict("旅游饭店", 12602, 2);
		addPropertyDict("一般旅馆", 12603, 3);
		addPropertyDict("其他住宿服务", 12604, 4);
		addPropertyDict("餐饮业", 12605, 5);
		addPropertyDict("正餐服务", 12606, 6);
		addPropertyDict("快餐服务", 12607, 7);
		addPropertyDict("饮料及冷饮服务", 12608, 8);
		addPropertyDict("其他餐饮服务", 12609, 9);

		addPropertyDict("银行业", 12701, 1);
		addPropertyDict("中央银行", 12702, 2);
		addPropertyDict("商业银行", 12703, 3);
		addPropertyDict("其他银行", 12704, 4);
		addPropertyDict("证券业", 12705, 5);
		addPropertyDict("证券市场管理", 12706, 6);
		addPropertyDict("证券经纪与交易", 12707, 7);
		addPropertyDict("证券投资", 12708, 8);
		addPropertyDict("证券分析与咨询", 12709, 9);

		addPropertyDict("人寿保险", 12801, 1);
		addPropertyDict("非人寿保险", 12802, 2);
		addPropertyDict("保险辅助服务", 12803, 3);
		addPropertyDict("其他金融活动", 12804, 4);
		addPropertyDict("金融信托与管理", 12805, 5);
		addPropertyDict("金融租赁", 12806, 6);
		addPropertyDict("财务公司", 12807, 7);
		addPropertyDict("邮政储蓄", 12808, 8);
		addPropertyDict("典当", 12809, 9);
		addPropertyDict("其他未列明的金融活动", 12810, 10);

		addPropertyDict("房地产业", 12901, 1);
		addPropertyDict("房地产开发经营", 12902, 2);
		addPropertyDict("物业管理", 12903, 3);
		addPropertyDict("房地产中介服务", 12904, 4);
		addPropertyDict("其他房地产活动", 12905, 5);

		addPropertyDict("租赁业", 13001, 1);
		addPropertyDict("机械设备租赁", 13002, 2);
		addPropertyDict("汽车租赁", 13003, 3);
		addPropertyDict("农业机械租赁", 13004, 4);
		addPropertyDict("建筑工程机械与设备租赁", 13005, 5);
		addPropertyDict("计算机及通讯设备租赁", 13006, 6);
		addPropertyDict("其他机械与设备租赁", 13007, 7);
		addPropertyDict("文化及日用品出租", 13008, 8);
		addPropertyDict("图书及音像制品出租", 13009, 9);
		addPropertyDict("其他文化及日用品出租", 13010, 10);

		addPropertyDict("企业管理服务", 13101, 1);
		addPropertyDict("企业管理机构", 13102, 2);
		addPropertyDict("投资与资产管理", 13103, 3);
		addPropertyDict("其他企业管理服务", 13104, 4);

		addPropertyDict("律师及相关的法律服务", 13201, 1);
		addPropertyDict("公证服务", 13202, 2);
		addPropertyDict("其他法律服务", 13203, 3);

		addPropertyDict("会计、审计及税务服务", 13301, 1);
		addPropertyDict("市场调查", 13302, 2);
		addPropertyDict("社会经济咨询", 13303, 3);
		addPropertyDict("其他专业咨询", 13304, 4);
		addPropertyDict("广告业", 13305, 5);
		addPropertyDict("知识产权服务", 13306, 6);
		addPropertyDict("职业中介服务", 13307, 7);
		addPropertyDict("市场管理", 13308, 8);
		addPropertyDict("旅行社", 13309, 9);

		addPropertyDict("会议及展览服务", 13401, 1);
		addPropertyDict("包装服务", 13402, 2);
		addPropertyDict("保安服务", 13403, 3);
		addPropertyDict("办公服务", 13404, 4);
		addPropertyDict("其他未列明的商务服务业", 13405, 5);

		addPropertyDict("研究与试验发展", 13501, 1);
		addPropertyDict("自然科学研究与试验发展", 13502, 2);
		addPropertyDict("工程和技术研究与试验发展", 13503, 3);
		addPropertyDict("农业科学研究与试验发展", 13504, 4);
		addPropertyDict("医学研究与试验发展", 13505, 5);
		addPropertyDict("社会人文科学研究与试验发展", 13506, 6);

		addPropertyDict("气象服务", 13601, 1);
		addPropertyDict("地震服务", 13602, 2);
		addPropertyDict("海洋服务", 13603, 3);
		addPropertyDict("测绘服务", 13604, 4);
		addPropertyDict("技术检测", 13605, 5);
		addPropertyDict("环境监测", 13606, 6);
		addPropertyDict("工程技术与规划管理", 13607, 7);
		addPropertyDict("工程管理服务", 13608, 8);
		addPropertyDict("工程勘察设计", 13609, 9);
		addPropertyDict("规划管理", 13610, 10);
		addPropertyDict("其他专业技术服务", 13611, 11);

		addPropertyDict("技术推广服务", 13701, 1);
		addPropertyDict("科技中介服务", 13702, 2);
		addPropertyDict("其他科技服务", 13703, 3);

		addPropertyDict("矿产地质勘查", 13801, 1);
		addPropertyDict("能源矿产地质勘查", 13802, 2);
		addPropertyDict("固体矿产地质勘查", 13803, 3);
		addPropertyDict("其他矿产地质勘查", 13804, 4);
		addPropertyDict("基础地质勘查", 13805, 5);
		addPropertyDict("地质勘查技术服务", 13806, 6);

		addPropertyDict("水利管理业", 13901, 1);
		addPropertyDict("防洪管理", 13902, 2);
		addPropertyDict("水资源管理", 13903, 3);
		addPropertyDict("水库管理", 13904, 4);
		addPropertyDict("调水、引水管理", 13905, 5);
		addPropertyDict("其他水资源管理", 13906, 6);
		addPropertyDict("其他水利管理", 13907, 7);

		addPropertyDict("自然保护", 14001, 1);
		addPropertyDict("自然保护区管理", 14002, 2);
		addPropertyDict("野生动植物保护", 14003, 3);
		addPropertyDict("其他自然保护", 14004, 4);

		addPropertyDict("城市市容管理", 14101, 1);
		addPropertyDict("城市环境卫生管理", 14102, 2);
		addPropertyDict("水污染治理", 14103, 3);
		addPropertyDict("危险废物治理", 14104, 4);
		addPropertyDict("其他环境治理", 14105, 5);

		addPropertyDict("市政公共设施管理", 14201, 1);
		addPropertyDict("城市绿化管理", 14202, 2);
		addPropertyDict("游览景区管理", 14203, 3);
		addPropertyDict("风景名胜区管理", 14204, 4);
		addPropertyDict("公园管理", 14205, 5);
		addPropertyDict("其他游览景区管理", 14206, 6);

		addPropertyDict("居民服务业", 14301, 1);
		addPropertyDict("家庭服务", 14302, 2);
		addPropertyDict("托儿所", 14303, 3);
		addPropertyDict("洗染服务", 14304, 4);
		addPropertyDict("理发及美容保健服务", 14305, 5);
		addPropertyDict("洗浴服务", 14306, 6);
		addPropertyDict("婚姻服务", 14307, 7);
		addPropertyDict("殡葬服务", 14308, 8);
		addPropertyDict("摄影扩印服务", 14309, 9);
		addPropertyDict("其他居民服务", 14310, 10);

		addPropertyDict("修理与维护", 14401, 1);
		addPropertyDict("汽车、摩托车维护与保养", 14402, 2);
		addPropertyDict("办公设备维修", 14403, 3);
		addPropertyDict("家用电器修理", 14404, 4);
		addPropertyDict("其他日用品修理", 14405, 5);
		addPropertyDict("清洁服务", 14406, 6);
		addPropertyDict("建筑物清洁服务", 14407, 7);
		addPropertyDict("其他清洁服务", 14408, 8);
		addPropertyDict("其他未列明的服务", 14409, 9);

		addPropertyDict("学前教育", 14501, 1);
		addPropertyDict("初等教育", 14502, 2);
		addPropertyDict("中等教育", 14503, 3);
		addPropertyDict("初中教育", 14504, 4);
		addPropertyDict("高中教育", 14505, 5);
		addPropertyDict("中等专业教育", 14506, 6);
		addPropertyDict("职业中学教育", 14507, 7);
		addPropertyDict("技工学校教育", 14508, 8);
		addPropertyDict("其他中等教育", 14509, 9);
		addPropertyDict("高等教育", 14510, 10);
		addPropertyDict("普通高等教育", 14511, 11);
		addPropertyDict("成人高等教育", 14512, 12);
		addPropertyDict("其他教育", 14513, 13);

		addPropertyDict("特殊教育", 14601, 1);
		addPropertyDict("其他未列明的教育", 14602, 2);

		addPropertyDict("卫生", 14701, 1);
		addPropertyDict("医院", 14702, 2);
		addPropertyDict("综合医院", 14703, 3);
		addPropertyDict("中医医院", 14704, 4);
		addPropertyDict("中西医结合医院", 14705, 5);
		addPropertyDict("民族医院", 14706, 6);
		addPropertyDict("专科医院", 14707, 7);
		addPropertyDict("疗养院", 14708, 8);
		addPropertyDict("社区卫生医疗活动", 14709, 9);
		addPropertyDict("卫生院", 14710, 10);
		addPropertyDict("门诊部医疗活动", 14711, 11);
		addPropertyDict("妇幼保健活动", 14712, 12);
		addPropertyDict("专科疾病防治活动", 14713, 13);
		addPropertyDict("疾病预防控制及防疫活动", 14714, 14);
		addPropertyDict("其他卫生活动", 14715, 15);
		addPropertyDict("社会保障业", 14716, 16);
		addPropertyDict("社会福利业", 14717, 17);
		addPropertyDict("提供住宿的社会福利", 14718, 18);
		addPropertyDict("干部休养所", 14719, 19);
		addPropertyDict("收养收容服务", 14720, 20);
		addPropertyDict("不提供住宿的社会福利", 14721, 21);

		addPropertyDict("新闻出版业", 14801, 1);
		addPropertyDict("新闻业", 14802, 2);
		addPropertyDict("出版业", 14803, 3);
		addPropertyDict("图书出版", 14804, 4);
		addPropertyDict("报纸出版", 14805, 5);
		addPropertyDict("期刊出版", 14806, 6);
		addPropertyDict("音像制品出版", 14807, 7);
		addPropertyDict("电子出版物出版", 14808, 8);
		addPropertyDict("其他出版", 14809, 9);

		addPropertyDict("广播", 14901, 1);
		addPropertyDict("电视", 14902, 2);
		addPropertyDict("电影", 14903, 3);
		addPropertyDict("电影制作与发行", 14904, 4);
		addPropertyDict("电影放映", 14905, 5);
		addPropertyDict("音像制作", 14906, 6);
		addPropertyDict("文化艺术业", 14907, 7);
		addPropertyDict("文艺创作与表演", 14908, 8);
		addPropertyDict("艺术表演场馆", 14909, 9);
		addPropertyDict("图书馆与档案馆", 14910, 10);
		addPropertyDict("图书馆", 14911, 11);
		addPropertyDict("档案馆", 14912, 12);
		addPropertyDict("文物及文化保护", 14913, 13);
		addPropertyDict("博物馆", 14914, 14);
		addPropertyDict("烈士陵园、纪念馆", 14915, 15);
		addPropertyDict("群众文化活动", 14916, 16);
		addPropertyDict("文化艺术经纪代理", 14917, 17);
		addPropertyDict("其他文化艺术", 14918, 18);
		addPropertyDict("体育", 14919, 19);
		addPropertyDict("体育组织", 14920, 20);
		addPropertyDict("体育场馆", 14921, 21);
		addPropertyDict("其他体育", 14922, 22);
		addPropertyDict("娱乐业", 14923, 23);
		addPropertyDict("室内娱乐活动", 14924, 24);
		addPropertyDict("游乐园", 14925, 25);
		addPropertyDict("休闲健身娱乐活动", 14926, 26);
		addPropertyDict("其他娱乐活动", 14927, 27);

		addPropertyDict("中国共产党机关", 15001, 1);
		addPropertyDict("国家机构", 15002, 2);
		addPropertyDict("国家权力机构", 15003, 3);
		addPropertyDict("国家行政机构", 15004, 4);
		addPropertyDict("综合事务管理机构", 15005, 5);
		addPropertyDict("对外事务管理机构", 15006, 6);
		addPropertyDict("公共安全管理机构", 15007, 7);
		addPropertyDict("社会事务管理机构", 15008, 8);
		addPropertyDict("经济事务管理机构", 15009, 9);
		addPropertyDict("政府事务管理机构", 15010, 10);
		addPropertyDict("行政监督检查机构", 15011, 11);
		addPropertyDict("人民法院和人民检察院", 15012, 12);
		addPropertyDict("人民法院", 15013, 13);
		addPropertyDict("人民检察院", 15014, 14);
		addPropertyDict("其他国家机构", 15015, 15);
		addPropertyDict("人民政协和民主党派", 15016, 16);
		addPropertyDict("人民政协", 15017, 17);
		addPropertyDict("民主党派", 15018, 18);
		addPropertyDict("群众团体、社会团体和宗教组织", 15019, 19);
		addPropertyDict("群众团体", 15020, 20);
		addPropertyDict("工会", 15021, 21);
		addPropertyDict("妇联", 15022, 22);
		addPropertyDict("共青团", 15023, 23);
		addPropertyDict("其他群众团体", 15024, 24);
		addPropertyDict("社会团体", 15025, 25);
		addPropertyDict("专业性团体", 15026, 26);
		addPropertyDict("行业性团体", 15027, 27);
		addPropertyDict("其他社会团体", 15028, 28);
		addPropertyDict("宗教组织", 15029, 29);
		addPropertyDict("基层群众自治组织", 15030, 30);
		addPropertyDict("社区自治组织", 15031, 31);
		addPropertyDict("村民自治组织", 15032, 32);
	}

	private void initBasin() {
		propertyDomain = addPropertyDomain(PropertyTypes.BASIN, false, null);
		addPropertyDict("长江流域", 0, 1);
		addPropertyDict("通天河", 0, 2);
		addPropertyDict("沱沱河（玛曲）", 0, 3);
		addPropertyDict("波陇曲", 0, 4);
		addPropertyDict("斜日贡尼曲", 0, 5);
		addPropertyDict("扎木曲", 0, 6);
		addPropertyDict("当曲", 0, 7);
		addPropertyDict("庭曲", 0, 8);
		addPropertyDict("布曲", 0, 9);
		addPropertyDict("尕尔曲（尕日曲）", 0, 10);
		addPropertyDict("冬曲（旦曲）", 0, 11);
		addPropertyDict("握布龙曲", 0, 12);
		addPropertyDict("沙丁曲", 0, 13);
		addPropertyDict("查曲", 0, 14);
		addPropertyDict("吾钦曲", 0, 15);
		addPropertyDict("查午曲", 0, 16);
		addPropertyDict("果曲", 0, 17);
		addPropertyDict("郭纽曲", 0, 18);
		addPropertyDict("日阿尺曲", 0, 19);
		addPropertyDict("冬布里曲", 0, 20);
		addPropertyDict("莫曲", 0, 21);
		addPropertyDict("巴子曲", 0, 22);
		addPropertyDict("君曲", 0, 23);
		addPropertyDict("牙哥曲", 0, 24);
		addPropertyDict("帮曲", 0, 25);
		addPropertyDict("北麓曲（勒玛曲）", 0, 26);
		addPropertyDict("科欠曲", 0, 27);
		addPropertyDict("勒池曲", 0, 28);
		addPropertyDict("楚玛尔河", 0, 29);
		addPropertyDict("扎日尕那曲", 0, 30);
		addPropertyDict("牙扎曲", 0, 31);
		addPropertyDict("色吾曲", 0, 32);
		addPropertyDict("昂日曲", 0, 33);
		addPropertyDict("宁恰曲", 0, 34);
		addPropertyDict("多来曲", 0, 35);
		addPropertyDict("登艾龙曲（登额曲）", 0, 36);
		addPropertyDict("德曲", 0, 37);
		addPropertyDict("曼宗曲", 0, 38);
		addPropertyDict("叶曲（益曲）", 0, 39);
		addPropertyDict("沱江", 0, 40);
		addPropertyDict("巴塘河", 0, 41);
		addPropertyDict("加日河", 0, 42);
		addPropertyDict("盖哈沟", 0, 43);
		addPropertyDict("俄沟", 0, 44);
		addPropertyDict("夕河", 0, 45);
		addPropertyDict("白曲", 0, 46);
		addPropertyDict("麦宿河", 0, 47);
		addPropertyDict("登龙沟", 0, 48);
		addPropertyDict("赠曲", 0, 49);
		addPropertyDict("卡曲", 0, 50);
		addPropertyDict("图根曲", 0, 51);
		addPropertyDict("朵拉曲", 0, 52);
		addPropertyDict("欧曲（偶曲）", 0, 53);
		addPropertyDict("边坝河", 0, 54);
		addPropertyDict("藏曲", 0, 55);
		addPropertyDict("字曲", 0, 56);
		addPropertyDict("热曲", 0, 57);
		addPropertyDict("马曲", 0, 58);
		addPropertyDict("哇曲", 0, 59);
		addPropertyDict("降曲", 0, 60);
		addPropertyDict("西曲", 0, 61);
		addPropertyDict("曲戈河（巴塘河、巴曲）", 0, 62);
		addPropertyDict("达拉河（宗曲）", 0, 63);
		addPropertyDict("鲁州河", 0, 64);
		addPropertyDict("仁波河（麦曲）", 0, 65);
		addPropertyDict("中岩曲", 0, 66);
		addPropertyDict("松麦河（定曲）", 0, 67);
		addPropertyDict("马衣河", 0, 68);
		addPropertyDict("硕衣河（硕曲河、乡城河）", 0, 69);
		addPropertyDict("翁水河", 0, 70);
		addPropertyDict("格咱河", 0, 71);
		addPropertyDict("支巴洛河", 0, 72);
		addPropertyDict("腊普河", 0, 73);
		addPropertyDict("冲江河", 0, 74);
		addPropertyDict("硕多岗河（硕多图河）", 0, 75);
		addPropertyDict("水落河", 0, 76);
		addPropertyDict("稻城河", 0, 77);
		addPropertyDict("拉波河", 0, 78);
		addPropertyDict("赤土河", 0, 79);
		addPropertyDict("东义河", 0, 80);
		addPropertyDict("尼汝河", 0, 81);
		addPropertyDict("五郎河", 0, 82);
		addPropertyDict("漾弓河", 0, 83);
		addPropertyDict("落漏河", 0, 84);
		addPropertyDict("达旦河", 0, 85);
		addPropertyDict("渔泡河（泡江）", 0, 86);
		addPropertyDict("涟河", 0, 87);
		addPropertyDict("马过河", 0, 88);
		addPropertyDict("万马河", 0, 89);
		addPropertyDict("新庄河", 0, 90);
		addPropertyDict("龙川江", 0, 91);
		addPropertyDict("石者河", 0, 92);
		addPropertyDict("紫甸河", 0, 93);
		addPropertyDict("蜻蛉河", 0, 94);
		addPropertyDict("永仁河", 0, 95);
		addPropertyDict("勐果河", 0, 96);
		addPropertyDict("普隆河", 0, 97);
		addPropertyDict("会川河", 0, 98);
		addPropertyDict("鲹鱼河", 0, 99);
		addPropertyDict("普渡河", 0, 100);
		addPropertyDict("掌鸠河", 0, 101);
		addPropertyDict("螳螂川", 0, 102);
		addPropertyDict("滇池", 0, 103);
		addPropertyDict("蟒栗河", 0, 104);
		addPropertyDict("款庄河", 0, 105);
		addPropertyDict("洗马河", 0, 106);
		addPropertyDict("可郎河", 0, 107);
		addPropertyDict("大桥河", 0, 108);
		addPropertyDict("小江", 0, 109);
		addPropertyDict("块河", 0, 110);
		addPropertyDict("以礼河", 0, 111);
		addPropertyDict("四甲河", 0, 112);
		addPropertyDict("蚂蟥河", 0, 113);
		addPropertyDict("黑水河", 0, 114);
		addPropertyDict("西罗河", 0, 115);
		addPropertyDict("西溪河", 0, 116);
		addPropertyDict("金曲", 0, 117);
		addPropertyDict("则普拉达河", 0, 118);
		addPropertyDict("牛栏江", 0, 119);
		addPropertyDict("硝河", 0, 120);
		addPropertyDict("哈喇河", 0, 121);
		addPropertyDict("西泽河", 0, 122);
		addPropertyDict("马龙河", 0, 123);
		addPropertyDict("美姑河", 0, 124);
		addPropertyDict("西宁河", 0, 125);
		addPropertyDict("中都河", 0, 126);
		addPropertyDict("横江", 0, 127);
		addPropertyDict("拖落河", 0, 128);
		addPropertyDict("洛泽河", 0, 129);
		addPropertyDict("白水河", 0, 130);
		addPropertyDict("奕良小河", 0, 131);
		addPropertyDict("牛街河", 0, 132);
		addPropertyDict("洒鱼河", 0, 133);
		addPropertyDict("大关河", 0, 134);
		addPropertyDict("南广河", 0, 135);
		addPropertyDict("筠连河", 0, 136);
		addPropertyDict("黄沙河", 0, 137);
		addPropertyDict("长宁河", 0, 138);
		addPropertyDict("泯溪河", 0, 139);
		addPropertyDict("永宁河", 0, 140);
		addPropertyDict("古宋河", 0, 141);
		addPropertyDict("沱江（锦远河）", 0, 142);
		addPropertyDict("湔江", 0, 143);
		addPropertyDict("石亭江", 0, 144);
		addPropertyDict("鸭子河", 0, 145);
		addPropertyDict("蒲阳江", 0, 146);
		addPropertyDict("清溪河", 0, 147);
		addPropertyDict("降溪河", 0, 148);
		addPropertyDict("资水河（阳化河）", 0, 149);
		addPropertyDict("东禅沟", 0, 150);
		addPropertyDict("九曲河", 0, 151);
		addPropertyDict("球溪河", 0, 152);
		addPropertyDict("通江河", 0, 153);
		addPropertyDict("麻柳河", 0, 154);
		addPropertyDict("蒙溪河", 0, 155);
		addPropertyDict("朝阳河", 0, 156);
		addPropertyDict("龙江", 0, 157);
		addPropertyDict("大清流河", 0, 158);
		addPropertyDict("小清流河", 0, 159);
		addPropertyDict("釜溪河", 0, 160);
		addPropertyDict("荣溪河", 0, 161);
		addPropertyDict("威远河", 0, 162);
		addPropertyDict("长江流域-沱江-沱江（锦远河）-白吉子河", 0, 163);
		addPropertyDict("胡市河（濑溪河）", 0, 164);
		addPropertyDict("库录河", 0, 165);
		addPropertyDict("赤水河", 0, 166);
		addPropertyDict("雨河", 0, 167);
		addPropertyDict("倒流河", 0, 168);
		addPropertyDict("马洛河", 0, 169);
		addPropertyDict("鱼洞河", 0, 170);
		addPropertyDict("二道河", 0, 171);
		addPropertyDict("桐梓河（牛渡河）", 0, 172);
		addPropertyDict("混子河", 0, 173);
		addPropertyDict("沙溪场大河", 0, 174);
		addPropertyDict("古蔺河", 0, 175);
		addPropertyDict("大村河", 0, 176);
		addPropertyDict("大同河", 0, 177);
		addPropertyDict("习水河", 0, 178);
		addPropertyDict("松溉河", 0, 179);
		addPropertyDict("永川河", 0, 180);
		addPropertyDict("塘河", 0, 181);
		addPropertyDict("小槽河", 0, 182);
		addPropertyDict("大槽河", 0, 183);
		addPropertyDict("壁河（壁南河）", 0, 184);
		addPropertyDict("九龙河", 0, 185);
		addPropertyDict("綦江", 0, 186);
		addPropertyDict("蒲河", 0, 187);
		addPropertyDict("藻渡河", 0, 188);
		addPropertyDict("松坎河", 0, 189);
		addPropertyDict("笋溪河", 0, 190);
		addPropertyDict("茶坝河", 0, 191);
		addPropertyDict("三溪", 0, 192);
		addPropertyDict("箭滩河", 0, 193);
		addPropertyDict("木洞河（五步河）", 0, 194);
		addPropertyDict("御临河（大洪河）", 0, 195);
		addPropertyDict("东河", 0, 196);
		addPropertyDict("桃花溪", 0, 197);
		addPropertyDict("龙溪河（高滩河）", 0, 198);
		addPropertyDict("大沙河", 0, 199);
		addPropertyDict("回龙河", 0, 200);
		addPropertyDict("黎香溪", 0, 201);
		addPropertyDict("渠溪河", 0, 202);
		addPropertyDict("龙河", 0, 203);
		addPropertyDict("黄金河（干井沟）", 0, 204);
		addPropertyDict("汝溪河", 0, 205);
		addPropertyDict("壤渡河", 0, 206);
		addPropertyDict("小江（东河）", 0, 207);
		addPropertyDict("江里河（桃溪河）", 0, 208);
		addPropertyDict("普里江", 0, 209);
		addPropertyDict("汤溪河", 0, 210);
		addPropertyDict("弯滩河", 0, 211);
		addPropertyDict("磨刀溪", 0, 212);
		addPropertyDict("驷步河", 0, 213);
		addPropertyDict("泥溪河", 0, 214);
		addPropertyDict("长滩河", 0, 215);
		addPropertyDict("梅溪河", 0, 216);
		addPropertyDict("大溪河（五马河）", 0, 217);
		addPropertyDict("新民河", 0, 218);
		addPropertyDict("大宁河", 0, 219);
		addPropertyDict("东溪河", 0, 220);
		addPropertyDict("后溪河", 0, 221);
		addPropertyDict("抱龙河", 0, 222);
		addPropertyDict("边鱼溪（巫峡）", 0, 223);
		addPropertyDict("万石河", 0, 224);
		addPropertyDict("沿渡河（龙船河）", 0, 225);
		addPropertyDict("三溪河（西陵峡）", 0, 226);
		addPropertyDict("清干河", 0, 227);
		addPropertyDict("叱溪河", 0, 228);
		addPropertyDict("香溪", 0, 229);
		addPropertyDict("九冲河", 0, 230);
		addPropertyDict("高岚河", 0, 231);
		addPropertyDict("长江中下游干流", 0, 232);
		addPropertyDict("清江", 0, 233);
		addPropertyDict("沮漳河", 0, 234);
		addPropertyDict("漳河", 0, 235);
		addPropertyDict("陆水", 0, 236);
		addPropertyDict("内荆河（荆河）", 0, 237);
		addPropertyDict("东荆河", 0, 238);
		addPropertyDict("金水", 0, 239);
		addPropertyDict("府不河（府河）", 0, 240);
		addPropertyDict("九道水", 0, 241);
		addPropertyDict("厥水", 0, 242);
		addPropertyDict("均水", 0, 243);
		addPropertyDict("差水", 0, 244);
		addPropertyDict("刘家河", 0, 245);
		addPropertyDict("漂水", 0, 246);
		addPropertyDict("浪河", 0, 247);
		addPropertyDict("余店河", 0, 248);
		addPropertyDict("徐家河", 0, 249);
		addPropertyDict("漳水", 0, 250);
		addPropertyDict("不水", 0, 251);
		addPropertyDict("广水河", 0, 252);
		addPropertyDict("应山河", 0, 253);
		addPropertyDict("大悟河", 0, 254);
		addPropertyDict("滠水", 0, 255);
		addPropertyDict("西大河", 0, 256);
		addPropertyDict("倒水", 0, 257);
		addPropertyDict("举水", 0, 258);
		addPropertyDict("浮桥河", 0, 259);
		addPropertyDict("阎家河", 0, 260);
		addPropertyDict("沙河", 0, 261);
		addPropertyDict("高桥河", 0, 262);
		addPropertyDict("长港", 0, 263);
		addPropertyDict("巴河", 0, 264);
		addPropertyDict("白庙河", 0, 265);
		addPropertyDict("天堂河", 0, 266);
		addPropertyDict("浠水", 0, 267);
		addPropertyDict("西河", 0, 268);
		addPropertyDict("白莲河", 0, 269);
		addPropertyDict("大港", 0, 270);
		addPropertyDict("雷溪河", 0, 271);
		addPropertyDict("蕲水", 0, 272);
		addPropertyDict("富水", 0, 273);
		addPropertyDict("通山河", 0, 274);
		addPropertyDict("横石河", 0, 275);
		addPropertyDict("龙港河", 0, 276);
		addPropertyDict("三溪河", 0, 277);
		addPropertyDict("长河", 0, 278);
		addPropertyDict("龙坪河", 0, 279);
		addPropertyDict("郎河", 0, 280);
		addPropertyDict("华阳河", 0, 281);
		addPropertyDict("尧渡新河", 0, 282);
		addPropertyDict("皖河（长河）", 0, 283);
		addPropertyDict("太湖河", 0, 284);
		addPropertyDict("牛镇河", 0, 285);
		addPropertyDict("潜水", 0, 286);
		addPropertyDict("皖水", 0, 287);
		addPropertyDict("黄盆河", 0, 288);
		addPropertyDict("大沙河（柏年河、莱子湖）", 0, 289);
		addPropertyDict("挂车河", 0, 290);
		addPropertyDict("孔城河", 0, 291);
		addPropertyDict("龙眼河", 0, 292);
		addPropertyDict("秋蒲河", 0, 293);
		addPropertyDict("龙舒河", 0, 294);
		addPropertyDict("白洋河", 0, 295);
		addPropertyDict("罗昌河", 0, 296);
		addPropertyDict("梅埂河", 0, 297);
		addPropertyDict("青通河", 0, 298);
		addPropertyDict("南河", 0, 299);
		addPropertyDict("青戈江", 0, 300);
		addPropertyDict("麻川河（麻河）", 0, 301);
		addPropertyDict("徽水", 0, 302);
		addPropertyDict("水阳江（青山河）", 0, 303);
		addPropertyDict("西津河", 0, 304);
		addPropertyDict("东津河", 0, 305);
		addPropertyDict("郎溪河", 0, 306);
		addPropertyDict("郎川河", 0, 307);
		addPropertyDict("流洞河", 0, 308);
		addPropertyDict("无量河", 0, 309);
		addPropertyDict("瑞水河", 0, 310);
		addPropertyDict("姑溪河", 0, 311);
		addPropertyDict("裕溪河（巢湖）", 0, 312);
		addPropertyDict("丰乐河", 0, 313);
		addPropertyDict("杭埠河", 0, 314);
		addPropertyDict("晓天河", 0, 315);
		addPropertyDict("上派河", 0, 316);
		addPropertyDict("南肥河", 0, 317);
		addPropertyDict("得胜河", 0, 318);
		addPropertyDict("秦淮河", 0, 319);
		addPropertyDict("句容河", 0, 320);
		addPropertyDict("滁河", 0, 321);
		addPropertyDict("襄河", 0, 322);
		addPropertyDict("清流河", 0, 323);
		addPropertyDict("来安河（乌衣河）", 0, 324);
		addPropertyDict("京杭运河（江南运河）", 0, 325);
		addPropertyDict("界河", 0, 326);
		addPropertyDict("东姜黄河", 0, 327);
		addPropertyDict("如海运河", 0, 328);
		addPropertyDict("通杨运河", 0, 329);
		addPropertyDict("通吕运河", 0, 330);
		addPropertyDict("三和港", 0, 331);
		addPropertyDict("通启运河", 0, 332);
		addPropertyDict("雅砻江", 0, 333);
		addPropertyDict("扎曲", 0, 334);
		addPropertyDict("牙河", 0, 335);
		addPropertyDict("麻摩柯河（麻母河）", 0, 336);
		addPropertyDict("江秋河", 0, 337);
		addPropertyDict("鄂曲（俄溪）", 0, 338);
		addPropertyDict("石渠河", 0, 339);
		addPropertyDict("通把河（拉马河）", 0, 340);
		addPropertyDict("文柯共马河", 0, 341);
		addPropertyDict("俄柯河（各雍河）", 0, 342);
		addPropertyDict("俄木其（长须沟）", 0, 343);
		addPropertyDict("三岔河", 0, 344);
		addPropertyDict("舍卡河（定柯河、定曲）", 0, 345);
		addPropertyDict("玉隆河", 0, 346);
		addPropertyDict("玉曲", 0, 347);
		addPropertyDict("达火沟", 0, 348);
		addPropertyDict("阿色沟", 0, 349);
		addPropertyDict("拉达沟", 0, 350);
		addPropertyDict("瓦日沟", 0, 351);
		addPropertyDict("通宵河", 0, 352);
		addPropertyDict("热衣曲", 0, 353);
		addPropertyDict("君坝河", 0, 354);
		addPropertyDict("如曲", 0, 355);
		addPropertyDict("鲜水河（泥曲）", 0, 356);
		addPropertyDict("达曲河", 0, 357);
		addPropertyDict("阿拉沟", 0, 358);
		addPropertyDict("木鲁若河", 0, 359);
		addPropertyDict("拉日马沟（拉曲）", 0, 360);
		addPropertyDict("假柯河", 0, 361);
		addPropertyDict("庆达河", 0, 362);
		addPropertyDict("莫果坝沟", 0, 363);
		addPropertyDict("德差河（霍曲河）", 0, 364);
		addPropertyDict("吉珠沟", 0, 365);
		addPropertyDict("力丘沟", 0, 366);
		addPropertyDict("塔拉沟", 0, 367);
		addPropertyDict("色物绒沟", 0, 368);
		addPropertyDict("理塘河（无量河）", 0, 369);
		addPropertyDict("哈错", 0, 370);
		addPropertyDict("卧落河", 0, 371);
		addPropertyDict("宁蒗河", 0, 372);
		addPropertyDict("前所河", 0, 373);
		addPropertyDict("泸沽湖", 0, 374);
		addPropertyDict("踏卡河", 0, 375);
		addPropertyDict("敢鱼河", 0, 376);
		addPropertyDict("惠民河", 0, 377);
		addPropertyDict("安宁河", 0, 378);
		addPropertyDict("西礼渠", 0, 379);
		addPropertyDict("孙水河", 0, 380);
		addPropertyDict("海河", 0, 381);
		addPropertyDict("邛海", 0, 382);
		addPropertyDict("锦川河", 0, 383);
		addPropertyDict("岷江", 0, 384);
		addPropertyDict("羊洞河", 0, 385);
		addPropertyDict("箭板河", 0, 386);
		addPropertyDict("沐川河", 0, 387);
		addPropertyDict("马边河", 0, 388);
		addPropertyDict("越溪河", 0, 389);
		addPropertyDict("沙沟河", 0, 390);
		addPropertyDict("茫溪河", 0, 391);
		addPropertyDict("漳金河", 0, 392);
		addPropertyDict("小姓沟", 0, 393);
		addPropertyDict("毛尔盖河", 0, 394);
		addPropertyDict("小黑水", 0, 395);
		addPropertyDict("打古河", 0, 396);
		addPropertyDict("赤不苏河", 0, 397);
		addPropertyDict("杂古脑河", 0, 398);
		addPropertyDict("孟屯沟", 0, 399);
		addPropertyDict("渔子溪", 0, 400);
		addPropertyDict("皮条沟", 0, 401);
		addPropertyDict("大南河", 0, 402);
		addPropertyDict("文锦江", 0, 403);
		addPropertyDict("斜江", 0, 404);
		addPropertyDict("蒲江河", 0, 405);
		addPropertyDict("临溪河", 0, 406);
		addPropertyDict("铁溪河", 0, 407);
		addPropertyDict("府河", 0, 408);
		addPropertyDict("东风渠", 0, 409);
		addPropertyDict("杨柳河", 0, 410);
		addPropertyDict("柏条河", 0, 411);
		addPropertyDict("人民渠", 0, 412);
		addPropertyDict("清白江", 0, 413);
		addPropertyDict("涛江", 0, 414);
		addPropertyDict("大渡河（马柯河、大金川）", 0, 415);
		addPropertyDict("马尔曲", 0, 416);
		addPropertyDict("俄柯河", 0, 417);
		addPropertyDict("热尔卡河", 0, 418);
		addPropertyDict("于青河", 0, 419);
		addPropertyDict("尼柯河", 0, 420);
		addPropertyDict("阿柯河", 0, 421);
		addPropertyDict("克柯河", 0, 422);
		addPropertyDict("作柯河", 0, 423);
		addPropertyDict("东柯河", 0, 424);
		addPropertyDict("达柯河", 0, 425);
		addPropertyDict("青坪河", 0, 426);
		addPropertyDict("梭磨河", 0, 427);
		addPropertyDict("绰斯甲河（杜柯河）", 0, 428);
		addPropertyDict("多洛河", 0, 429);
		addPropertyDict("夏曲河", 0, 430);
		addPropertyDict("色曲", 0, 431);
		addPropertyDict("中科河", 0, 432);
		addPropertyDict("俄日沟（俄垫河）", 0, 433);
		addPropertyDict("太阳河", 0, 434);
		addPropertyDict("革斯扎河", 0, 435);
		addPropertyDict("磨子沟", 0, 436);
		addPropertyDict("东谷河", 0, 437);
		addPropertyDict("小金川", 0, 438);
		addPropertyDict("抚边河", 0, 439);
		addPropertyDict("达维河（沃日河）", 0, 440);
		addPropertyDict("结斯河", 0, 441);
		addPropertyDict("金汤河（上鱼河）", 0, 442);
		addPropertyDict("瓦斯沟（雅拉河）", 0, 443);
		addPropertyDict("田湾沟（田湾小河）", 0, 444);
		addPropertyDict("安顺河", 0, 445);
		addPropertyDict("南桠河", 0, 446);
		addPropertyDict("流沙河", 0, 447);
		addPropertyDict("牛日河", 0, 448);
		addPropertyDict("普雄河", 0, 449);
		addPropertyDict("甘洛河", 0, 450);
		addPropertyDict("官庙河", 0, 451);
		addPropertyDict("青衣江（宝兴河、芦山河）", 0, 452);
		addPropertyDict("玉溪河（大川河）", 0, 453);
		addPropertyDict("天全河", 0, 454);
		addPropertyDict("名山河", 0, 455);
		addPropertyDict("荥经河", 0, 456);
		addPropertyDict("经河", 0, 457);
		addPropertyDict("周公河", 0, 458);
		addPropertyDict("花溪河", 0, 459);
		addPropertyDict("安溪河", 0, 460);
		addPropertyDict("长征渠", 0, 461);
		addPropertyDict("嘉陵江", 0, 462);
		addPropertyDict("小峪河", 0, 463);
		addPropertyDict("红崖河", 0, 464);
		addPropertyDict("旺峪河", 0, 465);
		addPropertyDict("前川", 0, 466);
		addPropertyDict("永宁河（党家川）", 0, 467);
		addPropertyDict("白家河", 0, 468);
		addPropertyDict("罗家河", 0, 469);
		addPropertyDict("江洛河（洛河）", 0, 470);
		addPropertyDict("青泥河", 0, 471);
		addPropertyDict("黄家河", 0, 472);
		addPropertyDict("西汉水", 0, 473);
		addPropertyDict("峁水河", 0, 474);
		addPropertyDict("燕子河", 0, 475);
		addPropertyDict("洮水河", 0, 476);
		addPropertyDict("清水河", 0, 477);
		addPropertyDict("太石河", 0, 478);
		addPropertyDict("六巷河", 0, 479);
		addPropertyDict("平洛河", 0, 480);
		addPropertyDict("窑坪河", 0, 481);
		addPropertyDict("八渡河", 0, 482);
		addPropertyDict("乐素河", 0, 483);
		addPropertyDict("巩家河", 0, 484);
		addPropertyDict("清河", 0, 485);
		addPropertyDict("铜钱河", 0, 486);
		addPropertyDict("安乐河", 0, 487);
		addPropertyDict("广坪河（羊漠河）", 0, 488);
		addPropertyDict("白龙江", 0, 489);
		addPropertyDict("达拉沟", 0, 490);
		addPropertyDict("多儿沟", 0, 491);
		addPropertyDict("拱坝河", 0, 492);
		addPropertyDict("五库河", 0, 493);
		addPropertyDict("白水江", 0, 494);
		addPropertyDict("丹堡河", 0, 495);
		addPropertyDict("中路河", 0, 496);
		addPropertyDict("白河", 0, 497);
		addPropertyDict("让水河", 0, 498);
		addPropertyDict("大团鱼河", 0, 499);
		addPropertyDict("青川河", 0, 500);
		addPropertyDict("金溪河", 0, 501);
		addPropertyDict("下寺河", 0, 502);
		addPropertyDict("闻溪河", 0, 503);
		addPropertyDict("白溪濠", 0, 504);
		addPropertyDict("东河（宽滩河）", 0, 505);
		addPropertyDict("盐井河（毛坝河）", 0, 506);
		addPropertyDict("插江", 0, 507);
		addPropertyDict("苟溪河", 0, 508);
		addPropertyDict("董家沟", 0, 509);
		addPropertyDict("杨河", 0, 510);
		addPropertyDict("螺溪河", 0, 511);
		addPropertyDict("西充河", 0, 512);
		addPropertyDict("酉溪河", 0, 513);
		addPropertyDict("街子河", 0, 514);
		addPropertyDict("渠江（南江、巴河）", 0, 515);
		addPropertyDict("神潭河", 0, 516);
		addPropertyDict("恩阳河（白水河）", 0, 517);
		addPropertyDict("毛溪河", 0, 518);
		addPropertyDict("渔溪河", 0, 519);
		addPropertyDict("鳌西河", 0, 520);
		addPropertyDict("坦溪河（驷马河）", 0, 521);
		addPropertyDict("大通江（通江）", 0, 522);
		addPropertyDict("铁溪", 0, 523);
		addPropertyDict("肖口河（洋河）", 0, 524);
		addPropertyDict("小通江", 0, 525);
		addPropertyDict("澌滩河", 0, 526);
		addPropertyDict("长滩河（长河）", 0, 527);
		addPropertyDict("州河", 0, 528);
		addPropertyDict("东柳河", 0, 529);
		addPropertyDict("明月江", 0, 530);
		addPropertyDict("新宁河", 0, 531);
		addPropertyDict("前河", 0, 532);
		addPropertyDict("后河", 0, 533);
		addPropertyDict("中河", 0, 534);
		addPropertyDict("白沙河", 0, 535);
		addPropertyDict("铜钵河（潼宝河）", 0, 536);
		addPropertyDict("流江河（仪陇河、林岗溪）", 0, 537);
		addPropertyDict("消水河", 0, 538);
		addPropertyDict("中滩河", 0, 539);
		addPropertyDict("肖水河", 0, 540);
		addPropertyDict("驴溪河", 0, 541);
		addPropertyDict("涪江", 0, 542);
		addPropertyDict("虎牙河", 0, 543);
		addPropertyDict("火溪河", 0, 544);
		addPropertyDict("平通河", 0, 545);
		addPropertyDict("通口河", 0, 546);
		addPropertyDict("土门河", 0, 547);
		addPropertyDict("青片河", 0, 548);
		addPropertyDict("白草河", 0, 549);
		addPropertyDict("安昌河", 0, 550);
		addPropertyDict("杜家河", 0, 551);
		addPropertyDict("凯江", 0, 552);
		addPropertyDict("梓潼江", 0, 553);
		addPropertyDict("魏城河", 0, 554);
		addPropertyDict("洋溪河", 0, 555);
		addPropertyDict("梁滩河", 0, 556);
		addPropertyDict("黑水滩河", 0, 557);
		addPropertyDict("乌江", 0, 558);
		addPropertyDict("大河", 0, 559);
		addPropertyDict("阿勒河", 0, 560);
		addPropertyDict("夕阳河", 0, 561);
		addPropertyDict("波玉河", 0, 562);
		addPropertyDict("鸭池河（大溪河）", 0, 563);
		addPropertyDict("石梁河", 0, 564);
		addPropertyDict("六冲河", 0, 565);
		addPropertyDict("红岩河", 0, 566);
		addPropertyDict("以萨太河", 0, 567);
		addPropertyDict("引底河", 0, 568);
		addPropertyDict("白甫河（落脚河）", 0, 569);
		addPropertyDict("猫跳河", 0, 570);
		addPropertyDict("暗流河", 0, 571);
		addPropertyDict("野济河（耳海河）", 0, 572);
		addPropertyDict("息烽河", 0, 573);
		addPropertyDict("偏岩河", 0, 574);
		addPropertyDict("鱼塘河", 0, 575);
		addPropertyDict("谷撒河", 0, 576);
		addPropertyDict("湘江", 0, 577);
		addPropertyDict("湄江", 0, 578);
		addPropertyDict("洛安江", 0, 579);
		addPropertyDict("月塘河", 0, 580);
		addPropertyDict("清水江（南明江）", 0, 581);
		addPropertyDict("独水河", 0, 582);
		addPropertyDict("鱼梁河", 0, 583);
		addPropertyDict("瓮安河", 0, 584);
		addPropertyDict("泸塘河", 0, 585);
		addPropertyDict("余庆河", 0, 586);
		addPropertyDict("六池河（岩河）", 0, 587);
		addPropertyDict("石阡河", 0, 588);
		addPropertyDict("清渡河", 0, 589);
		addPropertyDict("印江河（印河）", 0, 590);
		addPropertyDict("马蹄河", 0, 591);
		addPropertyDict("甘龙河", 0, 592);
		addPropertyDict("小河", 0, 593);
		addPropertyDict("坝沱河", 0, 594);
		addPropertyDict("濯河（唐沿河）", 0, 595);
		addPropertyDict("马鹿河", 0, 596);
		addPropertyDict("太平河", 0, 597);
		addPropertyDict("细纱河", 0, 598);
		addPropertyDict("洪渡河", 0, 599);
		addPropertyDict("诸佛河", 0, 600);
		addPropertyDict("长溪河", 0, 601);
		addPropertyDict("郁江", 0, 602);
		addPropertyDict("后江河", 0, 603);
		addPropertyDict("中井河", 0, 604);
		addPropertyDict("普子河", 0, 605);
		addPropertyDict("芙蓉江", 0, 606);
		addPropertyDict("三江", 0, 607);
		addPropertyDict("梅江", 0, 608);
		addPropertyDict("洞庭湖水系", 0, 609);
		addPropertyDict("松滋河", 0, 610);
		addPropertyDict("危水", 0, 611);
		addPropertyDict("界溪河", 0, 612);
		addPropertyDict("枚溪河", 0, 613);
		addPropertyDict("虎渡河", 0, 614);
		addPropertyDict("沮水", 0, 615);
		addPropertyDict("藕池河", 0, 616);
		addPropertyDict("汨罗江", 0, 617);
		addPropertyDict("湄水", 0, 618);
		addPropertyDict("罗水", 0, 619);
		addPropertyDict("调骇河", 0, 620);
		addPropertyDict("新墙河", 0, 621);
		addPropertyDict("迪（沙）港河", 0, 622);
		addPropertyDict("澧水", 0, 623);
		addPropertyDict("大庸溪", 0, 624);
		addPropertyDict("茅溪", 0, 625);
		addPropertyDict("郁水", 0, 626);
		addPropertyDict("澧水南源", 0, 627);
		addPropertyDict("澧水中源", 0, 628);
		addPropertyDict("溇水", 0, 629);
		addPropertyDict("金藏水", 0, 630);
		addPropertyDict("潆水", 0, 631);
		addPropertyDict("零溪", 0, 632);
		addPropertyDict("蝶水", 0, 633);
		addPropertyDict("青山灌区灌溉渠系", 0, 634);
		addPropertyDict("道水", 0, 635);
		addPropertyDict("涔水", 0, 636);
		addPropertyDict("王家厂灌溉渠", 0, 637);
		addPropertyDict("龙头江（马尾河）", 0, 638);
		addPropertyDict("清水江", 0, 639);
		addPropertyDict("重安江", 0, 640);
		addPropertyDict("巴拉河", 0, 641);
		addPropertyDict("台江河", 0, 642);
		addPropertyDict("南哨河", 0, 643);
		addPropertyDict("交密河（巫密河）", 0, 644);
		addPropertyDict("乌下江", 0, 645);
		addPropertyDict("六洞河（洞河）", 0, 646);
		addPropertyDict("亮江", 0, 647);
		addPropertyDict("娄江", 0, 648);
		addPropertyDict("鉴江", 0, 649);
		addPropertyDict("沅江", 0, 650);
		addPropertyDict("白羊河", 0, 651);
		addPropertyDict("黄石水库干渠", 0, 652);
		addPropertyDict("深水", 0, 653);
		addPropertyDict("珠江溪", 0, 654);
		addPropertyDict("怡溪", 0, 655);
		addPropertyDict("洞庭溪", 0, 656);
		addPropertyDict("大汰溪", 0, 657);
		addPropertyDict("夷望溪", 0, 658);
		addPropertyDict("三里溪", 0, 659);
		addPropertyDict("渠水", 0, 660);
		addPropertyDict("通道河", 0, 661);
		addPropertyDict("无阳河", 0, 662);
		addPropertyDict("龙江河", 0, 663);
		addPropertyDict("车坝河", 0, 664);
		addPropertyDict("平溪河", 0, 665);
		addPropertyDict("巫水", 0, 666);
		addPropertyDict("岩背水", 0, 667);
		addPropertyDict("埘竹水", 0, 668);
		addPropertyDict("公溪河", 0, 669);
		addPropertyDict("溆水", 0, 670);
		addPropertyDict("高明溪", 0, 671);
		addPropertyDict("四都河", 0, 672);
		addPropertyDict("辰水（锦江）", 0, 673);
		addPropertyDict("小江河", 0, 674);
		addPropertyDict("普觉河", 0, 675);
		addPropertyDict("大梁河", 0, 676);
		addPropertyDict("黄土溪", 0, 677);
		addPropertyDict("武水", 0, 678);
		addPropertyDict("沱水", 0, 679);
		addPropertyDict("酉水", 0, 680);
		addPropertyDict("龙潭河", 0, 681);
		addPropertyDict("溶溪", 0, 682);
		addPropertyDict("洗车河", 0, 683);
		addPropertyDict("花垣河（松桃河）", 0, 684);
		addPropertyDict("白溪", 0, 685);
		addPropertyDict("猛洞河", 0, 686);
		addPropertyDict("施河", 0, 687);
		addPropertyDict("夫夷水", 0, 688);
		addPropertyDict("新寨河", 0, 689);
		addPropertyDict("大圳溉区灌溉渠系", 0, 690);
		addPropertyDict("资水", 0, 691);
		addPropertyDict("平溪", 0, 692);
		addPropertyDict("黄泥江", 0, 693);
		addPropertyDict("赧水", 0, 694);
		addPropertyDict("蓼水", 0, 695);
		addPropertyDict("西洋江", 0, 696);
		addPropertyDict("辰溪", 0, 697);
		addPropertyDict("邵水", 0, 698);
		addPropertyDict("檩江", 0, 699);
		addPropertyDict("伏龙江", 0, 700);
		addPropertyDict("大洋江", 0, 701);
		addPropertyDict("洋溪", 0, 702);
		addPropertyDict("油溪", 0, 703);
		addPropertyDict("渠江", 0, 704);
		addPropertyDict("敷溪", 0, 705);
		addPropertyDict("沂溪", 0, 706);
		addPropertyDict("桃花江", 0, 707);
		addPropertyDict("志溪河", 0, 708);
		addPropertyDict("灵渠", 0, 709);
		addPropertyDict("灌江", 0, 710);
		addPropertyDict("大西江（宣乡河）", 0, 711);
		addPropertyDict("紫溪河", 0, 712);
		addPropertyDict("石期河", 0, 713);
		addPropertyDict("潇水（沱水、深水）", 0, 714);
		addPropertyDict("凌江", 0, 715);
		addPropertyDict("麻江", 0, 716);
		addPropertyDict("永明河", 0, 717);
		addPropertyDict("宁远河（冷水河）", 0, 718);
		addPropertyDict("九嶷河", 0, 719);
		addPropertyDict("春水", 0, 720);
		addPropertyDict("宜江", 0, 721);
		addPropertyDict("浮江", 0, 722);
		addPropertyDict("贤水", 0, 723);
		addPropertyDict("芦洪江", 0, 724);
		addPropertyDict("祁水", 0, 725);
		addPropertyDict("白水", 0, 726);
		addPropertyDict("黄花（溪）河", 0, 727);
		addPropertyDict("归阳河", 0, 728);
		addPropertyDict("宜水", 0, 729);
		addPropertyDict("潭水", 0, 730);
		addPropertyDict("栗江", 0, 731);
		addPropertyDict("春陵水（钟水）", 0, 732);
		addPropertyDict("新田河", 0, 733);
		addPropertyDict("毛俊水（舜水）", 0, 734);
		addPropertyDict("车溪河", 0, 735);
		addPropertyDict("黄狮江", 0, 736);
		addPropertyDict("欧阳海水库灌溉渠系", 0, 737);
		addPropertyDict("蒸水", 0, 738);
		addPropertyDict("耒水（东江、沤水）", 0, 739);
		addPropertyDict("东江水库", 0, 740);
		addPropertyDict("淇江", 0, 741);
		addPropertyDict("淅江河", 0, 742);
		addPropertyDict("滁水", 0, 743);
		addPropertyDict("郴江", 0, 744);
		addPropertyDict("资兴水", 0, 745);
		addPropertyDict("米水（茶陵江）", 0, 746);
		addPropertyDict("河漠水", 0, 747);
		addPropertyDict("斜濑水", 0, 748);
		addPropertyDict("泻河", 0, 749);
		addPropertyDict("马伏江", 0, 750);
		addPropertyDict("茶水", 0, 751);
		addPropertyDict("攸水", 0, 752);
		addPropertyDict("永乐江", 0, 753);
		addPropertyDict("青山垅灌区灌溉渠", 0, 754);
		addPropertyDict("渌水", 0, 755);
		addPropertyDict("萍水", 0, 756);
		addPropertyDict("麻山河", 0, 757);
		addPropertyDict("南溪", 0, 758);
		addPropertyDict("栗水", 0, 759);
		addPropertyDict("铁河", 0, 760);
		addPropertyDict("涟水", 0, 761);
		addPropertyDict("涓水", 0, 762);
		addPropertyDict("侧水(湄水)", 0, 763);
		addPropertyDict("桥头河", 0, 764);
		addPropertyDict("韶山溉区总干渠", 0, 765);
		addPropertyDict("靳江河", 0, 766);
		addPropertyDict("浏阳河", 0, 767);
		addPropertyDict("小溪河", 0, 768);
		addPropertyDict("涧江", 0, 769);
		addPropertyDict("捞刀河", 0, 770);
		addPropertyDict("沩水", 0, 771);
		addPropertyDict("黄材水库干渠", 0, 772);
		addPropertyDict("汉江（汉水）", 0, 773);
		addPropertyDict("沮水河", 0, 774);
		addPropertyDict("黑河", 0, 775);
		addPropertyDict("漾水河", 0, 776);
		addPropertyDict("玉带河", 0, 777);
		addPropertyDict("冷鱼河", 0, 778);
		addPropertyDict("漾家河", 0, 779);
		addPropertyDict("汪家河", 0, 780);
		addPropertyDict("外坝河", 0, 781);
		addPropertyDict("褒河", 0, 782);
		addPropertyDict("太白河", 0, 783);
		addPropertyDict("濂水河", 0, 784);
		addPropertyDict("冷水河", 0, 785);
		addPropertyDict("南沙河", 0, 786);
		addPropertyDict("文水", 0, 787);
		addPropertyDict("堰沟河", 0, 788);
		addPropertyDict("胥水河", 0, 789);
		addPropertyDict("溢水河", 0, 790);
		addPropertyDict("党水河", 0, 791);
		addPropertyDict("酉水河", 0, 792);
		addPropertyDict("金水河", 0, 793);
		addPropertyDict("子午河", 0, 794);
		addPropertyDict("堰坪河", 0, 795);
		addPropertyDict("汶水河", 0, 796);
		addPropertyDict("椒溪河", 0, 797);
		addPropertyDict("牧马河", 0, 798);
		addPropertyDict("泾洋河", 0, 799);
		addPropertyDict("池河", 0, 800);
		addPropertyDict("富水河", 0, 801);
		addPropertyDict("沽溪河", 0, 802);
		addPropertyDict("任河", 0, 803);
		addPropertyDict("岔溪河", 0, 804);
		addPropertyDict("褚河", 0, 805);
		addPropertyDict("汝河", 0, 806);
		addPropertyDict("洞河", 0, 807);
		addPropertyDict("大道河", 0, 808);
		addPropertyDict("岚河", 0, 809);
		addPropertyDict("滔河", 0, 810);
		addPropertyDict("吉河", 0, 811);
		addPropertyDict("月河", 0, 812);
		addPropertyDict("付家河", 0, 813);
		addPropertyDict("恒河", 0, 814);
		addPropertyDict("黄洋河", 0, 815);
		addPropertyDict("闾河", 0, 816);
		addPropertyDict("大神河", 0, 817);
		addPropertyDict("坝河", 0, 818);
		addPropertyDict("旬河", 0, 819);
		addPropertyDict("麻坪河", 0, 820);
		addPropertyDict("乾佑河", 0, 821);
		addPropertyDict("达仁河", 0, 822);
		addPropertyDict("小仁河", 0, 823);
		addPropertyDict("东川河", 0, 824);
		addPropertyDict("蜀河", 0, 825);
		addPropertyDict("仙河", 0, 826);
		addPropertyDict("大双河", 0, 827);
		addPropertyDict("夹河（金钱河）", 0, 828);
		addPropertyDict("靳家河", 0, 829);
		addPropertyDict("马滩河（磨沟）", 0, 830);
		addPropertyDict("县川河", 0, 831);
		addPropertyDict("唐家河", 0, 832);
		addPropertyDict("马耳峡河", 0, 833);
		addPropertyDict("金井河", 0, 834);
		addPropertyDict("白石河", 0, 835);
		addPropertyDict("天河（天桥河）", 0, 836);
		addPropertyDict("堵河（泗河、南江河）", 0, 837);
		addPropertyDict("北星河", 0, 838);
		addPropertyDict("潭口河（小河、县河、尖山河）", 0, 839);
		addPropertyDict("深河", 0, 840);
		addPropertyDict("霍河（秦口河）", 0, 841);
		addPropertyDict("苦桃河", 0, 842);
		addPropertyDict("官渡河", 0, 843);
		addPropertyDict("麻布河（公祖河）", 0, 844);
		addPropertyDict("洛阳河", 0, 845);
		addPropertyDict("兵营河（泉河）", 0, 846);
		addPropertyDict("竹溪河", 0, 847);
		addPropertyDict("汇湾河", 0, 848);
		addPropertyDict("神定河", 0, 849);
		addPropertyDict("泗河", 0, 850);
		addPropertyDict("官山河", 0, 851);
		addPropertyDict("丹江", 0, 852);
		addPropertyDict("丹江口水库", 0, 853);
		addPropertyDict("银花河", 0, 854);
		addPropertyDict("武关河", 0, 855);
		addPropertyDict("淇河", 0, 856);
		addPropertyDict("老灌河（淅川）", 0, 857);
		addPropertyDict("蛇尾河", 0, 858);
		addPropertyDict("清油河", 0, 859);
		addPropertyDict("乳河", 0, 860);
		addPropertyDict("板桥河", 0, 861);
		addPropertyDict("大荆河", 0, 862);
		addPropertyDict("北河", 0, 863);
		addPropertyDict("苦水河", 0, 864);
		addPropertyDict("马栏河", 0, 865);
		addPropertyDict("排子河", 0, 866);
		addPropertyDict("唐白河（白河、鸭河）", 0, 867);
		addPropertyDict("溧河", 0, 868);
		addPropertyDict("潦河", 0, 869);
		addPropertyDict("湍河", 0, 870);
		addPropertyDict("陵河", 0, 871);
		addPropertyDict("溢河", 0, 872);
		addPropertyDict("赵河", 0, 873);
		addPropertyDict("缸河", 0, 874);
		addPropertyDict("刁河", 0, 875);
		addPropertyDict("黄鸭河", 0, 876);
		addPropertyDict("松河", 0, 877);
		addPropertyDict("唐河", 0, 878);
		addPropertyDict("黑清河", 0, 879);
		addPropertyDict("江石河", 0, 880);
		addPropertyDict("涧河", 0, 881);
		addPropertyDict("三夹河", 0, 882);
		addPropertyDict("桐河", 0, 883);
		addPropertyDict("泌阳河", 0, 884);
		addPropertyDict("潘河", 0, 885);
		addPropertyDict("滚河", 0, 886);
		addPropertyDict("熊河", 0, 887);
		addPropertyDict("蛮河", 0, 888);
		addPropertyDict("湾河", 0, 889);
		addPropertyDict("王家河", 0, 890);
		addPropertyDict("竹陂河", 0, 891);
		addPropertyDict("池河（敖水）", 0, 892);
		addPropertyDict("天门河", 0, 893);
		addPropertyDict("汉北河", 0, 894);
		addPropertyDict("大富水", 0, 895);
		addPropertyDict("小富水", 0, 896);
		addPropertyDict("石板河", 0, 897);
		addPropertyDict("鬼水", 0, 898);
		addPropertyDict("潘阳湖", 0, 899);
		addPropertyDict("博阳河", 0, 900);
		addPropertyDict("后港河", 0, 901);
		addPropertyDict("西河（漳田河）", 0, 902);
		addPropertyDict("响水滩河", 0, 903);
		addPropertyDict("潼津河", 0, 904);
		addPropertyDict("饶河", 0, 905);
		addPropertyDict("昌江", 0, 906);
		addPropertyDict("南河（潘源水）", 0, 907);
		addPropertyDict("西河（大演水）", 0, 908);
		addPropertyDict("小北港河（北河）", 0, 909);
		addPropertyDict("闪河", 0, 910);
		addPropertyDict("南宁河", 0, 911);
		addPropertyDict("珠溪河", 0, 912);
		addPropertyDict("槎溪河", 0, 913);
		addPropertyDict("建节水", 0, 914);
		addPropertyDict("长乐水", 0, 915);
		addPropertyDict("洎水（白象河）", 0, 916);
		addPropertyDict("九都水", 0, 917);
		addPropertyDict("赋春水", 0, 918);
		addPropertyDict("中云水（横槎水）", 0, 919);
		addPropertyDict("清华水", 0, 920);
		addPropertyDict("潋溪", 0, 921);
		addPropertyDict("小港水", 0, 922);
		addPropertyDict("修水", 0, 923);
		addPropertyDict("渣津水", 0, 924);
		addPropertyDict("东津水", 0, 925);
		addPropertyDict("金沙河", 0, 926);
		addPropertyDict("山口水（武宁水）", 0, 927);
		addPropertyDict("北岸水", 0, 928);
		addPropertyDict("何市水", 0, 929);
		addPropertyDict("潦河（南潦河）", 0, 930);
		addPropertyDict("龙安河", 0, 931);
		addPropertyDict("北潦河", 0, 932);
		addPropertyDict("罗溪河", 0, 933);
		addPropertyDict("三都水", 0, 934);
		addPropertyDict("安溪水", 0, 935);
		addPropertyDict("赣江", 0, 936);
		addPropertyDict("赣江中支", 0, 937);
		addPropertyDict("赣江南支", 0, 938);
		addPropertyDict("绵水（贡水上源）", 0, 939);
		addPropertyDict("贡水", 0, 940);
		addPropertyDict("湘水", 0, 941);
		addPropertyDict("濂水", 0, 942);
		addPropertyDict("布龙河", 0, 943);
		addPropertyDict("九堡水（澄江）", 0, 944);
		addPropertyDict("青塘河", 0, 945);
		addPropertyDict("琴水（江）", 0, 946);
		addPropertyDict("白沙江（固厚水）", 0, 947);
		addPropertyDict("小布水（陈坊水）", 0, 948);
		addPropertyDict("肖田河", 0, 949);
		addPropertyDict("平江", 0, 950);
		addPropertyDict("岁水", 0, 951);
		addPropertyDict("东河（潋水）", 0, 952);
		addPropertyDict("桃江", 0, 953);
		addPropertyDict("古陂河（东河）", 0, 954);
		addPropertyDict("梦水（西河）", 0, 955);
		addPropertyDict("龙径河", 0, 956);
		addPropertyDict("黄田江", 0, 957);
		addPropertyDict("濂江", 0, 958);
		addPropertyDict("渥江", 0, 959);
		addPropertyDict("罗盘江（太平江）", 0, 960);
		addPropertyDict("章水", 0, 961);
		addPropertyDict("上犹江", 0, 962);
		addPropertyDict("龙华江（龙河江）", 0, 963);
		addPropertyDict("寺下河", 0, 964);
		addPropertyDict("小江（崇义江）", 0, 965);
		addPropertyDict("大江", 0, 966);
		addPropertyDict("珠坊水（杨眉江）", 0, 967);
		addPropertyDict("遂川江（右溪）", 0, 968);
		addPropertyDict("左溪", 0, 969);
		addPropertyDict("五星河", 0, 970);
		addPropertyDict("皂口河", 0, 971);
		addPropertyDict("蜀水", 0, 972);
		addPropertyDict("左江", 0, 973);
		addPropertyDict("右江", 0, 974);
		addPropertyDict("珠林江", 0, 975);
		addPropertyDict("孤江", 0, 976);
		addPropertyDict("禾泸水（禾水）", 0, 977);
		addPropertyDict("宁岗河", 0, 978);
		addPropertyDict("莲江", 0, 979);
		addPropertyDict("拿山河", 0, 980);
		addPropertyDict("牛吼江", 0, 981);
		addPropertyDict("牛田河", 0, 982);
		addPropertyDict("泸江", 0, 983);
		addPropertyDict("陈山河", 0, 984);
		addPropertyDict("东谷水", 0, 985);
		addPropertyDict("潇江", 0, 986);
		addPropertyDict("仙槎河", 0, 987);
		addPropertyDict("泷江", 0, 988);
		addPropertyDict("上固河", 0, 989);
		addPropertyDict("乌江（恩江）", 0, 990);
		addPropertyDict("滕田水", 0, 991);
		addPropertyDict("牛田水", 0, 992);
		addPropertyDict("湖平水", 0, 993);
		addPropertyDict("同江河", 0, 994);
		addPropertyDict("沂江", 0, 995);
		addPropertyDict("袁河", 0, 996);
		addPropertyDict("西坑河", 0, 997);
		addPropertyDict("蒙河", 0, 998);
		addPropertyDict("澧江", 0, 999);
		addPropertyDict("肖江", 0, 1000);
		addPropertyDict("丰水", 0, 1001);
		addPropertyDict("槎水", 0, 1002);
		addPropertyDict("秀水", 0, 1003);
		addPropertyDict("芗水", 0, 1004);
		addPropertyDict("锦河", 0, 1005);
		addPropertyDict("棠浦河", 0, 1006);
		addPropertyDict("宜丰河", 0, 1007);
		addPropertyDict("长胜港（芳溪水）", 0, 1008);
		addPropertyDict("泰溪", 0, 1009);
		addPropertyDict("抚河（盱江）", 0, 1010);
		addPropertyDict("九剧河", 0, 1011);
		addPropertyDict("黎滩河", 0, 1012);
		addPropertyDict("黄狮渡水", 0, 1013);
		addPropertyDict("崇宜水（宜黄水）", 0, 1014);
		addPropertyDict("黄水", 0, 1015);
		addPropertyDict("崇仁水", 0, 1016);
		addPropertyDict("相水", 0, 1017);
		addPropertyDict("西宁水", 0, 1018);
		addPropertyDict("宝塘水", 0, 1019);
		addPropertyDict("信江", 0, 1020);
		addPropertyDict("玉琊溪", 0, 1021);
		addPropertyDict("饶北河", 0, 1022);
		addPropertyDict("广丰水（丰溪河）", 0, 1023);
		addPropertyDict("视水溪", 0, 1024);
		addPropertyDict("泸溪河", 0, 1025);
		addPropertyDict("杨村河", 0, 1026);
		addPropertyDict("铅山河", 0, 1027);
		addPropertyDict("茗溪", 0, 1028);
		addPropertyDict("葛溪水", 0, 1029);
		addPropertyDict("陈坊水", 0, 1030);
		addPropertyDict("双港河", 0, 1031);
		addPropertyDict("罗塘水（西溪河）", 0, 1032);
		addPropertyDict("泗沥河", 0, 1033);
		addPropertyDict("白塔河", 0, 1034);
		addPropertyDict("瑶河", 0, 1035);
		addPropertyDict("东大河", 0, 1036);
		addPropertyDict("互惠河", 0, 1037);
		addPropertyDict("万年河", 0, 1038);
		addPropertyDict("太湖", 0, 1039);
		addPropertyDict("丹金溧槽河", 0, 1040);
		addPropertyDict("通济河", 0, 1041);
		addPropertyDict("南溪河（宜溧漕河）", 0, 1042);
		addPropertyDict("亨溧河（胥溪河）", 0, 1043);
		addPropertyDict("扁担河", 0, 1044);
		addPropertyDict("锡溧槽河", 0, 1045);
		addPropertyDict("澄锡运河", 0, 1046);
		addPropertyDict("青祝运河", 0, 1047);
		addPropertyDict("横套河", 0, 1048);
		addPropertyDict("卤汀河", 0, 1049);
		addPropertyDict("张家港", 0, 1050);
		addPropertyDict("焦港", 0, 1051);
		addPropertyDict("东青河", 0, 1052);
		addPropertyDict("盐铁塘", 0, 1053);
		addPropertyDict("望虞河", 0, 1054);
		addPropertyDict("横泾塘", 0, 1055);
		addPropertyDict("海门河", 0, 1056);
		addPropertyDict("白茆塘", 0, 1057);
		addPropertyDict("戚浦河", 0, 1058);
		addPropertyDict("新浏河（刘家港）", 0, 1059);
		addPropertyDict("黄浦江", 0, 1060);
		addPropertyDict("吴淞江（苏州河）", 0, 1061);
		addPropertyDict("内河", 0, 1062);
		addPropertyDict("运盐河", 0, 1063);
		addPropertyDict("隋唐河", 0, 1064);
		addPropertyDict("横泾", 0, 1065);
		addPropertyDict("练祁河", 0, 1066);
		addPropertyDict("红旗塘", 0, 1067);
		addPropertyDict("太浦河", 0, 1068);
		addPropertyDict("苕溪（西苕溪）", 0, 1069);
		addPropertyDict("东苕溪", 0, 1070);
		addPropertyDict("北苕溪", 0, 1071);
		addPropertyDict("合溪", 0, 1072);
		addPropertyDict("箬溪", 0, 1073);
		addPropertyDict("泗安溪", 0, 1074);
		addPropertyDict("赋石溪", 0, 1075);
		addPropertyDict("长山河", 0, 1076);
	}

	private void initLicensingType() {
		propertyDomain = addPropertyDomain(PropertyTypes.LICENSING_TYPE, false,
				null);
		addPropertyDict("有", 0, 1);
		addPropertyDict("无", 0, 2);
	}

	private void initAlarmCenter() {
		propertyDomain = addPropertyDomain(PropertyTypes.ALARMCENTER, false,
				null);
		addPropertyDict("街道公安局", 0, 1);
		addPropertyDict("区协警处", 0, 2);
		addPropertyDict("警卫室", 0, 3);
	}

	private void initPoliceRoom() {
		propertyDomain = addPropertyDomain(PropertyTypes.POLICEROOM, false,
				null);
		addPropertyDict("小区保安室", 0, 1);
		addPropertyDict("民卫处", 0, 2);
		addPropertyDict("警备室", 0, 3);
	}

	private void initMessageType() {
		propertyDomain = addPropertyDomain(PropertyTypes.MESSAGETYPE, false,
				null);
		addPropertyDict("01-火警", 0, 1);
		addPropertyDict("02-事警", 0, 2);
		addPropertyDict("03-通知", 0, 3);
	}

	private void initInsureSituation() {
		propertyDomain = addPropertyDomain(PropertyTypes.INSURE_SITUATION,
				false, null);
		addPropertyDict("养老保险", 0, 1);
		addPropertyDict("医疗保险", 1, 2);
		addPropertyDict("其他", 2, 3);
	}

	private void initInsureSituationSub() {
		propertyDomain = addPropertyDomain(PropertyTypes.INSURE_SITUATION_SUB,
				false, null);
		// 养老保险
		addPropertyDict("养老保险", 0, 1);
		addPropertyDict("新农保", 0, 2);
		// 医疗保险
		addPropertyDict("医保", 1, 3);
		addPropertyDict("新农合", 1, 4);
	}

	private void initDisableGrade() {
		propertyDomain = addPropertyDomain(PropertyTypes.DISABLE_GRADE, false,
				null);
		// 伤残等级
		addPropertyDict("一级", 0, 1);
		addPropertyDict("二级", 0, 2);
		addPropertyDict("三级", 0, 3);
		addPropertyDict("四级", 0, 4);
		addPropertyDict("五级", 0, 5);
		addPropertyDict("六级", 0, 6);
		addPropertyDict("七级", 0, 7);
		addPropertyDict("八级", 0, 8);
		addPropertyDict("九级", 0, 9);
		addPropertyDict("十级", 0, 10);
	}

	private void initSacrifice() {
		propertyDomain = addPropertyDomain(PropertyTypes.IS_SACRIFICE, false,
				null);
		// 是否牺牲
		addPropertyDict("是", 0, 1);
		addPropertyDict("否", 0, 2);
	}

	private void initAward() {
		propertyDomain = addPropertyDomain(PropertyTypes.AWARD, false, null);
		// 见义勇为奖项
		addPropertyDict("国家级", 0, 1);
		addPropertyDict("省级", 0, 2);
		addPropertyDict("市级", 0, 3);
		addPropertyDict("县级", 0, 4);
		addPropertyDict("其他", 0, 5);
	}

	private void initDifficuleTypeOfGoodSamaritan() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.DIFFICULT_TYPE_GOOD_SAMARITAN, false, null);
		// 见义勇为困难类型
		addPropertyDict("住房", 0, 1);
		addPropertyDict("就业", 0, 2);
		addPropertyDict("教育", 0, 3);
		addPropertyDict("基本生活", 0, 4);
		addPropertyDict("医疗", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	private void initWaterCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.LEDGER_WATEER_PROJECT,
				false, null);
		addPropertyDict("饮水工程", 0, 1);
		addPropertyDict("山坪塘", 1, 2);
		addPropertyDict("石河堰", 2, 3);
		addPropertyDict("蓄水池", 3, 4);
		addPropertyDict("渠道", 4, 5);
		addPropertyDict("中小河流治理", 5, 6);
		addPropertyDict("其他", 6, 7);

	}

	/**
	 * 三本台账字典项初始化
	 */
	private void initWaterSubCategory() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.LEDGER_WATEER_PROJECT_SUB_TYPE, false, null);
		// 水利服务
		addPropertyDict("农村饮水", 0, 1);
		addPropertyDict("场镇饮水", 0, 2);
		addPropertyDict("城市供水", 0, 3);
		addPropertyDict("其他", 0, 4);

		addPropertyDict("干渠", 4, 5);
		addPropertyDict("支渠", 4, 6);
		addPropertyDict("斗毛渠", 4, 7);
		addPropertyDict("其它", 4, 8);

		addPropertyDict("县管河流", 5, 9);
		addPropertyDict("乡管河流", 5, 10);

	}

	private void initWaterBuildCategory() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.LEDGER_WATEER_BUILD_TYPE, false, null);
		// 水利服务 新建、改建、扩建、维修
		addPropertyDict("新建", 0, 1);
		addPropertyDict("改建", 0, 2);
		addPropertyDict("扩建", 0, 3);
		addPropertyDict("维修", 0, 4);
	}

	private void initTrafficBuildType() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAFFIC_BUILD_TYPE,
				false, null);
		// 水利服务 新建、改建、扩建、维修
		addPropertyDict("新建", 0, 1);
		addPropertyDict("改建", 0, 2);
		addPropertyDict("扩建", 0, 3);
		addPropertyDict("维修", 0, 4);
	}

	private void initTrafficProject() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAFFIC_PROJECT,
				false, null);
		addPropertyDict("道路建设", 1, 1);
		addPropertyDict("道路维护", 2, 2);
		addPropertyDict("桥梁建设", 3, 3);
		addPropertyDict("桥梁维护", 4, 4);
		addPropertyDict("安保工程", 5, 5);
		addPropertyDict("客运", 6, 6);
		addPropertyDict("其他", 7, 7);
	}

	private void initTrafficRoad() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAFFIC_ROAD, false,
				null);
		// 国道、省道、县道、乡道、村道、社道、城区道路
		addPropertyDict("国道", 0, 1);
		addPropertyDict("省道", 0, 2);
		addPropertyDict("县道", 0, 3);
		addPropertyDict("乡道", 0, 4);
		addPropertyDict("村道", 0, 5);
		addPropertyDict("社道", 0, 6);
		addPropertyDict("城区道路", 0, 7);
	}

	private void initTrafficSurface() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAFFIC_ROADSURFACE,
				false, null);
		// 水泥、沥青、泥碎
		addPropertyDict("水泥", 0, 1);
		addPropertyDict("沥青", 0, 2);
		addPropertyDict("泥碎", 0, 3);
	}

	private void initSecurity() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAFFIC_SECURITY,
				false, null);
		// 防护栏、防撞墩、减速带、标志标牌、其他
		addPropertyDict("防护栏", 0, 1);
		addPropertyDict("防撞墩", 0, 2);
		addPropertyDict("减速带", 0, 3);
		addPropertyDict("标志标牌", 0, 4);
		addPropertyDict("其他", 0, 5);
	}

	private void initTrafficPassenger() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAFFIC_PASSENGER,
				false, null);
		// 农村客运、县际客运、市际客运、省际客运
		addPropertyDict("农村客运", 0, 1);
		addPropertyDict("县际客运", 0, 2);
		addPropertyDict("市际客运", 0, 3);
		addPropertyDict("省际客运", 0, 4);
	};

	private void initTrafficPassengerManage() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.TRAFFIC_PASSENGER_MANAGE, false, null);
		// 招呼站、客运站
		addPropertyDict("招呼站", 1, 1);
		addPropertyDict("客运站", 2, 2);
	};

	private void initTrafficPassengerBuild() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.TRAFFIC_PASSENGER_BUILD, false, null);
		// 招呼站、客运站
		addPropertyDict("招呼站", 1, 1);
		addPropertyDict("客运站", 2, 2);
	};

	private void initTrafficPublic() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.TRAFFIC_PUBLIC_TRANSPORT, false, null);
		// 招呼站、客运站
		addPropertyDict("公交汽车", 1, 1);
		addPropertyDict("出租汽车", 2, 2);
	}

	private void initLedgeLabor() {
		propertyDomain = addPropertyDomain(PropertyTypes.LABOR_PROJECT, false,
				null);
		addPropertyDict("就业", 1, 1);
		addPropertyDict("社会保障", 2, 2);
		addPropertyDict("农民工工资", 3, 3);
		addPropertyDict("其他", 4, 4);

	}

	private void initLedgeLaborSub() {
		propertyDomain = addPropertyDomain(PropertyTypes.LABOR_PROJECT_SUB,
				false, null);
		addPropertyDict("求职意愿登记", 1, 1);
		addPropertyDict("就业登记", 1, 2);
		addPropertyDict("失业登记", 1, 3);
		addPropertyDict("就业技能培训", 1, 4);

		addPropertyDict("养老保险", 2, 5);
		addPropertyDict("医疗保险", 2, 6);
		addPropertyDict("工伤保险", 2, 7);
		addPropertyDict("生育保险", 2, 8);
		addPropertyDict("失业保险", 2, 9);

		addPropertyDict("其它", 3, 10);
		addPropertyDict("其他", 4, 11);

	}

	private void initLedgeLaborContent() {
		propertyDomain = addPropertyDomain(PropertyTypes.LABOR_PROJECT_CONTENT,
				false, null);
		addPropertyDict("企业", 1, 1);
		addPropertyDict("建筑", 1, 2);
		addPropertyDict("运输", 1, 3);
		addPropertyDict("服务", 1, 4);
		addPropertyDict("其他求职意愿", 1, 5);

		addPropertyDict("个体经营", 2, 6);
		addPropertyDict("单位就业", 2, 7);
		addPropertyDict("灵活就业", 2, 8);
		addPropertyDict("其他就业登记", 2, 9);

		addPropertyDict("新成长失业人员", 3, 10);
		addPropertyDict("就业转失业人员", 3, 11);
		addPropertyDict("其他失业登记", 3, 12);

		addPropertyDict("职业技能培训", 4, 13);
		addPropertyDict("岗前培训", 4, 14);
		addPropertyDict("劳务品牌培训", 4, 15);
		addPropertyDict("其他就业技能培训", 4, 16);

		addPropertyDict("新型农村社会养老保险", 5, 17);
		addPropertyDict("城镇居民社会养老保险", 5, 18);
		addPropertyDict("城镇职工养老保险", 5, 19);
		addPropertyDict("城镇职工医疗保险", 6, 20);
		addPropertyDict("城镇居民医疗保险", 6, 21);

	}

	private void initLedgeEnergyProject() {
		propertyDomain = addPropertyDomain(PropertyTypes.ENERGY_PROJECT, false,
				null);
		addPropertyDict("天然气", 1, 1);
		addPropertyDict("石油液化气", 2, 2);
		addPropertyDict("汽柴油", 3, 3);
		addPropertyDict("电力", 4, 4);
		addPropertyDict("沼气池", 5, 5);
		addPropertyDict("其他", 6, 6);
	}

	private void initLedgeEnergySecurity() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ENERGY_SECURITY_CATEGORY, false, null);

		addPropertyDict("防护栏", 0, 1);
		addPropertyDict("防撞墩", 2, 2);
		addPropertyDict("减速带", 2, 3);
		addPropertyDict("防火设施", 0, 4);
		addPropertyDict("安全标志标牌", 4, 5);
		addPropertyDict("使用说明书", 1, 6);
		addPropertyDict("警示牌", 5, 7);
		addPropertyDict("安全使用手册", 5, 8);
		addPropertyDict("其他", 5, 9);

	}

	private void initLedgeEnergySubProject() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ENERGY_PROJECT_SUB_TYPE, false, null);
		addPropertyDict("管道建设", 1, 1);
		addPropertyDict("管道养护", 1, 2);
		addPropertyDict("户表工程", 1, 3);
		addPropertyDict("液化管道建设", 2, 4);
		addPropertyDict("液化管道养护", 2, 5);
		addPropertyDict("液化户表工程", 2, 6);

		addPropertyDict("加油站建设", 3, 7);
		addPropertyDict("电网设施", 4, 8);
		addPropertyDict("电网维护", 4, 9);
		addPropertyDict("电力户表工程", 4, 10);

		addPropertyDict("沼气池建设", 5, 11);
		addPropertyDict("沼气池安全设施建设", 5, 12);
	}

	private void initLedgeEnergyPipeMaterial() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ENERGY_PIPE_MATERIAL_CATEGORY, false, null);
		addPropertyDict("PE管", 0, 1);
		addPropertyDict("钢管", 0, 2);
		addPropertyDict("其他", 0, 3);
	}

	private void initLedgeEnergyPipeLine() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ENERGY_PIPELINE_CATEGORY, false, null);
		addPropertyDict("中压管道", 0, 1);
		addPropertyDict("低压管道", 0, 2);
		addPropertyDict("高压管道", 0, 3);
		addPropertyDict("户内管道", 0, 3);
	}

	private void initLedgeEnergyLine() {
		propertyDomain = addPropertyDomain(PropertyTypes.ENERGY_LINE_CATEGORY,
				false, null);
		addPropertyDict("变压器", 0, 1);
		addPropertyDict("高压线路", 0, 2);
		addPropertyDict("低压线路", 0, 3);
	}

	private void initLedgeEnergyUnit() {
		propertyDomain = addPropertyDomain(PropertyTypes.ENERGY_UNIT, false,
				null);
		addPropertyDict("处", 0, 1);
		addPropertyDict("KM", 0, 2);
		addPropertyDict("台", 0, 3);
		addPropertyDict("块", 0, 4);
		addPropertyDict("口", 0, 5);
	}

	private void initLedgeEnergyBuildType() {
		propertyDomain = addPropertyDomain(PropertyTypes.ENERGY_BUILD_TYPE,
				false, null);
		addPropertyDict("新建", 0, 1);
		addPropertyDict("改建", 0, 2);
		addPropertyDict("扩建", 0, 3);
		addPropertyDict("维修", 0, 4);
	}

	private void initLedgeScienceBuildType() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCIENCE_BUILD_TYPE,
				false, null);
		addPropertyDict("新建", 0, 1);
		addPropertyDict("改建", 0, 2);
		addPropertyDict("扩建", 0, 3);
		addPropertyDict("维修", 0, 4);
		addPropertyDict("添置设备设施", 0, 5);
	}

	private void initLedgeScienceLevel() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCIENCE_PROJECT_LEVEL,
				false, null);
		addPropertyDict("国家级类", 0, 1);
		addPropertyDict("省级类", 0, 2);
		addPropertyDict("市级类", 0, 3);
		addPropertyDict("县级类", 0, 4);
		addPropertyDict("其他", 0, 5);
	}

	private void initLedgeScienceProject() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCIENCE_PROJECT,
				false, null);
		addPropertyDict("广播电视", 1, 1);
		addPropertyDict("旅游", 2, 2);
		addPropertyDict("文化", 3, 3);
		addPropertyDict("体育", 4, 4);
		addPropertyDict("科技、科协项目", 5, 5);
		addPropertyDict("科技、科协宣传", 6, 6);
		addPropertyDict("其它", 7, 7);
	}

	private void initLedgeScienceSubProject() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCIENCE_PROJECT_SUB,
				false, null);

		addPropertyDict("电视“户户通”", 1, 1);
		addPropertyDict("广播“村村响”", 1, 2);
		addPropertyDict("电影“月月放”", 1, 3);

		addPropertyDict("A级旅游景区（点）管理", 2, 4);
		addPropertyDict("星级农家乐管理", 2, 5);
		addPropertyDict("星级旅游饭店管理", 2, 6);
		addPropertyDict("其他旅游", 2, 7);

		addPropertyDict("乡镇综合文化站", 3, 8);
		addPropertyDict("村（社区）农家书屋", 3, 9);
		addPropertyDict("其他文化", 3, 10);

		addPropertyDict("全民健身路径", 4, 4);
		addPropertyDict("乡镇社会体育指导站", 4, 4);
		addPropertyDict("其他体育", 4, 4);

	}

	private void initLedgeEducationCategroy() {
		propertyDomain = addPropertyDomain(PropertyTypes.EDUCATION_PROJECT,
				false, null);
		addPropertyDict("工程建设", 1, 1);
		addPropertyDict("就学", 2, 2);
		addPropertyDict("其他", 3, 3);
	}

	private void initLedgeEducationSubCategroy() {
		propertyDomain = addPropertyDomain(PropertyTypes.EDUCATION_PROJECT_SUB,
				false, null);
		addPropertyDict("幼儿园建设", 1, 1);
		addPropertyDict("农村薄弱学校改造", 1, 2);
		addPropertyDict("危房改造", 1, 3);
		addPropertyDict("教师周转房建设", 1, 4);
		addPropertyDict("维修维护", 1, 5);

		addPropertyDict("贫困大学新生资助", 2, 6);
		addPropertyDict("两免一补", 2, 7);
		addPropertyDict("高中及中职学生学杂费及生活困难补助", 2, 8);
		addPropertyDict("进城农民工子女就读", 2, 9);
		addPropertyDict("上学路途难", 2, 10);

	}

	private void initLedgeEducationBuildType() {
		propertyDomain = addPropertyDomain(PropertyTypes.EDUCATION_BUILD_TYPE,
				false, null);
		addPropertyDict("新建", 0, 1);
		addPropertyDict("改建", 0, 2);
		addPropertyDict("扩建", 0, 3);
		addPropertyDict("维修", 0, 4);
	}

	private void initLedgeMedicalBuildType() {
		propertyDomain = addPropertyDomain(PropertyTypes.MEDICAL_BUILD_TYPE,
				false, null);
		addPropertyDict("新建", 0, 1);
		addPropertyDict("改建", 0, 2);
		addPropertyDict("扩建", 0, 3);
		addPropertyDict("维修", 0, 4);
		addPropertyDict("添置设备", 0, 5);
	}

	private void initLedgeMedicalCategroy() {
		propertyDomain = addPropertyDomain(PropertyTypes.MEDICAL_PROJECT,
				false, null);
		addPropertyDict("食品卫生", 1, 1);
		addPropertyDict("公共卫生服务", 2, 2);
		addPropertyDict("医疗服务", 3, 3);
		addPropertyDict("新农合", 4, 4);
		addPropertyDict("服务能力建设", 5, 5);
		addPropertyDict("其他", 6, 5);
	}

	private void initLedgeMedicalSubCategroy() {
		propertyDomain = addPropertyDomain(PropertyTypes.MEDICAL_PROJECT_SUB,
				false, null);
		addPropertyDict("种养殖", 1, 1);
		addPropertyDict("生产", 1, 2);
		addPropertyDict("流通", 1, 3);
		addPropertyDict("消费", 1, 4);
		addPropertyDict("其他食品卫生", 1, 5);

		addPropertyDict("疾病预防", 2, 6);
		addPropertyDict("妇幼保健", 2, 7);
		addPropertyDict("卫生监督", 2, 8);
		addPropertyDict("卫生应急", 2, 9);
		addPropertyDict("精神卫生", 2, 10);
		addPropertyDict("其他公共卫生", 2, 11);

		addPropertyDict("服务质量", 3, 12);
		addPropertyDict("服务态度", 3, 13);
		addPropertyDict("医德医风", 3, 14);
		addPropertyDict("其他医疗服务", 3, 15);

		addPropertyDict("筹资", 4, 16);
		addPropertyDict("报销", 4, 17);
		addPropertyDict("监管", 4, 18);
		addPropertyDict("公示", 4, 19);
		addPropertyDict("其他新农合", 4, 20);

		addPropertyDict("队伍建设", 5, 21);
		addPropertyDict("医疗设备更新", 5, 22);
		addPropertyDict("基础设施", 5, 23);
		addPropertyDict("其他服务建设", 5, 24);

	}

	private void initLedgeEnviroCategroy() {
		propertyDomain = addPropertyDomain(PropertyTypes.ENVIRONMENT_PROJECT,
				false, null);
		addPropertyDict("工业企业", 1, 1);
		addPropertyDict("农村环保", 2, 2);
		addPropertyDict("生活污染源", 3, 3);
		addPropertyDict("电磁辐射", 4, 4);
		addPropertyDict("其他", 5, 5);
	}

	private void initLedgeEnviroSubCategroy() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ENVIRONMENT_PROJECT_SUB, false, null);
		addPropertyDict("废水", 1, 1);
		addPropertyDict("废气", 1, 2);
		addPropertyDict("噪声", 1, 3);
		addPropertyDict("固体废弃物", 1, 4);
		addPropertyDict("其他工业物", 1, 5);

		addPropertyDict("畜禽养殖污染", 2, 6);
		addPropertyDict("土壤污染", 2, 7);
		addPropertyDict("白色污染", 2, 8);
		addPropertyDict("河流污染", 2, 9);
		addPropertyDict("水库污染", 2, 10);
		addPropertyDict("其他污染", 2, 11);

		addPropertyDict("生活污水（含地沟油）", 3, 12);
		addPropertyDict("垃圾处理", 3, 13);
		addPropertyDict("生活噪声", 3, 14);
		addPropertyDict("餐饮油烟", 3, 15);
		addPropertyDict("其他生活污染", 3, 16);

		addPropertyDict("电力设施", 4, 17);
		addPropertyDict("通信网络", 4, 18);
		addPropertyDict("三类射线辐射", 4, 19);
		addPropertyDict("其他辐射污染", 4, 20);

	}

	private void initLedgeEnviroUnit() {
		propertyDomain = addPropertyDomain(PropertyTypes.ENVIRONMENT_UNIT,
				false, null);
		addPropertyDict("吨/天", 0, 1);
		addPropertyDict("平方米", 0, 2);
		addPropertyDict("立方米", 0, 3);
		addPropertyDict("分贝", 0, 4);
		addPropertyDict("吨", 0, 5);
	}

	private void initLedgeEnviroBuildType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.ENVIRONMENT_BUILD_TYPE, false, null);
		addPropertyDict("新建", 0, 1);
		addPropertyDict("改建", 0, 2);
		addPropertyDict("扩建", 0, 3);
		addPropertyDict("维修", 0, 4);
		addPropertyDict("整治", 0, 5);
		addPropertyDict("添置设备", 0, 6);
	}

	private void initLedgeTownBuildType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.TOWN_PROJECT_BUILD_TYPE, false, null);
		addPropertyDict("新建", 0, 1);
		addPropertyDict("改建", 0, 2);
		addPropertyDict("扩建", 0, 3);
		addPropertyDict("维修", 0, 4);
		addPropertyDict("添置设施、设备", 0, 5);
	}

	private void initLedgerTownCategroy() {
		propertyDomain = addPropertyDomain(PropertyTypes.TOWN_PROJECT, false,
				null);
		addPropertyDict("城市管理", 1, 1);
		addPropertyDict("城市街道", 2, 2);
		addPropertyDict("市政公共设施", 3, 3);
		addPropertyDict("市政环卫", 4, 4);
		addPropertyDict("村镇规划建设管理", 5, 5);
		addPropertyDict("住房保障", 6, 6);
		addPropertyDict("建筑质量安全", 7, 7);
		addPropertyDict("其他", 8, 8);
	}

	private void initLedgerTownSubCategroy() {
		propertyDomain = addPropertyDomain(PropertyTypes.TOWN_PROJECT_SUB,
				false, null);
		addPropertyDict("占道经营", 1, 1);
		addPropertyDict("旧城改造", 1, 2);
		addPropertyDict("环境治理", 1, 3);
		addPropertyDict("其他城市管理", 1, 4);

		addPropertyDict("建设", 2, 5);
		addPropertyDict("维护", 2, 6);
		addPropertyDict("安保", 2, 7);

		addPropertyDict("公共停车场", 3, 8);
		addPropertyDict("道路桥梁", 3, 9);
		addPropertyDict("道路照明", 3, 10);
		addPropertyDict("排水设施", 3, 11);
		addPropertyDict("公园", 3, 12);
		addPropertyDict("广场", 3, 13);
		addPropertyDict("城区河道", 3, 14);
		addPropertyDict("公共绿地", 3, 15);

		addPropertyDict("公厕", 4, 16);
		addPropertyDict("环卫设施", 4, 17);
		addPropertyDict("城区生活垃圾处理", 4, 18);

		addPropertyDict("农村规划建设管理", 5, 19);
		addPropertyDict("场镇规划建设管理", 5, 20);
		addPropertyDict("新农村建设", 5, 21);
		addPropertyDict("基础设施配套产", 5, 22);
		addPropertyDict("其他村镇规划", 5, 23);

		addPropertyDict("廉租房", 6, 24);
		addPropertyDict("公租房", 6, 25);
		addPropertyDict("安置房", 6, 26);
		addPropertyDict("危房改造", 6, 27);
		addPropertyDict("经济适用房", 6, 28);
		addPropertyDict("其他住房保障", 6, 29);

		addPropertyDict("房屋", 7, 30);
		addPropertyDict("桥梁", 7, 31);
		addPropertyDict("工地", 7, 32);
		addPropertyDict("路段", 7, 33);
		addPropertyDict("公园绿地", 7, 34);
		addPropertyDict("其他建筑", 7, 35);

	}

	private void initLedgerAgricultureCategory() {
		propertyDomain = addPropertyDomain(PropertyTypes.AGRICULTURE_PROJECT,
				false, null);
		addPropertyDict("农业产业化", 1, 1);
		addPropertyDict("田间工程", 2, 2);
		addPropertyDict("电力提灌站", 3, 3);
		addPropertyDict("农业培训", 4, 4);
		addPropertyDict("其它", 5, 5);
	}

	private void initLedgerAgricultureSubCategory() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.AGRICULTURE_PROJECT_SUB, false, null);
		addPropertyDict("粮食生产", 1, 1);
		addPropertyDict("油料生产", 1, 2);
		addPropertyDict("食用菌", 1, 3);
		addPropertyDict("大棚西瓜", 1, 4);
		addPropertyDict("设施蔬菜", 1, 5);
		addPropertyDict("中药材", 1, 6);
		addPropertyDict("干果生产", 1, 7);
		addPropertyDict("水果生产", 1, 8);
		addPropertyDict("其他", 1, 9);

		addPropertyDict("排灌沟渠", 2, 10);
		addPropertyDict("作业道", 2, 11);
		addPropertyDict("机耕道", 2, 12);
		addPropertyDict("蓄水池", 2, 13);
		addPropertyDict("堰塘防渗", 2, 14);
		addPropertyDict("其它", 2, 15);

		addPropertyDict("电力提灌站", 3, 16);
		addPropertyDict("机沉井", 3, 17);
		addPropertyDict("农业培训", 4, 18);
		addPropertyDict("农机培训", 4, 19);
	}

	private void initLedgerAgriculture() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.AGRICULTURE_PROJECT_BUILD_TYPE, false, null);
		addPropertyDict("新建", 0, 1);
		addPropertyDict("改建", 0, 2);
		addPropertyDict("扩建", 0, 3);
		addPropertyDict("维修", 0, 4);
	}

	private void initLedgerOther() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.LEDGER_OTHER_BUILD_TYPE, false, null);
		addPropertyDict("新建", 1, 1);
		addPropertyDict("改建", 2, 2);
		addPropertyDict("扩建", 3, 3);
		addPropertyDict("维修", 4, 4);
		addPropertyDict("其他", 5, 5);
	}

	private void initLedgerPoorPeopleSecurityType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.LEDGER_POOR_PEOPLE_SECURITY_TYPE, false, null);
		addPropertyDict("城镇低保", 0, 1);
		addPropertyDict("农村低保", 1, 2);
		addPropertyDict("农村五保", 2, 3);

	}

	private void initLedgerPoorPeopleDifficultType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.LEDGER_POOR_PEOPLE_DIFFICULT_TYPE, false, null);
		addPropertyDict("生活", 0, 1);
		addPropertyDict("医疗", 1, 2);
		addPropertyDict("住房", 2, 3);
		addPropertyDict("就学", 3, 4);
		addPropertyDict("就业", 4, 5);
		addPropertyDict("其他困难", 5, 6);
	}

	private void initLedgerPoorPeopleDifficultCause() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.LEDGER_POOR_PEOPLE_DIFFICULT_CAUSE, false, null);
		addPropertyDict("因病", 0, 1);
		addPropertyDict("因残", 0, 2);
		addPropertyDict("因灾", 0, 3);
		addPropertyDict("缺乏劳动能力", 0, 4);
		addPropertyDict("生活-其他", 0, 5);

		addPropertyDict("重大疾病", 1, 6);
		addPropertyDict("医疗-其他", 1, 7);

		addPropertyDict("危房改造", 2, 8);
		addPropertyDict("水灾", 2, 9);
		addPropertyDict("地灾", 2, 10);
		addPropertyDict("火灾", 2, 11);
		addPropertyDict("贫困", 2, 12);
		addPropertyDict("住房-其他", 2, 13);

		addPropertyDict("学前教育", 3, 14);
		addPropertyDict("小学", 3, 15);
		addPropertyDict("初中", 3, 16);
		addPropertyDict("高中职高", 3, 17);
		addPropertyDict("大学", 3, 18);
		addPropertyDict("特殊教育", 3, 19);
		addPropertyDict("就学-其他", 3, 20);

		addPropertyDict("城镇登记失业人员", 4, 22);
		addPropertyDict("4050人员", 4, 23);
		addPropertyDict("残疾人员", 4, 21);
		addPropertyDict("低收入家庭人员", 4, 22);
		addPropertyDict("按城镇人口安置的被征地农民", 4, 23);
		addPropertyDict("连续失业一年以上的人员", 4, 21);
		addPropertyDict("土地（林地）被依法征用或流转的农村劳动者", 4, 22);
		addPropertyDict("就业-其他", 4, 23);

		addPropertyDict("其他", 5, 24);

	}

	private void initLedgerPoorPeopleSpecificNeed() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.LEDGER_POOR_PEOPLE_SPECIFIC_NEED, false, null);
		addPropertyDict("口粮", 0, 1);
		addPropertyDict("五保", 1, 2);
		addPropertyDict("低保", 2, 3);
		addPropertyDict("救助资金", 3, 4);
		addPropertyDict("救助物资", 4, 5);
		addPropertyDict("住房", 5, 6);
		addPropertyDict("职业培训", 6, 7);
		addPropertyDict("职业指导", 7, 8);
		addPropertyDict("求职登记", 8, 9);
		addPropertyDict("职业介绍", 9, 10);
		addPropertyDict("其他", 10, 11);
	}

	private void initLedgerSteadyWorkInvolvingSteadyType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.STEADY_RECORD_WORK_INVOLVING_STEADY_TYPE, false,
				null);
		addPropertyDict("个人", 0, 1);
		addPropertyDict("反映群体代表", 1, 2);
	}

	private void initLedgerSteadyWorkType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.STEADY_RECORD_WORK_TYPE, false, null);
		addPropertyDict("涉法涉诉", 0, 1);
		addPropertyDict("林水土", 1, 2);
		addPropertyDict("惠农政策及村（社区）政务、财务", 2, 3);
		addPropertyDict("民政问题", 3, 4);
		addPropertyDict("人口与医疗卫生", 4, 5);
		addPropertyDict("劳动保障", 5, 6);
		addPropertyDict("交通运输", 6, 7);
		addPropertyDict("城建及综合执法", 7, 8);
		addPropertyDict("党纪政纪", 8, 9);
		addPropertyDict("教育", 9, 10);
		addPropertyDict("企业改制", 10, 11);
		addPropertyDict("环境保护", 11, 12);
		addPropertyDict("组织人事", 12, 13);
		addPropertyDict("其他稳定工作", 13, 14);
		addPropertyDict("重点人员", 14, 15);
		addPropertyDict("其他", 15, 16);
	}

	private void initLedgerSteadyWorkProblemType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.STEADY_RECORD_WORK_PROBLEM_TYPE, false, null);
		addPropertyDict("社会治安", 0, 1);
		addPropertyDict("民事申诉", 0, 2);
		addPropertyDict("刑事申诉", 0, 3);
		addPropertyDict("行政申诉", 0, 4);
		addPropertyDict("诉讼执行", 0, 5);
		addPropertyDict("刑事案件侦破", 0, 6);
		addPropertyDict("民事经济纠纷调解", 0, 7);
		addPropertyDict("司法作风", 0, 8);
		addPropertyDict("立案", 0, 9);
		addPropertyDict("涉法涉诉-其它", 0, 10);

		addPropertyDict("土地征用", 1, 11);
		addPropertyDict("土地承包", 1, 12);
		addPropertyDict("土地纠纷", 1, 13);
		addPropertyDict("水库水电移民", 1, 14);
		addPropertyDict("宅基地", 1, 15);
		addPropertyDict("退耕还林", 1, 16);
		addPropertyDict("地质灾害", 1, 17);
		addPropertyDict("林水土-其它", 1, 18);

		addPropertyDict("村社政务、财务", 2, 19);
		addPropertyDict("集体收入分配", 2, 20);
		addPropertyDict("集体工程项目", 2, 21);
		addPropertyDict("农民负担", 2, 22);
		addPropertyDict("政策性直补", 2, 23);
		addPropertyDict("危房改造", 2, 24);
		addPropertyDict("惠农政策及村（社区）政务、财务-其他", 2, 25);

		addPropertyDict("城镇和农村低保", 3, 26);
		addPropertyDict("复员退伍军人安置", 3, 27);
		addPropertyDict("退伍军人", 3, 28);
		addPropertyDict("伤残军人", 3, 29);
		addPropertyDict("优抚政策", 3, 30);
		addPropertyDict("村社选举", 3, 31);
		addPropertyDict("救灾和灾后安置", 3, 32);
		addPropertyDict("特困人员救助", 3, 33);
		addPropertyDict("民政问题-其他", 3, 34);

		addPropertyDict("医政管理", 4, 35);
		addPropertyDict("食品管理", 4, 36);
		addPropertyDict("药品管理", 4, 37);
		addPropertyDict("医患纠纷", 4, 38);
		addPropertyDict("新农合", 4, 39);
		addPropertyDict("传染病控制", 4, 40);
		addPropertyDict("计生优抚政策", 4, 41);
		addPropertyDict("再生育审批", 4, 42);
		addPropertyDict("违法生育处理", 4, 43);
		addPropertyDict("人口与医疗卫生-其他", 4, 44);

		addPropertyDict("城镇企业职工养老保险", 5, 45);
		addPropertyDict("城镇居民养老保险", 5, 46);
		addPropertyDict("农村居民养老保险", 5, 47);
		addPropertyDict("城镇职工医疗保险", 5, 48);
		addPropertyDict("城镇居民医疗保险", 5, 49);
		addPropertyDict("失业保险", 5, 50);
		addPropertyDict("工伤保险", 5, 51);
		addPropertyDict("生育保险", 5, 52);
		addPropertyDict("就业促进", 5, 53);
		addPropertyDict("农民工工资", 5, 54);
		addPropertyDict("特种行业保护", 5, 55);
		addPropertyDict("劳动仲裁", 5, 56);
		addPropertyDict("劳动保障-其他", 5, 57);

		addPropertyDict("道路运输安全", 6, 58);
		addPropertyDict("交通施工", 6, 59);
		addPropertyDict("行政管理", 6, 60);
		addPropertyDict("公路收费", 6, 61);
		addPropertyDict("水上安全", 6, 62);
		addPropertyDict("交通运输-其他", 6, 63);

		addPropertyDict("征地拆迁", 7, 64);
		addPropertyDict("城乡规划及实施", 7, 65);
		addPropertyDict("房产纠纷", 7, 66);
		addPropertyDict("工程质量", 7, 67);
		addPropertyDict("城乡环境综合执法", 7, 68);
		addPropertyDict("市政建设", 7, 69);
		addPropertyDict("城建及综合执法-其他", 7, 70);

		addPropertyDict("干部作风", 8, 71);
		addPropertyDict("贪污受贿", 8, 72);
		addPropertyDict("违法违规", 8, 73);
		addPropertyDict("干部处分", 8, 74);
		addPropertyDict("党纪政纪-其他", 8, 75);

		addPropertyDict("学校及在职教职工管理", 9, 76);
		addPropertyDict("退休教师", 9, 77);
		addPropertyDict("学生安全", 9, 78);
		addPropertyDict("教育布局", 9, 79);
		addPropertyDict("民办、代课教师及其他临聘人员", 9, 80);
		addPropertyDict("教师待遇", 9, 81);
		addPropertyDict("教育收费", 9, 82);
		addPropertyDict("教育-其他", 9, 83);

		addPropertyDict("企业破产", 10, 84);
		addPropertyDict("资产清算", 10, 85);
		addPropertyDict("职工安置", 10, 86);
		addPropertyDict("企业改制-其他", 10, 87);

		addPropertyDict("水、空气、噪音污染", 11, 88);
		addPropertyDict("污染物排放", 11, 89);
		addPropertyDict("环境保护-其他", 11, 90);

		addPropertyDict("离退休人员待遇", 12, 91);
		addPropertyDict("工资福利待遇", 12, 92);
		addPropertyDict("干部身份", 12, 93);
		addPropertyDict("军团干部", 12, 94);
		addPropertyDict("提拔任用", 12, 95);
		addPropertyDict("临聘人员", 12, 96);
		addPropertyDict("机构改革", 12, 97);
		addPropertyDict("组织人事-其他", 12, 98);

		addPropertyDict("精简下放", 13, 99);
		addPropertyDict("公私合营", 13, 100);
		addPropertyDict("经租房", 13, 101);
		addPropertyDict("乡镇债务", 13, 102);
		addPropertyDict("民间纠纷", 13, 103);
		addPropertyDict("其他", 13, 104);

		addPropertyDict("社区矫正人员", 14, 105);
		addPropertyDict("易肇事肇祸精神病人", 14, 106);
		addPropertyDict("重点青少年或群体", 14, 107);
		addPropertyDict("吸毒人员", 14, 108);
		addPropertyDict("吞食异物违法犯罪嫌疑人员", 14, 109);
		addPropertyDict("邪教及其他组织人员", 14, 110);
		addPropertyDict("其他应重点监管人员", 14, 111);
		addPropertyDict("其他内容", 15, 112);
	}

	public void initPeopleAspirationCreateTableType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.LEDGER_PEOPLEASPIRATION_CREATE_TABLE_TYPE, false,
				null);
		addPropertyDict("新建", 0, 1);
		addPropertyDict("上年接转", 1, 2);
		addPropertyDict("其他台账转入", 2, 3);
		addPropertyDict("上级主管部门和县级领导班子有关领导交办(县级部门选填)", 3, 4);
		addPropertyDict("县委县政府及县级领导班子有关领导交办(乡镇选填)", 4, 5);
		addPropertyDict("县人大议案、建议、意见交办", 5, 6);
		addPropertyDict("县政协提案、建议、意见交办", 6, 7);

	}

	private void initPeopleAspirationAppealHumanType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.LEDGER_APPEAL_HUMAN_TYPE, false, null);
		addPropertyDict("反映人", 0, 1);
		addPropertyDict("反映群体代表", 1, 2);
	}

	private void initOtherProject() {
		propertyDomain = addPropertyDomain(PropertyTypes.OTHER_PROJECT, false,
				null);
		addPropertyDict("建设工程", 1, 1);
		addPropertyDict("其他", 2, 2);

	}

	private void initAgricultureMachine() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.AGRICULTURE_MACHINERY_TRAIN, false, null);
		addPropertyDict("拖拉机驾驶员", 1, 1);
		addPropertyDict("其他操作", 2, 2);
		addPropertyDict("其他", 3, 3);
	}

	private void initAgricultureFraming() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.AGRICULTURE_FARMING_TRAIN, false, null);
		addPropertyDict("农技", 1, 1);
		addPropertyDict("农经", 2, 2);
		addPropertyDict("阳光工程", 3, 3);
		addPropertyDict("其他", 4, 4);

	}

	private void initTownSecurity() {
		propertyDomain = addPropertyDomain(PropertyTypes.TOWN_SECURITY_TYPE,
				false, null);
		addPropertyDict("防护栏", 1, 1);
		addPropertyDict("防撞柱", 2, 2);
		addPropertyDict("减速带", 3, 3);
		addPropertyDict("标志标牌", 4, 4);
		addPropertyDict("其它", 5, 5);
	}

	private void initDegreeProperty() {
		propertyDomain = addPropertyDomain(PropertyTypes.LEDGER_DEGREE, false,
				null);
		addPropertyDict("博士", 0, 1);
		addPropertyDict("研究生", 0, 2);
		addPropertyDict("大学本科", 0, 3);
		addPropertyDict("大专", 0, 4);
		addPropertyDict("高中\\中专", 0, 5);
		addPropertyDict("初中", 0, 6);
		addPropertyDict("小学", 0, 7);
		addPropertyDict("文盲", 0, 8);
		addPropertyDict("学龄前", 0, 9);
	}

	private void initLaborAge() {
		propertyDomain = addPropertyDomain(PropertyTypes.LABOR_AGE, false, null);
		addPropertyDict("60周岁以上", 1, 1);
		addPropertyDict("16—59周岁", 2, 2);
	}

	private void initLaborCripple() {
		propertyDomain = addPropertyDomain(PropertyTypes.LABOR_CRIPPLE, false,
				null);
		addPropertyDict("1—2级", 1, 1);
		addPropertyDict("3—4级", 2, 2);
		addPropertyDict("否", 3, 3);
	}

	private void initLaborDignity() {
		propertyDomain = addPropertyDomain(PropertyTypes.LABOR_DIGNITY, false,
				null);
		addPropertyDict("行政事业", 1, 1);
		addPropertyDict("企业", 2, 2);
		addPropertyDict("个体", 3, 3);
		addPropertyDict("学生", 4, 4);
		addPropertyDict("失地农民", 5, 5);
		addPropertyDict("重度残疾", 6, 6);
		addPropertyDict("新生婴儿", 7, 7);
		addPropertyDict("其他", 8, 8);
	}

	private void initScienceBroadcast() {
		propertyDomain = addPropertyDomain(PropertyTypes.SCIENCE_BROADCAST,
				false, null);
		addPropertyDict("直播卫星", 1, 1);
		addPropertyDict("有线电视“户户通”", 1, 2);
		addPropertyDict("地面数字电视“户户通”", 1, 3);
		addPropertyDict("广播站室", 2, 4);
		addPropertyDict("广播", 2, 5);
		addPropertyDict("村(社区)", 3, 6);
		addPropertyDict("其他", 7, 7);

	}

	private void initTrafficSecurityService() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.TRAFFIC_SECURITY_SERVICE, false, null);
		addPropertyDict("线路数量", 1, 1);
		addPropertyDict("覆盖区域", 2, 2);
		addPropertyDict("站台数量", 2, 3);
		addPropertyDict("车辆数量", 3, 4);
		addPropertyDict("安全管理", 4, 5);
		addPropertyDict("收费情况", 0, 6);
		addPropertyDict("服务质量", 0, 7);
		addPropertyDict("其他", 0, 8);

	}

	private void initTrafficLevel() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAFFIC_LEVEL, false,
				null);
		addPropertyDict("一级", 1, 1);
		addPropertyDict("二级", 2, 2);
		addPropertyDict("三级", 3, 3);
		addPropertyDict("四级", 4, 4);
		addPropertyDict("简易", 5, 5);
	}

	private void initTrafficType() {
		propertyDomain = addPropertyDomain(PropertyTypes.TRAFFIC_PASSTYPE,
				false, null);
		addPropertyDict("班线客运", 1, 1);
		addPropertyDict("城市公共交通", 2, 2);
		addPropertyDict("客运站管理", 3, 3);
		addPropertyDict("客运站建设", 4, 4);
	}

	private void initEduScopeType() {
		propertyDomain = addPropertyDomain(PropertyTypes.EDUCATION_SCOPE_TYPE,
				false, null);
		addPropertyDict("一个班", 1, 1);
		addPropertyDict("三个班", 0, 2);
		addPropertyDict("六个班", 0, 3);
		addPropertyDict("九个班以上", 1, 4);
		addPropertyDict("九个班", 2, 5);
		addPropertyDict("十二个班", 2, 6);
		addPropertyDict("十五个班以上", 2, 7);
		addPropertyDict("十二套", 3, 8);
		addPropertyDict("十八套", 3, 9);
		addPropertyDict("二十四套", 3, 10);
		addPropertyDict("三十六套以上", 3, 11);
		addPropertyDict("150人", 4, 12);
		addPropertyDict("300人", 4, 13);
		addPropertyDict("600人", 4, 14);
		addPropertyDict("800人以上", 4, 15);
	}

	private void initEduModeType() {
		propertyDomain = addPropertyDomain(PropertyTypes.EDUCATION_MODE_TYPE,
				false, null);
		addPropertyDict("助学贷款", 1, 1);
		addPropertyDict("社会捐赠", 2, 2);
		addPropertyDict("社会捐助", 3, 3);
		addPropertyDict("银行信贷", 4, 4);
	}

	private void initEduItemType() {
		propertyDomain = addPropertyDomain(PropertyTypes.EDUCATION_ITEM_TYPE,
				false, null);
		addPropertyDict("免学杂费", 1, 1);
		addPropertyDict("免书本费", 0, 2);
		addPropertyDict("生活困难补助", 1, 3);
	}

	private void initEduRoadType() {
		propertyDomain = addPropertyDomain(PropertyTypes.EDUCATION_ROAD_TYPE,
				false, null);
		addPropertyDict("路程", 1, 1);
		addPropertyDict("路况", 2, 2);
	}

	private void initEduDistanceType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.EDUCATION_DISTANCE_TYPE, false, null);
		addPropertyDict("三公里", 1, 1);
		addPropertyDict("四公里", 2, 2);
		addPropertyDict("五公里", 3, 3);
		addPropertyDict("六公里", 4, 4);
		addPropertyDict("七公里及以上", 5, 5);
	}

	private void initEduRoadConditionType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.EDUCATION_ROAD_CONDITION_TYPE, false, null);
		addPropertyDict("山路", 1, 1);
		addPropertyDict("渡河", 2, 2);
		addPropertyDict("过水库", 3, 3);
		addPropertyDict("乘车", 4, 4);
	}

	private void initEduDegreeType() {
		propertyDomain = addPropertyDomain(PropertyTypes.EDUCATION_DEGREE_TYPE,
				false, null);
		addPropertyDict("学前教育", 0, 1);
		addPropertyDict("小学", 2, 2);
		addPropertyDict("初中", 2, 3);
		addPropertyDict("高中", 1, 4);
		addPropertyDict("职中", 1, 5);
	}

	private void initEduAddressType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.EDUCATION_ADDRESS_TYPE, false, null);
		addPropertyDict("村", 1, 1);
		addPropertyDict("社区", 1, 2);
		addPropertyDict("场镇", 1, 3);
		addPropertyDict("城市", 1, 4);
		addPropertyDict("村小", 2, 5);
		addPropertyDict("分校", 2, 6);
		addPropertyDict("小学", 2, 7);
		addPropertyDict("中学", 2, 8);
	}

	/**
	 * 三本台账字典项初始化
	 */

	public void initSteadyRecordWorkWarnLevel() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.STEADY_RECORD_WORK_WARN_LEVEL, false, null);
		addPropertyDict("蓝色", 0, 1);
		addPropertyDict("黄色", 1, 2);
		addPropertyDict("橙色", 2, 3);
		addPropertyDict("红色", 3, 4);
	}

	/**
	 * 重点青少年帮扶情况
	 */
	public void initHelpingSituation() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.HELPING_SITUATION_TYPE, false, null);
		addPropertyDict("关爱救助", 0, 1);
		addPropertyDict("心理疏导", 0, 2);
		addPropertyDict("就业指导", 0, 3);
		addPropertyDict("个案访谈", 0, 4);
	}

	/**
	 * 初始化任务类型
	 */
	private void initTaskNature() {
		propertyDomain = addPropertyDomain(PropertyTypes.TASKPLOY_TYPE, true,
				null);
		addPropertyDict("存储过程", 0, 1);
		addPropertyDict("函数", 0, 2);
		addPropertyDict("sql语句", 0, 3);
		addPropertyDict("java方法", 0, 4);
	}

	/**
	 * 初始化任务频率
	 */
	private void initTaskFrequencyNature() {
		propertyDomain = addPropertyDomain(PropertyTypes.TASK_FREQUENCY, true,
				null);
		addPropertyDict("每年", 0, 1);
		addPropertyDict("每月", 0, 2);
		addPropertyDict("每周", 0, 3);
		addPropertyDict("每天", 0, 4);
		addPropertyDict("每时", 0, 5);
		addPropertyDict("每分", 0, 6);
		addPropertyDict("每秒", 0, 7);
	}

	/**
	 * 会议类型
	 */
	public void initAssignMeetingType() {
		propertyDomain = addPropertyDomain(PropertyTypes.ASSGIN_MEETING_TYPE,
				false, null);
		addPropertyDict("县委常委会", 0, 1);
		addPropertyDict("县政府常务会", 0, 2);
		addPropertyDict("专题会议", 0, 3);
		addPropertyDict("其他会议", 0, 4);
	}

	public void initWorkingContentType() {
		propertyDomain = addPropertyDomain(PropertyTypes.WORKING_CONTENT_TYPE,
				false, null);
		addPropertyDict("督促申报流动人口信息", 0, 1);
		addPropertyDict("宣传四川省流动人口信息登记办法", 0, 2);
		addPropertyDict("其他", 0, 3);

	}

	public void initExceptionSituationType() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.EXCEPTION_SITUATION_TYPE, false, null);

		addPropertyDict("大量聚集", 0, 1);
		addPropertyDict("异常气味", 0, 2);
		addPropertyDict("异常声音", 0, 3);
		addPropertyDict("无身份证", 0, 4);
		addPropertyDict("群租房人员来往复杂", 0, 5);
		addPropertyDict("已搬走", 0, 6);


	}

	public void initDangerExceptionType() {
		propertyDomain = addPropertyDomain(PropertyTypes.DANGER_EXCEPTION_TYPE,
				false, null);
		addPropertyDict("涉暴恐", 0, 1);
		addPropertyDict("涉枪涉爆", 0, 2);
		addPropertyDict("涉制毒", 0, 3);
		addPropertyDict("涉贩毒", 0, 4);
		addPropertyDict("涉吸毒", 0, 5);
		addPropertyDict("邪教活动", 0, 6);
		addPropertyDict("制假贩假", 0, 7);
		addPropertyDict("涉黄", 0, 8);
		addPropertyDict("涉赌", 0, 9);
		addPropertyDict("传销", 0, 10);
		addPropertyDict("火灾隐患", 0, 11);
		addPropertyDict("收赃", 0, 12);
		addPropertyDict("销赃", 0, 13);
		addPropertyDict("无守楼护院人员", 0, 14);
		addPropertyDict("其他异常事件", 0, 15);

	}

	public void initMentalPatientOutReason() {
		propertyDomain = addPropertyDomain(
				PropertyTypes.MENTALPATIENT_OUT_REASON, false, null);
		addPropertyDict("外出务工", 0, 1);
		addPropertyDict("投靠亲友", 0, 2);
	}

	public void initDruggyLifeResource() {
		propertyDomain = addPropertyDomain(PropertyTypes.DRUGGY_LIFE_RESOURCE,
				false, null);
		addPropertyDict("务农", 0, 1);
		addPropertyDict("打工", 0, 2);
		addPropertyDict("低保", 0, 3);
		addPropertyDict("其他", 0, 4);
	}

	public void initFormType() {
		propertyDomain = addPropertyDomain(PropertyTypes.FORM_TYPE,
				false, null);
		addPropertyDict("呈报件", 0, 1);
		addPropertyDict("交办件", 0, 2);
		addPropertyDict("转办件", 0, 3);
		addPropertyDict("来电来信来访件", 0, 4);
		addPropertyDict("干部走基层信息搜集", 0, 5);
		addPropertyDict("其他", 0, 6);
	}

	//红袖套队伍管理队伍类型-第一类
	public void initRedCuffTeamType() {
		propertyDomain = addPropertyDomain(PropertyTypes.RED_CUFF_TEAM_TYPE,
				false, null);
		addPropertyDict("第一类", 1, 1);
		addPropertyDict("第二类", 2, 2);
		addPropertyDict("第三类", 3, 3);
	}

	//红袖套队伍管理队伍类型-第一类
	public void initRedCuffSubTeamType() {
		propertyDomain = addPropertyDomain(PropertyTypes.RED_CUFF_TEAM_SUB_TYPE,
				false, null);
		addPropertyDict("综治巡逻队员", 1, 1);
		addPropertyDict("网格员", 1, 2);

		addPropertyDict("单位保安", 2, 3);
		addPropertyDict("院落门卫", 2, 4);
		addPropertyDict("城管队员", 2, 5);

		addPropertyDict("公益性工作者", 3, 6);
		addPropertyDict("机关干部", 3, 7);
		addPropertyDict("环卫工人", 3, 8);
		addPropertyDict("民兵预备役", 3, 9);
		addPropertyDict("平安志愿者", 3, 10);
		addPropertyDict("交通劝导员", 3, 11);

	}

	public void initLedgerType() {
		propertyDomain = addPropertyDomain(PropertyTypes.LEDGER_TYPE, false, null);
		addPropertyDict("水利信息", 0, 1);
		addPropertyDict("交通信息", 0, 2);

		addPropertyDict("能源信息", 0, 3);
		addPropertyDict("教育信息", 0, 4);
		addPropertyDict("科技文本信息", 0, 5);

		addPropertyDict("医疗卫生信息", 0, 6);
		addPropertyDict("劳动和社会保障信息", 0, 7);
		addPropertyDict("环境保护信息", 0, 8);
		addPropertyDict("城乡规划建设管理信息", 0, 9);
		addPropertyDict("农业信息", 0, 10);
		addPropertyDict("其它信息", 0, 11);
	}

	public void initLedgerStatus() {
		propertyDomain = addPropertyDomain(PropertyTypes.LEDGER_STATUS, false, null);
		addPropertyDict("待办", 0, 1);
		addPropertyDict("程序性办结", 0, 2);
		addPropertyDict("阶段性办结", 0, 3);
		addPropertyDict("实质性办结", 0, 4);
		addPropertyDict("已办", 0, 5);
		addPropertyDict("待反馈", 0, 6);
		addPropertyDict("上级交办", 0, 7);
		addPropertyDict("上报", 0, 8);
		addPropertyDict("协办", 0, 9);
		addPropertyDict("抄告", 0, 10);
	}

	/**
	 * 微信素材类型
	 */
	private void initWeChatType() {
		propertyDomain = addPropertyDomain(PropertyTypes.WECHAT_TYPE, true,
				WeChatType.getInternalProperties());
		addPropertyDict(WeChatType.wenben_CN, WeChatType.wenben, 1);
		addPropertyDict(WeChatType.tupian_CN, WeChatType.tupian, 2);
		addPropertyDict(WeChatType.tuwen_CN, WeChatType.tuwen, 3);
		addPropertyDict(WeChatType.yuyin_CN, WeChatType.yuyin, 4);
	}
	
	/**
	 * 微信语音提示状态
	 */
	private void initWechatInboxVoicePromptType() {
		propertyDomain = addPropertyDomain(PropertyTypes.WECHAT_INBOX_VOICE_PROMPT_TYPE, false, null);
		addPropertyDict("关闭", 1, 1);
		addPropertyDict("开启", 2, 2);
	}
	
	/**
	 * 网格员专兼职情况
	 */
	private void initGridPositionType() {
		propertyDomain = addPropertyDomain(PropertyTypes.GRID_POSITIONTYPE, false, null);
		addPropertyDict("专职", 0, 1);
		addPropertyDict("兼职", 0, 2);
	}

	/**
	 * 任务清单项目名
	 */
	private void initTaskListItemName() {
		propertyDomain = addPropertyDomain(PropertyTypes.TASKLIST_ITEM_NAME, false, null);
		addPropertyDict("宣传核查", TaskListItemNameInternalId.PROPAGANDA_AND_VERIFICATION
				, 1);
		addPropertyDict("民警带领下开展工作情况", TaskListItemNameInternalId.WORK_BYPOLICE_MANAGEMENT, 2);
		addPropertyDict("异常情况报告", TaskListItemNameInternalId.EXCEPTIONAL_SITUATION_RECORD_MANAGE, 3);
		addPropertyDict("吸毒人员", TaskListItemNameInternalId.DRUGGY_TASKVISIT_MANAGEMENT, 4);
		addPropertyDict("严重精神障碍患者", TaskListItemNameInternalId.MENTAL_PATIENT_TASKVISIT_MANAGEMENT, 5);
		addPropertyDict("社区服刑人员", TaskListItemNameInternalId.TERMER_RECORD_MANAGE, 6);
		addPropertyDict("刑释人员", TaskListItemNameInternalId.POSITIVE_INFORECORD_MANAGE, 7);
		addPropertyDict("发现治安隐患", TaskListItemNameInternalId.HIDDEN_DANGER, 8);
	}
}
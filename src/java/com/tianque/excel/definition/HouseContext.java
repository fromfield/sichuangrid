package com.tianque.excel.definition;

import com.tianque.core.datatransfer.DataType;
import com.tianque.domain.property.PropertyTypes;

public class HouseContext {
	/**
	 * 实有房屋信息导出 序号|对象属性|中文名|属性类型|类型|是否采用默认样式|合并行|合并列|
	 * 
	 * @return
	 */
	public static String[][] getHouseInfoPropertyArray() {
		String[][] excelColumArray = {
				{ "0", "", "实有房屋信息", "", "", "true", "0", "55" },
				{ "0", "houseCode", "房屋编号", "", "", "true" },
				{ "1", "organization", "所属网格", DataType.DATA_TYPE_ORG, "",
						"true" },
				// { "2", "addressType", "房屋地址类型", DataType.DATA_TYPE_DICT,
				// PropertyTypes.CURRENT_ADDRESS_TYPE, "true" },
				{ "2", "address", "房屋准确地址", "", "", "true" },
				{ "3", "houseAddress", "房产证地址", "", "", "true" },
				{ "4", "isRentalHouse", "是否是出租房", DataType.DATA_TYPE_BOOLEAN,
						"", "true" },
				{ "5", "rentalPerson", "房主姓名", "", "", "true" },
				{ "6", "hiddenDangerLevel", "隐患程度", DataType.DATA_TYPE_DICT,
						PropertyTypes.HIDDEN_TROUBLE_LEVEL, "true" },
				{ "7", "buildingName", "建筑物名称", "", "", "true" },
				{ "8", "buildingUses", "建筑物用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.BUILDING_USES, "true" },
				{ "9", "propertyName", "物业管理单位名称", "", "", "true" },
				{ "10", "houseOwner", "代表人/业主", "", "", "true" },
				{ "11", "houseOwnerIdCardNo", "业主身份证号码", "", "", "true" },
				{ "12", "telephone", "业主联系电话", "", "", "true" },
				{ "13", "houseDoorModel", "房屋户型", "", "", "true" },
				{ "14", "builtYear", "建成年份", "", "", "true" },
				{ "15", "houseArea", "本户建筑面积", "", "", "true" },
				{ "16", "houseStructure", "房屋结构", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_STRUTS, "true" },
				{ "17", "houseUses", "房屋用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSE_USES, "true" },
				{ "18", "houseSource", "房屋来源", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSE_SOURCE, "true" },
				{ "19", "ownProperty", "自有产权", DataType.DATA_TYPE_DICT,
						PropertyTypes.OWN_PROPERTY, "true" },
				{ "20", "rentalBuildings", "租赁公房", DataType.DATA_TYPE_DICT,
						PropertyTypes.RENTAL_BUILDINGS, "true" },
				{ "21", "housingVouchers", "房屋凭证", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSING_VOUCHERS, "true" },
				{ "22", "houseRightNumber", "房屋权证号", "", "", "true" },
				{ "23", "houseRightNumberDate", "房屋权证发证时间",
						DataType.DATA_TYPE_DATE, "", "true" },
				{ "24", "landDocuments", "土地凭证", DataType.DATA_TYPE_DICT,
						PropertyTypes.LAND_DOCUMENTS, "true" },
				{ "25", "landRightsNumbe", "土地权证号", "", "", "true" },
				{ "26", "landRightsNumbeDate", "土地权证发证时间",
						DataType.DATA_TYPE_DATE, "", "true" },
				{ "27", "propertyTypes", "产权人类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.PROPERTY_TYPES, "true" },
				{ "28", "name", "产权人姓名", "", "", "true" },
				{ "29", "certificateType", "产权人证件类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGCERTIFICATE_TYPE, "true" },
				{ "30", "certificateNumbe", "产权人证件号码", "", "", "true" },
				{ "31", "propertyPersonTel", "产权人联系电话", "", "", "true" },
				{ "32", "propertyPersonMobile", "产权人联系手机", "", "", "true" },
				{ "33", "usage", "出租房用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_USAGE, "true" },
				{ "34", "houseFileNum", "租赁备案证号", "", "", "true" },
				{ "35", "lessorType", "出租人类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.LESSOR_TYPE, "true" },
				{ "36", "rentalCertificateType", "出租人证件类型",
						DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGCERTIFICATE_TYPE, "true" },
				{ "37", "rentalCertificateNumbe", "出租人证件号码", "", "", "true" },
				{ "38", "rentalTelephone", "出租人联系电话", "", "", "true" },
				{ "39", "rentalMobileNumber", "出租人联系手机", "", "", "true" },
				{ "40", "lessorAddress", "出租人联系地址", "", "", "true" },
				{ "41", "mangerTypes", "管理类别", DataType.DATA_TYPE_DICT,
						PropertyTypes.MANGER_TYPES, "true" },

				{ "42", "rentalType", "出租房类别", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_TYPE, "true" },
				{ "43", "rentalHouseProperty", "出租房性质",
						DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_TYPE, "true" },

				{ "44", "registDate", "登记日期", DataType.DATA_TYPE_DATE, "",
						"true" },
				{ "45", "lessorDate", "出租时间", DataType.DATA_TYPE_DATE, "",
						"true" },

				{ "46", "limitPersons", "限住人数", "", "", "true" },

				{ "47", "roomNumber", "出租间数", "", "", "true" },
				{ "48", "rentMonth", "月租金", "", "", "true" },
				{ "49", "hiddenRectification", "隐患情况", "", "", "true" },

				{ "50", "isSignGuarantee", "是否签订治安责任保证书",
						DataType.DATA_TYPE_BOOLEAN, "", "true" },
				{ "51", "isSafetyChannel", "有无安全通道",
						DataType.DATA_TYPE_BOOLEANS, "", "true" },
				{ "52", "isFireChannels", "有无消防通道",
						DataType.DATA_TYPE_BOOLEANS, "", "true" },
				{ "53", "isEmphasis", "是否注销", DataType.DATA_TYPE_BOOLEAN, "",
						"true" }, { "54", "remark", "备注", "", "", "true" },
				{ "55", "memberNum", "居住人数", "", "", "true" } };
		return excelColumArray;
	}

	/**
	 * 出租房信息导出 序号|对象属性|中文名|属性类型|类型|是否采用默认样式|合并行|合并列|
	 * 
	 * @retur
	 */
	public static String[][] getRentalHouseInfoPropertyArray() {
		String[][] excelColumArray = {
				{ "0", "", "出租房信息", "", "", "true", "0", "55" },
				{ "0", "houseCode", "房屋编号", "", "", "true" },
				{ "1", "organization", "所属网格", DataType.DATA_TYPE_ORG, "",
						"true" },
				// { "2", "addressType", "房屋地址类型", DataType.DATA_TYPE_DICT,
				// PropertyTypes.CURRENT_ADDRESS_TYPE, "true" },
				{ "2", "address", "房屋准确地址", "", "", "true" },
				{ "3", "houseAddress", "房产证地址", "", "", "true" },
				{ "4", "rentalPerson", "房主姓名", "", "", "true" },
				{ "5", "hiddenDangerLevel", "隐患程度", DataType.DATA_TYPE_DICT,
						PropertyTypes.HIDDEN_TROUBLE_LEVEL, "true" },
				{ "6", "buildingName", "建筑物名称", "", "", "true" },
				{ "7", "buildingUses", "建筑物用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.BUILDING_USES, "true" },
				{ "8", "propertyName", "物业管理单位名称", "", "", "true" },
				{ "9", "houseOwner", "代表人/业主", "", "", "true" },
				{ "10", "houseOwnerIdCardNo", "业主身份证号码", "", "", "true" },
				{ "11", "telephone", "业主联系电话", "", "", "true" },
				{ "12", "houseDoorModel", "房屋户型", "", "", "true" },
				{ "13", "builtYear", "建成年份", "", "", "true" },
				{ "14", "houseArea", "本户建筑面积", "", "", "true" },
				{ "15", "houseStructure", "房屋结构", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_STRUTS, "true" },
				{ "16", "houseUses", "房屋用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSE_USES, "true" },
				{ "17", "houseSource", "房屋来源", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSE_SOURCE, "true" },
				{ "18", "ownProperty", "自有产权", DataType.DATA_TYPE_DICT,
						PropertyTypes.OWN_PROPERTY, "true" },
				{ "19", "rentalBuildings", "租赁公房", DataType.DATA_TYPE_DICT,
						PropertyTypes.RENTAL_BUILDINGS, "true" },
				{ "20", "housingVouchers", "房屋凭证", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSING_VOUCHERS, "true" },
				{ "21", "houseRightNumber", "房屋权证号", "", "", "true" },
				{ "22", "houseRightNumberDate", "房屋权证发证时间",
						DataType.DATA_TYPE_DATE, "", "true" },
				{ "23", "landDocuments", "土地凭证", DataType.DATA_TYPE_DICT,
						PropertyTypes.LAND_DOCUMENTS, "true" },
				{ "24", "landRightsNumbe", "土地权证号", "", "", "true" },
				{ "25", "landRightsNumbeDate", "土地权证发证时间",
						DataType.DATA_TYPE_DATE, "", "true" },
				{ "26", "propertyTypes", "产权人类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.PROPERTY_TYPES, "true" },
				{ "27", "name", "产权人姓名", "", "", "true" },
				{ "28", "certificateType", "产权人证件类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGCERTIFICATE_TYPE, "true" },
				{ "29", "certificateNumbe", "产权人证件号码", "", "", "true" },
				{ "30", "propertyPersonTel", "产权人联系电话", "", "", "true" },
				{ "31", "propertyPersonMobile", "产权人联系手机", "", "", "true" },
				{ "32", "usage", "出租房用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_USAGE, "true" },
				{ "33", "houseFileNum", "租赁备案证号", "", "", "true" },
				{ "34", "lessorType", "出租人类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.LESSOR_TYPE, "true" },
				{ "35", "rentalCertificateType", "出租人证件类型",
						DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGCERTIFICATE_TYPE, "true" },
				{ "36", "rentalCertificateNumbe", "出租人证件号码", "", "", "true" },
				{ "37", "rentalTelephone", "出租人联系电话", "", "", "true" },
				{ "38", "rentalMobileNumber", "出租人联系手机", "", "", "true" },
				{ "39", "lessorAddress", "出租人联系地址", "", "", "true" },
				{ "40", "mangerTypes", "管理类别", DataType.DATA_TYPE_DICT,
						PropertyTypes.MANGER_TYPES, "true" },

				// fateson add
				{ "40", "rentalType", "出租房类别", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_TYPE, "true" },
				{ "41", "rentalHouseProperty", "出租房性质",
						DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_TYPE, "true" },

				{ "42", "registDate", "登记日期", DataType.DATA_TYPE_DATE, "",
						"true" },

				{ "43", "lessorDate", "出租时间", DataType.DATA_TYPE_DATE, "",
						"true" },

				{ "44", "limitPersons", "限住人数", "", "", "true" },

				{ "45", "roomNumber", "出租间数", "", "", "true" },
				{ "46", "rentMonth", "月租金", "", "", "true" },
				{ "47", "hiddenRectification", "隐患情况", "", "", "true" },

				{ "48", "isSignGuarantee", "是否签订治安责任保证书",
						DataType.DATA_TYPE_BOOLEAN, "", "true" },
				{ "49", "isSafetyChannel", "有无安全通道",
						DataType.DATA_TYPE_BOOLEANS, "", "true" },
				{ "50", "isFireChannels", "有无消防通道",
						DataType.DATA_TYPE_BOOLEANS, "", "true" },
				{ "51", "isEmphasis", "是否注销", DataType.DATA_TYPE_BOOLEAN, "",
						"true" },
				{ "52", "hasServiceTeamMember", "有无治安负责人",
						DataType.DATA_TYPE_COUNTS, "", "true" },
				{ "53", "lastRecordTime", "最新巡场时间", DataType.DATA_TYPE_DATE,
						"", "true" }, { "54", "remark", "备注", "", "", "true" },
				{ "55", "memberNum", "居住人数", "", "", "true" } };
		return excelColumArray;
	}

	/**
	 * 实有房屋和出租房信息导入 序号|对象属性|中文名|属性类型|类型|是否采用默认样式|合并行|合并列|
	 * 
	 * @return
	 */
	public static String[][] getRentalHouseTempImportArray() {
		String[][] excelColumArray = {
				{ "0", "houseCode", "房屋编号", "", "", "true" },

				{ "1", "addressType", "房屋地址类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.CURRENT_ADDRESS_TYPE, "true" },
				{ "2", "community", "小区/地址", "", "", "true" },
				{ "3", "block", "幢", "", "", "true" },
				{ "4", "unit", "单元", "", "", "true" },
				{ "5", "room", "室", "", "", "true" },
				{ "6", "isRentalHouse", "是否是出租房", DataType.DATA_TYPE_BOOLEAN,
						"", "true" },
				{ "7", "rentalPerson", "房主姓名", "", "", "true" },
				{ "8", "hiddenDangerLevel", "隐患程度", DataType.DATA_TYPE_DICT,
						PropertyTypes.HIDDEN_TROUBLE_LEVEL, "true" },
				{ "9", "buildingName", "建筑物名称", "", "", "true" },
				{ "10", "buildingUses", "建筑物用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.BUILDING_USES, "true" },
				{ "11", "propertyName", "物业管理单位名称", "", "", "true" },
				{ "12", "houseOwner", "代表人/业主", "", "", "true" },
				{ "13", "houseOwnerIdCardNo", "业主身份证号码", "", "", "true" },
				{ "14", "telephone", "业主联系电话", "", "", "true" },
				{ "15", "houseDoorModel", "房屋户型", "", "", "true" },
				{ "16", "builtYear", "建成年份", "", "", "true" },
				{ "17", "houseArea", "本户建筑面积", "", "", "true" },
				{ "18", "houseStructure", "房屋结构", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_STRUTS, "true" },
				{ "19", "houseUses", "房屋用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSE_USES, "true" },
				{ "20", "houseSource", "房屋来源", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSE_SOURCE, "true" },
				{ "21", "ownProperty", "自有产权", DataType.DATA_TYPE_DICT,
						PropertyTypes.OWN_PROPERTY, "true" },
				{ "22", "rentalBuildings", "租赁公房", DataType.DATA_TYPE_DICT,
						PropertyTypes.RENTAL_BUILDINGS, "true" },
				{ "23", "housingVouchers", "房屋凭证", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSING_VOUCHERS, "true" },
				{ "24", "houseRightNumber", "房屋权证号", "", "", "true" },
				{ "25", "houseRightNumberDate", "房屋权证发证时间",
						DataType.DATA_TYPE_DATE, "", "true" },
				{ "26", "landDocuments", "土地凭证", DataType.DATA_TYPE_DICT,
						PropertyTypes.LAND_DOCUMENTS, "true" },
				{ "27", "landRightsNumbe", "土地权证号", "", "", "true" },
				{ "28", "landRightsNumbeDate", "土地权证发证时间",
						DataType.DATA_TYPE_DATE, "", "true" },
				{ "29", "propertyTypes", "产权人类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.PROPERTY_TYPES, "true" },
				{ "30", "name", "产权人姓名", "", "", "true" },
				{ "31", "certificateType", "产权人证件类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGCERTIFICATE_TYPE, "true" },
				{ "32", "certificateNumbe", "产权人证件号码", "", "", "true" },
				{ "33", "propertyPersonTel", "产权人联系电话", "", "", "true" },
				{ "34", "propertyPersonMobile", "产权人联系手机", "", "", "true" },
				{ "35", "usage", "出租房用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_USAGE, "true" },
				{ "36", "houseFileNum", "租赁备案证号", "", "", "true" },
				{ "37", "lessorType", "出租人类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.LESSOR_TYPE, "true" },
				{ "38", "rentalCertificateType", "出租人证件类型",
						DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGCERTIFICATE_TYPE, "true" },
				{ "39", "rentalCertificateNumbe", "出租人证件号码", "", "", "true" },
				{ "40", "rentalTelephone", "出租人联系电话", "", "", "true" },
				{ "41", "rentalMobileNumber", "出租人联系手机", "", "", "true" },
				{ "42", "lessorAddress", "出租人联系地址", "", "", "true" },
				{ "43", "mangerTypes", "管理类别", DataType.DATA_TYPE_DICT,
						PropertyTypes.MANGER_TYPES, "true" },
				{ "44", "lessorDate", "出租时间", DataType.DATA_TYPE_DATE, "",
						"true" },
				{ "45", "roomNumber", "出租间数", "", "", "true" },
				{ "46", "rentMonth", "月租金", "", "", "true" },
				{ "47", "isSignGuarantee", "是否签订治安责任保证书",
						DataType.DATA_TYPE_BOOLEAN, "", "true" },
				{ "48", "isSafetyChannel", "有无安全通道",
						DataType.DATA_TYPE_BOOLEANS, "", "true" },
				{ "49", "isFireChannels", "有无消防通道",
						DataType.DATA_TYPE_BOOLEANS, "", "true" },
				{ "50", "remark", "备注", "", "", "true" } };
		return excelColumArray;
	}

	public static String[][] getHouseInfoImportArray() {
		String[][] excelColumArray = {
				{ "0", "houseCode", "房屋编号", "", "", "true" },
				{ "1", "organization", "所属网格", DataType.DATA_TYPE_ORG, "",
						"true" },
				{ "2", "addressType", "房屋地址类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.CURRENT_ADDRESS_TYPE, "true" },
				{ "3", "community", "小区/地址", "", "", "true" },
				{ "4", "block", "幢", "", "", "true" },
				{ "5", "unit", "单元", "", "", "true" },
				{ "6", "room", "室", "", "", "true" },
				{ "7", "isRentalHouse", "是否是出租房", DataType.DATA_TYPE_BOOLEAN,
						"", "true" },
				{ "8", "rentalPerson", "房主姓名", "", "", "true" },
				{ "9", "hiddenDangerLevel", "隐患程度", DataType.DATA_TYPE_DICT,
						PropertyTypes.HIDDEN_TROUBLE_LEVEL, "true" },
				{ "10", "buildingName", "建筑物名称", "", "", "true" },
				{ "11", "buildingUses", "建筑物用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.BUILDING_USES, "true" },
				{ "12", "propertyName", "物业管理单位名称", "", "", "true" },
				{ "13", "houseOwner", "代表人/业主", "", "", "true" },
				{ "14", "houseOwnerIdCardNo", "业主身份证号码", "", "", "true" },
				{ "15", "telephone", "业主联系电话", "", "", "true" },
				{ "16", "houseDoorModel", "房屋户型", "", "", "true" },
				{ "17", "builtYear", "建成年份", "", "", "true" },
				{ "18", "houseArea", "本户建筑面积", DataType.DATA_TYPE_DOUBLE, "",
						"true" },
				{ "19", "houseStructure", "房屋结构", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_STRUTS, "true" },
				{ "20", "houseUses", "房屋用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSE_USES, "true" },
				{ "21", "houseSource", "房屋来源", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSE_SOURCE, "true" },
				{ "22", "ownProperty", "自有产权", DataType.DATA_TYPE_DICT,
						PropertyTypes.OWN_PROPERTY, "true" },
				{ "23", "rentalBuildings", "租赁公房", DataType.DATA_TYPE_DICT,
						PropertyTypes.RENTAL_BUILDINGS, "true" },
				{ "24", "housingVouchers", "房屋凭证", DataType.DATA_TYPE_DICT,
						PropertyTypes.HOUSING_VOUCHERS, "true" },
				{ "25", "houseRightNumber", "房屋权证号", "", "", "true" },
				{ "26", "houseRightNumberDate", "房屋权证发证时间",
						DataType.DATA_TYPE_DATE, "", "true" },
				{ "27", "landDocuments", "土地凭证", DataType.DATA_TYPE_DICT,
						PropertyTypes.LAND_DOCUMENTS, "true" },
				{ "28", "landRightsNumbe", "土地权证号", "", "", "true" },
				{ "29", "landRightsNumbeDate", "土地权证发证时间",
						DataType.DATA_TYPE_DATE, "", "true" },
				{ "30", "propertyTypes", "产权人类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.PROPERTY_TYPES, "true" },
				{ "31", "name", "产权人姓名", "", "", "true" },
				{ "32", "certificateType", "产权人证件类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGCERTIFICATE_TYPE, "true" },
				{ "33", "certificateNumbe", "产权人证件号码", "", "", "true" },
				{ "34", "propertyPersonTel", "产权人联系电话", "", "", "true" },
				{ "35", "propertyPersonMobile", "产权人联系手机", "", "", "true" },
				{ "36", "usage", "出租房用途", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_USAGE, "true" },
				{ "37", "houseFileNum", "租赁备案证号", "", "", "true" },
				{ "38", "lessorType", "出租人类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.LESSOR_TYPE, "true" },
				{ "39", "rentalCertificateType", "出租人证件类型",
						DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGCERTIFICATE_TYPE, "true" },
				{ "40", "rentalCertificateNumbe", "出租人证件号码", "", "", "true" },
				{ "41", "rentalTelephone", "出租人联系电话", "", "", "true" },
				{ "42", "rentalMobileNumber", "出租人联系手机", "", "", "true" },
				{ "43", "lessorAddress", "出租人联系地址", "", "", "true" },
				{ "44", "mangerTypes", "管理类别", DataType.DATA_TYPE_DICT,
						PropertyTypes.MANGER_TYPES, "true" },
				{ "45", "lessorDate", "出租时间", DataType.DATA_TYPE_DATE, "",
						"true" },
				{ "46", "roomNumber", "出租间数", "", "", "true" },
				{ "47", "rentMonth", "月租金", "", "", "true" },
				{ "48", "isSignGuarantee", "是否签订治安责任保证书",
						DataType.DATA_TYPE_BOOLEAN, "", "true" },
				{ "49", "isSafetyChannel", "有无安全通道",
						DataType.DATA_TYPE_BOOLEANS, "", "true" },
				{ "50", "isFireChannels", "有无消防通道",
						DataType.DATA_TYPE_BOOLEANS, "", "true" },
				{ "51", "remark", "备注", "", "", "true" } };
		return excelColumArray;
	}

	/**
	 * 楼宇信息数组 序号|属性|中文名|属性类型|是否采用默认样式|合并行|合并列
	 * 
	 * @return
	 */
	public static String[][] getBuildDatasImportArray() {
		String[][] excelColumArray = {
				{ "0", "buildingname", "楼宇名称", "", "", "true" },
				{ "1", "organization", "所属网格", DataType.DATA_TYPE_ORG, "",
						"true" },
				{ "2", "buildingaddress", "楼宇地址", "", "", "true" },
				{ "3", "owner", "业主", "", "", "true" },
				{ "4", "responsibleperson", "负责人", "", "", "true" },
				{ "5", "phone", "联系电话", "", "", "true" },
				{ "6", "buildingstructures", "建筑结构", DataType.DATA_TYPE_DICT,
						PropertyTypes.LETTINGHOUSE_STRUTS, "true" },
				{ "7", "type", "楼宇类型", DataType.DATA_TYPE_DICT,
						PropertyTypes.BUILDDATAS_TYPE, "true" } };
		return excelColumArray;
	}
}

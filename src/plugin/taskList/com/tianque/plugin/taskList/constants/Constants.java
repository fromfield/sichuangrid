package com.tianque.plugin.taskList.constants;

import java.util.HashMap;
import java.util.Map;

import com.tianque.plugin.judgmentAnalysis.util.StringUtil;

/**
 * 定义任务清单中使用的常量
 * 
 * @author lanhaifeng
 * 
 */
public class Constants {
	/** 定义任务清单中对应的表 **/
	private static Map<String, String> tableMap = new HashMap<String, String>();
	/** 定义治安隐患不同类别 **/
	private static Map<String, String> hiddenDangerMap = new HashMap<String, String>();

	public static String TERMERRECORD_KEY = "termerRecord";
	public static String POSITIVEINFORECORD_KEY = "positiveInfoRecord";
	public static String DRUGGYTASK_KEY = "druggyTask";
	public static String MENTALPATIENTTASK_KEY = "mentalPatientTask";
	public static String EXCEPTIONALSITUATIONRECORD_KEY = "exceptionalSituationRecord";

	public static String REPLY_TERMERRECORD_KEY = "reply_termerRecord";
	public static String REPLY_POSITIVEINFORECORD_KEY = "reply_positiveInfoRecord";
	public static String REPLY_DRUGGYTASK_KEY = "reply_druggyTask";
	public static String REPLY_MENTALPATIENTTASK_KEY = "reply_mentalPatientTask";
	public static String REPLY_HIDDENDANGER_KEY = "reply_hiddenDanger";
	public static String REPLY_EXCEPTIONALSITUATIONRECORD_KEY = "reply_exceptionalSituationRecord";

	public static String VIOLENCE = "violence";
	public static String GUN = "gun";
	public static String MAKE = "makeDrug";
	public static String PUSHDRUG = "pushDrug";
	public static String TAKEDRUG = "takeDrug";
	public static String CULT = "cult";
	public static String COUNTERFEIT = "counterfeit";
	public static String EROTICA = "erotica";
	public static String GAMBLE = "gamble";
	public static String PYRAMIDSALE = "pyramidSale";
	public static String FIRE = "fire";
	public static String RECEIVELOOT = "receiveLoot";
	public static String PUSHLOOT = "pushLoot";
	public static String NOTEND = "noTend";
	public static String OTHER = "other";

	public static String HIDDENDANGER_KEY = "hiddenDanger";
	public static String EXCEPTIONSITUATION_KEY = "exceptionSituation";
	/** 日期格式字符串 **/
	public static String SIGNDATEFORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String FUNCTIONAL_DEPARTMENT_TYPE = "职能部门类型";
	public static String JUSTICE_DEPARTMENT = "司法部门";
	public static String POLICE_DEPARTMENT = "公安部门";
	public static String HEALTH_DEPARTMENT = "卫生部门";

	public static String POLICE = "police";
	public static String JUSTICE = "justice";
	public static String ISADMINSTRATOR = "false";
	
	public static String TASKLIST_KEY="Task";
	
	public static Map<String,String> gridTableNameMap = new HashMap<String,String>();

	static {
		
		gridTableNameMap.put("Task", "gridConfigTask");
		gridTableNameMap.put("ServiceList", "gridConfigServiceList");
		
		tableMap.put(TERMERRECORD_KEY, "termerRecord");
		tableMap.put(POSITIVEINFORECORD_KEY, "positiveInfoRecord");
		tableMap.put(DRUGGYTASK_KEY, "druggyTask");
		tableMap.put(MENTALPATIENTTASK_KEY, "mentalPatientTask");
		tableMap.put(EXCEPTIONALSITUATIONRECORD_KEY, "exceptionalSituationRecord");

		hiddenDangerMap.put(VIOLENCE, "涉暴恐");
		hiddenDangerMap.put(GUN, "涉枪涉爆");
		hiddenDangerMap.put(MAKE, "涉制毒");
		hiddenDangerMap.put(PUSHDRUG, "涉贩毒");
		hiddenDangerMap.put(TAKEDRUG, "涉吸毒");
		hiddenDangerMap.put(CULT, "邪教活动");
		hiddenDangerMap.put(COUNTERFEIT, "制假贩假");
		hiddenDangerMap.put(EROTICA, "涉黄");
		hiddenDangerMap.put(GAMBLE, "涉赌");
		hiddenDangerMap.put(PYRAMIDSALE, "传销");
		hiddenDangerMap.put(FIRE, "火灾隐患");
		hiddenDangerMap.put(RECEIVELOOT, "收赃");
		hiddenDangerMap.put(PUSHLOOT, "销赃");
		hiddenDangerMap.put(NOTEND, "无守楼护院人员");
		hiddenDangerMap.put(OTHER, "其他异常事件");
	}

	public static String getTableByKey(String key) {
		if (StringUtil.isEmpty(key)) {
			return null;
		}
		return tableMap.get(key);
	}

	public static String getHiddenDangerMap(String key) {
		if (StringUtil.isEmpty(key)) {
			return null;
		}
		return hiddenDangerMap.get(key);
	}
}

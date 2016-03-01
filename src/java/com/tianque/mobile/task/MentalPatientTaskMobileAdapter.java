package com.tianque.mobile.task;

public interface MentalPatientTaskMobileAdapter {
	/**
	 * 查询精神病走访任务list
	 * @return
	 * @throws Exception
	 */
	public String getMentalPatientList() throws Exception;

	/**
	 * 新增精神病走访任务
	 * @return
	 * @throws Exception
	 */
	public String addMentalPatientTask() throws Exception;

	/**
	 * 修改精神病走访任务
	 * @return
	 * @throws Exception
	 */
	public String updateMentalPatientTask() throws Exception;

	/**
	 * 删除精神病走访任务
	 * @return
	 * @throws Exception
	 */
	public String deleteMentalPatientTask() throws Exception;

	/**
	 * 查看精神病走访任务
	 * @return
	 * @throws Exception
	 */
	public String viewMentalPatientTask() throws Exception;
	
	public String getMentalPatientTaskIsSign() throws Exception;
	
	/**
	 * 查询精神病走访记录list
	 * @return
	 * @throws Exception
	 */
	public String getInterViewMentalPatientList() throws Exception;
	
	/**
	 * 查看精神病走访任务
	 * @return
	 * @throws Exception
	 */
	public String viewInterViewMentalPatient() throws Exception;

}

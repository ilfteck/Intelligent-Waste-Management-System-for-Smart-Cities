package com.service;

import java.util.List;
import java.util.Map;

public interface CommonService {
	List<Map<String, Object>> pieSum(Map<String, Object> params);
	List<Map<String, Object>> pieCount(Map<String, Object> params);
	List<Map<String, Object>> barSumOne(Map<String, Object> params);
	List<Map<String, Object>> barCountOne(Map<String, Object> params);
	List<Map<String, Object>> barSumTwo(Map<String, Object> params);
	List<Map<String, Object>> barCountTwo(Map<String, Object> params);

	/**
	 tableName 
	 condition1 
	 condition1Value 
	 average 
	 * */
	Map<String, Object> queryScore(Map<String, Object> params);
	/**
	 * newSelectGroupSum
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> newSelectGroupSum(Map<String, Object> params);
	/**
	 * newSelectGroupCount
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> newSelectGroupCount(Map<String, Object> params);
	/**
	 * barSum
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> barSum(Map<String, Object> params);
	/**
	 * barCount
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> barCount(Map<String, Object> params);

}

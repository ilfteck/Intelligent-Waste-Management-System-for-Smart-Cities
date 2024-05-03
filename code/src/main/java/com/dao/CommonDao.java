
package com.dao;

import java.util.List;
import java.util.Map;

/**
 * Universal interface
 */
public interface CommonDao{
	List<Map<String, Object>> pieSum(Map<String, Object> params);
	List<Map<String, Object>> pieCount(Map<String, Object> params);
	List<Map<String, Object>> barSumOne(Map<String, Object> params);
	List<Map<String, Object>> barCountOne(Map<String, Object> params);
	List<Map<String, Object>> barSumTwo(Map<String, Object> params);
	List<Map<String, Object>> barCountTwo(Map<String, Object> params);
	Map<String, Object> queryScore(Map<String, Object> params);
	/**
	 * New group summation method for concatenated dictionary tables
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> newSelectGroupSum(Map<String, Object> params);
	/**
	 * New group summation method for concatenated dictionary tables
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> newSelectGroupCount(Map<String, Object> params);
	/**
	 *Bar graph summation
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> barSum(Map<String, Object> params);

	/**
	 * Bar chart statistics
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> barCount(Map<String, Object> params);
}


package com.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommonDao;
import com.service.CommonService;


/**
 * commonService
 * @author
 * @date
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private CommonDao commonDao;

	public List<Map<String, Object>> pieSum(Map<String, Object> params){
		return commonDao.pieSum(params);
	}
	public List<Map<String, Object>> pieCount(Map<String, Object> params){
		return commonDao.pieCount(params);
	}
	public List<Map<String, Object>> barSumOne(Map<String, Object> params){
		return commonDao.barSumOne(params);
	}
	public List<Map<String, Object>> barCountOne(Map<String, Object> params){
		return commonDao.barCountOne(params);
	}
	public List<Map<String, Object>> barSumTwo(Map<String, Object> params){
		return commonDao.barSumTwo(params);
	}
	public List<Map<String, Object>> barCountTwo(Map<String, Object> params){
		return commonDao.barCountTwo(params);
	}
	/**
	 tableName 
	 condition1 
	 condition1Value
	 average
	 * */
	public Map<String, Object> queryScore(Map<String, Object> params){
		return commonDao.queryScore(params);
	}
	/**
	 * newSelectGroupSum
	 * @param params
	 * @return
	 */
	@Override
	public List<Map<String, Object>> newSelectGroupSum(Map<String, Object> params) {
		return commonDao.newSelectGroupSum(params);
	}
	/**
	 * newSelectGroupCount
	 * @param params
	 * @return
	 */
	@Override
	public List<Map<String, Object>> newSelectGroupCount(Map<String, Object> params) {
		return commonDao.newSelectGroupCount(params);
	}
	/**
	 * barSum
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> barSum(Map<String, Object> params){
		return commonDao.barSum(params);
	}

	/**
	 * barCount
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> barCount(Map<String, Object> params){
		return commonDao.barCount(params);
	}

}

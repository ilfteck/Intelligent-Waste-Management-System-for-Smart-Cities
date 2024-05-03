
package com.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * Query parameter
 */
public class Query<T> extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
    /**
     * mybatis-plus paging parameters
     */
    private Page<T> page;
    /**
     * currPage
     */
    private int currPage = 1;
    /**
     * limit
     */
    private int limit = 10;

    public Query(JQPageInfo pageInfo) {
    	//Paging parameter
        if(pageInfo.getPage()!= null){
            currPage = pageInfo.getPage();
        }
        if(pageInfo.getLimit()!= null){
            limit = pageInfo.getLimit();
        }

    
        //Prevent SQL injection (because sidx and order are sorted by concatenating SQL, there will be SQL injection risk)
        String sidx = SQLFilter.sqlInject(pageInfo.getSidx());
        String order = SQLFilter.sqlInject(pageInfo.getOrder());
        

        //mybatis-pluspaging
        this.page = new Page<>(currPage, limit);

        //sort
        if(StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(order)){
            this.page.setOrderByField(sidx);
            this.page.setAsc("ASC".equalsIgnoreCase(order));
        }
    }
    
    
    public Query(Map<String, Object> params){
        this.putAll(params);

        //Paging parameter
        if(params.get("page") != null){
            currPage = Integer.parseInt(String.valueOf(params.get("page")));
        }
        if(params.get("limit") != null){
            limit = Integer.parseInt(String.valueOf(params.get("limit")));
        }

        this.put("offset", (currPage - 1) * limit);
        this.put("page", currPage);
        this.put("limit", limit);

        //Prevent SQL injection (because sidx and order are sorted by concatenating SQL, there will be SQL injection risk)
        String sidx = SQLFilter.sqlInject((String)params.get("sidx"));
        String order = SQLFilter.sqlInject((String)params.get("order"));
        this.put("sidx", sidx);
        this.put("order", order);

        //mybatis-pluspaging
        this.page = new Page<>(currPage, limit);

        //sort
        if(StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(order)){
            this.page.setOrderByField(sidx);
            this.page.setAsc("ASC".equalsIgnoreCase(order));
        }

    }

    public Page<T> getPage() {
        return page;
    }

    public int getCurrPage() {
        return currPage;
    }

    public int getLimit() {
        return limit;
    }
}

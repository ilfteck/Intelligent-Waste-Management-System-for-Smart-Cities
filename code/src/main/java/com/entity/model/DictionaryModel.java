package com.entity.model;

import com.entity.DictionaryEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * dictionary
 * The entity class that receives the argument
 *(In the actual development, with the mobile interface development, manually remove some useless fields, and the backend is generally enough to use entity)
 * model name from ModelAndView
 */
public class DictionaryModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */
    private Long id;


    /**
     * dicCode
     */
    private String dicCode;


    /**
     * dicName
     */
    private String dicName;


    /**
     * codeIndex
     */
    private Integer codeIndex;


    /**
     * codeIndex
     */
    private String codeIndex;


    /**
     * superId
     */
    private Integer superId;


    /**
     * beizhu
     */
    private String beizhu;


    /**
     * createTime
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


  
    public Long getId() {
        return id;
    }


    
    public void setId(Long id) {
        this.id = id;
    }
   
    public String getDicCode() {
        return dicCode;
    }


   
    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }
    
    public String getDicName() {
        return dicName;
    }


  
    public void setDicName(String dicName) {
        this.dicName = dicName;
    }
    
    public Integer getCodeIndex() {
        return codeIndex;
    }


  
    public void setCodeIndex(Integer codeIndex) {
        this.codeIndex = codeIndex;
    }
   
    public String getIndexName() {
        return indexName;
    }


    
    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
  
    public Integer getSuperId() {
        return superId;
    }


    public void setSuperId(Integer superId) {
        this.superId = superId;
    }
   
    public String getBeizhu() {
        return beizhu;
    }


    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
  
    public Date getCreateTime() {
        return createTime;
    }


    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

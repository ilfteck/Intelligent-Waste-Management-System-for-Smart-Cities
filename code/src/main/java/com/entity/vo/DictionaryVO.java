package com.entity.vo;

import com.entity.DictionaryEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
* Dictionary
* Mobile interface returns entity helper class
* (The main function is to remove some unnecessary fields)
 */
@TableName("dictionary")
public class DictionaryVO implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "id")
    private Long id;



    @TableField(value = "dic_code")
    private String dicCode;


    

    @TableField(value = "dic_name")
    private String dicName;



    @TableField(value = "code_index")
    private Integer codeIndex;


  

    @TableField(value = "index_name")
    private String indexName;


   

    @TableField(value = "super_id")
    private Integer superId;




    @TableField(value = "beizhu")
    private String beizhu;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

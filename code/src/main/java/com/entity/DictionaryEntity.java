package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * dictionary
 *
 * @author 
 * @email
 */
@TableName("dictionary")
public class DictionaryEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DictionaryEntity() {

	}

	public DictionaryEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="id",type="bigint(20)")
    @TableField(value = "id")

    private Long id;


    /**
     * dic_code
     */
    @ColumnInfo(comment="dic_code",type="varchar(200)")
    @TableField(value = "dic_code")

    private String dicCode;


    /**
     * dic_name
     */
    @ColumnInfo(comment="dic_name",type="varchar(200)")
    @TableField(value = "dic_name")

    private String dicName;


    /**
     * code_index
     */
    @ColumnInfo(comment="code_index",type="int(11)")
    @TableField(value = "code_index")

    private Integer codeIndex;


    /**
     * index_name
     */
    @ColumnInfo(comment="index_name",type="varchar(200)")
    @TableField(value = "index_name")

    private String indexName;


    /**
     * super_id
     */
    @ColumnInfo(comment="super_id",type="int(11)")
    @TableField(value = "super_id")

    private Integer superId;


    /**
     * remark
     */
    @ColumnInfo(comment="remark",type="varchar(200)")
    @TableField(value = "remark")

    private String beizhu;


    /**
     * create_time
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="create_time",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Dictionary{" +
            ", id=" + id +
            ", dicCode=" + dicCode +
            ", dicName=" + dicName +
            ", codeIndex=" + codeIndex +
            ", indexName=" + indexName +
            ", superId=" + superId +
            ", beizhu=" + beizhu +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

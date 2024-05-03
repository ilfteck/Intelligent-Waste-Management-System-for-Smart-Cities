package com.entity;

import com.annotation.ColumnInfo;

import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;

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
 * recycle
 *
 * @author 
 * @email
 */
@TableName("recycle")
public class RecycleEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RecycleEntity() {

	}

	public RecycleEntity(T t) {
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
    @ColumnInfo(comment="id",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * recycle_name
     */
    @ColumnInfo(comment="recycle_name",type="varchar(200)")
    @TableField(value = "recycle_name")

    private String recycleName;


    /**
     * recycle_uuid_number
     */
    @ColumnInfo(comment="recycle_uuid_number",type="varchar(200)")
    @TableField(value = "recycle_uuid_number")

    private String recycleUuidNumber;


    /**
     * recycle_photo
     */
    @ColumnInfo(comment="recycle_photo",type="varchar(200)")
    @TableField(value = "recycle_photo")

    private String recyclePhoto;


    /**
     * recycle_address
     */
    @ColumnInfo(comment="recycle_address",type="varchar(200)")
    @TableField(value = "recycle_address")

    private String recycleAddress;


    /**
     * recycle_types
     */
    @ColumnInfo(comment="recycle_types",type="int(11)")
    @TableField(value = "recycle_types")

    private Integer recycleTypes;


    /**
     * recycle_kucun_number
     */
    @ColumnInfo(comment="recycle_kucun_number",type="int(11)")
    @TableField(value = "recycle_kucun_number")

    private Integer recycleKucunNumber;


    /**
     * recycle_time
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="recycle_time",type="timestamp")
    @TableField(value = "recycle_time")

    private Date recycleTime;


    /**
     * recycle_content
     */
    @ColumnInfo(comment="recycle_content",type="longtext")
    @TableField(value = "recycle_content")

    private String recycleContent;


    /**
     * recycle_delete
     */
    @ColumnInfo(comment="recycle_delete",type="int(11)")
    @TableField(value = "recycle_delete")

    private Integer recycleDelete;


    /**
     * insert_time
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="insert_time",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * create_time
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="create_time",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;



    public Integer getId() {
        return id;
    }
  

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrecycleName() {
        return recycleName;
    }


    public void setrecycleName(String recycleName) {
        this.recycleName = recycleName;
    }
   
    public String getrecycleUuidNumber() {
        return recycleUuidNumber;
    }
  

    public void setrecycleUuidNumber(String recycleUuidNumber) {
        this.recycleUuidNumber = recycleUuidNumber;
    }
   
    public String getrecyclePhoto() {
        return recyclePhoto;
    }
  
    public void setrecyclePhoto(String recyclePhoto) {
        this.recyclePhoto = recyclePhoto;
    }
   
    public String getrecycleAddress() {
        return recycleAddress;
    }
  

    public void setrecycleAddress(String recycleAddress) {
        this.recycleAddress = recycleAddress;
    }
  
    public Integer getrecycleTypes() {
        return recycleTypes;
    }
   

    public void setrecycleTypes(Integer recycleTypes) {
        this.recycleTypes = recycleTypes;
    }
   
    public Integer getrecycleKucunNumber() {
        return recycleKucunNumber;
    }
  
    public void setrecycleKucunNumber(Integer recycleKucunNumber) {
        this.recycleKucunNumber = recycleKucunNumber;
    }
  
    public Date getrecycleTime() {
        return recycleTime;
    }

    public void setrecycleTime(Date recycleTime) {
        this.recycleTime = recycleTime;
    }
    
    public String getrecycleContent() {
        return recycleContent;
    }
    

    public void setrecycleContent(String recycleContent) {
        this.recycleContent = recycleContent;
    }
    
    public Integer getrecycleDelete() {
        return recycleDelete;
    }
    

    public void setrecycleDelete(Integer recycleDelete) {
        this.recycleDelete = recycleDelete;
    }
    
    public Date getInsertTime() {
        return insertTime;
    }
  

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
  
    public Date getCreateTime() {
        return createTime;
    }
    

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "recycle{" +
            ", id=" + id +
            ", recycleName=" + recycleName +
            ", recycleUuidNumber=" + recycleUuidNumber +
            ", recyclePhoto=" + recyclePhoto +
            ", recycleAddress=" + recycleAddress +
            ", recycleTypes=" + recycleTypes +
            ", recycleKucunNumber=" + recycleKucunNumber +
            ", recycleTime=" + DateUtil.convertString(recycleTime,"yyyy-MM-dd") +
            ", recycleContent=" + recycleContent +
            ", recycleDelete=" + recycleDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

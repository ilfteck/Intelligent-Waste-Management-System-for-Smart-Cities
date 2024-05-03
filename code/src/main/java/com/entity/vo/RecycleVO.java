package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
* Garbage collection
* Mobile interface returns entity helper class
* (The main function is to remove some unnecessary fields)
 */
@TableName("recycle")
public class RecycleVO implements Serializable {
    private static final long serialVersionUID = 1L;


 

    @TableField(value = "id")
    private Integer id;


   
    @TableField(value = "recycle_name")
    private String recycleName;



    @TableField(value = "recycle_uuid_number")
    private String recycleUuidNumber;


  
    @TableField(value = "recycle_photo")
    private String recyclePhoto;


   

    @TableField(value = "recycle_address")
    private String recycleAddress;



    @TableField(value = "recycle_types")
    private Integer recycleTypes;


    @TableField(value = "recycle_kucun_number")
    private Integer recycleKucunNumber;


   
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "recycle_time")
    private Date recycleTime;


   

    @TableField(value = "recycle_content")
    private String recycleContent;


  
    @TableField(value = "recycle_delete")
    private Integer recycleDelete;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}

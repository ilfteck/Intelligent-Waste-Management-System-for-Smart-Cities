package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * Garbage recycling
  * The entity class that receives the argument
 *(In the actual development, with the mobile interface development, manually remove some useless fields, and the backend is generally enough to use entity)
 * model name from ModelAndView
 */
public class RecycleModel implements Serializable {
    private static final long serialVersionUID = 1L;




    private Integer id;


 
    private String recycleName;



    private String recycleUuidNumber;


    private String recyclePhoto;



    private String recycleAddress;


  
    private Integer recycleTypes;


    private Integer recycleKucunNumber;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date recycleTime;


    private String recycleContent;


    private Integer recycleDelete;



    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
* Garbage removal request
* The entity class that receives arguments
* (In actual development, with the mobile interface development, manually remove some useless fields, and the backend is generally sufficient with entity)
* model name from ModelAndView
 */
public class RecycleReserveModel implements Serializable {
    private static final long serialVersionUID = 1L;




  
    private Integer id;


    private String recycleYuyueUuidNumber;


  
    private Integer recycleId;


    private Integer memberId;


  
    private String recycleYuyueText;


  
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date recycletransportTime;



    private Integer recycleYuyueYesnoTypes;


  
    private String recycleYuyueYesnoText;


  
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date recycleYuyueShenheTime;


 
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
   
    public String getrecycleYuyueUuidNumber() {
        return recycleYuyueUuidNumber;
    }


    public void setrecycleYuyueUuidNumber(String recycleYuyueUuidNumber) {
        this.recycleYuyueUuidNumber = recycleYuyueUuidNumber;
    }
  
    public Integer getrecycleId() {
        return recycleId;
    }


   
    public void setrecycleId(Integer recycleId) {
        this.recycleId = recycleId;
    }
   
    public Integer getmemberId() {
        return memberId;
    }


 
    public void setmemberId(Integer memberId) {
        this.memberId = memberId;
    }
   
    public String getrecycleYuyueText() {
        return recycleYuyueText;
    }


 
    public void setrecycleYuyueText(String recycleYuyueText) {
        this.recycleYuyueText = recycleYuyueText;
    }
  
    public Date getrecycletransportTime() {
        return recycletransportTime;
    }


   
    public void setrecycletransportTime(Date recycletransportTime) {
        this.recycletransportTime = recycletransportTime;
    }
   
    public Integer getrecycleYuyueYesnoTypes() {
        return recycleYuyueYesnoTypes;
    }


  
    public void setrecycleYuyueYesnoTypes(Integer recycleYuyueYesnoTypes) {
        this.recycleYuyueYesnoTypes = recycleYuyueYesnoTypes;
    }
  
    public String getrecycleYuyueYesnoText() {
        return recycleYuyueYesnoText;
    }


  
    public void setrecycleYuyueYesnoText(String recycleYuyueYesnoText) {
        this.recycleYuyueYesnoText = recycleYuyueYesnoText;
    }
   
    public Date getrecycleYuyueShenheTime() {
        return recycleYuyueShenheTime;
    }



    public void setrecycleYuyueShenheTime(Date recycleYuyueShenheTime) {
        this.recycleYuyueShenheTime = recycleYuyueShenheTime;
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

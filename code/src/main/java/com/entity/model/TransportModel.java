package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * Transportation
* The entity class that receives arguments
* (In actual development, with the mobile interface development, manually remove some useless fields, and the backend is generally sufficient with entity)
* model name from ModelAndView
 */
public class TransportModel implements Serializable {
    private static final long serialVersionUID = 1L;




  
    private Integer id;


   
    private Integer recycleYuyueId;


   
    private String transportName;


   
    private String transportUuidNumber;


   
    private String transportPhoto;


    private String transportAddress;


    private Integer transportTypes;


   
    private String transportMudiAddress;


    
    private String transportContent;


 
    private Integer transportDelete;


  
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
  
    public Integer getrecycleYuyueId() {
        return recycleYuyueId;
    }


   
    public void setrecycleYuyueId(Integer recycleYuyueId) {
        this.recycleYuyueId = recycleYuyueId;
    }
  
    public String gettransportName() {
        return transportName;
    }


   
    public void settransportName(String transportName) {
        this.transportName = transportName;
    }
   
    public String gettransportUuidNumber() {
        return transportUuidNumber;
    }


  
    public void settransportUuidNumber(String transportUuidNumber) {
        this.transportUuidNumber = transportUuidNumber;
    }
  
    public String gettransportPhoto() {
        return transportPhoto;
    }


    
    public void settransportPhoto(String transportPhoto) {
        this.transportPhoto = transportPhoto;
    }
    
    public String gettransportAddress() {
        return transportAddress;
    }


   
    public void settransportAddress(String transportAddress) {
        this.transportAddress = transportAddress;
    }
 
    public Integer gettransportTypes() {
        return transportTypes;
    }


 
    public void settransportTypes(Integer transportTypes) {
        this.transportTypes = transportTypes;
    }
  
    public String gettransportMudiAddress() {
        return transportMudiAddress;
    }


 
    public void settransportMudiAddress(String transportMudiAddress) {
        this.transportMudiAddress = transportMudiAddress;
    }
  
    public String gettransportContent() {
        return transportContent;
    }


  
    public void settransportContent(String transportContent) {
        this.transportContent = transportContent;
    }
   
    public Integer gettransportDelete() {
        return transportDelete;
    }


   
    public void settransportDelete(Integer transportDelete) {
        this.transportDelete = transportDelete;
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

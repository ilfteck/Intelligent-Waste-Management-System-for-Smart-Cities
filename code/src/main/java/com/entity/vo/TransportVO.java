package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
*transport
* Mobile interface returns entity helper class
* (The main function is to remove some unnecessary fields)
 */
@TableName("transport")
public class TransportVO implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "id")
    private Integer id;



    @TableField(value = "recycle_reserve_id")
    private Integer recycleYuyueId;


 
    @TableField(value = "transport_name")
    private String transportName;



    @TableField(value = "transport_uuid_number")
    private String transportUuidNumber;



    @TableField(value = "transport_photo")
    private String transportPhoto;



    @TableField(value = "transport_address")
    private String transportAddress;


   

    @TableField(value = "transport_types")
    private Integer transportTypes;


  

    @TableField(value = "transport_mudi_address")
    private String transportMudiAddress;


  

    @TableField(value = "transport_content")
    private String transportContent;



    @TableField(value = "transport_delete")
    private Integer transportDelete;


   
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

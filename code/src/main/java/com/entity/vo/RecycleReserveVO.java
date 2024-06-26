package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
* recycle_reserve
* Mobile interface returns entity helper class
* (The main function is to remove some unnecessary fields)
 */
@TableName("recycle_reserve")
public class RecycleReserveVO implements Serializable {
    private static final long serialVersionUID = 1L;



    @TableField(value = "id")
    private Integer id;


    @TableField(value = "recycle_reserve_uuid_number")
    private String recycleYuyueUuidNumber;

  

    @TableField(value = "recycle_id")
    private Integer recycleId;


    @TableField(value = "member_id")
    private Integer memberId;



    @TableField(value = "recycle_reserve_text")
    private String recycleYuyueText;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "recycle_transport_time")
    private Date recycletransportTime;


    @TableField(value = "recycle_reserve_yesno_types")
    private Integer recycleYuyueYesnoTypes;



    @TableField(value = "recycle_reserve_yesno_text")
    private String recycleYuyueYesnoText;



    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "recycle_reserve_shenhe_time")
    private Date recycleYuyueShenheTime;


  
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

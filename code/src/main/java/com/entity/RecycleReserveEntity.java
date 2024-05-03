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
 * recycle_reserve
 *
 * @author 
 * @email
 */
@TableName("recycle_reserve")
public class RecycleReserveEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RecycleReserveEntity() {

	}

	public RecycleReserveEntity(T t) {
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
     * recycleYuyueUuidNumber
     */
    @ColumnInfo(comment="recycleYuyueUuidNumber",type="varchar(200)")
    @TableField(value = "recycle_reserve_uuid_number")

    private String recycleYuyueUuidNumber;


    /**
     * recycleId
     */
    @ColumnInfo(comment="recycleId",type="int(11)")
    @TableField(value = "recycle_id")

    private Integer recycleId;


    /**
     * memberId
     */
    @ColumnInfo(comment="memberId",type="int(11)")
    @TableField(value = "member_id")

    private Integer memberId;


    /**
     * recycleYuyueText
     */
    @ColumnInfo(comment="recycleYuyueText",type="longtext")
    @TableField(value = "recycle_reserve_text")

    private String recycleYuyueText;


    /**
     * recycle_transport_time
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="recycle_transport_time",type="timestamp")
    @TableField(value = "recycle_transport_time")

    private Date recycletransportTime;


    /**
     * recycleYuyueYesnoTypes
     */
    @ColumnInfo(comment="recycleYuyueYesnoTypes",type="int(11)")
    @TableField(value = "recycle_reserve_yesno_types")

    private Integer recycleYuyueYesnoTypes;


    /**
     * recycleYuyueYesnoText
     */
    @ColumnInfo(comment="recycleYuyueYesnoText",type="longtext")
    @TableField(value = "recycle_reserve_yesno_text")

    private String recycleYuyueYesnoText;


    /**
     * recycle_reserve_shenhe_time
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="recycleYuyueShenheTime",type="timestamp")
    @TableField(value = "recycle_reserve_shenhe_time")

    private Date recycleYuyueShenheTime;


    /**
     * insert_time
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="insert_time",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * create_time  listShow
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

    @Override
    public String toString() {
        return "recycleYuyue{" +
            ", id=" + id +
            ", recycleYuyueUuidNumber=" + recycleYuyueUuidNumber +
            ", recycleId=" + recycleId +
            ", memberId=" + memberId +
            ", recycleYuyueText=" + recycleYuyueText +
            ", recycletransportTime=" + DateUtil.convertString(recycletransportTime,"yyyy-MM-dd") +
            ", recycleYuyueYesnoTypes=" + recycleYuyueYesnoTypes +
            ", recycleYuyueYesnoText=" + recycleYuyueYesnoText +
            ", recycleYuyueShenheTime=" + DateUtil.convertString(recycleYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

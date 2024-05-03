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
 * transport
 *
 * @author 
 * @email
 */
@TableName("transport")
public class TransportEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TransportEntity() {

	}

	public TransportEntity(T t) {
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
     * recycleYuyueId
     */
    @ColumnInfo(comment="recycleYuyueId",type="int(11)")
    @TableField(value = "recycle_reserve_id")

    private Integer recycleYuyueId;


    /**
     * transportName
     */
    @ColumnInfo(comment="transportName",type="varchar(200)")
    @TableField(value = "transport_name")

    private String transportName;


    /**
     * transportUuidNumber
     */
    @ColumnInfo(comment="transportUuidNumber",type="varchar(200)")
    @TableField(value = "transport_uuid_number")

    private String transportUuidNumber;


    /**
     * transportPhoto
     */
    @ColumnInfo(comment="transportPhoto",type="varchar(200)")
    @TableField(value = "transport_photo")

    private String transportPhoto;


    /**
     * transportAddress
     */
    @ColumnInfo(comment="transportAddress",type="varchar(200)")
    @TableField(value = "transport_address")

    private String transportAddress;


    /**
     * transportTypes
     */
    @ColumnInfo(comment="transportTypes",type="int(11)")
    @TableField(value = "transport_types")

    private Integer transportTypes;


    /**
     * transportMudiAddress
     */
    @ColumnInfo(comment="transportMudiAddress",type="varchar(200)")
    @TableField(value = "transport_mudi_address")

    private String transportMudiAddress;


    /**
     * transportContent
     */
    @ColumnInfo(comment="transportContent",type="longtext")
    @TableField(value = "transport_content")

    private String transportContent;


    /**
     * transportDelete
     */
    @ColumnInfo(comment="transportDelete",type="int(11)")
    @TableField(value = "transport_delete")

    private Integer transportDelete;


    /**
     * insertTime
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="insertTime",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * createTime
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="createTime",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "transport{" +
            ", id=" + id +
            ", recycleYuyueId=" + recycleYuyueId +
            ", transportName=" + transportName +
            ", transportUuidNumber=" + transportUuidNumber +
            ", transportPhoto=" + transportPhoto +
            ", transportAddress=" + transportAddress +
            ", transportTypes=" + transportTypes +
            ", transportMudiAddress=" + transportMudiAddress +
            ", transportContent=" + transportContent +
            ", transportDelete=" + transportDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

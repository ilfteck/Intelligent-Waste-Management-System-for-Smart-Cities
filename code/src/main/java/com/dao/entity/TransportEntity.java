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
 * 运输
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
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 垃圾运输
     */
    @ColumnInfo(comment="垃圾运输",type="int(11)")
    @TableField(value = "recycle_reserve_id")

    private Integer recycleYuyueId;


    /**
     * 运输名称
     */
    @ColumnInfo(comment="运输名称",type="varchar(200)")
    @TableField(value = "transport_name")

    private String transportName;


    /**
     * 运输编号
     */
    @ColumnInfo(comment="运输编号",type="varchar(200)")
    @TableField(value = "transport_uuid_number")

    private String transportUuidNumber;


    /**
     * 运输照片
     */
    @ColumnInfo(comment="运输照片",type="varchar(200)")
    @TableField(value = "transport_photo")

    private String transportPhoto;


    /**
     * 运输地点
     */
    @ColumnInfo(comment="运输地点",type="varchar(200)")
    @TableField(value = "transport_address")

    private String transportAddress;


    /**
     * 运输类型
     */
    @ColumnInfo(comment="运输类型",type="int(11)")
    @TableField(value = "transport_types")

    private Integer transportTypes;


    /**
     * 运输目的地
     */
    @ColumnInfo(comment="运输目的地",type="varchar(200)")
    @TableField(value = "transport_mudi_address")

    private String transportMudiAddress;


    /**
     * 运输介绍
     */
    @ColumnInfo(comment="运输介绍",type="longtext")
    @TableField(value = "transport_content")

    private String transportContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "transport_delete")

    private Integer transportDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：垃圾运输
	 */
    public Integer getrecycleYuyueId() {
        return recycleYuyueId;
    }
    /**
	 * 设置：垃圾运输
	 */

    public void setrecycleYuyueId(Integer recycleYuyueId) {
        this.recycleYuyueId = recycleYuyueId;
    }
    /**
	 * 获取：运输名称
	 */
    public String gettransportName() {
        return transportName;
    }
    /**
	 * 设置：运输名称
	 */

    public void settransportName(String transportName) {
        this.transportName = transportName;
    }
    /**
	 * 获取：运输编号
	 */
    public String gettransportUuidNumber() {
        return transportUuidNumber;
    }
    /**
	 * 设置：运输编号
	 */

    public void settransportUuidNumber(String transportUuidNumber) {
        this.transportUuidNumber = transportUuidNumber;
    }
    /**
	 * 获取：运输照片
	 */
    public String gettransportPhoto() {
        return transportPhoto;
    }
    /**
	 * 设置：运输照片
	 */

    public void settransportPhoto(String transportPhoto) {
        this.transportPhoto = transportPhoto;
    }
    /**
	 * 获取：运输地点
	 */
    public String gettransportAddress() {
        return transportAddress;
    }
    /**
	 * 设置：运输地点
	 */

    public void settransportAddress(String transportAddress) {
        this.transportAddress = transportAddress;
    }
    /**
	 * 获取：运输类型
	 */
    public Integer gettransportTypes() {
        return transportTypes;
    }
    /**
	 * 设置：运输类型
	 */

    public void settransportTypes(Integer transportTypes) {
        this.transportTypes = transportTypes;
    }
    /**
	 * 获取：运输目的地
	 */
    public String gettransportMudiAddress() {
        return transportMudiAddress;
    }
    /**
	 * 设置：运输目的地
	 */

    public void settransportMudiAddress(String transportMudiAddress) {
        this.transportMudiAddress = transportMudiAddress;
    }
    /**
	 * 获取：运输介绍
	 */
    public String gettransportContent() {
        return transportContent;
    }
    /**
	 * 设置：运输介绍
	 */

    public void settransportContent(String transportContent) {
        this.transportContent = transportContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer gettransportDelete() {
        return transportDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void settransportDelete(Integer transportDelete) {
        this.transportDelete = transportDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

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

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
 * 垃圾回收
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
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 垃圾回收名称
     */
    @ColumnInfo(comment="垃圾回收名称",type="varchar(200)")
    @TableField(value = "recycle_name")

    private String recycleName;


    /**
     * 垃圾回收编号
     */
    @ColumnInfo(comment="垃圾回收编号",type="varchar(200)")
    @TableField(value = "recycle_uuid_number")

    private String recycleUuidNumber;


    /**
     * 垃圾回收照片
     */
    @ColumnInfo(comment="垃圾回收照片",type="varchar(200)")
    @TableField(value = "recycle_photo")

    private String recyclePhoto;


    /**
     * 垃圾回收地点
     */
    @ColumnInfo(comment="垃圾回收地点",type="varchar(200)")
    @TableField(value = "recycle_address")

    private String recycleAddress;


    /**
     * 垃圾回收类型
     */
    @ColumnInfo(comment="垃圾回收类型",type="int(11)")
    @TableField(value = "recycle_types")

    private Integer recycleTypes;


    /**
     * 垃圾回收库存
     */
    @ColumnInfo(comment="垃圾回收库存",type="int(11)")
    @TableField(value = "recycle_kucun_number")

    private Integer recycleKucunNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="入库时间",type="timestamp")
    @TableField(value = "recycle_time")

    private Date recycleTime;


    /**
     * 垃圾回收介绍
     */
    @ColumnInfo(comment="垃圾回收介绍",type="longtext")
    @TableField(value = "recycle_content")

    private String recycleContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "recycle_delete")

    private Integer recycleDelete;


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
	 * 获取：垃圾回收名称
	 */
    public String getrecycleName() {
        return recycleName;
    }
    /**
	 * 设置：垃圾回收名称
	 */

    public void setrecycleName(String recycleName) {
        this.recycleName = recycleName;
    }
    /**
	 * 获取：垃圾回收编号
	 */
    public String getrecycleUuidNumber() {
        return recycleUuidNumber;
    }
    /**
	 * 设置：垃圾回收编号
	 */

    public void setrecycleUuidNumber(String recycleUuidNumber) {
        this.recycleUuidNumber = recycleUuidNumber;
    }
    /**
	 * 获取：垃圾回收照片
	 */
    public String getrecyclePhoto() {
        return recyclePhoto;
    }
    /**
	 * 设置：垃圾回收照片
	 */

    public void setrecyclePhoto(String recyclePhoto) {
        this.recyclePhoto = recyclePhoto;
    }
    /**
	 * 获取：垃圾回收地点
	 */
    public String getrecycleAddress() {
        return recycleAddress;
    }
    /**
	 * 设置：垃圾回收地点
	 */

    public void setrecycleAddress(String recycleAddress) {
        this.recycleAddress = recycleAddress;
    }
    /**
	 * 获取：垃圾回收类型
	 */
    public Integer getrecycleTypes() {
        return recycleTypes;
    }
    /**
	 * 设置：垃圾回收类型
	 */

    public void setrecycleTypes(Integer recycleTypes) {
        this.recycleTypes = recycleTypes;
    }
    /**
	 * 获取：垃圾回收库存
	 */
    public Integer getrecycleKucunNumber() {
        return recycleKucunNumber;
    }
    /**
	 * 设置：垃圾回收库存
	 */

    public void setrecycleKucunNumber(Integer recycleKucunNumber) {
        this.recycleKucunNumber = recycleKucunNumber;
    }
    /**
	 * 获取：入库时间
	 */
    public Date getrecycleTime() {
        return recycleTime;
    }
    /**
	 * 设置：入库时间
	 */

    public void setrecycleTime(Date recycleTime) {
        this.recycleTime = recycleTime;
    }
    /**
	 * 获取：垃圾回收介绍
	 */
    public String getrecycleContent() {
        return recycleContent;
    }
    /**
	 * 设置：垃圾回收介绍
	 */

    public void setrecycleContent(String recycleContent) {
        this.recycleContent = recycleContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getrecycleDelete() {
        return recycleDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setrecycleDelete(Integer recycleDelete) {
        this.recycleDelete = recycleDelete;
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

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
 * 公告
 *
 * @author 
 * @email
 */
@TableName("announcement")
public class AnnouncementEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public AnnouncementEntity() {

	}

	public AnnouncementEntity(T t) {
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
     * 公告名称
     */
    @ColumnInfo(comment="公告名称",type="varchar(200)")
    @TableField(value = "announcement_name")

    private String announcementName;


    /**
     * 公告图片
     */
    @ColumnInfo(comment="公告图片",type="varchar(200)")
    @TableField(value = "announcement_photo")

    private String announcementPhoto;


    /**
     * 公告类型
     */
    @ColumnInfo(comment="公告类型",type="int(11)")
    @TableField(value = "announcement_types")

    private Integer announcementTypes;


    /**
     * 公告发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="公告发布时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 公告详情
     */
    @ColumnInfo(comment="公告详情",type="longtext")
    @TableField(value = "announcement_content")

    private String announcementContent;


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
	 * 获取：公告名称
	 */
    public String getannouncementName() {
        return announcementName;
    }
    /**
	 * 设置：公告名称
	 */

    public void setannouncementName(String announcementName) {
        this.announcementName = announcementName;
    }
    /**
	 * 获取：公告图片
	 */
    public String getannouncementPhoto() {
        return announcementPhoto;
    }
    /**
	 * 设置：公告图片
	 */

    public void setannouncementPhoto(String announcementPhoto) {
        this.announcementPhoto = announcementPhoto;
    }
    /**
	 * 获取：公告类型
	 */
    public Integer getannouncementTypes() {
        return announcementTypes;
    }
    /**
	 * 设置：公告类型
	 */

    public void setannouncementTypes(Integer announcementTypes) {
        this.announcementTypes = announcementTypes;
    }
    /**
	 * 获取：公告发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：公告发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：公告详情
	 */
    public String getannouncementContent() {
        return announcementContent;
    }
    /**
	 * 设置：公告详情
	 */

    public void setannouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
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
        return "announcement{" +
            ", id=" + id +
            ", announcementName=" + announcementName +
            ", announcementPhoto=" + announcementPhoto +
            ", announcementTypes=" + announcementTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", announcementContent=" + announcementContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

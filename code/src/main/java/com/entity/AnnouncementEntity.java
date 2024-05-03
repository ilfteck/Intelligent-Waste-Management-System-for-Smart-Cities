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
 * announcement
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
     * ID
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="id",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * announcement_name
     */
    @ColumnInfo(comment="announcement_name",type="varchar(200)")
    @TableField(value = "announcement_name")

    private String announcementName;


    /**
     * announcement_photo
     */
    @ColumnInfo(comment="announcement_photo",type="varchar(200)")
    @TableField(value = "announcement_photo")

    private String announcementPhoto;


    /**
     * announcement_types
     */
    @ColumnInfo(comment="announcement_types",type="int(11)")
    @TableField(value = "announcement_types")

    private Integer announcementTypes;


    /**
     * insert_time
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="insert_time",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * announcement_content
     */
    @ColumnInfo(comment="announcement_content",type="longtext")
    @TableField(value = "announcement_content")

    private String announcementContent;


    /**
     * create_time
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
 
    public String getannouncementName() {
        return announcementName;
    }


    public void setannouncementName(String announcementName) {
        this.announcementName = announcementName;
    }
  
    public String getannouncementPhoto() {
        return announcementPhoto;
    }
  

    public void setannouncementPhoto(String announcementPhoto) {
        this.announcementPhoto = announcementPhoto;
    }

    public Integer getannouncementTypes() {
        return announcementTypes;
    }
 

    public void setannouncementTypes(Integer announcementTypes) {
        this.announcementTypes = announcementTypes;
    }

    public Date getInsertTime() {
        return insertTime;
    }


    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
 
    public String getannouncementContent() {
        return announcementContent;
    }


    public void setannouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }
 
    public Date getCreateTime() {
        return createTime;
    }
 

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

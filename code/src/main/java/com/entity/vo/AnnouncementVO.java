package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
* Announcement
* Mobile interface returns entity helper class
* (The main function is to remove some unnecessary fields)
 */
@TableName("announcement")
public class AnnouncementVO implements Serializable {
    private static final long serialVersionUID = 1L;



    @TableField(value = "id")
    private Integer id;



    @TableField(value = "announcement_name")
    private String announcementName;


   

    @TableField(value = "announcement_photo")
    private String announcementPhoto;


  

    @TableField(value = "announcement_types")
    private Integer announcementTypes;


  
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;



    @TableField(value = "announcement_content")
    private String announcementContent;



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

}

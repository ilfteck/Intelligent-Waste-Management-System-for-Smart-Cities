package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * announcement
 * The entity class that receives the argument
 *(In the actual development, with the mobile interface development, manually remove some useless fields, and the backend is generally enough to use entity)
 * model name from ModelAndView
 */
public class AnnouncementModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * Major key
     */
    private Integer id;


    /**
     * Announcement name
     */
    private String announcementName;


    /**
     * Announcement picture
     */
    private String announcementPhoto;


    /**
     * Announcement type
     */
    private Integer announcementTypes;


    /**
     * Announcement time
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * Announcement details
     */
    private String announcementContent;


    /**
     *Creation time show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * Get: Primary key
	 */
    public Integer getId() {
        return id;
    }


    /**
	 *set: Primary key
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * Get: Bulletin name
	 */
    public String getannouncementName() {
        return announcementName;
    }


    /**
	 * Setting: Bulletin name
	 */
    public void setannouncementName(String announcementName) {
        this.announcementName = announcementName;
    }
    /**
	 * Get: Announcement picture
	 */
    public String getannouncementPhoto() {
        return announcementPhoto;
    }


    /**
	 * Settings: Announcement picture
	 */
    public void setannouncementPhoto(String announcementPhoto) {
        this.announcementPhoto = announcementPhoto;
    }
    /**
	 *Settings: Announcement picture
	 */
    public Integer getannouncementTypes() {
        return announcementTypes;
    }


    /**
	 * Setting: Bulletin type
	 */
    public void setannouncementTypes(Integer announcementTypes) {
        this.announcementTypes = announcementTypes;
    }
    /**
	 * Obtain: Bulletin release time
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * Setting: Bulletin release time
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 *Setting: Bulletin release time
	 */
    public String getannouncementContent() {
        return announcementContent;
    }


    /**
	 * Setting: Bulletin release time
	 */
    public void setannouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }
    /**
	 * Setting: Bulletin release time
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * Setting: Creation time show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

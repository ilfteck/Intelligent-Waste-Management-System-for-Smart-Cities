package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 公告
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class AnnouncementModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 公告名称
     */
    private String announcementName;


    /**
     * 公告图片
     */
    private String announcementPhoto;


    /**
     * 公告类型
     */
    private Integer announcementTypes;


    /**
     * 公告发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 公告详情
     */
    private String announcementContent;


    /**
     * 创建时间 show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 公告
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("announcement")
public class AnnouncementVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 公告名称
     */

    @TableField(value = "announcement_name")
    private String announcementName;


    /**
     * 公告图片
     */

    @TableField(value = "announcement_photo")
    private String announcementPhoto;


    /**
     * 公告类型
     */

    @TableField(value = "announcement_types")
    private Integer announcementTypes;


    /**
     * 公告发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 公告详情
     */

    @TableField(value = "announcement_content")
    private String announcementContent;


    /**
     * 创建时间 show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：公告名称
	 */
    public String getannouncementName() {
        return announcementName;
    }


    /**
	 * 获取：公告名称
	 */

    public void setannouncementName(String announcementName) {
        this.announcementName = announcementName;
    }
    /**
	 * 设置：公告图片
	 */
    public String getannouncementPhoto() {
        return announcementPhoto;
    }


    /**
	 * 获取：公告图片
	 */

    public void setannouncementPhoto(String announcementPhoto) {
        this.announcementPhoto = announcementPhoto;
    }
    /**
	 * 设置：公告类型
	 */
    public Integer getannouncementTypes() {
        return announcementTypes;
    }


    /**
	 * 获取：公告类型
	 */

    public void setannouncementTypes(Integer announcementTypes) {
        this.announcementTypes = announcementTypes;
    }
    /**
	 * 设置：公告发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：公告发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：公告详情
	 */
    public String getannouncementContent() {
        return announcementContent;
    }


    /**
	 * 获取：公告详情
	 */

    public void setannouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }
    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

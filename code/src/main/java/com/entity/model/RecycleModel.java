package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 垃圾回收
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RecycleModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 垃圾回收名称
     */
    private String recycleName;


    /**
     * 垃圾回收编号
     */
    private String recycleUuidNumber;


    /**
     * 垃圾回收照片
     */
    private String recyclePhoto;


    /**
     * 垃圾回收地点
     */
    private String recycleAddress;


    /**
     * 垃圾回收类型
     */
    private Integer recycleTypes;


    /**
     * 垃圾回收库存
     */
    private Integer recycleKucunNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date recycleTime;


    /**
     * 垃圾回收介绍
     */
    private String recycleContent;


    /**
     * 逻辑删除
     */
    private Integer recycleDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

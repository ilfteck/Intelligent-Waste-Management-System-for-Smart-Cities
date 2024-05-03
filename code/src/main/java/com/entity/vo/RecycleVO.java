package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 垃圾回收
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("recycle")
public class RecycleVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 垃圾回收名称
     */

    @TableField(value = "recycle_name")
    private String recycleName;


    /**
     * 垃圾回收编号
     */

    @TableField(value = "recycle_uuid_number")
    private String recycleUuidNumber;


    /**
     * 垃圾回收照片
     */

    @TableField(value = "recycle_photo")
    private String recyclePhoto;


    /**
     * 垃圾回收地点
     */

    @TableField(value = "recycle_address")
    private String recycleAddress;


    /**
     * 垃圾回收类型
     */

    @TableField(value = "recycle_types")
    private Integer recycleTypes;


    /**
     * 垃圾回收库存
     */

    @TableField(value = "recycle_kucun_number")
    private Integer recycleKucunNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "recycle_time")
    private Date recycleTime;


    /**
     * 垃圾回收介绍
     */

    @TableField(value = "recycle_content")
    private String recycleContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "recycle_delete")
    private Integer recycleDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：垃圾回收名称
	 */
    public String getrecycleName() {
        return recycleName;
    }


    /**
	 * 获取：垃圾回收名称
	 */

    public void setrecycleName(String recycleName) {
        this.recycleName = recycleName;
    }
    /**
	 * 设置：垃圾回收编号
	 */
    public String getrecycleUuidNumber() {
        return recycleUuidNumber;
    }


    /**
	 * 获取：垃圾回收编号
	 */

    public void setrecycleUuidNumber(String recycleUuidNumber) {
        this.recycleUuidNumber = recycleUuidNumber;
    }
    /**
	 * 设置：垃圾回收照片
	 */
    public String getrecyclePhoto() {
        return recyclePhoto;
    }


    /**
	 * 获取：垃圾回收照片
	 */

    public void setrecyclePhoto(String recyclePhoto) {
        this.recyclePhoto = recyclePhoto;
    }
    /**
	 * 设置：垃圾回收地点
	 */
    public String getrecycleAddress() {
        return recycleAddress;
    }


    /**
	 * 获取：垃圾回收地点
	 */

    public void setrecycleAddress(String recycleAddress) {
        this.recycleAddress = recycleAddress;
    }
    /**
	 * 设置：垃圾回收类型
	 */
    public Integer getrecycleTypes() {
        return recycleTypes;
    }


    /**
	 * 获取：垃圾回收类型
	 */

    public void setrecycleTypes(Integer recycleTypes) {
        this.recycleTypes = recycleTypes;
    }
    /**
	 * 设置：垃圾回收库存
	 */
    public Integer getrecycleKucunNumber() {
        return recycleKucunNumber;
    }


    /**
	 * 获取：垃圾回收库存
	 */

    public void setrecycleKucunNumber(Integer recycleKucunNumber) {
        this.recycleKucunNumber = recycleKucunNumber;
    }
    /**
	 * 设置：入库时间
	 */
    public Date getrecycleTime() {
        return recycleTime;
    }


    /**
	 * 获取：入库时间
	 */

    public void setrecycleTime(Date recycleTime) {
        this.recycleTime = recycleTime;
    }
    /**
	 * 设置：垃圾回收介绍
	 */
    public String getrecycleContent() {
        return recycleContent;
    }


    /**
	 * 获取：垃圾回收介绍
	 */

    public void setrecycleContent(String recycleContent) {
        this.recycleContent = recycleContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getrecycleDelete() {
        return recycleDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setrecycleDelete(Integer recycleDelete) {
        this.recycleDelete = recycleDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

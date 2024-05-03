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
 * 垃圾出库申请
 *
 * @author 
 * @email
 */
@TableName("recycle_reserve")
public class RecycleReserveEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RecycleReserveEntity() {

	}

	public RecycleReserveEntity(T t) {
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
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "recycle_reserve_uuid_number")

    private String recycleYuyueUuidNumber;


    /**
     * 垃圾回收
     */
    @ColumnInfo(comment="垃圾回收",type="int(11)")
    @TableField(value = "recycle_id")

    private Integer recycleId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "member_id")

    private Integer memberId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "recycle_reserve_text")

    private String recycleYuyueText;


    /**
     * 出库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="出库时间",type="timestamp")
    @TableField(value = "recycle_transport_time")

    private Date recycletransportTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "recycle_reserve_yesno_types")

    private Integer recycleYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "recycle_reserve_yesno_text")

    private String recycleYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "recycle_reserve_shenhe_time")

    private Date recycleYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="活动报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：报名编号
	 */
    public String getrecycleYuyueUuidNumber() {
        return recycleYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setrecycleYuyueUuidNumber(String recycleYuyueUuidNumber) {
        this.recycleYuyueUuidNumber = recycleYuyueUuidNumber;
    }
    /**
	 * 获取：垃圾回收
	 */
    public Integer getrecycleId() {
        return recycleId;
    }
    /**
	 * 设置：垃圾回收
	 */

    public void setrecycleId(Integer recycleId) {
        this.recycleId = recycleId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getmemberId() {
        return memberId;
    }
    /**
	 * 设置：用户
	 */

    public void setmemberId(Integer memberId) {
        this.memberId = memberId;
    }
    /**
	 * 获取：报名理由
	 */
    public String getrecycleYuyueText() {
        return recycleYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setrecycleYuyueText(String recycleYuyueText) {
        this.recycleYuyueText = recycleYuyueText;
    }
    /**
	 * 获取：出库时间
	 */
    public Date getrecycletransportTime() {
        return recycletransportTime;
    }
    /**
	 * 设置：出库时间
	 */

    public void setrecycletransportTime(Date recycletransportTime) {
        this.recycletransportTime = recycletransportTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getrecycleYuyueYesnoTypes() {
        return recycleYuyueYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setrecycleYuyueYesnoTypes(Integer recycleYuyueYesnoTypes) {
        this.recycleYuyueYesnoTypes = recycleYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getrecycleYuyueYesnoText() {
        return recycleYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setrecycleYuyueYesnoText(String recycleYuyueYesnoText) {
        this.recycleYuyueYesnoText = recycleYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getrecycleYuyueShenheTime() {
        return recycleYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setrecycleYuyueShenheTime(Date recycleYuyueShenheTime) {
        this.recycleYuyueShenheTime = recycleYuyueShenheTime;
    }
    /**
	 * 获取：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "recycleYuyue{" +
            ", id=" + id +
            ", recycleYuyueUuidNumber=" + recycleYuyueUuidNumber +
            ", recycleId=" + recycleId +
            ", memberId=" + memberId +
            ", recycleYuyueText=" + recycleYuyueText +
            ", recycletransportTime=" + DateUtil.convertString(recycletransportTime,"yyyy-MM-dd") +
            ", recycleYuyueYesnoTypes=" + recycleYuyueYesnoTypes +
            ", recycleYuyueYesnoText=" + recycleYuyueYesnoText +
            ", recycleYuyueShenheTime=" + DateUtil.convertString(recycleYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
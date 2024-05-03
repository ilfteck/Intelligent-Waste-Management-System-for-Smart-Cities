package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 垃圾出库申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("recycle_reserve")
public class RecycleReserveVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "recycle_reserve_uuid_number")
    private String recycleYuyueUuidNumber;


    /**
     * 垃圾回收
     */

    @TableField(value = "recycle_id")
    private Integer recycleId;


    /**
     * 用户
     */

    @TableField(value = "member_id")
    private Integer memberId;


    /**
     * 报名理由
     */

    @TableField(value = "recycle_reserve_text")
    private String recycleYuyueText;


    /**
     * 出库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "recycle_transport_time")
    private Date recycletransportTime;


    /**
     * 申请状态
     */

    @TableField(value = "recycle_reserve_yesno_types")
    private Integer recycleYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "recycle_reserve_yesno_text")
    private String recycleYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "recycle_reserve_shenhe_time")
    private Date recycleYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：报名编号
	 */
    public String getrecycleYuyueUuidNumber() {
        return recycleYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setrecycleYuyueUuidNumber(String recycleYuyueUuidNumber) {
        this.recycleYuyueUuidNumber = recycleYuyueUuidNumber;
    }
    /**
	 * 设置：垃圾回收
	 */
    public Integer getrecycleId() {
        return recycleId;
    }


    /**
	 * 获取：垃圾回收
	 */

    public void setrecycleId(Integer recycleId) {
        this.recycleId = recycleId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getmemberId() {
        return memberId;
    }


    /**
	 * 获取：用户
	 */

    public void setmemberId(Integer memberId) {
        this.memberId = memberId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getrecycleYuyueText() {
        return recycleYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setrecycleYuyueText(String recycleYuyueText) {
        this.recycleYuyueText = recycleYuyueText;
    }
    /**
	 * 设置：出库时间
	 */
    public Date getrecycletransportTime() {
        return recycletransportTime;
    }


    /**
	 * 获取：出库时间
	 */

    public void setrecycletransportTime(Date recycletransportTime) {
        this.recycletransportTime = recycletransportTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getrecycleYuyueYesnoTypes() {
        return recycleYuyueYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setrecycleYuyueYesnoTypes(Integer recycleYuyueYesnoTypes) {
        this.recycleYuyueYesnoTypes = recycleYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getrecycleYuyueYesnoText() {
        return recycleYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setrecycleYuyueYesnoText(String recycleYuyueYesnoText) {
        this.recycleYuyueYesnoText = recycleYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getrecycleYuyueShenheTime() {
        return recycleYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setrecycleYuyueShenheTime(Date recycleYuyueShenheTime) {
        this.recycleYuyueShenheTime = recycleYuyueShenheTime;
    }
    /**
	 * 设置：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

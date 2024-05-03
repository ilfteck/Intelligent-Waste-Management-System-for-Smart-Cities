package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 垃圾出库申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RecycleReserveModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String recycleYuyueUuidNumber;


    /**
     * 垃圾回收
     */
    private Integer recycleId;


    /**
     * 用户
     */
    private Integer memberId;


    /**
     * 报名理由
     */
    private String recycleYuyueText;


    /**
     * 出库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date recycletransportTime;


    /**
     * 申请状态
     */
    private Integer recycleYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String recycleYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date recycleYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

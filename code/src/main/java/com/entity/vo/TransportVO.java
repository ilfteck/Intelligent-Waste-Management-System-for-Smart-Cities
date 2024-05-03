package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 运输
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("transport")
public class TransportVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 垃圾运输
     */

    @TableField(value = "recycle_reserve_id")
    private Integer recycleYuyueId;


    /**
     * 运输名称
     */

    @TableField(value = "transport_name")
    private String transportName;


    /**
     * 运输编号
     */

    @TableField(value = "transport_uuid_number")
    private String transportUuidNumber;


    /**
     * 运输照片
     */

    @TableField(value = "transport_photo")
    private String transportPhoto;


    /**
     * 运输地点
     */

    @TableField(value = "transport_address")
    private String transportAddress;


    /**
     * 运输类型
     */

    @TableField(value = "transport_types")
    private Integer transportTypes;


    /**
     * 运输目的地
     */

    @TableField(value = "transport_mudi_address")
    private String transportMudiAddress;


    /**
     * 运输介绍
     */

    @TableField(value = "transport_content")
    private String transportContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "transport_delete")
    private Integer transportDelete;


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
	 * 设置：垃圾运输
	 */
    public Integer getrecycleYuyueId() {
        return recycleYuyueId;
    }


    /**
	 * 获取：垃圾运输
	 */

    public void setrecycleYuyueId(Integer recycleYuyueId) {
        this.recycleYuyueId = recycleYuyueId;
    }
    /**
	 * 设置：运输名称
	 */
    public String gettransportName() {
        return transportName;
    }


    /**
	 * 获取：运输名称
	 */

    public void settransportName(String transportName) {
        this.transportName = transportName;
    }
    /**
	 * 设置：运输编号
	 */
    public String gettransportUuidNumber() {
        return transportUuidNumber;
    }


    /**
	 * 获取：运输编号
	 */

    public void settransportUuidNumber(String transportUuidNumber) {
        this.transportUuidNumber = transportUuidNumber;
    }
    /**
	 * 设置：运输照片
	 */
    public String gettransportPhoto() {
        return transportPhoto;
    }


    /**
	 * 获取：运输照片
	 */

    public void settransportPhoto(String transportPhoto) {
        this.transportPhoto = transportPhoto;
    }
    /**
	 * 设置：运输地点
	 */
    public String gettransportAddress() {
        return transportAddress;
    }


    /**
	 * 获取：运输地点
	 */

    public void settransportAddress(String transportAddress) {
        this.transportAddress = transportAddress;
    }
    /**
	 * 设置：运输类型
	 */
    public Integer gettransportTypes() {
        return transportTypes;
    }


    /**
	 * 获取：运输类型
	 */

    public void settransportTypes(Integer transportTypes) {
        this.transportTypes = transportTypes;
    }
    /**
	 * 设置：运输目的地
	 */
    public String gettransportMudiAddress() {
        return transportMudiAddress;
    }


    /**
	 * 获取：运输目的地
	 */

    public void settransportMudiAddress(String transportMudiAddress) {
        this.transportMudiAddress = transportMudiAddress;
    }
    /**
	 * 设置：运输介绍
	 */
    public String gettransportContent() {
        return transportContent;
    }


    /**
	 * 获取：运输介绍
	 */

    public void settransportContent(String transportContent) {
        this.transportContent = transportContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer gettransportDelete() {
        return transportDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void settransportDelete(Integer transportDelete) {
        this.transportDelete = transportDelete;
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

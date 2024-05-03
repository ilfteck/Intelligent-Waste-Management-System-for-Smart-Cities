package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 运输
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TransportModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 垃圾运输
     */
    private Integer recycleYuyueId;


    /**
     * 运输名称
     */
    private String transportName;


    /**
     * 运输编号
     */
    private String transportUuidNumber;


    /**
     * 运输照片
     */
    private String transportPhoto;


    /**
     * 运输地点
     */
    private String transportAddress;


    /**
     * 运输类型
     */
    private Integer transportTypes;


    /**
     * 运输目的地
     */
    private String transportMudiAddress;


    /**
     * 运输介绍
     */
    private String transportContent;


    /**
     * 逻辑删除
     */
    private Integer transportDelete;


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
	 * 获取：垃圾运输
	 */
    public Integer getrecycleYuyueId() {
        return recycleYuyueId;
    }


    /**
	 * 设置：垃圾运输
	 */
    public void setrecycleYuyueId(Integer recycleYuyueId) {
        this.recycleYuyueId = recycleYuyueId;
    }
    /**
	 * 获取：运输名称
	 */
    public String gettransportName() {
        return transportName;
    }


    /**
	 * 设置：运输名称
	 */
    public void settransportName(String transportName) {
        this.transportName = transportName;
    }
    /**
	 * 获取：运输编号
	 */
    public String gettransportUuidNumber() {
        return transportUuidNumber;
    }


    /**
	 * 设置：运输编号
	 */
    public void settransportUuidNumber(String transportUuidNumber) {
        this.transportUuidNumber = transportUuidNumber;
    }
    /**
	 * 获取：运输照片
	 */
    public String gettransportPhoto() {
        return transportPhoto;
    }


    /**
	 * 设置：运输照片
	 */
    public void settransportPhoto(String transportPhoto) {
        this.transportPhoto = transportPhoto;
    }
    /**
	 * 获取：运输地点
	 */
    public String gettransportAddress() {
        return transportAddress;
    }


    /**
	 * 设置：运输地点
	 */
    public void settransportAddress(String transportAddress) {
        this.transportAddress = transportAddress;
    }
    /**
	 * 获取：运输类型
	 */
    public Integer gettransportTypes() {
        return transportTypes;
    }


    /**
	 * 设置：运输类型
	 */
    public void settransportTypes(Integer transportTypes) {
        this.transportTypes = transportTypes;
    }
    /**
	 * 获取：运输目的地
	 */
    public String gettransportMudiAddress() {
        return transportMudiAddress;
    }


    /**
	 * 设置：运输目的地
	 */
    public void settransportMudiAddress(String transportMudiAddress) {
        this.transportMudiAddress = transportMudiAddress;
    }
    /**
	 * 获取：运输介绍
	 */
    public String gettransportContent() {
        return transportContent;
    }


    /**
	 * 设置：运输介绍
	 */
    public void settransportContent(String transportContent) {
        this.transportContent = transportContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer gettransportDelete() {
        return transportDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void settransportDelete(Integer transportDelete) {
        this.transportDelete = transportDelete;
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

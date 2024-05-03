package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 用户
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MemberModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 用户姓名
     */
    private String memberName;


    /**
     * 用户手机号
     */
    private String memberPhone;


    /**
     * 用户身份证号
     */
    private String memberIdNumber;


    /**
     * 用户头像
     */
    private String memberPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 用户邮箱
     */
    private String memberEmail;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：用户姓名
	 */
    public String getmemberName() {
        return memberName;
    }


    /**
	 * 设置：用户姓名
	 */
    public void setmemberName(String memberName) {
        this.memberName = memberName;
    }
    /**
	 * 获取：用户手机号
	 */
    public String getmemberPhone() {
        return memberPhone;
    }


    /**
	 * 设置：用户手机号
	 */
    public void setmemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }
    /**
	 * 获取：用户身份证号
	 */
    public String getmemberIdNumber() {
        return memberIdNumber;
    }


    /**
	 * 设置：用户身份证号
	 */
    public void setmemberIdNumber(String memberIdNumber) {
        this.memberIdNumber = memberIdNumber;
    }
    /**
	 * 获取：用户头像
	 */
    public String getmemberPhoto() {
        return memberPhoto;
    }


    /**
	 * 设置：用户头像
	 */
    public void setmemberPhoto(String memberPhoto) {
        this.memberPhoto = memberPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：用户邮箱
	 */
    public String getmemberEmail() {
        return memberEmail;
    }


    /**
	 * 设置：用户邮箱
	 */
    public void setmemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

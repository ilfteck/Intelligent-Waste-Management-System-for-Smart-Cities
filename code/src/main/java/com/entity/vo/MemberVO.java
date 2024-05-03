package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 用户
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("member")
public class MemberVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 用户姓名
     */

    @TableField(value = "member_name")
    private String memberName;


    /**
     * 用户手机号
     */

    @TableField(value = "member_phone")
    private String memberPhone;


    /**
     * 用户身份证号
     */

    @TableField(value = "member_id_number")
    private String memberIdNumber;


    /**
     * 用户头像
     */

    @TableField(value = "member_photo")
    private String memberPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 用户邮箱
     */

    @TableField(value = "member_email")
    private String memberEmail;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：用户姓名
	 */
    public String getmemberName() {
        return memberName;
    }


    /**
	 * 获取：用户姓名
	 */

    public void setmemberName(String memberName) {
        this.memberName = memberName;
    }
    /**
	 * 设置：用户手机号
	 */
    public String getmemberPhone() {
        return memberPhone;
    }


    /**
	 * 获取：用户手机号
	 */

    public void setmemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }
    /**
	 * 设置：用户身份证号
	 */
    public String getmemberIdNumber() {
        return memberIdNumber;
    }


    /**
	 * 获取：用户身份证号
	 */

    public void setmemberIdNumber(String memberIdNumber) {
        this.memberIdNumber = memberIdNumber;
    }
    /**
	 * 设置：用户头像
	 */
    public String getmemberPhoto() {
        return memberPhoto;
    }


    /**
	 * 获取：用户头像
	 */

    public void setmemberPhoto(String memberPhoto) {
        this.memberPhoto = memberPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：用户邮箱
	 */
    public String getmemberEmail() {
        return memberEmail;
    }


    /**
	 * 获取：用户邮箱
	 */

    public void setmemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
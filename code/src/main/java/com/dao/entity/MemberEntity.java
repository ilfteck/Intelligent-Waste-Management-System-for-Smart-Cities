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
 * 用户
 *
 * @author 
 * @email
 */
@TableName("member")
public class MemberEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MemberEntity() {

	}

	public MemberEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 用户姓名
     */
    @ColumnInfo(comment="用户姓名",type="varchar(200)")
    @TableField(value = "member_name")

    private String memberName;


    /**
     * 用户手机号
     */
    @ColumnInfo(comment="用户手机号",type="varchar(200)")
    @TableField(value = "member_phone")

    private String memberPhone;


    /**
     * 用户身份证号
     */
    @ColumnInfo(comment="用户身份证号",type="varchar(200)")
    @TableField(value = "member_id_number")

    private String memberIdNumber;


    /**
     * 用户头像
     */
    @ColumnInfo(comment="用户头像",type="varchar(200)")
    @TableField(value = "member_photo")

    private String memberPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 用户邮箱
     */
    @ColumnInfo(comment="用户邮箱",type="varchar(200)")
    @TableField(value = "member_email")

    private String memberEmail;


    /**
     * 创建时间
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

    @Override
    public String toString() {
        return "member{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", memberName=" + memberName +
            ", memberPhone=" + memberPhone +
            ", memberIdNumber=" + memberIdNumber +
            ", memberPhoto=" + memberPhoto +
            ", sexTypes=" + sexTypes +
            ", memberEmail=" + memberEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

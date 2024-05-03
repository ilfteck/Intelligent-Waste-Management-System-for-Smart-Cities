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
 * member
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
     * id
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="id",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * username
     */
    @ColumnInfo(comment="username",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * password
     */
    @ColumnInfo(comment="password",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * member_name
     */
    @ColumnInfo(comment="member_name",type="varchar(200)")
    @TableField(value = "member_name")

    private String memberName;


    /**
     * member_phone
     */
    @ColumnInfo(comment="member_phone",type="varchar(200)")
    @TableField(value = "member_phone")

    private String memberPhone;


    /**
     * member_id_number
     */
    @ColumnInfo(comment="member_id_number",type="varchar(200)")
    @TableField(value = "member_id_number")

    private String memberIdNumber;


    /**
     * member_photo
     */
    @ColumnInfo(comment="member_photo",type="varchar(200)")
    @TableField(value = "member_photo")

    private String memberPhoto;


    /**
     * sex_types
     */
    @ColumnInfo(comment="sex_types",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * member_email
     */
    @ColumnInfo(comment="member_email",type="varchar(200)")
    @TableField(value = "member_email")

    private String memberEmail;


    /**
     * create_time
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="create_time",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


  
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
   

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getmemberName() {
        return memberName;
    }

    public void setmemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getmemberPhone() {
        return memberPhone;
    }


    public void setmemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getmemberIdNumber() {
        return memberIdNumber;
    }
  
    public void setmemberIdNumber(String memberIdNumber) {
        this.memberIdNumber = memberIdNumber;
    }
 
    public String getmemberPhoto() {
        return memberPhoto;
    }


    public void setmemberPhoto(String memberPhoto) {
        this.memberPhoto = memberPhoto;
    }

    public Integer getSexTypes() {
        return sexTypes;
    }


    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
   
    public String getmemberEmail() {
        return memberEmail;
    }
   

    public void setmemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
   
    public Date getCreateTime() {
        return createTime;
    }
    

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

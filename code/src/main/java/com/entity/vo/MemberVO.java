package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
* member
* Mobile interface returns entity helper class
* (The main function is to remove some unnecessary fields)
 */
@TableName("member")
public class MemberVO implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "id")
    private Integer id;

    @TableField(value = "username")
    private String username;


    @TableField(value = "password")
    private String password;



    @TableField(value = "member_name")
    private String memberName;



    @TableField(value = "member_phone")
    private String memberPhone;



    @TableField(value = "member_id_number")
    private String memberIdNumber;


    @TableField(value = "member_photo")
    private String memberPhoto;



    @TableField(value = "sex_types")
    private Integer sexTypes;

    @TableField(value = "member_email")
    private String memberEmail;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}

package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * User
  * The entity class that receives the argument
 *(In the actual development, with the mobile interface development, manually remove some useless fields, and the backend is generally enough to use entity)
 * model name from ModelAndView
 */
public class MemberModel implements Serializable {
    private static final long serialVersionUID = 1L;




    private Integer id;


    private String username;


    private String password;


    private String memberName;


  
    private String memberPhone;


    private String memberIdNumber;


    private String memberPhoto;


    private Integer sexTypes;


    private String memberEmail;


 
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

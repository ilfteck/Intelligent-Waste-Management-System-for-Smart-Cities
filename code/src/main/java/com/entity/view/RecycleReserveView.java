package com.entity.view;

import com.annotation.ColumnInfo;
import com.entity.RecycleReserveEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* Garbage removal request
* The back end returns the view entity helper class
* (Usually back-end associated tables or custom fields need to be returned for use)
*/
@TableName("recycle_reserve")
public class RecycleReserveView extends RecycleReserveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//Current table
	/**
	* The value of the application status
	*/
	@ColumnInfo(comment="The dictionary table value of the request status",type="varchar(200)")
	private String recycleYuyueYesnoValue;

	//Cascading table garbage collection
		/**
		* Garbage collection name
		*/

		@ColumnInfo(comment="Garbage collection name",type="varchar(200)")
		private String recycleName;
		/**
		* Garbage collection number
		*/

		@ColumnInfo(comment="Garbage collection number",type="varchar(200)")
		private String recycleUuidNumber;
		/**
		* Garbage collection photos
		*/

		@ColumnInfo(comment="Garbage collection photos",type="varchar(200)")
		private String recyclePhoto;
		/**
		* Refuse collection site
		*/

		@ColumnInfo(comment="Refuse collection site",type="varchar(200)")
		private String recycleAddress;
		/**
		* Refuse collection site
		*/
		@ColumnInfo(comment="Garbage collection type",type="int(11)")
		private Integer recycleTypes;
			/**
			* The value of the garbage collection type
			*/
			@ColumnInfo(comment="Dictionary table value of the garbage collection type",type="varchar(200)")
			private String recycleValue;
		/**
		* Garbage collection inventory
		*/

		@ColumnInfo(comment="Garbage collection inventory",type="int(11)")
		private Integer recycleKucunNumber;
		/**
		* Warehousing time
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="Warehousing time",type="timestamp")
		private Date recycleTime;
		/**
		* Introduction to garbage collection
		*/

		@ColumnInfo(comment="Introduction to garbage collection",type="longtext")
		private String recycleContent;
		/**
		* Logical deletion
		*/

		@ColumnInfo(comment="Logical deletion",type="int(11)")
		private Integer recycleDelete;
	//User
		/**
		* User name
		*/

		@ColumnInfo(comment="User name",type="varchar(200)")
		private String memberName;
		/**
		* user phone
		*/

		@ColumnInfo(comment=" user phone",type="varchar(200)")
		private String memberPhone;
		/**
		* User id
		*/

		@ColumnInfo(comment=" User id",type="varchar(200)")
		private String memberIdNumber;
		/**
		* memberPhoto
		*/

		@ColumnInfo(comment="memberPhoto",type="varchar(200)")
		private String memberPhoto;
		/**
		* memberEmail
		*/

		@ColumnInfo(comment="memberEmail",type="varchar(200)")
		private String memberEmail;



	public RecycleReserveView() {

	}

	public RecycleReserveView(RecycleReserveEntity recycleReserveEntity) {
		try {
			BeanUtils.copyProperties(this, recycleReserveEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public String getrecycleYuyueYesnoValue() {
		return recycleYuyueYesnoValue;
	}
	
	public void setrecycleYuyueYesnoValue(String recycleYuyueYesnoValue) {
		this.recycleYuyueYesnoValue = recycleYuyueYesnoValue;
	}


		public String getrecycleName() {
			return recycleName;
		}
		
		public void setrecycleName(String recycleName) {
			this.recycleName = recycleName;
		}

		
		public String getrecycleUuidNumber() {
			return recycleUuidNumber;
		}
		
		public void setrecycleUuidNumber(String recycleUuidNumber) {
			this.recycleUuidNumber = recycleUuidNumber;
		}

		
		public String getrecyclePhoto() {
			return recyclePhoto;
		}
		
		public void setrecyclePhoto(String recyclePhoto) {
			this.recyclePhoto = recyclePhoto;
		}

		
		public String getrecycleAddress() {
			return recycleAddress;
		}
		
		public void setrecycleAddress(String recycleAddress) {
			this.recycleAddress = recycleAddress;
		}
		
		public Integer getrecycleTypes() {
			return recycleTypes;
		}
		
		public void setrecycleTypes(Integer recycleTypes) {
			this.recycleTypes = recycleTypes;
		}


			public String getrecycleValue() {
				return recycleValue;
			}
		
			public void setrecycleValue(String recycleValue) {
				this.recycleValue = recycleValue;
			}

		
		public Integer getrecycleKucunNumber() {
			return recycleKucunNumber;
		}
		
		public void setrecycleKucunNumber(Integer recycleKucunNumber) {
			this.recycleKucunNumber = recycleKucunNumber;
		}

		
		public Date getrecycleTime() {
			return recycleTime;
		}
		
		public void setrecycleTime(Date recycleTime) {
			this.recycleTime = recycleTime;
		}

		
		public String getrecycleContent() {
			return recycleContent;
		}
		
		public void setrecycleContent(String recycleContent) {
			this.recycleContent = recycleContent;
		}

		
		public Integer getrecycleDelete() {
			return recycleDelete;
		}
		
		public void setrecycleDelete(Integer recycleDelete) {
			this.recycleDelete = recycleDelete;
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

		
		public String getmemberEmail() {
			return memberEmail;
		}
		
		public void setmemberEmail(String memberEmail) {
			this.memberEmail = memberEmail;
		}


	@Override
	public String toString() {
		return "recycleYuyueView{" +
			", recycleYuyueYesnoValue=" + recycleYuyueYesnoValue +
			", memberName=" + memberName +
			", memberPhone=" + memberPhone +
			", memberIdNumber=" + memberIdNumber +
			", memberPhoto=" + memberPhoto +
			", memberEmail=" + memberEmail +
			", recycleName=" + recycleName +
			", recycleUuidNumber=" + recycleUuidNumber +
			", recyclePhoto=" + recyclePhoto +
			", recycleAddress=" + recycleAddress +
			", recycleKucunNumber=" + recycleKucunNumber +
			", recycleTime=" + DateUtil.convertString(recycleTime,"yyyy-MM-dd") +
			", recycleContent=" + recycleContent +
			", recycleDelete=" + recycleDelete +
			"} " + super.toString();
	}
}

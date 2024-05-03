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
* 垃圾出库申请
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("recycle_reserve")
public class RecycleReserveView extends RecycleReserveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String recycleYuyueYesnoValue;

	//级联表 垃圾回收
		/**
		* 垃圾回收名称
		*/

		@ColumnInfo(comment="垃圾回收名称",type="varchar(200)")
		private String recycleName;
		/**
		* 垃圾回收编号
		*/

		@ColumnInfo(comment="垃圾回收编号",type="varchar(200)")
		private String recycleUuidNumber;
		/**
		* 垃圾回收照片
		*/

		@ColumnInfo(comment="垃圾回收照片",type="varchar(200)")
		private String recyclePhoto;
		/**
		* 垃圾回收地点
		*/

		@ColumnInfo(comment="垃圾回收地点",type="varchar(200)")
		private String recycleAddress;
		/**
		* 垃圾回收类型
		*/
		@ColumnInfo(comment="垃圾回收类型",type="int(11)")
		private Integer recycleTypes;
			/**
			* 垃圾回收类型的值
			*/
			@ColumnInfo(comment="垃圾回收类型的字典表值",type="varchar(200)")
			private String recycleValue;
		/**
		* 垃圾回收库存
		*/

		@ColumnInfo(comment="垃圾回收库存",type="int(11)")
		private Integer recycleKucunNumber;
		/**
		* 入库时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="入库时间",type="timestamp")
		private Date recycleTime;
		/**
		* 垃圾回收介绍
		*/

		@ColumnInfo(comment="垃圾回收介绍",type="longtext")
		private String recycleContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer recycleDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String memberName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String memberPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String memberIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String memberPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
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



	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getrecycleYuyueYesnoValue() {
		return recycleYuyueYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setrecycleYuyueYesnoValue(String recycleYuyueYesnoValue) {
		this.recycleYuyueYesnoValue = recycleYuyueYesnoValue;
	}


	//级联表的get和set 垃圾回收

		/**
		* 获取： 垃圾回收名称
		*/
		public String getrecycleName() {
			return recycleName;
		}
		/**
		* 设置： 垃圾回收名称
		*/
		public void setrecycleName(String recycleName) {
			this.recycleName = recycleName;
		}

		/**
		* 获取： 垃圾回收编号
		*/
		public String getrecycleUuidNumber() {
			return recycleUuidNumber;
		}
		/**
		* 设置： 垃圾回收编号
		*/
		public void setrecycleUuidNumber(String recycleUuidNumber) {
			this.recycleUuidNumber = recycleUuidNumber;
		}

		/**
		* 获取： 垃圾回收照片
		*/
		public String getrecyclePhoto() {
			return recyclePhoto;
		}
		/**
		* 设置： 垃圾回收照片
		*/
		public void setrecyclePhoto(String recyclePhoto) {
			this.recyclePhoto = recyclePhoto;
		}

		/**
		* 获取： 垃圾回收地点
		*/
		public String getrecycleAddress() {
			return recycleAddress;
		}
		/**
		* 设置： 垃圾回收地点
		*/
		public void setrecycleAddress(String recycleAddress) {
			this.recycleAddress = recycleAddress;
		}
		/**
		* 获取： 垃圾回收类型
		*/
		public Integer getrecycleTypes() {
			return recycleTypes;
		}
		/**
		* 设置： 垃圾回收类型
		*/
		public void setrecycleTypes(Integer recycleTypes) {
			this.recycleTypes = recycleTypes;
		}


			/**
			* 获取： 垃圾回收类型的值
			*/
			public String getrecycleValue() {
				return recycleValue;
			}
			/**
			* 设置： 垃圾回收类型的值
			*/
			public void setrecycleValue(String recycleValue) {
				this.recycleValue = recycleValue;
			}

		/**
		* 获取： 垃圾回收库存
		*/
		public Integer getrecycleKucunNumber() {
			return recycleKucunNumber;
		}
		/**
		* 设置： 垃圾回收库存
		*/
		public void setrecycleKucunNumber(Integer recycleKucunNumber) {
			this.recycleKucunNumber = recycleKucunNumber;
		}

		/**
		* 获取： 入库时间
		*/
		public Date getrecycleTime() {
			return recycleTime;
		}
		/**
		* 设置： 入库时间
		*/
		public void setrecycleTime(Date recycleTime) {
			this.recycleTime = recycleTime;
		}

		/**
		* 获取： 垃圾回收介绍
		*/
		public String getrecycleContent() {
			return recycleContent;
		}
		/**
		* 设置： 垃圾回收介绍
		*/
		public void setrecycleContent(String recycleContent) {
			this.recycleContent = recycleContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getrecycleDelete() {
			return recycleDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setrecycleDelete(Integer recycleDelete) {
			this.recycleDelete = recycleDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getmemberName() {
			return memberName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setmemberName(String memberName) {
			this.memberName = memberName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getmemberPhone() {
			return memberPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setmemberPhone(String memberPhone) {
			this.memberPhone = memberPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getmemberIdNumber() {
			return memberIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setmemberIdNumber(String memberIdNumber) {
			this.memberIdNumber = memberIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getmemberPhoto() {
			return memberPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setmemberPhoto(String memberPhoto) {
			this.memberPhoto = memberPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getmemberEmail() {
			return memberEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
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

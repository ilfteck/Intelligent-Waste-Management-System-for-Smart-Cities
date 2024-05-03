package com.entity.view;

import com.annotation.ColumnInfo;
import com.entity.TransportEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 运输
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("transport")
public class TransportView extends TransportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 运输类型的值
	*/
	@ColumnInfo(comment="运输类型的字典表值",type="varchar(200)")
	private String transportValue;

	//级联表 垃圾出库申请
		/**
		* 报名编号
		*/

		@ColumnInfo(comment="报名编号",type="varchar(200)")
		private String recycleYuyueUuidNumber;
										 
		/**
		* 垃圾出库申请 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer recycleYuyuememberId;
		/**
		* 报名理由
		*/

		@ColumnInfo(comment="报名理由",type="longtext")
		private String recycleYuyueText;
		/**
		* 出库时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="出库时间",type="timestamp")
		private Date recycletransportTime;
		/**
		* 申请状态
		*/
		@ColumnInfo(comment="申请状态",type="int(11)")
		private Integer recycleYuyueYesnoTypes;
			/**
			* 申请状态的值
			*/
			@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
			private String recycleYuyueYesnoValue;
		/**
		* 审核回复
		*/

		@ColumnInfo(comment="审核回复",type="longtext")
		private String recycleYuyueYesnoText;
		/**
		* 审核时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="审核时间",type="timestamp")
		private Date recycleYuyueShenheTime;



	public TransportView() {

	}

	public TransportView(TransportEntity transportEntity) {
		try {
			BeanUtils.copyProperties(this, transportEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 运输类型的值
	*/
	public String gettransportValue() {
		return transportValue;
	}
	/**
	* 设置： 运输类型的值
	*/
	public void settransportValue(String transportValue) {
		this.transportValue = transportValue;
	}


	//级联表的get和set 垃圾出库申请

		/**
		* 获取： 报名编号
		*/
		public String getrecycleYuyueUuidNumber() {
			return recycleYuyueUuidNumber;
		}
		/**
		* 设置： 报名编号
		*/
		public void setrecycleYuyueUuidNumber(String recycleYuyueUuidNumber) {
			this.recycleYuyueUuidNumber = recycleYuyueUuidNumber;
		}
		/**
		* 获取：垃圾出库申请 的 用户
		*/
		public Integer getrecycleYuyuememberId() {
			return recycleYuyuememberId;
		}
		/**
		* 设置：垃圾出库申请 的 用户
		*/
		public void setrecycleYuyuememberId(Integer recycleYuyuememberId) {
			this.recycleYuyuememberId = recycleYuyuememberId;
		}

		/**
		* 获取： 报名理由
		*/
		public String getrecycleYuyueText() {
			return recycleYuyueText;
		}
		/**
		* 设置： 报名理由
		*/
		public void setrecycleYuyueText(String recycleYuyueText) {
			this.recycleYuyueText = recycleYuyueText;
		}

		/**
		* 获取： 出库时间
		*/
		public Date getrecycletransportTime() {
			return recycletransportTime;
		}
		/**
		* 设置： 出库时间
		*/
		public void setrecycletransportTime(Date recycletransportTime) {
			this.recycletransportTime = recycletransportTime;
		}
		/**
		* 获取： 申请状态
		*/
		public Integer getrecycleYuyueYesnoTypes() {
			return recycleYuyueYesnoTypes;
		}
		/**
		* 设置： 申请状态
		*/
		public void setrecycleYuyueYesnoTypes(Integer recycleYuyueYesnoTypes) {
			this.recycleYuyueYesnoTypes = recycleYuyueYesnoTypes;
		}


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

		/**
		* 获取： 审核回复
		*/
		public String getrecycleYuyueYesnoText() {
			return recycleYuyueYesnoText;
		}
		/**
		* 设置： 审核回复
		*/
		public void setrecycleYuyueYesnoText(String recycleYuyueYesnoText) {
			this.recycleYuyueYesnoText = recycleYuyueYesnoText;
		}

		/**
		* 获取： 审核时间
		*/
		public Date getrecycleYuyueShenheTime() {
			return recycleYuyueShenheTime;
		}
		/**
		* 设置： 审核时间
		*/
		public void setrecycleYuyueShenheTime(Date recycleYuyueShenheTime) {
			this.recycleYuyueShenheTime = recycleYuyueShenheTime;
		}


	@Override
	public String toString() {
		return "transportView{" +
			", transportValue=" + transportValue +
			", recycleYuyueUuidNumber=" + recycleYuyueUuidNumber +
			", recycleYuyueText=" + recycleYuyueText +
			", recycletransportTime=" + DateUtil.convertString(recycletransportTime,"yyyy-MM-dd") +
			", recycleYuyueYesnoText=" + recycleYuyueYesnoText +
			", recycleYuyueShenheTime=" + DateUtil.convertString(recycleYuyueShenheTime,"yyyy-MM-dd") +
			"} " + super.toString();
	}
}

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
* Transportation
* The back end returns the view entity helper class
* (Usually back-end associated tables or custom fields need to be returned for use)
*/
@TableName("transport")
public class TransportView extends TransportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	
	/**
	* The value of the transportation type
	*/
	@ColumnInfo(comment="Dictionary table value for the transport type",type="varchar(200)")
	private String transportValue;

	
		/**
		* Registration number
		*/

		@ColumnInfo(comment="recycleYuyueUuidNumbe",type="varchar(200)")
		private String recycleYuyueUuidNumber;
										 
		/**
		*Garbage daelivery application user
		*/
		@ColumnInfo(comment="User",type="int(11)")
		private Integer recycleYuyuememberId;
		/**
		*recycleYuyueText
		*/

		@ColumnInfo(comment="recycleYuyueText",type="longtext")
		private String recycleYuyueText;
		/**
		* recycletransportTime
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="recycletransportTime",type="timestamp")
		private Date recycletransportTime;
		/**
		* recycleYuyueYesnoTypes
		*/
		@ColumnInfo(comment="recycleYuyueYesnoTypes",type="int(11)")
		private Integer recycleYuyueYesnoTypes;
			/**
			* recycleYuyueYesnoValue
			*/
			@ColumnInfo(comment="recycleYuyueYesnoValue",type="varchar(200)")
			private String recycleYuyueYesnoValue;
		/**
		* recycleYuyueYesnoText
		*/

		@ColumnInfo(comment="recycleYuyueYesnoText",type="longtext")
		private String recycleYuyueYesnoText;
		/**
		* recycleYuyueShenheTime
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="recycleYuyueShenheTime",type="timestamp")
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


	public String gettransportValue() {
		return transportValue;
	}
	
	public void settransportValue(String transportValue) {
		this.transportValue = transportValue;
	}


		public String getrecycleYuyueUuidNumber() {
			return recycleYuyueUuidNumber;
		}
		
		public void setrecycleYuyueUuidNumber(String recycleYuyueUuidNumber) {
			this.recycleYuyueUuidNumber = recycleYuyueUuidNumber;
		}
		
	
		public Integer getrecycleYuyuememberId() {
			return recycleYuyuememberId;
		}
		
		public void setrecycleYuyuememberId(Integer recycleYuyuememberId) {
			this.recycleYuyuememberId = recycleYuyuememberId;
		}

		public String getrecycleYuyueText() {
			return recycleYuyueText;
		}
		
		public void setrecycleYuyueText(String recycleYuyueText) {
			this.recycleYuyueText = recycleYuyueText;
		}

		
		public Date getrecycletransportTime() {
			return recycletransportTime;
		}
		
		public void setrecycletransportTime(Date recycletransportTime) {
			this.recycletransportTime = recycletransportTime;
		}
		
		public Integer getrecycleYuyueYesnoTypes() {
			return recycleYuyueYesnoTypes;
		}
		
		public void setrecycleYuyueYesnoTypes(Integer recycleYuyueYesnoTypes) {
			this.recycleYuyueYesnoTypes = recycleYuyueYesnoTypes;
		}


		
			public String getrecycleYuyueYesnoValue() {
				return recycleYuyueYesnoValue;
			}
		
			public void setrecycleYuyueYesnoValue(String recycleYuyueYesnoValue) {
				this.recycleYuyueYesnoValue = recycleYuyueYesnoValue;
			}

	
		public String getrecycleYuyueYesnoText() {
			return recycleYuyueYesnoText;
		}
	
		public void setrecycleYuyueYesnoText(String recycleYuyueYesnoText) {
			this.recycleYuyueYesnoText = recycleYuyueYesnoText;
		}

		
		public Date getrecycleYuyueShenheTime() {
			return recycleYuyueShenheTime;
		}
		
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

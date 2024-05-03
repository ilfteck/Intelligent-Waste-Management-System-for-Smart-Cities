package com.entity.view;

import com.annotation.ColumnInfo;
import com.entity.MemberEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;

/**
* User
* The back end returns the view entity helper class
* (Usually back-end associated tables or custom fields need to be returned for use)
*/
@TableName("member")
public class MemberView extends MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//Current table
	/**
	* Gender value
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;




	public MemberView() {

	}

	public MemberView(MemberEntity memberEntity) {
		try {
			BeanUtils.copyProperties(this, memberEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	
	public String getSexValue() {
		return sexValue;
	}
	
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}




	@Override
	public String toString() {
		return "memberView{" +
			", sexValue=" + sexValue +
			"} " + super.toString();
	}
}

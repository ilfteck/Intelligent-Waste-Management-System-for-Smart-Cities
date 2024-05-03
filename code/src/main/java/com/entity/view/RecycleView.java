package com.entity.view;

import com.annotation.ColumnInfo;
import com.entity.RecycleEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;

/**
* Garbage collection
* The back end returns the view entity helper class
* (Usually back-end associated tables or custom fields need to be returned for use)

*/
@TableName("recycle")
public class RecycleView extends RecycleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	
	/**
	* The value of the garbage collection type
	*/
	@ColumnInfo(comment="The value of the garbage collection type",type="varchar(200)")
	private String recycleValue;




	public RecycleView() {

	}

	public RecycleView(RecycleEntity recycleEntity) {
		try {
			BeanUtils.copyProperties(this, recycleEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	

	public String getrecycleValue() {
		return recycleValue;
	}
	
	public void setrecycleValue(String recycleValue) {
		this.recycleValue = recycleValue;
	}




	@Override
	public String toString() {
		return "recycleView{" +
			", recycleValue=" + recycleValue +
			"} " + super.toString();
	}
}

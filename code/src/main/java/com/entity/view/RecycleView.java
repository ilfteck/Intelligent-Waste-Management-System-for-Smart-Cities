package com.entity.view;

import com.annotation.ColumnInfo;
import com.entity.RecycleEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;

/**
* 垃圾回收
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("recycle")
public class RecycleView extends RecycleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 垃圾回收类型的值
	*/
	@ColumnInfo(comment="垃圾回收类型的字典表值",type="varchar(200)")
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



	//当前表的
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




	@Override
	public String toString() {
		return "recycleView{" +
			", recycleValue=" + recycleValue +
			"} " + super.toString();
	}
}

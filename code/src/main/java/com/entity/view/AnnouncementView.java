package com.entity.view;

import com.annotation.ColumnInfo;
import com.entity.AnnouncementEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;

/**
* 公告
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("announcement")
public class AnnouncementView extends AnnouncementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 公告类型的值
	*/
	@ColumnInfo(comment="公告类型的字典表值",type="varchar(200)")
	private String announcementValue;




	public AnnouncementView() {

	}

	public AnnouncementView(AnnouncementEntity announcementEntity) {
		try {
			BeanUtils.copyProperties(this, announcementEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 公告类型的值
	*/
	public String getannouncementValue() {
		return announcementValue;
	}
	/**
	* 设置： 公告类型的值
	*/
	public void setannouncementValue(String announcementValue) {
		this.announcementValue = announcementValue;
	}




	@Override
	public String toString() {
		return "announcementView{" +
			", announcementValue=" + announcementValue +
			"} " + super.toString();
	}
}

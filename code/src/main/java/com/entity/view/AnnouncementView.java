package com.entity.view;

import com.annotation.ColumnInfo;
import com.entity.AnnouncementEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;

/**
* Announcement
* The back end returns the view entity helper class
* (Usually back-end associated tables or custom fields need to be returned for use)
*/
@TableName("announcement")
public class AnnouncementView extends AnnouncementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//Current table
	/**
	*Current table
	*/
	@ColumnInfo(comment="The dictionary table value of the bulletin type",type="varchar(200)")
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



	
	public String getannouncementValue() {
		return announcementValue;
	}
	
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

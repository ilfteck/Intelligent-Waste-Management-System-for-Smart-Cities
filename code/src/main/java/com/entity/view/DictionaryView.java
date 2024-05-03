package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.DictionaryEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* Dictionary
* The back end returns the view entity helper class
* (Usually back-end associated tables or custom fields need to be returned for use)
*/
@TableName("dictionary")
public class DictionaryView extends DictionaryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//Current table




	public DictionaryView() {

	}

	public DictionaryView(DictionaryEntity dictionaryEntity) {
		try {
			BeanUtils.copyProperties(this, dictionaryEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







	@Override
	public String toString() {
		return "DictionaryView{" +
			"} " + super.toString();
	}
}

package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.DictionaryDao;
import com.entity.DictionaryEntity;
import com.service.DictionaryService;
import com.entity.view.DictionaryView;

/**
 * dictionaryService
 */
@Service("dictionaryService")
@Transactional
public class DictionaryServiceImpl extends ServiceImpl<DictionaryDao, DictionaryEntity> implements DictionaryService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<DictionaryView> page =new Query<DictionaryView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

     /**
     * dictionaryConvert
     * @param obj view
     */
    public void dictionaryConvert(Object obj, HttpServletRequest request) {
        try {
            if (obj == null) return;
            //Fields of all types in the current view and entity
            List<String> fieldNameList = new ArrayList<>();
            Class tempClass = obj.getClass();
            while (tempClass !=null) {
                Field[] declaredFields = tempClass.getDeclaredFields();
                for (Field f : declaredFields) {
                    f.setAccessible(true);
                    if (f.getType().getName().equals("java.lang.Integer") && f.getName().contains("Types")) {
                        fieldNameList.add(f.getName());
                    }
                }
                tempClass = tempClass.getSuperclass(); //Get the parent class and assign it to yourself
            }

            // servletContext
//            ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
            ServletContext servletContext = request.getServletContext();
            Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");

            //Assign a Value to the value field by the value of Types
            for (String s : fieldNameList) {
                Field types = null;
                if(hasField(obj.getClass(),s)){
                    //To determine if this field is present in the view, use reflection to retrieve the field
                    types= obj.getClass().getDeclaredField(s);//Gets the Types private field
                }else{
                    // If this field does not exist in the table, it is an field in the parent table, that is, in entity. The value is taken from entity                    types=obj.getClass().getSuperclass().getDeclaredField(s);
                }
                Field value = obj.getClass().getDeclaredField(s.replace("Types", "Value"));//Gets the value private field
                //Set permissions
                types.setAccessible(true);
                value.setAccessible(true);

                //Assign
                if (StringUtil.isNotEmpty(String.valueOf(types.get(obj)))) { //The value of types is not null
                    int i = Integer.parseInt(String.valueOf(types.get(obj)));//type
                   // Convert all uppercase s1 characters to lowercase and prefix them with _                    char[] chars = s.toCharArray();
                    StringBuffer sbf = new StringBuffer();
                    for(int  b=0; b< chars.length; b++){
                        char ch = chars[b];
                        if(ch <= 90 && ch >= 65){
                            sbf.append("_");
                            ch += 32;
                        }
                        sbf.append(ch);
                    }
                    String s2 = dictionaryMap.get(sbf.toString()).get(i);
                    value.set(obj, s2);
                } else {
                    new Exception("There is a problem with dictionary table assignment::::"+value.getName());
                    value.set(obj, "");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Determine whether the entity has this field
     * @param c
     * @param fieldName
     * @return
     */
    public boolean hasField(Class c, String fieldName){
        Field[] fields = c.getDeclaredFields();

        for (Field f : fields) {
            if (fieldName.equals(f.getName())) {
                return true;

            }

        }

        return false;
    }

}

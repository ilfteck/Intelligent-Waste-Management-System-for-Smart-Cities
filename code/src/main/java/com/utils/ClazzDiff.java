package com.utils;

import com.annotation.ColumnInfo;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 对象比较
 */
public class ClazzDiff {


    /**
     * Object comparison, return a list, and automatically ignore the comparison of obj2 if the attribute value of obj1 is empty
     * @param obj1 
     * @param obj2 
     * @param ignoreProperties 
     * @return
     */
    public  List<String> ClazzDiffColumn(Object obj1, Object obj2, @Nullable String... ignoreProperties) throws NoSuchFieldException, IllegalAccessException {

        Assert.notNull(obj1, "obj1 is not empty");
        Assert.notNull(obj2, "obj2 is not empty");


        List<String> list = new ArrayList<>();

        Class<?> obj1Class = obj1.getClass();
        Class<?> obj2Class = obj2.getClass();
        if (!obj1Class.isInstance(obj2)) {
            throw new IllegalArgumentException("The two classes passed in are not the same class");
        }
        List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);//要忽略的属性

        /**
         * Current table
         */
        Field[] obj1DeclaredFields = obj1Class.getDeclaredFields();
        for (Field f : obj1DeclaredFields) {//Loop all fields of ojb1
            f.setAccessible(true);
            Field obj1Field = obj1Class.getDeclaredField(f.getName());
            Field obj2Field = obj2Class.getDeclaredField(f.getName());
            obj1Field.setAccessible(true);
            obj2Field.setAccessible(true);

// Property 1 is not null, property 2 is not null if ignoreProperties are passed in, and is not included            if (obj1Field.get(obj1) != null &&(ignoreList == null || !ignoreList.contains(obj1Field.getName())) ) {
                ColumnInfo columnInfo = obj1Field.getAnnotation(ColumnInfo.class);
                Object o1 = obj1Field.get(obj1);
                Object o2 = obj2Field.get(obj2);

                if(!String.valueOf(o1).equals(String.valueOf(o2))){
                    if(f.getName().contains("File")){
                        list.add(columnInfo.comment()+"-->now : <a type='success' style='text-decoration:none' class='el-button' href='"+o1+"' >File download</a>,original : <a type='success' style='text-decoration:none' class='el-button' href='"+o2+"' >文件下载</a>");
                    }else if(f.getName().contains("Video")){
                        list.add(columnInfo.comment()+"-->now : <video src='"+o1+"' width='100px' height='100px' controls='controls'></video>,original : <video src='"+o2+"' width='100px' height='100px' controls='controls'></video>");
                    }else if(f.getName().contains("Photo")){
                        list.add(columnInfo.comment()+"-->now : <img src='"+o1+"' width='100px' height='100px'>,original : <img src='"+o2+"' width='100px' height='100px'>");
                    }else if(f.getName().contains("Time")){
                        list.add(columnInfo.comment()+"-->now : ["+ DateUtils.format((Date) o1,"yyyy-MM-dd")+"],original : ["+DateUtils.format((Date) o2,"yyyy-MM-dd")+"]");
                    }else{
                        list.add(columnInfo.comment()+"-->now : ["+o1+"],original : ["+o2+"]");
                    }
                }
            }
        }



        /**
         * 父表
         */
        Field[] obj1DeclaredFields2 = obj1Class.getSuperclass().getDeclaredFields();
        for (Field f : obj1DeclaredFields2) {//Loop all fields of ojb1
            f.setAccessible(true);
            Field obj1Field = obj1Class.getSuperclass().getDeclaredField(f.getName());
            Field obj2Field = obj2Class.getSuperclass().getDeclaredField(f.getName());
            obj1Field.setAccessible(true);
            obj2Field.setAccessible(true);

// Property 1 is not null, property 2 is not null if ignoreProperties are passed in, and is not included            if (obj1Field.get(obj1) != null &&(ignoreList == null || !ignoreList.contains(obj1Field.getName())) ) {
                ColumnInfo columnInfo = obj1Field.getAnnotation(ColumnInfo.class);
                Object o1 = obj1Field.get(obj1);
                Object o2 = obj2Field.get(obj2);

                if(!String.valueOf(o1).equals(String.valueOf(o2))){
                    if(f.getName().contains("File")){
                        list.add(columnInfo.comment()+"-->now : <a type='success' style='text-decoration:none' class='el-button' href='"+o1+"' >File download</a>,original : <a type='success' style='text-decoration:none' class='el-button' href='"+o2+"' >文件下载</a>");
                    }else if(f.getName().contains("Video")){
                        list.add(columnInfo.comment()+"-->now : <video src='"+o1+"' width='100px' height='100px' controls='controls'></video>,original : <video src='"+o2+"' width='100px' height='100px' controls='controls'></video>");
                    }else if(f.getName().contains("Photo")){
                        list.add(columnInfo.comment()+"-->now : <img src='"+o1+"' width='100px' height='100px'>,original : <img src='"+o2+"' width='100px' height='100px'>");
                    }else if(f.getName().contains("Time")){
                        list.add(columnInfo.comment()+"-->now : ["+ DateUtils.format((Date) o1,"yyyy-MM-dd")+"],original : ["+DateUtils.format((Date) o2,"yyyy-MM-dd")+"]");
                    }else{
                        list.add(columnInfo.comment()+"-->now : ["+o1+"],original : ["+o2+"]");
                    }
                }
            }
        }
        return  list;
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


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

//        ChengpinEntity chengpinEntity1 = new ChengpinEntity();
//
//        chengpinEntity1.setId(2);
//        chengpinEntity1.setXiaoshourenyuanId(3);
//        chengpinEntity1.setChengpinUuidNumber("4");
//        chengpinEntity1.setChengpinName("6");
//        chengpinEntity1.setChengpinSchool("7");
//        chengpinEntity1.setChengpinLianxifangshi("8");
//        chengpinEntity1.setChengpinXiaoshouJine(9.0);
//        chengpinEntity1.setChengpinTichengJine(10.0);
//        chengpinEntity1.setLunwenTypes(11);
//        chengpinEntity1.setLunwenXiaoshouJine(12.1);
//        chengpinEntity1.setLunwenTichengJine(13.1);
//        chengpinEntity1.setChengpinZhuangtaiTypes(14);
//        chengpinEntity1.setChengpinFile("15");
//        chengpinEntity1.setChengpinText("16");
//        chengpinEntity1.setChengpinDelete(1);
//        chengpinEntity1.setInsertTime(new Date());
//        chengpinEntity1.setUpdateTime(null);
//        chengpinEntity1.setCreateTime(null);
//
//
//
//
//        ChengpinEntity chengpinEntity2 = new ChengpinEntity();
//
//        chengpinEntity2.setId(3);
//        chengpinEntity2.setXiaoshourenyuanId(4);
//        chengpinEntity2.setChengpinUuidNumber("4");
//        chengpinEntity2.setChengpinName("6");
//        chengpinEntity2.setChengpinSchool("7");
//        chengpinEntity2.setChengpinLianxifangshi("8");
//        chengpinEntity2.setChengpinXiaoshouJine(9.0);
//        chengpinEntity2.setChengpinTichengJine(10.0);
//        chengpinEntity2.setLunwenTypes(11);
//        chengpinEntity2.setLunwenXiaoshouJine(12.1);
//        chengpinEntity2.setLunwenTichengJine(13.1);
//        chengpinEntity2.setChengpinZhuangtaiTypes(14);
//        chengpinEntity2.setChengpinFile("16");
//        chengpinEntity2.setChengpinText("16");
//        chengpinEntity2.setChengpinDelete(1);
//        chengpinEntity2.setInsertTime(null);
//        chengpinEntity2.setUpdateTime(new Date());
//        chengpinEntity2.setCreateTime(null);


//        List<String> strings = new ClazzDiff<ChengpinEntity>().ClazzDiffColumn(chengpinEntity1, chengpinEntity2,new String[]{"serialVersionUID"});
//        List<String> strings = new ClazzDiff().ClazzDiffColumn(chengpinEntity1, chengpinEntity2);
//        System.out.println(strings);


    }

}

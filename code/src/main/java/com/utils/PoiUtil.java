package com.utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * PoiUtil
 */
public class PoiUtil {
    /**
     * PoiUtil
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static List<List<String>> poiImport(String url) throws Exception {
        List<List<String>> list = new ArrayList<>();
        //Create Excel to read file contents
        HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(new File(url)));
        /**
         * The first way reads the Sheet page
         */
//      HSSFSheet sheet = workbook.getSheet("Sheet0");
        /**
         * The second way reads the Sheet page
         */
        HSSFSheet sheet = workbook.getSheetAt(0);//Get worksheet
        for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
            HSSFRow row = sheet.getRow(i);//Fetch row
            List<String> rowlist = new ArrayList<>();//Row data
            for (int j = 0; j < row.getLastCellNum(); j++) {
                HSSFCell cell = row.getCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                String value = cell.getStringCellValue();
                rowlist.add(value);//Row Data is added to the row
            }
            list.add(rowlist);//Adds the row data to the list
        }
        return list;
    }






    // poiExport
    public static void poiExport(List<List<String>> list, String url) throws Exception {
        //workbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        //Create a worksheet shheet
        HSSFSheet sheet = workbook.createSheet();
        for (int i = 0; i < list.size(); i++) {
            HSSFRow row = sheet.createRow(i);
            List<String> dataList = list.get(i);
            for (int j = 0; j < dataList.size(); j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(dataList.get(j));
            }

        }
        FileOutputStream stream = FileUtils.openOutputStream(new File(url));
        workbook.write(stream);
        stream.close();
    }


    public static void main(String[] args) {
        try {
            //export
            List<List<String>> lists = PoiUtil.poiImport("C:/Users/Administrator/Desktop/工作1.xls");
            System.out.println();


            //expore

            PoiUtil.poiExport(lists, "C:/Users/Administrator/Desktop/工作1.xls");

//
//            List<List<String>> list = new ArrayList<>();
//            ArrayList<String> dataList = new ArrayList<>();
//            dataList.add("标题1");
//            dataList.add("标题2");
//            dataList.add("标题3");
//            list.add(dataList);
//            // 追加数据
//            for (int i = 1; i < 10; i++) {// 这里的int 起始是1 也就是第二行开始
//                ArrayList<String> dataList111 = new ArrayList<>();
//                dataList111.add("内容" + i);
//                dataList111.add("内容1111111121222222222333333333377777777411111111477777777" + i);
//                dataList111.add("内容" + i);
//                list.add(dataList111);
//            }
//            PoiUtil.poiExport(list, "C:/Users/Administrator/Desktop/工作1.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

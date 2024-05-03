package com.controller;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.IgnoreAuth;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.ConfigEntity;
import com.service.CommonService;
import com.service.ConfigService;
import com.utils.BaiduUtil;
import com.utils.FileUtil;
import com.utils.R;

/**
 * Universal interface
 */
@RestController
public class CommonController {
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private CommonService commonService;


    /**
     * Java code to achieve MySQL database export
     *
     * @param mysqlUrl     
     * @param hostIP      
     * @param userName    
     * @param hostPort     
     * @param password     
     * @param savePath     
     * @param fileName    
     * @param databaseName 
     * @return 
     */
    @IgnoreAuth
    @RequestMapping("/beifen")
    public R beifen(String mysqlUrl, String hostIP, String userName, String hostPort, String password, String savePath, String fileName, String databaseName) {
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// If the directory does not exist
            saveFile.mkdirs();// Create folder
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            String cmd = mysqlUrl + "mysqldump -h" + hostIP + " -u" + userName + " -P" + hostPort + " -p" + password + " " + databaseName;
            runtime.exec(cmd);
            Process process = runtime.exec(cmd);
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
            bufferedReader = new BufferedReader(inputStreamReader);
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line);
            }
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("Backup data error");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return R.ok();
    }

    /**
     * Java code to achieve MySQL database export
     *
     * @param mysqlUrl     
     * @param hostIP       
     * @param userName     
     * @param hostPort    
     * @param password     
     * @param savePath     
     * @param fileName     
     * @param databaseName 
     */
    @IgnoreAuth
    @RequestMapping("/huanyuan")
    public R huanyuan(String mysqlUrl, String hostIP, String userName, String hostPort, String password, String savePath, String fileName, String databaseName) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process child1 = rt.exec(mysqlUrl+"mysql.exe  -h" + hostIP + " -u" + userName + " -P" + hostPort + " -p" + password + " " + databaseName);
            OutputStream out = child1.getOutputStream();//The input information from the console is the output stream
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(savePath+"/"+fileName), "utf-8"));
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);
// Note: If the file is written in buffer mode, it will cause Chinese garbled characters, and the flush() method can be avoided
            writer.flush();
            out.close();
            br.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("Data import error");
        }
        return R.ok();
    }


    /**
     *Sum of pie charts
     * @return
     */
    @RequestMapping("/pieSum")
    public R pieSum(@RequestParam Map<String,Object> params) {
        logger.debug("Sum of pie charts:,,Controller:{},,params:{}",this.getClass().getName(),params);
        List<Map<String, Object>> result = commonService.pieSum(params);
        return R.ok().put("data", result);
    }

    /**
     * Pie chart statistics
     * @return
     */
    @RequestMapping("/pieCount")
    public R pieCount(@RequestParam Map<String,Object> params) {
        logger.debug("Pie chart statistics:,,Controller:{},,params:{}",this.getClass().getName(),params);
        List<Map<String, Object>> result = commonService.pieCount(params);
        return R.ok().put("data", result);
    }

    /**
     * Bar graphs sum in single columns
     * @return
     */
    @RequestMapping("/barSumOne")
    public R barSumOne(@RequestParam Map<String,Object> params) {
        logger.debug("Bar graphs sum in single columns:,,Controller:{},,params:{}",this.getClass().getName(),params);
        List<Map<String, Object>> result = commonService.barSumOne(params);

        List<String> xAxis = new ArrayList<>();//Report X-axis
        List<List<String>> yAxis = new ArrayList<>();//y
        List<String> legend = new ArrayList<>();//topic
        List<String> yAxis0 = new ArrayList<>();
        yAxis.add(yAxis0);
        legend.add("");
        for(Map<String, Object> map :result){
            String oneValue = String.valueOf(map.get("name"));
            String value = String.valueOf(map.get("value"));
            xAxis.add(oneValue);
            yAxis0.add(value);
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("xAxis",xAxis);
        resultMap.put("yAxis",yAxis);
        resultMap.put("legend",legend);
        return R.ok().put("data", resultMap);
    }
    /**
     * Bar chart statistics single column
     * @return
     */
    @RequestMapping("/barCountOne")
    public R barCountOne(@RequestParam Map<String,Object> params) {
        logger.debug("Bar chart statistics single column:,,Controller:{},,params:{}",this.getClass().getName(),params);
        List<Map<String, Object>> result = commonService.barCountOne(params);

        List<String> xAxis = new ArrayList<>();//x
        List<List<String>> yAxis = new ArrayList<>();//y
        List<String> legend = new ArrayList<>();//topic

        List<String> yAxis0 = new ArrayList<>();
        yAxis.add(yAxis0);
        legend.add("");
        for(Map<String, Object> map :result){
            String oneValue = String.valueOf(map.get("name"));
            String value = String.valueOf(map.get("value"));
            xAxis.add(oneValue);
            yAxis0.add(value);
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("xAxis",xAxis);
        resultMap.put("yAxis",yAxis);
        resultMap.put("legend",legend);
        return R.ok().put("data", resultMap);
    }

    /**
     * Bar chart statistics double columns
     * @return
     */
    @RequestMapping("/barSumTwo")
    public R barSumTwo(@RequestParam Map<String,Object> params) {
        logger.debug("Bar chart statistics double columns:,,Controller:{},,params:{}",this.getClass().getName(),params);
        List<Map<String, Object>> result = commonService.barSumTwo(params);
        List<String> xAxis = new ArrayList<>();//x
        List<List<String>> yAxis = new ArrayList<>();//y
        List<String> legend = new ArrayList<>();//topic

        Map<String, HashMap<String, String>> dataMap = new LinkedHashMap<>();
        for(Map<String, Object> map :result){
            String name1Value = String.valueOf(map.get("name1"));
            String name2Value = String.valueOf(map.get("name2"));
            String value = String.valueOf(map.get("value"));
            if(!legend.contains(name2Value)){
                legend.add(name2Value);//When added, it is the most complete type of the second column
            }
            if(dataMap.containsKey(name1Value)){
                dataMap.get(name1Value).put(name2Value,value);
            }else{
                HashMap<String, String> name1Data = new HashMap<>();
                name1Data.put(name2Value,value);
                dataMap.put(name1Value,name1Data);
            }

        }

        for(int i =0; i<legend.size(); i++){
            yAxis.add(new ArrayList<String>());
        }

        Set<String> keys = dataMap.keySet();
        for(String key:keys){
            xAxis.add(key);
            HashMap<String, String> map = dataMap.get(key);
            for(int i =0; i<legend.size(); i++){
                List<String> data = yAxis.get(i);
                if(StringUtil.isNotEmpty(map.get(legend.get(i)))){
                    data.add(map.get(legend.get(i)));
                }else{
                    data.add("0");
                }
            }
        }
        System.out.println();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("xAxis",xAxis);
        resultMap.put("yAxis",yAxis);
        resultMap.put("legend",legend);
        return R.ok().put("data", resultMap);
    }
    /**
     * Bar chart statistics double columns
     * @return
     */
    @RequestMapping("/barCountTwo")
    public R barCountTwo(@RequestParam Map<String,Object> params) {
        logger.debug("Bar chart statistics double columns:,,Controller:{},,params:{}",this.getClass().getName(),params);
        List<Map<String, Object>> result = commonService.barCountTwo(params);
        List<String> xAxis = new ArrayList<>();//x
        List<List<String>> yAxis = new ArrayList<>();//y
        List<String> legend = new ArrayList<>();//topic

        Map<String, HashMap<String, String>> dataMap = new LinkedHashMap<>();
        for(Map<String, Object> map :result){
            String name1Value = String.valueOf(map.get("name1"));
            String name2Value = String.valueOf(map.get("name2"));
            String value = String.valueOf(map.get("value"));
            if(!legend.contains(name2Value)){
                legend.add(name2Value);//When added, it is the most complete type of the second column
            }
            if(dataMap.containsKey(name1Value)){
                dataMap.get(name1Value).put(name2Value,value);
            }else{
                HashMap<String, String> name1Data = new HashMap<>();
                name1Data.put(name2Value,value);
                dataMap.put(name1Value,name1Data);
            }

        }

        for(int i =0; i<legend.size(); i++){
            yAxis.add(new ArrayList<String>());
        }

        Set<String> keys = dataMap.keySet();
        for(String key:keys){
            xAxis.add(key);
            HashMap<String, String> map = dataMap.get(key);
            for(int i =0; i<legend.size(); i++){
                List<String> data = yAxis.get(i);
                if(StringUtil.isNotEmpty(map.get(legend.get(i)))){
                    data.add(map.get(legend.get(i)));
                }else{
                    data.add("0");
                }
            }
        }
        System.out.println();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("xAxis",xAxis);
        resultMap.put("yAxis",yAxis);
        resultMap.put("legend",legend);
        return R.ok().put("data", resultMap);
    }

    /**
     tableName 
     condition1 
     condition1Value 
     average 

   
      Number(res.data.value.toFixed(1))
      if(res.data){}
     * */
    @IgnoreAuth
    @RequestMapping("/queryScore")
    public R queryScore(@RequestParam Map<String, Object> params) {
        logger.debug("queryScore:,,Controller:{},,params:{}",this.getClass().getName(),params);
        Map<String, Object> queryScore = commonService.queryScore(params);
        return R.ok().put("data", queryScore);
    }

    /**
     * 
     *  tableName  		
     *	groupColumn  	
     * @return
     */
    @RequestMapping("/newSelectGroupCount")
    public R newSelectGroupCount(@RequestParam Map<String,Object> params) {
        logger.debug("newSelectGroupCount:,,Controller:{},,params:{}",this.getClass().getName(),params);
        List<Map<String, Object>> result = commonService.newSelectGroupCount(params);
        return R.ok().put("data", result);
    }

    /**
     * tableName  		
     * groupColumn  	
     * sumCloum			
     * @return
     */
    @RequestMapping("/newSelectGroupSum")
    public R newSelectGroupSum(@RequestParam Map<String,Object> params) {
        logger.debug("newSelectGroupSum:,,Controller:{},,params:{}",this.getClass().getName(),params);
        List<Map<String, Object>> result = commonService.newSelectGroupSum(params);
        return R.ok().put("data", result);
    }

    /**
     * 
     */
    @RequestMapping("/barSum")
    public R barSum(@RequestParam Map<String,Object> params) {
        logger.debug("barSum方法:,,Controller:{},,params:{}",this.getClass().getName(), com.alibaba.fastjson.JSONObject.toJSONString(params));
        Boolean isJoinTableFlag =  false;
        String one =  "";
        String two =  "";

        
        Map<String,Object> thisTable = JSON.parseObject(String.valueOf(params.get("thisTable")),Map.class);
        params.put("thisTable",thisTable);

        
        String joinTableString = String.valueOf(params.get("joinTable"));
        if(StringUtil.isNotEmpty(joinTableString)) {
            Map<String, Object> joinTable = JSON.parseObject(joinTableString, Map.class);
            params.put("joinTable", joinTable);
            isJoinTableFlag = true;
        }

        if(StringUtil.isNotEmpty(String.valueOf(thisTable.get("date")))){//当前表日期
            thisTable.put("date",String.valueOf(thisTable.get("date")).split(","));
            one = "thisDate0";
        }
        if(isJoinTableFlag){
            Map<String, Object> joinTable = (Map<String, Object>) params.get("joinTable");
            if(StringUtil.isNotEmpty(String.valueOf(joinTable.get("date")))){
                joinTable.put("date",String.valueOf(joinTable.get("date")).split(","));
                if(StringUtil.isEmpty(one)){
                    one ="joinDate0";
                }else{
                    if(StringUtil.isEmpty(two)){
                        two ="joinDate0";
                    }
                }
            }
        }
        if(StringUtil.isNotEmpty(String.valueOf(thisTable.get("string")))){//string
            thisTable.put("string",String.valueOf(thisTable.get("string")).split(","));
            if(StringUtil.isEmpty(one)){
                one ="thisString0";
            }else{
                if(StringUtil.isEmpty(two)){
                    two ="thisString0";
                }
            }
        }
        if(isJoinTableFlag){//The string of the cascading table
            Map<String, Object> joinTable = (Map<String, Object>) params.get("joinTable");
            if(StringUtil.isNotEmpty(String.valueOf(joinTable.get("string")))){
                joinTable.put("string",String.valueOf(joinTable.get("string")).split(","));
                if(StringUtil.isEmpty(one)){
                    one ="joinString0";
                }else{
                    if(StringUtil.isEmpty(two)){
                        two ="joinString0";
                    }
                }
            }
        }
        if(StringUtil.isNotEmpty(String.valueOf(thisTable.get("types")))){//Current table type
            thisTable.put("types",String.valueOf(thisTable.get("types")).split(","));
            if(StringUtil.isEmpty(one)){
                one ="thisTypes0";
            }else{
                if(StringUtil.isEmpty(two)){
                    two ="thisTypes0";
                }
            }
        }
        if(isJoinTableFlag){//Current table type
            Map<String, Object> joinTable = (Map<String, Object>) params.get("joinTable");
            if(StringUtil.isNotEmpty(String.valueOf(joinTable.get("types")))){
                joinTable.put("types",String.valueOf(joinTable.get("types")).split(","));
                if(StringUtil.isEmpty(one)){
                    one ="joinTypes0";
                }else{
                    if(StringUtil.isEmpty(two)){
                        two ="joinTypes0";
                    }
                }

            }
        }

        List<Map<String, Object>> result = commonService.barSum(params);

        List<String> xAxis = new ArrayList<>();//x
        List<List<String>> yAxis = new ArrayList<>();//y
        List<String> legend = new ArrayList<>();//topic

        if(StringUtil.isEmpty(two)){//The second column is not included
            List<String> yAxis0 = new ArrayList<>();
            yAxis.add(yAxis0);
            legend.add("");
            for(Map<String, Object> map :result){
                String oneValue = String.valueOf(map.get(one));
                String value = String.valueOf(map.get("value"));
                xAxis.add(oneValue);
                yAxis0.add(value);
            }
        }else{//Include second column
            Map<String, HashMap<String, String>> dataMap = new LinkedHashMap<>();
            if(StringUtil.isNotEmpty(two)){
                for(Map<String, Object> map :result){
                    String oneValue = String.valueOf(map.get(one));
                    String twoValue = String.valueOf(map.get(two));
                    String value = String.valueOf(map.get("value"));
                    if(!legend.contains(twoValue)){
                        legend.add(twoValue);//When added, it is the most complete type of the second column
                    }
                    if(dataMap.containsKey(oneValue)){
                        dataMap.get(oneValue).put(twoValue,value);
                    }else{
                        HashMap<String, String> oneData = new HashMap<>();
                        oneData.put(twoValue,value);
                        dataMap.put(oneValue,oneData);
                    }

                }
            }

            for(int i =0; i<legend.size(); i++){
                yAxis.add(new ArrayList<String>());
            }

            Set<String> keys = dataMap.keySet();
            for(String key:keys){
                xAxis.add(key);
                HashMap<String, String> map = dataMap.get(key);
                for(int i =0; i<legend.size(); i++){
                    List<String> data = yAxis.get(i);
                    if(StringUtil.isNotEmpty(map.get(legend.get(i)))){
                        data.add(map.get(legend.get(i)));
                    }else{
                        data.add("0");
                    }
                }
            }
            System.out.println();
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("xAxis",xAxis);
        resultMap.put("yAxis",yAxis);
        resultMap.put("legend",legend);
        return R.ok().put("data", resultMap);
    }

   
    @RequestMapping("/barCount")
    public R barCount(@RequestParam Map<String,Object> params) {
        logger.debug("barCount方法:,,Controller:{},,params:{}",this.getClass().getName(), com.alibaba.fastjson.JSONObject.toJSONString(params));
        Boolean isJoinTableFlag =  false;
        String one =  "";
        String two =  "";

       
        Map<String,Object> thisTable = JSON.parseObject(String.valueOf(params.get("thisTable")),Map.class);
        params.put("thisTable",thisTable);

        String joinTableString = String.valueOf(params.get("joinTable"));
        if(StringUtil.isNotEmpty(joinTableString)) {
            Map<String, Object> joinTable = JSON.parseObject(joinTableString, Map.class);
            params.put("joinTable", joinTable);
            isJoinTableFlag = true;
        }

        if(StringUtil.isNotEmpty(String.valueOf(thisTable.get("date")))){
            thisTable.put("date",String.valueOf(thisTable.get("date")).split(","));
            one = "thisDate0";
        }
        if(isJoinTableFlag){
            Map<String, Object> joinTable = (Map<String, Object>) params.get("joinTable");
            if(StringUtil.isNotEmpty(String.valueOf(joinTable.get("date")))){
                joinTable.put("date",String.valueOf(joinTable.get("date")).split(","));
                if(StringUtil.isEmpty(one)){
                    one ="joinDate0";
                }else{
                    if(StringUtil.isEmpty(two)){
                        two ="joinDate0";
                    }
                }
            }
        }
        if(StringUtil.isNotEmpty(String.valueOf(thisTable.get("string")))){
            thisTable.put("string",String.valueOf(thisTable.get("string")).split(","));
            if(StringUtil.isEmpty(one)){
                one ="thisString0";
            }else{
                if(StringUtil.isEmpty(two)){
                    two ="thisString0";
                }
            }
        }
        if(isJoinTableFlag){
            Map<String, Object> joinTable = (Map<String, Object>) params.get("joinTable");
            if(StringUtil.isNotEmpty(String.valueOf(joinTable.get("string")))){
                joinTable.put("string",String.valueOf(joinTable.get("string")).split(","));
                if(StringUtil.isEmpty(one)){
                    one ="joinString0";
                }else{
                    if(StringUtil.isEmpty(two)){
                        two ="joinString0";
                    }
                }
            }
        }
        if(StringUtil.isNotEmpty(String.valueOf(thisTable.get("types")))){//当前表类型
            thisTable.put("types",String.valueOf(thisTable.get("types")).split(","));
            if(StringUtil.isEmpty(one)){
                one ="thisTypes0";
            }else{
                if(StringUtil.isEmpty(two)){
                    two ="thisTypes0";
                }
            }
        }
        if(isJoinTableFlag){
            Map<String, Object> joinTable = (Map<String, Object>) params.get("joinTable");
            if(StringUtil.isNotEmpty(String.valueOf(joinTable.get("types")))){
                joinTable.put("types",String.valueOf(joinTable.get("types")).split(","));
                if(StringUtil.isEmpty(one)){
                    one ="joinTypes0";
                }else{
                    if(StringUtil.isEmpty(two)){
                        two ="joinTypes0";
                    }
                }

            }
        }

        List<Map<String, Object>> result = commonService.barCount(params);

        List<String> xAxis = new ArrayList<>();//x
        List<List<String>> yAxis = new ArrayList<>();//y
        List<String> legend = new ArrayList<>();//

        if(StringUtil.isEmpty(two)){
            List<String> yAxis0 = new ArrayList<>();
            yAxis.add(yAxis0);
            legend.add("");
            for(Map<String, Object> map :result){
                String oneValue = String.valueOf(map.get(one));
                String value = String.valueOf(map.get("value"));
                xAxis.add(oneValue);
                yAxis0.add(value);
            }
        }else{
            Map<String, HashMap<String, String>> dataMap = new LinkedHashMap<>();
            if(StringUtil.isNotEmpty(two)){
                for(Map<String, Object> map :result){
                    String oneValue = String.valueOf(map.get(one));
                    String twoValue = String.valueOf(map.get(two));
                    String value = String.valueOf(map.get("value"));
                    if(!legend.contains(twoValue)){
                        legend.add(twoValue);
                    }
                    if(dataMap.containsKey(oneValue)){
                        dataMap.get(oneValue).put(twoValue,value);
                    }else{
                        HashMap<String, String> oneData = new HashMap<>();
                        oneData.put(twoValue,value);
                        dataMap.put(oneValue,oneData);
                    }

                }
            }

            for(int i =0; i<legend.size(); i++){
                yAxis.add(new ArrayList<String>());
            }

            Set<String> keys = dataMap.keySet();
            for(String key:keys){
                xAxis.add(key);
                HashMap<String, String> map = dataMap.get(key);
                for(int i =0; i<legend.size(); i++){
                    List<String> data = yAxis.get(i);
                    if(StringUtil.isNotEmpty(map.get(legend.get(i)))){
                        data.add(map.get(legend.get(i)));
                    }else{
                        data.add("0");
                    }
                }
            }
            System.out.println();
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("xAxis",xAxis);
        resultMap.put("yAxis",yAxis);
        resultMap.put("legend",legend);
        return R.ok().put("data", resultMap);
    }
}

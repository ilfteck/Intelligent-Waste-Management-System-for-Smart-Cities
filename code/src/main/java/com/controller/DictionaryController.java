
package com.controller;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;

import com.service.DictionaryService;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;

/**
 * dictionary
 * Back-enad interfaace
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);

    private static final String TABLE_NAME = "dictionary";

    @Autowired
    private DictionaryService dictionaryService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private TransportService transportService;
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private RecycleService recycleService;
    @Autowired
    private RecycleReserveService recycleReserveService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private UsersService usersService;


    /**
    * Back-end list
    */
    @RequestMapping("/page")
    @IgnoreAuth
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        PageUtils page = dictionaryService.queryPage(params);
        List<DictionaryView> list =(List<DictionaryView>)page.getList();
        for(DictionaryView c:list){
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * back-end detail
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DictionaryEntity dictionary = dictionaryService.selectById(id);
        if(dictionary !=null){
            //entity to view
            DictionaryView view = new DictionaryView();
            BeanUtils.copyProperties( dictionary , view );//Refactor the entity data into the view
            //Example Modify the corresponding dictionary table fields
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * back-end save
    */
    @RequestMapping("/save")
    public R save(@RequestBody DictionaryEntity dictionary, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dictionary:{}",this.getClass().getName(),dictionary.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"Never enter");

        Wrapper<DictionaryEntity> queryWrapper = new EntityWrapper<DictionaryEntity>()
            .eq("dic_code", dictionary.getDicCode())
            .eq("index_name", dictionary.getIndexName())
            ;
        if(dictionary.getDicCode().contains("_erji_types")){
            queryWrapper.eq("super_id",dictionary.getSuperId());
        }

        logger.info("sql language:"+queryWrapper.getSqlSegment());
        DictionaryEntity dictionaryEntity = dictionaryService.selectOne(queryWrapper);
        if(dictionaryEntity==null){
            dictionary.setCreateTime(new Date());
            dictionaryService.insert(dictionary);
            List<DictionaryEntity> dictionaryEntities = dictionaryService.selectList(new EntityWrapper<DictionaryEntity>());
            ServletContext servletContext = request.getServletContext();
            Map<String, Map<Integer,String>> map = new HashMap<>();
            for(DictionaryEntity d :dictionaryEntities){
                Map<Integer, String> m = map.get(d.getDicCode());
                if(m ==null || m.isEmpty()){
                    m = new HashMap<>();
                }
                m.put(d.getCodeIndex(),d.getIndexName());
                map.put(d.getDicCode(),m);
            }
            servletContext.setAttribute("dictionaryMap",map);
            return R.ok();
        }else {
            return R.error(511,"The table has the same data");
        }
    }

    /**
    * Back-end modification
    */
    @RequestMapping("/update")
    public R update(@RequestBody DictionaryEntity dictionary, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,dictionary:{}",this.getClass().getName(),dictionary.toString());
        DictionaryEntity oldDictionaryEntity = dictionaryService.selectById(dictionary.getId());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"Never enter");

            dictionaryService.updateById(dictionary);//Update by id
            //If the dictionary table modifies the data, look it up again and put it in the listener
            List<DictionaryEntity> dictionaryEntities = dictionaryService.selectList(new EntityWrapper<DictionaryEntity>());
            ServletContext servletContext = request.getServletContext();
            Map<String, Map<Integer,String>> map = new HashMap<>();
            for(DictionaryEntity d :dictionaryEntities){
                Map<Integer, String> m = map.get(d.getDicCode());
                if(m ==null || m.isEmpty()){
                    m = new HashMap<>();
                }
                m.put(d.getCodeIndex(),d.getIndexName());
                map.put(d.getDicCode(),m);
            }
            servletContext.setAttribute("dictionaryMap",map);
            return R.ok();
    }



    /**
    * delete
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DictionaryEntity> oldDictionaryList =dictionaryService.selectBatchIds(Arrays.asList(ids));//Data to delete
        dictionaryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * mix
     */
    @RequestMapping("/maxCodeIndex")
    public R maxCodeIndex(@RequestBody DictionaryEntity dictionary){
        logger.debug("maxCodeIndex:,,Controller:{},,dictionary:{}",this.getClass().getName(),dictionary.toString());
        List<String> descs = new ArrayList<>();
        descs.add("code_index");
        Wrapper<DictionaryEntity> queryWrapper = new EntityWrapper<DictionaryEntity>()
                .eq("dic_code", dictionary.getDicCode())
                .orderDesc(descs);
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        List<DictionaryEntity> dictionaryEntityList = dictionaryService.selectList(queryWrapper);
        if(dictionaryEntityList.size()>0 ){
            return R.ok().put("maxCodeIndex",dictionaryEntityList.get(0).getCodeIndex()+1);
        }else{
            return R.ok().put("maxCodeIndex",1);
        }
    }

    /**
     * Batch upload
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer memberId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<DictionaryEntity> dictionaryList = new ArrayList<>();//Batch upload
            Map<String, List<String>> seachFields= new HashMap<>();//Batch upload
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//Get file path
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//Get file path
                        dataList.remove(0);//Delete the first line because the first line is the prompt
                        for(List<String> data:dataList){
                            //循环
                            DictionaryEntity dictionaryEntity = new DictionaryEntity();
//                            dictionaryEntity.setDicCode(data.get(0));                   
//                            dictionaryEntity.setDicName(data.get(0));                    
//                            dictionaryEntity.setCodeIndex(Integer.valueOf(data.get(0)));   
//                            dictionaryEntity.setIndexName(data.get(0));                    
//                            dictionaryEntity.setSuperId(Integer.valueOf(data.get(0)));   
//                            dictionaryEntity.setBeizhu(data.get(0));                    
//                            dictionaryEntity.setCreateTime(date);
                            dictionaryList.add(dictionaryEntity);


                            //Put the field you want to query for duplicates into the map
                        }

                        //Check whether duplicate
                        dictionaryService.insertBatch(dictionaryList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"If data cannot be inserted in batches, contact the administrator");
        }
    }




}


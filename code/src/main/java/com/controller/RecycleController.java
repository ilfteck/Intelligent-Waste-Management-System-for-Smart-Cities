
package com.controller;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;

import com.service.TokenService;
import com.utils.*;

import com.service.DictionaryService;
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
 * Garbage recycling
 * Back-end interface
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/recycle")
public class RecycleController {
    private static final Logger logger = LoggerFactory.getLogger(RecycleController.class);

    @Autowired
    private RecycleService recycleService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private TransportService transportService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private RecycleReserveService recycleReserveService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private UsersService usersService;


    /**
    * back-end list
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page way:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"Will never enter");
        else if("用户".equals(role))
            params.put("memberId",request.getSession().getAttribute("userId"));
        params.put("recycleDeleteStart",1);params.put("recycleDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = recycleService.queryPage(params);

        //Dictionary table data conversion
        List<RecycleView> list =(List<RecycleView>)page.getList();
        for(RecycleView c:list){
            //Dictionary table data conversion
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * back-end detail
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info way:,,Controller:{},,id:{}",this.getClass().getName(),id);
        RecycleEntity recycle = recycleService.selectById(id);
        if(recycle !=null){
            //entity to view
            RecycleView view = new RecycleView();
            BeanUtils.copyProperties( recycle , view );//Dictionary table data conversion
            //Dictionary table data conversion
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"No data available");
        }

    }

    /**
    * back-end save
    */
    @RequestMapping("/save")
    public R save(@RequestBody RecycleEntity recycle, HttpServletRequest request){
        logger.debug("save way:,,Controller:{},,recycle:{}",this.getClass().getName(),recycle.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"Never enter");

        Wrapper<RecycleEntity> queryWrapper = new EntityWrapper<RecycleEntity>()
            .eq("recycle_name", recycle.getrecycleName())
            .eq("recycle_address", recycle.getrecycleAddress())
            .eq("recycle_types", recycle.getrecycleTypes())
            .eq("recycle_kucun_number", recycle.getrecycleKucunNumber())
            .eq("recycle_delete", recycle.getrecycleDelete())
            ;

        logger.info("sql language:"+queryWrapper.getSqlSegment());
        RecycleEntity recycleEntity = recycleService.selectOne(queryWrapper);
        if(recycleEntity ==null){
            recycle.setrecycleDelete(1);
            recycle.setInsertTime(new Date());
            recycle.setCreateTime(new Date());
            recycleService.insert(recycle);
            return R.ok();
        }else {
            return R.error(511,"The table has the same data");
        }
    }

    /**
    * back-end change
    */
    @RequestMapping("/update")
    public R update(@RequestBody RecycleEntity recycle, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update way:,,Controller:{},,recycle:{}",this.getClass().getName(),recycle.toString());
        RecycleEntity oldRecycleEntity = recycleService.selectById(recycle.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"The table has the same data");
        if("".equals(recycle.getrecyclePhoto()) || "null".equals(recycle.getrecyclePhoto())){
                recycle.setrecyclePhoto(null);
        }

            recycleService.updateById(recycle);
            return R.ok();
    }



    /**
    * deleete
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<RecycleEntity> oldrecycleList = recycleService.selectBatchIds(Arrays.asList(ids));
        ArrayList<RecycleEntity> list = new ArrayList<>();
        for(Integer id:ids){
            RecycleEntity recycleEntity = new RecycleEntity();
            recycleEntity.setId(id);
            recycleEntity.setrecycleDelete(2);
            list.add(recycleEntity);
        }
        if(list != null && list.size() >0){
            recycleService.updateBatchById(list);
        }

        return R.ok();
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
            List<RecycleEntity> recycleList = new ArrayList<>();//Batch upload
            Map<String, List<String>> seachFields= new HashMap<>();//Batch upload
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"The file has no suffix");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"Only excel files whose suffix is xls are supported");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"Unable to find upload file, please contact administrator");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());// Read the xls file
                        dataList.remove(0);// Delete the first line because the first line is the prompt
                        for(List<String> data:dataList){
                            //循环
                            RecycleEntity recycleEntity = new RecycleEntity();
//                            recycleEntity.setrecycleName(data.get(0));                    
//                            recycleEntity.setrecycleUuidNumber(data.get(0));                    
//                            recycleEntity.setrecyclePhoto("");
//                            recycleEntity.setrecycleAddress(data.get(0));                   
//                            recycleEntity.setrecycleTypes(Integer.valueOf(data.get(0)));  
//                            recycleEntity.setrecycleKucunNumber(Integer.valueOf(data.get(0)));   
//                            recycleEntity.setrecycleTime(sdf.parse(data.get(0)));          
//                            recycleEntity.setrecycleContent("");
//                            recycleEntity.setrecycleDelete(1);
//                            recycleEntity.setInsertTime(date);
//                            recycleEntity.setCreateTime(date);
                            recycleList.add(recycleEntity);


                            //Put the field you want to query for duplicates into the map
                                //Garbage collection number
                                if(seachFields.containsKey("recycleUuidNumber")){
                                    List<String> recycleUuidNumber = seachFields.get("recycleUuidNumber");
                                    recycleUuidNumber.add(data.get(0));
                                }else{
                                    List<String> recycleUuidNumber = new ArrayList<>();
                                    recycleUuidNumber.add(data.get(0));
                                    seachFields.put("recycleUuidNumber",recycleUuidNumber);
                                }
                        }

                        //Check whether duplicate
                         //Garbage collection number
                        List<RecycleEntity> recycleEntities_recycleUuidNumber = recycleService.selectList(new EntityWrapper<RecycleEntity>().in("recycle_uuid_number", seachFields.get("recycleUuidNumber")).eq("recycle_delete", 1));
                        if(recycleEntities_recycleUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RecycleEntity s:recycleEntities_recycleUuidNumber){
                                repeatFields.add(s.getrecycleUuidNumber());
                            }
                            return R.error(511,"The garbage collection Number field in the table of the database already exists:"+repeatFields.toString());
                        }
                        recycleService.insertBatch(recycleList);
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


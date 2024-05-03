
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
 * Garbage disposal application
 * Back-end interface
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/recyclereserve")
public class RecycleReserveController {
    private static final Logger logger = LoggerFactory.getLogger(RecycleReserveController.class);

    @Autowired
    private RecycleReserveService recycleReserveService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private TransportService transportService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private RecycleService recycleService;
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
            return R.error(511,"never enter");
        else if("用户".equals(role))
            params.put("memberId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = recycleReserveService.queryPage(params);

        //Dictionary table data conversion
        List<RecycleReserveView> list =(List<RecycleReserveView>)page.getList();
        for(RecycleReserveView c:list){
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
        RecycleReserveEntity recycleYuyue = recycleReserveService.selectById(id);
        if(recycleYuyue !=null){
            //entity to view
            RecycleReserveView view = new RecycleReserveView();
            BeanUtils.copyProperties( recycleYuyue , view );//Refactor the entity data into the view
            MemberEntity member = memberService.selectById(recycleYuyue.getmemberId());
            if(member != null){
            BeanUtils.copyProperties( member , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "memberId"});//Adds the cascaded data to the view and excludes the id and creation time fields for the current table in the cascaded registry
            view.setmemberId(member.getId());
            }
            RecycleEntity recycle = recycleService.selectById(recycleYuyue.getrecycleId());
            if(recycle != null){
            BeanUtils.copyProperties( recycle , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "memberId"});//Adds the cascaded data to the view and excludes the id and creation time fields for the current table in the cascaded registry
            view.setrecycleId(recycle.getId());
            }
            //Example Modify the corresponding dictionary table fields
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
    public R save(@RequestBody RecycleReserveEntity recycleYuyue, HttpServletRequest request){
        logger.debug("save way:,,Controller:{},,recycleYuyue:{}",this.getClass().getName(),recycleYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"never enter");
        else if("User".equals(role))
            recycleYuyue.setmemberId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<RecycleReserveEntity> queryWrapper = new EntityWrapper<RecycleReserveEntity>()
            .eq("recycle_id", recycleYuyue.getrecycleId())
            .eq("member_id", recycleYuyue.getmemberId())
            .in("recycle_reserve_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql language:"+queryWrapper.getSqlSegment());
        RecycleReserveEntity recycleReserveEntity = recycleReserveService.selectOne(queryWrapper);
        if(recycleReserveEntity ==null){
            recycleYuyue.setrecycleYuyueYesnoTypes(1);
            recycleReserveService.insert(recycleYuyue);
            return R.ok();
        }else {
            if(recycleReserveEntity.getrecycleYuyueYesnoTypes()==1)
                return R.error(511,"Have the same data pending review");
            else if(recycleReserveEntity.getrecycleYuyueYesnoTypes()==2)
                return R.error(511,"Have the same approved data");
            else
                return R.error(511,"The table has the same data");
        }
    }

    /**
    * Back-end modification
    */
    @RequestMapping("/update")
    public R update(@RequestBody RecycleReserveEntity recycleYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update way:,,Controller:{},,recycleYuyue:{}",this.getClass().getName(),recycleYuyue.toString());
        RecycleReserveEntity oldRecycleReserveEntity = recycleReserveService.selectById(recycleYuyue.getId());//Query original data

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"never enter");
//        else if("User".equals(role))
//            recycleYuyue.setmemberId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            recycleReserveService.updateById(recycleYuyue);
            return R.ok();
    }


    /**
    *examine
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody RecycleReserveEntity recycleReserveEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,recycleYuyueEntity:{}",this.getClass().getName(),
            recycleReserveEntity.toString());

        RecycleReserveEntity oldrecycleYuyue = recycleReserveService.selectById(recycleReserveEntity.getId());

//        if(recycleYuyueEntity.getrecycleYuyueYesnoTypes() == 2){
//            recycleYuyueEntity.setrecycleYuyueTypes();
//        }else if(recycleYuyueEntity.getrecycleYuyueYesnoTypes() == 3){
//            recycleYuyueEntity.setrecycleYuyueTypes();
//        }
        recycleReserveEntity.setrecycleYuyueShenheTime(new Date());
        recycleReserveService.updateById(recycleReserveEntity);//examine

        return R.ok();
    }

    /**
    * delete
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<RecycleReserveEntity> oldrecycleYuyueList = recycleReserveService.selectBatchIds(Arrays.asList(ids));//delete data
        recycleReserveService.deleteBatchIds(Arrays.asList(ids));

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
            List<RecycleReserveEntity> recycleYuyueList = new ArrayList<>();//Batch upload
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
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());/
                        dataList.remove(0);// Delete the first line because the first line is the prompt
                        for(List<String> data:dataList){
                            //循环
                            RecycleReserveEntity recycleReserveEntity = new RecycleReserveEntity();
//                            recycleYuyueEntity.setrecycleYuyueUuidNumber(data.get(0));                   
//                            recycleYuyueEntity.setrecycleId(Integer.valueOf(data.get(0)));   
//                            recycleYuyueEntity.setmemberId(Integer.valueOf(data.get(0)));   
//                            recycleYuyueEntity.setrecycleYuyueText(data.get(0));                    
//                            recycleYuyueEntity.setrecycletransportTime(sdf.parse(data.get(0)));          
//                            recycleYuyueEntity.setrecycleYuyueYesnoTypes(Integer.valueOf(data.get(0)));   
//                            recycleYuyueEntity.setrecycleYuyueYesnoText(data.get(0));                    
//                            recycleYuyueEntity.setrecycleYuyueShenheTime(sdf.parse(data.get(0)));          
//                            recycleYuyueEntity.setInsertTime(date);
//                            recycleYuyueEntity.setCreateTime(date);
                            recycleYuyueList.add(recycleReserveEntity);


                            //Put the field you want to query for duplicates into the map
                                //number
                                if(seachFields.containsKey("recycleYuyueUuidNumber")){
                                    List<String> recycleYuyueUuidNumber = seachFields.get("recycleYuyueUuidNumber");
                                    recycleYuyueUuidNumber.add(data.get(0));
                                }else{
                                    List<String> recycleYuyueUuidNumber = new ArrayList<>();
                                    recycleYuyueUuidNumber.add(data.get(0));
                                    seachFields.put("recycleYuyueUuidNumber",recycleYuyueUuidNumber);
                                }
                        }

                        //Put the field you want to query for duplicates into the map
                         //number
                        List<RecycleReserveEntity> recycleYuyueEntities_recycleYuyueUuidNumber = recycleReserveService.selectList(new EntityWrapper<RecycleReserveEntity>().in("recycle_reserve_uuid_number", seachFields.get("recycleYuyueUuidNumber")));
                        if(recycleYuyueEntities_recycleYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RecycleReserveEntity s:recycleYuyueEntities_recycleYuyueUuidNumber){
                                repeatFields.add(s.getrecycleYuyueUuidNumber());
                            }
                            return R.error(511,"The [Registration Number] field in the table of the database already exists:"+repeatFields.toString());
                        }
                        recycleReserveService.insertBatch(recycleYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"If data cannoat be inserted in batches, contact the administrator");
        }
    }




}


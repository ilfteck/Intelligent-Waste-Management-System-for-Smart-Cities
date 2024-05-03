
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
 * announcement
 * Back-end interface
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    private static final Logger logger = LoggerFactory.getLogger(AnnouncementController.class);

    @Autowired
    private AnnouncementService announcementService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private TransportService transportService;//transport
    @Autowired
    private DictionaryService dictionaryService;//dictionary
    @Autowired
    private RecycleService recycleService;//recycle
    @Autowired
    private RecycleReserveService recycleReserveService;//recycleReserve
    @Autowired
    private MemberService memberService;//User
    @Autowired
    private UsersService usersService;//Management


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("pageway:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"Will never enter");
        else if("User".equals(role))
            params.put("memberId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = announcementService.queryPage(params);

        //Dictionary table data conversion
        List<AnnouncementView> list =(List<AnnouncementView>)page.getList();
        for(AnnouncementView c:list){
            //Example Modify the corresponding dictionary table fields
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * Look at it from behind
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        AnnouncementEntity announcement = announcementService.selectById(id);
        if(announcement !=null){
            //entity change view
            AnnouncementView view = new AnnouncementView();
            BeanUtils.copyProperties( announcement , view );//Refactor the entity data into the view
            //Example Modify the corresponding dictionary table fields
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"No data available");
        }

    }

    /**
    * Back-end save
    */
    @RequestMapping("/save")
    public R save(@RequestBody AnnouncementEntity announcement, HttpServletRequest request){
        logger.debug("save way:,,Controller:{},,announcement:{}",this.getClass().getName(),announcement.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"No data available");

        Wrapper<AnnouncementEntity> queryWrapper = new EntityWrapper<AnnouncementEntity>()
            .eq("announcement_name", announcement.getannouncementName())
            .eq("announcement_types", announcement.getannouncementTypes())
            ;

        logger.info("sql language:"+queryWrapper.getSqlSegment());
        AnnouncementEntity announcementEntity = announcementService.selectOne(queryWrapper);
        if(announcementEntity ==null){
            announcement.setInsertTime(new Date());
            announcement.setCreateTime(new Date());
            announcementService.insert(announcement);
            return R.ok();
        }else {
            return R.error(511,"The table has the same data");
        }
    }

    /**
    * Back-end modification
    */
    @RequestMapping("/update")
    public R update(@RequestBody AnnouncementEntity announcement, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,announcement:{}",this.getClass().getName(),announcement.toString());
        AnnouncementEntity oldAnnouncementEntity = announcementService.selectById(announcement.getId());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"No data available");
        if("".equals(announcement.getannouncementPhoto()) || "null".equals(announcement.getannouncementPhoto())){
                announcement.setannouncementPhoto(null);
        }

            announcementService.updateById(announcement);//Update by id
            return R.ok();
    }



    /**
    * delete
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<AnnouncementEntity> oldannouncementList = announcementService.selectBatchIds(Arrays.asList(ids));//Data to delete
        announcementService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * Batch upload
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert way:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer memberId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<AnnouncementEntity> announcementList = new ArrayList<>();//Uploaded stuff
            Map<String, List<String>> seachFields= new HashMap<>();//The field to be queried
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"The file has no suffix");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"Only excel files whose suffix is xls are supported");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//Get file path
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"Unable to find upload file, please contact administrator");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());
                        dataList.remove(0);
                        for(List<String> data:dataList){
                            //loop    AnnouncementEntity announcementEntity = new AnnouncementEntity();
//                            announcementEntity.setannouncementName(data.get(0));                    //Announcement name to be changed
//                            announcementEntity.setannouncementPhoto("");//detail and map
//                            announcementEntity.setannouncementTypes(Integer.valueOf(data.get(0)));   //Announcement type to be changed
//                            announcementEntity.setInsertTime(date);//Time
//                            announcementEntity.setannouncementContent("");//detail and map
//                            announcementEntity.setCreateTime(date);//Time
                            announcementList.add(announcementEntity);


                            //Put the field you want to query for duplicates into the map
                        }

                        //Check whether duplicate
                        announcementService.insertBatch(announcementList);
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


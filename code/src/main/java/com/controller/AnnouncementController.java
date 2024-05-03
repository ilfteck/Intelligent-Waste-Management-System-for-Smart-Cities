
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
 * 公告
 * 后端接口
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
    private TransportService transportService;//运输
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private RecycleService recycleService;//垃圾回收
    @Autowired
    private RecycleReserveService recycleReserveService;//垃圾出库申请
    @Autowired
    private MemberService memberService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("memberId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = announcementService.queryPage(params);

        //字典表数据转换
        List<AnnouncementView> list =(List<AnnouncementView>)page.getList();
        for(AnnouncementView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        AnnouncementEntity announcement = announcementService.selectById(id);
        if(announcement !=null){
            //entity转view
            AnnouncementView view = new AnnouncementView();
            BeanUtils.copyProperties( announcement , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody AnnouncementEntity announcement, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,announcement:{}",this.getClass().getName(),announcement.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<AnnouncementEntity> queryWrapper = new EntityWrapper<AnnouncementEntity>()
            .eq("announcement_name", announcement.getannouncementName())
            .eq("announcement_types", announcement.getannouncementTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnnouncementEntity announcementEntity = announcementService.selectOne(queryWrapper);
        if(announcementEntity ==null){
            announcement.setInsertTime(new Date());
            announcement.setCreateTime(new Date());
            announcementService.insert(announcement);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody AnnouncementEntity announcement, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,announcement:{}",this.getClass().getName(),announcement.toString());
        AnnouncementEntity oldAnnouncementEntity = announcementService.selectById(announcement.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(announcement.getannouncementPhoto()) || "null".equals(announcement.getannouncementPhoto())){
                announcement.setannouncementPhoto(null);
        }

            announcementService.updateById(announcement);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<AnnouncementEntity> oldannouncementList = announcementService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        announcementService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer memberId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<AnnouncementEntity> announcementList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            AnnouncementEntity announcementEntity = new AnnouncementEntity();
//                            announcementEntity.setannouncementName(data.get(0));                    //公告名称 要改的
//                            announcementEntity.setannouncementPhoto("");//详情和图片
//                            announcementEntity.setannouncementTypes(Integer.valueOf(data.get(0)));   //公告类型 要改的
//                            announcementEntity.setInsertTime(date);//时间
//                            announcementEntity.setannouncementContent("");//详情和图片
//                            announcementEntity.setCreateTime(date);//时间
                            announcementList.add(announcementEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        announcementService.insertBatch(announcementList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}


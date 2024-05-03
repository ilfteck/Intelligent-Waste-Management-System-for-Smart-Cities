
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
 * 垃圾回收
 * 后端接口
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
    private TransportService transportService;//运输
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private AnnouncementService announcementService;//公告
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
        params.put("recycleDeleteStart",1);params.put("recycleDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = recycleService.queryPage(params);

        //字典表数据转换
        List<RecycleView> list =(List<RecycleView>)page.getList();
        for(RecycleView c:list){
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
        RecycleEntity recycle = recycleService.selectById(id);
        if(recycle !=null){
            //entity转view
            RecycleView view = new RecycleView();
            BeanUtils.copyProperties( recycle , view );//把实体数据重构到view中
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
    public R save(@RequestBody RecycleEntity recycle, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,recycle:{}",this.getClass().getName(),recycle.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<RecycleEntity> queryWrapper = new EntityWrapper<RecycleEntity>()
            .eq("recycle_name", recycle.getrecycleName())
            .eq("recycle_address", recycle.getrecycleAddress())
            .eq("recycle_types", recycle.getrecycleTypes())
            .eq("recycle_kucun_number", recycle.getrecycleKucunNumber())
            .eq("recycle_delete", recycle.getrecycleDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RecycleEntity recycleEntity = recycleService.selectOne(queryWrapper);
        if(recycleEntity ==null){
            recycle.setrecycleDelete(1);
            recycle.setInsertTime(new Date());
            recycle.setCreateTime(new Date());
            recycleService.insert(recycle);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RecycleEntity recycle, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,recycle:{}",this.getClass().getName(),recycle.toString());
        RecycleEntity oldRecycleEntity = recycleService.selectById(recycle.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(recycle.getrecyclePhoto()) || "null".equals(recycle.getrecyclePhoto())){
                recycle.setrecyclePhoto(null);
        }

            recycleService.updateById(recycle);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<RecycleEntity> oldrecycleList = recycleService.selectBatchIds(Arrays.asList(ids));//要删除的数据
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
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer memberId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<RecycleEntity> recycleList = new ArrayList<>();//上传的东西
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
                            RecycleEntity recycleEntity = new RecycleEntity();
//                            recycleEntity.setrecycleName(data.get(0));                    //垃圾回收名称 要改的
//                            recycleEntity.setrecycleUuidNumber(data.get(0));                    //垃圾回收编号 要改的
//                            recycleEntity.setrecyclePhoto("");//详情和图片
//                            recycleEntity.setrecycleAddress(data.get(0));                    //垃圾回收地点 要改的
//                            recycleEntity.setrecycleTypes(Integer.valueOf(data.get(0)));   //垃圾回收类型 要改的
//                            recycleEntity.setrecycleKucunNumber(Integer.valueOf(data.get(0)));   //垃圾回收库存 要改的
//                            recycleEntity.setrecycleTime(sdf.parse(data.get(0)));          //入库时间 要改的
//                            recycleEntity.setrecycleContent("");//详情和图片
//                            recycleEntity.setrecycleDelete(1);//逻辑删除字段
//                            recycleEntity.setInsertTime(date);//时间
//                            recycleEntity.setCreateTime(date);//时间
                            recycleList.add(recycleEntity);


                            //把要查询是否重复的字段放入map中
                                //垃圾回收编号
                                if(seachFields.containsKey("recycleUuidNumber")){
                                    List<String> recycleUuidNumber = seachFields.get("recycleUuidNumber");
                                    recycleUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> recycleUuidNumber = new ArrayList<>();
                                    recycleUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("recycleUuidNumber",recycleUuidNumber);
                                }
                        }

                        //查询是否重复
                         //垃圾回收编号
                        List<RecycleEntity> recycleEntities_recycleUuidNumber = recycleService.selectList(new EntityWrapper<RecycleEntity>().in("recycle_uuid_number", seachFields.get("recycleUuidNumber")).eq("recycle_delete", 1));
                        if(recycleEntities_recycleUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RecycleEntity s:recycleEntities_recycleUuidNumber){
                                repeatFields.add(s.getrecycleUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [垃圾回收编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        recycleService.insertBatch(recycleList);
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


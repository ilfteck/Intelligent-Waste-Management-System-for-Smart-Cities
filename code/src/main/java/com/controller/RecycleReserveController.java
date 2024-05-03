
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
 * 垃圾出库申请
 * 后端接口
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
    private TransportService transportService;//运输
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private AnnouncementService announcementService;//公告
    @Autowired
    private RecycleService recycleService;//垃圾回收
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
        PageUtils page = recycleReserveService.queryPage(params);

        //字典表数据转换
        List<RecycleReserveView> list =(List<RecycleReserveView>)page.getList();
        for(RecycleReserveView c:list){
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
        RecycleReserveEntity recycleYuyue = recycleReserveService.selectById(id);
        if(recycleYuyue !=null){
            //entity转view
            RecycleReserveView view = new RecycleReserveView();
            BeanUtils.copyProperties( recycleYuyue , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            MemberEntity member = memberService.selectById(recycleYuyue.getmemberId());
            if(member != null){
            BeanUtils.copyProperties( member , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "memberId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setmemberId(member.getId());
            }
            //级联表 垃圾回收
            //级联表
            RecycleEntity recycle = recycleService.selectById(recycleYuyue.getrecycleId());
            if(recycle != null){
            BeanUtils.copyProperties( recycle , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "memberId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setrecycleId(recycle.getId());
            }
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
    public R save(@RequestBody RecycleReserveEntity recycleYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,recycleYuyue:{}",this.getClass().getName(),recycleYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            recycleYuyue.setmemberId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<RecycleReserveEntity> queryWrapper = new EntityWrapper<RecycleReserveEntity>()
            .eq("recycle_id", recycleYuyue.getrecycleId())
            .eq("member_id", recycleYuyue.getmemberId())
            .in("recycle_reserve_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RecycleReserveEntity recycleReserveEntity = recycleReserveService.selectOne(queryWrapper);
        if(recycleReserveEntity ==null){
            recycleYuyue.setrecycleYuyueYesnoTypes(1);
            recycleReserveService.insert(recycleYuyue);
            return R.ok();
        }else {
            if(recycleReserveEntity.getrecycleYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(recycleReserveEntity.getrecycleYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RecycleReserveEntity recycleYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,recycleYuyue:{}",this.getClass().getName(),recycleYuyue.toString());
        RecycleReserveEntity oldRecycleReserveEntity = recycleReserveService.selectById(recycleYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            recycleYuyue.setmemberId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            recycleReserveService.updateById(recycleYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody RecycleReserveEntity recycleReserveEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,recycleYuyueEntity:{}",this.getClass().getName(),
            recycleReserveEntity.toString());

        RecycleReserveEntity oldrecycleYuyue = recycleReserveService.selectById(recycleReserveEntity.getId());//查询原先数据

//        if(recycleYuyueEntity.getrecycleYuyueYesnoTypes() == 2){//通过
//            recycleYuyueEntity.setrecycleYuyueTypes();
//        }else if(recycleYuyueEntity.getrecycleYuyueYesnoTypes() == 3){//拒绝
//            recycleYuyueEntity.setrecycleYuyueTypes();
//        }
        recycleReserveEntity.setrecycleYuyueShenheTime(new Date());//审核时间
        recycleReserveService.updateById(recycleReserveEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<RecycleReserveEntity> oldrecycleYuyueList = recycleReserveService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        recycleReserveService.deleteBatchIds(Arrays.asList(ids));

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
            List<RecycleReserveEntity> recycleYuyueList = new ArrayList<>();//上传的东西
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
                            RecycleReserveEntity recycleReserveEntity = new RecycleReserveEntity();
//                            recycleYuyueEntity.setrecycleYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            recycleYuyueEntity.setrecycleId(Integer.valueOf(data.get(0)));   //垃圾回收 要改的
//                            recycleYuyueEntity.setmemberId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            recycleYuyueEntity.setrecycleYuyueText(data.get(0));                    //报名理由 要改的
//                            recycleYuyueEntity.setrecycletransportTime(sdf.parse(data.get(0)));          //出库时间 要改的
//                            recycleYuyueEntity.setrecycleYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            recycleYuyueEntity.setrecycleYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            recycleYuyueEntity.setrecycleYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            recycleYuyueEntity.setInsertTime(date);//时间
//                            recycleYuyueEntity.setCreateTime(date);//时间
                            recycleYuyueList.add(recycleReserveEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("recycleYuyueUuidNumber")){
                                    List<String> recycleYuyueUuidNumber = seachFields.get("recycleYuyueUuidNumber");
                                    recycleYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> recycleYuyueUuidNumber = new ArrayList<>();
                                    recycleYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("recycleYuyueUuidNumber",recycleYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<RecycleReserveEntity> recycleYuyueEntities_recycleYuyueUuidNumber = recycleReserveService.selectList(new EntityWrapper<RecycleReserveEntity>().in("recycle_reserve_uuid_number", seachFields.get("recycleYuyueUuidNumber")));
                        if(recycleYuyueEntities_recycleYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RecycleReserveEntity s:recycleYuyueEntities_recycleYuyueUuidNumber){
                                repeatFields.add(s.getrecycleYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        recycleReserveService.insertBatch(recycleYuyueList);
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


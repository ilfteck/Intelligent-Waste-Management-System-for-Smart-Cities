
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
 * transport
 * Back-end interface
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/transport")
public class TransportController {
    private static final Logger logger = LoggerFactory.getLogger(TransportController.class);

    @Autowired
    private TransportService transportService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;
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
    * back-end list
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page way:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"never enter");
        else if("User".equals(role))
            params.put("memberId",request.getSession().getAttribute("userId"));
        params.put("transportDeleteStart",1);params.put("transportDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = transportService.queryPage(params);

        //Dictionary table data conversion
        List<TransportView> list =(List<TransportView>)page.getList();
        for(TransportView c:list){
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
        TransportEntity transport = transportService.selectById(id);
        if(transport !=null){
            //entity to view
            TransportView view = new TransportView();
            BeanUtils.copyProperties( transport , view );//Refactor the entity data into the view
            //Refactor the entity data into the view
            RecycleReserveEntity recycleYuyue = recycleReserveService.selectById(transport.getrecycleYuyueId());
            if(recycleYuyue != null){
            BeanUtils.copyProperties( recycleYuyue , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//Refactor the entity data into the view
            view.setrecycleYuyueId(recycleYuyue.getId());
            }
            //Refactor the entity data into the view
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
    public R save(@RequestBody TransportEntity transport, HttpServletRequest request){
        logger.debug("saveway:,,Controller:{},,transport:{}",this.getClass().getName(),transport.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"never enter");

        Wrapper<TransportEntity> queryWrapper = new EntityWrapper<TransportEntity>()
            .eq("recycle_reserve_id", transport.getrecycleYuyueId())
            .eq("transport_name", transport.gettransportName())
            .eq("transport_address", transport.gettransportAddress())
            .eq("transport_types", transport.gettransportTypes())
            .eq("transport_mudi_address", transport.gettransportMudiAddress())
            .eq("transport_delete", transport.gettransportDelete())
            ;

        logger.info("sql language:"+queryWrapper.getSqlSegment());
        TransportEntity transportEntity = transportService.selectOne(queryWrapper);
        if(transportEntity ==null){
            transport.settransportDelete(1);
            transport.setInsertTime(new Date());
            transport.setCreateTime(new Date());
            transportService.insert(transport);
            return R.ok();
        }else {
            return R.error(511,"The table has the same data");
        }
    }

    /**
    * back-end change
    */
    @RequestMapping("/update")
    public R update(@RequestBody TransportEntity transport, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update way:,,Controller:{},,transport:{}",this.getClass().getName(),transport.toString());
        TransportEntity oldTransportEntity = transportService.selectById(transport.getId());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"never enter");
        if("".equals(transport.gettransportPhoto()) || "null".equals(transport.gettransportPhoto())){
                transport.settransportPhoto(null);
        }

            transportService.updateById(transport);
            return R.ok();
    }



    /**
    * delete
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TransportEntity> oldtransportList = transportService.selectBatchIds(Arrays.asList(ids));//delete data
        ArrayList<TransportEntity> list = new ArrayList<>();
        for(Integer id:ids){
            TransportEntity transportEntity = new TransportEntity();
            transportEntity.setId(id);
            transportEntity.settransportDelete(2);
            list.add(transportEntity);
        }
        if(list != null && list.size() >0){
            transportService.updateBatchById(list);
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
            List<TransportEntity> transportList = new ArrayList<>();//Batch upload
            Map<String, List<String>> seachFields= new HashMap<>();
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"The file has no suffix");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"Only excel files whose suffix is xls are supported");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//Only excel files whose suffix is xls are supported
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"Unable to find upload file, please contact administrator");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//Unable to find upload file, please contact administrator
                        dataList.remove(0);//Unable to find upload file, please contact administrator
                        for(List<String> data:dataList){
                            //ioop
                            TransportEntity transportEntity = new TransportEntity();
//                            transportEntity.setrecycleYuyueId(Integer.valueOf(data.get(0)));   
//                            transportEntity.settransportName(data.get(0));                    
//                            transportEntity.settransportUuidNumber(data.get(0));                    
//                            transportEntity.settransportPhoto("");
//                            transportEntity.settransportAddress(data.get(0));                   
//                            transportEntity.settransportTypes(Integer.valueOf(data.get(0)));   
//                            transportEntity.settransportMudiAddress(data.get(0));                    
//                            transportEntity.settransportContent("");
//                            transportEntity.settransportDelete(1);
//                            transportEntity.setInsertTime(date);
//                            transportEntity.setCreateTime(date);
                            transportList.add(transportEntity);


                            //Put the field you want to query for duplicates into the map
                                //number
                                if(seachFields.containsKey("transportUuidNumber")){
                                    List<String> transportUuidNumber = seachFields.get("transportUuidNumber");
                                    transportUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> transportUuidNumber = new ArrayList<>();
                                    transportUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("transportUuidNumber",transportUuidNumber);
                                }
                        }

                        //Put the field you want to query for duplicates into the map
                         //number
                        List<TransportEntity> transportEntities_transportUuidNumber = transportService.selectList(new EntityWrapper<TransportEntity>().in("transport_uuid_number", seachFields.get("transportUuidNumber")).eq("transport_delete", 1));
                        if(transportEntities_transportUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TransportEntity s:transportEntities_transportUuidNumber){
                                repeatFields.add(s.gettransportUuidNumber());
                            }
                            return R.error(511,"The [Transport number] field in the table of the database already exists:"+repeatFields.toString());
                        }
                        transportService.insertBatch(transportList);
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



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
 * User
 * Back-end interface
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/member")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;


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
    private RecycleReserveService recycleReserveService;
    @Autowired
    private UsersService usersService;


    /**
    * back-end list
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"Will never enter");
        else if("User".equals(role))
            params.put("memberId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = memberService.queryPage(params);

        //Dictionary table data conversion
        List<MemberView> list =(List<MemberView>)page.getList();
        for(MemberView c:list){
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
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MemberEntity member = memberService.selectById(id);
        if(member !=null){
            //entity to view
            MemberView view = new MemberView();
            BeanUtils.copyProperties( member , view );//Dictionary table data conversion
            //Dictionary table data conversion
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    *back-end save
    */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member, HttpServletRequest request){
        logger.debug("save way:,,Controller:{},,member:{}",this.getClass().getName(),member.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"Never enter");

        Wrapper<MemberEntity> queryWrapper = new EntityWrapper<MemberEntity>()
            .eq("username", member.getUsername())
            .or()
            .eq("member_phone", member.getmemberPhone())
            .or()
            .eq("member_id_number", member.getmemberIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MemberEntity memberEntity = memberService.selectOne(queryWrapper);
        if(memberEntity ==null){
            member.setCreateTime(new Date());
            member.setPassword("123456");
            memberService.insert(member);
            return R.ok();
        }else {
            return R.error(511,"The account or user's mobile phone number or user ID number has been used");
        }
    }

    /**
    * back-end change
    */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,member:{}",this.getClass().getName(),member.toString());
        MemberEntity oldMemberEntity = memberService.selectById(member.getId());//The account or user's mobile phone number or user ID number has been used
        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"no enter");
        if("".equals(member.getmemberPhoto()) || "null".equals(member.getmemberPhoto())){
                member.setmemberPhoto(null);
        }

            memberService.updateById(member);
            return R.ok();
    }



    /**
    * delete
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MemberEntity> oldmemberList = memberService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        memberService.deleteBatchIds(Arrays.asList(ids));

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
            List<MemberEntity> memberList = new ArrayList<>();//Batch upload
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
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//Only excel files whose suffix is xls are supported
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//Only excel files whose suffix is xls are supported
                        dataList.remove(0);//Only excel files whose suffix is xls are supported
                        for(List<String> data:dataList){
                            //loop
                            MemberEntity memberEntity = new MemberEntity();
//                            memberEntity.setUsername(data.get(0));                    
//                            //memberEntity.setPassword("123456");
//                            memberEntity.setmemberName(data.get(0));                    
//                            memberEntity.setmemberPhone(data.get(0));                   
//                            memberEntity.setmemberIdNumber(data.get(0));                    
//                            memberEntity.setmemberPhoto("");//详情和图片
//                            memberEntity.setSexTypes(Integer.valueOf(data.get(0)));   
//                            memberEntity.setmemberEmail(data.get(0));                   
//                            memberEntity.setCreateTime(date);
                            memberList.add(memberEntity);


                            //Put the field you want to query for duplicates into the map
                                //account
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));
                                    seachFields.put("username",username);
                                }
                                //User phone
                                if(seachFields.containsKey("memberPhone")){
                                    List<String> memberPhone = seachFields.get("memberPhone");
                                    memberPhone.add(data.get(0));
                                }else{
                                    List<String> memberPhone = new ArrayList<>();
                                    memberPhone.add(data.get(0));
                                    seachFields.put("memberPhone",memberPhone);
                                }
                                //User id
                                if(seachFields.containsKey("memberIdNumber")){
                                    List<String> memberIdNumber = seachFields.get("memberIdNumber");
                                    memberIdNumber.add(data.get(0));
                                }else{
                                    List<String> memberIdNumber = new ArrayList<>();
                                    memberIdNumber.add(data.get(0));
                                    seachFields.put("memberIdNumber",memberIdNumber);
                                }
                        }

                        // Query whether the query is repeated
                         //account
                        List<MemberEntity> memberEntities_username = memberService.selectList(new EntityWrapper<MemberEntity>().in("username", seachFields.get("username")));
                        if(memberEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MemberEntity s:memberEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"The [Account] field in the table of the database already exists:"+repeatFields.toString());
                        }
                         //User phone
                        List<MemberEntity> memberEntities_memberPhone = memberService.selectList(new EntityWrapper<MemberEntity>().in("member_phone", seachFields.get("memberPhone")));
                        if(memberEntities_memberPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MemberEntity s:memberEntities_memberPhone){
                                repeatFields.add(s.getmemberPhone());
                            }
                            return R.error(511,"The [phone] field in the table of the database already exists:"+repeatFields.toString());
                        }
                         //User id
                        List<MemberEntity> memberEntities_memberIdNumber = memberService.selectList(new EntityWrapper<MemberEntity>().in("member_id_number", seachFields.get("memberIdNumber")));
                        if(memberEntities_memberIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MemberEntity s:memberEntities_memberIdNumber){
                                repeatFields.add(s.getmemberIdNumber());
                            }
                            return R.error(511,"The User [ID Number] field in the table of the database already exists:"+repeatFields.toString());
                        }
                        memberService.insertBatch(memberList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"If data cannot be inserted in batches, contact the administrator");
        }
    }

    /**
    * login
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        MemberEntity member = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("username", username));
        if(member==null || !member.getPassword().equals(password))
            return R.error("The account or password is incorrect");
        String token = tokenService.generateToken(member.getId(),username, "member", "用户");
        R r = R.ok();
        r.put("token", token);
        r.put("role","User");
        r.put("username",member.getmemberName());
        r.put("tableName","member");
        r.put("userId",member.getId());
        return r;
    }

    /**
    * Sign in
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody MemberEntity member, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<MemberEntity> queryWrapper = new EntityWrapper<MemberEntity>()
            .eq("username", member.getUsername())
            .or()
            .eq("member_phone", member.getmemberPhone())
            .or()
            .eq("member_id_number", member.getmemberIdNumber())
            ;
        MemberEntity memberEntity = memberService.selectOne(queryWrapper);
        if(memberEntity != null)
            return R.error("The account or user's mobile phone number or user ID number has been used");
        member.setCreateTime(new Date());
        memberService.insert(member);

        return R.ok();
    }

    /**
     * Reset password
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        MemberEntity member = memberService.selectById(id);
        member.setPassword("123456");
        memberService.updateById(member);
        return R.ok();
    }

	/**
	 * change password
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        MemberEntity member = memberService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("The new password cannot be empty") ;
		}
		if(!oldPassword.equals(member.getPassword())){
			return R.error("The old password was entered incorrectly");
		}
		if(newPassword.equals(member.getPassword())){
			return R.error("The new password cannot be the same as the old password") ;
		}
        member.setPassword(newPassword);
		memberService.updateById(member);
		return R.ok();
	}



    /**
     * forget password
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        MemberEntity member = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("username", username));
        if(member!=null){
            member.setPassword("123456");
            memberService.updateById(member);
            return R.ok();
        }else{
           return R.error("Account does not exist");
        }
    }


    /**
    * Obtain session user information about the user
    */
    @RequestMapping("/session")
    public R getCurrmember(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        MemberEntity member = memberService.selectById(id);
        if(member !=null){
            //entity to view
            MemberView view = new MemberView();
            BeanUtils.copyProperties( member , view );//Refactor the entity data into the view
            //Refactor the entity data into the view
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"No data available");
        }
    }


    /**
    * quit
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("quit success");
    }



}



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
 * 用户
 * 后端接口
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
    private TransportService transportService;//运输
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private AnnouncementService announcementService;//公告
    @Autowired
    private RecycleService recycleService;//垃圾回收
    @Autowired
    private RecycleReserveService recycleReserveService;//垃圾出库申请
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
        PageUtils page = memberService.queryPage(params);

        //字典表数据转换
        List<MemberView> list =(List<MemberView>)page.getList();
        for(MemberView c:list){
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
        MemberEntity member = memberService.selectById(id);
        if(member !=null){
            //entity转view
            MemberView view = new MemberView();
            BeanUtils.copyProperties( member , view );//把实体数据重构到view中
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
    public R save(@RequestBody MemberEntity member, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,member:{}",this.getClass().getName(),member.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

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
            return R.error(511,"账户或者用户手机号或者用户身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,member:{}",this.getClass().getName(),member.toString());
        MemberEntity oldMemberEntity = memberService.selectById(member.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(member.getmemberPhoto()) || "null".equals(member.getmemberPhoto())){
                member.setmemberPhoto(null);
        }

            memberService.updateById(member);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MemberEntity> oldmemberList = memberService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        memberService.deleteBatchIds(Arrays.asList(ids));

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
            List<MemberEntity> memberList = new ArrayList<>();//上传的东西
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
                            MemberEntity memberEntity = new MemberEntity();
//                            memberEntity.setUsername(data.get(0));                    //账户 要改的
//                            //memberEntity.setPassword("123456");//密码
//                            memberEntity.setmemberName(data.get(0));                    //用户姓名 要改的
//                            memberEntity.setmemberPhone(data.get(0));                    //用户手机号 要改的
//                            memberEntity.setmemberIdNumber(data.get(0));                    //用户身份证号 要改的
//                            memberEntity.setmemberPhoto("");//详情和图片
//                            memberEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            memberEntity.setmemberEmail(data.get(0));                    //用户邮箱 要改的
//                            memberEntity.setCreateTime(date);//时间
                            memberList.add(memberEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //用户手机号
                                if(seachFields.containsKey("memberPhone")){
                                    List<String> memberPhone = seachFields.get("memberPhone");
                                    memberPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> memberPhone = new ArrayList<>();
                                    memberPhone.add(data.get(0));//要改的
                                    seachFields.put("memberPhone",memberPhone);
                                }
                                //用户身份证号
                                if(seachFields.containsKey("memberIdNumber")){
                                    List<String> memberIdNumber = seachFields.get("memberIdNumber");
                                    memberIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> memberIdNumber = new ArrayList<>();
                                    memberIdNumber.add(data.get(0));//要改的
                                    seachFields.put("memberIdNumber",memberIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<MemberEntity> memberEntities_username = memberService.selectList(new EntityWrapper<MemberEntity>().in("username", seachFields.get("username")));
                        if(memberEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MemberEntity s:memberEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //用户手机号
                        List<MemberEntity> memberEntities_memberPhone = memberService.selectList(new EntityWrapper<MemberEntity>().in("member_phone", seachFields.get("memberPhone")));
                        if(memberEntities_memberPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MemberEntity s:memberEntities_memberPhone){
                                repeatFields.add(s.getmemberPhone());
                            }
                            return R.error(511,"数据库的该表中的 [用户手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //用户身份证号
                        List<MemberEntity> memberEntities_memberIdNumber = memberService.selectList(new EntityWrapper<MemberEntity>().in("member_id_number", seachFields.get("memberIdNumber")));
                        if(memberEntities_memberIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MemberEntity s:memberEntities_memberIdNumber){
                                repeatFields.add(s.getmemberIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [用户身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        memberService.insertBatch(memberList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        MemberEntity member = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("username", username));
        if(member==null || !member.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(member.getId(),username, "member", "用户");
        R r = R.ok();
        r.put("token", token);
        r.put("role","用户");
        r.put("username",member.getmemberName());
        r.put("tableName","member");
        r.put("userId",member.getId());
        return r;
    }

    /**
    * 注册
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
            return R.error("账户或者用户手机号或者用户身份证号已经被使用");
        member.setCreateTime(new Date());
        memberService.insert(member);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        MemberEntity member = memberService.selectById(id);
        member.setPassword("123456");
        memberService.updateById(member);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        MemberEntity member = memberService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(member.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(member.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        member.setPassword(newPassword);
		memberService.updateById(member);
		return R.ok();
	}



    /**
     * 忘记密码
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
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrmember(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        MemberEntity member = memberService.selectById(id);
        if(member !=null){
            //entity转view
            MemberView view = new MemberView();
            BeanUtils.copyProperties( member , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



}


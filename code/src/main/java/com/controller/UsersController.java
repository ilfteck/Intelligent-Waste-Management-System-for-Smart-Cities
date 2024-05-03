
package com.controller;

import java.util.List;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.UsersEntity;
import com.service.TokenService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;

/**
 * login
 */
@RequestMapping("users")
@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private TokenService tokenService;

	/**
	 * log
	 */
	@IgnoreAuth
	@PostMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		UsersEntity user = usersService.selectOne(new EntityWrapper<UsersEntity>().eq("username", username));
		if(user==null || !user.getPassword().equals(password)) {
			return R.error("The account or password is incorrect");
		}
		String token = tokenService.generateToken(user.getId(),username, "users", user.getRole());
		R r = R.ok();
		r.put("token", token);
		r.put("role",user.getRole());
		r.put("userId",user.getId());
		return r;
	}
	
	/**
	 * Sign in
	 */
	@IgnoreAuth
	@PostMapping(value = "/register")
	public R register(@RequestBody UsersEntity user){
//    	ValidatorUtils.validateEntity(user);
    	if(usersService.selectOne(new EntityWrapper<UsersEntity>().eq("username", user.getUsername())) !=null) {
    		return R.error("User exists");
    	}
        usersService.insert(user);
        return R.ok();
    }

	/**
	 * end
	 */
	@GetMapping(value = "logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("Exit successfully");
	}

	/**
	 * change password
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
		UsersEntity users = usersService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("The new password cannot be empty") ;
		}
		if(!oldPassword.equals(users.getPassword())){
			return R.error("The old password was entered incorrectly");
		}
		if(newPassword.equals(users.getPassword())){
			return R.error("The new password cannot be the same as the old password") ;
		}
		users.setPassword(newPassword);
		usersService.updateById(users);
		return R.ok();
	}
	
	/**
     * Password reset
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	UsersEntity user = usersService.selectOne(new EntityWrapper<UsersEntity>().eq("username", username));
    	if(user==null) {
    		return R.error("Account does not exist");
    	}
    	user.setPassword("123456");
        usersService.update(user,null);
        return R.ok("Password has been reset to：123456");
    }
	
	/**
     * list
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,UsersEntity user){
        EntityWrapper<UsersEntity> ew = new EntityWrapper<UsersEntity>();
    	PageUtils page = usersService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, user), params), params));
        return R.ok().put("data", page);
    }

	/**
     * list
     */
    @RequestMapping("/list")
    public R list( UsersEntity user){
       	EntityWrapper<UsersEntity> ew = new EntityWrapper<UsersEntity>();
      	ew.allEq(MPUtil.allEQMapPre( user, "user")); 
        return R.ok().put("data", usersService.selectListView(ew));
    }

    /**
     * info
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        UsersEntity user = usersService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * Obtain session user information about the user
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Integer id = (Integer)request.getSession().getAttribute("userId");
        UsersEntity user = usersService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * save
     */
    @PostMapping("/save")
    public R save(@RequestBody UsersEntity user){
//    	ValidatorUtils.validateEntity(user);
    	if(usersService.selectOne(new EntityWrapper<UsersEntity>().eq("username", user.getUsername())) !=null) {
    		return R.error("User exists");
    	}
        usersService.insert(user);
        return R.ok();
    }

    /**
     * change
     */
    @RequestMapping("/update")
    public R update(@RequestBody UsersEntity user){
//        ValidatorUtils.validateEntity(user);
        usersService.updateById(user);//updaata
        return R.ok();
    }

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		List<UsersEntity> user = usersService.selectList(null);
		if(user.size() > 1){
			usersService.deleteBatchIds(Arrays.asList(ids));
		}else{
			return R.error("The administrator retains at least one");
		}
        return R.ok();
    }
}

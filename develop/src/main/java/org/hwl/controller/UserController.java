package org.hwl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hwl.bean.User;
import org.hwl.redis.RedisUtil;
import org.hwl.service.IUserService;
import org.hwl.util.HttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/login")
	public void loginPage(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam(value="name",required=true)String name,
			 @RequestParam(value="pwd",required=true)String pwd){
		User user=userService.getUserByName(name);
		if(user==null){
			flush(response, HttpCode.buildResult(HttpCode.STATE_ERROR, "用户不存在"));
		}else if(user.getPassword()!=pwd){
			flush(response, HttpCode.buildResult(HttpCode.STATE_ERROR, "密码错误"));
		}else{
			flush(response, HttpCode.buildResult(HttpCode.STATE_SUCCESS, null));
		}
	}
	@ResponseBody
	@RequestMapping("/add")
	public User addUser(){
		User u=new User();
		u.setPassword("1231231");
		u.setUsername("haifeng");
		u.setRole(123);
		return u;
	}
	
}

package org.hwl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hwl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/user")
public class UserController  {
	private static Logger logger= Logger.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/login")
	public void loginPage(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam(value="name",required=true)String name,
			 @RequestParam(value="pwd",required=true)String pwd){
	}
	
}

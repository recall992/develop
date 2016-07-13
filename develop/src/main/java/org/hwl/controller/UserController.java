package org.hwl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hwl.bean.User;
import org.hwl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private IUserService userService;

	@RequestMapping("/all")
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		flush(response, userService.getAllUsers());
	}
}

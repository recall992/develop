package org.hwl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 页面映射类
 * @author haifeng
 *
 */
@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
}

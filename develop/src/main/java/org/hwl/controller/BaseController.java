package org.hwl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class BaseController {
	protected void flush(HttpServletResponse response,Object data){
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.print(JSON.toJSONString(data));
			out.flush();
			out.close();
		}
	}
}

package org.hwl.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.hwl.util.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/upload")
public class FileUploadController {
	private static final long serialVersionUID = 1L;
	
	
	@RequestMapping("/upfile")
	public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");  
		String key=request.getParameter("key");
	    //String key = Integer.toString(request.hashCode());  
	    request.getSession().setAttribute("key", key);
        PrintWriter out = response.getWriter();  
        FileUpload fu=new FileUpload();  
        fu.setMap(request,key);//解析request  
        Map<String,FileItem> files=fu.getFiles();  
        String fileName =fu.getFileName(files.get("file"));  
        File file=new File(request.getServletContext().getRealPath("upload\\"+fileName));  
        try {  
            files.get("file").write(file);  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        out.println("<script>parent.uploadSuccess();</script>");  
	}
	@RequestMapping("/progress")
	public void getProgress(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");  
        PrintWriter out = response.getWriter();  
        HttpSession session=request.getSession();  
        String key = (String) request.getSession().getAttribute("key");
        String status=(String) session.getAttribute(key);//获取上传进度百分比  
        out.println(status);//响应  
	}
}

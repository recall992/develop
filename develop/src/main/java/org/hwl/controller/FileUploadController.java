package org.hwl.controller;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.hwl.util.FileListener;
import org.hwl.util.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/upload")
public class FileUploadController {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(FileUploadController.class);
	// 文件保存地址
	private static final String savePath = "upload" + File.separator + "log";
	// 缓存保存地址
	private static final String tempPath = "upload" + File.separator + "temp";
	// 最大上传文件大小
	private static final int maxSize = 10000;// MB
	// 最大缓存
	private static final int memorySize = 5;// MB
	
	
	@RequestMapping("/upfile")
	public void uploadFile(HttpServletRequest request, HttpServletResponse response){
		String basePath=request.getSession().getServletContext().getRealPath("/");
		String appName,discribe;
		// 判断表单是否是Multipart类型的。这里可以直接对request进行判断
		if (ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(memorySize * 1024 * 1024);
			factory.setRepository(new File(basePath+tempPath));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxSize * 1024 * 1024);
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				return;
			}
			Iterator<FileItem> it = items.iterator();
			FileUpload xfFileUpload=new FileUpload();
			xfFileUpload.setSessionid(request.getSession().getId());
			FileListener listener=new FileListener(xfFileUpload);
			//upload.setProgressListener(progressListener);
			// 设置上传文件记录
			while (it.hasNext()) {
				FileItem item = it.next();
				// 是文件
				if (!item.isFormField()) {
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					// 存储的文件
					String saveName = UUID.randomUUID().toString() + fileName;
					File uploadedFile = new File(basePath+savePath, saveName);
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					long sizeInBytes = item.getSize();
					try {
						item.write(uploadedFile);
					} catch (Exception e) {
						return;
					}
				} 
			}
			
			
			
		}
	}
}

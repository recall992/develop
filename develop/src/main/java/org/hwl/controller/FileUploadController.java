package org.hwl.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hwl.util.upload.UploadListener;
import org.hwl.util.upload.UploadProgress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload")
public class FileUploadController extends BaseController{

	// 文件保存地址
	private static final String savePath = "upload";
	@RequestMapping("/upfile")
	public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String basePath=request.getSession().getServletContext().getRealPath("/");
		// 判断表单是否是Multipart类型的。这里可以直接对request进行判断
		if (ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setProgressListener(new UploadListener(request.getSession()));
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				return;
			}
			Iterator<FileItem> it = items.iterator();
			while (it.hasNext()) {
				FileItem item = it.next();
				// 是文件
				if (!item.isFormField()) {
					String fileName = item.getName();
					// 存储的文件
					String saveName = UUID.randomUUID().toString() + fileName;
					File uploadedFile = new File(basePath+savePath, saveName);
					try {
						item.write(uploadedFile);
					} catch (Exception e) {
					}
				} 
			}
		}
	}

	@RequestMapping("/progress")
	public void getProgress(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
		UploadProgress progress=(UploadProgress) request.getSession().getAttribute(request.getSession().getId());
		flush(response, progress);
	}
}

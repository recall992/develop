package org.hwl.util.upload;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;


public class UploadListener implements ProgressListener {

	private HttpSession session;

	public static Map<String,UploadProgress> map=new HashMap<>();
	public UploadListener(HttpSession session) {
		super();
		this.session = session;
	}

	public void update(long pBytesRead, long pContentLength, int pItems) {
			UploadProgress progress=new UploadProgress();
			String key=this.session.getId();
			progress.setKey(this.session.getId());
			progress.setRead(pBytesRead);
			progress.setLength(pContentLength);
			progress.setItem(pItems);
			if(pBytesRead==pContentLength){
				progress.setIsComplete(true);
			}
			map.put(key, progress);
			this.session.setAttribute(key, progress);
	}

}

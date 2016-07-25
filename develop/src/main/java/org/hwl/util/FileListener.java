package org.hwl.util;

import org.apache.commons.fileupload.ProgressListener;

public class FileListener implements ProgressListener{
	private FileUpload uploadFile=null;
	
	public FileListener(FileUpload uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public void update(long pBytesRead, long pContentLength, int pItems) {
		uploadFile.setRead(pBytesRead);
		uploadFile.setLength(pContentLength);
		System.out.println(pBytesRead/pContentLength*100);
	}

}

package org.hwl.util.upload;

/**
 * 断点续传工具类
 * @author haifeng
 *
 */
public class ResumeUpload {
	private String key;
	private long read;
	private long contentLength;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public long getRead() {
		return read;
	}
	public void setRead(long read) {
		this.read = read;
	}
	public long getContentLength() {
		return contentLength;
	}
	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}
	public ResumeUpload(String key, long read, long contentLength) {
		super();
		this.key = key;
		this.read = read;
		this.contentLength = contentLength;
	}
	
}

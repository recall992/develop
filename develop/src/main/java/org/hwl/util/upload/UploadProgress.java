package org.hwl.util.upload;

public class UploadProgress {

	private String key;
	private int item;
	private long read;
	private long length;
	private Boolean isComplete=false;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public long getRead() {
		return read;
	}
	public void setRead(long read) {
		this.read = read;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public Boolean getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
	public UploadProgress(String key, int item, long read, long length, Boolean isComplete) {
		super();
		this.key = key;
		this.item = item;
		this.read = read;
		this.length = length;
		this.isComplete = isComplete;
	}
	public UploadProgress() {
		super();
	}
	@Override
	public String toString() {
		return "UploadProgress [key=" + key + ", item=" + item + ", read=" + read + ", length=" + length
				+ ", isComplete=" + isComplete + "]";
	}
	
}

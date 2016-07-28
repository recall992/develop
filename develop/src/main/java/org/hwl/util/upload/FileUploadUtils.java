package org.hwl.util.upload;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class FileUploadUtils {
	public static int block_size = 1024 * 1024 * 10;

	public byte[] readFile(long offset, String filePath) {
		RandomAccessFile randomAccessFile = null;
		try {
			// 初使化这个文件
			randomAccessFile = new RandomAccessFile(filePath, "r");
			byte[] temByte = null;
			// 判断传入的指针是否比总文件长度还要长，只要小于文件长度，才是正常的
			if (offset < randomAccessFile.length()) {
				// 把指针移到要开始的字节位置
				randomAccessFile.seek(offset);
				// 这里是做一个判断，判断从这个位置开始读取，读取这个长度，是否已经超过了文件的长度,一般情况下，我们的块的
				// 长度是固定的，比如1M，而对于一个10.5M的文件，要分11包，当读最后一个包的时候，就会出现这种情况
				if (offset + block_size > randomAccessFile.length()) {
					// 如果已经超过了文件的长度，初使化字节数组的时候，就用文件长度减去指针的位置
					temByte = new byte[((int) (randomAccessFile.length() - offset))];
					// 这个方法 ，会读取字节长度的数据，然后把数据存储到字节数组
					randomAccessFile.read(temByte);
				} else {
					// 如果我们要读的一个块的长度，没有超过文件的长度，那就把字节数组初始化为块的长度
					temByte = new byte[(int) block_size];
					randomAccessFile.read(temByte);
				}

				return temByte;
			}
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		} finally {
			if (randomAccessFile != null) {
				try {
					// 关闭文件流
					randomAccessFile.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	}
	public static void main(String[] args) throws FileNotFoundException {
		RandomAccessFile accessFile=new RandomAccessFile("text.txt", "rw");
		for(int i=0;i<10;i++){
			try {
				accessFile.writeInt(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			accessFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		accessFile=new RandomAccessFile("text.txt", "rw");
	}
}
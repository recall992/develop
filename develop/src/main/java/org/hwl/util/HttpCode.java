package org.hwl.util;

import java.util.HashMap;
import java.util.Map;

/**
 * http
 * 
 * @author haifeng
 *
 */
public class HttpCode {
	/**
	 * 成功
	 */
	public final static int STATE_SUCCESS = 200;
	/**
	 * 失败
	 */
	public final static int STATE_ERROR = 500;
	/**
	 * 无权限
	 */
	public final static int STATE_AUTH = 480;
	
	
	
	public static Map<String,Object> buildResult(int state,Object obj){
		Map<String,Object> map=new HashMap<>();
		map.put("state", state);
		if(obj!=null){
			map.put("msg", obj);
		}
		return map;
	}
}

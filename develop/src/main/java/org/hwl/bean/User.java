package org.hwl.bean;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8634075459491215197L;
	private int id;
	private String username;
	private String password;
	private String createtime;
	private int role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public User(int id, String username, String password, String createtime, int role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createtime = createtime;
		this.role = role;
	}
	public User() {
		super();
	}
	
}

package org.hwl.mongo;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7872964528592803963L;
	private int _id;
	private String name;
	private String address;
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(int _id, String name, String address) {
		super();
		this._id = _id;
		this.name = name;
		this.address = address;
	}
	public User() {
		super();
	}
	
}

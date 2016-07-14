package org.hwl.dao;

import java.util.List;
import java.util.Map;

import org.hwl.bean.User;

public interface UserDao {
	public List<User> getAllUser();

	public void addUser(User user);

	public User getUserById(int id);

	public User getUserByName(String name);

	public List<Map> getAll();

}

package org.hwl.dao;

import java.util.List;

import org.hwl.bean.User;

public interface UserDao {
	public List<User> getUserListByName(String name);

	public User getUserByName(String name);

	public User getUserById(int id);

	public void delUser(int id);

	public void updateUser(User user);

	public void addUser(User user);
}

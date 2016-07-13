package org.hwl.service;

import java.util.List;

import org.hwl.bean.User;

public interface IUserService {
	public List<User> getAllUsers();
	public void addUser(User user);

	public User getUserById(int id);

	public User getUserByName(String name);
}

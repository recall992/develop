package org.hwl.service.impl;

import java.util.List;
import java.util.Map;

import org.hwl.bean.User;
import org.hwl.dao.UserDao;
import org.hwl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userdao;

	@Override
	public List<User> getAllUsers() {
		return userdao.getAllUser();
	}
	public void addUser(User user){
		userdao.addUser(user);
	}

	public User getUserById(int id){
		return userdao.getUserById(id);
	}

	public User getUserByName(String name){
		return userdao.getUserByName(name);
	}
	@Override
	public List<Map> getAll() {
		return userdao.getAll();
	}
}

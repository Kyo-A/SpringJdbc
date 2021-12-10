package org.eclipse.firstspringmvc.service;

import java.util.List;

import org.eclipse.firstspringmvc.dao.UserDao;
import org.eclipse.firstspringmvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public User getUser(int id) {
		return userDao.getUserById(id);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();

	}

	public int addUser(User user) {
		return userDao.addUser(user);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

}

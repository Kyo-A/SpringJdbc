package org.eclipse.firstspringmvc.service;

import java.util.List;

import org.eclipse.firstspringmvc.models.User;

public interface UserService {
	
	public User getUser(int id);
	public List<User> getAllUsers();
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(int id);

}

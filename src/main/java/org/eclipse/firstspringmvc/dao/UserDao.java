package org.eclipse.firstspringmvc.dao;

import java.util.List;

import org.eclipse.firstspringmvc.models.User;

public interface UserDao {
	
	public User getUserById(int id);
	
	public List<User> getAllUsers();
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(int id);

}

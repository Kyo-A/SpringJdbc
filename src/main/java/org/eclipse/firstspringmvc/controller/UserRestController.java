package org.eclipse.firstspringmvc.controller;

import org.eclipse.firstspringmvc.models.User;
import org.eclipse.firstspringmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces="application/json")
	public String getUserDetail(@PathVariable int id) {
		return userService.getUser(id).toString();
	}
	@RequestMapping(value = "/users", method = RequestMethod.GET,produces="application/json")
	public String getUsers() {
		return userService.getAllUsers().toString();
	}
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public int addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return "user deleted";
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable("id") int id, @RequestBody User user) {
		user.setId(id);
		userService.updateUser(user);
		return "user updated";
	}
}

package org.eclipse.firstspringmvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.firstspringmvc.models.User;
import org.eclipse.firstspringmvc.utils.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public User getUserById(int id) {
		User user = (User) jdbcTemplate.queryForObject("select * from users where id = ?",
				new Object[] { id }, new UserRowMapper());
		return user;
	}
	@Transactional
	public List<User> getAllUsers() {
		List<User> users = (List<User>) jdbcTemplate.query("select * from users",
				new UserRowMapper());
		return users;
	}
	@Transactional
	public int addUser(User user) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("users").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(3);
		parameters.put("first_name", user.getFirstName());
		parameters.put("last_name", user.getLastName());
		parameters.put("email", user.getEmail());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}
	@Transactional
	public int updateUser(User user) {
		String sql = "update users set first_name = ?, last_name = ?, email = ? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getId() });
		return resp;
	}
	@Transactional
	public int deleteUser(int id) {
		int resp = jdbcTemplate.update("delete from users where id = ?", id);
		return resp;
	}

}

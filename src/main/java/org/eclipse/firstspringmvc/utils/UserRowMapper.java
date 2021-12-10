package org.eclipse.firstspringmvc.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.firstspringmvc.models.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		return user;
	}

}

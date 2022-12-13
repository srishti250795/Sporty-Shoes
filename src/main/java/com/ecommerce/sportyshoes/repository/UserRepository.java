package com.ecommerce.sportyshoes.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportyshoes.enums.UserType;
import com.ecommerce.sportyshoes.exceptions.BusinessException;
import com.ecommerce.sportyshoes.model.User;

@Repository
public class UserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user=new User();
			user.setID(rs.getLong("id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setMobile(rs.getString("mobile"));
			user.setPassword(rs.getString("password"));
			user.setUserType(UserType.getUserType(rs.getString("user_type")));
			user.setCreatedAt(rs.getDate("created_at"));
			user.setUpdatedAt(rs.getDate("updated_at"));
			
			return user;
		}
	}
	public List<User> findAll() throws BusinessException{
	try {
		return jdbcTemplate.query("select * from users",new UserRowMapper());}
		catch (Exception exception) {
		throw new BusinessException("Internal Error Occured "+exception.getMessage());
		}
				
		}

	public Optional<User> findByEmail(String email) throws BusinessException{
		try {
		return Optional.of(jdbcTemplate.queryForObject("select * from users where email=?", 
				new Object[] {email}, new BeanPropertyRowMapper<User>(User.class)));}
		catch (Exception exception) {
			throw new BusinessException("Internal Error Occured "+exception.getMessage());
			}
			
			}
	
	public int createUser(User user) throws BusinessException {
		try {

			
		return jdbcTemplate.update("insert into users( first_name,last_name, email,password, mobile) values(?,?,?,?,?)", 
				new Object[] {user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),user.getMobile()});
		}
		catch (Exception exception) {
			throw new BusinessException("Internal Error Occured "+exception.getMessage());
			}
			}
	
	public int updateUser(User user) throws BusinessException {
		try {
			return jdbcTemplate.update("update users "
					+ "set first_name=ifnull(?,first_name), "
					+ "last_name=ifnull(?,last_name), "
					+ "password=ifnull(?,password) where email=?", 
					new Object[] {user.getFirstName(),user.getLastName(),user.getPassword(),user.getEmail()});
			}
			catch (Exception exception) {
				throw new BusinessException("Internal Error Occured "+exception.getMessage());
				}
			}
	
	public int deleteUser(String email) throws BusinessException {
		try {
			return jdbcTemplate.update("delete from users where email=?", new Object[] {email});}
			catch (Exception exception) {
				throw new BusinessException("Internal Error Occured "+exception.getMessage());
				}
			}
	
}

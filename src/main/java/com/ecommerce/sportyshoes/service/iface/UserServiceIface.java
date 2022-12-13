package com.ecommerce.sportyshoes.service.iface;

import java.util.List;
import java.util.Optional;

import com.ecommerce.sportyshoes.exceptions.BusinessException;
import com.ecommerce.sportyshoes.model.User;

public interface UserServiceIface {
	
	public int updateUser(User userDataInput) throws BusinessException;
	
	public List<User> getAllUsers() throws BusinessException;
	
	public Optional<User> getUserByEmail(User userDataInput) throws BusinessException;

	public int createUser(User userDataInput) throws BusinessException;
	
	public int deleteUser(User userDataInput) throws BusinessException;

}

package com.ecommerce.sportyshoes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sportyshoes.exceptions.BusinessException;
import com.ecommerce.sportyshoes.model.User;
import com.ecommerce.sportyshoes.repository.UserRepository;
import com.ecommerce.sportyshoes.service.iface.UserServiceIface;

@Service
public class UserServiceImpl implements UserServiceIface{
	
	@Autowired
	UserRepository userRepository;
	
	public int updateUser(User userDataInput) throws BusinessException {
		User user = new User();
		user.setFirstName(userDataInput.getFirstName());
		user.setLastName(userDataInput.getLastName());
		user.setPassword(userDataInput.getPassword());
		user.setEmail(userDataInput.getEmail());
		return userRepository.updateUser(user);
	}
	
	public List<User> getAllUsers() throws BusinessException{
		return userRepository.findAll();
	}
	
	public Optional<User> getUserByEmail(User userDataInput) throws BusinessException{
		return userRepository.findByEmail(userDataInput.getEmail());
	}

	public int createUser(User userDataInput) throws BusinessException {
		
		return userRepository.createUser(userDataInput);
	}
	
	public int deleteUser(User userDataInput) throws BusinessException {
		
		return userRepository.deleteUser(userDataInput.getEmail());
	}
	
}

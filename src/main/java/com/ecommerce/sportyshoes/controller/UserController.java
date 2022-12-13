package com.ecommerce.sportyshoes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sportyshoes.exceptions.BusinessException;
import com.ecommerce.sportyshoes.model.User;
import com.ecommerce.sportyshoes.service.iface.UserServiceIface;

@RestController
@RequestMapping("/user")
public class UserController {
   
	@Autowired
	UserServiceIface userServiceIface;
	
	@PutMapping(value = "updateUser")
	public int updateUser(@RequestBody User userDataInput) throws BusinessException {
		return userServiceIface.updateUser(userDataInput);
	}
	
	@GetMapping(value = "getAllUsers")
	public List<User> getAllUsers() throws BusinessException{
		return userServiceIface.getAllUsers();
	}
	
	@GetMapping(value = "/getUserByEmail")
	public Optional<User> getUserByEmail(@RequestBody User userDataInput) throws BusinessException{
		return userServiceIface.getUserByEmail(userDataInput);
	}
	
	@PutMapping(value = "createUser")
	public int createUser(@RequestBody User userDataInput) throws BusinessException {
		return userServiceIface.createUser(userDataInput);
	}
	
	@PutMapping(value = "deleteUser")
	public int deleteUser(@RequestBody User userDataInput) throws BusinessException {
		return userServiceIface.deleteUser(userDataInput);
	}


}

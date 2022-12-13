package com.ecommerce.sportyshoes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.sportyshoes.exceptions.BusinessException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<Object> exception(BusinessException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
	}

}

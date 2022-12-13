package com.ecommerce.sportyshoes.exceptions;

public class BusinessException extends Exception{

	private String message;
	public BusinessException(String message) {
		this.message=message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -851150852212525045L;

}

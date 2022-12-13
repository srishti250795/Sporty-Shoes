package com.ecommerce.sportyshoes.enums;

public enum UserType {
	ADMIN,NORMAL;
	
	public static UserType getUserType(String userTypeString) {
    	return UserType.valueOf(userTypeString);
    }

}

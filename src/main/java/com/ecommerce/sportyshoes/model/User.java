package com.ecommerce.sportyshoes.model;

import java.util.Date;

import com.ecommerce.sportyshoes.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
private Long iD;
private String firstName;
private String lastName;
private String email;
private String mobile;
private String password;
private UserType userType;
private Date createdAt;
private Date updatedAt;
}

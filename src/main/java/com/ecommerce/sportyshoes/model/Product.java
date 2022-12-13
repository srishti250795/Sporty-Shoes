package com.ecommerce.sportyshoes.model;

import java.util.Date;

import com.ecommerce.sportyshoes.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
private long id;
private String name;
private String description;
private long price;
private long availability;
private Category category;
private Date createdAt;
private Date updatedAt;
}

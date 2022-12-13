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
public class Purchase {
private long id;
private long user_id;
private long product_id;
private Category category;
private int quantity;
private Date createdAt;
private Date updatedAt;
}

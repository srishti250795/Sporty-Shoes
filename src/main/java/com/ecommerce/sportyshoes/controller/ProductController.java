package com.ecommerce.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sportyshoes.exceptions.BusinessException;
import com.ecommerce.sportyshoes.model.Product;
import com.ecommerce.sportyshoes.service.iface.ProductServiceIface;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductServiceIface productServiceIface;
	
	@PutMapping("/update")
	public int updateProduct(@RequestBody Product prodDataInput) throws BusinessException {
		return productServiceIface.updateProduct(prodDataInput);
		
	}
	
	@PutMapping("/create")
	public int createProduct(@RequestBody Product prodDataInput) throws BusinessException {
		return productServiceIface.createProduct(prodDataInput);
		
	}
	
	@PutMapping("/delete")
	public int deleteProduct(@RequestBody Product prodDataInput) throws BusinessException {
		return productServiceIface.deleteProduct(prodDataInput);
		
	}
	
	@GetMapping("/getByCategory")
	public List<Product> getByCategory(@RequestBody Product prodDataInput) throws BusinessException{
		return productServiceIface.getProdByCategory(prodDataInput);
	}
	
	
	
}

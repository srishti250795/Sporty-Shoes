package com.ecommerce.sportyshoes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sportyshoes.exceptions.BusinessException;
import com.ecommerce.sportyshoes.model.Product;
import com.ecommerce.sportyshoes.repository.ProductRepository;
import com.ecommerce.sportyshoes.service.iface.ProductServiceIface;

@Service
public class ProductServiceImpl implements ProductServiceIface{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public int updateProduct(Product prodDataInput) throws BusinessException {
		Product product = new Product();
		product.setId(prodDataInput.getId());
		product.setAvailability(prodDataInput.getAvailability());
		product.setPrice(prodDataInput.getPrice());
		
		return productRepository.updateProduct(product);
	}

	@Override
	public int createProduct(Product prodDataInput) throws BusinessException {
		// TODO Auto-generated method stub
		return productRepository.createProduct(prodDataInput);
	}

	@Override
	public int deleteProduct(Product prodDataInput) throws BusinessException {
		// TODO Auto-generated method stub
		return productRepository.deleteProduct(prodDataInput.getId());
	}

	@Override
	public List<Product> getProdByCategory(Product prodDataInput) throws BusinessException {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(prodDataInput.getCategory().toString());
	}

	@Override
	public Optional<Product> getPodById(Product prodDataInput) throws BusinessException {
		// TODO Auto-generated method stub
		return productRepository.findById(prodDataInput.getId());
	}

}

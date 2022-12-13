package com.ecommerce.sportyshoes.service.iface;

import java.util.List;
import java.util.Optional;

import com.ecommerce.sportyshoes.exceptions.BusinessException;
import com.ecommerce.sportyshoes.model.Product;

public interface ProductServiceIface {
public int updateProduct(Product prodDataInput) throws BusinessException;

public int createProduct(Product prodDataInput) throws BusinessException;

public int deleteProduct(Product prodDataInput) throws BusinessException;

public List<Product> getProdByCategory(Product prodDataInput) throws BusinessException;

public Optional<Product> getPodById(Product prodDataInput) throws BusinessException;

}

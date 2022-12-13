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
import com.ecommerce.sportyshoes.model.Purchase;
import com.ecommerce.sportyshoes.service.iface.PurchaseServiceIface;

@RestController
@RequestMapping ("/purchase")
public class PurchaseController {

	@Autowired
	PurchaseServiceIface purchaseServiceIface;
	
	@PutMapping("/createsale")
	public int createSale(@RequestBody Purchase purchaseDataInput) throws BusinessException
	{
		return purchaseServiceIface.createSale(purchaseDataInput);
	}

	@PutMapping("/deletesale")
	public int deleteSale(@RequestBody Purchase purchaseDataInput) throws BusinessException
	{
		return purchaseServiceIface.deleteSale(purchaseDataInput);
	}
	
	@GetMapping("/getById")
	public Optional<Purchase> getById(@RequestBody Purchase purchaseDataInput) throws BusinessException{
		return purchaseServiceIface.getPurchaseById(purchaseDataInput);
	}
	
	@GetMapping("/getByDateCategory")
	public List<Purchase> getByDateCategory(@RequestBody Purchase purchaseDataInput) throws BusinessException{
		return purchaseServiceIface.getByDateCategory(purchaseDataInput);
	}
}

package com.example.boot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.dao.ProductDao;
import com.example.boot.domain.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public Product getProduct(long id) {
		return productDao.getProduct(id);
	}
	
	@Transactional
	public long saveProduct(Product product) {
		throw new RuntimeException("Just an exception !!!");
		//return productDao.saveProduct(product);
	}

}

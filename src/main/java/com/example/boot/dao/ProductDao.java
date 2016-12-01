package com.example.boot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.boot.domain.Product;

@Repository
public class ProductDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Product getProduct(long id) {
		return entityManager.find(Product.class, id);
	}

	public long saveProduct(Product product) {
		entityManager.persist(product);
		return product.getId();
	}

}

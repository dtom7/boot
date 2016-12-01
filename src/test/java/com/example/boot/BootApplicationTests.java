package com.example.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.boot.BootApplication;
import com.example.boot.domain.Product;
import com.example.boot.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={BootApplication.class})
public class BootApplicationTests {
	
	@Autowired
	private ProductService productService;
	
	

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSaveProduct() {
		Product product = new Product();
		
		product.setCode("1234");
		product.setName("Toys");
		
		productService.saveProduct(product);
	}
	
	
	
	

}

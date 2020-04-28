/**
 * 
 */
package com.project.spacehub.repository.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.spacehub.models.Product;
import com.project.spacehub.models.ProductStatus;
import com.project.spacehub.models.StatusName;
import com.project.spacehub.repository.ProductRepository;
import com.project.spacehub.repository.RepositoryConfig;

/**
 * @author gbemisola
 *
 */
@SpringBootTest(classes = RepositoryConfig.class)
class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository repo;

	@Test
	void test() {
		ProductStatus status = new ProductStatus(StatusName.VACANT);
		Product product = new Product("safe","3pple",80.00,"/image",status);
		
		
		repo.save(product);
	}

}

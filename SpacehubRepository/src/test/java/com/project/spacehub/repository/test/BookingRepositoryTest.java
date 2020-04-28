/**
 * 
 */
package com.project.spacehub.repository.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.spacehub.models.Booking;
import com.project.spacehub.models.Product;
import com.project.spacehub.models.ProductStatus;
import com.project.spacehub.models.SpaceHubUser;
import com.project.spacehub.models.StatusName;
import com.project.spacehub.repository.BookingRepository;
import com.project.spacehub.repository.ProductRepository;
import com.project.spacehub.repository.RepositoryConfig;
import com.project.spacehub.repository.SpacehubUserRepository;

/**
 * @author gbemisola
 *
 */
@SpringBootTest(classes = RepositoryConfig.class)
class BookingRepositoryTest {

	
	@Autowired
	private BookingRepository bk;
	
	@Autowired
	private ProductRepository prepo;
	
	@Autowired
	private SpacehubUserRepository userprepo;
	
	
//	@Test
//	void saveBookingTest() {
//
//		ProductStatus statusx = new ProductStatus(1, StatusName.VACANT);
//		Product product1 = new Product("safe","3pple",80.00,"/image",statusx);
//
//		prepo.save(product1);
//
//
//		SpaceHubUser user = new SpaceHubUser("ge@goole.com","123","gbemi","google","1234566");
//
//		userprepo.save(user);
//
//
//		Booking book = new Booking("gby@goole.com","gbemi",product1,user);
//
//
//		bk.save(book);
//
//
//	}

}

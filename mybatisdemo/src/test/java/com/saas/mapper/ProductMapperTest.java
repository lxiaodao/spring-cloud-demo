/**
 * 
 */
package com.saas.mapper;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.saas.domain.Product;


/**
 * @author yangliu
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {
	
	@Autowired
	ProductMapper mapper;
	
	@Test
	public void test_insert() {
		 Product p=new Product();
	        p.setName("iphone 7");
	        BigDecimal bd=new BigDecimal(230.5);
		int number=mapper.insert(p);
		Assert.assertEquals(1, number);
	}
	@Test
	public void test_insertAndReturnKey() {
		 Product p=new Product();
	        p.setName("iphone 6s");
	        BigDecimal bd=new BigDecimal(230.5);
		Integer key=mapper.insertAndReturnKey(p);
		System.out.println("=============the key is============"+key);
		Assert.assertTrue(key!=null);
	}

}

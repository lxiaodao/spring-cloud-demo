/**
 * 
 */
package com.saas.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.saas.domain.ProductType;

/**
 * @author yangliu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTypeMapperTest {
	
	@Autowired
	ProductTypeMapper tymapper;
	
	@Test
	public void test_insertandreturnkey() {
		
		  ProductType ty=new ProductType();
	        ty.setName("Apple");
	        
	        Integer typeid=tymapper.insertAndReturnKey(ty);	
	        Assert.assertTrue(typeid!=null);
	        Assert.assertTrue(typeid!=-1);
	}
	
	

}

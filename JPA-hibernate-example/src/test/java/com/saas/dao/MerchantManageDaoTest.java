/**
 * 
 */
package com.saas.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.saas.domain.Product;
import com.saas.domain.ProductType;
import com.saas.dto.ProductWithTypeName;

/**
 * @author yangliu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchantManageDaoTest {
	
	@Autowired
	MerchantManageDao mmdao;
	
	static Integer pid;
	static Integer typeid;
	 @Before
	 public void init() {
		 
		 Product p=new Product();
	        p.setName("iphone 7");
	        BigDecimal bd=new BigDecimal(230.5);	        
	        p.setCostPrice(bd);
	        
	        ProductType ty=new ProductType();
	        ty.setName("Apple");
	        Product pin=mmdao.createProductAndType(p, ty);
	        //
	        pid=pin.getId();
	        typeid=pin.getProductTypeBean().getId();
	        System.out.println("------------------this is return------------------"+typeid);
		 
	 }
	 @After
	 public void destory() {
	       mmdao.delete(Product.class, pid);
	       mmdao.delete(Product.class, typeid);
	 }
	
	@Test
	public void test_native_query_entityManager() {
		//
		List<ProductWithTypeName> pList=mmdao.queryProduct("", "");
		Assert.assertTrue(!pList.isEmpty());
		Assert.assertEquals(pid, pList.get(0).getProdectId());
	}

}

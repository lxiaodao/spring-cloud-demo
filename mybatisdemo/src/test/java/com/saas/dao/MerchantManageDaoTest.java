/**
 * 
 */
package com.saas.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.Logger;
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
import com.saas.mapper.ProductMapper;
import com.saas.mapper.ProductTypeMapper;

import lombok.extern.log4j.Log4j2;

/**
 * @author yangliu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Log4j2
public class MerchantManageDaoTest {
	
	@Autowired
	MerchantManageDao mmdao;
	
	@Autowired
	ProductMapper mapper;
	
	@Autowired
	ProductTypeMapper type_mapper;
	
	static Integer pid;
	static Integer typeid;
	private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(MerchantManageDaoTest.class);
	 @Before
	 public void init() {
		 
		 
	       
	        
	        ProductType ty=new ProductType();
	        ty.setName("Apple");
	        
	        typeid=type_mapper.insertAndReturnKey(ty);	        
	        
	        Product p=new Product();
	        p.setName("iphone 7");
	        BigDecimal bd=new BigDecimal(230.5);	        
	        p.setCostPrice(bd);
	        p.setProductType(typeid);
	        pid=mapper.insertAndReturnKey(p);
	        
	        
	        //	    
	        log.info("------------------this is return key of product------------------"+pid);
		 
	 }
	 @After
	 public void destory() {
		 this.mapper.deleteByPrimaryKey(pid);
		 
	     this.type_mapper.deleteByPrimaryKey(typeid);
	     
	 }
	
	@Test
	public void test_queryProduct() {
		//
		List<ProductWithTypeName> pList=mmdao.queryProduct("iphone 7", "");
		Assert.assertTrue(!pList.isEmpty());
		//Assert.assertEquals(pid, pList.get(0).getProdectId());
		boolean isex=false;
		for(ProductWithTypeName pt:pList) {
			if(pt.getProdectId()==pid) {
				isex=true;
				break;
			}
		}
		Assert.assertTrue(isex);
	}
	
	@Test
	public void test_queryProductAnnotation() {
		//
		List<ProductWithTypeName> pList=mmdao.queryProductAnnotation("iphone 7", null);
		Assert.assertTrue(!pList.isEmpty());
		//Assert.assertEquals(pid, pList.get(0).getProdectId());
		boolean isex=false;
		for(ProductWithTypeName pt:pList) {
			if(pt.getProdectId()==pid) {
				isex=true;
				break;
			}
		}
		Assert.assertTrue(isex);
	}

}

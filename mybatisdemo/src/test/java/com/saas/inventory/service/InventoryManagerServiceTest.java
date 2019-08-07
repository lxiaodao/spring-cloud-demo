/**
 * 
 */
package com.saas.inventory.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j2;

/**
 * @author yangliu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2(topic="Inventory_Module")
public class InventoryManagerServiceTest {
	
	
	@Test
	public void test_reduceAmountOfProduct() {
		
		log.info("---------this is reduceAmountOfProduct----------");
		log.debug("---------debug test for reduceAmountOfProduct----------");
	}

}

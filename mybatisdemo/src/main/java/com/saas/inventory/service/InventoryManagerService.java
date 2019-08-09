/**
 * 
 */
package com.saas.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saas.dao.MerchantManageDao;
import com.saas.dto.ProductWithTypeName;

/**
 * @author yangliu
 *
 */
@Service
public class InventoryManagerService {
	
	
	@Autowired
	MerchantManageDao mmdao;
	
	public List<ProductWithTypeName> findProduct(String productName,String typeName) {
		
		return mmdao.queryProductAnnotation(productName, typeName);
	}

}

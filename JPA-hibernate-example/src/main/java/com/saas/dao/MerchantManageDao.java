/**
 * 
 */
package com.saas.dao;

import java.util.List;

import com.saas.domain.Product;
import com.saas.domain.ProductType;
import com.saas.domain.SaasUser;
import com.saas.dto.ProductWithTypeName;

/**
 * 
 * merchart CRUD
 * @author yangliu
 *
 */
public interface MerchantManageDao {
	  public void delete(Class entityclass,Object key);
      public SaasUser grantAuthority(SaasUser user);
      public Product createProductAndType(Product p,ProductType type);
      public List<ProductWithTypeName> queryProduct(String prodectName,String typeName);
}

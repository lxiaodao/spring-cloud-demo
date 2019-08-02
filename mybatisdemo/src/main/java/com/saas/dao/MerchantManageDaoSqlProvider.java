/**
 * 
 */
package com.saas.dao;

import org.apache.commons.lang.StringUtils;

/**
 * @author yangliu
 *
 */
public class MerchantManageDaoSqlProvider {
	
	public String queryProductProvider(String productName,String typeName) {
		
		String sql="select p.id as prodectId, p.name as productName,type.id as typeId,type.name as typeName "
				+ "from product p left join product_type type on p.product_type =type.id where 1=1 ";
		if(StringUtils.isNotBlank(productName)) {
			sql+=" and p.name='"+productName+"'";
		}
		if(StringUtils.isNotBlank(typeName)) {
			sql+=" and type.name='"+typeName+"'";
		}
		return sql;
	}

}

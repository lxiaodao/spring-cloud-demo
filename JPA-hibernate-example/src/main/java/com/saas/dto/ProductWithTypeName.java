/**
 * 
 */
package com.saas.dto;

import javax.persistence.Entity;

/**
 * @author yangliu
 *
 */

public class ProductWithTypeName {
	
	private Integer prodectId;
	private String productName;
	private  Integer typeId;
	private String typeName;
	public Integer getProdectId() {
		return prodectId;
	}
	public void setProdectId(Integer prodectId) {
		this.prodectId = prodectId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	

}

package com.saas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="cost_price", precision=8, scale=2)
	private BigDecimal costPrice;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(length=50)
	private String name;

	@Column(name="retail_price", precision=8, scale=2)
	private BigDecimal retailPrice;

	//bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name="product_type")
	private ProductType productTypeBean;

	public Product() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCostPrice() {
		return this.costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getRetailPrice() {
		return this.retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public ProductType getProductTypeBean() {
		return this.productTypeBean;
	}

	public void setProductTypeBean(ProductType productTypeBean) {
		this.productTypeBean = productTypeBean;
	}

}
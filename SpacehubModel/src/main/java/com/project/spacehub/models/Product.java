/**
 * 
 */
package com.project.spacehub.models;
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gbemisola
 *
 */
@Entity
@DynamicUpdate
@Table(name="product")
public class Product {
	
	@Transient
	@Autowired
	private ProductImage productImage;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	@Column(name="product_name")
	private String productName; 
	
	
	@Column(name="product_plan")
	private String productPlan;
	
	@Column(name="product_price")
	private double productPrice;
	
	
	
	@Column(name="product_image")
	private String productImg;
	
	@OneToOne
	@JoinColumn(name="status_name")
    private ProductStatus productStatus;
    
	
	
	public Product() {
		
	}

		
		
	









	public Product(String productName, String productPlan, double productPrice, String productImg,
			ProductStatus productStatus) {
		super();
		this.productName = productName;
		this.productPlan = productPlan;
		this.productPrice = productPrice;
		this.productImg = productImg;
		this.productStatus = productStatus;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

	public String getProductPlan() {
		return productPlan;
	}

	public void setProductPlan(String productPlan) {
		this.productPlan = productPlan;
	}
	
	

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	


	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		
		this.productImg = productImg;
	}

	
	


	

	


	public ProductStatus getProductStatus() {
		return productStatus;
	}



	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}



	@Override
	public String toString() {
		return "Product [productImage=" + productImage + ", id=" + id + ", productName=" + productName
				+ ", productPlan=" + productPlan + ", productPrice=" + productPrice 
				+ ", productImg=" + productImg + "]";
	}



	



	
	

		
	
	
	
	
	

}

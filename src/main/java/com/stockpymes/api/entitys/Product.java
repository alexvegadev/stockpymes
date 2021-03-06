package com.stockpymes.api.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Alex P. Vega
 */
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "bard_code")
	private String barCode;
	
	@Column(name = "name", length = 100)
	private String name;
	
	@Column(name = "category", length = 100)
	private String category;
	
	@Column(name = "image", length = 100)
	private String image;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "pricetosell")
	private Double priceToSell;
	
	@Column(name = "priceperunit")
	private Double pricePerUnit;
	
	@Column(name = "quantity")
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPriceToSell() {
		return priceToSell;
	}

	public void setPriceToSell(Double priceToSell) {
		this.priceToSell = priceToSell;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getBarCode() {
		return barCode;
	}
	
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	
}

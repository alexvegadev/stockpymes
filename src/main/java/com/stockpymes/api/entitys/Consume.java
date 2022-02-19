package com.stockpymes.api.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class contains a representation of products consumed for an client or not.
 * @author Alex P. Vega
 */
@Entity
@Table(name = "consumes")
public class Consume {
	/**
	 * this represents the client id, if the clientId is = -1 don't is an habitual client.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rid")
	private Long id;
	
	@Column(name = "client_id")
	private Long clientId;
	/**
	 * this represents the product id
	 */
	@Column(name = "product_id")
	private Long productId;
	
	/**
	 * this represents the consume date
	 */
	@Column(name = "consume_date", length = 100)
	private String consumeDate;
	
	/**
	 * this represents the consume hour
	 */
	@Column(name = "consume_hour", length = 100)
	private String consumeHour;
	
	@Column(name = "quantity")
	private int quantity;
	
	/**
	 * TODO -> Es necesario editar esto
	 */
	/*@OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "product_id")
	private Product productDetail;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getConsumeDate() {
		return consumeDate;
	}

	public void setConsumeDate(String consumeDate) {
		this.consumeDate = consumeDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public String getConsumeHour() {
		return consumeHour;
	}
	
	public void setConsumeHour(String consumeHour) {
		this.consumeHour = consumeHour;
	}
	
	
}

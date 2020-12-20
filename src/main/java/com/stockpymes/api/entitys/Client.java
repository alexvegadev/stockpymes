package com.stockpymes.api.entitys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * @author Alex P. Vega
 */
@Entity
@Table(name = "clients")
public class Client {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstname", length = 100)
	private String firstName;
	
	@Column(name = "lastname", length = 100)
	private String lastName;
	
	@OneToMany(targetEntity = Consume.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private List<Consume> consumes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Consume> getConsumes() {
		return consumes;
	}
	
	@PrePersist
	public void prePersist() {
		if(consumes == null) {
			consumes = new ArrayList<>();
		}
	}
	
	
}

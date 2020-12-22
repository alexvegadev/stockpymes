package com.stockpymes.api.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EnumRole name;
	
	
	public Role() {
	}
	
	public Long getId() {
		return id;
	}
	
	public EnumRole getName() {
		return name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(EnumRole name) {
		this.name = name;
	}
}

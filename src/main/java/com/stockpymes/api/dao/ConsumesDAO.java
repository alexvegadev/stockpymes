package com.stockpymes.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockpymes.api.entitys.Consume;

/**
 * This class represents the DAO of the "consumes" table.
 * @author Alex P. Vega
 */
public interface ConsumesDAO extends JpaRepository<Consume, Long>{
	List<Consume> findByProductId(Long productId);
	
	List<Consume> findByClientId(Long clientId);
	
	List<Consume> findByClientIdAndProductId(Long clientId, Long productId);
	
	void deleteByClientId(Long clientId);
	
	void deleteByProductId(Long productId);
	
	void deleteByClientIdAndProductId(Long clientId, Long productId);
}

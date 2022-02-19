package com.stockpymes.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.stockpymes.api.entitys.Consume;

/**
 * This class represents the DAO of the "consumes" table.
 * @author Alex P. Vega
 */
public interface ConsumesDAO extends PagingAndSortingRepository<Consume, Long>{
	List<Consume> findByProductId(Long productId);
	
	List<Consume> findByClientId(Long clientId);
	
	List<Consume> findByClientIdAndProductId(Long clientId, Long productId);
	
	void deleteByClientId(Long clientId);
	
	void deleteByProductId(Long productId);
	
	void deleteByClientIdAndProductId(Long clientId, Long productId);
	
	@Query(nativeQuery = true, value = "select " + 
			"co.client_id, " + 
			"sum(prod.pricetosell * co.quantity) as Balance " + 
			"from consumes as co " + 
			"inner join products as prod " + 
			"	on " + 
			"		prod.id = co.product_id " + 
			"where " + 
			"co.client_id = ?1 " + 
			"and extract(year from cast(consume_date as date)) = ?2 " + 
			"and extract(month from cast(consume_date as date)) = ?3 " + 
			"group by 1")
	Object sumConsumesByClientId(Long clientId, Integer year, Integer month);
}

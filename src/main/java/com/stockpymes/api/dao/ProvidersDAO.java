package com.stockpymes.api.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.stockpymes.api.entitys.Provider;

/**
 * @author Alex P. Vega
 */
public interface ProvidersDAO extends PagingAndSortingRepository<Provider, Long> {
	
}

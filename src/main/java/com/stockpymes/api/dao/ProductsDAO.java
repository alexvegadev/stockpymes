package com.stockpymes.api.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.stockpymes.api.entitys.Product;


/**
 * @author Alex P. Vega
 */
public interface ProductsDAO extends PagingAndSortingRepository<Product, Long> {
	Page<Product> findByNameContainingIgnoreCase(Pageable pager, String name);
}

package com.stockpymes.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockpymes.api.entitys.Product;


/**
 * @author Alex P. Vega
 */
public interface ProductsDAO extends JpaRepository<Product, Long> {
}

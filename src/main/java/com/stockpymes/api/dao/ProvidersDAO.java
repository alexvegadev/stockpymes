package com.stockpymes.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockpymes.api.entitys.Provider;

/**
 * @author Alex P. Vega
 */
public interface ProvidersDAO extends JpaRepository<Provider, Long> {

}

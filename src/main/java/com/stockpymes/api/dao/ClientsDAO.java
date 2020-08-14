package com.stockpymes.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockpymes.api.entitys.Client;

/**
 * @author Alex P. Vega
 */
public interface ClientsDAO extends JpaRepository<Client, Long> {

}

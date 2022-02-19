package com.stockpymes.api.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.stockpymes.api.entitys.Client;

/**
 * @author Alex P. Vega
 */
public interface ClientsDAO extends PagingAndSortingRepository<Client, Long> {
	Page<Client> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(Pageable pager, String firstName, String lastName);
}

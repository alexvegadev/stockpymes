package com.stockpymes.api.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockpymes.api.entitys.User;

/**
 * Repository that provides safe information to auth,
 * @author Alex P. Vega
 */
public interface UserDAO extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
}

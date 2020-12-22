package com.stockpymes.api.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockpymes.api.entitys.EnumRole;
import com.stockpymes.api.entitys.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {
	Optional<Role> findByName(EnumRole name);
}

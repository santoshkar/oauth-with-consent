package com.poc.service;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<SecurityUser, Long>{
	SecurityUser findByUsername(String username);
}

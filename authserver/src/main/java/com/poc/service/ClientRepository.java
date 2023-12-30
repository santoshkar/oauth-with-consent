package com.poc.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, String>{
	Optional<Client> findByClientId(String clientId);
}

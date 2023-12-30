package com.poc.service;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

	@Id
	private String id;

	private String clientId;
	
	private Instant clientIdIssuedAt;
	
	private String clientSecret;

	private Instant clientSecretExpiresAt;
	
	private String clientName;

	private String clientAuthenticationMethods;

	private String authorizationGrantTypes;

	private String redirectUris;
	
	private String postLogoutRedirectUris;

	private String scopes;
	
	@Column(length = 2000)
	private String clientSettings;
	
	@Column(length = 2000)
	private String tokenSettings;
}

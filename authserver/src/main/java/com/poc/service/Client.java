package com.poc.service;

import java.time.Instant;

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

	private String clientName;

	private String clientSecret;

	private Instant clientIdIssuedAt;

	private Instant clientSecretExpiresAt;

	private String clientAuthenticationMethods;

	private String authorizationGrantTypes;

	private String redirectUris;

	private String scopes;
}

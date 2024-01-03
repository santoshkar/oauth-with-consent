package com.brane.patientservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;

	private static final String[] AUTH_WHITELIST = { "/v3/api-docs/**", "/swagger-ui/**", "/actuator/**" };

	@Bean
	@Order(1)
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		// @formatter:off
		http
			.userDetailsService(inMemoryUserDetailsManager)
			.csrf(c -> c.disable())
			.cors(c -> c.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.headers(h -> h.disable())
			.authorizeHttpRequests(e -> e.requestMatchers(AUTH_WHITELIST).hasAuthority("admin"))
			.httpBasic(Customizer.withDefaults());
		
		http.authorizeHttpRequests((authorize) -> 
			authorize
			.requestMatchers(HttpMethod.GET, "/message/**").hasAuthority("SCOPE_message.read")
			.requestMatchers(HttpMethod.POST, "/message/**").hasAuthority("SCOPE_message.write")
			.anyRequest().authenticated())
			.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
		// @formatter:on
		return http.build();
	}

}
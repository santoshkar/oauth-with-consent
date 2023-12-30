
package com.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.poc.authorization.DeviceCodeOAuth2AuthorizedClientProvider;

/**
 * @author Joe Grandja
 * @author Steve Riesenberg
 * @since 0.0.1
 */
@Configuration
public class WebClientConfig {

//	@Bean
//	public WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
//		ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client =
//				new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
//		// @formatter:off
//		return WebClient.builder()
//				.apply(oauth2Client.oauth2Configuration())
//				.build();
//		// @formatter:on
//	}

//	@Bean
//	public OAuth2AuthorizedClientManager authorizedClientManager(
//			ClientRegistrationRepository clientRegistrationRepository,
//			OAuth2AuthorizedClientRepository authorizedClientRepository) {
//
//		// @formatter:off
//		OAuth2AuthorizedClientProvider authorizedClientProvider =
//				OAuth2AuthorizedClientProviderBuilder.builder()
//						.authorizationCode()
//						.refreshToken()
//						.clientCredentials()
//						.provider(new DeviceCodeOAuth2AuthorizedClientProvider())
//						.build();
//		// @formatter:on
//
//		DefaultOAuth2AuthorizedClientManager authorizedClientManager = new DefaultOAuth2AuthorizedClientManager(
//				clientRegistrationRepository, authorizedClientRepository);
//		authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
//
//		// Set a contextAttributesMapper to obtain device_code from the request
//		authorizedClientManager.setContextAttributesMapper(DeviceCodeOAuth2AuthorizedClientProvider
//				.deviceCodeContextAttributesMapper());
//
//		return authorizedClientManager;
//	}

}

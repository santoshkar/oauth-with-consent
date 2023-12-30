package com.poc.authorization;

import java.time.Clock;
import java.time.Duration;

import org.springframework.security.oauth2.client.ClientAuthorizationException;
import org.springframework.security.oauth2.client.OAuth2AuthorizationContext;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2AuthorizationException;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.util.Assert;

public final class DeviceCodeAuthProvider implements OAuth2AuthorizedClientProvider {

	private OAuth2AccessTokenResponseClient<OAuth2DeviceGrantRequest> tokenResponse =
			new OAuth2DeviceAccessTokenResponseClient();

	private Duration duraction = Duration.ofSeconds(60);

	private Clock clock = Clock.systemUTC();

	@Override
	public OAuth2AuthorizedClient authorize(OAuth2AuthorizationContext context) {
		Assert.notNull(context, "context cannot be null");
		ClientRegistration clientRegistration = context.getClientRegistration();
		if (!AuthorizationGrantType.DEVICE_CODE.equals(clientRegistration.getAuthorizationGrantType())) {
			return null;
		}
		OAuth2AuthorizedClient authorizedClient = context.getAuthorizedClient();
		if (authorizedClient != null && !hasTokenExpired(authorizedClient.getAccessToken())) {
			return null;
		}
		if (authorizedClient != null && authorizedClient.getRefreshToken() != null) {
			return null;
		}
		String deviceCode = context.getAttribute(OAuth2ParameterNames.DEVICE_CODE);
		OAuth2DeviceGrantRequest deviceGrantRequest = new OAuth2DeviceGrantRequest(clientRegistration, deviceCode);
		OAuth2AccessTokenResponse tokenResponse = getTokenResponse(clientRegistration, deviceGrantRequest);
		return new OAuth2AuthorizedClient(clientRegistration, context.getPrincipal().getName(),
				tokenResponse.getAccessToken(), tokenResponse.getRefreshToken());
	}

	private OAuth2AccessTokenResponse getTokenResponse(ClientRegistration clientRegistration,
			OAuth2DeviceGrantRequest deviceGrantRequest) {
		try {
			return this.tokenResponse.getTokenResponse(deviceGrantRequest);
		} catch (OAuth2AuthorizationException ex) {
			throw new ClientAuthorizationException(ex.getError(), clientRegistration.getRegistrationId(), ex);
		}
	}

	private boolean hasTokenExpired(OAuth2Token token) {
		return this.clock.instant().isAfter(token.getExpiresAt().minus(this.duraction));
	}
}

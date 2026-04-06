package com.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class OAuth2ClientConfig {

	@Bean
	ClientRegistrationRepository clientRegistrationRepository(Environment environment) {
		List<ClientRegistration> registrations = new ArrayList<>();

		addGithubRegistration(registrations, environment);
		addGoogleRegistration(registrations, environment);

		if (registrations.isEmpty()) {
			return registrationId -> null;
		}

		return new InMemoryClientRegistrationRepository(registrations);
	}

	@Bean
	OAuth2AuthorizedClientService authorizedClientService(ClientRegistrationRepository repository) {
		return new InMemoryOAuth2AuthorizedClientService(repository);
	}

	private void addGithubRegistration(List<ClientRegistration> registrations, Environment environment) {
		String clientId = environment.getProperty("oauth.github.client-id");
		String clientSecret = environment.getProperty("oauth.github.client-secret");

		if (hasText(clientId) && hasText(clientSecret)) {
			registrations.add(CommonOAuth2Provider.GITHUB.getBuilder("github")
					.clientId(clientId)
					.clientSecret(clientSecret)
					.scope("read:user", "user:email")
					.build());
		}
	}

	private void addGoogleRegistration(List<ClientRegistration> registrations, Environment environment) {
		String clientId = environment.getProperty("oauth.google.client-id");
		String clientSecret = environment.getProperty("oauth.google.client-secret");

		if (hasText(clientId) && hasText(clientSecret)) {
			registrations.add(CommonOAuth2Provider.GOOGLE.getBuilder("google")
					.clientId(clientId)
					.clientSecret(clientSecret)
					.scope("openid", "profile", "email")
					.build());
		}
	}

	private boolean hasText(String value) {
		return value != null && !value.isBlank();
	}
}

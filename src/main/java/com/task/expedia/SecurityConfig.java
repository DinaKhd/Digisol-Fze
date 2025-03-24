package com.task.expedia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(authorize -> authorize
						// Allow access to Swagger UI and API docs without authentication
						.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
						// Allow all other requests without authentication
						.anyRequest().permitAll()
				)
				.csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection for non-browser clients (if needed)
				.formLogin(AbstractHttpConfigurer::disable) // Disable form login
				.httpBasic(AbstractHttpConfigurer::disable)
				.anonymous(AbstractHttpConfigurer::disable); // Disable basic authentication

		return http.build();
	}
}

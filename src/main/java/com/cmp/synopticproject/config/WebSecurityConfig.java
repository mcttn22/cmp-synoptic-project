package com.cmp.synopticproject.config;

import com.cmp.synopticproject.service.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Class to configure spring web security.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	private CustomUserDetailsService customUserDetailsService;

	public WebSecurityConfig(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	/**
	 * Generate SecurityFilterChain object.
	 * @return SecurityFilterChain object.
	 */
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(csrf -> csrf.disable());
		return httpSecurity
			.authorizeHttpRequests(authorise -> authorise
					.requestMatchers("/", "/index", "/assets/**", "/*.css", "/scripts/**", "/api/signup").permitAll()
					.requestMatchers("/infoF", "/ourGoalF", "/reportF", "/welcomeF").hasRole("Farmer")
					.requestMatchers("/infoR", "/ourGoalR", "/reportR", "/welcomeR").hasRole("Resident")
					.anyRequest().authenticated()
			)
			.formLogin((form) -> form
					.loginPage("/")
					.loginProcessingUrl("/login")
					.successHandler((request, response, authentication) -> {
						response.setStatus(HttpStatus.OK.value());
						response.setContentType("application/json");

						// Respond with JSON object containing the authenticated user's role
						response.getWriter().write(String.format("{\"role\": \"%s\"}", ((GrantedAuthority) authentication.getAuthorities().toArray()[0]).getAuthority()));
					})
					.failureHandler((request, response, exception) -> {
						response.setStatus(HttpStatus.UNAUTHORIZED.value());
					})
					.permitAll()
			)
			.logout((logout) -> logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/")
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.permitAll()
			)
			.userDetailsService(customUserDetailsService)
			.build();
	}

	/**
	 * Create PasswordEncoder object.
	 * @return PasswordEncoder object.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}


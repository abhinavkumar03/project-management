package com.abhinav.config;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class AppConfig {


    @Value("${ALLOWED_ORIGINS}")
    private String allowedOrigins;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.sessionManagement(Management -> Management.sessionCreationPolicy(
				SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests(Authorize -> Authorize.requestMatchers("/api/admin/**").hasRole("ADMIN")
				.requestMatchers("/api/**")
				.authenticated().anyRequest().permitAll())
		.addFilterBefore(new JwtTokenValidator(),BasicAuthenticationFilter.class)
		.csrf(csrf -> csrf.disable())
		.cors(cors -> cors.configurationSource(corsConfigurationSource()));
		
		return http.build();
	}

	private CorsConfigurationSource corsConfigurationSource() {
		// TODO Auto-generated method stub
		return new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(
					HttpServletRequest request) {
				// TODO Auto-generated method stub
				CorsConfiguration cfg = new CorsConfiguration();
				
				cfg.setAllowedOrigins(Arrays.asList(allowedOrigins.split(",")));
				cfg.setAllowedMethods(Collections.singletonList("*"));
				cfg.setAllowCredentials(true);
				cfg.setAllowedHeaders(Collections.singletonList("*"));
				cfg.setExposedHeaders(Arrays.asList("Authorization"));
				cfg.setMaxAge(3600L);
				return cfg;
			}
		};
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} 


}

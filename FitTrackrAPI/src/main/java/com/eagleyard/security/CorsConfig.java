package com.eagleyard.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class CorsConfig{
	@Bean
	  public SecurityFilterChain masaiSecurityConfig(HttpSecurity http) throws Exception {
		
		http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.NEVER))
		
		.cors(cors ->{
			cors.configurationSource(new CorsConfigurationSource() {
				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration cfg= new CorsConfiguration();
				
				cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
				cfg.setAllowedMethods(Collections.singletonList("*"));
				cfg.setAllowCredentials(true);
				cfg.setAllowedHeaders(Collections.singletonList("*"));
				cfg.setExposedHeaders(Arrays.asList("*"));
				return cfg;					
				}
			});	
		})
	    	.authorizeHttpRequests( (auth)->auth
	    	.requestMatchers(HttpMethod.POST,"/signin").permitAll()
	    	.anyRequest()	
	        .authenticated()
	    ).csrf(csrf -> csrf.disable())
	    .formLogin(Customizer.withDefaults())
	    .httpBasic(Customizer.withDefaults())
		.cors(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable);
		
		return http.build();
	    
	  }
}

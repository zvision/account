package com.alaf.account;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.alaf.account.model.Account;
import com.alaf.account.service.AccountService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	
	@Autowired
	AccountService accountService;
	
	@PostConstruct
	public void init() {
		Account account = new Account();
		account.setName("www.ankeborg.com");
		account.setPwd("12345");
		account.setUid("Kalle");
		accountService.createAccount(account);
	}
	
	
	@Bean
	public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true); // you USUALLY want this
	    config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://127.0.0.1:5500"));
	    config.setAllowedHeaders(Arrays.asList("Origin", "Access-Controll-Allow-Origin",
	    		"Content-Type", "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
	    		"Access-Controll-Request-Method", "Access-Controll-Request-Headers"));
	    config.setExposedHeaders(Arrays.asList("Origin", "Access-Controll-Allow-Origin",
	    		"Content-Type", "Accept", "Authorization", "Access-Controll-Allow-Credentials"));
	    config.setAllowedMethods(Arrays.asList("OPTIONS", "GET", "PUT","POST","DELETE"));
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
	
}

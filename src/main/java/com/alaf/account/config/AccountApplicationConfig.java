package com.alaf.account.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import com.alaf.account.controller.AccountResource;
import com.alaf.account.interceptors.AccountInterceptor;

import jakarta.ws.rs.ApplicationPath;
import lombok.extern.slf4j.Slf4j;



@Component
@ApplicationPath("/")
@Slf4j
public class AccountApplicationConfig extends ResourceConfig  {

	public AccountApplicationConfig() {
		
		register(AccountResource.class);
		log.info("Jersey registration done.");
		register(new AccountInterceptor());
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
	
	
}
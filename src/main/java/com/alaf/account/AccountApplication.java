package com.alaf.account;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alaf.account.model.Account;
import com.alaf.account.service.AccountService;

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
}

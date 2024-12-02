package com.alaf.account.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alaf.account.model.Account;
import com.alaf.account.service.AccountService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import lombok.extern.slf4j.Slf4j;


@Component
@Path("/api/v1")
@Slf4j
public class AccountResource {

	
	@Autowired
	private AccountService accountService;

	
	@GET
	@Produces("application/json")
	@Path("/accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		
		Iterable<Account> allAccounts = accountService.findAll();
		ResponseEntity<List<Account>> resp = ResponseEntity.ok()
				.body(StreamSupport.stream(allAccounts.spliterator(), false)
						.sorted(new Comparator<Account>() {
							@Override
							public int compare(Account a1, Account a2) {
								return a1.getName().compareTo(a2.getName());
							}
						})

						//.peek(s -> s.setPwd("********")) // beh�vs ingen returv�rde h�r, enbart f�r debug�ndam�l 
				
						.map(s -> { 						// m�ste returnera v�rde
							// s.setUid("********");
							s.setPwd("********");
							return s;
						}).collect(Collectors.toList()));
		return resp;
	}
	

	@GET
	@Produces("application/json")
	@Path("/accounts/{name}")
	public ResponseEntity<List<Account>> findByName(@PathParam(value = "name") String name) {
		
		List<Account> accounts = accountService.getAccountByName(name).get();
		if (!accounts.isEmpty()) {
			return ResponseEntity.ok().body(StreamSupport.stream(accounts.spliterator(), false)
					.peek(s -> log.info("konto: {}", s.getName()))
					.map(s -> {
						//s.setUid("********");
						s.setPwd("********");
						return s;
					})
					.collect(Collectors.toList()));
		} 
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/accounts")
	@PostMapping("/accounts")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.createAccount(account));
	}


	@DELETE
	@Produces("application/json")
	@Path("/accounts/{id}")
	public ResponseEntity<String> deleteAccountById(@PathParam(value = "id") Long accountId)  {
		
		Optional<Account> account = accountService.getAccountById(accountId);

		String msg = "NOT_FOUND";
		if (account.isPresent()) {
			accountService.deleteAccount(account.get());
			msg = "DELETED";
		}
		return ResponseEntity.ok().body(msg);
	}
	
	@DELETE
	@Produces("application/json")
	@Path("/accounts/del")
	public ResponseEntity<String> deleteAllAccounts()  {
		accountService.deleteAllAccounts();
		return ResponseEntity.ok().body("Deleted all accounts");
	}
}

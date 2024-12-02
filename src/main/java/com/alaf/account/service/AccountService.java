
package com.alaf.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alaf.account.model.Account;
import com.alaf.account.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Optional<List<Account>> getAccountByName(String accountName) {
        return Optional.of(accountRepository.findByName(accountName));
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }


    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().spliterator().forEachRemaining(accounts::add);
        return accounts;
    }

    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }
    
    public void deleteAllAccounts() {
        accountRepository.deleteAll();
    }
}

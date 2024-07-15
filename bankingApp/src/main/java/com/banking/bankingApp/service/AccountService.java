package com.banking.bankingApp.service;

import java.util.Optional;

import com.banking.bankingApp.entity.Account;

public interface AccountService {
	public Account createAccount(Account account);
	public Optional<Account> getAccount(Long Id);
	public Account deposit(Long Id, double amount);
	public Account withdraw(Long Id, double amount);

}

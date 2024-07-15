package com.banking.bankingApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.bankingApp.entity.Account;
import com.banking.bankingApp.repository.AccountRepository;


@Service
public class AccountSeviceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepo;

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepo.save(account);
	}

	@Override
	public Optional<Account> getAccount(Long Id) {
		// TODO Auto-generated method stub
		return accountRepo.findById(Id);
	}

	@Override
	public Account deposit(Long Id, double amount) {
		// TODO Auto-generated method stub
		Account account=getAccount(Id).orElseThrow(()->new RuntimeException("Account not found"));
		account.setBalance(account.getBalance()+amount);
		return accountRepo.saveAndFlush(account);
	}

	@Override
	public Account withdraw(Long Id, double amount) {
		// TODO Auto-generated method stub
		Account account=getAccount(Id).orElseThrow(()->new RuntimeException("Account not found"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient funds!");
		}
		account.setBalance(account.getBalance()-amount);
		return accountRepo.saveAndFlush(account);
	}

}

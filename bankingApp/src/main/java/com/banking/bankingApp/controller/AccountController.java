package com.banking.bankingApp.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.bankingApp.entity.Account;
import com.banking.bankingApp.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	AccountService service;
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		Account newaccount= service.createAccount(account);
		return new ResponseEntity<>(newaccount,HttpStatus.CREATED);
	}
	@GetMapping("/{Id}")
	public ResponseEntity<Optional<Account>> getAccount(@PathVariable Long Id){
		Optional<Account> newaccount= service.getAccount(Id);
		return new ResponseEntity<>(newaccount,HttpStatus.CREATED);
	}
	@PostMapping("/{Id}/deposit")
	public ResponseEntity<Account> deposit(@PathVariable Long Id, @RequestBody Map<String, Double> request){
		Double amount=request.get("amount");
		Account newaccount= service.deposit(Id,amount);
		return new ResponseEntity<>(newaccount,HttpStatus.CREATED);
	}
	@PostMapping("/{Id}/withdraw")
	public ResponseEntity<Account> withdraw(@PathVariable Long Id, @RequestBody Map<String, Double> request){
		Double amount=request.get("amount");
		Account newaccount= service.withdraw(Id,amount);
		return new ResponseEntity<>(newaccount,HttpStatus.CREATED);
	}
	
	

}

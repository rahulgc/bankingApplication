package com.banking.bankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.bankingApp.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}

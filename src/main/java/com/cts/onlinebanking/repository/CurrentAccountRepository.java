package com.cts.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.onlinebanking.model.CurrentAccount;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Integer> {

	CurrentAccount findByUserName(String userName);
	CurrentAccount findByAccountNumber(int accountNumber);
	
}

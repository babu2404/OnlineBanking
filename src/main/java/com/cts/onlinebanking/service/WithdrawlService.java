package com.cts.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.onlinebanking.model.CurrentAccount;
import com.cts.onlinebanking.model.Deposit;
import com.cts.onlinebanking.model.SavingsAccount;
import com.cts.onlinebanking.model.Withdraw;
import com.cts.onlinebanking.repository.CurrentAccountRepository;
import com.cts.onlinebanking.repository.SavingsAccountRepository;

@Service
public class WithdrawlService {
	
	@Autowired
	CurrentAccountRepository cRepository;
	
	@Autowired
	SavingsAccountRepository sRepository;
	
	public void withdrawlAmount(Withdraw withdrawl,String userName)
	{
		String accountType = withdrawl.getAccType();
		if(accountType.equalsIgnoreCase("Savings Account"))
		{
			SavingsAccount sAccount = sRepository.findByUserName(userName);
			float tot = sAccount.getBalance()-withdrawl.getWithdrawlAmt();
			sAccount.setBalance(tot);
			sRepository.save(sAccount);
		}
		else
		{
			CurrentAccount cAccount = cRepository.findByUserName(userName);
			float tot = cAccount.getBalance()-withdrawl.getWithdrawlAmt();
			cAccount.setBalance(tot);
			cRepository.save(cAccount);
		}
	}

}

package com.cts.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.onlinebanking.model.CurrentAccount;
import com.cts.onlinebanking.model.SavingsAccount;
import com.cts.onlinebanking.model.TransferOthersAccount;
import com.cts.onlinebanking.repository.CurrentAccountRepository;
import com.cts.onlinebanking.repository.SavingsAccountRepository;

@Service
public class OtherAccountTransferService {
	
	@Autowired
	CurrentAccountRepository cRepository;
	
	@Autowired
	SavingsAccountRepository sRepository;
	
	public void transferToOthers(TransferOthersAccount transferOthers,String userName)
	{
		if(transferOthers.getAcc1().equals("Savings Account"))
		{
			SavingsAccount sAccount = sRepository.findByUserName(userName);
			sAccount.setBalance(sAccount.getBalance()-transferOthers.getAmount());
			if(transferOthers.getAcc2().equals("Savings Account"))
			{
				SavingsAccount sAccount2 = sRepository.findByAccountNumber(transferOthers.getAccNumber());
				sAccount2.setBalance(sAccount2.getBalance()+transferOthers.getAmount());
				sRepository.save(sAccount2);
			}
			else
			{
				CurrentAccount cAccount2 = cRepository.findByAccountNumber(transferOthers.getAccNumber());
				cAccount2.setBalance(cAccount2.getBalance()+transferOthers.getAmount());
				cRepository.save(cAccount2);
			}
			sRepository.save(sAccount);
		}
		else
		{
			CurrentAccount cAccount = cRepository.findByUserName(userName);
			cAccount.setBalance(cAccount.getBalance()-transferOthers.getAmount());
			if(transferOthers.getAcc2().equals("Savings Account"))
			{
				SavingsAccount sAccount2 = sRepository.findByAccountNumber(transferOthers.getAccNumber());
				sAccount2.setBalance(sAccount2.getBalance()+transferOthers.getAmount());
				sRepository.save(sAccount2);
			}
			else
			{
				CurrentAccount cAccount2 = cRepository.findByAccountNumber(transferOthers.getAccNumber());
				cAccount2.setBalance(cAccount2.getBalance()+transferOthers.getAmount());
				cRepository.save(cAccount2);
			}
			cRepository.save(cAccount);
		}
	}

}

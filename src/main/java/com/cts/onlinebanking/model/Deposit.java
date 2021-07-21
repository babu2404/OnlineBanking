package com.cts.onlinebanking.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Deposit {

	@Id
	@GeneratedValue
	private int id;

	private String UserName;
	private float balance;
	private int depositAmt;
	private String accountType;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(int depositAmt) {
		this.depositAmt = depositAmt;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}

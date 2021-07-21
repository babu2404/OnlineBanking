package com.cts.onlinebanking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Withdraw {

	@Id
	@GeneratedValue
	private int id;

	private String accType;
	private int withdrawlAmt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public int getWithdrawlAmt() {
		return withdrawlAmt;
	}

	public void setWithdrawlAmt(int withdrawlAmt) {
		this.withdrawlAmt = withdrawlAmt;
	}
}

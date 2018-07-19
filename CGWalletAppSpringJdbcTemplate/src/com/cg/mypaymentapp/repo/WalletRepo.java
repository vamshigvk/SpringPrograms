package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;

public interface WalletRepo
{

	public boolean save(Customer customer);
	
	public Customer findOne(String mobileNo);
	
	public void update(String mobileno, BigDecimal amount1, String transactionType, BigDecimal amount2);
	
	public ArrayList<Transactions> miniStatement(String mobileno);
}

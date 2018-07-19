package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;
@Component(value="repo")
public class WalletRepoImpl implements WalletRepo{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean save(Customer customer) {
		return false;
	}

	@Override
	public Customer findOne(String mobileNo) {
	
		return null;
	}

	@Override
	public void update(String mobileno, BigDecimal amount1, String transactionType, BigDecimal amount2) {
		
		
	}

	@Override
	public ArrayList<Transactions> miniStatement(String mobileno) {
	
		return null;
	}

	
}

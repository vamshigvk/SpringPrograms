
package com.cg.mypaymentapp.service;
import java.sql.Statement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.beans.Transactions;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletRepoImpl;
@Component(value="walletService")
public class WalletServiceImpl implements WalletService
{	
	@Autowired
	private WalletRepo repo;
	public WalletServiceImpl(WalletRepo repo) 
	{
		super();
	}

	public WalletServiceImpl(Map<String, Customer> data) {
		// TODO Auto-generated constructor stub
	}

	public Customer createAccount(String name, String mobileNo, BigDecimal amount)
	{
		if(!isValidName(name) || !isValidMobile(mobileNo) || !isValidAmount(amount))
		{
			throw new InvalidInputException("Sorry , your details are incorrect");
		}
		Customer cus = new Customer(name,mobileNo,new Wallet(amount));
		boolean b = repo.save(cus);
		return cus;
				
	}


	public Customer showBalance(String mobileNo) 
	{
		if(!isValidMobile(mobileNo))
		{
			throw new InvalidInputException("Invalid Mobile number");
		}
		else
		{
		Customer customer=repo.findOne(mobileNo);
		if(customer!=null)
			return customer;
		else
			throw new InvalidInputException("account with mobile number not found ");
		}
	}

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) 
	{
		if( !isValidMobile(sourceMobileNo) || !isValidMobile(targetMobileNo) || !isValidAmount(amount))
		{
			throw new InvalidInputException("Sorry , your details are incorrect");
		}
		Customer sourceCustomer=repo.findOne(sourceMobileNo);
		Customer destCustomer=repo.findOne(targetMobileNo);
	
		if(sourceCustomer!=null && destCustomer!=null)
		{	Wallet balance1 = sourceCustomer.getWallet();
			Wallet balance2 = destCustomer.getWallet();
			if(balance1.getBalance().compareTo(amount) > 0)
			{
				BigDecimal remainBalance = balance1.getBalance().subtract(amount);
				BigDecimal addedBalance = balance2.getBalance().add(amount);
				balance1.setBalance(remainBalance);
				
				BigDecimal total= sourceCustomer.getWallet().getBalance();
				
				String transactionType1="Debit";
				String transactionType2="Credit";
				
				repo.update(sourceMobileNo, remainBalance, transactionType1, amount);
				repo.update(targetMobileNo, addedBalance, transactionType2, amount);
				
				return sourceCustomer;
			}
			else
			{
				throw new InsufficientBalanceException("insufficient balance");
				
			}
		}
		else
		{
			throw new InvalidInputException("account with mobile number not found ");
		}
		
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) 
	{
		if( !isValidMobile(mobileNo) || !isValidAmount(amount))
		{
			throw new InvalidInputException("Sorry , your details are incorrect");
		}
		Customer cus = repo.findOne(mobileNo);
		if(cus!= null)
		{
			Wallet wallet = new Wallet();
			wallet = cus.getWallet();
			wallet.setBalance(wallet.getBalance().add(amount));
			BigDecimal total= cus.getWallet().getBalance();
			
			String transactionType="credit";
			
			repo.update(mobileNo, total, transactionType, amount);
			return cus;
		}
		else 
		{
			throw new InvalidInputException("account with mobile number not found ");
		}
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) 
	{
		if( !isValidMobile(mobileNo) || !isValidAmount(amount))
		{
			throw new InvalidInputException("Sorry , your details are incorrect");
		}
		Customer cus = repo.findOne(mobileNo);
		if(cus!= null)
		{
			Wallet balance = cus.getWallet();
			if(balance.getBalance().compareTo(amount)>0)
			{
				BigDecimal withdrawedBalance = balance.getBalance().subtract(amount);
				balance.setBalance(withdrawedBalance);
				BigDecimal total= cus.getWallet().getBalance();
				
				String transactionType="Debit";
				
				repo.update(mobileNo, total, transactionType, amount);
				
				return cus;
			}
			else
			{
				throw new InsufficientBalanceException("Insufficient balance ");
			}
		}
		else 
		{
			throw new InvalidInputException("account with mobile number not found ");
		}
	}
	
	private boolean isValidMobile(String mobileNo) 
	{
		if(String.valueOf(mobileNo).matches("[1-9][0-9]{9}")) 
		{
			return true;
		}		
		else 
		{
			return false;
		}
		
	}
	
	private boolean isValidAmount(BigDecimal amount)
	{
		BigDecimal val = new BigDecimal("0");
		if(amount.compareTo(val)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	private boolean isValidName(String name) 
	{
		if(name.isEmpty())
		{
			return false; 
		}
		else
		{
			return true;
		}
			
	}

	@Override
	public ArrayList<Transactions> miniStatement(String mobileno)
	{
		ArrayList<Transactions> transactions=repo.miniStatement(mobileno);
		return transactions;

	}

	
}


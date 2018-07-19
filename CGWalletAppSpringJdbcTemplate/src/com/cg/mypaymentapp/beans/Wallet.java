package com.cg.mypaymentapp.beans;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

public class Wallet 
{
@Autowired
private BigDecimal balance;

public Wallet(BigDecimal amount) 
{
	this.balance=amount;
}

public Wallet() {
	// TODO Auto-generated constructor stub
}

public BigDecimal getBalance() 
{
	return balance;
}

public void setBalance(BigDecimal balance) 
{
	this.balance = balance;
}

@Override
public String toString() 
{
	return ", balance="+balance;
}

}

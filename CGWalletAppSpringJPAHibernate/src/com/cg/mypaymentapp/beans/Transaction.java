package com.cg.mypaymentapp.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name="transaction")
public class Transaction implements Serializable
{

	@Autowired
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String mobileNo;
	private String transactionType;
	private BigDecimal amount;
	private Date dateofTransaction;
	
	public Transaction(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", mobileNo=" + mobileNo + ", transactionType=" + transactionType + ", amount="
				+ amount + ", date=" + dateofTransaction + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		return true;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return dateofTransaction;
	}
	public void setDate(Date date) {
		this.dateofTransaction = date;
	}
	public Transaction(String mobileNo, String transactionType, BigDecimal amount, Date date) {
		super();
		this.mobileNo = mobileNo;
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateofTransaction = date;
	}
	public Transaction() {
		super();
	}
	
}

package com.cg.mypaymentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;

public interface WalletRepo1  extends JpaRepository<Transaction, String >{

}

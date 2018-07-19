package com.cg.mypaymentapp.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.mypaymentapp.beans.Transaction;

public interface WalletRepo1 extends JpaRepository<Transaction, String>, CrudRepository<Transaction,String> {

	ArrayList<Transaction> findByMobileNo(String mobileNo) ;

}

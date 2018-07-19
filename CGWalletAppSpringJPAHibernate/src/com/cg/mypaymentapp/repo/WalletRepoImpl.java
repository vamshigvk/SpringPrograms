package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mypaymentapp.util.JPAUtil;
import com.cg.mypaymentapp.*;
import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletServiceImpl;
@Component(value="repo")
public class WalletRepoImpl implements WalletRepo{
	
	@Autowired(required=true)
	private EntityManagerFactory entityManagerFactory;
	
	public boolean save(Customer customer) 
	{		
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();	
		try
		{//id will be passed when object is passed
		entityManager.persist(customer);
		}	 
		catch (Exception e) 
		{
			throw new InvalidInputException(e);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}
	@Override
	public Customer findOne(String mobileNo)
	{
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();	
		Customer customer = null;
		try {
			customer = entityManager.find(Customer.class, mobileNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		return customer;
	}


	@Override
	public void update(Customer customer, Transaction transaction) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();	
		entityManager.merge(customer);
		entityManager.persist(transaction);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public ArrayList<Transaction> miniStatement(String mobileno)
	{
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		ArrayList<Transaction>	transaction=new ArrayList<Transaction>();	
		try
		{
			Query query = entityManager.createNamedQuery("getAllEmployees");
			transaction = (ArrayList<Transaction>) query.getResultList();
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		entityManager.close();
		return transaction;
		
	}
}

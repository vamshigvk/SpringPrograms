package com.cg.payroll.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;

@Component(value="service")
public class PayrollServicesImpl implements PayrollServices {

	@Autowired
	PayrollDAOServices dao;
	
	@Override
	public Associate acceptAssociateDetails(Associate associate) {
		return dao.save(associate);
	}

	@Override
	public int calculateNetSalary(int associateId) throws AssociateDetailsNotFoundException {
			 
		return 0;
	}

	@Override
	public Associate getAssociateDetails(int associateId) throws AssociateDetailsNotFoundException {
		Associate associate=dao.findOne(associateId);
		return associate;
	}

	@Override
	public ArrayList<Associate> getAllAssociatesDetails() {
		return (ArrayList<Associate>) dao.findAll();
	}

}

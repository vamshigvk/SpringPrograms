package com.cg.mypaymentapp.controllers;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.service.WalletService;

@Controller
public class CustomerActionController {
	@Autowired
	WalletService walletService;
	
	@RequestMapping(value="/registerCustomer")
	public ModelAndView registerCustomer(@ModelAttribute("customer")Customer customer ,  BindingResult result) {
		try {
			if(result.hasErrors())
			{
				return new ModelAndView("registrationPage");
			}
			customer=walletService.createAccount(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("errorPage");
		}
		return new ModelAndView("registrationSuccessPage", "customer", customer);
	}
	
	@RequestMapping(value="/balanceSuccessPage")
	public ModelAndView getBalance(@Valid @RequestParam("mobileNo")String mobileNo) {
		Customer customer=walletService.showBalance(mobileNo);
		return new ModelAndView("balanceSuccessPage", "customer", customer);
	}
	
	@RequestMapping(value="/depositSuccessPage")
	public ModelAndView getDeposit(@Valid @RequestParam("mobileNo")String mobileNo, @RequestParam("wallet.balance")BigDecimal amount) {
		
		Customer customer=walletService.depositAmount(mobileNo, amount);
		ModelAndView m= new ModelAndView("depositSuccessPage", "customer", customer);
		return m;
	}
	
	@RequestMapping(value="/withdrawSuccessPage")
	public ModelAndView getWithdraw(@Valid @RequestParam("mobileNo")String mobileNo, @RequestParam("wallet.balance")BigDecimal amount) {
		Customer customer=walletService.withdrawAmount(mobileNo, amount);
		return new ModelAndView("withdrawSuccessPage", "customer", customer);
	}

	@RequestMapping(value="/fundTransferSuccessPage")
	public ModelAndView getFundTransfer(@Valid @RequestParam("sourceMobileNo")String sourceMobileNo,@Valid @RequestParam("destinationMobileNo")String destinationMobileNo, @RequestParam("wallet.balance")BigDecimal amount) {
		Customer customer=walletService.fundTransfer(sourceMobileNo, destinationMobileNo, amount);
		return new ModelAndView("fundTransferSuccessPage", "customer", customer);
	}
	
}

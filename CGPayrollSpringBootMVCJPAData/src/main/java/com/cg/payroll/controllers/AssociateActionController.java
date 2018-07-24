package com.cg.payroll.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;

@Controller
public class AssociateActionController {
	@Autowired
	PayrollServices payrollService;
	
	@Transactional
	@RequestMapping(value="/registerAssociate")
	public ModelAndView registerAssociate(@ModelAttribute("associate")Associate associate ,  BindingResult result) {
		associate=payrollService.acceptAssociateDetails(associate);
		return new ModelAndView("registrationSuccessPage","associate",associate);
	}
	
	@RequestMapping(value="/associateDetailsSuccessPage")
	public ModelAndView getassociateDetailsPage(@Valid @RequestParam("associateID")int associateID) throws AssociateDetailsNotFoundException {
		Associate associate=payrollService.getAssociateDetails(associateID);
		return new ModelAndView("associateDetailsSuccessPage", "associate", associate);
	}

	@RequestMapping(value="/allAssociatesDetailsSuccessPage")
	public ModelAndView getAllassociateDetailsPage() throws AssociateDetailsNotFoundException {
		ArrayList<Associate> associate=payrollService.getAllAssociatesDetails();
		return new ModelAndView("allAssociatesDetailsSuccessPage", "associate", associate);
	}
}

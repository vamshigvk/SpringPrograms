package com.cg.payroll.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.payroll.beans.Associate;


@Controller
public class URIController {
	@RequestMapping(value="/")
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping(value="/registrationPage")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	
	@RequestMapping(value="/associateDetailsPage")
	public String getAssociatesDetailsPage() {
		return "associateDetailsPage";
	}
	
	@RequestMapping(value="/allAssociatesDetailsPage")
	public String getAllAssociatesDetailsPage() {
		return "allAssociatesDetailsPage";
	}
	
	@ModelAttribute("associate")
	public Associate associate(){
		return new Associate();
	}
	
}

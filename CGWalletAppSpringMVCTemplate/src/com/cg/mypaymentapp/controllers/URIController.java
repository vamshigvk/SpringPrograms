package com.cg.mypaymentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class URIController {
	@RequestMapping(value="/")
	public String getIndexPage() {
		return "indexPage";
	}
	@RequestMapping(value="/loginPage")
	public String getLoginPage() {
		return "loginPage";
	}
	@RequestMapping(value="/registrationPage")
	public String getRegistrationPage() {
		return "registrationPage";
	}
}

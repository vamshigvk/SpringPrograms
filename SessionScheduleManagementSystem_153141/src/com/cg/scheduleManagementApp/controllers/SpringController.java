package com.cg.scheduleManagementApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.scheduleManagementApp.beans.ScheduledSessions;
import com.cg.scheduleManagementApp.exceptions.ScheduleManagementNotFound;
import com.cg.scheduleManagementApp.services.ITrainingService;

@Controller
public class SpringController {
	//Autowiring services
	@Autowired
	ITrainingService TrainingServices;
	
	@RequestMapping(value="/")
	public ModelAndView getAllSessions() {
		List<ScheduledSessions> sessions;
		try {
			sessions = TrainingServices.getAllSessions();
		} catch (ScheduleManagementNotFound e) {
			return new ModelAndView("getAllSessions","errorPage",e.getMessage());
		}
		return new ModelAndView("getAllSessions","ScheduledSessions",sessions);	
	}
		
	@RequestMapping(value="/getDetails/{name}",method=RequestMethod.GET)  
    public ModelAndView edit(@PathVariable String name){
		return new ModelAndView("success","enroll",name);
	}
	
}

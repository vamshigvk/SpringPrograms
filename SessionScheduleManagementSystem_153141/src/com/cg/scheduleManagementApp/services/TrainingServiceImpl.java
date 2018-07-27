package com.cg.scheduleManagementApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.scheduleManagementApp.beans.ScheduledSessions;
import com.cg.scheduleManagementApp.exceptions.ScheduleManagementNotFound;
import com.cg.scheduleManagementApp.repo.ITrainingDAO;
@Component(value = "TrainingServices")
public class TrainingServiceImpl implements ITrainingService{
	
	@Autowired(required=true)
	ITrainingDAO repo;
	
	@Override
	public List<ScheduledSessions> getAllSessions() throws ScheduleManagementNotFound{
	
		return repo.findAll();
	}
	
}

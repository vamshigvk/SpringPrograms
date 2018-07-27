package com.cg.scheduleManagementApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.scheduleManagementApp.beans.ScheduledSessions;


public interface ITrainingDAO extends JpaRepository<ScheduledSessions, Integer>{

}

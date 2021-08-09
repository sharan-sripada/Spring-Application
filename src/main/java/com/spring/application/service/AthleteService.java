package com.spring.application.service;

import com.spring.application.entity.Athlete;

import java.util.List;

public interface AthleteService {

	public List<Athlete> findAll();
	
	public Athlete findById(int theId);
	
	public Athlete save(Athlete athlete);
	
	public void deleteById(int theId);

	
}

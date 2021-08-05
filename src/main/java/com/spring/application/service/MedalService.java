package com.spring.application.service;

import com.spring.application.entity.Country;
import com.spring.application.entity.Medal;

import java.util.List;

public interface MedalService {

	public List<Medal> findAll();
	
	public Medal findById(int theId);
	
	public void save(Medal medal);
	
	public void deleteById(int theId);

	
}

package com.spring.application.service;

import com.spring.application.dao.AthleteRepository;
import com.spring.application.entity.Athlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AthleteServiceImpl implements AthleteService {

	private AthleteRepository athleteRepository;
	
	@Autowired
	public AthleteServiceImpl(AthleteRepository theAthleteRepository) {
		athleteRepository = theAthleteRepository;
	}
	
	@Override
	@Transactional
	public List<Athlete> findAll() {
		return athleteRepository.findAll();
	}

	@Override
	@Transactional
	public Athlete findById(int theId) {
		Optional<Athlete> result = athleteRepository.findById(theId);
		Athlete athlete=null;
		if(result.isPresent()){
			athlete=result.get();
		}
		else {
			throw new RuntimeException("No athlete with id:"+theId);
		}
		return athlete;
	}

	@Override
	@Transactional
	public Athlete save(Athlete athlete) {
		athleteRepository.save(athlete);
        return athlete;
    }

	@Override
	@Transactional
	public void deleteById(int theId) {
		athleteRepository.deleteById(theId);
	}


}







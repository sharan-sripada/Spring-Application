package com.spring.application.service;

import com.spring.application.dao.MedalRepository;
import com.spring.application.entity.Medal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedalServiceImpl implements MedalService {

	private MedalRepository medalRepository;
	
	@Autowired
	public MedalServiceImpl(MedalRepository theMedalRepository) {
		medalRepository = theMedalRepository;
	}
	
	@Override
	@Transactional
	public List<Medal> findAll() {
		return medalRepository.findAll();
	}

	@Override
	@Transactional
	public Medal findById(int theId) {
		Optional<Medal> result = medalRepository.findById(theId);
		Medal medal=null;
		if(result.isPresent()){
			medal=result.get();
		}
		else {
			throw new RuntimeException("No medal with id:"+theId);
		}
		return medal;
	}

	@Override
	@Transactional
	public Medal save(Medal medal) {
		medalRepository.save(medal);
		return medal;
	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		medalRepository.deleteById(theId);
	}


}







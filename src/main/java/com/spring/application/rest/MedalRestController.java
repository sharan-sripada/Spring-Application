package com.spring.application.rest;

import com.spring.application.entity.Country;
import com.spring.application.entity.Medal;
import com.spring.application.service.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MedalRestController {

	private MedalService medalService;


	@Autowired
	public MedalRestController(MedalService theMedalService) {
		medalService = theMedalService;

	}

	@GetMapping("/medals")
	public List<Medal> findAll() {
		return medalService.findAll();
	}


	@GetMapping("/medals/{medalId}")
	public Medal getMedal(@PathVariable int medalId) {

		Medal theMedal = medalService.findById(medalId);

		if (theMedal == null) {
			throw new RuntimeException("Medal id not found - " + medalId);
		}

		return theMedal;
	}


	@PostMapping("/medals")
	public Medal addMedal(@RequestBody Medal medal) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		medal.setId(0);

		medalService.save(medal);

		return medal;
	}


	@PutMapping("/medal")
	public Medal updateMedal(@RequestBody Medal medal) {

		medalService.save(medal);

		return medal;
	}


	@DeleteMapping("/medals/{medalId}")
	public String deleteMedal(@PathVariable int medalId) {

		Medal tempMedal = medalService.findById(medalId);

		// throw exception if null

		if (tempMedal == null) {
			throw new RuntimeException("Medal id not found - " + medalId);
		}

		medalService.deleteById(medalId);
		
		return "Deleted medals id - " + medalId;
	}

}











package com.spring.application.rest;

import com.spring.application.dto.AthleteMedalDTO;
import com.spring.application.service.DTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DTOController {
    @Autowired
    private DTOService dtoService;


    @GetMapping("/dto")
    @ResponseBody
    public List<AthleteMedalDTO> getAthleteMedals(){
        List<AthleteMedalDTO> athleteMedalDTOS=dtoService.getAll();
        return athleteMedalDTOS;
    }
}

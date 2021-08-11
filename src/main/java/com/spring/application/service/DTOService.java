package com.spring.application.service;

import com.spring.application.dao.AthleteRepository;
import com.spring.application.dao.MedalRepository;
import com.spring.application.dto.AthleteMedalDTO;
import com.spring.application.entity.Athlete;
import com.spring.application.entity.Medal;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DTOService {


    @Autowired
    private MedalRepository medalRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<AthleteMedalDTO> getAll() {
        return ((List<Medal>)medalRepository
                .findAll())
                .stream()
                .map(this::convertToAthleteMedalDTO)
                .collect(Collectors.toList());
    }

    private AthleteMedalDTO convertToAthleteMedalDTO(Medal medal) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        AthleteMedalDTO athleteMedalDTO=modelMapper
                .map(medal,AthleteMedalDTO.class);
        return athleteMedalDTO;
    }
}

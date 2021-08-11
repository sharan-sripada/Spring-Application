package com.spring.application;
import com.spring.application.dao.AthleteRepository;
import com.spring.application.entity.Athlete;
import com.spring.application.service.AthleteService;

import com.spring.application.service.AthleteServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = {com.spring.application.Application.class})
public class AthleteTest  {
    @Test
    void contextLoads() {}
    private AthleteService athleteService;
    @Mock
    private AthleteRepository athleteRepository;

    @BeforeEach
    void init(){
        athleteService=new AthleteServiceImpl(athleteRepository);
    }

    @Test
    void saveAthlete_newAthlete_returnsAthlete(){
        Athlete athlete=new Athlete(10,"sai","IND",183,70);
        Mockito.when(athleteRepository.save(athlete)).thenReturn(athlete);
        Athlete athlete1=athleteService.save(athlete);
        assertThat(athlete1.getName()).isNotNull();
    }

    @Test
    void findById_whenInvoked_returnsAthlete(){
        Athlete athlete=new Athlete(5,"mike","USA",180,76);
        Mockito.when(athleteRepository.findById(5)).thenReturn(java.util.Optional.of(athlete));
        Assert.assertEquals(athlete,athleteService.findById(5));
        Mockito.verify(athleteRepository).findById(5);
    }




}

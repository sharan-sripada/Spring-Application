package com.spring.application;

import com.spring.application.dao.MedalRepository;
import com.spring.application.entity.Medal;
import com.spring.application.service.MedalService;
import com.spring.application.service.MedalServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Java6Assertions.assertThat;


@SpringBootTest(classes = {Application.class})
public class MedalTest extends ApplicationTests {
    @Test
    void contextLoads() {}
    private MedalService medalService;
    @Mock
    private MedalRepository medalRepository;

    @BeforeEach
    void init(){
        medalService=new MedalServiceImpl(medalRepository);
    }

    @Test
    void saveMedal_newMedal_returnsMedal(){
        Medal medal=new Medal(2,1,1,1);
        Mockito.when(medalRepository.save(medal)).thenReturn(medal);
        Medal medal1=medalService.save(medal);
        assertThat(medal1.getGold()).isNotNull();
    }

    @Test
    void findById_whenInvoked_returnsMedal(){
        Medal medal=new Medal(5,1,0,1);
        Mockito.when(medalRepository.findById(5)).thenReturn(java.util.Optional.of(medal));
        Assert.assertEquals(medal,medalService.findById(5));
        Mockito.verify(medalRepository).findById(5);
    }




}

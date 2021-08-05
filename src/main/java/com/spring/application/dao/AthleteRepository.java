package com.spring.application.dao;

import com.spring.application.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "athlete")
public interface AthleteRepository extends JpaRepository<Athlete,Integer> {
    //nothing to code

}

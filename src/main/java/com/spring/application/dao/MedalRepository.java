package com.spring.application.dao;

import com.spring.application.entity.Country;
import com.spring.application.entity.Medal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "medals")
public interface MedalRepository extends JpaRepository<Medal,Integer> {
    //nothing to code

}

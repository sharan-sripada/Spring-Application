package com.spring.application;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(Suite.class)
@SuiteClasses({ AthleteTest.class, MedalTest.class})
public class TestSuit extends ApplicationTests{
}

package com.spring.application.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class Logging {
    private final Logger logger = Logger.getLogger(getClass().getName());
    @Pointcut("execution(* com.spring.application.controller.*.*(..))")
    private void forControllerPackage() {}

    @Before("forControllerPackage()")
    public void before(JoinPoint joinPoint){
        String method=joinPoint.getSignature().toShortString();
        logger.info("@Before : "+method);

    }


}

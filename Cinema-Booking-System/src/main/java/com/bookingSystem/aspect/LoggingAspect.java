package com.bookingSystem.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.bookingSystem.controller.*.*(..))")
    public void logBeforeMethodCall() {
        logger.info("Method is about to be called.");
    }

    @AfterReturning(pointcut = "execution(* com.bookingSystem.controller.*.*(..))", returning = "result")
    public void logAfterMethodReturn(Object result) {
        logger.info("Method returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.bookingSystem.controller.*.*(..))", throwing = "ex")
    public void logAfterMethodThrows(Exception ex) {
        logger.error("Method threw exception: " + ex.getMessage());
    }
}


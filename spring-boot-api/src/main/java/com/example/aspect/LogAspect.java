package com.example.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by kuanchungtu on 2020/2/25
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.example.api.LogTestApi.log(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(){
        logger.info("-------------- doBefore ------------");
    }

    @After("log()")
    public void doAfter(){
        logger.info("-------------- doAfter ------------");
    }


    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result){
        logger.info("-------------- doAfterReturning ------------: 內容 {} ", result);
    }
}

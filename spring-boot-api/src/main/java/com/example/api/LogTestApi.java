package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kuanchungtu on 2020/2/25
 */
@RestController
public class LogTestApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/log")
    public String log(){

        String name = "abc";
        String email = "abc@111.com";
        logger.info(" ---------------- log ----------------");
//        logger.warn("warn ---- log");
//        logger.error("error --- log");
//        logger.debug("debug --- log");
//        logger.trace("debug --- log");
//        logger.info("name : {}, email : {}", name, email);

        return "logtest";

    }
}

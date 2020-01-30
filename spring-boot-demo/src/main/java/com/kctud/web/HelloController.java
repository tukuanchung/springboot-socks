package com.kctud.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Created by KCTUD on 2019/01/30
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "Hello Spring boot";
    }
}

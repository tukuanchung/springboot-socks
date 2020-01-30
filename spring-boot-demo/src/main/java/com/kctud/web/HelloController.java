package com.kctud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *  Created by KCTUD on 2019/01/30
 */
//@RestController
@Controller
@RequestMapping("/api")
public class HelloController {

//    @RequestMapping(value="/say", method=RequestMethod.GET)
//    @RequestMapping("/say")
    @PostMapping("/say")
    public String hello(){
        return "Hello Spring boot";
    }

    @GetMapping("/books")
    @ResponseBody
    public Object getAll(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","hello");
        map.put("age","18");
        return map;
    }
}

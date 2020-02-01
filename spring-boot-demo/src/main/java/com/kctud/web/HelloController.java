package com.kctud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *  Created by KCTUD on 2019/01/30
 */
@RestController
//@Controller
@RequestMapping("/api/v1")
public class HelloController {

//    @RequestMapping(value="/say", method=RequestMethod.GET)
//    @RequestMapping("/say")
    @PostMapping("/say")
    public String hello(){
        return "Hello Spring boot";
    }

    @GetMapping("/books")
//    @ResponseBody
    public Object getAll(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","hello");
        map.put("age","18");
        return map;
    }

    /**
     * regexPattern: {paramName:regexPattern}
     * @param id
     * @param username
     * @return
     */
    @GetMapping("/books/{id}/{username:[a-z_]+}")
    public Object getOne(@PathVariable long id, @PathVariable String username){
        System.out.print(" --- id: " + id + "  username:" + username);
        Map<String, Object> book = new HashMap<>();
        book.put("name","愛在飛行");
        book.put("isbn","10100000200");
        book.put("author","杜貫仲");
        book.put("username",username);
        return book;
    }
}

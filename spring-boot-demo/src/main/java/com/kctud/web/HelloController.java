package com.kctud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public Object getAll(@RequestParam("page") int page, @RequestParam(value = "size", defaultValue = "10") int size){
        Map<String, Object> book = new HashMap<>();
        book.put("name","愛在飛行");
        book.put("isbn","10100000200");
        book.put("author","杜貫仲");

        Map<String, Object> book2 = new HashMap<>();
        book2.put("name","程序員的思維");
        book2.put("isbn","10100003330");
        book2.put("author","劉德華");

        List<Map> contents = new ArrayList<>();
        contents.add(book);
        contents.add(book2);

        Map<String, Object> pagemap = new HashMap<>();
        pagemap.put("page",page);
        pagemap.put("size", size);
        pagemap.put("content", contents);
        return pagemap;
    }

    /**
     * regexPattern: {paramName:regexPattern}
     * @param id
     * @param username
     * @return
     */
    @GetMapping("{id}/books/{username:[a-z_]+}")
    public Object getOne(@PathVariable long id, @PathVariable String username){
        System.out.print(" --- id: " + id + "  username:" + username);
        Map<String, Object> book = new HashMap<>();
        book.put("name","愛在飛行");
        book.put("isbn","10100000200");
        book.put("author","杜貫仲");
        book.put("username",username);
        return book;
    }

    @PostMapping("/books")
    public Object post(@RequestParam("name") String name,
                       @RequestParam("author") String author,
                       @RequestParam("isbn") String isbn){

        Map<String, Object> book = new HashMap<String, Object>();
        book.put("name", name);
        book.put("author", author);
        book.put("isbn", isbn);
        return book;
    }
}

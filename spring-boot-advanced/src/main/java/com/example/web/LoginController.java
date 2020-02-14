package com.example.web;

import com.example.dmain.User;
import com.example.dmain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kuanchungtu on 2020/2/13
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/register")
    public String registerPost(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email,
                               @RequestParam Integer phone){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        userRepository.save(user);
        return "redirect:/login";
    }
}

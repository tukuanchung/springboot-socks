package com.example.web;

import com.example.dmain.User;
import com.example.dmain.UserRepository;
import com.example.form.UserForm;
import com.example.form.UserFormConvert;
import org.springframework.beans.BeanUtils;
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
    public String registerPage(){
        return "register";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/register")
    public String register(UserForm userForm){
       User user = new UserFormConvert().convert(userForm);
       userRepository.save(user);
       return "redirect:/login";
    }

}

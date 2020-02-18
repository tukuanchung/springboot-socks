package com.example.web;

import com.example.dmain.User;
import com.example.dmain.UserRepository;
import com.example.form.UserForm;
import com.example.form.UserFormConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by kuanchungtu on 2020/2/13
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("userForm", new UserForm());
        return "register";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result, Model model){

        if(!userForm.confirmPassword()){
            result.rejectValue("confirmPassword","confirmError","密碼不一至");
        }

        if(result.hasErrors()){
          return "register";
        }
        User user = userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/exception")
    public String testException(){
        throw new RuntimeException();
    }

}

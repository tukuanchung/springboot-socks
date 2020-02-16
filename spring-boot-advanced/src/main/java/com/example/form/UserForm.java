package com.example.form;

import com.example.dmain.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Created by kuanchungtu on 2020/2/14
 */
public class UserForm {

    public static final String PHONE_REG= "[0-9]{4}[0-9]{6}";

    @NotBlank
    private String username;
    @NotBlank
    @Length(min = 6, message ="密碼至少需要6位")
    private String password;
    @Pattern(regexp = PHONE_REG, message = "請輸入正確手機號碼")
    private String phone;
    @Email
    private String email;
    @NotBlank
    private String confirmPassword;

    public UserForm(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean confirmPassword(){
        if(this.password.equals(this.confirmPassword)){
            return true;
        }
        return false;
    }

    public User convertToUser(){
        User user = new UserFormConvert().convert(this);
        return user;
    }

    private class UserFormConvert implements FormConvert<UserForm, User>{

        @Override
        public User convert(UserForm userForm) {
            User user = new User();
            BeanUtils.copyProperties(userForm, user);
            return user;
        }
    }
}

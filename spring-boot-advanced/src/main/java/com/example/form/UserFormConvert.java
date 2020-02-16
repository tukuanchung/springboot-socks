package com.example.form;

import com.example.dmain.User;
import org.springframework.beans.BeanUtils;

/**
 * Created by kuanchungtu on 2020/2/14
 */
public class UserFormConvert implements  FormConvert<UserForm, User>{


    @Override
    public User convert(UserForm userForm) {
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return user;
    }
}

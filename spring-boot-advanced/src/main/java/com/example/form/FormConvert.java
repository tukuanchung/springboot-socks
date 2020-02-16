package com.example.form;

/**
 * Created by kuanchungtu on 2020/2/14
 */
public interface FormConvert<S, T>{
    T convert(S s);
}

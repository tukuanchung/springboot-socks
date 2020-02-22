package com.example.dto;

/**
 * Created by kuanchungtu on 2020/2/22
 */
public interface Convert<S, T> {

    T convert(S s, T t);

    T convert(S s);
}

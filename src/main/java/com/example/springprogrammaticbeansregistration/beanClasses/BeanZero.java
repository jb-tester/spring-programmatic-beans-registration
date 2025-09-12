package com.example.springprogrammaticbeansregistration.beanClasses;


import org.springframework.beans.factory.annotation.Autowired;

public class BeanZero {
    @Autowired private BeanOne one;

    public BeanOne getOne() {
        return one;
    }
}

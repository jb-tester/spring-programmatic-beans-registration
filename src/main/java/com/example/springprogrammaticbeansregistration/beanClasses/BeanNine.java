package com.example.springprogrammaticbeansregistration.beanClasses;


import org.springframework.beans.factory.annotation.Autowired;

public class BeanNine {
    @Autowired
    BeanTen beanTen;

    public BeanTen getBeanTen() {
        return beanTen;
    }
}

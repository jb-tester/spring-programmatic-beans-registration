package com.example.springprogrammaticbeansregistration.beanClasses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;

public class BeanNine {
    @Autowired
    BeanTen beanTen;

    public BeanTen getBeanTen() {
        return beanTen;
    }
}

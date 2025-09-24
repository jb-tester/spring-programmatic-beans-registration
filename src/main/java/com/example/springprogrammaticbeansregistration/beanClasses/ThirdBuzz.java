package com.example.springprogrammaticbeansregistration.beanClasses;

import org.springframework.stereotype.Service;


public class ThirdBuzz implements Buzz {

    @Override
    public String getId() {
        return "Buzz_3";
    }
}
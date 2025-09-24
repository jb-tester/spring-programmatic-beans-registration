package com.example.springprogrammaticbeansregistration.beanClasses;

import org.springframework.stereotype.Service;


public class SecondBuzz implements Buzz {

    @Override
    public String getId() {
        return "Buzz_2";
    }
}
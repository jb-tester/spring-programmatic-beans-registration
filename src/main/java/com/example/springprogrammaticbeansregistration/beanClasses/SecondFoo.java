package com.example.springprogrammaticbeansregistration.beanClasses;

import org.springframework.stereotype.Service;

@Service
public class SecondFoo implements Foo {

    @Override
    public String getId() {
        return "Foo_2";
    }
}
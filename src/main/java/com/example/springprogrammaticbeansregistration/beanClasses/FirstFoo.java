package com.example.springprogrammaticbeansregistration.beanClasses;

import org.springframework.stereotype.Service;

@Service
public class FirstFoo implements Foo {

    @Override
    public String getId() {
        return "Foo_1";
    }
}


    
package com.example.springprogrammaticbeansregistration.beanClasses;

import org.springframework.stereotype.Service;

@Service
public class ThirdFoo implements Foo {

    @Override
    public String getId() {
        return "Foo_3";
    }
}
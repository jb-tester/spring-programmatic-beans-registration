package com.example.springprogrammaticbeansregistration;


import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class SomeEmptyRegistrar implements BeanRegistrar {
    @Override
    public void register(BeanRegistry registry, Environment env) {

    }
}

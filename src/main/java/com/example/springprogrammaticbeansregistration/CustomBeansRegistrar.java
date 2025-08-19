package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.BeanZero;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;


public class CustomBeansRegistrar implements BeanRegistrar {
    @Override
    public void register(BeanRegistry registry, Environment env) {
        registry.registerBean("zero", BeanZero.class);
    }
}

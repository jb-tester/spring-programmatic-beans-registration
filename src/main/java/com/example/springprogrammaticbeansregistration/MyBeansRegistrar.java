package com.example.springprogrammaticbeansregistration;


import com.example.springprogrammaticbeansregistration.beanClasses.BeanNine;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanTen;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

// just some registrar that is registered programmatically in another registrar
// (RegistrarOfRegistrars)
// this configuration is not recognized by IDEA, thus the beans `bean9` and `bean10` are not shown as beans anywhere
public class MyBeansRegistrar implements BeanRegistrar {

    @Override
    public void register(BeanRegistry registry, Environment environment) {
        registry.registerBean("bean9", BeanNine.class);
        registry.registerBean("bean10", BeanTen.class);
    }
}
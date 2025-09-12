package com.example.springprogrammaticbeansregistration;


import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

// registrar of registrar
public class RegistrarOfRegistrars implements BeanRegistrar {
    @Override
    public void register(BeanRegistry registry, Environment env) {
        registry.register(new MyBeansRegistrar());
    }
}

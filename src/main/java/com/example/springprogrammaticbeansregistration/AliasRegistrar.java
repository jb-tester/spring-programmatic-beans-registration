package com.example.springprogrammaticbeansregistration;


import com.example.springprogrammaticbeansregistration.beanClasses.BeanEleven;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanTwelve;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class AliasRegistrar implements BeanRegistrar {
    @Override
    public void register(BeanRegistry registry, Environment env) {
        registry.registerBean( BeanEleven.class, customizer -> customizer.supplier(
                ctx -> new BeanEleven("b11_0"){}
        ));
        registry.registerBean( BeanEleven.class, customizer -> customizer.supplier(
                ctx -> new BeanEleven("b11_1"){}
        ));

        registry.registerAlias("com.example.springprogrammaticbeansregistration.beanClasses.BeanEleven#0", "alias11_1");
        registry.registerAlias("com.example.springprogrammaticbeansregistration.beanClasses.BeanEleven#1", "alias11_2");
        registry.registerBean("twelve", BeanTwelve.class,
                customizer -> customizer.supplier(
                        (context) ->
                                new BeanTwelve(context.bean("alias11_2", BeanEleven.class))
                ));
    }
}

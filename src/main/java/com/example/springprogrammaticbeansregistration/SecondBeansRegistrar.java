package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.BeanSeven;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanSix;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

import java.util.Random;


public class SecondBeansRegistrar implements BeanRegistrar {
    @Override
    public void register(BeanRegistry registry, Environment env) {
        registry.registerBean("bean6", BeanSix.class, spec -> spec
                .prototype()
                .supplier(ctx -> new BeanSix(new Random().nextInt(10)))
        );
        registry.registerBean("bean71", BeanSeven.class, spec -> spec
                .supplier(ctx -> new BeanSeven(ctx.bean(BeanSix.class), 1)));
        registry.registerBean("bean72", BeanSeven.class, spec -> spec
                .supplier(ctx -> new BeanSeven(ctx.bean(BeanSix.class), 2)));
        registry.registerBean("bean73", BeanSeven.class, spec -> spec
                .supplier(ctx -> new BeanSeven(ctx.bean(BeanSix.class), 3)));
    }
}

package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.Buzz;
import com.example.springprogrammaticbeansregistration.beanClasses.FirstBuzz;
import com.example.springprogrammaticbeansregistration.beanClasses.SecondBuzz;
import com.example.springprogrammaticbeansregistration.beanClasses.ThirdBuzz;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

/**
 * *
 * <p>Created by Irina on 9/24/2025.</p>
 * *
 */
public class SameTypeBeansRegistrar implements BeanRegistrar {
    @Override
    public void register(BeanRegistry registry, Environment env) {
        registry.registerBean(
                Buzz.class,
                (BeanRegistry.Spec<Buzz> spec) -> spec
                        .supplier(ctx -> new FirstBuzz() {
                        })
        );
        registry.registerBean(
                Buzz.class,
                (BeanRegistry.Spec<Buzz> spec) -> spec
                        .supplier(ctx -> new SecondBuzz() {
                        })
        );
        registry.registerBean("thirdBuzz",
                Buzz.class,
                (BeanRegistry.Spec<Buzz> spec) -> spec
                        .supplier(ctx -> new ThirdBuzz() {
                        })
        );
    }
}

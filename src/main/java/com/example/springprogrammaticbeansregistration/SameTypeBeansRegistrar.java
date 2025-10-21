package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.Buzz;
import com.example.springprogrammaticbeansregistration.beanClasses.FirstBuzz;
import com.example.springprogrammaticbeansregistration.beanClasses.SecondBuzz;
import com.example.springprogrammaticbeansregistration.beanClasses.ThirdBuzz;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;


public class SameTypeBeansRegistrar implements BeanRegistrar {

    // incorrect implict names are detected:
    // the implementation type is used for the name composing instead of`
    // the declared type (interface type), like
    // `FirstBuzz#0` and `SecondBuzz#0` instead of `Buzz#0` and `Buzz#1`
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

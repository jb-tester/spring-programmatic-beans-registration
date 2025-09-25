package com.example.springprogrammaticbeansregistration;


import com.example.springprogrammaticbeansregistration.beanClasses.BeanEight;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanFive;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanFour;
import com.example.springprogrammaticbeansregistration.beanClasses.Foo;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

// dependent beans registration:
// observe the beans diagram: the dependent beans are shown incorrectly
// also, the beans dependencies are not shown in Structure
// feature proposals: provide completion for bean names
// provide inspection for not satisified dependencies?
public class DependentBeansRegistrar implements BeanRegistrar {
    // observe the beans diagram: the dependent beans are shown incorrectly
    @Override
    public void register(BeanRegistry registry, Environment environment) {

        registry.registerBean("four", BeanFour.class
                , customizer -> customizer.supplier(
                        // would be nice to have the bean name completion here - we select specific existing bean `firstFoo` of the interface type
                        context -> new BeanFour(context.bean("firstFoo", Foo.class))));
        registry.registerBean("eight1", BeanEight.class);
        registry.registerBean("eight2", BeanEight.class);
        // primary bean:
        registry.registerBean("eight3", BeanEight.class,
                customizer -> customizer.primary()
        );
        registry.registerBean("five", BeanFive.class,
                customizer -> {
                    customizer.supplier(
                            context -> new BeanFive(
                                    context.bean(BeanFour.class),
                                    // would be nice to have the bean name completion here
                                    context.bean("eight1", BeanEight.class)));
                });
        registry.registerBean("five2", BeanFive.class,
                customizer -> {
                    customizer.supplier(
                            context -> new BeanFive(
                                    context.bean(BeanFour.class),
                                    // would be nice to have the bean name completion here
                                    context.bean("eight2", BeanEight.class)));
                });

    }
}
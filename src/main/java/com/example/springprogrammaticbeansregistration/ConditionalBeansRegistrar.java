package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.BeanThree;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

// conditional registration of beans:
// actually the attempt to autowire bean of type BeanThree shows the 'multiple beans of the same type' error
// we should switch off the error for conditional beans autowiring since we can't evaluate the conditions in runtime
public class ConditionalBeansRegistrar implements BeanRegistrar {
    @Override
    public void register(BeanRegistry registry, Environment env) {
        // conditional registration; profiles
        if (env.matchesProfiles("profile1", "profile2")) {
            registry.registerBean("three", BeanThree.class, spec -> spec.supplier(context -> new BeanThree("bean three from profile1 or profile2")));
        } else {
            registry.registerBean("alt_three", BeanThree.class, spec -> spec.supplier(context -> new BeanThree("bean three default")));
        }
    }
}

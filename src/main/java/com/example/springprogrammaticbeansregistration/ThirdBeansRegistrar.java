package com.example.springprogrammaticbeansregistration;


import com.example.springprogrammaticbeansregistration.beanClasses.*;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class ThirdBeansRegistrar implements BeanRegistrar {
// observe the beans diagram: the dependent beans are shown incorrectly
	@Override
	public void register(BeanRegistry registry, Environment environment) {

		registry.registerBean("four", BeanFour.class
		, customizer -> customizer.supplier(context -> new BeanFour(context.bean("firstFoo", Foo.class))));// would be nice to have bean name completion here
		registry.registerBean("eight1", BeanEight.class);
		registry.registerBean("eight2", BeanEight.class);
		registry.registerBean("five", BeanFive.class,
				customizer -> {
					customizer.supplier(context -> new BeanFive(
							context.bean(BeanFour.class),
							context.bean("eight1", BeanEight.class))); // would be nice to have bean name completion here
				});

	}
}
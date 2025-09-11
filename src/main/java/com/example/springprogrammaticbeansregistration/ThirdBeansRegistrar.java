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
		, customizer -> customizer.supplier(
						// would be nice to have the bean name completion here - we select the specific bean of the interface type
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

	}
}
package com.example.springprogrammaticbeansregistration;


import com.example.springprogrammaticbeansregistration.beanClasses.BeanTwo;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanThree;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanOne;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanZero;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class SimpleBeansRegistrar implements BeanRegistrar {

	@Override
	public void register(BeanRegistry registry, Environment environment) {
		// bean w/o dependencies; default scope; implicit name
		registry.registerBean(BeanZero.class);
		// bean with explicit name; default scope; has String-type constructor
		registry.registerBean("one", BeanOne.class, spec -> spec.supplier(context -> new BeanOne("bean one")));
		// explicit name, custom description; depends on other bean
		registry.registerBean("two", BeanTwo.class,
				customizer -> {
					customizer.description("bean two depending on bean one description");
					customizer.supplier(context -> new BeanTwo(context.bean(BeanOne.class)));
				});

	}
}
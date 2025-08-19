package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.BeanOne;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanThree;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanTwo;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanZero;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringProgrammaticBeansRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProgrammaticBeansRegistrationApplication.class, args);
    }
       @Bean
           public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
               return args -> {
                   System.out.println("--------------------------------------");
                   System.out.println("Let's inspect the beans provided by Spring Boot:");
                   System.out.println("BeanZero: ");
                   ctx.getBeansOfType(BeanZero.class).forEach((name, bean) -> System.out.println(name));
                   System.out.println("BeanOne: ");
                   ctx.getBeansOfType(BeanOne.class).forEach((name, bean) -> System.out.println(name));
                   System.out.println("BeanTwo: ");
                   ctx.getBeansOfType(BeanTwo.class).forEach((name, bean) -> System.out.println(name));
                   System.out.println("BeanThree: ");
                   ctx.getBeansOfType(BeanThree.class).forEach((name, bean) -> System.out.println(name));
                   System.out.println("--------------------------------------");
               };
           }
}

package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.Buzz;
import com.example.springprogrammaticbeansregistration.beanClasses.FirstBuzz;
import com.example.springprogrammaticbeansregistration.beanClasses.SecondBuzz;
import com.example.springprogrammaticbeansregistration.beanClasses.ThirdBuzz;
import com.jayway.jsonpath.internal.function.sequence.First;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SameTypeBeansRegistrationTests {

     // Referencing by declaration type (interface) with name qualifier:
    // implicit names:
    // ~~doesn't navigate to the proper bean definition - navigates to the first implicit-name bean instead~~
    // Update: not resolved qualifiers, no navigation at all:
    // we incorrectly consider the names to be
    // `com.example.springprogrammaticbeansregistration.beanClasses.FirstBuzz#0`
    // and `com.example.springprogrammaticbeansregistration.beanClasses.SecondBuzz#0`

    @Qualifier("com.example.springprogrammaticbeansregistration.beanClasses.Buzz#0")
    @Autowired
    private Buzz buzz1_qualified;

    @Qualifier("com.example.springprogrammaticbeansregistration.beanClasses.Buzz#1")
    @Autowired
    private Buzz buzz2_qualified;

    // explicit name:
    @Qualifier("thirdBuzz")
    @Autowired
    private Buzz buzz3_qualified;

     // referencing by the implementation type:
    // ~~the beans are not found by their specific type (false-positive errors)~~ - FIXED
    @Autowired
    private FirstBuzz buzz1;
    @Autowired
    private SecondBuzz buzz2;
    @Autowired
    private ThirdBuzz buzz3;

    @Autowired
    ApplicationContext ctx;

    @Test
    public void notNullTest() {
        assertNotNull(buzz1_qualified);
        assertNotNull(buzz2_qualified);
        assertNotNull(buzz3_qualified);
        assertNotNull(buzz1);
        assertNotNull(buzz2);
        assertNotNull(buzz3);
    }

    @Test
    void displayBeanNames() {
        Map<String, Buzz> buzzbeans = ctx.getBeansOfType(Buzz.class);
        System.out.println("===Buzz-type beans:");
        buzzbeans.forEach((k, v) -> System.out.println("bean name: " + k + ", bean class: " + v.getClass()));
        System.out.println("===FirstBuzz-type beans:");
        Map<String, FirstBuzz> firstBuzzMap = ctx.getBeansOfType(FirstBuzz.class);
        firstBuzzMap.forEach((k, v) -> System.out.println("bean name: " + k + ", bean class: " + v.getClass()));
        System.out.println("===SecondBuzz-type beans:");
        Map<String, SecondBuzz> secondBuzzMap = ctx.getBeansOfType(SecondBuzz.class);
        secondBuzzMap.forEach((k, v) -> System.out.println("bean name: " + k + ", bean class: " + v.getClass()));
        System.out.println("===ThirdBuzz-type beans:");
        Map<String, ThirdBuzz> thirdBuzzMap = ctx.getBeansOfType(ThirdBuzz.class);
        thirdBuzzMap.forEach((k, v) -> System.out.println("bean name: " + k + ", bean class: " + v.getClass()));
    }
}

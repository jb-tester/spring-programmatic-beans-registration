package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.Bar;
import com.example.springprogrammaticbeansregistration.beanClasses.FirstBar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DynamicBeansRegistrationTests {

    // dynamic name/type test: dynamic type
    // uncomment here and in the DynamicBeansRegistrar class to test
    @Autowired private FirstBar bar;
    @Autowired private Bar boo;
    @Autowired SomeBean1 someBean1;
    @Autowired SomeBean2 someBean2;
    @Autowired SomeBean3 someBean3;



    @Test
    public void notNullTest() {
        //assertNotNull(bar);
        //assertNotNull(boo);
        assertNotNull(someBean1);
        assertNotNull(someBean2);
        assertNotNull(someBean3);
    }

}

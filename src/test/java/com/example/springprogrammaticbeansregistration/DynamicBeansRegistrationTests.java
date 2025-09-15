package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.Bar;
import com.example.springprogrammaticbeansregistration.beanClasses.FirstBar;
import com.example.springprogrammaticbeansregistration.beanClasses.SecondBar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DynamicBeansRegistrationTests {

    @Autowired
    ApplicationContext context;

    // dynamic name/type test: dynamic type
    // uncomment here and in the DynamicBeansRegistrar class to test
    @Autowired private FirstBar bar; // bean with no explicit name and type from method call
    @Autowired private Bar boo;  // bean with name 'boo' and type from method call
    // ====
    // dynamic name/type test: dynamic name
    @Autowired SomeBean1 someBean1;  // name from some util method call
    @Autowired SomeBean2 someBean2;  // name from constant
    @Autowired SomeBean3 someBean3;  // Objects.requireNonNull(env.getProperty())
    @Autowired SomeBean4 someBean4;  // name from env.getProperty()

    // 'normal' bean:
    @Autowired SomeBean0 bean0;



    @Test
    public void notNullTest() {
        assertNotNull(bar);
        assertNotNull(boo);
        assertNotNull(bean0);
        assertNotNull(someBean1);
        assertNotNull(someBean2);
        assertNotNull(someBean3);
    }

    @Test
    void testBeanNames() {
        assertEquals("com.example.springprogrammaticbeansregistration.beanClasses.FirstBar#0", context.getBeanNamesForType(FirstBar.class)[0]);
        assertEquals("boo", context.getBeanNamesForType(SecondBar.class)[0]);
        assertEquals("someBean0", context.getBeanNamesForType(SomeBean0.class)[0]);
        assertEquals("beanNameFromProperties1", context.getBeanNamesForType(SomeBean1.class)[0]);
        assertEquals("beanNameFromConstant", context.getBeanNamesForType(SomeBean2.class)[0]);
        assertEquals("beanNameFromProperties2", context.getBeanNamesForType(SomeBean3.class)[0]);
        assertEquals("beanNameFromProperties3", context.getBeanNamesForType(SomeBean4.class)[0]);
    }
}

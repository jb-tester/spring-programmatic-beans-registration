package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SimpleBeansRegistrationTests {

    @Autowired private BeanZero zero;
    @Autowired private BeanOne beanOne;
    @Autowired private BeanTwo beanTwo;


    @Test
    public void notNullTest() {
        assertNotNull(beanOne);
        assertNotNull(beanTwo);
        assertNotNull(zero);
    }

    @Test
    void testAutowiring() {
        assertEquals("bean one", beanOne.id());
        assertEquals(zero.getOne().id(), beanOne.id());
        assertEquals(beanTwo.beanOne().id(), beanOne.id());
    }
}

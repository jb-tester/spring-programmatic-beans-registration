package com.example.springprogrammaticbeansregistration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PrimaryFallbackNotautowirableBeansRegistrationTest {

    // multiple candidates instead of 1 primary - FIXED
    @Autowired
    TestBean1 testBean1;
    // multiple candidates instead of 1 non-fallback:
    @Autowired
    TestBean2 testBean2;
    // multiple candidates instead of 1 that is not notAutowirable:
    @Autowired
    TestBean3 testBean3;

    @Test
    void primaryBeansTest() {
        assertNotNull(testBean1);
        assertEquals("tb11", testBean1.getId());
    }
    @Test
    void fallbackBeansTest() {
        assertNotNull(testBean2);
        assertEquals("tb22", testBean2.getId());
    }
    @Test
    void notAutowirableBeansTest() {
        assertNotNull(testBean3);
        assertEquals("tb32", testBean3.getId());
    }
}

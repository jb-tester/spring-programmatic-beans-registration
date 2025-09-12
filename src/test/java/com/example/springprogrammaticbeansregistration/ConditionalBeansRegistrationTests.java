package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ConditionalBeansRegistrationTests {


    // these beans are defined as if-else alternatives, should be no error
    @Autowired private BeanThree beanThree;

    @Test
    public void notNullTest() {
        assertNotNull(beanThree) ;
    }

}

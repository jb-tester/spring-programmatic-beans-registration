package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DependentBeansRegistrationTests {


    @Autowired private BeanFour beanFour;
    @Qualifier("five1")
    @Autowired private BeanFive beanFive;

    // one of the beans is defined as primary, should be no errors - fixed
    @Autowired private BeanEight beanEight;
    // qualified autowiring is ok:
    @Autowired private BeanEight eight2;
    @Qualifier("eight1") @Autowired private BeanEight b8;



    @Test
    public void notNullTest() {

        assertNotNull(beanFour);
        assertNotNull(beanFive);
        assertNotNull(beanEight);
        assertNotNull(eight2);

    }

}

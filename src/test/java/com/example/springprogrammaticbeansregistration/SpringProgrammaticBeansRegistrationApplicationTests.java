package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringProgrammaticBeansRegistrationApplicationTests {

    @Autowired private BeanZero zero;
    @Autowired private BeanOne beanOne;
    @Autowired private BeanTwo beanTwo;
    // these beans are defined as alternatives, should be no error
    @Autowired private BeanThree beanThree;
    @Autowired private BeanFour beanFour;
    @Autowired private BeanFive beanFive;
    // one of the beans is defined as primary, should be no errors
    @Autowired private BeanEight beanEight;
    @Autowired private BeanEight eight2;
    @Qualifier("eight1") @Autowired private BeanEight b8;



    @Test
    public void contextLoads() {
        assert zero != null;
        assert beanOne != null;
        assert beanTwo != null;
        assert beanThree != null;
        assert beanFour != null;
        assert beanFive != null;
        assert beanEight != null;
    }

}

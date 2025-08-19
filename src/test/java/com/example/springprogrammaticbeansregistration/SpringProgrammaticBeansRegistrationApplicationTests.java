package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.BeanOne;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanThree;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanZero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringProgrammaticBeansRegistrationApplicationTests {

    @Autowired private BeanZero zero;
    @Autowired private BeanOne beanOne;
    @Autowired private BeanThree beanThree;
    @Test
    void contextLoads() {
        assert zero != null;
        assert beanOne != null;
        assert beanThree != null;
    }

}

package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.BeanOne;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanThree;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanTwo;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanZero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringProgrammaticBeansRegistrationApplicationTests {

    @Autowired private BeanZero zero;
    @Autowired private BeanOne beanOne;
    @Autowired private BeanTwo beanTwo;
    @Autowired private BeanThree beanThree;

    @Test
    public void contextLoads() {
        assert zero != null;
        assert beanOne != null;
        assert beanTwo != null;
        assert beanThree != null;
    }

}

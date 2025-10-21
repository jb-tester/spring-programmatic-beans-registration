package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.BeanEleven;
import com.example.springprogrammaticbeansregistration.beanClasses.BeanTwelve;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AliasRegistrationTests {

    // aliases are not resolved - fixed; alias completion - fixed.
    // alias rename doesn't work, but this is minor
    @Qualifier("alias11_1")
    @Autowired
    private BeanEleven beanEleven1;
    @Qualifier("alias11_2")
    @Autowired
    private BeanEleven beanEleven2;

    @Autowired
    private BeanTwelve beanTwelve;

    @Test
    void testNotNull() {
        assertNotNull(beanEleven1);
        assertNotNull(beanEleven2);
        assertNotNull(beanTwelve);
    }

    @Test
    void testInjectedBean() {
        assertEquals("b11_0", beanEleven1.getId());
        assertEquals("b11_1", beanEleven2.getId());
        assertEquals("b11_1", beanTwelve.bean().getId());
    }
}

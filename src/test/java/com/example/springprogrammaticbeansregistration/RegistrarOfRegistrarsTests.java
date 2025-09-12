package com.example.springprogrammaticbeansregistration;

import com.example.springprogrammaticbeansregistration.beanClasses.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RegistrarOfRegistrarsTests {

    // registrar of registrars: bean is registered in registrar that is registered as registrar itself
    @Autowired BeanNine bean9;

    @Test
    public void notNullTest() {

        assertNotNull(bean9);
    }

}

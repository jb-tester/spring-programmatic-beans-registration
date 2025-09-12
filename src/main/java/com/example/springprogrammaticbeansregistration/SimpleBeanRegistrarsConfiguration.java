package com.example.springprogrammaticbeansregistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SimpleBeansRegistrar.class)
public class SimpleBeanRegistrarsConfiguration {

}

package com.example.springprogrammaticbeansregistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import( SameTypeBeansRegistrar.class)
class SameTypeBeansRegistrarConfiguration {

}

package com.example.springprogrammaticbeansregistration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * *
 * <p>Created by irina on 10/21/2025.</p>
 * *
 */
@Configuration
@Import(SomeEmptyRegistrar.class)
class SomeConfiguration {



}

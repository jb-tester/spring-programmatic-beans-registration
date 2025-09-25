package com.example.springprogrammaticbeansregistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(AliasRegistrar.class)
public class AliasRegistrarConfiguration {

}

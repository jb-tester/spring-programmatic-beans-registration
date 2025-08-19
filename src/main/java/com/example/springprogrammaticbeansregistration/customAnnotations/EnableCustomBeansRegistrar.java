package com.example.springprogrammaticbeansregistration.customAnnotations;

import com.example.springprogrammaticbeansregistration.CustomBeansRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CustomBeansRegistrar.class)
public @interface EnableCustomBeansRegistrar {
}

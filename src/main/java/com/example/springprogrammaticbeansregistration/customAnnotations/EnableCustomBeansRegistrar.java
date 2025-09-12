package com.example.springprogrammaticbeansregistration.customAnnotations;

import com.example.springprogrammaticbeansregistration.ImportedByCustomAnnotationBeansRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ImportedByCustomAnnotationBeansRegistrar.class)
public @interface EnableCustomBeansRegistrar {
}

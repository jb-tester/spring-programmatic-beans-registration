package com.example.springprogrammaticbeansregistration.customAnnotations;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnPropertyEqualsCondition.class)
public @interface ConditionalOnPropertyValue {

    /**
     * Name of the property to check in the Spring Environment.
     */
    String name();

    /**
     * The required value for the property to match.
     */
    String havingValue() default "true";

    /**
     * Whether to match if the property is absent.
     */
    boolean matchIfMissing() default false;
}

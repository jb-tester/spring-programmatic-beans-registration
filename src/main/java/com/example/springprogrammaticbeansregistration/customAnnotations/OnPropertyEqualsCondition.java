package com.example.springprogrammaticbeansregistration.customAnnotations;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Objects;

public class OnPropertyEqualsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attrs = metadata.getAnnotationAttributes(ConditionalOnPropertyValue.class.getName());
        if (attrs == null) {
            return false;
        }
        String name = (String) attrs.get("name");
        String havingValue = (String) attrs.getOrDefault("havingValue", "true");
        boolean matchIfMissing = (Boolean) attrs.getOrDefault("matchIfMissing", false);

        String value = context.getEnvironment().getProperty(name);
        if (value == null) {
            return matchIfMissing;
        }
        return Objects.equals(value, havingValue);
    }
}
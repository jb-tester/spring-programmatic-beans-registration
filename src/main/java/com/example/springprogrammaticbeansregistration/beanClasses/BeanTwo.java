package com.example.springprogrammaticbeansregistration.beanClasses;


public class BeanTwo {
    private final BeanOne beanOne;

    public BeanTwo(BeanOne beanOne) {
        this.beanOne = beanOne;
    }

    public BeanOne getBeanOne() {
        return beanOne;
    }
}

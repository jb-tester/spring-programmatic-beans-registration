package com.example.springprogrammaticbeansregistration.beanClasses;

/**
 * *
 * <p>Created by irina on 9/9/2025.</p>
 * *
 */
public class BeanSeven {
    private BeanSix beanSix;
    private int id;

    public BeanSeven(BeanSix beanSix, int id) {
        this.beanSix = beanSix;
        this.id = id;
    }

    public BeanSix getBeanSix() {
        return beanSix;
    }
}

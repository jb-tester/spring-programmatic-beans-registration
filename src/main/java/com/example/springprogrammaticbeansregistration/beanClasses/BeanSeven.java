package com.example.springprogrammaticbeansregistration.beanClasses;


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

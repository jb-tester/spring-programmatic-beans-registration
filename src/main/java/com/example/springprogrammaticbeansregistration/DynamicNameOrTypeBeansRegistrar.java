package com.example.springprogrammaticbeansregistration;


import com.example.springprogrammaticbeansregistration.beanClasses.Bar;
import com.example.springprogrammaticbeansregistration.beanClasses.FirstBar;
import com.example.springprogrammaticbeansregistration.beanClasses.SecondBar;
import com.example.springprogrammaticbeansregistration.beanClasses.ThirdBar;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

import java.util.Objects;

// dynamic name or type of beans registration:
// sometimes it is impossible to understand the bean name or type in the design type
// we should provide some graceful way to show and autowire such beans, avoiding false-positives
public class DynamicNameOrTypeBeansRegistrar implements BeanRegistrar {

    @Override
    public void register(BeanRegistry registry, Environment env) {
        // static registration:
        registry.registerBean("someBean0", SomeBean0.class);
        // ~~IDEA uses the default bean name instead of the one get from method call~~
        // ~~Update: now it gets name `java.lang.String#0`~~ - FIXED: `<unknown name>` is reported
        registry.registerBean(Utils.getBeanName1(env), SomeBean1.class);
        registry.registerBean(Utils.getBeanName2(env), SomeBean1.class);
        // bean name is correctly recognized
        registry.registerBean(Utils.BEAN_NAME_CONSTANT, SomeBean2.class);
        // ~~IDEA uses the default bean name instead of the one get from method call~~
        // ~~update: now it uses the name `T#0`~~ - FIXED: `<unknown name>` is reported
        registry.registerBean(Objects.requireNonNull(env.getProperty("utils.bean.name2")), SomeBean3.class);
        // ~~the name is considered to be `java.lang.String#0`~~ - FIXED: `<unknown name>` is reported
        registry.registerBean(env.getProperty("utils.bean.name3"), SomeBean4.class);
        // ~~bean is displayed as `null#0` in the beans view~~
        // ~~also (!!!) is treated as a bean of any type, making all injections display 'multiple candidates' error~~
        // ~~update: now it is shown as Class<? extends Bar>#0~~
        // UPDATE: now the beans of not defined type are not shown at all neither in Beans view nor in Structure
        registry.registerBean(Utils.getBeanTypeFirst(env));
        // ~~bean is treated as a 'boo' bean of any type, again making all injections display 'multiple candidates' error~~
        // UPDATE: now this, as other beans of not defined type, is not shown at all neither in Beans view nor in Structure
        registry.registerBean("boo", Utils.getBeanTypeSecond(env));
        // ~~bean name is considered to be `java.lang.Class<ThirdBar>#0`~~
        // UPDATE: now the beans of not defined type are not shown at all neither in Beans view nor in Structure
        registry.registerBean(Utils.getBeanTypeThird());
    }


}

class SomeBean0 {
}

class SomeBean1 {
}

class SomeBean2 {
}

class SomeBean3 {
}

class SomeBean4 {
}

class Utils {
    static final String BEAN_NAME_CONSTANT = "beanNameFromConstant";

    public static String getBeanName1(Environment env) {
        return env.getProperty("utils.bean.name11");
    }
public static String getBeanName2(Environment env) {
        return env.getProperty("utils.bean.name12");
    }

    public static Class<? extends Bar> getBeanTypeFirst(Environment env) {
        if (Objects.requireNonNull(env.getProperty("utils.bean.type1")).equals("first")) {
            return FirstBar.class;
        } else {
            return SecondBar.class;
        }
    }

    public static Class<? extends Bar> getBeanTypeSecond(Environment env) {
        if (Objects.requireNonNull(env.getProperty("utils.bean.type2")).equals("second")) {
            return SecondBar.class;
        } else {
            return FirstBar.class;
        }
    }

    public static Class<ThirdBar> getBeanTypeThird() {
        return ThirdBar.class;
    }

}
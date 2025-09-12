package com.example.springprogrammaticbeansregistration;


import com.example.springprogrammaticbeansregistration.beanClasses.Bar;
import com.example.springprogrammaticbeansregistration.beanClasses.FirstBar;
import com.example.springprogrammaticbeansregistration.beanClasses.SecondBar;
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
        // IDEA uses the default bean name instead of the one get from method call
       registry.registerBean(Utils.getBeanName(env), SomeBean1.class);
       // bean name is correctly recognized
       registry.registerBean(Utils.BEAN_NAME_CONSTANT, SomeBean2.class);
        // IDEA uses the default bean name instead of the one get from method call
       registry.registerBean(Objects.requireNonNull(env.getProperty("utils.bean.name2")), SomeBean3.class);
       // bean is displayed as `null#0` in the beans view
        // also (!!!) is treated as a bean of any type, making all injections display 'multiple candidates' error
       registry.registerBean( Utils.getBeanTypeFirst(env));
        // bean is treated as a 'boo' bean of any type, again making all injections display 'multiple candidates' error
        registry.registerBean( "boo",Utils.getBeanTypeSecond(env));
    }


}
class SomeBean1 {
}
class SomeBean2 {
}
class SomeBean3 {

}
class Utils {
    static final String BEAN_NAME_CONSTANT = "beanNameFromConstant";
    public static String getBeanName(Environment env) {
        return env.getProperty("utils.bean.name1");
    }
    public static Class<? extends Bar> getBeanTypeFirst(Environment env) {
        if (Objects.requireNonNull(env.getProperty("utils.bean.type1")).equals("first")) {
            return FirstBar.class;
        }
        else {
            return SecondBar.class;
        }
    }
    public static Class<? extends Bar> getBeanTypeSecond(Environment env) {
        if (Objects.requireNonNull(env.getProperty("utils.bean.type2")).equals("second")) {
            return SecondBar.class;
        }
        else {
            return FirstBar.class;
        }
    }
}
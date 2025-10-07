package com.example.springprogrammaticbeansregistration;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class PrimaryFallbackNotautowirableBeansRegistrar implements BeanRegistrar {
    @Override
    public void register(BeanRegistry registry, Environment env) {
       registry.registerBean("tb10", TestBean1.class,
               spec -> spec.supplier(ctx -> new TestBean1("tb10")));
       registry.registerBean("tb11",TestBean1.class,
               spec -> {
                                         spec.supplier(ctx -> new TestBean1("tb11"));
                                         spec.primary();});
       registry.registerBean("tb12", TestBean1.class,
               spec -> spec.supplier(ctx -> new TestBean1("tb12")));
        registry.registerBean("tb20", TestBean2.class,
                spec -> {
                    spec.supplier(ctx -> new TestBean2("tb20"));
                    spec.fallback();});
        registry.registerBean("tb21",TestBean2.class,
                spec -> {
                    spec.supplier(ctx -> new TestBean2("tb21"));
                    spec.fallback();});
        registry.registerBean("tb22", TestBean2.class,
                spec -> spec.supplier(ctx -> new TestBean2("tb22")));
        registry.registerBean("tb31",TestBean3.class,
                spec -> {
                    spec.supplier(ctx -> new TestBean3("tb31"));
                    spec.fallback();});
        registry.registerBean("tb32", TestBean3.class,
                spec -> spec.supplier(ctx -> new TestBean3("tb32")));
    }
}
class TestBean1{

    String id;

    public TestBean1(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
class TestBean2{
    String id;
    public TestBean2(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
class TestBean3{
    String id;
    public TestBean3(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
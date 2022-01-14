package proxyFactoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ProxyFactoryBeanTest.class);

        applicationContext.register(ProxyFactoryBeanTest1.class);

        applicationContext.refresh();

        Service1 proxy = applicationContext.getBean("proxyFactoryBean1", Service1.class);

        proxy.m1();

        System.out.println("---------------分割线-----------------");

        proxy.m2();
    }
}

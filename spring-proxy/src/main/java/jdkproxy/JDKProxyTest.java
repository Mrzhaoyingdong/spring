package jdkproxy;

import java.lang.reflect.Proxy;

public class JDKProxyTest {

    public static void main(String[] args) {

        Service target = new Service();
        CostTimeInvocationHandler costTimeInvocationHandler = new CostTimeInvocationHandler(target);

        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                new Class[]{Service1.class, Service2.class},
                costTimeInvocationHandler);

        //判断代理对象是否是Service类型的，肯定是false咯
        System.out.println(String.format("proxyInstance instanceof Service = %s", proxyInstance instanceof Service));
        //判断代理对象是否是IService1类型的，肯定是true
        System.out.println(String.format("proxyInstance instanceof IService1 = %s", proxyInstance instanceof Service1));
        //判断代理对象是否是IService2类型的，肯定是true
        System.out.println(String.format("proxyInstance instanceof IService2 = %s", proxyInstance instanceof Service2));


        Service1 service1 = (Service1)proxyInstance;
        service1.m1();

        System.out.println(">>>");

        Service2 service2 = (Service2)proxyInstance;
        service2.m2();
    }
}

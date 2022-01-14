package cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  @Description: cglib 代理测试
 *  @author: zhao_yd
 *  @Date: 2021/1/22 9:48 上午
 *
 */

public class CglibTest {

    interface Service1 {
        void m1();
    }

    interface Service2{
        void m2();
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //设置代理对象需要实现的接口
        enhancer.setInterfaces(new Class[]{Service1.class,Service2.class});
        //通过callBack来对被代理的方法进行增强
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("方法" + method.getName());
                return null;
            }
        });

        Object proxy = enhancer.create();

        if(proxy instanceof  Service1){
         Service1 service1 =  (Service1)proxy;
         service1.m1();
        }

        if(proxy instanceof Service2){
            Service2 service2 = (Service2)proxy;
            service2.m2();
        }

        System.out.println(proxy.getClass());
        //看一下代理类实现的接口
        System.out.println("创建代理类实现的接口如下：");
        for (Class<?> cs : proxy.getClass().getInterfaces()) {
            System.out.println(cs);
        }
    }


}

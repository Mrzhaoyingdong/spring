package cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  @Description: cglib代理接口和类
 *  @author: zhao_yd
 *  @Date: 2021/1/22 10:00 上午
 *
 */

public class CglibTest1 {

    interface Service1{
        void m1();
    }

    interface Service2{
        void m2();
    }

    public static class Service implements Service1,Service2{

        @Override
        public void m1() {
            System.out.println("我是m1");
        }

        @Override
        public void m2() {
            System.out.println("我是m2");
        }
    }

    /**
     * 为接口和类生成代理
     * @param args
     */
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service.class);
        enhancer.setInterfaces(new Class[]{Service1.class,Service2.class});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long startTime = System.currentTimeMillis();
                Object result = methodProxy.invokeSuper(o, args);
                long endTime = System.currentTimeMillis();
                System.out.println("耗时:"+(endTime-startTime));
                return result;
            }
        });

        Object proxy = enhancer.create();

        System.out.println("proxy instanceof Service "+(proxy instanceof Service));

        if(proxy instanceof Service){
           Service service =  (Service)proxy;
           service.m1();
           service.m2();
        }

        //看一下代理对象的类型
        System.out.println(proxy.getClass());
        //输出代理对象的父类
        System.out.println("代理类的父类：" + proxy.getClass().getSuperclass());
        //看一下代理类实现的接口
        System.out.println("创建代理类实现的接口如下：");
        for (Class<?> cs : proxy.getClass().getInterfaces()) {
            System.out.println(cs);
        }
    }
}

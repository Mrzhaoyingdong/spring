package proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  @Description: cglib测试
 *  @author: zhao_yd
 *  @Date: 2020/12/10 2:26 下午
 *
 */

public class CglibTest {


    public static <T> T createProxy(Class<T> target){

        //1.创建 Enhancer类来给某个类创建代理对象
        Enhancer enhancer = new Enhancer();
       //2.通过setSuperclass来设置父类型，即需要给哪个类创建代理类
        enhancer.setSuperclass(IServiceA.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println("调用方法:" + method);
                Object result = methodProxy.invokeSuper(o,objects);
                return result;
            }
        });

        T t = (T)enhancer.create();
        return t;
    }

    public static void main(String[] args) {
        IServiceA proxy = CglibTest.createProxy(IServiceA.class);
        proxy.m1();
    }
}

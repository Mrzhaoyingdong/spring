package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  @Description: 动态代理
 *  @author: zhao_yd
 *  @Date: 2020/12/10 11:27 上午
 *
 */

public class DynamicProxy {

   public static IService proxyIservice() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

       Class<IService> proxyClass = (Class<IService>) Proxy.getProxyClass(IService.class.getClassLoader(), IService.class);

       InvocationHandler invocationHandler = new InvocationHandler() {
           @Override
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               System.out.println(">>>>>>>>>>>>>>"+method.getName()+"start!<<<<<<<<<<<<<<");
               //method.invoke(proxy,args);
               System.out.println(">>>>>>>>>>>>>>"+method.getName()+"end!<<<<<<<<<<<<<<");
               return null;
           }
       };
       IService iService = proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
       //iService.m1();
       return iService;
   }

}

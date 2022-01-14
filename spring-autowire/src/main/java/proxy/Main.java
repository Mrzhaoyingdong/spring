package proxy;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        IService iServiceA = new IServiceProxy(new IServiceA());
        IService iServiceB = new IServiceProxy(new IServiceB());
//        iServiceA.m1();
//        iServiceA.m2();
//        iServiceA.m3();
//
//        System.out.println(">>>>>>>>>>>>>>>分割线<<<<<<<<<<<<<<<<<<<<<<");
//
//        iServiceB.m1();
//        iServiceB.m2();
//        iServiceB.m3();

        IService iService = DynamicProxy.proxyIservice();
      // iService.m1();

        IService proxy = CostTimeInvocationHandler.createProxy(new IServiceA(), IService.class);
        proxy.m1();


    }
}

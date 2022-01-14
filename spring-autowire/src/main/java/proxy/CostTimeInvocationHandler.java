package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2020/12/10 1:39 下午
 *
 */

public class CostTimeInvocationHandler implements InvocationHandler {

    private Object target;

    public CostTimeInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long starTime = System.nanoTime();
        Object result = method.invoke(this.target, args);//@1
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + "方法耗时(纳秒):" + (endTime - starTime));
        return result;
    }

    public static <T> T createProxy(Object target,Class<T> targetInterface) throws IllegalAccessException {
        if(!targetInterface.isInterface()){
            throw new IllegalAccessException("targetInterface is not interface");
        }
        if(!targetInterface.isAssignableFrom(target.getClass())){
            throw new IllegalStateException("target必须是targetInterface接口的实现类!");
        }

        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new CostTimeInvocationHandler(target));
    }

}

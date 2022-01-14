package aopuse;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.*;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

/**
 *
 *  @Description: spring aop使用
 *  @author: zhao_yd
 *  @Date: 2021/1/26 10:16 上午
 *
 */
public class UserServiceProxy {


    @Test
    public void test2(){
        //1、创建目标对象
        UserService target = new UserService();

        //2、创建pointCut用来拦截目标对象中的Work

        Pointcut pointcut = new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return clazz->UserService.class.isAssignableFrom(clazz);
            }

            @Override
            public MethodMatcher getMethodMatcher() {
             return new MethodMatcher() {
                 @Override
                 public boolean matches(Method method, Class<?> aClass) {
                     return "work".equals(method.getName());
                 }

                 @Override
                 public boolean isRuntime() {
                     return false;
                 }

                 @Override
                 public boolean matches(Method method, Class<?> aClass, Object... objects) {
                     return false;
                 }
             };
            }
        };

        //3、创建通知Adivice
        AfterReturningAdvice afterAdvice = ((o1,method, objects, o)  ->{
            System.out.println("再见" +objects[0]);
        });

        //4、创建advisor 将pointcut 和 advice通知连起来
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut,afterAdvice);

        //5、通过Spring 提供的工厂来创建代理类
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);

        proxyFactory.addAdvisor(advisor);

        Object proxy = proxyFactory.getProxy();

        UserService userService = (UserService)proxy;

        userService.work("xxxxxNB_iot");

    }

    @Test
    public void test(){
        //1、创建目标对象
        UserService target = new UserService();

        //2、创建pointCut用来拦截目标对象中的 work
        Pointcut pointcut = new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                //判断是否是UserService类型的
                return Clazz->UserService.class.isAssignableFrom(Clazz);
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    //判断方法名是否为 work
                    @Override
                    public boolean matches(Method method, Class<?> aClass) {
                        return "work".equals(method.getName());
                    }

                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> aClass, Object... objects) {
                        return false;
                    }
                };
            }
        };

        //3、创建通知Adivice
        MethodBeforeAdvice beforeAdvice = ((method, objects, o)  ->{
            System.out.println("hello" +objects[0]);
        });

        //4、创建 Advisor，讲adivice 和 pointCut 链接起来
        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor(pointcut,beforeAdvice);

        //5、通过Spring 提供的工厂来创建代理类
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);

        proxyFactory.addAdvisor(pointcutAdvisor);

        Object proxy = proxyFactory.getProxy();

        UserService userService = (UserService)proxy;
        userService.work("赵英东");
    }

    @Test
    public void test1(){
        //1、创建目标对象
        UserService target = new UserService();

        //2、创建pointcut来拦截目标对象中的方法
        Pointcut pointcut = new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return Clazz->UserService.class.isAssignableFrom(Clazz);
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> aClass) {
                        return "work".equals(method.getName());
                    }

                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> aClass, Object... objects) {
                        return false;
                    }
                };
            }
        };

        //3、创建通知
        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("开始调用"+methodInvocation.getMethod().getName());
                long startTime = System.currentTimeMillis();
                Object result = methodInvocation.proceed();
                long endTime = System.currentTimeMillis();
                System.out.println("调用结束用时"+(endTime-startTime));
                return result;
            }
        };

        //4、创建Advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut,interceptor);

        //5、用ProxyFactroy 创建代理对象
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);

        proxyFactory.addAdvisor(advisor);

        Object proxy = proxyFactory.getProxy();
        UserService userService = (UserService)proxy;
        userService.work("昨天的");

    }
}

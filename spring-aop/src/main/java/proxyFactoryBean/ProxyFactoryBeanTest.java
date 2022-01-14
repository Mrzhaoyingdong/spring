package proxyFactoryBean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class ProxyFactoryBeanTest {


    @Bean
    public Service1 service1(){
        return new Service1();
    }

    /**
     * 注入前置通知
     * @return
     */
    @Bean
    public MethodBeforeAdvice beforeAdvice(){
        MethodBeforeAdvice methodBeforeAdvice = new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("准备调用"+method);
            }
        };
        return methodBeforeAdvice;
    }

    @Bean
    public MethodInterceptor costTimeInterceptor(){
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                long startTime = System.currentTimeMillis();
                Object proceed = methodInvocation.proceed();
                long endTime = System.currentTimeMillis();
                System.out.println("花费了时间"+(endTime-startTime));
                return proceed;
            }
        };
        return methodInterceptor;
    }

    /**
     * 注册 ProxyFactoryBean
     */

    @Bean
    public ProxyFactoryBean proxyFactoryBean(){
        //1、创建ProxyFactoryBean 对象
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //2、设置目标对象名称
        proxyFactoryBean.setTargetName("service1");
        //3、设置拦截器的bean名称列表，此处2个（advice1和advice2)
        proxyFactoryBean.setInterceptorNames("beforeAdvice","costTimeInterceptor");
        return proxyFactoryBean;
    }
}

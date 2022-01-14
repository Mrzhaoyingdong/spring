package proxyFactoryBean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class ProxyFactoryBeanTest1 {

    @Bean
    public Advisor interceptor1(){
        MethodBeforeAdvice advice = new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("开始调用"+method);
            }
        };
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setAdvice(advice);

        return advisor;
    }

    @Bean
    public MethodInterceptor interceptor2(){
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                long startTime = System.currentTimeMillis();

                Object proceed = methodInvocation.proceed();
                long endTiem = System.currentTimeMillis();
                System.out.println("花费了时间为："+(endTiem-startTime));
                return proceed;
            }
        };

        return methodInterceptor;
    }

    @Bean
    public ProxyFactoryBean proxyFactoryBean1(){
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();

        proxyFactoryBean.setTargetName("service1");
        //设置拦截器的bean名称列表，此处批量注册
       // proxyFactoryBean.setInterceptorNames("interceptor*");
        proxyFactoryBean.setInterceptorNames("interceptor*"); //@1
        return proxyFactoryBean;
    }
}

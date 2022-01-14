package processor;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

/**
 *  @Description: 拦截器
 *  @author: zhao_yd
 *  @Date: 2021/1/13 6:45 下午
 *
 */
//@Component
public class MethodBeforeInterceptor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("service1".equals(beanName)){
            //创建代理工厂，传入被代理的对象
            ProxyFactory proxyFactory = new ProxyFactory(bean);
            proxyFactory.addAdvice(new MethodBeforeAdvice() {
                @Override
                public void before(Method method, Object[] objects, Object o) throws Throwable {
                    System.out.println("你好，service1");
                }
            });
            return proxyFactory.getProxy();
        }
        return bean;
    }
}

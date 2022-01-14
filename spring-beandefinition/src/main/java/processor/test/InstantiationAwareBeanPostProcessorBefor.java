package processor.test;

import domain.Car;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import processor.CallInstantiationAwareBeanPostProcessor;

/**
 *  @Description: bean 初始化前阶段，会调用{@link InstantiationAwareBeanPostProcessor}
 *  @author: zhao_yd
 *  @Date: 2020/12/24 10:00 上午
 *
 */

public class InstantiationAwareBeanPostProcessorBefor {

    public static void main(String[] args) {
        instantiationAwareBeanPostProcessorapp();
    }

    /**
     * 实际上，在实例化前阶段对bean的创建进行干预的情况
     */
    public static void instantiationAwareBeanPostProcessorapp(){

        //创建一个spring容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new CallInstantiationAwareBeanPostProcessor());

        //通过注册器注册一个对象
        AbstractBeanDefinition beanDefinition =
                BeanDefinitionBuilder.genericBeanDefinition(Car.class).
                        addPropertyValue("name", "查无此人").
                        getBeanDefinition();

        beanFactory.registerBeanDefinition("car",beanDefinition);

        Object car = beanFactory.getBean("car");
        System.out.println(String.format("finally get this the bean is > %s",car));
    }
}

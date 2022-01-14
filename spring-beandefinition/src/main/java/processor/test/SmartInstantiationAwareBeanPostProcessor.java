package processor.test;

import domain.Person;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import processor.CallSmartInstantiationAwareBeanPostProcessor;

/**
 *  @Description: 使用 {@link org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor}
 *  @author: zhao_yd
 *  @Date: 2020/12/24 5:05 下午
 *
 */

public class SmartInstantiationAwareBeanPostProcessor {

    public static void main(String[] args) {
        smartInstantiationAwareBeanPostProcessorUse();
    }

    public static void smartInstantiationAwareBeanPostProcessorUse(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //添加postProcessor
        beanFactory.addBeanPostProcessor(new CallSmartInstantiationAwareBeanPostProcessor());

        beanFactory.registerBeanDefinition("name",
                BeanDefinitionBuilder.genericBeanDefinition(String.class).
                        addConstructorArgValue("赵英东").getBeanDefinition());

        beanFactory.registerBeanDefinition("age",
                BeanDefinitionBuilder.genericBeanDefinition(Integer.class).
                addConstructorArgValue(Integer.class).getBeanDefinition());


        beanFactory.registerBeanDefinition("persopn",
                BeanDefinitionBuilder.genericBeanDefinition(Person.class).getBeanDefinition());

        Object persopn = beanFactory.getBean("persopn");
        System.out.println(persopn);
    }
}

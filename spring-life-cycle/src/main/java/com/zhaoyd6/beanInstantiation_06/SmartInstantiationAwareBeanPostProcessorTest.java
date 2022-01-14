package com.zhaoyd6.beanInstantiation_06;

import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 *
 * @Description:
 *
 * Bean实例化操作
 * 这个过程会通过反射来调用bean的构造器来创建bean的实例。
 * 自定义一个注解，当构造器被这个注解标注的时候，让spring自动选择使用这个构造器创建对象。
 *
 *  @author: zhao_yd
 *  @Date: 2021/6/25 1:47 下午
 */

public class SmartInstantiationAwareBeanPostProcessorTest {


    @Test
    public void test1(){

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.addBeanPostProcessor(new ISmartInstantiationAwareBeanPostProcessor());

        factory.registerBeanDefinition("name",
                BeanDefinitionBuilder.genericBeanDefinition(String.class)
                        .addConstructorArgValue("zhaoyd6")
                        .getBeanDefinition());


        factory.registerBeanDefinition("age",
                BeanDefinitionBuilder.genericBeanDefinition(Integer.class)
                        .addConstructorArgValue(30)
                        .getBeanDefinition());

        factory.registerBeanDefinition("person",
                BeanDefinitionBuilder.genericBeanDefinition(Person.class)
                        .getBeanDefinition());

        Person bean = factory.getBean(Person.class);
        System.out.println(bean);
    }


}

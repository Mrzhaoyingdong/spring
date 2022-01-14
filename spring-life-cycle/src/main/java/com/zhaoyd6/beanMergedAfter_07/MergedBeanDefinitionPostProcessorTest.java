package com.zhaoyd6.beanMergedAfter_07;

import com.zhaoyd6.metaInfoConfig_01.Car;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;

/**
 *  @Description: {@link MergedBeanDefinitionPostProcessor}
 *  @author: zhao_yd
 *  @Date: 2021/6/25 4:49 下午
 *
 */

public class MergedBeanDefinitionPostProcessorTest {


    @Test
    public void test1(){

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        AbstractBeanDefinition root = BeanDefinitionBuilder.rootBeanDefinition(Car.class).addPropertyValue("city", "nb").getBeanDefinition();

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Car.class).setParentName("car").addPropertyValue("name", "nberzi").getBeanDefinition();

        factory.addBeanPostProcessor(new IMergedBeanDefinitionPostProcessor());

        factory.registerBeanDefinition("car",root);
        factory.registerBeanDefinition("car2",beanDefinition);


        Object car = factory.getBean("car2");

        System.out.println(car);
    }
}

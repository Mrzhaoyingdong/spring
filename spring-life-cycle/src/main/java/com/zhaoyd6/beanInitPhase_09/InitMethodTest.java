package com.zhaoyd6.beanInitPhase_09;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 *  @Description: bean初始化方法调用
 *
 *  @author: zhao_yd
 *  @Date: 2021/6/29 11:44 上午
 *
 */

public class InitMethodTest {

    @Test
    public void test1() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinition service = BeanDefinitionBuilder.genericBeanDefinition(Service.class).
                setInitMethodName("init"). //@1：指定初始化方法
                getBeanDefinition();

        factory.registerBeanDefinition("service", service);

        System.out.println(factory.getBean("service"));
    }

}

package com.zhaoyd6.beanRegister_03;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Arrays;

/**
 * 阶段3：Spring Bean注册阶段
 *
 *  @Description:
 *  BeanDefinitionRegistry唯一实现：DefaultListableBeanFactory
 * spring中BeanDefinitionRegistry接口有一个唯一的实现类：
 *
 * org.springframework.beans.factory.support.DefaultListableBeanFactory
 * 大家可能看到有很多类也实现了BeanDefinitionRegistry接口，比如我们经常用到的AnnotationConfigApplicationContext，
 * 但实际上其内部是转发给了DefaultListableBeanFactory进行处理的，所以真正实现这个接口的类是DefaultListableBeanFactory。
 *
 *
 *
 *  @author: zhao_yd
 *  @Date: 2021/6/24 2:42 下午
 *
 */

public class BeanDefinitionRegistryTest {

    @Test
    public void test1(){

        //创建一个容器，这个容器默认实现了BeanDefinitionRegistry，所以也是一个注册器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //定义一个Bean
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(String.class);
        beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0,"测试一下");

        //将bean注册到容器
        factory.registerBeanDefinition("name",beanDefinition);

        //通过名称获取BeanDefinition
        BeanDefinition name = factory.getBeanDefinition("name");
        System.out.println(name);

        //通过名称判断是否注册过BeanDefinition
        boolean b = factory.containsBeanDefinition("name");
        System.out.println(b);

        //获取所有注册到名称
        System.out.println(Arrays.asList(factory.getBeanDefinitionNames()));

        //获取已注册Bean的数量
        System.out.println(factory.getBeanDefinitionCount());

        //判断指定的name是否使用过
        System.out.println(factory.isBeanNameInUse("name"));


        //为bean注册两个别名
        factory.registerAlias("name","alias-name-1");
        factory.registerAlias("name","alias-name-2");

        //判断 alias-name-1 是否作为别名使用过
        System.out.println(factory.isAlias("alias-name-1"));

        //再来获取一下这个bean
        Object name1 = factory.getBean("name");
        System.out.println(name1);


    }
}

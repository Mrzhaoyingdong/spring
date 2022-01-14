package com.zhaoyd6.metaAnalysis_02;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**  * All rights Reserved, Designed By zhaoyd.
 *
 * 阶段2：Bean元信息解析阶段
 * <p>
 * Bean元信息的解析主要有3种方式
 * 1 xml文件定义bean的解析
 * 2 properties文件定义bean的解析
 * 3 注解方式定义bean的解析
 *
 * XML方式解析：XmlBeanDefinitionReader
 * spring中提供了一个类{@link XmlBeanDefinitionReader}，将xml中定义的bean解析为BeanDefinition对象。
 *
 * properties文件定义bean的解析：{@link PropertiesBeanDefinitionReader}
 *
 * 注解定义bean的解析：{@link AnnotatedBeanDefinitionReader}
 *
 * @author: zhaoyd
 * @date: 2021/6/23 21:44
 * @Copyright: ©2020 zhaoyd. All rights reserved.
 * 注意：本内容仅限于自己阅读，禁止外泄以及用于其他的商业用途。
 */
public class BeanDefinitionReaderTest {

    @Test
    public void test(){
        //定义一个spring 容器，这个容器实现了 BeanDefinitionRegistry ，本身也是一个注册器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //定义个注解方式的BeanDefinition读取器，需要传递一个 BeanDefinitionRegistry （bean的注册器）对象
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(factory);

        //注册Bean
        beanDefinitionReader.register(Service1.class,Service2.class);


        //todo 没有后置处理器，service1 不会注册到service2 zhong
        factory.getBeansOfType(BeanPostProcessor.class).values().forEach(factory::addBeanPostProcessor);

        //打印Bean的信息
        for(String name :new String[]{"service1","service2"}){

            //通过名称获取对应的 beanDefinition信息
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            //获取BeanDefinition具体使用的是哪个类
            String beanClassName = beanDefinition.getClass().getName();

            System.out.println(beanClassName);
            //通过名称获取bean对象
            Object bean = factory.getBean(name);

            //打印输出
            System.out.println(name + ":");
            System.out.println("    beanDefinitionClassName：" + beanClassName);
            System.out.println("    beanDefinition：" + beanDefinition);
            System.out.println("    bean：" + bean);


        }

    }
}

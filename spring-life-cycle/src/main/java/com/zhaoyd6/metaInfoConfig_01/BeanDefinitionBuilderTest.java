package com.zhaoyd6.metaInfoConfig_01;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;

/**  * All rights Reserved, Designed By zhaoyd.
 *
 * spring生命周期第一个阶段
 * 阶段1：Bean元信息配置阶段
 * <P>
 *
 *
 * {@link RootBeanDefinition}类：表示根bean定义信息
 * 通常bean中没有父bean的就使用这种表示
 *
 * {@link ChildBeanDefinition}类：表示子bean定义信息
 * 如果需要指定父bean的，可以使用ChildBeanDefinition来定义子bean的配置信息，里面有个parentName属性，用来指定父bean的名称。
 *
 * {@link GenericBeanDefinition}类：通用的bean定义信息
 * 既可以表示没有父bean的bean配置信息，也可以表示有父bean的子bean配置信息，这个类里面也有parentName属性，用来指定父bean的名称。
 *
 * ConfigurationClassBeanDefinition类：表示通过配置类中@Bean方法定义bean信息
 * 可以通过配置类中使用@Bean来标注一些方法，通过这些方法来定义bean，这些方法配置的bean信息最后会转换为ConfigurationClassBeanDefinition类型的对象
 *
 * @author: zhaoyd
 * @date: 2021/6/23 21:04
 * @Copyright: ©2020 zhaoyd. All rights reserved.
 * 注意：本内容仅限于自己阅读，禁止外泄以及用于其他的商业用途。
 */
public class BeanDefinitionBuilderTest {

    //BeanDefinitionBuilder：构建BeanDefinition的工具类
    @Test
    public void test1(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Car.class);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);
    }


    @Test
    public void test2(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName());

        //设置普通类型的属性
        beanDefinitionBuilder.addPropertyValue("name","ASS");

        BeanDefinition carBeanDefinition = beanDefinitionBuilder.getBeanDefinition();

        System.out.println(carBeanDefinition);


        //向容器中注册beanDefinition
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.registerBeanDefinition(Car.class.getName(),carBeanDefinition);

        Car bean = factory.getBean(Car.class);

        System.out.println(bean);

    }

    @Test
    public void test4(){

        BeanDefinition carBenDefinition = BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName())
                .addPropertyValue("name","MEIYOU")
                .getBeanDefinition();


        BeanDefinitionBuilder beanDefinitionBuilder =
                BeanDefinitionBuilder.genericBeanDefinition().setParentName("car");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("car",carBenDefinition);
        factory.registerBeanDefinition("car1",beanDefinition);

        //从容器中获取car
        System.out.println(String.format("car->%s", factory.getBean("car")));
        //从容器中获取car1
        System.out.println(String.format("car1->%s", factory.getBean("car1")));


    }
}

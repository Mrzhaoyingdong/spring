package com.zhaoyd6.beanMerge_04;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 阶段4：BeanDefinition合并阶段
 * 阶段5：Bean Class加载阶段
 *  @Description:
 *
 *  可能我们定义bean的时候有父子bean关系，此时子BeanDefinition中的信息是不完整的，
 *  比如设置属性的时候配置在父BeanDefinition中，此时子BeanDefinition中是没有这些信息的，
 *  需要将子bean的BeanDefinition和父bean的BeanDefinition进行合并，
 *  得到最终的一个RootBeanDefinition，合并之后得到的RootBeanDefinition包含bean定义的所有信息，
 *  包含了从父bean中继继承过来的所有信息，后续bean的所有创建工作就是依靠合并之后BeanDefinition来进行的。
 *
 *  @author: zhao_yd
 *  @Date: 2021/6/24 5:53 下午
 *
 */

public class MergedBeanDefinitionTest {

    @Test
    public void test(){

        //创建bean容器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //创建一个bean.xml的解析器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions("com/zhaoyd6/beanMerge_04/bean.xml");

        //遍历容器中注册的所有bean信息
        for (String beanName : factory.getBeanDefinitionNames()) {
            //通过bean名称获取原始的注册的BeanDefinition信息
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            //获取合并之后的BeanDefinition信息
            BeanDefinition mergedBeanDefinition = factory.getMergedBeanDefinition(beanName);

            System.out.println(beanName);
            System.out.println("解析xml过程中注册的beanDefinition：" + beanDefinition);
            System.out.println("beanDefinition中的属性信息" + beanDefinition.getPropertyValues());
            System.out.println("合并之后得到的mergedBeanDefinition：" + mergedBeanDefinition);
            System.out.println("mergedBeanDefinition中的属性信息" + mergedBeanDefinition.getPropertyValues());
            System.out.println("---------------------------");
        }
    }


}

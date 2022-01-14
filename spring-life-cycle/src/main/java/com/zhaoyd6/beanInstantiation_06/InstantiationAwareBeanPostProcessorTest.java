package com.zhaoyd6.beanInstantiation_06;

import com.zhaoyd6.metaInfoConfig_01.Car;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * 阶段6：Bean实例化阶段
 *
 *  @Description:
 *
 *  BeanPostProcessor是一个接口，还有很多子接口，这些接口中提供了很多方法，
 *  spring在bean生命周期的不同阶段，会调用上面这个列表中的BeanPostProcessor中的一些方法，
 *  来对生命周期进行扩展，bean生命周期中的所有扩展点都是依靠这个集合中的BeanPostProcessor来实现的。
 *  @author: zhao_yd
 *  @Date: 2021/6/24 7:59 下午
 *
 */


/**
 * bean初始化前阶段，会调用 {@link InstantiationAwareBeanPostProcessor}
 */
public class InstantiationAwareBeanPostProcessorTest {

    @Test
    public void test1(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //添加一个BeanPostProcessor
        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
                System.out.println("开始调用 >InstantiationAwareBeanPostProcessor");
                //发现类型为Car的时候，硬编码创建一个Car对象返回
                if(beanClass == Car.class){
                    Car car = new Car();
                    car.setName("阿三开阶段即可");
                    return car;
                }
                return null;
            }
        });

        AbstractBeanDefinition beanDefinition =
                BeanDefinitionBuilder.genericBeanDefinition(Car.class).addPropertyValue("name", "cccc").getBeanDefinition();

        factory.registerBeanDefinition("car",beanDefinition);

        Car bean = factory.getBean(Car.class);
        System.out.println(bean);
    }








}

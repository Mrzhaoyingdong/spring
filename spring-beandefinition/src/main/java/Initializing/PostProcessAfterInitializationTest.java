package Initializing;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Arrays;

/**
 *  @Description: 使用 {@link BeanPostProcessor#postProcessAfterInitialization(Object, String)}
 *  @author: zhao_yd
 *  @Date: 2020/12/25 9:57 上午
 *
 */

public class PostProcessAfterInitializationTest {



    public static void afterInitializationMethod(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("postProcessBeforeInitialization ：" + beanName);
                return null;
            }
        });

        beanFactory.registerBeanDefinition(
                "name",
                BeanDefinitionBuilder.genericBeanDefinition(String.class).addConstructorArgValue("零零落落").getBeanDefinition());

        beanFactory.registerBeanDefinition(
                "personInformation",
                BeanDefinitionBuilder.genericBeanDefinition(String.class).addConstructorArgValue("呜呜呜").getBeanDefinition());

        System.out.println("--------输出bean---------");

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        Arrays.asList(beanDefinitionNames).stream().forEach(
                name->{

                }
        );
    }
}

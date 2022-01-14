package processor.test;

import domain.UserModel;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import processor.CallInstantiationAwareBeanPostProcessor;

import java.util.Arrays;

/**
 *  @Description: 调用 {@link org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor}
 *  @author: zhao_yd
 *  @Date: 2020/12/24 7:57 下午
 *
 */

public class InstantiationAwareBeanPostProcessoryAfter {

    public static void main(String[] args) {
        instaniationAwareBeanPostProcessoryApp();
    }

    public static void instaniationAwareBeanPostProcessoryApp(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new CallInstantiationAwareBeanPostProcessor());

        beanFactory.registerBeanDefinition(
                "user1",
                BeanDefinitionBuilder.genericBeanDefinition(UserModel.class).
                        addPropertyValue("name","赵英东").
                        addPropertyValue("age",18).
                        getBeanDefinition());

        beanFactory.registerBeanDefinition(
                "user2",
                BeanDefinitionBuilder.genericBeanDefinition(UserModel.class).
                        addPropertyValue("name","王富贵").
                        addPropertyValue("age",250).
                        getBeanDefinition());

        String[] names = beanFactory.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(name->{
            Object bean = beanFactory.getBean(name);
            System.out.println(String.format("获取到容器中的bean %s",bean));
        });

    }
}

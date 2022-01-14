package processor.test;


import domain.UserModel;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import processor.CallInstantiationAwareBeanPostProcessor;

/**
 *  @Description: {@link org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor}
 *  @author: zhao_yd
 *  @Date: 2020/12/24 8:39 下午
 *
 */

public class InstantiationAwareBeanPostProcessorProperties {


    public static void main(String[] args) {
        instantiationAwareBeanPostProcessorProperties();
    }

    public static void instantiationAwareBeanPostProcessorProperties(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //加上 CallInstantiationAwareBeanPostProcessor 处理属性
        beanFactory.addBeanPostProcessor(new CallInstantiationAwareBeanPostProcessor());

        beanFactory.registerBeanDefinition("zyd", BeanDefinitionBuilder.
                genericBeanDefinition(UserModel.class).
                getBeanDefinition());


        Object zyd = beanFactory.getBean("zyd");
        System.out.println(String.format("获取到bean 为>%s",zyd));
    }
}

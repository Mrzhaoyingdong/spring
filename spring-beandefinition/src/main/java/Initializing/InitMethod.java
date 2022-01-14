package Initializing;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import service.Service;

/**
 *  @Description: 初始化方法使用
 *  @author: zhao_yd
 *  @Date: 2020/12/25 9:44 上午
 *
 */

public class InitMethod {

    public static void main(String[] args) {
        init();
    }


    /**
     * 调用顺序，先调用 afterPropertiesSet() 方法
     * 再调用自己定义的 init() 方法
     *
     */
    public static void init(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AbstractBeanDefinition init =
                BeanDefinitionBuilder.genericBeanDefinition(Service.class).
                        setInitMethodName("init").getBeanDefinition();


        beanFactory.registerBeanDefinition("service",init);
        System.out.println(beanFactory.getBean("service"));

    }
}

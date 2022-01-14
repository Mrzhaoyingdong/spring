package definition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import service.Service1;
import service.Service2;

/**
 *  @Description: 解析
 *  @author: zhao_yd
 *  @Date: 2020/12/22 3:07 下午
 *
 */

public class AnalysisBeanDefinition {

    public static void main(String[] args) {
        analysisMethod();
    }

    public static void analysisMethod(){
        //实现了BeanDefinitionRegistry,所以本身也是bean的注册器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //定义一个注解方式BeanDefinition读取器，需要传递一个 BeanDefinitionRegistry（bean注册器）
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);

        beanDefinitionReader.register(Service1.class, Service2.class);

        //通过下边这段代码Service2中才会有Service1
        beanFactory.getBeansOfType(BeanPostProcessor.class).values().forEach(beanFactory::addBeanPostProcessor);

        for(String name : new String[]{"service1","service2"}){

            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getClass().getName();

            //通过名称从容器中获取对应的BeanDefinition信息
            Object bean = beanFactory.getBean(name);
            //打印输出
            System.out.println(name + ":");
            System.out.println("    beanDefinitionClassName：" + beanClassName);
            System.out.println("    beanDefinition：" + beanDefinition);
            System.out.println("    bean：" + bean);
        }

    }
}

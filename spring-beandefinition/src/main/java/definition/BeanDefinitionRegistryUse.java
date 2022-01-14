package definition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Arrays;

/**
 *  @Description:  {@link org.springframework.beans.factory.support.BeanDefinitionRegistry} 应用
 *  @author: zhao_yd
 *  @Date: 2020/12/22 9:33 下午
 *
 */

public class BeanDefinitionRegistryUse {


    public static void app(){

        //创建一个 bean容器 默认实现了 BeanDefinitionRegistry,也是一个注册器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //定一个bean
        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setBeanClass(String.class);
        definition.getConstructorArgumentValues().addIndexedArgumentValue(0,"赵英东");

        //将bean注入容器
        beanFactory.registerBeanDefinition("name",definition);

        //通过名称获取BeanDefinition
        BeanDefinition name = beanFactory.getBeanDefinition("name");
        System.out.println(String.format("BeanDefinition name is %s",name));

        //通过名称判断是否注册过该 bean
        boolean injection = beanFactory.containsBeanDefinition("name");
        System.out.println(String.format("if inject this bean >%s",injection));

        //获取已经注册的BeanDefinition数量
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        System.out.println(String.format("context has bean count is > %s",beanDefinitionCount));

        //判断指定的name是否使用过
        boolean use = beanFactory.isBeanNameInUse("name");
        System.out.println(String.format("the bean name if use ? >%s",use));

        //别名相关方法
        beanFactory.registerAlias("name","alias-name-1");
        beanFactory.registerAlias("name","alias-name-2");

        //获取对应Bean对应所有的别名
        String[] names = beanFactory.getAliases("name");
        Arrays.asList(names).forEach(System.out::println);

        //判断别名是否被使用过
        boolean alias = beanFactory.isAlias("alias-name-1");
        System.out.println(String.format("the alias alias-name-1 if used? > %s",alias));

        //再次获取此bean
        Object bean = beanFactory.getBean("name");
        System.out.println(String.format("finally get the 'name' bean %s",bean));

    }

    public static void main(String[] args) {
        app();
    }
}

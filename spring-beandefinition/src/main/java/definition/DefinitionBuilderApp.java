package definition;


import domain.Car;
import domain.CompositeObj;
import domain.User;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.*;

import java.util.Arrays;

/**
 *  @Description: 使用 {@link BeanDefinitionBuilder}
 *  @author: zhao_yd
 *  @Date: 2020/12/21 8:33 下午
 *
 */

public class DefinitionBuilderApp {

    public static void main(String[] args) {
        setProperties();
        dependencyProperties();
        complexPOJO();
    }

    public static void complexPOJO(){
        AbstractBeanDefinition car =
                BeanDefinitionBuilder.
                        genericBeanDefinition(Car.class).
                        addPropertyValue("name","越野").getBeanDefinition();
        AbstractBeanDefinition car2 =
                BeanDefinitionBuilder.
                        genericBeanDefinition(Car.class).
                        addPropertyValue("name","轿车").getBeanDefinition();

        ManagedList<String> managedList = new ManagedList<>();
        managedList.addAll(Arrays.asList("清华","北大","浙大"));

        ManagedList<RuntimeBeanReference> cars = new ManagedList<>();
        cars.add(new RuntimeBeanReference("car"));
        cars.add(new RuntimeBeanReference("car2"));

        ManagedSet<String> nameSet = new ManagedSet<>();
        nameSet.addAll(Arrays.asList("清华","北大","浙大"));

        ManagedSet<RuntimeBeanReference> carSet = new ManagedSet<>();
        carSet.add(new RuntimeBeanReference("car"));
        carSet.add(new RuntimeBeanReference("car2"));

        //创建stringMap这个属性对应的值
        ManagedMap<String, String> stringMap = new ManagedMap<>();
        stringMap.put("系列1", "java高并发系列");
        stringMap.put("系列2", "Maven高手系列");
        stringMap.put("系列3", "mysql系列");

        ManagedMap<String, RuntimeBeanReference> stringCarMap = new ManagedMap<>();
        stringCarMap.put("car", new RuntimeBeanReference("car"));
        stringCarMap.put("car2", new RuntimeBeanReference("car2"));

        //使用原生Api构建BeanDefinition
        GenericBeanDefinition compositeObj = new GenericBeanDefinition();
        compositeObj.setBeanClassName(CompositeObj.class.getName());
        compositeObj.getPropertyValues().
                add("name","zhaoyd6").
                add("salary",10000).
                add("car",new RuntimeBeanReference("car")).
                add("names",managedList).
                add("cars",cars).
                add("nameSet",nameSet).
                add("carSet",carSet).
                add("mapnames",stringMap).
                add("carMap",stringCarMap);

        //构建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("car",car);
        beanFactory.registerBeanDefinition("car2",car2);
        beanFactory.registerBeanDefinition("compositeObj",compositeObj);

        String[] names = beanFactory.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(bean->{
            System.out.println(String.format("%s->%s", bean, beanFactory.getBean(bean)));
        });
    }

    public static void dependencyProperties(){
        AbstractBeanDefinition beanDefinition =
                BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName()).
                addPropertyValue("name", "奔驰").
                getBeanDefinition();

        BeanDefinitionBuilder beanDefinitionBuilder =
                BeanDefinitionBuilder.rootBeanDefinition(User.class.getName()).
                        addPropertyValue("master", "赵英东").
                        addPropertyReference("car", Car.class.getName());
        //创建Spring容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition(Car.class.getName(),beanDefinition);
        beanFactory.registerBeanDefinition(User.class.getName(),beanDefinitionBuilder.getBeanDefinition());
        Car car = beanFactory.getBean(Car.class);
        User user = beanFactory.getBean(User.class);
        System.out.println(String.format("through dependency create bean car is >%s, user is >%s",car,user));
    }

    public static void setProperties(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName());
        beanDefinitionBuilder.addPropertyValue("name","别克");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(String.format("BeanDefinition is %s",beanDefinition));

        //创建Spring容器
        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();
        listableBeanFactory.registerBeanDefinition(Car.class.getName(),beanDefinition);
        Car bean = listableBeanFactory.getBean(Car.class);
        System.out.println(String.format("through beanDefinition create bean,the bean name info %s",bean));
    }

    public void simpleUse(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName());
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinition.setAutowireCandidate(false);
        beanDefinition.setDependsOn("house");
        beanDefinition.setLazyInit(false);
        System.out.println(String.format("BeanDefinition is %s",beanDefinition));
    }
}

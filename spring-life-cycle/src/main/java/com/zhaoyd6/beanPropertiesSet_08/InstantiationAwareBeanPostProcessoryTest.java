package com.zhaoyd6.beanPropertiesSet_08;


import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 *  阶段8：Bean属性设置阶段
 *
 *会调用{@link InstantiationAwareBeanPostProcessor}接口的postProcessAfterInstantiation这个方法
 *postProcessAfterInstantiation方法返回false的时候，后续的Bean属性赋值前处理、Bean属性赋值都会被跳过了。
 *
 *
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/6/25 5:15 下午
 *
 */

public class InstantiationAwareBeanPostProcessoryTest {


    @Test
    public void test1(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();


        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
                if("user1".equals(beanName)){
                    return false;
                }else {
                    return true;
                }
            }
        });

        factory.registerBeanDefinition("user1", BeanDefinitionBuilder.
                genericBeanDefinition(UserModel.class).
                addPropertyValue("name", "xxxJava").
                addPropertyValue("age", 30).
                getBeanDefinition());

        factory.registerBeanDefinition("user2", BeanDefinitionBuilder.
                genericBeanDefinition(UserModel.class).
                addPropertyValue("name", "刘xxx").
                addPropertyValue("age", 50).
                getBeanDefinition());

        for (String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void test2(){

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
          @Override
          public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName){
              if("user1".equals(beanName)){
                  if(pvs == null){
                      pvs = new MutablePropertyValues();
                  }

                  if(pvs instanceof MutablePropertyValues){
                      MutablePropertyValues mpvs = (MutablePropertyValues)pvs;
                      mpvs.add("name","庐山时尚");
                      mpvs.add("age",10);
                  }
              }
              return null;
          }
        });


        factory.registerBeanDefinition("user1",
                BeanDefinitionBuilder
                        .genericBeanDefinition(UserModel.class)
                        .getBeanDefinition());


        factory.registerBeanDefinition("user2",
                BeanDefinitionBuilder.genericBeanDefinition(UserModel.class).
                        addPropertyValue("name","axx")
                        .addPropertyValue("age",108)
                        .getBeanDefinition());

        for (String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, factory.getBean(beanName)));
        }


    }


}

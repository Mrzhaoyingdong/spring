package com.zhaoyd6.beanMergedAfter_07;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 *
 * 阶段7：合并后的BeanDefinition处理
 *
 * postProcessMergedBeanDefinition有2个实现类，前面我们介绍过，用的也比较多，面试的时候也会经常问的
 * org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
 * 在 postProcessMergedBeanDefinition 方法中对 @Autowired、@Value 标注的方法、字段进行缓存
 *
 * org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
 * 在 postProcessMergedBeanDefinition 方法中对 @Resource 标注的字段、@Resource 标注的方法、 @PostConstruct 标注的字段、 @PreDestroy标注的方法进行缓存
 *
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/6/25 2:07 下午
 *
 */


public class IMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition rootBeanDefinition, Class<?> aClass, String s) {
        System.out.println(">>>>>>>>>"+rootBeanDefinition);
        MutablePropertyValues values = new MutablePropertyValues();
        values.add("name","aaaa");
        values.add("city","哈哈哈");
        rootBeanDefinition.setPropertyValues(values);
    }
}

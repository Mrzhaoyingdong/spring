package com.zhaoyd6.beanInstantiation_06;

import java.lang.annotation.*;

/**
 *  @Description: 自定义注解，当构造器被这个注解标注的时候
 *  Spring会选择使用这个构造器去创建对象
 *  @author: zhao_yd
 *  @Date: 2021/6/25 9:40 上午
 *
 */

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowried {
}

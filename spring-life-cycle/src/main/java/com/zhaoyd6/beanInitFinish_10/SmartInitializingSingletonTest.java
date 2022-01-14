package com.zhaoyd6.beanInitFinish_10;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 *  阶段10：所有单例bean初始化完成后阶段
 *  阶段11：Bean使用阶段
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/6/29 2:07 下午
 *
 */

@ComponentScan
public class SmartInitializingSingletonTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SmartInitializingSingletonTest.class);
        System.out.println("开始启动容器!");
        context.refresh();
        System.out.println("容器启动完毕!");
    }
}

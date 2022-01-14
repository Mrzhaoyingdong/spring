package com.zhaoyd6.beanInitPhase_09;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 阶段9：Bean初始化阶段
 *  @Description:
 *这个阶段分为5个小的阶段
 * Bean Aware接口回调
 *
 * Bean初始化前操作
 *
 * Bean初始化操作
 *
 * Bean初始化后操作
 *
 * Bean初始化完成操作
 *
 *
 *  @author: zhao_yd
 *  @Date: 2021/6/29 11:36 上午
 *
 */

public class PostProcessBeforeInitializationTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanTest.class);
        context.refresh();
    }
}

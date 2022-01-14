package com.zhaoyd6.beanInitFinish_10;

import org.springframework.stereotype.Component;

@Component
public class Service1 {

    public Service1() {
        System.out.println("create " + this.getClass());
    }
}

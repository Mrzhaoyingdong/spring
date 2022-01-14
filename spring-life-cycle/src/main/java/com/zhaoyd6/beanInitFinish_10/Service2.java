package com.zhaoyd6.beanInitFinish_10;

import org.springframework.stereotype.Component;

@Component
public class Service2 {

    public Service2() {
        System.out.println("create " + this.getClass());
    }
}

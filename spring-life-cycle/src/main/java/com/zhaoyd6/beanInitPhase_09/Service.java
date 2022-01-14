package com.zhaoyd6.beanInitPhase_09;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;

@Scope()
public class Service implements InitializingBean {

    public void init() {
        System.out.println("调用init()方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用afterPropertiesSet()");
    }
}

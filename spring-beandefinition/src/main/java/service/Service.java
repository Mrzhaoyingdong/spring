package service;

import org.springframework.beans.factory.InitializingBean;

/**
 *  @Description: 使用 {@link InitializingBean}
 *  @author: zhao_yd
 *  @Date: 2020/12/25 9:42 上午
 *
 */

public class Service implements InitializingBean {

    public void init(){
        System.out.println("调用 init()方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用 afterPropertiesSet 方法");
    }
}

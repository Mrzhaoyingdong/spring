package com.zhaoyd6.patternface.door.refresh;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

/**
 *
 *  @Description: 自定义刷新注解
 *  @author: zhao_yd
 *  @Date: 2021/6/29 5:17 下午
 *
 */


@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Scope(BeanRefreshScope.SCOPE_REFRESH)
public @interface RefreshScope {


}

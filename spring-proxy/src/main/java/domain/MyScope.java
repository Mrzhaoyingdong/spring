package domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import scope.BeanMyScope;

import java.lang.annotation.*;

/**
 *  @Description: 自定义注解
 *  @author: zhao_yd
 *  @Date: 2021/1/11 10:24 下午
 *
 */

@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Scope(BeanMyScope.SCOPE_MY)
public @interface MyScope {

    /**
     * @See Scope#ProxyMode
     * @return
     */
    ScopedProxyMode proxyMode() default ScopedProxyMode.TARGET_CLASS;
}

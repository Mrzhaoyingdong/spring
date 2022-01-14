
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import scope.BeanRefreshScope;

import java.lang.annotation.*;

/**
 *  @Description: 自动刷新 @Value值，自定义Scope注解
 *  @author: zhao_yd
 *  @Date: 2021/1/11 10:50 下午
 *
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Scope(BeanRefreshScope.SCOPE_REFRESH)
@Documented
public @interface RefreshScope {

    ScopedProxyMode proxyMode() default  ScopedProxyMode.TARGET_CLASS;
}

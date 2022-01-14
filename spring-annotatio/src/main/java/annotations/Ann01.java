package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  TYPE_USE 用在任何类型名称上
 *  @Description: 自定义注解
 *  @author: zhao_yd
 *  @Date: 2020/12/11 9:59 上午
 *
 */

@Target(value = {
        ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ann01 {
    String value();
}

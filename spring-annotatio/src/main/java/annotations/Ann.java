package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *  TYPE_PARAMETER 作用在类型参数上
 *
 *  @Description: 足定义注解
 *  @author: zhao_yd
 *  @Date: 2020/12/11 9:28 上午
 *
 */

@Target(value = {
        ElementType.TYPE_PARAMETER
})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Ann {

    String value();
}

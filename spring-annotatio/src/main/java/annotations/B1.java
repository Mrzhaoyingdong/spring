package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  @Description: 自定义注解
 *  @author: zhao_yd
 *  @Date: 2020/12/15 4:46 下午
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@A1
public @interface B1 {
    String value() default "b";
}

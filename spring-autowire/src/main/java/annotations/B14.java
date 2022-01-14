package annotations;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  @Description: {@link AliasFor} 使用
 *  @author: zhao_yd
 *  @Date: 2020/12/15 5:10 下午
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@A14
public @interface B14 {

    String value() default "b";

    @AliasFor(annotation = A14.class, value = "value")
    String a14Value();
}

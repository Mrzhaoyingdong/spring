package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  @Description: 需要解析的自定义注解
 *  @author: zhao_yd
 *  @Date: 2020/12/15 9:22 上午
 *
 */

@Target({
        ElementType.ANNOTATION_TYPE,
        ElementType.FIELD,
        ElementType.LOCAL_VARIABLE,
        ElementType.TYPE,
        ElementType.TYPE_PARAMETER,
        ElementType.TYPE_USE,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.PACKAGE,
        ElementType.CONSTRUCTOR
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ann02_1 {

    int value();

}

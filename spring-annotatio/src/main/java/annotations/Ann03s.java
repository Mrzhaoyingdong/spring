package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  @Description: {@link java.lang.annotation.Repeatable}
 *  @author: zhao_yd
 *  @Date: 2020/12/15 11:30 上午
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.TYPE,
        ElementType.FIELD
})
public @interface Ann03s {

    Ann03[] value(); //@1
}

package annotations;

import java.lang.annotation.*;

/**
 *  @Description: Repeatable 重复使用注解
 *  @author: zhao_yd
 *  @Date: 2020/12/15 11:28 上午
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Repeatable(Ann03s.class)//@2
@interface Ann03 {
    String name();
}
package annotations;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 *  @Description: {@link Inherited} 注解继承使用
 *  @author: zhao_yd
 *  @Date: 2020/12/15 11:10 上午
 *
 */

public class InheritAnnotationTest {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface A1{

    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface A2{

    }

    @A1
    interface I1{}

    @A2
    static class C1{}

    static class C2 extends C1 implements I1{} //@5

    /**
     * 从输出中可以看出类可以继承父类上被@Inherited修饰的注解，
     * 而不能继承接口上被@Inherited修饰的注解，这个一定要注意
     * @param args
     */
    public static void main(String[] args) {
        Annotation[] annotations = C2.class.getAnnotations();
        Arrays.asList(annotations).forEach(System.out::println);
    }
}

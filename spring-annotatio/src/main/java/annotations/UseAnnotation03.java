package annotations;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 *  @Description: 注解使用
 *  @author: zhao_yd
 *  @Date: 2020/12/15 11:29 上午
 *
 */
@Ann03(name = "01")
@Ann03(name = "04")
public class UseAnnotation03 {

    public static void main(String[] args) {
        Annotation[] annotations = UseAnnotation03.class.getAnnotations();
        Arrays.asList(annotations).forEach(System.out::println);
    }
}

package annotations;

import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 *  @Description: 测试 AliasFor
 *  @author: zhao_yd
 *  @Date: 2020/12/16 9:32 上午
 *
 */
@B14(value = "赵英东",a14Value = "通过B14赋值给A14")
public class UseAnnotation05 {


    public static void main(String[] args) {
        B14 mergedAnnotation = AnnotatedElementUtils.getMergedAnnotation(UseAnnotation05.class, B14.class);
        System.out.println(mergedAnnotation);

        A14 mergedAnnotation1 = AnnotatedElementUtils.getMergedAnnotation(UseAnnotation05.class, A14.class);
        System.out.println(mergedAnnotation1);
    }
}

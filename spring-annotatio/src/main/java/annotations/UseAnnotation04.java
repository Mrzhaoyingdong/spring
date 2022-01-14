package annotations;

import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2020/12/15 4:48 下午
 *
 */
@B1("赵英东")
public class UseAnnotation04 {

    public static void main(String[] args) {
        B1 mergedAnnotation = AnnotatedElementUtils.getMergedAnnotation(UseAnnotation04.class, B1.class);
        System.out.println(mergedAnnotation.value());
        A1 mergedAnnotation1 = AnnotatedElementUtils.getMergedAnnotation(UseAnnotation04.class, A1.class);
        System.out.println(mergedAnnotation1.value());
    }
}

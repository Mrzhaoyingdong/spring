package annotations;

import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2020/12/16 9:49 上午
 *
 */

@A15(v1 = "v1")
public class UseAnnotation06 {

    public static void main(String[] args) {
        A15 annotation = AnnotatedElementUtils.getMergedAnnotation(UseAnnotation06.class, A15.class);
        System.out.println(annotation);
    }
}

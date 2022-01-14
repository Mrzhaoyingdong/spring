package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

/**
 *  @Description: 解析注解类
 *  @author: zhao_yd
 *  @Date: 2020/12/15 9:34 上午
 *
 */

public class analysis {


    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        analysisClass();
        analysisFiled();
        analysisTypeParamiter();
        analysisMap();
        analysisMethod();
    }

    /**
     * 解析类
     */
    public static void analysisClass(){
        Annotation[] annotations = UseAnnotation02.class.getAnnotations();
        Arrays.asList(annotations).stream().forEach(System.out::println);
    }

    /**
     * 解析类型变量上的字段
     */
    public static void analysisTypeParamiter(){
        TypeVariable<Class<UseAnnotation02>>[] typeParameters = UseAnnotation02.class.getTypeParameters();
        Arrays.asList(typeParameters).stream().forEach(
                classTypeVariable -> {
                    AnnotatedType[] annotatedBounds = classTypeVariable.getAnnotatedBounds();
                    Annotation[] annotations = classTypeVariable.getAnnotations();
                    Arrays.asList(annotations).forEach(System.out::println);
                }
        );
    }

    /**
     * 解析字段
     */
    public static void analysisFiled() throws NoSuchFieldException {
        Field name = UseAnnotation02.class.getDeclaredField("name");
        name.setAccessible(true);
        Annotation[] annotations = name.getAnnotations();
        Arrays.asList(annotations).stream().forEach(System.out::println);
    }

    /**
     * 解析map
     */
    public static void analysisMap() throws NoSuchFieldException {
        Field field = UseAnnotation02.class.getDeclaredField("map");
        field.setAccessible(true);
        Type genericType = field.getGenericType();
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
        AnnotatedType annotatedType = field.getAnnotatedType();
        AnnotatedType[] annotatedActualTypeArguments = ((AnnotatedParameterizedType) annotatedType).getAnnotatedActualTypeArguments();
        int i = 0;
        for (AnnotatedType type :annotatedActualTypeArguments){
            Type ty = actualTypeArguments[i++];
            System.out.println(ty.getTypeName()+"注解如下:");
            Annotation[] annotations = type.getAnnotations();
            Arrays.asList(annotations).forEach(System.out::println);
        }
    }

    public static void analysisMethod() throws NoSuchMethodException {
        Method method = UseAnnotation02.class.getDeclaredMethod("getName", String.class);
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        Arrays.asList(declaredAnnotations).forEach(System.out::println);
    }
}

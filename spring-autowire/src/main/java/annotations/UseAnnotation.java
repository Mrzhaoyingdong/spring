package annotations;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**
 *  @Description: 使用自定义注解
 *  @author: zhao_yd
 *  @Date: 2020/12/11 9:30 上午
 *
 */
public class UseAnnotation<@Ann("T0是在类上声明的一个泛型类型变量") T0,@Ann("T1是类上声明的一个范型变量") T1> {

    public  <@Ann("T2是声明在方法上的一个类型变量") T2> void m1(){

    }

    public static void main(String[] args) throws NoSuchMethodException {
//        AnnotatedType[] annotatedInterfaces = UseAnnotation.class.getAnnotatedInterfaces();
//        Arrays.asList(annotatedInterfaces).stream().forEach(System.out::print);

        TypeVariable<Class<UseAnnotation>>[] typeParameters = UseAnnotation.class.getTypeParameters();
        for (TypeVariable<Class<UseAnnotation>> typeParameter : typeParameters) {
            print(typeParameter);
        }

        Method[] methods = UseAnnotation.class.getMethods();
        TypeVariable<Method>[] typeParameters1 = methods[0].getTypeParameters();


        TypeVariable<Method>[] typeVariables = UseAnnotation.class.getDeclaredMethod("m1").getTypeParameters();
        AnnotatedType[] annotatedBounds = typeVariables[0].getAnnotatedBounds();
        Arrays.asList(annotatedBounds).stream().forEach( System.out::println);

    }


    public static void print(TypeVariable typeVariable){
        String name = typeVariable.getName();
        System.out.println(String.format("类型变量名称为：[%s]",name));
        AnnotatedType[] annotatedBounds = typeVariable.getAnnotatedBounds();
        Arrays.asList(annotatedBounds).stream().forEach(System.out::println);
    }

}

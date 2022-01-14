package processor;


import annotation.CallThisConstructer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.lang.NonNull;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  @Description: 自定义 {@link SmartInstantiationAwareBeanPostProcessor}
 *  @author: zhao_yd
 *  @Date: 2020/12/24 4:41 下午
 *
 */

public class CallSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    @NonNull
    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println(beanName);
        System.out.println("call CallSmartInstantiationAwareBeanPostProcessor determineCandidateConstructors method..");
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        //获取有@MyAutowried注解的构造器列表
        List<Constructor<?>> collect =
                Arrays.asList(declaredConstructors).stream().filter(
                        constructor -> constructor.isAnnotationPresent(CallThisConstructer.class)).
                        collect(Collectors.toList());
        Constructor[] constructors = collect.toArray(new Constructor[collect.size()]);
        return constructors.length != 0 ? constructors : null;
    }
}

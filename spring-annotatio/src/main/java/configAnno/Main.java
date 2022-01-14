package configAnno;

import configAnno.config.UserServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 *  @Description: 主测试类
 *  @author: zhao_yd
 *  @Date: 2020/12/16 8:00 下午
 *
 */

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserServiceConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).stream().forEach(name->{
            //别名
            String[] aliases = context.getAliases(name);
            System.out.println(String.format("bean名称:%s,别名:%s,bean对象:%s",
                    name,
                    Arrays.asList(aliases),
                    context.getBean(name)));
                }
        );
    }
}

package enableAspectJAutoProxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @Description: 测试类
 *  @author: zhao_yd
 *  @Date: 2021/2/6 1:56 下午
 *
 */

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();

        CarService bean = context.getBean(CarService.class);

        bean.say();


    }
}

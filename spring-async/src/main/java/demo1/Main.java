package demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(MainConfig.class);

        context.refresh();

        System.out.println("当前线程"+Thread.currentThread().getName());

        LogService bean = context.getBean(LogService.class);

        bean.log("异步执行方法!");
    }
}

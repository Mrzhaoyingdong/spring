
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Service1;
import service.Service2;

public class CirularDependenceTest {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.addBeanFactoryPostProcessor(beanFactory -> {
            if(beanFactory instanceof DefaultListableBeanFactory){
                ((DefaultListableBeanFactory) beanFactory).setAllowRawInjectionDespiteWrapping(true);
            }
        });
        context.register(MainConfig.class);
        context.refresh();

        //获取service1
        Service1 service1 = context.getBean(Service1.class);
        //获取service2
        Service2 service2 = context.getBean(Service2.class);

        System.out.println("----A-----");
        service2.m1(); //@1
        System.out.println("----B-----");
        service1.m1(); //@2
        System.out.println("----C-----");
        System.out.println(service2.getService1() == service1);
    }
}

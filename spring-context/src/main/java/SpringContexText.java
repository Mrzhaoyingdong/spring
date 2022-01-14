
import module.MyConfigScan;
import module1.MyConfigScan1;
import module1.Service3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanFactory接口，是spring容器的顶层接口，这个接口中的方法是支持容器嵌套结构查找的，
 * 比如我们常用的getBean方法，就是这个接口中定义的，调用getBean方法的时候，
 * 会从沿着当前容器向上查找，直到找到满足条件的bean为止
 * 而ListableBeanFactory这个接口中的方法是不支持容器嵌套结构查找的，比如下面这个方法
 * BeanFactoryUtils工具类中提供了一些非常实用的方法，比如支持bean层次查找的方法等等
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/1/8 7:09 下午
 *
 */

public class SpringContexText {

    public static void main(String[] args) {
        SpringParentAndChiledContext();
    }

    public static void SpringParentAndChiledContext(){

        //创建父容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //向Spring容器中注册配置类
        applicationContext.register(MyConfigScan.class);
        //启动父容器
        applicationContext.refresh();

        //创建自容器
        AnnotationConfigApplicationContext chiledContext = new AnnotationConfigApplicationContext();
        chiledContext.register(MyConfigScan1.class);
        //设置父容器
        chiledContext.setParent(applicationContext);
        //启动子容器
        chiledContext.refresh();

        Service3 bean = chiledContext.getBean(Service3.class);
        System.out.println(bean.m1());
        System.out.println(bean.m2());


    }
}

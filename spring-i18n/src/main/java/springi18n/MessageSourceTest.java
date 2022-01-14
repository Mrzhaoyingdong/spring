package springi18n;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springi18n.config.MainConfig;

import java.util.Locale;

/**
 *  @Description: 国际化资源测试
 *  @author: zhao_yd
 *  @Date: 2021/1/12 1:15 下午
 *
 */


public class MessageSourceTest {


    public static void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();

        System.out.println(context.getMessage("name",null,null));
        System.out.println(context.getMessage("name",null, Locale.CHINA));
        System.out.println(context.getMessage("name",null,Locale.UK));
    }

    public static void main(String[] args) {
        test();
    }
}

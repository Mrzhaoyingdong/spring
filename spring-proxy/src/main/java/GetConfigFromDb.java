
import config.MailConfig;
import config.MailConfig2;
import domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MapPropertySource;
import scope.BeanMyScope;
import util.DbUtil;

import java.util.Map;

/**
 *  {@link @Value}
 *  @Description: 模拟从数据库获取配置文件
 *  @author: zhao_yd
 *  @Date: 2021/1/11 5:36 下午
 *
 */

public class GetConfigFromDb {

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //将自定义作用域注册到Spring容器中
        context.getBeanFactory().registerScope(BeanMyScope.SCOPE_MY,new BeanMyScope());
        context.register(MainConfig.class);
        context.refresh();
        System.out.println("从容器中获取User对象");
        User user = context.getBean(User.class); //@2
        System.out.println("user对象的class为：" + user.getClass()); //@3

        System.out.println("多次调用user的getUsername感受一下效果\n");
        for (int i = 1; i <= 3; i++) {
            System.out.println(String.format("********\n第%d次开始调用getUsername", i));
            System.out.println(user.getUserName());
            System.out.println(String.format("第%d次调用getUsername结束\n********\n", i));
        }

        System.out.println();
    }

    public static void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //获取配置文件
        /*下面这段是关键 start*/
        Map<String, Object> mailInfoFromDb = DbUtil.getMailInfoFromDb();
        MapPropertySource mapPropertySource = new MapPropertySource("mail",mailInfoFromDb);
        context.getEnvironment().getPropertySources().addFirst(mapPropertySource);
        context.register(MailConfig2.class);
        context.refresh();

        MailConfig bean = context.getBean(MailConfig.class);
        System.out.println(bean);
    }

}

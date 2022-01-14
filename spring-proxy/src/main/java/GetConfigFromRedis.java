
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import scope.BeanRefreshScope;
import service.MailService;
import util.RefreshConfigUtil;

import java.util.concurrent.TimeUnit;

/**
 *  @Description: 动态更新@Value
 *  @author: zhao_yd
 *  @Date: 2021/1/11 11:27 下午
 *
 */

public class GetConfigFromRedis {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getBeanFactory().registerScope(BeanRefreshScope.SCOPE_REFRESH, BeanRefreshScope.getBeanRefreshScope());
        context.register(MainConfig.class);
        //刷新mail的配置到Environment
        RefreshConfigUtil.refreshMailPropertySource(context);
        context.refresh();

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }


        MailService mailService = context.getBean(MailService.class);
        System.out.println("配置未更新的情况下,输出3次");
        for (int i = 0; i < 3; i++) { //@1
            System.out.println(mailService);
            TimeUnit.MILLISECONDS.sleep(200);
        }

        System.out.println("模拟3次更新配置效果");
        for (int i = 0; i < 3; i++) { //@2
            RefreshConfigUtil.updateRediesConfig(context); //@3
            System.out.println(mailService);
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }
}

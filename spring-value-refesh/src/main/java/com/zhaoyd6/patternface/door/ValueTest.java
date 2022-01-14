package com.zhaoyd6.patternface.door;

import com.zhaoyd6.patternface.door.refresh.BeanRefreshScope;
import com.zhaoyd6.patternface.door.refresh.MailService;
import com.zhaoyd6.patternface.door.refresh.MainConfig4;
import com.zhaoyd6.patternface.door.refresh.RefreshConfigUtil;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 1. 将@Value注解的value参数值作为Environment.resolvePlaceholders方法参数进行解析
 * 2. Environment内部会访问MutablePropertySources来解析
 * 3. MutablePropertySources内部有多个PropertySource，此时会遍历PropertySource列表，调用PropertySource.getProperty方法来解析key对应的值
 *
 *  @Description: spring从配置文件中获取值
 *  @author: zhao_yd
 *  @Date: 2021/6/29 4:55 下午
 *
 */

public class ValueTest {


    @Test
    public void test(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(MainConfig1.class);

        context.refresh();

        DbConfig bean = context.getBean(DbConfig.class);

        System.out.println(bean);
    }

    @Test
    public void test2(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        Map<String, Object> mailInfoFromDb = DbUtil.getMailInfoFromDb();

        MapPropertySource mapPropertySource = new MapPropertySource("mail",mailInfoFromDb);

        context.getEnvironment().getPropertySources().addFirst(mapPropertySource);

        context.register(MainConfig2.class);

        context.refresh();

        MailConfig bean = context.getBean(MailConfig.class);

        System.out.println(bean);
    }


    @Test
    public void test4() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getBeanFactory().registerScope(BeanRefreshScope.SCOPE_REFRESH, BeanRefreshScope.getInstance());
        context.register(MainConfig4.class);
        //刷新mail的配置到Environment
        RefreshConfigUtil.refreshMailPropertySource(context);
        context.refresh();

        MailService mailService = context.getBean(MailService.class);
        System.out.println("配置未更新的情况下,输出3次");
        for (int i = 0; i < 3; i++) {
            System.out.println(mailService);
            TimeUnit.MILLISECONDS.sleep(200);
        }

        System.out.println("模拟3次更新配置效果");
        for (int i = 0; i < 3; i++) { //@2
            RefreshConfigUtil.updateDbConfig(context);
            System.out.println(mailService);
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }
}

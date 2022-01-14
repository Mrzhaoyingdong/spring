package canonical;

import canonical.config.ScanConfig;
import canonical.service.OrderService;
import canonical.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @Description: 范型注入使用 {@link @Autowied}
 *  @author: zhao_yd
 *  @Date: 2020/12/21 10:05 上午
 *
 */

public class CanonicalInjection {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanConfig.class);
        UserService userService = context.getBean(UserService.class);
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println(String.format("用户服务>%s,订单服务>%s",userService,orderService));
    }
}

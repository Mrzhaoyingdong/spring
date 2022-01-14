package demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();

        RechargeService rechargeService = context.getBean(RechargeService.class);
        rechargeService.recharge();
        CashOutService cashOutService = context.getBean(CashOutService.class);
        cashOutService.cashOut();

        //休眠一下，防止@Test退出
        TimeUnit.SECONDS.sleep(3);

    }
}

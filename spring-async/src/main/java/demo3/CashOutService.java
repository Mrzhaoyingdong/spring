package demo3;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CashOutService {
    //模拟异步提现
    @Async(MainConfig.CASHOUT_EXECUTORS_BEAN_NAME)
    public void cashOut() {
        System.out.println(Thread.currentThread() + "模拟异步提现");
    }
}

package demo1;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 *  @Description: 日志类
 *  @author: zhao_yd
 *  @Date: 2021/2/6 10:53 下午
 *
 */

@Component
public class LogService {

    @Async
    public void log(String msg) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"开始记录日志>> "+System.currentTimeMillis());

        //模拟业务处理
        TimeUnit.SECONDS.sleep(2);

        System.out.println(Thread.currentThread().getName() + "记录日志完毕>> "+System.currentTimeMillis());

    }
}

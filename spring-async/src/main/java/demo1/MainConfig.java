package demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@ComponentScan
@EnableAsync
public class MainConfig {


    @Bean
    public Executor taskExecutor() {
//        TaskExecutor taskExecutor = new ConcurrentTaskExecutor();
//        return taskExecutor;
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(12);
        executor.setThreadNamePrefix("my-thread-");
        return executor;
    }
}

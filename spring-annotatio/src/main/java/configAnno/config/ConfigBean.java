package configAnno.config;


import configAnno.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  @Description: config类
 *  @author: zhao_yd
 *  @Date: 2020/12/16 7:57 下午
 *
 */

@Configuration
public class ConfigBean {

    @Bean
    public User user1(){
        return new User();
    }

    @Bean("user2")
    public User user2(){
        return new User();
    }

    @Bean({"user3","userBeanAlis1","userBeanAlias2"})
    public User user3(){
        return new User();
    }
}

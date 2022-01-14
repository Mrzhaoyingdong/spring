package configAnno.config;


import canonical.service.UserService;
import configAnno.UserServiceParent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {

    @Bean
    public UserService userService(){
        System.out.println("userService()方法"); //@0
        return new UserService();
    }


    @Bean
    UserServiceParent serviceParent1(){
        System.out.println("serviceParent1()方法");
        UserService userService = this.userService();
        return new UserServiceParent(userService);
    }

    @Bean
    UserServiceParent serviceParent2(){
        System.out.println("serviceParent1()方法");
        UserService userService = this.userService();
        return new UserServiceParent(userService);
    }

}

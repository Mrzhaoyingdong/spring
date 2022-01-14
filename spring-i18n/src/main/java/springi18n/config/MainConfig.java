package springi18n.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/1/12 1:11 下午
 *
 */
@Configuration
public class MainConfig {

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource result = new ResourceBundleMessageSource();
        //可以指定国际化化配置文件的位置，格式：路径/文件名称,注意不包含【语言_国家.properties】含这部分
        result.setBasenames("com/zyd/springi18n/file/message"); //@1
        return result;
    }
}

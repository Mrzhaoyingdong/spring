package scaner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *  @Description: 扫描器
 *  @author: zhao_yd
 *  @Date: 2020/12/18 9:59 上午
 *
 */
@ComponentScan(
        basePackages = {"caner"},
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilter.class)
        }
)
public class ScanBean {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(name->{
            System.out.println(String.format("Bean name is >>%s",name));
        });
    }
}

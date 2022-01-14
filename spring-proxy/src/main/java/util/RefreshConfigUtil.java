package util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.MapPropertySource;
import scope.BeanRefreshScope;

import java.util.Map;

/**
 *  @Description: 自动刷新工具类
 *  @author: zhao_yd
 *  @Date: 2021/1/11 11:20 下午
 *
 */

public class RefreshConfigUtil {


    /**
     * 模拟更新缓存的配置
     * @param context
     */
    public static void updateRediesConfig(AbstractApplicationContext context){

        refreshMailPropertySource(context);
        BeanRefreshScope.getBeanRefreshScope().clean();
    }

    public static void refreshMailPropertySource(AbstractApplicationContext context){
        Map<String, Object> mailInfoFromRedis = DbUtil.getMailInfoFromRedis();
        MapPropertySource mapPropertySource = new MapPropertySource("mail",mailInfoFromRedis);
        context.getEnvironment().getPropertySources().addFirst(mapPropertySource);
    }
}

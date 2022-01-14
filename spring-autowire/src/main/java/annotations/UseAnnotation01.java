package annotations;

import java.util.Map;

/**
 *  @Description: 自定义注解
 *  @author: zhao_yd
 *  @Date: 2020/12/11 10:04 上午
 *
 */
@Ann01("用在类上")
public class UseAnnotation01<@Ann01("用在了类变量类型") T,@Ann01("用在了类变量类型") T1>{

    private Map<@Ann01("用在了范型的类型上面") String,String> map;

    private <@Ann01("用在了方法的类型上面") T0>String m1(String name){
        return name;
    }
}

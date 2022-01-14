package annotations;

import java.util.Map;

/**
 *  @Description: 解析各种注解
 *  @author: zhao_yd
 *  @Date: 2020/12/15 9:24 上午
 *
 */


@Ann02("用在类上")
@Ann02_1(0)
public class UseAnnotation02<@Ann02("用在了类型变量上V1") @Ann02_1(0) V1,@Ann02("用在类型变量上V2") @Ann02_1(1) V2> {

    @Ann02("用在字段上")
    @Ann02_1(1)
    private String name;

    private Map<@Ann02("用在范型上String") @Ann02_1(0) String,@Ann02("用在范型上Integer") @Ann02_1(0) Integer> map;

    @Ann02("用在构造器上")
    @Ann02_1(1)
    public UseAnnotation02(){

    }

    @Ann02("用在返回值上")
    @Ann02_1(3)
    public String getName(@Ann02("用在参数类型上") @Ann02_1(1) String name){
        return name;
    }
}

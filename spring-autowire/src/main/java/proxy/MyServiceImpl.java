package proxy;
/**
 *  @Description: 实现类
 *  @author: zhao_yd
 *  @Date: 2020/12/10 1:59 下午
 *
 */

public class MyServiceImpl implements MyService{

    @Override
    public String insert(String name) {
        System.out.println("插入数据成功" + name);
        return name;
    }
}

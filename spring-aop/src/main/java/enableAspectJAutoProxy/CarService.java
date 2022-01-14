package enableAspectJAutoProxy;

import org.springframework.stereotype.Component;

/**
 *  @Description: 目标类
 *  @author: zhao_yd
 *  @Date: 2021/2/6 1:30 下午
 *
 */

@Component
public class CarService {

    public void say(){
        System.out.println("CarService say ......");
    }
}

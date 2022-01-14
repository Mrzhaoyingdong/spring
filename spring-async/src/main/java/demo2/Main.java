package demo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;

/**
 *  @Description: 测试类
 *  @author: zhao_yd
 *  @Date: 2021/2/7 9:57 上午
 *
 */

public class Main {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(MainConfig.class);

        context.refresh();

        GoodsService goodsService = context.getBean(GoodsService.class);

        long startTime = System.currentTimeMillis();

        System.out.println(goodsService.getGoodsDesc(123L).get());
        System.out.println(goodsService.getGoodsDesc(123L).get());
        System.out.println(goodsService.getGoodsPinglun(123L).get());

        long endTime = System.currentTimeMillis();

        System.out.println("花费时间为"+(endTime-startTime));

    }
}

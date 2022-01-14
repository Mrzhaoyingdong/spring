package demo2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *  @Description: 商品类
 *  @author: zhao_yd
 *  @Date: 2021/2/7 9:47 上午
 *
 */

@Async
@Component
public class GoodsService {

    public Future<String> getGoodsId(long goodsId) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return AsyncResult.forValue(String.format("商品%s基本信息",goodsId));
    }

    public Future<String> getGoodsDesc(long goodsId) throws InterruptedException{
        TimeUnit.SECONDS.sleep(4);
        return AsyncResult.forValue(String.format("商品%s基本描述",goodsId));
    }

    public Future<List<String>> getGoodsPinglun(long goodsId) throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        List<String> comments = Arrays.asList("评论1", "评论2");
        return AsyncResult.forValue(comments);
    }
}

package proxy;
/**
 *  @Description: 静态代理类
 *  @author: zhao_yd
 *  @Date: 2020/12/10 11:21 上午
 *
 */

public class IServiceProxy implements IService{

    //被代理的目标类
    private IService target;

    public IServiceProxy(IService target) {
        this.target = target;
    }

    @Override
    public void m1() {
        long starTime = System.nanoTime();
        this.target.m1();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m1()方法耗时(纳秒):" + (endTime - starTime));
    }

    @Override
    public void m2() {
        long starTime = System.nanoTime();
        this.target.m1();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m2()方法耗时(纳秒):" + (endTime - starTime));
    }

    @Override
    public void m3() {
        long starTime = System.nanoTime();
        this.target.m1();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m3()方法耗时(纳秒):" + (endTime - starTime));
    }
}

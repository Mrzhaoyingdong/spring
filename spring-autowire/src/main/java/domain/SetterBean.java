package domain;

import java.util.List;

/**
 *  @Description: autowireCandidate 设置spring的候选
 *  @author: zhao_yd
 *  @Date: 2020/12/9 5:26 下午
 *
 */

public class SetterBean {

    public interface IService {} //@1

    public static class ServiceA implements IService {} //@2

    public static class ServiceB implements IService {} //@3

    private IService service;

    public void setService(IService service) {
        this.service = service;
    }

    public void setService1(List<IService> service) {//@0
        System.out.println(service+">>>>"); //@1
    }

    @Override
    public String toString() {
        return "SetterBean{" +
                "service=" + service +
                '}';
    }
}

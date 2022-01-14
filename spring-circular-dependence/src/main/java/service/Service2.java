package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service2 {

    private Service1 service1;

    public void m1(){
        System.out.println("service2 m1");
        this.service1.m1();
    }


    public Service1 getService1() {
        return service1;
    }

    @Autowired
    public void setService1(Service1 service1) {
        this.service1 = service1;
    }

}

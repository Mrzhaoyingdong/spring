package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service1 {

    public void m1(){
        System.out.println("service1 m1");
    }

    private Service2 service2;

    @Autowired
    public void setService2(Service2 service2) {
        this.service2 = service2;
    }
}

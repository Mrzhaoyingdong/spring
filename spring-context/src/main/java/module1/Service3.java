package module1;

import module.Service2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service3 {

    @Autowired
    private Service1 service1;

    @Autowired
    private Service2 service2;

    public String m1() {
        return this.service2.out();
    }

    public String m2() {
        return this.service1.out();
    }
}




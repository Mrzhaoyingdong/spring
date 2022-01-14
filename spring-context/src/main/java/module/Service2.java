package module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service2 {

    @Autowired
    private Service1 service1;

    public String out(){
        return service1.out();
    }
}

package module1;

import org.springframework.stereotype.Component;

@Component
public class Service1 {

    public String out(){
        //System.out.println("");
        return "我是 module1 中 Service1 方法中的 out";
    }
}


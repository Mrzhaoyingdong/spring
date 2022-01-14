package module;

import org.springframework.stereotype.Component;

@Component
public class Service1 {

    public String out(){
        //System.out.println("");
        return "我是 module 中 Service1 方法中的 out";
    }
}


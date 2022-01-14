package domain;


import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@MyScope
public class User {

    private String userName;

    public User() {
        System.out.println("---------创建User对象" + this); //@2
        this.userName = UUID.randomUUID().toString().replace("-",""); //@3
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

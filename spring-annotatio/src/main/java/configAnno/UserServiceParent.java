package configAnno;

import canonical.service.UserService;

/**
 *  @Description: 拥有 {@link UserService} 的构造参数
 *  @author: zhao_yd
 *  @Date: 2020/12/17 9:31 上午
 *
 */

public class UserServiceParent {

    private UserService userService;

    public UserServiceParent(UserService userService){
        this.userService = userService;
    }

    public UserServiceParent() {

    }

    @Override
    public String toString() {
        return "UserServiceParent{" +
                "userService=" + userService +
                '}';
    }
}

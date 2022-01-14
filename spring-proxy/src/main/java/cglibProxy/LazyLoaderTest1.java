package cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.LazyLoader;

/**
 *
 *
 *  @Description: 使用 {@link LazyLoader}
 *  @author: zhao_yd
 *  @Date: 2021/1/24 11:00 上午
 *
 */

public class LazyLoaderTest1 {

    public static class UserModule{
        private String userName;

        public UserModule(){
        }

        public UserModule(String userName){
            this.userName = userName;
        }

        public void say(){
            System.out.println("say " + userName);
        }
    }

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserModule.class);

        LazyLoader lazyLoader = new LazyLoader() {
            @Override
            public Object loadObject() throws Exception {
                System.out.println("调用 lazyLoader 中的 loadObject 方法");
                return new UserModule("zyd");
            }
        };

        /**
         * 第一次调用 会走到lazyLoader 中的loadObject 方法中，
         * 第二次走缓存
         */
        enhancer.setCallback(lazyLoader);
        Object proxy = enhancer.create();

        UserModule userModule = (UserModule)proxy;
        System.out.println("第一次调用 say");
        userModule.say();

        System.out.println("第二次调用 say");
        userModule.say();
    }
}

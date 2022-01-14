package scope;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 *  @Description: 自定义 scope
 *  @author: zhao_yd
 *  @Date: 2021/1/11 10:17 下午
 *
 */

public class BeanMyScope implements Scope {

    public static final String SCOPE_MY = "my"; //@1

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("BeanMyScope >>>>>>>>get :"+name);
        return objectFactory.getObject();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}


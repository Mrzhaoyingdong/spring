package com.zhaoyd6.patternface.door.refresh;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.ConcurrentHashMap;

public class BeanRefreshScope implements Scope {

    public static final String SCOPE_REFRESH = "refresh";

    private static final BeanRefreshScope INSTANCE = new BeanRefreshScope();

    //map缓存bean
    private ConcurrentHashMap<String,Object> beanMap = new ConcurrentHashMap<>();


    private BeanRefreshScope(){

    }

    public static BeanRefreshScope getInstance(){
        return INSTANCE;
    }


    /**
     * 清理当前
     */
    public static void clean(){
        INSTANCE.beanMap.clear();
    }



    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        Object bean = beanMap.get(s);
        if (bean == null) {
            bean = objectFactory.getObject();
            beanMap.put(s, bean);
        }
        return bean;
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

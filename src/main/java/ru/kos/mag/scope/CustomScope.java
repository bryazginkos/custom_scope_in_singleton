package ru.kos.mag.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brjazgin on 30.03.2016.
 */
public class CustomScope implements Scope {

    private Map<ThreadAndBeanNameKey, Object> cash = new HashMap<ThreadAndBeanNameKey, Object>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        String currentThreadName = Thread.currentThread().getName();
        ThreadAndBeanNameKey key = new ThreadAndBeanNameKey(currentThreadName, name);
        Object cashedObject = cash.get(key);
        if (cashedObject == null ) {
            Object freshObject = objectFactory.getObject();
            cash.put(new ThreadAndBeanNameKey(currentThreadName, name), freshObject);
            return freshObject;
        } else {
            return cashedObject;
        }
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

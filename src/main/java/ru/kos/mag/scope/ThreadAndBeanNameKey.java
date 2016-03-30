package ru.kos.mag.scope;

import com.google.common.base.Objects;

/**
 * Created by brjazgin on 30.03.2016.
 */
public class ThreadAndBeanNameKey {
    private String threadName;
    private String beanName;

    public ThreadAndBeanNameKey(String threadName, String beanName) {
        this.threadName = threadName;
        this.beanName = beanName;
    }


    @Override
    public boolean equals(Object o) {
        if (! (o instanceof ThreadAndBeanNameKey)) return false;

        ThreadAndBeanNameKey that = (ThreadAndBeanNameKey) o;

        return Objects.equal(this.threadName, that.threadName) &&
                Objects.equal(this.beanName, that.beanName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(threadName, beanName);
    }
}

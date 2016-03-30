package ru.kos.mag;


/**
 * Created by brjazgin on 30.03.2016.
 */
public abstract class SomeSingleton {

    public void askDoSomething() {
        getSomeService().doSomething();
    }

    protected abstract SomeService getSomeService();
}

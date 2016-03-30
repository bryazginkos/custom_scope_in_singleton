package ru.kos.mag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by brjazgin on 30.03.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.kos.mag");
        final SomeSingleton someSingleton = (SomeSingleton) context.getBean("someSingleton");

        Thread thread1 = new MyThread(someSingleton);
        Thread thread2 = new MyThread(someSingleton);

        thread1.start();
        thread2.start();
    }
}

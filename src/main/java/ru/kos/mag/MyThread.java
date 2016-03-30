package ru.kos.mag;

/**
 * Created by brjazgin on 30.03.2016.
 */
public class MyThread extends Thread {

    private SomeSingleton someSingleton;

    public MyThread(SomeSingleton someSingleton) {
        this.someSingleton = someSingleton;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Hi, I'm singleton " + someSingleton);
            someSingleton.askDoSomething();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.carto.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main implements Runnable {
    public static void main(String[] args) {
        while (true) {
            int i = 0;
            i++;
        }

//        ExecutorService service = Executors.newFixedThreadPool(1);
//        service.execute(new Main());
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

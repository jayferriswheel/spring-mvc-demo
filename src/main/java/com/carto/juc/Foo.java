package com.carto.juc;

import java.util.concurrent.atomic.AtomicInteger;

class Foo {
    CountDownLatch downLatch1 = new CountDownLatch(1);
    CountDownLatch downLatch2 = new CountDownLatch(1);

    private AtomicInteger firstJobDone = new AtomicInteger(0);


    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        downLatch1.countDown();

        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {

        }
        downLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        downLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        downLatch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

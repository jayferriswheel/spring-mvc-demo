package com.carto.jvm;

public class TestClass {
    private int m;
    private Object object = new Object();


    public synchronized int inc() {
        return m + 1;
    }

    public int add() {
        synchronized (object) {
            m = m + 1;
        }
        return m + 1;
    }
}

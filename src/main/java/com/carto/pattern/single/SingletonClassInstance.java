package com.carto.pattern.single;

public class SingletonClassInstance {
    private static class SingleDemo {
        private static final SingletonClassInstance instance = new SingletonClassInstance();
    }

    public static SingletonClassInstance getInstance() {
        return SingleDemo.instance;
    }
}

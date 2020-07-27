package com.carto.lambda;

/**
 * @author yangjie263
 * @date 2020/7/1 15:32
 */
public class MyDemo {

    public static void main(String[] args) {
        MyDemo myDemo = new MyDemo();
        String str = "11";
        for (int i = 0; i < 100; i++) {
            myDemo.demo(new MyInterface() {
                @Override
                public void put(String str) {
                    this.lamStr.length();
                    str.length();
                }
            });
        }
    }

    private void demo(MyInterface myInterface) {
        myInterface.put("hello");
    }
}

package com.carto.lambda;

/**
 * @author yangjie263
 * @date 2020/7/1 15:34
 */
public class LambdaDemo {
    String str = "";

    public void main(String[] args) {
        LambdaDemo myDemo = new LambdaDemo();

        myDemo.demo(str -> {
            this.lamStr.length();
        });
    }

    private void demo(MyInterface myInterface) {
        myInterface.put("hello");
    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
            }
        };
        new Thread(r).start();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(i)).start();
            // Error—cannot capture i
        }
    }
}

package com.carto.jvm;

/**
 * @author yangjie263
 * @date 2020/6/30 15:06
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        oom.stackLeak();
    }
}

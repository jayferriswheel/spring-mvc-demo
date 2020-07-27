package com.carto.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存：核心在于在直接内存中分配变量
 *
 * @author yangjie263
 * @date 2020/6/30 15:16
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            // Unsafe分配
            unsafe.allocateMemory(_1MB);
        }
    }
}

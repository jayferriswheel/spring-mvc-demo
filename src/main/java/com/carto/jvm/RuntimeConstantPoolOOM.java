package com.carto.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量池异常：核心在于产生大量的类
 *
 * @author yangjie263
 * @date 2020/6/30 15:12
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}

package com.carto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrintUtils {
    public static void main(String[] args) throws Exception {
        // 序列化会带来什么影响呢？ 序列化之后是不影响其类型的，可以看一下序列化的原理
//        Map<String, String> map = new HashMap<>();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("d", "1");
        map.put("b", "2");
        map.put("c", "3");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
        oos.writeObject(map);
        oos.close();
        File file = new File("template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Map<String, String> newMap = (Map<String, String>) ois.readObject();
        print(newMap);
    }


    public static <T> void print(List<T> list) {
        for (T t : list) {
            System.out.print(t + ";");
        }
        System.out.println();
    }

    public static void print(String[] array) {
        for (String t : array) {
            System.out.print(t + ";");
        }
        System.out.println();
    }

    public static void print(Map<String, String> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.print(entry.getKey() + ":");
            System.out.print(entry.getValue());
            System.out.println();
        }
    }


}

package com.carto.collection;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//
//        for (String temp : list) {
//            if ("2".equals(temp)) {
//                list.remove(temp);
//            }
//        }
//        System.out.println(list);

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            if ("3".equals(temp)) {
                list.remove(temp);
            }
        }
        System.out.println(list);
        while (true) {

        }
    }
}

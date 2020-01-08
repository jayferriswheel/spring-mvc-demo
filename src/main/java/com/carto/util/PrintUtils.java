package com.carto.util;

import org.eclipse.jetty.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintUtils {
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

    public static void main(String[] args) {
        String s = "100:::10:10";
        System.out.println(s.split(":"));
//        List<String> channelIds = new ArrayList<>();
//        channelIds.add("");
//        channelIds.add("11");
//        channelIds.add("22");
//        List<String> ss = channelIds.stream()
//                .filter(StringUtil::isNotBlank)
//                .map(id -> id + "_")
//                .collect(Collectors.toList());
//        print(ss);
    }
}

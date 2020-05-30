package com.carto.leetcode.round1;

import java.util.Stack;

public class Task71 {


    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] strs = path.split("/");
        System.out.println(strs.length);
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            if ("/".equals(str) || "".equals(str.trim())) {
                continue;
            }

            if (".".equals(str)) {
                continue;
            }


            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            stack.push(str);
        }


        String res = "";
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            String str = stack.pop();
            res = "/" + str + res;
        }

        return res;
    }


}

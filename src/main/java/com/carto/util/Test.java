package com.carto.util;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<HashUser, String> hashMap = new HashMap<>();
        HashUser user = new HashUser();
        hashMap.put(user, "111");
        hashMap.put(user, "111");
        hashMap.put(null, "111");
        hashMap.get(user);
    }
}

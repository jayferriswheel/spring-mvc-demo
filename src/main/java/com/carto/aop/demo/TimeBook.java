package com.carto.aop.demo;

public class TimeBook implements TimeBookInterface {
    @Override
    public void doAuditing(String name) {
        System.out.println(name + " 正在审核...");
    }
}

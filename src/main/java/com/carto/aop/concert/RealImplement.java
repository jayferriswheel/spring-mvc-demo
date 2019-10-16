package com.carto.aop.concert;


import org.aspectj.lang.annotation.Aspect;

@Aspect
public class RealImplement implements InterfaceA {
    @Override
    public void exec() {
        System.out.println("real impl");
    }
}

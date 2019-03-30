package com.carto.aop.concert;

import org.aspectj.lang.annotation.Pointcut;

public interface Performance {
    @Pointcut(value = "execution(* com.carto.aop.concert.Performance.perform(..))")
    public void perform();
}

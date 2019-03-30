package com.carto.aop.concert;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Pointcut("execution(* com.carto.aop.concert.Performance.perform(..)))")
    public void performance() {
    }

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @Before("performance()")
    public void applause() {
        System.out.println("clap clap clap");
    }

    @Before("performance()")
    public void demandRefund() {
        System.out.println("Damanding a refund");
    }

//    @Around("performance()")
//    public void watchPerformance(ProceedingJoinPoint jp) {
//        System.out.println("silencing cell phones");
//        System.out.println("Taking seats");
//
//        try {
//            jp.proceed();
//            System.out.println("clap clap clap");
//        } catch (Exception e) {
//            System.out.println("Damanding a refund");
//        }
//    }
}

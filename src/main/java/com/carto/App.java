package com.carto;

import com.alibaba.dubbo.container.Main;
import com.carto.aop.demo.TimeBookInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext actx = new FileSystemXmlApplicationContext("classpath:spring-aop.xml");
//        TimeBookInterface timeBookProxy = (TimeBookInterface) actx.getBean("logProxy");
//        timeBookProxy.doAuditing("张三a");

        Main.main(args);
    }
}

package com.carto.guava;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import com.carto.util.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class GuavaDemo {

    public static void main(String[] args) {
//        GuavaDemo guavaDemo = new GuavaDemo();
//        guavaDemo.demo();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(13);
        list.add(14);
        List<String> result = list.stream().map(Object::toString).collect(Collectors.toList());
        PrintUtils.print(result);
    }

//    private void demo() {
//        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
//        ListenableFuture explosion = service.submit(new Callable() {
//            public Object call() {
//                return new Object();
//            }
//        });
//
//        Futures.addCallback(explosion, new FutureCallback<Object>() {
//            @Override
//            public void onSuccess(Object result) {
//                System.out.println("success");
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                System.out.println("fail");
//            }
//        });
//    }
}

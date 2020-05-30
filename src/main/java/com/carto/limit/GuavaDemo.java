//package com.carto.limit;
//
//import com.tiefan.infra.ratelimiter.client.RateLimiterClient;
//
//import java.util.concurrent.TimeUnit;
//
//public class GuavaDemo {
//    private static final int SIXTY_SECONDS = 60;
//    private static final int FIVE_SECONDS = 5;
//
//    private void demo() {
//        // 触发点在这，每一次请求都会触发限流。 启停只要启用、关闭这行代码就可以了。
//        boolean needLimit = RateLimiterClient.doLimit("", null);
//    }
//
//    public static void main(String[] args) {
//        int timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
//        int activeOneIndex = (int) (timestamp % SIXTY_SECONDS);
//        int activeFiveIndex = activeOneIndex / FIVE_SECONDS;
//        System.out.println("activeOneIndex = " + activeOneIndex);
//        System.out.println("activeFiveIndex = " + activeFiveIndex);
//    }
//}

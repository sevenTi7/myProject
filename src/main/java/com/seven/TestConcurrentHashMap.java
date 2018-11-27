package com.seven;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class TestConcurrentHashMap {
    //private static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>(1962);

    public static void main(String[] args) throws Exception {
//        new Thread(new Gen(1)).start();
//        new Thread(new Gen(2)).start();
//        new Thread(new Gen(3)).start();
//        new Thread(new Gen(4)).start();
//        TimeUnit.SECONDS.sleep(10);
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 1962; i++) {
            map.putIfAbsent(i, "a");
        }
        System.out.println("end");
        //TimeUnit.SECONDS.sleep(20);
        long time = System.currentTimeMillis();
        ConcurrentHashMap<Integer, String> newMap = new ConcurrentHashMap<>(map);
        for (Map.Entry<Integer, String> entry : map.entrySet()){
            newMap.put(entry.getKey(),entry.getValue());
        }
//        newMap.putAll(map);
        System.out.println("cost time : " + (System.currentTimeMillis() - time));
        TimeUnit.SECONDS.sleep(20);
    }

//    private static class Gen implements Runnable {
//        private int n;
//
//        public Gen(int n) {
//            this.n = n;
//        }
//
//        @Override
//        public void run() {
//            for (int i = 1000 * (n - 1); i < 1000 * n; i++) {
//                map.putIfAbsent(i, "a" + i);
//            }
//            System.out.println(n +"::end");
//        }
//    }
}

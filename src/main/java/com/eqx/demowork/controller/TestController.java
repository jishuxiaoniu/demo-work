package com.eqx.demowork.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午4:24 2018/5/21
 */
public class TestController {


    public static void main(String[] args) {

//        long begin = System.currentTimeMillis();
//
//        CompletableFuture future1 = CompletableFuture.supplyAsync(()-> {
//            try {
//                Thread.sleep(3000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("The result is 1");
//            return 13;});
//        CompletableFuture future2 = CompletableFuture.supplyAsync(()-> {
//            try {
//                Thread.sleep(4000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("The result is 2");
//
//            return 12;});
//        CompletableFuture future3 = CompletableFuture.supplyAsync(()-> {
//            try {
//                Thread.sleep(2000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("The result is 3");
//            return 14;});
//
//
//        List<Integer> list = Lists.newArrayList();
//        list.add(ExceptionResolver.resolver(future1));
//        list.add(ExceptionResolver.resolver(future2));
//        list.add(ExceptionResolver.resolver(future3));
//
//        System.out.println("The result is " + list + ", time=" + (System.currentTimeMillis() - begin)/1000);


//        long sum  = IntStream.rangeClosed(1, 5)
//                .reduce((a, b) -> a * b)
//                .getAsInt();
//        System.out.println("The result is " +sum);

//        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
//                .limit(20)
//                .map(n -> n[0])
//                .forEach(System.out::println);

//        Stream.generate(Math::random)
//                .limit(10)
//                .forEach(System.out::println);

//        List<String> menu = Lists.newArrayList("aaa", "bbb", "ccc", "ddd");
//        String str = menu.stream().collect(joining(","));
//        System.out.println("The result is" +str);

//        Map<Boolean, List<Integer>> map = partitionPrimes(20);
//        System.out.println("The result is" +map);

        System.out.println("The result is " + sum(100));

    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static long sum(long n){
        long begin = System.currentTimeMillis();
        long res =  Stream.iterate(1L, i -> i+1)
                .limit(n)
//                .parallel()
                .reduce(0L, Long::sum);
        System.out.println("The result is ----> " + (System.currentTimeMillis()-begin) + "ms");
        return res;
    }

}

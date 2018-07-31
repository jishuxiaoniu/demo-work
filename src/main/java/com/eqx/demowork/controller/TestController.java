package com.eqx.demowork.controller;

import com.eqx.demowork.model.UserTags;
import com.eqx.demowork.model.UserTagsDTO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
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

        testFilter();

//        join();

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

//        System.out.println("The result is " + sum(100));

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

    public static long sum(long n) {
        long begin = System.currentTimeMillis();
        long res = Stream.iterate(1L, i -> i + 1)
                .limit(n)
//                .parallel()
                .reduce(0L, Long::sum);
        System.out.println("The result is ----> " + (System.currentTimeMillis() - begin) + "ms");
        return res;
    }

    public static void stream() {
        List<UserTags> tagsList = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            UserTags userTags = new UserTags();
            userTags.setId(1L);
            userTags.setTypeName("123");
            tagsList.add(userTags);
        }

        Optional optional = Optional.of(tagsList.stream().map(e -> {
            UserTagsDTO userTagsDTO = new UserTagsDTO();
            BeanUtils.copyProperties(e, userTagsDTO);
            return userTagsDTO;
        }).collect(Collectors.toList()));
        System.out.println("The result is ----> " + optional.get());
    }

    public static void join() {

        int count = 30;

        List<UserTags> tagsList = Lists.newArrayList();
        for (int i = 0; i < 50; i++) {
            UserTags userTags = new UserTags();
            userTags.setId(1L);
            userTags.setTypeName("123");
            userTags.setPreferenceTag("aa" + i + ",bb" + (i - 1));
            tagsList.add(userTags);
        }

        List<String> result = Lists.newArrayList();
        for (UserTags dto : tagsList) {
            String[] preferenceTags = dto.getPreferenceTag().split(",");
            if (result.size() < count) {
                for (String str : preferenceTags) {
                    result.add(str);
                }
            }
        }

        List<String> result2 = tagsList.stream().map(UserTags::getPreferenceTag)
                .map(e -> e.split(","))
                .flatMap(Arrays::stream)
                .limit(30L)
                .collect(Collectors.toList());


        result.stream().forEach(System.out::print);
        System.out.println("The result is ----> ");
        result2.stream().forEach(System.out::print);

    }

    public static void testFilter() {
        List<Map<String, Object>> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("price", i);
            list.add(map);
        }

        List<Map<String, Object>> resList = list.stream()
                .filter(e -> {
                    System.out.println("The result is ----> " + e.get("price"));
                    boolean flag = !e.get("price").toString().contains("-");
                    return flag;
                })
                .collect(Collectors.toList());
        System.out.println("The result is ----> " + resList);
    }

}

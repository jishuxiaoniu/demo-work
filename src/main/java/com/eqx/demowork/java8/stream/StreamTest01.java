package com.eqx.demowork.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 上午11:05 2018/8/6
 */
public class StreamTest01 {

    public static void main(String[] args) {
        learnStream();
        mapping();
    }

    private static void learnStream() {
        //首先,创建一个1-6乱序的List
        List<Integer> lists = new ArrayList<>();
        lists.add(4);
        lists.add(3);
        lists.add(6);
        lists.add(1);
        lists.add(5);
        lists.add(2);

        // 最小值
        Optional<Integer> minOptional = lists.stream().min(Integer::compareTo);
        System.out.println("The result is ----> " + minOptional.get());

        // 最大值
        lists.stream().max(Integer::compareTo).ifPresent(System.out::println);

        //排序
        lists.stream().sorted().forEach(elem -> System.out.print(elem + " "));
        System.out.println();

        // 过滤
        lists.stream().filter(elem -> elem > 3).forEach(elem -> System.out.print(elem + " "));
        System.out.println();

        // 求和
        int sum = lists.stream().mapToInt(Integer::intValue).sum();
        System.out.println("和是 ----> " + sum);
        lists.stream().reduce((a, b) -> a + b).ifPresent(elem->System.out.println("和是：" + elem));
        Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);
        System.out.println("和是 ----> " + sum2);

    }

    /**
     * 映射
     */
    private static void mapping() {
        List<String> citys = Arrays.asList("GuangZhou ShangHai", "GuangZhou ShenZhen",
                "ShangHai ShenZhen", "BeiJing ShangHai", "GuangZhou BeiJing", "ShenZhen BeiJing");

        citys.stream().flatMap(mCities->Arrays.stream(mCities.split(" "))).forEach(System.out::println);
    }
}

package com.soft.demo.test;

import com.soft.demo.jpa.entity.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: lps
 * DateTime: 2019/4/23 16:19
 * @Version: 1.0
 */
public class CollectionsTest {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");

        List<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("3");
        list2.add("7");
        list2.add("8");

        // 交集
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
        System.out.println("--------交集-------");
        intersection.parallelStream().forEach(System.out::println);

        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        System.out.println("--------差集 list1 - list2 ---------");
        reduce1.parallelStream().forEach(System.out::println);

        // 差集 list2 - list1
        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
        System.out.println("--------差集 list2 - list1 ---------");
        reduce2.parallelStream().forEach(System.out::println);

        // 并集
        List<String> listAll = list1.parallelStream().collect(Collectors.toList());
        List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        System.out.println("--------并集---------");
        listAll.stream().forEach(System.out::println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
        System.out.println("--------去重并集---------");
        listAllDistinct.parallelStream().forEachOrdered(System.out::println);

        System.out.println("--------原来的list1---------");
        list1.parallelStream().forEachOrdered(System.out::println);
        System.out.println("--------原来的list2---------");
        list2.parallelStream().forEachOrdered(System.out::println);

        System.out.println();
        String[] s = {"E", "F", "B", "D", "L"};
        List<String> list = Arrays.asList(s);
        // 开始排序
        Collections.sort(list, String::compareTo);

        list.forEach(System.out::print);

        System.out.println();
        List<User> users = new ArrayList<>();
        users.add(new User("userName06", "password06", 34));
        users.add(new User("userName03", "password03", 29));
        users.add(new User("userName07", "password07", 56));
        users.add(new User("userName01", "password01", 90));
        users.add(new User("userName08", "password08", 9));
        users.add(new User("userName05", "password05", 11));
        users.add(new User("userName04", "password04", 80));
        users.add(new User("userName02", "password02", 12));

        String sortType = "userName";
        if ("age".equals(sortType)) {
            users.sort(Comparator.comparing(User::getAge));
        } else if ("userName".equals(sortType)) {
            users.sort(Comparator.comparing(User::getUserName));
        }

        users.forEach(user -> System.out.println(user.toString()));
    }

    //java7排序
    public static void sortUsingJava7(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
    // java8 排序
    public static void sortUsingJava8(List<String> list) {
        Collections.sort(list, String::compareTo);
    }

}

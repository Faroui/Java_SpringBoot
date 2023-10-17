package com.learnJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,6,3,5,9);
        Predicate<Integer> predi = n->n % 2 == 1;
        Function<Integer,Integer> mapper=n-> n+2;


        int result=nums.stream()
                .filter(predi)
                .sorted()
                .map(mapper)
                .reduce(0,(c,e)->c+e);
        System.out.println(result);
        //data.map(n->n+2).forEach(t-> System.out.println(t));
        //data.forEach(n-> System.out.println(n));
    }
}







package com.ds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkingWithList {
    public static void main(String[] args) {
        List<Object> numbers = new ArrayList<>();
        numbers.add(67);
        numbers.add(90);
        numbers.add("Hello World");
        numbers.forEach(System.out::println);
    }
}
